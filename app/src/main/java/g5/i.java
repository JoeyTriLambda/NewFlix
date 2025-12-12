package g5;

import java.util.regex.Pattern;
import s5.g;

/* compiled from: GaplessInfoHolder.java */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final a f12708c = new a();

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f12709d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a, reason: collision with root package name */
    public int f12710a = -1;

    /* renamed from: b, reason: collision with root package name */
    public int f12711b = -1;

    /* compiled from: GaplessInfoHolder.java */
    public static class a implements g.a {
        public boolean evaluate(int i10, int i11, int i12, int i13, int i14) {
            return i11 == 67 && i12 == 79 && i13 == 77 && (i14 == 77 || i10 == 2);
        }
    }

    public boolean hasGaplessInfo() {
        return (this.f12710a == -1 || this.f12711b == -1) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean setFromMetadata(q5.a r8) throws java.lang.NumberFormatException {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r8.length()
            if (r1 >= r2) goto L4f
            q5.a$b r2 = r8.get(r1)
            boolean r3 = r2 instanceof s5.e
            if (r3 == 0) goto L4c
            s5.e r2 = (s5.e) r2
            java.lang.String r3 = r2.f19085n
            java.lang.String r4 = "iTunSMPB"
            boolean r3 = r4.equals(r3)
            r4 = 1
            if (r3 != 0) goto L1f
        L1d:
            r2 = 0
            goto L49
        L1f:
            java.util.regex.Pattern r3 = g5.i.f12709d
            java.lang.String r2 = r2.f19086o
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r3 = r2.find()
            if (r3 == 0) goto L1d
            java.lang.String r3 = r2.group(r4)     // Catch: java.lang.NumberFormatException -> L1d
            r5 = 16
            int r3 = java.lang.Integer.parseInt(r3, r5)     // Catch: java.lang.NumberFormatException -> L1d
            r6 = 2
            java.lang.String r2 = r2.group(r6)     // Catch: java.lang.NumberFormatException -> L1d
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch: java.lang.NumberFormatException -> L1d
            if (r3 > 0) goto L44
            if (r2 <= 0) goto L1d
        L44:
            r7.f12710a = r3     // Catch: java.lang.NumberFormatException -> L1d
            r7.f12711b = r2     // Catch: java.lang.NumberFormatException -> L1d
            r2 = 1
        L49:
            if (r2 == 0) goto L4c
            return r4
        L4c:
            int r1 = r1 + 1
            goto L2
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.i.setFromMetadata(q5.a):boolean");
    }

    public boolean setFromXingHeaderValue(int i10) {
        int i11 = i10 >> 12;
        int i12 = i10 & 4095;
        if (i11 <= 0 && i12 <= 0) {
            return false;
        }
        this.f12710a = i11;
        this.f12711b = i12;
        return true;
    }
}
