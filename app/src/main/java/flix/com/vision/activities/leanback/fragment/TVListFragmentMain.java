package flix.com.vision.activities.leanback.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.leanback.widget.d;
import androidx.leanback.widget.f0;
import androidx.leanback.widget.j0;
import androidx.leanback.widget.m;
import androidx.leanback.widget.m0;
import androidx.leanback.widget.u;
import androidx.leanback.widget.v;
import c1.c;
import com.google.gson.o;
import flix.com.vision.App;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.utils.JsonUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import r.x;
import se.f;
import ub.n0;

/* loaded from: classes2.dex */
public class TVListFragmentMain extends androidx.leanback.app.b {
    public static final /* synthetic */ int T0 = 0;
    public ArrayList<Movie> C0;
    public ArrayList<Movie> D0;
    public ArrayList<Movie> E0;
    public ArrayList<Movie> F0;
    public ArrayList<Movie> G0;
    public ArrayList<Movie> H0;
    public ArrayList<Movie> I0;
    public ArrayList<Movie> J0;
    public ArrayList<Movie> K0;
    public ArrayList<Movie> L0;
    public ArrayList<Movie> M0;
    public ContentTypeLB N0;
    public flix.com.vision.activities.leanback.fragment.a O0;
    public final androidx.leanback.widget.a P0;
    public boolean Q0;
    public androidx.leanback.widget.a R0;
    public boolean S0;

    public enum ContentTypeLB {
        HOME,
        MOVIES,
        TV_SHOWS,
        /* JADX INFO: Fake field, exist only in values array */
        GENRES
    }

    public enum GenresType {
        COMEDY,
        ANIMATION,
        CRIME,
        ACTION,
        ROMANCE,
        HORROR
    }

    public enum RequestType {
        MOVIE,
        TV_SHOW
    }

    public class a implements d {
        public a() {
        }

        public void onItemSelected(f0.a aVar, Object obj, m0.b bVar, j0 j0Var) {
            flix.com.vision.activities.leanback.fragment.a aVar2;
            boolean z10 = obj instanceof Movie;
            TVListFragmentMain tVListFragmentMain = TVListFragmentMain.this;
            if (z10) {
                flix.com.vision.activities.leanback.fragment.a aVar3 = tVListFragmentMain.O0;
                if (aVar3 != null) {
                    aVar3.onMovieSelected((Movie) obj);
                    return;
                }
                return;
            }
            if (!(obj instanceof ld.a) || (aVar2 = tVListFragmentMain.O0) == null) {
                return;
            }
            aVar2.onNetworkSelected((ld.a) obj);
        }
    }

    public TVListFragmentMain(ContentTypeLB contentTypeLB) {
        this.Q0 = false;
        this.S0 = false;
        this.N0 = contentTypeLB;
        v vVar = new v(2);
        vVar.enableChildRoundedCorners(true);
        this.P0 = new androidx.leanback.widget.a(vVar);
    }

    public void getContinueContent() {
        androidx.leanback.widget.a aVar;
        if (App.getInstance().f11574v.getBoolean("pref_hide_continue", false) || (aVar = this.P0) == null) {
            return;
        }
        try {
            ArrayList<Movie> watchingMoviesFromDb = App.getInstance().f11573u.getWatchingMoviesFromDb();
            if (watchingMoviesFromDb != null && watchingMoviesFromDb.size() != 0) {
                this.Q0 = true;
                this.R0 = new androidx.leanback.widget.a(new nd.b(watchingMoviesFromDb, getActivity(), this));
                Iterator<Movie> it = watchingMoviesFromDb.iterator();
                while (it.hasNext()) {
                    this.R0.add(it.next());
                }
                u uVar = new u(new m("Continue Watching"), this.R0);
                uVar.setId(999L);
                if (this.N0 == ContentTypeLB.HOME) {
                    aVar.add(0, uVar);
                } else {
                    aVar.add(uVar);
                }
                new Handler().postDelayed(new yb.a(this, 2), 1000L);
            }
        } catch (Exception unused) {
        }
    }

    public void markAsWatched(Movie movie) {
        reloadWatchedHistory();
        int i10 = -1;
        for (int i11 = 0; i11 < this.R0.size(); i11++) {
            if (((Movie) this.R0.get(i11)).getMovieId() == movie.getMovieId()) {
                i10 = i11;
            }
        }
        if (i10 > -1) {
            this.R0.remove(Integer.valueOf(i10));
            this.R0.notifyItemRangeChanged(0, 1);
            androidx.leanback.widget.a aVar = this.R0;
            aVar.notifyArrayItemRangeChanged(0, aVar.size());
            androidx.leanback.widget.a aVar2 = this.R0;
            aVar2.notifyItemRangeChanged(0, aVar2.size());
        }
    }

    @Override // androidx.leanback.app.b, androidx.leanback.app.a, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setAdapter(this.P0);
        setOnItemViewSelectedListener(new a());
        setOnItemViewClickedListener(new c(this, 21));
        if (this.N0 == null) {
            this.N0 = ContentTypeLB.HOME;
        }
        int iOrdinal = this.N0.ordinal();
        RequestType requestType = RequestType.TV_SHOW;
        RequestType requestType2 = RequestType.MOVIE;
        int i10 = 1;
        if (iOrdinal == 0) {
            getContinueContent();
            s();
            q(requestType2, "Trending", 0, 1);
            q(requestType, "Trending", 0, 1);
            q(requestType2, "Now Playing", 1, 1);
            q(requestType, "Now Playing", 1, 1);
            q(requestType2, "Popular", 2, 1);
            q(requestType, "Popular", 2, 1);
            q(requestType2, "Top Rated", 3, 1);
            q(requestType, "Top Rated", 3, 1);
            q(requestType2, "Upcoming", 4, 1);
            q(requestType2, "Upcoming", 4, 2);
        } else if (iOrdinal == 1) {
            q(requestType2, "Trending", 0, 1);
            q(requestType2, "Trending", 0, 2);
            q(requestType2, "Now Playing", 1, 1);
            q(requestType2, "Now Playing", 1, 2);
            q(requestType2, "Popular", 2, 1);
            q(requestType2, "Popular", 2, 2);
            q(requestType2, "Top Rated", 3, 1);
            q(requestType2, "Top Rated", 3, 2);
            q(requestType2, "Upcoming", 4, 1);
            q(requestType2, "Upcoming", 4, 2);
        } else if (iOrdinal == 2) {
            s();
            q(requestType, "Trending", 0, 1);
            q(requestType, "Trending", 0, 2);
            q(requestType, "Now Playing", 1, 1);
            q(requestType, "Now Playing", 1, 2);
            q(requestType, "Popular", 2, 1);
            q(requestType, "Popular", 2, 2);
            q(requestType, "Top Rated", 3, 1);
            q(requestType, "Top Rated", 3, 2);
        } else if (iOrdinal == 3) {
            GenresType genresType = GenresType.HORROR;
            r(27, "Horror", 1, genresType);
            r(27, "Horror", 2, genresType);
            GenresType genresType2 = GenresType.ACTION;
            r(28, "Action", 1, genresType2);
            r(28, "Action", 2, genresType2);
            GenresType genresType3 = GenresType.CRIME;
            r(80, "Crime", 1, genresType3);
            r(80, "Crime", 2, genresType3);
            GenresType genresType4 = GenresType.ROMANCE;
            r(10749, "Romance", 1, genresType4);
            r(10749, "Romance", 2, genresType4);
            GenresType genresType5 = GenresType.COMEDY;
            r(35, "Comedy", 1, genresType5);
            r(35, "Comedy", 2, genresType5);
            GenresType genresType6 = GenresType.ANIMATION;
            r(16, "Animation", 1, genresType6);
            r(16, "Animation", 2, genresType6);
        }
        new Handler().postDelayed(new yb.a(this, i10), 1000L);
    }

    @SuppressLint({"CheckResult"})
    public final void q(RequestType requestType, final String str, final int i10, int i11) {
        if (this.P0 == null) {
            return;
        }
        RequestType requestType2 = RequestType.MOVIE;
        final int i12 = requestType == requestType2 ? 0 : 1;
        bc.a.gettabbedList(getContext(), i11, requestType == requestType2 ? "movie" : "tv", i10).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new f() { // from class: yb.b
            @Override // se.f
            public final void accept(Object obj) {
                int i13 = TVListFragmentMain.T0;
                TVListFragmentMain tVListFragmentMain = this.f22048b;
                tVListFragmentMain.getClass();
                ArrayList<Movie> listMovie = JsonUtils.parseListMovie((o) obj, i12);
                int i14 = i10;
                boolean z10 = false;
                if (i14 == 0) {
                    if (tVListFragmentMain.C0 == null) {
                        tVListFragmentMain.C0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.C0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.C0);
                        tVListFragmentMain.C0.clear();
                    }
                } else if (i14 == 1) {
                    if (tVListFragmentMain.G0 == null) {
                        tVListFragmentMain.G0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.G0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.G0);
                        tVListFragmentMain.G0.clear();
                    }
                } else if (i14 == 2) {
                    if (tVListFragmentMain.D0 == null) {
                        tVListFragmentMain.D0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.D0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.D0);
                        tVListFragmentMain.D0.clear();
                    }
                } else if (i14 == 3) {
                    if (tVListFragmentMain.E0 == null) {
                        tVListFragmentMain.E0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.E0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.E0);
                        tVListFragmentMain.E0.clear();
                    }
                } else if (i14 == 4) {
                    if (tVListFragmentMain.F0 == null) {
                        tVListFragmentMain.F0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.F0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.F0);
                        tVListFragmentMain.F0.clear();
                    }
                }
                if (z10) {
                    if (i14 != 4 && tVListFragmentMain.N0 == TVListFragmentMain.ContentTypeLB.HOME) {
                        Collections.shuffle(listMovie);
                    }
                    androidx.leanback.widget.a aVar = new androidx.leanback.widget.a(new nd.d());
                    Iterator<Movie> it = listMovie.iterator();
                    while (it.hasNext()) {
                        aVar.add(it.next());
                    }
                    u uVar = new u(new m(str), aVar);
                    androidx.leanback.widget.a aVar2 = tVListFragmentMain.P0;
                    if (i14 == 0 && aVar2.size() > 1 && tVListFragmentMain.Q0) {
                        aVar2.add(2, uVar);
                    } else if (i14 != 0 || aVar2.size() <= 1) {
                        aVar2.add(uVar);
                    } else {
                        aVar2.add(2, uVar);
                    }
                    if (tVListFragmentMain.S0) {
                        return;
                    }
                    tVListFragmentMain.S0 = true;
                    new Handler().postDelayed(new a(tVListFragmentMain, 3), 1000L);
                }
            }
        }, new n0(25));
    }

    @SuppressLint({"CheckResult"})
    public final void r(int i10, final String str, int i11, final GenresType genresType) {
        if (this.P0 == null) {
            return;
        }
        bc.a.getItemsByGenresLeanBack(getContext(), i10 + "", i11, 0, "popularity.desc", false).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new f(this) { // from class: flix.com.vision.activities.leanback.fragment.b

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ TVListFragmentMain f11958b;

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TVListFragmentMain.RequestType f11959m;

            {
                TVListFragmentMain.RequestType requestType = TVListFragmentMain.RequestType.MOVIE;
                this.f11958b = this;
                this.f11959m = requestType;
            }

            @Override // se.f
            public final void accept(Object obj) {
                o oVar = (o) obj;
                int i12 = TVListFragmentMain.T0;
                TVListFragmentMain tVListFragmentMain = this.f11958b;
                tVListFragmentMain.getClass();
                boolean z10 = false;
                ArrayList<Movie> listMovie = JsonUtils.parseListMovie(oVar, this.f11959m == TVListFragmentMain.RequestType.MOVIE ? 0 : 1);
                int iOrdinal = genresType.ordinal();
                if (iOrdinal == 0) {
                    if (tVListFragmentMain.H0 == null) {
                        tVListFragmentMain.H0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.H0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.H0);
                        tVListFragmentMain.H0.clear();
                    }
                } else if (iOrdinal == 1) {
                    if (tVListFragmentMain.L0 == null) {
                        tVListFragmentMain.L0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.L0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.L0);
                        tVListFragmentMain.L0.clear();
                    }
                } else if (iOrdinal == 2) {
                    if (tVListFragmentMain.M0 == null) {
                        tVListFragmentMain.M0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.M0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.M0);
                        tVListFragmentMain.M0.clear();
                    }
                } else if (iOrdinal == 3) {
                    if (tVListFragmentMain.K0 == null) {
                        tVListFragmentMain.K0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.K0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.K0);
                        tVListFragmentMain.K0.clear();
                    }
                } else if (iOrdinal == 4) {
                    if (tVListFragmentMain.J0 == null) {
                        tVListFragmentMain.J0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.J0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.J0);
                        tVListFragmentMain.J0.clear();
                    }
                } else if (iOrdinal == 5) {
                    if (tVListFragmentMain.I0 == null) {
                        tVListFragmentMain.I0 = new ArrayList<>();
                    } else {
                        z10 = true;
                    }
                    tVListFragmentMain.I0.addAll(listMovie);
                    if (z10) {
                        listMovie.clear();
                        listMovie.addAll(tVListFragmentMain.I0);
                        tVListFragmentMain.I0.clear();
                    }
                }
                if (z10) {
                    androidx.leanback.widget.a aVar = new androidx.leanback.widget.a(new nd.d());
                    Iterator<Movie> it = listMovie.iterator();
                    while (it.hasNext()) {
                        aVar.add(it.next());
                    }
                    u uVar = new u(new m(str), aVar);
                    androidx.leanback.widget.a aVar2 = tVListFragmentMain.P0;
                    if (aVar2 != null) {
                        aVar2.add(uVar);
                    }
                    if (tVListFragmentMain.S0) {
                        return;
                    }
                    tVListFragmentMain.S0 = true;
                    new Handler().postDelayed(new yb.a(tVListFragmentMain, 4), 1000L);
                }
            }
        }, new n0(26));
    }

    public void reloadWatchedHistory() {
        androidx.leanback.widget.a aVar;
        if (this.N0 != ContentTypeLB.HOME || (aVar = this.P0) == null || aVar.size() <= 0) {
            return;
        }
        int i10 = 0;
        u uVar = (u) aVar.get(0);
        if (uVar.getId() == 999) {
            aVar.remove(uVar);
        }
        getContinueContent();
        new Handler().postDelayed(new yb.a(this, i10), 500L);
    }

    public final void s() {
        ArrayList<ld.a> networks = Constants.getNetworks();
        if (networks.size() == 0) {
            return;
        }
        try {
            androidx.leanback.widget.a aVar = new androidx.leanback.widget.a(new nd.c(networks));
            Iterator<ld.a> it = networks.iterator();
            while (it.hasNext()) {
                aVar.add(it.next());
            }
            u uVar = new u(new m("Popular Services"), aVar);
            uVar.setId(888L);
            boolean z10 = this.Q0;
            androidx.leanback.widget.a aVar2 = this.P0;
            if (z10 && aVar2 != null) {
                new Handler().postDelayed(new x(23, this, uVar), 1000L);
            } else if (aVar2 != null) {
                aVar2.add(0, uVar);
            }
        } catch (Exception unused) {
        }
    }

    public void setOnContentSelectedListener(flix.com.vision.activities.leanback.fragment.a aVar) {
        this.O0 = aVar;
    }

    public TVListFragmentMain() {
        this.N0 = ContentTypeLB.HOME;
        this.Q0 = false;
        this.S0 = false;
    }
}
