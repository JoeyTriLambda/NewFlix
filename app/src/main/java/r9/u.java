package r9;

/* compiled from: TimeProvider.kt */
/* loaded from: classes.dex */
public final class u implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final u f18895a = new u();

    @Override // r9.t
    public long currentTimeUs() {
        return System.currentTimeMillis() * 1000;
    }
}
