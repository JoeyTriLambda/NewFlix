package x5;

import java.util.List;
import l6.u;

/* compiled from: SegmentBase.java */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final f f21600a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21601b;

    /* renamed from: c, reason: collision with root package name */
    public final long f21602c;

    /* compiled from: SegmentBase.java */
    public static abstract class a extends h {

        /* renamed from: d, reason: collision with root package name */
        public final int f21603d;

        /* renamed from: e, reason: collision with root package name */
        public final long f21604e;

        /* renamed from: f, reason: collision with root package name */
        public final List<d> f21605f;

        public a(f fVar, long j10, long j11, int i10, long j12, List<d> list) {
            super(fVar, j10, j11);
            this.f21603d = i10;
            this.f21604e = j12;
            this.f21605f = list;
        }

        public int getFirstSegmentNum() {
            return this.f21603d;
        }

        public abstract int getSegmentCount(long j10);

        public final long getSegmentDurationUs(int i10, long j10) {
            long j11 = this.f21601b;
            List<d> list = this.f21605f;
            if (list != null) {
                return (list.get(i10 - this.f21603d).f21610b * 1000000) / j11;
            }
            int segmentCount = getSegmentCount(j10);
            return (segmentCount == -1 || i10 != (getFirstSegmentNum() + segmentCount) + (-1)) ? (this.f21604e * 1000000) / j11 : j10 - getSegmentTimeUs(i10);
        }

        public int getSegmentNum(long j10, long j11) {
            int firstSegmentNum = getFirstSegmentNum();
            int segmentCount = getSegmentCount(j11);
            if (segmentCount == 0) {
                return firstSegmentNum;
            }
            if (this.f21605f == null) {
                int i10 = this.f21603d + ((int) (j10 / ((this.f21604e * 1000000) / this.f21601b)));
                return i10 < firstSegmentNum ? firstSegmentNum : segmentCount == -1 ? i10 : Math.min(i10, (firstSegmentNum + segmentCount) - 1);
            }
            int i11 = (segmentCount + firstSegmentNum) - 1;
            int i12 = firstSegmentNum;
            while (i12 <= i11) {
                int i13 = ((i11 - i12) / 2) + i12;
                long segmentTimeUs = getSegmentTimeUs(i13);
                if (segmentTimeUs < j10) {
                    i12 = i13 + 1;
                } else {
                    if (segmentTimeUs <= j10) {
                        return i13;
                    }
                    i11 = i13 - 1;
                }
            }
            return i12 == firstSegmentNum ? i12 : i11;
        }

        public final long getSegmentTimeUs(int i10) {
            int i11 = this.f21603d;
            List<d> list = this.f21605f;
            return u.scaleLargeTimestamp(list != null ? list.get(i10 - i11).f21609a - this.f21602c : (i10 - i11) * this.f21604e, 1000000L, this.f21601b);
        }

        public abstract f getSegmentUrl(g gVar, int i10);

        public boolean isExplicit() {
            return this.f21605f != null;
        }
    }

    /* compiled from: SegmentBase.java */
    public static class b extends a {

        /* renamed from: g, reason: collision with root package name */
        public final List<f> f21606g;

        public b(f fVar, long j10, long j11, int i10, long j12, List<d> list, List<f> list2) {
            super(fVar, j10, j11, i10, j12, list);
            this.f21606g = list2;
        }

        @Override // x5.h.a
        public int getSegmentCount(long j10) {
            return this.f21606g.size();
        }

        @Override // x5.h.a
        public f getSegmentUrl(g gVar, int i10) {
            return this.f21606g.get(i10 - this.f21603d);
        }

        @Override // x5.h.a
        public boolean isExplicit() {
            return true;
        }
    }

    /* compiled from: SegmentBase.java */
    public static class c extends a {

        /* renamed from: g, reason: collision with root package name */
        public final j f21607g;

        /* renamed from: h, reason: collision with root package name */
        public final j f21608h;

        public c(f fVar, long j10, long j11, int i10, long j12, List<d> list, j jVar, j jVar2) {
            super(fVar, j10, j11, i10, j12, list);
            this.f21607g = jVar;
            this.f21608h = jVar2;
        }

        @Override // x5.h
        public f getInitialization(g gVar) {
            j jVar = this.f21607g;
            if (jVar == null) {
                return super.getInitialization(gVar);
            }
            c5.i iVar = gVar.f21591a;
            return new f(jVar.buildUri(iVar.f5115b, 0, iVar.f5116m, 0L), 0L, -1L);
        }

        @Override // x5.h.a
        public int getSegmentCount(long j10) {
            List<d> list = this.f21605f;
            if (list != null) {
                return list.size();
            }
            if (j10 != -9223372036854775807L) {
                return (int) u.ceilDivide(j10, (this.f21604e * 1000000) / this.f21601b);
            }
            return -1;
        }

        @Override // x5.h.a
        public f getSegmentUrl(g gVar, int i10) {
            int i11 = this.f21603d;
            List<d> list = this.f21605f;
            long j10 = list != null ? list.get(i10 - i11).f21609a : (i10 - i11) * this.f21604e;
            j jVar = this.f21608h;
            c5.i iVar = gVar.f21591a;
            return new f(jVar.buildUri(iVar.f5115b, i10, iVar.f5116m, j10), 0L, -1L);
        }
    }

    /* compiled from: SegmentBase.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f21609a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21610b;

        public d(long j10, long j11) {
            this.f21609a = j10;
            this.f21610b = j11;
        }
    }

    public h(f fVar, long j10, long j11) {
        this.f21600a = fVar;
        this.f21601b = j10;
        this.f21602c = j11;
    }

    public f getInitialization(g gVar) {
        return this.f21600a;
    }

    public long getPresentationTimeOffsetUs() {
        return u.scaleLargeTimestamp(this.f21602c, 1000000L, this.f21601b);
    }

    /* compiled from: SegmentBase.java */
    public static class e extends h {

        /* renamed from: d, reason: collision with root package name */
        public final long f21611d;

        /* renamed from: e, reason: collision with root package name */
        public final long f21612e;

        public e(f fVar, long j10, long j11, long j12, long j13) {
            super(fVar, j10, j11);
            this.f21611d = j12;
            this.f21612e = j13;
        }

        public f getIndex() {
            long j10 = this.f21612e;
            if (j10 <= 0) {
                return null;
            }
            return new f(null, this.f21611d, j10);
        }

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
