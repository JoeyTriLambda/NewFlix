package kotlinx.coroutines.flow;

import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$IntRef;
import lf.h;
import qf.c;
import yf.p;

/* compiled from: Limit.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__LimitKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    public static final class a<T> implements ng.a<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ng.a f15409b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ int f15410m;

        public a(ng.a aVar, int i10) {
            this.f15409b = aVar;
            this.f15410m = i10;
        }

        @Override // ng.a
        public Object collect(ng.b<? super T> bVar, c<? super h> cVar) {
            Object objCollect = this.f15409b.collect(new FlowKt__LimitKt$drop$2$1(new Ref$IntRef(), this.f15410m, bVar), cVar);
            return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    public static final class b<T> implements ng.a<T> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ng.a f15411b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ p f15412m;

        public b(ng.a aVar, p pVar) {
            this.f15411b = aVar;
            this.f15412m = pVar;
        }

        @Override // ng.a
        public Object collect(ng.b<? super T> bVar, c<? super h> cVar) {
            Object objCollect = this.f15411b.collect(new FlowKt__LimitKt$dropWhile$1$1(new Ref$BooleanRef(), bVar, this.f15412m), cVar);
            return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : h.f16056a;
        }
    }

    public static final <T> ng.a<T> drop(ng.a<? extends T> aVar, int i10) {
        if (i10 >= 0) {
            return new a(aVar, i10);
        }
        throw new IllegalArgumentException(ac.c.f("Drop count should be non-negative, but had ", i10).toString());
    }

    public static final <T> ng.a<T> dropWhile(ng.a<? extends T> aVar, p<? super T, ? super c<? super Boolean>, ? extends Object> pVar) {
        return new b(aVar, pVar);
    }
}
