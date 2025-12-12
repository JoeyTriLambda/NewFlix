package ac;

import ac.c0;
import ac.h;
import ac.m;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.View;
import androidx.appcompat.widget.r0;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.models.Anime;
import flix.com.vision.models.Drama;
import flix.com.vision.models.Movie;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class g implements View.OnLongClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f453b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f454m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f455n;

    public /* synthetic */ g(int i10, Object obj, Object obj2) {
        this.f453b = i10;
        this.f454m = obj;
        this.f455n = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i10 = this.f453b;
        Object obj = this.f455n;
        Object obj2 = this.f454m;
        final int i11 = 1;
        switch (i10) {
            case 0:
                h hVar = (h) obj2;
                h.a aVar = (h.a) obj;
                hVar.getClass();
                r0 r0Var = new r0(hVar.f459g, aVar.f464w);
                Anime anime = aVar.f462u;
                if (App.getInstance().f11573u.isMovieFavorited_ANIME(anime.toMovie())) {
                    r0Var.getMenuInflater().inflate(R.menu.context_menu_remove_fav_channels, r0Var.getMenu());
                } else {
                    r0Var.getMenuInflater().inflate(R.menu.context_menu_add_fav_channels, r0Var.getMenu());
                }
                r0Var.setOnMenuItemClickListener(new q2.b(7, hVar, anime, r0Var));
                r0Var.show();
                break;
            case 1:
                m mVar = (m) obj2;
                m.a aVar2 = (m.a) obj;
                mVar.getClass();
                r0 r0Var2 = new r0(mVar.f507e, aVar2.f511w);
                Drama drama = aVar2.f509u;
                if (App.getInstance().f11573u.isDramaFavorited(drama)) {
                    r0Var2.getMenuInflater().inflate(R.menu.context_menu_remove_fav_channels, r0Var2.getMenu());
                } else {
                    r0Var2.getMenuInflater().inflate(R.menu.context_menu_add_fav_channels, r0Var2.getMenu());
                }
                r0Var2.setOnMenuItemClickListener(new y4.n(mVar, drama, aVar2, r0Var2));
                r0Var2.show();
                break;
            case 2:
                ((LinksActivity) ((c0) obj2).f401h).linkClicked(((c0.a) obj).f402u, true);
                break;
            default:
                final nd.b bVar = (nd.b) obj2;
                final Movie movie = (Movie) obj;
                Activity activity = bVar.f16805c;
                FragmentManager fragmentManager = activity.getFragmentManager();
                kc.d dVarNewInstance = kc.d.newInstance(activity, true);
                dVarNewInstance.setTitle(movie.getTitle());
                dVarNewInstance.setMessage("What would you like to Do?");
                final int i12 = 0;
                dVarNewInstance.setButton1("MARK AS WATCHED", new View.OnClickListener() { // from class: nd.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        int i13 = i12;
                        Movie movie2 = movie;
                        b bVar2 = bVar;
                        switch (i13) {
                            case 0:
                                bVar2.getClass();
                                App.getInstance().f11573u.markAsWatched(movie2);
                                be.d.makeToast(bVar2.f16805c, "Marked as watched", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                            case 1:
                                bVar2.getClass();
                                App.getInstance().f11573u.addMovieFavorites(movie2);
                                be.d.makeToast(bVar2.f16805c, "Added to Favorites", true);
                                break;
                            default:
                                bVar2.getClass();
                                App.getInstance().f11573u.removeFromWaching(movie2);
                                be.d.makeToast(bVar2.f16805c, "Removed", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                        }
                    }
                });
                dVarNewInstance.setButton2("ADD TO FAVORITES", new View.OnClickListener() { // from class: nd.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        int i13 = i11;
                        Movie movie2 = movie;
                        b bVar2 = bVar;
                        switch (i13) {
                            case 0:
                                bVar2.getClass();
                                App.getInstance().f11573u.markAsWatched(movie2);
                                be.d.makeToast(bVar2.f16805c, "Marked as watched", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                            case 1:
                                bVar2.getClass();
                                App.getInstance().f11573u.addMovieFavorites(movie2);
                                be.d.makeToast(bVar2.f16805c, "Added to Favorites", true);
                                break;
                            default:
                                bVar2.getClass();
                                App.getInstance().f11573u.removeFromWaching(movie2);
                                be.d.makeToast(bVar2.f16805c, "Removed", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                        }
                    }
                });
                final int i13 = 2;
                dVarNewInstance.setButton3("REMOVE", new View.OnClickListener() { // from class: nd.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        int i132 = i13;
                        Movie movie2 = movie;
                        b bVar2 = bVar;
                        switch (i132) {
                            case 0:
                                bVar2.getClass();
                                App.getInstance().f11573u.markAsWatched(movie2);
                                be.d.makeToast(bVar2.f16805c, "Marked as watched", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                            case 1:
                                bVar2.getClass();
                                App.getInstance().f11573u.addMovieFavorites(movie2);
                                be.d.makeToast(bVar2.f16805c, "Added to Favorites", true);
                                break;
                            default:
                                bVar2.getClass();
                                App.getInstance().f11573u.removeFromWaching(movie2);
                                be.d.makeToast(bVar2.f16805c, "Removed", true);
                                bVar2.f16806d.markAsWatched(movie2);
                                break;
                        }
                    }
                });
                try {
                    dVarNewInstance.show(fragmentManager, "");
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    break;
                }
        }
        return true;
        return false;
    }
}
