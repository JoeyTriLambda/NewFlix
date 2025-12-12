package e8;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import w4.e;

/* compiled from: Futures.java */
/* loaded from: classes.dex */
public final class b extends e {

    /* compiled from: Futures.java */
    public static final class a<V> implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Future<V> f11169b;

        /* renamed from: m, reason: collision with root package name */
        public final e8.a<? super V> f11170m;

        public a(Future<V> future, e8.a<? super V> aVar) {
            this.f11169b = future;
            this.f11170m = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Throwable thTryInternalFastPathGetFailure;
            Future<V> future = this.f11169b;
            boolean z10 = future instanceof f8.a;
            e8.a<? super V> aVar = this.f11170m;
            if (z10 && (thTryInternalFastPathGetFailure = f8.b.tryInternalFastPathGetFailure((f8.a) future)) != null) {
                aVar.onFailure(thTryInternalFastPathGetFailure);
                return;
            }
            try {
                aVar.onSuccess((Object) b.getDone(future));
            } catch (Error e10) {
                e = e10;
                aVar.onFailure(e);
            } catch (RuntimeException e11) {
                e = e11;
                aVar.onFailure(e);
            } catch (ExecutionException e12) {
                aVar.onFailure(e12.getCause());
            }
        }

        public String toString() {
            return b8.c.toStringHelper(this).addValue(this.f11170m).toString();
        }
    }

    public static <V> void addCallback(c<V> cVar, e8.a<? super V> aVar, Executor executor) {
        b8.e.checkNotNull(aVar);
        cVar.addListener(new a(cVar, aVar), executor);
    }

    public static <V> V getDone(Future<V> future) throws ExecutionException {
        b8.e.checkState(future.isDone(), "Future was expected to be done: %s", future);
        return (V) d.getUninterruptibly(future);
    }
}
