package l6;

/* compiled from: FlacStreamInfo.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f15854a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15855b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15856c;

    /* renamed from: d, reason: collision with root package name */
    public final long f15857d;

    public f(byte[] bArr, int i10) {
        k kVar = new k(bArr);
        kVar.setPosition(i10 * 8);
        kVar.readBits(16);
        kVar.readBits(16);
        kVar.readBits(24);
        kVar.readBits(24);
        this.f15854a = kVar.readBits(20);
        this.f15855b = kVar.readBits(3) + 1;
        this.f15856c = kVar.readBits(5) + 1;
        this.f15857d = ((kVar.readBits(4) & 15) << 32) | (kVar.readBits(32) & 4294967295L);
    }

    public int bitRate() {
        return this.f15856c * this.f15854a;
    }

    public long durationUs() {
        return (this.f15857d * 1000000) / this.f15854a;
    }
}
