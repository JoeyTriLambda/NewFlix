package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.PreferencesProto$Value;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite.a;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.a;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.w;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends androidx.datastore.preferences.protobuf.a<MessageType, BuilderType> {
    private static Map<Object, GeneratedMessageLite<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected g1 unknownFields = g1.getDefaultInstance();
    protected int memoizedSerializedSize = -1;

    public enum MethodToInvoke {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        /* JADX INFO: Fake field, exist only in values array */
        GET_PARSER
    }

    public static abstract class a<MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends a.AbstractC0023a<MessageType, BuilderType> {

        /* renamed from: b, reason: collision with root package name */
        public final MessageType f2354b;

        /* renamed from: m, reason: collision with root package name */
        public MessageType f2355m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f2356n = false;

        public a(MessageType messagetype) {
            this.f2354b = messagetype;
            this.f2355m = (MessageType) messagetype.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        }

        public void copyOnWrite() {
            if (this.f2356n) {
                MessageType messagetype = (MessageType) this.f2355m.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
                u0.getInstance().schemaFor((u0) messagetype).mergeFrom(messagetype, this.f2355m);
                this.f2355m = messagetype;
                this.f2356n = false;
            }
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            MessageType messagetype2 = this.f2355m;
            u0.getInstance().schemaFor((u0) messagetype2).mergeFrom(messagetype2, messagetype);
            return this;
        }

        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public final MessageType m4build() {
            MessageType messagetype = (MessageType) m5buildPartial();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw a.AbstractC0023a.newUninitializedMessageException(messagetype);
        }

        /* renamed from: buildPartial, reason: merged with bridge method [inline-methods] */
        public MessageType m5buildPartial() {
            if (this.f2356n) {
                return this.f2355m;
            }
            this.f2355m.makeImmutable();
            this.f2356n = true;
            return this.f2355m;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BuilderType m6clone() {
            PreferencesProto$Value.a aVar = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            aVar.mergeFrom((PreferencesProto$Value.a) m5buildPartial());
            return aVar;
        }

        @Override // androidx.datastore.preferences.protobuf.l0
        public MessageType getDefaultInstanceForType() {
            return this.f2354b;
        }

        @Override // androidx.datastore.preferences.protobuf.a.AbstractC0023a
        public BuilderType internalMergeFrom(MessageType messagetype) {
            return (BuilderType) mergeFrom((a<MessageType, BuilderType>) messagetype);
        }
    }

    public static class b<T extends GeneratedMessageLite<T, ?>> extends androidx.datastore.preferences.protobuf.b<T> {
        public b(T t10) {
        }
    }

    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends GeneratedMessageLite<MessageType, BuilderType> implements l0 {
        protected s<d> extensions = s.emptySet();

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.l0
        public /* bridge */ /* synthetic */ k0 getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.k0
        public /* bridge */ /* synthetic */ k0.a newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.k0
        public /* bridge */ /* synthetic */ k0.a toBuilder() {
            return super.toBuilder();
        }
    }

    public static final class d implements s.a<d> {
        @Override // androidx.datastore.preferences.protobuf.s.a
        public WireFormat.JavaType getLiteJavaType() {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.s.a
        public WireFormat.FieldType getLiteType() {
            return null;
        }

        @Override // androidx.datastore.preferences.protobuf.s.a
        public int getNumber() {
            return 0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.s.a
        public k0.a internalMergeFrom(k0.a aVar, k0 k0Var) {
            return ((a) aVar).mergeFrom((a) k0Var);
        }

        @Override // androidx.datastore.preferences.protobuf.s.a
        public boolean isPacked() {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.s.a
        public boolean isRepeated() {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(d dVar) {
            dVar.getClass();
            return 0;
        }
    }

    public static class e<ContainingType extends k0, Type> extends l<ContainingType, Type> {
        public k0 getMessageDefaultInstance() {
            return null;
        }

        public int getNumber() {
            throw null;
        }
    }

    public static <T extends GeneratedMessageLite<?, ?>> T d(Class<T> cls) throws ClassNotFoundException {
        GeneratedMessageLite<?, ?> generatedMessageLite = defaultInstanceMap.get(cls);
        if (generatedMessageLite == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                generatedMessageLite = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (generatedMessageLite == null) {
            generatedMessageLite = (T) ((GeneratedMessageLite) j1.a(cls)).getDefaultInstanceForType();
            if (generatedMessageLite == null) {
                throw new IllegalStateException();
            }
            defaultInstanceMap.put(cls, generatedMessageLite);
        }
        return (T) generatedMessageLite;
    }

    public static Object e(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <E> w.h<E> emptyProtobufList() {
        return v0.emptyList();
    }

    public static <T extends GeneratedMessageLite<T, ?>> T f(T t10, h hVar, n nVar) throws InvalidProtocolBufferException {
        T t11 = (T) t10.dynamicMethod(MethodToInvoke.NEW_MUTABLE_INSTANCE);
        try {
            y0 y0VarSchemaFor = u0.getInstance().schemaFor((u0) t11);
            y0VarSchemaFor.mergeFrom(t11, i.forCodedInput(hVar), nVar);
            y0VarSchemaFor.makeImmutable(t11);
            return t11;
        } catch (IOException e10) {
            if (e10.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e10.getCause());
            }
            throw new InvalidProtocolBufferException(e10.getMessage()).setUnfinishedMessage(t11);
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e11.getCause());
            }
            throw e11;
        }
    }

    public static <E> w.h<E> mutableCopy(w.h<E> hVar) {
        int size = hVar.size();
        return hVar.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
    }

    public static Object newMessageInfo(k0 k0Var, String str, Object[] objArr) {
        return new w0(k0Var, str, objArr);
    }

    public static <T extends GeneratedMessageLite<T, ?>> T parseFrom(T t10, InputStream inputStream) throws InvalidProtocolBufferException {
        T t11 = (T) f(t10, h.newInstance(inputStream), n.getEmptyRegistry());
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw new UninitializedMessageException(t11).asInvalidProtocolBufferException().setUnfinishedMessage(t11);
    }

    public static <T extends GeneratedMessageLite<?, ?>> void registerDefaultInstance(Class<T> cls, T t10) {
        defaultInstanceMap.put(cls, t10);
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final int a() {
        return this.memoizedSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.a
    public final void c(int i10) {
        this.memoizedSerializedSize = i10;
    }

    public final <MessageType extends GeneratedMessageLite<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    public Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj) {
        return dynamicMethod(methodToInvoke, obj, null);
    }

    public abstract Object dynamicMethod(MethodToInvoke methodToInvoke, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (getDefaultInstanceForType().getClass().isInstance(obj)) {
            return u0.getInstance().schemaFor((u0) this).equals(this, (GeneratedMessageLite) obj);
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = u0.getInstance().schemaFor((u0) this).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i10 = this.memoizedHashCode;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = u0.getInstance().schemaFor((u0) this).hashCode(this);
        this.memoizedHashCode = iHashCode;
        return iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        u0.getInstance().schemaFor((u0) this).makeImmutable(this);
    }

    public String toString() {
        String string = super.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("# ");
        sb2.append(string);
        m0.c(this, sb2, 0);
        return sb2.toString();
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        u0.getInstance().schemaFor((u0) this).writeTo(this, j.forCodedOutput(codedOutputStream));
    }

    public static final <T extends GeneratedMessageLite<T, ?>> boolean isInitialized(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.dynamicMethod(MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zIsInitialized = u0.getInstance().schemaFor((u0) t10).isInitialized(t10);
        if (z10) {
            t10.dynamicMethod(MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED, zIsInitialized ? t10 : null);
        }
        return zIsInitialized;
    }

    public Object dynamicMethod(MethodToInvoke methodToInvoke) {
        return dynamicMethod(methodToInvoke, null, null);
    }

    @Override // androidx.datastore.preferences.protobuf.l0
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(MethodToInvoke.GET_DEFAULT_INSTANCE);
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) dynamicMethod(MethodToInvoke.NEW_BUILDER);
        buildertype.mergeFrom(this);
        return buildertype;
    }
}
