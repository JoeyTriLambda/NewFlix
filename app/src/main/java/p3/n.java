package p3;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* compiled from: LottieTask.java */
/* loaded from: classes.dex */
public final class n<T> {

    /* renamed from: e, reason: collision with root package name */
    public static final ExecutorService f17535e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f17536a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f17537b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f17538c;

    /* renamed from: d, reason: collision with root package name */
    public volatile l<T> f17539d;

    /* compiled from: LottieTask.java */
    public class a extends FutureTask<l<T>> {
        public a(Callable<l<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            n nVar = n.this;
            if (isCancelled()) {
                return;
            }
            try {
                nVar.b(get());
            } catch (InterruptedException | ExecutionException e10) {
                nVar.b(new l<>(e10));
            }
        }
    }

    public n() {
        throw null;
    }

    public n(Callable<l<T>> callable) {
        this.f17536a = new LinkedHashSet(1);
        this.f17537b = new LinkedHashSet(1);
        this.f17538c = new Handler(Looper.getMainLooper());
        this.f17539d = null;
        f17535e.execute(new a(callable));
    }

    public static void a(n nVar, Object obj) {
        synchronized (nVar) {
            Iterator it = new ArrayList(nVar.f17536a).iterator();
            while (it.hasNext()) {
                ((h) it.next()).onResult(obj);
            }
        }
    }

    public synchronized n<T> addFailureListener(h<Throwable> hVar) {
        if (this.f17539d != null && this.f17539d.getException() != null) {
            hVar.onResult(this.f17539d.getException());
        }
        this.f17537b.add(hVar);
        return this;
    }

    public synchronized n<T> addListener(h<T> hVar) {
        if (this.f17539d != null && this.f17539d.getValue() != null) {
            hVar.onResult(this.f17539d.getValue());
        }
        this.f17536a.add(hVar);
        return this;
    }

    public final void b(l<T> lVar) {
        if (this.f17539d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f17539d = lVar;
        this.f17538c.post(new m(this));
    }

    public synchronized n<T> removeFailureListener(h<Throwable> hVar) {
        this.f17537b.remove(hVar);
        return this;
    }

    public synchronized n<T> removeListener(h<T> hVar) {
        this.f17536a.remove(hVar);
        return this;
    }
}
