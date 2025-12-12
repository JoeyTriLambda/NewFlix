package k5;

import g5.m;

/* compiled from: TrackEncryptionBox.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final String f14923a;

    /* renamed from: b, reason: collision with root package name */
    public final m.a f14924b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14925c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f14926d;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(boolean r4, java.lang.String r5, int r6, byte[] r7, int r8, int r9, byte[] r10) {
        /*
            r3 = this;
            r3.<init>()
            r4 = 0
            r0 = 1
            if (r6 != 0) goto L9
            r1 = 1
            goto La
        L9:
            r1 = 0
        La:
            if (r10 != 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            r1 = r1 ^ r2
            l6.a.checkArgument(r1)
            r3.f14923a = r5
            r3.f14925c = r6
            r3.f14926d = r10
            g5.m$a r6 = new g5.m$a
            if (r5 != 0) goto L1e
            goto L70
        L1e:
            int r10 = r5.hashCode()
            r1 = 2
            r2 = -1
            switch(r10) {
                case 3046605: goto L4a;
                case 3046671: goto L3f;
                case 3049879: goto L34;
                case 3049895: goto L29;
                default: goto L27;
            }
        L27:
            r4 = -1
            goto L53
        L29:
            java.lang.String r4 = "cens"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L32
            goto L27
        L32:
            r4 = 3
            goto L53
        L34:
            java.lang.String r4 = "cenc"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L3d
            goto L27
        L3d:
            r4 = 2
            goto L53
        L3f:
            java.lang.String r4 = "cbcs"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L48
            goto L27
        L48:
            r4 = 1
            goto L53
        L4a:
            java.lang.String r10 = "cbc1"
            boolean r10 = r5.equals(r10)
            if (r10 != 0) goto L53
            goto L27
        L53:
            switch(r4) {
                case 0: goto L6f;
                case 1: goto L6f;
                case 2: goto L70;
                case 3: goto L70;
                default: goto L56;
            }
        L56:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r10 = "Unsupported protection scheme type '"
            r4.<init>(r10)
            r4.append(r5)
            java.lang.String r5 = "'. Assuming AES-CTR crypto mode."
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "TrackEncryptionBox"
            android.util.Log.w(r5, r4)
            goto L70
        L6f:
            r0 = 2
        L70:
            r6.<init>(r0, r7, r8, r9)
            r3.f14924b = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.k.<init>(boolean, java.lang.String, int, byte[], int, int, byte[]):void");
    }
}
