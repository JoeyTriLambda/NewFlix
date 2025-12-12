package ub;

import android.view.View;
import flix.com.vision.App;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.activities.SeriesDetailActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20152b;

    public /* synthetic */ b(int i10) {
        this.f20152b = i10;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f20152b) {
            case 0:
                int i10 = AnimeDetailActivity.f11584e0;
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.3f).scaleY(1.3f).start();
                    break;
                }
            case 1:
                int i11 = DramaDetailActivity.f11610b0;
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.3f).scaleY(1.3f).start();
                    break;
                }
            case 2:
                int i12 = SeriesDetailActivity.f11800h0;
                break;
            case 3:
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    break;
                }
            case 4:
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    break;
                }
            case 5:
                if (!z10) {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                        break;
                    }
                } else if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    break;
                }
                break;
            case 6:
                if (!z10) {
                    o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                    break;
                } else {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    break;
                }
            default:
                if (!z10) {
                    if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                        o1.a.c(view, 0.0f, 0.0f, 0.0f, 1.0f).scaleY(1.0f).start();
                        break;
                    }
                } else if (App.getInstance().f11574v.getBoolean("pref_adult_zone_animate", true)) {
                    o1.a.c(view, 20.0f, 20.0f, 20.0f, 1.1f).scaleY(1.1f).start();
                    break;
                }
                break;
        }
    }
}
