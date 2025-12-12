package com.loopj.android.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.cookie.Cookie;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class PersistentCookieStore implements CookieStore {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private static final String LOG_TAG = "PersistentCookieStore";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap<String, Cookie> cookies;
    private boolean omitNonPersistentCookies = false;

    public PersistentCookieStore(Context context) {
        Cookie cookieDecodeCookie;
        SharedPreferences sharedPreferences = context.getSharedPreferences(COOKIE_PREFS, 0);
        this.cookiePrefs = sharedPreferences;
        this.cookies = new ConcurrentHashMap<>();
        String string = sharedPreferences.getString(COOKIE_NAME_STORE, null);
        if (string != null) {
            for (String str : TextUtils.split(string, ",")) {
                String string2 = this.cookiePrefs.getString(COOKIE_NAME_PREFIX + str, null);
                if (string2 != null && (cookieDecodeCookie = decodeCookie(string2)) != null) {
                    this.cookies.put(str, cookieDecodeCookie);
                }
            }
            clearExpired(new Date());
        }
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void addCookie(Cookie cookie) {
        if (!this.omitNonPersistentCookies || cookie.isPersistent()) {
            String str = cookie.getName() + cookie.getDomain();
            if (cookie.isExpired(new Date())) {
                this.cookies.remove(str);
            } else {
                this.cookies.put(str, cookie);
            }
            SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
            editorEdit.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
            editorEdit.putString(COOKIE_NAME_PREFIX + str, encodeCookie(new SerializableCookie(cookie)));
            editorEdit.apply();
        }
    }

    public String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            int i10 = b10 & 255;
            if (i10 < 16) {
                sb2.append('0');
            }
            sb2.append(Integer.toHexString(i10));
        }
        return sb2.toString().toUpperCase(Locale.US);
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public void clear() {
        SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
        Iterator<String> it = this.cookies.keySet().iterator();
        while (it.hasNext()) {
            editorEdit.remove(COOKIE_NAME_PREFIX + it.next());
        }
        editorEdit.remove(COOKIE_NAME_STORE);
        editorEdit.apply();
        this.cookies.clear();
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public boolean clearExpired(Date date) {
        SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
        boolean z10 = false;
        for (Map.Entry<String, Cookie> entry : this.cookies.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue().isExpired(date)) {
                this.cookies.remove(key);
                editorEdit.remove(COOKIE_NAME_PREFIX + key);
                z10 = true;
            }
        }
        if (z10) {
            editorEdit.putString(COOKIE_NAME_STORE, TextUtils.join(",", this.cookies.keySet()));
        }
        editorEdit.apply();
        return z10;
    }

    public Cookie decodeCookie(String str) {
        try {
            return ((SerializableCookie) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str))).readObject()).getCookie();
        } catch (IOException e10) {
            AsyncHttpClient.log.d(LOG_TAG, "IOException in decodeCookie", e10);
            return null;
        } catch (ClassNotFoundException e11) {
            AsyncHttpClient.log.d(LOG_TAG, "ClassNotFoundException in decodeCookie", e11);
            return null;
        }
    }

    public void deleteCookie(Cookie cookie) {
        String str = cookie.getName() + cookie.getDomain();
        this.cookies.remove(str);
        SharedPreferences.Editor editorEdit = this.cookiePrefs.edit();
        editorEdit.remove(COOKIE_NAME_PREFIX + str);
        editorEdit.apply();
    }

    public String encodeCookie(SerializableCookie serializableCookie) throws IOException {
        if (serializableCookie == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializableCookie);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (IOException e10) {
            AsyncHttpClient.log.d(LOG_TAG, "IOException in encodeCookie", e10);
            return null;
        }
    }

    @Override // cz.msebera.android.httpclient.client.CookieStore
    public List<Cookie> getCookies() {
        return new ArrayList(this.cookies.values());
    }

    public byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i10 = 0; i10 < length; i10 += 2) {
            bArr[i10 / 2] = (byte) (Character.digit(str.charAt(i10 + 1), 16) + (Character.digit(str.charAt(i10), 16) << 4));
        }
        return bArr;
    }

    public void setOmitNonPersistentCookies(boolean z10) {
        this.omitNonPersistentCookies = z10;
    }
}
