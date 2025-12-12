package p8;

import android.os.Bundle;

/* compiled from: CrashlyticsOriginAnalyticsEventLogger.java */
/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: b, reason: collision with root package name */
    public final i8.a f17644b;

    public e(i8.a aVar) {
        this.f17644b = aVar;
    }

    @Override // p8.a
    public void logEvent(String str, Bundle bundle) {
        this.f17644b.logEvent("clx", str, bundle);
    }
}
