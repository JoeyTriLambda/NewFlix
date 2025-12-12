package dh;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: HttpConnection.java */
/* loaded from: classes2.dex */
public final class c implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
