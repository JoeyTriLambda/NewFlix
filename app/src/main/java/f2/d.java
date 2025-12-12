package f2;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11391b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f11392m;

    public /* synthetic */ d(Context context, int i10) {
        this.f11391b = i10;
        this.f11392m = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws PackageManager.NameNotFoundException, IOException {
        int i10 = this.f11391b;
        Context context = this.f11392m;
        switch (i10) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new d(context, 1));
                break;
            default:
                androidx.profileinstaller.c.writeProfile(context);
                break;
        }
    }
}
