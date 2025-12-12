package com.ptrbrynt.kotlin_bloc.core;

import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import ng.f;
import oa.d;
import oa.e;
import qf.c;
import yf.p;
import yf.q;
import zf.i;

/* compiled from: Bloc.kt */
/* loaded from: classes.dex */
public abstract class Bloc<Event, State> extends BlocBase<State> {

    /* renamed from: r, reason: collision with root package name */
    public static final a f10406r = new a(null);

    /* renamed from: s, reason: collision with root package name */
    public static oa.a f10407s = new d();

    /* renamed from: p, reason: collision with root package name */
    public final f<Event> f10408p;

    /* renamed from: q, reason: collision with root package name */
    public final b f10409q;

    /* compiled from: Bloc.kt */
    @sf.d(c = "com.ptrbrynt.kotlin_bloc.core.Bloc$1", f = "Bloc.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.ptrbrynt.kotlin_bloc.core.Bloc$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<Event, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10410b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Bloc<Event, State> f10411m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Bloc<Event, State> bloc, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.f10411m = bloc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f10411m, cVar);
            anonymousClass1.f10410b = obj;
            return anonymousClass1;
        }

        @Override // yf.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, c<? super h> cVar) {
            return invoke2((AnonymousClass1) obj, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            rf.a.getCOROUTINE_SUSPENDED();
            lf.f.throwOnFailure(obj);
            this.f10411m.onEvent(this.f10410b);
            return h.f16056a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Event event, c<? super h> cVar) {
            return ((AnonymousClass1) create(event, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: Bloc.kt */
    @sf.d(c = "com.ptrbrynt.kotlin_bloc.core.Bloc$2", f = "Bloc.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.ptrbrynt.kotlin_bloc.core.Bloc$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements q<Event, oa.b<State>, c<? super e<Event, State>>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10412b;

        /* renamed from: m, reason: collision with root package name */
        public /* synthetic */ oa.b f10413m;

        public AnonymousClass2(c<? super AnonymousClass2> cVar) {
            super(3, cVar);
        }

        @Override // yf.q
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return invoke((AnonymousClass2) obj, (oa.b) obj2, (c<? super e<AnonymousClass2, State>>) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            rf.a.getCOROUTINE_SUSPENDED();
            lf.f.throwOnFailure(obj);
            Object obj2 = this.f10412b;
            oa.b bVar = this.f10413m;
            return new e(bVar.getState(), obj2, bVar.getNewState());
        }

        public final Object invoke(Event event, oa.b<State> bVar, c<? super e<Event, State>> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(cVar);
            anonymousClass2.f10412b = event;
            anonymousClass2.f10413m = bVar;
            return anonymousClass2.invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: Bloc.kt */
    @sf.d(c = "com.ptrbrynt.kotlin_bloc.core.Bloc$3", f = "Bloc.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.ptrbrynt.kotlin_bloc.core.Bloc$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements p<e<Event, State>, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10414b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Bloc<Event, State> f10415m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Bloc<Event, State> bloc, c<? super AnonymousClass3> cVar) {
            super(2, cVar);
            this.f10415m = bloc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.f10415m, cVar);
            anonymousClass3.f10414b = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            rf.a.getCOROUTINE_SUSPENDED();
            lf.f.throwOnFailure(obj);
            this.f10415m.onTransition((e) this.f10414b);
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(e<Event, State> eVar, c<? super h> cVar) {
            return ((AnonymousClass3) create(eVar, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: Bloc.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public final oa.a getObserver() {
            return Bloc.f10407s;
        }

        public final void setObserver(oa.a aVar) {
            i.checkNotNullParameter(aVar, "<set-?>");
            Bloc.f10407s = aVar;
        }
    }

    /* compiled from: Bloc.kt */
    @sf.d(c = "com.ptrbrynt.kotlin_bloc.core.Bloc$add$1", f = "Bloc.kt", l = {82}, m = "invokeSuspend")
    /* renamed from: com.ptrbrynt.kotlin_bloc.core.Bloc$add$1, reason: invalid class name and case insensitive filesystem */
    public static final class C03451 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f10416b;

        /* renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Bloc<Event, State> f10417m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Event f10418n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C03451(Bloc<Event, State> bloc, Event event, c<? super C03451> cVar) {
            super(2, cVar);
            this.f10417m = bloc;
            this.f10418n = event;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new C03451(this.f10417m, this.f10418n, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f10416b;
            if (i10 == 0) {
                lf.f.throwOnFailure(obj);
                f<Event> eventFlow = this.f10417m.getEventFlow();
                this.f10416b = 1;
                if (eventFlow.emit(this.f10418n, this) == coroutine_suspended) {
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
            return ((C03451) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* compiled from: Bloc.kt */
    public static final class b implements oa.c<State> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bloc<Event, State> f10419a;

        public b(Bloc<Event, State> bloc) {
            this.f10419a = bloc;
        }

        @Override // oa.c
        public Object emit(State state, c<? super h> cVar) {
            Bloc<Event, State> bloc = this.f10419a;
            Object objEmit = bloc.getMutableChangeFlow().emit(new oa.b<>(bloc.getState(), state), cVar);
            return objEmit == rf.a.getCOROUTINE_SUSPENDED() ? objEmit : h.f16056a;
        }
    }

    public Bloc(State state) {
        super(state);
        f<Event> fVarMutableSharedFlow$default = ng.i.MutableSharedFlow$default(0, 0, null, 7, null);
        this.f10408p = fVarMutableSharedFlow$default;
        ng.c.launchIn(ng.c.onEach(ng.c.zip(ng.c.onEach(fVarMutableSharedFlow$default, new AnonymousClass1(this, null)), getMutableChangeFlow(), new AnonymousClass2(null)), new AnonymousClass3(this, null)), getBlocScope());
        this.f10409q = new b(this);
    }

    public final void add(Event event) {
        kg.h.launch$default(getBlocScope(), null, null, new C03451(this, event, null), 3, null);
    }

    public final oa.c<State> getEmitter() {
        return this.f10409q;
    }

    public final f<Event> getEventFlow() {
        return this.f10408p;
    }

    public void onEvent(Event event) {
        f10407s.onEvent(this, event);
    }

    public void onTransition(e<Event, State> eVar) {
        i.checkNotNullParameter(eVar, "transition");
        f10407s.onTransition(this, eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ng.a<Event> transformEvents(ng.a<? extends Event> aVar) {
        i.checkNotNullParameter(aVar, "<this>");
        return aVar;
    }
}
