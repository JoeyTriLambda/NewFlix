package ef;

import ne.q;

/* compiled from: DefaultObserver.java */
/* loaded from: classes2.dex */
public abstract class b<T> implements q<T> {

    /* renamed from: b, reason: collision with root package name */
    public qe.b f11314b;

    @Override // ne.q
    public final void onSubscribe(qe.b bVar) {
        if (cf.e.validate(this.f11314b, bVar, getClass())) {
            this.f11314b = bVar;
            onStart();
        }
    }

    public void onStart() {
    }
}
