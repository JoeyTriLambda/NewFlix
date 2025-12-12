package y;

import java.util.concurrent.Executor;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f21804b;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f21804b) {
            case 1:
                b.getInstance().executeOnDiskIO(runnable);
                break;
            case 2:
                runnable.run();
                break;
            case 3:
                runnable.run();
                break;
            case 4:
                runnable.run();
                break;
            case 5:
                runnable.run();
                break;
            case 6:
                runnable.run();
                break;
            case 7:
                runnable.run();
                break;
            case 8:
                runnable.run();
                break;
            case 9:
                runnable.run();
                break;
            case 10:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
