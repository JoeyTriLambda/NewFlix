package v5;

import android.util.Log;
import v5.d;

/* compiled from: BaseMediaChunkOutput.java */
/* loaded from: classes.dex */
public final class b implements d.b {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f20464a;

    /* renamed from: b, reason: collision with root package name */
    public final u5.j[] f20465b;

    public b(int[] iArr, u5.j[] jVarArr) {
        this.f20464a = iArr;
        this.f20465b = jVarArr;
    }

    public int[] getWriteIndices() {
        u5.j[] jVarArr = this.f20465b;
        int[] iArr = new int[jVarArr.length];
        for (int i10 = 0; i10 < jVarArr.length; i10++) {
            u5.j jVar = jVarArr[i10];
            if (jVar != null) {
                iArr[i10] = jVar.getWriteIndex();
            }
        }
        return iArr;
    }

    public void setSampleOffsetUs(long j10) {
        for (u5.j jVar : this.f20465b) {
            if (jVar != null) {
                jVar.setSampleOffsetUs(j10);
            }
        }
    }

    public g5.m track(int i10, int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = this.f20464a;
            if (i12 >= iArr.length) {
                Log.e("BaseMediaChunkOutput", "Unmatched track of type: " + i11);
                return new g5.d();
            }
            if (i11 == iArr[i12]) {
                return this.f20465b[i12];
            }
            i12++;
        }
    }
}
