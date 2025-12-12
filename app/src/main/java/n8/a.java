package n8;

import android.os.Bundle;
import h9.a;
import i8.a;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements q8.b, p8.a, a.InterfaceC0161a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f16755b;

    @Override // h9.a.InterfaceC0161a
    public final void handle(h9.b bVar) {
        b bVar2 = this.f16755b;
        bVar2.getClass();
        o8.e.getLogger().d("AnalyticsConnector now available.");
        i8.a aVar = (i8.a) bVar.get();
        p8.e eVar = new p8.e(aVar);
        c cVar = new c();
        a.InterfaceC0166a interfaceC0166aRegisterAnalyticsConnectorListener = aVar.registerAnalyticsConnectorListener("clx", cVar);
        if (interfaceC0166aRegisterAnalyticsConnectorListener == null) {
            o8.e.getLogger().d("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            interfaceC0166aRegisterAnalyticsConnectorListener = aVar.registerAnalyticsConnectorListener("crash", cVar);
            if (interfaceC0166aRegisterAnalyticsConnectorListener != null) {
                o8.e.getLogger().w("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        if (interfaceC0166aRegisterAnalyticsConnectorListener == null) {
            o8.e.getLogger().w("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        o8.e.getLogger().d("Registered Firebase Analytics listener.");
        p8.d dVar = new p8.d();
        p8.c cVar2 = new p8.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (bVar2) {
            Iterator it = bVar2.f16758c.iterator();
            while (it.hasNext()) {
                dVar.registerBreadcrumbHandler((q8.a) it.next());
            }
            cVar.setBreadcrumbEventReceiver(dVar);
            cVar.setCrashlyticsOriginEventReceiver(cVar2);
            bVar2.f16757b = dVar;
            bVar2.f16756a = cVar2;
        }
    }

    @Override // p8.a
    public final void logEvent(String str, Bundle bundle) {
        this.f16755b.f16756a.logEvent(str, bundle);
    }

    @Override // q8.b
    public final void registerBreadcrumbHandler(q8.a aVar) {
        b bVar = this.f16755b;
        synchronized (bVar) {
            if (bVar.f16757b instanceof q8.c) {
                bVar.f16758c.add(aVar);
            }
            bVar.f16757b.registerBreadcrumbHandler(aVar);
        }
    }
}
