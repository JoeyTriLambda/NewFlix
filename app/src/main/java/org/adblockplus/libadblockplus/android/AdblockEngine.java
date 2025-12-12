package org.adblockplus.libadblockplus.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import bi.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.adblockplus.libadblockplus.AppInfo;
import org.adblockplus.libadblockplus.FileSystem;
import org.adblockplus.libadblockplus.Filter;
import org.adblockplus.libadblockplus.FilterChangeCallback;
import org.adblockplus.libadblockplus.FilterEngine;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.IsAllowedConnectionCallback;
import org.adblockplus.libadblockplus.JsValue;
import org.adblockplus.libadblockplus.LogSystem;
import org.adblockplus.libadblockplus.Platform;
import org.adblockplus.libadblockplus.android.AndroidHttpClientResourceWrapper;

/* loaded from: classes2.dex */
public final class AdblockEngine {
    public static final String BASE_PATH_DIRECTORY = "adblock";
    private volatile FileSystem fileSystem;
    private volatile FilterChangeCallback filterChangeCallback;
    private volatile FilterEngine filterEngine;
    private volatile HttpClient httpClient;
    private volatile LogSystem logSystem;
    private volatile Platform platform;
    private volatile boolean elemhideEnabled = true;
    private volatile boolean enabled = true;
    private final Set<SettingsChangedListener> settingsChangedListeners = new HashSet();

    public static class Builder implements Factory {
        private HttpClient androidHttpClient;
        private final AppInfo appInfo;
        private final String basePath;
        private Context context;
        private final AdblockEngine engine;
        private IsAllowedConnectionCallback isAllowedConnectionCallback;
        private AndroidHttpClientResourceWrapper.Storage resourceStorage;
        private Map<String, Integer> urlToResourceIdMap;
        private Long v8IsolateProviderPtr;
        private boolean forceUpdatePreloadedSubscriptions = true;
        private boolean enabledByDefault = true;

        public Builder(Context context, AppInfo appInfo, String str) {
            AdblockEngine adblockEngine = new AdblockEngine();
            this.engine = adblockEngine;
            adblockEngine.elemhideEnabled = true;
            this.context = context;
            this.appInfo = appInfo;
            this.basePath = str;
        }

        private void createEngines() {
            this.engine.logSystem = new TimberLogSystem();
            this.engine.fileSystem = null;
            this.engine.platform = new Platform(this.engine.logSystem, this.engine.fileSystem, this.engine.httpClient, this.basePath);
            if (this.v8IsolateProviderPtr != null) {
                this.engine.platform.setUpJsEngine(this.appInfo, this.v8IsolateProviderPtr.longValue());
            } else {
                this.engine.platform.setUpJsEngine(this.appInfo);
            }
            this.engine.platform.setUpFilterEngine(this.isAllowedConnectionCallback, this.enabledByDefault);
            this.engine.enabled = this.enabledByDefault;
            AdblockEngine adblockEngine = this.engine;
            adblockEngine.filterEngine = adblockEngine.platform.getFilterEngine();
        }

        private void initCallbacks() {
            if (this.engine.filterChangeCallback != null) {
                this.engine.filterEngine.setFilterChangeCallback(this.engine.filterChangeCallback);
            }
        }

        private void initRequests() {
            if (this.androidHttpClient == null) {
                this.androidHttpClient = new AndroidHttpClient(true);
            }
            this.engine.httpClient = this.androidHttpClient;
            if (this.urlToResourceIdMap != null) {
                AndroidHttpClientResourceWrapper androidHttpClientResourceWrapper = new AndroidHttpClientResourceWrapper(this.context, this.engine.httpClient, this.urlToResourceIdMap, this.resourceStorage);
                if (this.forceUpdatePreloadedSubscriptions) {
                    androidHttpClientResourceWrapper.setListener(new AndroidHttpClientResourceWrapper.Listener() { // from class: org.adblockplus.libadblockplus.android.AdblockEngine.Builder.1
                        @Override // org.adblockplus.libadblockplus.android.AndroidHttpClientResourceWrapper.Listener
                        public void onIntercepted(String str, int i10) {
                            a.d("Force subscription update for intercepted URL %s", str);
                            if (Builder.this.engine.filterEngine != null) {
                                Builder.this.engine.filterEngine.updateFiltersAsync(str);
                            }
                        }
                    });
                }
                this.engine.httpClient = androidHttpClientResourceWrapper;
            }
        }

        @Override // org.adblockplus.libadblockplus.android.AdblockEngine.Factory
        public AdblockEngine build() {
            initRequests();
            createEngines();
            initCallbacks();
            return this.engine;
        }

        public Builder enableElementHiding(boolean z10) {
            this.engine.elemhideEnabled = z10;
            return this;
        }

        public boolean getDisableByDefault() {
            return !this.enabledByDefault;
        }

        public Builder preloadSubscriptions(Context context, Map<String, Integer> map, AndroidHttpClientResourceWrapper.Storage storage) {
            this.context = context;
            this.urlToResourceIdMap = map;
            this.resourceStorage = storage;
            return this;
        }

        public Builder setDisableByDefault() {
            this.enabledByDefault = false;
            return this;
        }

        public Builder setFilterChangeCallback(FilterChangeCallback filterChangeCallback) {
            this.engine.filterChangeCallback = filterChangeCallback;
            return this;
        }

        public Builder setForceUpdatePreloadedSubscriptions(boolean z10) {
            this.forceUpdatePreloadedSubscriptions = z10;
            return this;
        }

        public Builder setHttpClient(HttpClient httpClient) {
            this.androidHttpClient = httpClient;
            return this;
        }

        public Builder setIsAllowedConnectionCallback(IsAllowedConnectionCallback isAllowedConnectionCallback) {
            this.isAllowedConnectionCallback = isAllowedConnectionCallback;
            return this;
        }

        public Builder useV8IsolateProvider(long j10) {
            this.v8IsolateProviderPtr = Long.valueOf(j10);
            return this;
        }
    }

    public interface Factory {
        AdblockEngine build();
    }

    public enum MatchesResult {
        BLOCKED,
        ALLOWLISTED,
        NOT_FOUND,
        NOT_ENABLED
    }

    public interface SettingsChangedListener {
        void onEnableStateChanged(boolean z10);
    }

    public static Builder builder(Context context, AppInfo appInfo, String str) {
        return new Builder(context, appInfo, str);
    }

    private static Subscription convertJsSubscription(org.adblockplus.libadblockplus.Subscription subscription) {
        return new Subscription(subscription.getTitle(), subscription.getUrl(), subscription.getLanguages(), subscription.getHomepage(), subscription.getAuthor());
    }

    private static Subscription[] convertJsSubscriptions(List<org.adblockplus.libadblockplus.Subscription> list) {
        int size = list.size();
        Subscription[] subscriptionArr = new Subscription[size];
        for (int i10 = 0; i10 < size; i10++) {
            subscriptionArr[i10] = convertJsSubscription(list.get(i10));
        }
        return subscriptionArr;
    }

    public static AppInfo generateAppInfo(Context context, String str, String str2) {
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        String strReplace = Locale.getDefault().toString().replace('_', '-');
        if (strReplace.startsWith("iw-")) {
            strReplace = "he" + strReplace.substring(2);
        }
        AppInfo.Builder locale = AppInfo.builder().setApplicationVersion(strValueOf).setLocale(strReplace);
        if (str != null) {
            locale.setApplication(str);
        }
        if (str2 != null) {
            locale.setApplicationVersion(str2);
        }
        return locale.build();
    }

    public void addDomainAllowlistingFilter(String str) {
        this.filterEngine.addFilter(Utils.createDomainAllowlistingFilter(this.filterEngine, str));
    }

    public void addDomainWhitelistingFilter(String str) {
        this.filterEngine.addFilter(Utils.createDomainAllowlistingFilter(this.filterEngine, str));
    }

    public synchronized AdblockEngine addSettingsChangedListener(SettingsChangedListener settingsChangedListener) {
        if (settingsChangedListener == null) {
            throw new IllegalArgumentException("SettingsChangedListener cannot be null");
        }
        this.settingsChangedListeners.add(settingsChangedListener);
        return this;
    }

    public void clearSubscriptions() {
        Iterator<org.adblockplus.libadblockplus.Subscription> it = this.filterEngine.getListedSubscriptions().iterator();
        while (it.hasNext()) {
            it.next().removeFromList();
        }
    }

    public void dispose() {
        a.w("Dispose", new Object[0]);
        if (this.filterEngine != null) {
            if (this.filterChangeCallback != null) {
                this.filterEngine.removeFilterChangeCallback();
            }
            this.platform.dispose();
            this.platform = null;
        }
        if (this.filterChangeCallback != null) {
            this.filterChangeCallback.dispose();
            this.filterChangeCallback = null;
        }
    }

    public String getAcceptableAdsSubscriptionURL() {
        return this.filterEngine.getAcceptableAdsSubscriptionURL();
    }

    public String getDocumentationLink() {
        JsValue pref = this.filterEngine.getPref("documentation_link");
        try {
            return pref.toString();
        } finally {
            pref.dispose();
        }
    }

    public List<FilterEngine.EmulationSelector> getElementHidingEmulationSelectors(String str, String str2, List<String> list, String str3) {
        return (!this.enabled || !this.elemhideEnabled || isContentAllowlisted(str, FilterEngine.ContentType.maskOf(FilterEngine.ContentType.DOCUMENT), list, str3) || isContentAllowlisted(str, FilterEngine.ContentType.maskOf(FilterEngine.ContentType.ELEMHIDE), list, str3)) ? new ArrayList() : this.filterEngine.getElementHidingEmulationSelectors(str2);
    }

    public String getElementHidingStyleSheet(String str, String str2, List<String> list, String str3, boolean z10) {
        return (!this.enabled || !this.elemhideEnabled || isContentAllowlisted(str, FilterEngine.ContentType.maskOf(FilterEngine.ContentType.DOCUMENT), list, str3) || isContentAllowlisted(str, FilterEngine.ContentType.maskOf(FilterEngine.ContentType.ELEMHIDE), list, str3)) ? "" : this.filterEngine.getElementHidingStyleSheet(str2, z10);
    }

    public FilterEngine getFilterEngine() {
        return this.filterEngine;
    }

    public Subscription[] getListedSubscriptions() {
        return convertJsSubscriptions(this.filterEngine.getListedSubscriptions());
    }

    public Subscription[] getRecommendedSubscriptions() {
        return convertJsSubscriptions(this.filterEngine.fetchAvailableSubscriptions());
    }

    public void initAllowlistedDomains(List<String> list) {
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                addDomainAllowlistingFilter(it.next());
            }
        }
    }

    public boolean isAcceptableAdsEnabled() {
        return this.filterEngine.isAcceptableAdsEnabled();
    }

    public boolean isContentAllowlisted(String str, Set<FilterEngine.ContentType> set, List<String> list, String str2) {
        return this.filterEngine.isContentAllowlisted(str, set, list, str2);
    }

    public boolean isElemhideEnabled() {
        return this.elemhideEnabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public MatchesResult matches(String str, Set<FilterEngine.ContentType> set, String str2, String str3, boolean z10) {
        if (!this.enabled) {
            return MatchesResult.NOT_ENABLED;
        }
        Filter filterMatches = this.filterEngine.matches(str, set, str2, str3, z10);
        if (filterMatches == null) {
            return MatchesResult.NOT_FOUND;
        }
        a.d("Found filter `%s` for url `%s`", filterMatches.getRaw(), str);
        return filterMatches.getType() == Filter.Type.BLOCKING ? MatchesResult.BLOCKED : MatchesResult.NOT_FOUND;
    }

    public void onLowMemory() {
        if (this.platform == null || this.platform.getJsEngine() == null) {
            return;
        }
        this.platform.getJsEngine().onLowMemory();
    }

    public void removeDomainAllowlistingFilter(String str) {
        this.filterEngine.removeFilter(Utils.createDomainAllowlistingFilter(this.filterEngine, str));
    }

    public synchronized AdblockEngine removeSettingsChangedListener(SettingsChangedListener settingsChangedListener) {
        this.settingsChangedListeners.remove(settingsChangedListener);
        return this;
    }

    public void setAcceptableAdsEnabled(boolean z10) {
        this.filterEngine.setAcceptableAdsEnabled(z10);
    }

    public void setEnabled(boolean z10) {
        if (z10 == this.enabled) {
            return;
        }
        this.enabled = z10;
        if (this.filterEngine != null) {
            this.filterEngine.setEnabled(z10);
        }
        synchronized (this) {
            Iterator<SettingsChangedListener> it = this.settingsChangedListeners.iterator();
            while (it.hasNext()) {
                it.next().onEnableStateChanged(z10);
            }
        }
    }

    public void setSubscription(String str) {
        clearSubscriptions();
        org.adblockplus.libadblockplus.Subscription subscription = this.filterEngine.getSubscription(str);
        if (subscription != null) {
            subscription.addToList();
        }
    }

    public void setSubscriptions(Collection<String> collection) {
        for (org.adblockplus.libadblockplus.Subscription subscription : this.filterEngine.getListedSubscriptions()) {
            if (!collection.contains(subscription.getUrl())) {
                subscription.removeFromList();
            }
        }
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            org.adblockplus.libadblockplus.Subscription subscription2 = this.filterEngine.getSubscription(it.next());
            if (subscription2 != null && !subscription2.isListed()) {
                subscription2.addToList();
            }
        }
    }

    public static Builder builder(Context context, String str) throws PackageManager.NameNotFoundException {
        AppInfo appInfoGenerateAppInfo = generateAppInfo(context);
        return builder(context, appInfoGenerateAppInfo, str).setIsAllowedConnectionCallback(new IsAllowedConnectionCallbackImpl((ConnectivityManager) context.getSystemService("connectivity")));
    }

    public static AppInfo generateAppInfo(Context context) throws PackageManager.NameNotFoundException {
        try {
            return generateAppInfo(context, context.getPackageName(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException(e10);
        }
    }
}
