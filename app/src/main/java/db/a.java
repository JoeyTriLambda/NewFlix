package db;

import android.content.Context;
import cb.g;
import com.google.android.gms.ads.query.QueryInfo;
import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.e;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.j;
import eb.d;

/* compiled from: ScarAdapter.java */
/* loaded from: classes2.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public final g<QueryInfo> f10971e;

    /* compiled from: ScarAdapter.java */
    /* renamed from: db.a$a, reason: collision with other inner class name */
    public class RunnableC0127a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ eb.b f10972b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: db.a$a$a, reason: collision with other inner class name */
        public class C0128a implements bb.b {
        }

        public RunnableC0127a(eb.b bVar) {
            this.f10972b = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10972b.loadAd(new C0128a());
        }
    }

    /* compiled from: ScarAdapter.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f10973b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: db.a$b$a, reason: collision with other inner class name */
        public class C0129a implements bb.b {
        }

        public b(d dVar) {
            this.f10973b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f10973b.loadAd(new C0129a());
        }
    }

    public a(c<j> cVar) {
        super(cVar);
        g<QueryInfo> gVar = new g<>();
        this.f10971e = gVar;
        this.f10671a = new fb.b(gVar);
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadInterstitialAd(Context context, bb.c cVar, e eVar) {
        i.runOnUiThread(new RunnableC0127a(new eb.b(context, this.f10971e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, eVar)));
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadRewardedAd(Context context, bb.c cVar, f fVar) {
        i.runOnUiThread(new b(new d(context, this.f10971e.getQueryInfo(cVar.getPlacementId()), cVar, this.f10674d, fVar)));
    }
}
