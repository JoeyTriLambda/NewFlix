package c5;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l6.u;

/* compiled from: Format.java */
/* loaded from: classes.dex */
public final class i implements Parcelable {
    public static final Parcelable.Creator<i> CREATOR = new a();
    public final byte[] A;
    public final m6.b B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final long H;
    public final int I;
    public final String J;
    public final int K;
    public int L;

    /* renamed from: b, reason: collision with root package name */
    public final String f5115b;

    /* renamed from: m, reason: collision with root package name */
    public final int f5116m;

    /* renamed from: n, reason: collision with root package name */
    public final String f5117n;

    /* renamed from: o, reason: collision with root package name */
    public final q5.a f5118o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5119p;

    /* renamed from: q, reason: collision with root package name */
    public final String f5120q;

    /* renamed from: r, reason: collision with root package name */
    public final int f5121r;

    /* renamed from: s, reason: collision with root package name */
    public final List<byte[]> f5122s;

    /* renamed from: t, reason: collision with root package name */
    public final com.google.android.exoplayer2.drm.c f5123t;

    /* renamed from: u, reason: collision with root package name */
    public final int f5124u;

    /* renamed from: v, reason: collision with root package name */
    public final int f5125v;

    /* renamed from: w, reason: collision with root package name */
    public final float f5126w;

    /* renamed from: x, reason: collision with root package name */
    public final int f5127x;

    /* renamed from: y, reason: collision with root package name */
    public final float f5128y;

    /* renamed from: z, reason: collision with root package name */
    public final int f5129z;

    /* compiled from: Format.java */
    public static class a implements Parcelable.Creator<i> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public i[] newArray(int i10) {
            return new i[i10];
        }
    }

    public i(String str, String str2, String str3, String str4, int i10, int i11, int i12, int i13, float f10, int i14, float f11, byte[] bArr, int i15, m6.b bVar, int i16, int i17, int i18, int i19, int i20, int i21, String str5, int i22, long j10, List<byte[]> list, com.google.android.exoplayer2.drm.c cVar, q5.a aVar) {
        this.f5115b = str;
        this.f5119p = str2;
        this.f5120q = str3;
        this.f5117n = str4;
        this.f5116m = i10;
        this.f5121r = i11;
        this.f5124u = i12;
        this.f5125v = i13;
        this.f5126w = f10;
        this.f5127x = i14;
        this.f5128y = f11;
        this.A = bArr;
        this.f5129z = i15;
        this.B = bVar;
        this.C = i16;
        this.D = i17;
        this.E = i18;
        this.F = i19;
        this.G = i20;
        this.I = i21;
        this.J = str5;
        this.K = i22;
        this.H = j10;
        this.f5122s = list == null ? Collections.emptyList() : list;
        this.f5123t = cVar;
        this.f5118o = aVar;
    }

    @TargetApi(16)
    public static void a(MediaFormat mediaFormat, String str, int i10) {
        if (i10 != -1) {
            mediaFormat.setInteger(str, i10);
        }
    }

    public static i createAudioContainerFormat(String str, String str2, String str3, String str4, int i10, int i11, int i12, List<byte[]> list, int i13, String str5) {
        return new i(str, str2, str3, str4, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i11, i12, -1, -1, -1, i13, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    public static i createAudioSampleFormat(String str, String str2, String str3, int i10, int i11, int i12, int i13, List<byte[]> list, com.google.android.exoplayer2.drm.c cVar, int i14, String str4) {
        return createAudioSampleFormat(str, str2, str3, i10, i11, i12, i13, -1, list, cVar, i14, str4);
    }

    public static i createContainerFormat(String str, String str2, String str3, String str4, int i10, int i11, String str5) {
        return new i(str, str2, str3, str4, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i11, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static i createImageSampleFormat(String str, String str2, String str3, int i10, List<byte[]> list, String str4, com.google.android.exoplayer2.drm.c cVar) {
        return new i(str, null, str2, str3, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, cVar, null);
    }

    public static i createSampleFormat(String str, String str2, long j10) {
        return new i(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j10, null, null, null);
    }

    public static i createTextContainerFormat(String str, String str2, String str3, String str4, int i10, int i11, String str5) {
        return createTextContainerFormat(str, str2, str3, str4, i10, i11, str5, -1);
    }

    public static i createTextSampleFormat(String str, String str2, int i10, String str3) {
        return createTextSampleFormat(str, str2, i10, str3, null);
    }

    public static i createVideoContainerFormat(String str, String str2, String str3, String str4, int i10, int i11, int i12, float f10, List<byte[]> list, int i13) {
        return new i(str, str2, str3, str4, i10, -1, i11, i12, f10, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i13, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static i createVideoSampleFormat(String str, String str2, String str3, int i10, int i11, int i12, int i13, float f10, List<byte[]> list, int i14, float f11, com.google.android.exoplayer2.drm.c cVar) {
        return createVideoSampleFormat(str, str2, str3, i10, i11, i12, i13, f10, list, i14, f11, null, -1, null, cVar);
    }

    public i copyWithContainerInfo(String str, String str2, int i10, int i11, int i12, int i13, String str3) {
        return new i(str, this.f5119p, this.f5120q, str2, i10, this.f5121r, i11, i12, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, i13, str3, this.K, this.H, this.f5122s, this.f5123t, this.f5118o);
    }

    public i copyWithDrmInitData(com.google.android.exoplayer2.drm.c cVar) {
        return new i(this.f5115b, this.f5119p, this.f5120q, this.f5117n, this.f5116m, this.f5121r, this.f5124u, this.f5125v, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, this.I, this.J, this.K, this.H, this.f5122s, cVar, this.f5118o);
    }

    public i copyWithGaplessInfo(int i10, int i11) {
        return new i(this.f5115b, this.f5119p, this.f5120q, this.f5117n, this.f5116m, this.f5121r, this.f5124u, this.f5125v, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, i10, i11, this.I, this.J, this.K, this.H, this.f5122s, this.f5123t, this.f5118o);
    }

    public i copyWithManifestFormatInfo(i iVar) {
        if (this == iVar) {
            return this;
        }
        String str = iVar.f5115b;
        String str2 = this.f5117n;
        if (str2 == null) {
            str2 = iVar.f5117n;
        }
        String str3 = str2;
        int i10 = this.f5116m;
        int i11 = i10 == -1 ? iVar.f5116m : i10;
        float f10 = this.f5126w;
        float f11 = f10 == -1.0f ? iVar.f5126w : f10;
        int i12 = this.I | iVar.I;
        String str4 = this.J;
        if (str4 == null) {
            str4 = iVar.J;
        }
        String str5 = str4;
        com.google.android.exoplayer2.drm.c cVar = iVar.f5123t;
        if (cVar == null) {
            cVar = this.f5123t;
        }
        return new i(str, this.f5119p, this.f5120q, str3, i11, this.f5121r, this.f5124u, this.f5125v, f11, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, i12, str5, this.K, this.H, this.f5122s, cVar, this.f5118o);
    }

    public i copyWithMaxInputSize(int i10) {
        return new i(this.f5115b, this.f5119p, this.f5120q, this.f5117n, this.f5116m, i10, this.f5124u, this.f5125v, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, this.I, this.J, this.K, this.H, this.f5122s, this.f5123t, this.f5118o);
    }

    public i copyWithMetadata(q5.a aVar) {
        return new i(this.f5115b, this.f5119p, this.f5120q, this.f5117n, this.f5116m, this.f5121r, this.f5124u, this.f5125v, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, this.I, this.J, this.K, this.H, this.f5122s, this.f5123t, aVar);
    }

    public i copyWithSubsampleOffsetUs(long j10) {
        return new i(this.f5115b, this.f5119p, this.f5120q, this.f5117n, this.f5116m, this.f5121r, this.f5124u, this.f5125v, this.f5126w, this.f5127x, this.f5128y, this.A, this.f5129z, this.B, this.C, this.D, this.E, this.F, this.G, this.I, this.J, this.K, j10, this.f5122s, this.f5123t, this.f5118o);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f5116m == iVar.f5116m && this.f5121r == iVar.f5121r && this.f5124u == iVar.f5124u && this.f5125v == iVar.f5125v && this.f5126w == iVar.f5126w && this.f5127x == iVar.f5127x && this.f5128y == iVar.f5128y && this.f5129z == iVar.f5129z && this.C == iVar.C && this.D == iVar.D && this.E == iVar.E && this.F == iVar.F && this.G == iVar.G && this.H == iVar.H && this.I == iVar.I && u.areEqual(this.f5115b, iVar.f5115b) && u.areEqual(this.J, iVar.J) && this.K == iVar.K && u.areEqual(this.f5119p, iVar.f5119p) && u.areEqual(this.f5120q, iVar.f5120q) && u.areEqual(this.f5117n, iVar.f5117n) && u.areEqual(this.f5123t, iVar.f5123t) && u.areEqual(this.f5118o, iVar.f5118o) && u.areEqual(this.B, iVar.B) && Arrays.equals(this.A, iVar.A)) {
                List<byte[]> list = this.f5122s;
                int size = list.size();
                List<byte[]> list2 = iVar.f5122s;
                if (size == list2.size()) {
                    for (int i10 = 0; i10 < list.size(); i10++) {
                        if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat getFrameworkMediaFormatV16() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f5120q);
        String str = this.J;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        a(mediaFormat, "max-input-size", this.f5121r);
        a(mediaFormat, "width", this.f5124u);
        a(mediaFormat, "height", this.f5125v);
        float f10 = this.f5126w;
        if (f10 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f10);
        }
        a(mediaFormat, "rotation-degrees", this.f5127x);
        a(mediaFormat, "channel-count", this.C);
        a(mediaFormat, "sample-rate", this.D);
        a(mediaFormat, "encoder-delay", this.F);
        a(mediaFormat, "encoder-padding", this.G);
        int i10 = 0;
        while (true) {
            List<byte[]> list = this.f5122s;
            if (i10 >= list.size()) {
                break;
            }
            mediaFormat.setByteBuffer(ac.c.f("csd-", i10), ByteBuffer.wrap(list.get(i10)));
            i10++;
        }
        m6.b bVar = this.B;
        if (bVar != null) {
            a(mediaFormat, "color-transfer", bVar.f16117n);
            a(mediaFormat, "color-standard", bVar.f16115b);
            a(mediaFormat, "color-range", bVar.f16116m);
            byte[] bArr = bVar.f16118o;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public int getPixelCount() {
        int i10;
        int i11 = this.f5124u;
        if (i11 == -1 || (i10 = this.f5125v) == -1) {
            return -1;
        }
        return i11 * i10;
    }

    public int hashCode() {
        if (this.L == 0) {
            String str = this.f5115b;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f5119p;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f5120q;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f5117n;
            int iHashCode4 = (((((((((((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.f5116m) * 31) + this.f5124u) * 31) + this.f5125v) * 31) + this.C) * 31) + this.D) * 31;
            String str5 = this.J;
            int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.K) * 31;
            com.google.android.exoplayer2.drm.c cVar = this.f5123t;
            int iHashCode6 = (iHashCode5 + (cVar == null ? 0 : cVar.hashCode())) * 31;
            q5.a aVar = this.f5118o;
            this.L = iHashCode6 + (aVar != null ? aVar.hashCode() : 0);
        }
        return this.L;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Format(");
        sb2.append(this.f5115b);
        sb2.append(", ");
        sb2.append(this.f5119p);
        sb2.append(", ");
        sb2.append(this.f5120q);
        sb2.append(", ");
        sb2.append(this.f5116m);
        sb2.append(", ");
        sb2.append(this.J);
        sb2.append(", [");
        sb2.append(this.f5124u);
        sb2.append(", ");
        sb2.append(this.f5125v);
        sb2.append(", ");
        sb2.append(this.f5126w);
        sb2.append("], [");
        sb2.append(this.C);
        sb2.append(", ");
        return ac.c.m(sb2, this.D, "])");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f5115b);
        parcel.writeString(this.f5119p);
        parcel.writeString(this.f5120q);
        parcel.writeString(this.f5117n);
        parcel.writeInt(this.f5116m);
        parcel.writeInt(this.f5121r);
        parcel.writeInt(this.f5124u);
        parcel.writeInt(this.f5125v);
        parcel.writeFloat(this.f5126w);
        parcel.writeInt(this.f5127x);
        parcel.writeFloat(this.f5128y);
        byte[] bArr = this.A;
        parcel.writeInt(bArr != null ? 1 : 0);
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.f5129z);
        parcel.writeParcelable(this.B, i10);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.I);
        parcel.writeString(this.J);
        parcel.writeInt(this.K);
        parcel.writeLong(this.H);
        List<byte[]> list = this.f5122s;
        int size = list.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            parcel.writeByteArray(list.get(i11));
        }
        parcel.writeParcelable(this.f5123t, 0);
        parcel.writeParcelable(this.f5118o, 0);
    }

    public static i createAudioSampleFormat(String str, String str2, String str3, int i10, int i11, int i12, int i13, int i14, List<byte[]> list, com.google.android.exoplayer2.drm.c cVar, int i15, String str4) {
        return createAudioSampleFormat(str, str2, str3, i10, i11, i12, i13, i14, -1, -1, list, cVar, i15, str4, null);
    }

    public static i createSampleFormat(String str, String str2, String str3, int i10, com.google.android.exoplayer2.drm.c cVar) {
        return new i(str, null, str2, str3, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, cVar, null);
    }

    public static i createTextContainerFormat(String str, String str2, String str3, String str4, int i10, int i11, String str5, int i12) {
        return new i(str, str2, str3, str4, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i11, str5, i12, Long.MAX_VALUE, null, null, null);
    }

    public static i createTextSampleFormat(String str, String str2, int i10, String str3, com.google.android.exoplayer2.drm.c cVar) {
        return createTextSampleFormat(str, str2, null, -1, i10, str3, -1, cVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static i createVideoSampleFormat(String str, String str2, String str3, int i10, int i11, int i12, int i13, float f10, List<byte[]> list, int i14, float f11, byte[] bArr, int i15, m6.b bVar, com.google.android.exoplayer2.drm.c cVar) {
        return new i(str, null, str2, str3, i10, i11, i12, i13, f10, i14, f11, bArr, i15, bVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, cVar, null);
    }

    public static i createAudioSampleFormat(String str, String str2, String str3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, List<byte[]> list, com.google.android.exoplayer2.drm.c cVar, int i17, String str4, q5.a aVar) {
        return new i(str, null, str2, str3, i10, i11, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i12, i13, i14, i15, i16, i17, str4, -1, Long.MAX_VALUE, list, cVar, aVar);
    }

    public static i createTextSampleFormat(String str, String str2, String str3, int i10, int i11, String str4, int i12, com.google.android.exoplayer2.drm.c cVar) {
        return createTextSampleFormat(str, str2, str3, i10, i11, str4, i12, cVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static i createTextSampleFormat(String str, String str2, String str3, int i10, int i11, String str4, com.google.android.exoplayer2.drm.c cVar, long j10) {
        return createTextSampleFormat(str, str2, str3, i10, i11, str4, -1, cVar, j10, Collections.emptyList());
    }

    public static i createTextSampleFormat(String str, String str2, String str3, int i10, int i11, String str4, int i12, com.google.android.exoplayer2.drm.c cVar, long j10, List<byte[]> list) {
        return new i(str, null, str2, str3, i10, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i11, str4, i12, j10, list, cVar, null);
    }

    public i(Parcel parcel) {
        this.f5115b = parcel.readString();
        this.f5119p = parcel.readString();
        this.f5120q = parcel.readString();
        this.f5117n = parcel.readString();
        this.f5116m = parcel.readInt();
        this.f5121r = parcel.readInt();
        this.f5124u = parcel.readInt();
        this.f5125v = parcel.readInt();
        this.f5126w = parcel.readFloat();
        this.f5127x = parcel.readInt();
        this.f5128y = parcel.readFloat();
        this.A = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.f5129z = parcel.readInt();
        this.B = (m6.b) parcel.readParcelable(m6.b.class.getClassLoader());
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readString();
        this.K = parcel.readInt();
        this.H = parcel.readLong();
        int i10 = parcel.readInt();
        this.f5122s = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            this.f5122s.add(parcel.createByteArray());
        }
        this.f5123t = (com.google.android.exoplayer2.drm.c) parcel.readParcelable(com.google.android.exoplayer2.drm.c.class.getClassLoader());
        this.f5118o = (q5.a) parcel.readParcelable(q5.a.class.getClassLoader());
    }
}
