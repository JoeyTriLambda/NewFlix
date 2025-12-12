package com.unity3d.services.core.request.metrics;

import android.text.TextUtils;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import mf.j;
import mf.k;
import zf.i;

/* compiled from: MetricSenderWithBatch.kt */
/* loaded from: classes2.dex */
public final class MetricSenderWithBatch extends MetricSenderBase {
    private SDKMetricsSender _original;
    private final LinkedBlockingQueue<Metric> _queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSenderWithBatch(SDKMetricsSender sDKMetricsSender, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        i.checkNotNullParameter(sDKMetricsSender, "_original");
        i.checkNotNullParameter(initializationStatusReader, "initializationStatusReader");
        this._original = sDKMetricsSender;
        this._queue = new LinkedBlockingQueue<>();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public boolean areMetricsEnabledForCurrentSession() {
        return this._original.areMetricsEnabledForCurrentSession();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public String getMetricEndPoint() {
        return this._original.getMetricEndPoint();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String str, String str2, Map<String, String> map) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(str, "event");
        i.checkNotNullParameter(map, "tags");
        if (!(str.length() == 0)) {
            sendMetrics(j.listOf(new Metric(str, str2, map)));
            return;
        }
        DeviceLog.debug("Metric event not sent due to being empty: " + str);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(Metric metric) {
        i.checkNotNullParameter(metric, "metric");
        sendMetrics(j.listOf(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public synchronized void sendMetrics(List<Metric> list) {
        i.checkNotNullParameter(list, "metrics");
        this._queue.addAll(list);
        if (!TextUtils.isEmpty(this._original.getMetricEndPoint()) && this._queue.size() > 0) {
            ArrayList arrayList = new ArrayList();
            this._queue.drainTo(arrayList);
            this._original.sendMetrics(arrayList);
        }
    }

    public final void sendQueueIfNeeded() {
        sendMetrics(k.emptyList());
    }

    public final void updateOriginal(SDKMetricsSender sDKMetricsSender) {
        i.checkNotNullParameter(sDKMetricsSender, "metrics");
        this._original = sDKMetricsSender;
    }
}
