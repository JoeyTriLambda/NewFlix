package i9;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: GetIdListener.java */
/* loaded from: classes.dex */
public final class e implements h {

    /* renamed from: a, reason: collision with root package name */
    public final TaskCompletionSource<String> f13348a;

    public e(TaskCompletionSource<String> taskCompletionSource) {
        this.f13348a = taskCompletionSource;
    }

    @Override // i9.h
    public boolean onException(Exception exc) {
        return false;
    }

    @Override // i9.h
    public boolean onStateReached(com.google.firebase.installations.local.b bVar) {
        if (!bVar.isUnregistered() && !bVar.isRegistered() && !bVar.isErrored()) {
            return false;
        }
        this.f13348a.trySetResult(bVar.getFirebaseInstallationId());
        return true;
    }
}
