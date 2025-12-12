package androidx.emoji2.text;

import java.util.concurrent.ThreadFactory;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2591b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.f2591b);
        thread.setPriority(10);
        return thread;
    }
}
