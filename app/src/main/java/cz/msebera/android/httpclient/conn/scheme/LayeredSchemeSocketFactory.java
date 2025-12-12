package cz.msebera.android.httpclient.conn.scheme;

import java.io.IOException;
import java.net.Socket;

@Deprecated
/* loaded from: classes2.dex */
public interface LayeredSchemeSocketFactory extends SchemeSocketFactory {
    Socket createLayeredSocket(Socket socket, String str, int i10, boolean z10) throws IOException;
}
