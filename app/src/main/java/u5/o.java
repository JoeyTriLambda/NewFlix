package u5;

import java.util.Arrays;

/* compiled from: TrackGroupArray.java */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: d, reason: collision with root package name */
    public static final o f20110d = new o(new n[0]);

    /* renamed from: a, reason: collision with root package name */
    public final int f20111a;

    /* renamed from: b, reason: collision with root package name */
    public final n[] f20112b;

    /* renamed from: c, reason: collision with root package name */
    public int f20113c;

    public o(n... nVarArr) {
        this.f20112b = nVarArr;
        this.f20111a = nVarArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return this.f20111a == oVar.f20111a && Arrays.equals(this.f20112b, oVar.f20112b);
    }

    public n get(int i10) {
        return this.f20112b[i10];
    }

    public int hashCode() {
        if (this.f20113c == 0) {
            this.f20113c = Arrays.hashCode(this.f20112b);
        }
        return this.f20113c;
    }

    public int indexOf(n nVar) {
        for (int i10 = 0; i10 < this.f20111a; i10++) {
            if (this.f20112b[i10] == nVar) {
                return i10;
            }
        }
        return -1;
    }
}
