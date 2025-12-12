package zb;

import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: SimpleVideoPlayer.java */
/* loaded from: classes2.dex */
public final class i implements sa.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22669a;

    public i(SimpleVideoPlayer simpleVideoPlayer) {
        this.f22669a = simpleVideoPlayer;
    }

    @Override // sa.b
    public void onSuccess() {
        this.f22669a.f11996n0.setVisibility(0);
    }

    @Override // sa.b
    public void onError(Exception exc) {
    }
}
