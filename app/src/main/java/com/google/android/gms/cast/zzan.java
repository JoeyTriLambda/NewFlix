package com.google.android.gms.cast;

import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzan implements OnCompleteListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CastRemoteDisplayLocalService f6927a;

    public zzan(CastRemoteDisplayLocalService castRemoteDisplayLocalService) {
        this.f6927a = castRemoteDisplayLocalService;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        boolean zIsSuccessful = task.isSuccessful();
        CastRemoteDisplayLocalService castRemoteDisplayLocalService = this.f6927a;
        if (zIsSuccessful) {
            Logger logger = CastRemoteDisplayLocalService.f6164w;
            castRemoteDisplayLocalService.a("remote display stopped");
        } else {
            Logger logger2 = CastRemoteDisplayLocalService.f6164w;
            castRemoteDisplayLocalService.a("Unable to stop the remote display, result unsuccessful");
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) castRemoteDisplayLocalService.f6169m.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplaySessionError(new Status(2202));
            }
        }
        castRemoteDisplayLocalService.getClass();
    }
}
