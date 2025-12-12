package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mf.l;
import mf.x;
import zf.f;
import zf.i;

/* compiled from: MetricsContainer.kt */
/* loaded from: classes2.dex */
public final class MetricsContainer {
    public static final Companion Companion = new Companion(null);
    private static final String METRICS_CONTAINER = "m";
    private static final String METRICS_CONTAINER_TAGS = "t";
    private static final String METRIC_CONTAINER_API_LEVEL = "apil";
    private static final String METRIC_CONTAINER_DEVICE_MAKE = "deviceMake";
    private static final String METRIC_CONTAINER_DEVICE_MODEL = "deviceModel";
    private static final String METRIC_CONTAINER_DEVICE_NAME = "deviceName";
    private static final String METRIC_CONTAINER_GAME_ID = "gameId";
    private static final String METRIC_CONTAINER_SAMPLE_RATE = "msr";
    private static final String METRIC_CONTAINER_SESSION_TOKEN = "sTkn";
    private static final String METRIC_CONTAINER_SHARED_SESSION_ID = "shSid";
    private final String apiLevel;
    private final MetricCommonTags commonTags;
    private final String deviceManufacturer;
    private final String deviceModel;
    private final String deviceName;
    private final String gameId;
    private final String metricSampleRate;
    private final List<Metric> metrics;
    private final String sTkn;
    private final String shSid;

    /* compiled from: MetricsContainer.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public MetricsContainer(String str, MetricCommonTags metricCommonTags, List<Metric> list, String str2) {
        i.checkNotNullParameter(str, "metricSampleRate");
        i.checkNotNullParameter(metricCommonTags, "commonTags");
        i.checkNotNullParameter(list, "metrics");
        this.metricSampleRate = str;
        this.commonTags = metricCommonTags;
        this.metrics = list;
        this.sTkn = str2;
        this.shSid = Session.Default.getId();
        this.apiLevel = String.valueOf(Device.getApiLevel());
        this.deviceModel = Device.getModel();
        this.deviceName = Device.getDevice();
        this.deviceManufacturer = Device.getManufacturer();
        this.gameId = ClientProperties.getGameId();
    }

    public final Map<String, Object> toMap() {
        List<Metric> list = this.metrics;
        ArrayList arrayList = new ArrayList(l.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Metric) it.next()).toMap());
        }
        Map mapCreateMapBuilder = x.createMapBuilder();
        mapCreateMapBuilder.put(METRIC_CONTAINER_SAMPLE_RATE, this.metricSampleRate);
        mapCreateMapBuilder.put(METRICS_CONTAINER, arrayList);
        mapCreateMapBuilder.put(METRICS_CONTAINER_TAGS, this.commonTags.toMap());
        mapCreateMapBuilder.put(METRIC_CONTAINER_SHARED_SESSION_ID, this.shSid);
        mapCreateMapBuilder.put(METRIC_CONTAINER_API_LEVEL, this.apiLevel);
        String str = this.sTkn;
        if (str != null) {
            mapCreateMapBuilder.put(METRIC_CONTAINER_SESSION_TOKEN, str);
        }
        String str2 = this.deviceModel;
        if (str2 != null) {
            i.checkNotNullExpressionValue(str2, METRIC_CONTAINER_DEVICE_MODEL);
            mapCreateMapBuilder.put(METRIC_CONTAINER_DEVICE_MODEL, str2);
        }
        String str3 = this.deviceName;
        if (str3 != null) {
            i.checkNotNullExpressionValue(str3, METRIC_CONTAINER_DEVICE_NAME);
            mapCreateMapBuilder.put(METRIC_CONTAINER_DEVICE_NAME, str3);
        }
        String str4 = this.deviceManufacturer;
        if (str4 != null) {
            i.checkNotNullExpressionValue(str4, "deviceManufacturer");
            mapCreateMapBuilder.put(METRIC_CONTAINER_DEVICE_MAKE, str4);
        }
        String str5 = this.gameId;
        if (str5 != null) {
            i.checkNotNullExpressionValue(str5, METRIC_CONTAINER_GAME_ID);
            mapCreateMapBuilder.put(METRIC_CONTAINER_GAME_ID, str5);
        }
        return x.build(mapCreateMapBuilder);
    }
}
