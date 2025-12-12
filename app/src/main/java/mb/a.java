package mb;

import android.content.Context;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.i;
import com.unity3d.scar.adapter.common.j;
import ob.c;
import ob.e;

/* compiled from: ScarAdapter.java */
/* loaded from: classes2.dex */
public final class a extends h {

    /* renamed from: e, reason: collision with root package name */
    public final nb.a f16259e;

    /* compiled from: ScarAdapter.java */
    /* renamed from: mb.a$a, reason: collision with other inner class name */
    public class RunnableC0198a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f16260b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: mb.a$a$a, reason: collision with other inner class name */
        public class C0199a implements bb.b {
        }

        public RunnableC0198a(c cVar) {
            this.f16260b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16260b.loadAd(new C0199a());
        }
    }

    /* compiled from: ScarAdapter.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f16261b;

        /* compiled from: ScarAdapter.java */
        /* renamed from: mb.a$b$a, reason: collision with other inner class name */
        public class C0200a implements bb.b {
        }

        public b(e eVar) {
            this.f16261b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f16261b.loadAd(new C0200a());
        }
    }

    public a(com.unity3d.scar.adapter.common.c<j> cVar, String str) {
        super(cVar);
        nb.a aVar = new nb.a(new ab.a(str));
        this.f16259e = aVar;
        this.f10671a = new pb.b(aVar);
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadInterstitialAd(Context context, bb.c cVar, com.unity3d.scar.adapter.common.e eVar) {
        i.runOnUiThread(new RunnableC0198a(new c(context, this.f16259e, cVar, this.f10674d, eVar)));
    }

    @Override // com.unity3d.scar.adapter.common.d
    public void loadRewardedAd(Context context, bb.c cVar, f fVar) {
        i.runOnUiThread(new b(new e(context, this.f16259e, cVar, this.f10674d, fVar)));
    }
}
