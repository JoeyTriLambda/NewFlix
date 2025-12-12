package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzgg implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final zzgh f7976b;

    /* renamed from: m, reason: collision with root package name */
    public final int f7977m;

    /* renamed from: n, reason: collision with root package name */
    public final Throwable f7978n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f7979o;

    /* renamed from: p, reason: collision with root package name */
    public final String f7980p;

    /* renamed from: q, reason: collision with root package name */
    public final Map<String, List<String>> f7981q;

    public zzgg() {
        throw null;
    }

    public zzgg(String str, zzgh zzghVar, int i10, IOException iOException, byte[] bArr, Map map) {
        Preconditions.checkNotNull(zzghVar);
        this.f7976b = zzghVar;
        this.f7977m = i10;
        this.f7978n = iOException;
        this.f7979o = bArr;
        this.f7980p = str;
        this.f7981q = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7976b.zza(this.f7980p, this.f7977m, this.f7978n, this.f7979o, this.f7981q);
    }
}
