package r9;

import android.util.Base64;

/* compiled from: SessionDataStoreConfigs.kt */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f18866a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18867b;

    /* renamed from: c, reason: collision with root package name */
    public static final String f18868c;

    static {
        String strEncodeToString = Base64.encodeToString(ig.l.encodeToByteArray(i.f18865a.getProcessName$com_google_firebase_firebase_sessions()), 10);
        f18867b = ac.c.k("firebase_session_", strEncodeToString, "_data");
        f18868c = ac.c.k("firebase_session_", strEncodeToString, "_settings");
    }

    public final String getSESSIONS_CONFIG_NAME() {
        return f18867b;
    }

    public final String getSETTINGS_CONFIG_NAME() {
        return f18868c;
    }
}
