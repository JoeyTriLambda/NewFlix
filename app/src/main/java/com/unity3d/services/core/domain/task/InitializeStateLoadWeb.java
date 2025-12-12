package com.unity3d.services.core.domain.task;

import ac.c;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import kg.f;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import sf.d;
import yf.p;
import zf.i;

/* compiled from: InitializeStateLoadWeb.kt */
/* loaded from: classes2.dex */
public final class InitializeStateLoadWeb extends MetricTask<Params, LoadWebResult> {
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final InitializeStateNetworkError initializeStateNetworkError;

    /* compiled from: InitializeStateLoadWeb.kt */
    public static final class LoadWebResult {
        private final Configuration config;
        private final String webViewDataString;

        public LoadWebResult(Configuration configuration, String str) {
            i.checkNotNullParameter(configuration, "config");
            i.checkNotNullParameter(str, "webViewDataString");
            this.config = configuration;
            this.webViewDataString = str;
        }

        public static /* synthetic */ LoadWebResult copy$default(LoadWebResult loadWebResult, Configuration configuration, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                configuration = loadWebResult.config;
            }
            if ((i10 & 2) != 0) {
                str = loadWebResult.webViewDataString;
            }
            return loadWebResult.copy(configuration, str);
        }

        public final Configuration component1() {
            return this.config;
        }

        public final String component2() {
            return this.webViewDataString;
        }

        public final LoadWebResult copy(Configuration configuration, String str) {
            i.checkNotNullParameter(configuration, "config");
            i.checkNotNullParameter(str, "webViewDataString");
            return new LoadWebResult(configuration, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadWebResult)) {
                return false;
            }
            LoadWebResult loadWebResult = (LoadWebResult) obj;
            return i.areEqual(this.config, loadWebResult.config) && i.areEqual(this.webViewDataString, loadWebResult.webViewDataString);
        }

        public final Configuration getConfig() {
            return this.config;
        }

        public final String getWebViewDataString() {
            return this.webViewDataString;
        }

        public int hashCode() {
            return this.webViewDataString.hashCode() + (this.config.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("LoadWebResult(config=");
            sb2.append(this.config);
            sb2.append(", webViewDataString=");
            return c.n(sb2, this.webViewDataString, ')');
        }
    }

    /* compiled from: InitializeStateLoadWeb.kt */
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

    /* compiled from: InitializeStateLoadWeb.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", l = {42, 59, 61}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, qf.c<? super LoadWebResult>, Object> {
        final /* synthetic */ Params $params;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ InitializeStateLoadWeb this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, InitializeStateLoadWeb initializeStateLoadWeb, qf.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
            this.this$0 = initializeStateLoadWeb;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<h> create(Object obj, qf.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$params, this.this$0, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0153  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0168  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0181  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x01a3  */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v18 */
        /* JADX WARN: Type inference failed for: r1v23 */
        /* JADX WARN: Type inference failed for: r1v24 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r31) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 443
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadWeb.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, qf.c<? super LoadWebResult> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateLoadWeb(ISDKDispatchers iSDKDispatchers, InitializeStateNetworkError initializeStateNetworkError, HttpClient httpClient) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(initializeStateNetworkError, "initializeStateNetworkError");
        i.checkNotNullParameter(httpClient, "httpClient");
        this.dispatchers = iSDKDispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.httpClient = httpClient;
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, qf.c cVar) {
        return doWork((Params) baseParams, (qf.c<? super LoadWebResult>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("download_web_view");
    }

    public Object doWork(Params params, qf.c<? super LoadWebResult> cVar) {
        return f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, this, null), cVar);
    }
}
