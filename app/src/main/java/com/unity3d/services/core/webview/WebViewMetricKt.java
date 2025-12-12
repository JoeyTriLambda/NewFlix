package com.unity3d.services.core.webview;

import com.unity3d.services.core.request.metrics.Metric;

/* compiled from: WebViewMetric.kt */
/* loaded from: classes2.dex */
public final class WebViewMetricKt {
    public static final Metric webMessageListenerDisabledMetric() {
        return new Metric("web_message_listener_disabled", null, null, 6, null);
    }

    public static final Metric webMessageListenerEnabledMetric() {
        return new Metric("web_message_listener_enabled", null, null, 6, null);
    }

    public static final Metric webMessageListenerSupportedMetric() {
        return new Metric("web_message_listener_supported", null, null, 6, null);
    }

    public static final Metric webMessageListenerUnsupportedMetric() {
        return new Metric("web_message_listener_unsupported", null, null, 6, null);
    }
}
