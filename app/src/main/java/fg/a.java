package fg;

import java.util.Iterator;

/* compiled from: Progressions.kt */
/* loaded from: classes2.dex */
public class a implements Iterable<Integer>, ag.a {

    /* renamed from: o, reason: collision with root package name */
    public static final C0139a f11544o = new C0139a(null);

    /* renamed from: b, reason: collision with root package name */
    public final int f11545b;

    /* renamed from: m, reason: collision with root package name */
    public final int f11546m;

    /* renamed from: n, reason: collision with root package name */
    public final int f11547n;

    /* compiled from: Progressions.kt */
    /* renamed from: fg.a$a, reason: collision with other inner class name */
    public static final class C0139a {
        public C0139a(zf.f fVar) {
        }

        public final a fromClosedRange(int i10, int i11, int i12) {
            return new a(i10, i11, i12);
        }
    }

    public a(int i10, int i11, int i12) {
        if (i12 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i12 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f11545b = i10;
        this.f11546m = tf.c.getProgressionLastElement(i10, i11, i12);
        this.f11547n = i12;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f11545b != aVar.f11545b || this.f11546m != aVar.f11546m || this.f11547n != aVar.f11547n) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f11545b;
    }

    public final int getLast() {
        return this.f11546m;
    }

    public final int getStep() {
        return this.f11547n;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f11545b * 31) + this.f11546m) * 31) + this.f11547n;
    }

    public boolean isEmpty() {
        int i10 = this.f11547n;
        int i11 = this.f11546m;
        int i12 = this.f11545b;
        if (i10 > 0) {
            if (i12 > i11) {
                return true;
            }
        } else if (i12 < i11) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2;
        int i10 = this.f11546m;
        int i11 = this.f11545b;
        int i12 = this.f11547n;
        if (i12 > 0) {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append("..");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(i12);
        } else {
            sb2 = new StringBuilder();
            sb2.append(i11);
            sb2.append(" downTo ");
            sb2.append(i10);
            sb2.append(" step ");
            sb2.append(-i12);
        }
        return sb2.toString();
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new b(this.f11545b, this.f11546m, this.f11547n);
    }
}
