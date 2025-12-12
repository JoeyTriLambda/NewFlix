package c6;

import b6.h;

/* compiled from: CeaOutputBuffer.java */
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: p, reason: collision with root package name */
    public final d f5244p;

    public e(d dVar) {
        this.f5244p = dVar;
    }

    @Override // b6.h
    public final void release() {
        this.f5244p.releaseOutputBuffer(this);
    }
}
