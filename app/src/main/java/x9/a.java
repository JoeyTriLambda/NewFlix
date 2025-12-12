package x9;

import com.google.gson.JsonIOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* compiled from: ReflectionHelper.java */
/* loaded from: classes.dex */
public final class a {
    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.9.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static void makeAccessible(Field field) throws JsonIOException, SecurityException {
        try {
            field.setAccessible(true);
        } catch (Exception e10) {
            throw new JsonIOException("Failed making field '" + field.getDeclaringClass().getName() + "#" + field.getName() + "' accessible; either change its visibility or write a custom TypeAdapter for its declaring type", e10);
        }
    }

    public static String tryMakeAccessible(Constructor<?> constructor) throws SecurityException {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder("Failed making constructor '");
            StringBuilder sb3 = new StringBuilder(constructor.getDeclaringClass().getName());
            sb3.append('#');
            sb3.append(constructor.getDeclaringClass().getSimpleName());
            sb3.append('(');
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i10 = 0; i10 < parameterTypes.length; i10++) {
                if (i10 > 0) {
                    sb3.append(", ");
                }
                sb3.append(parameterTypes[i10].getSimpleName());
            }
            sb3.append(')');
            sb2.append(sb3.toString());
            sb2.append("' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: ");
            sb2.append(e10.getMessage());
            return sb2.toString();
        }
    }
}
