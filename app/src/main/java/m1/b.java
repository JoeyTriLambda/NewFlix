package m1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: MetadataList.java */
/* loaded from: classes.dex */
public final class b extends c {
    public static b getRootAsMetadataList(ByteBuffer byteBuffer) {
        return getRootAsMetadataList(byteBuffer, new b());
    }

    public b __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public a list(a aVar, int i10) {
        int i__offset = __offset(6);
        if (i__offset == 0) {
            return null;
        }
        return aVar.__assign(__indirect((i10 * 4) + __vector(i__offset)), this.f16089b);
    }

    public int listLength() {
        int i__offset = __offset(6);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public int version() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f16089b.getInt(i__offset + this.f16088a);
        }
        return 0;
    }

    public static b getRootAsMetadataList(ByteBuffer byteBuffer, b bVar) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return bVar.__assign(byteBuffer.position() + byteBuffer.getInt(byteBuffer.position()), byteBuffer);
    }
}
