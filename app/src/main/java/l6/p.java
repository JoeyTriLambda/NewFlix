package l6;

import android.os.SystemClock;

/* compiled from: StandaloneMediaClock.java */
/* loaded from: classes.dex */
public final class p implements h {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15900b;

    /* renamed from: m, reason: collision with root package name */
    public long f15901m;

    /* renamed from: n, reason: collision with root package name */
    public long f15902n;

    /* renamed from: o, reason: collision with root package name */
    public c5.m f15903o = c5.m.f5142d;

    @Override // l6.h
    public c5.m getPlaybackParameters() {
        return this.f15903o;
    }

    @Override // l6.h
    public long getPositionUs() {
        long j10 = this.f15901m;
        if (!this.f15900b) {
            return j10;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f15902n;
        c5.m mVar = this.f15903o;
        return j10 + (mVar.f5143a == 1.0f ? c5.b.msToUs(jElapsedRealtime) : mVar.getSpeedAdjustedDurationUs(jElapsedRealtime));
    }

    @Override // l6.h
    public c5.m setPlaybackParameters(c5.m mVar) {
        if (this.f15900b) {
            setPositionUs(getPositionUs());
        }
        this.f15903o = mVar;
        return mVar;
    }

    public void setPositionUs(long j10) {
        this.f15901m = j10;
        if (this.f15900b) {
            this.f15902n = SystemClock.elapsedRealtime();
        }
    }

    public void start() {
        if (this.f15900b) {
            return;
        }
        this.f15902n = SystemClock.elapsedRealtime();
        this.f15900b = true;
    }

    public void stop() {
        if (this.f15900b) {
            setPositionUs(getPositionUs());
            this.f15900b = false;
        }
    }

    public void synchronize(h hVar) {
        setPositionUs(hVar.getPositionUs());
        this.f15903o = hVar.getPlaybackParameters();
    }
}
