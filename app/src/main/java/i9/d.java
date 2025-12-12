package i9;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: GetAuthTokenListener.java */
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: a, reason: collision with root package name */
    public final i f13346a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskCompletionSource<f> f13347b;

    public d(i iVar, TaskCompletionSource<f> taskCompletionSource) {
        this.f13346a = iVar;
        this.f13347b = taskCompletionSource;
    }

    @Override // i9.h
    public boolean onException(Exception exc) {
        this.f13347b.trySetException(exc);
        return true;
    }

    @Override // i9.h
    public boolean onStateReached(com.google.firebase.installations.local.b bVar) {
        if (!bVar.isRegistered() || this.f13346a.isAuthTokenExpired(bVar)) {
            return false;
        }
        this.f13347b.setResult(f.builder().setToken(bVar.getAuthToken()).setTokenExpirationTimestamp(bVar.getExpiresInSecs()).setTokenCreationTimestamp(bVar.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
