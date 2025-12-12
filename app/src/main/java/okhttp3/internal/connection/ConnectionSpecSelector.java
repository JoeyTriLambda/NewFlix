package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import zf.i;

/* compiled from: ConnectionSpecSelector.kt */
/* loaded from: classes2.dex */
public final class ConnectionSpecSelector {
    private final List<ConnectionSpec> connectionSpecs;
    private boolean isFallback;
    private boolean isFallbackPossible;
    private int nextModeIndex;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        i.checkNotNullParameter(list, "connectionSpecs");
        this.connectionSpecs = list;
    }

    private final boolean isFallbackPossible(SSLSocket sSLSocket) {
        int i10 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (this.connectionSpecs.get(i10).isCompatible(sSLSocket)) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }

    public final ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        int i10 = this.nextModeIndex;
        int size = this.connectionSpecs.size();
        while (true) {
            if (i10 >= size) {
                connectionSpec = null;
                break;
            }
            int i11 = i10 + 1;
            connectionSpec = this.connectionSpecs.get(i10);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.nextModeIndex = i11;
                break;
            }
            i10 = i11;
        }
        if (connectionSpec != null) {
            this.isFallbackPossible = isFallbackPossible(sSLSocket);
            connectionSpec.apply$okhttp(sSLSocket, this.isFallback);
            return connectionSpec;
        }
        StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.isFallback);
        sb2.append(", modes=");
        sb2.append(this.connectionSpecs);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        i.checkNotNull(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        i.checkNotNullExpressionValue(string, "toString(this)");
        sb2.append(string);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean connectionFailed(IOException iOException) {
        i.checkNotNullParameter(iOException, "e");
        this.isFallback = true;
        return (!this.isFallbackPossible || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException) || ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) || !(iOException instanceof SSLException)) ? false : true;
    }
}
