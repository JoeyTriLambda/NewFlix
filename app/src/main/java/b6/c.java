package b6;

/* compiled from: SimpleSubtitleOutputBuffer.java */
/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: p, reason: collision with root package name */
    public final b f4780p;

    public c(b bVar) {
        this.f4780p = bVar;
    }

    @Override // b6.h
    public final void release() {
        this.f4780p.releaseOutputBuffer((h) this);
    }
}
