package r9;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: ProcessDetailsProvider.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f18865a = new i();

    public final List<h> getAppProcessDetails(Context context) {
        zf.i.checkNotNullParameter(context, "context");
        int i10 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = mf.k.emptyList();
        }
        List listFilterNotNull = mf.q.filterNotNull(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i10) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(mf.l.collectionSizeOrDefault(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            zf.i.checkNotNullExpressionValue(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new h(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, zf.i.areEqual(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final h getCurrentProcessDetails(Context context) {
        Object next;
        zf.i.checkNotNullParameter(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((h) next).getPid() == iMyPid) {
                break;
            }
        }
        h hVar = (h) next;
        return hVar == null ? new h(getProcessName$com_google_firebase_firebase_sessions(), iMyPid, 0, false) : hVar;
    }

    public final String getProcessName$com_google_firebase_firebase_sessions() throws Throwable {
        String processName;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            String strMyProcessName = Process.myProcessName();
            zf.i.checkNotNullExpressionValue(strMyProcessName, "myProcessName()");
            return strMyProcessName;
        }
        if (i10 >= 28 && (processName = Application.getProcessName()) != null) {
            return processName;
        }
        String myProcessName = ProcessUtils.getMyProcessName();
        return myProcessName != null ? myProcessName : "";
    }
}
