package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* compiled from: ExtensionSchemaLite.java */
/* loaded from: classes.dex */
public final class p extends o<GeneratedMessageLite.d> {
    @Override // androidx.datastore.preferences.protobuf.o
    public final int a(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.d) entry.getKey()).getNumber();
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final GeneratedMessageLite.e b(n nVar, k0 k0Var, int i10) {
        return nVar.findLiteExtensionByNumber(k0Var, i10);
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final s<GeneratedMessageLite.d> c(Object obj) {
        return ((GeneratedMessageLite.c) obj).extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final s<GeneratedMessageLite.d> d(Object obj) {
        GeneratedMessageLite.c cVar = (GeneratedMessageLite.c) obj;
        if (cVar.extensions.isImmutable()) {
            cVar.extensions = cVar.extensions.m8clone();
        }
        return cVar.extensions;
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final boolean e(k0 k0Var) {
        return k0Var instanceof GeneratedMessageLite.c;
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final void f(Object obj) {
        ((GeneratedMessageLite.c) obj).extensions.makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final Object g(Object obj) throws IOException {
        ((GeneratedMessageLite.e) obj).getNumber();
        throw null;
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final void h(x0 x0Var, Object obj, n nVar, s<GeneratedMessageLite.d> sVar) throws IOException {
        sVar.setField(null, x0Var.readMessage(((GeneratedMessageLite.e) obj).getMessageDefaultInstance().getClass(), nVar));
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final void i(ByteString byteString, Object obj, n nVar, s<GeneratedMessageLite.d> sVar) throws IOException {
        k0 k0VarM5buildPartial = ((GeneratedMessageLite.a) ((GeneratedMessageLite.e) obj).getMessageDefaultInstance().newBuilderForType()).m5buildPartial();
        e eVarNewInstance = e.newInstance(ByteBuffer.wrap(byteString.toByteArray()), true);
        u0.getInstance().mergeFrom(k0VarM5buildPartial, eVarNewInstance, nVar);
        sVar.setField(null, k0VarM5buildPartial);
        if (((e.a) eVarNewInstance).getFieldNumber() != Integer.MAX_VALUE) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.o
    public final void j(Writer writer, Map.Entry<?, ?> entry) throws IOException {
        GeneratedMessageLite.d dVar = (GeneratedMessageLite.d) entry.getKey();
        if (dVar.isRepeated()) {
            switch (dVar.getLiteType().ordinal()) {
                case 0:
                    a1.writeDoubleList(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 1:
                    a1.writeFloatList(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 2:
                    a1.writeInt64List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 3:
                    a1.writeUInt64List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 4:
                    a1.writeInt32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 5:
                    a1.writeFixed64List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 6:
                    a1.writeFixed32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 7:
                    a1.writeBoolList(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 8:
                    a1.writeStringList(dVar.getNumber(), (List) entry.getValue(), writer);
                    break;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        a1.writeGroupList(dVar.getNumber(), (List) entry.getValue(), writer, u0.getInstance().schemaFor((Class) list.get(0).getClass()));
                        break;
                    }
                    break;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        a1.writeMessageList(dVar.getNumber(), (List) entry.getValue(), writer, u0.getInstance().schemaFor((Class) list2.get(0).getClass()));
                        break;
                    }
                    break;
                case 11:
                    a1.writeBytesList(dVar.getNumber(), (List) entry.getValue(), writer);
                    break;
                case 12:
                    a1.writeUInt32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 13:
                    a1.writeInt32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 14:
                    a1.writeSFixed32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 15:
                    a1.writeSFixed64List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 16:
                    a1.writeSInt32List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
                case 17:
                    a1.writeSInt64List(dVar.getNumber(), (List) entry.getValue(), writer, dVar.isPacked());
                    break;
            }
        }
        switch (dVar.getLiteType().ordinal()) {
            case 0:
                ((j) writer).writeDouble(dVar.getNumber(), ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                ((j) writer).writeFloat(dVar.getNumber(), ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                ((j) writer).writeInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                break;
            case 3:
                ((j) writer).writeUInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                break;
            case 4:
                ((j) writer).writeInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                ((j) writer).writeFixed64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                break;
            case 6:
                ((j) writer).writeFixed32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                ((j) writer).writeBool(dVar.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                ((j) writer).writeString(dVar.getNumber(), (String) entry.getValue());
                break;
            case 9:
                ((j) writer).writeGroup(dVar.getNumber(), entry.getValue(), u0.getInstance().schemaFor((Class) entry.getValue().getClass()));
                break;
            case 10:
                ((j) writer).writeMessage(dVar.getNumber(), entry.getValue(), u0.getInstance().schemaFor((Class) entry.getValue().getClass()));
                break;
            case 11:
                ((j) writer).writeBytes(dVar.getNumber(), (ByteString) entry.getValue());
                break;
            case 12:
                ((j) writer).writeUInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                ((j) writer).writeInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                ((j) writer).writeSFixed32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                ((j) writer).writeSFixed64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                break;
            case 16:
                ((j) writer).writeSInt32(dVar.getNumber(), ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                ((j) writer).writeSInt64(dVar.getNumber(), ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
