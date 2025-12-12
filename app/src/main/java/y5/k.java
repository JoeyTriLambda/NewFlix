package y5;

import android.util.SparseArray;
import l6.r;

/* compiled from: TimestampAdjusterProvider.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<r> f21996a = new SparseArray<>();

    public r getAdjuster(int i10) {
        SparseArray<r> sparseArray = this.f21996a;
        r rVar = sparseArray.get(i10);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(Long.MAX_VALUE);
        sparseArray.put(i10, rVar2);
        return rVar2;
    }

    public void reset() {
        this.f21996a.clear();
    }
}
