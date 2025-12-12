package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IConfigurationLoader;
import com.unity3d.services.core.configuration.IConfigurationLoaderListener;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.extensions.AbortRetryException;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import com.unity3d.services.core.request.metrics.TSIMetric;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.b;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateConfigWithLoader.kt */
@d(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1", f = "InitializeStateConfigWithLoader.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InitializeStateConfigWithLoader$doWork$2$configResult$1$1 extends SuspendLambda implements p<Integer, c<? super h>, Object> {
    final /* synthetic */ Ref$ObjectRef<Configuration> $config;
    final /* synthetic */ Ref$ObjectRef<IConfigurationLoader> $configurationLoader;
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* compiled from: InitializeStateConfigWithLoader.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1", f = "InitializeStateConfigWithLoader.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        final /* synthetic */ Ref$ObjectRef<Configuration> $config;
        final /* synthetic */ Ref$ObjectRef<IConfigurationLoader> $configurationLoader;
        int label;
        final /* synthetic */ InitializeStateConfigWithLoader this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Ref$ObjectRef<IConfigurationLoader> ref$ObjectRef, Ref$ObjectRef<Configuration> ref$ObjectRef2, InitializeStateConfigWithLoader initializeStateConfigWithLoader, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$configurationLoader = ref$ObjectRef;
            this.$config = ref$ObjectRef2;
            this.this$0 = initializeStateConfigWithLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(this.$configurationLoader, this.$config, this.this$0, cVar);
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
            iConfigurationLoader.loadConfiguration(new IConfigurationLoaderListener() { // from class: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.doWork.2.configResult.1.1.1.1
                @Override // com.unity3d.services.core.configuration.IConfigurationLoaderListener
                public void onError(String str) throws AbortRetryException {
                    i.checkNotNullParameter(str, "errorMsg");
                    SDKMetricsSender sDKMetricsSender = initializeStateConfigWithLoader.sdkMetricsSender;
                    Metric metricNewEmergencySwitchOff = TSIMetric.newEmergencySwitchOff();
                    i.checkNotNullExpressionValue(metricNewEmergencySwitchOff, "newEmergencySwitchOff()");
                    sDKMetricsSender.sendMetric(metricNewEmergencySwitchOff);
                    throw new AbortRetryException(str);
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
    public InitializeStateConfigWithLoader$doWork$2$configResult$1$1(InitializeStateConfigWithLoader initializeStateConfigWithLoader, Ref$ObjectRef<IConfigurationLoader> ref$ObjectRef, Ref$ObjectRef<Configuration> ref$ObjectRef2, c<? super InitializeStateConfigWithLoader$doWork$2$configResult$1$1> cVar) {
        super(2, cVar);
        this.this$0 = initializeStateConfigWithLoader;
        this.$configurationLoader = ref$ObjectRef;
        this.$config = ref$ObjectRef2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c<h> create(Object obj, c<?> cVar) {
        InitializeStateConfigWithLoader$doWork$2$configResult$1$1 initializeStateConfigWithLoader$doWork$2$configResult$1$1 = new InitializeStateConfigWithLoader$doWork$2$configResult$1$1(this.this$0, this.$configurationLoader, this.$config, cVar);
        initializeStateConfigWithLoader$doWork$2$configResult$1$1.I$0 = ((Number) obj).intValue();
        return initializeStateConfigWithLoader$doWork$2$configResult$1$1;
    }

    public final Object invoke(int i10, c<? super h> cVar) {
        return ((InitializeStateConfigWithLoader$doWork$2$configResult$1$1) create(Integer.valueOf(i10), cVar)).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 == 0) {
            f.throwOnFailure(obj);
            if (this.I$0 > 0) {
                InitializeEventsMetricSender.getInstance().onRetryConfig();
            }
            b io2 = this.this$0.dispatchers.getIo();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$configurationLoader, this.$config, this.this$0, null);
            this.label = 1;
            if (kg.f.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
        }
        return h.f16056a;
    }

    @Override // yf.p
    public /* bridge */ /* synthetic */ Object invoke(Integer num, c<? super h> cVar) {
        return invoke(num.intValue(), cVar);
    }
}
