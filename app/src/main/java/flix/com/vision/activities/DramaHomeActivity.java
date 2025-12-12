package flix.com.vision.activities;

import a2.x;
import ac.m;
import ac.n;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaFavoritesActivity;
import flix.com.vision.activities.DramaFilterActivity;
import flix.com.vision.activities.DramaHistoryActivity;
import flix.com.vision.activities.DramaHomeActivity;
import flix.com.vision.activities.DramaSearchActivityMobile;
import flix.com.vision.activities.DramaSearchResultActivity;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.models.Drama;
import flix.com.vision.tv.Constant;
import gd.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kc.d;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ub.f;
import ub.r;
import ub.u;
import ub.v;

/* loaded from: classes2.dex */
public class DramaHomeActivity extends wb.a implements e {

    /* renamed from: x0, reason: collision with root package name */
    public static final /* synthetic */ int f11619x0 = 0;
    public ScrollView K;
    public MaterialSearchView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public RelativeLayout P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public TextView U;
    public ImageView V;
    public ImageView W;
    public ImageView X;
    public ImageView Y;
    public ArrayList<Drama> Z;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList<Drama> f11620a0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList<Drama> f11621b0;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList<Drama> f11622c0;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList<Drama> f11623d0;

    /* renamed from: e0, reason: collision with root package name */
    public ArrayList<Drama> f11624e0;

    /* renamed from: f0, reason: collision with root package name */
    public ArrayList<Drama> f11625f0;

    /* renamed from: g0, reason: collision with root package name */
    public m f11626g0;

    /* renamed from: h0, reason: collision with root package name */
    public m f11627h0;

    /* renamed from: i0, reason: collision with root package name */
    public m f11628i0;

    /* renamed from: j0, reason: collision with root package name */
    public m f11629j0;

    /* renamed from: k0, reason: collision with root package name */
    public m f11630k0;

    /* renamed from: l0, reason: collision with root package name */
    public m f11631l0;

    /* renamed from: m0, reason: collision with root package name */
    public RecyclerView f11632m0;

    /* renamed from: n0, reason: collision with root package name */
    public RecyclerView f11633n0;

    /* renamed from: o0, reason: collision with root package name */
    public RecyclerView f11634o0;

    /* renamed from: p0, reason: collision with root package name */
    public RecyclerView f11635p0;

    /* renamed from: q0, reason: collision with root package name */
    public RecyclerView f11636q0;

    /* renamed from: r0, reason: collision with root package name */
    public RecyclerView f11637r0;

    /* renamed from: s0, reason: collision with root package name */
    public RecyclerView f11638s0;

    /* renamed from: t0, reason: collision with root package name */
    public n f11639t0;

    /* renamed from: u0, reason: collision with root package name */
    public d f11640u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f11641v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public String f11642w0 = "https://kissasiantv.to";

    public enum DRAMA_TYPE {
        /* JADX INFO: Fake field, exist only in values array */
        CONTINUE,
        ONGOING,
        ACTION,
        MYSTERY,
        VARIETY,
        ROMANCE,
        COMPLETED,
        /* JADX INFO: Fake field, exist only in values array */
        NEW_AND_HOT
    }

    public class a implements MaterialSearchView.OnQueryTextListener {
        public a() {
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) throws UnsupportedEncodingException {
            if (str.length() > 1) {
                int i10 = DramaHomeActivity.f11619x0;
                DramaHomeActivity dramaHomeActivity = DramaHomeActivity.this;
                dramaHomeActivity.getClass();
                ArrayList arrayList = new ArrayList();
                String strConcat = "http://suggestqueries.google.com/complete/search?client=youtube&ds=yt&q=".concat(str);
                try {
                    URLEncoder.encode(str, "UTF-8");
                    App.getInstance().addToRequestQueue(new d4.m(0, strConcat, new x(6, dramaHomeActivity, arrayList), new u8.a(27)), "MOVIES_App_Update_version");
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
            DramaHomeActivity dramaHomeActivity = DramaHomeActivity.this;
            if (zIsTVDevice) {
                Intent intent = new Intent(dramaHomeActivity, (Class<?>) AnimeSearchResultActivty.class);
                intent.putExtra("query", str);
                dramaHomeActivity.startActivity(intent);
                return false;
            }
            Intent intent2 = new Intent(dramaHomeActivity, (Class<?>) AnimeSearchResultActivityClassic.class);
            intent2.putExtra("query", str);
            dramaHomeActivity.startActivity(intent2);
            return false;
        }
    }

    public class b extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11651a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11652b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DRAMA_TYPE f11653c;

        public b(String str, ArrayList arrayList, DRAMA_TYPE drama_type) {
            this.f11651a = str;
            this.f11652b = arrayList;
            this.f11653c = drama_type;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            try {
                String str = this.f11651a;
                this.f11652b.addAll(DramaHomeActivity.this.d(ch.a.parse(App.get(str, str).body().string())));
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
            int iOrdinal = this.f11653c.ordinal();
            ArrayList arrayList = this.f11652b;
            DramaHomeActivity dramaHomeActivity = DramaHomeActivity.this;
            switch (iOrdinal) {
                case 1:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11620a0.addAll(arrayList);
                        dramaHomeActivity.f11626g0.notifyDataSetChanged();
                        dramaHomeActivity.f11633n0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11632m0.setVisibility(8);
                        break;
                    }
                case 2:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11623d0.addAll(arrayList);
                        dramaHomeActivity.f11629j0.notifyDataSetChanged();
                        dramaHomeActivity.f11636q0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11636q0.setVisibility(8);
                        break;
                    }
                case 3:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11624e0.addAll(arrayList);
                        dramaHomeActivity.f11630k0.notifyDataSetChanged();
                        dramaHomeActivity.f11637r0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11637r0.setVisibility(8);
                        break;
                    }
                case 4:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11625f0.addAll(arrayList);
                        dramaHomeActivity.f11631l0.notifyDataSetChanged();
                        dramaHomeActivity.f11638s0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11638s0.setVisibility(8);
                        break;
                    }
                case 5:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11622c0.addAll(arrayList);
                        dramaHomeActivity.f11628i0.notifyDataSetChanged();
                        dramaHomeActivity.f11635p0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11635p0.setVisibility(8);
                        break;
                    }
                case 6:
                    if (!arrayList.isEmpty()) {
                        dramaHomeActivity.f11621b0.addAll(arrayList);
                        dramaHomeActivity.f11627h0.notifyDataSetChanged();
                        dramaHomeActivity.f11634o0.invalidate();
                        arrayList.clear();
                        break;
                    } else {
                        dramaHomeActivity.f11634o0.setVisibility(8);
                        break;
                    }
            }
        }
    }

    public final ArrayList<Drama> d(Document document) {
        ArrayList<Drama> arrayList = new ArrayList<>();
        Iterator<Element> it = document.select("div.list-drama div.item").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            try {
                Drama drama = new Drama();
                Element elementFirst = next.getElementsByTag("IMG").first();
                if (elementFirst != null) {
                    String strAttr = elementFirst.attr("alt");
                    String str = "https://" + elementFirst.attr("src");
                    drama.f12389n = strAttr;
                    drama.f12392q = str;
                }
                drama.f12391p = this.f11642w0 + next.getElementsByTag("A").first().attr("href");
                try {
                    if (drama.f12389n.toLowerCase().endsWith(")")) {
                        String strSubstring = drama.f12389n.substring(r3.length() - 6);
                        drama.f12389n = drama.f12389n.replace(strSubstring, "").trim();
                        drama.f12387b = strSubstring.replace("(", "").replace(")", "");
                    }
                } catch (Exception unused) {
                }
                if (!arrayList.contains(drama)) {
                    arrayList.add(drama);
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }

    public final void e() {
        ArrayList<Drama> dramaContinue = App.getInstance().f11573u.getDramaContinue();
        if (dramaContinue.isEmpty()) {
            this.f11632m0.setVisibility(8);
            this.U.setVisibility(8);
            return;
        }
        this.Z.clear();
        this.Z.addAll(dramaContinue);
        this.f11639t0.notifyDataSetChanged();
        this.f11632m0.setVisibility(0);
        this.U.setVisibility(0);
        dramaContinue.clear();
    }

    @SuppressLint({"StaticFieldLeak"})
    public final void f(DRAMA_TYPE drama_type, String str) {
        new b(str, new ArrayList(), drama_type).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        if (this.f11641v0) {
            this.f11641v0 = false;
            finish();
        } else {
            this.K.fullScroll(33);
            Toast.makeText(getBaseContext(), "Press again to Exit", 0).show();
            this.f11641v0 = true;
            new Handler().postDelayed(new r(this, 1), 1600L);
        }
    }

    public void onContinueLongPress(int i10) {
        Drama drama = this.Z.get(i10);
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, true);
        dVarNewInstance.setTitle(drama.f12389n);
        dVarNewInstance.setMessage("What would you like to Do?");
        int i11 = 0;
        dVarNewInstance.setButton1("MARK AS WATCHED", new u(this, drama, i10, i11));
        dVarNewInstance.setButton2("ADD TO FAVORITES", new v(i11, this, drama));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.f11642w0 = sharedPreferences.getString("pref_drama_host", "https://kissasiantv.to");
        setContentView(App.K ? R.layout.activity_drama_home : R.layout.activity_drama_home_light);
        FragmentManager fragmentManager = getFragmentManager();
        final int i10 = 0;
        d dVarNewInstance = d.newInstance(this, false);
        this.f11640u0 = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.f11640u0.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new Handler().postDelayed(new r(this, 0), 5000L);
        this.K = (ScrollView) findViewById(R.id.scrollview_drama_home);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.L = materialSearchView;
        final int i11 = 1;
        if (materialSearchView != null) {
            materialSearchView.setShouldKeepHistory(false);
            this.L.setTintAlpha(1);
            this.L.setOnQueryTextListener(new a());
            this.L.setOnItemClickListener(new f(this, i11));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(getString(R.string.anime_label));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.U = (TextView) findViewById(R.id.continue_label);
        this.Y = (ImageView) findViewById(R.id.filter_anime_button_imageview);
        this.X = (ImageView) findViewById(R.id.search_anime_button_imageview);
        this.W = (ImageView) findViewById(R.id.progress_anime_button_image);
        this.V = (ImageView) findViewById(R.id.anime_fav_textview_button_imageview);
        this.T = (TextView) findViewById(R.id.anime_fav_textview);
        this.S = (TextView) findViewById(R.id.progress_anime_textview);
        this.Q = (TextView) findViewById(R.id.filter_anime__textview);
        this.R = (TextView) findViewById(R.id.search_anime__textview);
        this.P = (RelativeLayout) findViewById(R.id.filter_anime_button);
        this.O = (RelativeLayout) findViewById(R.id.search_anime_button);
        this.N = (RelativeLayout) findViewById(R.id.anime_history_button);
        this.M = (RelativeLayout) findViewById(R.id.anime_favorites);
        this.f11632m0 = (RecyclerView) findViewById(R.id.recyclerview_continue);
        this.f11633n0 = (RecyclerView) findViewById(R.id.recyclerview_dramma_ongoing);
        this.f11634o0 = (RecyclerView) findViewById(R.id.recyclerview_dramma_completed);
        this.f11635p0 = (RecyclerView) findViewById(R.id.recyclerview_romance);
        this.f11636q0 = (RecyclerView) findViewById(R.id.recyclerview_action);
        this.f11637r0 = (RecyclerView) findViewById(R.id.recyclerview_mystery);
        this.f11636q0 = (RecyclerView) findViewById(R.id.recyclerview_action);
        this.f11638s0 = (RecyclerView) findViewById(R.id.recyclerview_variety_show);
        this.Z = new ArrayList<>();
        this.f11623d0 = new ArrayList<>();
        this.f11622c0 = new ArrayList<>();
        this.f11624e0 = new ArrayList<>();
        this.f11621b0 = new ArrayList<>();
        this.f11620a0 = new ArrayList<>();
        this.f11625f0 = new ArrayList<>();
        this.f11639t0 = new n(this.Z, this, this);
        this.f11629j0 = new m(this.f11623d0, this, this);
        this.f11628i0 = new m(this.f11622c0, this, this);
        this.f11630k0 = new m(this.f11624e0, this, this);
        this.f11626g0 = new m(this.f11620a0, this, this);
        this.f11631l0 = new m(this.f11625f0, this, this);
        this.f11627h0 = new m(this.f11621b0, this, this);
        this.f11638s0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11638s0.setAdapter(this.f11631l0);
        o1.a.h(15, this.f11638s0);
        this.f11637r0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11637r0.setAdapter(this.f11630k0);
        o1.a.h(15, this.f11637r0);
        this.f11634o0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11634o0.setAdapter(this.f11627h0);
        o1.a.h(15, this.f11634o0);
        this.f11635p0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11635p0.setAdapter(this.f11628i0);
        o1.a.h(15, this.f11635p0);
        this.f11632m0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11632m0.setAdapter(this.f11639t0);
        o1.a.h(15, this.f11632m0);
        this.f11633n0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11633n0.setAdapter(this.f11626g0);
        o1.a.h(15, this.f11633n0);
        this.f11636q0.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.f11636q0.setAdapter(this.f11629j0);
        o1.a.h(15, this.f11636q0);
        final int i12 = 3;
        final int i13 = 2;
        if (this.P != null) {
            this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.s

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20266m;

                {
                    this.f20266m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i10;
                    DramaHomeActivity dramaHomeActivity = this.f20266m;
                    switch (i14) {
                        case 0:
                            int i15 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            if (!App.K) {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchActivityMobile.class));
                                break;
                            } else {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchResultActivity.class));
                                break;
                            }
                        case 1:
                            int i16 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFavoritesActivity.class));
                            break;
                        case 2:
                            int i17 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaHistoryActivity.class));
                            break;
                        default:
                            int i18 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFilterActivity.class));
                            break;
                    }
                }
            });
            this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.s

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20266m;

                {
                    this.f20266m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i11;
                    DramaHomeActivity dramaHomeActivity = this.f20266m;
                    switch (i14) {
                        case 0:
                            int i15 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            if (!App.K) {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchActivityMobile.class));
                                break;
                            } else {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchResultActivity.class));
                                break;
                            }
                        case 1:
                            int i16 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFavoritesActivity.class));
                            break;
                        case 2:
                            int i17 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaHistoryActivity.class));
                            break;
                        default:
                            int i18 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFilterActivity.class));
                            break;
                    }
                }
            });
            this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.s

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20266m;

                {
                    this.f20266m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i13;
                    DramaHomeActivity dramaHomeActivity = this.f20266m;
                    switch (i14) {
                        case 0:
                            int i15 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            if (!App.K) {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchActivityMobile.class));
                                break;
                            } else {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchResultActivity.class));
                                break;
                            }
                        case 1:
                            int i16 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFavoritesActivity.class));
                            break;
                        case 2:
                            int i17 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaHistoryActivity.class));
                            break;
                        default:
                            int i18 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFilterActivity.class));
                            break;
                    }
                }
            });
            this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ub.s

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20266m;

                {
                    this.f20266m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i14 = i12;
                    DramaHomeActivity dramaHomeActivity = this.f20266m;
                    switch (i14) {
                        case 0:
                            int i15 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            if (!App.K) {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchActivityMobile.class));
                                break;
                            } else {
                                dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaSearchResultActivity.class));
                                break;
                            }
                        case 1:
                            int i16 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFavoritesActivity.class));
                            break;
                        case 2:
                            int i17 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaHistoryActivity.class));
                            break;
                        default:
                            int i18 = DramaHomeActivity.f11619x0;
                            dramaHomeActivity.getClass();
                            dramaHomeActivity.startActivity(new Intent(dramaHomeActivity, (Class<?>) DramaFilterActivity.class));
                            break;
                    }
                }
            });
        }
        RelativeLayout relativeLayout = this.P;
        if (relativeLayout != null) {
            relativeLayout.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.t

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20275m;

                {
                    this.f20275m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i10;
                    DramaHomeActivity dramaHomeActivity = this.f20275m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.P.animate().scaleX(1.0f).start();
                                dramaHomeActivity.P.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.P, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.P, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.M.animate().scaleX(1.0f).start();
                                dramaHomeActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.M, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.M, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.N.animate().scaleX(1.0f).start();
                                dramaHomeActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.N, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.N, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.O.animate().scaleX(1.0f).start();
                                dramaHomeActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.O, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.O, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout2 = this.M;
        if (relativeLayout2 != null) {
            relativeLayout2.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.t

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20275m;

                {
                    this.f20275m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i11;
                    DramaHomeActivity dramaHomeActivity = this.f20275m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.P.animate().scaleX(1.0f).start();
                                dramaHomeActivity.P.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.P, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.P, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.M.animate().scaleX(1.0f).start();
                                dramaHomeActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.M, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.M, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.N.animate().scaleX(1.0f).start();
                                dramaHomeActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.N, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.N, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.O.animate().scaleX(1.0f).start();
                                dramaHomeActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.O, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.O, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout3 = this.N;
        if (relativeLayout3 != null) {
            relativeLayout3.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.t

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20275m;

                {
                    this.f20275m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i13;
                    DramaHomeActivity dramaHomeActivity = this.f20275m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.P.animate().scaleX(1.0f).start();
                                dramaHomeActivity.P.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.P, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.P, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.M.animate().scaleX(1.0f).start();
                                dramaHomeActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.M, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.M, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.N.animate().scaleX(1.0f).start();
                                dramaHomeActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.N, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.N, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.O.animate().scaleX(1.0f).start();
                                dramaHomeActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.O, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.O, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        RelativeLayout relativeLayout4 = this.O;
        if (relativeLayout4 != null) {
            relativeLayout4.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.t

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ DramaHomeActivity f20275m;

                {
                    this.f20275m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i12;
                    DramaHomeActivity dramaHomeActivity = this.f20275m;
                    switch (i14) {
                        case 0:
                            if (!z10) {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.P.animate().scaleX(1.0f).start();
                                dramaHomeActivity.P.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.Y.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.Q.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.P, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.P, 100L, 1.03f);
                                break;
                            }
                        case 1:
                            if (!z10) {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.M.animate().scaleX(1.0f).start();
                                dramaHomeActivity.M.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.V.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.T.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.M, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.M, 100L, 1.03f);
                                break;
                            }
                        case 2:
                            if (!z10) {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.N.animate().scaleX(1.0f).start();
                                dramaHomeActivity.N.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.W.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.S.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.N, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.N, 100L, 1.03f);
                                break;
                            }
                        default:
                            if (!z10) {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.white), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.white));
                                dramaHomeActivity.O.animate().scaleX(1.0f).start();
                                dramaHomeActivity.O.animate().scaleY(1.0f).start();
                                break;
                            } else {
                                dramaHomeActivity.X.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(dramaHomeActivity, R.color.black), PorterDuff.Mode.SRC_IN));
                                dramaHomeActivity.R.setTextColor(dramaHomeActivity.getResources().getColor(R.color.black));
                                o1.a.k(dramaHomeActivity.O, 100L, 1.03f);
                                o1.a.r(dramaHomeActivity.O, 100L, 1.03f);
                                break;
                            }
                    }
                }
            });
        }
        e();
        f(DRAMA_TYPE.ONGOING, this.f11642w0 + "/drama-list/ongoing.html");
        f(DRAMA_TYPE.COMPLETED, this.f11642w0 + "/drama-list/completed.html");
        f(DRAMA_TYPE.ACTION, this.f11642w0 + "/genre/action/");
        f(DRAMA_TYPE.MYSTERY, this.f11642w0 + "/genre/mystery/");
        f(DRAMA_TYPE.ROMANCE, this.f11642w0 + "/genre/romance/");
        f(DRAMA_TYPE.VARIETY, this.f11642w0 + "/genre/variety-show/");
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        e();
    }

    @Override // gd.e
    public void openDrama(Drama drama) {
        Intent intent = new Intent(this, (Class<?>) DramaDetailActivity.class);
        intent.putExtra("drama", drama);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // gd.e
    public void removeDramaFromFavorites(Drama drama) {
    }
}
