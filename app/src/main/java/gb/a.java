package gb;

import android.content.Context;
import cb.g;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.e;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.j;
import hb.d;

/* compiled from: ScarAdapter.java */
/* loaded from: classes2.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public final g<QueryInfo> f12815e;

    /* compiled from: ScarAdapter.java */
    /* renamed from: gb.a$a, reason: collision with other inner class name */
    public class RunnableC0154a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ hb.b f12816b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: gb.a$a$a, reason: collision with other inner class name */
        public class C0155a implements bb.b {
        }

        public RunnableC0154a(hb.b bVar) {
            this.f12816b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12816b.loadAd(new C0155a());
        }
    }

    /* compiled from: ScarAdapter.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f12817b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: gb.a$b$a, reason: collision with other inner class name */
        public class C0156a implements bb.b {
        }

        public b(d dVar) {
            this.f12817b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f12817b.loadAd(new C0156a());
        }
    }

    public a(c<j> cVar) {
        super(cVar);
        g<QueryInfo> gVar = new g<>();
        this.f12815e = gVar;
        this.f10671a = new ib.b(gVar);
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadInterstitialAd(Context context, bb.c cVar, e eVar) {
        i.runOnUiThread(new RunnableC0154a(new hb.b(context, this.f12815e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, eVar)));
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadRewardedAd(Context context, bb.c cVar, f fVar) {
        i.runOnUiThread(new b(new d(context, this.f12815e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, fVar)));
    }
}
