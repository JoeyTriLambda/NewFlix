package te;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: ListCompositeDisposable.java */
/* loaded from: classes2.dex */
public final class b implements qe.b, a {

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f19912b;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f19913m;

    @Override // te.a
    public boolean add(qe.b bVar) {
        ue.a.requireNonNull(bVar, "d is null");
        if (!this.f19913m) {
            synchronized (this) {
                if (!this.f19913m) {
                    LinkedList linkedList = this.f19912b;
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        this.f19912b = linkedList;
                    }
                    linkedList.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // te.a
    public boolean delete(qe.b bVar) {
        ue.a.requireNonNull(bVar, "Disposable item is null");
        if (this.f19913m) {
            return false;
        }
        synchronized (this) {
            if (this.f19913m) {
                return false;
            }
            LinkedList linkedList = this.f19912b;
            if (linkedList != null && linkedList.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // qe.b
    public void dispose() {
        if (this.f19913m) {
            return;
        }
        synchronized (this) {
            if (this.f19913m) {
                return;
            }
            this.f19913m = true;
            LinkedList linkedList = this.f19912b;
            ArrayList arrayList = null;
            this.f19912b = null;
            if (linkedList == null) {
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    ((qe.b) it.next()).dispose();
                } catch (Throwable th2) {
                    re.a.throwIfFatal(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            if (arrayList != null) {
                if (arrayList.size() != 1) {
                    throw new CompositeException(arrayList);
                }
                throw ExceptionHelper.wrapOrThrow((Throwable) arrayList.get(0));
            }
        }
    }

    @Override // te.a
    public boolean remove(qe.b bVar) {
        if (!delete(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }
}
