package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaQueueContainerMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueContainerMetadata> CREATOR = new zzcg();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6242b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6243m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public List f6244n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public List f6245o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public double f6246p;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final MediaQueueContainerMetadata f6247a = new MediaQueueContainerMetadata(0);

        public MediaQueueContainerMetadata build() {
            return new MediaQueueContainerMetadata(this.f6247a);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.google.android.gms.cast.MediaQueueContainerMetadata.Builder zza(org.json.JSONObject r7) throws org.json.JSONException {
            /*
                r6 = this;
                android.os.Parcelable$Creator<com.google.android.gms.cast.MediaQueueContainerMetadata> r0 = com.google.android.gms.cast.MediaQueueContainerMetadata.CREATOR
                com.google.android.gms.cast.MediaQueueContainerMetadata r0 = r6.f6247a
                r1 = 0
                r0.f6242b = r1
                r2 = 0
                r0.f6243m = r2
                r0.f6244n = r2
                r0.f6245o = r2
                r2 = 0
                r0.f6246p = r2
                java.lang.String r2 = "containerType"
                java.lang.String r3 = ""
                java.lang.String r2 = r7.optString(r2, r3)
                int r3 = r2.hashCode()
                r4 = 6924225(0x69a7c1, float:9.702906E-39)
                r5 = 1
                if (r3 == r4) goto L34
                r4 = 828666841(0x316473d9, float:3.3244218E-9)
                if (r3 == r4) goto L2a
                goto L3e
            L2a:
                java.lang.String r3 = "GENERIC_CONTAINER"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L3e
                r2 = 0
                goto L3f
            L34:
                java.lang.String r3 = "AUDIOBOOK_CONTAINER"
                boolean r2 = r2.equals(r3)
                if (r2 == 0) goto L3e
                r2 = 1
                goto L3f
            L3e:
                r2 = -1
            L3f:
                if (r2 == 0) goto L47
                if (r2 == r5) goto L44
                goto L49
            L44:
                r0.f6242b = r5
                goto L49
            L47:
                r0.f6242b = r1
            L49:
                java.lang.String r2 = "title"
                java.lang.String r2 = com.google.android.gms.cast.internal.CastUtils.optStringOrNull(r7, r2)
                r0.f6243m = r2
                java.lang.String r2 = "sections"
                org.json.JSONArray r2 = r7.optJSONArray(r2)
                if (r2 == 0) goto L7a
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>()
                r0.f6244n = r3
            L60:
                int r4 = r2.length()
                if (r1 >= r4) goto L7a
                org.json.JSONObject r4 = r2.optJSONObject(r1)
                if (r4 == 0) goto L77
                com.google.android.gms.cast.MediaMetadata r5 = new com.google.android.gms.cast.MediaMetadata
                r5.<init>()
                r5.zzc(r4)
                r3.add(r5)
            L77:
                int r1 = r1 + 1
                goto L60
            L7a:
                java.lang.String r1 = "containerImages"
                org.json.JSONArray r1 = r7.optJSONArray(r1)
                if (r1 == 0) goto L8c
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                r0.f6245o = r2
                com.google.android.gms.cast.internal.media.zza.zzd(r2, r1)
            L8c:
                double r1 = r0.f6246p
                java.lang.String r3 = "containerDuration"
                double r1 = r7.optDouble(r3, r1)
                r0.f6246p = r1
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaQueueContainerMetadata.Builder.zza(org.json.JSONObject):com.google.android.gms.cast.MediaQueueContainerMetadata$Builder");
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueContainerType {
    }

    private MediaQueueContainerMetadata() {
        this.f6242b = 0;
        this.f6243m = null;
        this.f6244n = null;
        this.f6245o = null;
        this.f6246p = 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueContainerMetadata)) {
            return false;
        }
        MediaQueueContainerMetadata mediaQueueContainerMetadata = (MediaQueueContainerMetadata) obj;
        return this.f6242b == mediaQueueContainerMetadata.f6242b && TextUtils.equals(this.f6243m, mediaQueueContainerMetadata.f6243m) && Objects.equal(this.f6244n, mediaQueueContainerMetadata.f6244n) && Objects.equal(this.f6245o, mediaQueueContainerMetadata.f6245o) && this.f6246p == mediaQueueContainerMetadata.f6246p;
    }

    public double getContainerDuration() {
        return this.f6246p;
    }

    public List<WebImage> getContainerImages() {
        List list = this.f6245o;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public int getContainerType() {
        return this.f6242b;
    }

    public List<MediaMetadata> getSections() {
        List list = this.f6244n;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getTitle() {
        return this.f6243m;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f6242b), this.f6243m, this.f6244n, this.f6245o, Double.valueOf(this.f6246p));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getContainerType());
        SafeParcelWriter.writeString(parcel, 3, getTitle(), false);
        SafeParcelWriter.writeTypedList(parcel, 4, getSections(), false);
        SafeParcelWriter.writeTypedList(parcel, 5, getContainerImages(), false);
        SafeParcelWriter.writeDouble(parcel, 6, getContainerDuration());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            int i10 = this.f6242b;
            if (i10 == 0) {
                jSONObject.put("containerType", "GENERIC_CONTAINER");
            } else if (i10 == 1) {
                jSONObject.put("containerType", "AUDIOBOOK_CONTAINER");
            }
            if (!TextUtils.isEmpty(this.f6243m)) {
                jSONObject.put("title", this.f6243m);
            }
            List list = this.f6244n;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f6244n.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaMetadata) it.next()).zza());
                }
                jSONObject.put("sections", jSONArray);
            }
            List list2 = this.f6245o;
            if (list2 != null && !list2.isEmpty()) {
                jSONObject.put("containerImages", com.google.android.gms.cast.internal.media.zza.zzc(this.f6245o));
            }
            jSONObject.put("containerDuration", this.f6246p);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @SafeParcelable.Constructor
    public MediaQueueContainerMetadata(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param ArrayList arrayList2, @SafeParcelable.Param double d10) {
        this.f6242b = i10;
        this.f6243m = str;
        this.f6244n = arrayList;
        this.f6245o = arrayList2;
        this.f6246p = d10;
    }

    public MediaQueueContainerMetadata(int i10) {
        this.f6242b = 0;
        this.f6243m = null;
        this.f6244n = null;
        this.f6245o = null;
        this.f6246p = 0.0d;
    }

    public /* synthetic */ MediaQueueContainerMetadata(MediaQueueContainerMetadata mediaQueueContainerMetadata) {
        this.f6242b = mediaQueueContainerMetadata.f6242b;
        this.f6243m = mediaQueueContainerMetadata.f6243m;
        this.f6244n = mediaQueueContainerMetadata.f6244n;
        this.f6245o = mediaQueueContainerMetadata.f6245o;
        this.f6246p = mediaQueueContainerMetadata.f6246p;
    }
}
