package m9;

/* compiled from: SystemClock.java */
/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public static b f16224a;

    public static b getInstance() {
        if (f16224a == null) {
            f16224a = new b();
        }
        return f16224a;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
