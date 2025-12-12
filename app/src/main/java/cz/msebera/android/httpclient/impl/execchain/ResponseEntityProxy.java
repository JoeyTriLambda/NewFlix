package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.EofSensorInputStream;
import cz.msebera.android.httpclient.conn.EofSensorWatcher;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/* loaded from: classes2.dex */
class ResponseEntityProxy extends HttpEntityWrapper implements EofSensorWatcher {
    private final ConnectionHolder connHolder;

    public ResponseEntityProxy(HttpEntity httpEntity, ConnectionHolder connectionHolder) {
        super(httpEntity);
        this.connHolder = connectionHolder;
    }

    private void abortConnection() {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.abortConnection();
        }
    }

    private void cleanup() throws IOException {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.close();
        }
    }

    public static void enchance(HttpResponse httpResponse, ConnectionHolder connectionHolder) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity == null || !entity.isStreaming() || connectionHolder == null) {
            return;
        }
        httpResponse.setEntity(new ResponseEntityProxy(entity, connectionHolder));
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws IOException {
        releaseConnection();
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean eofDetected(InputStream inputStream) throws IOException {
        try {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    abortConnection();
                    throw e10;
                } catch (RuntimeException e11) {
                    abortConnection();
                    throw e11;
                }
            }
            releaseConnection();
            cleanup();
            return false;
        } catch (Throwable th2) {
            cleanup();
            throw th2;
        }
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws IOException {
        return new EofSensorInputStream(this.wrappedEntity.getContent(), this);
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    public void releaseConnection() {
        ConnectionHolder connectionHolder = this.connHolder;
        if (connectionHolder != null) {
            connectionHolder.releaseConnection();
        }
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamAbort(InputStream inputStream) throws IOException {
        cleanup();
        return false;
    }

    @Override // cz.msebera.android.httpclient.conn.EofSensorWatcher
    public boolean streamClosed(InputStream inputStream) throws IOException {
        try {
            try {
                ConnectionHolder connectionHolder = this.connHolder;
                boolean z10 = (connectionHolder == null || connectionHolder.isReleased()) ? false : true;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (SocketException e10) {
                        if (z10) {
                            throw e10;
                        }
                    }
                }
                releaseConnection();
                return false;
            } catch (IOException e11) {
                abortConnection();
                throw e11;
            } catch (RuntimeException e12) {
                abortConnection();
                throw e12;
            }
        } finally {
            cleanup();
        }
    }

    public String toString() {
        return "ResponseEntityProxy{" + this.wrappedEntity + '}';
    }

    @Override // cz.msebera.android.httpclient.entity.HttpEntityWrapper, cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (outputStream != null) {
                try {
                    this.wrappedEntity.writeTo(outputStream);
                } catch (IOException e10) {
                    abortConnection();
                    throw e10;
                } catch (RuntimeException e11) {
                    abortConnection();
                    throw e11;
                }
            }
            releaseConnection();
        } finally {
            cleanup();
        }
    }
}
