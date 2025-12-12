package hd;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

/* compiled from: VideoSource.java */
/* loaded from: classes2.dex */
public final class o implements Parcelable, Comparable {
    public static final Parcelable.Creator<o> CREATOR = new a();
    public boolean A;
    public boolean B;
    public String C;
    public String D;
    public boolean E;
    public boolean F;

    /* renamed from: b, reason: collision with root package name */
    public String f13036b;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13037m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13038n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13039o;

    /* renamed from: p, reason: collision with root package name */
    public String f13040p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f13041q;

    /* renamed from: r, reason: collision with root package name */
    public String f13042r;

    /* renamed from: s, reason: collision with root package name */
    public int f13043s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f13044t;

    /* renamed from: u, reason: collision with root package name */
    public String f13045u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f13046v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13047w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f13048x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f13049y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f13050z;

    /* compiled from: VideoSource.java */
    public class a implements Parcelable.Creator<o> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public o[] newArray(int i10) {
            return new o[i10];
        }
    }

    public o(Parcel parcel) {
        new HashMap();
        this.f13043s = 0;
        this.f13046v = false;
        this.f13050z = false;
        this.A = false;
        this.B = false;
        this.E = false;
        this.F = false;
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.f13047w = parcel.readByte() != 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        boolean z10 = this.f13037m;
        if (!z10) {
            o oVar = (o) obj;
            if (!oVar.f13037m) {
                return Integer.compare(oVar.f13043s, this.f13043s);
            }
        }
        return Boolean.compare(((o) obj).f13037m, z10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        return (obj == null || (str = this.D) == null || !str.equals(((o) obj).D)) ? false : true;
    }

    public boolean hasMultiSubtitles() {
        String str = this.D;
        return str != null && str.contains("2embed");
    }

    public boolean hasSubtitles() {
        String str = this.C;
        if (str != null && str.toLowerCase().contains("dood")) {
            return true;
        }
        String str2 = this.C;
        if (str2 != null && str2.toLowerCase().contains("sbembed")) {
            return true;
        }
        String str3 = this.C;
        return str3 != null && str3.toLowerCase().contains("vidnext");
    }

    public boolean isDoodlink() {
        String str = this.D;
        return str != null && (str.contains("d0000d") || this.D.contains("d0o0d") || this.D.contains("dood"));
    }

    public boolean isFileMoonlink() {
        String str = this.D;
        return str != null && str.contains("filemoon");
    }

    public boolean isOpenload() {
        String str = this.D;
        return str != null && (str.contains("openload") || this.D.contains("oload.")) && !this.D.contains("stream");
    }

    public boolean isSplitable() {
        return this.D != null && this.f13038n;
    }

    public String toString() {
        return this.C;
    }

    public boolean topLink() {
        return this.f13047w || this.f13050z || hasSubtitles() || hasMultiSubtitles() || this.D.toLowerCase().contains("flixvision") || this.f13046v || this.C.contains("FILESTREAM");
    }

    public boolean unavailable() {
        return isOpenload() || this.C.toLowerCase().contains("hydrax") || this.C.toLowerCase().contains("hqq") || this.C.toLowerCase().contains("supervideo") || this.C.toLowerCase().contains("2embed") || this.C.toLowerCase().contains("unlimitedfiles");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeByte(this.f13047w ? (byte) 1 : (byte) 0);
    }

    public o() {
        new HashMap();
        this.f13043s = 0;
        this.f13046v = false;
        this.f13050z = false;
        this.A = false;
        this.B = false;
        this.E = false;
        this.F = false;
    }
}
