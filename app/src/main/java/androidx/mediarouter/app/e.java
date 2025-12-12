package androidx.mediarouter.app;

import a2.n;
import androidx.mediarouter.app.OverlayListView;

/* compiled from: MediaRouteControllerDialog.java */
/* loaded from: classes.dex */
public final class e implements OverlayListView.a.InterfaceC0034a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n.g f3624a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3625b;

    public e(h hVar, n.g gVar) {
        this.f3625b = hVar;
        this.f3624a = gVar;
    }

    public void onAnimationEnd() {
        h hVar = this.f3625b;
        hVar.W.remove(this.f3624a);
        hVar.S.notifyDataSetChanged();
    }
}
