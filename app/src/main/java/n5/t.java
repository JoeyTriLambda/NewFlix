package n5;

import n5.v;

/* compiled from: SpliceInfoSectionReader.java */
/* loaded from: classes.dex */
public final class t implements q {

    /* renamed from: a, reason: collision with root package name */
    public l6.r f16697a;

    /* renamed from: b, reason: collision with root package name */
    public g5.m f16698b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16699c;

    @Override // n5.q
    public void consume(l6.l lVar) {
        if (!this.f16699c) {
            if (this.f16697a.getTimestampOffsetUs() == -9223372036854775807L) {
                return;
            }
            this.f16698b.format(c5.i.createSampleFormat(null, "application/x-scte35", this.f16697a.getTimestampOffsetUs()));
            this.f16699c = true;
        }
        int iBytesLeft = lVar.bytesLeft();
        this.f16698b.sampleData(lVar, iBytesLeft);
        this.f16698b.sampleMetadata(this.f16697a.getLastAdjustedTimestampUs(), 1, iBytesLeft, 0, null);
    }

    @Override // n5.q
    public void init(l6.r rVar, g5.g gVar, v.d dVar) {
        this.f16697a = rVar;
        dVar.generateNewId();
        g5.m mVarTrack = gVar.track(dVar.getTrackId(), 4);
        this.f16698b = mVarTrack;
        mVarTrack.format(c5.i.createSampleFormat(dVar.getFormatId(), "application/x-scte35", null, -1, null));
    }
}
