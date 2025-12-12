package o5;

import c5.i;
import com.google.android.exoplayer2.ParserException;
import g5.e;
import g5.f;
import g5.g;
import g5.k;
import g5.l;
import g5.m;
import java.io.IOException;

/* compiled from: WavExtractor.java */
/* loaded from: classes.dex */
public final class a implements e, l {

    /* renamed from: a, reason: collision with root package name */
    public g f17014a;

    /* renamed from: b, reason: collision with root package name */
    public m f17015b;

    /* renamed from: c, reason: collision with root package name */
    public b f17016c;

    /* renamed from: d, reason: collision with root package name */
    public int f17017d;

    /* renamed from: e, reason: collision with root package name */
    public int f17018e;

    @Override // g5.l
    public long getDurationUs() {
        return this.f17016c.getDurationUs();
    }

    @Override // g5.l
    public long getPosition(long j10) {
        return this.f17016c.getPosition(j10);
    }

    @Override // g5.e
    public void init(g gVar) {
        this.f17014a = gVar;
        this.f17015b = gVar.track(0, 1);
        this.f17016c = null;
        gVar.endTracks();
    }

    @Override // g5.l
    public boolean isSeekable() {
        return true;
    }

    @Override // g5.e
    public int read(f fVar, k kVar) throws InterruptedException, IOException {
        if (this.f17016c == null) {
            b bVarPeek = c.peek(fVar);
            this.f17016c = bVarPeek;
            if (bVarPeek == null) {
                throw new ParserException("Unsupported or unrecognized wav header.");
            }
            this.f17015b.format(i.createAudioSampleFormat(null, "audio/raw", null, bVarPeek.getBitrate(), 32768, this.f17016c.getNumChannels(), this.f17016c.getSampleRateHz(), this.f17016c.getEncoding(), null, null, 0, null));
            this.f17017d = this.f17016c.getBytesPerFrame();
        }
        if (!this.f17016c.hasDataBounds()) {
            c.skipToData(fVar, this.f17016c);
            this.f17014a.seekMap(this);
        }
        int iSampleData = this.f17015b.sampleData(fVar, 32768 - this.f17018e, true);
        if (iSampleData != -1) {
            this.f17018e += iSampleData;
        }
        int i10 = this.f17018e / this.f17017d;
        if (i10 > 0) {
            long timeUs = this.f17016c.getTimeUs(((g5.b) fVar).getPosition() - this.f17018e);
            int i11 = i10 * this.f17017d;
            int i12 = this.f17018e - i11;
            this.f17018e = i12;
            this.f17015b.sampleMetadata(timeUs, 1, i11, i12, null);
        }
        return iSampleData == -1 ? -1 : 0;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        this.f17018e = 0;
    }

    @Override // g5.e
    public boolean sniff(f fVar) throws InterruptedException, IOException {
        return c.peek(fVar) != null;
    }

    @Override // g5.e
    public void release() {
    }
}
