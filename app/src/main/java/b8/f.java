package b8;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: Strings.java */
/* loaded from: classes.dex */
public final class f {
    public static String lenientFormat(String str, Object... objArr) {
        String string;
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i10 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i11 = 0; i11 < objArr.length; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    string = "null";
                } else {
                    try {
                        string = obj.toString();
                    } catch (Exception e10) {
                        String name = obj.getClass().getName();
                        String hexString = Integer.toHexString(System.identityHashCode(obj));
                        StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                        sb2.append(name);
                        sb2.append('@');
                        sb2.append(hexString);
                        String string2 = sb2.toString();
                        Logger logger = Logger.getLogger("com.google.common.base.Strings");
                        Level level = Level.WARNING;
                        String strValueOf2 = String.valueOf(string2);
                        logger.log(level, strValueOf2.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf2) : new String("Exception during lenientFormat for "), (Throwable) e10);
                        String name2 = e10.getClass().getName();
                        StringBuilder sb3 = new StringBuilder(name2.length() + String.valueOf(string2).length() + 9);
                        sb3.append("<");
                        sb3.append(string2);
                        sb3.append(" threw ");
                        sb3.append(name2);
                        sb3.append(">");
                        string = sb3.toString();
                    }
                }
                objArr[i11] = string;
            }
        }
        StringBuilder sb4 = new StringBuilder((objArr.length * 16) + strValueOf.length());
        int i12 = 0;
        while (i10 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i12)) != -1) {
            sb4.append((CharSequence) strValueOf, i12, iIndexOf);
            sb4.append(objArr[i10]);
            i12 = iIndexOf + 2;
            i10++;
        }
        sb4.append((CharSequence) strValueOf, i12, strValueOf.length());
        if (i10 < objArr.length) {
            sb4.append(" [");
            sb4.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb4.append(", ");
                sb4.append(objArr[i13]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }
}
