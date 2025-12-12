package d5;

import c5.i;
import java.nio.ByteBuffer;
import l6.k;

/* compiled from: DtsUtil.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f10870a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f10871b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f10872c = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int getDtsFrameSize(byte[] bArr) {
        return (((bArr[7] & 240) >> 4) | ((bArr[5] & 2) << 12) | ((bArr[6] & 255) << 4)) + 1;
    }

    public static int parseDtsAudioSampleCount(byte[] bArr) {
        return ((((bArr[5] & 252) >> 2) | ((bArr[4] & 1) << 6)) + 1) * 32;
    }

    public static i parseDtsFormat(byte[] bArr, String str, String str2, com.google.android.exoplayer2.drm.c cVar) {
        k kVar = new k(bArr);
        kVar.skipBits(60);
        int i10 = f10870a[kVar.readBits(6)];
        int i11 = f10871b[kVar.readBits(4)];
        int bits = kVar.readBits(5);
        int i12 = bits >= 29 ? -1 : (f10872c[bits] * 1000) / 2;
        kVar.skipBits(10);
        return i.createAudioSampleFormat(str, "audio/vnd.dts", null, i12, -1, i10 + (kVar.readBits(2) > 0 ? 1 : 0), i11, null, cVar, 0, str2);
    }

    public static int parseDtsAudioSampleCount(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        return ((((byteBuffer.get(iPosition + 5) & 252) >> 2) | ((byteBuffer.get(iPosition + 4) & 1) << 6)) + 1) * 32;
    }
}
