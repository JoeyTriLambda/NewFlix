package kotlinx.coroutines.flow;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.CombineKt;
import lf.f;
import lf.h;
import ng.a;
import ng.b;
import qf.c;
import sf.d;
import yf.q;
import yf.r;

/* compiled from: Zip.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ZipKt {
    public static final <T1, T2, T3, R> a<R> combine(a<? extends T1> aVar, a<? extends T2> aVar2, a<? extends T3> aVar3, final r<? super T1, ? super T2, ? super T3, ? super c<? super R>, ? extends Object> rVar) {
        final a[] aVarArr = {aVar, aVar2, aVar3};
        return new a<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            /* compiled from: Zip.kt */
            @d(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", f = "Zip.kt", l = {333, 262}, m = "invokeSuspend")
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2, reason: invalid class name */
            public static final class AnonymousClass2 extends SuspendLambda implements q<b<? super R>, Object[], c<? super h>, Object> {

                /* renamed from: b, reason: collision with root package name */
                public int f15448b;

                /* renamed from: m, reason: collision with root package name */
                public /* synthetic */ b f15449m;

                /* renamed from: n, reason: collision with root package name */
                public /* synthetic */ Object[] f15450n;

                /* renamed from: o, reason: collision with root package name */
                public final /* synthetic */ r f15451o;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(c cVar, r rVar) {
                    super(3, cVar);
                    this.f15451o = rVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    b bVar;
                    Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
                    int i10 = this.f15448b;
                    if (i10 == 0) {
                        f.throwOnFailure(obj);
                        bVar = this.f15449m;
                        Object[] objArr = this.f15450n;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        this.f15449m = bVar;
                        this.f15448b = 1;
                        zf.h.mark(6);
                        obj = this.f15451o.invoke(obj2, obj3, obj4, this);
                        zf.h.mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i10 != 1) {
                            if (i10 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            f.throwOnFailure(obj);
                            return h.f16056a;
                        }
                        bVar = this.f15449m;
                        f.throwOnFailure(obj);
                    }
                    this.f15449m = null;
                    this.f15448b = 2;
                    if (bVar.emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return h.f16056a;
                }

                @Override // yf.q
                public final Object invoke(b<? super R> bVar, Object[] objArr, c<? super h> cVar) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar, this.f15451o);
                    anonymousClass2.f15449m = bVar;
                    anonymousClass2.f15450n = objArr;
                    return anonymousClass2.invokeSuspend(h.f16056a);
                }
            }

            @Override // ng.a
            public Object collect(b bVar, c cVar) {
                Object objCombineInternal = CombineKt.combineInternal(bVar, aVarArr, new yf.a() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // yf.a
                    public final Void invoke() {
                        return null;
                    }
                }, new AnonymousClass2(null, rVar), cVar);
                return objCombineInternal == rf.a.getCOROUTINE_SUSPENDED() ? objCombineInternal : h.f16056a;
            }
        };
    }

    public static final <T1, T2, R> a<R> zip(a<? extends T1> aVar, a<? extends T2> aVar2, q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return CombineKt.zipImpl(aVar, aVar2, qVar);
    }
}
