package sf;

import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.reflect.Method;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import zf.i;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f19281a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final a f19282b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static a f19283c;

    /* compiled from: DebugMetadata.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f19284a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f19285b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f19286c;

        public a(Method method, Method method2, Method method3) {
            this.f19284a = method;
            this.f19285b = method2;
            this.f19286c = method3;
        }
    }

    public final String getModuleName(BaseContinuationImpl baseContinuationImpl) {
        i.checkNotNullParameter(baseContinuationImpl, "continuation");
        a aVar = f19283c;
        a aVar2 = f19282b;
        if (aVar == null) {
            try {
                a aVar3 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(MediationMetaData.KEY_NAME, new Class[0]));
                f19283c = aVar3;
                aVar = aVar3;
            } catch (Exception unused) {
                f19283c = aVar2;
                aVar = aVar2;
            }
        }
        if (aVar == aVar2) {
            return null;
        }
        Method method = aVar.f19284a;
        Object objInvoke = method != null ? method.invoke(baseContinuationImpl.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = aVar.f19285b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = aVar.f19286c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
