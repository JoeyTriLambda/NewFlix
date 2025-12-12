package androidx.profileinstaller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: ProfileTranscoder.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3852a = {112, 114, 111, 0};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3853b = {112, 114, 109, 0};

    public static byte[] a(f2.b[] bVarArr, byte[] bArr) throws IOException {
        int i10 = 0;
        int length = 0;
        for (f2.b bVar : bVarArr) {
            length += (((((bVar.f11388g * 2) + 8) - 1) & (-8)) / 8) + (bVar.f11386e * 2) + b(bVar.f11382a, bVar.f11383b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + bVar.f11387f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(length);
        if (Arrays.equals(bArr, f2.f.f11396c)) {
            int length2 = bVarArr.length;
            while (i10 < length2) {
                f2.b bVar2 = bVarArr[i10];
                l(byteArrayOutputStream, bVar2, b(bVar2.f11382a, bVar2.f11383b, bArr));
                n(byteArrayOutputStream, bVar2);
                k(byteArrayOutputStream, bVar2);
                m(byteArrayOutputStream, bVar2);
                i10++;
            }
        } else {
            for (f2.b bVar3 : bVarArr) {
                l(byteArrayOutputStream, bVar3, b(bVar3.f11382a, bVar3.f11383b, bArr));
            }
            int length3 = bVarArr.length;
            while (i10 < length3) {
                f2.b bVar4 = bVarArr[i10];
                n(byteArrayOutputStream, bVar4);
                k(byteArrayOutputStream, bVar4);
                m(byteArrayOutputStream, bVar4);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == length) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + length);
    }

    public static String b(String str, String str2, byte[] bArr) {
        byte[] bArr2 = f2.f.f11398e;
        boolean zEquals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = f2.f.f11397d;
        String str3 = (zEquals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                str2 = str2.replace("!", ":");
            }
            return str2;
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (!str2.contains("!") && !str2.contains(":")) {
            if (str2.endsWith(".apk")) {
                return str2;
            }
            return ac.c.o(ac.c.r(str), (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2);
        }
        if ("!".equals(str3)) {
            return str2.replace(":", "!");
        }
        if (":".equals(str3)) {
            str2 = str2.replace("!", ":");
        }
        return str2;
    }

    public static int c(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw new IllegalStateException("HOT methods are not stored in the bitmap");
        }
        if (i10 == 2) {
            return i11;
        }
        if (i10 == 4) {
            return i11 + i12;
        }
        throw new IllegalStateException(ac.c.f("Unexpected flag: ", i10));
    }

    public static int[] d(ByteArrayInputStream byteArrayInputStream, int i10) throws IOException {
        int[] iArr = new int[i10];
        int iE = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            iE += f2.c.e(byteArrayInputStream);
            iArr[i11] = iE;
        }
        return iArr;
    }

    public static f2.b[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, f2.b[] bVarArr) throws IOException {
        byte[] bArr3 = f2.f.f11399f;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, f2.f.f11400g)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int iE = f2.c.e(fileInputStream);
            byte[] bArrC = f2.c.c(fileInputStream, (int) f2.c.d(fileInputStream, 4), (int) f2.c.d(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
            try {
                f2.b[] bVarArrG = g(byteArrayInputStream, bArr2, iE, bVarArr);
                byteArrayInputStream.close();
                return bVarArrG;
            } catch (Throwable th2) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        if (Arrays.equals(f2.f.f11394a, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int iD = (int) f2.c.d(fileInputStream, 1);
        byte[] bArrC2 = f2.c.c(fileInputStream, (int) f2.c.d(fileInputStream, 4), (int) f2.c.d(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArrC2);
        try {
            f2.b[] bVarArrF = f(byteArrayInputStream2, iD, bVarArr);
            byteArrayInputStream2.close();
            return bVarArrF;
        } catch (Throwable th4) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th5) {
                th4.addSuppressed(th5);
            }
            throw th4;
        }
    }

    public static f2.b[] f(ByteArrayInputStream byteArrayInputStream, int i10, f2.b[] bVarArr) throws IOException {
        if (byteArrayInputStream.available() == 0) {
            return new f2.b[0];
        }
        if (i10 != bVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i10];
        int[] iArr = new int[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iE = f2.c.e(byteArrayInputStream);
            iArr[i11] = f2.c.e(byteArrayInputStream);
            strArr[i11] = new String(f2.c.b(byteArrayInputStream, iE), StandardCharsets.UTF_8);
        }
        for (int i12 = 0; i12 < i10; i12++) {
            f2.b bVar = bVarArr[i12];
            if (!bVar.f11383b.equals(strArr[i12])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i13 = iArr[i12];
            bVar.f11386e = i13;
            bVar.f11389h = d(byteArrayInputStream, i13);
        }
        return bVarArr;
    }

    public static f2.b[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i10, f2.b[] bVarArr) throws IOException {
        f2.b bVar;
        if (byteArrayInputStream.available() == 0) {
            return new f2.b[0];
        }
        if (i10 != bVarArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i11 = 0; i11 < i10; i11++) {
            f2.c.e(byteArrayInputStream);
            String str = new String(f2.c.b(byteArrayInputStream, f2.c.e(byteArrayInputStream)), StandardCharsets.UTF_8);
            long jD = f2.c.d(byteArrayInputStream, 4);
            int iE = f2.c.e(byteArrayInputStream);
            if (bVarArr.length > 0) {
                int iIndexOf = str.indexOf("!");
                if (iIndexOf < 0) {
                    iIndexOf = str.indexOf(":");
                }
                String strSubstring = iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
                for (int i12 = 0; i12 < bVarArr.length; i12++) {
                    if (bVarArr[i12].f11383b.equals(strSubstring)) {
                        bVar = bVarArr[i12];
                        break;
                    }
                }
                bVar = null;
            } else {
                bVar = null;
            }
            if (bVar == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            bVar.f11385d = jD;
            int[] iArrD = d(byteArrayInputStream, iE);
            if (Arrays.equals(bArr, f2.f.f11398e)) {
                bVar.f11386e = iE;
                bVar.f11389h = iArrD;
            }
        }
        return bVarArr;
    }

    public static f2.b[] h(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, f2.f.f11395b)) {
            throw new IllegalStateException("Unsupported version");
        }
        int iD = (int) f2.c.d(fileInputStream, 1);
        byte[] bArrC = f2.c.c(fileInputStream, (int) f2.c.d(fileInputStream, 4), (int) f2.c.d(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrC);
        try {
            f2.b[] bVarArrI = i(byteArrayInputStream, str, iD);
            byteArrayInputStream.close();
            return bVarArrI;
        } catch (Throwable th2) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static f2.b[] i(ByteArrayInputStream byteArrayInputStream, String str, int i10) throws IOException {
        TreeMap<Integer, Integer> treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new f2.b[0];
        }
        f2.b[] bVarArr = new f2.b[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            int iE = f2.c.e(byteArrayInputStream);
            int iE2 = f2.c.e(byteArrayInputStream);
            bVarArr[i11] = new f2.b(str, new String(f2.c.b(byteArrayInputStream, iE), StandardCharsets.UTF_8), f2.c.d(byteArrayInputStream, 4), iE2, (int) f2.c.d(byteArrayInputStream, 4), (int) f2.c.d(byteArrayInputStream, 4), new int[iE2], new TreeMap());
        }
        for (int i12 = 0; i12 < i10; i12++) {
            f2.b bVar = bVarArr[i12];
            int iAvailable = byteArrayInputStream.available() - bVar.f11387f;
            int iE3 = 0;
            while (true) {
                int iAvailable2 = byteArrayInputStream.available();
                treeMap = bVar.f11390i;
                if (iAvailable2 <= iAvailable) {
                    break;
                }
                iE3 += f2.c.e(byteArrayInputStream);
                treeMap.put(Integer.valueOf(iE3), 1);
                for (int iE4 = f2.c.e(byteArrayInputStream); iE4 > 0; iE4--) {
                    f2.c.e(byteArrayInputStream);
                    int iD = (int) f2.c.d(byteArrayInputStream, 1);
                    if (iD != 6 && iD != 7) {
                        while (iD > 0) {
                            f2.c.d(byteArrayInputStream, 1);
                            for (int iD2 = (int) f2.c.d(byteArrayInputStream, 1); iD2 > 0; iD2--) {
                                f2.c.e(byteArrayInputStream);
                            }
                            iD--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != iAvailable) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            bVar.f11389h = d(byteArrayInputStream, bVar.f11386e);
            int i13 = bVar.f11388g;
            BitSet bitSetValueOf = BitSet.valueOf(f2.c.b(byteArrayInputStream, ((((i13 * 2) + 8) - 1) & (-8)) / 8));
            for (int i14 = 0; i14 < i13; i14++) {
                int i15 = bitSetValueOf.get(c(2, i14, i13)) ? 2 : 0;
                if (bitSetValueOf.get(c(4, i14, i13))) {
                    i15 |= 4;
                }
                if (i15 != 0) {
                    Integer num = treeMap.get(Integer.valueOf(i14));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i14), Integer.valueOf(i15 | num.intValue()));
                }
            }
        }
        return bVarArr;
    }

    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, f2.b[] bVarArr) throws IOException {
        ArrayList arrayList;
        int length;
        byte[] bArr2 = f2.f.f11394a;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = f2.f.f11395b;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] bArrA = a(bVarArr, bArr3);
                f2.c.f(byteArrayOutputStream, bVarArr.length, 1);
                f2.c.f(byteArrayOutputStream, bArrA.length, 4);
                byte[] bArrA2 = f2.c.a(bArrA);
                f2.c.f(byteArrayOutputStream, bArrA2.length, 4);
                byteArrayOutputStream.write(bArrA2);
                return true;
            }
            byte[] bArr4 = f2.f.f11397d;
            if (Arrays.equals(bArr, bArr4)) {
                f2.c.f(byteArrayOutputStream, bVarArr.length, 1);
                for (f2.b bVar : bVarArr) {
                    int size = bVar.f11390i.size() * 4;
                    String strB = b(bVar.f11382a, bVar.f11383b, bArr4);
                    f2.c.g(byteArrayOutputStream, strB.getBytes(StandardCharsets.UTF_8).length);
                    f2.c.g(byteArrayOutputStream, bVar.f11389h.length);
                    f2.c.f(byteArrayOutputStream, size, 4);
                    f2.c.f(byteArrayOutputStream, bVar.f11384c, 4);
                    byteArrayOutputStream.write(strB.getBytes(StandardCharsets.UTF_8));
                    Iterator<Integer> it = bVar.f11390i.keySet().iterator();
                    while (it.hasNext()) {
                        f2.c.g(byteArrayOutputStream, it.next().intValue());
                        f2.c.g(byteArrayOutputStream, 0);
                    }
                    for (int i10 : bVar.f11389h) {
                        f2.c.g(byteArrayOutputStream, i10);
                    }
                }
                return true;
            }
            byte[] bArr5 = f2.f.f11396c;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] bArrA3 = a(bVarArr, bArr5);
                f2.c.f(byteArrayOutputStream, bVarArr.length, 1);
                f2.c.f(byteArrayOutputStream, bArrA3.length, 4);
                byte[] bArrA4 = f2.c.a(bArrA3);
                f2.c.f(byteArrayOutputStream, bArrA4.length, 4);
                byteArrayOutputStream.write(bArrA4);
                return true;
            }
            byte[] bArr6 = f2.f.f11398e;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            f2.c.g(byteArrayOutputStream, bVarArr.length);
            for (f2.b bVar2 : bVarArr) {
                String strB2 = b(bVar2.f11382a, bVar2.f11383b, bArr6);
                f2.c.g(byteArrayOutputStream, strB2.getBytes(StandardCharsets.UTF_8).length);
                TreeMap<Integer, Integer> treeMap = bVar2.f11390i;
                f2.c.g(byteArrayOutputStream, treeMap.size());
                f2.c.g(byteArrayOutputStream, bVar2.f11389h.length);
                f2.c.f(byteArrayOutputStream, bVar2.f11384c, 4);
                byteArrayOutputStream.write(strB2.getBytes(StandardCharsets.UTF_8));
                Iterator<Integer> it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    f2.c.g(byteArrayOutputStream, it2.next().intValue());
                }
                for (int i11 : bVar2.f11389h) {
                    f2.c.g(byteArrayOutputStream, i11);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            f2.c.g(byteArrayOutputStream2, bVarArr.length);
            int i12 = 2;
            int i13 = 2;
            for (f2.b bVar3 : bVarArr) {
                f2.c.f(byteArrayOutputStream2, bVar3.f11384c, 4);
                f2.c.f(byteArrayOutputStream2, bVar3.f11385d, 4);
                f2.c.f(byteArrayOutputStream2, bVar3.f11388g, 4);
                String strB3 = b(bVar3.f11382a, bVar3.f11383b, bArr2);
                int length2 = strB3.getBytes(StandardCharsets.UTF_8).length;
                f2.c.g(byteArrayOutputStream2, length2);
                i13 = i13 + 4 + 4 + 4 + 2 + (length2 * 1);
                byteArrayOutputStream2.write(strB3.getBytes(StandardCharsets.UTF_8));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i13 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i13 + ", does not match actual size " + byteArray.length);
            }
            f fVar = new f(FileSectionType.DEX_FILES, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(fVar);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i14 = 0;
            for (int i15 = 0; i15 < bVarArr.length; i15++) {
                try {
                    f2.b bVar4 = bVarArr[i15];
                    f2.c.g(byteArrayOutputStream3, i15);
                    f2.c.g(byteArrayOutputStream3, bVar4.f11386e);
                    i14 = i14 + 2 + 2 + (bVar4.f11386e * 2);
                    k(byteArrayOutputStream3, bVar4);
                } finally {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i14 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray2.length);
            }
            f fVar2 = new f(FileSectionType.CLASSES, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(fVar2);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i16 = 0;
            int i17 = 0;
            while (i16 < bVarArr.length) {
                try {
                    f2.b bVar5 = bVarArr[i16];
                    Iterator<Map.Entry<Integer, Integer>> it3 = bVar5.f11390i.entrySet().iterator();
                    int iIntValue = 0;
                    while (it3.hasNext()) {
                        iIntValue |= it3.next().getValue().intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        m(byteArrayOutputStream4, bVar5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            n(byteArrayOutputStream4, bVar5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            f2.c.g(byteArrayOutputStream3, i16);
                            int length3 = byteArray3.length + i12 + byteArray4.length;
                            int i18 = i17 + 2 + 4;
                            ArrayList arrayList4 = arrayList3;
                            f2.c.f(byteArrayOutputStream3, length3, 4);
                            f2.c.g(byteArrayOutputStream3, iIntValue);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i17 = i18 + length3;
                            i16++;
                            arrayList3 = arrayList4;
                            i12 = 2;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i17 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i17 + ", does not match actual size " + byteArray5.length);
            }
            f fVar3 = new f(FileSectionType.METHODS, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(fVar3);
            long j10 = 4;
            long size2 = j10 + j10 + 4 + (arrayList2.size() * 16);
            f2.c.f(byteArrayOutputStream, arrayList2.size(), 4);
            int i19 = 0;
            while (i19 < arrayList2.size()) {
                f fVar4 = (f) arrayList2.get(i19);
                f2.c.f(byteArrayOutputStream, fVar4.f3861a.getValue(), 4);
                f2.c.f(byteArrayOutputStream, size2, 4);
                boolean z10 = fVar4.f3863c;
                byte[] bArr7 = fVar4.f3862b;
                if (z10) {
                    long length4 = bArr7.length;
                    byte[] bArrA5 = f2.c.a(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(bArrA5);
                    f2.c.f(byteArrayOutputStream, bArrA5.length, 4);
                    f2.c.f(byteArrayOutputStream, length4, 4);
                    length = bArrA5.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    f2.c.f(byteArrayOutputStream, bArr7.length, 4);
                    f2.c.f(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i19++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i20 = 0; i20 < arrayList6.size(); i20++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i20));
            }
            return true;
        } finally {
            try {
                byteArrayOutputStream2.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, f2.b bVar) throws IOException {
        int iIntValue = 0;
        for (int i10 : bVar.f11389h) {
            Integer numValueOf = Integer.valueOf(i10);
            f2.c.g(byteArrayOutputStream, numValueOf.intValue() - iIntValue);
            iIntValue = numValueOf.intValue();
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, f2.b bVar, String str) throws IOException {
        f2.c.g(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        f2.c.g(byteArrayOutputStream, bVar.f11386e);
        f2.c.f(byteArrayOutputStream, bVar.f11387f, 4);
        f2.c.f(byteArrayOutputStream, bVar.f11384c, 4);
        f2.c.f(byteArrayOutputStream, bVar.f11388g, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, f2.b bVar) throws IOException {
        byte[] bArr = new byte[((((bVar.f11388g * 2) + 8) - 1) & (-8)) / 8];
        for (Map.Entry<Integer, Integer> entry : bVar.f11390i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            int iIntValue2 = entry.getValue().intValue();
            int i10 = iIntValue2 & 2;
            int i11 = bVar.f11388g;
            if (i10 != 0) {
                int iC = c(2, iIntValue, i11);
                int i12 = iC / 8;
                bArr[i12] = (byte) ((1 << (iC % 8)) | bArr[i12]);
            }
            if ((iIntValue2 & 4) != 0) {
                int iC2 = c(4, iIntValue, i11);
                int i13 = iC2 / 8;
                bArr[i13] = (byte) ((1 << (iC2 % 8)) | bArr[i13]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, f2.b bVar) throws IOException {
        int i10 = 0;
        for (Map.Entry<Integer, Integer> entry : bVar.f11390i.entrySet()) {
            int iIntValue = entry.getKey().intValue();
            if ((entry.getValue().intValue() & 1) != 0) {
                f2.c.g(byteArrayOutputStream, iIntValue - i10);
                f2.c.g(byteArrayOutputStream, 0);
                i10 = iIntValue;
            }
        }
    }
}
