package ac;

import ac.d0;
import ac.f;
import ac.k;
import ac.n;
import ac.t;
import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.r0;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.models.Drama;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.ChannelsListActivityImport;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class e implements View.OnLongClickListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f432b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f433m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f434n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.z f435o;

    public /* synthetic */ e(RecyclerView.Adapter adapter, int i10, RecyclerView.z zVar, int i11) {
        this.f432b = i11;
        this.f434n = adapter;
        this.f433m = i10;
        this.f435o = zVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i10 = this.f432b;
        final int i11 = this.f433m;
        RecyclerView.z zVar = this.f435o;
        RecyclerView.Adapter adapter = this.f434n;
        switch (i10) {
            case 0:
                f fVar = (f) adapter;
                f.a aVar = (f.a) zVar;
                Activity activity = fVar.f445e;
                if (!(activity instanceof AdultHistoryActivity)) {
                    if (!(activity instanceof AdultVideosFavoritesActivity)) {
                        try {
                            r0 r0Var = new r0(activity, aVar.A);
                            id.c cVar = aVar.f447u;
                            if (App.getInstance().f11573u.isAdultVideoFavorited(cVar)) {
                                r0Var.getMenuInflater().inflate(R.menu.context_menu_remove_fav_channels, r0Var.getMenu());
                            } else {
                                r0Var.getMenuInflater().inflate(R.menu.context_menu_add_fav_channels, r0Var.getMenu());
                            }
                            r0Var.setOnMenuItemClickListener(new q2.b(6, fVar, cVar, r0Var));
                            r0Var.show();
                            break;
                        } catch (Exception unused) {
                            break;
                        }
                    } else {
                        ((AdultVideosFavoritesActivity) activity).onFavoritesLongPress(i11);
                        break;
                    }
                } else {
                    ((AdultHistoryActivity) activity).onHistoryLongPress(i11);
                    break;
                }
            case 1:
                k kVar = (k) adapter;
                k.b bVar = (k.b) zVar;
                ChannelsListActivityImport channelsListActivityImport = kVar.f490g;
                if (channelsListActivityImport == null) {
                    r0 r0Var2 = new r0(kVar.f489f, bVar.f494v);
                    hd.d dVar = bVar.f493u;
                    if (App.getInstance().f11573u.isChannelFavorited(dVar)) {
                        r0Var2.getMenuInflater().inflate(R.menu.context_menu_remove_fav_channels, r0Var2.getMenu());
                    } else {
                        r0Var2.getMenuInflater().inflate(R.menu.context_menu_add_fav_channels, r0Var2.getMenu());
                    }
                    r0Var2.setOnMenuItemClickListener(new q2.b(8, kVar, dVar, r0Var2));
                    r0Var2.show();
                    break;
                } else {
                    channelsListActivityImport.channelLongPress(i11, kVar.f491h);
                    break;
                }
            case 2:
                n nVar = (n) adapter;
                nVar.getClass();
                Drama drama = ((n.a) zVar).f518u;
                nVar.f516e.onContinueLongPress(i11);
                break;
            case 3:
                final t tVar = (t) adapter;
                t.b bVar2 = (t.b) zVar;
                tVar.getClass();
                final r0 r0Var3 = new r0(tVar.f562h, bVar2.f572w);
                final Movie movie = bVar2.f570u;
                if (App.getInstance().f11573u.isMovieFavorited(movie)) {
                    r0Var3.getMenuInflater().inflate(R.menu.context_menu_remove_fav_channels, r0Var3.getMenu());
                } else {
                    r0Var3.getMenuInflater().inflate(R.menu.context_menu_add_fav_channels, r0Var3.getMenu());
                }
                r0Var3.setOnMenuItemClickListener(new r0.c() { // from class: ac.s
                    @Override // androidx.appcompat.widget.r0.c
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        t tVar2 = tVar;
                        tVar2.getClass();
                        int itemId = menuItem.getItemId();
                        Movie movie2 = movie;
                        Context context = tVar2.f559e;
                        if (itemId == R.id.action_add_favorites_live_tv) {
                            App.getInstance().f11573u.addMovieFavorites(movie2);
                            Toast.makeText(context, context.getString(R.string.added_fav_label), 0).show();
                        }
                        if (menuItem.getItemId() == R.id.action_remove_favorites_live_tv) {
                            App.getInstance().f11573u.deleteFavoriteMovie(movie2);
                            Toast.makeText(context, context.getString(R.string.removed_fav_label), 0).show();
                            tVar2.f558d.favoriteDeleted(i11);
                        }
                        r0Var3.dismiss();
                        return true;
                    }
                });
                r0Var3.show();
                break;
            default:
                ((d0) adapter).f418g.showLongPressDialog(((d0.b) zVar).f426u, i11);
                break;
        }
        return true;
        return true;
    }

    public /* synthetic */ e(RecyclerView.Adapter adapter, RecyclerView.z zVar, int i10, int i11) {
        this.f432b = i11;
        this.f434n = adapter;
        this.f435o = zVar;
        this.f433m = i10;
    }
}
