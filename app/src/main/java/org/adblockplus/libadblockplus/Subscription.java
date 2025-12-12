package org.adblockplus.libadblockplus;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class Subscription {
    private final String author;
    protected final WeakReference<FilterEngine> filterEngine;
    private final String homepage;
    private final String languages;
    private final String title;
    protected final String url;

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    private Subscription(String str, String str2, String str3, String str4, String str5, FilterEngine filterEngine) {
        this.url = str;
        this.title = str2;
        this.homepage = str3;
        this.author = str4;
        this.languages = str5;
        this.filterEngine = new WeakReference<>(filterEngine);
    }

    private static native String getSynchronizationStatus(long j10, String str);

    private static native boolean isAcceptableAds(long j10, String str);

    private static native boolean isDisabled(long j10, String str);

    private static native boolean isUpdating(long j10, String str);

    private static native void registerNatives();

    private static native void setDisabled(long j10, boolean z10, String str);

    private static native void updateFilters(long j10, String str);

    public void addToList() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return;
        }
        filterEngine.addSubscription(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Subscription) {
            return this.url.equals(((Subscription) obj).url);
        }
        return false;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getHomepage() {
        return this.homepage;
    }

    public String getLanguages() {
        return this.languages;
    }

    public String getSynchronizationStatus() {
        FilterEngine filterEngine = this.filterEngine.get();
        return filterEngine == null ? "Filter Engine destroyed" : getSynchronizationStatus(filterEngine.getNativePtr(), this.url);
    }

    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public boolean isAcceptableAds() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return false;
        }
        return isAcceptableAds(filterEngine.getNativePtr(), this.url);
    }

    public boolean isDisabled() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return true;
        }
        return isDisabled(filterEngine.getNativePtr(), this.url);
    }

    public boolean isListed() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return false;
        }
        return filterEngine.getListedSubscriptions().contains(this);
    }

    public boolean isUpdating() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return false;
        }
        return isUpdating(filterEngine.getNativePtr(), this.url);
    }

    public void removeFromList() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return;
        }
        filterEngine.removeSubscription(this);
    }

    public void setDisabled(boolean z10) {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return;
        }
        setDisabled(filterEngine.getNativePtr(), z10, this.url);
    }

    public void updateFilters() {
        FilterEngine filterEngine = this.filterEngine.get();
        if (filterEngine == null) {
            return;
        }
        updateFilters(filterEngine.getNativePtr(), this.url);
    }
}
