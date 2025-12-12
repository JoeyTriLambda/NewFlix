package org.adblockplus.libadblockplus;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class Filter {
    private WeakReference<FilterEngine> filterEngine;
    private final String raw;
    private final Type type;

    public enum Type {
        BLOCKING,
        EXCEPTION,
        ELEMHIDE,
        ELEMHIDE_EXCEPTION,
        ELEMHIDE_EMULATION,
        COMMENT,
        INVALID
    }

    private Filter(Type type, String str) {
        this.type = type;
        this.raw = str;
    }

    @Deprecated
    public void addToList() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine != null) {
            filterEngine.addFilter(this);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Filter.class != obj.getClass()) {
            return false;
        }
        Filter filter = (Filter) obj;
        return this.type == filter.type && this.raw.equals(filter.raw);
    }

    public String getRaw() {
        return this.raw;
    }

    public Type getType() {
        return this.type;
    }

    @Deprecated
    public boolean isListed() {
        FilterEngine filterEngine = this.filterEngine.get();
        return filterEngine != null && filterEngine.getListedFilters().contains(this);
    }

    @Deprecated
    public void removeFromList() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine != null) {
            filterEngine.removeFilter(this);
        }
    }

    public void setFilterEngine(FilterEngine filterEngine) {
        this.filterEngine = new WeakReference<>(filterEngine);
    }
}
