package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateConfig.kt */
/* loaded from: classes2.dex */
public final class InitializeStateConfig extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;
    private final InitializeStateConfigWithLoader initializeStateConfigWithLoader;

    /* compiled from: InitializeStateConfig.kt */
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

    /* compiled from: InitializeStateConfig.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2", f = "InitializeStateConfig.kt", l = {26}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfig$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
        final /* synthetic */ Params $params;
        int label;
        final /* synthetic */ InitializeStateConfig this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, InitializeStateConfig initializeStateConfig, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
            this.this$0 = initializeStateConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$params, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                DeviceLog.info("Unity Ads init: load configuration from " + SdkProperties.getConfigUrl());
                Configuration configuration = new Configuration(SdkProperties.getConfigUrl(), this.$params.getConfig().getExperimentsReader());
                InitializeStateConfigWithLoader initializeStateConfigWithLoader = this.this$0.initializeStateConfigWithLoader;
                InitializeStateConfigWithLoader.Params params = new InitializeStateConfigWithLoader.Params(configuration);
                this.label = 1;
                obj = initializeStateConfigWithLoader.invoke((BaseParams) params, (c<? super Configuration>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
            }
            return obj;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateConfig(ISDKDispatchers iSDKDispatchers, InitializeStateConfigWithLoader initializeStateConfigWithLoader) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(initializeStateConfigWithLoader, "initializeStateConfigWithLoader");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateConfigWithLoader = initializeStateConfigWithLoader;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super Configuration>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("config_fetch");
    }

    public Object doWork(Params params, c<? super Configuration> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, this, null), cVar);
    }
}
