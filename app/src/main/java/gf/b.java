package gf;

import java.util.concurrent.TimeUnit;

/* compiled from: Timed.java */
/* loaded from: classes2.dex */
public final class b<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T f12830a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12831b;

    /* renamed from: c, reason: collision with root package name */
    public final TimeUnit f12832c;

    public b(T t10, long j10, TimeUnit timeUnit) {
        this.f12830a = t10;
        this.f12831b = j10;
        this.f12832c = (TimeUnit) ue.a.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return ue.a.equals(this.f12830a, bVar.f12830a) && this.f12831b == bVar.f12831b && ue.a.equals(this.f12832c, bVar.f12832c);
    }

    public int hashCode() {
        T t10 = this.f12830a;
        int iHashCode = t10 != null ? t10.hashCode() : 0;
        long j10 = this.f12831b;
        return this.f12832c.hashCode() + (((iHashCode * 31) + ((int) (j10 ^ (j10 >>> 31)))) * 31);
    }

    public long time() {
        return this.f12831b;
    }

    public String toString() {
        return "Timed[time=" + this.f12831b + ", unit=" + this.f12832c + ", value=" + this.f12830a + "]";
    }

    public T value() {
        return this.f12830a;
    }
}
