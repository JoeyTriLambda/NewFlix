package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new zah();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f7298b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final Uri f7299m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7300n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f7301o;

    @SafeParcelable.Constructor
    public WebImage(@SafeParcelable.Param int i10, @SafeParcelable.Param Uri uri, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12) {
        this.f7298b = i10;
        this.f7299m = uri;
        this.f7300n = i11;
        this.f7301o = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (Objects.equal(this.f7299m, webImage.f7299m) && this.f7300n == webImage.f7300n && this.f7301o == webImage.f7301o) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        return this.f7301o;
    }

    public Uri getUrl() {
        return this.f7299m;
    }

    public int getWidth() {
        return this.f7300n;
    }

    public int hashCode() {
        return Objects.hashCode(this.f7299m, Integer.valueOf(this.f7300n), Integer.valueOf(this.f7301o));
    }

    @KeepForSdk
    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("url", this.f7299m.toString());
            jSONObject.put("width", this.f7300n);
            jSONObject.put("height", this.f7301o);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f7300n), Integer.valueOf(this.f7301o), this.f7299m.toString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f7298b);
        SafeParcelWriter.writeParcelable(parcel, 2, getUrl(), i10, false);
        SafeParcelWriter.writeInt(parcel, 3, getWidth());
        SafeParcelWriter.writeInt(parcel, 4, getHeight());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public WebImage(Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }

    public WebImage(Uri uri, int i10, int i11) throws IllegalArgumentException {
        this(1, uri, i10, i11);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @KeepForSdk
    public WebImage(JSONObject jSONObject) throws IllegalArgumentException {
        Uri uri = Uri.EMPTY;
        if (jSONObject.has("url")) {
            try {
                uri = Uri.parse(jSONObject.getString("url"));
            } catch (JSONException unused) {
            }
        }
        this(uri, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
    }
}
