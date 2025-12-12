package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
enum zzai {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');


    /* renamed from: b, reason: collision with root package name */
    public final char f7654b;

    zzai(char c10) {
        this.f7654b = c10;
    }

    public static zzai zza(char c10) {
        for (zzai zzaiVar : values()) {
            if (zzaiVar.f7654b == c10) {
                return zzaiVar;
            }
        }
        return UNSET;
    }
}
