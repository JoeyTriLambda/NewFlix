package kotlinx.coroutines.flow.internal;

import kotlin.jvm.internal.FunctionReferenceImpl;
import lf.h;
import ng.b;
import qf.c;
import yf.q;

/* compiled from: SafeCollector.kt */
/* loaded from: classes2.dex */
public /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<b<? super Object>, Object, c<? super h>, Object> {

    /* renamed from: u, reason: collision with root package name */
    public static final SafeCollectorKt$emitFun$1 f15554u = new SafeCollectorKt$emitFun$1();

    public SafeCollectorKt$emitFun$1() {
        super(3, b.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @Override // yf.q
    public /* bridge */ /* synthetic */ Object invoke(b<? super Object> bVar, Object obj, c<? super h> cVar) {
        return invoke2((b<Object>) bVar, obj, cVar);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b<Object> bVar, Object obj, c<? super h> cVar) {
        return bVar.emit(obj, cVar);
    }
}
