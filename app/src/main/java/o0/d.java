package o0;

import android.graphics.Path;
import android.util.Log;

/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public final class d {
    public static float[] a(float[] fArr, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = i10 - 0;
        int iMin = Math.min(i11, length - 0);
        float[] fArr2 = new float[i11];
        System.arraycopy(fArr, 0, fArr2, 0, iMin);
        return fArr2;
    }

    public static boolean canMorph(a[] aVarArr, a[] aVarArr2) {
        if (aVarArr == null || aVarArr2 == null || aVarArr.length != aVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            a aVar = aVarArr[i10];
            char c10 = aVar.f16889a;
            a aVar2 = aVarArr2[i10];
            if (c10 != aVar2.f16889a || aVar.f16890b.length != aVar2.f16890b.length) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r13 == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0094 A[Catch: NumberFormatException -> 0x00b3, LOOP:3: B:25:0x0069->B:45:0x0094, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0056, B:25:0x0069, B:27:0x006f, B:32:0x007d, B:45:0x0094, B:47:0x0099, B:50:0x00a9, B:52:0x00ad), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099 A[Catch: NumberFormatException -> 0x00b3, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0056, B:25:0x0069, B:27:0x006f, B:32:0x007d, B:45:0x0094, B:47:0x0099, B:50:0x00a9, B:52:0x00ad), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a9 A[Catch: NumberFormatException -> 0x00b3, TryCatch #0 {NumberFormatException -> 0x00b3, blocks: (B:22:0x0056, B:25:0x0069, B:27:0x006f, B:32:0x007d, B:45:0x0094, B:47:0x0099, B:50:0x00a9, B:52:0x00ad), top: B:68:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0093 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static o0.d.a[] createNodesFromPathData(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.d.createNodesFromPathData(java.lang.String):o0.d$a[]");
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        try {
            a.nodesToPath(createNodesFromPathData(str), path);
            return path;
        } catch (RuntimeException e10) {
            throw new RuntimeException(ac.c.j("Error in parsing ", str), e10);
        }
    }

    public static a[] deepCopyNodes(a[] aVarArr) {
        a[] aVarArr2 = new a[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            aVarArr2[i10] = new a(aVarArr[i10]);
        }
        return aVarArr2;
    }

    public static void nodesToPath(a[] aVarArr, Path path) {
        int i10;
        int i11;
        char c10;
        a aVar;
        int i12;
        float[] fArr;
        int i13;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float f28;
        a[] aVarArr2 = aVarArr;
        float[] fArr2 = new float[6];
        int length = aVarArr2.length;
        char c11 = 'm';
        int i14 = 0;
        while (i14 < length) {
            a aVar2 = aVarArr2[i14];
            char c12 = aVar2.f16889a;
            float f29 = fArr2[0];
            float f30 = fArr2[1];
            float f31 = fArr2[2];
            float f32 = fArr2[3];
            float f33 = fArr2[4];
            float f34 = fArr2[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i10 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f33, f34);
                    f29 = f33;
                    f31 = f29;
                    f30 = f34;
                    f32 = f30;
                default:
                    i10 = 2;
                    break;
            }
            float f35 = f33;
            float f36 = f34;
            float f37 = f29;
            float f38 = f30;
            int i15 = 0;
            while (true) {
                float[] fArr3 = aVar2.f16890b;
                if (i15 < fArr3.length) {
                    if (c12 != 'A') {
                        if (c12 == 'C') {
                            i11 = i15;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                            fArr = fArr2;
                            i13 = length;
                            int i16 = i11 + 2;
                            int i17 = i11 + 3;
                            int i18 = i11 + 4;
                            int i19 = i11 + 5;
                            path.cubicTo(fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i16], fArr3[i17], fArr3[i18], fArr3[i19]);
                            f37 = fArr3[i18];
                            f38 = fArr3[i19];
                            f31 = fArr3[i16];
                            f32 = fArr3[i17];
                        } else if (c12 == 'H') {
                            i11 = i15;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                            fArr = fArr2;
                            i13 = length;
                            int i20 = i11 + 0;
                            path.lineTo(fArr3[i20], f38);
                            f37 = fArr3[i20];
                        } else if (c12 == 'Q') {
                            i11 = i15;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                            fArr = fArr2;
                            i13 = length;
                            int i21 = i11 + 0;
                            float f39 = fArr3[i21];
                            int i22 = i11 + 1;
                            int i23 = i11 + 2;
                            int i24 = i11 + 3;
                            path.quadTo(f39, fArr3[i22], fArr3[i23], fArr3[i24]);
                            float f40 = fArr3[i21];
                            float f41 = fArr3[i22];
                            float f42 = fArr3[i23];
                            f38 = fArr3[i24];
                            f31 = f40;
                            f32 = f41;
                            f37 = f42;
                        } else if (c12 == 'V') {
                            i11 = i15;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                            fArr = fArr2;
                            i13 = length;
                            int i25 = i11 + 0;
                            path.lineTo(f37, fArr3[i25]);
                            f38 = fArr3[i25];
                        } else if (c12 != 'a') {
                            if (c12 != 'c') {
                                if (c12 == 'h') {
                                    i11 = i15;
                                    fArr = fArr2;
                                    i13 = length;
                                    int i26 = i11 + 0;
                                    path.rLineTo(fArr3[i26], 0.0f);
                                    f37 += fArr3[i26];
                                } else if (c12 != 'q') {
                                    if (c12 != 'v') {
                                        if (c12 != 'L') {
                                            if (c12 == 'M') {
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                                f19 = fArr3[i11 + 0];
                                                f20 = fArr3[i11 + 1];
                                                if (i11 > 0) {
                                                    path.lineTo(f19, f20);
                                                } else {
                                                    path.moveTo(f19, f20);
                                                    f37 = f19;
                                                    f38 = f20;
                                                }
                                            } else if (c12 == 'S') {
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                                float f43 = f38;
                                                float f44 = f37;
                                                if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                    f21 = (f43 * 2.0f) - f32;
                                                    f22 = (f44 * 2.0f) - f31;
                                                } else {
                                                    f22 = f44;
                                                    f21 = f43;
                                                }
                                                int i27 = i11 + 0;
                                                int i28 = i11 + 1;
                                                int i29 = i11 + 2;
                                                int i30 = i11 + 3;
                                                path.cubicTo(f22, f21, fArr3[i27], fArr3[i28], fArr3[i29], fArr3[i30]);
                                                f11 = fArr3[i27];
                                                float f45 = fArr3[i28];
                                                f16 = fArr3[i29];
                                                f15 = fArr3[i30];
                                                f32 = f45;
                                                float f46 = f15;
                                                f31 = f11;
                                                f38 = f46;
                                                f37 = f16;
                                            } else if (c12 == 'T') {
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                                float f47 = f38;
                                                float f48 = f37;
                                                if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                    f23 = (f48 * 2.0f) - f31;
                                                    f24 = (f47 * 2.0f) - f32;
                                                } else {
                                                    f23 = f48;
                                                    f24 = f47;
                                                }
                                                int i31 = i11 + 0;
                                                float f49 = fArr3[i31];
                                                int i32 = i11 + 1;
                                                path.quadTo(f23, f24, f49, fArr3[i32]);
                                                f32 = f24;
                                                f31 = f23;
                                                c10 = c12;
                                                aVar = aVar2;
                                                i12 = i14;
                                                f37 = fArr3[i31];
                                                f38 = fArr3[i32];
                                            } else if (c12 == 'l') {
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                                f17 = f38;
                                                int i33 = i11 + 0;
                                                float f50 = fArr3[i33];
                                                int i34 = i11 + 1;
                                                path.rLineTo(f50, fArr3[i34]);
                                                f37 += fArr3[i33];
                                                f18 = fArr3[i34];
                                            } else if (c12 == 'm') {
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                                float f51 = fArr3[i11 + 0];
                                                f37 += f51;
                                                float f52 = fArr3[i11 + 1];
                                                f38 += f52;
                                                if (i11 > 0) {
                                                    path.rLineTo(f51, f52);
                                                } else {
                                                    path.rMoveTo(f51, f52);
                                                }
                                            } else if (c12 != 's') {
                                                if (c12 == 't') {
                                                    if (c11 == 'q' || c11 == 't' || c11 == 'Q' || c11 == 'T') {
                                                        f27 = f37 - f31;
                                                        f28 = f38 - f32;
                                                    } else {
                                                        f28 = 0.0f;
                                                        f27 = 0.0f;
                                                    }
                                                    int i35 = i15 + 0;
                                                    int i36 = i15 + 1;
                                                    path.rQuadTo(f27, f28, fArr3[i35], fArr3[i36]);
                                                    float f53 = f27 + f37;
                                                    f32 = f28 + f38;
                                                    f37 += fArr3[i35];
                                                    f38 += fArr3[i36];
                                                    f31 = f53;
                                                }
                                                i11 = i15;
                                                fArr = fArr2;
                                                i13 = length;
                                            } else {
                                                if (c11 == 'c' || c11 == 's' || c11 == 'C' || c11 == 'S') {
                                                    f25 = f37 - f31;
                                                    f26 = f38 - f32;
                                                } else {
                                                    f25 = 0.0f;
                                                    f26 = 0.0f;
                                                }
                                                int i37 = i15 + 0;
                                                float f54 = fArr3[i37];
                                                int i38 = i15 + 1;
                                                float f55 = fArr3[i38];
                                                int i39 = i15 + 2;
                                                float f56 = fArr3[i39];
                                                int i40 = i15 + 3;
                                                float f57 = fArr3[i40];
                                                float f58 = f25;
                                                i11 = i15;
                                                i13 = length;
                                                f10 = f38;
                                                fArr = fArr2;
                                                float f59 = f37;
                                                path.rCubicTo(f58, f26, f54, f55, f56, f57);
                                                f11 = fArr3[i37] + f59;
                                                f12 = fArr3[i38] + f10;
                                                f13 = f59 + fArr3[i39];
                                                f14 = fArr3[i40];
                                            }
                                            f36 = f38;
                                            f35 = f37;
                                        } else {
                                            i11 = i15;
                                            fArr = fArr2;
                                            i13 = length;
                                            int i41 = i11 + 0;
                                            float f60 = fArr3[i41];
                                            int i42 = i11 + 1;
                                            path.lineTo(f60, fArr3[i42]);
                                            f19 = fArr3[i41];
                                            f20 = fArr3[i42];
                                        }
                                        f37 = f19;
                                        f38 = f20;
                                    } else {
                                        i11 = i15;
                                        fArr = fArr2;
                                        i13 = length;
                                        f17 = f38;
                                        int i43 = i11 + 0;
                                        path.rLineTo(0.0f, fArr3[i43]);
                                        f18 = fArr3[i43];
                                    }
                                    f38 = f17 + f18;
                                } else {
                                    i11 = i15;
                                    fArr = fArr2;
                                    i13 = length;
                                    f10 = f38;
                                    float f61 = f37;
                                    int i44 = i11 + 0;
                                    float f62 = fArr3[i44];
                                    int i45 = i11 + 1;
                                    int i46 = i11 + 2;
                                    int i47 = i11 + 3;
                                    path.rQuadTo(f62, fArr3[i45], fArr3[i46], fArr3[i47]);
                                    f11 = fArr3[i44] + f61;
                                    f12 = fArr3[i45] + f10;
                                    float f63 = fArr3[i46] + f61;
                                    float f64 = fArr3[i47];
                                    f13 = f63;
                                    f14 = f64;
                                }
                                c10 = c12;
                                aVar = aVar2;
                                i12 = i14;
                            } else {
                                i11 = i15;
                                fArr = fArr2;
                                i13 = length;
                                f10 = f38;
                                float f65 = f37;
                                int i48 = i11 + 2;
                                int i49 = i11 + 3;
                                int i50 = i11 + 4;
                                int i51 = i11 + 5;
                                path.rCubicTo(fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i48], fArr3[i49], fArr3[i50], fArr3[i51]);
                                f11 = fArr3[i48] + f65;
                                f12 = fArr3[i49] + f10;
                                f13 = f65 + fArr3[i50];
                                f14 = fArr3[i51];
                            }
                            f15 = f10 + f14;
                            f32 = f12;
                            f16 = f13;
                            float f462 = f15;
                            f31 = f11;
                            f38 = f462;
                            f37 = f16;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                        } else {
                            i11 = i15;
                            fArr = fArr2;
                            i13 = length;
                            float f66 = f38;
                            float f67 = f37;
                            int i52 = i11 + 5;
                            int i53 = i11 + 6;
                            c10 = c12;
                            aVar = aVar2;
                            i12 = i14;
                            a.a(path, f67, f66, fArr3[i52] + f67, fArr3[i53] + f66, fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i11 + 2], fArr3[i11 + 3] != 0.0f, fArr3[i11 + 4] != 0.0f);
                            f37 = f67 + fArr3[i52];
                            f38 = f66 + fArr3[i53];
                        }
                        i15 = i11 + i10;
                        i14 = i12;
                        fArr2 = fArr;
                        c11 = c10;
                        c12 = c11;
                        length = i13;
                        aVar2 = aVar;
                    } else {
                        i11 = i15;
                        c10 = c12;
                        aVar = aVar2;
                        i12 = i14;
                        fArr = fArr2;
                        i13 = length;
                        int i54 = i11 + 5;
                        int i55 = i11 + 6;
                        a.a(path, f37, f38, fArr3[i54], fArr3[i55], fArr3[i11 + 0], fArr3[i11 + 1], fArr3[i11 + 2], fArr3[i11 + 3] != 0.0f, fArr3[i11 + 4] != 0.0f);
                        f37 = fArr3[i54];
                        f38 = fArr3[i55];
                    }
                    f32 = f38;
                    f31 = f37;
                    i15 = i11 + i10;
                    i14 = i12;
                    fArr2 = fArr;
                    c11 = c10;
                    c12 = c11;
                    length = i13;
                    aVar2 = aVar;
                }
            }
            float[] fArr4 = fArr2;
            fArr4[0] = f37;
            fArr4[1] = f38;
            fArr4[2] = f31;
            fArr4[3] = f32;
            fArr4[4] = f35;
            fArr4[5] = f36;
            c11 = aVar2.f16889a;
            i14++;
            aVarArr2 = aVarArr;
            fArr2 = fArr4;
            length = length;
        }
    }

    public static void updateNodes(a[] aVarArr, a[] aVarArr2) {
        for (int i10 = 0; i10 < aVarArr2.length; i10++) {
            aVarArr[i10].f16889a = aVarArr2[i10].f16889a;
            int i11 = 0;
            while (true) {
                float[] fArr = aVarArr2[i10].f16890b;
                if (i11 < fArr.length) {
                    aVarArr[i10].f16890b[i11] = fArr[i11];
                    i11++;
                }
            }
        }
    }

    /* compiled from: PathParser.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public char f16889a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f16890b;

        public a(float[] fArr, char c10) {
            this.f16889a = c10;
            this.f16890b = fArr;
        }

        public static void a(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            double radians = Math.toRadians(f16);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d12 = f10;
            double d13 = f11;
            double d14 = (d13 * dSin) + (d12 * dCos);
            double d15 = d12;
            double d16 = f14;
            double d17 = d14 / d16;
            double d18 = f15;
            double d19 = ((d13 * dCos) + ((-f10) * dSin)) / d18;
            double d20 = d13;
            double d21 = f13;
            double d22 = ((d21 * dSin) + (f12 * dCos)) / d16;
            double d23 = ((d21 * dCos) + ((-f12) * dSin)) / d18;
            double d24 = d17 - d22;
            double d25 = d19 - d23;
            double d26 = (d17 + d22) / 2.0d;
            double d27 = (d19 + d23) / 2.0d;
            double d28 = (d25 * d25) + (d24 * d24);
            if (d28 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d29 = (1.0d / d28) - 0.25d;
            if (d29 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d28);
                float fSqrt = (float) (Math.sqrt(d28) / 1.99999d);
                a(path, f10, f11, f12, f13, f14 * fSqrt, f15 * fSqrt, f16, z10, z11);
                return;
            }
            double dSqrt = Math.sqrt(d29);
            double d30 = d24 * dSqrt;
            double d31 = dSqrt * d25;
            if (z10 == z11) {
                d10 = d26 - d31;
                d11 = d27 + d30;
            } else {
                d10 = d26 + d31;
                d11 = d27 - d30;
            }
            double dAtan2 = Math.atan2(d19 - d11, d17 - d10);
            double dAtan22 = Math.atan2(d23 - d11, d22 - d10) - dAtan2;
            int i10 = 0;
            if (z11 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            double d32 = d10 * d16;
            double d33 = d11 * d18;
            double d34 = (d32 * dCos) - (d33 * dSin);
            double d35 = (d33 * dCos) + (d32 * dSin);
            int iCeil = (int) Math.ceil(Math.abs((dAtan22 * 4.0d) / 3.141592653589793d));
            double dCos2 = Math.cos(radians);
            double dSin2 = Math.sin(radians);
            double dCos3 = Math.cos(dAtan2);
            double dSin3 = Math.sin(dAtan2);
            double d36 = -d16;
            double d37 = d36 * dCos2;
            double d38 = d18 * dSin2;
            double d39 = (d37 * dSin3) - (d38 * dCos3);
            double d40 = d36 * dSin2;
            double d41 = d18 * dCos2;
            double d42 = (dCos3 * d41) + (dSin3 * d40);
            double d43 = dAtan22 / iCeil;
            double d44 = dAtan2;
            while (i10 < iCeil) {
                double d45 = d44 + d43;
                double dSin4 = Math.sin(d45);
                double dCos4 = Math.cos(d45);
                double d46 = d43;
                double d47 = (((d16 * dCos2) * dCos4) + d34) - (d38 * dSin4);
                double d48 = d34;
                double d49 = (d41 * dSin4) + (d16 * dSin2 * dCos4) + d35;
                double d50 = (d37 * dSin4) - (d38 * dCos4);
                double d51 = (dCos4 * d41) + (dSin4 * d40);
                double d52 = d45 - d44;
                double dTan = Math.tan(d52 / 2.0d);
                double dSqrt2 = ((Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d) * Math.sin(d52)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) ((d39 * dSqrt2) + d15), (float) ((d42 * dSqrt2) + d20), (float) (d47 - (dSqrt2 * d50)), (float) (d49 - (dSqrt2 * d51)), (float) d47, (float) d49);
                i10++;
                d41 = d41;
                d40 = d40;
                iCeil = iCeil;
                dCos2 = dCos2;
                d44 = d45;
                d16 = d16;
                d42 = d51;
                d39 = d50;
                d15 = d47;
                d20 = d49;
                d43 = d46;
                d34 = d48;
            }
        }

        @Deprecated
        public static void nodesToPath(a[] aVarArr, Path path) {
            d.nodesToPath(aVarArr, path);
        }

        public void interpolatePathDataNode(a aVar, a aVar2, float f10) {
            this.f16889a = aVar.f16889a;
            int i10 = 0;
            while (true) {
                float[] fArr = aVar.f16890b;
                if (i10 >= fArr.length) {
                    return;
                }
                this.f16890b[i10] = (aVar2.f16890b[i10] * f10) + ((1.0f - f10) * fArr[i10]);
                i10++;
            }
        }

        public a(a aVar) {
            this.f16889a = aVar.f16889a;
            float[] fArr = aVar.f16890b;
            this.f16890b = d.a(fArr, fArr.length);
        }
    }
}
