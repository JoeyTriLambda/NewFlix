package o1;

import android.util.Log;
import com.fasterxml.jackson.core.JsonPointer;
import cz.msebera.android.httpclient.HttpStatus;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: ExifInterface.java */
/* loaded from: classes.dex */
public final class b {
    public static final HashMap<Integer, Integer> A;
    public static final Charset B;
    public static final byte[] C;

    /* renamed from: k, reason: collision with root package name */
    public static final List<Integer> f16910k = Arrays.asList(1, 6, 3, 8);

    /* renamed from: l, reason: collision with root package name */
    public static final List<Integer> f16911l = Arrays.asList(2, 7, 4, 5);

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f16912m = {8, 8, 8};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f16913n = {8};

    /* renamed from: o, reason: collision with root package name */
    public static final byte[] f16914o = {-1, -40, -1};

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f16915p = {79, 76, 89, 77, 80, 0};

    /* renamed from: q, reason: collision with root package name */
    public static final byte[] f16916q = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f16917r = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: s, reason: collision with root package name */
    public static final int[] f16918s = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: t, reason: collision with root package name */
    public static final byte[] f16919t = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: u, reason: collision with root package name */
    public static final c f16920u;

    /* renamed from: v, reason: collision with root package name */
    public static final c[][] f16921v;

    /* renamed from: w, reason: collision with root package name */
    public static final c[] f16922w;

    /* renamed from: x, reason: collision with root package name */
    public static final HashMap<Integer, c>[] f16923x;

    /* renamed from: y, reason: collision with root package name */
    public static final HashMap<String, c>[] f16924y;

    /* renamed from: z, reason: collision with root package name */
    public static final HashSet<String> f16925z;

    /* renamed from: a, reason: collision with root package name */
    public final String f16926a;

    /* renamed from: b, reason: collision with root package name */
    public int f16927b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, C0208b>[] f16928c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f16929d;

    /* renamed from: e, reason: collision with root package name */
    public ByteOrder f16930e;

    /* renamed from: f, reason: collision with root package name */
    public int f16931f;

    /* renamed from: g, reason: collision with root package name */
    public int f16932g;

    /* renamed from: h, reason: collision with root package name */
    public int f16933h;

    /* renamed from: i, reason: collision with root package name */
    public int f16934i;

    /* renamed from: j, reason: collision with root package name */
    public int f16935j;

    /* compiled from: ExifInterface.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f16949a;

        /* renamed from: b, reason: collision with root package name */
        public final long f16950b;

        public d(long j10, long j11) {
            if (j11 == 0) {
                this.f16949a = 0L;
                this.f16950b = 1L;
            } else {
                this.f16949a = j10;
                this.f16950b = j11;
            }
        }

        public double calculate() {
            return this.f16949a / this.f16950b;
        }

        public String toString() {
            return this.f16949a + "/" + this.f16950b;
        }
    }

    static {
        c[] cVarArr = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ImageWidth", 256), new c("ImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", HttpStatus.SC_MOVED_PERMANENTLY, 3), new c("Software", HttpStatus.SC_USE_PROXY, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        c[] cVarArr2 = {new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962), new c("PixelYDimension", 40963), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        c[] cVarArr3 = {new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        c[] cVarArr4 = {new c("InteroperabilityIndex", 1, 2)};
        c[] cVarArr5 = {new c("NewSubfileType", 254, 4), new c("SubfileType", 255, 4), new c("ThumbnailImageWidth", 256), new c("ThumbnailImageLength", 257), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278), new c("StripByteCounts", 279), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", HttpStatus.SC_MOVED_PERMANENTLY, 3), new c("Software", HttpStatus.SC_USE_PROXY, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720)};
        f16920u = new c("StripOffsets", 273, 3);
        f16921v = new c[][]{cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, new c[]{new c("ThumbnailImage", 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)}, new c[]{new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)}, new c[]{new c("AspectFrame", 4371, 3)}, new c[]{new c("ColorSpace", 55, 3)}};
        f16922w = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        f16923x = new HashMap[10];
        f16924y = new HashMap[10];
        f16925z = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        A = new HashMap<>();
        Charset charsetForName = Charset.forName("US-ASCII");
        B = charsetForName;
        C = "Exif\u0000\u0000".getBytes(charsetForName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            c[][] cVarArr6 = f16921v;
            if (i10 >= cVarArr6.length) {
                HashMap<Integer, Integer> map = A;
                c[] cVarArr7 = f16922w;
                map.put(Integer.valueOf(cVarArr7[0].f16945a), 5);
                map.put(Integer.valueOf(cVarArr7[1].f16945a), 1);
                map.put(Integer.valueOf(cVarArr7[2].f16945a), 2);
                map.put(Integer.valueOf(cVarArr7[3].f16945a), 3);
                map.put(Integer.valueOf(cVarArr7[4].f16945a), 7);
                map.put(Integer.valueOf(cVarArr7[5].f16945a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f16923x[i10] = new HashMap<>();
            f16924y[i10] = new HashMap<>();
            for (c cVar : cVarArr6[i10]) {
                f16923x[i10].put(Integer.valueOf(cVar.f16945a), cVar);
                f16924y[i10].put(cVar.f16946b, cVar);
            }
            i10++;
        }
    }

    public b(String str) throws Throwable {
        FileInputStream fileInputStream;
        c[][] cVarArr = f16921v;
        this.f16928c = new HashMap[cVarArr.length];
        this.f16929d = new HashSet(cVarArr.length);
        this.f16930e = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        this.f16926a = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
        try {
            l(fileInputStream);
            try {
                fileInputStream.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (RuntimeException e11) {
                    throw e11;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] b(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            jArr[i10] = iArr[i10];
        }
        return jArr;
    }

    public static ByteOrder n(a aVar) throws IOException {
        short s10 = aVar.readShort();
        if (s10 == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s10 == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s10));
    }

    public final void a() {
        String attribute = getAttribute("DateTimeOriginal");
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        if (attribute != null && getAttribute("DateTime") == null) {
            mapArr[0].put("DateTime", C0208b.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            mapArr[0].put("ImageWidth", C0208b.createULong(0L, this.f16930e));
        }
        if (getAttribute("ImageLength") == null) {
            mapArr[0].put("ImageLength", C0208b.createULong(0L, this.f16930e));
        }
        if (getAttribute("Orientation") == null) {
            mapArr[0].put("Orientation", C0208b.createULong(0L, this.f16930e));
        }
        if (getAttribute("LightSource") == null) {
            mapArr[1].put("LightSource", C0208b.createULong(0L, this.f16930e));
        }
    }

    public final C0208b c(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i10 = 0; i10 < f16921v.length; i10++) {
            C0208b c0208b = this.f16928c[i10].get(str);
            if (c0208b != null) {
                return c0208b;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0116, code lost:
    
        r10.setByteOrder(r9.f16930e);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x011b, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(o1.b.a r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.b.d(o1.b$a, int, int):void");
    }

    public final int e(BufferedInputStream bufferedInputStream) throws IOException {
        boolean z10;
        boolean z11;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f16914o;
            if (i10 >= bArr2.length) {
                z10 = true;
                break;
            }
            if (bArr[i10] != bArr2[i10]) {
                z10 = false;
                break;
            }
            i10++;
        }
        if (z10) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i11 = 0;
        while (true) {
            if (i11 >= bytes.length) {
                z11 = true;
                break;
            }
            if (bArr[i11] != bytes[i11]) {
                z11 = false;
                break;
            }
            i11++;
        }
        if (z11) {
            return 9;
        }
        a aVar = new a(bArr);
        ByteOrder byteOrderN = n(aVar);
        this.f16930e = byteOrderN;
        aVar.setByteOrder(byteOrderN);
        short s10 = aVar.readShort();
        aVar.close();
        if (s10 == 20306 || s10 == 21330) {
            return 7;
        }
        a aVar2 = new a(bArr);
        ByteOrder byteOrderN2 = n(aVar2);
        this.f16930e = byteOrderN2;
        aVar2.setByteOrder(byteOrderN2);
        short s11 = aVar2.readShort();
        aVar2.close();
        return s11 == 85 ? 10 : 0;
    }

    public final void f(a aVar) throws Throwable {
        int i10;
        int i11;
        h(aVar);
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        C0208b c0208b = mapArr[1].get("MakerNote");
        if (c0208b != null) {
            a aVar2 = new a(c0208b.f16944c);
            aVar2.setByteOrder(this.f16930e);
            byte[] bArr = f16915p;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.seek(0L);
            byte[] bArr3 = f16916q;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.seek(12L);
            }
            o(aVar2, 6);
            C0208b c0208b2 = mapArr[7].get("PreviewImageStart");
            C0208b c0208b3 = mapArr[7].get("PreviewImageLength");
            if (c0208b2 != null && c0208b3 != null) {
                mapArr[5].put("JPEGInterchangeFormat", c0208b2);
                mapArr[5].put("JPEGInterchangeFormatLength", c0208b3);
            }
            C0208b c0208b4 = mapArr[8].get("AspectFrame");
            if (c0208b4 != null) {
                int[] iArr = (int[]) c0208b4.a(this.f16930e);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i12 = iArr[2];
                int i13 = iArr[0];
                if (i12 <= i13 || (i10 = iArr[3]) <= (i11 = iArr[1])) {
                    return;
                }
                int i14 = (i12 - i13) + 1;
                int i15 = (i10 - i11) + 1;
                if (i14 < i15) {
                    int i16 = i14 + i15;
                    i15 = i16 - i15;
                    i14 = i16 - i15;
                }
                C0208b c0208bCreateUShort = C0208b.createUShort(i14, this.f16930e);
                C0208b c0208bCreateUShort2 = C0208b.createUShort(i15, this.f16930e);
                mapArr[0].put("ImageWidth", c0208bCreateUShort);
                mapArr[0].put("ImageLength", c0208bCreateUShort2);
            }
        }
    }

    public final void g(a aVar) throws IOException {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        d(aVar, i10, 5);
        aVar.seek(i11);
        aVar.setByteOrder(ByteOrder.BIG_ENDIAN);
        int i12 = aVar.readInt();
        for (int i13 = 0; i13 < i12; i13++) {
            int unsignedShort = aVar.readUnsignedShort();
            int unsignedShort2 = aVar.readUnsignedShort();
            if (unsignedShort == f16920u.f16945a) {
                short s10 = aVar.readShort();
                short s11 = aVar.readShort();
                C0208b c0208bCreateUShort = C0208b.createUShort(s10, this.f16930e);
                C0208b c0208bCreateUShort2 = C0208b.createUShort(s11, this.f16930e);
                HashMap<String, C0208b>[] mapArr = this.f16928c;
                mapArr[0].put("ImageLength", c0208bCreateUShort);
                mapArr[0].put("ImageWidth", c0208bCreateUShort2);
                return;
            }
            aVar.skipBytes(unsignedShort2);
        }
    }

    public String getAttribute(String str) {
        C0208b c0208bC = c(str);
        if (c0208bC != null) {
            if (!f16925z.contains(str)) {
                return c0208bC.getStringValue(this.f16930e);
            }
            if (str.equals("GPSTimeStamp")) {
                int i10 = c0208bC.f16942a;
                if (i10 != 5 && i10 != 10) {
                    o1.a.o("GPS Timestamp format is not rational. format=", i10, "ExifInterface");
                    return null;
                }
                d[] dVarArr = (d[]) c0208bC.a(this.f16930e);
                if (dVarArr == null || dVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                    return null;
                }
                d dVar = dVarArr[0];
                d dVar2 = dVarArr[1];
                d dVar3 = dVarArr[2];
                return String.format("%02d:%02d:%02d", Integer.valueOf((int) (dVar.f16949a / dVar.f16950b)), Integer.valueOf((int) (dVar2.f16949a / dVar2.f16950b)), Integer.valueOf((int) (dVar3.f16949a / dVar3.f16950b)));
            }
            try {
                return Double.toString(c0208bC.getDoubleValue(this.f16930e));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int getAttributeInt(String str, int i10) {
        C0208b c0208bC = c(str);
        if (c0208bC == null) {
            return i10;
        }
        try {
            return c0208bC.getIntValue(this.f16930e);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    public final void h(a aVar) throws Throwable {
        C0208b c0208b;
        m(aVar, aVar.available());
        o(aVar, 0);
        r(aVar, 0);
        r(aVar, 5);
        r(aVar, 4);
        q(0, 5);
        q(0, 4);
        q(5, 4);
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        C0208b c0208b2 = mapArr[1].get("PixelXDimension");
        C0208b c0208b3 = mapArr[1].get("PixelYDimension");
        if (c0208b2 != null && c0208b3 != null) {
            mapArr[0].put("ImageWidth", c0208b2);
            mapArr[0].put("ImageLength", c0208b3);
        }
        if (mapArr[4].isEmpty() && k(mapArr[5])) {
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap<>();
        }
        if (!k(mapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.f16927b != 8 || (c0208b = mapArr[1].get("MakerNote")) == null) {
            return;
        }
        a aVar2 = new a(c0208b.f16944c);
        aVar2.setByteOrder(this.f16930e);
        aVar2.seek(6L);
        o(aVar2, 9);
        C0208b c0208b4 = mapArr[9].get("ColorSpace");
        if (c0208b4 != null) {
            mapArr[1].put("ColorSpace", c0208b4);
        }
    }

    public final void i(a aVar) throws Throwable {
        h(aVar);
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        if (mapArr[0].get("JpgFromRaw") != null) {
            d(aVar, this.f16935j, 5);
        }
        C0208b c0208b = mapArr[0].get("ISO");
        C0208b c0208b2 = mapArr[1].get("PhotographicSensitivity");
        if (c0208b == null || c0208b2 != null) {
            return;
        }
        mapArr[1].put("PhotographicSensitivity", c0208b);
    }

    public final void j(a aVar, HashMap map) throws Throwable {
        int i10;
        C0208b c0208b = (C0208b) map.get("JPEGInterchangeFormat");
        C0208b c0208b2 = (C0208b) map.get("JPEGInterchangeFormatLength");
        if (c0208b == null || c0208b2 == null) {
            return;
        }
        int intValue = c0208b.getIntValue(this.f16930e);
        int iMin = Math.min(c0208b2.getIntValue(this.f16930e), aVar.available() - intValue);
        int i11 = this.f16927b;
        if (i11 != 4 && i11 != 9 && i11 != 10) {
            if (i11 == 7) {
                i10 = this.f16932g;
            }
            if (intValue > 0 || iMin <= 0 || this.f16926a != null) {
                return;
            }
            aVar.seek(intValue);
            aVar.readFully(new byte[iMin]);
            return;
        }
        i10 = this.f16931f;
        intValue += i10;
        if (intValue > 0) {
        }
    }

    public final boolean k(HashMap map) throws IOException {
        C0208b c0208b = (C0208b) map.get("ImageLength");
        C0208b c0208b2 = (C0208b) map.get("ImageWidth");
        if (c0208b == null || c0208b2 == null) {
            return false;
        }
        return c0208b.getIntValue(this.f16930e) <= 512 && c0208b2.getIntValue(this.f16930e) <= 512;
    }

    public final void l(FileInputStream fileInputStream) throws IOException {
        for (int i10 = 0; i10 < f16921v.length; i10++) {
            try {
                this.f16928c[i10] = new HashMap<>();
            } catch (IOException unused) {
            } catch (Throwable th2) {
                a();
                throw th2;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 5000);
        this.f16927b = e(bufferedInputStream);
        a aVar = new a(bufferedInputStream);
        switch (this.f16927b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                h(aVar);
                break;
            case 4:
                d(aVar, 0, 0);
                break;
            case 7:
                f(aVar);
                break;
            case 9:
                g(aVar);
                break;
            case 10:
                i(aVar);
                break;
        }
        p(aVar);
        a();
    }

    public final void m(a aVar, int i10) throws IOException {
        ByteOrder byteOrderN = n(aVar);
        this.f16930e = byteOrderN;
        aVar.setByteOrder(byteOrderN);
        int unsignedShort = aVar.readUnsignedShort();
        int i11 = this.f16927b;
        if (i11 != 7 && i11 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i12 = aVar.readInt();
        if (i12 < 8 || i12 >= i10) {
            throw new IOException(ac.c.f("Invalid first Ifd offset: ", i12));
        }
        int i13 = i12 - 8;
        if (i13 > 0 && aVar.skipBytes(i13) != i13) {
            throw new IOException(ac.c.f("Couldn't jump to first Ifd: ", i13));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0103  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void o(o1.b.a r27, int r28) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 763
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.b.o(o1.b$a, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(o1.b.a r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.b.p(o1.b$a):void");
    }

    public final void q(int i10, int i11) throws Throwable {
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        if (mapArr[i10].isEmpty() || mapArr[i11].isEmpty()) {
            return;
        }
        C0208b c0208b = mapArr[i10].get("ImageLength");
        C0208b c0208b2 = mapArr[i10].get("ImageWidth");
        C0208b c0208b3 = mapArr[i11].get("ImageLength");
        C0208b c0208b4 = mapArr[i11].get("ImageWidth");
        if (c0208b == null || c0208b2 == null || c0208b3 == null || c0208b4 == null) {
            return;
        }
        int intValue = c0208b.getIntValue(this.f16930e);
        int intValue2 = c0208b2.getIntValue(this.f16930e);
        int intValue3 = c0208b3.getIntValue(this.f16930e);
        int intValue4 = c0208b4.getIntValue(this.f16930e);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, C0208b> map = mapArr[i10];
        mapArr[i10] = mapArr[i11];
        mapArr[i11] = map;
    }

    public final void r(a aVar, int i10) throws Throwable {
        C0208b c0208b;
        C0208b c0208bCreateUShort;
        C0208b c0208bCreateUShort2;
        HashMap<String, C0208b>[] mapArr = this.f16928c;
        C0208b c0208b2 = mapArr[i10].get("DefaultCropSize");
        C0208b c0208b3 = mapArr[i10].get("SensorTopBorder");
        C0208b c0208b4 = mapArr[i10].get("SensorLeftBorder");
        C0208b c0208b5 = mapArr[i10].get("SensorBottomBorder");
        C0208b c0208b6 = mapArr[i10].get("SensorRightBorder");
        if (c0208b2 != null) {
            if (c0208b2.f16942a == 5) {
                d[] dVarArr = (d[]) c0208b2.a(this.f16930e);
                if (dVarArr == null || dVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                    return;
                }
                c0208bCreateUShort = C0208b.createURational(dVarArr[0], this.f16930e);
                c0208bCreateUShort2 = C0208b.createURational(dVarArr[1], this.f16930e);
            } else {
                int[] iArr = (int[]) c0208b2.a(this.f16930e);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                c0208bCreateUShort = C0208b.createUShort(iArr[0], this.f16930e);
                c0208bCreateUShort2 = C0208b.createUShort(iArr[1], this.f16930e);
            }
            mapArr[i10].put("ImageWidth", c0208bCreateUShort);
            mapArr[i10].put("ImageLength", c0208bCreateUShort2);
            return;
        }
        if (c0208b3 == null || c0208b4 == null || c0208b5 == null || c0208b6 == null) {
            C0208b c0208b7 = mapArr[i10].get("ImageLength");
            C0208b c0208b8 = mapArr[i10].get("ImageWidth");
            if ((c0208b7 == null || c0208b8 == null) && (c0208b = mapArr[i10].get("JPEGInterchangeFormat")) != null) {
                d(aVar, c0208b.getIntValue(this.f16930e), i10);
                return;
            }
            return;
        }
        int intValue = c0208b3.getIntValue(this.f16930e);
        int intValue2 = c0208b5.getIntValue(this.f16930e);
        int intValue3 = c0208b6.getIntValue(this.f16930e);
        int intValue4 = c0208b4.getIntValue(this.f16930e);
        if (intValue2 <= intValue || intValue3 <= intValue4) {
            return;
        }
        C0208b c0208bCreateUShort3 = C0208b.createUShort(intValue2 - intValue, this.f16930e);
        C0208b c0208bCreateUShort4 = C0208b.createUShort(intValue3 - intValue4, this.f16930e);
        mapArr[i10].put("ImageLength", c0208bCreateUShort3);
        mapArr[i10].put("ImageWidth", c0208bCreateUShort4);
    }

    /* compiled from: ExifInterface.java */
    public static class a extends InputStream implements DataInput {

        /* renamed from: p, reason: collision with root package name */
        public static final ByteOrder f16936p = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: q, reason: collision with root package name */
        public static final ByteOrder f16937q = ByteOrder.BIG_ENDIAN;

        /* renamed from: b, reason: collision with root package name */
        public final DataInputStream f16938b;

        /* renamed from: m, reason: collision with root package name */
        public ByteOrder f16939m;

        /* renamed from: n, reason: collision with root package name */
        public final int f16940n;

        /* renamed from: o, reason: collision with root package name */
        public int f16941o;

        public a(InputStream inputStream) throws IOException {
            this.f16939m = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f16938b = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.f16940n = iAvailable;
            this.f16941o = 0;
            dataInputStream.mark(iAvailable);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f16938b.available();
        }

        public int peek() {
            return this.f16941o;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f16941o++;
            return this.f16938b.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f16941o++;
            return this.f16938b.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i10 = this.f16941o + 1;
            this.f16941o = i10;
            if (i10 > this.f16940n) {
                throw new EOFException();
            }
            int i11 = this.f16938b.read();
            if (i11 >= 0) {
                return (byte) i11;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f16941o += 2;
            return this.f16938b.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f16941o + i11;
            this.f16941o = i12;
            if (i12 > this.f16940n) {
                throw new EOFException();
            }
            if (this.f16938b.read(bArr, i10, i11) != i11) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i10 = this.f16941o + 4;
            this.f16941o = i10;
            if (i10 > this.f16940n) {
                throw new EOFException();
            }
            DataInputStream dataInputStream = this.f16938b;
            int i11 = dataInputStream.read();
            int i12 = dataInputStream.read();
            int i13 = dataInputStream.read();
            int i14 = dataInputStream.read();
            if ((i11 | i12 | i13 | i14) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f16939m;
            if (byteOrder == f16936p) {
                return (i14 << 24) + (i13 << 16) + (i12 << 8) + i11;
            }
            if (byteOrder == f16937q) {
                return (i11 << 24) + (i12 << 16) + (i13 << 8) + i14;
            }
            throw new IOException("Invalid byte order: " + this.f16939m);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i10 = this.f16941o + 8;
            this.f16941o = i10;
            if (i10 > this.f16940n) {
                throw new EOFException();
            }
            DataInputStream dataInputStream = this.f16938b;
            int i11 = dataInputStream.read();
            int i12 = dataInputStream.read();
            int i13 = dataInputStream.read();
            int i14 = dataInputStream.read();
            int i15 = dataInputStream.read();
            int i16 = dataInputStream.read();
            int i17 = dataInputStream.read();
            int i18 = dataInputStream.read();
            if ((i11 | i12 | i13 | i14 | i15 | i16 | i17 | i18) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f16939m;
            if (byteOrder == f16936p) {
                return (i18 << 56) + (i17 << 48) + (i16 << 40) + (i15 << 32) + (i14 << 24) + (i13 << 16) + (i12 << 8) + i11;
            }
            if (byteOrder == f16937q) {
                return (i11 << 56) + (i12 << 48) + (i13 << 40) + (i14 << 32) + (i15 << 24) + (i16 << 16) + (i17 << 8) + i18;
            }
            throw new IOException("Invalid byte order: " + this.f16939m);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i10 = this.f16941o + 2;
            this.f16941o = i10;
            if (i10 > this.f16940n) {
                throw new EOFException();
            }
            DataInputStream dataInputStream = this.f16938b;
            int i11 = dataInputStream.read();
            int i12 = dataInputStream.read();
            if ((i11 | i12) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f16939m;
            if (byteOrder == f16936p) {
                return (short) ((i12 << 8) + i11);
            }
            if (byteOrder == f16937q) {
                return (short) ((i11 << 8) + i12);
            }
            throw new IOException("Invalid byte order: " + this.f16939m);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f16941o += 2;
            return this.f16938b.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f16941o++;
            return this.f16938b.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i10 = this.f16941o + 2;
            this.f16941o = i10;
            if (i10 > this.f16940n) {
                throw new EOFException();
            }
            DataInputStream dataInputStream = this.f16938b;
            int i11 = dataInputStream.read();
            int i12 = dataInputStream.read();
            if ((i11 | i12) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f16939m;
            if (byteOrder == f16936p) {
                return (i12 << 8) + i11;
            }
            if (byteOrder == f16937q) {
                return (i11 << 8) + i12;
            }
            throw new IOException("Invalid byte order: " + this.f16939m);
        }

        public void seek(long j10) throws IOException {
            int i10 = this.f16941o;
            if (i10 > j10) {
                this.f16941o = 0;
                DataInputStream dataInputStream = this.f16938b;
                dataInputStream.reset();
                dataInputStream.mark(this.f16940n);
            } else {
                j10 -= i10;
            }
            int i11 = (int) j10;
            if (skipBytes(i11) != i11) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.f16939m = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) throws IOException {
            int iMin = Math.min(i10, this.f16940n - this.f16941o);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.f16938b.skipBytes(iMin - iSkipBytes);
            }
            this.f16941o += iSkipBytes;
            return iSkipBytes;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int i12 = this.f16938b.read(bArr, i10, i11);
            this.f16941o += i12;
            return i12;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.f16941o + bArr.length;
            this.f16941o = length;
            if (length <= this.f16940n) {
                if (this.f16938b.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public a(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: o1.b$b, reason: collision with other inner class name */
    public static class C0208b {

        /* renamed from: a, reason: collision with root package name */
        public final int f16942a;

        /* renamed from: b, reason: collision with root package name */
        public final int f16943b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f16944c;

        public C0208b(int i10, byte[] bArr, int i11) {
            this.f16942a = i10;
            this.f16943b = i11;
            this.f16944c = bArr;
        }

        public static C0208b createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(b.B);
            return new C0208b(2, bytes, bytes.length);
        }

        public static C0208b createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[b.f16918s[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j10 : jArr) {
                byteBufferWrap.putInt((int) j10);
            }
            return new C0208b(4, byteBufferWrap.array(), jArr.length);
        }

        public static C0208b createURational(d[] dVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[b.f16918s[5] * dVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (d dVar : dVarArr) {
                byteBufferWrap.putInt((int) dVar.f16949a);
                byteBufferWrap.putInt((int) dVar.f16950b);
            }
            return new C0208b(5, byteBufferWrap.array(), dVarArr.length);
        }

        public static C0208b createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[b.f16918s[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i10 : iArr) {
                byteBufferWrap.putShort((short) i10);
            }
            return new C0208b(3, byteBufferWrap.array(), iArr.length);
        }

        /* JADX WARN: Can't wrap try/catch for region: R(9:80|(3:82|(2:83|(1:181)(2:85|(2:182|87)(1:88)))|(1:90))|91|(2:93|(6:184|95|101|175|102|106)(3:96|(2:98|186)(2:99|185)|100))|183|101|175|102|106) */
        /* JADX WARN: Code restructure failed: missing block: B:104:0x011d, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:105:0x011e, code lost:
        
            android.util.Log.e("ExifInterface", "IOException occurred while closing InputStream", r0);
         */
        /* JADX WARN: Not initialized variable reg: 4, insn: 0x015a: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:347), block:B:130:0x015a */
        /* JADX WARN: Removed duplicated region for block: B:154:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r13v23, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v24, types: [java.io.Serializable, long[]] */
        /* JADX WARN: Type inference failed for: r13v25, types: [java.io.Serializable, o1.b$d[]] */
        /* JADX WARN: Type inference failed for: r13v26, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v27, types: [int[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v28, types: [java.io.Serializable, o1.b$d[]] */
        /* JADX WARN: Type inference failed for: r13v29, types: [double[], java.io.Serializable] */
        /* JADX WARN: Type inference failed for: r13v30, types: [double[], java.io.Serializable] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.io.Serializable a(java.nio.ByteOrder r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 410
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: o1.b.C0208b.a(java.nio.ByteOrder):java.io.Serializable");
        }

        public double getDoubleValue(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objA instanceof String) {
                return Double.parseDouble((String) objA);
            }
            if (objA instanceof long[]) {
                if (((long[]) objA).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof int[]) {
                if (((int[]) objA).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objA instanceof double[]) {
                double[] dArr = (double[]) objA;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objA instanceof d[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            d[] dVarArr = (d[]) objA;
            if (dVarArr.length == 1) {
                return dVarArr[0].calculate();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int getIntValue(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objA instanceof String) {
                return Integer.parseInt((String) objA);
            }
            if (objA instanceof long[]) {
                long[] jArr = (long[]) objA;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objA instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objA;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String getStringValue(ByteOrder byteOrder) throws Throwable {
            Object objA = a(byteOrder);
            if (objA == null) {
                return null;
            }
            if (objA instanceof String) {
                return (String) objA;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (objA instanceof long[]) {
                long[] jArr = (long[]) objA;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objA instanceof int[]) {
                int[] iArr = (int[]) objA;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (objA instanceof double[]) {
                double[] dArr = (double[]) objA;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
            if (!(objA instanceof d[])) {
                return null;
            }
            d[] dVarArr = (d[]) objA;
            while (i10 < dVarArr.length) {
                sb2.append(dVarArr[i10].f16949a);
                sb2.append(JsonPointer.SEPARATOR);
                sb2.append(dVarArr[i10].f16950b);
                i10++;
                if (i10 != dVarArr.length) {
                    sb2.append(",");
                }
            }
            return sb2.toString();
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("(");
            sb2.append(b.f16917r[this.f16942a]);
            sb2.append(", data length:");
            return ac.c.m(sb2, this.f16944c.length, ")");
        }

        public static C0208b createULong(long j10, ByteOrder byteOrder) {
            return createULong(new long[]{j10}, byteOrder);
        }

        public static C0208b createUShort(int i10, ByteOrder byteOrder) {
            return createUShort(new int[]{i10}, byteOrder);
        }

        public static C0208b createURational(d dVar, ByteOrder byteOrder) {
            return createURational(new d[]{dVar}, byteOrder);
        }
    }

    /* compiled from: ExifInterface.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f16945a;

        /* renamed from: b, reason: collision with root package name */
        public final String f16946b;

        /* renamed from: c, reason: collision with root package name */
        public final int f16947c;

        /* renamed from: d, reason: collision with root package name */
        public final int f16948d;

        public c(String str, int i10, int i11) {
            this.f16946b = str;
            this.f16945a = i10;
            this.f16947c = i11;
            this.f16948d = -1;
        }

        public c(String str, int i10) {
            this.f16946b = str;
            this.f16945a = i10;
            this.f16947c = 3;
            this.f16948d = 4;
        }
    }
}
