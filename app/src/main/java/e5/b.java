package e5;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import l6.u;

/* compiled from: CryptoInfo.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f11133a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f11134b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f11135c;

    /* renamed from: d, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f11136d;

    /* renamed from: e, reason: collision with root package name */
    public final a f11137e;

    /* compiled from: CryptoInfo.java */
    @TargetApi(24)
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f11138a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaCodec.CryptoInfo.Pattern f11139b = new MediaCodec.CryptoInfo.Pattern(0, 0);

        public a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f11138a = cryptoInfo;
        }
    }

    public b() {
        int i10 = u.f15907a;
        MediaCodec.CryptoInfo cryptoInfo = i10 >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.f11136d = cryptoInfo;
        this.f11137e = i10 >= 24 ? new a(cryptoInfo) : null;
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.f11136d;
    }

    public void set(int i10, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i11, int i12, int i13) {
        this.f11134b = iArr;
        this.f11135c = iArr2;
        this.f11133a = bArr2;
        int i14 = u.f15907a;
        if (i14 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.f11136d;
            cryptoInfo.numSubSamples = i10;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr;
            cryptoInfo.iv = bArr2;
            cryptoInfo.mode = i11;
            if (i14 >= 24) {
                a aVar = this.f11137e;
                MediaCodec.CryptoInfo.Pattern pattern = aVar.f11139b;
                pattern.set(i12, i13);
                aVar.f11138a.setPattern(pattern);
            }
        }
    }
}
