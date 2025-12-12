package g3;

import android.content.ComponentName;
import android.content.Context;
import org.apache.commons.lang3.StringUtils;

/* compiled from: PackageManagerHelper.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12650a = w2.g.tagWithPrefix("PackageManagerHelper");

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z10) {
        String str = f12650a;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z10 ? 1 : 2, 1);
            w2.g gVar = w2.g.get();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls.getName());
            sb2.append(StringUtils.SPACE);
            sb2.append(z10 ? "enabled" : "disabled");
            gVar.debug(str, sb2.toString());
        } catch (Exception e10) {
            w2.g gVar2 = w2.g.get();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(cls.getName());
            sb3.append("could not be ");
            sb3.append(z10 ? "enabled" : "disabled");
            gVar2.debug(str, sb3.toString(), e10);
        }
    }
}
