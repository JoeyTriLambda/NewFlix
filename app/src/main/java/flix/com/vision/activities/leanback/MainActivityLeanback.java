package flix.com.vision.activities.leanback;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.core.content.FileProvider;
import androidx.fragment.app.g0;
import androidx.fragment.app.p;
import androidx.leanback.widget.BrowseFrameLayout;
import be.b;
import com.github.ybq.android.spinkit.SpinKitView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.AnimesListActivity;
import flix.com.vision.activities.FavoritesAcvivity;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.SearchActivityClassic;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.adult.AdultPINSetupActivity;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;
import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import flix.com.vision.tv.TVCategoriesActivity2;
import hd.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import ub.q0;
import ub.t0;
import ub.u2;
import xb.e;
import xb.f;

/* loaded from: classes2.dex */
public class MainActivityLeanback extends p implements View.OnKeyListener, View.OnFocusChangeListener {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f11919g0 = 0;
    public View I;
    public SpinKitView K;
    public FrameLayout L;
    public c4.a M;
    public Typeface N;
    public View P;
    public BrowseFrameLayout Q;
    public flix.com.vision.activities.leanback.fragment.a R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public TextView W;
    public TextView X;
    public TextView Y;
    public TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    public TextView f11920a0;

    /* renamed from: b0, reason: collision with root package name */
    public TextView f11921b0;

    /* renamed from: c0, reason: collision with root package name */
    public TextView f11922c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11923d0;
    public boolean J = true;
    public String O = "home";

    /* renamed from: e0, reason: collision with root package name */
    public Animation f11924e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public Animation f11925f0 = null;

    public class a extends AsyncTask<String, Integer, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ int f11926f = 0;

        /* renamed from: a, reason: collision with root package name */
        public String f11927a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f11928b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f11929c = "";

        /* renamed from: d, reason: collision with root package name */
        public ProgressDialog f11930d;

        /* renamed from: flix.com.vision.activities.leanback.MainActivityLeanback$a$a, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0142a implements DialogInterface.OnClickListener {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
            }
        }

        public a() {
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            try {
                File file = new File(this.f11929c);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            super.onCancelled();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
            MainActivityLeanback mainActivityLeanback = MainActivityLeanback.this;
            ProgressDialog progressDialog = new ProgressDialog(mainActivityLeanback);
            this.f11930d = progressDialog;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mainActivityLeanback.getString(R.string.downloading_update_wait));
            sb2.append(StringUtils.SPACE);
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            sb2.append(sharedPreferences.getString("update_version_name", ""));
            progressDialog.setTitle(sb2.toString());
            this.f11930d.setIndeterminate(false);
            this.f11930d.setMax(100);
            this.f11930d.setCancelable(false);
            this.f11930d.setButton(-1, mainActivityLeanback.getString(R.string.cancel_label), new u2(this, 1));
            this.f11930d.setProgressStyle(1);
            this.f11930d.show();
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) throws PackageManager.NameNotFoundException, IOException {
            URL url;
            URLConnection uRLConnectionOpenConnection;
            String str;
            MainActivityLeanback mainActivityLeanback = MainActivityLeanback.this;
            String str2 = "";
            try {
                url = new URL(strArr[0]);
                uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.connect();
                this.f11928b = Environment.getExternalStorageDirectory().getPath();
                str = this.f11928b + "/FlixVision.Update" + this.f11927a.replace(StringUtils.SPACE, "").replace(".", "") + ".apk";
                this.f11929c = str;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                int contentLength = uRLConnectionOpenConnection.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    this.f11927a = "." + mainActivityLeanback.getPackageManager().getPackageInfo(mainActivityLeanback.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e11) {
                    e11.printStackTrace();
                    this.f11927a = "";
                }
                FileOutputStream fileOutputStream = new FileOutputStream(this.f11929c);
                byte[] bArr = new byte[1024];
                long j10 = 0;
                while (true) {
                    int i10 = bufferedInputStream.read(bArr);
                    if (i10 == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        return str;
                    }
                    j10 += i10;
                    publishProgress(Integer.valueOf((int) ((100 * j10) / contentLength)));
                    fileOutputStream.write(bArr, 0, i10);
                }
            } catch (Exception e12) {
                e = e12;
                str2 = str;
                e.printStackTrace();
                try {
                    File file = new File(this.f11929c);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
                return str2;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            try {
                this.f11930d.dismiss();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            File file = new File(str);
            boolean zExists = file.exists();
            MainActivityLeanback mainActivityLeanback = MainActivityLeanback.this;
            if (!zExists) {
                d dVarCreate = new d.a(mainActivityLeanback).create();
                dVarCreate.setTitle("OOPPSS!!");
                dVarCreate.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate.setMessage(mainActivityLeanback.getString(R.string.error_downloading_apk_mess));
                dVarCreate.setButton(-1, "GOT IT", new DialogInterfaceOnClickListenerC0142a());
                try {
                    dVarCreate.show();
                    return;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    return;
                }
            }
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    Uri uriForFile = FileProvider.getUriForFile(mainActivityLeanback.getBaseContext(), mainActivityLeanback.getBaseContext().getApplicationContext().getPackageName() + ".provider", file);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    intent.setFlags(1);
                    mainActivityLeanback.startActivity(intent);
                } else {
                    Uri uriFromFile = Uri.fromFile(file);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    mainActivityLeanback.startActivity(intent2);
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                d dVarCreate2 = new d.a(mainActivityLeanback).create();
                dVarCreate2.setTitle("OOPPSS!!");
                dVarCreate2.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate2.setMessage(mainActivityLeanback.getString(R.string.apk_downloaded_but_could_not) + this.f11929c + "\n\nAnd Install the Apk manually");
                dVarCreate2.setButton(-1, "GOT IT", new t0(7));
                try {
                    dVarCreate2.show();
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            }
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(Integer... numArr) {
            super.onProgressUpdate((Object[]) numArr);
            this.f11930d.setProgress(numArr[0].intValue());
        }
    }

    public static void i(TextView textView, int i10) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(textView.getContext(), i10), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public void askToUpdateIfAny(boolean z10, Movie movie) {
        try {
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            int i10 = 0;
            int i11 = 1;
            if (sharedPreferences.getBoolean("update_available", false) && App.getInstance().f11574v.getString("update_url", "").length() > 5) {
                kc.d dVarNewInstance = kc.d.newInstance(this, false);
                dVarNewInstance.setButton1(getString(R.string.later_label).toUpperCase(), new f(this, dVarNewInstance, movie, i10));
                dVarNewInstance.setButton2(getString(R.string.download_update_label), new f(this, dVarNewInstance, movie, i11));
                dVarNewInstance.setMessage(getString(R.string.new_update_message) + App.getInstance().f11574v.getString("update_message", "") + getString(R.string.make_sure_you_get_it_mess));
                dVarNewInstance.setTitle(getString(R.string.update_available_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("update_version_name", ""));
                dVarNewInstance.show(getFragmentManager(), "");
            } else if (z10) {
                Toast.makeText(getBaseContext(), "You're running the latest version", 1).show();
            }
        } catch (Exception unused) {
        }
    }

    public final void c(flix.com.vision.activities.leanback.fragment.a aVar) {
        this.K.setVisibility(0);
        g0 g0VarBeginTransaction = getSupportFragmentManager().beginTransaction();
        g0VarBeginTransaction.replace(R.id.container, aVar);
        g0VarBeginTransaction.commit();
    }

    public final void d() {
        flix.com.vision.activities.leanback.fragment.a aVar = this.R;
        if (aVar != null) {
            aVar.requestFocus1();
        }
        int widthInPercent = b.getWidthInPercent(this, 6);
        this.Q.startAnimation(this.f11925f0);
        this.L.setTranslationX(widthInPercent - 95);
        this.Q.requestLayout();
        this.Q.getLayoutParams().width = widthInPercent;
    }

    public final void e(boolean z10) {
        new Handler().postDelayed(new xb.d(this, 0), z10 ? 10L : 1000L);
    }

    public final boolean f() {
        return this.Q.getLayoutParams().width > 200;
    }

    public void finished() {
        SpinKitView spinKitView = this.K;
        if (spinKitView != null) {
            spinKitView.setVisibility(8);
        }
    }

    public final void g() {
        int widthInPercent = b.getWidthInPercent(this, 18);
        this.Q.startAnimation(this.f11924e0);
        this.L.setTranslationX(widthInPercent - 50);
        this.Q.requestLayout();
        this.Q.getLayoutParams().width = widthInPercent;
        j();
        k();
    }

    public final void h(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public final void j() {
        String str = this.O;
        str.getClass();
        switch (str) {
            case "favorites":
                this.Y.requestFocus();
                break;
            case "genres":
                this.f11922c0.requestFocus();
                break;
            case "search":
                this.S.requestFocus();
                break;
            case "tv":
                this.V.requestFocus();
                break;
            case "exit":
                this.f11920a0.requestFocus();
                break;
            case "home":
                this.T.requestFocus();
                break;
            case "more":
                this.f11921b0.requestFocus();
                break;
            case "anime":
                this.X.requestFocus();
                break;
            case "movie":
                this.U.requestFocus();
                break;
            case "live_tv":
                this.W.requestFocus();
                break;
            case "settings":
                this.Z.requestFocus();
                break;
        }
    }

    public final void k() {
        new Handler().postDelayed(new xb.d(this, 2), 100L);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 12345 && i11 == -1) {
            String stringExtra = intent.getStringExtra("fileExtraPath");
            h hVar = new h();
            try {
                hVar.f13009m = stringExtra.split("/")[r3.length - 1];
            } catch (Exception unused) {
                hVar.f13009m = stringExtra;
            }
            hVar.f13008b = stringExtra;
            hVar.f13010n = "3";
            App.getInstance().f11573u.addHistoryIPTV(hVar);
            Intent intent2 = new Intent(this, (Class<?>) TVCategoriesActivity2.class);
            intent2.putExtra("is_file", true);
            intent2.putExtra("url", stringExtra);
            startActivity(intent2);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        flix.com.vision.activities.leanback.fragment.a aVar = this.R;
        if (aVar != null && aVar.getSelectedPosition() > 0) {
            this.R.setSelectedPosition(0);
        } else if (f()) {
            d();
        } else {
            g();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        TextView textView;
        super.onCreate(bundle);
        int i10 = 1;
        if (bundle == null) {
            if (App.getInstance().f11574v.getBoolean("IS_RD_LOGGED_IN", false)) {
                App.getInstance().refreshTokenRD();
            }
            if (App.getInstance().f11574v.getBoolean("PREM_LOGGED_IN", false)) {
                PremiumizeCommon.f12045b = true;
                SharedPreferences sharedPreferences = App.getInstance().f11574v;
                String str = Constants.f12319a;
                PremiumizeCommon.f12046m = sharedPreferences.getString("prem_apikey", null);
            }
            if (App.getInstance().f11574v.getBoolean("ALL_DEBRID_LOGGED_IN", false)) {
                AllDebridCommon.f12043n = true;
                SharedPreferences sharedPreferences2 = App.getInstance().f11574v;
                String str2 = Constants.f12319a;
                AllDebridCommon.f12044o = sharedPreferences2.getString("all_debrid_apikey", null);
            }
        }
        setContentView(R.layout.activity_main_leanback);
        new Handler().postDelayed(new xb.d(this, i10), 2000L);
        App.getInstance().loadRemoteConfig();
        this.I = findViewById(R.id.padding_view);
        this.f11923d0 = (TextView) findViewById(R.id.button_adult);
        this.f11922c0 = (TextView) findViewById(R.id.button_genres);
        this.f11921b0 = (TextView) findViewById(R.id.button_more);
        this.K = (SpinKitView) findViewById(R.id.loader_circle);
        this.L = (FrameLayout) findViewById(R.id.container);
        this.Q = (BrowseFrameLayout) findViewById(R.id.navBar);
        this.S = (TextView) findViewById(R.id.button_search);
        this.T = (TextView) findViewById(R.id.button_home);
        this.U = (TextView) findViewById(R.id.button_movies);
        this.V = (TextView) findViewById(R.id.button_tv_series);
        this.X = (TextView) findViewById(R.id.button_anime);
        this.W = (TextView) findViewById(R.id.button_live_tv);
        this.Y = (TextView) findViewById(R.id.button_favorites);
        this.Z = (TextView) findViewById(R.id.button_settings);
        this.f11920a0 = (TextView) findViewById(R.id.button_exit);
        this.M = new c4.a();
        AssetManager assets = getAssets();
        String str3 = Constant.f12450b;
        this.N = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.M.applyFontToView(this.f11923d0, this.N);
        this.M.applyFontToView(this.S, this.N);
        this.M.applyFontToView(this.T, this.N);
        this.M.applyFontToView(this.U, this.N);
        this.M.applyFontToView(this.V, this.N);
        this.M.applyFontToView(this.X, this.N);
        this.M.applyFontToView(this.W, this.N);
        this.M.applyFontToView(this.Y, this.N);
        this.M.applyFontToView(this.Z, this.N);
        this.M.applyFontToView(this.f11920a0, this.N);
        this.M.applyFontToView(this.f11921b0, this.N);
        this.M.applyFontToView(this.f11922c0, this.N);
        this.f11924e0 = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
        this.f11925f0 = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
        if (!App.getInstance().f11574v.getBoolean("pref_show_adult_zone", true) && (textView = this.f11923d0) != null) {
            textView.setVisibility(8);
            this.I.setVisibility(0);
        }
        this.f11923d0.setOnKeyListener(this);
        this.f11922c0.setOnKeyListener(this);
        this.S.setOnKeyListener(this);
        this.T.setOnKeyListener(this);
        this.U.setOnKeyListener(this);
        this.V.setOnKeyListener(this);
        this.X.setOnKeyListener(this);
        this.W.setOnKeyListener(this);
        this.Y.setOnKeyListener(this);
        this.f11920a0.setOnKeyListener(this);
        this.Z.setOnKeyListener(this);
        this.f11921b0.setOnKeyListener(this);
        this.Q.setOnFocusChangeListener(new v7.b(this, 5));
        this.f11923d0.setOnFocusChangeListener(this);
        this.f11922c0.setOnFocusChangeListener(this);
        this.S.setOnFocusChangeListener(this);
        this.T.setOnFocusChangeListener(this);
        this.U.setOnFocusChangeListener(this);
        this.V.setOnFocusChangeListener(this);
        this.X.setOnFocusChangeListener(this);
        this.W.setOnFocusChangeListener(this);
        this.Y.setOnFocusChangeListener(this);
        this.f11920a0.setOnFocusChangeListener(this);
        this.Z.setOnFocusChangeListener(this);
        this.f11921b0.setOnFocusChangeListener(this);
        TextView textView2 = this.T;
        this.P = textView2;
        textView2.setActivated(true);
        flix.com.vision.activities.leanback.fragment.a aVar = new flix.com.vision.activities.leanback.fragment.a(this, TVListFragmentMain.ContentTypeLB.HOME);
        this.R = aVar;
        aVar.setHome();
        c(this.R);
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/FlixVision.Update" + "".replace(StringUtils.SPACE, "").replace(".", "") + ".apk");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z10) {
        if (!(view instanceof TextView) || view.isActivated()) {
            return;
        }
        if (!z10) {
            TextView textView = (TextView) view;
            i(textView, R.color.white);
            textView.setTextColor(getResources().getColor(R.color.color_grey));
        } else {
            if (!f()) {
                g();
            }
            TextView textView2 = (TextView) view;
            textView2.setTextColor(getResources().getColor(R.color.black));
            i(textView2, R.color.black);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnKeyListener
    @SuppressLint({"NonConstantResourceId"})
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        int i11 = 1;
        if (keyEvent.getAction() != 0) {
            return true;
        }
        int i12 = 4;
        if (i10 == 4) {
            d();
            return true;
        }
        int i13 = 0;
        if (i10 != 66) {
            if (i10 != 82) {
                switch (i10) {
                    case 21:
                        break;
                    case 22:
                        if (view instanceof TextView) {
                            view.clearFocus();
                            flix.com.vision.activities.leanback.fragment.a aVar = this.R;
                            if (aVar != null) {
                                aVar.requestFocus1();
                            }
                            d();
                            return true;
                        }
                        return false;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!f()) {
                j();
                g();
            }
            return true;
        }
        switch (view.getId()) {
            case R.id.button_adult /* 2131427602 */:
                if (f()) {
                    d();
                }
                if (App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
                    startActivity(new Intent(this, (Class<?>) AdultZonePINEntryActivity.class));
                } else {
                    startActivity(new Intent(this, (Class<?>) AdultPINSetupActivity.class));
                }
                k();
                break;
            case R.id.button_anime /* 2131427605 */:
                if (f()) {
                    d();
                }
                startActivity(new Intent(this, (Class<?>) AnimesListActivity.class));
                break;
            case R.id.button_exit /* 2131427613 */:
                if (f()) {
                    d();
                }
                FragmentManager fragmentManager = getFragmentManager();
                kc.d dVarNewInstance = kc.d.newInstance(this, true);
                dVarNewInstance.setTitle("Exit");
                dVarNewInstance.setMessage("Do you really want to close the App ?");
                dVarNewInstance.setButton1("CANCEL", new q0(17));
                dVarNewInstance.setButton2("YES", new e(this, i13));
                try {
                    dVarNewInstance.show(fragmentManager, "");
                    break;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    break;
                }
            case R.id.button_favorites /* 2131427615 */:
                if (!Objects.equals(this.O, "favorites")) {
                    if (App.getInstance().f11573u.getFavoritesMoviesFromDb().size() != 0) {
                        startActivity(new Intent(this, (Class<?>) FavoritesAcvivity.class));
                        break;
                    } else {
                        be.d.makeToast(this, "No Item in your Favorites", false);
                        break;
                    }
                }
                break;
            case R.id.button_genres /* 2131427616 */:
                if (!Objects.equals(this.O, "genres")) {
                    startActivity(new Intent(this, (Class<?>) FilterActivityLeanBack.class));
                    break;
                }
                break;
            case R.id.button_home /* 2131427617 */:
                if (!Objects.equals(this.O, "home")) {
                    if (f()) {
                        d();
                    }
                    this.U.requestFocus();
                    flix.com.vision.activities.leanback.fragment.a aVar2 = new flix.com.vision.activities.leanback.fragment.a(this, TVListFragmentMain.ContentTypeLB.HOME);
                    this.R = aVar2;
                    aVar2.setHome();
                    c(this.R);
                    this.P.setActivated(false);
                    view.setActivated(true);
                    this.P = view;
                    this.O = "home";
                    k();
                    e(false);
                    break;
                }
                break;
            case R.id.button_live_tv /* 2131427620 */:
                if (f()) {
                    d();
                }
                startActivity(new Intent(this, (Class<?>) TVCategoriesActivity2.class));
                break;
            case R.id.button_more /* 2131427622 */:
                FragmentManager fragmentManager2 = getFragmentManager();
                kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
                dVarNewInstance2.setButton_check_update_listener(new e(this, i11));
                dVarNewInstance2.setListener_watched(new e(this, 2));
                dVarNewInstance2.setButton_contact_us_listener(new e(this, 3));
                dVarNewInstance2.setTrakt_listener(new e(this, i12));
                dVarNewInstance2.setListener_donation(new q0(18));
                dVarNewInstance2.setImport_Playlist_listener(new e(this, 5));
                dVarNewInstance2.setMyplaylist_listener(new e(this, 6));
                dVarNewInstance2.setMenuMode();
                try {
                    dVarNewInstance2.show(fragmentManager2, "");
                    break;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    break;
                }
            case R.id.button_movies /* 2131427623 */:
                if (!Objects.equals(this.O, "movie")) {
                    if (f()) {
                        d();
                    }
                    this.U.requestFocus();
                    App.getInstance().f11574v.edit().putInt("content_type", 0).apply();
                    flix.com.vision.activities.leanback.fragment.a aVar3 = new flix.com.vision.activities.leanback.fragment.a(this, TVListFragmentMain.ContentTypeLB.MOVIES);
                    this.R = aVar3;
                    c(aVar3);
                    this.P.setActivated(false);
                    view.setActivated(true);
                    this.P = view;
                    this.O = "movie";
                    k();
                    e(false);
                    break;
                }
                break;
            case R.id.button_search /* 2131427629 */:
                if (f()) {
                    d();
                }
                if (App.getInstance().f11574v.getBoolean("pref_classic_search", false)) {
                    startActivity(new Intent(this, (Class<?>) SearchActivityClassic.class));
                } else {
                    startActivity(new Intent(this, (Class<?>) SearchActivityTV.class));
                }
                k();
                break;
            case R.id.button_settings /* 2131427632 */:
                if (f()) {
                    d();
                }
                startActivity(new Intent(this, (Class<?>) SettingsActivity.class));
                break;
            case R.id.button_tv_series /* 2131427636 */:
                if (!Objects.equals(this.O, "tv")) {
                    if (f()) {
                        d();
                    }
                    this.V.requestFocus();
                    App.getInstance().f11574v.edit().putInt("content_type", 1).apply();
                    flix.com.vision.activities.leanback.fragment.a aVar4 = new flix.com.vision.activities.leanback.fragment.a(this, TVListFragmentMain.ContentTypeLB.TV_SHOWS);
                    this.R = aVar4;
                    c(aVar4);
                    this.P.setActivated(false);
                    view.setActivated(true);
                    this.P = view;
                    this.O = "tv";
                    k();
                    e(false);
                    break;
                }
                break;
        }
        return true;
        return true;
        return true;
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.J && App.getInstance().f11566n) {
            flix.com.vision.activities.leanback.fragment.a aVar = this.R;
            if (aVar != null) {
                aVar.reloadWatchedHistory();
                return;
            }
            return;
        }
        this.J = false;
        if (this.f11923d0 != null) {
            if (App.getInstance().f11574v.getBoolean("pref_show_adult_zone", true)) {
                this.f11923d0.setVisibility(0);
                this.I.setVisibility(8);
            } else {
                this.f11923d0.setVisibility(8);
                this.I.setVisibility(0);
            }
        }
        requestAndDisplayAd();
    }

    public void openMovieintent(Movie movie) {
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        if (sharedPreferences.getBoolean("update_available", false)) {
            if (!App.getInstance().f11574v.getBoolean("mandatory_update", false)) {
                askToUpdateIfAny(false, movie);
                return;
            }
            askToUpdateIfAny(false, null);
        }
        h(movie);
    }

    public void requestAndDisplayAd() {
    }
}
