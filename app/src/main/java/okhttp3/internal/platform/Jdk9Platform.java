package okhttp3.internal.platform;

import ig.k;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import zf.f;
import zf.i;

/* compiled from: Jdk9Platform.kt */
/* loaded from: classes2.dex */
public class Jdk9Platform extends Platform {
    public static final Companion Companion = new Companion(0 == true ? 1 : 0);
    private static final boolean isAvailable;

    /* compiled from: Jdk9Platform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Jdk9Platform buildIfSupported() {
            if (isAvailable()) {
                return new Jdk9Platform();
            }
            return null;
        }

        public final boolean isAvailable() {
            return Jdk9Platform.isAvailable;
        }
    }

    static {
        String property = System.getProperty("java.specification.version");
        Integer intOrNull = property != null ? k.toIntOrNull(property) : null;
        boolean z10 = true;
        if (intOrNull == null) {
            try {
                SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]);
            } catch (NoSuchMethodException unused) {
            }
        } else if (intOrNull.intValue() < 9) {
            z10 = false;
        }
        isAvailable = z10;
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        i.checkNotNullParameter(list, "protocols");
        SSLParameters sSLParameters = sSLSocket.getSSLParameters();
        Object[] array = Platform.Companion.alpnProtocolNames(list).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        sSLParameters.setApplicationProtocols((String[]) array);
        sSLSocket.setSSLParameters(sSLParameters);
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressSignatureCheck
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        try {
            String applicationProtocol = sSLSocket.getApplicationProtocol();
            if (applicationProtocol == null ? true : i.areEqual(applicationProtocol, "")) {
                return null;
            }
            return applicationProtocol;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        i.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        throw new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
