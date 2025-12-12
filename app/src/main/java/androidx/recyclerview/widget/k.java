package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* compiled from: GapWorker.java */
/* loaded from: classes.dex */
public final class k implements Runnable {

    /* renamed from: p, reason: collision with root package name */
    public static final ThreadLocal<k> f4203p = new ThreadLocal<>();

    /* renamed from: q, reason: collision with root package name */
    public static final a f4204q = new a();

    /* renamed from: m, reason: collision with root package name */
    public long f4206m;

    /* renamed from: n, reason: collision with root package name */
    public long f4207n;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList<RecyclerView> f4205b = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList<c> f4208o = new ArrayList<>();

    /* compiled from: GapWorker.java */
    public class a implements Comparator<c> {
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f4216d;
            if ((recyclerView == null) != (cVar2.f4216d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f4213a;
            if (z10 != cVar2.f4213a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f4214b - cVar.f4214b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f4215c - cVar2.f4215c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    /* compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.l.c {

        /* renamed from: a, reason: collision with root package name */
        public int f4209a;

        /* renamed from: b, reason: collision with root package name */
        public int f4210b;

        /* renamed from: c, reason: collision with root package name */
        public int[] f4211c;

        /* renamed from: d, reason: collision with root package name */
        public int f4212d;

        public final void a(RecyclerView recyclerView, boolean z10) {
            this.f4212d = 0;
            int[] iArr = this.f4211c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.l lVar = recyclerView.f3938x;
            if (recyclerView.f3936w == null || lVar == null || !lVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z10) {
                if (!recyclerView.f3920o.g()) {
                    lVar.collectInitialPrefetchPositions(recyclerView.f3936w.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                lVar.collectAdjacentPrefetchPositions(this.f4209a, this.f4210b, recyclerView.f3927r0, this);
            }
            int i10 = this.f4212d;
            if (i10 > lVar.f3970j) {
                lVar.f3970j = i10;
                lVar.f3971k = z10;
                recyclerView.f3916m.i();
            }
        }

        public void addPosition(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f4212d * 2;
            int[] iArr = this.f4211c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f4211c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i12 >= iArr.length) {
                int[] iArr3 = new int[i12 * 2];
                this.f4211c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f4211c;
            iArr4[i12] = i10;
            iArr4[i12 + 1] = i11;
            this.f4212d++;
        }
    }

    /* compiled from: GapWorker.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f4213a;

        /* renamed from: b, reason: collision with root package name */
        public int f4214b;

        /* renamed from: c, reason: collision with root package name */
        public int f4215c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f4216d;

        /* renamed from: e, reason: collision with root package name */
        public int f4217e;

        public void clear() {
            this.f4213a = false;
            this.f4214b = 0;
            this.f4215c = 0;
            this.f4216d = null;
            this.f4217e = 0;
        }
    }

    public static RecyclerView.z c(RecyclerView recyclerView, int i10, long j10) {
        boolean z10;
        int iG = recyclerView.f3922p.g();
        int i11 = 0;
        while (true) {
            if (i11 >= iG) {
                z10 = false;
                break;
            }
            RecyclerView.z zVarC = RecyclerView.C(recyclerView.f3922p.f(i11));
            if (zVarC.f4043c == i10 && !zVarC.f()) {
                z10 = true;
                break;
            }
            i11++;
        }
        if (z10) {
            return null;
        }
        RecyclerView.r rVar = recyclerView.f3916m;
        try {
            recyclerView.I();
            RecyclerView.z zVarG = rVar.g(j10, i10);
            if (zVarG != null) {
                if (!zVarG.e() || zVarG.f()) {
                    rVar.a(zVarG, false);
                } else {
                    rVar.recycleView(zVarG.f4041a);
                }
            }
            return zVarG;
        } finally {
            recyclerView.J(false);
        }
    }

    public final void a(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f4206m == 0) {
            this.f4206m = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.f3925q0;
        bVar.f4209a = i10;
        bVar.f4210b = i11;
    }

    public void add(RecyclerView recyclerView) {
        this.f4205b.add(recyclerView);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x012e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(long r17) {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.b(long):void");
    }

    public void remove(RecyclerView recyclerView) {
        this.f4205b.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            t0.m.beginSection("RV Prefetch");
            ArrayList<RecyclerView> arrayList = this.f4205b;
            if (!arrayList.isEmpty()) {
                int size = arrayList.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = arrayList.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f4207n);
                }
            }
        } finally {
            this.f4206m = 0L;
            t0.m.endSection();
        }
    }
}
