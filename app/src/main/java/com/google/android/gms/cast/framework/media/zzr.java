package com.google.android.gms.cast.framework.media;

import android.util.LruCache;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzr extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaQueue f6781a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzr(MediaQueue mediaQueue) {
        super(20);
        this.f6781a = mediaQueue;
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z10, Object obj, Object obj2, Object obj3) {
        Integer num = (Integer) obj;
        if (z10) {
            MediaQueue mediaQueue = this.f6781a;
            Preconditions.checkNotNull(mediaQueue.f6485g);
            mediaQueue.f6485g.add(num);
        }
    }
}
