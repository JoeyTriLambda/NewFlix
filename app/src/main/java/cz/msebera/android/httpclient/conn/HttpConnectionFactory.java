package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.config.ConnectionConfig;

/* loaded from: classes2.dex */
public interface HttpConnectionFactory<T, C extends HttpConnection> {
    C create(T t10, ConnectionConfig connectionConfig);
}
