package com.unity3d.services;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kg.e0;
import kotlin.coroutines.CoroutineContext;
import yf.p;
import zf.i;

/* compiled from: SDKErrorHandler.kt */
/* loaded from: classes2.dex */
public final class SDKErrorHandler implements e0 {
    private final ISDKDispatchers dispatchers;
    private final e0.b key;
    private final SDKMetricsSender sdkMetricsSender;

    public SDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        i.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        i.checkNotNullParameter(sDKMetricsSender, "sdkMetricsSender");
        this.dispatchers = iSDKDispatchers;
        this.sdkMetricsSender = sDKMetricsSender;
        this.key = e0.b.f15106b;
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, p<? super R, ? super CoroutineContext.a, ? extends R> pVar) {
        return (R) e0.a.fold(this, r10, pVar);
    }

    @Override // kotlin.coroutines.CoroutineContext.a, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.a> E get(CoroutineContext.b<E> bVar) {
        return (E) e0.a.get(this, bVar);
    }

    @Override // kg.e0
    public void handleException(CoroutineContext coroutineContext, Throwable th2) {
        i.checkNotNullParameter(coroutineContext, "context");
        i.checkNotNullParameter(th2, "exception");
        String fileName = th2.getStackTrace()[0].getFileName();
        i.checkNotNullExpressionValue(fileName, "exception.stackTrace[0].fileName");
        int lineNumber = th2.getStackTrace()[0].getLineNumber();
        sendMetric(new Metric(th2 instanceof NullPointerException ? "native_exception_npe" : th2 instanceof OutOfMemoryError ? "native_exception_oom" : th2 instanceof IllegalStateException ? "native_exception_ise" : th2 instanceof RuntimeException ? "native_exception_re" : th2 instanceof SecurityException ? "native_exception_se" : "native_exception", "{" + fileName + "}_" + lineNumber, null, 4, null));
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.b<?> bVar) {
        return e0.a.minusKey(this, bVar);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return e0.a.plus(this, coroutineContext);
    }

    @Override // kotlin.coroutines.CoroutineContext.a
    public e0.b getKey() {
        return this.key;
    }
}
