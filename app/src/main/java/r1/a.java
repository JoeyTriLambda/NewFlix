package r1;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import androidx.leanback.widget.q0;
import java.util.Iterator;

/* compiled from: Settings.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f18350c;

    /* renamed from: a, reason: collision with root package name */
    public boolean f18351a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f18352b;

    /* compiled from: Settings.java */
    /* renamed from: r1.a$a, reason: collision with other inner class name */
    public static class C0235a {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f18353a;

        /* renamed from: b, reason: collision with root package name */
        public final String f18354b;

        public C0235a(Resources resources, String str) {
            this.f18353a = resources;
            this.f18354b = str;
        }

        public boolean getBoolean(String str, boolean z10) {
            String str2 = this.f18354b;
            Resources resources = this.f18353a;
            int identifier = resources.getIdentifier(str, "bool", str2);
            return identifier > 0 ? resources.getBoolean(identifier) : z10;
        }
    }

    public a(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getPackageManager();
        Iterator<ResolveInfo> it = packageManager.queryBroadcastReceivers(new Intent("android.support.v17.leanback.action.PARTNER_CUSTOMIZATION"), 0).iterator();
        Resources resourcesForApplication = null;
        String str = null;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            String str2 = activityInfo.packageName;
            if (str2 != null) {
                if ((activityInfo.applicationInfo.flags & 1) != 0) {
                    try {
                        resourcesForApplication = packageManager.getResourcesForApplication(str2);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
            }
            str = str2;
            if (resourcesForApplication != null) {
                break;
            }
        }
        C0235a c0235a = resourcesForApplication != null ? new C0235a(resourcesForApplication, str) : null;
        if (q0.supportsDynamicShadow()) {
            this.f18351a = false;
            if (c0235a != null) {
                this.f18351a = c0235a.getBoolean("leanback_prefer_static_shadows", false);
            }
        } else {
            this.f18351a = true;
        }
        this.f18352b = false;
        if (c0235a != null) {
            this.f18352b = c0235a.getBoolean("leanback_outline_clipping_disabled", false);
        }
    }

    public static a getInstance(Context context) {
        if (f18350c == null) {
            f18350c = new a(context);
        }
        return f18350c;
    }

    public boolean isOutlineClippingDisabled() {
        return this.f18352b;
    }

    public boolean preferStaticShadows() {
        return this.f18351a;
    }
}
