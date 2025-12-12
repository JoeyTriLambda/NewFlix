package com.google.android.gms.cast;

import android.view.Display;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzam implements OnCompleteListener {
    public zzam() {
        throw null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        if (!task.isSuccessful()) {
            CastRemoteDisplayLocalService.f6164w.e("Connection was not successful", new Object[0]);
            throw null;
        }
        Logger logger = CastRemoteDisplayLocalService.f6164w;
        logger.d("startRemoteDisplay successful", new Object[0]);
        synchronized (CastRemoteDisplayLocalService.f6165x) {
            if (CastRemoteDisplayLocalService.f6167z == null) {
                logger.d("Remote Display started but session already cancelled", new Object[0]);
                throw null;
            }
        }
        if (((Display) task.getResult()) != null) {
            throw null;
        }
        logger.e("Cast Remote Display session created without display", new Object[0]);
        CastRemoteDisplayLocalService.f6166y.set(false);
        throw null;
    }
}
