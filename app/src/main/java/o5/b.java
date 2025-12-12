package o5;

/* compiled from: WavHeader.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f17019a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17020b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17021c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17022d;

    /* renamed from: e, reason: collision with root package name */
    public final int f17023e;

    /* renamed from: f, reason: collision with root package name */
    public final int f17024f;

    /* renamed from: g, reason: collision with root package name */
    public long f17025g;

    /* renamed from: h, reason: collision with root package name */
    public long f17026h;

    public b(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f17019a = i10;
        this.f17020b = i11;
        this.f17021c = i12;
        this.f17022d = i13;
        this.f17023e = i14;
        this.f17024f = i15;
    }

    public int getBitrate() {
        return this.f17020b * this.f17023e * this.f17019a;
    }

    public int getBytesPerFrame() {
        return this.f17022d;
    }

    public long getDurationUs() {
        return ((this.f17026h / this.f17022d) * 1000000) / this.f17020b;
    }

    public int getEncoding() {
        return this.f17024f;
    }

    public int getNumChannels() {
        return this.f17019a;
    }

    public long getPosition(long j10) {
        long j11 = (j10 * this.f17021c) / 1000000;
        int i10 = this.f17022d;
        return Math.min((j11 / i10) * i10, this.f17026h - i10) + this.f17025g;
    }

    public int getSampleRateHz() {
        return this.f17020b;
    }

    public long getTimeUs(long j10) {
        return (j10 * 1000000) / this.f17021c;
    }

    public boolean hasDataBounds() {
        return (this.f17025g == 0 || this.f17026h == 0) ? false : true;
    }

    public void setDataBounds(long j10, long j11) {
        this.f17025g = j10;
        this.f17026h = j11;
    }
}
