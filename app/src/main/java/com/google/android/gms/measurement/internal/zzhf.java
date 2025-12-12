package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzfn;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final /* synthetic */ class zzhf {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f8068a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f8069b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f8070c;

    static {
        int[] iArr = new int[zzfn.zza.zzd.values().length];
        f8070c = iArr;
        try {
            iArr[zzfn.zza.zzd.DENIED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f8070c[zzfn.zza.zzd.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[zzfn.zza.zze.values().length];
        f8069b = iArr2;
        try {
            iArr2[zzfn.zza.zze.AD_STORAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f8069b[zzfn.zza.zze.ANALYTICS_STORAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f8069b[zzfn.zza.zze.AD_USER_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f8069b[zzfn.zza.zze.AD_PERSONALIZATION.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr3 = new int[com.google.android.gms.internal.measurement.zzs.values().length];
        f8068a = iArr3;
        try {
            iArr3[com.google.android.gms.internal.measurement.zzs.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f8068a[com.google.android.gms.internal.measurement.zzs.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f8068a[com.google.android.gms.internal.measurement.zzs.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f8068a[com.google.android.gms.internal.measurement.zzs.VERBOSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
