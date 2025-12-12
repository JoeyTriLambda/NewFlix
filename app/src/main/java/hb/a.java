package hb;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* compiled from: ScarAdBase.java */
/* loaded from: classes2.dex */
public abstract class a implements bb.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12957a;

    /* renamed from: b, reason: collision with root package name */
    public final bb.c f12958b;

    /* renamed from: c, reason: collision with root package name */
    public final QueryInfo f12959c;

    /* renamed from: d, reason: collision with root package name */
    public final com.unity3d.scar.adapter.common.c f12960d;

    public a(Context context, bb.c cVar, QueryInfo queryInfo, com.unity3d.scar.adapter.common.c cVar2) {
        this.f12957a = context;
        this.f12958b = cVar;
        this.f12959c = queryInfo;
        this.f12960d = cVar2;
    }

    public void loadAd(bb.b bVar) {
        bb.c cVar = this.f12958b;
        QueryInfo queryInfo = this.f12959c;
        if (queryInfo == null) {
            this.f12960d.handleError(com.unity3d.scar.adapter.common.b.QueryNotFoundError(cVar));
        } else {
            loadAdInternal(bVar, new AdRequest.Builder().setAdInfo(new AdInfo(queryInfo, cVar.getAdString())).build());
        }
    }

    public abstract void loadAdInternal(bb.b bVar, AdRequest adRequest);
}
