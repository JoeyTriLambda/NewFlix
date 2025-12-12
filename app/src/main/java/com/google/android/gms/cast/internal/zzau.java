package com.google.android.gms.cast.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.cast.zzed;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
public final class zzau {

    /* renamed from: j, reason: collision with root package name */
    public static final Object f6844j = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Logger f6845a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6846b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6847c;

    /* renamed from: h, reason: collision with root package name */
    public zzas f6852h;

    /* renamed from: i, reason: collision with root package name */
    public zzat f6853i;

    /* renamed from: e, reason: collision with root package name */
    public final Clock f6849e = DefaultClock.getInstance();

    /* renamed from: f, reason: collision with root package name */
    public long f6850f = -1;

    /* renamed from: g, reason: collision with root package name */
    public long f6851g = 0;

    /* renamed from: d, reason: collision with root package name */
    public final zzed f6848d = new zzed(Looper.getMainLooper());

    public zzau(long j10, String str) {
        this.f6846b = j10;
        this.f6847c = str;
        this.f6845a = new Logger("RequestTracker", str);
    }

    public static /* synthetic */ void zza(zzau zzauVar) {
        synchronized (f6844j) {
            if (zzauVar.zzf()) {
                zzauVar.b(15);
            }
        }
    }

    public final void a(String str, int i10, Object obj) {
        this.f6845a.d(str, new Object[0]);
        Object obj2 = f6844j;
        synchronized (obj2) {
            if (this.f6852h != null) {
                ((zzas) Preconditions.checkNotNull(this.f6852h)).zza(this.f6847c, this.f6850f, i10, obj, this.f6851g, this.f6849e.currentTimeMillis());
            }
            this.f6850f = -1L;
            this.f6852h = null;
            synchronized (obj2) {
                zzat zzatVar = this.f6853i;
                if (zzatVar != null) {
                    this.f6848d.removeCallbacks(zzatVar);
                    this.f6853i = null;
                }
            }
        }
    }

    public final boolean b(int i10) {
        synchronized (f6844j) {
            if (!zzf()) {
                return false;
            }
            a(String.format(Locale.ROOT, "clearing request %d", Long.valueOf(this.f6850f)), i10, null);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.google.android.gms.cast.internal.zzat, java.lang.Runnable] */
    public final void zzb(long j10, zzas zzasVar) {
        zzas zzasVar2;
        long j11;
        long j12;
        long jCurrentTimeMillis = this.f6849e.currentTimeMillis();
        Object obj = f6844j;
        synchronized (obj) {
            zzasVar2 = this.f6852h;
            j11 = this.f6850f;
            j12 = this.f6851g;
            this.f6850f = j10;
            this.f6852h = zzasVar;
            this.f6851g = jCurrentTimeMillis;
        }
        if (zzasVar2 != null) {
            zzasVar2.zzb(this.f6847c, j11, j12, jCurrentTimeMillis);
        }
        synchronized (obj) {
            zzat zzatVar = this.f6853i;
            if (zzatVar != null) {
                this.f6848d.removeCallbacks(zzatVar);
            }
            ?? r10 = new Runnable() { // from class: com.google.android.gms.cast.internal.zzat
                @Override // java.lang.Runnable
                public final void run() {
                    zzau.zza(this.f6843b);
                }
            };
            this.f6853i = r10;
            this.f6848d.postDelayed(r10, this.f6846b);
        }
    }

    public final boolean zzc(int i10) {
        return b(2002);
    }

    public final boolean zzd(long j10, int i10, Object obj) {
        synchronized (f6844j) {
            if (!zze(j10)) {
                return false;
            }
            a(String.format(Locale.ROOT, "request %d completed", Long.valueOf(j10)), i10, obj);
            return true;
        }
    }

    public final boolean zze(long j10) {
        boolean z10;
        synchronized (f6844j) {
            long j11 = this.f6850f;
            z10 = false;
            if (j11 != -1 && j11 == j10) {
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean zzf() {
        boolean z10;
        synchronized (f6844j) {
            z10 = this.f6850f != -1;
        }
        return z10;
    }
}
