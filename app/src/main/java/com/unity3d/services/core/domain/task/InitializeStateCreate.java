package com.unity3d.services.core.domain.task;

import ac.c;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import rf.a;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateCreate.kt */
/* loaded from: classes2.dex */
public final class InitializeStateCreate extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateCreate.kt */
    public static final class Params implements BaseParams {
        private final Configuration config;
        private final String webViewData;

        public Params(Configuration configuration, String str) {
            i.checkNotNullParameter(configuration, "config");
            i.checkNotNullParameter(str, "webViewData");
            this.config = configuration;
            this.webViewData = str;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                configuration = params.config;
            }
            if ((i10 & 2) != 0) {
                str = params.webViewData;
            }
            return params.copy(configuration, str);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final String component2() {
            return this.webViewData;
        }

        public final Params copy(Configuration configuration, String str) {
            i.checkNotNullParameter(configuration, "config");
            i.checkNotNullParameter(str, "webViewData");
            return new Params(configuration, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return i.areEqual(this.config, params.config) && i.areEqual(this.webViewData, params.webViewData);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }

        public int hashCode() {
            return this.webViewData.hashCode() + (this.config.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Params(config=");
            sb2.append(this.config);
            sb2.append(", webViewData=");
            return c.n(sb2, this.webViewData, ')');
        }
    }

    /* compiled from: InitializeStateCreate.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2", f = "InitializeStateCreate.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateCreate$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, qf.c<? super Configuration>, Object> {
        final /* synthetic */ Params $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, qf.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<h> create(Object obj, qf.c<?> cVar) {
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
            config.setWebViewData(this.$params.getWebViewData());
            try {
                ErrorState errorStateCreate = WebViewApp.create(config, false);
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
        public final Object invoke(g0 g0Var, qf.c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateCreate(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, qf.c cVar) {
        return doWork((Params) baseParams, (qf.c<? super Configuration>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("create_web_view");
    }

    public Object doWork(Params params, qf.c<? super Configuration> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, null), cVar);
    }
}
