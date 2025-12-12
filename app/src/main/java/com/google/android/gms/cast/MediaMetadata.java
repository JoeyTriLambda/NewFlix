package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class MediaMetadata extends AbstractSafeParcelable {

    /* renamed from: p, reason: collision with root package name */
    public static final zzcd f6238p;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final List f6239b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final Bundle f6240m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public int f6241n;

    /* renamed from: o, reason: collision with root package name */
    public static final String[] f6237o = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new zzce();

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    @KeepForSdk
    public class Writer {
        public Writer(MediaMetadata mediaMetadata) {
        }
    }

    static {
        zzcd zzcdVar = new zzcd();
        zzcdVar.zzb("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.TITLE", "title", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.ARTIST", "artist", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.STUDIO", "studio", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.WIDTH", "width", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.HEIGHT", "height", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SECTION_DURATION", "sectionDuration", 5);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "sectionStartTimeInMedia", 5);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "sectionStartAbsoluteTime", 5);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "sectionStartTimeInContainer", 5);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.QUEUE_ITEM_ID", "queueItemId", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.BOOK_TITLE", "bookTitle", 1);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "chapterNumber", 2);
        zzcdVar.zzb("com.google.android.gms.cast.metadata.CHAPTER_TITLE", "chapterTitle", 1);
        f6238p = zzcdVar;
    }

    public MediaMetadata() {
        this(0);
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !a((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static void throwIfWrongType(String str, int i10) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("null and empty keys are not allowed");
        }
        int iZza = f6238p.zza(str);
        if (iZza == i10 || iZza == 0) {
            return;
        }
        throw new IllegalArgumentException("Value for " + str + " must be a " + f6237o[i10]);
    }

    public void addImage(WebImage webImage) {
        this.f6239b.add(webImage);
    }

    public void clear() {
        this.f6240m.clear();
        this.f6239b.clear();
    }

    public boolean containsKey(String str) {
        return this.f6240m.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return a(this.f6240m, mediaMetadata.f6240m) && this.f6239b.equals(mediaMetadata.f6239b);
    }

    public List<WebImage> getImages() {
        return this.f6239b;
    }

    public int getMediaType() {
        return this.f6241n;
    }

    public String getString(String str) throws IllegalArgumentException {
        throwIfWrongType(str, 1);
        return this.f6240m.getString(str);
    }

    public long getTimeMillis(String str) throws IllegalArgumentException {
        throwIfWrongType(str, 5);
        return this.f6240m.getLong(str);
    }

    public boolean hasImages() {
        List list = this.f6239b;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public int hashCode() {
        int iHashCode = 17;
        Bundle bundle = this.f6240m;
        if (bundle != null) {
            Iterator<String> it = bundle.keySet().iterator();
            while (it.hasNext()) {
                Object obj = bundle.get(it.next());
                iHashCode = (iHashCode * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return this.f6239b.hashCode() + (iHashCode * 31);
    }

    public void putString(String str, String str2) throws IllegalArgumentException {
        throwIfWrongType(str, 1);
        this.f6240m.putString(str, str2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getImages(), false);
        SafeParcelWriter.writeBundle(parcel, 3, this.f6240m, false);
        SafeParcelWriter.writeInt(parcel, 4, getMediaType());
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public final JSONObject zza() throws JSONException {
        Bundle bundle;
        zzcd zzcdVar;
        String strZzc;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadataType", this.f6241n);
        } catch (JSONException unused) {
        }
        JSONArray jSONArrayZzc = com.google.android.gms.cast.internal.media.zza.zzc(this.f6239b);
        if (jSONArrayZzc.length() != 0) {
            try {
                jSONObject.put("images", jSONArrayZzc);
            } catch (JSONException unused2) {
            }
        }
        ArrayList arrayList = new ArrayList();
        int i10 = this.f6241n;
        if (i10 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i10 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i10 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        try {
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                bundle = this.f6240m;
                if (!zHasNext) {
                    break;
                }
                String str = (String) it.next();
                if (str != null && bundle.containsKey(str) && (strZzc = (zzcdVar = f6238p).zzc(str)) != null) {
                    int iZza = zzcdVar.zza(str);
                    if (iZza != 1) {
                        if (iZza == 2) {
                            jSONObject.put(strZzc, bundle.getInt(str));
                        } else if (iZza == 3) {
                            jSONObject.put(strZzc, bundle.getDouble(str));
                        } else if (iZza != 4) {
                            if (iZza == 5) {
                                jSONObject.put(strZzc, CastUtils.millisecToSec(bundle.getLong(str)));
                            }
                        }
                    }
                    jSONObject.put(strZzc, bundle.getString(str));
                }
            }
            for (String str2 : bundle.keySet()) {
                if (!str2.startsWith("com.google.")) {
                    Object obj = bundle.get(str2);
                    if (obj instanceof String) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Integer) {
                        jSONObject.put(str2, obj);
                    } else if (obj instanceof Double) {
                        jSONObject.put(str2, obj);
                    }
                }
            }
        } catch (JSONException unused3) {
        }
        return jSONObject;
    }

    public final void zzc(JSONObject jSONObject) throws JSONException {
        clear();
        this.f6241n = 0;
        try {
            this.f6241n = jSONObject.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("images");
        if (jSONArrayOptJSONArray != null) {
            com.google.android.gms.cast.internal.media.zza.zzd(this.f6239b, jSONArrayOptJSONArray);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = this.f6241n;
        if (i10 == 0) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 1) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 2) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE");
        } else if (i10 == 3) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE");
        } else if (i10 == 4) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE");
        } else if (i10 == 5) {
            Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.CHAPTER_TITLE", "com.google.android.gms.cast.metadata.CHAPTER_NUMBER", "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.BOOK_TITLE", "com.google.android.gms.cast.metadata.SUBTITLE");
        }
        Collections.addAll(arrayList, "com.google.android.gms.cast.metadata.SECTION_DURATION", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA", "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME", "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER", "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID");
        HashSet hashSet = new HashSet(arrayList);
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && !"metadataType".equals(next)) {
                    zzcd zzcdVar = f6238p;
                    String strZzd = zzcdVar.zzd(next);
                    Bundle bundle = this.f6240m;
                    if (strZzd == null) {
                        Object obj = jSONObject.get(next);
                        if (obj instanceof String) {
                            bundle.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            bundle.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            bundle.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(strZzd)) {
                        try {
                            Object obj2 = jSONObject.get(next);
                            if (obj2 != null) {
                                int iZza = zzcdVar.zza(strZzd);
                                if (iZza != 1) {
                                    if (iZza != 2) {
                                        if (iZza == 3) {
                                            double dOptDouble = jSONObject.optDouble(next);
                                            if (!Double.isNaN(dOptDouble)) {
                                                bundle.putDouble(strZzd, dOptDouble);
                                            }
                                        } else if (iZza != 4) {
                                            if (iZza == 5) {
                                                bundle.putLong(strZzd, CastUtils.secToMillisec(jSONObject.optLong(next)));
                                            }
                                        } else if (obj2 instanceof String) {
                                            String str = (String) obj2;
                                            if (com.google.android.gms.cast.internal.media.zza.zzb(str) != null) {
                                                bundle.putString(strZzd, str);
                                            }
                                        }
                                    } else if (obj2 instanceof Integer) {
                                        bundle.putInt(strZzd, ((Integer) obj2).intValue());
                                    }
                                } else if (obj2 instanceof String) {
                                    bundle.putString(strZzd, (String) obj2);
                                }
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                }
            }
        } catch (JSONException unused3) {
        }
    }

    public MediaMetadata(int i10) {
        this(new ArrayList(), new Bundle(), i10);
    }

    @SafeParcelable.Constructor
    public MediaMetadata(@SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param Bundle bundle, @SafeParcelable.Param int i10) {
        new Writer(this);
        this.f6239b = arrayList;
        this.f6240m = bundle;
        this.f6241n = i10;
    }
}
