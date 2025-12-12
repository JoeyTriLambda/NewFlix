package jb;

import android.content.Context;
import cb.g;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.j;
import kb.c;
import kb.e;

/* compiled from: ScarAdapter.java */
/* loaded from: classes2.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public final g<QueryInfo> f14684e;

    /* compiled from: ScarAdapter.java */
    /* renamed from: jb.a$a, reason: collision with other inner class name */
    public class RunnableC0170a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f14685b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: jb.a$a$a, reason: collision with other inner class name */
        public class C0171a implements bb.b {
        }

        public RunnableC0170a(c cVar) {
            this.f14685b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14685b.loadAd(new C0171a());
        }
    }

    /* compiled from: ScarAdapter.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f14686b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: jb.a$b$a, reason: collision with other inner class name */
        public class C0172a implements bb.b {
        }

        public b(e eVar) {
            this.f14686b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14686b.loadAd(new C0172a());
        }
    }

    public a(com.unity3d.scar.adapter.common.c<j> cVar) {
        super(cVar);
        g<QueryInfo> gVar = new g<>();
        this.f14684e = gVar;
        this.f10671a = new lb.b(gVar);
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadInterstitialAd(Context context, bb.c cVar, com.unity3d.scar.adapter.common.e eVar) {
        i.runOnUiThread(new RunnableC0170a(new c(context, this.f14684e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, eVar)));
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadRewardedAd(Context context, bb.c cVar, f fVar) {
        i.runOnUiThread(new b(new e(context, this.f14684e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, fVar)));
    }
}
