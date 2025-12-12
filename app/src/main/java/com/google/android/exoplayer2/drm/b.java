package com.google.android.exoplayer2.drm;

import pc.a;

/* compiled from: DefaultDrmSessionManager.java */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f5833b;

    public b(a aVar) {
        this.f5833b = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((a.b) this.f5833b.f5807b).onDrmKeysLoaded();
    }
}
