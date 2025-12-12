package com.unity3d.services.core.domain.task;

import android.app.Application;
import com.unity3d.services.core.api.Lifecycle;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.properties.ClientProperties;
import kg.f;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import qf.c;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateReset.kt */
/* loaded from: classes2.dex */
public class InitializeStateReset extends MetricTask<Params, Configuration> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateReset.kt */
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

    /* compiled from: InitializeStateReset.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", l = {37}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super Configuration>, Object> {
        final /* synthetic */ Params $params;
        int label;
        final /* synthetic */ InitializeStateReset this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, InitializeStateReset initializeStateReset, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
            this.this$0 = initializeStateReset;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return new AnonymousClass2(this.$params, this.this$0, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Exception {
            /*
                r7 = this;
                java.lang.Object r0 = rf.a.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L18
                if (r1 != r3) goto L10
                lf.f.throwOnFailure(r8)
                goto L4d
            L10:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L18:
                lf.f.throwOnFailure(r8)
                java.lang.String r8 = "Unity Ads init: starting init"
                com.unity3d.services.core.log.DeviceLog.debug(r8)
                com.unity3d.services.core.webview.WebViewApp r8 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
                if (r8 == 0) goto L29
                r8.resetWebViewAppInitialization()
            L29:
                if (r8 == 0) goto L30
                com.unity3d.services.core.webview.WebView r1 = r8.getWebView()
                goto L31
            L30:
                r1 = r2
            L31:
                if (r1 == 0) goto L5a
                com.unity3d.services.core.domain.task.InitializeStateReset$Params r1 = r7.$params
                com.unity3d.services.core.configuration.Configuration r1 = r1.getConfig()
                long r4 = r1.getWebViewAppCreateTimeout()
                com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1 r1 = new com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1
                com.unity3d.services.core.domain.task.InitializeStateReset r6 = r7.this$0
                r1.<init>(r6, r8, r2)
                r7.label = r3
                java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r4, r1, r7)
                if (r8 != r0) goto L4d
                return r0
            L4d:
                lf.h r8 = (lf.h) r8
                if (r8 == 0) goto L52
                goto L5a
            L52:
                java.lang.Exception r8 = new java.lang.Exception
                java.lang.String r0 = "Reset failed on opening ConditionVariable"
                r8.<init>(r0)
                throw r8
            L5a:
                com.unity3d.services.core.domain.task.InitializeStateReset r8 = r7.this$0
                com.unity3d.services.core.domain.task.InitializeStateReset.access$unregisterLifecycleCallbacks(r8)
                com.unity3d.services.core.properties.SdkProperties.setCacheDirectory(r2)
                java.io.File r8 = com.unity3d.services.core.properties.SdkProperties.getCacheDirectory()
                if (r8 == 0) goto La2
                r8 = 0
                com.unity3d.services.core.properties.SdkProperties.setInitialized(r8)
                com.unity3d.services.core.domain.task.InitializeStateReset$Params r0 = r7.$params
                com.unity3d.services.core.configuration.Configuration r0 = r0.getConfig()
                java.lang.Class[] r0 = r0.getModuleConfigurationList()
                if (r0 != 0) goto L7a
                java.lang.Class[] r0 = new java.lang.Class[r8]
            L7a:
                int r1 = r0.length
            L7b:
                if (r8 >= r1) goto L9b
                r2 = r0[r8]
                com.unity3d.services.core.domain.task.InitializeStateReset$Params r3 = r7.$params
                com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
                com.unity3d.services.core.configuration.IModuleConfiguration r2 = r3.getModuleConfiguration(r2)
                if (r2 == 0) goto L98
                com.unity3d.services.core.domain.task.InitializeStateReset$Params r3 = r7.$params
                com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
                boolean r2 = r2.resetState(r3)
                sf.a.boxBoolean(r2)
            L98:
                int r8 = r8 + 1
                goto L7b
            L9b:
                com.unity3d.services.core.domain.task.InitializeStateReset$Params r8 = r7.$params
                com.unity3d.services.core.configuration.Configuration r8 = r8.getConfig()
                return r8
            La2:
                java.lang.Exception r8 = new java.lang.Exception
                java.lang.String r0 = "Cache directory is NULL"
                r8.<init>(r0)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateReset.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super Configuration> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateReset(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public static /* synthetic */ Object doWork$suspendImpl(InitializeStateReset initializeStateReset, Params params, c<? super Configuration> cVar) {
        return f.withContext(initializeStateReset.dispatchers.getDefault(), new AnonymousClass2(params, initializeStateReset, null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void unregisterLifecycleCallbacks() {
        if (Lifecycle.getLifecycleListener() != null) {
            Application application = ClientProperties.getApplication();
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(Lifecycle.getLifecycleListener());
            }
            Lifecycle.setLifecycleListener(null);
        }
    }

    public Object doWork(Params params, c<? super Configuration> cVar) {
        return doWork$suspendImpl(this, params, cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("reset");
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, c cVar) {
        return doWork((Params) baseParams, (c<? super Configuration>) cVar);
    }
}
