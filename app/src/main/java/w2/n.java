package w2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.work.ExistingPeriodicWorkPolicy;
import java.util.Collections;
import java.util.List;
import x2.e0;

/* compiled from: WorkManager.java */
@SuppressLint({"AddedAbstractMethod"})
/* loaded from: classes.dex */
public abstract class n {
    public static n getInstance(Context context) {
        return e0.getInstance(context);
    }

    public static void initialize(Context context, androidx.work.a aVar) {
        e0.initialize(context, aVar);
    }

    public abstract i enqueue(List<? extends o> list);

    public final i enqueue(o oVar) {
        return enqueue(Collections.singletonList(oVar));
    }

    public abstract i enqueueUniquePeriodicWork(String str, ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, j jVar);
}
