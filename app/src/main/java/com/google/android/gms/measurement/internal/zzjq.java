package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
final class zzjq implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f8275b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f8276m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f8277n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Bundle f8278o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ boolean f8279p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f8280q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ boolean f8281r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ String f8282s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ zziy f8283t;

    public zzjq(zziy zziyVar, String str, String str2, long j10, Bundle bundle, boolean z10, boolean z11, boolean z12, String str3) {
        this.f8275b = str;
        this.f8276m = str2;
        this.f8277n = j10;
        this.f8278o = bundle;
        this.f8279p = z10;
        this.f8280q = z11;
        this.f8281r = z12;
        this.f8282s = str3;
        this.f8283t = zziyVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.f8283t.zza(this.f8275b, this.f8276m, this.f8277n, this.f8278o, this.f8279p, this.f8280q, this.f8281r, this.f8282s);
    }
}
