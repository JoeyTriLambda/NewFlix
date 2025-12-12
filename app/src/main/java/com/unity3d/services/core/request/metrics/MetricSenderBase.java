package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.properties.InitializationStatusReader;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.collections.a;
import lf.g;
import mf.x;
import zf.i;

/* compiled from: MetricSenderBase.kt */
/* loaded from: classes2.dex */
public abstract class MetricSenderBase implements SDKMetricsSender {
    private final InitializationStatusReader _initStatusReader;

    public MetricSenderBase(InitializationStatusReader initializationStatusReader) {
        i.checkNotNullParameter(initializationStatusReader, "_initStatusReader");
        this._initStatusReader = initializationStatusReader;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(String str) {
        SDKMetricsSender.DefaultImpls.sendEvent(this, str);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetricWithInitState(Metric metric) {
        i.checkNotNullParameter(metric, "metric");
        sendMetric(Metric.copy$default(metric, null, null, a.plus(metric.getTags(), x.mapOf(g.to(AdOperationMetric.INIT_STATE, this._initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState())))), 3, null));
    }
}
