package l5;

import com.google.android.exoplayer2.ParserException;
import g5.m;
import java.io.IOException;
import l5.b;
import l5.h;
import l6.l;

/* compiled from: OggExtractor.java */
/* loaded from: classes.dex */
public final class c implements g5.e {

    /* renamed from: a, reason: collision with root package name */
    public g5.g f15791a;

    /* renamed from: b, reason: collision with root package name */
    public h f15792b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f15793c;

    public final boolean a(g5.f fVar) throws InterruptedException, IOException {
        e eVar = new e();
        if (eVar.populate(fVar, true) && (eVar.f15800a & 2) == 2) {
            int iMin = Math.min(eVar.f15804e, 8);
            l lVar = new l(iMin);
            ((g5.b) fVar).peekFully(lVar.f15881a, 0, iMin);
            lVar.setPosition(0);
            if (b.verifyBitstreamType(lVar)) {
                this.f15792b = new b();
            } else {
                lVar.setPosition(0);
                if (j.verifyBitstreamType(lVar)) {
                    this.f15792b = new j();
                } else {
                    lVar.setPosition(0);
                    if (g.verifyBitstreamType(lVar)) {
                        this.f15792b = new g();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // g5.e
    public void init(g5.g gVar) {
        this.f15791a = gVar;
    }

    @Override // g5.e
    public int read(g5.f fVar, g5.k kVar) throws InterruptedException, IOException {
        d dVar;
        if (this.f15792b == null) {
            if (!a(fVar)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            ((g5.b) fVar).resetPeekPosition();
        }
        if (!this.f15793c) {
            m mVarTrack = this.f15791a.track(0, 1);
            this.f15791a.endTracks();
            h hVar = this.f15792b;
            hVar.f15812c = this.f15791a;
            hVar.f15811b = mVarTrack;
            hVar.reset(true);
            this.f15793c = true;
        }
        h hVar2 = this.f15792b;
        int i10 = hVar2.f15817h;
        d dVar2 = hVar2.f15810a;
        if (i10 == 0) {
            boolean z10 = true;
            while (z10) {
                if (dVar2.populate(fVar)) {
                    g5.b bVar = (g5.b) fVar;
                    hVar2.f15820k = bVar.getPosition() - hVar2.f15815f;
                    boolean headers = hVar2.readHeaders(dVar2.getPayload(), hVar2.f15815f, hVar2.f15819j);
                    if (headers) {
                        hVar2.f15815f = bVar.getPosition();
                    }
                    z10 = headers;
                } else {
                    hVar2.f15817h = 3;
                }
            }
            c5.i iVar = hVar2.f15819j.f15823a;
            hVar2.f15818i = iVar.D;
            if (!hVar2.f15822m) {
                hVar2.f15811b.format(iVar);
                hVar2.f15822m = true;
            }
            b.a aVar = hVar2.f15819j.f15824b;
            if (aVar != null) {
                hVar2.f15813d = aVar;
            } else {
                g5.b bVar2 = (g5.b) fVar;
                if (bVar2.getLength() != -1) {
                    e pageHeader = dVar2.getPageHeader();
                    dVar = dVar2;
                    hVar2.f15813d = new a(hVar2.f15815f, bVar2.getLength(), hVar2, pageHeader.f15804e + pageHeader.f15803d, pageHeader.f15801b);
                    hVar2.f15819j = null;
                    hVar2.f15817h = 2;
                    dVar.trimPayload();
                    return 0;
                }
                hVar2.f15813d = new h.b();
            }
            dVar = dVar2;
            hVar2.f15819j = null;
            hVar2.f15817h = 2;
            dVar.trimPayload();
            return 0;
        }
        if (i10 == 1) {
            ((g5.b) fVar).skipFully((int) hVar2.f15815f);
            hVar2.f15817h = 2;
            return 0;
        }
        if (i10 != 2) {
            throw new IllegalStateException();
        }
        long j10 = hVar2.f15813d.read(fVar);
        if (j10 >= 0) {
            kVar.f12726a = j10;
            return 1;
        }
        if (j10 < -1) {
            hVar2.onSeekEnd(-(j10 + 2));
        }
        if (!hVar2.f15821l) {
            hVar2.f15812c.seekMap(hVar2.f15813d.createSeekMap());
            hVar2.f15821l = true;
        }
        if (hVar2.f15820k > 0 || dVar2.populate(fVar)) {
            hVar2.f15820k = 0L;
            l payload = dVar2.getPayload();
            long jPreparePayload = hVar2.preparePayload(payload);
            if (jPreparePayload >= 0) {
                long j11 = hVar2.f15816g;
                if (j11 + jPreparePayload >= hVar2.f15814e) {
                    long jConvertGranuleToTime = hVar2.convertGranuleToTime(j11);
                    hVar2.f15811b.sampleData(payload, payload.limit());
                    hVar2.f15811b.sampleMetadata(jConvertGranuleToTime, 1, payload.limit(), 0, null);
                    hVar2.f15814e = -1L;
                }
            }
            hVar2.f15816g += jPreparePayload;
            return 0;
        }
        hVar2.f15817h = 3;
        return -1;
    }

    @Override // g5.e
    public void seek(long j10, long j11) {
        h hVar = this.f15792b;
        if (hVar != null) {
            hVar.f15810a.reset();
            if (j10 == 0) {
                hVar.reset(!hVar.f15821l);
            } else if (hVar.f15817h != 0) {
                hVar.f15814e = hVar.f15813d.startSeek(j11);
                hVar.f15817h = 2;
            }
        }
    }

    @Override // g5.e
    public boolean sniff(g5.f fVar) throws InterruptedException, IOException {
        try {
            return a(fVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // g5.e
    public void release() {
    }
}
