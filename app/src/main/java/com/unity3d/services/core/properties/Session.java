package com.unity3d.services.core.properties;

/* compiled from: Session.kt */
/* loaded from: classes2.dex */
public interface Session {
    public static final Default Default = Default.$$INSTANCE;

    /* compiled from: Session.kt */
    public static final class Default implements Session {
        static final /* synthetic */ Default $$INSTANCE = new Default();

        /* renamed from: id, reason: collision with root package name */
        private static final String f10707id = SessionIdReader.INSTANCE.getSessionId();

        private Default() {
        }

        @Override // com.unity3d.services.core.properties.Session
        public String getId() {
            return f10707id;
        }
    }

    String getId();
}
