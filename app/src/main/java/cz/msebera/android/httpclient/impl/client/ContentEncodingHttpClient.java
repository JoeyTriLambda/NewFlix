package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpProcessor;

@Contract(threading = ThreadingBehavior.SAFE_CONDITIONAL)
@Deprecated
/* loaded from: classes2.dex */
public class ContentEncodingHttpClient extends DefaultHttpClient {
    public ContentEncodingHttpClient(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        super(clientConnectionManager, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.client.DefaultHttpClient, cz.msebera.android.httpclient.impl.client.AbstractHttpClient
    public BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor basicHttpProcessorCreateHttpProcessor = super.createHttpProcessor();
        basicHttpProcessorCreateHttpProcessor.addRequestInterceptor(new RequestAcceptEncoding());
        basicHttpProcessorCreateHttpProcessor.addResponseInterceptor(new ResponseContentEncoding());
        return basicHttpProcessorCreateHttpProcessor;
    }

    public ContentEncodingHttpClient(HttpParams httpParams) {
        this(null, httpParams);
    }

    public ContentEncodingHttpClient() {
        this(null);
    }
}
