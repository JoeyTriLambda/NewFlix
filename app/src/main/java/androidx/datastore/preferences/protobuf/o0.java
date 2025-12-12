package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.s;
import androidx.datastore.preferences.protobuf.x;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MessageSetSchema.java */
/* loaded from: classes.dex */
public final class o0<T> implements y0<T> {

    /* renamed from: a, reason: collision with root package name */
    public final k0 f2522a;

    /* renamed from: b, reason: collision with root package name */
    public final f1<?, ?> f2523b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2524c;

    /* renamed from: d, reason: collision with root package name */
    public final o<?> f2525d;

    public o0(f1<?, ?> f1Var, o<?> oVar, k0 k0Var) {
        this.f2523b = f1Var;
        this.f2524c = oVar.e(k0Var);
        this.f2525d = oVar;
        this.f2522a = k0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <UT, UB, ET extends s.a<ET>> boolean a(x0 x0Var, n nVar, o<ET> oVar, s<ET> sVar, f1<UT, UB> f1Var, UB ub2) throws IOException {
        int tag = x0Var.getTag();
        k0 k0Var = this.f2522a;
        if (tag != 11) {
            if (WireFormat.getTagWireType(tag) != 2) {
                return x0Var.skipField();
            }
            GeneratedMessageLite.e eVarB = oVar.b(nVar, k0Var, WireFormat.getTagFieldNumber(tag));
            if (eVarB == null) {
                return f1Var.l(ub2, x0Var);
            }
            oVar.h(x0Var, eVarB, nVar, sVar);
            return true;
        }
        GeneratedMessageLite.e eVarB2 = null;
        ByteString bytes = null;
        int uInt32 = 0;
        while (x0Var.getFieldNumber() != Integer.MAX_VALUE) {
            int tag2 = x0Var.getTag();
            if (tag2 == 16) {
                uInt32 = x0Var.readUInt32();
                eVarB2 = oVar.b(nVar, k0Var, uInt32);
            } else if (tag2 == 26) {
                if (eVarB2 != null) {
                    oVar.h(x0Var, eVarB2, nVar, sVar);
                } else {
                    bytes = x0Var.readBytes();
                }
            } else if (!x0Var.skipField()) {
                break;
            }
        }
        if (x0Var.getTag() != 12) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        if (bytes != null) {
            if (eVarB2 != null) {
                oVar.i(bytes, eVarB2, nVar, sVar);
            } else {
                f1Var.d(ub2, uInt32, bytes);
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public boolean equals(T t10, T t11) {
        f1<?, ?> f1Var = this.f2523b;
        if (!f1Var.g(t10).equals(f1Var.g(t11))) {
            return false;
        }
        if (!this.f2524c) {
            return true;
        }
        o<?> oVar = this.f2525d;
        return oVar.c(t10).equals(oVar.c(t11));
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public int getSerializedSize(T t10) {
        f1<?, ?> f1Var = this.f2523b;
        int i10 = f1Var.i(f1Var.g(t10)) + 0;
        return this.f2524c ? i10 + this.f2525d.c(t10).getMessageSetSerializedSize() : i10;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public int hashCode(T t10) {
        int iHashCode = this.f2523b.g(t10).hashCode();
        return this.f2524c ? (iHashCode * 53) + this.f2525d.c(t10).hashCode() : iHashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public final boolean isInitialized(T t10) {
        return this.f2525d.c(t10).isInitialized();
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void makeImmutable(T t10) {
        this.f2523b.j(t10);
        this.f2525d.f(t10);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void mergeFrom(T t10, T t11) {
        Class<?> cls = a1.f2397a;
        f1<?, ?> f1Var = this.f2523b;
        f1Var.o(t10, f1Var.k(f1Var.g(t10), f1Var.g(t11)));
        if (this.f2524c) {
            o<?> oVar = this.f2525d;
            s<T> sVarC = oVar.c(t11);
            if (sVarC.d()) {
                return;
            }
            oVar.d(t10).mergeFrom(sVarC);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public T newInstance() {
        return (T) ((GeneratedMessageLite.a) this.f2522a.newBuilderForType()).m5buildPartial();
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void writeTo(T t10, Writer writer) throws IOException {
        Iterator it = this.f2525d.c(t10).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            s.a aVar = (s.a) entry.getKey();
            if (aVar.getLiteJavaType() != WireFormat.JavaType.MESSAGE || aVar.isRepeated() || aVar.isPacked()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (entry instanceof x.a) {
                ((j) writer).writeMessageSetItem(aVar.getNumber(), ((x.a) entry).getField().toByteString());
            } else {
                ((j) writer).writeMessageSetItem(aVar.getNumber(), entry.getValue());
            }
        }
        f1<?, ?> f1Var = this.f2523b;
        f1Var.r(f1Var.g(t10), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    public void mergeFrom(T t10, x0 x0Var, n nVar) throws IOException {
        f1 f1Var = this.f2523b;
        g1 g1VarF = f1Var.f(t10);
        o oVar = this.f2525d;
        s<ET> sVarD = oVar.d(t10);
        while (x0Var.getFieldNumber() != Integer.MAX_VALUE && a(x0Var, nVar, oVar, sVarD, f1Var, g1VarF)) {
            try {
            } finally {
                f1Var.n(t10, g1VarF);
            }
        }
    }
}
