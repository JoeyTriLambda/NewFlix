package r8;

import com.google.firebase.sessions.api.SessionSubscriber;

/* compiled from: CrashlyticsAppQualitySessionsSubscriber.java */
/* loaded from: classes.dex */
public final class k implements SessionSubscriber {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f18714a;

    /* renamed from: b, reason: collision with root package name */
    public final j f18715b;

    public k(d0 d0Var, w8.b bVar) {
        this.f18714a = d0Var;
        this.f18715b = new j(bVar);
    }

    public String getAppQualitySessionId(String str) {
        return this.f18715b.getAppQualitySessionId(str);
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public SessionSubscriber.Name getSessionSubscriberName() {
        return SessionSubscriber.Name.CRASHLYTICS;
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public boolean isDataCollectionEnabled() {
        return this.f18714a.isAutomaticDataCollectionEnabled();
    }

    @Override // com.google.firebase.sessions.api.SessionSubscriber
    public void onSessionChanged(SessionSubscriber.a aVar) {
        o8.e.getLogger().d("App Quality Sessions session changed: " + aVar);
        this.f18715b.rotateAppQualitySessionId(aVar.getSessionId());
    }

    public void setSessionId(String str) {
        this.f18715b.rotateSessionId(str);
    }
}
