package c5;

import android.util.Pair;
import c5.g;
import c5.r;
import u5.h;

/* compiled from: MediaPeriodInfoSequence.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final r.b f5131a = new r.b();

    /* renamed from: b, reason: collision with root package name */
    public final r.c f5132b = new r.c();

    /* renamed from: c, reason: collision with root package name */
    public r f5133c;

    /* renamed from: d, reason: collision with root package name */
    public int f5134d;

    /* compiled from: MediaPeriodInfoSequence.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final h.b f5135a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5136b;

        /* renamed from: c, reason: collision with root package name */
        public final long f5137c;

        /* renamed from: d, reason: collision with root package name */
        public final long f5138d;

        /* renamed from: e, reason: collision with root package name */
        public final long f5139e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f5140f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f5141g;

        public a(h.b bVar, long j10, long j11, long j12, long j13, boolean z10, boolean z11) {
            this.f5135a = bVar;
            this.f5136b = j10;
            this.f5137c = j11;
            this.f5138d = j12;
            this.f5139e = j13;
            this.f5140f = z10;
            this.f5141g = z11;
        }

        public a copyWithPeriodIndex(int i10) {
            return new a(this.f5135a.copyWithPeriodIndex(i10), this.f5136b, this.f5137c, this.f5138d, this.f5139e, this.f5140f, this.f5141g);
        }

        public a copyWithStartPositionUs(long j10) {
            return new a(this.f5135a, j10, this.f5137c, this.f5138d, this.f5139e, this.f5140f, this.f5141g);
        }
    }

    public final a a(h.b bVar, long j10, long j11) {
        r rVar = this.f5133c;
        int i10 = bVar.f20054a;
        r.b bVar2 = this.f5131a;
        rVar.getPeriod(i10, bVar2);
        if (bVar.isAd()) {
            if (bVar2.isAdAvailable(bVar.f20055b, bVar.f20056c)) {
                return b(bVar.f20054a, bVar.f20055b, bVar.f20056c, j10);
            }
            return null;
        }
        int adGroupIndexAfterPositionUs = bVar2.getAdGroupIndexAfterPositionUs(j11);
        return c(bVar.f20054a, j11, adGroupIndexAfterPositionUs == -1 ? Long.MIN_VALUE : bVar2.getAdGroupTimeUs(adGroupIndexAfterPositionUs));
    }

    public final a b(int i10, int i11, int i12, long j10) {
        h.b bVar = new h.b(i10, i11, i12);
        boolean zE = e(bVar, Long.MIN_VALUE);
        boolean zF = f(bVar, zE);
        r rVar = this.f5133c;
        int i13 = bVar.f20054a;
        r.b bVar2 = this.f5131a;
        return new a(bVar, i12 == bVar2.getPlayedAdCount(i11) ? bVar2.getAdResumePositionUs() : 0L, Long.MIN_VALUE, j10, rVar.getPeriod(i13, bVar2).getAdDurationUs(bVar.f20055b, bVar.f20056c), zE, zF);
    }

    public final a c(int i10, long j10, long j11) {
        h.b bVar = new h.b(i10);
        boolean zE = e(bVar, j11);
        boolean zF = f(bVar, zE);
        r rVar = this.f5133c;
        int i11 = bVar.f20054a;
        r.b bVar2 = this.f5131a;
        rVar.getPeriod(i11, bVar2);
        return new a(bVar, j10, j11, -9223372036854775807L, j11 == Long.MIN_VALUE ? bVar2.getDurationUs() : j11, zE, zF);
    }

    public final a d(a aVar, h.b bVar) {
        long j10;
        long durationUs;
        long j11 = aVar.f5136b;
        long j12 = aVar.f5137c;
        boolean zE = e(bVar, j12);
        boolean zF = f(bVar, zE);
        r rVar = this.f5133c;
        int i10 = bVar.f20054a;
        r.b bVar2 = this.f5131a;
        rVar.getPeriod(i10, bVar2);
        if (bVar.isAd()) {
            durationUs = bVar2.getAdDurationUs(bVar.f20055b, bVar.f20056c);
        } else {
            if (j12 != Long.MIN_VALUE) {
                j10 = j12;
                return new a(bVar, j11, j12, aVar.f5138d, j10, zE, zF);
            }
            durationUs = bVar2.getDurationUs();
        }
        j10 = durationUs;
        return new a(bVar, j11, j12, aVar.f5138d, j10, zE, zF);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean e(u5.h.b r11, long r12) {
        /*
            r10 = this;
            c5.r r0 = r10.f5133c
            int r1 = r11.f20054a
            c5.r$b r2 = r10.f5131a
            c5.r$b r0 = r0.getPeriod(r1, r2)
            int r0 = r0.getAdGroupCount()
            r1 = 1
            if (r0 != 0) goto L12
            return r1
        L12:
            int r0 = r0 - r1
            boolean r3 = r11.isAd()
            long r4 = r2.getAdGroupTimeUs(r0)
            r6 = -9223372036854775808
            r8 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 == 0) goto L2b
            if (r3 != 0) goto L29
            int r11 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r11 != 0) goto L29
            goto L2a
        L29:
            r1 = 0
        L2a:
            return r1
        L2b:
            int r12 = r2.getAdCountInAdGroup(r0)
            r13 = -1
            if (r12 != r13) goto L33
            return r8
        L33:
            if (r3 == 0) goto L41
            int r13 = r11.f20055b
            if (r13 != r0) goto L41
            int r13 = r12 + (-1)
            int r11 = r11.f20056c
            if (r11 != r13) goto L41
            r11 = 1
            goto L42
        L41:
            r11 = 0
        L42:
            if (r11 != 0) goto L4e
            if (r3 != 0) goto L4d
            int r11 = r2.getPlayedAdCount(r0)
            if (r11 != r12) goto L4d
            goto L4e
        L4d:
            r1 = 0
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: c5.l.e(u5.h$b, long):boolean");
    }

    public final boolean f(h.b bVar, boolean z10) {
        r rVar = this.f5133c;
        int i10 = bVar.f20054a;
        r.b bVar2 = this.f5131a;
        int i11 = rVar.getPeriod(i10, bVar2).f5151c;
        r rVar2 = this.f5133c;
        r.c cVar = this.f5132b;
        return !rVar2.getWindow(i11, cVar).f5161b && this.f5133c.isLastPeriod(bVar.f20054a, bVar2, cVar, this.f5134d) && z10;
    }

    public a getFirstMediaPeriodInfo(g.b bVar) {
        return a(bVar.f5101a, bVar.f5103c, bVar.f5102b);
    }

    public a getNextMediaPeriodInfo(a aVar, long j10, long j11) {
        boolean z10 = aVar.f5140f;
        r.b bVar = this.f5131a;
        h.b bVar2 = aVar.f5135a;
        if (z10) {
            r rVar = this.f5133c;
            int i10 = bVar2.f20054a;
            int i11 = this.f5134d;
            r.c cVar = this.f5132b;
            int nextPeriodIndex = rVar.getNextPeriodIndex(i10, bVar, cVar, i11);
            if (nextPeriodIndex == -1) {
                return null;
            }
            int i12 = this.f5133c.getPeriod(nextPeriodIndex, bVar).f5151c;
            long jLongValue = 0;
            if (this.f5133c.getWindow(i12, cVar).f5162c == nextPeriodIndex) {
                Pair<Integer, Long> periodPosition = this.f5133c.getPeriodPosition(this.f5132b, this.f5131a, i12, -9223372036854775807L, Math.max(0L, (j10 + aVar.f5139e) - j11));
                if (periodPosition == null) {
                    return null;
                }
                nextPeriodIndex = ((Integer) periodPosition.first).intValue();
                jLongValue = ((Long) periodPosition.second).longValue();
            }
            return a(resolvePeriodPositionForAds(nextPeriodIndex, jLongValue), jLongValue, jLongValue);
        }
        if (bVar2.isAd()) {
            int i13 = bVar2.f20055b;
            this.f5133c.getPeriod(bVar2.f20054a, bVar);
            int adCountInAdGroup = bVar.getAdCountInAdGroup(i13);
            if (adCountInAdGroup == -1) {
                return null;
            }
            int i14 = bVar2.f20056c + 1;
            if (i14 >= adCountInAdGroup) {
                int adGroupIndexAfterPositionUs = bVar.getAdGroupIndexAfterPositionUs(aVar.f5138d);
                return c(bVar2.f20054a, aVar.f5138d, adGroupIndexAfterPositionUs != -1 ? bVar.getAdGroupTimeUs(adGroupIndexAfterPositionUs) : Long.MIN_VALUE);
            }
            if (bVar.isAdAvailable(i13, i14)) {
                return b(bVar2.f20054a, i13, i14, aVar.f5138d);
            }
            return null;
        }
        long j12 = aVar.f5137c;
        if (j12 != Long.MIN_VALUE) {
            int adGroupIndexForPositionUs = bVar.getAdGroupIndexForPositionUs(j12);
            if (bVar.isAdAvailable(adGroupIndexForPositionUs, 0)) {
                return b(bVar2.f20054a, adGroupIndexForPositionUs, 0, aVar.f5137c);
            }
            return null;
        }
        int adGroupCount = bVar.getAdGroupCount();
        if (adGroupCount != 0) {
            int i15 = adGroupCount - 1;
            if (bVar.getAdGroupTimeUs(i15) == Long.MIN_VALUE && !bVar.hasPlayedAdGroup(i15) && bVar.isAdAvailable(i15, 0)) {
                return b(bVar2.f20054a, i15, 0, bVar.getDurationUs());
            }
        }
        return null;
    }

    public a getUpdatedMediaPeriodInfo(a aVar) {
        return d(aVar, aVar.f5135a);
    }

    public h.b resolvePeriodPositionForAds(int i10, long j10) {
        r rVar = this.f5133c;
        r.b bVar = this.f5131a;
        rVar.getPeriod(i10, bVar);
        int adGroupIndexForPositionUs = bVar.getAdGroupIndexForPositionUs(j10);
        return adGroupIndexForPositionUs == -1 ? new h.b(i10) : new h.b(i10, adGroupIndexForPositionUs, bVar.getPlayedAdCount(adGroupIndexForPositionUs));
    }

    public void setRepeatMode(int i10) {
        this.f5134d = i10;
    }

    public void setTimeline(r rVar) {
        this.f5133c = rVar;
    }

    public a getUpdatedMediaPeriodInfo(a aVar, int i10) {
        return d(aVar, aVar.f5135a.copyWithPeriodIndex(i10));
    }
}
