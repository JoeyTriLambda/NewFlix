package ub;

import android.util.Log;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.player.SimpleVideoPlayer;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class m0 implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20231b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ hd.o f20232m;

    public /* synthetic */ m0(int i10, hd.o oVar) {
        this.f20231b = i10;
        this.f20232m = oVar;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20231b;
        hd.o oVar = this.f20232m;
        switch (i10) {
            case 0:
                int i11 = LinksActivity.C0;
                Log.d(MainActivity.class.toString(), oVar.C, (Throwable) obj);
                break;
            default:
                int i12 = SimpleVideoPlayer.f11976g1;
                Log.d(MainActivity.class.toString(), oVar.C, (Throwable) obj);
                break;
        }
    }
}
