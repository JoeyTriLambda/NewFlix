package j6;

import android.os.SystemClock;
import java.util.Arrays;
import java.util.Comparator;
import u5.n;

/* compiled from: BaseTrackSelection.java */
/* loaded from: classes.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public final n f14634a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14635b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f14636c;

    /* renamed from: d, reason: collision with root package name */
    public final c5.i[] f14637d;

    /* renamed from: e, reason: collision with root package name */
    public final long[] f14638e;

    /* renamed from: f, reason: collision with root package name */
    public int f14639f;

    /* compiled from: BaseTrackSelection.java */
    public static final class a implements Comparator<c5.i> {
        @Override // java.util.Comparator
        public int compare(c5.i iVar, c5.i iVar2) {
            return iVar2.f5116m - iVar.f5116m;
        }
    }

    public b(n nVar, int... iArr) {
        int i10 = 0;
        l6.a.checkState(iArr.length > 0);
        this.f14634a = (n) l6.a.checkNotNull(nVar);
        int length = iArr.length;
        this.f14635b = length;
        this.f14637d = new c5.i[length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f14637d[i11] = nVar.getFormat(iArr[i11]);
        }
        Arrays.sort(this.f14637d, new a());
        this.f14636c = new int[this.f14635b];
        while (true) {
            int i12 = this.f14635b;
            if (i10 >= i12) {
                this.f14638e = new long[i12];
                return;
            } else {
                this.f14636c[i10] = nVar.indexOf(this.f14637d[i10]);
                i10++;
            }
        }
    }

    @Override // j6.f
    public final boolean blacklist(int i10, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsBlacklisted = isBlacklisted(i10, jElapsedRealtime);
        int i11 = 0;
        while (i11 < this.f14635b && !zIsBlacklisted) {
            zIsBlacklisted = (i11 == i10 || isBlacklisted(i11, jElapsedRealtime)) ? false : true;
            i11++;
        }
        if (!zIsBlacklisted) {
            return false;
        }
        long[] jArr = this.f14638e;
        jArr[i10] = Math.max(jArr[i10], jElapsedRealtime + j10);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14634a == bVar.f14634a && Arrays.equals(this.f14636c, bVar.f14636c);
    }

    @Override // j6.f
    public final c5.i getFormat(int i10) {
        return this.f14637d[i10];
    }

    @Override // j6.f
    public final int getIndexInTrackGroup(int i10) {
        return this.f14636c[i10];
    }

    @Override // j6.f
    public final c5.i getSelectedFormat() {
        return this.f14637d[getSelectedIndex()];
    }

    @Override // j6.f
    public final int getSelectedIndexInTrackGroup() {
        return this.f14636c[getSelectedIndex()];
    }

    @Override // j6.f
    public final n getTrackGroup() {
        return this.f14634a;
    }

    public int hashCode() {
        if (this.f14639f == 0) {
            this.f14639f = Arrays.hashCode(this.f14636c) + (System.identityHashCode(this.f14634a) * 31);
        }
        return this.f14639f;
    }

    @Override // j6.f
    public final int indexOf(c5.i iVar) {
        for (int i10 = 0; i10 < this.f14635b; i10++) {
            if (this.f14637d[i10] == iVar) {
                return i10;
            }
        }
        return -1;
    }

    public final boolean isBlacklisted(int i10, long j10) {
        return this.f14638e[i10] > j10;
    }

    @Override // j6.f
    public final int length() {
        return this.f14636c.length;
    }

    @Override // j6.f
    public final int indexOf(int i10) {
        for (int i11 = 0; i11 < this.f14635b; i11++) {
            if (this.f14636c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }
}
