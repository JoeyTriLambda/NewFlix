package com.unity3d.services.core.properties;

import java.util.UUID;
import zf.i;

/* compiled from: SessionIdReader.kt */
/* loaded from: classes2.dex */
public final class SessionIdReader {
    public static final SessionIdReader INSTANCE = new SessionIdReader();
    private static final String sessionId;

    static {
        String string = UUID.randomUUID().toString();
        i.checkNotNullExpressionValue(string, "randomUUID().toString()");
        sessionId = string;
    }

    private SessionIdReader() {
    }

    public final String getSessionId() {
        return sessionId;
    }
}
