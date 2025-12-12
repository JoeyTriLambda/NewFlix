package ub;

import flix.com.vision.App;
import flix.com.vision.activities.CastMoviesActivity;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class l implements se.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20221b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ CastMoviesActivity f20222m;

    public /* synthetic */ l(CastMoviesActivity castMoviesActivity, int i10) {
        this.f20221b = i10;
        this.f20222m = castMoviesActivity;
    }

    @Override // se.f
    public final void accept(Object obj) {
        int i10 = this.f20221b;
        int i11 = 1;
        CastMoviesActivity castMoviesActivity = this.f20222m;
        switch (i10) {
            case 0:
                int i12 = CastMoviesActivity.f11604f0;
                castMoviesActivity.getClass();
                ArrayList<Movie> castMovies = JsonUtils.parseCastMovies((com.google.gson.o) obj, 0);
                ArrayList<Movie> arrayList = castMoviesActivity.M;
                arrayList.addAll(App.getInstance().filterList(castMovies));
                castMoviesActivity.Q.setText("Movies · " + arrayList.size());
                if (arrayList.size() > 0) {
                    castMoviesActivity.f11605a0.notifyDataSetChanged();
                    ArrayList<Movie> arrayList2 = castMoviesActivity.N;
                    arrayList2.clear();
                    arrayList2.addAll(arrayList);
                }
                bc.a.getDetailCast(castMoviesActivity, "tv_credits", castMoviesActivity.S, false).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new l(castMoviesActivity, i11), new u8.a(26));
                break;
            default:
                int i13 = CastMoviesActivity.f11604f0;
                castMoviesActivity.getClass();
                ArrayList<Movie> castMovies2 = JsonUtils.parseCastMovies((com.google.gson.o) obj, 1);
                ArrayList<Movie> arrayList3 = castMoviesActivity.O;
                arrayList3.addAll(App.getInstance().filterList(castMovies2));
                castMoviesActivity.R.setText("Series · " + arrayList3.size());
                if (castMoviesActivity.M.size() == 0 && arrayList3.size() > 0) {
                    castMoviesActivity.f11605a0.notifyDataSetChanged();
                    ArrayList<Movie> arrayList4 = castMoviesActivity.N;
                    arrayList4.clear();
                    arrayList4.addAll(arrayList3);
                    break;
                }
                break;
        }
    }
}
