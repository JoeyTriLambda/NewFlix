package ie;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class k extends a {

    /* renamed from: c, reason: collision with root package name */
    public final int f13420c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13421d;

    /* renamed from: e, reason: collision with root package name */
    public final j f13422e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f13423f;

    /* renamed from: g, reason: collision with root package name */
    public long f13424g;

    /* renamed from: h, reason: collision with root package name */
    public final byte[] f13425h;

    public k() {
        this.f13420c = 28672;
        this.f13421d = 28673;
    }

    public byte[] a(long j10, byte[] bArr) {
        j jVarA = j.a();
        jVarA.a(this.f13420c, j10);
        jVarA.a(this.f13421d, bArr);
        return j.a().a(7, jVarA).c();
    }

    public byte[] c() {
        return this.f13423f;
    }

    public long d() {
        return this.f13424g;
    }

    public boolean e() {
        int i10;
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f13425h);
            int i11 = byteBufferWrap.getInt();
            int i12 = byteBufferWrap.getInt();
            int i13 = byteBufferWrap.getInt();
            int i14 = byteBufferWrap.getInt();
            this.f13424g = byteBufferWrap.getLong();
            int i15 = byteBufferWrap.getInt();
            int i16 = byteBufferWrap.getInt();
            int i17 = this.f13420c;
            if (i13 != i17 || i15 != (i10 = this.f13421d) || i16 + 24 > i12) {
                je.a.b("k", "ERROR VALIDATING MESSAGE: type:%d totalLen:%d TunnelParam:%d TunnelIdLen:%d tunnel id:%d msgParamType:%d msgParamLen:%d", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Long.valueOf(this.f13424g), Integer.valueOf(i15), Integer.valueOf(i16));
                throw new NumberFormatException("Format or (internal) Size is irastional ");
            }
            if (b() != 7) {
                return false;
            }
            j jVarF = this.f13422e.f(7);
            this.f13424g = jVarF.e(i17).longValue();
            this.f13423f = jVarF.c(i10);
            return true;
        } catch (Exception e10) {
            je.a.b("k", "TunnelMessage tunnel id:%d Validation Fail: %s trace: %s", Long.valueOf(this.f13424g), e10.getMessage(), e10.toString());
            return false;
        }
    }

    public k(byte[] bArr) {
        super(bArr);
        this.f13420c = 28672;
        this.f13421d = 28673;
        this.f13422e = new j(bArr);
        this.f13425h = bArr;
    }
}
