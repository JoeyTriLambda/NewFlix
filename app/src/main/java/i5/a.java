package i5;

import com.google.android.exoplayer2.ParserException;
import i5.d;
import java.io.IOException;
import java.util.Stack;

/* compiled from: DefaultEbmlReader.java */
/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f13138a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final Stack<C0164a> f13139b = new Stack<>();

    /* renamed from: c, reason: collision with root package name */
    public final f f13140c = new f();

    /* renamed from: d, reason: collision with root package name */
    public c f13141d;

    /* renamed from: e, reason: collision with root package name */
    public int f13142e;

    /* renamed from: f, reason: collision with root package name */
    public int f13143f;

    /* renamed from: g, reason: collision with root package name */
    public long f13144g;

    /* compiled from: DefaultEbmlReader.java */
    /* renamed from: i5.a$a, reason: collision with other inner class name */
    public static final class C0164a {

        /* renamed from: a, reason: collision with root package name */
        public final int f13145a;

        /* renamed from: b, reason: collision with root package name */
        public final long f13146b;

        public C0164a(int i10, long j10) {
            this.f13145a = i10;
            this.f13146b = j10;
        }
    }

    public void init(c cVar) {
        this.f13141d = cVar;
    }

    public boolean read(g5.f fVar) throws InterruptedException, IOException {
        String str;
        int unsignedVarintLength;
        int iAssembleVarint;
        l6.a.checkState(this.f13141d != null);
        while (true) {
            Stack<C0164a> stack = this.f13139b;
            if (!stack.isEmpty() && ((g5.b) fVar).getPosition() >= stack.peek().f13146b) {
                ((d.a) this.f13141d).endMasterElement(stack.pop().f13145a);
                return true;
            }
            int i10 = this.f13142e;
            byte[] bArr = this.f13138a;
            f fVar2 = this.f13140c;
            if (i10 == 0) {
                long unsignedVarint = fVar2.readUnsignedVarint(fVar, true, false, 4);
                if (unsignedVarint == -2) {
                    g5.b bVar = (g5.b) fVar;
                    bVar.resetPeekPosition();
                    while (true) {
                        bVar.peekFully(bArr, 0, 4);
                        unsignedVarintLength = f.parseUnsignedVarintLength(bArr[0]);
                        if (unsignedVarintLength != -1 && unsignedVarintLength <= 4) {
                            iAssembleVarint = (int) f.assembleVarint(bArr, unsignedVarintLength, false);
                            if (((d.a) this.f13141d).isLevel1Element(iAssembleVarint)) {
                                break;
                            }
                        }
                        bVar.skipFully(1);
                    }
                    bVar.skipFully(unsignedVarintLength);
                    unsignedVarint = iAssembleVarint;
                }
                if (unsignedVarint == -1) {
                    return false;
                }
                this.f13143f = (int) unsignedVarint;
                this.f13142e = 1;
            }
            if (this.f13142e == 1) {
                this.f13144g = fVar2.readUnsignedVarint(fVar, false, true, 8);
                this.f13142e = 2;
            }
            int elementType = ((d.a) this.f13141d).getElementType(this.f13143f);
            if (elementType != 0) {
                if (elementType == 1) {
                    long position = ((g5.b) fVar).getPosition();
                    stack.add(new C0164a(this.f13143f, this.f13144g + position));
                    ((d.a) this.f13141d).startMasterElement(this.f13143f, position, this.f13144g);
                    this.f13142e = 0;
                    return true;
                }
                if (elementType == 2) {
                    long j10 = this.f13144g;
                    if (j10 > 8) {
                        throw new ParserException("Invalid integer size: " + this.f13144g);
                    }
                    c cVar = this.f13141d;
                    int i11 = this.f13143f;
                    int i12 = (int) j10;
                    ((g5.b) fVar).readFully(bArr, 0, i12);
                    long j11 = 0;
                    for (int i13 = 0; i13 < i12; i13++) {
                        j11 = (j11 << 8) | (bArr[i13] & 255);
                    }
                    ((d.a) cVar).integerElement(i11, j11);
                    this.f13142e = 0;
                    return true;
                }
                if (elementType == 3) {
                    long j12 = this.f13144g;
                    if (j12 > 2147483647L) {
                        throw new ParserException("String element size: " + this.f13144g);
                    }
                    c cVar2 = this.f13141d;
                    int i14 = this.f13143f;
                    int i15 = (int) j12;
                    if (i15 == 0) {
                        str = "";
                    } else {
                        byte[] bArr2 = new byte[i15];
                        ((g5.b) fVar).readFully(bArr2, 0, i15);
                        str = new String(bArr2);
                    }
                    ((d.a) cVar2).stringElement(i14, str);
                    this.f13142e = 0;
                    return true;
                }
                if (elementType == 4) {
                    ((d.a) this.f13141d).binaryElement(this.f13143f, (int) this.f13144g, fVar);
                    this.f13142e = 0;
                    return true;
                }
                if (elementType != 5) {
                    throw new ParserException(ac.c.f("Invalid element type ", elementType));
                }
                long j13 = this.f13144g;
                if (j13 != 4 && j13 != 8) {
                    throw new ParserException("Invalid float size: " + this.f13144g);
                }
                c cVar3 = this.f13141d;
                int i16 = this.f13143f;
                int i17 = (int) j13;
                ((g5.b) fVar).readFully(bArr, 0, i17);
                long j14 = 0;
                for (int i18 = 0; i18 < i17; i18++) {
                    j14 = (j14 << 8) | (bArr[i18] & 255);
                }
                ((d.a) cVar3).floatElement(i16, i17 == 4 ? Float.intBitsToFloat((int) j14) : Double.longBitsToDouble(j14));
                this.f13142e = 0;
                return true;
            }
            ((g5.b) fVar).skipFully((int) this.f13144g);
            this.f13142e = 0;
        }
    }

    public void reset() {
        this.f13142e = 0;
        this.f13139b.clear();
        this.f13140c.reset();
    }
}
