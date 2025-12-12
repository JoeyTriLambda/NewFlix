package ie;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public int f13370a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13371b;

    public a() {
        this.f13370a = 0;
        this.f13371b = 0;
    }

    public int a() {
        return this.f13371b;
    }

    public int b() {
        return this.f13370a;
    }

    public a(byte[] bArr) {
        this.f13370a = 0;
        this.f13371b = 0;
        if (bArr.length >= 8) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f13370a = byteBufferWrap.getInt();
            this.f13371b = byteBufferWrap.getInt();
        }
    }

    public void a(int i10) {
        this.f13370a = i10;
    }
}
