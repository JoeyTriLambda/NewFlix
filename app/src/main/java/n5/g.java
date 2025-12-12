package n5;

import java.util.Collections;
import java.util.List;
import n5.v;

/* compiled from: DvbSubtitleReader.java */
/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final List<v.a> f16540a;

    /* renamed from: b, reason: collision with root package name */
    public final g5.m[] f16541b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16542c;

    /* renamed from: d, reason: collision with root package name */
    public int f16543d;

    /* renamed from: e, reason: collision with root package name */
    public int f16544e;

    /* renamed from: f, reason: collision with root package name */
    public long f16545f;

    public g(List<v.a> list) {
        this.f16540a = list;
        this.f16541b = new g5.m[list.size()];
    }

    @Override // n5.h
    public void consume(l6.l lVar) {
        boolean z10;
        boolean z11;
        if (this.f16542c) {
            if (this.f16543d == 2) {
                if (lVar.bytesLeft() == 0) {
                    z11 = false;
                } else {
                    if (lVar.readUnsignedByte() != 32) {
                        this.f16542c = false;
                    }
                    this.f16543d--;
                    z11 = this.f16542c;
                }
                if (!z11) {
                    return;
                }
            }
            if (this.f16543d == 1) {
                if (lVar.bytesLeft() == 0) {
                    z10 = false;
                } else {
                    if (lVar.readUnsignedByte() != 0) {
                        this.f16542c = false;
                    }
                    this.f16543d--;
                    z10 = this.f16542c;
                }
                if (!z10) {
                    return;
                }
            }
            int position = lVar.getPosition();
            int iBytesLeft = lVar.bytesLeft();
            for (g5.m mVar : this.f16541b) {
                lVar.setPosition(position);
                mVar.sampleData(lVar, iBytesLeft);
            }
            this.f16544e += iBytesLeft;
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        int i10 = 0;
        while (true) {
            g5.m[] mVarArr = this.f16541b;
            if (i10 >= mVarArr.length) {
                return;
            }
            v.a aVar = this.f16540a.get(i10);
            dVar.generateNewId();
            g5.m mVarTrack = gVar.track(dVar.getTrackId(), 3);
            mVarTrack.format(c5.i.createImageSampleFormat(dVar.getFormatId(), "application/dvbsubs", null, -1, Collections.singletonList(aVar.f16722b), aVar.f16721a, null));
            mVarArr[i10] = mVarTrack;
            i10++;
        }
    }

    @Override // n5.h
    public void packetFinished() {
        if (this.f16542c) {
            for (g5.m mVar : this.f16541b) {
                mVar.sampleMetadata(this.f16545f, 1, this.f16544e, 0, null);
            }
            this.f16542c = false;
        }
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        if (z10) {
            this.f16542c = true;
            this.f16545f = j10;
            this.f16544e = 0;
            this.f16543d = 2;
        }
    }

    @Override // n5.h
    public void seek() {
        this.f16542c = false;
    }
}
