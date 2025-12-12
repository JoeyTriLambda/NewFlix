package kb;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: ScarAdBase.java */
/* loaded from: classes2.dex */
public abstract class a<T> implements bb.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15036a;

    /* renamed from: b, reason: collision with root package name */
    public final bb.c f15037b;

    /* renamed from: c, reason: collision with root package name */
    public final QueryInfo f15038c;

    /* renamed from: d, reason: collision with root package name */
    public b f15039d;

    /* renamed from: e, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.c f15040e;

    public a(Context context, bb.c cVar, QueryInfo queryInfo, com.unity3d.scar.adapter.common.c cVar2) {
        this.f15036a = context;
        this.f15037b = cVar;
        this.f15038c = queryInfo;
        this.f15040e = cVar2;
    }

    public void loadAd(bb.b bVar) {
        bb.c cVar = this.f15037b;
        QueryInfo queryInfo = this.f15038c;
        if (queryInfo == null) {
            this.f15040e.handleError(com.unity3d.scar.adapter.common.b.QueryNotFoundError(cVar));
            return;
        }
        AdRequest adRequestBuild = new AdRequest.Builder().setAdInfo(new AdInfo(queryInfo, cVar.getAdString())).build();
        this.f15039d.setLoadListener(bVar);
        loadAdInternal(adRequestBuild, bVar);
    }

    public abstract void loadAdInternal(AdRequest adRequest, bb.b bVar);
}
