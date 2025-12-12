package a2;

import a2.a;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f108b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Handler f109m;

    public /* synthetic */ e(int i10, Handler handler) {
        this.f108b = i10;
        this.f109m = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        int i10 = this.f108b;
        Handler handler = this.f109m;
        switch (i10) {
            case 0:
                handler.post(runnable);
                break;
            default:
                ((a.c) handler).post(runnable);
                break;
        }
    }
}
