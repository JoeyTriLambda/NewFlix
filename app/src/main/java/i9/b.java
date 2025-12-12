package i9;

import android.view.View;
import com.google.firebase.installations.FirebaseInstallationsException;
import i7.t;
import java.io.IOException;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13343b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f13344m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f13345n;

    public /* synthetic */ b(boolean z10, int i10, Object obj) {
        this.f13343b = i10;
        this.f13344m = obj;
        this.f13345n = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.firebase.installations.local.b persistedInstallationEntryValue;
        com.google.firebase.installations.local.b bVarF;
        switch (this.f13343b) {
            case 0:
                ((com.google.firebase.installations.a) this.f13344m).b(this.f13345n);
                return;
            case 1:
                com.google.firebase.installations.a aVar = (com.google.firebase.installations.a) this.f13344m;
                boolean z10 = this.f13345n;
                aVar.getClass();
                synchronized (com.google.firebase.installations.a.f9802m) {
                    y5.e eVarA = y5.e.a(aVar.f9803a.getApplicationContext());
                    try {
                        persistedInstallationEntryValue = aVar.f9805c.readPersistedInstallationEntryValue();
                    } finally {
                        if (eVarA != null) {
                            eVarA.b();
                        }
                    }
                }
                try {
                    if (persistedInstallationEntryValue.isErrored() || persistedInstallationEntryValue.isUnregistered()) {
                        bVarF = aVar.f(persistedInstallationEntryValue);
                    } else if (!z10 && !aVar.f9806d.isAuthTokenExpired(persistedInstallationEntryValue)) {
                        return;
                    } else {
                        bVarF = aVar.c(persistedInstallationEntryValue);
                    }
                    aVar.d(bVarF);
                    aVar.j(persistedInstallationEntryValue, bVarF);
                    if (bVarF.isRegistered()) {
                        aVar.i(bVarF.getFirebaseInstallationId());
                    }
                    if (bVarF.isErrored()) {
                        aVar.g(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
                        return;
                    } else if (bVarF.isNotGenerated()) {
                        aVar.g(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        aVar.h(bVarF);
                        return;
                    }
                } catch (FirebaseInstallationsException e10) {
                    aVar.g(e10);
                    return;
                }
            default:
                t.showKeyboard((View) this.f13344m, this.f13345n);
                return;
        }
    }
}
