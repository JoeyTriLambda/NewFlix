package flix.com.vision.activities;

import ac.i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.d;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.AnimeDetailActivity;
import flix.com.vision.activities.LinksActivity;
import flix.com.vision.models.Anime;
import flix.com.vision.tv.Constant;
import hd.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class AnimeDetailActivity extends wb.a {

    /* renamed from: e0, reason: collision with root package name */
    public static final /* synthetic */ int f11584e0 = 0;
    public ImageView K;
    public TextView L;
    public TextView M;
    public RelativeLayout N;
    public SpinKitView O;
    public RecyclerView P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public i T;
    public Anime U;
    public ImageButton Y;
    public Typeface Z;

    /* renamed from: a0, reason: collision with root package name */
    public RelativeLayout f11585a0;

    /* renamed from: b0, reason: collision with root package name */
    public c4.a f11586b0;

    /* renamed from: d0, reason: collision with root package name */
    public Menu f11588d0;
    public final ArrayList<f> V = new ArrayList<>();
    public String W = "gogoanime.pe";
    public String X = "www.gogoanimes.so/";

    /* renamed from: c0, reason: collision with root package name */
    public int f11587c0 = -1;

    public enum RESULT_EVENT {
        SUCCESS,
        /* JADX INFO: Fake field, exist only in values array */
        ERROR,
        /* JADX INFO: Fake field, exist only in values array */
        EPISODE_READY,
        EPISODE_FAILED,
        /* JADX INFO: Fake field, exist only in values array */
        LOAD_FOO_LINK
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Menu menu;
            AnimeDetailActivity animeDetailActivity = AnimeDetailActivity.this;
            try {
                if (!App.getInstance().f11573u.isMovieFavorited_ANIME(animeDetailActivity.U.toMovie()) || (menu = animeDetailActivity.f11588d0) == null) {
                    return;
                }
                menu.findItem(R.id.action_fav).setIcon(R.drawable.ic_action_favorite);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public void extractDominantColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 3));
        valueAnimatorOfObject.addListener(new b());
        valueAnimatorOfObject.start();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_anime_detail);
        } catch (Exception e10) {
            e10.printStackTrace();
            finish();
        }
        this.f11585a0 = (RelativeLayout) findViewById(R.id.activity_anime_detail);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.Z = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f11586b0 = new c4.a();
        this.W = "https://" + App.getInstance().f11574v.getString("anime_domain", this.X);
        this.X = App.getInstance().f11574v.getString("anime_domain", this.X);
        this.Y = (ImageButton) findViewById(R.id.play_single_media_button);
        this.M = (TextView) findViewById(R.id.anime_year_label);
        this.K = (ImageView) findViewById(R.id.button_favorite_image);
        EventBus.getDefault().register(this);
        if (bundle == null) {
            App.C.clear();
        }
        this.O = (SpinKitView) findViewById(R.id.loader_view);
        this.L = (TextView) findViewById(R.id.last_watched_label);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.add_favorites);
        this.N = relativeLayout;
        int i10 = 2;
        if (relativeLayout != null) {
            relativeLayout.setOnFocusChangeListener(new v7.b(this, i10));
        }
        this.P = (RecyclerView) findViewById(R.id.listview_);
        this.Q = (ImageView) findViewById(R.id.poster);
        this.R = (TextView) findViewById(R.id.plot);
        this.S = (TextView) findViewById(R.id.title);
        Anime anime = (Anime) getIntent().getSerializableExtra("anime");
        this.U = anime;
        anime.f12382p = anime.f12382p.replace("gogoanime.pe", "www5.gogoanimes.fi");
        this.R.setText(this.U.f12384r);
        String str2 = this.U.f12380n;
        if (str2 != null) {
            this.S.setText(str2.toUpperCase());
        }
        String string = App.getInstance().f11574v.getString(this.U.f12382p + "episode", null);
        if (string != null) {
            this.L.setText("· last episode: E".concat(string));
        } else {
            this.L.setVisibility(8);
        }
        final int i11 = 0;
        this.Y.setOnClickListener(new View.OnClickListener(this) { // from class: ub.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeDetailActivity f20143m;

            {
                this.f20143m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                boolean z10 = true;
                AnimeDetailActivity animeDetailActivity = this.f20143m;
                switch (i12) {
                    case 0:
                        int i13 = AnimeDetailActivity.f11584e0;
                        animeDetailActivity.getClass();
                        try {
                            App.getInstance().f11573u.addMovieHistory_ANIME(animeDetailActivity.U.toMovie());
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                        Intent intent = new Intent(animeDetailActivity, (Class<?>) LinksActivity.class);
                        intent.putExtra("server_index", animeDetailActivity.f11587c0);
                        ArrayList<hd.f> arrayList = animeDetailActivity.V;
                        intent.putExtra("url", arrayList.get(0).f12994n);
                        intent.putExtra("img_url", animeDetailActivity.U.f12383q);
                        intent.putExtra("movie", animeDetailActivity.U.toMovie());
                        intent.putExtra("episode_index", 0);
                        intent.putExtra("episode_number", 1);
                        intent.putExtra("title", animeDetailActivity.U.f12380n + " - episode " + arrayList.get(0).f12996p);
                        intent.putExtra("episode", arrayList.get(0).f12996p);
                        intent.putExtra("title_simple", animeDetailActivity.U.f12380n);
                        animeDetailActivity.startActivity(intent);
                        String str3 = arrayList.get(0).f12996p;
                        App.getInstance().f11574v.edit().putString(animeDetailActivity.U.f12382p + "episode", str3).apply();
                        break;
                    default:
                        int i14 = AnimeDetailActivity.f11584e0;
                        animeDetailActivity.getClass();
                        if (App.getInstance().f11573u.isMovieFavorited_ANIME(animeDetailActivity.U.toMovie())) {
                            App.getInstance().f11573u.deleteFavoriteMovie_ANIME(animeDetailActivity.U.toMovie());
                            try {
                                ic.a.Success(animeDetailActivity.getApplicationContext(), "Removed from your list", null, 80, 0);
                            } catch (Exception unused) {
                            }
                            z10 = false;
                        } else {
                            App.getInstance().f11573u.addMovieFavorites_Anime(animeDetailActivity.U.toMovie());
                            try {
                                ic.a.Success(animeDetailActivity.getApplicationContext(), "Added to your Anime List", null, 80, 0);
                            } catch (Exception unused2) {
                            }
                        }
                        if (!z10) {
                            animeDetailActivity.K.setImageResource(R.drawable.ic_bookmark);
                            break;
                        } else {
                            animeDetailActivity.K.setImageResource(R.drawable.ic_delete_bookmark);
                            break;
                        }
                }
            }
        });
        this.M.setText(this.U.f12378b);
        this.Y.setOnFocusChangeListener(new ub.b(i11));
        final int i12 = 1;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeDetailActivity f20143m;

            {
                this.f20143m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i12;
                boolean z10 = true;
                AnimeDetailActivity animeDetailActivity = this.f20143m;
                switch (i122) {
                    case 0:
                        int i13 = AnimeDetailActivity.f11584e0;
                        animeDetailActivity.getClass();
                        try {
                            App.getInstance().f11573u.addMovieHistory_ANIME(animeDetailActivity.U.toMovie());
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                        Intent intent = new Intent(animeDetailActivity, (Class<?>) LinksActivity.class);
                        intent.putExtra("server_index", animeDetailActivity.f11587c0);
                        ArrayList<hd.f> arrayList = animeDetailActivity.V;
                        intent.putExtra("url", arrayList.get(0).f12994n);
                        intent.putExtra("img_url", animeDetailActivity.U.f12383q);
                        intent.putExtra("movie", animeDetailActivity.U.toMovie());
                        intent.putExtra("episode_index", 0);
                        intent.putExtra("episode_number", 1);
                        intent.putExtra("title", animeDetailActivity.U.f12380n + " - episode " + arrayList.get(0).f12996p);
                        intent.putExtra("episode", arrayList.get(0).f12996p);
                        intent.putExtra("title_simple", animeDetailActivity.U.f12380n);
                        animeDetailActivity.startActivity(intent);
                        String str3 = arrayList.get(0).f12996p;
                        App.getInstance().f11574v.edit().putString(animeDetailActivity.U.f12382p + "episode", str3).apply();
                        break;
                    default:
                        int i14 = AnimeDetailActivity.f11584e0;
                        animeDetailActivity.getClass();
                        if (App.getInstance().f11573u.isMovieFavorited_ANIME(animeDetailActivity.U.toMovie())) {
                            App.getInstance().f11573u.deleteFavoriteMovie_ANIME(animeDetailActivity.U.toMovie());
                            try {
                                ic.a.Success(animeDetailActivity.getApplicationContext(), "Removed from your list", null, 80, 0);
                            } catch (Exception unused) {
                            }
                            z10 = false;
                        } else {
                            App.getInstance().f11573u.addMovieFavorites_Anime(animeDetailActivity.U.toMovie());
                            try {
                                ic.a.Success(animeDetailActivity.getApplicationContext(), "Added to your Anime List", null, 80, 0);
                            } catch (Exception unused2) {
                            }
                        }
                        if (!z10) {
                            animeDetailActivity.K.setImageResource(R.drawable.ic_bookmark);
                            break;
                        } else {
                            animeDetailActivity.K.setImageResource(R.drawable.ic_delete_bookmark);
                            break;
                        }
                }
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
        if (getResources().getConfiguration().orientation == 2) {
            try {
                getSupportActionBar().hide();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            Picasso.get().load(this.U.f12383q).fit().placeholder(R.drawable.ic_anime).centerCrop().into(this.Q);
        } catch (OutOfMemoryError e12) {
            e12.printStackTrace();
        }
        float f10 = o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density;
        int i13 = App.K ? 12 : 8;
        int iRound = Math.round(f10 / 105);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listview_);
        this.P = recyclerView;
        recyclerView.setClipToPadding(false);
        this.P.addItemDecoration(new c(i13));
        ArrayList<f> arrayList = this.V;
        i iVar = new i(this, arrayList, string);
        this.T = iVar;
        this.P.setAdapter(iVar);
        this.P.setLayoutManager(new GridLayoutManager(this, iRound));
        if (bundle == null) {
            String strReplace = this.U.f12382p.replace("www9.gogoanime.io", "gogoanime.pe");
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str3 = Constant.f12450b;
            new flix.com.vision.activities.a(this, strReplace.replace("www9.gogoanime.io", this.X).replace("gogoanime.io", this.X), sharedPreferences.getString("anime_host_ajax_pref", "https://ajax.gogocdn.net")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            arrayList.addAll(bundle.getParcelableArrayList("episodes"));
            this.T.notifyDataSetChanged();
            this.O.setVisibility(8);
            this.f11587c0 = 0;
            EventBus.getDefault().post(RESULT_EVENT.SUCCESS);
        }
        new Handler().postDelayed(new a(), 500L);
        this.f11586b0.applyFontToView(this.R, this.Z);
        this.f11586b0.applyFontToView(this.L, this.Z);
        new Handler().postDelayed(new d(this, 25), 800L);
        this.P.requestFocus();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anime_detail_menu_2, menu);
        this.f11588d0 = menu;
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RESULT_EVENT result_event) {
        if (result_event == RESULT_EVENT.SUCCESS) {
            this.T.notifyDataSetChanged();
            this.O.setVisibility(8);
        } else if (result_event == RESULT_EVENT.EPISODE_FAILED) {
            this.O.setVisibility(8);
            Toast.makeText(getBaseContext(), getString(R.string.failed_to_load), 1);
        }
        this.O.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.action_fav) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (App.getInstance().f11573u.isMovieFavorited_ANIME(this.U.toMovie())) {
            menuItem.setIcon(R.drawable.love);
            App.getInstance().f11573u.deleteFavoriteMovie_ANIME(this.U.toMovie());
            Snackbar.make(findViewById(R.id.main_view), R.string.removed_fav_label, -1).show();
        } else {
            menuItem.setIcon(R.drawable.ic_action_favorite);
            App.getInstance().f11573u.addMovieFavorites_Anime(this.U.toMovie());
            Snackbar.make(findViewById(R.id.main_view), R.string.added_fav_label, -1).show();
        }
        return true;
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            i iVar = this.T;
            if (iVar != null) {
                iVar.notifyDataSetChanged();
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("episodes", this.V);
    }

    public void openEpisode(int i10) {
        App.getInstance().A.clear();
        ArrayList<f> arrayList = App.getInstance().A;
        ArrayList<f> arrayList2 = this.V;
        arrayList.addAll(arrayList2);
        try {
            App.getInstance().f11573u.addMovieHistory_ANIME(this.U.toMovie());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        Intent intent = new Intent(this, (Class<?>) LinksActivity.class);
        intent.putExtra("server_index", this.f11587c0);
        intent.putExtra("url", arrayList2.get(i10).f12994n);
        intent.putExtra("img_url", this.U.f12383q);
        intent.putExtra("movie", this.U.toMovie());
        intent.putExtra("episode_number", i10 + 1);
        intent.putExtra("title_episode", "Episode " + i10 + 1);
        intent.putExtra("title", this.U.f12380n + " - episode " + arrayList2.get(i10).f12996p);
        intent.putExtra("episode", arrayList2.get(i10).f12996p);
        intent.putExtra("title_simple", this.U.f12380n);
        startActivity(intent);
        String str = arrayList2.get(i10).f12996p;
        App.getInstance().f11574v.edit().putString(this.U.f12382p + "episode", str).apply();
    }
}
