package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import zf.f;
import zf.i;

/* compiled from: StandardAndroidSocketAdapter.kt */
/* loaded from: classes2.dex */
public final class StandardAndroidSocketAdapter extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion(null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    /* compiled from: StandardAndroidSocketAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ SocketAdapter buildIfSupported$default(Companion companion, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(str);
        }

        public final SocketAdapter buildIfSupported(String str) throws ClassNotFoundException {
            i.checkNotNullParameter(str, "packageName");
            try {
                Class<?> cls = Class.forName(i.stringPlus(str, ".OpenSSLSocketImpl"));
                Class<?> cls2 = Class.forName(i.stringPlus(str, ".OpenSSLSocketFactoryImpl"));
                Class<?> cls3 = Class.forName(i.stringPlus(str, ".SSLParametersImpl"));
                i.checkNotNullExpressionValue(cls3, "paramsClass");
                return new StandardAndroidSocketAdapter(cls, cls2, cls3);
            } catch (Exception e10) {
                Platform.Companion.get().log("unable to load android socket classes", 5, e10);
                return null;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StandardAndroidSocketAdapter(Class<? super SSLSocket> cls, Class<? super SSLSocketFactory> cls2, Class<?> cls3) {
        super(cls);
        i.checkNotNullParameter(cls, "sslSocketClass");
        i.checkNotNullParameter(cls2, "sslSocketFactoryClass");
        i.checkNotNullParameter(cls3, "paramClass");
        this.sslSocketFactoryClass = cls2;
        this.paramClass = cls3;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        i.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter, okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        i.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        Object fieldOrNull = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        i.checkNotNull(fieldOrNull);
        X509TrustManager x509TrustManager = (X509TrustManager) Util.readFieldOrNull(fieldOrNull, X509TrustManager.class, "x509TrustManager");
        return x509TrustManager == null ? (X509TrustManager) Util.readFieldOrNull(fieldOrNull, X509TrustManager.class, "trustManager") : x509TrustManager;
    }
}
