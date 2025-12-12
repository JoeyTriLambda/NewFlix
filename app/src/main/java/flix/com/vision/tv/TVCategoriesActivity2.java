package flix.com.vision.tv;

import ac.c;
import ac.y;
import ae.g;
import ae.h;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import cz.msebera.android.httpclient.HttpHost;
import fd.i;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.tv.TVCategoriesActivity2;
import flix.com.vision.tv.TVCategory;
import gd.l;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import vb.d;

/* loaded from: classes2.dex */
public class TVCategoriesActivity2 extends wb.a implements l {

    /* renamed from: l0, reason: collision with root package name */
    public static final /* synthetic */ int f12477l0 = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public c4.a N;
    public Typeface O;
    public TextView P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public LinearLayout U;
    public LinearLayout V;
    public RecyclerView W;
    public RecyclerView X;
    public y Y;
    public y Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f12478a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f12479b0;

    /* renamed from: c0, reason: collision with root package name */
    public Handler f12480c0;

    /* renamed from: d0, reason: collision with root package name */
    public d f12481d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f12482e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f12483f0;

    /* renamed from: g0, reason: collision with root package name */
    public RelativeLayout f12484g0;

    /* renamed from: h0, reason: collision with root package name */
    public AlphaAnimation f12485h0;

    /* renamed from: k0, reason: collision with root package name */
    public int f12488k0;
    public final ArrayList<TVCategory> T = new ArrayList<>();

    /* renamed from: i0, reason: collision with root package name */
    public boolean f12486i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public HashSet<String> f12487j0 = new HashSet<>();

    public class a extends AsyncTask<String, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public Exception f12489a = null;

        public a() {
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) throws IOException {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(TVCategoriesActivity2.this.f12478a0)))));
                StringBuilder sb2 = new StringBuilder();
                int i10 = 0;
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    i10++;
                    if (i10 > 1000 && line.trim().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        App.getInstance().f11569q.addAll(i.parseChannels(sb2.toString()));
                        publishProgress(new Void[0]);
                        sb2 = new StringBuilder();
                        i10 = 0;
                    }
                    sb2.append(line);
                    sb2.append('\n');
                }
                App.getInstance().f11569q.addAll(i.parseChannels(sb2.toString()));
                e = null;
            } catch (Exception e10) {
                e = e10;
                e.printStackTrace();
            }
            this.f12489a = e;
            return null;
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            TVCategoriesActivity2 tVCategoriesActivity2 = TVCategoriesActivity2.this;
            tVCategoriesActivity2.f12486i0 = true;
            if (App.getInstance().f11569q.size() > 0) {
                tVCategoriesActivity2.d();
                tVCategoriesActivity2.Y.notifyDataSetChanged();
                tVCategoriesActivity2.U.setVisibility(8);
            } else {
                Exception exc = this.f12489a;
                if (exc != null) {
                    Objects.toString(exc);
                }
                tVCategoriesActivity2.U.setVisibility(8);
                Toast.makeText(tVCategoriesActivity2.getBaseContext(), "Failed to load Channels", 1).show();
            }
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
            TVCategoriesActivity2.this.f12483f0.setText(App.getInstance().f11569q.size() + " channels loaded");
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    public class b extends AsyncTask<String, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public Exception f12491a;

        public b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005c, code lost:
        
            r3 = r6.f12492b;
            r4 = r0.toString();
            r3.getClass();
            r3 = flix.com.vision.tv.TVCategoriesActivity2.f12477l0;
            flix.com.vision.App.getInstance().f11569q.addAll(fd.i.parseChannels(r4));
            publishProgress(new java.lang.Void[0]);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String getUrlContents(java.lang.String r7) throws java.io.IOException {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L89
                r1.<init>(r7)     // Catch: java.lang.Exception -> L89
                java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Exception -> L89
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Exception -> L89
                r7.getResponseCode()     // Catch: java.lang.Exception -> L89
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L89
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Exception -> L89
                java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Exception -> L89
                r2.<init>(r7)     // Catch: java.lang.Exception -> L89
                r1.<init>(r2)     // Catch: java.lang.Exception -> L89
            L21:
                r7 = 0
                r2 = 0
            L23:
                java.lang.String r3 = r1.readLine()     // Catch: java.lang.Exception -> L89
                if (r3 == 0) goto L85
                java.lang.String r4 = "EXTVLCOPT"
                boolean r4 = r3.contains(r4)     // Catch: java.lang.Exception -> L89
                if (r4 == 0) goto L32
                goto L23
            L32:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L80
                r4.<init>()     // Catch: java.lang.Exception -> L80
                java.lang.String r5 = r3.trim()     // Catch: java.lang.Exception -> L80
                r4.append(r5)     // Catch: java.lang.Exception -> L80
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch: java.lang.Exception -> L80
                java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L80
                r0.append(r4)     // Catch: java.lang.Exception -> L80
                int r2 = r2 + 1
                r4 = 1000(0x3e8, float:1.401E-42)
                if (r2 <= r4) goto L23
                java.lang.String r3 = r3.trim()     // Catch: java.lang.Exception -> L80
                java.lang.String r4 = "http"
                boolean r3 = r3.startsWith(r4)     // Catch: java.lang.Exception -> L80
                if (r3 == 0) goto L23
                flix.com.vision.tv.TVCategoriesActivity2 r3 = flix.com.vision.tv.TVCategoriesActivity2.this     // Catch: java.lang.Exception -> L80
                java.lang.String r4 = r0.toString()     // Catch: java.lang.Exception -> L80
                r3.getClass()     // Catch: java.lang.Exception -> L80
                int r3 = flix.com.vision.tv.TVCategoriesActivity2.f12477l0     // Catch: java.lang.Exception -> L80
                flix.com.vision.App r3 = flix.com.vision.App.getInstance()     // Catch: java.lang.Exception -> L80
                java.util.ArrayList<hd.d> r3 = r3.f11569q     // Catch: java.lang.Exception -> L80
                java.util.ArrayList r4 = fd.i.parseChannels(r4)     // Catch: java.lang.Exception -> L80
                r3.addAll(r4)     // Catch: java.lang.Exception -> L80
                java.lang.Void[] r3 = new java.lang.Void[r7]     // Catch: java.lang.Exception -> L80
                r6.publishProgress(r3)     // Catch: java.lang.Exception -> L80
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L80
                r3.<init>()     // Catch: java.lang.Exception -> L80
                r0 = r3
                goto L21
            L80:
                r3 = move-exception
                r3.printStackTrace()     // Catch: java.lang.Exception -> L89
                goto L23
            L85:
                r1.close()     // Catch: java.lang.Exception -> L89
                goto L8c
            L89:
                r7 = move-exception
                r6.f12491a = r7
            L8c:
                r7 = 0
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: flix.com.vision.tv.TVCategoriesActivity2.b.getUrlContents(java.lang.String):java.lang.String");
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) throws IOException {
            getUrlContents(strArr[0]);
            return "OK";
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            String str2;
            int size = App.getInstance().f11569q.size();
            TVCategoriesActivity2 tVCategoriesActivity2 = TVCategoriesActivity2.this;
            if (size > 0) {
                tVCategoriesActivity2.d();
                tVCategoriesActivity2.Y.notifyDataSetChanged();
                tVCategoriesActivity2.U.setVisibility(8);
            } else {
                if (this.f12491a != null) {
                    str2 = "Failed to load Channels: " + this.f12491a;
                } else {
                    str2 = "Failed to load Channels";
                }
                tVCategoriesActivity2.U.setVisibility(8);
                Toast.makeText(tVCategoriesActivity2.getBaseContext(), str2, 1).show();
                tVCategoriesActivity2.P.setText("TV Categories · Failed");
            }
            tVCategoriesActivity2.f12486i0 = true;
            tVCategoriesActivity2.updateFavoritesBar();
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Void... voidArr) {
            int size = App.getInstance().f11569q.size();
            TextView textView = TVCategoriesActivity2.this.f12483f0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(size);
            sb2.append(" channels loaded (");
            sb2.append(size > 16500 ? "100%" : c.m(new StringBuilder(), (int) ((size / 16500) * 100.0d), "%"));
            sb2.append(")");
            textView.setText(sb2.toString());
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    public void ToastChannel(String str) {
        if (this.f12484g0 == null) {
            return;
        }
        if (str != null && str.length() > 20) {
            str = str.substring(0, 19);
        }
        this.f12484g0.setAlpha(1.0f);
        this.f12480c0.removeCallbacks(this.f12481d0);
        this.f12480c0.postDelayed(this.f12481d0, 2000L);
        this.f12482e0.setText(str);
        this.f12484g0.setVisibility(0);
    }

    public final void d() {
        App.getInstance().f11571s.clear();
        ArrayList arrayList = new ArrayList();
        Iterator<hd.d> it = App.getInstance().f11569q.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            hd.d next = it.next();
            i10++;
            String str = next.f12987t;
            if (str != null && !arrayList.contains(str) && !next.f12987t.toLowerCase().contains("agent")) {
                arrayList.add(next.f12987t);
                TVCategory tVCategory = new TVCategory();
                tVCategory.setCategoryName(next.f12987t);
                tVCategory.setCategoryId(i10);
                App.getInstance().f11571s.add(tVCategory);
            }
        }
        if (App.getInstance().f11571s.size() > 0) {
            this.P.setText("TV Categories · " + App.getInstance().f11571s.size());
            this.Y.notifyDataSetChanged();
            Toast.makeText(this, App.getInstance().f11569q.size() + " Channels loaded", 1).show();
            updateFavoritesBar();
            if (App.getInstance().f11574v.getBoolean("hint_tv_cat_shown", false)) {
                return;
            }
            be.d.makeToast(this, "You can long press on a Category to pin it at the top of the list", true);
            o1.a.j(App.getInstance().f11574v, "hint_tv_cat_shown", true);
        }
    }

    public void getCategories() {
        if (App.getInstance().f11571s.size() <= 0) {
            App.getInstance().f11568p = this.f12478a0;
            if (this.f12479b0) {
                new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f12478a0);
                return;
            } else {
                new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this.f12478a0);
                return;
            }
        }
        this.P.setText("TV Categories · " + App.getInstance().f11571s.size());
        this.U.setVisibility(8);
        this.Y.notifyDataSetChanged();
        this.W.requestFocus();
        this.f12486i0 = true;
        updateFavoritesBar();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.X.getVisibility() == 0 && !this.X.hasFocus()) {
            this.X.requestFocus();
            return;
        }
        if (this.f12486i0) {
            super.onBackPressed();
            finish();
            return;
        }
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Still working");
        dVarNewInstance.setMessage("We're still loading your channels. Can you please wait a little more?");
        dVarNewInstance.setButton1("CANCEL", new g(this, 0));
        dVarNewInstance.setButton2("OK, I'LL WAIT", new h(0));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_tv_categories2);
        this.f12487j0 = new HashSet<>(App.getInstance().f11574v.getStringSet("prefs_tv_category_fav_set", new HashSet()));
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.O = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.N = new c4.a();
        String stringExtra = getIntent().getStringExtra("url");
        this.f12478a0 = stringExtra;
        if (stringExtra == null) {
            this.f12478a0 = App.getInstance().f11574v.getString("iptv_url", "https://iptv-org.github.io/iptv/index.country.m3u");
        }
        this.f12479b0 = getIntent().getBooleanExtra("is_file", false);
        this.f12478a0 = this.f12478a0.toLowerCase(Locale.ROOT);
        String str2 = App.getInstance().f11568p;
        if (App.getInstance().f11571s == null) {
            App.getInstance().f11571s = new ArrayList<>();
        }
        if (App.getInstance().f11569q == null) {
            App.getInstance().f11569q = new ArrayList<>();
        }
        if (App.getInstance().f11570r == null) {
            App.getInstance().f11570r = new ArrayList<>();
        }
        if (App.getInstance().f11571s.size() > 0 && str2 != null && !str2.equalsIgnoreCase(this.f12478a0)) {
            App.getInstance().f11571s.clear();
            App.getInstance().f11569q.clear();
            App.getInstance().f11570r.clear();
        }
        this.V = (LinearLayout) findViewById(R.id.tv_favorites_layout);
        this.X = (RecyclerView) findViewById(R.id.recyclerview_tv_favorites);
        this.f12483f0 = (TextView) findViewById(R.id.loader_text);
        this.W = (RecyclerView) findViewById(R.id.recyclerview_categories);
        this.U = (LinearLayout) findViewById(R.id.loader);
        this.S = (TextView) findViewById(R.id.adult_settings_text);
        this.M = (RelativeLayout) findViewById(R.id.settings_button_adult);
        this.R = (TextView) findViewById(R.id.adult_search_text);
        this.Q = (TextView) findViewById(R.id.adult_favorites_text);
        this.L = (RelativeLayout) findViewById(R.id.activity_player);
        this.K = (RelativeLayout) findViewById(R.id.search_button_adult);
        this.W = (RecyclerView) findViewById(R.id.recyclerview_categories);
        TextView textView = (TextView) findViewById(R.id.adult_page_title);
        this.P = textView;
        this.N.applyFontToView(textView, this.O);
        TextView textView2 = this.f12483f0;
        if (textView2 != null) {
            this.N.applyFontToView(textView2, this.O);
        }
        TextView textView3 = this.Q;
        if (textView3 != null) {
            this.N.applyFontToView(textView3, this.O);
        }
        TextView textView4 = this.S;
        if (textView4 != null) {
            this.N.applyFontToView(textView4, this.O);
        }
        TextView textView5 = this.R;
        if (textView5 != null) {
            this.N.applyFontToView(textView5, this.O);
        }
        this.K.setOnClickListener(new g(this, 1));
        this.M.setOnClickListener(new g(this, 2));
        setBackgroundColor();
        if (App.K) {
            this.f12484g0 = (RelativeLayout) findViewById(R.id.toast_view);
            this.f12485h0 = new AlphaAnimation(1.0f, 0.0f);
            this.f12482e0 = (TextView) findViewById(R.id.customToastText);
            this.f12480c0 = new Handler();
            this.f12481d0 = new d(this, 14);
        }
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.W.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.W.addItemDecoration(new fd.d(5));
        y yVar = new y(App.getInstance().f11571s, this, this);
        this.Y = yVar;
        this.W.setAdapter(yVar);
        this.Z = new y(this.T, this, this);
        this.X.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.X.setAdapter(this.Z);
        this.X.addItemDecoration(new fd.c(15));
        getCategories();
    }

    @Override // gd.l
    public void onLongPress(int i10, ArrayList<TVCategory> arrayList) {
        final TVCategory tVCategory = arrayList.get(i10);
        final int i11 = 1;
        if (this.f12487j0.contains(tVCategory.getCategoryName())) {
            FragmentManager fragmentManager = getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setTitle(tVCategory.getCategoryName());
            dVarNewInstance.setMessage("What would you like to Do?");
            final int i12 = 0;
            dVarNewInstance.setButton1("REMOVE FAVORITE", new View.OnClickListener(this) { // from class: ae.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ TVCategoriesActivity2 f653m;

                {
                    this.f653m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i12;
                    TVCategory tVCategory2 = tVCategory;
                    TVCategoriesActivity2 tVCategoriesActivity2 = this.f653m;
                    switch (i13) {
                        case 0:
                            int i14 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.getClass();
                            be.d.makeToast(tVCategoriesActivity2, "Removed From Favorites", true);
                            tVCategoriesActivity2.f12487j0.remove(tVCategory2.getCategoryName());
                            App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                            tVCategoriesActivity2.updateFavoritesBar();
                            break;
                        case 1:
                            int i15 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.openCategory(tVCategory2);
                            break;
                        case 2:
                            int i16 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.getClass();
                            be.d.makeToast(tVCategoriesActivity2, "Added To Favorites", true);
                            tVCategoriesActivity2.f12487j0.add(tVCategory2.getCategoryName());
                            App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                            tVCategoriesActivity2.updateFavoritesBar();
                            break;
                        default:
                            int i17 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.openCategory(tVCategory2);
                            break;
                    }
                }
            });
            dVarNewInstance.setButton2("OPEN", new View.OnClickListener(this) { // from class: ae.i

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ TVCategoriesActivity2 f653m;

                {
                    this.f653m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i11;
                    TVCategory tVCategory2 = tVCategory;
                    TVCategoriesActivity2 tVCategoriesActivity2 = this.f653m;
                    switch (i13) {
                        case 0:
                            int i14 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.getClass();
                            be.d.makeToast(tVCategoriesActivity2, "Removed From Favorites", true);
                            tVCategoriesActivity2.f12487j0.remove(tVCategory2.getCategoryName());
                            App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                            tVCategoriesActivity2.updateFavoritesBar();
                            break;
                        case 1:
                            int i15 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.openCategory(tVCategory2);
                            break;
                        case 2:
                            int i16 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.getClass();
                            be.d.makeToast(tVCategoriesActivity2, "Added To Favorites", true);
                            tVCategoriesActivity2.f12487j0.add(tVCategory2.getCategoryName());
                            App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                            tVCategoriesActivity2.updateFavoritesBar();
                            break;
                        default:
                            int i17 = TVCategoriesActivity2.f12477l0;
                            tVCategoriesActivity2.openCategory(tVCategory2);
                            break;
                    }
                }
            });
            try {
                dVarNewInstance.show(fragmentManager, "");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        FragmentManager fragmentManager2 = getFragmentManager();
        kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
        dVarNewInstance2.setTitle(tVCategory.getCategoryName());
        dVarNewInstance2.setMessage("What would you like to Do?");
        final int i13 = 2;
        dVarNewInstance2.setButton1("ADD TO FAVORITES", new View.OnClickListener(this) { // from class: ae.i

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TVCategoriesActivity2 f653m;

            {
                this.f653m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i13;
                TVCategory tVCategory2 = tVCategory;
                TVCategoriesActivity2 tVCategoriesActivity2 = this.f653m;
                switch (i132) {
                    case 0:
                        int i14 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.getClass();
                        be.d.makeToast(tVCategoriesActivity2, "Removed From Favorites", true);
                        tVCategoriesActivity2.f12487j0.remove(tVCategory2.getCategoryName());
                        App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                        tVCategoriesActivity2.updateFavoritesBar();
                        break;
                    case 1:
                        int i15 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.openCategory(tVCategory2);
                        break;
                    case 2:
                        int i16 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.getClass();
                        be.d.makeToast(tVCategoriesActivity2, "Added To Favorites", true);
                        tVCategoriesActivity2.f12487j0.add(tVCategory2.getCategoryName());
                        App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                        tVCategoriesActivity2.updateFavoritesBar();
                        break;
                    default:
                        int i17 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.openCategory(tVCategory2);
                        break;
                }
            }
        });
        final int i14 = 3;
        dVarNewInstance2.setButton2("OPEN", new View.OnClickListener(this) { // from class: ae.i

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TVCategoriesActivity2 f653m;

            {
                this.f653m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i14;
                TVCategory tVCategory2 = tVCategory;
                TVCategoriesActivity2 tVCategoriesActivity2 = this.f653m;
                switch (i132) {
                    case 0:
                        int i142 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.getClass();
                        be.d.makeToast(tVCategoriesActivity2, "Removed From Favorites", true);
                        tVCategoriesActivity2.f12487j0.remove(tVCategory2.getCategoryName());
                        App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                        tVCategoriesActivity2.updateFavoritesBar();
                        break;
                    case 1:
                        int i15 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.openCategory(tVCategory2);
                        break;
                    case 2:
                        int i16 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.getClass();
                        be.d.makeToast(tVCategoriesActivity2, "Added To Favorites", true);
                        tVCategoriesActivity2.f12487j0.add(tVCategory2.getCategoryName());
                        App.getInstance().f11574v.edit().putStringSet("prefs_tv_category_fav_set", tVCategoriesActivity2.f12487j0).apply();
                        tVCategoriesActivity2.updateFavoritesBar();
                        break;
                    default:
                        int i17 = TVCategoriesActivity2.f12477l0;
                        tVCategoriesActivity2.openCategory(tVCategory2);
                        break;
                }
            }
        });
        try {
            dVarNewInstance2.show(fragmentManager2, "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(lc.b bVar) {
        ArrayList<TVCategory> arrayList = App.getInstance().f11571s;
        throw null;
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.l
    public void openCategory(TVCategory tVCategory) {
        App.getInstance().f11570r.clear();
        Iterator<hd.d> it = App.getInstance().f11569q.iterator();
        while (it.hasNext()) {
            hd.d next = it.next();
            if (next.f12987t.equalsIgnoreCase(tVCategory.getCategoryName())) {
                App.getInstance().f11570r.add(next);
            }
        }
        Intent intent = new Intent(this, (Class<?>) ChannelsListActivityImport.class);
        intent.putExtra("cat_name", tVCategory.getCategoryName());
        startActivity(intent);
    }

    public void setBackgroundColor() {
        this.f12488k0 = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f12488k0), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 21));
        valueAnimatorOfObject.start();
        this.f12488k0 = 0;
    }

    public void updateFavoritesBar() {
        ArrayList<TVCategory> arrayList = this.T;
        try {
            arrayList.clear();
            Iterator<TVCategory> it = App.getInstance().f11571s.iterator();
            while (it.hasNext()) {
                TVCategory next = it.next();
                if (this.f12487j0.contains(next.getCategoryName())) {
                    arrayList.add(next);
                }
            }
            Collections.reverse(arrayList);
            if (arrayList.isEmpty()) {
                this.V.setVisibility(8);
            } else {
                this.V.setVisibility(0);
                this.Z.notifyDataSetChanged();
            }
        } catch (Exception e10) {
            be.d.makeToast(this, "ERROR: " + e10.getMessage(), false);
        }
    }
}
