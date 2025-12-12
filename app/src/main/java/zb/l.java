package zb;

import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: SimpleVideoPlayer.java */
/* loaded from: classes2.dex */
public final class l implements sa.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimpleVideoPlayer f22672a;

    public l(SimpleVideoPlayer simpleVideoPlayer) {
        this.f22672a = simpleVideoPlayer;
    }

    @Override // sa.b
    public void onError(Exception exc) {
        this.f22672a.f11986e1 = false;
    }

    @Override // sa.b
    public void onSuccess() {
        this.f22672a.f11986e1 = true;
    }
}
