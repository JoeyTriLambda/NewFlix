package io.reactivex.internal.util;

import java.io.Serializable;
import ne.q;
import qe.b;
import ue.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes2.dex */
public final class NotificationLite {

    /* renamed from: b, reason: collision with root package name */
    public static final NotificationLite f14547b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ NotificationLite[] f14548m;

    public static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;

        /* renamed from: b, reason: collision with root package name */
        public final b f14549b;

        public DisposableNotification(b bVar) {
            this.f14549b = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.f14549b + "]";
        }
    }

    public static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f14550b;

        public ErrorNotification(Throwable th2) {
            this.f14550b = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return a.equals(this.f14550b, ((ErrorNotification) obj).f14550b);
            }
            return false;
        }

        public int hashCode() {
            return this.f14550b.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f14550b + "]";
        }
    }

    static {
        NotificationLite notificationLite = new NotificationLite();
        f14547b = notificationLite;
        f14548m = new NotificationLite[]{notificationLite};
    }

    public static <T> boolean accept(Object obj, q<? super T> qVar) {
        if (obj == f14547b) {
            qVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            qVar.onError(((ErrorNotification) obj).f14550b);
            return true;
        }
        qVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, q<? super T> qVar) {
        if (obj == f14547b) {
            qVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            qVar.onError(((ErrorNotification) obj).f14550b);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            qVar.onSubscribe(((DisposableNotification) obj).f14549b);
            return false;
        }
        qVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return f14547b;
    }

    public static Object disposable(b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f14550b;
    }

    public static boolean isComplete(Object obj) {
        return obj == f14547b;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static NotificationLite valueOf(String str) {
        return (NotificationLite) Enum.valueOf(NotificationLite.class, str);
    }

    public static NotificationLite[] values() {
        return (NotificationLite[]) f14548m.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static <T> Object next(T t10) {
        return t10;
    }
}
