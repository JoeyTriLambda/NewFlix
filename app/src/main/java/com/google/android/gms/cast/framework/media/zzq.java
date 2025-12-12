package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.cast.zzed;
import java.util.ArrayDeque;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzq extends TimerTask {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaQueue f6780b;

    public zzq(MediaQueue mediaQueue) {
        this.f6780b = mediaQueue;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        final MediaQueue mediaQueue = this.f6780b;
        if (mediaQueue.f6486h.isEmpty() || mediaQueue.f6489k != null || mediaQueue.f6480b == 0) {
            return;
        }
        ArrayDeque arrayDeque = mediaQueue.f6486h;
        PendingResult pendingResultZzj = mediaQueue.f6481c.zzj(CastUtils.zzf(arrayDeque));
        mediaQueue.f6489k = pendingResultZzj;
        pendingResultZzj.setResultCallback(new ResultCallback() { // from class: com.google.android.gms.cast.framework.media.zzp
            @Override // com.google.android.gms.common.api.ResultCallback
            public final void onResult(Result result) {
                MediaQueue mediaQueue2 = mediaQueue;
                mediaQueue2.getClass();
                Status status = ((RemoteMediaClient.MediaChannelResult) result).getStatus();
                int statusCode = status.getStatusCode();
                if (statusCode != 0) {
                    mediaQueue2.f6479a.w(String.format("Error fetching queue items, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
                }
                mediaQueue2.f6489k = null;
                if (mediaQueue2.f6486h.isEmpty()) {
                    return;
                }
                TimerTask timerTask = mediaQueue2.f6488j;
                zzed zzedVar = mediaQueue2.f6487i;
                zzedVar.removeCallbacks(timerTask);
                zzedVar.postDelayed(timerTask, 500L);
            }
        });
        arrayDeque.clear();
    }
}
