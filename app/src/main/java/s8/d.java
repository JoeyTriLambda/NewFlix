package s8;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KeysMap.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f19131a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final int f19132b;

    /* renamed from: c, reason: collision with root package name */
    public final int f19133c;

    public d(int i10, int i11) {
        this.f19132b = i10;
        this.f19133c = i11;
    }

    public static String sanitizeString(String str, int i10) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        return strTrim.length() > i10 ? strTrim.substring(0, i10) : strTrim;
    }

    public synchronized Map<String, String> getKeys() {
        return Collections.unmodifiableMap(new HashMap(this.f19131a));
    }

    public synchronized boolean setKey(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Custom attribute key must not be null.");
        }
        String strSanitizeString = sanitizeString(str, this.f19133c);
        if (this.f19131a.size() >= this.f19132b && !this.f19131a.containsKey(strSanitizeString)) {
            o8.e.getLogger().w("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f19132b);
            return false;
        }
        String strSanitizeString2 = sanitizeString(str2, this.f19133c);
        if (CommonUtils.nullSafeEquals((String) this.f19131a.get(strSanitizeString), strSanitizeString2)) {
            return false;
        }
        HashMap map = this.f19131a;
        if (str2 == null) {
            strSanitizeString2 = "";
        }
        map.put(strSanitizeString, strSanitizeString2);
        return true;
    }

    public synchronized void setKeys(Map<String, String> map) {
        int i10 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            if (key == null) {
                throw new IllegalArgumentException("Custom attribute key must not be null.");
            }
            String strSanitizeString = sanitizeString(key, this.f19133c);
            if (this.f19131a.size() < this.f19132b || this.f19131a.containsKey(strSanitizeString)) {
                String value = entry.getValue();
                this.f19131a.put(strSanitizeString, value == null ? "" : sanitizeString(value, this.f19133c));
            } else {
                i10++;
            }
        }
        if (i10 > 0) {
            o8.e.getLogger().w("Ignored " + i10 + " entries when adding custom keys. Maximum allowable: " + this.f19132b);
        }
    }
}
