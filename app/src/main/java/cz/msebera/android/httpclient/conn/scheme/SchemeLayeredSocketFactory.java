package cz.msebera.android.httpclient.conn.scheme;

import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public interface SchemeLayeredSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i10, HttpParams httpParams) throws IOException;
}
