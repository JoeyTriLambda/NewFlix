package h5;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import g5.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import l6.l;

/* compiled from: ScriptTagPayloadReader.java */
/* loaded from: classes.dex */
public final class b extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    public long f12932b;

    public b(m mVar) {
        super(mVar);
        this.f12932b = -9223372036854775807L;
    }

    public static Serializable a(int i10, l lVar) {
        if (i10 == 0) {
            return Double.valueOf(Double.longBitsToDouble(lVar.readLong()));
        }
        if (i10 == 1) {
            return Boolean.valueOf(lVar.readUnsignedByte() == 1);
        }
        if (i10 == 2) {
            return c(lVar);
        }
        if (i10 != 3) {
            if (i10 == 8) {
                return b(lVar);
            }
            if (i10 != 10) {
                if (i10 != 11) {
                    return null;
                }
                Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(lVar.readLong())).doubleValue());
                lVar.skipBytes(2);
                return date;
            }
            int unsignedIntToInt = lVar.readUnsignedIntToInt();
            ArrayList arrayList = new ArrayList(unsignedIntToInt);
            for (int i11 = 0; i11 < unsignedIntToInt; i11++) {
                arrayList.add(a(lVar.readUnsignedByte(), lVar));
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strC = c(lVar);
            int unsignedByte = lVar.readUnsignedByte();
            if (unsignedByte == 9) {
                return map;
            }
            map.put(strC, a(unsignedByte, lVar));
        }
    }

    public static HashMap<String, Object> b(l lVar) {
        int unsignedIntToInt = lVar.readUnsignedIntToInt();
        HashMap<String, Object> map = new HashMap<>(unsignedIntToInt);
        for (int i10 = 0; i10 < unsignedIntToInt; i10++) {
            map.put(c(lVar), a(lVar.readUnsignedByte(), lVar));
        }
        return map;
    }

    public static String c(l lVar) {
        int unsignedShort = lVar.readUnsignedShort();
        int position = lVar.getPosition();
        lVar.skipBytes(unsignedShort);
        return new String(lVar.f15881a, position, unsignedShort);
    }

    public long getDurationUs() {
        return this.f12932b;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean parseHeader(l lVar) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void parsePayload(l lVar, long j10) throws ParserException {
        if (lVar.readUnsignedByte() != 2) {
            throw new ParserException();
        }
        if ("onMetaData".equals(c(lVar)) && lVar.readUnsignedByte() == 8) {
            HashMap<String, Object> mapB = b(lVar);
            if (mapB.containsKey("duration")) {
                double dDoubleValue = ((Double) mapB.get("duration")).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.f12932b = (long) (dDoubleValue * 1000000.0d);
                }
            }
        }
    }
}
