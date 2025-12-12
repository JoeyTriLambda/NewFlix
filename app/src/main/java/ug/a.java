package ug;

import java.util.concurrent.Executor;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class a implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f20377b = new a();

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
