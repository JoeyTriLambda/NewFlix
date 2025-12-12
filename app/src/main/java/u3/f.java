package u3;

import b0.i;

/* compiled from: LottieCompositionCache.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final f f19991b = new f();

    /* renamed from: a, reason: collision with root package name */
    public final i<String, p3.d> f19992a = new i<>(20);

    public static f getInstance() {
        return f19991b;
    }

    public p3.d get(String str) {
        if (str == null) {
            return null;
        }
        return this.f19992a.get(str);
    }

    public void put(String str, p3.d dVar) {
        if (str == null) {
            return;
        }
        this.f19992a.put(str, dVar);
    }
}
