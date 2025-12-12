package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.b0;
import java.nio.charset.Charset;

/* compiled from: ManifestSchemaFactory.java */
/* loaded from: classes.dex */
public final class d0 implements z0 {

    /* renamed from: b, reason: collision with root package name */
    public static final a f2431b = new a();

    /* renamed from: a, reason: collision with root package name */
    public final j0 f2432a;

    /* compiled from: ManifestSchemaFactory.java */
    public static class a implements j0 {
        @Override // androidx.datastore.preferences.protobuf.j0
        public boolean isSupported(Class<?> cls) {
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.j0
        public i0 messageInfoFor(Class<?> cls) {
            throw new IllegalStateException("This should never be called.");
        }
    }

    /* compiled from: ManifestSchemaFactory.java */
    public static class b implements j0 {

        /* renamed from: a, reason: collision with root package name */
        public final j0[] f2433a;

        public b(j0... j0VarArr) {
            this.f2433a = j0VarArr;
        }

        @Override // androidx.datastore.preferences.protobuf.j0
        public boolean isSupported(Class<?> cls) {
            for (j0 j0Var : this.f2433a) {
                if (j0Var.isSupported(cls)) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.j0
        public i0 messageInfoFor(Class<?> cls) {
            for (j0 j0Var : this.f2433a) {
                if (j0Var.isSupported(cls)) {
                    return j0Var.messageInfoFor(cls);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
        }
    }

    public d0() {
        j0 j0Var;
        j0[] j0VarArr = new j0[2];
        j0VarArr[0] = u.getInstance();
        try {
            j0Var = (j0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            j0Var = f2431b;
        }
        j0VarArr[1] = j0Var;
        b bVar = new b(j0VarArr);
        Charset charset = w.f2545a;
        this.f2432a = bVar;
    }

    @Override // androidx.datastore.preferences.protobuf.z0
    public <T> y0<T> createSchema(Class<T> cls) {
        a1.requireGeneratedMessage(cls);
        i0 i0VarMessageInfoFor = this.f2432a.messageInfoFor(cls);
        if (i0VarMessageInfoFor.isMessageSetWireFormat()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                return new o0(a1.unknownFieldSetLiteSchema(), q.f2526a, i0VarMessageInfoFor.getDefaultInstance());
            }
            f1<?, ?> f1VarProto2UnknownFieldSetSchema = a1.proto2UnknownFieldSetSchema();
            o<?> oVar = q.f2527b;
            if (oVar != null) {
                return new o0(f1VarProto2UnknownFieldSetSchema, oVar, i0VarMessageInfoFor.getDefaultInstance());
            }
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        boolean zIsAssignableFrom = GeneratedMessageLite.class.isAssignableFrom(cls);
        ProtoSyntax protoSyntax = ProtoSyntax.PROTO2;
        if (zIsAssignableFrom) {
            return i0VarMessageInfoFor.getSyntax() == protoSyntax ? n0.n(i0VarMessageInfoFor, r0.f2529b, b0.f2402b, a1.unknownFieldSetLiteSchema(), q.f2526a, h0.f2477b) : n0.n(i0VarMessageInfoFor, r0.f2529b, b0.f2402b, a1.unknownFieldSetLiteSchema(), null, h0.f2477b);
        }
        if (!(i0VarMessageInfoFor.getSyntax() == protoSyntax)) {
            return n0.n(i0VarMessageInfoFor, r0.f2528a, b0.f2401a, a1.proto3UnknownFieldSetSchema(), null, h0.f2476a);
        }
        p0 p0Var = r0.f2528a;
        b0.a aVar = b0.f2401a;
        f1<?, ?> f1VarProto2UnknownFieldSetSchema2 = a1.proto2UnknownFieldSetSchema();
        o<?> oVar2 = q.f2527b;
        if (oVar2 != null) {
            return n0.n(i0VarMessageInfoFor, p0Var, aVar, f1VarProto2UnknownFieldSetSchema2, oVar2, h0.f2476a);
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
