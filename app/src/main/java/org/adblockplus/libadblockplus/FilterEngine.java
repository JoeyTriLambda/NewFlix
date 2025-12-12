package org.adblockplus.libadblockplus;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class FilterEngine {
    public static final String EMPTY_PARENT = "";
    public static final String EMPTY_SITEKEY = "";
    protected final long ptr;

    public enum ContentType {
        OTHER,
        SCRIPT,
        IMAGE,
        STYLESHEET,
        OBJECT,
        SUBDOCUMENT,
        DOCUMENT,
        WEBSOCKET,
        WEBRTC,
        PING,
        XMLHTTPREQUEST,
        OBJECT_SUBREQUEST,
        MEDIA,
        FONT,
        GENERICBLOCK,
        ELEMHIDE,
        GENERICHIDE;

        public static Set<ContentType> maskOf(ContentType... contentTypeArr) {
            HashSet hashSet = new HashSet(contentTypeArr.length);
            for (ContentType contentType : contentTypeArr) {
                hashSet.add(contentType);
            }
            return hashSet;
        }
    }

    public static class EmulationSelector {
        public String selector;
        public String text;

        public EmulationSelector(String str, String str2) {
            this.selector = str;
            this.text = str2;
        }
    }

    static {
        System.loadLibrary(BuildConfig.nativeLibraryName);
        registerNatives();
    }

    public FilterEngine(long j10) {
        this.ptr = j10;
    }

    private static native void addFilter(long j10, String str);

    private static native void addSubscription(long j10, String str);

    private static native List<Subscription> fetchAvailableSubscriptions(long j10, FilterEngine filterEngine);

    private static native String getAcceptableAdsSubscriptionURL(long j10);

    private static native String getAllowedConnectionType(long j10);

    private static native List<EmulationSelector> getElementHidingEmulationSelectors(long j10, String str);

    private static native String getElementHidingStyleSheet(long j10, String str, boolean z10);

    private static native Filter getFilter(long j10, String str);

    private static native String getHostFromURL(long j10, String str);

    private static native List<Filter> getListedFilters(long j10);

    private static native List<Subscription> getListedSubscriptions(long j10, FilterEngine filterEngine);

    private static native long getNativePtr(long j10);

    private static native JsValue getPref(long j10, String str);

    private static native Subscription getSubscription(long j10, String str, FilterEngine filterEngine);

    private static native boolean isAcceptableAdsEnabled(long j10);

    private static native boolean isContentAllowlisted(long j10, String str, ContentType[] contentTypeArr, List<String> list, String str2);

    private static native boolean isDocumentAllowlisted(long j10, String str, List<String> list, String str2);

    private static native boolean isElemhideAllowlisted(long j10, String str, List<String> list, String str2);

    private static native boolean isEnabled(long j10);

    private static native boolean isGenericblockAllowlisted(long j10, String str, List<String> list, String str2);

    private static native Filter matches(long j10, String str, ContentType[] contentTypeArr, String str2, String str3, boolean z10);

    private static native Filter matches(long j10, String str, ContentType[] contentTypeArr, List<String> list, String str2, boolean z10);

    private static native void registerNatives();

    private static native void removeFilter(long j10, String str);

    private static native void removeFilterChangeCallback(long j10);

    private static native void removeSubscription(long j10, String str);

    private static native void setAcceptableAdsEnabled(long j10, boolean z10);

    private static native void setAllowedConnectionType(long j10, String str);

    private static native void setEnabled(long j10, boolean z10);

    private static native void setFilterChangeCallback(long j10, long j11);

    private static native void setPref(long j10, String str, long j11);

    private static native void updateFiltersAsync(long j10, String str);

    public void addFilter(Filter filter) {
        addFilter(this.ptr, filter.getRaw());
    }

    public void addSubscription(Subscription subscription) {
        addSubscription(this.ptr, subscription.getUrl());
    }

    public List<Subscription> fetchAvailableSubscriptions() {
        return fetchAvailableSubscriptions(this.ptr, this);
    }

    public String getAcceptableAdsSubscriptionURL() {
        return getAcceptableAdsSubscriptionURL(this.ptr);
    }

    public String getAllowedConnectionType() {
        return getAllowedConnectionType(this.ptr);
    }

    public List<EmulationSelector> getElementHidingEmulationSelectors(String str) {
        return getElementHidingEmulationSelectors(this.ptr, str);
    }

    public String getElementHidingStyleSheet(String str) {
        return getElementHidingStyleSheet(str, false);
    }

    public Filter getFilter(String str) {
        Filter filter = getFilter(this.ptr, str);
        if (filter != null) {
            filter.setFilterEngine(this);
        }
        return filter;
    }

    public String getHostFromURL(String str) {
        return getHostFromURL(this.ptr, str);
    }

    public List<Filter> getListedFilters() {
        List<Filter> listedFilters = getListedFilters(this.ptr);
        Iterator<Filter> it = listedFilters.iterator();
        while (it.hasNext()) {
            it.next().setFilterEngine(this);
        }
        return listedFilters;
    }

    public List<Subscription> getListedSubscriptions() {
        return getListedSubscriptions(this.ptr, this);
    }

    public long getNativePtr() {
        return getNativePtr(this.ptr);
    }

    public JsValue getPref(String str) {
        return getPref(this.ptr, str);
    }

    public Subscription getSubscription(String str) {
        return getSubscription(this.ptr, str, this);
    }

    public boolean isAcceptableAdsEnabled() {
        return isAcceptableAdsEnabled(this.ptr);
    }

    public boolean isContentAllowlisted(String str, Set<ContentType> set, List<String> list, String str2) {
        return isContentAllowlisted(this.ptr, str, (ContentType[]) set.toArray(new ContentType[set.size()]), list, str2);
    }

    @Deprecated
    public boolean isDocumentAllowlisted(String str, List<String> list, String str2) {
        return isDocumentAllowlisted(this.ptr, str, list, str2);
    }

    @Deprecated
    public boolean isElemhideAllowlisted(String str, List<String> list, String str2) {
        return isElemhideAllowlisted(this.ptr, str, list, str2);
    }

    public boolean isEnabled() {
        return isEnabled(this.ptr);
    }

    @Deprecated
    public boolean isGenericblockAllowlisted(String str, List<String> list, String str2) {
        return isGenericblockAllowlisted(this.ptr, str, list, str2);
    }

    @Deprecated
    public Filter matches(String str, Set<ContentType> set, List<String> list, String str2) {
        Filter filterMatches = matches(this.ptr, str, (ContentType[]) set.toArray(new ContentType[set.size()]), list, str2, false);
        if (filterMatches != null) {
            filterMatches.setFilterEngine(this);
        }
        return filterMatches;
    }

    public void removeFilter(Filter filter) {
        removeFilter(this.ptr, filter.getRaw());
    }

    public void removeFilterChangeCallback() {
        removeFilterChangeCallback(this.ptr);
    }

    public void removeSubscription(Subscription subscription) {
        removeSubscription(this.ptr, subscription.getUrl());
    }

    public void setAcceptableAdsEnabled(boolean z10) {
        setAcceptableAdsEnabled(this.ptr, z10);
    }

    public void setAllowedConnectionType(String str) {
        setAllowedConnectionType(this.ptr, str);
    }

    public void setEnabled(boolean z10) {
        setEnabled(this.ptr, z10);
    }

    public void setFilterChangeCallback(FilterChangeCallback filterChangeCallback) {
        setFilterChangeCallback(this.ptr, filterChangeCallback.ptr);
    }

    public void setPref(String str, JsValue jsValue) {
        setPref(this.ptr, str, jsValue.ptr);
    }

    public void updateFiltersAsync(String str) {
        updateFiltersAsync(this.ptr, str);
    }

    public String getElementHidingStyleSheet(String str, boolean z10) {
        return getElementHidingStyleSheet(this.ptr, str, z10);
    }

    @Deprecated
    public Filter matches(String str, Set<ContentType> set, List<String> list, String str2, boolean z10) {
        Filter filterMatches = matches(this.ptr, str, (ContentType[]) set.toArray(new ContentType[set.size()]), list, str2, z10);
        if (filterMatches != null) {
            filterMatches.setFilterEngine(this);
        }
        return filterMatches;
    }

    public Filter matches(String str, Set<ContentType> set, String str2, String str3, boolean z10) {
        Filter filterMatches = matches(this.ptr, str, (ContentType[]) set.toArray(new ContentType[set.size()]), str2, str3, z10);
        if (filterMatches != null) {
            filterMatches.setFilterEngine(this);
        }
        return filterMatches;
    }
}
