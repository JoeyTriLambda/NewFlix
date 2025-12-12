package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpRequestInterceptor;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public interface HttpRequestInterceptorList {
    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor);

    void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i10);

    void clearRequestInterceptors();

    HttpRequestInterceptor getRequestInterceptor(int i10);

    int getRequestInterceptorCount();

    void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls);

    void setInterceptors(List<?> list);
}
