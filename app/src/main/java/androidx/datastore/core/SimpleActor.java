package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kg.g0;
import kg.k1;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.channels.a;
import lf.h;
import mg.a;
import qf.c;
import sf.d;
import yf.l;
import yf.p;
import zf.i;

/* compiled from: SimpleActor.kt */
/* loaded from: classes.dex */
public final class SimpleActor<T> {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f2180a;

    /* renamed from: b, reason: collision with root package name */
    public final p<T, c<? super h>, Object> f2181b;

    /* renamed from: c, reason: collision with root package name */
    public final a<T> f2182c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f2183d;

    /* compiled from: SimpleActor.kt */
    @d(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    /* renamed from: androidx.datastore.core.SimpleActor$offer$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public p f2187b;

        /* renamed from: m, reason: collision with root package name */
        public int f2188m;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ SimpleActor<T> f2189n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(SimpleActor<T> simpleActor, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.f2189n = simpleActor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.f2189n, cVar);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0054 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x005e -> B:22:0x0061). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
                int r1 = r6.f2188m
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L24
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                lf.f.throwOnFailure(r7)
                r7 = r6
                goto L61
            L13:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1b:
                yf.p r1 = r6.f2187b
                lf.f.throwOnFailure(r7)
                r4 = r1
                r1 = r7
                r7 = r6
                goto L55
            L24:
                lf.f.throwOnFailure(r7)
                androidx.datastore.core.SimpleActor<T> r7 = r6.f2189n
                java.util.concurrent.atomic.AtomicInteger r7 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r7)
                int r7 = r7.get()
                if (r7 <= 0) goto L35
                r7 = 1
                goto L36
            L35:
                r7 = 0
            L36:
                if (r7 == 0) goto L70
                r7 = r6
            L39:
                androidx.datastore.core.SimpleActor<T> r1 = r7.f2189n
                kg.g0 r4 = androidx.datastore.core.SimpleActor.access$getScope$p(r1)
                kg.h0.ensureActive(r4)
                yf.p r4 = androidx.datastore.core.SimpleActor.access$getConsumeMessage$p(r1)
                mg.a r1 = androidx.datastore.core.SimpleActor.access$getMessageQueue$p(r1)
                r7.f2187b = r4
                r7.f2188m = r3
                java.lang.Object r1 = r1.receive(r7)
                if (r1 != r0) goto L55
                return r0
            L55:
                r5 = 0
                r7.f2187b = r5
                r7.f2188m = r2
                java.lang.Object r1 = r4.invoke(r1, r7)
                if (r1 != r0) goto L61
                return r0
            L61:
                androidx.datastore.core.SimpleActor<T> r1 = r7.f2189n
                java.util.concurrent.atomic.AtomicInteger r1 = androidx.datastore.core.SimpleActor.access$getRemainingMessages$p(r1)
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L39
                lf.h r7 = lf.h.f16056a
                return r7
            L70:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SimpleActor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleActor(g0 g0Var, final l<? super Throwable, h> lVar, final p<? super T, ? super Throwable, h> pVar, p<? super T, ? super c<? super h>, ? extends Object> pVar2) {
        i.checkNotNullParameter(g0Var, "scope");
        i.checkNotNullParameter(lVar, "onComplete");
        i.checkNotNullParameter(pVar, "onUndeliveredElement");
        i.checkNotNullParameter(pVar2, "consumeMessage");
        this.f2180a = g0Var;
        this.f2181b = pVar2;
        this.f2182c = mg.c.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        this.f2183d = new AtomicInteger(0);
        CoroutineContext coroutineContext = g0Var.getCoroutineContext();
        int i10 = k1.f15118i;
        k1 k1Var = (k1) coroutineContext.get(k1.b.f15119b);
        if (k1Var == null) {
            return;
        }
        k1Var.invokeOnCompletion(new l<Throwable, h>() { // from class: androidx.datastore.core.SimpleActor.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                h hVar;
                lVar.invoke(th2);
                SimpleActor<T> simpleActor = this;
                simpleActor.f2182c.close(th2);
                do {
                    Object objM75getOrNullimpl = kotlinx.coroutines.channels.a.m75getOrNullimpl(simpleActor.f2182c.mo69tryReceivePtdJZtk());
                    if (objM75getOrNullimpl == null) {
                        hVar = null;
                    } else {
                        pVar.invoke(objM75getOrNullimpl, th2);
                        hVar = h.f16056a;
                    }
                } while (hVar != null);
            }
        });
    }

    public final void offer(T t10) throws Throwable {
        Object objMo70trySendJP2dKIU = this.f2182c.mo70trySendJP2dKIU(t10);
        if (objMo70trySendJP2dKIU instanceof a.C0181a) {
            Throwable thM74exceptionOrNullimpl = kotlinx.coroutines.channels.a.m74exceptionOrNullimpl(objMo70trySendJP2dKIU);
            if (thM74exceptionOrNullimpl != null) {
                throw thM74exceptionOrNullimpl;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!kotlinx.coroutines.channels.a.m78isSuccessimpl(objMo70trySendJP2dKIU)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.f2183d.getAndIncrement() == 0) {
            kg.h.launch$default(this.f2180a, null, null, new AnonymousClass2(this, null), 3, null);
        }
    }
}
