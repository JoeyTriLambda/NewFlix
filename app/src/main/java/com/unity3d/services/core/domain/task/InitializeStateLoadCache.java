package com.unity3d.services.core.domain.task;

import ac.c;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import kg.g0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.h;
import rf.a;
import sf.d;
import yf.p;
import zf.f;
import zf.i;

/* compiled from: InitializeStateLoadCache.kt */
/* loaded from: classes2.dex */
public final class InitializeStateLoadCache extends MetricTask<Params, LoadCacheResult> {
    private final ISDKDispatchers dispatchers;

    /* compiled from: InitializeStateLoadCache.kt */
    public static final class LoadCacheResult {
        private final boolean hasHashMismatch;
        private final String webViewData;

        public LoadCacheResult(boolean z10, String str) {
            this.hasHashMismatch = z10;
            this.webViewData = str;
        }

        public static /* synthetic */ LoadCacheResult copy$default(LoadCacheResult loadCacheResult, boolean z10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = loadCacheResult.hasHashMismatch;
            }
            if ((i10 & 2) != 0) {
                str = loadCacheResult.webViewData;
            }
            return loadCacheResult.copy(z10, str);
        }

        public final boolean component1() {
            return this.hasHashMismatch;
        }

        public final String component2() {
            return this.webViewData;
        }

        public final LoadCacheResult copy(boolean z10, String str) {
            return new LoadCacheResult(z10, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadCacheResult)) {
                return false;
            }
            LoadCacheResult loadCacheResult = (LoadCacheResult) obj;
            return this.hasHashMismatch == loadCacheResult.hasHashMismatch && i.areEqual(this.webViewData, loadCacheResult.webViewData);
        }

        public final boolean getHasHashMismatch() {
            return this.hasHashMismatch;
        }

        public final String getWebViewData() {
            return this.webViewData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z10 = this.hasHashMismatch;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            String str = this.webViewData;
            return i10 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("LoadCacheResult(hasHashMismatch=");
            sb2.append(this.hasHashMismatch);
            sb2.append(", webViewData=");
            return c.n(sb2, this.webViewData, ')');
        }

        public /* synthetic */ LoadCacheResult(boolean z10, String str, int i10, f fVar) {
            this(z10, (i10 & 2) != 0 ? null : str);
        }
    }

    /* compiled from: InitializeStateLoadCache.kt */
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

    /* compiled from: InitializeStateLoadCache.kt */
    @d(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", f = "InitializeStateLoadCache.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, qf.c<? super LoadCacheResult>, Object> {
        final /* synthetic */ Params $params;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Params params, qf.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$params = params;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final qf.c<h> create(Object obj, qf.c<?> cVar) {
            return InitializeStateLoadCache.this.new AnonymousClass2(this.$params, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lf.f.throwOnFailure(obj);
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            byte[] webViewData = InitializeStateLoadCache.this.getWebViewData();
            boolean z10 = true;
            if (webViewData == null) {
                return new LoadCacheResult(z10, null, 2, 0 == true ? 1 : 0);
            }
            String strSha256 = Utilities.Sha256(webViewData);
            Charset charsetForName = Charset.forName("UTF-8");
            i.checkNotNullExpressionValue(charsetForName, "forName(\"UTF-8\")");
            String str = new String(webViewData, charsetForName);
            if (strSha256 != null && i.areEqual(strSha256, this.$params.getConfig().getWebViewHash())) {
                z10 = false;
            }
            if (!z10) {
                DeviceLog.info("Unity Ads init: webapp loaded from local cache");
            }
            return new LoadCacheResult(z10, str);
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, qf.c<? super LoadCacheResult> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    public InitializeStateLoadCache(ISDKDispatchers iSDKDispatchers) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] getWebViewData() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            return Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
        } catch (Exception e10) {
            DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e10.getMessage());
            return null;
        }
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    public /* bridge */ /* synthetic */ Object doWork(BaseParams baseParams, qf.c cVar) {
        return doWork((Params) baseParams, (qf.c<? super LoadCacheResult>) cVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_webview");
    }

    public Object doWork(Params params, qf.c<? super LoadCacheResult> cVar) {
        return kg.f.withContext(this.dispatchers.getDefault(), new AnonymousClass2(params, null), cVar);
    }
}
