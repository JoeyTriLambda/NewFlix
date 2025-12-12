package ab;

import ac.c;
import android.os.Bundle;

/* compiled from: RequestExtras.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f383a;

    public a(String str) {
        this.f383a = c.j("UnityScar", str);
    }

    public Bundle getExtras() {
        Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_5");
        return bundle;
    }

    public String getVersionName() {
        return this.f383a;
    }
}
