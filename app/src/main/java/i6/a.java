package i6;

import java.util.regex.Pattern;
import l6.l;

/* compiled from: CssParser.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f13212c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: a, reason: collision with root package name */
    public final l f13213a = new l();

    /* renamed from: b, reason: collision with root package name */
    public final StringBuilder f13214b = new StringBuilder();

    public static String a(l lVar, StringBuilder sb2) {
        boolean z10 = false;
        sb2.setLength(0);
        int position = lVar.getPosition();
        int iLimit = lVar.limit();
        while (position < iLimit && !z10) {
            char c10 = (char) lVar.f15881a[position];
            if ((c10 < 'A' || c10 > 'Z') && ((c10 < 'a' || c10 > 'z') && !((c10 >= '0' && c10 <= '9') || c10 == '#' || c10 == '-' || c10 == '.' || c10 == '_'))) {
                z10 = true;
            } else {
                position++;
                sb2.append(c10);
            }
        }
        lVar.skipBytes(position - lVar.getPosition());
        return sb2.toString();
    }

    public static String b(l lVar, StringBuilder sb2) {
        c(lVar);
        if (lVar.bytesLeft() == 0) {
            return null;
        }
        String strA = a(lVar, sb2);
        if (!"".equals(strA)) {
            return strA;
        }
        return "" + ((char) lVar.readUnsignedByte());
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(l6.l r8) {
        /*
            r0 = 1
        L1:
            r1 = 1
        L2:
            int r2 = r8.bytesLeft()
            if (r2 <= 0) goto L72
            if (r1 == 0) goto L72
            int r1 = r8.getPosition()
            byte[] r2 = r8.f15881a
            r1 = r2[r1]
            char r1 = (char) r1
            r2 = 9
            r3 = 0
            if (r1 == r2) goto L2a
            r2 = 10
            if (r1 == r2) goto L2a
            r2 = 12
            if (r1 == r2) goto L2a
            r2 = 13
            if (r1 == r2) goto L2a
            r2 = 32
            if (r1 == r2) goto L2a
            r1 = 0
            goto L2e
        L2a:
            r8.skipBytes(r0)
            r1 = 1
        L2e:
            if (r1 != 0) goto L1
            int r1 = r8.getPosition()
            int r2 = r8.limit()
            byte[] r4 = r8.f15881a
            int r5 = r1 + 2
            if (r5 > r2) goto L6c
            int r5 = r1 + 1
            r1 = r4[r1]
            r6 = 47
            if (r1 != r6) goto L6c
            int r1 = r5 + 1
            r5 = r4[r5]
            r7 = 42
            if (r5 != r7) goto L6c
        L4e:
            int r5 = r1 + 1
            if (r5 >= r2) goto L62
            r1 = r4[r1]
            char r1 = (char) r1
            if (r1 != r7) goto L60
            r1 = r4[r5]
            char r1 = (char) r1
            if (r1 != r6) goto L60
            int r2 = r5 + 1
            r1 = r2
            goto L4e
        L60:
            r1 = r5
            goto L4e
        L62:
            int r1 = r8.getPosition()
            int r2 = r2 - r1
            r8.skipBytes(r2)
            r1 = 1
            goto L6d
        L6c:
            r1 = 0
        L6d:
            if (r1 == 0) goto L70
            goto L1
        L70:
            r1 = 0
            goto L2
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.a.c(l6.l):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public i6.d parseBlock(l6.l r18) {
        /*
            Method dump skipped, instructions count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.a.parseBlock(l6.l):i6.d");
    }
}
