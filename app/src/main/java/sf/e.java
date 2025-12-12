package sf;

import com.fasterxml.jackson.core.JsonPointer;
import java.lang.reflect.Field;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import zf.i;

/* compiled from: DebugMetadata.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        i.checkNotNullParameter(baseContinuationImpl, "<this>");
        d dVar = (d) baseContinuationImpl.getClass().getAnnotation(d.class);
        if (dVar == null) {
            return null;
        }
        int iV = dVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i10 = iIntValue >= 0 ? dVar.l()[iIntValue] : -1;
        String moduleName = g.f19281a.getModuleName(baseContinuationImpl);
        if (moduleName == null) {
            strC = dVar.c();
        } else {
            strC = moduleName + JsonPointer.SEPARATOR + dVar.c();
        }
        return new StackTraceElement(strC, dVar.m(), dVar.f(), i10);
    }
}
