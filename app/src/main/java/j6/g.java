package j6;

import java.util.Arrays;

/* compiled from: TrackSelectionArray.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f14665a;

    /* renamed from: b, reason: collision with root package name */
    public final f[] f14666b;

    /* renamed from: c, reason: collision with root package name */
    public int f14667c;

    public g(f... fVarArr) {
        this.f14666b = fVarArr;
        this.f14665a = fVarArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f14666b, ((g) obj).f14666b);
    }

    public f get(int i10) {
        return this.f14666b[i10];
    }

    public f[] getAll() {
        return (f[]) this.f14666b.clone();
    }

    public int hashCode() {
        if (this.f14667c == 0) {
            this.f14667c = 527 + Arrays.hashCode(this.f14666b);
        }
        return this.f14667c;
    }
}
