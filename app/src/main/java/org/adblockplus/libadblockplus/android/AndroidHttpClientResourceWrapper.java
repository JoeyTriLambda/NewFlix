package org.adblockplus.libadblockplus.android;

import android.content.Context;
import android.content.SharedPreferences;
import bi.a;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.adblockplus.libadblockplus.HttpClient;
import org.adblockplus.libadblockplus.HttpRequest;
import org.adblockplus.libadblockplus.ServerResponse;

/* loaded from: classes2.dex */
public class AndroidHttpClientResourceWrapper extends HttpClient {
    public static final String ACCEPTABLE_ADS = "https://easylist-downloads.adblockplus.org/exceptionrules.txt";
    public static final String EASYLIST = "https://easylist-downloads.adblockplus.org/easylist.txt";
    public static final String EASYLIST_ARABIAN_FRENCH = "https://easylist-downloads.adblockplus.org/liste_ar+liste_fr+easylist.txt";
    public static final String EASYLIST_BULGARIAN = "https://easylist-downloads.adblockplus.org/bulgarian_list+easylist.txt";
    public static final String EASYLIST_CHINESE = "https://easylist-downloads.adblockplus.org/easylistchina+easylist.txt";
    public static final String EASYLIST_CZECH_SLOVAK = "https://easylist-downloads.adblockplus.org/easylistczechslovak+easylist.txt";
    public static final String EASYLIST_DUTCH = "https://easylist-downloads.adblockplus.org/easylistdutch+easylist.txt";
    public static final String EASYLIST_FRENCH = "https://easylist-downloads.adblockplus.org/liste_fr+easylist.txt";
    public static final String EASYLIST_GERMAN = "https://easylist-downloads.adblockplus.org/easylistgermany+easylist.txt";
    public static final String EASYLIST_INDONESIAN = "https://easylist-downloads.adblockplus.org/abpindo+easylist.txt";
    public static final String EASYLIST_ISRAELI = "https://easylist-downloads.adblockplus.org/israellist+easylist.txt";
    public static final String EASYLIST_ITALIAN = "https://easylist-downloads.adblockplus.org/easylistitaly+easylist.txt";
    public static final String EASYLIST_LATVIAN = "https://easylist-downloads.adblockplus.org/latvianlist+easylist.txt";
    public static final String EASYLIST_LITHUANIAN = "https://easylist-downloads.adblockplus.org/easylistlithuania+easylist.txt";
    public static final String EASYLIST_POLISH = "https://easylist-downloads.adblockplus.org/easylistpolish+easylist.txt";
    public static final String EASYLIST_ROMANIAN = "https://easylist-downloads.adblockplus.org/rolist+easylist.txt";
    public static final String EASYLIST_RUSSIAN = "https://easylist-downloads.adblockplus.org/ruadlist+easylist.txt";
    private Context context;
    private HttpClient httpClient;
    private Listener listener;
    private Storage storage;
    private Map<String, Integer> urlToResourceIdMap;

    public interface Listener {
        void onIntercepted(String str, int i10);
    }

    public static class SharedPrefsStorage implements Storage {
        private static final String URLS = "urls";
        private SharedPreferences prefs;
        private Set<String> urls;

        public SharedPrefsStorage(SharedPreferences sharedPreferences) {
            this.prefs = sharedPreferences;
            this.urls = sharedPreferences.getStringSet(URLS, new HashSet());
        }

        @Override // org.adblockplus.libadblockplus.android.AndroidHttpClientResourceWrapper.Storage
        public synchronized boolean contains(String str) {
            return this.urls.contains(str);
        }

        @Override // org.adblockplus.libadblockplus.android.AndroidHttpClientResourceWrapper.Storage
        public synchronized void put(String str) {
            this.urls.add(str);
            this.prefs.edit().putStringSet(URLS, this.urls).commit();
        }
    }

    public interface Storage {
        boolean contains(String str);

        void put(String str);
    }

    public AndroidHttpClientResourceWrapper(Context context, HttpClient httpClient, Map<String, Integer> map, Storage storage) {
        this.context = context;
        this.httpClient = httpClient;
        this.urlToResourceIdMap = Collections.synchronizedMap(map);
        this.storage = storage;
    }

    public ServerResponse buildResourceContentResponse(int i10) {
        ServerResponse serverResponse = new ServerResponse();
        try {
            serverResponse.setResponse(readResourceContent(i10));
            serverResponse.setResponseStatus(200);
            serverResponse.setStatus(ServerResponse.NsStatus.OK);
        } catch (IOException e10) {
            a.e(e10, "Error injecting response", new Object[0]);
            serverResponse.setStatus(ServerResponse.NsStatus.ERROR_FAILURE);
        }
        return serverResponse;
    }

    public Listener getListener() {
        return this.listener;
    }

    public ByteBuffer readResourceContent(int i10) throws IOException {
        a.d("Reading from resource ...", new Object[0]);
        InputStream inputStreamOpenRawResource = null;
        try {
            inputStreamOpenRawResource = this.context.getResources().openRawResource(i10);
            return Utils.readFromInputStream(inputStreamOpenRawResource);
        } finally {
            if (inputStreamOpenRawResource != null) {
                inputStreamOpenRawResource.close();
            }
        }
    }

    @Override // org.adblockplus.libadblockplus.HttpClient
    public void request(HttpRequest httpRequest, HttpClient.Callback callback) {
        String urlWithoutParams = Utils.getUrlWithoutParams(httpRequest.getUrl());
        Integer num = this.urlToResourceIdMap.get(urlWithoutParams);
        if (num == null) {
            a.d("Skip intercepting request for %s", urlWithoutParams);
        } else {
            if (!this.storage.contains(urlWithoutParams)) {
                a.w("Intercepting request for %s with resource #%d", httpRequest.getUrl(), num);
                ServerResponse serverResponseBuildResourceContentResponse = buildResourceContentResponse(num.intValue());
                this.storage.put(urlWithoutParams);
                callback.onFinished(serverResponseBuildResourceContentResponse);
                Listener listener = this.listener;
                if (listener != null) {
                    listener.onIntercepted(httpRequest.getUrl(), num.intValue());
                    return;
                }
                return;
            }
            a.d("Already intercepted request for %s", urlWithoutParams);
        }
        this.httpClient.request(httpRequest, callback);
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
}
