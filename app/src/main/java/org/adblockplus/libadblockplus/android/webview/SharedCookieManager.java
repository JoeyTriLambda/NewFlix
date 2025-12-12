package org.adblockplus.libadblockplus.android.webview;

import bi.a;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.adblockplus.libadblockplus.HeaderEntry;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.android.Utils;

/* loaded from: classes2.dex */
class SharedCookieManager extends CookieManager {
    static final String PROP_ACCEPT_TPC = "X-Prop-Accept-Tpc";
    static final String PROP_NAVIGATION_URL = "X-Prop-Navigation-Url";
    private static final AtomicReference<CookieHandler> previousCookieManager = new AtomicReference<>();

    private SharedCookieManager() {
    }

    public static void enforceCookieManager() {
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler instanceof SharedCookieManager) {
            return;
        }
        previousCookieManager.set(cookieHandler);
        CookieHandler.setDefault(new SharedCookieManager());
        if (cookieHandler == null) {
            a.d("SharedCookieManager set as a default java.net.CookieManager", new Object[0]);
        } else {
            a.w("SharedCookieManager overwrites existing java.net.CookieManager", new Object[0]);
        }
    }

    public static void injectPropertyHeaders(boolean z10, String str, List<HeaderEntry> list) {
        list.add(new HeaderEntry(PROP_ACCEPT_TPC, String.valueOf(z10)));
        list.add(new HeaderEntry(PROP_NAVIGATION_URL, str));
    }

    public static void unloadCookieManager() {
        if (CookieHandler.getDefault() instanceof SharedCookieManager) {
            CookieHandler.setDefault(previousCookieManager.get());
        }
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> map) {
        if (uri == null || map == null) {
            throw new IllegalArgumentException("Arguments can't be null!");
        }
        if (!android.webkit.CookieManager.getInstance().acceptCookie()) {
            return map;
        }
        String cookie = android.webkit.CookieManager.getInstance().getCookie(Utils.getUrlWithoutFragment(uri.toString()));
        HashMap map2 = new HashMap(map);
        List list = (List) map2.remove(PROP_ACCEPT_TPC);
        List list2 = (List) map2.remove(PROP_NAVIGATION_URL);
        if (cookie != null) {
            boolean z10 = !Utils.isNullOrEmpty(list) ? Boolean.parseBoolean((String) list.get(0)) : false;
            String string = !Utils.isNullOrEmpty(list2) ? (String) list2.get(0) : uri.toString();
            List list3 = (List) map2.get("Cookie");
            if (z10 || Utils.isFirstPartyCookie(string, uri.toString(), cookie)) {
                if (list3 == null) {
                    map2.put("Cookie", Arrays.asList(cookie));
                } else {
                    list3.add(cookie);
                }
            }
        }
        return map2;
    }

    @Override // java.net.CookieManager
    public CookieStore getCookieStore() {
        throw new UnsupportedOperationException("SharedCookieManager stores cookies in android.webkit.CookieManager storage!");
    }

    @Override // java.net.CookieManager, java.net.CookieHandler
    public void put(URI uri, Map<String, List<String>> map) {
        if (map.containsKey("Location") && android.webkit.CookieManager.getInstance().acceptCookie()) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (HttpClient.HEADER_SET_COOKIE.equalsIgnoreCase(entry.getKey())) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        android.webkit.CookieManager.getInstance().setCookie(Utils.getUrlWithoutFragment(uri.toString()), it.next());
                    }
                    android.webkit.CookieManager.getInstance().flush();
                    return;
                }
            }
        }
    }

    @Override // java.net.CookieManager
    public void setCookiePolicy(CookiePolicy cookiePolicy) {
        throw new UnsupportedOperationException("SharedCookieManager uses settings of android.webkit.CookieManager!");
    }
}
