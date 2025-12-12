package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzo {

    /* renamed from: d, reason: collision with root package name */
    public static final Uri f7422d = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: a, reason: collision with root package name */
    public final String f7423a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7424b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7425c;

    public zzo(String str, String str2, int i10, boolean z10) {
        Preconditions.checkNotEmpty(str);
        this.f7423a = str;
        Preconditions.checkNotEmpty(str2);
        this.f7424b = str2;
        this.f7425c = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzo)) {
            return false;
        }
        zzo zzoVar = (zzo) obj;
        return Objects.equal(this.f7423a, zzoVar.f7423a) && Objects.equal(this.f7424b, zzoVar.f7424b) && Objects.equal(null, null) && this.f7425c == zzoVar.f7425c;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f7423a, this.f7424b, null, 4225, Boolean.valueOf(this.f7425c));
    }

    public final String toString() {
        String str = this.f7423a;
        if (str != null) {
            return str;
        }
        Preconditions.checkNotNull(null);
        throw null;
    }

    public final ComponentName zza() {
        return null;
    }

    public final Intent zzb(Context context) {
        Bundle bundleCall;
        String str = this.f7423a;
        if (str == null) {
            return new Intent().setComponent(null);
        }
        if (this.f7425c) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", str);
            try {
                bundleCall = context.getContentResolver().call(f7422d, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e10) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e10.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(str)));
            }
        }
        return intent == null ? new Intent(str).setPackage(this.f7424b) : intent;
    }

    public final String zzc() {
        return this.f7424b;
    }
}
