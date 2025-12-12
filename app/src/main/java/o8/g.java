package o8;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mf.k;
import mf.l;
import mf.q;
import t8.f0;
import zf.i;

/* compiled from: ProcessDetailsProvider.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f17048a = new g();

    public static /* synthetic */ f0.e.d.a.c buildProcessDetails$default(g gVar, String str, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = 0;
        }
        if ((i12 & 8) != 0) {
            z10 = false;
        }
        return gVar.buildProcessDetails(str, i10, i11, z10);
    }

    public final f0.e.d.a.c buildProcessDetails(String str, int i10, int i11) {
        i.checkNotNullParameter(str, "processName");
        return buildProcessDetails$default(this, str, i10, i11, false, 8, null);
    }

    public final List<f0.e.d.a.c> getAppProcessDetails(Context context) {
        i.checkNotNullParameter(context, "context");
        int i10 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = k.emptyList();
        }
        List listFilterNotNull = q.filterNotNull(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : listFilterNotNull) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i10) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(l.collectionSizeOrDefault(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(f0.e.d.a.c.builder().setProcessName(runningAppProcessInfo.processName).setPid(runningAppProcessInfo.pid).setImportance(runningAppProcessInfo.importance).setDefaultProcess(i.areEqual(runningAppProcessInfo.processName, str)).build());
        }
        return arrayList2;
    }

    public final f0.e.d.a.c getCurrentProcessDetails(Context context) {
        Object next;
        String processName;
        i.checkNotNullParameter(context, "context");
        int iMyPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((f0.e.d.a.c) next).getPid() == iMyPid) {
                break;
            }
        }
        f0.e.d.a.c cVar = (f0.e.d.a.c) next;
        if (cVar != null) {
            return cVar;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            processName = Process.myProcessName();
            i.checkNotNullExpressionValue(processName, "{\n      Process.myProcessName()\n    }");
        } else if (i10 < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        return buildProcessDetails$default(this, processName, iMyPid, 0, false, 12, null);
    }

    public final f0.e.d.a.c buildProcessDetails(String str, int i10, int i11, boolean z10) {
        i.checkNotNullParameter(str, "processName");
        f0.e.d.a.c cVarBuild = f0.e.d.a.c.builder().setProcessName(str).setPid(i10).setImportance(i11).setDefaultProcess(z10).build();
        i.checkNotNullExpressionValue(cVarBuild, "builder()\n      .setProc…ltProcess)\n      .build()");
        return cVarBuild;
    }
}
