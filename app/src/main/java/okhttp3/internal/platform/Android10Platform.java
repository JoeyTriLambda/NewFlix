package okhttp3.internal.platform;

import android.annotation.SuppressLint;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import mf.k;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import zf.f;
import zf.i;

/* compiled from: Android10Platform.kt */
@SuppressSignatureCheck
/* loaded from: classes2.dex */
public final class Android10Platform extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private final List<SocketAdapter> socketAdapters;

    /* compiled from: Android10Platform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final Platform buildIfSupported() {
            if (isSupported()) {
                return new Android10Platform();
            }
            return null;
        }

        public final boolean isSupported() {
            return Android10Platform.isSupported;
        }
    }

    static {
        isSupported = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
    }

    public Android10Platform() {
        List listListOfNotNull = k.listOfNotNull(Android10SocketAdapter.Companion.buildIfSupported(), new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory()));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((SocketAdapter) obj).isSupported()) {
                arrayList.add(obj);
            }
        }
        this.socketAdapters = arrayList;
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        i.checkNotNullParameter(x509TrustManager, "trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleanerBuildIfSupported = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        return androidCertificateChainCleanerBuildIfSupported == null ? super.buildCertificateChainCleaner(x509TrustManager) : androidCertificateChainCleanerBuildIfSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Object next;
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        i.checkNotNullParameter(list, "protocols");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (((SocketAdapter) next).matchesSocket(sSLSocket)) {
                    break;
                }
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter == null) {
            return;
        }
        socketAdapter.configureTlsExtensions(sSLSocket, str, list);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Object next;
        i.checkNotNullParameter(sSLSocket, "sslSocket");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).matchesSocket(sSLSocket)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    @SuppressLint({"NewApi"})
    public boolean isCleartextTrafficPermitted(String str) {
        i.checkNotNullParameter(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object next;
        i.checkNotNullParameter(sSLSocketFactory, "sslSocketFactory");
        Iterator<T> it = this.socketAdapters.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SocketAdapter) next).matchesSocketFactory(sSLSocketFactory)) {
                break;
            }
        }
        SocketAdapter socketAdapter = (SocketAdapter) next;
        if (socketAdapter == null) {
            return null;
        }
        return socketAdapter.trustManager(sSLSocketFactory);
    }
}
