package w2;

import android.app.Notification;

/* compiled from: ForegroundInfo.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final int f20874a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20875b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f20876c;

    public c(int i10, Notification notification, int i11) {
        this.f20874a = i10;
        this.f20876c = notification;
        this.f20875b = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f20874a == cVar.f20874a && this.f20875b == cVar.f20875b) {
            return this.f20876c.equals(cVar.f20876c);
        }
        return false;
    }

    public int getForegroundServiceType() {
        return this.f20875b;
    }

    public Notification getNotification() {
        return this.f20876c;
    }

    public int getNotificationId() {
        return this.f20874a;
    }

    public int hashCode() {
        return this.f20876c.hashCode() + (((this.f20874a * 31) + this.f20875b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f20874a + ", mForegroundServiceType=" + this.f20875b + ", mNotification=" + this.f20876c + '}';
    }
}
