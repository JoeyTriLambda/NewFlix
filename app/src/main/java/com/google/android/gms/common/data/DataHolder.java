package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@KeepName
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7284b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String[] f7285m;

    /* renamed from: n, reason: collision with root package name */
    public Bundle f7286n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final CursorWindow[] f7287o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7288p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f7289q;

    /* renamed from: r, reason: collision with root package name */
    public int[] f7290r;

    /* renamed from: s, reason: collision with root package name */
    public int f7291s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f7292t = false;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f7293u = true;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static class Builder {
        public /* synthetic */ Builder(String[] strArr) {
            new ArrayList();
            new HashMap();
        }
    }

    static {
        new zab(new String[0]);
    }

    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param int i10, @SafeParcelable.Param String[] strArr, @SafeParcelable.Param CursorWindow[] cursorWindowArr, @SafeParcelable.Param int i11, @SafeParcelable.Param Bundle bundle) {
        this.f7284b = i10;
        this.f7285m = strArr;
        this.f7287o = cursorWindowArr;
        this.f7288p = i11;
        this.f7289q = bundle;
    }

    public final void a(int i10, String str) {
        Bundle bundle = this.f7286n;
        if (bundle == null || !bundle.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i10 < 0 || i10 >= this.f7291s) {
            throw new CursorIndexOutOfBoundsException(i10, this.f7291s);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public void close() {
        synchronized (this) {
            if (!this.f7292t) {
                this.f7292t = true;
                int i10 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f7287o;
                    if (i10 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i10].close();
                    i10++;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.f7293u && this.f7287o.length > 0 && !isClosed()) {
                close();
                String string = toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 178);
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(string);
                sb2.append(")");
                Log.e("DataBuffer", sb2.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public byte[] getByteArray(String str, int i10, int i11) {
        a(i10, str);
        return this.f7287o[i11].getBlob(i10, this.f7286n.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.f7291s;
    }

    @KeepForSdk
    public Bundle getMetadata() {
        return this.f7289q;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.f7288p;
    }

    @KeepForSdk
    public int getWindowIndex(int i10) {
        int length;
        int i11 = 0;
        Preconditions.checkState(i10 >= 0 && i10 < this.f7291s);
        while (true) {
            int[] iArr = this.f7290r;
            length = iArr.length;
            if (i11 >= length) {
                break;
            }
            if (i10 < iArr[i11]) {
                i11--;
                break;
            }
            i11++;
        }
        return i11 == length ? i11 - 1 : i11;
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z10;
        synchronized (this) {
            z10 = this.f7292t;
        }
        return z10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.f7285m, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.f7287o, i10, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f7284b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        if ((i10 & 1) != 0) {
            close();
        }
    }

    public final void zad() {
        this.f7286n = new Bundle();
        int i10 = 0;
        while (true) {
            String[] strArr = this.f7285m;
            if (i10 >= strArr.length) {
                break;
            }
            this.f7286n.putInt(strArr[i10], i10);
            i10++;
        }
        CursorWindow[] cursorWindowArr = this.f7287o;
        this.f7290r = new int[cursorWindowArr.length];
        int numRows = 0;
        for (int i11 = 0; i11 < cursorWindowArr.length; i11++) {
            this.f7290r[i11] = numRows;
            numRows += cursorWindowArr[i11].getNumRows() - (numRows - cursorWindowArr[i11].getStartPosition());
        }
        this.f7291s = numRows;
    }
}
