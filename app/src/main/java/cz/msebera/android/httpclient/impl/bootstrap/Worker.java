package cz.msebera.android.httpclient.impl.bootstrap;

import cz.msebera.android.httpclient.ExceptionLogger;
import cz.msebera.android.httpclient.HttpServerConnection;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpCoreContext;
import cz.msebera.android.httpclient.protocol.HttpService;
import java.io.IOException;

/* loaded from: classes2.dex */
class Worker implements Runnable {
    private final HttpServerConnection conn;
    private final ExceptionLogger exceptionLogger;
    private final HttpService httpservice;

    public Worker(HttpService httpService, HttpServerConnection httpServerConnection, ExceptionLogger exceptionLogger) {
        this.httpservice = httpService;
        this.conn = httpServerConnection;
        this.exceptionLogger = exceptionLogger;
    }

    public HttpServerConnection getConnection() {
        return this.conn;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                try {
                    BasicHttpContext basicHttpContext = new BasicHttpContext();
                    HttpCoreContext httpCoreContextAdapt = HttpCoreContext.adapt(basicHttpContext);
                    while (!Thread.interrupted() && this.conn.isOpen()) {
                        this.httpservice.handleRequest(this.conn, httpCoreContextAdapt);
                        basicHttpContext.clear();
                    }
                    this.conn.close();
                    this.conn.shutdown();
                } catch (Throwable th2) {
                    try {
                        this.conn.shutdown();
                    } catch (IOException e10) {
                        this.exceptionLogger.log(e10);
                    }
                    throw th2;
                }
            } catch (Exception e11) {
                this.exceptionLogger.log(e11);
                this.conn.shutdown();
            }
        } catch (IOException e12) {
            this.exceptionLogger.log(e12);
        }
    }
}
