package t5;

import com.google.android.exoplayer2.metadata.MetadataDecoderException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.k;
import l6.l;
import l6.r;
import q5.a;
import t5.d;
import t5.f;

/* compiled from: SpliceInfoDecoder.java */
/* loaded from: classes.dex */
public final class c implements q5.b {

    /* renamed from: a, reason: collision with root package name */
    public final l f19424a = new l();

    /* renamed from: b, reason: collision with root package name */
    public final k f19425b = new k();

    /* renamed from: c, reason: collision with root package name */
    public r f19426c;

    @Override // q5.b
    public q5.a decode(q5.d dVar) throws MetadataDecoderException {
        a.b eVar;
        long j10;
        ArrayList arrayList;
        boolean z10;
        boolean z11;
        long j11;
        boolean z12;
        long j12;
        int unsignedShort;
        int unsignedByte;
        int unsignedByte2;
        boolean z13;
        long unsignedInt;
        List list;
        long j13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        long j14;
        int i10;
        int i11;
        int unsignedByte3;
        boolean z18;
        long unsignedInt2;
        r rVar = this.f19426c;
        if (rVar == null || dVar.f17888q != rVar.getTimestampOffsetUs()) {
            r rVar2 = new r(dVar.f11143o);
            this.f19426c = rVar2;
            rVar2.adjustSampleTimestamp(dVar.f11143o - dVar.f17888q);
        }
        ByteBuffer byteBuffer = dVar.f11142n;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        l lVar = this.f19424a;
        lVar.reset(bArrArray, iLimit);
        k kVar = this.f19425b;
        kVar.reset(bArrArray, iLimit);
        kVar.skipBits(39);
        long bits = (kVar.readBits(1) << 32) | kVar.readBits(32);
        kVar.skipBits(20);
        int bits2 = kVar.readBits(12);
        int bits3 = kVar.readBits(8);
        lVar.skipBytes(14);
        if (bits3 == 0) {
            eVar = new e();
        } else if (bits3 != 255) {
            long j15 = 128;
            if (bits3 == 4) {
                int unsignedByte4 = lVar.readUnsignedByte();
                ArrayList arrayList2 = new ArrayList(unsignedByte4);
                int i12 = 0;
                while (i12 < unsignedByte4) {
                    long unsignedInt3 = lVar.readUnsignedInt();
                    boolean z19 = (lVar.readUnsignedByte() & 128) != 0;
                    ArrayList arrayList3 = new ArrayList();
                    if (z19) {
                        j10 = j15;
                        arrayList = arrayList3;
                        z10 = false;
                        z11 = false;
                        j11 = -9223372036854775807L;
                        z12 = false;
                        j12 = -9223372036854775807L;
                        unsignedShort = 0;
                        unsignedByte = 0;
                        unsignedByte2 = 0;
                    } else {
                        int unsignedByte5 = lVar.readUnsignedByte();
                        boolean z20 = (unsignedByte5 & 128) != 0;
                        boolean z21 = (unsignedByte5 & 64) != 0;
                        boolean z22 = (unsignedByte5 & 32) != 0;
                        long unsignedInt4 = z21 ? lVar.readUnsignedInt() : -9223372036854775807L;
                        if (!z21) {
                            int unsignedByte6 = lVar.readUnsignedByte();
                            ArrayList arrayList4 = new ArrayList(unsignedByte6);
                            for (int i13 = 0; i13 < unsignedByte6; i13++) {
                                arrayList4.add(new f.b(lVar.readUnsignedByte(), lVar.readUnsignedInt()));
                            }
                            arrayList3 = arrayList4;
                        }
                        if (z22) {
                            long unsignedByte7 = lVar.readUnsignedByte();
                            j10 = 128;
                            z13 = (unsignedByte7 & 128) != 0;
                            unsignedInt = lVar.readUnsignedInt() | ((unsignedByte7 & 1) << 32);
                        } else {
                            j10 = 128;
                            z13 = false;
                            unsignedInt = -9223372036854775807L;
                        }
                        z12 = z13;
                        arrayList = arrayList3;
                        z10 = z20;
                        z11 = z21;
                        j11 = unsignedInt4;
                        j12 = unsignedInt;
                        unsignedShort = lVar.readUnsignedShort();
                        unsignedByte = lVar.readUnsignedByte();
                        unsignedByte2 = lVar.readUnsignedByte();
                    }
                    arrayList2.add(new f.c(unsignedInt3, z19, z10, z11, arrayList, j11, z12, j12, unsignedShort, unsignedByte, unsignedByte2));
                    i12++;
                    j15 = j10;
                }
                eVar = new f(arrayList2);
            } else if (bits3 == 5) {
                r rVar3 = this.f19426c;
                long unsignedInt5 = lVar.readUnsignedInt();
                boolean z23 = (lVar.readUnsignedByte() & 128) != 0;
                List listEmptyList = Collections.emptyList();
                if (z23) {
                    list = listEmptyList;
                    j13 = -9223372036854775807L;
                    z14 = false;
                    z15 = false;
                    z16 = false;
                    z17 = false;
                    j14 = -9223372036854775807L;
                    i10 = 0;
                    i11 = 0;
                    unsignedByte3 = 0;
                } else {
                    int unsignedByte8 = lVar.readUnsignedByte();
                    boolean z24 = (unsignedByte8 & 128) != 0;
                    boolean z25 = (unsignedByte8 & 64) != 0;
                    boolean z26 = (unsignedByte8 & 32) != 0;
                    boolean z27 = (unsignedByte8 & 16) != 0;
                    long jA = (!z25 || z27) ? -9223372036854775807L : g.a(lVar, bits);
                    if (!z25) {
                        int unsignedByte9 = lVar.readUnsignedByte();
                        ArrayList arrayList5 = new ArrayList(unsignedByte9);
                        for (int i14 = 0; i14 < unsignedByte9; i14++) {
                            int unsignedByte10 = lVar.readUnsignedByte();
                            long jA2 = !z27 ? g.a(lVar, bits) : -9223372036854775807L;
                            arrayList5.add(new d.b(unsignedByte10, jA2, rVar3.adjustTsTimestamp(jA2)));
                        }
                        listEmptyList = arrayList5;
                    }
                    if (z26) {
                        long unsignedByte11 = lVar.readUnsignedByte();
                        z18 = (unsignedByte11 & 128) != 0;
                        unsignedInt2 = ((unsignedByte11 & 1) << 32) | lVar.readUnsignedInt();
                    } else {
                        z18 = false;
                        unsignedInt2 = -9223372036854775807L;
                    }
                    int unsignedShort2 = lVar.readUnsignedShort();
                    int unsignedByte12 = lVar.readUnsignedByte();
                    z17 = z18;
                    unsignedByte3 = lVar.readUnsignedByte();
                    list = listEmptyList;
                    i10 = unsignedShort2;
                    i11 = unsignedByte12;
                    j14 = unsignedInt2;
                    z14 = z24;
                    z15 = z25;
                    j13 = jA;
                    z16 = z27;
                }
                eVar = new d(unsignedInt5, z23, z14, z15, z16, j13, rVar3.adjustTsTimestamp(j13), list, z17, j14, i10, i11, unsignedByte3);
            } else if (bits3 != 6) {
                eVar = null;
            } else {
                r rVar4 = this.f19426c;
                long jA3 = g.a(lVar, bits);
                eVar = new g(jA3, rVar4.adjustTsTimestamp(jA3));
            }
        } else {
            long unsignedInt6 = lVar.readUnsignedInt();
            int i15 = bits2 - 4;
            byte[] bArr = new byte[i15];
            lVar.readBytes(bArr, 0, i15);
            eVar = new a(unsignedInt6, bArr, bits);
        }
        return eVar == null ? new q5.a(new a.b[0]) : new q5.a(eVar);
    }
}
