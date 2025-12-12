package p3;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public final class m implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f17534b;

    public m(n nVar) {
        this.f17534b = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f17534b.f17539d == null) {
            return;
        }
        l<T> lVar = this.f17534b.f17539d;
        if (lVar.getValue() != null) {
            n.a(this.f17534b, lVar.getValue());
            return;
        }
        n nVar = this.f17534b;
        Throwable exception = lVar.getException();
        synchronized (nVar) {
            ArrayList arrayList = new ArrayList(nVar.f17537b);
            if (arrayList.isEmpty()) {
                a4.d.warning("Lottie encountered an error but no failure listener was added:", exception);
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((h) it.next()).onResult(exception);
            }
        }
    }
}
