package v2;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: WebViewGlueCommunicator.java */
/* loaded from: classes.dex */
public final class m {

    /* compiled from: WebViewGlueCommunicator.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final o f20442a;

        static {
            o fVar;
            try {
                fVar = new p((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, m.a()));
            } catch (ClassNotFoundException unused) {
                fVar = new f();
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (NoSuchMethodException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException(e12);
            }
            f20442a = fVar;
        }
    }

    public static InvocationHandler a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, getWebViewClassLoader()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke(null, new Object[0]);
    }

    public static o getFactory() {
        return a.f20442a;
    }

    public static ClassLoader getWebViewClassLoader() throws NoSuchMethodException, SecurityException {
        if (Build.VERSION.SDK_INT >= 28) {
            return d.getWebViewClassLoader();
        }
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, new Object[0]).getClass().getClassLoader();
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        } catch (InvocationTargetException e12) {
            throw new RuntimeException(e12);
        }
    }
}
