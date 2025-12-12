package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-flags@@17.0.1 */
@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends com.google.android.gms.flags.zzd {

    /* renamed from: a, reason: collision with root package name */
    public boolean f7588a = false;

    /* renamed from: b, reason: collision with root package name */
    public SharedPreferences f7589b;

    @Override // com.google.android.gms.flags.zze
    public boolean getBooleanFlagValue(String str, boolean z10, int i10) {
        if (!this.f7588a) {
            return z10;
        }
        SharedPreferences sharedPreferences = this.f7589b;
        Boolean boolValueOf = Boolean.valueOf(z10);
        try {
            boolValueOf = (Boolean) com.google.android.gms.internal.flags.zzd.zza(new zza(sharedPreferences, str, boolValueOf));
        } catch (Exception e10) {
            String strValueOf = String.valueOf(e10.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.google.android.gms.flags.zze
    public int getIntFlagValue(String str, int i10, int i11) {
        if (!this.f7588a) {
            return i10;
        }
        SharedPreferences sharedPreferences = this.f7589b;
        Integer numValueOf = Integer.valueOf(i10);
        try {
            numValueOf = (Integer) com.google.android.gms.internal.flags.zzd.zza(new zzb(sharedPreferences, str, numValueOf));
        } catch (Exception e10) {
            String strValueOf = String.valueOf(e10.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return numValueOf.intValue();
    }

    @Override // com.google.android.gms.flags.zze
    public long getLongFlagValue(String str, long j10, int i10) {
        if (!this.f7588a) {
            return j10;
        }
        SharedPreferences sharedPreferences = this.f7589b;
        Long lValueOf = Long.valueOf(j10);
        try {
            lValueOf = (Long) com.google.android.gms.internal.flags.zzd.zza(new zzc(sharedPreferences, str, lValueOf));
        } catch (Exception e10) {
            String strValueOf = String.valueOf(e10.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
        }
        return lValueOf.longValue();
    }

    @Override // com.google.android.gms.flags.zze
    public String getStringFlagValue(String str, String str2, int i10) {
        if (!this.f7588a) {
            return str2;
        }
        try {
            return (String) com.google.android.gms.internal.flags.zzd.zza(new zzd(this.f7589b, str, str2));
        } catch (Exception e10) {
            String strValueOf = String.valueOf(e10.getMessage());
            Log.w("FlagDataUtils", strValueOf.length() != 0 ? "Flag value not available, returning default: ".concat(strValueOf) : new String("Flag value not available, returning default: "));
            return str2;
        }
    }

    @Override // com.google.android.gms.flags.zze
    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.f7588a) {
            return;
        }
        try {
            this.f7589b = zzf.zza(context.createPackageContext("com.google.android.gms", 0));
            this.f7588a = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e10) {
            String strValueOf = String.valueOf(e10.getMessage());
            Log.w("FlagProviderImpl", strValueOf.length() != 0 ? "Could not retrieve sdk flags, continuing with defaults: ".concat(strValueOf) : new String("Could not retrieve sdk flags, continuing with defaults: "));
        }
    }
}
