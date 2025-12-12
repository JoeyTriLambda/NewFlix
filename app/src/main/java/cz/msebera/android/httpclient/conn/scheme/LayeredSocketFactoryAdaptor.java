package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
class LayeredSocketFactoryAdaptor extends SocketFactoryAdaptor implements LayeredSocketFactory {
    private final LayeredSchemeSocketFactory factory;

    public LayeredSocketFactoryAdaptor(LayeredSchemeSocketFactory layeredSchemeSocketFactory) {
        super(layeredSchemeSocketFactory);
        this.factory = layeredSchemeSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        return this.factory.createLayeredSocket(socket, str, i10, z10);
    }
}
