package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.properties.InitializationStatusReader;
import ig.l;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import kg.e0;
import kg.g0;
import kg.h0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import mf.j;
import org.json.JSONObject;
import qf.c;
import rf.a;
import sf.d;
import yf.p;
import zf.i;
import zf.k;

/* compiled from: MetricSender.kt */
/* loaded from: classes2.dex */
public class MetricSender extends MetricSenderBase implements IServiceComponent {
    private final MetricCommonTags commonTags;
    private final ISDKDispatchers dispatchers;
    private final HttpClient httpClient;
    private final String metricEndPoint;
    private final String metricSampleRate;
    private final g0 scope;
    private final String sessionToken;

    /* compiled from: MetricSender.kt */
    @d(c = "com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1", f = "MetricSender.kt", l = {69}, m = "invokeSuspend")
    /* renamed from: com.unity3d.services.core.request.metrics.MetricSender$sendMetrics$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<g0, c<? super h>, Object> {
        final /* synthetic */ List<Metric> $metrics;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<Metric> list, c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$metrics = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return MetricSender.this.new AnonymousClass1(this.$metrics, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objExecute;
            Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
            int i10 = this.label;
            if (i10 == 0) {
                f.throwOnFailure(obj);
                String string = new JSONObject(new MetricsContainer(MetricSender.this.metricSampleRate, MetricSender.this.commonTags, this.$metrics, MetricSender.this.sessionToken).toMap()).toString();
                i.checkNotNullExpressionValue(string, "JSONObject(container.toMap()).toString()");
                String metricEndPoint = MetricSender.this.getMetricEndPoint();
                if (metricEndPoint == null) {
                    metricEndPoint = "";
                }
                HttpRequest httpRequest = new HttpRequest(metricEndPoint, null, RequestType.POST, string, null, null, null, null, null, 0, 0, 0, 0, 8178, null);
                HttpClient httpClient = MetricSender.this.httpClient;
                this.label = 1;
                objExecute = httpClient.execute(httpRequest, this);
                if (objExecute == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                f.throwOnFailure(obj);
                objExecute = obj;
            }
            HttpResponse httpResponse = (HttpResponse) objExecute;
            if (httpResponse.getStatusCode() / 100 == 2) {
                DeviceLog.debug("Metric " + this.$metrics + " sent to " + MetricSender.this.getMetricEndPoint());
            } else {
                DeviceLog.debug("Metric " + this.$metrics + " failed to send with response code: " + httpResponse.getStatusCode());
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass1) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender(Configuration configuration, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        i.checkNotNullParameter(configuration, "configuration");
        i.checkNotNullParameter(initializationStatusReader, "initializationStatusReader");
        MetricCommonTags metricCommonTags = new MetricCommonTags();
        metricCommonTags.updateWithConfig(configuration);
        this.commonTags = metricCommonTags;
        this.metricSampleRate = String.valueOf(bg.a.roundToInt(configuration.getMetricSampleRate()));
        this.sessionToken = configuration.getSessionToken();
        ServiceProvider serviceProvider = ServiceProvider.INSTANCE;
        ISDKDispatchers iSDKDispatchers = (ISDKDispatchers) serviceProvider.getRegistry().getService("", k.getOrCreateKotlinClass(ISDKDispatchers.class));
        this.dispatchers = iSDKDispatchers;
        this.httpClient = (HttpClient) serviceProvider.getRegistry().getService("", k.getOrCreateKotlinClass(HttpClient.class));
        this.scope = h0.CoroutineScope(iSDKDispatchers.getIo());
        this.metricEndPoint = configuration.getMetricsUrl();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public boolean areMetricsEnabledForCurrentSession() {
        return true;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public String getMetricEndPoint() {
        return this.metricEndPoint;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String str, String str2, Map<String, String> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(str, "event");
        i.checkNotNullParameter(map, "tags");
        if (!(str.length() == 0)) {
            sendMetrics(j.listOf(new Metric(str, str2, map)));
            return;
        }
        DeviceLog.debug("Metric event not sent due to being null or empty: " + str);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(Metric metric) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(metric, "metric");
        sendMetrics(j.listOf(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetrics(List<Metric> list) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(list, "metrics");
        if (list.isEmpty()) {
            DeviceLog.debug("Metrics event not send due to being empty");
            return;
        }
        String metricEndPoint = getMetricEndPoint();
        if (!(metricEndPoint == null || l.isBlank(metricEndPoint))) {
            int i10 = e0.f15105h;
            kg.h.launch$default(this.scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(e0.b.f15106b, list), null, new AnonymousClass1(list, null), 2, null);
            return;
        }
        DeviceLog.debug("Metrics: " + list + " was not sent to null or empty endpoint: " + getMetricEndPoint());
    }

    public final void shutdown() {
        this.commonTags.shutdown();
    }
}
