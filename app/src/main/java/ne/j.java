package ne;

import io.reactivex.internal.util.NotificationLite;

/* compiled from: Notification.java */
/* loaded from: classes2.dex */
public final class j<T> {

    /* renamed from: b, reason: collision with root package name */
    public static final j<Object> f16808b = new j<>(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f16809a;

    public j(Object obj) {
        this.f16809a = obj;
    }

    public static <T> j<T> createOnComplete() {
        return (j<T>) f16808b;
    }

    public static <T> j<T> createOnError(Throwable th2) {
        ue.a.requireNonNull(th2, "error is null");
        return new j<>(NotificationLite.error(th2));
    }

    public static <T> j<T> createOnNext(T t10) {
        ue.a.requireNonNull(t10, "value is null");
        return new j<>(t10);
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return ue.a.equals(this.f16809a, ((j) obj).f16809a);
        }
        return false;
    }

    public Throwable getError() {
        Object obj = this.f16809a;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T getValue() {
        T t10 = (T) this.f16809a;
        if (t10 == null || NotificationLite.isError(t10)) {
            return null;
        }
        return t10;
    }

    public int hashCode() {
        Object obj = this.f16809a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean isOnComplete() {
        return this.f16809a == null;
    }

    public boolean isOnError() {
        return NotificationLite.isError(this.f16809a);
    }

    public boolean isOnNext() {
        Object obj = this.f16809a;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public String toString() {
        Object obj = this.f16809a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + obj + "]";
    }
}
