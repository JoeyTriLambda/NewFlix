package v5;

/* compiled from: BaseMediaChunk.java */
/* loaded from: classes.dex */
public abstract class a extends l {

    /* renamed from: j, reason: collision with root package name */
    public b f20462j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f20463k;

    public a(k6.d dVar, k6.f fVar, c5.i iVar, int i10, Object obj, long j10, long j11, int i11) {
        super(dVar, fVar, iVar, i10, obj, j10, j11, i11);
    }

    public final int getFirstSampleIndex(int i10) {
        return this.f20463k[i10];
    }

    public final b getOutput() {
        return this.f20462j;
    }

    public void init(b bVar) {
        this.f20462j = bVar;
        this.f20463k = bVar.getWriteIndices();
    }
}
