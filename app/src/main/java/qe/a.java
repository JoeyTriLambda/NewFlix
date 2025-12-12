package qe;

import cf.h;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayList;

/* compiled from: CompositeDisposable.java */
/* loaded from: classes2.dex */
public final class a implements b, te.a {

    /* renamed from: b, reason: collision with root package name */
    public h<b> f18147b;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f18148m;

    @Override // te.a
    public boolean add(b bVar) {
        ue.a.requireNonNull(bVar, "disposable is null");
        if (!this.f18148m) {
            synchronized (this) {
                if (!this.f18148m) {
                    h<b> hVar = this.f18147b;
                    if (hVar == null) {
                        hVar = new h<>();
                        this.f18147b = hVar;
                    }
                    hVar.add(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    @Override // te.a
    public boolean delete(b bVar) {
        ue.a.requireNonNull(bVar, "disposables is null");
        if (this.f18148m) {
            return false;
        }
        synchronized (this) {
            if (this.f18148m) {
                return false;
            }
            h<b> hVar = this.f18147b;
            if (hVar != null && hVar.remove(bVar)) {
                return true;
            }
            return false;
        }
    }

    @Override // qe.b
    public void dispose() {
        if (this.f18148m) {
            return;
        }
        synchronized (this) {
            if (this.f18148m) {
                return;
            }
            this.f18148m = true;
            h<b> hVar = this.f18147b;
            ArrayList arrayList = null;
            this.f18147b = null;
            if (hVar == null) {
                return;
            }
            for (Object obj : hVar.keys()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th2) {
                        re.a.throwIfFatal(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
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

    public boolean isDisposed() {
        return this.f18148m;
    }

    @Override // te.a
    public boolean remove(b bVar) {
        if (!delete(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public int size() {
        if (this.f18148m) {
            return 0;
        }
        synchronized (this) {
            if (this.f18148m) {
                return 0;
            }
            h<b> hVar = this.f18147b;
            return hVar != null ? hVar.size() : 0;
        }
    }
}
