package com.google.android.gms.cast;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public final class TextTrackStyle extends AbstractSafeParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<TextTrackStyle> CREATOR = new zzds();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public float f6314b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6315m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6316n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6317o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6318p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6319q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6320r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6321s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6322t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6323u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6324v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6325w;

    /* renamed from: x, reason: collision with root package name */
    public JSONObject f6326x;

    public TextTrackStyle() {
        this(1.0f, 0, 0, -1, 0, -1, 0, 0, null, -1, -1, null);
    }

    public static final int a(String str) throws NumberFormatException {
        if (str != null && str.length() == 9 && str.charAt(0) == '#') {
            try {
                return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
            } catch (NumberFormatException unused) {
            }
        }
        return 0;
    }

    public static final String b(int i10) {
        return String.format("#%02X%02X%02X%02X", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Integer.valueOf(Color.alpha(i10)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) obj;
        JSONObject jSONObject = this.f6326x;
        boolean z10 = jSONObject == null;
        JSONObject jSONObject2 = textTrackStyle.f6326x;
        if (z10 != (jSONObject2 == null)) {
            return false;
        }
        return (jSONObject == null || jSONObject2 == null || JsonUtils.areJsonValuesEquivalent(jSONObject, jSONObject2)) && this.f6314b == textTrackStyle.f6314b && this.f6315m == textTrackStyle.f6315m && this.f6316n == textTrackStyle.f6316n && this.f6317o == textTrackStyle.f6317o && this.f6318p == textTrackStyle.f6318p && this.f6319q == textTrackStyle.f6319q && this.f6320r == textTrackStyle.f6320r && this.f6321s == textTrackStyle.f6321s && CastUtils.zze(this.f6322t, textTrackStyle.f6322t) && this.f6323u == textTrackStyle.f6323u && this.f6324v == textTrackStyle.f6324v;
    }

    @KeepForSdk
    public void fromJson(JSONObject jSONObject) throws JSONException {
        this.f6314b = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.f6315m = a(jSONObject.optString("foregroundColor"));
        this.f6316n = a(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.f6317o = 0;
            } else if ("OUTLINE".equals(string)) {
                this.f6317o = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.f6317o = 2;
            } else if ("RAISED".equals(string)) {
                this.f6317o = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.f6317o = 4;
            }
        }
        this.f6318p = a(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.f6319q = 0;
            } else if ("NORMAL".equals(string2)) {
                this.f6319q = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.f6319q = 2;
            }
        }
        this.f6320r = a(jSONObject.optString("windowColor"));
        if (this.f6319q == 2) {
            this.f6321s = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.f6322t = CastUtils.optStringOrNull(jSONObject, "fontFamily");
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.f6323u = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.f6323u = 1;
            } else if ("SERIF".equals(string3)) {
                this.f6323u = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.f6323u = 3;
            } else if ("CASUAL".equals(string3)) {
                this.f6323u = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.f6323u = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.f6323u = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.f6324v = 0;
            } else if ("BOLD".equals(string4)) {
                this.f6324v = 1;
            } else if ("ITALIC".equals(string4)) {
                this.f6324v = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.f6324v = 3;
            }
        }
        this.f6326x = jSONObject.optJSONObject("customData");
    }

    public int getBackgroundColor() {
        return this.f6316n;
    }

    public int getEdgeColor() {
        return this.f6318p;
    }

    public int getEdgeType() {
        return this.f6317o;
    }

    public String getFontFamily() {
        return this.f6322t;
    }

    public int getFontGenericFamily() {
        return this.f6323u;
    }

    public float getFontScale() {
        return this.f6314b;
    }

    public int getFontStyle() {
        return this.f6324v;
    }

    public int getForegroundColor() {
        return this.f6315m;
    }

    public int getWindowColor() {
        return this.f6320r;
    }

    public int getWindowCornerRadius() {
        return this.f6321s;
    }

    public int getWindowType() {
        return this.f6319q;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.f6314b), Integer.valueOf(this.f6315m), Integer.valueOf(this.f6316n), Integer.valueOf(this.f6317o), Integer.valueOf(this.f6318p), Integer.valueOf(this.f6319q), Integer.valueOf(this.f6320r), Integer.valueOf(this.f6321s), this.f6322t, Integer.valueOf(this.f6323u), Integer.valueOf(this.f6324v), String.valueOf(this.f6326x));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6326x;
        this.f6325w = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, getFontScale());
        SafeParcelWriter.writeInt(parcel, 3, getForegroundColor());
        SafeParcelWriter.writeInt(parcel, 4, getBackgroundColor());
        SafeParcelWriter.writeInt(parcel, 5, getEdgeType());
        SafeParcelWriter.writeInt(parcel, 6, getEdgeColor());
        SafeParcelWriter.writeInt(parcel, 7, getWindowType());
        SafeParcelWriter.writeInt(parcel, 8, getWindowColor());
        SafeParcelWriter.writeInt(parcel, 9, getWindowCornerRadius());
        SafeParcelWriter.writeString(parcel, 10, getFontFamily(), false);
        SafeParcelWriter.writeInt(parcel, 11, getFontGenericFamily());
        SafeParcelWriter.writeInt(parcel, 12, getFontStyle());
        SafeParcelWriter.writeString(parcel, 13, this.f6325w, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", this.f6314b);
            int i10 = this.f6315m;
            if (i10 != 0) {
                jSONObject.put("foregroundColor", b(i10));
            }
            int i11 = this.f6316n;
            if (i11 != 0) {
                jSONObject.put("backgroundColor", b(i11));
            }
            int i12 = this.f6317o;
            if (i12 == 0) {
                jSONObject.put("edgeType", "NONE");
            } else if (i12 == 1) {
                jSONObject.put("edgeType", "OUTLINE");
            } else if (i12 == 2) {
                jSONObject.put("edgeType", "DROP_SHADOW");
            } else if (i12 == 3) {
                jSONObject.put("edgeType", "RAISED");
            } else if (i12 == 4) {
                jSONObject.put("edgeType", "DEPRESSED");
            }
            int i13 = this.f6318p;
            if (i13 != 0) {
                jSONObject.put("edgeColor", b(i13));
            }
            int i14 = this.f6319q;
            if (i14 == 0) {
                jSONObject.put("windowType", "NONE");
            } else if (i14 == 1) {
                jSONObject.put("windowType", "NORMAL");
            } else if (i14 == 2) {
                jSONObject.put("windowType", "ROUNDED_CORNERS");
            }
            int i15 = this.f6320r;
            if (i15 != 0) {
                jSONObject.put("windowColor", b(i15));
            }
            if (this.f6319q == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.f6321s);
            }
            String str = this.f6322t;
            if (str != null) {
                jSONObject.put("fontFamily", str);
            }
            switch (this.f6323u) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            int i16 = this.f6324v;
            if (i16 == 0) {
                jSONObject.put("fontStyle", "NORMAL");
            } else if (i16 == 1) {
                jSONObject.put("fontStyle", "BOLD");
            } else if (i16 == 2) {
                jSONObject.put("fontStyle", "ITALIC");
            } else if (i16 == 3) {
                jSONObject.put("fontStyle", "BOLD_ITALIC");
            }
            JSONObject jSONObject2 = this.f6326x;
            if (jSONObject2 != null) {
                jSONObject.put("customData", jSONObject2);
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @SafeParcelable.Constructor
    public TextTrackStyle(@SafeParcelable.Param float f10, @SafeParcelable.Param int i10, @SafeParcelable.Param int i11, @SafeParcelable.Param int i12, @SafeParcelable.Param int i13, @SafeParcelable.Param int i14, @SafeParcelable.Param int i15, @SafeParcelable.Param int i16, @SafeParcelable.Param String str, @SafeParcelable.Param int i17, @SafeParcelable.Param int i18, @SafeParcelable.Param String str2) {
        this.f6314b = f10;
        this.f6315m = i10;
        this.f6316n = i11;
        this.f6317o = i12;
        this.f6318p = i13;
        this.f6319q = i14;
        this.f6320r = i15;
        this.f6321s = i16;
        this.f6322t = str;
        this.f6323u = i17;
        this.f6324v = i18;
        this.f6325w = str2;
        if (str2 == null) {
            this.f6326x = null;
            return;
        }
        try {
            this.f6326x = new JSONObject(this.f6325w);
        } catch (JSONException unused) {
            this.f6326x = null;
            this.f6325w = null;
        }
    }
}
