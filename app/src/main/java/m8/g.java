package m8;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.google.firebase.sessions.FirebaseSessionsRegistrar;
import java.util.concurrent.ScheduledExecutorService;
import l8.n;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements l8.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16223a;

    public /* synthetic */ g(int i10) {
        this.f16223a = i10;
    }

    @Override // l8.g
    public final Object create(l8.d dVar) {
        switch (this.f16223a) {
            case 0:
                return ExecutorsRegistrar.f9739a.get();
            case 1:
                return ExecutorsRegistrar.f9741c.get();
            case 2:
                return ExecutorsRegistrar.f9740b.get();
            case 3:
                n<ScheduledExecutorService> nVar = ExecutorsRegistrar.f9739a;
                return UiExecutor.f9757b;
            case 4:
                return TransportRegistrar.lambda$getComponents$0(dVar);
            case 5:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(dVar);
            case 6:
                return new o9.b(dVar.setOf(o9.e.class), o9.c.getInstance());
            case 7:
                return FirebaseSessionsRegistrar.m14getComponents$lambda0(dVar);
            case 8:
                return FirebaseSessionsRegistrar.m15getComponents$lambda1(dVar);
            case 9:
                return FirebaseSessionsRegistrar.m16getComponents$lambda2(dVar);
            case 10:
                return FirebaseSessionsRegistrar.m17getComponents$lambda3(dVar);
            case 11:
                return FirebaseSessionsRegistrar.m18getComponents$lambda4(dVar);
            default:
                return FirebaseSessionsRegistrar.m19getComponents$lambda5(dVar);
        }
    }
}
