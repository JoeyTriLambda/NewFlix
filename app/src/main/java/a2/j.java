package a2;

import a2.a;
import a2.i;
import java.util.Collection;

/* compiled from: MediaRouteProvider.java */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i.b.c f174b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ g f175m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Collection f176n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ i.b f177o;

    public j(i.b bVar, i.b.c cVar, g gVar, Collection collection) {
        this.f177o = bVar;
        this.f174b = cVar;
        this.f175m = gVar;
        this.f176n = collection;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((a.b) this.f174b).onRoutesChanged(this.f177o, this.f175m, this.f176n);
    }
}
