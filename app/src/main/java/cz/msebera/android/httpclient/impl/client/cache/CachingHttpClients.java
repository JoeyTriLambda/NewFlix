package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.impl.client.CloseableHttpClient;
import java.io.File;

/* loaded from: classes2.dex */
public class CachingHttpClients {
    private CachingHttpClients() {
    }

    public static CloseableHttpClient createFileBound(File file) {
        return CachingHttpClientBuilder.create().setCacheDir(file).build();
    }

    public static CloseableHttpClient createMemoryBound() {
        return CachingHttpClientBuilder.create().build();
    }

    public static CachingHttpClientBuilder custom() {
        return CachingHttpClientBuilder.create();
    }
}
