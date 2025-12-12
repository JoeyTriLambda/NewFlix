package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzw extends MediaQueue.Callback {
    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsInsertedInRange(int i10, int i11) {
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsReloaded() {
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsRemovedAtIndexes(int[] iArr) {
        int length = iArr.length;
        if (length > 1) {
            throw null;
        }
        if (length <= 0) {
            return;
        }
        int i10 = iArr[0];
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsReorderedAtIndexes(List<Integer> list, int i10) {
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void itemsUpdatedAtIndexes(int[] iArr) {
        if (iArr.length <= 0) {
            return;
        }
        int i10 = iArr[0];
        throw null;
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void mediaQueueChanged() {
    }

    @Override // com.google.android.gms.cast.framework.media.MediaQueue.Callback
    public final void mediaQueueWillChange() {
    }
}
