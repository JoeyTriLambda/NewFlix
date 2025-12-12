package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* loaded from: classes.dex */
final class zzgi implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final URL f7982b;

    /* renamed from: m, reason: collision with root package name */
    public final byte[] f7983m;

    /* renamed from: n, reason: collision with root package name */
    public final zzgh f7984n;

    /* renamed from: o, reason: collision with root package name */
    public final String f7985o;

    /* renamed from: p, reason: collision with root package name */
    public final Map<String, String> f7986p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ zzge f7987q;

    public zzgi(zzge zzgeVar, String str, URL url, byte[] bArr, Map<String, String> map, zzgh zzghVar) {
        this.f7987q = zzgeVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzghVar);
        this.f7982b = url;
        this.f7983m = bArr;
        this.f7984n = zzghVar;
        this.f7985o = str;
        this.f7986p = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgi.run():void");
    }
}
