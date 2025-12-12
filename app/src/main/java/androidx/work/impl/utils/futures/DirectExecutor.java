package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
final class DirectExecutor implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final DirectExecutor f4639b;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ DirectExecutor[] f4640m;

    static {
        DirectExecutor directExecutor = new DirectExecutor();
        f4639b = directExecutor;
        f4640m = new DirectExecutor[]{directExecutor};
    }

    public static DirectExecutor valueOf(String str) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, str);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) f4640m.clone();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }
}
