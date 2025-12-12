package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.unity3d.ads.metadata.MediationMetaData;
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
public class MediaQueueData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaQueueData> CREATOR = new zzci();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6248b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6249m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6250n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6251o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public MediaQueueContainerMetadata f6252p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6253q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public List f6254r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6255s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public long f6256t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public boolean f6257u;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final MediaQueueData f6258a = new MediaQueueData(0);

        public MediaQueueData build() {
            return new MediaQueueData(this.f6258a);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final com.google.android.gms.cast.MediaQueueData.Builder zza(org.json.JSONObject r13) {
            /*
                Method dump skipped, instructions count: 370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaQueueData.Builder.zza(org.json.JSONObject):com.google.android.gms.cast.MediaQueueData$Builder");
        }
    }

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface MediaQueueType {
    }

    private MediaQueueData() {
        a();
    }

    public final void a() {
        this.f6248b = null;
        this.f6249m = null;
        this.f6250n = 0;
        this.f6251o = null;
        this.f6253q = 0;
        this.f6254r = null;
        this.f6255s = 0;
        this.f6256t = -1L;
        this.f6257u = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaQueueData)) {
            return false;
        }
        MediaQueueData mediaQueueData = (MediaQueueData) obj;
        return TextUtils.equals(this.f6248b, mediaQueueData.f6248b) && TextUtils.equals(this.f6249m, mediaQueueData.f6249m) && this.f6250n == mediaQueueData.f6250n && TextUtils.equals(this.f6251o, mediaQueueData.f6251o) && Objects.equal(this.f6252p, mediaQueueData.f6252p) && this.f6253q == mediaQueueData.f6253q && Objects.equal(this.f6254r, mediaQueueData.f6254r) && this.f6255s == mediaQueueData.f6255s && this.f6256t == mediaQueueData.f6256t && this.f6257u == mediaQueueData.f6257u;
    }

    public MediaQueueContainerMetadata getContainerMetadata() {
        return this.f6252p;
    }

    public String getEntity() {
        return this.f6249m;
    }

    public List<MediaQueueItem> getItems() {
        List list = this.f6254r;
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public String getName() {
        return this.f6251o;
    }

    public String getQueueId() {
        return this.f6248b;
    }

    public int getQueueType() {
        return this.f6250n;
    }

    public int getRepeatMode() {
        return this.f6253q;
    }

    public int getStartIndex() {
        return this.f6255s;
    }

    public long getStartTime() {
        return this.f6256t;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6248b, this.f6249m, Integer.valueOf(this.f6250n), this.f6251o, this.f6252p, Integer.valueOf(this.f6253q), this.f6254r, Integer.valueOf(this.f6255s), Long.valueOf(this.f6256t), Boolean.valueOf(this.f6257u));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getQueueId(), false);
        SafeParcelWriter.writeString(parcel, 3, getEntity(), false);
        SafeParcelWriter.writeInt(parcel, 4, getQueueType());
        SafeParcelWriter.writeString(parcel, 5, getName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getContainerMetadata(), i10, false);
        SafeParcelWriter.writeInt(parcel, 7, getRepeatMode());
        SafeParcelWriter.writeTypedList(parcel, 8, getItems(), false);
        SafeParcelWriter.writeInt(parcel, 9, getStartIndex());
        SafeParcelWriter.writeLong(parcel, 10, getStartTime());
        SafeParcelWriter.writeBoolean(parcel, 11, this.f6257u);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f6248b)) {
                jSONObject.put("id", this.f6248b);
            }
            if (!TextUtils.isEmpty(this.f6249m)) {
                jSONObject.put("entity", this.f6249m);
            }
            switch (this.f6250n) {
                case 1:
                    jSONObject.put("queueType", "ALBUM");
                    break;
                case 2:
                    jSONObject.put("queueType", "PLAYLIST");
                    break;
                case 3:
                    jSONObject.put("queueType", "AUDIOBOOK");
                    break;
                case 4:
                    jSONObject.put("queueType", "RADIO_STATION");
                    break;
                case 5:
                    jSONObject.put("queueType", "PODCAST_SERIES");
                    break;
                case 6:
                    jSONObject.put("queueType", "TV_SERIES");
                    break;
                case 7:
                    jSONObject.put("queueType", "VIDEO_PLAYLIST");
                    break;
                case 8:
                    jSONObject.put("queueType", "LIVE_TV");
                    break;
                case 9:
                    jSONObject.put("queueType", "MOVIE");
                    break;
            }
            if (!TextUtils.isEmpty(this.f6251o)) {
                jSONObject.put(MediationMetaData.KEY_NAME, this.f6251o);
            }
            MediaQueueContainerMetadata mediaQueueContainerMetadata = this.f6252p;
            if (mediaQueueContainerMetadata != null) {
                jSONObject.put("containerMetadata", mediaQueueContainerMetadata.zza());
            }
            String strZza = MediaCommon.zza(Integer.valueOf(this.f6253q));
            if (strZza != null) {
                jSONObject.put("repeatMode", strZza);
            }
            List list = this.f6254r;
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                Iterator it = this.f6254r.iterator();
                while (it.hasNext()) {
                    jSONArray.put(((MediaQueueItem) it.next()).toJson());
                }
                jSONObject.put("items", jSONArray);
            }
            jSONObject.put("startIndex", this.f6255s);
            long j10 = this.f6256t;
            if (j10 != -1) {
                jSONObject.put("startTime", CastUtils.millisecToSec(j10));
            }
            jSONObject.put("shuffle", this.f6257u);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @ShowFirstParty
    public final boolean zzk() {
        return this.f6257u;
    }

    public /* synthetic */ MediaQueueData(int i10) {
        a();
    }

    public /* synthetic */ MediaQueueData(MediaQueueData mediaQueueData) {
        this.f6248b = mediaQueueData.f6248b;
        this.f6249m = mediaQueueData.f6249m;
        this.f6250n = mediaQueueData.f6250n;
        this.f6251o = mediaQueueData.f6251o;
        this.f6252p = mediaQueueData.f6252p;
        this.f6253q = mediaQueueData.f6253q;
        this.f6254r = mediaQueueData.f6254r;
        this.f6255s = mediaQueueData.f6255s;
        this.f6256t = mediaQueueData.f6256t;
        this.f6257u = mediaQueueData.f6257u;
    }

    @SafeParcelable.Constructor
    public MediaQueueData(@SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param int i10, @SafeParcelable.Param String str3, @SafeParcelable.Param MediaQueueContainerMetadata mediaQueueContainerMetadata, @SafeParcelable.Param int i11, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param int i12, @SafeParcelable.Param long j10, @SafeParcelable.Param boolean z10) {
        this.f6248b = str;
        this.f6249m = str2;
        this.f6250n = i10;
        this.f6251o = str3;
        this.f6252p = mediaQueueContainerMetadata;
        this.f6253q = i11;
        this.f6254r = arrayList;
        this.f6255s = i12;
        this.f6256t = j10;
        this.f6257u = z10;
    }
}
