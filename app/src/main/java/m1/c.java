package m1;

import java.nio.ByteBuffer;

/* compiled from: Table.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public int f16088a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f16089b;

    /* renamed from: c, reason: collision with root package name */
    public int f16090c;

    /* renamed from: d, reason: collision with root package name */
    public int f16091d;

    public c() {
        d.getDefault();
    }

    public int __indirect(int i10) {
        return this.f16089b.getInt(i10) + i10;
    }

    public int __offset(int i10) {
        if (i10 < this.f16091d) {
            return this.f16089b.getShort(this.f16090c + i10);
        }
        return 0;
    }

    public void __reset(int i10, ByteBuffer byteBuffer) {
        this.f16089b = byteBuffer;
        if (byteBuffer == null) {
            this.f16088a = 0;
            this.f16090c = 0;
            this.f16091d = 0;
        } else {
            this.f16088a = i10;
            int i11 = i10 - byteBuffer.getInt(i10);
            this.f16090c = i11;
            this.f16091d = this.f16089b.getShort(i11);
        }
    }

    public int __vector(int i10) {
        int i11 = i10 + this.f16088a;
        return this.f16089b.getInt(i11) + i11 + 4;
    }

    public int __vector_len(int i10) {
        int i11 = i10 + this.f16088a;
        return this.f16089b.getInt(this.f16089b.getInt(i11) + i11);
    }
}
