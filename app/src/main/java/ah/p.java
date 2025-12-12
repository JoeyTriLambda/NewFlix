package ah;

import java.io.IOException;
import java.util.List;
import java.util.RandomAccess;
import okio.ByteString;

/* compiled from: Options.kt */
/* loaded from: classes2.dex */
public final class p extends mf.a<ByteString> implements RandomAccess {

    /* renamed from: o, reason: collision with root package name */
    public static final a f705o = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public final ByteString[] f706m;

    /* renamed from: n, reason: collision with root package name */
    public final int[] f707n;

    /* compiled from: Options.kt */
    public static final class a {
        public a(zf.f fVar) {
        }

        public static void a(long j10, c cVar, int i10, List list, int i11, int i12, List list2) throws IOException {
            int i13;
            int i14;
            int i15;
            int i16;
            long j11;
            c cVar2;
            long j12;
            int i17 = i10;
            if (!(i11 < i12)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i11 < i12) {
                int i18 = i11;
                while (true) {
                    int i19 = i18 + 1;
                    if (!(((ByteString) list.get(i18)).size() >= i17)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                    if (i19 >= i12) {
                        break;
                    } else {
                        i18 = i19;
                    }
                }
            }
            ByteString byteString = (ByteString) list.get(i11);
            ByteString byteString2 = (ByteString) list.get(i12 - 1);
            if (i17 == byteString.size()) {
                int iIntValue = ((Number) list2.get(i11)).intValue();
                int i20 = i11 + 1;
                ByteString byteString3 = (ByteString) list.get(i20);
                i13 = i20;
                i14 = iIntValue;
                byteString = byteString3;
            } else {
                i13 = i11;
                i14 = -1;
            }
            if (byteString.getByte(i17) == byteString2.getByte(i17)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                if (i17 < iMin) {
                    int i21 = i17;
                    i15 = 0;
                    while (true) {
                        int i22 = i21 + 1;
                        if (byteString.getByte(i21) != byteString2.getByte(i21)) {
                            break;
                        }
                        i15++;
                        if (i22 >= iMin) {
                            break;
                        } else {
                            i21 = i22;
                        }
                    }
                } else {
                    i15 = 0;
                }
                long j13 = 4;
                long size = (cVar.size() / j13) + j10 + 2 + i15 + 1;
                cVar.writeInt(-i15);
                cVar.writeInt(i14);
                int i23 = i17 + i15;
                if (i17 < i23) {
                    while (true) {
                        int i24 = i17 + 1;
                        cVar.writeInt(byteString.getByte(i17) & 255);
                        if (i24 >= i23) {
                            break;
                        } else {
                            i17 = i24;
                        }
                    }
                }
                if (i13 + 1 == i12) {
                    if (!(i23 == ((ByteString) list.get(i13)).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    cVar.writeInt(((Number) list2.get(i13)).intValue());
                    return;
                } else {
                    c cVar3 = new c();
                    cVar.writeInt(((int) ((cVar3.size() / j13) + size)) * (-1));
                    a(size, cVar3, i23, list, i13, i12, list2);
                    cVar.writeAll(cVar3);
                    return;
                }
            }
            int i25 = i13 + 1;
            int i26 = 1;
            if (i25 < i12) {
                while (true) {
                    int i27 = i25 + 1;
                    if (((ByteString) list.get(i25 - 1)).getByte(i17) != ((ByteString) list.get(i25)).getByte(i17)) {
                        i26++;
                    }
                    if (i27 >= i12) {
                        break;
                    } else {
                        i25 = i27;
                    }
                }
            }
            long j14 = 4;
            long size2 = (i26 * 2) + (cVar.size() / j14) + j10 + 2;
            cVar.writeInt(i26);
            cVar.writeInt(i14);
            if (i13 < i12) {
                int i28 = i13;
                while (true) {
                    int i29 = i28 + 1;
                    int i30 = ((ByteString) list.get(i28)).getByte(i17);
                    if (i28 == i13 || i30 != ((ByteString) list.get(i28 - 1)).getByte(i17)) {
                        cVar.writeInt(i30 & 255);
                    }
                    if (i29 >= i12) {
                        break;
                    } else {
                        i28 = i29;
                    }
                }
            }
            c cVar4 = new c();
            while (i13 < i12) {
                byte b10 = ((ByteString) list.get(i13)).getByte(i17);
                int i31 = i13 + 1;
                if (i31 < i12) {
                    int i32 = i31;
                    while (true) {
                        int i33 = i32 + 1;
                        if (b10 != ((ByteString) list.get(i32)).getByte(i17)) {
                            i16 = i32;
                            break;
                        } else if (i33 >= i12) {
                            break;
                        } else {
                            i32 = i33;
                        }
                    }
                    i16 = i12;
                } else {
                    i16 = i12;
                }
                if (i31 == i16 && i17 + 1 == ((ByteString) list.get(i13)).size()) {
                    cVar.writeInt(((Number) list2.get(i13)).intValue());
                    j11 = size2;
                    cVar2 = cVar4;
                    j12 = j14;
                } else {
                    cVar.writeInt(((int) ((cVar4.size() / j14) + size2)) * (-1));
                    j11 = size2;
                    cVar2 = cVar4;
                    j12 = j14;
                    a(size2, cVar4, i17 + 1, list, i13, i16, list2);
                }
                i13 = i16;
                cVar4 = cVar2;
                j14 = j12;
                size2 = j11;
            }
            cVar.writeAll(cVar4);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x00e1, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final ah.p of(okio.ByteString... r17) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 318
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: ah.p.a.of(okio.ByteString[]):ah.p");
        }
    }

    public p(ByteString[] byteStringArr, int[] iArr, zf.f fVar) {
        this.f706m = byteStringArr;
        this.f707n = iArr;
    }

    public static final p of(ByteString... byteStringArr) {
        return f705o.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public final ByteString[] getByteStrings$okio() {
        return this.f706m;
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f706m.length;
    }

    public final int[] getTrie$okio() {
        return this.f707n;
    }

    @Override // mf.a, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    @Override // mf.a, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains((p) byteString);
    }

    @Override // mf.a, java.util.List
    public ByteString get(int i10) {
        return this.f706m[i10];
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf((p) byteString);
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf((p) byteString);
    }
}
