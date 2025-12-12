package com.unity3d.services.core.request.metrics;

import java.util.List;
import java.util.Map;
import kotlin.collections.a;
import zf.i;

/* compiled from: SDKMetricsSender.kt */
/* loaded from: classes2.dex */
public interface SDKMetricsSender {

    /* compiled from: SDKMetricsSender.kt */
    public static final class DefaultImpls {
        public static void sendEvent(SDKMetricsSender sDKMetricsSender, String str) {
            i.checkNotNullParameter(str, "event");
            sendEvent$default(sDKMetricsSender, str, null, null, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendEvent$default(SDKMetricsSender sDKMetricsSender, String str, String str2, Map map, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                map = a.emptyMap();
            }
            sDKMetricsSender.sendEvent(str, str2, map);
        }
    }

    boolean areMetricsEnabledForCurrentSession();

    String getMetricEndPoint();

    void sendEvent(String str);

    void sendEvent(String str, String str2, Map<String, String> map);

    void sendMetric(Metric metric);

    void sendMetricWithInitState(Metric metric);

    void sendMetrics(List<Metric> list);
}
