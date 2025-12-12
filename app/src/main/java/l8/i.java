package l8;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements h9.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15954a;

    @Override // h9.b
    public final Object get() {
        switch (this.f15954a) {
            case 0:
                return Collections.emptySet();
            case 1:
                return null;
            case 2:
                n<ScheduledExecutorService> nVar = ExecutorsRegistrar.f9739a;
                StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    builderDetectNetwork.detectResourceMismatches();
                    if (i10 >= 26) {
                        builderDetectNetwork.detectUnbufferedIo();
                    }
                }
                return new m8.e(Executors.newFixedThreadPool(4, new m8.a("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), ExecutorsRegistrar.f9742d.get());
            case 3:
                n<ScheduledExecutorService> nVar2 = ExecutorsRegistrar.f9739a;
                return new m8.e(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new m8.a("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), ExecutorsRegistrar.f9742d.get());
            case 4:
                n<ScheduledExecutorService> nVar3 = ExecutorsRegistrar.f9739a;
                return new m8.e(Executors.newCachedThreadPool(new m8.a("Firebase Blocking", 11, null)), ExecutorsRegistrar.f9742d.get());
            default:
                n<ScheduledExecutorService> nVar4 = ExecutorsRegistrar.f9739a;
                return Executors.newSingleThreadScheduledExecutor(new m8.a("Firebase Scheduler", 0, null));
        }
    }
}
