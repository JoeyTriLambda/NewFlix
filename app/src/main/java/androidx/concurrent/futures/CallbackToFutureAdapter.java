package androidx.concurrent.futures;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public Object f1618a;

        /* renamed from: b, reason: collision with root package name */
        public c<T> f1619b;

        /* renamed from: c, reason: collision with root package name */
        public c0.a<Void> f1620c = c0.a.create();

        /* renamed from: d, reason: collision with root package name */
        public boolean f1621d;

        public void finalize() {
            c0.a<Void> aVar;
            c<T> cVar = this.f1619b;
            if (cVar != null && !cVar.isDone()) {
                cVar.f1623m.setException(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1618a));
            }
            if (this.f1621d || (aVar = this.f1620c) == null) {
                return;
            }
            aVar.set(null);
        }

        public boolean set(T t10) {
            this.f1621d = true;
            c<T> cVar = this.f1619b;
            boolean z10 = cVar != null && cVar.f1623m.set(t10);
            if (z10) {
                this.f1618a = null;
                this.f1619b = null;
                this.f1620c = null;
            }
            return z10;
        }

        public boolean setCancelled() {
            this.f1621d = true;
            c<T> cVar = this.f1619b;
            boolean z10 = cVar != null && cVar.f1623m.cancel(true);
            if (z10) {
                this.f1618a = null;
                this.f1619b = null;
                this.f1620c = null;
            }
            return z10;
        }

        public boolean setException(Throwable th2) {
            this.f1621d = true;
            c<T> cVar = this.f1619b;
            boolean z10 = cVar != null && cVar.f1623m.setException(th2);
            if (z10) {
                this.f1618a = null;
                this.f1619b = null;
                this.f1620c = null;
            }
            return z10;
        }
    }

    public interface b<T> {
        Object attachCompleter(a<T> aVar) throws Exception;
    }

    public static final class c<T> implements e8.c<T> {

        /* renamed from: b, reason: collision with root package name */
        public final WeakReference<a<T>> f1622b;

        /* renamed from: m, reason: collision with root package name */
        public final a f1623m = new a();

        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public String pendingToString() {
                a<T> aVar = c.this.f1622b.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f1618a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f1622b = new WeakReference<>(aVar);
        }

        @Override // e8.c
        public void addListener(Runnable runnable, Executor executor) {
            this.f1623m.addListener(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a<T> aVar = this.f1622b.get();
            boolean zCancel = this.f1623m.cancel(z10);
            if (zCancel && aVar != null) {
                aVar.f1618a = null;
                aVar.f1619b = null;
                aVar.f1620c.set(null);
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return this.f1623m.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f1623m.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f1623m.isDone();
        }

        public String toString() {
            return this.f1623m.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f1623m.get(j10, timeUnit);
        }
    }

    public static <T> e8.c<T> getFuture(b<T> bVar) {
        a<T> aVar = new a<>();
        c<T> cVar = new c<>(aVar);
        aVar.f1619b = cVar;
        aVar.f1618a = bVar.getClass();
        try {
            Object objAttachCompleter = bVar.attachCompleter(aVar);
            if (objAttachCompleter != null) {
                aVar.f1618a = objAttachCompleter;
            }
        } catch (Exception e10) {
            cVar.f1623m.setException(e10);
        }
        return cVar;
    }
}
