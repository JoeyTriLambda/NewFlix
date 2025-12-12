package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.SocketHttpClientConnection;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.io.SessionOutputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.params.BasicHttpParams;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.params.HttpProtocolParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

@Deprecated
/* loaded from: classes2.dex */
public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection, ManagedHttpClientConnection, HttpContext {
    private boolean connSecure;
    private volatile boolean shutdown;
    private volatile Socket socket;
    private HttpHost targetHost;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    public HttpClientAndroidLog headerLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
    public HttpClientAndroidLog wireLog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
    private final Map<String, Object> attributes = new HashMap();

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public void bind(Socket socket) throws IOException {
        bind(socket, new BasicHttpParams());
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.HttpConnection, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection " + this + " closed");
            }
        } catch (IOException e10) {
            this.log.debug("I/O error closing connection", e10);
        }
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection
    public HttpMessageParser<HttpResponse> createResponseParser(SessionInputBuffer sessionInputBuffer, HttpResponseFactory httpResponseFactory, HttpParams httpParams) {
        return new DefaultHttpResponseParser(sessionInputBuffer, (LineParser) null, httpResponseFactory, httpParams);
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection
    public SessionInputBuffer createSessionInputBuffer(Socket socket, int i10, HttpParams httpParams) throws IOException {
        if (i10 <= 0) {
            i10 = 8192;
        }
        SessionInputBuffer sessionInputBufferCreateSessionInputBuffer = super.createSessionInputBuffer(socket, i10, httpParams);
        return this.wireLog.isDebugEnabled() ? new LoggingSessionInputBuffer(sessionInputBufferCreateSessionInputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(httpParams)) : sessionInputBufferCreateSessionInputBuffer;
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection
    public SessionOutputBuffer createSessionOutputBuffer(Socket socket, int i10, HttpParams httpParams) throws IOException {
        if (i10 <= 0) {
            i10 = 8192;
        }
        SessionOutputBuffer sessionOutputBufferCreateSessionOutputBuffer = super.createSessionOutputBuffer(socket, i10, httpParams);
        return this.wireLog.isDebugEnabled() ? new LoggingSessionOutputBuffer(sessionOutputBufferCreateSessionOutputBuffer, new Wire(this.wireLog), HttpProtocolParams.getHttpElementCharset(httpParams)) : sessionOutputBufferCreateSessionOutputBuffer;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public String getId() {
        return null;
    }

    @Override // cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public SSLSession getSSLSession() {
        if (this.socket instanceof SSLSocket) {
            return ((SSLSocket) this.socket).getSession();
        }
        return null;
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.conn.OperatedClientConnection, cz.msebera.android.httpclient.conn.ManagedHttpClientConnection
    public final Socket getSocket() {
        return this.socket;
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public final boolean isSecure() {
        return this.connSecure;
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void openCompleted(boolean z10, HttpParams httpParams) throws IOException {
        Args.notNull(httpParams, "Parameters");
        assertNotOpen();
        this.connSecure = z10;
        bind(this.socket, httpParams);
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void opening(Socket socket, HttpHost httpHost) throws IOException {
        assertNotOpen();
        this.socket = socket;
        this.targetHost = httpHost;
        if (this.shutdown) {
            socket.close();
            throw new InterruptedIOException("Connection already shutdown");
        }
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection, cz.msebera.android.httpclient.HttpClientConnection
    public HttpResponse receiveResponseHeader() throws IllegalStateException, HttpException, IOException {
        HttpResponse httpResponseReceiveResponseHeader = super.receiveResponseHeader();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Receiving response: " + httpResponseReceiveResponseHeader.getStatusLine());
        }
        if (this.headerLog.isDebugEnabled()) {
            this.headerLog.debug("<< " + httpResponseReceiveResponseHeader.getStatusLine().toString());
            for (Header header : httpResponseReceiveResponseHeader.getAllHeaders()) {
                this.headerLog.debug("<< " + header.toString());
            }
        }
        return httpResponseReceiveResponseHeader;
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public Object removeAttribute(String str) {
        return this.attributes.remove(str);
    }

    @Override // cz.msebera.android.httpclient.impl.AbstractHttpClientConnection, cz.msebera.android.httpclient.HttpClientConnection
    public void sendRequestHeader(HttpRequest httpRequest) throws IllegalStateException, IOException, HttpException {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Sending request: " + httpRequest.getRequestLine());
        }
        super.sendRequestHeader(httpRequest);
        if (this.headerLog.isDebugEnabled()) {
            this.headerLog.debug(">> " + httpRequest.getRequestLine().toString());
            for (Header header : httpRequest.getAllHeaders()) {
                this.headerLog.debug(">> " + header.toString());
            }
        }
    }

    @Override // cz.msebera.android.httpclient.protocol.HttpContext
    public void setAttribute(String str, Object obj) {
        this.attributes.put(str, obj);
    }

    @Override // cz.msebera.android.httpclient.impl.SocketHttpClientConnection, cz.msebera.android.httpclient.HttpConnection
    public void shutdown() throws IOException {
        this.shutdown = true;
        try {
            super.shutdown();
            if (this.log.isDebugEnabled()) {
                this.log.debug("Connection " + this + " shut down");
            }
            Socket socket = this.socket;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e10) {
            this.log.debug("I/O error shutting down connection", e10);
        }
    }

    @Override // cz.msebera.android.httpclient.conn.OperatedClientConnection
    public void update(Socket socket, HttpHost httpHost, boolean z10, HttpParams httpParams) throws IOException {
        assertOpen();
        Args.notNull(httpHost, "Target host");
        Args.notNull(httpParams, "Parameters");
        if (socket != null) {
            this.socket = socket;
            bind(socket, httpParams);
        }
        this.targetHost = httpHost;
        this.connSecure = z10;
    }
}
