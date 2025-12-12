package zb;

import flix.com.vision.activities.player.WebPlayerActivity;

/* compiled from: WebPlayerActivity.java */
/* loaded from: classes2.dex */
public final class o implements sa.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebPlayerActivity f22677a;

    public o(WebPlayerActivity webPlayerActivity) {
        this.f22677a = webPlayerActivity;
    }

    @Override // sa.b
    public void onSuccess() {
        this.f22677a.X.setVisibility(0);
    }

    @Override // sa.b
    public void onError(Exception exc) {
    }
}
