package u5;

import java.util.Arrays;

/* compiled from: TrackGroup.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final int f20107a;

    /* renamed from: b, reason: collision with root package name */
    public final c5.i[] f20108b;

    /* renamed from: c, reason: collision with root package name */
    public int f20109c;

    public n(c5.i... iVarArr) {
        l6.a.checkState(iVarArr.length > 0);
        this.f20108b = iVarArr;
        this.f20107a = iVarArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        return this.f20107a == nVar.f20107a && Arrays.equals(this.f20108b, nVar.f20108b);
    }

    public c5.i getFormat(int i10) {
        return this.f20108b[i10];
    }

    public int hashCode() {
        if (this.f20109c == 0) {
            this.f20109c = 527 + Arrays.hashCode(this.f20108b);
        }
        return this.f20109c;
    }

    public int indexOf(c5.i iVar) {
        int i10 = 0;
        while (true) {
            c5.i[] iVarArr = this.f20108b;
            if (i10 >= iVarArr.length) {
                return -1;
            }
            if (iVar == iVarArr[i10]) {
                return i10;
            }
            i10++;
        }
    }
}
