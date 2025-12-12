package l5;

import g5.l;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: DefaultOggSeeker.java */
/* loaded from: classes.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final e f15771a = new e();

    /* renamed from: b, reason: collision with root package name */
    public final long f15772b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15773c;

    /* renamed from: d, reason: collision with root package name */
    public final h f15774d;

    /* renamed from: e, reason: collision with root package name */
    public int f15775e;

    /* renamed from: f, reason: collision with root package name */
    public long f15776f;

    /* renamed from: g, reason: collision with root package name */
    public long f15777g;

    /* renamed from: h, reason: collision with root package name */
    public long f15778h;

    /* renamed from: i, reason: collision with root package name */
    public long f15779i;

    /* renamed from: j, reason: collision with root package name */
    public long f15780j;

    /* renamed from: k, reason: collision with root package name */
    public long f15781k;

    /* renamed from: l, reason: collision with root package name */
    public long f15782l;

    /* compiled from: DefaultOggSeeker.java */
    /* renamed from: l5.a$a, reason: collision with other inner class name */
    public class C0188a implements l {
        public C0188a() {
        }

        @Override // g5.l
        public long getDurationUs() {
            a aVar = a.this;
            return aVar.f15774d.convertGranuleToTime(aVar.f15776f);
        }

        @Override // g5.l
        public long getPosition(long j10) {
            a aVar = a.this;
            if (j10 == 0) {
                return aVar.f15772b;
            }
            long jConvertTimeToGranule = aVar.f15774d.convertTimeToGranule(j10);
            long j11 = aVar.f15772b;
            long j12 = aVar.f15773c;
            long j13 = ((((j12 - j11) * jConvertTimeToGranule) / aVar.f15776f) - 30000) + j11;
            if (j13 >= j11) {
                j11 = j13;
            }
            return j11 >= j12 ? j12 - 1 : j11;
        }

        @Override // g5.l
        public boolean isSeekable() {
            return true;
        }
    }

    public a(long j10, long j11, h hVar, int i10, long j12) {
        l6.a.checkArgument(j10 >= 0 && j11 > j10);
        this.f15774d = hVar;
        this.f15772b = j10;
        this.f15773c = j11;
        if (i10 != j11 - j10) {
            this.f15775e = 0;
        } else {
            this.f15776f = j12;
            this.f15775e = 3;
        }
    }

    public final boolean a(long j10, g5.f fVar) throws InterruptedException, IOException {
        int i10;
        long jMin = Math.min(j10 + 3, this.f15773c);
        int position = 2048;
        byte[] bArr = new byte[2048];
        while (true) {
            g5.b bVar = (g5.b) fVar;
            int i11 = 0;
            if (bVar.getPosition() + position > jMin && (position = (int) (jMin - bVar.getPosition())) < 4) {
                return false;
            }
            bVar.peekFully(bArr, 0, position, false);
            while (true) {
                i10 = position - 3;
                if (i11 < i10) {
                    if (bArr[i11] == 79 && bArr[i11 + 1] == 103 && bArr[i11 + 2] == 103 && bArr[i11 + 3] == 83) {
                        bVar.skipFully(i11);
                        return true;
                    }
                    i11++;
                }
            }
            bVar.skipFully(i10);
        }
    }

    public long getNextSeekPosition(long j10, g5.f fVar) throws InterruptedException, IOException {
        if (this.f15779i == this.f15780j) {
            return -(this.f15781k + 2);
        }
        g5.b bVar = (g5.b) fVar;
        long position = bVar.getPosition();
        if (!a(this.f15780j, bVar)) {
            long j11 = this.f15779i;
            if (j11 != position) {
                return j11;
            }
            throw new IOException("No ogg page can be found.");
        }
        e eVar = this.f15771a;
        eVar.populate(bVar, false);
        bVar.resetPeekPosition();
        long j12 = eVar.f15801b;
        long j13 = j10 - j12;
        int i10 = eVar.f15803d + eVar.f15804e;
        if (j13 >= 0 && j13 <= 72000) {
            bVar.skipFully(i10);
            return -(eVar.f15801b + 2);
        }
        if (j13 < 0) {
            this.f15780j = position;
            this.f15782l = j12;
        } else {
            long j14 = i10;
            long position2 = bVar.getPosition() + j14;
            this.f15779i = position2;
            this.f15781k = eVar.f15801b;
            if ((this.f15780j - position2) + j14 < 100000) {
                bVar.skipFully(i10);
                return -(this.f15781k + 2);
            }
        }
        long j15 = this.f15780j;
        long j16 = this.f15779i;
        if (j15 - j16 < 100000) {
            this.f15780j = j16;
            return j16;
        }
        long position3 = bVar.getPosition() - (i10 * (j13 <= 0 ? 2 : 1));
        long j17 = this.f15780j;
        long j18 = this.f15779i;
        return Math.min(Math.max((((j17 - j18) * j13) / (this.f15782l - this.f15781k)) + position3, j18), this.f15780j - 1);
    }

    @Override // l5.f
    public long read(g5.f fVar) throws InterruptedException, IOException {
        int i10 = this.f15775e;
        e eVar = this.f15771a;
        long j10 = this.f15773c;
        if (i10 == 0) {
            long position = ((g5.b) fVar).getPosition();
            this.f15777g = position;
            this.f15775e = 1;
            long j11 = j10 - 65307;
            if (j11 > position) {
                return j11;
            }
        } else if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j12 = this.f15778h;
            long j13 = 0;
            if (j12 != 0) {
                long nextSeekPosition = getNextSeekPosition(j12, fVar);
                if (nextSeekPosition >= 0) {
                    return nextSeekPosition;
                }
                long j14 = this.f15778h;
                long j15 = -(nextSeekPosition + 2);
                eVar.populate(fVar, false);
                while (eVar.f15801b < j14) {
                    g5.b bVar = (g5.b) fVar;
                    bVar.skipFully(eVar.f15803d + eVar.f15804e);
                    long j16 = eVar.f15801b;
                    eVar.populate(bVar, false);
                    j15 = j16;
                }
                ((g5.b) fVar).resetPeekPosition();
                j13 = j15;
            }
            this.f15775e = 3;
            return -(j13 + 2);
        }
        if (!a(j10, fVar)) {
            throw new EOFException();
        }
        eVar.reset();
        while ((eVar.f15800a & 4) != 4) {
            g5.b bVar2 = (g5.b) fVar;
            if (bVar2.getPosition() >= j10) {
                break;
            }
            eVar.populate(bVar2, false);
            bVar2.skipFully(eVar.f15803d + eVar.f15804e);
        }
        this.f15776f = eVar.f15801b;
        this.f15775e = 3;
        return this.f15777g;
    }

    public void resetSeeking() {
        this.f15779i = this.f15772b;
        this.f15780j = this.f15773c;
        this.f15781k = 0L;
        this.f15782l = this.f15776f;
    }

    @Override // l5.f
    public long startSeek(long j10) {
        int i10 = this.f15775e;
        l6.a.checkArgument(i10 == 3 || i10 == 2);
        this.f15778h = j10 != 0 ? this.f15774d.convertTimeToGranule(j10) : 0L;
        this.f15775e = 2;
        resetSeeking();
        return this.f15778h;
    }

    @Override // l5.f
    public C0188a createSeekMap() {
        if (this.f15776f != 0) {
            return new C0188a();
        }
        return null;
    }
}
