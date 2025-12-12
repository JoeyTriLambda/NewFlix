package v2;

import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v2.a;
import v2.h;

/* compiled from: WebViewFeatureInternal.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final a.d f20439a;

    /* renamed from: b, reason: collision with root package name */
    public static final a.d f20440b;

    /* compiled from: WebViewFeatureInternal.java */
    public class a extends a.i {

        /* renamed from: d, reason: collision with root package name */
        public final Pattern f20441d = Pattern.compile("\\A\\d+");

        @Override // v2.a
        public boolean isSupportedByWebView() {
            boolean zIsSupportedByWebView = super.isSupportedByWebView();
            if (!zIsSupportedByWebView || Build.VERSION.SDK_INT >= 29) {
                return zIsSupportedByWebView;
            }
            PackageInfo currentLoadedWebViewPackage = u2.e.getCurrentLoadedWebViewPackage();
            if (currentLoadedWebViewPackage == null) {
                return false;
            }
            Matcher matcher = this.f20441d.matcher(currentLoadedWebViewPackage.versionName);
            return matcher.find() && Integer.parseInt(currentLoadedWebViewPackage.versionName.substring(matcher.start(), matcher.end())) >= 105;
        }
    }

    static {
        new a.b("VISUAL_STATE_CALLBACK", "VISUAL_STATE_CALLBACK");
        new a.b("OFF_SCREEN_PRERASTER", "OFF_SCREEN_PRERASTER");
        new a.e("SAFE_BROWSING_ENABLE", "SAFE_BROWSING_ENABLE");
        new a.c("DISABLED_ACTION_MODE_MENU_ITEMS", "DISABLED_ACTION_MODE_MENU_ITEMS");
        new a.f("START_SAFE_BROWSING", "START_SAFE_BROWSING");
        new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_WHITELIST");
        new a.f("SAFE_BROWSING_WHITELIST", "SAFE_BROWSING_ALLOWLIST");
        new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_WHITELIST");
        new a.f("SAFE_BROWSING_ALLOWLIST", "SAFE_BROWSING_ALLOWLIST");
        new a.f("SAFE_BROWSING_PRIVACY_POLICY_URL", "SAFE_BROWSING_PRIVACY_POLICY_URL");
        new a.c("SERVICE_WORKER_BASIC_USAGE", "SERVICE_WORKER_BASIC_USAGE");
        new a.c("SERVICE_WORKER_CACHE_MODE", "SERVICE_WORKER_CACHE_MODE");
        new a.c("SERVICE_WORKER_CONTENT_ACCESS", "SERVICE_WORKER_CONTENT_ACCESS");
        new a.c("SERVICE_WORKER_FILE_ACCESS", "SERVICE_WORKER_FILE_ACCESS");
        new a.c("SERVICE_WORKER_BLOCK_NETWORK_LOADS", "SERVICE_WORKER_BLOCK_NETWORK_LOADS");
        new a.c("SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST", "SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST");
        new a.b("RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_WEB_RESOURCE_ERROR");
        new a.b("RECEIVE_HTTP_ERROR", "RECEIVE_HTTP_ERROR");
        new a.c("SHOULD_OVERRIDE_WITH_REDIRECTS", "SHOULD_OVERRIDE_WITH_REDIRECTS");
        new a.f("SAFE_BROWSING_HIT", "SAFE_BROWSING_HIT");
        new a.c("WEB_RESOURCE_REQUEST_IS_REDIRECT", "WEB_RESOURCE_REQUEST_IS_REDIRECT");
        new a.b("WEB_RESOURCE_ERROR_GET_DESCRIPTION", "WEB_RESOURCE_ERROR_GET_DESCRIPTION");
        new a.b("WEB_RESOURCE_ERROR_GET_CODE", "WEB_RESOURCE_ERROR_GET_CODE");
        new a.f("SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY", "SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY");
        new a.f("SAFE_BROWSING_RESPONSE_PROCEED", "SAFE_BROWSING_RESPONSE_PROCEED");
        new a.f("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL", "SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL");
        new a.b("WEB_MESSAGE_PORT_POST_MESSAGE", "WEB_MESSAGE_PORT_POST_MESSAGE");
        new a.b("WEB_MESSAGE_PORT_CLOSE", "WEB_MESSAGE_PORT_CLOSE");
        f20439a = new a.d("WEB_MESSAGE_GET_MESSAGE_PAYLOAD", "WEB_MESSAGE_GET_MESSAGE_PAYLOAD");
        new a.b("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK", "WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK");
        new a.b("CREATE_WEB_MESSAGE_CHANNEL", "CREATE_WEB_MESSAGE_CHANNEL");
        new a.b("POST_WEB_MESSAGE", "POST_WEB_MESSAGE");
        new a.b("WEB_MESSAGE_CALLBACK_ON_MESSAGE", "WEB_MESSAGE_CALLBACK_ON_MESSAGE");
        new a.e("GET_WEB_VIEW_CLIENT", "GET_WEB_VIEW_CLIENT");
        new a.e("GET_WEB_CHROME_CLIENT", "GET_WEB_CHROME_CLIENT");
        new a.h("GET_WEB_VIEW_RENDERER", "GET_WEB_VIEW_RENDERER");
        new a.h("WEB_VIEW_RENDERER_TERMINATE", "WEB_VIEW_RENDERER_TERMINATE");
        new a.g();
        new h.a();
        new a.h("WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE", "WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE");
        new a();
        new a.d("PROXY_OVERRIDE", "PROXY_OVERRIDE:3");
        new a.d("SUPPRESS_ERROR_PAGE", "SUPPRESS_ERROR_PAGE");
        new a.d("MULTI_PROCESS", "MULTI_PROCESS_QUERY");
        new a.h("FORCE_DARK", "FORCE_DARK");
        new a.d("FORCE_DARK_STRATEGY", "FORCE_DARK_BEHAVIOR");
        f20440b = new a.d("WEB_MESSAGE_LISTENER", "WEB_MESSAGE_LISTENER");
        new a.d("DOCUMENT_START_SCRIPT", "DOCUMENT_START_SCRIPT:1");
        new a.d("PROXY_OVERRIDE_REVERSE_BYPASS", "PROXY_OVERRIDE_REVERSE_BYPASS");
        new a.d("GET_VARIATIONS_HEADER", "GET_VARIATIONS_HEADER");
        new a.d("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY", "ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY");
        new a.d("GET_COOKIE_INFO", "GET_COOKIE_INFO");
        new a.d("REQUESTED_WITH_HEADER_ALLOW_LIST", "REQUESTED_WITH_HEADER_ALLOW_LIST");
    }

    public static UnsupportedOperationException getUnsupportedOperationException() {
        return new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public static boolean isSupported(String str) {
        return isSupported(str, v2.a.values());
    }

    public static <T extends e> boolean isSupported(String str, Collection<T> collection) {
        HashSet hashSet = new HashSet();
        for (T t10 : collection) {
            if (t10.getPublicFeatureName().equals(str)) {
                hashSet.add(t10);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException(ac.c.j("Unknown feature ", str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).isSupported()) {
                return true;
            }
        }
        return false;
    }
}
