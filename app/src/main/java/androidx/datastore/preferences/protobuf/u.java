package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;

/* compiled from: GeneratedMessageInfoFactory.java */
/* loaded from: classes.dex */
public final class u implements j0 {

    /* renamed from: a, reason: collision with root package name */
    public static final u f2536a = new u();

    public static u getInstance() {
        return f2536a;
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public boolean isSupported(Class<?> cls) {
        return GeneratedMessageLite.class.isAssignableFrom(cls);
    }

    @Override // androidx.datastore.preferences.protobuf.j0
    public i0 messageInfoFor(Class<?> cls) {
        if (!GeneratedMessageLite.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (i0) GeneratedMessageLite.d(cls.asSubclass(GeneratedMessageLite.class)).dynamicMethod(GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
        }
    }
}
