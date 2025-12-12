package o8;

import l8.p;
import s8.m;

/* compiled from: RemoteConfigDeferredProxy.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final h9.a<p9.a> f17049a;

    public h(h9.a<p9.a> aVar) {
        this.f17049a = aVar;
    }

    public void setupListener(m mVar) {
        if (mVar == null) {
            e.getLogger().w("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            ((p) this.f17049a).whenAvailable(new c1.c(new c(mVar), 12));
        }
    }
}
