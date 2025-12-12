package kotlinx.coroutines.flow;

import java.util.Arrays;
import kg.k1;
import kg.m;
import kg.o;
import kg.u0;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.BufferOverflow;
import lf.h;
import ng.b;
import ng.f;
import ng.j;
import pg.b0;
import qf.c;
import sf.d;
import zf.i;

/* compiled from: SharedFlow.kt */
/* loaded from: classes2.dex */
public class SharedFlowImpl<T> extends og.a<j> implements f<T>, ng.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f15453o;

    /* renamed from: p, reason: collision with root package name */
    public final int f15454p;

    /* renamed from: q, reason: collision with root package name */
    public final BufferOverflow f15455q;

    /* renamed from: r, reason: collision with root package name */
    public Object[] f15456r;

    /* renamed from: s, reason: collision with root package name */
    public long f15457s;

    /* renamed from: t, reason: collision with root package name */
    public long f15458t;

    /* renamed from: u, reason: collision with root package name */
    public int f15459u;

    /* renamed from: v, reason: collision with root package name */
    public int f15460v;

    /* compiled from: SharedFlow.kt */
    public static final class a implements u0 {

        /* renamed from: b, reason: collision with root package name */
        public final SharedFlowImpl<?> f15461b;

        /* renamed from: m, reason: collision with root package name */
        public final long f15462m;

        /* renamed from: n, reason: collision with root package name */
        public final Object f15463n;

        /* renamed from: o, reason: collision with root package name */
        public final c<h> f15464o;

        /* JADX WARN: Multi-variable type inference failed */
        public a(SharedFlowImpl<?> sharedFlowImpl, long j10, Object obj, c<? super h> cVar) {
            this.f15461b = sharedFlowImpl;
            this.f15462m = j10;
            this.f15463n = obj;
            this.f15464o = cVar;
        }

        @Override // kg.u0
        public void dispose() {
            SharedFlowImpl.access$cancelEmitter(this.f15461b, this);
        }
    }

    /* compiled from: SharedFlow.kt */
    @d(c = "kotlinx.coroutines.flow.SharedFlowImpl", f = "SharedFlow.kt", l = {372, 379, 382}, m = "collect$suspendImpl")
    /* renamed from: kotlinx.coroutines.flow.SharedFlowImpl$collect$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: b, reason: collision with root package name */
        public SharedFlowImpl f15465b;

        /* renamed from: m, reason: collision with root package name */
        public b f15466m;

        /* renamed from: n, reason: collision with root package name */
        public j f15467n;

        /* renamed from: o, reason: collision with root package name */
        public k1 f15468o;

        /* renamed from: p, reason: collision with root package name */
        public /* synthetic */ Object f15469p;

        /* renamed from: q, reason: collision with root package name */
        public final /* synthetic */ SharedFlowImpl<T> f15470q;

        /* renamed from: r, reason: collision with root package name */
        public int f15471r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SharedFlowImpl<T> sharedFlowImpl, c<? super AnonymousClass1> cVar) {
            super(cVar);
            this.f15470q = sharedFlowImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f15469p = obj;
            this.f15471r |= Integer.MIN_VALUE;
            return SharedFlowImpl.c(this.f15470q, null, this);
        }
    }

    public SharedFlowImpl(int i10, int i11, BufferOverflow bufferOverflow) {
        this.f15453o = i10;
        this.f15454p = i11;
        this.f15455q = bufferOverflow;
    }

    public static final void access$cancelEmitter(SharedFlowImpl sharedFlowImpl, a aVar) {
        synchronized (sharedFlowImpl) {
            if (aVar.f15462m < sharedFlowImpl.g()) {
                return;
            }
            Object[] objArr = sharedFlowImpl.f15456r;
            i.checkNotNull(objArr);
            if (ng.i.access$getBufferAt(objArr, aVar.f15462m) != aVar) {
                return;
            }
            ng.i.access$setBufferAt(objArr, aVar.f15462m, ng.i.f16828a);
            sharedFlowImpl.b();
            h hVar = h.f16056a;
        }
    }

    public static final int access$getTotalSize(SharedFlowImpl sharedFlowImpl) {
        return sharedFlowImpl.f15459u + sharedFlowImpl.f15460v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0093 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [ng.b] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r5v7, types: [kotlinx.coroutines.flow.SharedFlowImpl] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ <T> java.lang.Object c(kotlinx.coroutines.flow.SharedFlowImpl<T> r8, ng.b<? super T> r9, qf.c<?> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 194
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.c(kotlinx.coroutines.flow.SharedFlowImpl, ng.b, qf.c):java.lang.Object");
    }

    public final Object a(j jVar, c<? super h> cVar) {
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        synchronized (this) {
            if (j(jVar) < 0) {
                jVar.f16830b = mVar;
            } else {
                int i10 = Result.f15189m;
                mVar.resumeWith(Result.m59constructorimpl(h.f16056a));
            }
            h hVar = h.f16056a;
        }
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
    }

    public final void b() {
        if (this.f15454p != 0 || this.f15460v > 1) {
            Object[] objArr = this.f15456r;
            i.checkNotNull(objArr);
            while (this.f15460v > 0 && ng.i.access$getBufferAt(objArr, (g() + (this.f15459u + this.f15460v)) - 1) == ng.i.f16828a) {
                this.f15460v--;
                ng.i.access$setBufferAt(objArr, g() + this.f15459u + this.f15460v, null);
            }
        }
    }

    @Override // ng.a
    public Object collect(b<? super T> bVar, c<?> cVar) {
        return c(this, bVar, cVar);
    }

    public final void d() {
        og.b[] bVarArr;
        Object[] objArr = this.f15456r;
        i.checkNotNull(objArr);
        ng.i.access$setBufferAt(objArr, g(), null);
        this.f15459u--;
        long jG = g() + 1;
        if (this.f15457s < jG) {
            this.f15457s = jG;
        }
        if (this.f15458t < jG) {
            if (this.f17088m != 0 && (bVarArr = this.f17087b) != null) {
                for (og.b bVar : bVarArr) {
                    if (bVar != null) {
                        j jVar = (j) bVar;
                        long j10 = jVar.f16829a;
                        if (j10 >= 0 && j10 < jG) {
                            jVar.f16829a = jG;
                        }
                    }
                }
            }
            this.f15458t = jG;
        }
    }

    public final void e(Object obj) {
        int i10 = this.f15459u + this.f15460v;
        Object[] objArrH = this.f15456r;
        if (objArrH == null) {
            objArrH = h(0, 2, null);
        } else if (i10 >= objArrH.length) {
            objArrH = h(i10, objArrH.length * 2, objArrH);
        }
        ng.i.access$setBufferAt(objArrH, g() + i10, obj);
    }

    @Override // ng.f, ng.b
    public Object emit(T t10, c<? super h> cVar) {
        c[] cVarArrF;
        a aVar;
        if (tryEmit(t10)) {
            return h.f16056a;
        }
        m mVar = new m(IntrinsicsKt__IntrinsicsJvmKt.intercepted(cVar), 1);
        mVar.initCancellability();
        c[] cVarArrF2 = c8.i.f5255f;
        synchronized (this) {
            if (i(t10)) {
                int i10 = Result.f15189m;
                mVar.resumeWith(Result.m59constructorimpl(h.f16056a));
                cVarArrF = f(cVarArrF2);
                aVar = null;
            } else {
                a aVar2 = new a(this, access$getTotalSize(this) + g(), t10, mVar);
                e(aVar2);
                this.f15460v++;
                if (this.f15454p == 0) {
                    cVarArrF2 = f(cVarArrF2);
                }
                cVarArrF = cVarArrF2;
                aVar = aVar2;
            }
        }
        if (aVar != null) {
            o.disposeOnCancellation(mVar, aVar);
        }
        for (c cVar2 : cVarArrF) {
            if (cVar2 != null) {
                int i11 = Result.f15189m;
                cVar2.resumeWith(Result.m59constructorimpl(h.f16056a));
            }
        }
        Object result = mVar.getResult();
        if (result == rf.a.getCOROUTINE_SUSPENDED()) {
            sf.f.probeCoroutineSuspended(cVar);
        }
        if (result != rf.a.getCOROUTINE_SUSPENDED()) {
            result = h.f16056a;
        }
        return result == rf.a.getCOROUTINE_SUSPENDED() ? result : h.f16056a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.Object, java.lang.Object[]] */
    public final c<h>[] f(c<h>[] cVarArr) {
        og.b[] bVarArr;
        j jVar;
        m mVar;
        int length = cVarArr.length;
        if (this.f17088m != 0 && (bVarArr = this.f17087b) != null) {
            int length2 = bVarArr.length;
            int i10 = 0;
            cVarArr = cVarArr;
            while (i10 < length2) {
                og.b bVar = bVarArr[i10];
                if (bVar != null && (mVar = (jVar = (j) bVar).f16830b) != null && j(jVar) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        ?? CopyOf = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                        i.checkNotNullExpressionValue(CopyOf, "copyOf(this, newSize)");
                        cVarArr = CopyOf;
                    }
                    cVarArr[length] = mVar;
                    jVar.f16830b = null;
                    length++;
                }
                i10++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    public final long g() {
        return Math.min(this.f15458t, this.f15457s);
    }

    public final Object[] h(int i10, int i11, Object[] objArr) {
        if (!(i11 > 0)) {
            throw new IllegalStateException("Buffer size overflow".toString());
        }
        Object[] objArr2 = new Object[i11];
        this.f15456r = objArr2;
        if (objArr == null) {
            return objArr2;
        }
        long jG = g();
        for (int i12 = 0; i12 < i10; i12++) {
            long j10 = i12 + jG;
            ng.i.access$setBufferAt(objArr2, j10, ng.i.access$getBufferAt(objArr, j10));
        }
        return objArr2;
    }

    public final boolean i(T t10) {
        int nCollectors = getNCollectors();
        int i10 = this.f15453o;
        if (nCollectors == 0) {
            if (i10 != 0) {
                e(t10);
                int i11 = this.f15459u + 1;
                this.f15459u = i11;
                if (i11 > i10) {
                    d();
                }
                this.f15458t = g() + this.f15459u;
            }
            return true;
        }
        int i12 = this.f15459u;
        int i13 = this.f15454p;
        if (i12 >= i13 && this.f15458t <= this.f15457s) {
            int iOrdinal = this.f15455q.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal == 2) {
                return true;
            }
        }
        e(t10);
        int i14 = this.f15459u + 1;
        this.f15459u = i14;
        if (i14 > i13) {
            d();
        }
        long jG = g() + this.f15459u;
        long j10 = this.f15457s;
        if (((int) (jG - j10)) > i10) {
            l(j10 + 1, this.f15458t, g() + this.f15459u, g() + this.f15459u + this.f15460v);
        }
        return true;
    }

    public final long j(j jVar) {
        long j10 = jVar.f16829a;
        if (j10 < g() + this.f15459u) {
            return j10;
        }
        if (this.f15454p <= 0 && j10 <= g() && this.f15460v != 0) {
            return j10;
        }
        return -1L;
    }

    public final Object k(j jVar) {
        Object obj;
        c<h>[] cVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = c8.i.f5255f;
        synchronized (this) {
            long j10 = j(jVar);
            if (j10 < 0) {
                obj = ng.i.f16828a;
            } else {
                long j11 = jVar.f16829a;
                Object[] objArr = this.f15456r;
                i.checkNotNull(objArr);
                Object objAccess$getBufferAt = ng.i.access$getBufferAt(objArr, j10);
                if (objAccess$getBufferAt instanceof a) {
                    objAccess$getBufferAt = ((a) objAccess$getBufferAt).f15463n;
                }
                jVar.f16829a = j10 + 1;
                Object obj2 = objAccess$getBufferAt;
                cVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core = updateCollectorIndexLocked$kotlinx_coroutines_core(j11);
                obj = obj2;
            }
        }
        for (c<h> cVar : cVarArrUpdateCollectorIndexLocked$kotlinx_coroutines_core) {
            if (cVar != null) {
                int i10 = Result.f15189m;
                cVar.resumeWith(Result.m59constructorimpl(h.f16056a));
            }
        }
        return obj;
    }

    public final void l(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jG = g(); jG < jMin; jG++) {
            Object[] objArr = this.f15456r;
            i.checkNotNull(objArr);
            ng.i.access$setBufferAt(objArr, jG, null);
        }
        this.f15457s = j10;
        this.f15458t = j11;
        this.f15459u = (int) (j12 - jMin);
        this.f15460v = (int) (j13 - j12);
    }

    public boolean tryEmit(T t10) {
        int i10;
        boolean z10;
        c<h>[] cVarArrF = c8.i.f5255f;
        synchronized (this) {
            if (i(t10)) {
                cVarArrF = f(cVarArrF);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (c<h> cVar : cVarArrF) {
            if (cVar != null) {
                int i11 = Result.f15189m;
                cVar.resumeWith(Result.m59constructorimpl(h.f16056a));
            }
        }
        return z10;
    }

    public final c<h>[] updateCollectorIndexLocked$kotlinx_coroutines_core(long j10) {
        long j11;
        long j12;
        long j13;
        og.b[] bVarArr;
        long j14 = this.f15458t;
        c<h>[] cVarArr = c8.i.f5255f;
        if (j10 > j14) {
            return cVarArr;
        }
        long jG = g();
        long j15 = this.f15459u + jG;
        int i10 = this.f15454p;
        if (i10 == 0 && this.f15460v > 0) {
            j15++;
        }
        if (this.f17088m != 0 && (bVarArr = this.f17087b) != null) {
            for (og.b bVar : bVarArr) {
                if (bVar != null) {
                    long j16 = ((j) bVar).f16829a;
                    if (j16 >= 0 && j16 < j15) {
                        j15 = j16;
                    }
                }
            }
        }
        if (j15 <= this.f15458t) {
            return cVarArr;
        }
        long jG2 = g() + this.f15459u;
        int iMin = getNCollectors() > 0 ? Math.min(this.f15460v, i10 - ((int) (jG2 - j15))) : this.f15460v;
        long j17 = this.f15460v + jG2;
        if (iMin > 0) {
            cVarArr = new c[iMin];
            Object[] objArr = this.f15456r;
            i.checkNotNull(objArr);
            long j18 = jG2;
            int i11 = 0;
            while (true) {
                if (jG2 >= j17) {
                    j11 = j15;
                    j12 = j17;
                    break;
                }
                Object objAccess$getBufferAt = ng.i.access$getBufferAt(objArr, jG2);
                j11 = j15;
                b0 b0Var = ng.i.f16828a;
                if (objAccess$getBufferAt != b0Var) {
                    i.checkNotNull(objAccess$getBufferAt, "null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                    a aVar = (a) objAccess$getBufferAt;
                    int i12 = i11 + 1;
                    j12 = j17;
                    cVarArr[i11] = aVar.f15464o;
                    ng.i.access$setBufferAt(objArr, jG2, b0Var);
                    ng.i.access$setBufferAt(objArr, j18, aVar.f15463n);
                    j13 = 1;
                    j18++;
                    if (i12 >= iMin) {
                        break;
                    }
                    i11 = i12;
                } else {
                    j12 = j17;
                    j13 = 1;
                }
                jG2 += j13;
                j15 = j11;
                j17 = j12;
            }
            jG2 = j18;
        } else {
            j11 = j15;
            j12 = j17;
        }
        c<h>[] cVarArr2 = cVarArr;
        int i13 = (int) (jG2 - jG);
        long j19 = getNCollectors() == 0 ? jG2 : j11;
        long jMax = Math.max(this.f15457s, jG2 - Math.min(this.f15453o, i13));
        if (i10 == 0 && jMax < j12) {
            Object[] objArr2 = this.f15456r;
            i.checkNotNull(objArr2);
            if (i.areEqual(ng.i.access$getBufferAt(objArr2, jMax), ng.i.f16828a)) {
                jG2++;
                jMax++;
            }
        }
        l(jMax, j19, jG2, j12);
        b();
        return (cVarArr2.length == 0) ^ true ? f(cVarArr2) : cVarArr2;
    }

    public final long updateNewCollectorIndexLocked$kotlinx_coroutines_core() {
        long j10 = this.f15457s;
        if (j10 < this.f15458t) {
            this.f15458t = j10;
        }
        return j10;
    }

    @Override // og.a
    public j createSlot() {
        return new j();
    }

    @Override // og.a
    public j[] createSlotArray(int i10) {
        return new j[i10];
    }
}
