package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@SafeParcelable.Class
/* loaded from: classes.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: w, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f6077w = new Scope("profile");

    /* renamed from: x, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f6078x;

    /* renamed from: y, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f6079y;

    /* renamed from: z, reason: collision with root package name */
    @VisibleForTesting
    public static final Scope f6080z;

    /* renamed from: b, reason: collision with root package name */
    @SafeParcelable.VersionField
    public final int f6081b;

    /* renamed from: m, reason: collision with root package name */
    @SafeParcelable.Field
    public final ArrayList<Scope> f6082m;

    /* renamed from: n, reason: collision with root package name */
    @SafeParcelable.Field
    public final Account f6083n;

    /* renamed from: o, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6084o;

    /* renamed from: p, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6085p;

    /* renamed from: q, reason: collision with root package name */
    @SafeParcelable.Field
    public final boolean f6086q;

    /* renamed from: r, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6087r;

    /* renamed from: s, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6088s;

    /* renamed from: t, reason: collision with root package name */
    @SafeParcelable.Field
    public final ArrayList<GoogleSignInOptionsExtensionParcelable> f6089t;

    /* renamed from: u, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f6090u;

    /* renamed from: v, reason: collision with root package name */
    public final Map<Integer, GoogleSignInOptionsExtensionParcelable> f6091v;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f6092a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f6093b = new HashMap();

        public GoogleSignInOptions build() {
            HashSet hashSet = this.f6092a;
            if (hashSet.contains(GoogleSignInOptions.f6080z)) {
                Scope scope = GoogleSignInOptions.f6079y;
                if (hashSet.contains(scope)) {
                    hashSet.remove(scope);
                }
            }
            return new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, this.f6093b, null);
        }

        public Builder requestId() {
            this.f6092a.add(GoogleSignInOptions.f6078x);
            return this;
        }

        public Builder requestProfile() {
            this.f6092a.add(GoogleSignInOptions.f6077w);
            return this;
        }

        public Builder requestScopes(Scope scope, Scope... scopeArr) {
            HashSet hashSet = this.f6092a;
            hashSet.add(scope);
            hashSet.addAll(Arrays.asList(scopeArr));
            return this;
        }
    }

    static {
        new Scope("email");
        f6078x = new Scope("openid");
        Scope scope = new Scope("https://www.googleapis.com/auth/games_lite");
        f6079y = scope;
        f6080z = new Scope("https://www.googleapis.com/auth/games");
        Builder builder = new Builder();
        builder.requestId();
        builder.requestProfile();
        builder.build();
        Builder builder2 = new Builder();
        builder2.requestScopes(scope, new Scope[0]);
        builder2.build();
        CREATOR = new zae();
        new zac();
    }

    @SafeParcelable.Constructor
    public GoogleSignInOptions() {
        throw null;
    }

    public GoogleSignInOptions(int i10, ArrayList arrayList, Account account, boolean z10, boolean z11, boolean z12, String str, String str2, HashMap map, String str3) {
        this.f6081b = i10;
        this.f6082m = arrayList;
        this.f6083n = account;
        this.f6084o = z10;
        this.f6085p = z11;
        this.f6086q = z12;
        this.f6087r = str;
        this.f6088s = str2;
        this.f6089t = new ArrayList<>(map.values());
        this.f6091v = map;
        this.f6090u = str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050 A[Catch: ClassCastException -> 0x008c, TryCatch #0 {ClassCastException -> 0x008c, blocks: (B:5:0x0008, B:7:0x0012, B:10:0x001c, B:12:0x002a, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0050, B:30:0x0066, B:32:0x006e, B:34:0x0076, B:36:0x007e, B:27:0x005b, B:20:0x0040), top: B:42:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b A[Catch: ClassCastException -> 0x008c, TryCatch #0 {ClassCastException -> 0x008c, blocks: (B:5:0x0008, B:7:0x0012, B:10:0x001c, B:12:0x002a, B:15:0x0035, B:17:0x0039, B:22:0x004a, B:24:0x0050, B:30:0x0066, B:32:0x006e, B:34:0x0076, B:36:0x007e, B:27:0x005b, B:20:0x0040), top: B:42:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.String r0 = r5.f6087r
            java.util.ArrayList<com.google.android.gms.common.api.Scope> r1 = r5.f6082m
            r2 = 0
            if (r6 != 0) goto L8
            return r2
        L8:
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r6 = (com.google.android.gms.auth.api.signin.GoogleSignInOptions) r6     // Catch: java.lang.ClassCastException -> L8c
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r3 = r5.f6089t     // Catch: java.lang.ClassCastException -> L8c
            int r3 = r3.size()     // Catch: java.lang.ClassCastException -> L8c
            if (r3 > 0) goto L8c
            java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r3 = r6.f6089t     // Catch: java.lang.ClassCastException -> L8c
            int r3 = r3.size()     // Catch: java.lang.ClassCastException -> L8c
            if (r3 <= 0) goto L1c
            goto L8c
        L1c:
            int r3 = r1.size()     // Catch: java.lang.ClassCastException -> L8c
            java.util.ArrayList r4 = r6.getScopes()     // Catch: java.lang.ClassCastException -> L8c
            int r4 = r4.size()     // Catch: java.lang.ClassCastException -> L8c
            if (r3 != r4) goto L8c
            java.util.ArrayList r3 = r6.getScopes()     // Catch: java.lang.ClassCastException -> L8c
            boolean r1 = r1.containsAll(r3)     // Catch: java.lang.ClassCastException -> L8c
            if (r1 != 0) goto L35
            goto L8c
        L35:
            android.accounts.Account r1 = r5.f6083n     // Catch: java.lang.ClassCastException -> L8c
            if (r1 != 0) goto L40
            android.accounts.Account r1 = r6.getAccount()     // Catch: java.lang.ClassCastException -> L8c
            if (r1 != 0) goto L8c
            goto L4a
        L40:
            android.accounts.Account r3 = r6.getAccount()     // Catch: java.lang.ClassCastException -> L8c
            boolean r1 = r1.equals(r3)     // Catch: java.lang.ClassCastException -> L8c
            if (r1 == 0) goto L8c
        L4a:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.ClassCastException -> L8c
            if (r1 == 0) goto L5b
            java.lang.String r0 = r6.getServerClientId()     // Catch: java.lang.ClassCastException -> L8c
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.ClassCastException -> L8c
            if (r0 == 0) goto L8c
            goto L66
        L5b:
            java.lang.String r1 = r6.getServerClientId()     // Catch: java.lang.ClassCastException -> L8c
            boolean r0 = r0.equals(r1)     // Catch: java.lang.ClassCastException -> L8c
            if (r0 != 0) goto L66
            goto L8c
        L66:
            boolean r0 = r5.f6086q     // Catch: java.lang.ClassCastException -> L8c
            boolean r1 = r6.isForceCodeForRefreshToken()     // Catch: java.lang.ClassCastException -> L8c
            if (r0 != r1) goto L8c
            boolean r0 = r5.f6084o     // Catch: java.lang.ClassCastException -> L8c
            boolean r1 = r6.isIdTokenRequested()     // Catch: java.lang.ClassCastException -> L8c
            if (r0 != r1) goto L8c
            boolean r0 = r5.f6085p     // Catch: java.lang.ClassCastException -> L8c
            boolean r1 = r6.isServerAuthCodeRequested()     // Catch: java.lang.ClassCastException -> L8c
            if (r0 != r1) goto L8c
            java.lang.String r0 = r5.f6090u     // Catch: java.lang.ClassCastException -> L8c
            java.lang.String r6 = r6.getLogSessionId()     // Catch: java.lang.ClassCastException -> L8c
            boolean r6 = android.text.TextUtils.equals(r0, r6)     // Catch: java.lang.ClassCastException -> L8c
            if (r6 == 0) goto L8c
            r6 = 1
            return r6
        L8c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.GoogleSignInOptions.equals(java.lang.Object):boolean");
    }

    @KeepForSdk
    public Account getAccount() {
        return this.f6083n;
    }

    @KeepForSdk
    public ArrayList<GoogleSignInOptionsExtensionParcelable> getExtensions() {
        return this.f6089t;
    }

    @KeepForSdk
    public String getLogSessionId() {
        return this.f6090u;
    }

    @KeepForSdk
    public ArrayList<Scope> getScopes() {
        return new ArrayList<>(this.f6082m);
    }

    @KeepForSdk
    public String getServerClientId() {
        return this.f6087r;
    }

    public int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList<Scope> arrayList2 = this.f6082m;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(arrayList2.get(i10).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.addObject(arrayList);
        hashAccumulator.addObject(this.f6083n);
        hashAccumulator.addObject(this.f6087r);
        hashAccumulator.zaa(this.f6086q);
        hashAccumulator.zaa(this.f6084o);
        hashAccumulator.zaa(this.f6085p);
        hashAccumulator.addObject(this.f6090u);
        return hashAccumulator.hash();
    }

    @KeepForSdk
    public boolean isForceCodeForRefreshToken() {
        return this.f6086q;
    }

    @KeepForSdk
    public boolean isIdTokenRequested() {
        return this.f6084o;
    }

    @KeepForSdk
    public boolean isServerAuthCodeRequested() {
        return this.f6085p;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f6081b);
        SafeParcelWriter.writeTypedList(parcel, 2, getScopes(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getAccount(), i10, false);
        SafeParcelWriter.writeBoolean(parcel, 4, isIdTokenRequested());
        SafeParcelWriter.writeBoolean(parcel, 5, isServerAuthCodeRequested());
        SafeParcelWriter.writeBoolean(parcel, 6, isForceCodeForRefreshToken());
        SafeParcelWriter.writeString(parcel, 7, getServerClientId(), false);
        SafeParcelWriter.writeString(parcel, 8, this.f6088s, false);
        SafeParcelWriter.writeTypedList(parcel, 9, getExtensions(), false);
        SafeParcelWriter.writeString(parcel, 10, getLogSessionId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
