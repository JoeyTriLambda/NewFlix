package u5;

import java.io.IOException;

/* compiled from: MediaSource.java */
/* loaded from: classes.dex */
public interface h {

    /* compiled from: MediaSource.java */
    public interface a {
    }

    /* compiled from: MediaSource.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f20054a;

        /* renamed from: b, reason: collision with root package name */
        public final int f20055b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20056c;

        static {
            new b(-1, -1, -1);
        }

        public b(int i10) {
            this(i10, -1, -1);
        }

        public b copyWithPeriodIndex(int i10) {
            return this.f20054a == i10 ? this : new b(i10, this.f20055b, this.f20056c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f20054a == bVar.f20054a && this.f20055b == bVar.f20055b && this.f20056c == bVar.f20056c;
        }

        public int hashCode() {
            return ((((527 + this.f20054a) * 31) + this.f20055b) * 31) + this.f20056c;
        }

        public boolean isAd() {
            return this.f20055b != -1;
        }

        public b(int i10, int i11, int i12) {
            this.f20054a = i10;
            this.f20055b = i11;
            this.f20056c = i12;
        }
    }

    g createPeriod(b bVar, k6.b bVar2);

    void maybeThrowSourceInfoRefreshError() throws IOException;

    void prepareSource(c5.d dVar, boolean z10, a aVar);

    void releasePeriod(g gVar);

    void releaseSource();
}
