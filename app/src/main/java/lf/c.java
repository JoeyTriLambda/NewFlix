package lf;

import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes2.dex */
public final class c implements Comparable<c> {

    /* renamed from: p, reason: collision with root package name */
    public static final c f16051p;

    /* renamed from: b, reason: collision with root package name */
    public final int f16052b;

    /* renamed from: m, reason: collision with root package name */
    public final int f16053m;

    /* renamed from: n, reason: collision with root package name */
    public final int f16054n;

    /* renamed from: o, reason: collision with root package name */
    public final int f16055o;

    /* compiled from: KotlinVersion.kt */
    public static final class a {
        public a(zf.f fVar) {
        }
    }

    static {
        new a(null);
        f16051p = d.get();
    }

    public c(int i10, int i11, int i12) {
        this.f16052b = i10;
        this.f16053m = i11;
        this.f16054n = i12;
        boolean z10 = false;
        if (new fg.c(0, 255).contains(i10) && new fg.c(0, 255).contains(i11) && new fg.c(0, 255).contains(i12)) {
            z10 = true;
        }
        if (z10) {
            this.f16055o = (i10 << 16) + (i11 << 8) + i12;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i11 + ClassUtils.PACKAGE_SEPARATOR_CHAR + i12).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        c cVar = obj instanceof c ? (c) obj : null;
        return cVar != null && this.f16055o == cVar.f16055o;
    }

    public int hashCode() {
        return this.f16055o;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f16052b);
        sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb2.append(this.f16053m);
        sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        sb2.append(this.f16054n);
        return sb2.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(c cVar) {
        i.checkNotNullParameter(cVar, "other");
        return this.f16055o - cVar.f16055o;
    }
}
