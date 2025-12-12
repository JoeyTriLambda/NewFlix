package androidx.datastore.preferences;

import androidx.datastore.preferences.a;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.l0;
import androidx.datastore.preferences.protobuf.s0;

/* loaded from: classes.dex */
public final class PreferencesProto$Value extends GeneratedMessageLite<PreferencesProto$Value, a> implements l0 {
    public static final int BOOLEAN_FIELD_NUMBER = 1;
    private static final PreferencesProto$Value DEFAULT_INSTANCE;
    public static final int DOUBLE_FIELD_NUMBER = 7;
    public static final int FLOAT_FIELD_NUMBER = 2;
    public static final int INTEGER_FIELD_NUMBER = 3;
    public static final int LONG_FIELD_NUMBER = 4;
    private static volatile s0<PreferencesProto$Value> PARSER = null;
    public static final int STRING_FIELD_NUMBER = 5;
    public static final int STRING_SET_FIELD_NUMBER = 6;
    private int bitField0_;
    private int valueCase_ = 0;
    private Object value_;

    public enum ValueCase {
        BOOLEAN,
        FLOAT,
        INTEGER,
        LONG,
        STRING,
        STRING_SET,
        DOUBLE,
        VALUE_NOT_SET;

        public static ValueCase forNumber(int i10) {
            switch (i10) {
                case 0:
                    return VALUE_NOT_SET;
                case 1:
                    return BOOLEAN;
                case 2:
                    return FLOAT;
                case 3:
                    return INTEGER;
                case 4:
                    return LONG;
                case 5:
                    return STRING;
                case 6:
                    return STRING_SET;
                case 7:
                    return DOUBLE;
                default:
                    return null;
            }
        }
    }

    public static final class a extends GeneratedMessageLite.a<PreferencesProto$Value, a> implements l0 {
        public a() {
            super(PreferencesProto$Value.DEFAULT_INSTANCE);
        }

        public a setBoolean(boolean z10) {
            copyOnWrite();
            PreferencesProto$Value.l((PreferencesProto$Value) this.f2355m, z10);
            return this;
        }

        public a setDouble(double d10) {
            copyOnWrite();
            PreferencesProto$Value.j((PreferencesProto$Value) this.f2355m, d10);
            return this;
        }

        public a setFloat(float f10) {
            copyOnWrite();
            PreferencesProto$Value.m((PreferencesProto$Value) this.f2355m, f10);
            return this;
        }

        public a setInteger(int i10) {
            copyOnWrite();
            PreferencesProto$Value.n((PreferencesProto$Value) this.f2355m, i10);
            return this;
        }

        public a setLong(long j10) {
            copyOnWrite();
            PreferencesProto$Value.g((PreferencesProto$Value) this.f2355m, j10);
            return this;
        }

        public a setString(String str) {
            copyOnWrite();
            PreferencesProto$Value.h(str, (PreferencesProto$Value) this.f2355m);
            return this;
        }

        public a setStringSet(a.C0022a c0022a) {
            copyOnWrite();
            PreferencesProto$Value.i((PreferencesProto$Value) this.f2355m, c0022a);
            return this;
        }
    }

    static {
        PreferencesProto$Value preferencesProto$Value = new PreferencesProto$Value();
        DEFAULT_INSTANCE = preferencesProto$Value;
        GeneratedMessageLite.registerDefaultInstance(PreferencesProto$Value.class, preferencesProto$Value);
    }

    public static void g(PreferencesProto$Value preferencesProto$Value, long j10) {
        preferencesProto$Value.valueCase_ = 4;
        preferencesProto$Value.value_ = Long.valueOf(j10);
    }

    public static PreferencesProto$Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static void h(String str, PreferencesProto$Value preferencesProto$Value) {
        preferencesProto$Value.getClass();
        str.getClass();
        preferencesProto$Value.valueCase_ = 5;
        preferencesProto$Value.value_ = str;
    }

    public static void i(PreferencesProto$Value preferencesProto$Value, a.C0022a c0022a) {
        preferencesProto$Value.getClass();
        preferencesProto$Value.value_ = c0022a.m4build();
        preferencesProto$Value.valueCase_ = 6;
    }

    public static void j(PreferencesProto$Value preferencesProto$Value, double d10) {
        preferencesProto$Value.valueCase_ = 7;
        preferencesProto$Value.value_ = Double.valueOf(d10);
    }

    public static void l(PreferencesProto$Value preferencesProto$Value, boolean z10) {
        preferencesProto$Value.valueCase_ = 1;
        preferencesProto$Value.value_ = Boolean.valueOf(z10);
    }

    public static void m(PreferencesProto$Value preferencesProto$Value, float f10) {
        preferencesProto$Value.valueCase_ = 2;
        preferencesProto$Value.value_ = Float.valueOf(f10);
    }

    public static void n(PreferencesProto$Value preferencesProto$Value, int i10) {
        preferencesProto$Value.valueCase_ = 3;
        preferencesProto$Value.value_ = Integer.valueOf(i10);
    }

    public static a newBuilder() {
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
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0001\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001:\u0000\u00024\u0000\u00037\u0000\u00045\u0000\u0005;\u0000\u0006<\u0000\u00073\u0000", new Object[]{"value_", "valueCase_", "bitField0_", androidx.datastore.preferences.a.class});
            case NEW_MUTABLE_INSTANCE:
                return new PreferencesProto$Value();
            case NEW_BUILDER:
                return new a();
            case GET_DEFAULT_INSTANCE:
                return DEFAULT_INSTANCE;
            case GET_PARSER:
                s0<PreferencesProto$Value> bVar = PARSER;
                if (bVar == null) {
                    synchronized (PreferencesProto$Value.class) {
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

    public boolean getBoolean() {
        if (this.valueCase_ == 1) {
            return ((Boolean) this.value_).booleanValue();
        }
        return false;
    }

    public double getDouble() {
        if (this.valueCase_ == 7) {
            return ((Double) this.value_).doubleValue();
        }
        return 0.0d;
    }

    public float getFloat() {
        if (this.valueCase_ == 2) {
            return ((Float) this.value_).floatValue();
        }
        return 0.0f;
    }

    public int getInteger() {
        if (this.valueCase_ == 3) {
            return ((Integer) this.value_).intValue();
        }
        return 0;
    }

    public long getLong() {
        if (this.valueCase_ == 4) {
            return ((Long) this.value_).longValue();
        }
        return 0L;
    }

    public String getString() {
        return this.valueCase_ == 5 ? (String) this.value_ : "";
    }

    public androidx.datastore.preferences.a getStringSet() {
        return this.valueCase_ == 6 ? (androidx.datastore.preferences.a) this.value_ : androidx.datastore.preferences.a.getDefaultInstance();
    }

    public ValueCase getValueCase() {
        return ValueCase.forNumber(this.valueCase_);
    }
}
