package flix.com.vision.activities;

import ac.t;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SearchResultsActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import flix.com.vision.utils.JsonUtils;
import gd.j;
import java.util.ArrayList;
import se.f;
import ub.n0;
import ub.t1;

/* loaded from: classes2.dex */
public class SearchResultsActivity extends wb.a implements j {

    /* renamed from: i0, reason: collision with root package name */
    public static final /* synthetic */ int f11791i0 = 0;
    public c4.a K;
    public Typeface L;
    public TextView M;
    public TextView N;
    public TextView O;
    public TextView P;
    public RelativeLayout Q;
    public RelativeLayout R;
    public RelativeLayout S;
    public int T = 0;
    public final ArrayList<Movie> U = new ArrayList<>();
    public final ArrayList<Movie> V = new ArrayList<>();
    public final ArrayList<hd.b> W = new ArrayList<>();
    public final ArrayList<Movie> X = new ArrayList<>();
    public qe.b Y;
    public qe.b Z;

    /* renamed from: a0, reason: collision with root package name */
    public qe.b f11792a0;

    /* renamed from: b0, reason: collision with root package name */
    public SuperRecyclerView f11793b0;

    /* renamed from: c0, reason: collision with root package name */
    public RecyclerView f11794c0;

    /* renamed from: d0, reason: collision with root package name */
    public Toolbar f11795d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f11796e0;

    /* renamed from: f0, reason: collision with root package name */
    public LinearLayout f11797f0;

    /* renamed from: g0, reason: collision with root package name */
    public t f11798g0;

    /* renamed from: h0, reason: collision with root package name */
    public ac.j f11799h0;

    public final void d(int i10) {
        if (this.f11796e0 == null) {
            this.f11796e0 = "";
        }
        qe.b bVar = this.Y;
        if (bVar != null) {
            bVar.dispose();
        }
        int i11 = 0;
        App.getInstance().f11574v.getBoolean("parental_control", false);
        this.Y = bc.a.searchData(this, this.f11796e0, i10, "movie", false).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new t1(this, i11, i10, i11), new n0(15));
    }

    public final void e(int i10) {
        if (this.f11796e0 == null) {
            this.f11796e0 = "";
        }
        qe.b bVar = this.f11792a0;
        if (bVar != null) {
            bVar.dispose();
        }
        final int i11 = 0;
        final int i12 = 1;
        this.f11792a0 = bc.a.searchPeople(this, this.f11796e0, i10).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new f(this) { // from class: ub.v1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchResultsActivity f20301m;

            {
                this.f20301m = this;
            }

            @Override // se.f
            public final void accept(Object obj) {
                int i13 = i11;
                SearchResultsActivity searchResultsActivity = this.f20301m;
                switch (i13) {
                    case 0:
                        searchResultsActivity.f11797f0.setVisibility(8);
                        ArrayList<hd.b> people = JsonUtils.parsePeople((com.google.gson.o) obj);
                        searchResultsActivity.W.addAll(people);
                        searchResultsActivity.f11799h0.notifyDataSetChanged();
                        searchResultsActivity.P.setText("People · " + people.size());
                        if (people.size() > 0) {
                            searchResultsActivity.f11793b0.setVisibility(8);
                            searchResultsActivity.f11794c0.setVisibility(0);
                            break;
                        }
                        break;
                    default:
                        searchResultsActivity.P.setText("People · 0");
                        break;
                }
            }
        }, new f(this) { // from class: ub.v1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchResultsActivity f20301m;

            {
                this.f20301m = this;
            }

            @Override // se.f
            public final void accept(Object obj) {
                int i13 = i12;
                SearchResultsActivity searchResultsActivity = this.f20301m;
                switch (i13) {
                    case 0:
                        searchResultsActivity.f11797f0.setVisibility(8);
                        ArrayList<hd.b> people = JsonUtils.parsePeople((com.google.gson.o) obj);
                        searchResultsActivity.W.addAll(people);
                        searchResultsActivity.f11799h0.notifyDataSetChanged();
                        searchResultsActivity.P.setText("People · " + people.size());
                        if (people.size() > 0) {
                            searchResultsActivity.f11793b0.setVisibility(8);
                            searchResultsActivity.f11794c0.setVisibility(0);
                            break;
                        }
                        break;
                    default:
                        searchResultsActivity.P.setText("People · 0");
                        break;
                }
            }
        });
    }

    public final void f(int i10) {
        if (this.f11796e0 == null) {
            this.f11796e0 = "";
        }
        qe.b bVar = this.Z;
        if (bVar != null) {
            bVar.dispose();
        }
        int i11 = 1;
        this.Z = bc.a.searchData(this, this.f11796e0, i10, "tv", !App.getInstance().f11574v.getBoolean("parental_control", true)).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new t1(this, i11, i10, i11), new n0(16));
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_tabbed);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new c4.a();
        this.P = (TextView) findViewById(R.id.label_people_button);
        this.M = (TextView) findViewById(R.id.label_series_button);
        this.N = (TextView) findViewById(R.id.label_movies_button);
        this.O = (TextView) findViewById(R.id.unreleased_movie_text);
        this.f11797f0 = (LinearLayout) findViewById(R.id.progress_web);
        this.K.applyFontToView(this.M, this.L);
        this.K.applyFontToView(this.N, this.L);
        this.Q = (RelativeLayout) findViewById(R.id.movies_button);
        this.R = (RelativeLayout) findViewById(R.id.series_button);
        this.S = (RelativeLayout) findViewById(R.id.people_button);
        this.f11793b0 = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.f11794c0 = (RecyclerView) findViewById(R.id.recyclerview_cast);
        ((ProgressBar) findViewById(R.id.progress_bar)).setVisibility(8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.f11795d0 = toolbar;
        this.K.applyFontToToolbar(toolbar, this.L);
        this.f11796e0 = getIntent().getStringExtra("query");
        final int i10 = 0;
        this.T = getIntent().getIntExtra("type", 0);
        if (this.f11796e0 == null) {
            this.f11796e0 = "";
        }
        this.T = getIntent().getBooleanExtra("tv_shows_only", false) ? 1 : 0;
        setSupportActionBar(this.f11795d0);
        getSupportActionBar().setTitle(("Results for \"" + this.f11796e0 + "\"").toUpperCase());
        final int i11 = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.f11798g0 = new t(getBaseContext(), this.V, this, 0, this, null);
        this.f11799h0 = new ac.j(getBaseContext(), this.W, this, 0);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        float f10 = displayMetricsB.widthPixels / getResources().getDisplayMetrics().density;
        ArrayList<String> arrayList = App.B;
        int iRound = Math.round(f10 / 140);
        this.f11793b0.setLayoutManager(new CenterGridLayoutManager(this, iRound));
        this.f11793b0.addItemDecoration(new c(12));
        this.f11793b0.setAdapter(this.f11798g0);
        this.f11793b0.invalidate();
        this.f11793b0.requestFocus();
        this.f11794c0.setLayoutManager(new CenterGridLayoutManager(this, iRound));
        o1.a.h(12, this.f11794c0);
        this.f11794c0.setAdapter(this.f11799h0);
        this.f11794c0.invalidate();
        this.Q.setOnClickListener(new View.OnClickListener(this) { // from class: ub.u1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchResultsActivity f20290m;

            {
                this.f20290m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i10;
                SearchResultsActivity searchResultsActivity = this.f20290m;
                switch (i12) {
                    case 0:
                        searchResultsActivity.T = 0;
                        ArrayList<Movie> arrayList2 = searchResultsActivity.U;
                        if (arrayList2.size() <= 0) {
                            searchResultsActivity.d(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList3 = searchResultsActivity.V;
                            arrayList3.clear();
                            arrayList3.addAll(arrayList2);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    case 1:
                        searchResultsActivity.T = 1;
                        ArrayList<Movie> arrayList4 = searchResultsActivity.X;
                        if (arrayList4.size() <= 0) {
                            searchResultsActivity.f(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList5 = searchResultsActivity.V;
                            arrayList5.clear();
                            arrayList5.addAll(arrayList4);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    default:
                        if (searchResultsActivity.W.size() <= 0) {
                            searchResultsActivity.e(0);
                            break;
                        } else {
                            searchResultsActivity.f11793b0.setVisibility(8);
                            searchResultsActivity.f11794c0.setVisibility(0);
                            searchResultsActivity.f11799h0.notifyDataSetChanged();
                            break;
                        }
                }
            }
        });
        this.R.setOnClickListener(new View.OnClickListener(this) { // from class: ub.u1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchResultsActivity f20290m;

            {
                this.f20290m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                SearchResultsActivity searchResultsActivity = this.f20290m;
                switch (i12) {
                    case 0:
                        searchResultsActivity.T = 0;
                        ArrayList<Movie> arrayList2 = searchResultsActivity.U;
                        if (arrayList2.size() <= 0) {
                            searchResultsActivity.d(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList3 = searchResultsActivity.V;
                            arrayList3.clear();
                            arrayList3.addAll(arrayList2);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    case 1:
                        searchResultsActivity.T = 1;
                        ArrayList<Movie> arrayList4 = searchResultsActivity.X;
                        if (arrayList4.size() <= 0) {
                            searchResultsActivity.f(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList5 = searchResultsActivity.V;
                            arrayList5.clear();
                            arrayList5.addAll(arrayList4);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    default:
                        if (searchResultsActivity.W.size() <= 0) {
                            searchResultsActivity.e(0);
                            break;
                        } else {
                            searchResultsActivity.f11793b0.setVisibility(8);
                            searchResultsActivity.f11794c0.setVisibility(0);
                            searchResultsActivity.f11799h0.notifyDataSetChanged();
                            break;
                        }
                }
            }
        });
        final int i12 = 2;
        this.S.setOnClickListener(new View.OnClickListener(this) { // from class: ub.u1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchResultsActivity f20290m;

            {
                this.f20290m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i122 = i12;
                SearchResultsActivity searchResultsActivity = this.f20290m;
                switch (i122) {
                    case 0:
                        searchResultsActivity.T = 0;
                        ArrayList<Movie> arrayList2 = searchResultsActivity.U;
                        if (arrayList2.size() <= 0) {
                            searchResultsActivity.d(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList3 = searchResultsActivity.V;
                            arrayList3.clear();
                            arrayList3.addAll(arrayList2);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    case 1:
                        searchResultsActivity.T = 1;
                        ArrayList<Movie> arrayList4 = searchResultsActivity.X;
                        if (arrayList4.size() <= 0) {
                            searchResultsActivity.f(0);
                            break;
                        } else {
                            searchResultsActivity.f11794c0.setVisibility(8);
                            searchResultsActivity.f11793b0.setVisibility(0);
                            ArrayList<Movie> arrayList5 = searchResultsActivity.V;
                            arrayList5.clear();
                            arrayList5.addAll(arrayList4);
                            searchResultsActivity.f11798g0.notifyDataSetChanged();
                            break;
                        }
                    default:
                        if (searchResultsActivity.W.size() <= 0) {
                            searchResultsActivity.e(0);
                            break;
                        } else {
                            searchResultsActivity.f11793b0.setVisibility(8);
                            searchResultsActivity.f11794c0.setVisibility(0);
                            searchResultsActivity.f11799h0.notifyDataSetChanged();
                            break;
                        }
                }
            }
        });
        d(1);
        f(1);
        e(1);
        if (App.getInstance().f11574v.getBoolean("pref_hide_unreleased", true)) {
            this.O.setVisibility(0);
        }
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
