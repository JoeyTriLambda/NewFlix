package e5;

import java.nio.ByteBuffer;

/* compiled from: DecoderInputBuffer.java */
/* loaded from: classes.dex */
public class e extends a {

    /* renamed from: m, reason: collision with root package name */
    public final b f11141m = new b();

    /* renamed from: n, reason: collision with root package name */
    public ByteBuffer f11142n;

    /* renamed from: o, reason: collision with root package name */
    public long f11143o;

    /* renamed from: p, reason: collision with root package name */
    public final int f11144p;

    public e(int i10) {
        this.f11144p = i10;
    }

    public static e newFlagsOnlyInstance() {
        return new e(0);
    }

    public final ByteBuffer a(int i10) {
        int i11 = this.f11144p;
        if (i11 == 1) {
            return ByteBuffer.allocate(i10);
        }
        if (i11 == 2) {
            return ByteBuffer.allocateDirect(i10);
        }
        ByteBuffer byteBuffer = this.f11142n;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i10 + ")");
    }

    @Override // e5.a
    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.f11142n;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void ensureSpaceForWrite(int i10) throws IllegalStateException {
        ByteBuffer byteBuffer = this.f11142n;
        if (byteBuffer == null) {
            this.f11142n = a(i10);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.f11142n.position();
        int i11 = i10 + iPosition;
        if (iCapacity >= i11) {
            return;
        }
        ByteBuffer byteBufferA = a(i11);
        if (iPosition > 0) {
            this.f11142n.position(0);
            this.f11142n.limit(iPosition);
            byteBufferA.put(this.f11142n);
        }
        this.f11142n = byteBufferA;
    }

    public final void flip() {
        this.f11142n.flip();
    }

    public final boolean isEncrypted() {
        return getFlag(1073741824);
    }

    public final boolean isFlagsOnly() {
        return this.f11142n == null && this.f11144p == 0;
    }
}
