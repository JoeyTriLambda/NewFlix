package com.google.android.youtube.player.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.youtube.player.internal.f;
import com.google.android.youtube.player.internal.h;
import com.google.android.youtube.player.internal.i;

/* loaded from: classes.dex */
public final class g extends h<f> implements a8.b {

    /* renamed from: k, reason: collision with root package name */
    public final String f9571k;

    /* renamed from: l, reason: collision with root package name */
    public final String f9572l;

    /* renamed from: m, reason: collision with root package name */
    public final String f9573m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9574n;

    public g(Context context, String str, String str2, String str3, i.a aVar, i.b bVar) {
        super(context, aVar, bVar);
        this.f9571k = (String) a8.a.a(str);
        this.f9572l = a8.a.a(str2, (Object) "callingPackage cannot be null or empty");
        this.f9573m = a8.a.a(str3, (Object) "callingAppVersion cannot be null or empty");
    }

    @Override // a8.b
    public final IBinder a() {
        i();
        if (this.f9574n) {
            throw new IllegalStateException("Connection client has been released");
        }
        try {
            return j().a();
        } catch (RemoteException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // com.google.android.youtube.player.internal.h
    public final String b() {
        return "com.google.android.youtube.player.internal.IYouTubeService";
    }

    @Override // com.google.android.youtube.player.internal.h
    public final String c() {
        return "com.google.android.youtube.api.service.START";
    }

    @Override // com.google.android.youtube.player.internal.h, com.google.android.youtube.player.internal.i
    public final void d() {
        if (!this.f9574n) {
            a(true);
        }
        super.d();
    }

    @Override // com.google.android.youtube.player.internal.h
    public final /* synthetic */ IInterface a(IBinder iBinder) {
        return f.a.a(iBinder);
    }

    @Override // com.google.android.youtube.player.internal.h
    public final void a(e eVar, h.e eVar2) throws RemoteException {
        eVar.a(eVar2, 1202, this.f9572l, this.f9573m, this.f9571k, null);
    }

    @Override // a8.b
    public final void a(boolean z10) {
        if (f()) {
            try {
                j().a(z10);
            } catch (RemoteException unused) {
            }
            this.f9574n = true;
        }
    }
}
