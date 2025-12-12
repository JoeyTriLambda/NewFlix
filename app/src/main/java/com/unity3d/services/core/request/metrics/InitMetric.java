package com.unity3d.services.core.request.metrics;

/* loaded from: classes2.dex */
public class InitMetric {
    private static final String INIT_METRIC_DIFF_PARAMS = "native_init_diff_params";
    private static final String INIT_METRIC_SAME_PARAMS = "native_init_same_params";

    public static Metric newInitDiffParams() {
        return new Metric(INIT_METRIC_DIFF_PARAMS, null);
    }

    public static Metric newInitSameParams() {
        return new Metric(INIT_METRIC_SAME_PARAMS, null);
    }
}
