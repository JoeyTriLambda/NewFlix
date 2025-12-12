package k1;

import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.MapFieldLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.e0;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* compiled from: PreferencesProto.java */
/* loaded from: classes.dex */
public final class c extends GeneratedMessageLite<c, a> implements l0 {
    private static final c DEFAULT_INSTANCE;
    private static volatile s0<c> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private MapFieldLite<String, PreferencesProto$Value> preferences_ = MapFieldLite.emptyMapField();

    /* compiled from: PreferencesProto.java */
    public static final class a extends GeneratedMessageLite.a<c, a> implements l0 {
        public a() {
            super(c.DEFAULT_INSTANCE);
        }

        public a putPreferences(String str, PreferencesProto$Value preferencesProto$Value) {
            str.getClass();
            preferencesProto$Value.getClass();
            copyOnWrite();
            c.h((c) this.f2355m).put(str, preferencesProto$Value);
            return this;
        }
    }

    /* compiled from: PreferencesProto.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final e0<String, PreferencesProto$Value> f14719a = e0.newDefaultInstance(WireFormat.FieldType.f2377n, "", WireFormat.FieldType.f2379p, PreferencesProto$Value.getDefaultInstance());
    }

    static {
        c cVar = new c();
        DEFAULT_INSTANCE = cVar;
        GeneratedMessageLite.registerDefaultInstance(c.class, cVar);
    }

    public static MapFieldLite h(c cVar) {
        if (!cVar.preferences_.isMutable()) {
            cVar.preferences_ = cVar.preferences_.mutableCopy();
        }
        return cVar.preferences_;
    }

    public static a newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static c parseFrom(InputStream inputStream) throws IOException {
        return (c) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (methodToInvoke) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            case BUILD_MESSAGE_INFO:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.f14719a});
            case NEW_MUTABLE_INSTANCE:
                return new c();
            case NEW_BUILDER:
                return new a();
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                s0<c> bVar = PARSER;
                if (bVar == null) {
                    synchronized (c.class) {
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

    public Map<String, PreferencesProto$Value> getPreferencesMap() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
