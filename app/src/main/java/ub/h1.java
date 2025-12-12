package ub;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.activities.SettingsActivity;
import io.github.giangpham96.expandable_textview.ExpandableTextView;
import java.util.ArrayList;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class h1 implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20194b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ MovieDetailActivity f20195m;

    public /* synthetic */ h1(MovieDetailActivity movieDetailActivity, int i10) {
        this.f20194b = i10;
        this.f20195m = movieDetailActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20194b;
        MovieDetailActivity movieDetailActivity = this.f20195m;
        switch (i10) {
            case 0:
                movieDetailActivity.I0.setEnabled(false);
                new Handler().postDelayed(new g1(movieDetailActivity, 6), 2000L);
                String str = movieDetailActivity.f11756o1;
                if (str != null && str.length() != 0) {
                    if (!movieDetailActivity.isYoutubeInstall()) {
                        movieDetailActivity.e();
                        break;
                    } else {
                        movieDetailActivity.watchYoutubeVideo(movieDetailActivity.getBaseContext(), movieDetailActivity.f11756o1);
                        break;
                    }
                } else {
                    Toast.makeText(movieDetailActivity.getBaseContext(), "No Trailer Found!", 0).show();
                    break;
                }
            case 1:
                boolean zIsSeries = movieDetailActivity.N0.isSeries();
                ArrayList<hd.j> arrayList = movieDetailActivity.f11750l1;
                if (!zIsSeries) {
                    if (!movieDetailActivity.f11758p1) {
                        if (movieDetailActivity.N0.f12405w == null) {
                            be.d.makeToast(movieDetailActivity, "This Movie Is Not Yet Released", true);
                            break;
                        } else {
                            be.d.makeToastLong(movieDetailActivity, "This Movie Is Not Yet Released \nRelease Date: " + movieDetailActivity.f11760q1, true);
                            break;
                        }
                    } else {
                        movieDetailActivity.I0.setEnabled(false);
                        new Handler().postDelayed(new g1(movieDetailActivity, 5), 1000L);
                        Intent intent = new Intent(movieDetailActivity, (Class<?>) LinksActivity.class);
                        intent.putExtra("movie", movieDetailActivity.N0);
                        intent.putParcelableArrayListExtra("seasons", arrayList);
                        intent.putExtra("mini_poster", movieDetailActivity.N0.getImage_url());
                        intent.putExtra("plot", movieDetailActivity.N0.getPlot());
                        movieDetailActivity.startActivity(intent);
                        break;
                    }
                } else {
                    Intent intent2 = new Intent(movieDetailActivity, (Class<?>) SeriesDetailActivity.class);
                    intent2.putExtra("movie", movieDetailActivity.N0);
                    intent2.putParcelableArrayListExtra("seasons", new ArrayList<>(arrayList));
                    movieDetailActivity.N0.f12401s = new ArrayList<>();
                    movieDetailActivity.startActivity(intent2);
                    break;
                }
            case 2:
                ExpandableTextView expandableTextView = movieDetailActivity.O0;
                if (expandableTextView != null) {
                    expandableTextView.toggle();
                    break;
                }
                break;
            case 3:
                int i11 = MovieDetailActivity.f11726u1;
                movieDetailActivity.getClass();
                movieDetailActivity.startActivityForResult(new Intent(movieDetailActivity, (Class<?>) SettingsActivity.class), 1100);
                break;
            case 4:
                int i12 = MovieDetailActivity.f11726u1;
                movieDetailActivity.getClass();
                try {
                    if (App.getInstance().f11573u.isMovieFavorited(movieDetailActivity.N0)) {
                        App.getInstance().f11573u.deleteFavoriteMovie(movieDetailActivity.N0);
                        movieDetailActivity.f11749l0 = false;
                        ic.a.Success(movieDetailActivity.getApplicationContext(), "Removed from your List", null, 48, 0);
                    } else {
                        App.getInstance().f11573u.addMovieFavorites(movieDetailActivity.N0);
                        movieDetailActivity.f11749l0 = true;
                        ic.a.Success(movieDetailActivity.getApplicationContext(), "Added to your List", null, 48, 0);
                    }
                } catch (Exception unused) {
                }
                if (!movieDetailActivity.f11749l0) {
                    movieDetailActivity.f11732c1.setImageResource(R.drawable.ic_bookmark);
                    break;
                } else {
                    movieDetailActivity.f11732c1.setImageResource(R.drawable.ic_delete_bookmark);
                    break;
                }
            case 5:
                movieDetailActivity.Y0.setText("PLAY");
                LinearLayout linearLayout = movieDetailActivity.Q;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                movieDetailActivity.f11730b1.setImageResource(R.drawable.ic_play);
                movieDetailActivity.M0.setVisibility(8);
                App.getInstance().f11573u.markAsWatched(movieDetailActivity.N0);
                if (movieDetailActivity.N0.isSeries()) {
                    App.getInstance().f11574v.edit().remove(movieDetailActivity.N0.getMovieId() + "watched_season_index").apply();
                    try {
                        SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
                        int i13 = 0;
                        while (true) {
                            ArrayList<hd.j> arrayList2 = movieDetailActivity.f11750l1;
                            if (i13 < arrayList2.size()) {
                                int i14 = 0;
                                while (i14 < arrayList2.get(i13).f13014n) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(movieDetailActivity.N0.getMovieId());
                                    sb2.append("");
                                    sb2.append(i13 + 1);
                                    sb2.append("");
                                    i14++;
                                    sb2.append(i14);
                                    String string = sb2.toString();
                                    if (App.getInstance().f11574v.contains(string)) {
                                        editorEdit.remove(string);
                                    }
                                }
                                i13++;
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                App.getInstance().f11566n = true;
                try {
                    ic.a.Success(movieDetailActivity.getApplicationContext(), "Marked as Watched", null, 48, 0);
                    break;
                } catch (Exception unused3) {
                    return;
                }
            default:
                int i15 = MovieDetailActivity.f11726u1;
                movieDetailActivity.getClass();
                if (App.K && !App.getInstance().f11574v.getBoolean("pref_classic_search", false)) {
                    movieDetailActivity.startActivity(new Intent(movieDetailActivity, (Class<?>) SearchActivityTV.class));
                    break;
                } else {
                    movieDetailActivity.G0.openSearch();
                    break;
                }
                break;
        }
    }
}
