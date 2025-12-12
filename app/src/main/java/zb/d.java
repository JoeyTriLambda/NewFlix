package zb;

import android.view.View;
import flix.com.vision.activities.player.PlayerActivityLiveTV;

/* compiled from: PlayerActivityLiveTV.java */
/* loaded from: classes2.dex */
public final class d implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PlayerActivityLiveTV f22659b;

    public d(PlayerActivityLiveTV playerActivityLiveTV) {
        this.f22659b = playerActivityLiveTV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f22659b.finish();
    }
}
