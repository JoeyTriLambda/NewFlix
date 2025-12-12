package ub;

import ac.i;
import ac.o;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.WatchedAcvivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.models.Drama;
import flix.com.vision.models.Movie;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f20283b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f20284m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f20285n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f20286o;

    public /* synthetic */ u(RecyclerView.Adapter adapter, int i10, RecyclerView.z zVar, int i11) {
        this.f20283b = i11;
        this.f20285n = adapter;
        this.f20284m = i10;
        this.f20286o = zVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f20283b;
        int i11 = this.f20284m;
        Object obj = this.f20286o;
        Object obj2 = this.f20285n;
        switch (i10) {
            case 0:
                DramaHomeActivity dramaHomeActivity = (DramaHomeActivity) obj2;
                Drama drama = (Drama) obj;
                int i12 = DramaHomeActivity.f11619x0;
                dramaHomeActivity.getClass();
                App.getInstance().f11573u.deletDramaFromContinue(drama);
                App.getInstance().f11573u.addDramaToHistory(drama);
                dramaHomeActivity.Z.remove(i11);
                be.d.makeToast(dramaHomeActivity, "Marked as watched", true);
                dramaHomeActivity.f11639t0.notifyItemRemoved(i11);
                break;
            case 1:
                MainActivity mainActivity = (MainActivity) obj2;
                int i13 = MainActivity.f11697v0;
                mainActivity.getClass();
                App.getInstance().f11573u.markAsWatched((Movie) obj);
                mainActivity.K.remove(i11);
                be.d.makeToast(mainActivity, "Marked as watched", true);
                mainActivity.M.notifyItemRemoved(i11);
                break;
            case 2:
                WatchedAcvivity watchedAcvivity = (WatchedAcvivity) obj2;
                Movie movie = (Movie) obj;
                int i14 = WatchedAcvivity.P;
                watchedAcvivity.getClass();
                App.getInstance().f11573u.removeFromWaching(movie);
                be.d.makeToast(watchedAcvivity, "Removed", true);
                watchedAcvivity.N.remove(i11);
                watchedAcvivity.O.notifyItemRemoved(i11);
                App.getInstance().f11573u.removeFromWatched(movie);
                break;
            case 3:
                AdultHistoryActivity adultHistoryActivity = (AdultHistoryActivity) obj2;
                int i15 = AdultHistoryActivity.X;
                adultHistoryActivity.getClass();
                App.getInstance().f11573u.deleteAdultFromHistory((id.c) obj);
                adultHistoryActivity.R.remove(i11);
                be.d.makeToast(adultHistoryActivity, "Deleted from History", true);
                adultHistoryActivity.T.notifyItemRemoved(i11);
                break;
            case 4:
                AdultVideosFavoritesActivity adultVideosFavoritesActivity = (AdultVideosFavoritesActivity) obj2;
                int i16 = AdultVideosFavoritesActivity.X;
                adultVideosFavoritesActivity.getClass();
                App.getInstance().f11573u.deleteAdultFromFavorites((id.c) obj);
                adultVideosFavoritesActivity.R.remove(i11);
                be.d.makeToast(adultVideosFavoritesActivity, "Deleted from Favorites", true);
                adultVideosFavoritesActivity.T.notifyItemRemoved(i11);
                break;
            case 5:
                ((ac.i) obj2).f471g.openEpisode(i11);
                ((i.a) obj).f472u.toString().getClass();
                break;
            default:
                ((ac.o) obj2).f527g.openEpisode(i11);
                ((o.a) obj).f528u.toString().getClass();
                break;
        }
    }

    public /* synthetic */ u(wb.a aVar, Object obj, int i10, int i11) {
        this.f20283b = i11;
        this.f20285n = aVar;
        this.f20286o = obj;
        this.f20284m = i10;
    }
}
