package flix.com.vision.activities;

import a2.x;
import ac.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.uwetrottmann.trakt5.TraktV2;
import d4.m;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.AnimeHistoryActivity;
import flix.com.vision.activities.AnimeSearchResultActivty;
import flix.com.vision.activities.AnimesFavoritesAcvivity;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.models.Anime;
import gd.d;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import ub.f;
import ub.g;

/* loaded from: classes2.dex */
public class AnimesListActivity extends wb.a implements d {

    /* renamed from: f0, reason: collision with root package name */
    public static final /* synthetic */ int f11597f0 = 0;
    public MaterialSearchView K;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public ImageView T;
    public ImageView U;
    public ImageView V;
    public ImageView W;
    public RelativeLayout Z;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList<Anime> f11599b0;

    /* renamed from: c0, reason: collision with root package name */
    public h f11600c0;

    /* renamed from: d0, reason: collision with root package name */
    public SuperRecyclerView f11601d0;
    public int X = 0;
    public final int Y = 200;

    /* renamed from: a0, reason: collision with root package name */
    public final String f11598a0 = "";

    /* renamed from: e0, reason: collision with root package name */
    public boolean f11602e0 = false;

    public class a implements MaterialSearchView.OnQueryTextListener {
        public a() {
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) throws UnsupportedEncodingException {
            if (str.length() > 1) {
                int i10 = AnimesListActivity.f11597f0;
                AnimesListActivity animesListActivity = AnimesListActivity.this;
                animesListActivity.getClass();
                ArrayList arrayList = new ArrayList();
                String strConcat = "http://suggestqueries.google.com/complete/search?client=youtube&ds=yt&q=".concat(str);
                try {
                    URLEncoder.encode(str, "UTF-8");
                    App.getInstance().addToRequestQueue(new m(0, strConcat, new x(5, animesListActivity, arrayList), new u8.a(24)), "MOVIES_App_Update_version");
                } catch (Exception unused) {
                }
            }
            return false;
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            if (str == null || str.length() < 1) {
                return false;
            }
            boolean zIsTVDevice = App.getInstance().isTVDevice();
            AnimesListActivity animesListActivity = AnimesListActivity.this;
            if (zIsTVDevice) {
                Intent intent = new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivty.class);
                intent.putExtra("query", str);
                animesListActivity.startActivity(intent);
                return false;
            }
            Intent intent2 = new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivityClassic.class);
            intent2.putExtra("query", str);
            animesListActivity.startActivity(intent2);
            return false;
        }
    }

    public class b extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public void ExtractDominentColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 5));
        valueAnimatorOfObject.addListener(new b());
        valueAnimatorOfObject.start();
    }

    public void applyFilter() {
        recreate();
    }

    public final void d(int i10) {
        String string = App.getInstance().f11574v.getString("server_anime", "1");
        String string2 = App.getInstance().f11574v.getString("genre_anime", "");
        String string3 = App.getInstance().f11574v.getString("year_anime", "");
        String string4 = App.getInstance().f11574v.getString("type_anime", "");
        String string5 = App.getInstance().f11574v.getString("lang_anime", "");
        if (string2.equals("All")) {
            string2 = "";
        }
        string4.equals("All");
        if (string3.equals("All")) {
            string3 = "";
        }
        if (string5.equals("All")) {
            string5 = "";
        }
        this.f11599b0.addAll(App.getInstance().f11573u.getGoAnime(string2, string3, string.equals(TraktV2.API_VERSION) ? "" : string5, i10));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        if (this.f11602e0) {
            this.f11602e0 = false;
            finish();
            return;
        }
        Toast.makeText(getBaseContext(), "Press again to Exit", 0).show();
        if (this.f11599b0.size() < 200) {
            this.f11601d0.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.f11601d0.getRecyclerView().scrollToPosition(0);
        }
        this.f11602e0 = true;
        new Handler().postDelayed(new ub.h(this, 1), 1600L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(App.K ? R.layout.activity_animes_list : R.layout.activity_animes_list_light);
        this.Z = (RelativeLayout) findViewById(R.id.activity_player);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.K = materialSearchView;
        final int i10 = 1;
        final int i11 = 0;
        if (materialSearchView != null) {
            materialSearchView.setShouldKeepHistory(false);
            this.K.setTintAlpha(1);
            this.K.setOnQueryTextListener(new a());
            this.K.setOnItemClickListener(new f(this, i11));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(getString(R.string.anime_label));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.W = (ImageView) findViewById(R.id.filter_anime_button_imageview);
        this.V = (ImageView) findViewById(R.id.search_anime_button_imageview);
        this.U = (ImageView) findViewById(R.id.progress_anime_button_image);
        this.T = (ImageView) findViewById(R.id.anime_fav_textview_button_imageview);
        this.S = (TextView) findViewById(R.id.anime_fav_textview);
        this.R = (TextView) findViewById(R.id.progress_anime_textview);
        this.P = (TextView) findViewById(R.id.filter_anime__textview);
        this.Q = (TextView) findViewById(R.id.search_anime__textview);
        this.O = (RelativeLayout) findViewById(R.id.filter_anime_button);
        this.N = (RelativeLayout) findViewById(R.id.search_anime_button);
        this.M = (RelativeLayout) findViewById(R.id.anime_history_button);
        this.L = (RelativeLayout) findViewById(R.id.anime_favorites);
        this.f11601d0 = (SuperRecyclerView) findViewById(R.id.recyclerview);
        final int i12 = 3;
        final int i13 = 2;
        if (this.O != null) {
            this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20199m;

                {
                    this.f20199m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i11;
                    AnimesListActivity animesListActivity = this.f20199m;
                    switch (i14) {
                        case 0:
                            int i15 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivty.class));
                            break;
                        case 1:
                            int i16 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimesFavoritesAcvivity.class));
                            break;
                        case 2:
                            int i17 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeHistoryActivity.class));
                            break;
                        default:
                            int i18 = AnimesListActivity.f11597f0;
                            try {
                                ed.a.newInstance(false, animesListActivity).show(animesListActivity.getFragmentManager(), "");
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                    }
                }
            });
            this.L.setOnClickListener(new View.OnClickListener(this) { // from class: ub.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20199m;

                {
                    this.f20199m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i10;
                    AnimesListActivity animesListActivity = this.f20199m;
                    switch (i14) {
                        case 0:
                            int i15 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivty.class));
                            break;
                        case 1:
                            int i16 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimesFavoritesAcvivity.class));
                            break;
                        case 2:
                            int i17 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeHistoryActivity.class));
                            break;
                        default:
                            int i18 = AnimesListActivity.f11597f0;
                            try {
                                ed.a.newInstance(false, animesListActivity).show(animesListActivity.getFragmentManager(), "");
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                    }
                }
            });
            this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20199m;

                {
                    this.f20199m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i13;
                    AnimesListActivity animesListActivity = this.f20199m;
                    switch (i14) {
                        case 0:
                            int i15 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivty.class));
                            break;
                        case 1:
                            int i16 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimesFavoritesAcvivity.class));
                            break;
                        case 2:
                            int i17 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeHistoryActivity.class));
                            break;
                        default:
                            int i18 = AnimesListActivity.f11597f0;
                            try {
                                ed.a.newInstance(false, animesListActivity).show(animesListActivity.getFragmentManager(), "");
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                    }
                }
            });
            this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20199m;

                {
                    this.f20199m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i12;
                    AnimesListActivity animesListActivity = this.f20199m;
                    switch (i14) {
                        case 0:
                            int i15 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeSearchResultActivty.class));
                            break;
                        case 1:
                            int i16 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimesFavoritesAcvivity.class));
                            break;
                        case 2:
                            int i17 = AnimesListActivity.f11597f0;
                            animesListActivity.getClass();
                            animesListActivity.startActivity(new Intent(animesListActivity, (Class<?>) AnimeHistoryActivity.class));
                            break;
                        default:
                            int i18 = AnimesListActivity.f11597f0;
                            try {
                                ed.a.newInstance(false, animesListActivity).show(animesListActivity.getFragmentManager(), "");
                                break;
                            } catch (Exception e10) {
                                e10.printStackTrace();
                                return;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout = this.O;
        if (relativeLayout != null) {
            relativeLayout.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20206m;

                {
                    this.f20206m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i11;
                    AnimesListActivity animesListActivity = this.f20206m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.O.animate().scaleX(1.0f).start();
                                animesListActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.O, 100L, 1.03f);
                                o1.a.r(animesListActivity.O, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.L.animate().scaleX(1.0f).start();
                                animesListActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.L, 100L, 1.03f);
                                o1.a.r(animesListActivity.L, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.M.animate().scaleX(1.0f).start();
                                animesListActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.M, 100L, 1.03f);
                                o1.a.r(animesListActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.N.animate().scaleX(1.0f).start();
                                animesListActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.N, 100L, 1.03f);
                                o1.a.r(animesListActivity.N, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout2 = this.L;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20206m;

                {
                    this.f20206m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i10;
                    AnimesListActivity animesListActivity = this.f20206m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.O.animate().scaleX(1.0f).start();
                                animesListActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.O, 100L, 1.03f);
                                o1.a.r(animesListActivity.O, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.L.animate().scaleX(1.0f).start();
                                animesListActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.L, 100L, 1.03f);
                                o1.a.r(animesListActivity.L, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.M.animate().scaleX(1.0f).start();
                                animesListActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.M, 100L, 1.03f);
                                o1.a.r(animesListActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.N.animate().scaleX(1.0f).start();
                                animesListActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.N, 100L, 1.03f);
                                o1.a.r(animesListActivity.N, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout3 = this.M;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20206m;

                {
                    this.f20206m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i13;
                    AnimesListActivity animesListActivity = this.f20206m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.O.animate().scaleX(1.0f).start();
                                animesListActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.O, 100L, 1.03f);
                                o1.a.r(animesListActivity.O, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.L.animate().scaleX(1.0f).start();
                                animesListActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.L, 100L, 1.03f);
                                o1.a.r(animesListActivity.L, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.M.animate().scaleX(1.0f).start();
                                animesListActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.M, 100L, 1.03f);
                                o1.a.r(animesListActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.N.animate().scaleX(1.0f).start();
                                animesListActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.N, 100L, 1.03f);
                                o1.a.r(animesListActivity.N, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout4 = this.N;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.j

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ AnimesListActivity f20206m;

                {
                    this.f20206m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i12;
                    AnimesListActivity animesListActivity = this.f20206m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.O.animate().scaleX(1.0f).start();
                                animesListActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.P.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.O, 100L, 1.03f);
                                o1.a.r(animesListActivity.O, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.L.animate().scaleX(1.0f).start();
                                animesListActivity.L.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.T.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.S.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.L, 100L, 1.03f);
                                o1.a.r(animesListActivity.L, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.M.animate().scaleX(1.0f).start();
                                animesListActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.U.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.R.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.M, 100L, 1.03f);
                                o1.a.r(animesListActivity.M, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.white));
                                animesListActivity.N.animate().scaleX(1.0f).start();
                                animesListActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                animesListActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(animesListActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                animesListActivity.Q.setTextColor(animesListActivity.getResources().getColor(R.color.black));
                                o1.a.k(animesListActivity.N, 100L, 1.03f);
                                o1.a.r(animesListActivity.N, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        this.f11601d0.setRefreshListener(new g(this));
        this.f11599b0 = new ArrayList<>();
        this.f11600c0 = new h(getBaseContext(), this.f11599b0, this, this.Y, this);
        this.f11601d0.setLayoutManager(new CenterGridLayoutManager(this, Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.f11601d0.addItemDecoration(new c(12));
        this.f11601d0.setAdapter(this.f11600c0);
        this.f11601d0.setupMoreListener(new g(this), 10);
        this.f11601d0.requestFocus();
        d(this.X);
        new Handler().postDelayed(new ub.h(this, 0), 800L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anime_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_search) {
            this.K.openSearch();
        } else if (itemId == R.id.action_filter) {
            try {
                ed.a.newInstance(false, this).show(getFragmentManager(), "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (itemId == 16908332) {
            finish();
        } else if (itemId == R.id.action_favorites_anime) {
            startActivity(new Intent(this, (Class<?>) AnimesFavoritesAcvivity.class));
        } else if (itemId == R.id.action_history_anime) {
            startActivity(new Intent(this, (Class<?>) AnimeHistoryActivity.class));
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.d
    public void openAnime(Anime anime) {
        Intent intent = new Intent(this, (Class<?>) AnimeDetailActivity.class);
        String strTrim = anime.f12380n;
        if (strTrim.toLowerCase().contains("(dub)")) {
            strTrim = strTrim.toLowerCase().replace("(dub)", "").trim();
        }
        if (strTrim.toLowerCase().contains("(sub)")) {
            strTrim = strTrim.toLowerCase().replace("(sub)", "").trim();
        }
        if (strTrim.toLowerCase().endsWith(")")) {
            String strSubstring = strTrim.substring(strTrim.length() - 6);
            strTrim.replace(strSubstring, "").getClass();
            anime.f12378b = strSubstring.replace("(", "").replace(")", "");
        }
        String str = anime.f12378b;
        if (str != null && str.length() == 4) {
            anime.f12380n = anime.f12380n.replace("(" + anime.f12378b + ")", "");
        }
        intent.putExtra("anime", anime);
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
