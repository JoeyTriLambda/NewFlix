package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Deprecated
/* loaded from: classes2.dex */
class CloseableHttpResponseProxy implements InvocationHandler {
    private static final Constructor<?> CONSTRUCTOR;
    private final HttpResponse original;

    static {
        try {
            CONSTRUCTOR = Proxy.getProxyClass(CloseableHttpResponseProxy.class.getClassLoader(), CloseableHttpResponse.class).getConstructor(InvocationHandler.class);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public CloseableHttpResponseProxy(HttpResponse httpResponse) {
        this.original = httpResponse;
    }

    public static CloseableHttpResponse newProxy(HttpResponse httpResponse) {
        try {
            return (CloseableHttpResponse) CONSTRUCTOR.newInstance(new CloseableHttpResponseProxy(httpResponse));
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException(e10);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        } catch (InvocationTargetException e12) {
            throw new IllegalStateException(e12);
        }
    }

    public void close() throws IOException {
        EntityUtils.consume(this.original.getEntity());
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getName().equals("close")) {
            close();
            return null;
        }
        try {
            return method.invoke(this.original, objArr);
        } catch (InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause != null) {
                throw cause;
            }
            throw e10;
        }
    }
}
