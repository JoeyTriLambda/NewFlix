package flix.com.vision.activities;

import ac.c;
import ac.t;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.YouTubeWebviewActivity;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.j;
import io.github.giangpham96.expandable_textview.ExpandableTextView;
import java.util.ArrayList;
import me.grantland.widget.AutofitTextView;
import ub.f;
import ub.g1;
import ub.h1;
import ub.i1;
import ub.k1;
import ub.m1;
import ub.n0;
import ub.n1;

/* loaded from: classes2.dex */
public class MovieDetailActivity extends wb.a implements j {

    /* renamed from: u1, reason: collision with root package name */
    public static final /* synthetic */ int f11726u1 = 0;
    public qe.b A0;
    public qe.b B0;
    public qe.b C0;
    public qe.b D0;
    public qe.b E0;
    public qe.b F0;
    public MaterialSearchView G0;
    public Toolbar H0;
    public LinearLayout I0;
    public RelativeLayout J0;
    public ProgressBar K;
    public RelativeLayout K0;
    public RelativeLayout L0;
    public ImageView M;
    public RelativeLayout M0;
    public ImageView N;
    public Movie N0;
    public ImageView O;
    public ExpandableTextView O0;
    public ImageView P;
    public TextView P0;
    public LinearLayout Q;
    public TextView Q0;
    public LinearLayout R;
    public TextView R0;
    public LinearLayout S;
    public TextView S0;
    public LinearLayout T;
    public TextView T0;
    public LinearLayout U;
    public TextView U0;
    public LinearLayout V;
    public TextView V0;
    public TextClock W;
    public TextView W0;
    public TextView X;
    public TextView X0;
    public TextView Y;
    public TextView Y0;
    public TextView Z;
    public TextView Z0;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f11727a0;

    /* renamed from: a1, reason: collision with root package name */
    public ImageView f11728a1;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f11729b0;

    /* renamed from: b1, reason: collision with root package name */
    public ImageView f11730b1;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f11731c0;

    /* renamed from: c1, reason: collision with root package name */
    public ImageView f11732c1;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11733d0;

    /* renamed from: d1, reason: collision with root package name */
    public FrameLayout f11734d1;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f11735e0;

    /* renamed from: e1, reason: collision with root package name */
    public AutofitTextView f11736e1;

    /* renamed from: f0, reason: collision with root package name */
    public Typeface f11737f0;

    /* renamed from: g0, reason: collision with root package name */
    public Typeface f11739g0;

    /* renamed from: h0, reason: collision with root package name */
    public c4.a f11741h0;

    /* renamed from: i0, reason: collision with root package name */
    public Animation f11743i0;

    /* renamed from: j0, reason: collision with root package name */
    public Animation f11745j0;

    /* renamed from: k0, reason: collision with root package name */
    public ScrollView f11747k0;

    /* renamed from: m0, reason: collision with root package name */
    public MenuItem f11751m0;

    /* renamed from: m1, reason: collision with root package name */
    public Menu f11752m1;

    /* renamed from: n0, reason: collision with root package name */
    public t f11753n0;

    /* renamed from: o0, reason: collision with root package name */
    public t f11755o0;

    /* renamed from: p0, reason: collision with root package name */
    public t f11757p0;

    /* renamed from: q0, reason: collision with root package name */
    public t f11759q0;

    /* renamed from: r0, reason: collision with root package name */
    public ac.j f11761r0;

    /* renamed from: r1, reason: collision with root package name */
    public qe.b f11762r1;

    /* renamed from: s0, reason: collision with root package name */
    public RecyclerView f11763s0;

    /* renamed from: t0, reason: collision with root package name */
    public RecyclerView f11765t0;

    /* renamed from: u0, reason: collision with root package name */
    public RecyclerView f11767u0;

    /* renamed from: v0, reason: collision with root package name */
    public RecyclerView f11768v0;

    /* renamed from: w0, reason: collision with root package name */
    public RecyclerView f11769w0;

    /* renamed from: x0, reason: collision with root package name */
    public qe.b f11770x0;

    /* renamed from: y0, reason: collision with root package name */
    public qe.b f11771y0;

    /* renamed from: z0, reason: collision with root package name */
    public qe.b f11772z0;
    public boolean L = false;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f11749l0 = false;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f11738f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    public final ArrayList<Movie> f11740g1 = new ArrayList<>();

    /* renamed from: h1, reason: collision with root package name */
    public final ArrayList<Movie> f11742h1 = new ArrayList<>();

    /* renamed from: i1, reason: collision with root package name */
    public final ArrayList<hd.b> f11744i1 = new ArrayList<>();

    /* renamed from: j1, reason: collision with root package name */
    public final ArrayList<Movie> f11746j1 = new ArrayList<>();

    /* renamed from: k1, reason: collision with root package name */
    public final ArrayList<Movie> f11748k1 = new ArrayList<>();

    /* renamed from: l1, reason: collision with root package name */
    public final ArrayList<hd.j> f11750l1 = new ArrayList<>();

    /* renamed from: n1, reason: collision with root package name */
    public String f11754n1 = "";

    /* renamed from: o1, reason: collision with root package name */
    public String f11756o1 = "";

    /* renamed from: p1, reason: collision with root package name */
    public boolean f11758p1 = true;

    /* renamed from: q1, reason: collision with root package name */
    public String f11760q1 = null;

    /* renamed from: s1, reason: collision with root package name */
    public boolean f11764s1 = false;

    /* renamed from: t1, reason: collision with root package name */
    public boolean f11766t1 = true;

    public class a implements MaterialSearchView.OnQueryTextListener {
        public a() {
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            if (str.length() > 1) {
                MovieDetailActivity movieDetailActivity = MovieDetailActivity.this;
                qe.b bVar = movieDetailActivity.f11762r1;
                if (bVar != null) {
                    bVar.dispose();
                }
                movieDetailActivity.f11762r1 = bc.a.getSuggest(movieDetailActivity.getBaseContext(), str).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new m1(movieDetailActivity), new n1());
            }
            return true;
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            MovieDetailActivity movieDetailActivity = MovieDetailActivity.this;
            if (str != null && str.length() >= 1) {
                Intent intent = new Intent(movieDetailActivity, (Class<?>) SearchResultsActivity.class);
                intent.putExtra("query", str);
                movieDetailActivity.startActivity(intent);
                movieDetailActivity.G0.saveQueryToDb(str, System.currentTimeMillis());
            }
            movieDetailActivity.G0.activityResumed();
            movieDetailActivity.G0.closeSearch();
            movieDetailActivity.G0.clearFocus();
            return true;
        }
    }

    public final void d(Movie movie) {
        qe.b bVar = this.f11771y0;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f11771y0 = bc.a.getStreamingServices(this, movie.getType() == 0 ? "movie" : "tv", movie.getMovieId()).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new k1(this, 5), new n0(13));
    }

    public final void e() {
        try {
            Intent intent = new Intent(this, (Class<?>) YouTubeWebviewActivity.class);
            intent.putExtra("url", App.getInstance().f11578z + "/ext/goyt2.html?link=" + this.f11756o1);
            intent.putExtra("poster", this.N0.getCover());
            if (this.N0.f12394b) {
                String str = App.getInstance().f11578z + getString(R.string.api_path_movie) + this.N0.getMovieId() + ".png";
                if (this.N0.isSeries()) {
                    str = App.getInstance().f11578z + getString(R.string.api_path_tv) + this.N0.getMovieId() + ".png";
                }
                intent.putExtra("title_logo", str);
            }
            startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public final void f() {
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.f11737f0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f11739g0 = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.f11741h0 = new c4.a();
        this.Y = (TextView) findViewById(R.id.imdb_text);
        this.V = (LinearLayout) findViewById(R.id.crew_container);
        this.P = (ImageView) findViewById(R.id.mark_as_watched_imageview);
        this.O = (ImageView) findViewById(R.id.title_logo);
        this.M0 = (RelativeLayout) findViewById(R.id.mark_as_watched);
        this.M = (ImageView) findViewById(R.id.settings_image_view);
        this.f11735e0 = (TextView) findViewById(R.id.type_text_providers);
        this.N = (ImageView) findViewById(R.id.search_image_view);
        this.S = (LinearLayout) findViewById(R.id.settings_button_movies_page);
        this.U = (LinearLayout) findViewById(R.id.search_button_movies_page);
        this.T = (LinearLayout) findViewById(R.id.clock_container_view);
        this.f11729b0 = (TextView) findViewById(R.id.writers_label);
        this.W = (TextClock) findViewById(R.id.clock);
        this.R = (LinearLayout) findViewById(R.id.loader);
        this.Q = (LinearLayout) findViewById(R.id.progress_layout);
        this.X = (TextView) findViewById(R.id.progress_title);
        this.K = (ProgressBar) findViewById(R.id.progress_bar);
        this.J0 = (RelativeLayout) findViewById(R.id.poster_container);
        this.Y0 = (TextView) findViewById(R.id.play_button_label);
        this.Z0 = (TextView) findViewById(R.id.trailer_button_label);
        this.X0 = (TextView) findViewById(R.id.from_director_textview);
        this.f11734d1 = (FrameLayout) findViewById(R.id.frame_layout_background);
        this.f11732c1 = (ImageView) findViewById(R.id.button_favorite_image);
        this.f11730b1 = (ImageView) findViewById(R.id.button_play_image);
        this.f11767u0 = (RecyclerView) findViewById(R.id.recyclerview_from_cast);
        this.f11768v0 = (RecyclerView) findViewById(R.id.recyclerview_from_director);
        this.f11769w0 = (RecyclerView) findViewById(R.id.recyclerview_collection);
        this.W0 = (TextView) findViewById(R.id.type_text_view);
        this.V0 = (TextView) findViewById(R.id.more_from_textview);
        AutofitTextView autofitTextView = (AutofitTextView) findViewById(R.id.movie_title);
        this.f11736e1 = autofitTextView;
        int i10 = 1;
        autofitTextView.setMaxLines(1);
        this.f11731c0 = (TextView) findViewById(R.id.collection_label);
        this.f11733d0 = (TextView) findViewById(R.id.text_view_rating);
        this.H0 = (Toolbar) findViewById(R.id.toolbar);
        this.K0 = (RelativeLayout) findViewById(R.id.add_favorites);
        this.P0 = (TextView) findViewById(R.id.total_seasons);
        this.f11728a1 = (ImageView) findViewById(R.id.big_poster);
        this.L0 = (RelativeLayout) findViewById(R.id.trailer_lin);
        this.I0 = (LinearLayout) findViewById(R.id.movie_lin);
        this.Q0 = (TextView) findViewById(R.id.info);
        ExpandableTextView expandableTextView = (ExpandableTextView) findViewById(R.id.plot);
        this.O0 = expandableTextView;
        if (expandableTextView != null) {
            expandableTextView.setOnClickListener(new h1(this, 2));
        }
        this.R0 = (TextView) findViewById(R.id.director_textview);
        this.S0 = (TextView) findViewById(R.id.cast_textview);
        this.T0 = (TextView) findViewById(R.id.season_label_textview);
        this.U0 = (TextView) findViewById(R.id.director_label_textview);
        this.f11763s0 = (RecyclerView) findViewById(R.id.recyclerview_similar);
        this.f11765t0 = (RecyclerView) findViewById(R.id.recyclerview_cast);
        this.Z = (TextView) findViewById(R.id.cast_label);
        this.f11727a0 = (TextView) findViewById(R.id.similar_label);
        if (this.M != null) {
            this.S.setOnFocusChangeListener(new i1(this, 0));
            this.U.setOnFocusChangeListener(new i1(this, i10));
        }
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.G0 = materialSearchView;
        materialSearchView.adjustTintAlpha(0.0f);
        this.G0.setCloseOnTintClick(true);
        this.G0.setOnQueryTextListener(new a());
        this.G0.setHint("Movies, TV Shows, People...");
        int i11 = 3;
        this.G0.setOnItemClickListener(new f(this, i11));
        LinearLayout linearLayout = this.S;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new h1(this, i11));
        }
        RelativeLayout relativeLayout = this.K0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new h1(this, 4));
        }
        RelativeLayout relativeLayout2 = this.M0;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnClickListener(new h1(this, 5));
        }
        LinearLayout linearLayout2 = this.U;
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new h1(this, 6));
        }
    }

    public final void g() {
        String str;
        LinearLayout linearLayout = this.Q;
        if (linearLayout == null) {
            return;
        }
        if (this.N0 == null) {
            linearLayout.setVisibility(8);
            return;
        }
        int i10 = App.getInstance().f11574v.getInt(this.N0.getMovieId() + "", -1);
        if (i10 <= 0) {
            this.Q.setVisibility(8);
            return;
        }
        try {
            int duration = this.N0.getDuration() - (i10 / 60000);
            if (duration < 0) {
                this.Q.setVisibility(8);
                return;
            }
            if (duration > 60) {
                str = (duration / 60) + "h " + (duration % 60) + "m";
            } else {
                str = duration + "m";
            }
            this.X.setText(str + " remaining");
            this.K.setProgress((int) ((double) (((float) (i10 * 100)) / ((float) (this.N0.getDuration() * 60000)))));
            this.Q.setVisibility(0);
        } catch (Exception unused) {
        }
    }

    public final void h() {
        int i10;
        if (this.N0.isSeries()) {
            int i11 = App.getInstance().f11574v.getInt(this.N0.getMovieId() + "watched_season_episode_count", -1);
            if (i11 > 0) {
                int i12 = App.getInstance().f11574v.getInt(this.N0.getMovieId() + "watched_season_index", 0) + 1;
                int i13 = App.getInstance().f11574v.getInt(this.N0.getMovieId() + "season" + i12 + "episode" + i12, 0) + 1;
                if (i13 <= 0 || (i10 = i11 - i13) <= 0) {
                    return;
                }
                this.K.setProgress((int) ((i13 * 100) / i11));
                this.Q.setVisibility(0);
                this.X.setText(i10 + " episodes remaining on season " + i12);
            }
        }
    }

    public boolean isYoutubeInstall() {
        return getPackageManager().getLaunchIntentForPackage("com.google.android.youtube") != null;
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1100 && App.getInstance().f11574v.getBoolean("clear_history_pending", false)) {
            try {
                MaterialSearchView materialSearchView = this.G0;
                if (materialSearchView != null) {
                    materialSearchView.clearHistory();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            o1.a.j(App.getInstance().f11574v, "clear_history_pending", false);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MaterialSearchView materialSearchView = this.G0;
        if (materialSearchView != null && materialSearchView.isOpen()) {
            this.G0.closeSearch();
        } else if (this.f11747k0.getScrollY() > 300) {
            this.f11747k0.fullScroll(33);
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x036d  */
    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 1532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.activities.MovieDetailActivity.onCreate(android.os.Bundle):void");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getResources().getConfiguration().orientation == 2) {
            getMenuInflater().inflate(R.menu.movie_detail_menu_land, menu);
        } else {
            getMenuInflater().inflate(R.menu.movie_detail_menu, menu);
        }
        this.f11752m1 = menu;
        this.f11751m0 = menu.findItem(R.id.action_search);
        return true;
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("query", movie.getTitle());
        intent.putExtra("server", "");
        intent.putExtra("movie", movie);
        intent.putExtra("year", movie.I);
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_fav /* 2131427434 */:
                if (App.getInstance().f11573u.isMovieFavorited(this.N0)) {
                    menuItem.setIcon(R.drawable.love);
                    App.getInstance().f11573u.deleteFavoriteMovie(this.N0);
                    Snackbar.make(findViewById(R.id.main_view), getString(R.string.removed_fav_label), -1).show();
                } else {
                    menuItem.setIcon(R.drawable.ic_action_favorite);
                    App.getInstance().f11573u.addMovieFavorites(this.N0);
                    Snackbar.make(findViewById(R.id.main_view), getString(R.string.added_fav_label), -1).show();
                }
                return true;
            case R.id.action_search /* 2131427463 */:
                this.G0.openSearch();
                return true;
            case R.id.action_settings /* 2131427464 */:
                startActivityForResult(new Intent(this, (Class<?>) SettingsActivity.class), 1100);
                return true;
            case R.id.action_watch /* 2131427473 */:
                if (this.L) {
                    try {
                        menuItem.getIcon().setVisible(false, true);
                        App.getInstance().f11573u.markAsWatched(this.N0);
                        Toast.makeText(getApplicationContext(), "Marked as Watched", 1).show();
                    } catch (Exception e10) {
                        throw new RuntimeException(e10);
                    }
                }
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onResume() {
        super.onResume();
        boolean zIsMovieWatching = App.getInstance().f11573u.isMovieWatching(this.N0);
        this.L = zIsMovieWatching;
        if (zIsMovieWatching) {
            this.Y0.setText("CONTINUE");
            if (this.N0.isSeries()) {
                int i10 = App.getInstance().f11574v.getInt(this.N0.getMovieId() + "watched_season_index", 0) + 1;
                String strG = c.g("S", i10, "E", App.getInstance().f11574v.getInt(this.N0.getMovieId() + "season" + i10 + "episode" + i10, 0) + 1);
                TextView textView = this.Y0;
                StringBuilder sb2 = new StringBuilder("CONTINUE  ");
                sb2.append(strG);
                textView.setText(sb2.toString());
                h();
            } else {
                g();
            }
            this.f11730b1.setImageResource(R.drawable.is_resume);
            if (!App.K) {
                this.f11730b1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN));
            }
            RelativeLayout relativeLayout = this.M0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
        } else {
            LinearLayout linearLayout = this.Q;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            this.Y0.setText("PLAY");
            this.f11730b1.setImageResource(R.drawable.ic_play);
            this.M0.setVisibility(8);
            if (!App.K) {
                this.f11730b1.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(this, R.color.black), PorterDuff.Mode.SRC_IN));
            }
        }
        new Handler().postDelayed(new g1(this, 4), 200L);
    }

    public void watchYoutubeVideo(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + str));
        new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + str));
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            e();
        } catch (Exception unused2) {
            e();
        }
    }

    public class b implements sa.b {
        public b() {
        }

        @Override // sa.b
        public void onSuccess() {
            MovieDetailActivity movieDetailActivity = MovieDetailActivity.this;
            AutofitTextView autofitTextView = movieDetailActivity.f11736e1;
            if (autofitTextView != null) {
                autofitTextView.setVisibility(8);
            }
            movieDetailActivity.N0.f12394b = true;
            ImageView imageView = movieDetailActivity.O;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            movieDetailActivity.f11764s1 = true;
        }

        @Override // sa.b
        public void onError(Exception exc) {
        }
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
