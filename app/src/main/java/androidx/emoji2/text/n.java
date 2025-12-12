package androidx.emoji2.text;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataListReader.java */
/* loaded from: classes.dex */
public final class n {

    /* compiled from: MetadataListReader.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ByteBuffer f2653a;

        public a(ByteBuffer byteBuffer) {
            this.f2653a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public long getPosition() {
            return this.f2653a.position();
        }

        public int readTag() throws IOException {
            return this.f2653a.getInt();
        }

        public long readUnsignedInt() throws IOException {
            return this.f2653a.getInt() & 4294967295L;
        }

        public int readUnsignedShort() throws IOException {
            return this.f2653a.getShort() & 65535;
        }

        public void skip(int i10) throws IOException {
            ByteBuffer byteBuffer = this.f2653a;
            byteBuffer.position(byteBuffer.position() + i10);
        }
    }

    public static m1.b a(ByteBuffer byteBuffer) throws IOException {
        long unsignedInt;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        a aVar = new a(byteBufferDuplicate);
        aVar.skip(4);
        int unsignedShort = aVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        aVar.skip(6);
        int i10 = 0;
        while (true) {
            if (i10 >= unsignedShort) {
                unsignedInt = -1;
                break;
            }
            int tag = aVar.readTag();
            aVar.skip(4);
            unsignedInt = aVar.readUnsignedInt();
            aVar.skip(4);
            if (1835365473 == tag) {
                break;
            }
            i10++;
        }
        if (unsignedInt != -1) {
            aVar.skip((int) (unsignedInt - aVar.getPosition()));
            aVar.skip(12);
            long unsignedInt2 = aVar.readUnsignedInt();
            for (int i11 = 0; i11 < unsignedInt2; i11++) {
                int tag2 = aVar.readTag();
                long unsignedInt3 = aVar.readUnsignedInt();
                aVar.readUnsignedInt();
                if (1164798569 == tag2 || 1701669481 == tag2) {
                    byteBufferDuplicate.position((int) (unsignedInt3 + unsignedInt));
                    return m1.b.getRootAsMetadataList(byteBufferDuplicate);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }
}
