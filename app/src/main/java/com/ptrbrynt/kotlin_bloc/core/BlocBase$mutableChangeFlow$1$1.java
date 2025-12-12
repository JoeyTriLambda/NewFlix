package com.ptrbrynt.kotlin_bloc.core;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import ng.f;
import oa.b;
import qf.c;
import sf.d;
import yf.p;

/* compiled from: BlocBase.kt */
@d(c = "com.ptrbrynt.kotlin_bloc.core.BlocBase$mutableChangeFlow$1$1", f = "BlocBase.kt", l = {66}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class BlocBase$mutableChangeFlow$1$1 extends SuspendLambda implements p<g0, c<? super h>, Object> {

    /* renamed from: b, reason: collision with root package name */
    public int f10429b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ f<b<State>> f10430m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ BlocBase<State> f10431n;

    /* JADX INFO: Add missing generic type declarations: [State] */
    /* compiled from: Collect.kt */
    public static final class a<State> implements ng.b<b<State>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BlocBase f10432b;

        public a(BlocBase blocBase) {
            this.f10432b = blocBase;
        }

        @Override // ng.b
        public Object emit(b<State> bVar, c<? super h> cVar) {
            this.f10432b.onChange(bVar);
            return h.f16056a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlocBase$mutableChangeFlow$1$1(f<b<State>> fVar, BlocBase<State> blocBase, c<? super BlocBase$mutableChangeFlow$1$1> cVar) {
        super(2, cVar);
        this.f10430m = fVar;
        this.f10431n = blocBase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        return new BlocBase$mutableChangeFlow$1$1(this.f10430m, this.f10431n, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
        int i10 = this.f10429b;
        if (i10 == 0) {
            lf.f.throwOnFailure(obj);
            a aVar = new a(this.f10431n);
            this.f10429b = 1;
            if (this.f10430m.collect(aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
        }
        return h.f16056a;
    }

    @Override // yf.p
    public final Object invoke(g0 g0Var, c<? super h> cVar) {
        return ((BlocBase$mutableChangeFlow$1$1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
    }
}
