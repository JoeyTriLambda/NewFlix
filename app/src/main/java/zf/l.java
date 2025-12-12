package zf;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference2;

/* compiled from: ReflectionFactory.java */
/* loaded from: classes2.dex */
public final class l {
    public gg.b getOrCreateKotlinClass(Class cls) {
        return new d(cls);
    }

    public gg.c getOrCreateKotlinPackage(Class cls, String str) {
        return new j(cls, str);
    }

    public String renderLambdaToString(Lambda lambda) {
        return renderLambdaToString((g) lambda);
    }

    public String renderLambdaToString(g gVar) {
        String string = gVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }

    public gg.d function(FunctionReference functionReference) {
        return functionReference;
    }

    public gg.e property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public gg.f property2(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }
}
