package n5;

import android.util.Log;
import n5.v;

/* compiled from: Id3Reader.java */
/* loaded from: classes.dex */
public final class l implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l6.l f16640a = new l6.l(10);

    /* renamed from: b, reason: collision with root package name */
    public g5.m f16641b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16642c;

    /* renamed from: d, reason: collision with root package name */
    public long f16643d;

    /* renamed from: e, reason: collision with root package name */
    public int f16644e;

    /* renamed from: f, reason: collision with root package name */
    public int f16645f;

    @Override // n5.h
    public void consume(l6.l lVar) {
        if (this.f16642c) {
            int iBytesLeft = lVar.bytesLeft();
            int i10 = this.f16645f;
            if (i10 < 10) {
                int iMin = Math.min(iBytesLeft, 10 - i10);
                byte[] bArr = lVar.f15881a;
                int position = lVar.getPosition();
                l6.l lVar2 = this.f16640a;
                System.arraycopy(bArr, position, lVar2.f15881a, this.f16645f, iMin);
                if (this.f16645f + iMin == 10) {
                    lVar2.setPosition(0);
                    if (73 != lVar2.readUnsignedByte() || 68 != lVar2.readUnsignedByte() || 51 != lVar2.readUnsignedByte()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.f16642c = false;
                        return;
                    } else {
                        lVar2.skipBytes(3);
                        this.f16644e = lVar2.readSynchSafeInt() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iBytesLeft, this.f16644e - this.f16645f);
            this.f16641b.sampleData(lVar, iMin2);
            this.f16645f += iMin2;
        }
    }

    @Override // n5.h
    public void createTracks(g5.g gVar, v.d dVar) {
        dVar.generateNewId();
        g5.m mVarTrack = gVar.track(dVar.getTrackId(), 4);
        this.f16641b = mVarTrack;
        mVarTrack.format(c5.i.createSampleFormat(dVar.getFormatId(), "application/id3", null, -1, null));
    }

    @Override // n5.h
    public void packetFinished() {
        int i10;
        if (this.f16642c && (i10 = this.f16644e) != 0 && this.f16645f == i10) {
            this.f16641b.sampleMetadata(this.f16643d, 1, i10, 0, null);
            this.f16642c = false;
        }
    }

    @Override // n5.h
    public void packetStarted(long j10, boolean z10) {
        if (z10) {
            this.f16642c = true;
            this.f16643d = j10;
            this.f16644e = 0;
            this.f16645f = 0;
        }
    }

    @Override // n5.h
    public void seek() {
        this.f16642c = false;
    }
}
