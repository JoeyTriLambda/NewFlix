package o0;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f16883e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f16884a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16885b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16886c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16887d;

    /* compiled from: Insets.java */
    public static class a {
        public static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    public b(int i10, int i11, int i12, int i13) {
        this.f16884a = i10;
        this.f16885b = i11;
        this.f16886c = i12;
        this.f16887d = i13;
    }

    public static b max(b bVar, b bVar2) {
        return of(Math.max(bVar.f16884a, bVar2.f16884a), Math.max(bVar.f16885b, bVar2.f16885b), Math.max(bVar.f16886c, bVar2.f16886c), Math.max(bVar.f16887d, bVar2.f16887d));
    }

    public static b of(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f16883e : new b(i10, i11, i12, i13);
    }

    public static b toCompatInsets(Insets insets) {
        return of(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16887d == bVar.f16887d && this.f16884a == bVar.f16884a && this.f16886c == bVar.f16886c && this.f16885b == bVar.f16885b;
    }

    public int hashCode() {
        return (((((this.f16884a * 31) + this.f16885b) * 31) + this.f16886c) * 31) + this.f16887d;
    }

    public Insets toPlatformInsets() {
        return a.a(this.f16884a, this.f16885b, this.f16886c, this.f16887d);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Insets{left=");
        sb2.append(this.f16884a);
        sb2.append(", top=");
        sb2.append(this.f16885b);
        sb2.append(", right=");
        sb2.append(this.f16886c);
        sb2.append(", bottom=");
        return ac.c.l(sb2, this.f16887d, '}');
    }

    public static b of(Rect rect) {
        return of(rect.left, rect.top, rect.right, rect.bottom);
    }
}
