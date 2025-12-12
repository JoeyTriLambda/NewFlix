package ub;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import flix.com.vision.R;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class i1 implements View.OnFocusChangeListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20202b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MovieDetailActivity f20203m;

    public /* synthetic */ i1(MovieDetailActivity movieDetailActivity, int i10) {
        this.f20202b = i10;
        this.f20203m = movieDetailActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        int i10 = this.f20202b;
        MovieDetailActivity movieDetailActivity = this.f20203m;
        switch (i10) {
            case 0:
                if (!z10) {
                    movieDetailActivity.M.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    break;
                } else {
                    movieDetailActivity.M.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    break;
                }
            case 1:
                if (!z10) {
                    movieDetailActivity.N.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    break;
                } else {
                    movieDetailActivity.N.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    break;
                }
            case 2:
                if (!z10) {
                    movieDetailActivity.f11730b1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    movieDetailActivity.Y0.setTextColor(movieDetailActivity.getResources().getColor(R.color.white));
                    movieDetailActivity.I0.animate().scaleX(1.0f).start();
                    movieDetailActivity.I0.animate().scaleY(1.0f).start();
                    break;
                } else {
                    movieDetailActivity.f11730b1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    movieDetailActivity.Y0.setTextColor(movieDetailActivity.getResources().getColor(R.color.black));
                    movieDetailActivity.I0.animate().setDuration(100L).scaleX(1.03f).start();
                    movieDetailActivity.I0.animate().setDuration(100L).scaleY(1.03f).start();
                    break;
                }
            case 3:
                if (!z10) {
                    movieDetailActivity.Z0.setTextColor(movieDetailActivity.getResources().getColor(R.color.white));
                    o1.a.k(movieDetailActivity.L0, 100L, 1.0f);
                    o1.a.r(movieDetailActivity.L0, 100L, 1.0f);
                    break;
                } else {
                    movieDetailActivity.Z0.setTextColor(movieDetailActivity.getResources().getColor(R.color.black));
                    o1.a.k(movieDetailActivity.L0, 100L, 1.03f);
                    o1.a.r(movieDetailActivity.L0, 100L, 1.03f);
                    break;
                }
            case 4:
                if (!z10) {
                    movieDetailActivity.f11732c1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                    o1.a.k(movieDetailActivity.K0, 100L, 1.0f);
                    o1.a.r(movieDetailActivity.K0, 100L, 1.0f);
                    break;
                } else {
                    movieDetailActivity.f11732c1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    o1.a.k(movieDetailActivity.K0, 100L, 1.02f);
                    o1.a.r(movieDetailActivity.K0, 100L, 1.02f);
                    break;
                }
            default:
                if (!z10) {
                    movieDetailActivity.P.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.accent), PorterDuff.Mode.SRC_IN));
                    o1.a.k(movieDetailActivity.M0, 100L, 1.0f);
                    o1.a.r(movieDetailActivity.M0, 100L, 1.0f);
                    break;
                } else {
                    movieDetailActivity.P.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(movieDetailActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                    o1.a.k(movieDetailActivity.M0, 100L, 1.02f);
                    o1.a.r(movieDetailActivity.M0, 100L, 1.02f);
                    break;
                }
        }
    }
}
