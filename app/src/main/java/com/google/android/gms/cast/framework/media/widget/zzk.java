package com.google.android.gms.cast.framework.media.widget;

import android.os.Looper;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.internal.cast.zzed;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzk extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RemoteMediaClient f6711b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ExpandedControllerActivity f6712m;

    public zzk(ExpandedControllerActivity expandedControllerActivity, RemoteMediaClient remoteMediaClient) {
        this.f6712m = expandedControllerActivity;
        this.f6711b = remoteMediaClient;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        new zzed(Looper.getMainLooper()).post(new zzj(this));
    }
}
