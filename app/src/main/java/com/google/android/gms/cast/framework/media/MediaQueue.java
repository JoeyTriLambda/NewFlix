package com.google.android.gms.cast.framework.media;

import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzed;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public class MediaQueue {

    /* renamed from: b, reason: collision with root package name */
    public long f6480b;

    /* renamed from: c, reason: collision with root package name */
    public final RemoteMediaClient f6481c;

    /* renamed from: d, reason: collision with root package name */
    public List f6482d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseIntArray f6483e;

    /* renamed from: f, reason: collision with root package name */
    public LruCache f6484f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f6485g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayDeque f6486h;

    /* renamed from: i, reason: collision with root package name */
    public final zzed f6487i;

    /* renamed from: j, reason: collision with root package name */
    public final TimerTask f6488j;

    /* renamed from: k, reason: collision with root package name */
    public PendingResult f6489k;

    /* renamed from: l, reason: collision with root package name */
    public PendingResult f6490l;

    /* renamed from: m, reason: collision with root package name */
    public final Set f6491m = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with root package name */
    public final Logger f6479a = new Logger("MediaQueue");

    public MediaQueue(RemoteMediaClient remoteMediaClient) {
        this.f6481c = remoteMediaClient;
        Math.max(20, 1);
        this.f6482d = new ArrayList();
        this.f6483e = new SparseIntArray();
        this.f6485g = new ArrayList();
        this.f6486h = new ArrayDeque(20);
        this.f6487i = new zzed(Looper.getMainLooper());
        this.f6488j = new zzq(this);
        remoteMediaClient.registerCallback(new zzs(this));
        this.f6484f = new zzr(this);
        MediaStatus mediaStatus = remoteMediaClient.getMediaStatus();
        this.f6480b = (mediaStatus == null || mediaStatus.zzd()) ? 0L : mediaStatus.zzb();
        zzo();
    }

    public static void a(MediaQueue mediaQueue, int[] iArr) {
        synchronized (mediaQueue.f6491m) {
            Iterator it = mediaQueue.f6491m.iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).itemsUpdatedAtIndexes(iArr);
            }
        }
    }

    public static /* bridge */ /* synthetic */ void b(MediaQueue mediaQueue) {
        mediaQueue.f6483e.clear();
        for (int i10 = 0; i10 < mediaQueue.f6482d.size(); i10++) {
            mediaQueue.f6483e.put(((Integer) mediaQueue.f6482d.get(i10)).intValue(), i10);
        }
    }

    public final void c() {
        synchronized (this.f6491m) {
            Iterator it = this.f6491m.iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).mediaQueueChanged();
            }
        }
    }

    public final void d() {
        synchronized (this.f6491m) {
            Iterator it = this.f6491m.iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).itemsReloaded();
            }
        }
    }

    public final void e() {
        synchronized (this.f6491m) {
            Iterator it = this.f6491m.iterator();
            while (it.hasNext()) {
                ((Callback) it.next()).mediaQueueWillChange();
            }
        }
    }

    public final void zzl() {
        e();
        this.f6482d.clear();
        this.f6483e.clear();
        this.f6484f.evictAll();
        this.f6485g.clear();
        this.f6487i.removeCallbacks(this.f6488j);
        this.f6486h.clear();
        PendingResult pendingResult = this.f6490l;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.f6490l = null;
        }
        PendingResult pendingResult2 = this.f6489k;
        if (pendingResult2 != null) {
            pendingResult2.cancel();
            this.f6489k = null;
        }
        d();
        c();
    }

    public final void zzo() {
        PendingResult pendingResult;
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.f6480b != 0 && (pendingResult = this.f6490l) == null) {
            if (pendingResult != null) {
                pendingResult.cancel();
                this.f6490l = null;
            }
            PendingResult pendingResult2 = this.f6489k;
            if (pendingResult2 != null) {
                pendingResult2.cancel();
                this.f6489k = null;
            }
            PendingResult pendingResultZzi = this.f6481c.zzi();
            this.f6490l = pendingResultZzi;
            pendingResultZzi.setResultCallback(new ResultCallback() { // from class: com.google.android.gms.cast.framework.media.zzo
                @Override // com.google.android.gms.common.api.ResultCallback
                public final void onResult(Result result) {
                    MediaQueue mediaQueue = this.f6778a;
                    mediaQueue.getClass();
                    Status status = ((RemoteMediaClient.MediaChannelResult) result).getStatus();
                    int statusCode = status.getStatusCode();
                    if (statusCode != 0) {
                        mediaQueue.f6479a.w(String.format("Error fetching queue item ids, statusCode=%s, statusMessage=%s", Integer.valueOf(statusCode), status.getStatusMessage()), new Object[0]);
                    }
                    mediaQueue.f6490l = null;
                    if (mediaQueue.f6486h.isEmpty()) {
                        return;
                    }
                    TimerTask timerTask = mediaQueue.f6488j;
                    zzed zzedVar = mediaQueue.f6487i;
                    zzedVar.removeCallbacks(timerTask);
                    zzedVar.postDelayed(timerTask, 500L);
                }
            });
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
    public static abstract class Callback {
        public void itemsReloaded() {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }

        public void itemsRemovedAtIndexes(int[] iArr) {
        }

        public void itemsUpdatedAtIndexes(int[] iArr) {
        }

        public void itemsInsertedInRange(int i10, int i11) {
        }

        public void itemsReorderedAtIndexes(List<Integer> list, int i10) {
        }
    }
}
