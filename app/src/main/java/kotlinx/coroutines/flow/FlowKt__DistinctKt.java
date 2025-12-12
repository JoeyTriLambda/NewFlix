package kotlinx.coroutines.flow;

import ng.a;
import ng.k;
import yf.l;
import yf.p;
import zf.i;

/* compiled from: Distinct.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__DistinctKt {

    /* renamed from: a, reason: collision with root package name */
    public static final l<Object, Object> f15389a = new l<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // yf.l
        public final Object invoke(Object obj) {
            return obj;
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public static final p<Object, Object, Boolean> f15390b = new p<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // yf.p
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(i.areEqual(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> distinctUntilChanged(a<? extends T> aVar) {
        if (aVar instanceof k) {
            return aVar;
        }
        l<Object, Object> lVar = f15389a;
        p<Object, Object, Boolean> pVar = f15390b;
        if (aVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) aVar;
            if (distinctFlowImpl.f15379m == lVar && distinctFlowImpl.f15380n == pVar) {
                return aVar;
            }
        }
        return new DistinctFlowImpl(aVar, lVar, pVar);
    }
}
