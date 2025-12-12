package m1;

import java.nio.ByteBuffer;

/* compiled from: MetadataItem.java */
/* loaded from: classes.dex */
public final class a extends c {
    public a __assign(int i10, ByteBuffer byteBuffer) {
        __init(i10, byteBuffer);
        return this;
    }

    public void __init(int i10, ByteBuffer byteBuffer) {
        __reset(i10, byteBuffer);
    }

    public int codepoints(int i10) {
        int i__offset = __offset(16);
        if (i__offset == 0) {
            return 0;
        }
        return this.f16089b.getInt((i10 * 4) + __vector(i__offset));
    }

    public int codepointsLength() {
        int i__offset = __offset(16);
        if (i__offset != 0) {
            return __vector_len(i__offset);
        }
        return 0;
    }

    public boolean emojiStyle() {
        int i__offset = __offset(6);
        return (i__offset == 0 || this.f16089b.get(i__offset + this.f16088a) == 0) ? false : true;
    }

    public short height() {
        int i__offset = __offset(14);
        if (i__offset != 0) {
            return this.f16089b.getShort(i__offset + this.f16088a);
        }
        return (short) 0;
    }

    public int id() {
        int i__offset = __offset(4);
        if (i__offset != 0) {
            return this.f16089b.getInt(i__offset + this.f16088a);
        }
        return 0;
    }

    public short sdkAdded() {
        int i__offset = __offset(8);
        if (i__offset != 0) {
            return this.f16089b.getShort(i__offset + this.f16088a);
        }
        return (short) 0;
    }

    public short width() {
        int i__offset = __offset(12);
        if (i__offset != 0) {
            return this.f16089b.getShort(i__offset + this.f16088a);
        }
        return (short) 0;
    }
}
