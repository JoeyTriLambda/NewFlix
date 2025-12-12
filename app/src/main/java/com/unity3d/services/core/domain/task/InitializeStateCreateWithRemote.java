package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateCreateWithRemote.kt */
/* loaded from: classes2.dex */
public final class InitializeStateCreateWithRemote extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateCreateWithRemote.kt */
    public static final class Params implements BaseParams {
        private Configuration config;

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

        public final void setConfig(Configuration configuration) {
            i.checkNotNullParameter(configuration, "<set-?>");
            this.config = configuration;
        }

        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    /* compiled from: InitializeStateCreateWithRemote.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$doWork$2", f = "InitializeStateCreateWithRemote.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
        final /* synthetic */ Params $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$params, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            f.throwOnFailure(obj);
            DeviceLog.debug("Unity Ads init: creating webapp");
            Configuration config = this.$params.getConfig();
            try {
                ErrorState errorStateCreate = WebViewApp.create(config, true);
                if (errorStateCreate == null) {
                    return config;
                }
                String webAppFailureMessage = WebViewApp.getCurrentApp().getWebAppFailureMessage() != null ? WebViewApp.getCurrentApp().getWebAppFailureMessage() : "Unity Ads WebApp creation failed";
                DeviceLog.error(webAppFailureMessage);
                throw new InitializationException(errorStateCreate, new Exception(webAppFailureMessage), config);
            } catch (IllegalThreadStateException e10) {
                DeviceLog.exception("Illegal Thread", e10);
                throw new InitializationException(ErrorState.CreateWebApp, e10, config);
            }
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateCreateWithRemote(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super Configuration>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("create_web_view");
    }

    public Object doWork(Params params, c<? super Configuration> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, null), cVar);
    }
}
