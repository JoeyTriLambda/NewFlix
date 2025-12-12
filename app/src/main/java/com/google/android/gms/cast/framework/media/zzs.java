package com.google.android.gms.cast.framework.media;

import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.MediaQueue;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
public final class zzs extends RemoteMediaClient.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaQueue f6782a;

    public zzs(MediaQueue mediaQueue) {
        this.f6782a = mediaQueue;
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void onStatusUpdated() {
        MediaQueue mediaQueue = this.f6782a;
        MediaStatus mediaStatus = mediaQueue.f6481c.getMediaStatus();
        long jZzb = (mediaStatus == null || mediaStatus.zzd()) ? 0L : mediaStatus.zzb();
        if (jZzb != mediaQueue.f6480b) {
            mediaQueue.f6480b = jZzb;
            mediaQueue.zzl();
            if (mediaQueue.f6480b != 0) {
                mediaQueue.zzo();
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzb(int[] iArr) {
        List listZzd = CastUtils.zzd(iArr);
        MediaQueue mediaQueue = this.f6782a;
        if (mediaQueue.f6482d.equals(listZzd)) {
            return;
        }
        mediaQueue.e();
        mediaQueue.f6484f.evictAll();
        mediaQueue.f6485g.clear();
        mediaQueue.f6482d = listZzd;
        MediaQueue.b(mediaQueue);
        mediaQueue.d();
        mediaQueue.c();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzc(int[] iArr, int i10) {
        int size;
        if (i10 == 0) {
            size = this.f6782a.f6482d.size();
        } else {
            size = this.f6782a.f6483e.get(i10, -1);
            if (size == -1) {
                this.f6782a.zzo();
                return;
            }
        }
        int length = iArr.length;
        this.f6782a.e();
        this.f6782a.f6482d.addAll(size, CastUtils.zzd(iArr));
        MediaQueue.b(this.f6782a);
        MediaQueue mediaQueue = this.f6782a;
        synchronized (mediaQueue.f6491m) {
            Iterator it = mediaQueue.f6491m.iterator();
            while (it.hasNext()) {
                ((MediaQueue.Callback) it.next()).itemsInsertedInRange(size, length);
            }
        }
        this.f6782a.c();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzd(MediaQueueItem[] mediaQueueItemArr) {
        HashSet hashSet = new HashSet();
        MediaQueue mediaQueue = this.f6782a;
        mediaQueue.f6485g.clear();
        int i10 = 0;
        while (true) {
            int length = mediaQueueItemArr.length;
            SparseIntArray sparseIntArray = mediaQueue.f6483e;
            if (i10 >= length) {
                ArrayList arrayList = mediaQueue.f6485g;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    int i11 = sparseIntArray.get(((Integer) it.next()).intValue(), -1);
                    if (i11 != -1) {
                        hashSet.add(Integer.valueOf(i11));
                    }
                }
                arrayList.clear();
                ArrayList arrayList2 = new ArrayList(hashSet);
                Collections.sort(arrayList2);
                mediaQueue.e();
                MediaQueue.a(mediaQueue, CastUtils.zzf(arrayList2));
                mediaQueue.c();
                return;
            }
            MediaQueueItem mediaQueueItem = mediaQueueItemArr[i10];
            int itemId = mediaQueueItem.getItemId();
            mediaQueue.f6484f.put(Integer.valueOf(itemId), mediaQueueItem);
            int i12 = sparseIntArray.get(itemId, -1);
            if (i12 == -1) {
                mediaQueue.zzo();
                return;
            } else {
                hashSet.add(Integer.valueOf(i12));
                i10++;
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zze(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            this.f6782a.f6484f.remove(Integer.valueOf(i10));
            int i11 = this.f6782a.f6483e.get(i10, -1);
            if (i11 == -1) {
                this.f6782a.zzo();
                return;
            } else {
                this.f6782a.f6483e.delete(i10);
                arrayList.add(Integer.valueOf(i11));
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Collections.sort(arrayList);
        this.f6782a.e();
        this.f6782a.f6482d.removeAll(CastUtils.zzd(iArr));
        MediaQueue.b(this.f6782a);
        MediaQueue mediaQueue = this.f6782a;
        int[] iArrZzf = CastUtils.zzf(arrayList);
        synchronized (mediaQueue.f6491m) {
            Iterator it = mediaQueue.f6491m.iterator();
            while (it.hasNext()) {
                ((MediaQueue.Callback) it.next()).itemsRemovedAtIndexes(iArrZzf);
            }
        }
        this.f6782a.c();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzf(List list, List list2, int i10) {
        int size;
        ArrayList arrayList = new ArrayList();
        if (i10 == 0) {
            size = this.f6782a.f6482d.size();
        } else if (list2.isEmpty()) {
            this.f6782a.f6479a.w("Received a Queue Reordered message with an empty reordered items IDs list.", new Object[0]);
            size = -1;
        } else {
            size = this.f6782a.f6483e.get(i10, -1);
            if (size == -1) {
                MediaQueue mediaQueue = this.f6782a;
                size = mediaQueue.f6483e.get(((Integer) list2.get(0)).intValue(), -1);
            }
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            int i11 = this.f6782a.f6483e.get(((Integer) it.next()).intValue(), -1);
            if (i11 == -1) {
                this.f6782a.zzo();
                return;
            }
            arrayList.add(Integer.valueOf(i11));
        }
        this.f6782a.e();
        MediaQueue mediaQueue2 = this.f6782a;
        mediaQueue2.f6482d = list;
        MediaQueue.b(mediaQueue2);
        MediaQueue mediaQueue3 = this.f6782a;
        synchronized (mediaQueue3.f6491m) {
            Iterator it2 = mediaQueue3.f6491m.iterator();
            while (it2.hasNext()) {
                ((MediaQueue.Callback) it2.next()).itemsReorderedAtIndexes(arrayList, size);
            }
        }
        this.f6782a.c();
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzg(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            int length = iArr.length;
            MediaQueue mediaQueue = this.f6782a;
            if (i10 >= length) {
                Collections.sort(arrayList);
                mediaQueue.e();
                MediaQueue.a(mediaQueue, CastUtils.zzf(arrayList));
                mediaQueue.c();
                return;
            }
            int i11 = iArr[i10];
            mediaQueue.f6484f.remove(Integer.valueOf(i11));
            int i12 = mediaQueue.f6483e.get(i11, -1);
            if (i12 == -1) {
                mediaQueue.zzo();
                return;
            } else {
                arrayList.add(Integer.valueOf(i12));
                i10++;
            }
        }
    }

    @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
    public final void zzh() {
        this.f6782a.zzo();
    }
}
