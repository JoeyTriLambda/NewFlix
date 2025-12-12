package m8;

import android.annotation.SuppressLint;
import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: DelegatingScheduledFuture.java */
@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class f<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {

    /* renamed from: s, reason: collision with root package name */
    public final ScheduledFuture<?> f16221s;

    /* compiled from: DelegatingScheduledFuture.java */
    public class a implements b<V> {
        public a() {
        }

        public void set(V v10) {
            f.this.set(v10);
        }

        public void setException(Throwable th2) {
            f.this.setException(th2);
        }
    }

    /* compiled from: DelegatingScheduledFuture.java */
    public interface b<T> {
    }

    /* compiled from: DelegatingScheduledFuture.java */
    public interface c<T> {
        ScheduledFuture<?> addCompleter(b<T> bVar);
    }

    public f(c<V> cVar) {
        this.f16221s = cVar.addCompleter(new a());
    }

    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public void afterDone() {
        this.f16221s.cancel(wasInterrupted());
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.f16221s.getDelay(timeUnit);
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        return this.f16221s.compareTo(delayed);
    }
}
