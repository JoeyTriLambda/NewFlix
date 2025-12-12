package o8;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import l8.p;
import t8.f0;
import t8.g0;

/* compiled from: CrashlyticsNativeComponentDeferredProxy.java */
/* loaded from: classes.dex */
public final class b implements o8.a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f17038c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final h9.a<o8.a> f17039a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<o8.a> f17040b = new AtomicReference<>(null);

    /* compiled from: CrashlyticsNativeComponentDeferredProxy.java */
    public static final class a implements f {
        public File getAppFile() {
            return null;
        }

        public f0.a getApplicationExitInto() {
            return null;
        }

        public File getDeviceFile() {
            return null;
        }

        public File getMetadataFile() {
            return null;
        }

        public File getMinidumpFile() {
            return null;
        }

        public File getOsFile() {
            return null;
        }

        public File getSessionFile() {
            return null;
        }
    }

    public b(h9.a<o8.a> aVar) {
        this.f17039a = aVar;
        ((p) aVar).whenAvailable(new c1.c(this, 11));
    }

    @Override // o8.a
    public f getSessionFileProvider(String str) {
        o8.a aVar = this.f17040b.get();
        return aVar == null ? f17038c : aVar.getSessionFileProvider(str);
    }

    @Override // o8.a
    public boolean hasCrashDataForCurrentSession() {
        o8.a aVar = this.f17040b.get();
        return aVar != null && aVar.hasCrashDataForCurrentSession();
    }

    @Override // o8.a
    public boolean hasCrashDataForSession(String str) {
        o8.a aVar = this.f17040b.get();
        return aVar != null && aVar.hasCrashDataForSession(str);
    }

    @Override // o8.a
    public void prepareNativeSession(String str, String str2, long j10, g0 g0Var) {
        e.getLogger().v("Deferring native open session: " + str);
        ((p) this.f17039a).whenAvailable(new x4.f(str, str2, j10, g0Var, 3));
    }
}
