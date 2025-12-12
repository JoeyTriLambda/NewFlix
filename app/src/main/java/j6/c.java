package j6;

import android.text.TextUtils;
import c5.p;
import com.google.android.exoplayer2.ExoPlaybackException;
import j6.a;
import j6.f;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
import l6.u;
import u5.n;
import u5.o;

/* compiled from: DefaultTrackSelector.java */
/* loaded from: classes.dex */
public final class c extends e {

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f14640f = new int[0];

    /* renamed from: d, reason: collision with root package name */
    public final f.a f14641d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReference<b> f14642e = new AtomicReference<>(new b());

    /* compiled from: DefaultTrackSelector.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14643a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14644b;

        /* renamed from: c, reason: collision with root package name */
        public final String f14645c;

        public a(int i10, int i11, String str) {
            this.f14643a = i10;
            this.f14644b = i11;
            this.f14645c = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f14643a == aVar.f14643a && this.f14644b == aVar.f14644b && TextUtils.equals(this.f14645c, aVar.f14645c);
        }

        public int hashCode() {
            int i10 = ((this.f14643a * 31) + this.f14644b) * 31;
            String str = this.f14645c;
            return i10 + (str != null ? str.hashCode() : 0);
        }
    }

    /* compiled from: DefaultTrackSelector.java */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f14646a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14647b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14648c;

        /* renamed from: d, reason: collision with root package name */
        public final int f14649d;

        /* renamed from: e, reason: collision with root package name */
        public final int f14650e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f14651f;

        /* renamed from: g, reason: collision with root package name */
        public final int f14652g;

        /* renamed from: h, reason: collision with root package name */
        public final int f14653h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f14654i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f14655j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f14656k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f14657l;

        public b() {
            this(null, null, false, true, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, Integer.MAX_VALUE, Integer.MAX_VALUE, true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f14655j == bVar.f14655j && this.f14656k == bVar.f14656k && this.f14648c == bVar.f14648c && this.f14649d == bVar.f14649d && this.f14651f == bVar.f14651f && this.f14657l == bVar.f14657l && this.f14654i == bVar.f14654i && this.f14652g == bVar.f14652g && this.f14653h == bVar.f14653h && this.f14650e == bVar.f14650e && TextUtils.equals(this.f14646a, bVar.f14646a) && TextUtils.equals(this.f14647b, bVar.f14647b);
        }

        public int hashCode() {
            return ((((((((((((((((((ac.c.b(this.f14647b, this.f14646a.hashCode() * 31, 31) + (this.f14655j ? 1 : 0)) * 31) + (this.f14656k ? 1 : 0)) * 31) + this.f14648c) * 31) + this.f14649d) * 31) + this.f14650e) * 31) + (this.f14651f ? 1 : 0)) * 31) + (this.f14657l ? 1 : 0)) * 31) + (this.f14654i ? 1 : 0)) * 31) + this.f14652g) * 31) + this.f14653h;
        }

        public b(String str, String str2, boolean z10, boolean z11, int i10, int i11, int i12, boolean z12, boolean z13, int i13, int i14, boolean z14) {
            this.f14646a = str;
            this.f14647b = str2;
            this.f14655j = z10;
            this.f14656k = z11;
            this.f14648c = i10;
            this.f14649d = i11;
            this.f14650e = i12;
            this.f14651f = z12;
            this.f14657l = z13;
            this.f14652g = i13;
            this.f14653h = i14;
            this.f14654i = z14;
        }
    }

    public c(f.a aVar) {
        this.f14641d = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList a(u5.n r16, int r17, int r18, boolean r19) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.util.ArrayList r3 = new java.util.ArrayList
            int r4 = r0.f20107a
            r3.<init>(r4)
            r4 = 0
            r5 = 0
        Lf:
            int r6 = r0.f20107a
            if (r5 >= r6) goto L1d
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r3.add(r6)
            int r5 = r5 + 1
            goto Lf
        L1d:
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r5) goto La8
            if (r2 != r5) goto L26
            goto La8
        L26:
            r7 = 0
            r8 = 2147483647(0x7fffffff, float:NaN)
        L2a:
            r9 = 1
            if (r7 >= r6) goto L82
            c5.i r10 = r0.getFormat(r7)
            int r11 = r10.f5124u
            if (r11 <= 0) goto L7f
            int r12 = r10.f5125v
            if (r12 <= 0) goto L7f
            if (r19 == 0) goto L49
            if (r11 <= r12) goto L3f
            r13 = 1
            goto L40
        L3f:
            r13 = 0
        L40:
            if (r1 <= r2) goto L43
            goto L44
        L43:
            r9 = 0
        L44:
            if (r13 == r9) goto L49
            r9 = r1
            r13 = r2
            goto L4b
        L49:
            r13 = r1
            r9 = r2
        L4b:
            int r14 = r11 * r9
            int r15 = r12 * r13
            if (r14 < r15) goto L5b
            android.graphics.Point r9 = new android.graphics.Point
            int r11 = l6.u.ceilDivide(r15, r11)
            r9.<init>(r13, r11)
            goto L65
        L5b:
            android.graphics.Point r11 = new android.graphics.Point
            int r13 = l6.u.ceilDivide(r14, r12)
            r11.<init>(r13, r9)
            r9 = r11
        L65:
            int r10 = r10.f5124u
            int r11 = r10 * r12
            int r13 = r9.x
            float r13 = (float) r13
            r14 = 1065017672(0x3f7ae148, float:0.98)
            float r13 = r13 * r14
            int r13 = (int) r13
            if (r10 < r13) goto L7f
            int r9 = r9.y
            float r9 = (float) r9
            float r9 = r9 * r14
            int r9 = (int) r9
            if (r12 < r9) goto L7f
            if (r11 >= r8) goto L7f
            r8 = r11
        L7f:
            int r7 = r7 + 1
            goto L2a
        L82:
            if (r8 == r5) goto La8
            int r1 = r3.size()
            int r1 = r1 - r9
        L89:
            if (r1 < 0) goto La8
            java.lang.Object r2 = r3.get(r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            c5.i r2 = r0.getFormat(r2)
            int r2 = r2.getPixelCount()
            r4 = -1
            if (r2 == r4) goto La2
            if (r2 <= r8) goto La5
        La2:
            r3.remove(r1)
        La5:
            int r1 = r1 + (-1)
            goto L89
        La8:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.c.a(u5.n, int, int, boolean):java.util.ArrayList");
    }

    public static boolean b(c5.i iVar, int i10, a aVar) {
        if (!isSupported(i10, false) || iVar.C != aVar.f14643a || iVar.D != aVar.f14644b) {
            return false;
        }
        String str = aVar.f14645c;
        return str == null || TextUtils.equals(str, iVar.f5120q);
    }

    public static boolean c(c5.i iVar, String str, int i10, int i11, int i12, int i13, int i14) {
        if (!isSupported(i10, false) || (i10 & i11) == 0) {
            return false;
        }
        if (str != null && !u.areEqual(iVar.f5120q, str)) {
            return false;
        }
        int i15 = iVar.f5124u;
        if (i15 != -1 && i15 > i12) {
            return false;
        }
        int i16 = iVar.f5125v;
        if (i16 != -1 && i16 > i13) {
            return false;
        }
        int i17 = iVar.f5116m;
        return i17 == -1 || i17 <= i14;
    }

    public static boolean formatHasLanguage(c5.i iVar, String str) {
        return str != null && TextUtils.equals(str, u.normalizeLanguageCode(iVar.J));
    }

    public static boolean isSupported(int i10, boolean z10) {
        int i11 = i10 & 7;
        return i11 == 4 || (z10 && i11 == 3);
    }

    public f selectAudioTrack(o oVar, int[][] iArr, b bVar, f.a aVar) throws ExoPlaybackException {
        int i10;
        int[] iArr2;
        int i11 = -1;
        int i12 = -1;
        int i13 = 0;
        for (int i14 = 0; i14 < oVar.f20111a; i14++) {
            n nVar = oVar.get(i14);
            int[] iArr3 = iArr[i14];
            for (int i15 = 0; i15 < nVar.f20107a; i15++) {
                if (isSupported(iArr3[i15], bVar.f14657l)) {
                    c5.i format = nVar.getFormat(i15);
                    int i16 = iArr3[i15];
                    boolean z10 = (format.I & 1) != 0;
                    int i17 = formatHasLanguage(format, bVar.f14646a) ? z10 ? 4 : 3 : z10 ? 2 : 1;
                    if (isSupported(i16, false)) {
                        i17 += 1000;
                    }
                    if (i17 > i13) {
                        i11 = i14;
                        i12 = i15;
                        i13 = i17;
                    }
                }
            }
        }
        if (i11 == -1) {
            return null;
        }
        n nVar2 = oVar.get(i11);
        if (aVar != null) {
            int[] iArr4 = iArr[i11];
            boolean z11 = bVar.f14655j;
            HashSet hashSet = new HashSet();
            a aVar2 = null;
            int i18 = 0;
            int i19 = 0;
            while (true) {
                i10 = nVar2.f20107a;
                if (i18 >= i10) {
                    break;
                }
                c5.i format2 = nVar2.getFormat(i18);
                a aVar3 = new a(format2.C, format2.D, z11 ? null : format2.f5120q);
                if (hashSet.add(aVar3)) {
                    int i20 = 0;
                    for (int i21 = 0; i21 < i10; i21++) {
                        if (b(nVar2.getFormat(i21), iArr4[i21], aVar3)) {
                            i20++;
                        }
                    }
                    if (i20 > i19) {
                        aVar2 = aVar3;
                        i19 = i20;
                    }
                }
                i18++;
            }
            if (i19 > 1) {
                iArr2 = new int[i19];
                int i22 = 0;
                for (int i23 = 0; i23 < i10; i23++) {
                    if (b(nVar2.getFormat(i23), iArr4[i23], aVar2)) {
                        iArr2[i22] = i23;
                        i22++;
                    }
                }
            } else {
                iArr2 = f14640f;
            }
            if (iArr2.length > 0) {
                return ((a.C0169a) aVar).m32createTrackSelection(nVar2, iArr2);
            }
        }
        return new d(nVar2, i12);
    }

    public f selectOtherTrack(int i10, o oVar, int[][] iArr, b bVar) throws ExoPlaybackException {
        n nVar = null;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < oVar.f20111a; i13++) {
            n nVar2 = oVar.get(i13);
            int[] iArr2 = iArr[i13];
            for (int i14 = 0; i14 < nVar2.f20107a; i14++) {
                if (isSupported(iArr2[i14], bVar.f14657l)) {
                    int i15 = (nVar2.getFormat(i14).I & 1) != 0 ? 2 : 1;
                    if (isSupported(iArr2[i14], false)) {
                        i15 += 1000;
                    }
                    if (i15 > i12) {
                        nVar = nVar2;
                        i11 = i14;
                        i12 = i15;
                    }
                }
            }
        }
        if (nVar == null) {
            return null;
        }
        return new d(nVar, i11);
    }

    public f selectTextTrack(o oVar, int[][] iArr, b bVar) throws ExoPlaybackException {
        n nVar = null;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < oVar.f20111a; i12++) {
            n nVar2 = oVar.get(i12);
            int[] iArr2 = iArr[i12];
            for (int i13 = 0; i13 < nVar2.f20107a; i13++) {
                if (isSupported(iArr2[i13], bVar.f14657l)) {
                    c5.i format = nVar2.getFormat(i13);
                    int i14 = format.I;
                    int i15 = 1;
                    boolean z10 = (i14 & 1) != 0;
                    boolean z11 = (i14 & 2) != 0;
                    if (formatHasLanguage(format, bVar.f14647b)) {
                        i15 = z10 ? 6 : !z11 ? 5 : 4;
                    } else if (z10) {
                        i15 = 3;
                    } else if (z11) {
                        if (formatHasLanguage(format, bVar.f14646a)) {
                            i15 = 2;
                        }
                    }
                    if (isSupported(iArr2[i13], false)) {
                        i15 += 1000;
                    }
                    if (i15 > i11) {
                        nVar = nVar2;
                        i10 = i13;
                        i11 = i15;
                    }
                }
            }
        }
        if (nVar == null) {
            return null;
        }
        return new d(nVar, i10);
    }

    @Override // j6.e
    public f[] selectTracks(p[] pVarArr, o[] oVarArr, int[][][] iArr) throws ExoPlaybackException {
        int length = pVarArr.length;
        f[] fVarArr = new f[length];
        b bVar = this.f14642e.get();
        boolean z10 = false;
        int i10 = 0;
        boolean z11 = false;
        while (true) {
            if (i10 >= length) {
                break;
            }
            if (2 == ((c5.a) pVarArr[i10]).getTrackType()) {
                if (!z10) {
                    f fVarSelectVideoTrack = selectVideoTrack(pVarArr[i10], oVarArr[i10], iArr[i10], bVar, this.f14641d);
                    fVarArr[i10] = fVarSelectVideoTrack;
                    z10 = fVarSelectVideoTrack != null;
                }
                z11 |= oVarArr[i10].f20111a > 0;
            }
            i10++;
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i11 = 0; i11 < length; i11++) {
            int trackType = ((c5.a) pVarArr[i11]).getTrackType();
            if (trackType != 1) {
                if (trackType != 2) {
                    if (trackType != 3) {
                        fVarArr[i11] = selectOtherTrack(((c5.a) pVarArr[i11]).getTrackType(), oVarArr[i11], iArr[i11], bVar);
                    } else if (!z13) {
                        f fVarSelectTextTrack = selectTextTrack(oVarArr[i11], iArr[i11], bVar);
                        fVarArr[i11] = fVarSelectTextTrack;
                        z13 = fVarSelectTextTrack != null;
                    }
                }
            } else if (!z12) {
                f fVarSelectAudioTrack = selectAudioTrack(oVarArr[i11], iArr[i11], bVar, z11 ? null : this.f14641d);
                fVarArr[i11] = fVarSelectAudioTrack;
                z12 = fVarSelectAudioTrack != null;
            }
        }
        return fVarArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014d A[LOOP:0: B:15:0x001f->B:56:0x014d, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public j6.f selectVideoTrack(c5.p r27, u5.o r28, int[][] r29, j6.c.b r30, j6.f.a r31) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            Method dump skipped, instructions count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.c.selectVideoTrack(c5.p, u5.o, int[][], j6.c$b, j6.f$a):j6.f");
    }
}
