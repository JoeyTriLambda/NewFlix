package com.traffmonetizer.sdk;

import a.A;
import a.t;
import a.u;
import a.v;
import a.w;
import a.x;
import a.y;
import a.z;
import android.content.Context;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;
import androidx.lifecycle.l;
import com.ptrbrynt.kotlin_bloc.core.Bloc;
import k.h;
import lf.e;
import lh.a;
import ng.g;
import qb.m;
import qb.o;
import yh.b;
import zf.i;

/* loaded from: classes2.dex */
public final class TraffmonetizerSdkImpl implements c, a {

    /* renamed from: b, reason: collision with root package name */
    public final p000if.a f10647b;

    /* renamed from: m, reason: collision with root package name */
    public Lifecycle f10648m;

    /* renamed from: n, reason: collision with root package name */
    public final e f10649n;

    /* renamed from: o, reason: collision with root package name */
    public final e f10650o;

    /* renamed from: p, reason: collision with root package name */
    public final e f10651p;

    public TraffmonetizerSdkImpl(Context context, p000if.a aVar) {
        i.checkNotNullParameter(context, "context");
        i.checkNotNullParameter(aVar, "defaultConfig");
        this.f10647b = aVar;
        t tVar = new t(context, this);
        b bVar = b.f22543a;
        e eVarLazy = kotlin.a.lazy(bVar.defaultLazyMode(), new w(this, tVar));
        this.f10649n = eVarLazy;
        this.f10650o = kotlin.a.lazy(bVar.defaultLazyMode(), new x(this, new u(context)));
        kotlin.a.lazy(bVar.defaultLazyMode(), new y(this, new A(this)));
        this.f10651p = kotlin.a.lazy(bVar.defaultLazyMode(), new z(this, new v(this)));
        Bloc.f10406r.setObserver(new k3.a());
        g gVar = k.c.f14701a;
        k.c.a("SDK", "SDK version = " + ((p000if.a) ((p000if.b) eVarLazy.getValue()).f13438a.getValue()).f13435h);
    }

    public final void a() {
        e eVar = this.f10651p;
        if (((h) eVar.getValue()).f14711q) {
            g gVar = k.c.f14701a;
            i.checkNotNullParameter("SDK", "tag");
            i.checkNotNullParameter("Already started!", "message");
            k.c.f14701a.setValue(new k.b(System.currentTimeMillis(), "SDK: ".concat("Already started!")));
            Log.e("SDK", "Already started!");
            return;
        }
        k.c.a("SDK", "start: ");
        ((kf.b) this.f10650o.getValue()).b();
        h hVar = (h) eVar.getValue();
        hVar.f14711q = true;
        ((qb.h) hVar.f14710p.getValue()).add(m.f18066a);
    }

    @Override // lh.a
    public final kh.a getKoin() {
        return a.C0191a.getKoin(this);
    }

    @Override // androidx.lifecycle.c
    public final void onCreate(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        androidx.lifecycle.b.a(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final void onDestroy(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        androidx.lifecycle.b.b(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onPause(l lVar) {
        androidx.lifecycle.b.c(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final /* synthetic */ void onResume(l lVar) {
        androidx.lifecycle.b.d(this, lVar);
    }

    @Override // androidx.lifecycle.c
    public final void onStart(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        androidx.lifecycle.b.e(this, lVar);
        a();
    }

    @Override // androidx.lifecycle.c
    public final void onStop(l lVar) {
        i.checkNotNullParameter(lVar, "owner");
        androidx.lifecycle.b.f(this, lVar);
        k.c.a("SDK", "stop: ");
        ((kf.b) this.f10650o.getValue()).c();
        h hVar = (h) this.f10651p.getValue();
        ((qb.h) hVar.f14710p.getValue()).add(o.f18068a);
        hVar.f14711q = false;
    }
}
