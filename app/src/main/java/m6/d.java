package m6;

import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import l6.j;
import l6.l;

/* compiled from: HevcConfig.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f16133a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16134b;

    public d(int i10, List list) {
        this.f16133a = list;
        this.f16134b = i10;
    }

    public static d parse(l lVar) throws ParserException {
        try {
            lVar.skipBytes(21);
            int unsignedByte = lVar.readUnsignedByte() & 3;
            int unsignedByte2 = lVar.readUnsignedByte();
            int position = lVar.getPosition();
            int i10 = 0;
            for (int i11 = 0; i11 < unsignedByte2; i11++) {
                lVar.skipBytes(1);
                int unsignedShort = lVar.readUnsignedShort();
                for (int i12 = 0; i12 < unsignedShort; i12++) {
                    int unsignedShort2 = lVar.readUnsignedShort();
                    i10 += unsignedShort2 + 4;
                    lVar.skipBytes(unsignedShort2);
                }
            }
            lVar.setPosition(position);
            byte[] bArr = new byte[i10];
            int i13 = 0;
            for (int i14 = 0; i14 < unsignedByte2; i14++) {
                lVar.skipBytes(1);
                int unsignedShort3 = lVar.readUnsignedShort();
                for (int i15 = 0; i15 < unsignedShort3; i15++) {
                    int unsignedShort4 = lVar.readUnsignedShort();
                    System.arraycopy(j.f15860a, 0, bArr, i13, 4);
                    int i16 = i13 + 4;
                    System.arraycopy(lVar.f15881a, lVar.getPosition(), bArr, i16, unsignedShort4);
                    i13 = i16 + unsignedShort4;
                    lVar.skipBytes(unsignedShort4);
                }
            }
            return new d(unsignedByte + 1, i10 == 0 ? null : Collections.singletonList(bArr));
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw new ParserException("Error parsing HEVC config", e10);
        }
    }
}
