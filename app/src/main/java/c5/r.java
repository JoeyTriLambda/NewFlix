package c5;

import android.util.Pair;

/* compiled from: Timeline.java */
/* loaded from: classes.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final a f5148a = new a();

    /* compiled from: Timeline.java */
    public static class a extends r {
        @Override // c5.r
        public int getIndexOfPeriod(Object obj) {
            return -1;
        }

        @Override // c5.r
        public b getPeriod(int i10, b bVar, boolean z10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // c5.r
        public int getPeriodCount() {
            return 0;
        }

        @Override // c5.r
        public c getWindow(int i10, c cVar, boolean z10, long j10) {
            throw new IndexOutOfBoundsException();
        }

        @Override // c5.r
        public int getWindowCount() {
            return 0;
        }
    }

    /* compiled from: Timeline.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public Object f5149a;

        /* renamed from: b, reason: collision with root package name */
        public Object f5150b;

        /* renamed from: c, reason: collision with root package name */
        public int f5151c;

        /* renamed from: d, reason: collision with root package name */
        public long f5152d;

        /* renamed from: e, reason: collision with root package name */
        public long f5153e;

        /* renamed from: f, reason: collision with root package name */
        public long[] f5154f;

        /* renamed from: g, reason: collision with root package name */
        public int[] f5155g;

        /* renamed from: h, reason: collision with root package name */
        public int[] f5156h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f5157i;

        /* renamed from: j, reason: collision with root package name */
        public long[][] f5158j;

        /* renamed from: k, reason: collision with root package name */
        public long f5159k;

        public int getAdCountInAdGroup(int i10) {
            return this.f5155g[i10];
        }

        public long getAdDurationUs(int i10, int i11) {
            long[] jArr = this.f5158j[i10];
            if (i11 >= jArr.length) {
                return -9223372036854775807L;
            }
            return jArr[i11];
        }

        public int getAdGroupCount() {
            long[] jArr = this.f5154f;
            if (jArr == null) {
                return 0;
            }
            return jArr.length;
        }

        public int getAdGroupIndexAfterPositionUs(long j10) {
            if (this.f5154f == null) {
                return -1;
            }
            int i10 = 0;
            while (true) {
                long[] jArr = this.f5154f;
                if (i10 >= jArr.length) {
                    break;
                }
                long j11 = jArr[i10];
                if (j11 == Long.MIN_VALUE || (j10 < j11 && !hasPlayedAdGroup(i10))) {
                    break;
                }
                i10++;
            }
            if (i10 < this.f5154f.length) {
                return i10;
            }
            return -1;
        }

        public int getAdGroupIndexForPositionUs(long j10) {
            long[] jArr = this.f5154f;
            if (jArr == null) {
                return -1;
            }
            int length = jArr.length - 1;
            while (length >= 0) {
                long j11 = this.f5154f[length];
                if (j11 != Long.MIN_VALUE && j11 <= j10) {
                    break;
                }
                length--;
            }
            if (length < 0 || hasPlayedAdGroup(length)) {
                return -1;
            }
            return length;
        }

        public long getAdGroupTimeUs(int i10) {
            return this.f5154f[i10];
        }

        public long getAdResumePositionUs() {
            return this.f5159k;
        }

        public long getDurationUs() {
            return this.f5152d;
        }

        public int getPlayedAdCount(int i10) {
            return this.f5157i[i10];
        }

        public long getPositionInWindowMs() {
            return c5.b.usToMs(this.f5153e);
        }

        public boolean hasPlayedAdGroup(int i10) {
            int i11 = this.f5155g[i10];
            return i11 != -1 && this.f5157i[i10] == i11;
        }

        public boolean isAdAvailable(int i10, int i11) {
            return i11 < this.f5156h[i10];
        }

        public b set(Object obj, Object obj2, int i10, long j10, long j11) {
            return set(obj, obj2, i10, j10, j11, null, null, null, null, null, -9223372036854775807L);
        }

        public b set(Object obj, Object obj2, int i10, long j10, long j11, long[] jArr, int[] iArr, int[] iArr2, int[] iArr3, long[][] jArr2, long j12) {
            this.f5149a = obj;
            this.f5150b = obj2;
            this.f5151c = i10;
            this.f5152d = j10;
            this.f5153e = j11;
            this.f5154f = jArr;
            this.f5155g = iArr;
            this.f5156h = iArr2;
            this.f5157i = iArr3;
            this.f5158j = jArr2;
            this.f5159k = j12;
            return this;
        }
    }

    /* compiled from: Timeline.java */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public Object f5160a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f5161b;

        /* renamed from: c, reason: collision with root package name */
        public int f5162c;

        /* renamed from: d, reason: collision with root package name */
        public int f5163d;

        /* renamed from: e, reason: collision with root package name */
        public long f5164e;

        /* renamed from: f, reason: collision with root package name */
        public long f5165f;

        /* renamed from: g, reason: collision with root package name */
        public long f5166g;

        public long getDefaultPositionUs() {
            return this.f5164e;
        }

        public long getDurationMs() {
            return c5.b.usToMs(this.f5165f);
        }

        public long getPositionInFirstPeriodUs() {
            return this.f5166g;
        }

        public c set(Object obj, long j10, long j11, boolean z10, boolean z11, long j12, long j13, int i10, int i11, long j14) {
            this.f5160a = obj;
            this.f5161b = z11;
            this.f5164e = j12;
            this.f5165f = j13;
            this.f5162c = i10;
            this.f5163d = i11;
            this.f5166g = j14;
            return this;
        }
    }

    public abstract int getIndexOfPeriod(Object obj);

    public final int getNextPeriodIndex(int i10, b bVar, c cVar, int i11) {
        int i12 = getPeriod(i10, bVar).f5151c;
        if (getWindow(i12, cVar).f5163d != i10) {
            return i10 + 1;
        }
        int nextWindowIndex = getNextWindowIndex(i12, i11);
        if (nextWindowIndex == -1) {
            return -1;
        }
        return getWindow(nextWindowIndex, cVar).f5162c;
    }

    public int getNextWindowIndex(int i10, int i11) {
        if (i11 == 0) {
            if (i10 == getWindowCount() - 1) {
                return -1;
            }
            return i10 + 1;
        }
        if (i11 == 1) {
            return i10;
        }
        if (i11 != 2) {
            throw new IllegalStateException();
        }
        if (i10 == getWindowCount() - 1) {
            return 0;
        }
        return i10 + 1;
    }

    public final b getPeriod(int i10, b bVar) {
        return getPeriod(i10, bVar, false);
    }

    public abstract b getPeriod(int i10, b bVar, boolean z10);

    public abstract int getPeriodCount();

    public final Pair<Integer, Long> getPeriodPosition(c cVar, b bVar, int i10, long j10) {
        return getPeriodPosition(cVar, bVar, i10, j10, 0L);
    }

    public final c getWindow(int i10, c cVar) {
        return getWindow(i10, cVar, false);
    }

    public abstract c getWindow(int i10, c cVar, boolean z10, long j10);

    public abstract int getWindowCount();

    public final boolean isEmpty() {
        return getWindowCount() == 0;
    }

    public final boolean isLastPeriod(int i10, b bVar, c cVar, int i11) {
        return getNextPeriodIndex(i10, bVar, cVar, i11) == -1;
    }

    public final Pair<Integer, Long> getPeriodPosition(c cVar, b bVar, int i10, long j10, long j11) {
        l6.a.checkIndex(i10, 0, getWindowCount());
        getWindow(i10, cVar, false, j11);
        if (j10 == -9223372036854775807L) {
            j10 = cVar.getDefaultPositionUs();
            if (j10 == -9223372036854775807L) {
                return null;
            }
        }
        int i11 = cVar.f5162c;
        long positionInFirstPeriodUs = cVar.getPositionInFirstPeriodUs() + j10;
        long durationUs = getPeriod(i11, bVar).getDurationUs();
        while (durationUs != -9223372036854775807L && positionInFirstPeriodUs >= durationUs && i11 < cVar.f5163d) {
            positionInFirstPeriodUs -= durationUs;
            i11++;
            durationUs = getPeriod(i11, bVar).getDurationUs();
        }
        return Pair.create(Integer.valueOf(i11), Long.valueOf(positionInFirstPeriodUs));
    }

    public c getWindow(int i10, c cVar, boolean z10) {
        return getWindow(i10, cVar, z10, 0L);
    }
}
