package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateConfigWithLoader.kt */
/* loaded from: classes2.dex */
public final class InitializeStateConfigWithLoader implements BaseTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateNetworkError initializeStateNetworkError;
    private final SDKMetricsSender sdkMetricsSender;
    private final TokenStorage tokenStorage;

    /* compiled from: InitializeStateConfigWithLoader.kt */
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

    /* compiled from: InitializeStateConfigWithLoader.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", l = {52, 94, 97}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
        final /* synthetic */ Params $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ InitializeStateConfigWithLoader this$0;

        /* compiled from: InitializeStateConfigWithLoader.kt */
        @d(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1", f = "InitializeStateConfigWithLoader.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
            final /* synthetic */ Ref$ObjectRef<Configuration> $config;
            final /* synthetic */ Ref$ObjectRef<IConfigurationLoader> $configurationLoader;
            final /* synthetic */ Params $params;
            int label;
            final /* synthetic */ InitializeStateConfigWithLoader this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Ref$ObjectRef<IConfigurationLoader> ref$ObjectRef, Ref$ObjectRef<Configuration> ref$ObjectRef2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, Params params, c<? super AnonymousClass1> cVar) {
                super(2, cVar);
                this.$configurationLoader = ref$ObjectRef;
                this.$config = ref$ObjectRef2;
                this.this$0 = initializeStateConfigWithLoader;
                this.$params = params;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final c<h> create(Object obj, c<?> cVar) {
                return new AnonymousClass1(this.$configurationLoader, this.$config, this.this$0, this.$params, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Exception {
                a.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
                IConfigurationLoader iConfigurationLoader = this.$configurationLoader.f15262b;
                final Ref$ObjectRef<Configuration> ref$ObjectRef = this.$config;
                final InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0;
                final Params params = this.$params;
                iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.doWork.2.1.1
                    @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                    public void onError(String str) throws InitializationException {
                        i.checkNotNullParameter(str, "errorMsg");
                        SDKMetricsSender sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                        Metric metricNewEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                        i.checkNotNullExpressionValue(metricNewEmergencySwitchOff, "newEmergencySwitchOff()");
                        sDKMetricsSender.sendMetric(metricNewEmergencySwitchOff);
                        throw new InitializationException(ErrorState.NetworkConfigRequest, new Exception(str), params.getConfig());
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                    public void onSuccess(Configuration configuration) {
                        i.checkNotNullParameter(configuration, "configuration");
                        ref$ObjectRef.f15262b = configuration;
                        configuration.saveToDisk();
                        initializeStateConfigWithLoader.tokenStorage.setInitToken(ref$ObjectRef.f15262b.getUnifiedAuctionToken());
                    }
                });
                return h.f16056a;
            }

            @Override // yf.p
            public final Object invoke(g0 g0Var, c<? super h> cVar) {
                return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, InitializeStateConfigWithLoader initializeStateConfigWithLoader, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
            this.this$0 = initializeStateConfigWithLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$params, this.this$0, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x01ca  */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, com.unity3d.services.core.configuration.Configuration] */
        /* JADX WARN: Type inference failed for: r4v0, types: [T, com.unity3d.services.core.configuration.ConfigurationLoader] */
        /* JADX WARN: Type inference failed for: r5v1, types: [T, com.unity3d.services.core.configuration.PrivacyConfigurationLoader] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 469
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateConfigWithLoader(ISDKDispatchers iSDKDispatchers, InitializeStateNetworkError initializeStateNetworkError, TokenStorage tokenStorage, SDKMetricsSender sDKMetricsSender) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(initializeStateNetworkError, "initializeStateNetworkError");
        i.checkNotNullParameter(tokenStorage, "tokenStorage");
        i.checkNotNullParameter(sDKMetricsSender, "sdkMetricsSender");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.tokenStorage = tokenStorage;
        this.sdkMetricsSender = sDKMetricsSender;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public Object doWork(Params params, c<? super Configuration> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, this, null), cVar);
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public Object invoke(Params params, c<? super Configuration> cVar) {
        return BaseTask.DefaultImpls.invoke(this, params, cVar);
    }
}
