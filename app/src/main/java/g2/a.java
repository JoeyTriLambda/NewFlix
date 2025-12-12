package g2;

/* compiled from: AutoCloser.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public int f12547a;

    /* renamed from: b, reason: collision with root package name */
    public k2.e f12548b;

    /* compiled from: AutoCloser.kt */
    /* renamed from: g2.a$a, reason: collision with other inner class name */
    public static final class C0149a {
        public C0149a(zf.f fVar) {
        }
    }

    static {
        new C0149a(null);
    }

    public final void decrementCountAndScheduleClose() {
        throw null;
    }

    public final <V> V executeRefCountingFunction(yf.l<? super k2.e, ? extends V> lVar) {
        zf.i.checkNotNullParameter(lVar, "block");
        try {
            return lVar.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final k2.f getDelegateOpenHelper() {
        zf.i.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    public final k2.e incrementCountAndEnsureDbIsOpen() {
        throw null;
    }

    public final boolean isActive() {
        return !false;
    }

    public final void setAutoCloseCallback(Runnable runnable) {
        zf.i.checkNotNullParameter(runnable, "onAutoClose");
    }
}
