package n5;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import n5.v;

/* compiled from: DefaultTsPayloadReaderFactory.java */
/* loaded from: classes.dex */
public final class e implements v.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f16527a;

    /* renamed from: b, reason: collision with root package name */
    public final List<c5.i> f16528b;

    public e(int i10) {
        this(i10, Collections.emptyList());
    }

    public final s a(v.b bVar) {
        String str;
        int i10;
        boolean zB = b(32);
        List<c5.i> list = this.f16528b;
        if (zB) {
            return new s(list);
        }
        l6.l lVar = new l6.l(bVar.f16726d);
        while (lVar.bytesLeft() > 0) {
            int unsignedByte = lVar.readUnsignedByte();
            int position = lVar.getPosition() + lVar.readUnsignedByte();
            if (unsignedByte == 134) {
                ArrayList arrayList = new ArrayList();
                int unsignedByte2 = lVar.readUnsignedByte() & 31;
                for (int i11 = 0; i11 < unsignedByte2; i11++) {
                    String string = lVar.readString(3);
                    int unsignedByte3 = lVar.readUnsignedByte();
                    if ((unsignedByte3 & 128) != 0) {
                        i10 = unsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i10 = 1;
                    }
                    arrayList.add(c5.i.createTextSampleFormat((String) null, str, (String) null, -1, 0, string, i10, (com.google.android.exoplayer2.drm.c) null));
                    lVar.skipBytes(2);
                }
                list = arrayList;
            }
            lVar.setPosition(position);
        }
        return new s(list);
    }

    public final boolean b(int i10) {
        return (i10 & this.f16527a) != 0;
    }

    @Override // n5.v.c
    public SparseArray<v> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // n5.v.c
    public v createPayloadReader(int i10, v.b bVar) {
        if (i10 == 2) {
            return new o(new i());
        }
        if (i10 == 3 || i10 == 4) {
            return new o(new m(bVar.f16724b));
        }
        if (i10 == 15) {
            if (b(2)) {
                return null;
            }
            return new o(new d(false, bVar.f16724b));
        }
        if (i10 == 21) {
            return new o(new l());
        }
        if (i10 == 27) {
            if (b(4)) {
                return null;
            }
            return new o(new j(a(bVar), b(1), b(8)));
        }
        if (i10 == 36) {
            return new o(new k(a(bVar)));
        }
        if (i10 == 89) {
            return new o(new g(bVar.f16725c));
        }
        if (i10 != 138) {
            if (i10 != 129) {
                if (i10 != 130) {
                    if (i10 == 134) {
                        if (b(16)) {
                            return null;
                        }
                        return new r(new t());
                    }
                    if (i10 != 135) {
                        return null;
                    }
                }
            }
            return new o(new b(bVar.f16724b));
        }
        return new o(new f(bVar.f16724b));
    }

    public e(int i10, List<c5.i> list) {
        this.f16527a = i10;
        if (!b(32) && list.isEmpty()) {
            list = Collections.singletonList(c5.i.createTextSampleFormat(null, "application/cea-608", 0, null));
        }
        this.f16528b = list;
    }
}
