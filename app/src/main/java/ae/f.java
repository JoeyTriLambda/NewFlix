package ae;

import flix.com.vision.tv.PlayerActivityLiveExternal;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f647b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ PlayerActivityLiveExternal f648m;

    public /* synthetic */ f(PlayerActivityLiveExternal playerActivityLiveExternal, int i10) {
        this.f647b = i10;
        this.f648m = playerActivityLiveExternal;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f647b;
        PlayerActivityLiveExternal playerActivityLiveExternal = this.f648m;
        switch (i10) {
            case 0:
                playerActivityLiveExternal.f12472g0 = false;
                break;
            default:
                playerActivityLiveExternal.playChannel(playerActivityLiveExternal.U);
                break;
        }
    }
}
