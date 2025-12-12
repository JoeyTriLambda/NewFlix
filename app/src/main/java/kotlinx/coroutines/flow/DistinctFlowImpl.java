package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$ObjectRef;
import lf.h;
import ng.a;
import ng.b;
import og.j;
import qf.c;
import yf.l;
import yf.p;

/* compiled from: Distinct.kt */
/* loaded from: classes2.dex */
public final class DistinctFlowImpl<T> implements a<T> {

    /* renamed from: b, reason: collision with root package name */
    public final a<T> f15378b;

    /* renamed from: m, reason: collision with root package name */
    public final l<T, Object> f15379m;

    /* renamed from: n, reason: collision with root package name */
    public final p<Object, Object, Boolean> f15380n;

    /* compiled from: Distinct.kt */
    /* renamed from: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements b {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DistinctFlowImpl<T> f15381b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<Object> f15382m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ b<T> f15383n;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(DistinctFlowImpl<T> distinctFlowImpl, Ref$ObjectRef<Object> ref$ObjectRef, b<? super T> bVar) {
            this.f15381b = distinctFlowImpl;
            this.f15382m = ref$ObjectRef;
            this.f15383n = bVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // ng.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(T r8, qf.c<? super lf.h> r9) throws java.lang.Throwable {
            /*
                r7 = this;
                boolean r0 = r9 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                if (r0 == 0) goto L13
                r0 = r9
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
                int r1 = r0.f15386n
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15386n = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
                r0.<init>(r7, r9)
            L18:
                java.lang.Object r9 = r0.f15384b
                java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.f15386n
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                lf.f.throwOnFailure(r9)
                goto L63
            L29:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L31:
                lf.f.throwOnFailure(r9)
                kotlinx.coroutines.flow.DistinctFlowImpl<T> r9 = r7.f15381b
                yf.l<T, java.lang.Object> r2 = r9.f15379m
                java.lang.Object r2 = r2.invoke(r8)
                kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r4 = r7.f15382m
                T r5 = r4.f15262b
                pg.b0 r6 = og.j.f17095a
                if (r5 == r6) goto L56
                yf.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r9 = r9.f15380n
                java.lang.Object r9 = r9.invoke(r5, r2)
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 != 0) goto L53
                goto L56
            L53:
                lf.h r8 = lf.h.f16056a
                return r8
            L56:
                r4.f15262b = r2
                r0.f15386n = r3
                ng.b<T> r9 = r7.f15383n
                java.lang.Object r8 = r9.emit(r8, r0)
                if (r8 != r1) goto L63
                return r1
            L63:
                lf.h r8 = lf.h.f16056a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(a<? extends T> aVar, l<? super T, ? extends Object> lVar, p<Object, Object, Boolean> pVar) {
        this.f15378b = aVar;
        this.f15379m = lVar;
        this.f15380n = pVar;
    }

    @Override // ng.a
    public Object collect(b<? super T> bVar, c<? super h> cVar) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.f15262b = (T) j.f17095a;
        Object objCollect = this.f15378b.collect(new AnonymousClass2(this, ref$ObjectRef, bVar), cVar);
        return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
    }
}
