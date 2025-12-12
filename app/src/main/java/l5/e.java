package l5;

import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;
import l6.l;
import l6.u;

/* compiled from: OggPageHeader.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: h, reason: collision with root package name */
    public static final int f15799h = u.getIntegerCodeForString("OggS");

    /* renamed from: a, reason: collision with root package name */
    public int f15800a;

    /* renamed from: b, reason: collision with root package name */
    public long f15801b;

    /* renamed from: c, reason: collision with root package name */
    public int f15802c;

    /* renamed from: d, reason: collision with root package name */
    public int f15803d;

    /* renamed from: e, reason: collision with root package name */
    public int f15804e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f15805f = new int[255];

    /* renamed from: g, reason: collision with root package name */
    public final l f15806g = new l(255);

    public boolean populate(g5.f fVar, boolean z10) throws InterruptedException, IOException {
        l lVar = this.f15806g;
        lVar.reset();
        reset();
        g5.b bVar = (g5.b) fVar;
        if (!(bVar.getLength() == -1 || bVar.getLength() - bVar.getPeekPosition() >= 27) || !bVar.peekFully(lVar.f15881a, 0, 27, true)) {
            if (z10) {
                return false;
            }
            throw new EOFException();
        }
        if (lVar.readUnsignedInt() != f15799h) {
            if (z10) {
                return false;
            }
            throw new ParserException("expected OggS capture pattern at begin of page");
        }
        if (lVar.readUnsignedByte() != 0) {
            if (z10) {
                return false;
            }
            throw new ParserException("unsupported bit stream revision");
        }
        this.f15800a = lVar.readUnsignedByte();
        this.f15801b = lVar.readLittleEndianLong();
        lVar.readLittleEndianUnsignedInt();
        lVar.readLittleEndianUnsignedInt();
        lVar.readLittleEndianUnsignedInt();
        int unsignedByte = lVar.readUnsignedByte();
        this.f15802c = unsignedByte;
        this.f15803d = unsignedByte + 27;
        lVar.reset();
        bVar.peekFully(lVar.f15881a, 0, this.f15802c);
        for (int i10 = 0; i10 < this.f15802c; i10++) {
            int unsignedByte2 = lVar.readUnsignedByte();
            this.f15805f[i10] = unsignedByte2;
            this.f15804e += unsignedByte2;
        }
        return true;
    }

    public void reset() {
        this.f15800a = 0;
        this.f15801b = 0L;
        this.f15802c = 0;
        this.f15803d = 0;
        this.f15804e = 0;
    }
}
