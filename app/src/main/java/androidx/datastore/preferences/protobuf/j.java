package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import androidx.datastore.preferences.protobuf.e0;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/* compiled from: CodedOutputStreamWriter.java */
/* loaded from: classes.dex */
public final class j implements Writer {

    /* renamed from: a, reason: collision with root package name */
    public final CodedOutputStream f2485a;

    public j(CodedOutputStream codedOutputStream) {
        Charset charset = w.f2545a;
        if (codedOutputStream == null) {
            throw new NullPointerException("output");
        }
        this.f2485a = codedOutputStream;
        codedOutputStream.f2329a = this;
    }

    public static j forCodedOutput(CodedOutputStream codedOutputStream) {
        j jVar = codedOutputStream.f2329a;
        return jVar != null ? jVar : new j(codedOutputStream);
    }

    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public void writeBool(int i10, boolean z10) throws IOException {
        this.f2485a.writeBool(i10, z10);
    }

    public void writeBoolList(int i10, List<Boolean> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeBool(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i12).booleanValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeBoolNoTag(list.get(i11).booleanValue());
            i11++;
        }
    }

    public void writeBytes(int i10, ByteString byteString) throws IOException {
        this.f2485a.writeBytes(i10, byteString);
    }

    public void writeBytesList(int i10, List<ByteString> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f2485a.writeBytes(i10, list.get(i11));
        }
    }

    public void writeDouble(int i10, double d10) throws IOException {
        this.f2485a.writeDouble(i10, d10);
    }

    public void writeDoubleList(int i10, List<Double> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeDouble(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i12).doubleValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeDoubleNoTag(list.get(i11).doubleValue());
            i11++;
        }
    }

    public void writeEndGroup(int i10) throws IOException {
        this.f2485a.writeTag(i10, 4);
    }

    public void writeEnum(int i10, int i11) throws IOException {
        this.f2485a.writeEnum(i10, i11);
    }

    public void writeEnumList(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeEnum(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeEnumNoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeFixed32(int i10, int i11) throws IOException {
        this.f2485a.writeFixed32(i10, i11);
    }

    public void writeFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeFixed32(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeFixed32NoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeFixed64(int i10, long j10) throws IOException {
        this.f2485a.writeFixed64(i10, j10);
    }

    public void writeFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeFixed64(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i12).longValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeFixed64NoTag(list.get(i11).longValue());
            i11++;
        }
    }

    public void writeFloat(int i10, float f10) throws IOException {
        this.f2485a.writeFloat(i10, f10);
    }

    public void writeFloatList(int i10, List<Float> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeFloat(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i12).floatValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeFloatNoTag(list.get(i11).floatValue());
            i11++;
        }
    }

    public void writeGroup(int i10, Object obj, y0 y0Var) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        codedOutputStream.writeTag(i10, 3);
        y0Var.writeTo((k0) obj, codedOutputStream.f2329a);
        codedOutputStream.writeTag(i10, 4);
    }

    public void writeGroupList(int i10, List<?> list, y0 y0Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeGroup(i10, list.get(i11), y0Var);
        }
    }

    public void writeInt32(int i10, int i11) throws IOException {
        this.f2485a.writeInt32(i10, i11);
    }

    public void writeInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeInt32(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeInt32NoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeInt64(int i10, long j10) throws IOException {
        this.f2485a.writeInt64(i10, j10);
    }

    public void writeInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeInt64(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i12).longValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeInt64NoTag(list.get(i11).longValue());
            i11++;
        }
    }

    public <K, V> void writeMap(int i10, e0.a<K, V> aVar, Map<K, V> map) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        codedOutputStream.getClass();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            codedOutputStream.writeTag(i10, 2);
            codedOutputStream.writeUInt32NoTag(e0.a(aVar, entry.getKey(), entry.getValue()));
            K key = entry.getKey();
            V value = entry.getValue();
            s.h(codedOutputStream, aVar.f2443a, 1, key);
            s.h(codedOutputStream, aVar.f2445c, 2, value);
        }
    }

    public void writeMessage(int i10, Object obj, y0 y0Var) throws IOException {
        this.f2485a.c(i10, (k0) obj, y0Var);
    }

    public void writeMessageList(int i10, List<?> list, y0 y0Var) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeMessage(i10, list.get(i11), y0Var);
        }
    }

    public final void writeMessageSetItem(int i10, Object obj) throws IOException {
        boolean z10 = obj instanceof ByteString;
        CodedOutputStream codedOutputStream = this.f2485a;
        if (z10) {
            codedOutputStream.writeRawMessageSetExtension(i10, (ByteString) obj);
        } else {
            codedOutputStream.writeMessageSetExtension(i10, (k0) obj);
        }
    }

    public void writeSFixed32(int i10, int i11) throws IOException {
        this.f2485a.writeSFixed32(i10, i11);
    }

    public void writeSFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeSFixed32(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeSFixed32NoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeSFixed64(int i10, long j10) throws IOException {
        this.f2485a.writeSFixed64(i10, j10);
    }

    public void writeSFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeSFixed64(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i12).longValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeSFixed64NoTag(list.get(i11).longValue());
            i11++;
        }
    }

    public void writeSInt32(int i10, int i11) throws IOException {
        this.f2485a.writeSInt32(i10, i11);
    }

    public void writeSInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeSInt32(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeSInt32NoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeSInt64(int i10, long j10) throws IOException {
        this.f2485a.writeSInt64(i10, j10);
    }

    public void writeSInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeSInt64(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i12).longValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeSInt64NoTag(list.get(i11).longValue());
            i11++;
        }
    }

    public void writeStartGroup(int i10) throws IOException {
        this.f2485a.writeTag(i10, 3);
    }

    public void writeString(int i10, String str) throws IOException {
        this.f2485a.writeString(i10, str);
    }

    public void writeStringList(int i10, List<String> list) throws IOException {
        boolean z10 = list instanceof a0;
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeString(i10, list.get(i11));
                i11++;
            }
            return;
        }
        a0 a0Var = (a0) list;
        while (i11 < list.size()) {
            Object raw = a0Var.getRaw(i11);
            if (raw instanceof String) {
                codedOutputStream.writeString(i10, (String) raw);
            } else {
                codedOutputStream.writeBytes(i10, (ByteString) raw);
            }
            i11++;
        }
    }

    public void writeUInt32(int i10, int i11) throws IOException {
        this.f2485a.writeUInt32(i10, i11);
    }

    public void writeUInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeUInt32(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i12).intValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeUInt32NoTag(list.get(i11).intValue());
            i11++;
        }
    }

    public void writeUInt64(int i10, long j10) throws IOException {
        this.f2485a.writeUInt64(i10, j10);
    }

    public void writeUInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        CodedOutputStream codedOutputStream = this.f2485a;
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                codedOutputStream.writeUInt64(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        codedOutputStream.writeTag(i10, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i12).longValue());
        }
        codedOutputStream.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i11 < list.size()) {
            codedOutputStream.writeUInt64NoTag(list.get(i11).longValue());
            i11++;
        }
    }
}
