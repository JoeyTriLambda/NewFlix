package fd;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: MySSl.java */
/* loaded from: classes2.dex */
public final class g extends SSLSocketFactory {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f11542b = {"TLSv1.2"};

    /* renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f11543a;

    public g(SSLSocketFactory sSLSocketFactory) {
        this.f11543a = sSLSocketFactory;
    }

    public static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f11542b);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i10, boolean z10) throws IOException {
        Socket socketCreateSocket = this.f11543a.createSocket(socket, str, i10, z10);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f11543a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f11543a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10) throws IOException {
        Socket socketCreateSocket = this.f11543a.createSocket(str, i10);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i10, InetAddress inetAddress, int i11) throws IOException {
        Socket socketCreateSocket = this.f11543a.createSocket(str, i10, inetAddress, i11);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10) throws IOException {
        Socket socketCreateSocket = this.f11543a.createSocket(inetAddress, i10);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i10, InetAddress inetAddress2, int i11) throws IOException {
        Socket socketCreateSocket = this.f11543a.createSocket(inetAddress, i10, inetAddress2, i11);
        a(socketCreateSocket);
        return socketCreateSocket;
    }
}
