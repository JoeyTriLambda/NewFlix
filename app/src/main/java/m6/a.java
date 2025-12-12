package m6;

import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;
import l6.j;
import l6.l;

/* compiled from: AvcConfig.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final List<byte[]> f16110a;

    /* renamed from: b, reason: collision with root package name */
    public final int f16111b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16112c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16113d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16114e;

    public a(ArrayList arrayList, int i10, int i11, int i12, float f10) {
        this.f16110a = arrayList;
        this.f16111b = i10;
        this.f16112c = i11;
        this.f16113d = i12;
        this.f16114e = f10;
    }

    public static a parse(l lVar) throws ParserException {
        int i10;
        int i11;
        float f10;
        try {
            lVar.skipBytes(4);
            int unsignedByte = (lVar.readUnsignedByte() & 3) + 1;
            if (unsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int unsignedByte2 = lVar.readUnsignedByte() & 31;
            for (int i12 = 0; i12 < unsignedByte2; i12++) {
                int unsignedShort = lVar.readUnsignedShort();
                int position = lVar.getPosition();
                lVar.skipBytes(unsignedShort);
                arrayList.add(l6.c.buildNalUnit(lVar.f15881a, position, unsignedShort));
            }
            int unsignedByte3 = lVar.readUnsignedByte();
            for (int i13 = 0; i13 < unsignedByte3; i13++) {
                int unsignedShort2 = lVar.readUnsignedShort();
                int position2 = lVar.getPosition();
                lVar.skipBytes(unsignedShort2);
                arrayList.add(l6.c.buildNalUnit(lVar.f15881a, position2, unsignedShort2));
            }
            if (unsignedByte2 > 0) {
                j.b spsNalUnit = j.parseSpsNalUnit((byte[]) arrayList.get(0), unsignedByte, ((byte[]) arrayList.get(0)).length);
                int i14 = spsNalUnit.f15868b;
                int i15 = spsNalUnit.f15869c;
                f10 = spsNalUnit.f15870d;
                i10 = i14;
                i11 = i15;
            } else {
                i10 = -1;
                i11 = -1;
                f10 = 1.0f;
            }
            return new a(arrayList, unsignedByte, i10, i11, f10);
        } catch (ArrayIndexOutOfBoundsException e10) {
            throw new ParserException("Error parsing AVC config", e10);
        }
    }
}
