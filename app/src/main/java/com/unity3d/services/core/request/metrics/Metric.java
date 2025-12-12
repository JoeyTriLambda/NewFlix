package com.unity3d.services.core.request.metrics;

import java.util.Map;
import kotlin.collections.a;
import mf.x;
import zf.f;
import zf.i;

/* compiled from: Metric.kt */
/* loaded from: classes2.dex */
public final class Metric {
    public static final Companion Companion = new Companion(null);
    private static final String METRIC_NAME = "n";
    private static final String METRIC_TAGS = "t";
    private static final String METRIC_VALUE = "v";
    private final String name;
    private final Map<String, String> tags;
    private final Object value;

    /* compiled from: Metric.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Metric(String str) {
        this(str, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Metric copy$default(Metric metric, String str, Object obj, Map map, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            str = metric.name;
        }
        if ((i10 & 2) != 0) {
            obj = metric.value;
        }
        if ((i10 & 4) != 0) {
            map = metric.tags;
        }
        return metric.copy(str, obj, map);
    }

    public final String component1() {
        return this.name;
    }

    public final Object component2() {
        return this.value;
    }

    public final Map<String, String> component3() {
        return this.tags;
    }

    public final Metric copy(String str, Object obj, Map<String, String> map) {
        i.checkNotNullParameter(map, "tags");
        return new Metric(str, obj, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Metric)) {
            return false;
        }
        Metric metric = (Metric) obj;
        return i.areEqual(this.name, metric.name) && i.areEqual(this.value, metric.value) && i.areEqual(this.tags, metric.tags);
    }

    public final String getName() {
        return this.name;
    }

    public final Map<String, String> getTags() {
        return this.tags;
    }

    public final Object getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Object obj = this.value;
        return this.tags.hashCode() + ((iHashCode + (obj != null ? obj.hashCode() : 0)) * 31);
    }

    public final Map<String, Object> toMap() {
        Map mapCreateMapBuilder = x.createMapBuilder();
        String str = this.name;
        if (str != null) {
            mapCreateMapBuilder.put(METRIC_NAME, str);
        }
        Object obj = this.value;
        if (obj != null) {
            mapCreateMapBuilder.put(METRIC_VALUE, obj);
        }
        if (!this.tags.isEmpty()) {
            mapCreateMapBuilder.put(METRIC_TAGS, this.tags);
        }
        return x.build(mapCreateMapBuilder);
    }

    public String toString() {
        return "Metric(name=" + this.name + ", value=" + this.value + ", tags=" + this.tags + ')';
    }

    public Metric(String str, Object obj) {
        this(str, obj, null, 4, null);
    }

    public Metric(String str, Object obj, Map<String, String> map) {
        i.checkNotNullParameter(map, "tags");
        this.name = str;
        this.value = obj;
        this.tags = map;
    }

    public /* synthetic */ Metric(String str, Object obj, Map map, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? null : obj, (i10 & 4) != 0 ? a.emptyMap() : map);
    }
}
