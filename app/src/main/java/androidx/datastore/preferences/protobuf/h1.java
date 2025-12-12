package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLiteSchema.java */
/* loaded from: classes.dex */
public final class h1 extends f1<g1, g1> {
    @Override // androidx.datastore.preferences.protobuf.f1
    public final void a(int i10, int i11, Object obj) {
        ((g1) obj).a((i10 << 3) | 5, Integer.valueOf(i11));
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void b(long j10, int i10, Object obj) {
        ((g1) obj).a((i10 << 3) | 1, Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void c(int i10, Object obj, Object obj2) {
        ((g1) obj).a((i10 << 3) | 3, (g1) obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void d(g1 g1Var, int i10, ByteString byteString) {
        g1Var.a((i10 << 3) | 2, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void e(long j10, int i10, Object obj) {
        ((g1) obj).a((i10 << 3) | 0, Long.valueOf(j10));
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final g1 f(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        g1 g1Var = generatedMessageLite.unknownFields;
        if (g1Var != g1.getDefaultInstance()) {
            return g1Var;
        }
        g1 g1Var2 = new g1();
        generatedMessageLite.unknownFields = g1Var2;
        return g1Var2;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final g1 g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final int h(g1 g1Var) {
        return g1Var.getSerializedSize();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final int i(g1 g1Var) {
        return g1Var.getSerializedSizeAsMessageSet();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void j(Object obj) {
        ((GeneratedMessageLite) obj).unknownFields.makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final g1 k(Object obj, Object obj2) {
        g1 g1Var = (g1) obj;
        g1 g1Var2 = (g1) obj2;
        if (g1Var2.equals(g1.getDefaultInstance())) {
            return g1Var;
        }
        int i10 = g1Var.f2451a + g1Var2.f2451a;
        int[] iArrCopyOf = Arrays.copyOf(g1Var.f2452b, i10);
        System.arraycopy(g1Var2.f2452b, 0, iArrCopyOf, g1Var.f2451a, g1Var2.f2451a);
        Object[] objArrCopyOf = Arrays.copyOf(g1Var.f2453c, i10);
        System.arraycopy(g1Var2.f2453c, 0, objArrCopyOf, g1Var.f2451a, g1Var2.f2451a);
        return new g1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final g1 m() {
        return new g1();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void n(Object obj, g1 g1Var) {
        ((GeneratedMessageLite) obj).unknownFields = g1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void o(Object obj, g1 g1Var) {
        ((GeneratedMessageLite) obj).unknownFields = g1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final g1 q(Object obj) {
        g1 g1Var = (g1) obj;
        g1Var.makeImmutable();
        return g1Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void r(g1 g1Var, Writer writer) throws IOException {
        g1 g1Var2 = g1Var;
        g1Var2.getClass();
        j jVar = (j) writer;
        if (jVar.fieldOrder() != Writer.FieldOrder.DESCENDING) {
            for (int i10 = 0; i10 < g1Var2.f2451a; i10++) {
                jVar.writeMessageSetItem(WireFormat.getTagFieldNumber(g1Var2.f2452b[i10]), g1Var2.f2453c[i10]);
            }
            return;
        }
        int i11 = g1Var2.f2451a;
        while (true) {
            i11--;
            if (i11 < 0) {
                return;
            } else {
                jVar.writeMessageSetItem(WireFormat.getTagFieldNumber(g1Var2.f2452b[i11]), g1Var2.f2453c[i11]);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void s(g1 g1Var, Writer writer) throws IOException {
        g1Var.writeTo(writer);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final void p() {
    }
}
