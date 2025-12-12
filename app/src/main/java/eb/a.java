package eb;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: ScarAdBase.java */
/* loaded from: classes2.dex */
public abstract class a implements bb.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11186a;

    /* renamed from: b, reason: collision with root package name */
    public final bb.c f11187b;

    /* renamed from: c, reason: collision with root package name */
    public final QueryInfo f11188c;

    /* renamed from: d, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.c f11189d;

    public a(Context context, bb.c cVar, QueryInfo queryInfo, com.unity3d.scar.adapter.common.c cVar2) {
        this.f11186a = context;
        this.f11187b = cVar;
        this.f11188c = queryInfo;
        this.f11189d = cVar2;
    }

    public void loadAd(bb.b bVar) {
        bb.c cVar = this.f11187b;
        QueryInfo queryInfo = this.f11188c;
        if (queryInfo == null) {
            this.f11189d.handleError(com.unity3d.scar.adapter.common.b.QueryNotFoundError(cVar));
        } else {
            loadAdInternal(bVar, new AdRequest.Builder().setAdInfo(new AdInfo(queryInfo, cVar.getAdString())).build());
        }
    }

    public abstract void loadAdInternal(bb.b bVar, AdRequest adRequest);
}
