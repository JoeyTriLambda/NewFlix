package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
class SchemeLayeredSocketFactoryAdaptor extends SchemeSocketFactoryAdaptor implements SchemeLayeredSocketFactory {
    private final LayeredSocketFactory factory;

    public SchemeLayeredSocketFactoryAdaptor(LayeredSocketFactory layeredSocketFactory) {
        super(layeredSocketFactory);
        this.factory = layeredSocketFactory;
    }

    @Override // cz.msebera.android.httpclient.conn.scheme.SchemeLayeredSocketFactory
    public Socket createLayeredSocket(Socket socket, String str, int i10, HttpParams httpParams) throws IOException {
        return this.factory.createSocket(socket, str, i10, true);
    }
}
