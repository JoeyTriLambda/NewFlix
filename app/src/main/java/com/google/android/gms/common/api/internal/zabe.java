package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.ClientLibraryUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zabe extends GoogleApiClient implements zabz {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f7170c = 0;

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f7171a;

    /* renamed from: b, reason: collision with root package name */
    public Set<Scope> f7172b;

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println((Object) null);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f7171a);
        printWriter.append(" mWorkQueue.size()=");
        throw null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t10) {
        t10.getApi();
        t10.getClientKey();
        throw null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper getLooper() {
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zaa(ConnectionResult connectionResult) {
        connectionResult.getErrorCode();
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zab(Bundle bundle) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void zac(int i10, boolean z10) {
        if (i10 != 1 || z10 || this.f7171a) {
            throw null;
        }
        this.f7171a = true;
        if (!ClientLibraryUtils.isPackageSide()) {
            throw null;
        }
        throw null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zao(zada zadaVar) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void zap(zada zadaVar) {
        throw null;
    }
}
