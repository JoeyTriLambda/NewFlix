package androidx.datastore.preferences.protobuf;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class WireFormat {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class FieldType {

        /* renamed from: n, reason: collision with root package name */
        public static final FieldType f2377n;

        /* renamed from: o, reason: collision with root package name */
        public static final FieldType f2378o;

        /* renamed from: p, reason: collision with root package name */
        public static final FieldType f2379p;

        /* renamed from: q, reason: collision with root package name */
        public static final /* synthetic */ FieldType[] f2380q;

        /* renamed from: b, reason: collision with root package name */
        public final JavaType f2381b;

        /* renamed from: m, reason: collision with root package name */
        public final int f2382m;

        /* JADX INFO: Fake field, exist only in values array */
        FieldType EF0;

        /* JADX INFO: Fake field, exist only in values array */
        FieldType EF1;

        /* JADX INFO: Fake field, exist only in values array */
        FieldType EF2;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            FieldType fieldType9 = new FieldType() { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.1
                {
                    JavaType javaType3 = JavaType.STRING;
                }
            };
            f2377n = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType(javaType3) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.2
            };
            f2378o = fieldType10;
            FieldType fieldType11 = new FieldType(javaType3) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.3
            };
            f2379p = fieldType11;
            f2380q = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, new FieldType(JavaType.BYTE_STRING) { // from class: androidx.datastore.preferences.protobuf.WireFormat.FieldType.4
            }, new FieldType("UINT32", 12, javaType2, 0), new FieldType("ENUM", 13, JavaType.ENUM, 0), new FieldType("SFIXED32", 14, javaType2, 5), new FieldType("SFIXED64", 15, javaType, 1), new FieldType("SINT32", 16, javaType2, 0), new FieldType("SINT64", 17, javaType, 0)};
        }

        public /* synthetic */ FieldType() {
            throw null;
        }

        public FieldType(String str, int i10, JavaType javaType, int i11) {
            this.f2381b = javaType;
            this.f2382m = i11;
        }

        public static FieldType valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        public static FieldType[] values() {
            return (FieldType[]) f2380q.clone();
        }

        public JavaType getJavaType() {
            return this.f2381b;
        }

        public int getWireType() {
            return this.f2382m;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.f2316m),
        ENUM(null),
        MESSAGE(null);


        /* renamed from: b, reason: collision with root package name */
        public final Object f2393b;

        JavaType(Serializable serializable) {
            this.f2393b = serializable;
        }
    }

    public static int getTagFieldNumber(int i10) {
        return i10 >>> 3;
    }

    public static int getTagWireType(int i10) {
        return i10 & 7;
    }
}
