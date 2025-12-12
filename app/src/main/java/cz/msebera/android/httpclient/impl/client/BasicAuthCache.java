package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.conn.SchemePortResolver;
import cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import cz.msebera.android.httpclient.util.Args;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Contract(threading = ThreadingBehavior.SAFE)
/* loaded from: classes2.dex */
public class BasicAuthCache implements AuthCache {
    public HttpClientAndroidLog log;
    private final Map<HttpHost, byte[]> map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver schemePortResolver) {
        this.log = new HttpClientAndroidLog(getClass());
        this.map = new ConcurrentHashMap();
        this.schemePortResolver = schemePortResolver == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver;
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void clear() {
        this.map.clear();
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public AuthScheme get(HttpHost httpHost) throws IOException {
        Args.notNull(httpHost, "HTTP host");
        byte[] bArr = this.map.get(getKey(httpHost));
        if (bArr != null) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                AuthScheme authScheme = (AuthScheme) objectInputStream.readObject();
                objectInputStream.close();
                return authScheme;
            } catch (IOException e10) {
                if (this.log.isWarnEnabled()) {
                    this.log.warn("Unexpected I/O error while de-serializing auth scheme", e10);
                }
            } catch (ClassNotFoundException e11) {
                if (this.log.isWarnEnabled()) {
                    this.log.warn("Unexpected error while de-serializing auth scheme", e11);
                }
                return null;
            }
        }
        return null;
    }

    public HttpHost getKey(HttpHost httpHost) {
        if (httpHost.getPort() <= 0) {
            try {
                return new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
            } catch (UnsupportedSchemeException unused) {
            }
        }
        return httpHost;
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void put(HttpHost httpHost, AuthScheme authScheme) throws IOException {
        Args.notNull(httpHost, "HTTP host");
        if (authScheme == null) {
            return;
        }
        if (!(authScheme instanceof Serializable)) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("Auth scheme " + authScheme.getClass() + " is not serializable");
                return;
            }
            return;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(authScheme);
            objectOutputStream.close();
            this.map.put(getKey(httpHost), byteArrayOutputStream.toByteArray());
        } catch (IOException e10) {
            if (this.log.isWarnEnabled()) {
                this.log.warn("Unexpected I/O error while serializing auth scheme", e10);
            }
        }
    }

    @Override // cz.msebera.android.httpclient.client.AuthCache
    public void remove(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.map.remove(getKey(httpHost));
    }

    public String toString() {
        return this.map.toString();
    }

    public BasicAuthCache() {
        this(null);
    }
}
