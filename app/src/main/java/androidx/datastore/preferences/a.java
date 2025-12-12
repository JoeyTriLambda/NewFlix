package androidx.datastore.preferences;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.w;
import java.util.List;

/* compiled from: PreferencesProto.java */
/* loaded from: classes.dex */
public final class a extends GeneratedMessageLite<a, C0022a> implements l0 {
    private static final a DEFAULT_INSTANCE;
    private static volatile s0<a> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w.h<String> strings_ = GeneratedMessageLite.emptyProtobufList();

    /* compiled from: PreferencesProto.java */
    /* renamed from: androidx.datastore.preferences.a$a, reason: collision with other inner class name */
    public static final class C0022a extends GeneratedMessageLite.a<a, C0022a> implements l0 {
        public C0022a() {
            super(a.DEFAULT_INSTANCE);
        }

        public C0022a addAllStrings(Iterable<String> iterable) {
            copyOnWrite();
            a.h((a) this.f2355m, iterable);
            return this;
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.registerDefaultInstance(a.class, aVar);
    }

    public static a getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static void h(a aVar, Iterable iterable) {
        if (!aVar.strings_.isModifiable()) {
            aVar.strings_ = GeneratedMessageLite.mutableCopy(aVar.strings_);
        }
        androidx.datastore.preferences.protobuf.a.addAll(iterable, aVar.strings_);
    }

    public static C0022a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case NEW_MUTABLE_INSTANCE:
                return new a();
            case NEW_BUILDER:
                return new C0022a();
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                s0<a> bVar = PARSER;
                if (bVar == null) {
                    synchronized (a.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new GeneratedMessageLite.b<>(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    }
                }
                return bVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public List<String> getStringsList() {
        return this.strings_;
    }
}
