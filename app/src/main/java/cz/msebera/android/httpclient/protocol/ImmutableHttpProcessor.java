package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import java.io.IOException;
import java.util.List;

@Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/* loaded from: classes2.dex */
public final class ImmutableHttpProcessor implements HttpProcessor {
    private final HttpRequestInterceptor[] requestInterceptors;
    private final HttpResponseInterceptor[] responseInterceptors;

    public ImmutableHttpProcessor(HttpRequestInterceptor[] httpRequestInterceptorArr, HttpResponseInterceptor[] httpResponseInterceptorArr) {
        if (httpRequestInterceptorArr != null) {
            int length = httpRequestInterceptorArr.length;
            HttpRequestInterceptor[] httpRequestInterceptorArr2 = new HttpRequestInterceptor[length];
            this.requestInterceptors = httpRequestInterceptorArr2;
            System.arraycopy(httpRequestInterceptorArr, 0, httpRequestInterceptorArr2, 0, length);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorArr == null) {
            this.responseInterceptors = new HttpResponseInterceptor[0];
            return;
        }
        int length2 = httpResponseInterceptorArr.length;
        HttpResponseInterceptor[] httpResponseInterceptorArr2 = new HttpResponseInterceptor[length2];
        this.responseInterceptors = httpResponseInterceptorArr2;
        System.arraycopy(httpResponseInterceptorArr, 0, httpResponseInterceptorArr2, 0, length2);
    }

    @Override // cz.msebera.android.httpclient.HttpRequestInterceptor
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        for (HttpRequestInterceptor httpRequestInterceptor : this.requestInterceptors) {
            httpRequestInterceptor.process(httpRequest, httpContext);
        }
    }

    @Override // cz.msebera.android.httpclient.HttpResponseInterceptor
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        for (HttpResponseInterceptor httpResponseInterceptor : this.responseInterceptors) {
            httpResponseInterceptor.process(httpResponse, httpContext);
        }
    }

    public ImmutableHttpProcessor(List<HttpRequestInterceptor> list, List<HttpResponseInterceptor> list2) {
        if (list != null) {
            this.requestInterceptors = (HttpRequestInterceptor[]) list.toArray(new HttpRequestInterceptor[list.size()]);
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (list2 != null) {
            this.responseInterceptors = (HttpResponseInterceptor[]) list2.toArray(new HttpResponseInterceptor[list2.size()]);
        } else {
            this.responseInterceptors = new HttpResponseInterceptor[0];
        }
    }

    @Deprecated
    public ImmutableHttpProcessor(HttpRequestInterceptorList httpRequestInterceptorList, HttpResponseInterceptorList httpResponseInterceptorList) {
        if (httpRequestInterceptorList != null) {
            int requestInterceptorCount = httpRequestInterceptorList.getRequestInterceptorCount();
            this.requestInterceptors = new HttpRequestInterceptor[requestInterceptorCount];
            for (int i10 = 0; i10 < requestInterceptorCount; i10++) {
                this.requestInterceptors[i10] = httpRequestInterceptorList.getRequestInterceptor(i10);
            }
        } else {
            this.requestInterceptors = new HttpRequestInterceptor[0];
        }
        if (httpResponseInterceptorList != null) {
            int responseInterceptorCount = httpResponseInterceptorList.getResponseInterceptorCount();
            this.responseInterceptors = new HttpResponseInterceptor[responseInterceptorCount];
            for (int i11 = 0; i11 < responseInterceptorCount; i11++) {
                this.responseInterceptors[i11] = httpResponseInterceptorList.getResponseInterceptor(i11);
            }
            return;
        }
        this.responseInterceptors = new HttpResponseInterceptor[0];
    }

    public ImmutableHttpProcessor(HttpRequestInterceptor... httpRequestInterceptorArr) {
        this(httpRequestInterceptorArr, (HttpResponseInterceptor[]) null);
    }

    public ImmutableHttpProcessor(HttpResponseInterceptor... httpResponseInterceptorArr) {
        this((HttpRequestInterceptor[]) null, httpResponseInterceptorArr);
    }
}
