package androidx.mediarouter.app;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.media.MediaRouter2;
import java.util.Iterator;

/* compiled from: SystemOutputSwitcherDialogController.java */
/* loaded from: classes.dex */
public final class s {

    /* compiled from: SystemOutputSwitcherDialogController.java */
    public static class a {
        public static MediaRouter2 a(Context context) {
            return MediaRouter2.getInstance(context);
        }
    }

    /* compiled from: SystemOutputSwitcherDialogController.java */
    public static class b {
        public static boolean a(MediaRouter2 mediaRouter2) {
            return mediaRouter2.showSystemOutputSwitcher();
        }
    }

    public static boolean a(Context context) {
        ApplicationInfo applicationInfo;
        Intent intentPutExtra = new Intent().addFlags(268435456).setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName());
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intentPutExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.startActivity(intentPutExtra);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean showDialog(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 30
            r2 = 1
            r3 = 0
            r4 = 34
            if (r0 < r4) goto L17
            if (r0 < r1) goto L74
            android.media.MediaRouter2 r1 = androidx.mediarouter.app.s.a.a(r5)
            if (r0 < r4) goto L74
            boolean r0 = androidx.mediarouter.app.s.b.a(r1)
            goto L75
        L17:
            r4 = 31
            if (r0 < r4) goto L6d
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r1 = "com.android.systemui.action.LAUNCH_MEDIA_OUTPUT_DIALOG"
            android.content.Intent r0 = r0.setAction(r1)
            java.lang.String r1 = "com.android.systemui"
            android.content.Intent r0 = r0.setPackage(r1)
            java.lang.String r1 = r5.getPackageName()
            java.lang.String r4 = "package_name"
            android.content.Intent r0 = r0.putExtra(r4, r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            java.util.List r1 = r1.queryBroadcastReceivers(r0, r3)
            java.util.Iterator r1 = r1.iterator()
        L42:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L62
            java.lang.Object r4 = r1.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            if (r4 == 0) goto L42
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo
            if (r4 != 0) goto L57
            goto L42
        L57:
            int r4 = r4.flags
            r4 = r4 & 129(0x81, float:1.81E-43)
            if (r4 == 0) goto L42
            r5.sendBroadcast(r0)
            r0 = 1
            goto L63
        L62:
            r0 = 0
        L63:
            if (r0 != 0) goto L6b
            boolean r0 = a(r5)
            if (r0 == 0) goto L74
        L6b:
            r0 = 1
            goto L75
        L6d:
            if (r0 != r1) goto L74
            boolean r0 = a(r5)
            goto L75
        L74:
            r0 = 0
        L75:
            if (r0 == 0) goto L78
            return r2
        L78:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            java.lang.String r1 = "android.hardware.type.watch"
            boolean r0 = r0.hasSystemFeature(r1)
            if (r0 == 0) goto Lce
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.settings.BLUETOOTH_SETTINGS"
            r0.<init>(r1)
            r1 = 268468224(0x10008000, float:2.5342157E-29)
            android.content.Intent r0 = r0.addFlags(r1)
            java.lang.String r1 = "EXTRA_CONNECTION_ONLY"
            android.content.Intent r0 = r0.putExtra(r1, r2)
            java.lang.String r1 = "android.bluetooth.devicepicker.extra.FILTER_TYPE"
            android.content.Intent r0 = r0.putExtra(r1, r2)
            android.content.pm.PackageManager r1 = r5.getPackageManager()
            java.util.List r1 = r1.queryIntentActivities(r0, r3)
            java.util.Iterator r1 = r1.iterator()
        Laa:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto Lca
            java.lang.Object r4 = r1.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ActivityInfo r4 = r4.activityInfo
            if (r4 == 0) goto Laa
            android.content.pm.ApplicationInfo r4 = r4.applicationInfo
            if (r4 != 0) goto Lbf
            goto Laa
        Lbf:
            int r4 = r4.flags
            r4 = r4 & 129(0x81, float:1.81E-43)
            if (r4 == 0) goto Laa
            r5.startActivity(r0)
            r5 = 1
            goto Lcb
        Lca:
            r5 = 0
        Lcb:
            if (r5 == 0) goto Lce
            return r2
        Lce:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.s.showDialog(android.content.Context):boolean");
    }
}
