package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.JsonUtils;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes.dex */
public class SessionState extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SessionState> CREATOR = new zzdr();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.Field
    public final MediaLoadRequestData f6310b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6311m;

    /* renamed from: n, reason: collision with root package name */
    public final JSONObject f6312n;

    /* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public MediaLoadRequestData f6313a;

        public SessionState build() {
            return new SessionState(this.f6313a, null);
        }

        public Builder setLoadRequestData(MediaLoadRequestData mediaLoadRequestData) {
            this.f6313a = mediaLoadRequestData;
            return this;
        }
    }

    public SessionState(MediaLoadRequestData mediaLoadRequestData, JSONObject jSONObject) {
        this.f6310b = mediaLoadRequestData;
        this.f6312n = jSONObject;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionState)) {
            return false;
        }
        SessionState sessionState = (SessionState) obj;
        if (JsonUtils.areJsonValuesEquivalent(this.f6312n, sessionState.f6312n)) {
            return Objects.equal(this.f6310b, sessionState.f6310b);
        }
        return false;
    }

    public MediaLoadRequestData getLoadRequestData() {
        return this.f6310b;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6310b, String.valueOf(this.f6312n));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.f6312n;
        this.f6311m = jSONObject == null ? null : jSONObject.toString();
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getLoadRequestData(), i10, false);
        SafeParcelWriter.writeString(parcel, 3, this.f6311m, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
