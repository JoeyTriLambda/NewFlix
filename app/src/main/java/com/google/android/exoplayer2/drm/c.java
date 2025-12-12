package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import l6.u;

/* compiled from: DrmInitData.java */
/* loaded from: classes.dex */
public final class c implements Comparator<b>, Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final b[] f5834b;

    /* renamed from: m, reason: collision with root package name */
    public int f5835m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5836n;

    /* compiled from: DrmInitData.java */
    public static class a implements Parcelable.Creator<c> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public c[] newArray(int i10) {
            return new c[i10];
        }
    }

    /* compiled from: DrmInitData.java */
    public static final class b implements Parcelable {
        public static final Parcelable.Creator<b> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public int f5837b;

        /* renamed from: m, reason: collision with root package name */
        public final UUID f5838m;

        /* renamed from: n, reason: collision with root package name */
        public final String f5839n;

        /* renamed from: o, reason: collision with root package name */
        public final String f5840o;

        /* renamed from: p, reason: collision with root package name */
        public final byte[] f5841p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f5842q;

        /* compiled from: DrmInitData.java */
        public static class a implements Parcelable.Creator<b> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public b createFromParcel(Parcel parcel) {
                return new b(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public b[] newArray(int i10) {
                return new b[i10];
            }
        }

        public b(UUID uuid, String str, String str2, byte[] bArr) {
            this(uuid, str, str2, bArr, false);
        }

        public b copyWithSchemeType(String str) {
            return u.areEqual(this.f5839n, str) ? this : new b(this.f5838m, str, this.f5840o, this.f5841p, this.f5842q);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            return this.f5840o.equals(bVar.f5840o) && u.areEqual(this.f5838m, bVar.f5838m) && u.areEqual(this.f5839n, bVar.f5839n) && Arrays.equals(this.f5841p, bVar.f5841p);
        }

        public int hashCode() {
            if (this.f5837b == 0) {
                int iHashCode = this.f5838m.hashCode() * 31;
                String str = this.f5839n;
                this.f5837b = Arrays.hashCode(this.f5841p) + ac.c.b(this.f5840o, (iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
            }
            return this.f5837b;
        }

        public boolean matches(UUID uuid) {
            UUID uuid2 = c5.b.f5032b;
            UUID uuid3 = this.f5838m;
            return uuid2.equals(uuid3) || uuid.equals(uuid3);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            UUID uuid = this.f5838m;
            parcel.writeLong(uuid.getMostSignificantBits());
            parcel.writeLong(uuid.getLeastSignificantBits());
            parcel.writeString(this.f5839n);
            parcel.writeString(this.f5840o);
            parcel.writeByteArray(this.f5841p);
            parcel.writeByte(this.f5842q ? (byte) 1 : (byte) 0);
        }

        public b(UUID uuid, String str, String str2, byte[] bArr, boolean z10) {
            this.f5838m = (UUID) l6.a.checkNotNull(uuid);
            this.f5839n = str;
            this.f5840o = (String) l6.a.checkNotNull(str2);
            this.f5841p = (byte[]) l6.a.checkNotNull(bArr);
            this.f5842q = z10;
        }

        public b(Parcel parcel) {
            this.f5838m = new UUID(parcel.readLong(), parcel.readLong());
            this.f5839n = parcel.readString();
            this.f5840o = parcel.readString();
            this.f5841p = parcel.createByteArray();
            this.f5842q = parcel.readByte() != 0;
        }
    }

    public c(List<b> list) {
        this(false, (b[]) list.toArray(new b[list.size()]));
    }

    public c copyWithSchemeType(String str) {
        boolean z10;
        b[] bVarArr = this.f5834b;
        int length = bVarArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (!u.areEqual(bVarArr[i10].f5839n, str)) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return this;
        }
        int length2 = bVarArr.length;
        b[] bVarArr2 = new b[length2];
        for (int i11 = 0; i11 < length2; i11++) {
            bVarArr2[i11] = bVarArr[i11].copyWithSchemeType(str);
        }
        return new c(bVarArr2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f5834b, ((c) obj).f5834b);
    }

    public b get(UUID uuid) {
        for (b bVar : this.f5834b) {
            if (bVar.matches(uuid)) {
                return bVar;
            }
        }
        return null;
    }

    public int hashCode() {
        if (this.f5835m == 0) {
            this.f5835m = Arrays.hashCode(this.f5834b);
        }
        return this.f5835m;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedArray(this.f5834b, 0);
    }

    public c(b... bVarArr) {
        this(true, bVarArr);
    }

    @Override // java.util.Comparator
    public int compare(b bVar, b bVar2) {
        UUID uuid = c5.b.f5032b;
        if (uuid.equals(bVar.f5838m)) {
            return uuid.equals(bVar2.f5838m) ? 0 : 1;
        }
        return bVar.f5838m.compareTo(bVar2.f5838m);
    }

    public c(boolean z10, b... bVarArr) {
        bVarArr = z10 ? (b[]) bVarArr.clone() : bVarArr;
        Arrays.sort(bVarArr, this);
        for (int i10 = 1; i10 < bVarArr.length; i10++) {
            if (bVarArr[i10 - 1].f5838m.equals(bVarArr[i10].f5838m)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + bVarArr[i10].f5838m);
            }
        }
        this.f5834b = bVarArr;
        this.f5836n = bVarArr.length;
    }

    public b get(int i10) {
        return this.f5834b[i10];
    }

    public c(Parcel parcel) {
        b[] bVarArr = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f5834b = bVarArr;
        this.f5836n = bVarArr.length;
    }
}
