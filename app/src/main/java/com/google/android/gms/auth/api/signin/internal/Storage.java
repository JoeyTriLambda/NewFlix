package com.google.android.gms.auth.api.signin.internal;

import ac.c;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
/* loaded from: classes.dex */
public class Storage {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f6098c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static Storage f6099d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f6100a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f6101b;

    @VisibleForTesting
    public Storage(Context context) {
        this.f6101b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static final String a(String str, String str2) {
        return c.p(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, ":", str2);
    }

    @KeepForSdk
    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        ReentrantLock reentrantLock = f6098c;
        reentrantLock.lock();
        try {
            if (f6099d == null) {
                f6099d = new Storage(context.getApplicationContext());
            }
            return f6099d;
        } finally {
            reentrantLock.unlock();
        }
    }

    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String strZaa;
        String strZaa2 = zaa("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(strZaa2) || (strZaa = zaa(a("googleSignInAccount", strZaa2))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.zab(strZaa);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String zaa(String str) {
        ReentrantLock reentrantLock = this.f6100a;
        reentrantLock.lock();
        try {
            return this.f6101b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
