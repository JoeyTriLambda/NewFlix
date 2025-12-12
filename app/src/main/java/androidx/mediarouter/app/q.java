package androidx.mediarouter.app;

import android.view.View;
import androidx.mediarouter.app.p;

/* compiled from: MediaRouteDynamicControllerDialog.java */
/* loaded from: classes.dex */
public final class q implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p.h.c f3783b;

    public q(p.h.c cVar) {
        this.f3783b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p.h.c cVar = this.f3783b;
        p.this.f3729q.transferToRoute(cVar.f3772z);
        cVar.f3768v.setVisibility(4);
        cVar.f3769w.setVisibility(0);
    }
}
