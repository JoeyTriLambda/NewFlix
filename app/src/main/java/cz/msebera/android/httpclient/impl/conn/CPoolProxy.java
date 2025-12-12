package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.HttpConnectionMetrics;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
class CPoolProxy implements ManagedHttpClientConnection, HttpContext {
    private volatile CPoolEntry poolEntry;

    public CPoolProxy(CPoolEntry cPoolEntry) {
        this.poolEntry = cPoolEntry;
    }

    private static CPoolProxy getProxy(HttpClientConnection httpClientConnection) {
        if (CPoolProxy.class.isInstance(httpClientConnection)) {
            return (CPoolProxy) CPoolProxy.class.cast(httpClientConnection);
        }
        throw new IllegalStateException("Unexpected connection proxy class: " + httpClientConnection.getClass());
    }

    public static HttpClientConnection newProxy(CPoolEntry cPoolEntry) {
        return new CPoolProxy(cPoolEntry);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket socket) throws IOException {
        getValidConnection().bind(socket);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.closeConnection();
        }
    }

    public CPoolEntry detach() {
        CPoolEntry cPoolEntry = this.poolEntry;
        this.poolEntry = null;
        return cPoolEntry;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void flush() throws IOException {
        getValidConnection().flush();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String str) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            return ((HttpContext) validConnection).getAttribute(str);
        }
        return null;
    }

    public ManagedHttpClientConnection getConnection() {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry == null) {
            return null;
        }
        return cPoolEntry.getConnection();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return getValidConnection().getId();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getLocalAddress() {
        return getValidConnection().getLocalAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getLocalPort() {
        return getValidConnection().getLocalPort();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public HttpConnectionMetrics getMetrics() {
        return getValidConnection().getMetrics();
    }

    public CPoolEntry getPoolEntry() {
        return this.poolEntry;
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public InetAddress getRemoteAddress() {
        return getValidConnection().getRemoteAddress();
    }

    @Override // cz.msebera.android.httpclient.HttpInetConnection
    public int getRemotePort() {
        return getValidConnection().getRemotePort();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        return getValidConnection().getSSLSession();
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public Socket getSocket() {
        return getValidConnection().getSocket();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public int getSocketTimeout() {
        return getValidConnection().getSocketTimeout();
    }

    public ManagedHttpClientConnection getValidConnection() {
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            return connection;
        }
        throw new ConnectionShutdownException();
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isOpen() {
        CPoolEntry cPoolEntry = this.poolEntry;
        return (cPoolEntry == null || cPoolEntry.isClosed()) ? false : true;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public boolean isResponseAvailable(int i10) throws IOException {
        return getValidConnection().isResponseAvailable(i10);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public boolean isStale() {
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            return connection.isStale();
        }
        return true;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void receiveResponseEntity(HttpResponse httpResponse) throws HttpException, IOException {
        getValidConnection().receiveResponseEntity(httpResponse);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        return getValidConnection().receiveResponseHeader();
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String str) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            return ((HttpContext) validConnection).removeAttribute(str);
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) throws HttpException, IOException {
        getValidConnection().sendRequestEntity(httpEntityEnclosingRequest);
    }

    @Override // cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws HttpException, IOException {
        getValidConnection().sendRequestHeader(httpRequest);
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        ManagedHttpClientConnection validConnection = getValidConnection();
        if (validConnection instanceof HttpContext) {
            ((HttpContext) validConnection).setAttribute(str, obj);
        }
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void setSocketTimeout(int i10) {
        getValidConnection().setSocketTimeout(i10);
    }

    @Override // cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        CPoolEntry cPoolEntry = this.poolEntry;
        if (cPoolEntry != null) {
            cPoolEntry.shutdownConnection();
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("CPoolProxy{");
        ManagedHttpClientConnection connection = getConnection();
        if (connection != null) {
            sb2.append(connection);
        } else {
            sb2.append("detached");
        }
        sb2.append('}');
        return sb2.toString();
    }

    public static CPoolEntry getPoolEntry(HttpClientConnection httpClientConnection) {
        CPoolEntry poolEntry = getProxy(httpClientConnection).getPoolEntry();
        if (poolEntry != null) {
            return poolEntry;
        }
        throw new ConnectionShutdownException();
    }

    public static CPoolEntry detach(HttpClientConnection httpClientConnection) {
        return getProxy(httpClientConnection).detach();
    }
}
