package flix.com.vision.activities;

import ac.c;
import ac.q;
import ac.w;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SeriesDetailActivity;
import flix.com.vision.customviews.CustomImageView;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import flix.com.vision.utils.JsonUtils;
import gd.k;
import hd.f;
import hd.j;
import java.util.ArrayList;
import kc.d;
import ub.n0;
import ub.q0;
import ub.w1;

/* loaded from: classes2.dex */
public class SeriesDetailActivity extends wb.a implements k {

    /* renamed from: h0, reason: collision with root package name */
    public static final /* synthetic */ int f11800h0 = 0;
    public TextView K;
    public TextView L;
    public TextView M;
    public TextView N;
    public TextView O;
    public w P;
    public q Q;
    public RecyclerView S;
    public RecyclerView T;
    public ImageView U;
    public qe.b W;
    public Movie X;
    public RelativeLayout Y;
    public c4.a Z;

    /* renamed from: a0, reason: collision with root package name */
    public Typeface f11801a0;

    /* renamed from: b0, reason: collision with root package name */
    public Typeface f11802b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f11803c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f11804d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f11805e0;

    /* renamed from: f0, reason: collision with root package name */
    public CustomImageView f11806f0;
    public ArrayList<j> R = new ArrayList<>();
    public final ArrayList<f> V = new ArrayList<>();

    /* renamed from: g0, reason: collision with root package name */
    public boolean f11807g0 = true;

    public final void d() {
        final boolean z10 = App.getInstance().f11574v.getBoolean("pref_hide_episodes", false);
        qe.b bVar = this.W;
        if (bVar != null) {
            bVar.dispose();
        }
        this.W = bc.a.getListEpisode(getBaseContext(), String.valueOf(this.X.getMovieId()), String.valueOf(this.f11803c0)).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new se.f() { // from class: ub.x1
            @Override // se.f
            public final void accept(Object obj) {
                SeriesDetailActivity seriesDetailActivity = this.f20318b;
                ArrayList<hd.f> arrayList = seriesDetailActivity.V;
                arrayList.clear();
                arrayList.addAll(JsonUtils.parseListEpisode((com.google.gson.o) obj, z10));
                seriesDetailActivity.Q.notifyDataSetChanged();
                if (seriesDetailActivity.f11807g0) {
                    seriesDetailActivity.f11807g0 = false;
                } else {
                    seriesDetailActivity.T.smoothScrollToPosition(0);
                }
                if (arrayList.size() > 0) {
                    seriesDetailActivity.episodeHighlited(seriesDetailActivity.f11804d0 - 1);
                }
            }
        }, new n0(17));
    }

    public void episodeHighlited(int i10) {
        if (i10 >= 0) {
            this.V.size();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_series_details);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.f11801a0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f11802b0 = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.Z = new c4.a();
        this.f11806f0 = (CustomImageView) findViewById(R.id.title_logo);
        this.O = (TextView) findViewById(R.id.last_episode_text_view);
        this.K = (TextView) findViewById(R.id.movie_title);
        this.L = (TextView) findViewById(R.id.info_text_view);
        this.T = (RecyclerView) findViewById(R.id.recyclerview_episodes);
        this.S = (RecyclerView) findViewById(R.id.recyclerview_seasons);
        this.N = (TextView) findViewById(R.id.season_info_text_view);
        this.M = (TextView) findViewById(R.id.season_label_view);
        this.Y = (RelativeLayout) findViewById(R.id.season_button);
        this.U = (ImageView) findViewById(R.id.poster);
        RelativeLayout relativeLayout = this.Y;
        int i10 = 1;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new w1(this, i10));
        }
        this.T.setOnFocusChangeListener(new ub.b(2));
        this.X = (Movie) getIntent().getSerializableExtra("movie");
        this.R = getIntent().getParcelableArrayListExtra("seasons");
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        ArrayList<String> arrayList = App.B;
        float f10 = getResources().getDisplayMetrics().density;
        int i11 = App.getInstance().f11574v.getInt(this.X.getMovieId() + "watched_season_index", 0) + 1;
        this.f11803c0 = i11;
        try {
            this.f11805e0 = this.R.get(i11 - 1).f13017q;
        } catch (Exception unused) {
        }
        TextView textView = this.M;
        if (textView != null) {
            textView.setText("Season " + this.f11803c0);
        }
        try {
            this.N.setText(this.R.get(this.f11803c0 - 1).f13015o);
            if (this.R.get(this.f11803c0 - 1).f13016p != null && !this.R.get(this.f11803c0 - 1).f13016p.isEmpty()) {
                try {
                    Picasso.get().load(this.R.get(this.f11803c0 - 1).f13016p).fit().centerCrop().into(this.U);
                } catch (OutOfMemoryError e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Exception e11) {
            try {
                Picasso.get().load(this.X.getCover()).fit().centerCrop().into(this.U);
            } catch (OutOfMemoryError unused2) {
                e11.printStackTrace();
            }
        }
        this.f11804d0 = App.getInstance().f11574v.getInt(this.X.getMovieId() + "season" + this.f11803c0 + "episode" + this.f11803c0, 0) + 1;
        this.K.setText(this.X.getTitle());
        if (bundle == null) {
            d();
        }
        this.L.setText(this.X.getYear() + " · " + this.X.getSeason_count() + " Seasons");
        if (App.getInstance().f11574v.getInt(this.X.getMovieId() + "watched_season_index", -1) >= 0) {
            this.O.setText(" · last episode: S" + this.f11803c0 + "E" + this.f11804d0);
            this.O.setVisibility(0);
        }
        ArrayList<f> arrayList2 = this.V;
        if (bundle != null) {
            try {
                ArrayList parcelableArrayList = bundle.getParcelableArrayList("episodes");
                arrayList2.clear();
                arrayList2.addAll(parcelableArrayList);
            } catch (Exception unused3) {
            }
        }
        w wVar = new w(this, this, this.R, this.f11803c0);
        this.P = wVar;
        RecyclerView recyclerView = this.S;
        if (recyclerView != null) {
            recyclerView.setAdapter(wVar);
            o1.a.h(18, this.S);
            this.S.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.P.notifyDataSetChanged();
        }
        q qVar = new q(this, arrayList2, this.f11804d0, this.f11803c0);
        this.Q = qVar;
        qVar.setSeason(this.f11803c0);
        this.T.setAdapter(this.Q);
        o1.a.h(22, this.T);
        this.T.setLayoutManager(new CenterLayoutManager(this, 1, false));
        this.Q.notifyDataSetChanged();
        this.Z.applyFontToView(this.K, this.f11802b0);
        this.Z.applyFontToView(this.L, this.f11801a0);
        this.Z.applyFontToView(this.M, this.f11801a0);
        this.Z.applyFontToView(this.N, this.f11801a0);
        if (this.f11806f0 != null) {
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str2 = Constant.f12450b;
            if (sharedPreferences.getBoolean("pref_load_logos", false)) {
                try {
                    Picasso.get().load(App.getInstance().f11578z + getString(R.string.api_path_tv) + this.X.getMovieId() + ".png").into(this.f11806f0, new a());
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_series, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        if (App.getInstance().f11567o) {
            int i10 = 0;
            if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
                if (App.getInstance().f11574v.getBoolean("trakt_episode_always_send", false)) {
                    App.getInstance().f11572t.traktAddToWatchedHistoryEpisode(this.X, this.f11803c0, this.f11804d0);
                } else {
                    try {
                        FragmentManager fragmentManager = getFragmentManager();
                        d dVarNewInstance = d.newInstance(this, true);
                        dVarNewInstance.setTitle("Trakt Watched Episode");
                        dVarNewInstance.setMessage("Looks like you've just watched S" + this.f11803c0 + "E" + this.f11804d0 + " of " + this.X.getTitle() + "\n Do you want to send to Trakt?");
                        dVarNewInstance.setButton1("NO THANKS", new q0(4));
                        dVarNewInstance.setButton2("YES, SEND TO TRAKT", new w1(this, i10));
                        dVarNewInstance.setButton3("ALWAYS SEND", new q0(5));
                        try {
                            dVarNewInstance.show(fragmentManager, "");
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        super.onResume();
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
        this.Q.notifyDataSetChanged();
        if (this.f11803c0 == 1) {
            App.getInstance().f11574v.edit().putInt(this.X.getMovieId() + "watched_season_index", 0).apply();
        }
        this.L.setText(this.X.getYear() + " · " + this.X.getSeason_count() + " Seasons");
        if (App.getInstance().f11574v.getInt(this.X.getMovieId() + "watched_season_index", -1) >= 0) {
            this.O.setText(" · last episode: S" + this.f11803c0 + "E" + arrayList2.get(i10).f13001u);
            this.O.setVisibility(0);
        }
        try {
            App.getInstance().f11574v.edit().putInt(this.X.getMovieId() + "watched_season_episode_count", this.R.get(this.f11803c0 - 1).f13014n).apply();
        } catch (Exception unused) {
        }
        App.getInstance().f11567o = false;
        int i11 = i10 + 1;
        this.f11804d0 = i11;
        Intent intent = new Intent(this, (Class<?>) LinksActivity.class);
        intent.putExtra("movie", this.X);
        intent.putExtra("season_year", this.f11805e0);
        intent.putExtra("episode_number", i11);
        intent.putExtra("season", this.f11803c0);
        intent.putExtra("episode_count", arrayList2.size());
        intent.putExtra("episode_id", arrayList2.get(i10).f13001u);
        startActivity(intent);
        App.getInstance().f11574v.edit().putInt(this.X.getMovieId() + "season" + this.f11803c0 + "episode" + this.f11803c0, i10).apply();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.X.getMovieId());
        sb2.append("s");
        sb2.append(this.f11803c0);
        sb2.append("e");
        App.getInstance().f11574v.edit().putString(c.m(sb2, this.f11803c0, "title"), arrayList2.get(i10).f13000t).apply();
    }

    @Override // gd.k
    public void openSeason(int i10) {
        this.f11803c0 = i10 + 1;
        this.f11805e0 = this.R.get(i10).f13017q;
        d();
        this.Q.setSeason(this.f11803c0);
        TextView textView = this.M;
        if (textView != null) {
            textView.setText("Season " + this.f11803c0);
        }
        if (this.N != null && this.R.get(i10).f13016p != null && !this.R.get(i10).f13016p.isEmpty()) {
            try {
                Picasso.get().load(this.R.get(i10).f13016p).fit().centerCrop().into(this.U);
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
        }
        App.getInstance().f11574v.edit().putInt(this.X.getMovieId() + "watched_season_index", i10).apply();
    }

    public class a implements sa.b {
        public a() {
        }

        @Override // sa.b
        public void onSuccess() {
            SeriesDetailActivity seriesDetailActivity = SeriesDetailActivity.this;
            TextView textView = seriesDetailActivity.K;
            if (textView != null) {
                textView.setVisibility(8);
            }
            CustomImageView customImageView = seriesDetailActivity.f11806f0;
            if (customImageView != null) {
                customImageView.setVisibility(0);
            }
        }

        @Override // sa.b
        public void onError(Exception exc) {
        }
    }
}
