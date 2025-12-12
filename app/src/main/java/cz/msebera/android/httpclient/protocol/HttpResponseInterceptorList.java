package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpResponseInterceptor;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public interface HttpResponseInterceptorList {
    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor);

    void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i10);

    void clearResponseInterceptors();

    HttpResponseInterceptor getResponseInterceptor(int i10);

    int getResponseInterceptorCount();

    void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls);

    void setInterceptors(List<?> list);
}
