package org.apache.commons.lang3;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
import o1.a;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.text.StrBuilder;

/* loaded from: classes2.dex */
public class ObjectUtils {
    private static final char AT_SIGN = '@';
    public static final Null NULL = new Null();

    public static class Null implements Serializable {
        private static final long serialVersionUID = 7092611880189329093L;

        private Object readResolve() {
            return ObjectUtils.NULL;
        }
    }

    public static byte CONST(byte b10) {
        return b10;
    }

    public static byte CONST_BYTE(int i10) {
        if (i10 < -128 || i10 > 127) {
            throw new IllegalArgumentException(a.d("Supplied value must be a valid byte literal between -128 and 127: [", i10, "]"));
        }
        return (byte) i10;
    }

    public static short CONST_SHORT(int i10) {
        if (i10 < -32768 || i10 > 32767) {
            throw new IllegalArgumentException(a.d("Supplied value must be a valid byte literal between -32768 and 32767: [", i10, "]"));
        }
        return (short) i10;
    }

    public static boolean allNotNull(Object... objArr) {
        if (objArr == null) {
            return false;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyNotNull(Object... objArr) {
        return firstNonNull(objArr) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T clone(T t10) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (!(t10 instanceof Cloneable)) {
            return null;
        }
        if (!t10.getClass().isArray()) {
            try {
                return (T) t10.getClass().getMethod("clone", new Class[0]).invoke(t10, new Object[0]);
            } catch (IllegalAccessException e10) {
                throw new CloneFailedException("Cannot clone Cloneable type ".concat(t10.getClass().getName()), e10);
            } catch (NoSuchMethodException e11) {
                throw new CloneFailedException("Cloneable type " + t10.getClass().getName() + " has no clone method", e11);
            } catch (InvocationTargetException e12) {
                throw new CloneFailedException("Exception cloning Cloneable type ".concat(t10.getClass().getName()), e12.getCause());
            }
        }
        Class<?> componentType = t10.getClass().getComponentType();
        if (!componentType.isPrimitive()) {
            return (T) ((Object[]) t10).clone();
        }
        int length = Array.getLength(t10);
        T t11 = (T) Array.newInstance(componentType, length);
        while (true) {
            int i10 = length - 1;
            if (length <= 0) {
                return t11;
            }
            Array.set(t11, i10, Array.get(t10, i10));
            length = i10;
        }
    }

    public static <T> T cloneIfPossible(T t10) {
        T t11 = (T) clone(t10);
        return t11 == null ? t10 : t11;
    }

    public static <T extends Comparable<? super T>> int compare(T t10, T t11) {
        return compare(t10, t11, false);
    }

    public static <T> T defaultIfNull(T t10, T t11) {
        return t10 != null ? t10 : t11;
    }

    @Deprecated
    public static boolean equals(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    @SafeVarargs
    public static <T> T firstNonNull(T... tArr) {
        if (tArr == null) {
            return null;
        }
        for (T t10 : tArr) {
            if (t10 != null) {
                return t10;
            }
        }
        return null;
    }

    @Deprecated
    public static int hashCode(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Deprecated
    public static int hashCodeMulti(Object... objArr) {
        int iHashCode = 1;
        if (objArr != null) {
            for (Object obj : objArr) {
                iHashCode = (iHashCode * 31) + hashCode(obj);
            }
        }
        return iHashCode;
    }

    public static String identityToString(Object obj) {
        if (obj == null) {
            return null;
        }
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        StringBuilder sb2 = new StringBuilder(hexString.length() + name.length() + 1);
        sb2.append(name);
        sb2.append(AT_SIGN);
        sb2.append(hexString);
        return sb2.toString();
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T max(T... tArr) {
        T t10 = null;
        if (tArr != null) {
            for (T t11 : tArr) {
                if (compare(t11, t10, false) > 0) {
                    t10 = t11;
                }
            }
        }
        return t10;
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T median(T... tArr) {
        Validate.notEmpty(tArr);
        Validate.noNullElements(tArr);
        TreeSet treeSet = new TreeSet();
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    @SafeVarargs
    public static <T extends Comparable<? super T>> T min(T... tArr) {
        T t10 = null;
        if (tArr != null) {
            for (T t11 : tArr) {
                if (compare(t11, t10, true) < 0) {
                    t10 = t11;
                }
            }
        }
        return t10;
    }

    @SafeVarargs
    public static <T> T mode(T... tArr) {
        if (!ArrayUtils.isNotEmpty(tArr)) {
            return null;
        }
        HashMap map = new HashMap(tArr.length);
        int i10 = 0;
        for (T t10 : tArr) {
            MutableInt mutableInt = (MutableInt) map.get(t10);
            if (mutableInt == null) {
                map.put(t10, new MutableInt(1));
            } else {
                mutableInt.increment();
            }
        }
        while (true) {
            T t11 = null;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue = ((MutableInt) entry.getValue()).intValue();
                if (iIntValue == i10) {
                    break;
                }
                if (iIntValue > i10) {
                    t11 = (T) entry.getKey();
                    i10 = iIntValue;
                }
            }
            return t11;
        }
    }

    public static boolean notEqual(Object obj, Object obj2) {
        return !equals(obj, obj2);
    }

    @Deprecated
    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static char CONST(char c10) {
        return c10;
    }

    public static <T extends Comparable<? super T>> int compare(T t10, T t11, boolean z10) {
        if (t10 == t11) {
            return 0;
        }
        return t10 == null ? z10 ? 1 : -1 : t11 == null ? z10 ? -1 : 1 : t10.compareTo(t11);
    }

    @Deprecated
    public static String toString(Object obj, String str) {
        return obj == null ? str : obj.toString();
    }

    public static double CONST(double d10) {
        return d10;
    }

    public static float CONST(float f10) {
        return f10;
    }

    public static int CONST(int i10) {
        return i10;
    }

    public static long CONST(long j10) {
        return j10;
    }

    @SafeVarargs
    public static <T> T median(Comparator<T> comparator, T... tArr) {
        Validate.notEmpty(tArr, "null/empty items", new Object[0]);
        Validate.noNullElements(tArr);
        Validate.notNull(comparator, "null comparator", new Object[0]);
        TreeSet treeSet = new TreeSet(comparator);
        Collections.addAll(treeSet, tArr);
        return (T) treeSet.toArray()[(treeSet.size() - 1) / 2];
    }

    public static <T> T CONST(T t10) {
        return t10;
    }

    public static short CONST(short s10) {
        return s10;
    }

    public static void identityToString(Appendable appendable, Object obj) throws IOException {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        appendable.append(obj.getClass().getName()).append(AT_SIGN).append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static boolean CONST(boolean z10) {
        return z10;
    }

    @Deprecated
    public static void identityToString(StrBuilder strBuilder, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        strBuilder.ensureCapacity(hexString.length() + name.length() + strBuilder.length() + 1);
        strBuilder.append(name).append(AT_SIGN).append(hexString);
    }

    public static void identityToString(StringBuffer stringBuffer, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        stringBuffer.ensureCapacity(hexString.length() + name.length() + stringBuffer.length() + 1);
        stringBuffer.append(name);
        stringBuffer.append(AT_SIGN);
        stringBuffer.append(hexString);
    }

    public static void identityToString(StringBuilder sb2, Object obj) {
        Validate.notNull(obj, "Cannot get the toString of a null object", new Object[0]);
        String name = obj.getClass().getName();
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        sb2.ensureCapacity(hexString.length() + name.length() + sb2.length() + 1);
        sb2.append(name);
        sb2.append(AT_SIGN);
        sb2.append(hexString);
    }
}
