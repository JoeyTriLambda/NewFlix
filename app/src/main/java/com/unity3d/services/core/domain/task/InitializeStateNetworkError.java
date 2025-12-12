package com.unity3d.services.core.domain.task;

import com.loopj.android.http.AsyncHttpClient;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.connectivity.IConnectivityListener;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import java.lang.reflect.InvocationTargetException;
import kg.g0;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.TimeoutKt;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateNetworkError.kt */
/* loaded from: classes2.dex */
public final class InitializeStateNetworkError extends MetricTask<Params, h> implements IConnectivityListener {
    private int connectedEventThreshold;
    private c<? super h> continuation;
    private final ISDKDispatchers dispatchers;
    private long lastConnectedEventTimeMs;
    private int maximumConnectedEvents;
    private int receivedConnectedEvents;

    /* compiled from: InitializeStateNetworkError.kt */
    public static final class Params implements BaseParams {
        private final Configuration config;

        public Params(Configuration configuration) {
            i.checkNotNullParameter(configuration, "config");
            this.config = configuration;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final Params copy(Configuration configuration) {
            i.checkNotNullParameter(configuration, "config");
            return new Params(configuration);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && i.areEqual(this.config, ((Params) obj).config);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    /* compiled from: InitializeStateNetworkError.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError", f = "InitializeStateNetworkError.kt", l = {32}, m = "doWork")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return InitializeStateNetworkError.this.doWork((Params) null, (c<? super h>) this);
        }
    }

    /* compiled from: InitializeStateNetworkError.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", f = "InitializeStateNetworkError.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        final /* synthetic */ Params $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return InitializeStateNetworkError.this.new AnonymousClass2(this.$params, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Exception {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                DeviceLog.error("Unity Ads init: network error, waiting for connection events");
                InitializeStateNetworkError.this.maximumConnectedEvents = this.$params.getConfig().getMaximumConnectedEvents();
                InitializeStateNetworkError.this.connectedEventThreshold = this.$params.getConfig().getConnectedEventThreshold();
                long networkErrorTimeout = this.$params.getConfig().getNetworkErrorTimeout();
                InitializeStateNetworkError$doWork$2$success$1 initializeStateNetworkError$doWork$2$success$1 = new InitializeStateNetworkError$doWork$2$success$1(InitializeStateNetworkError.this, null);
                this.label = 1;
                obj = TimeoutKt.withTimeoutOrNull(networkErrorTimeout, initializeStateNetworkError$doWork$2$success$1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            if (((h) obj) != null) {
                return h.f16056a;
            }
            ConnectivityMonitor.removeListener(InitializeStateNetworkError.this);
            throw new Exception("No connected events within the timeout!");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateNetworkError(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
        this.maximumConnectedEvents = 500;
        this.connectedEventThreshold = AsyncHttpClient.DEFAULT_SOCKET_TIMEOUT;
    }

    private final boolean shouldHandleConnectedEvent() {
        return System.currentTimeMillis() - this.lastConnectedEventTimeMs >= ((long) this.connectedEventThreshold) && this.receivedConnectedEvents <= this.maximumConnectedEvents;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startListening(c<? super h> cVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.continuation = cVar;
        ConnectivityMonitor.addListener(this);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super h>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("error_network");
    }

    @Override // com.unity3d.services.core.connectivity.IConnectivityListener
    public void onConnected() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this.receivedConnectedEvents++;
        DeviceLog.debug("Unity Ads init got connected event");
        if (shouldHandleConnectedEvent()) {
            c<? super h> cVar = this.continuation;
            if (cVar != null) {
                int i10 = Result.f15189m;
                cVar.resumeWith(Result.m59constructorimpl(h.f16056a));
            }
            this.continuation = null;
        }
        if (this.receivedConnectedEvents > this.maximumConnectedEvents) {
            ConnectivityMonitor.removeListener(this);
        }
        this.lastConnectedEventTimeMs = System.currentTimeMillis();
    }

    @Override // com.unity3d.services.core.connectivity.IConnectivityListener
    public void onDisconnected() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DeviceLog.debug("Unity Ads init got disconnected event");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.InitializeStateNetworkError.Params r6, qf.c<? super lf.h> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateNetworkError.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateNetworkError.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            lf.f.throwOnFailure(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            lf.f.throwOnFailure(r7)
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r5.dispatchers
            kotlinx.coroutines.b r7 = r7.getDefault()
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2
            r4 = 0
            r2.<init>(r6, r4)
            r0.label = r3
            java.lang.Object r6 = kg.f.withContext(r7, r2, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            lf.h r6 = lf.h.f16056a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateNetworkError.doWork(com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params, qf.c):java.lang.Object");
    }
}
