package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
    protected final List<HttpRequestInterceptor> requestInterceptors = new ArrayList();
    protected final List<HttpResponseInterceptor> responseInterceptors = new ArrayList();

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        addRequestInterceptor(httpRequestInterceptor);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor) {
        if (httpRequestInterceptor == null) {
            return;
        }
        this.requestInterceptors.add(httpRequestInterceptor);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i10) {
        if (httpResponseInterceptor == null) {
            return;
        }
        this.responseInterceptors.add(i10, httpResponseInterceptor);
    }

    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void clearRequestInterceptors() {
        this.requestInterceptors.clear();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void clearResponseInterceptors() {
        this.responseInterceptors.clear();
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor basicHttpProcessor = (BasicHttpProcessor) super.clone();
        copyInterceptors(basicHttpProcessor);
        return basicHttpProcessor;
    }

    public BasicHttpProcessor copy() {
        BasicHttpProcessor basicHttpProcessor = new BasicHttpProcessor();
        copyInterceptors(basicHttpProcessor);
        return basicHttpProcessor;
    }

    public void copyInterceptors(BasicHttpProcessor basicHttpProcessor) {
        basicHttpProcessor.requestInterceptors.clear();
        basicHttpProcessor.requestInterceptors.addAll(this.requestInterceptors);
        basicHttpProcessor.responseInterceptors.clear();
        basicHttpProcessor.responseInterceptors.addAll(this.responseInterceptors);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public HttpRequestInterceptor getRequestInterceptor(int i10) {
        if (i10 < 0 || i10 >= this.requestInterceptors.size()) {
            return null;
        }
        return this.requestInterceptors.get(i10);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public int getRequestInterceptorCount() {
        return this.requestInterceptors.size();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public HttpResponseInterceptor getResponseInterceptor(int i10) {
        if (i10 < 0 || i10 >= this.responseInterceptors.size()) {
            return null;
        }
        return this.responseInterceptors.get(i10);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public int getResponseInterceptorCount() {
        return this.responseInterceptors.size();
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Iterator<HttpRequestInterceptor> it = this.requestInterceptors.iterator();
        while (it.hasNext()) {
            it.next().process(httpRequest, httpContext);
        }
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> cls) {
        Iterator<HttpRequestInterceptor> it = this.requestInterceptors.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                it.remove();
            }
        }
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> cls) {
        Iterator<HttpResponseInterceptor> it = this.responseInterceptors.iterator();
        while (it.hasNext()) {
            if (it.next().getClass().equals(cls)) {
                it.remove();
            }
        }
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList, cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void setInterceptors(List<?> list) {
        Args.notNull(list, "Inteceptor list");
        this.requestInterceptors.clear();
        this.responseInterceptors.clear();
        for (Object obj : list) {
            if (obj instanceof HttpRequestInterceptor) {
                addInterceptor((HttpRequestInterceptor) obj);
            }
            if (obj instanceof HttpResponseInterceptor) {
                addInterceptor((HttpResponseInterceptor) obj);
            }
        }
    }

    public final void addInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i10) {
        addRequestInterceptor(httpRequestInterceptor, i10);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpRequestInterceptorList
    public void addRequestInterceptor(HttpRequestInterceptor httpRequestInterceptor, int i10) {
        if (httpRequestInterceptor == null) {
            return;
        }
        this.requestInterceptors.add(i10, httpRequestInterceptor);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpResponseInterceptorList
    public void addResponseInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        if (httpResponseInterceptor == null) {
            return;
        }
        this.responseInterceptors.add(httpResponseInterceptor);
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor) {
        addResponseInterceptor(httpResponseInterceptor);
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Iterator<HttpResponseInterceptor> it = this.responseInterceptors.iterator();
        while (it.hasNext()) {
            it.next().process(httpResponse, httpContext);
        }
    }

    public final void addInterceptor(HttpResponseInterceptor httpResponseInterceptor, int i10) {
        addResponseInterceptor(httpResponseInterceptor, i10);
    }
}
