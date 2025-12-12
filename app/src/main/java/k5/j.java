package k5;

/* compiled from: Track.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f14912a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14913b;

    /* renamed from: c, reason: collision with root package name */
    public final long f14914c;

    /* renamed from: d, reason: collision with root package name */
    public final long f14915d;

    /* renamed from: e, reason: collision with root package name */
    public final long f14916e;

    /* renamed from: f, reason: collision with root package name */
    public final c5.i f14917f;

    /* renamed from: g, reason: collision with root package name */
    public final int f14918g;

    /* renamed from: h, reason: collision with root package name */
    public final long[] f14919h;

    /* renamed from: i, reason: collision with root package name */
    public final long[] f14920i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14921j;

    /* renamed from: k, reason: collision with root package name */
    public final k[] f14922k;

    public j(int i10, int i11, long j10, long j11, long j12, c5.i iVar, int i12, k[] kVarArr, int i13, long[] jArr, long[] jArr2) {
        this.f14912a = i10;
        this.f14913b = i11;
        this.f14914c = j10;
        this.f14915d = j11;
        this.f14916e = j12;
        this.f14917f = iVar;
        this.f14918g = i12;
        this.f14922k = kVarArr;
        this.f14921j = i13;
        this.f14919h = jArr;
        this.f14920i = jArr2;
    }

    public k getSampleDescriptionEncryptionBox(int i10) {
        k[] kVarArr = this.f14922k;
        if (kVarArr == null) {
            return null;
        }
        return kVarArr[i10];
    }
}
