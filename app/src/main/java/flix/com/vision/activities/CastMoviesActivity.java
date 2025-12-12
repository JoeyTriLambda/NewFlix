package flix.com.vision.activities;

import ac.t;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.unity3d.ads.metadata.MediationMetaData;
import de.hdodenhof.circleimageview.CircleImageView;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.CastMoviesActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.j;
import java.util.ArrayList;
import java.util.Collections;
import ub.l;

/* loaded from: classes2.dex */
public class CastMoviesActivity extends wb.a implements j {

    /* renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f11604f0 = 0;
    public c4.a K;
    public Typeface L;
    public String P;
    public TextView Q;
    public TextView R;
    public long S;
    public CircleImageView T;
    public Toolbar U;
    public RecyclerView V;
    public RelativeLayout W;
    public RelativeLayout X;
    public RelativeLayout Y;
    public qe.b Z;

    /* renamed from: a0, reason: collision with root package name */
    public t f11605a0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f11607c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11608d0;
    public final ArrayList<Movie> M = new ArrayList<>();
    public final ArrayList<Movie> N = new ArrayList<>();
    public final ArrayList<Movie> O = new ArrayList<>();

    /* renamed from: b0, reason: collision with root package name */
    public String f11606b0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public int f11609e0 = 0;

    @SuppressLint({"CheckResult"})
    public final void d() {
        qe.b bVar = this.Z;
        if (bVar != null) {
            bVar.dispose();
        }
        this.Z = bc.a.getDetailCast(this, "movie_credits", this.S, false).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new l(this, 0), new u8.a(25));
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_cast_movies);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.L = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.K = new c4.a();
        final int i10 = 0;
        this.f11609e0 = getIntent().getIntExtra("gender", 0);
        this.P = getIntent().getStringExtra(MediationMetaData.KEY_NAME);
        this.S = getIntent().getLongExtra("id", 0L);
        getIntent().getIntExtra("type", 0);
        this.f11606b0 = getIntent().getStringExtra("image");
        this.f11608d0 = (TextView) findViewById(R.id.cast_name_text);
        this.X = (RelativeLayout) findViewById(R.id.series_button);
        this.W = (RelativeLayout) findViewById(R.id.movies_button);
        this.T = (CircleImageView) findViewById(R.id.image_cast);
        this.R = (TextView) findViewById(R.id.label_series_button);
        this.Q = (TextView) findViewById(R.id.label_movies_button);
        this.K.applyFontToView(this.R, this.L);
        this.K.applyFontToView(this.Q, this.L);
        this.X.setOnClickListener(new View.OnClickListener(this) { // from class: ub.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ CastMoviesActivity f20215m;

            {
                this.f20215m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                CastMoviesActivity castMoviesActivity = this.f20215m;
                switch (i11) {
                    case 0:
                        ArrayList<Movie> arrayList = castMoviesActivity.O;
                        if (arrayList.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList2 = castMoviesActivity.N;
                            arrayList2.clear();
                            arrayList2.addAll(arrayList);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    case 1:
                        ArrayList<Movie> arrayList3 = castMoviesActivity.M;
                        if (arrayList3.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList4 = castMoviesActivity.N;
                            arrayList4.clear();
                            arrayList4.addAll(arrayList3);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    default:
                        boolean z10 = castMoviesActivity.f11607c0;
                        ArrayList<Movie> arrayList5 = castMoviesActivity.N;
                        if (!z10) {
                            Collections.sort(arrayList5);
                            castMoviesActivity.f11607c0 = true;
                            be.d.makeToast(castMoviesActivity.getBaseContext(), "Sorted by Year: DESC", true);
                        }
                        Collections.reverse(arrayList5);
                        castMoviesActivity.f11605a0.notifyDataSetChanged();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.W.setOnClickListener(new View.OnClickListener(this) { // from class: ub.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ CastMoviesActivity f20215m;

            {
                this.f20215m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                CastMoviesActivity castMoviesActivity = this.f20215m;
                switch (i112) {
                    case 0:
                        ArrayList<Movie> arrayList = castMoviesActivity.O;
                        if (arrayList.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList2 = castMoviesActivity.N;
                            arrayList2.clear();
                            arrayList2.addAll(arrayList);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    case 1:
                        ArrayList<Movie> arrayList3 = castMoviesActivity.M;
                        if (arrayList3.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList4 = castMoviesActivity.N;
                            arrayList4.clear();
                            arrayList4.addAll(arrayList3);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    default:
                        boolean z10 = castMoviesActivity.f11607c0;
                        ArrayList<Movie> arrayList5 = castMoviesActivity.N;
                        if (!z10) {
                            Collections.sort(arrayList5);
                            castMoviesActivity.f11607c0 = true;
                            be.d.makeToast(castMoviesActivity.getBaseContext(), "Sorted by Year: DESC", true);
                        }
                        Collections.reverse(arrayList5);
                        castMoviesActivity.f11605a0.notifyDataSetChanged();
                        break;
                }
            }
        });
        float f10 = o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density;
        int iRound = Math.round(f10 / (App.K ? 140 : 120));
        if (App.getInstance().f11574v.getBoolean("prefs_show_big_cobers", false)) {
            iRound = Math.round(f10 / 180.0f);
        }
        this.V = (RecyclerView) findViewById(R.id.recyclerview_cast);
        this.Y = (RelativeLayout) findViewById(R.id.sort_button);
        this.V.addItemDecoration(new c(App.K ? 12 : 8));
        this.f11605a0 = new t(getBaseContext(), this.N, this, 0, this, null);
        this.V.setLayoutManager(new CenterGridLayoutManager(this, iRound));
        o1.a.h(8, this.V);
        this.V.setAdapter(this.f11605a0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.U = toolbar;
        setSupportActionBar(toolbar);
        if (this.P != null) {
            getSupportActionBar().setTitle("WITH " + this.P.toUpperCase());
            TextView textView = this.f11608d0;
            if (textView != null) {
                textView.setText(this.P);
            }
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int i12 = 2;
        this.Y.setOnClickListener(new View.OnClickListener(this) { // from class: ub.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ CastMoviesActivity f20215m;

            {
                this.f20215m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                CastMoviesActivity castMoviesActivity = this.f20215m;
                switch (i112) {
                    case 0:
                        ArrayList<Movie> arrayList = castMoviesActivity.O;
                        if (arrayList.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList2 = castMoviesActivity.N;
                            arrayList2.clear();
                            arrayList2.addAll(arrayList);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    case 1:
                        ArrayList<Movie> arrayList3 = castMoviesActivity.M;
                        if (arrayList3.size() <= 0) {
                            castMoviesActivity.d();
                            break;
                        } else {
                            ArrayList<Movie> arrayList4 = castMoviesActivity.N;
                            arrayList4.clear();
                            arrayList4.addAll(arrayList3);
                            castMoviesActivity.f11605a0.notifyDataSetChanged();
                            castMoviesActivity.V.getLayoutManager().scrollToPosition(0);
                            break;
                        }
                    default:
                        boolean z10 = castMoviesActivity.f11607c0;
                        ArrayList<Movie> arrayList5 = castMoviesActivity.N;
                        if (!z10) {
                            Collections.sort(arrayList5);
                            castMoviesActivity.f11607c0 = true;
                            be.d.makeToast(castMoviesActivity.getBaseContext(), "Sorted by Year: DESC", true);
                        }
                        Collections.reverse(arrayList5);
                        castMoviesActivity.f11605a0.notifyDataSetChanged();
                        break;
                }
            }
        });
        this.K.applyFontToToolbar(this.U, this.L);
        this.W.requestFocus();
        d();
        try {
            if (this.f11606b0 != null) {
                Picasso.get().load(this.f11606b0).fit().centerCrop().into(this.T);
                this.T.setBorderColor(getResources().getColor(R.color.white));
            } else {
                Picasso.get().load(this.f11609e0 == 0 ? R.drawable.cast_ : R.drawable.cast_2).fit().centerCrop().into(this.T);
                this.T.setBorderColor(getResources().getColor(R.color.white));
            }
        } catch (Exception unused) {
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
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
