package c5;

import com.google.android.exoplayer2.util.PriorityTaskManager;
import l6.u;

/* compiled from: DefaultLoadControl.java */
/* loaded from: classes.dex */
public final class c implements k {

    /* renamed from: a, reason: collision with root package name */
    public final k6.g f5036a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5037b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5038c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5039d;

    /* renamed from: e, reason: collision with root package name */
    public final long f5040e;

    /* renamed from: f, reason: collision with root package name */
    public int f5041f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5042g;

    public c() {
        this(new k6.g(true, 65536));
    }

    public k6.b getAllocator() {
        return this.f5036a;
    }

    public void onPrepared() {
        this.f5041f = 0;
        this.f5042g = false;
    }

    public void onReleased() {
        this.f5041f = 0;
        this.f5042g = false;
        this.f5036a.reset();
    }

    public void onStopped() {
        this.f5041f = 0;
        this.f5042g = false;
        this.f5036a.reset();
    }

    public void onTracksSelected(o[] oVarArr, u5.o oVar, j6.g gVar) {
        this.f5041f = 0;
        for (int i10 = 0; i10 < oVarArr.length; i10++) {
            if (gVar.get(i10) != null) {
                this.f5041f = u.getDefaultBufferSize(oVarArr[i10].getTrackType()) + this.f5041f;
            }
        }
        this.f5036a.setTargetBufferSize(this.f5041f);
    }

    public boolean shouldContinueLoading(long j10) {
        boolean z10 = false;
        char c10 = j10 > this.f5038c ? (char) 0 : j10 < this.f5037b ? (char) 2 : (char) 1;
        boolean z11 = this.f5036a.getTotalBytesAllocated() >= this.f5041f;
        boolean z12 = this.f5042g;
        if (c10 == 2 || (c10 == 1 && z12 && !z11)) {
            z10 = true;
        }
        this.f5042g = z10;
        return z10;
    }

    public boolean shouldStartPlayback(long j10, boolean z10) {
        long j11 = z10 ? this.f5040e : this.f5039d;
        return j11 <= 0 || j10 >= j11;
    }

    public c(k6.g gVar) {
        this(gVar, 15000, 30000, 2500L, 5000L);
    }

    public c(k6.g gVar, int i10, int i11, long j10, long j11) {
        this(gVar, i10, i11, j10, j11, null);
    }

    public c(k6.g gVar, int i10, int i11, long j10, long j11, PriorityTaskManager priorityTaskManager) {
        this.f5036a = gVar;
        this.f5037b = i10 * 1000;
        this.f5038c = i11 * 1000;
        this.f5039d = j10 * 1000;
        this.f5040e = j11 * 1000;
    }
}
