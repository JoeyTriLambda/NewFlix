package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaaw implements zabf {

    /* renamed from: a, reason: collision with root package name */
    public ConnectionResult f7158a;

    /* renamed from: b, reason: collision with root package name */
    public int f7159b;

    /* renamed from: c, reason: collision with root package name */
    public int f7160c;

    /* renamed from: d, reason: collision with root package name */
    public int f7161d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.gms.signin.zae f7162e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7163f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7164g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7165h;

    /* renamed from: i, reason: collision with root package name */
    public IAccountAccessor f7166i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7167j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7168k;

    public final void a() {
        this.f7164g = false;
        throw null;
    }

    public final void b(boolean z10) {
        com.google.android.gms.signin.zae zaeVar = this.f7162e;
        if (zaeVar != null) {
            if (zaeVar.isConnected() && z10) {
                zaeVar.zaa();
            }
            zaeVar.disconnect();
            this.f7166i = null;
        }
    }

    public final void c() {
        throw null;
    }

    public final void d(ConnectionResult connectionResult) {
        throw null;
    }

    public final void e(ConnectionResult connectionResult, Api<?> api, boolean z10) {
        int priority = api.zac().getPriority();
        if (z10 && !connectionResult.hasResolution()) {
            connectionResult.getErrorCode();
            throw null;
        }
        if (this.f7158a == null || priority < this.f7159b) {
            this.f7158a = connectionResult;
            this.f7159b = priority;
        }
        throw null;
    }

    public final void f() {
        if (this.f7161d != 0) {
            return;
        }
        if (!this.f7164g || this.f7165h) {
            new ArrayList();
            this.f7160c = 1;
            throw null;
        }
    }

    public final boolean g(int i10) {
        if (this.f7160c == i10) {
            return true;
        }
        throw null;
    }

    public final boolean h() {
        int i10 = this.f7161d - 1;
        this.f7161d = i10;
        if (i10 > 0) {
            return false;
        }
        if (i10 < 0) {
            throw null;
        }
        if (this.f7158a == null) {
            return true;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zad() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zag(Bundle bundle) {
        if (g(1)) {
            if (bundle != null) {
                throw null;
            }
            if (h()) {
                c();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zah(ConnectionResult connectionResult, Api<?> api, boolean z10) {
        if (g(1)) {
            e(connectionResult, api, z10);
            if (h()) {
                c();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final void zai(int i10) {
        d(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zabf
    public final boolean zaj() {
        throw null;
    }
}
