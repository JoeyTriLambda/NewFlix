package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import b0.d;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@VisibleForTesting
@KeepForSdk
/* loaded from: classes.dex */
public final class ClientSettings {

    /* renamed from: a, reason: collision with root package name */
    public final Account f7307a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<Scope> f7308b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Scope> f7309c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Api<?>, zab> f7310d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7311e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7312f;

    /* renamed from: g, reason: collision with root package name */
    public final SignInOptions f7313g;

    /* renamed from: h, reason: collision with root package name */
    public Integer f7314h;

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @KeepForSdk
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Account f7315a;

        /* renamed from: b, reason: collision with root package name */
        public d<Scope> f7316b;

        /* renamed from: c, reason: collision with root package name */
        public String f7317c;

        /* renamed from: d, reason: collision with root package name */
        public String f7318d;

        /* renamed from: e, reason: collision with root package name */
        public final SignInOptions f7319e = SignInOptions.f8640b;

        @KeepForSdk
        public ClientSettings build() {
            return new ClientSettings(this.f7315a, this.f7316b, null, 0, null, this.f7317c, this.f7318d, this.f7319e, false);
        }

        @KeepForSdk
        public Builder setRealClientPackageName(String str) {
            this.f7317c = str;
            return this;
        }

        public final Builder zaa(Collection<Scope> collection) {
            if (this.f7316b == null) {
                this.f7316b = new d<>();
            }
            this.f7316b.addAll(collection);
            return this;
        }

        public final Builder zab(Account account) {
            this.f7315a = account;
            return this;
        }

        public final Builder zac(String str) {
            this.f7318d = str;
            return this;
        }
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, zab> map, int i10, View view, String str, String str2, SignInOptions signInOptions, boolean z10) {
        this.f7307a = account;
        Set<Scope> setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f7308b = setEmptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f7310d = map;
        this.f7311e = str;
        this.f7312f = str2;
        this.f7313g = signInOptions == null ? SignInOptions.f8640b : signInOptions;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator<zab> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().getClass();
            hashSet.addAll(null);
        }
        this.f7309c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    public Account getAccount() {
        return this.f7307a;
    }

    @KeepForSdk
    public Account getAccountOrDefault() {
        Account account = this.f7307a;
        return account != null ? account : new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
    }

    @KeepForSdk
    public Set<Scope> getAllRequestedScopes() {
        return this.f7309c;
    }

    @KeepForSdk
    public String getRealClientPackageName() {
        return this.f7311e;
    }

    @KeepForSdk
    public Set<Scope> getRequiredScopes() {
        return this.f7308b;
    }

    public final SignInOptions zaa() {
        return this.f7313g;
    }

    public final Integer zab() {
        return this.f7314h;
    }

    public final String zac() {
        return this.f7312f;
    }

    public final Map<Api<?>, zab> zad() {
        return this.f7310d;
    }

    public final void zae(Integer num) {
        this.f7314h = num;
    }
}
