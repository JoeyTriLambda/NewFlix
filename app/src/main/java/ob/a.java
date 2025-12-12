package ob;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;

/* compiled from: ScarAdBase.java */
/* loaded from: classes2.dex */
public abstract class a<T> implements bb.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f17064a;

    /* renamed from: b, reason: collision with root package name */
    public final bb.c f17065b;

    /* renamed from: c, reason: collision with root package name */
    public final nb.a f17066c;

    /* renamed from: d, reason: collision with root package name */
    public b f17067d;

    /* renamed from: e, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.c f17068e;

    public a(Context context, bb.c cVar, nb.a aVar, com.unity3d.scar.adapter.common.c cVar2) {
        this.f17064a = context;
        this.f17065b = cVar;
        this.f17066c = aVar;
        this.f17068e = cVar2;
    }

    public void loadAd(bb.b bVar) {
        AdRequest adRequestBuildAdRequestWithAdString = this.f17066c.buildAdRequestWithAdString(this.f17065b.getAdString());
        this.f17067d.setLoadListener(bVar);
        loadAdInternal(adRequestBuildAdRequestWithAdString, bVar);
    }

    public abstract void loadAdInternal(AdRequest adRequest, bb.b bVar);
}
