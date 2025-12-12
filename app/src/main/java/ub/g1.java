package ub;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MovieDetailActivity;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20186b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MovieDetailActivity f20187m;

    public /* synthetic */ g1(MovieDetailActivity movieDetailActivity, int i10) {
        this.f20186b = i10;
        this.f20187m = movieDetailActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f20186b;
        MovieDetailActivity movieDetailActivity = this.f20187m;
        switch (i10) {
            case 0:
                movieDetailActivity.f11747k0.fullScroll(33);
                movieDetailActivity.f11747k0.setVisibility(0);
                movieDetailActivity.R.setVisibility(8);
                movieDetailActivity.I0.requestFocus();
                break;
            case 1:
                if (movieDetailActivity.J0.getVisibility() != 0) {
                    movieDetailActivity.J0.setVisibility(0);
                    movieDetailActivity.J0.startAnimation(movieDetailActivity.f11743i0);
                }
                LinearLayout linearLayout = movieDetailActivity.T;
                if (linearLayout != null && App.K) {
                    linearLayout.setVisibility(0);
                    break;
                }
                break;
            case 2:
                int i11 = MovieDetailActivity.f11726u1;
                movieDetailActivity.getClass();
                try {
                    if (App.getInstance().f11573u.isMovieFavorited(movieDetailActivity.N0)) {
                        ImageView imageView = movieDetailActivity.f11732c1;
                        if (imageView != null) {
                            imageView.setImageResource(R.drawable.ic_delete_bookmark);
                        }
                        Menu menu = movieDetailActivity.f11752m1;
                        if (menu != null) {
                            menu.findItem(R.id.action_fav).setIcon(R.drawable.ic_action_favorite);
                            break;
                        }
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return;
                }
                break;
            case 3:
                ImageView imageView2 = movieDetailActivity.O;
                if (imageView2 != null && imageView2.getVisibility() != 0 && movieDetailActivity.f11764s1) {
                    movieDetailActivity.O.setVisibility(0);
                    movieDetailActivity.O.startAnimation(movieDetailActivity.f11743i0);
                    break;
                }
                break;
            case 4:
                movieDetailActivity.I0.requestFocus();
                break;
            case 5:
                movieDetailActivity.I0.setEnabled(true);
                break;
            case 6:
                movieDetailActivity.I0.setEnabled(true);
                break;
            case 7:
                movieDetailActivity.O.setVisibility(0);
                movieDetailActivity.O.startAnimation(movieDetailActivity.f11743i0);
                break;
            default:
                movieDetailActivity.f11766t1 = true;
                break;
        }
    }
}
