package e6;

import b6.d;
import java.util.Collections;
import java.util.List;
import l6.u;

/* compiled from: SsaSubtitle.java */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: b, reason: collision with root package name */
    public final b6.a[] f11165b;

    /* renamed from: m, reason: collision with root package name */
    public final long[] f11166m;

    public b(b6.a[] aVarArr, long[] jArr) {
        this.f11165b = aVarArr;
        this.f11166m = jArr;
    }

    @Override // b6.d
    public List<b6.a> getCues(long j10) {
        b6.a aVar;
        int iBinarySearchFloor = u.binarySearchFloor(this.f11166m, j10, true, false);
        return (iBinarySearchFloor == -1 || (aVar = this.f11165b[iBinarySearchFloor]) == null) ? Collections.emptyList() : Collections.singletonList(aVar);
    }

    @Override // b6.d
    public long getEventTime(int i10) {
        l6.a.checkArgument(i10 >= 0);
        long[] jArr = this.f11166m;
        l6.a.checkArgument(i10 < jArr.length);
        return jArr[i10];
    }

    @Override // b6.d
    public int getEventTimeCount() {
        return this.f11166m.length;
    }

    @Override // b6.d
    public int getNextEventTimeIndex(long j10) {
        long[] jArr = this.f11166m;
        int iBinarySearchCeil = u.binarySearchCeil(jArr, j10, false, false);
        if (iBinarySearchCeil < jArr.length) {
            return iBinarySearchCeil;
        }
        return -1;
    }
}
