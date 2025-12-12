package com.ptrbrynt.kotlin_bloc.core;

import kg.g0;
import kg.h;
import kg.h0;
import kg.s0;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import ng.a;
import ng.f;
import ng.i;
import oa.b;
import qf.c;
import sf.d;

/* compiled from: BlocBase.kt */
/* loaded from: classes.dex */
public abstract class BlocBase<State> {

    /* renamed from: b, reason: collision with root package name */
    public final g0 f10420b;

    /* renamed from: m, reason: collision with root package name */
    public final f<b<State>> f10421m;

    /* renamed from: n, reason: collision with root package name */
    public final BlocBase$special$$inlined$map$1 f10422n;

    /* renamed from: o, reason: collision with root package name */
    public State f10423o;

    public BlocBase(State state) {
        Bloc.f10406r.getObserver().onCreate(this);
        this.f10420b = h0.CoroutineScope(s0.getUnconfined());
        final f<b<State>> fVarMutableSharedFlow$default = i.MutableSharedFlow$default(0, 0, null, 7, null);
        h.launch$default(getBlocScope(), null, null, new BlocBase$mutableChangeFlow$1$1(fVarMutableSharedFlow$default, this, null), 3, null);
        this.f10421m = fVarMutableSharedFlow$default;
        this.f10422n = new a<State>() { // from class: com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1

            /* compiled from: Collect.kt */
            /* renamed from: com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements ng.b<b<State>> {

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ng.b f10425b;

                @d(c = "com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2", f = "BlocBase.kt", l = {137}, m = "emit")
                /* renamed from: com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: b, reason: collision with root package name */
                    public /* synthetic */ Object f10426b;

                    /* renamed from: m, reason: collision with root package name */
                    public int f10427m;

                    public AnonymousClass1(c cVar) {
                        super(cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f10426b = obj;
                        this.f10427m |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(ng.b bVar) {
                    this.f10425b = bVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // ng.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public java.lang.Object emit(java.lang.Object r5, qf.c r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2$1 r0 = (com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f10427m
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f10427m = r1
                        goto L18
                    L13:
                        com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2$1 r0 = new com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f10426b
                        java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f10427m
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        lf.f.throwOnFailure(r6)
                        goto L45
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        lf.f.throwOnFailure(r6)
                        oa.b r5 = (oa.b) r5
                        java.lang.Object r5 = r5.getNewState()
                        r0.f10427m = r3
                        ng.b r6 = r4.f10425b
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L45
                        return r1
                    L45:
                        lf.h r5 = lf.h.f16056a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.ptrbrynt.kotlin_bloc.core.BlocBase$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, qf.c):java.lang.Object");
                }
            }

            @Override // ng.a
            public Object collect(ng.b bVar, c cVar) {
                Object objCollect = fVarMutableSharedFlow$default.collect(new AnonymousClass2(bVar), cVar);
                return objCollect == rf.a.getCOROUTINE_SUSPENDED() ? objCollect : lf.h.f16056a;
            }
        };
        this.f10423o = state;
    }

    public final g0 getBlocScope() {
        return this.f10420b;
    }

    public final f<b<State>> getMutableChangeFlow() {
        return this.f10421m;
    }

    public final State getState() {
        return this.f10423o;
    }

    public final a<State> getStateFlow() {
        return this.f10422n;
    }

    public void onChange(b<State> bVar) {
        zf.i.checkNotNullParameter(bVar, "change");
        Bloc.f10406r.getObserver().onChange(this, bVar);
        this.f10423o = bVar.getNewState();
    }
}
