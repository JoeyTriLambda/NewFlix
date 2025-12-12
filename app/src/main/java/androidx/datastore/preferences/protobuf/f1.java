package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: UnknownFieldSchema.java */
/* loaded from: classes.dex */
public abstract class f1<T, B> {
    public abstract void a(int i10, int i11, Object obj);

    public abstract void b(long j10, int i10, Object obj);

    public abstract void c(int i10, Object obj, Object obj2);

    public abstract void d(B b10, int i10, ByteString byteString);

    public abstract void e(long j10, int i10, Object obj);

    public abstract g1 f(Object obj);

    public abstract g1 g(Object obj);

    public abstract int h(T t10);

    public abstract int i(T t10);

    public abstract void j(Object obj);

    public abstract g1 k(Object obj, Object obj2);

    public final boolean l(B b10, x0 x0Var) throws IOException {
        int tag = x0Var.getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(tag);
        int tagWireType = WireFormat.getTagWireType(tag);
        if (tagWireType == 0) {
            e(x0Var.readInt64(), tagFieldNumber, b10);
            return true;
        }
        if (tagWireType == 1) {
            b(x0Var.readFixed64(), tagFieldNumber, b10);
            return true;
        }
        if (tagWireType == 2) {
            d(b10, tagFieldNumber, x0Var.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.b();
            }
            a(tagFieldNumber, x0Var.readFixed32(), b10);
            return true;
        }
        g1 g1VarM = m();
        int i10 = (tagFieldNumber << 3) | 4;
        while (x0Var.getFieldNumber() != Integer.MAX_VALUE && l(g1VarM, x0Var)) {
        }
        if (i10 != x0Var.getTag()) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
        c(tagFieldNumber, b10, q(g1VarM));
        return true;
    }

    public abstract g1 m();

    public abstract void n(Object obj, B b10);

    public abstract void o(Object obj, T t10);

    public abstract void p();

    public abstract g1 q(Object obj);

    public abstract void r(T t10, Writer writer) throws IOException;

    public abstract void s(T t10, Writer writer) throws IOException;
}
