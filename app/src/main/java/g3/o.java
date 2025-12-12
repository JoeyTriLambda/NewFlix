package g3;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProcessUtils.kt */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12652a;

    static {
        String strTagWithPrefix = w2.g.tagWithPrefix("ProcessUtils");
        zf.i.checkNotNullExpressionValue(strTagWithPrefix, "tagWithPrefix(\"ProcessUtils\")");
        f12652a = strTagWithPrefix;
    }

    public static final boolean isDefaultProcess(Context context, androidx.work.a aVar) {
        String processName;
        Object next;
        Object objInvoke;
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(aVar, "configuration");
        if (Build.VERSION.SDK_INT >= 28) {
            processName = a.f12634a.getProcessName();
        } else {
            processName = null;
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, w2.n.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, new Object[0]);
                zf.i.checkNotNull(objInvoke);
            } catch (Throwable th2) {
                w2.g.get().debug(f12652a, "Unable to check ActivityThread for processName", th2);
            }
            if (objInvoke instanceof String) {
                processName = (String) objInvoke;
            } else {
                int iMyPid = Process.myPid();
                Object systemService = context.getSystemService("activity");
                zf.i.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<T> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if (((ActivityManager.RunningAppProcessInfo) next).pid == iMyPid) {
                            break;
                        }
                    }
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                    if (runningAppProcessInfo != null) {
                        processName = runningAppProcessInfo.processName;
                    }
                }
            }
        }
        String defaultProcessName = aVar.getDefaultProcessName();
        return !(defaultProcessName == null || defaultProcessName.length() == 0) ? zf.i.areEqual(processName, aVar.getDefaultProcessName()) : zf.i.areEqual(processName, context.getApplicationInfo().processName);
    }
}
