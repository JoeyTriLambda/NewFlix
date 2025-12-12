package g3;

import android.os.Build;
import androidx.work.b;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* compiled from: EnqueueUtils.kt */
/* loaded from: classes.dex */
public final class d {
    public static final f3.t tryDelegateConstrainedWorkSpec(f3.t tVar) throws Throwable {
        zf.i.checkNotNullParameter(tVar, "workSpec");
        w2.b bVar = tVar.f11435j;
        String name = ConstraintTrackingWorker.class.getName();
        String str = tVar.f11428c;
        if (zf.i.areEqual(str, name)) {
            return tVar;
        }
        if (!bVar.requiresBatteryNotLow() && !bVar.requiresStorageNotLow()) {
            return tVar;
        }
        androidx.work.b bVarBuild = new b.a().putAll(tVar.f11430e).putString("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str).build();
        zf.i.checkNotNullExpressionValue(bVarBuild, "Builder().putAll(workSpe…ame)\n            .build()");
        String name2 = ConstraintTrackingWorker.class.getName();
        zf.i.checkNotNullExpressionValue(name2, MediationMetaData.KEY_NAME);
        return tVar.copy((1048555 & 1) != 0 ? tVar.f11426a : null, (1048555 & 2) != 0 ? tVar.f11427b : null, (1048555 & 4) != 0 ? tVar.f11428c : name2, (1048555 & 8) != 0 ? tVar.f11429d : null, (1048555 & 16) != 0 ? tVar.f11430e : bVarBuild, (1048555 & 32) != 0 ? tVar.f11431f : null, (1048555 & 64) != 0 ? tVar.f11432g : 0L, (1048555 & 128) != 0 ? tVar.f11433h : 0L, (1048555 & 256) != 0 ? tVar.f11434i : 0L, (1048555 & 512) != 0 ? tVar.f11435j : null, (1048555 & 1024) != 0 ? tVar.f11436k : 0, (1048555 & 2048) != 0 ? tVar.f11437l : null, (1048555 & 4096) != 0 ? tVar.f11438m : 0L, (1048555 & 8192) != 0 ? tVar.f11439n : 0L, (1048555 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? tVar.f11440o : 0L, (1048555 & 32768) != 0 ? tVar.f11441p : 0L, (1048555 & 65536) != 0 ? tVar.f11442q : false, (131072 & 1048555) != 0 ? tVar.f11443r : null, (1048555 & 262144) != 0 ? tVar.f11444s : 0, (1048555 & 524288) != 0 ? tVar.f11445t : 0);
    }

    public static final f3.t wrapInConstraintTrackingWorkerIfNeeded(List<? extends x2.t> list, f3.t tVar) throws ClassNotFoundException {
        zf.i.checkNotNullParameter(list, "schedulers");
        zf.i.checkNotNullParameter(tVar, "workSpec");
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (23 <= i10 && i10 < 26) {
            return tryDelegateConstrainedWorkSpec(tVar);
        }
        if (i10 > 22) {
            return tVar;
        }
        try {
            Class<?> cls = Class.forName("androidx.work.impl.background.gcm.GcmScheduler");
            List<? extends x2.t> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (cls.isAssignableFrom(((x2.t) it.next()).getClass())) {
                        break;
                    }
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        z10 = false;
        return z10 ? tryDelegateConstrainedWorkSpec(tVar) : tVar;
    }
}
