package k5;

import java.io.IOException;

/* compiled from: TrackFragment.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public c f14927a;

    /* renamed from: b, reason: collision with root package name */
    public long f14928b;

    /* renamed from: c, reason: collision with root package name */
    public long f14929c;

    /* renamed from: d, reason: collision with root package name */
    public int f14930d;

    /* renamed from: e, reason: collision with root package name */
    public int f14931e;

    /* renamed from: f, reason: collision with root package name */
    public long[] f14932f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f14933g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f14934h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f14935i;

    /* renamed from: j, reason: collision with root package name */
    public long[] f14936j;

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f14937k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f14938l;

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f14939m;

    /* renamed from: n, reason: collision with root package name */
    public k f14940n;

    /* renamed from: o, reason: collision with root package name */
    public int f14941o;

    /* renamed from: p, reason: collision with root package name */
    public l6.l f14942p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f14943q;

    /* renamed from: r, reason: collision with root package name */
    public long f14944r;

    public void fillEncryptionData(g5.f fVar) throws InterruptedException, IOException {
        ((g5.b) fVar).readFully(this.f14942p.f15881a, 0, this.f14941o);
        this.f14942p.setPosition(0);
        this.f14943q = false;
    }

    public long getSamplePresentationTime(int i10) {
        return this.f14936j[i10] + this.f14935i[i10];
    }

    public void initEncryptionData(int i10) {
        l6.l lVar = this.f14942p;
        if (lVar == null || lVar.limit() < i10) {
            this.f14942p = new l6.l(i10);
        }
        this.f14941o = i10;
        this.f14938l = true;
        this.f14943q = true;
    }

    public void initTables(int i10, int i11) {
        this.f14930d = i10;
        this.f14931e = i11;
        int[] iArr = this.f14933g;
        if (iArr == null || iArr.length < i10) {
            this.f14932f = new long[i10];
            this.f14933g = new int[i10];
        }
        int[] iArr2 = this.f14934h;
        if (iArr2 == null || iArr2.length < i11) {
            int i12 = (i11 * 125) / 100;
            this.f14934h = new int[i12];
            this.f14935i = new int[i12];
            this.f14936j = new long[i12];
            this.f14937k = new boolean[i12];
            this.f14939m = new boolean[i12];
        }
    }

    public void reset() {
        this.f14930d = 0;
        this.f14944r = 0L;
        this.f14938l = false;
        this.f14943q = false;
        this.f14940n = null;
    }

    public void fillEncryptionData(l6.l lVar) {
        lVar.readBytes(this.f14942p.f15881a, 0, this.f14941o);
        this.f14942p.setPosition(0);
        this.f14943q = false;
    }
}
