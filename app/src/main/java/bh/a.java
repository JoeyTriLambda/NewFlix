package bh;

import ah.c;
import ah.c0;
import ah.d0;
import ah.p;
import ah.u;
import java.io.EOFException;
import zf.i;

/* compiled from: -Buffer.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f4931a = c0.asUtf8ToByteArray("0123456789abcdef");

    public static final c.a commonReadAndWriteUnsafe(ah.c cVar, c.a aVar) {
        i.checkNotNullParameter(cVar, "<this>");
        i.checkNotNullParameter(aVar, "unsafeCursor");
        c.a aVarResolveDefaultParameter = d0.resolveDefaultParameter(aVar);
        if (!(aVarResolveDefaultParameter.f678b == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVarResolveDefaultParameter.f678b = cVar;
        aVarResolveDefaultParameter.f679m = true;
        return aVarResolveDefaultParameter;
    }

    public static final byte[] getHEX_DIGIT_BYTES() {
        return f4931a;
    }

    public static final boolean rangeEquals(u uVar, int i10, byte[] bArr, int i11, int i12) {
        i.checkNotNullParameter(uVar, "segment");
        i.checkNotNullParameter(bArr, "bytes");
        int i13 = uVar.f725c;
        byte[] bArr2 = uVar.f723a;
        while (i11 < i12) {
            if (i10 == i13) {
                uVar = uVar.f728f;
                i.checkNotNull(uVar);
                byte[] bArr3 = uVar.f723a;
                bArr2 = bArr3;
                i10 = uVar.f724b;
                i13 = uVar.f725c;
            }
            if (bArr2[i10] != bArr[i11]) {
                return false;
            }
            i10++;
            i11++;
        }
        return true;
    }

    public static final String readUtf8Line(ah.c cVar, long j10) throws EOFException {
        i.checkNotNullParameter(cVar, "<this>");
        if (j10 > 0) {
            long j11 = j10 - 1;
            if (cVar.getByte(j11) == ((byte) 13)) {
                String utf8 = cVar.readUtf8(j11);
                cVar.skip(2L);
                return utf8;
            }
        }
        String utf82 = cVar.readUtf8(j10);
        cVar.skip(1L);
        return utf82;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        if (r20 == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return r10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int selectPrefix(ah.c r18, ah.p r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 191
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bh.a.selectPrefix(ah.c, ah.p, boolean):int");
    }

    public static /* synthetic */ int selectPrefix$default(ah.c cVar, p pVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return selectPrefix(cVar, pVar, z10);
    }
}
