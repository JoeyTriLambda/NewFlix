package zf;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference2;

/* compiled from: Reflection.java */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final l f22728a;

    /* renamed from: b, reason: collision with root package name */
    public static final gg.b[] f22729b;

    static {
        l lVar = null;
        try {
            lVar = (l) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new l();
        }
        f22728a = lVar;
        f22729b = new gg.b[0];
    }

    public static gg.d function(FunctionReference functionReference) {
        return f22728a.function(functionReference);
    }

    public static gg.b getOrCreateKotlinClass(Class cls) {
        return f22728a.getOrCreateKotlinClass(cls);
    }

    public static gg.c getOrCreateKotlinPackage(Class cls) {
        return f22728a.getOrCreateKotlinPackage(cls, "");
    }

    public static gg.e property0(PropertyReference0 propertyReference0) {
        return f22728a.property0(propertyReference0);
    }

    public static gg.f property2(PropertyReference2 propertyReference2) {
        return f22728a.property2(propertyReference2);
    }

    public static String renderLambdaToString(Lambda lambda) {
        return f22728a.renderLambdaToString(lambda);
    }

    public static String renderLambdaToString(g gVar) {
        return f22728a.renderLambdaToString(gVar);
    }
}
