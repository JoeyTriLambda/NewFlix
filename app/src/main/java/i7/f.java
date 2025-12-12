package i7;

import android.os.Build;
import java.util.Locale;

/* compiled from: ManufacturerUtils.java */
/* loaded from: classes.dex */
public final class f {
    public static boolean isMeizuDevice() {
        String str = Build.MANUFACTURER;
        return (str != null ? str.toLowerCase(Locale.ENGLISH) : "").equals("meizu");
    }
}
