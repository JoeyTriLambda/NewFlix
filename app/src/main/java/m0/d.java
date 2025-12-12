package m0;

import android.content.Context;
import android.os.Process;
import l0.h;

/* compiled from: PermissionChecker.java */
/* loaded from: classes.dex */
public final class d {
    public static int checkPermission(Context context, String str, int i10, int i11, String str2) {
        if (context.checkPermission(str, i10, i11) == -1) {
            return -1;
        }
        String strPermissionToOp = h.permissionToOp(str);
        if (strPermissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return (Process.myUid() == i11 && w0.c.equals(context.getPackageName(), str2) ? h.checkOrNoteProxyOp(context, i11, strPermissionToOp, str2) : h.noteProxyOpNoThrow(context, strPermissionToOp, str2)) == 0 ? 0 : -2;
    }

    public static int checkSelfPermission(Context context, String str) {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
