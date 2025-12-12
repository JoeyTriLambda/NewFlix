package com.google.android.gms.auth.api.signin;

import ac.c;
import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zab();

    /* renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    public static final Clock f6063y = DefaultClock.getInstance();

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f6064b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6065m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6066n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6067o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6068p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final Uri f6069q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public String f6070r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final long f6071s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6072t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final List<Scope> f6073u;

    /* renamed from: v, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6074v;

    /* renamed from: w, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6075w;

    /* renamed from: x, reason: collision with root package name */
    public final HashSet f6076x = new HashSet();

    @SafeParcelable.Constructor
    public GoogleSignInAccount(@SafeParcelable.Param int i10, @SafeParcelable.Param String str, @SafeParcelable.Param String str2, @SafeParcelable.Param String str3, @SafeParcelable.Param String str4, @SafeParcelable.Param Uri uri, @SafeParcelable.Param String str5, @SafeParcelable.Param long j10, @SafeParcelable.Param String str6, @SafeParcelable.Param ArrayList arrayList, @SafeParcelable.Param String str7, @SafeParcelable.Param String str8) {
        this.f6064b = i10;
        this.f6065m = str;
        this.f6066n = str2;
        this.f6067o = str3;
        this.f6068p = str4;
        this.f6069q = uri;
        this.f6070r = str5;
        this.f6071s = j10;
        this.f6072t = str6;
        this.f6073u = arrayList;
        this.f6074v = str7;
        this.f6075w = str8;
    }

    public static GoogleSignInAccount zaa(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l10, String str7, Set<Scope> set) {
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, l10.longValue(), Preconditions.checkNotEmpty(str7), new ArrayList((Collection) Preconditions.checkNotNull(set)), str5, str6);
    }

    public static GoogleSignInAccount zab(String str) throws JSONException, NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j10 = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            hashSet.add(new Scope(jSONArray.getString(i10)));
        }
        GoogleSignInAccount googleSignInAccountZaa = zaa(jSONObject.optString("id"), jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null, jSONObject.has("email") ? jSONObject.optString("email") : null, jSONObject.has("displayName") ? jSONObject.optString("displayName") : null, jSONObject.has("givenName") ? jSONObject.optString("givenName") : null, jSONObject.has("familyName") ? jSONObject.optString("familyName") : null, uri, Long.valueOf(j10), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        googleSignInAccountZaa.f6070r = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccountZaa;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        return googleSignInAccount.f6072t.equals(this.f6072t) && googleSignInAccount.getRequestedScopes().equals(getRequestedScopes());
    }

    public Account getAccount() {
        String str = this.f6067o;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String getDisplayName() {
        return this.f6068p;
    }

    public String getEmail() {
        return this.f6067o;
    }

    public String getFamilyName() {
        return this.f6075w;
    }

    public String getGivenName() {
        return this.f6074v;
    }

    public String getId() {
        return this.f6065m;
    }

    public String getIdToken() {
        return this.f6066n;
    }

    public Uri getPhotoUrl() {
        return this.f6069q;
    }

    @KeepForSdk
    public Set<Scope> getRequestedScopes() {
        HashSet hashSet = new HashSet(this.f6073u);
        hashSet.addAll(this.f6076x);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.f6070r;
    }

    public int hashCode() {
        return getRequestedScopes().hashCode() + c.b(this.f6072t, 527, 31);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6064b);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 4, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 5, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 6, getPhotoUrl(), i10, false);
        SafeParcelWriter.writeString(parcel, 7, getServerAuthCode(), false);
        SafeParcelWriter.writeLong(parcel, 8, this.f6071s);
        SafeParcelWriter.writeString(parcel, 9, this.f6072t, false);
        SafeParcelWriter.writeTypedList(parcel, 10, this.f6073u, false);
        SafeParcelWriter.writeString(parcel, 11, getGivenName(), false);
        SafeParcelWriter.writeString(parcel, 12, getFamilyName(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
