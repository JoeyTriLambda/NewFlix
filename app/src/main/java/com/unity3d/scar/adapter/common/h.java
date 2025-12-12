package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ScarAdapterBase.java */
/* loaded from: classes2.dex */
public abstract class h implements d {

    /* renamed from: a, reason: collision with root package name */
    public cb.e f10671a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f10672b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    public bb.a f10673c;

    /* renamed from: d, reason: collision with root package name */
    public final c<j> f10674d;

    /* compiled from: ScarAdapterBase.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f10675b;

        public a(Activity activity) {
            this.f10675b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f10673c.show(this.f10675b);
        }
    }

    public h(c<j> cVar) {
        this.f10674d = cVar;
    }

    public void getSCARBiddingSignals(Context context, cb.b bVar) {
        this.f10671a.getSCARBiddingSignals(context, bVar);
    }

    public void getSCARSignals(Context context, String[] strArr, String[] strArr2, cb.b bVar) {
        this.f10671a.getSCARSignals(context, strArr, strArr2, bVar);
    }

    public void show(Activity activity, String str, String str2) {
        bb.a aVar = (bb.a) this.f10672b.get(str2);
        if (aVar != null) {
            this.f10673c = aVar;
            i.runOnUiThread(new a(activity));
            return;
        }
        this.f10674d.handleError(b.NoAdsError(str2, str, "Could not find ad for placement '" + str2 + "'."));
    }
}
