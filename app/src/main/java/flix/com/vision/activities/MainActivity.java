package flix.com.vision.activities;

import ac.e0;
import ac.t;
import ac.u;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.mediarouter.app.MediaRouteButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.material.tabs.TabLayout;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.adult.AdultPINSetupActivity;
import flix.com.vision.activities.adult.AdultZonePINEntryActivity;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.helpers.Constants;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import flix.com.vision.tv.MyImportActivity;
import flix.com.vision.tv.TVCategoriesActivity2;
import flix.com.vision.utils.JsonUtils;
import gd.j;
import hd.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.UUID;
import l7.c;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import r.x;
import se.f;
import ub.a1;
import ub.c1;
import ub.d1;
import ub.e1;
import ub.n0;
import ub.q0;
import ub.s0;
import ub.t0;
import ub.u0;
import ub.v;
import ub.v0;
import ub.x0;
import ub.y0;
import ub.z0;

/* loaded from: classes2.dex */
public class MainActivity extends wb.a implements c.InterfaceC0189c, j, SwipeRefreshLayout.f, aa.a {

    /* renamed from: v0, reason: collision with root package name */
    public static final /* synthetic */ int f11697v0 = 0;
    public e0 M;
    public u N;
    public RecyclerView O;
    public RecyclerView P;
    public MediaRouteButton Q;
    public TabLayout R;
    public qe.b S;
    public RelativeLayout U;
    public MenuItem W;
    public c X;
    public Toolbar Z;

    /* renamed from: a0, reason: collision with root package name */
    public MaterialSearchView f11698a0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList<Movie> f11699b0;

    /* renamed from: c0, reason: collision with root package name */
    public t f11700c0;

    /* renamed from: d0, reason: collision with root package name */
    public SuperRecyclerView f11701d0;

    /* renamed from: f0, reason: collision with root package name */
    public DrawerLayout f11703f0;

    /* renamed from: g0, reason: collision with root package name */
    public c1 f11704g0;

    /* renamed from: h0, reason: collision with root package name */
    public c4.a f11705h0;

    /* renamed from: i0, reason: collision with root package name */
    public Typeface f11706i0;

    /* renamed from: j0, reason: collision with root package name */
    public Typeface f11707j0;

    /* renamed from: m0, reason: collision with root package name */
    public Menu f11710m0;

    /* renamed from: o0, reason: collision with root package name */
    public fd.b f11712o0;

    /* renamed from: p0, reason: collision with root package name */
    public ProgressDialog f11713p0;

    /* renamed from: q0, reason: collision with root package name */
    public qe.b f11714q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f11715r0;
    public final ArrayList<Movie> K = new ArrayList<>();
    public final ArrayList<ld.a> L = new ArrayList<>();
    public final boolean T = true;
    public boolean V = false;
    public final int Y = 200;

    /* renamed from: e0, reason: collision with root package name */
    public int f11702e0 = 1;

    /* renamed from: k0, reason: collision with root package name */
    public String f11708k0 = "IN THEATER";

    /* renamed from: l0, reason: collision with root package name */
    public final int f11709l0 = 1;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f11711n0 = false;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f11716s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    public int f11717t0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f11718u0 = false;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            MainActivity.this.f11716s0 = false;
        }
    }

    public class b extends AsyncTask<String, Integer, String> {

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f11720e = 0;

        /* renamed from: a, reason: collision with root package name */
        public String f11721a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f11722b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f11723c = "";

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
                b.this.cancel(true);
            }
        }

        /* renamed from: flix.com.vision.activities.MainActivity$b$b, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0140b implements DialogInterface.OnClickListener {
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
            }
        }

        public b() {
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            try {
                File file = new File(this.f11723c);
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
            MainActivity mainActivity = MainActivity.this;
            mainActivity.f11713p0 = new ProgressDialog(mainActivity);
            ProgressDialog progressDialog = mainActivity.f11713p0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mainActivity.getString(R.string.downloading_update_wait));
            sb2.append(StringUtils.SPACE);
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            sb2.append(sharedPreferences.getString("update_version_name", ""));
            progressDialog.setTitle(sb2.toString());
            mainActivity.f11713p0.setIndeterminate(false);
            mainActivity.f11713p0.setMax(100);
            mainActivity.f11713p0.setCancelable(false);
            mainActivity.f11713p0.setButton(-1, mainActivity.getString(R.string.cancel_label), new a());
            mainActivity.f11713p0.setProgressStyle(1);
            mainActivity.f11713p0.show();
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) throws PackageManager.NameNotFoundException, IOException {
            URL url;
            URLConnection uRLConnectionOpenConnection;
            String str;
            MainActivity mainActivity = MainActivity.this;
            String str2 = "";
            try {
                url = new URL(strArr[0]);
                uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.connect();
                this.f11722b = Environment.getExternalStorageDirectory().getPath();
                str = this.f11722b + "/FlixVision.Update" + this.f11721a.replace(StringUtils.SPACE, "").replace(".", "") + ".apk";
                this.f11723c = str;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                int contentLength = uRLConnectionOpenConnection.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    this.f11721a = "." + mainActivity.getPackageManager().getPackageInfo(mainActivity.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e11) {
                    e11.printStackTrace();
                    this.f11721a = "";
                }
                FileOutputStream fileOutputStream = new FileOutputStream(this.f11723c);
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
                    File file = new File(this.f11723c);
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
            MainActivity mainActivity = MainActivity.this;
            super.onPostExecute((b) str);
            try {
                mainActivity.f11713p0.dismiss();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            File file = new File(str);
            if (!file.exists()) {
                d dVarCreate = new d.a(mainActivity).create();
                dVarCreate.setTitle("OOPPSS!!");
                dVarCreate.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate.setMessage(mainActivity.getString(R.string.error_downloading_apk_mess));
                dVarCreate.setButton(-1, "GOT IT", new DialogInterfaceOnClickListenerC0140b());
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
                    Uri uriForFile = FileProvider.getUriForFile(mainActivity.getBaseContext(), mainActivity.getBaseContext().getApplicationContext().getPackageName() + ".provider", file);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    intent.setFlags(1);
                    mainActivity.startActivity(intent);
                } else {
                    Uri uriFromFile = Uri.fromFile(file);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    mainActivity.startActivity(intent2);
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                d dVarCreate2 = new d.a(mainActivity).create();
                dVarCreate2.setTitle("OOPPSS!!");
                dVarCreate2.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate2.setMessage(mainActivity.getString(R.string.apk_downloaded_but_could_not) + this.f11723c + "\n\nAnd Install the Apk manually");
                dVarCreate2.setButton(-1, "GOT IT", new t0(3));
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
            MainActivity.this.f11713p0.setProgress(numArr[0].intValue());
        }
    }

    public static void d(MainActivity mainActivity, TabLayout.f fVar) {
        if (mainActivity.f11709l0 > 1) {
            mainActivity.recreate();
            return;
        }
        App.getInstance().f11574v.edit().putString("genre", "").apply();
        App.getInstance().f11574v.edit().putString("year", "").apply();
        mainActivity.f11699b0.clear();
        mainActivity.f11700c0.notifyDataSetChanged();
        mainActivity.f11717t0 = fVar.getPosition();
        mainActivity.f11702e0 = 1;
        mainActivity.k();
        mainActivity.f(mainActivity.f11702e0);
    }

    public static void resetFilter() {
        SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
        editorEdit.remove("year");
        editorEdit.remove("year_index");
        editorEdit.remove("genre_index_genre");
        editorEdit.remove("network_index");
        editorEdit.remove("content_type");
        editorEdit.remove("sort_by_index");
        editorEdit.apply();
    }

    public final void askToUpdateIfAny(boolean z10, Movie movie) {
        try {
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            int i10 = 0;
            int i11 = 1;
            if (sharedPreferences.getBoolean("update_available", false) && App.getInstance().f11574v.getString("update_url", "").length() > 5) {
                kc.d dVarNewInstance = kc.d.newInstance(this, false);
                dVarNewInstance.setButton1(getString(R.string.later_label).toUpperCase(), new v0(this, dVarNewInstance, movie, i10));
                dVarNewInstance.setButton2(getString(R.string.download_update_label), new v0(this, dVarNewInstance, movie, i11));
                dVarNewInstance.setMessage(getString(R.string.new_update_message) + App.getInstance().f11574v.getString("update_message", "") + getString(R.string.make_sure_you_get_it_mess));
                dVarNewInstance.setTitle(getString(R.string.update_available_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("update_version_name", ""));
                dVarNewInstance.show(getFragmentManager(), "");
            } else if (z10) {
                Toast.makeText(getBaseContext(), "You're running the latest version", 1).show();
            }
        } catch (Exception unused) {
        }
    }

    public final void e() {
        if (this.f11703f0.isDrawerOpen(8388611)) {
            this.f11703f0.closeDrawer(8388611, true);
            return;
        }
        if (this.f11698a0.isOpen()) {
            this.f11698a0.closeSearch();
            return;
        }
        if (!this.f11711n0) {
            if (this.f11699b0.size() < 200) {
                this.f11701d0.getRecyclerView().smoothScrollToPosition(0);
            } else {
                this.f11701d0.getRecyclerView().scrollToPosition(0);
            }
            this.f11711n0 = true;
            this.Z.requestFocus();
            this.f11701d0.clearFocus();
            new Handler().postDelayed(new x0(this, 5), 2000L);
            return;
        }
        this.f11711n0 = false;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Exit");
        dVarNewInstance.setMessage("Do you really want to close the App ?");
        int i10 = 3;
        dVarNewInstance.setButton1("CANCEL", new q0(i10));
        dVarNewInstance.setButton2("YES", new y0(this, i10));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void extractDominantColor(int i10) {
        if (this.f11716s0) {
            return;
        }
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f11715r0), Integer.valueOf(i10));
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 11));
        valueAnimatorOfObject.addListener(new a());
        valueAnimatorOfObject.start();
        this.f11715r0 = i10;
        this.f11716s0 = true;
    }

    public final void f(int i10) {
        this.f11701d0.setupMoreListener(this, 20);
        qe.b bVar = this.S;
        if (bVar != null) {
            bVar.dispose();
        }
        final int i11 = 0;
        final int i12 = App.getInstance().f11574v.getInt("content_type", 0);
        final int i13 = 1;
        if ((App.getInstance().f11574v.getInt("year_index", 0) == 0 || !App.getInstance().f11574v.contains("year_index")) && (App.getInstance().f11574v.getInt("genre_index_genre", 0) == 0 || !App.getInstance().f11574v.contains("genre_index_genre")) && ((App.getInstance().f11574v.getInt("network_index", 0) == 0 || !App.getInstance().f11574v.contains("network_index")) && ((App.getInstance().f11574v.getInt("content_type", 0) == 0 || !App.getInstance().f11574v.contains("content_type")) && (App.getInstance().f11574v.getInt("sort_by_index", 0) == 0 || !App.getInstance().f11574v.contains("sort_by_index"))))) {
            this.S = bc.a.gettabbedList(this, i10, i12 == 0 ? "movie" : "tv", this.f11717t0).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new f(this) { // from class: ub.w0

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ MainActivity f20307m;

                {
                    this.f20307m = this;
                }

                @Override // se.f
                public final void accept(Object obj) {
                    int i14 = i11;
                    int i15 = i12;
                    MainActivity mainActivity = this.f20307m;
                    switch (i14) {
                        case 0:
                            int i16 = MainActivity.f11697v0;
                            mainActivity.getClass();
                            ArrayList<Movie> listMovie = JsonUtils.parseListMovie((com.google.gson.o) obj, i15);
                            mainActivity.f11699b0.addAll(App.getInstance().filterList(listMovie));
                            mainActivity.f11700c0.notifyItemRangeChanged(mainActivity.f11699b0.size() - 1, listMovie.size());
                            if (listMovie.size() > 0 && mainActivity.f11699b0.size() == 0) {
                                int i17 = mainActivity.f11702e0 + 1;
                                mainActivity.f11702e0 = i17;
                                mainActivity.f(i17);
                                break;
                            }
                            break;
                        default:
                            int i18 = MainActivity.f11697v0;
                            mainActivity.getClass();
                            ArrayList<Movie> listMovie2 = JsonUtils.parseListMovie((com.google.gson.o) obj, i15);
                            mainActivity.f11699b0.addAll(App.getInstance().filterList(listMovie2));
                            mainActivity.f11700c0.notifyItemRangeChanged(mainActivity.f11699b0.size() - 1, listMovie2.size());
                            if (listMovie2.size() > 0 && mainActivity.f11699b0.size() == 0) {
                                int i19 = mainActivity.f11702e0 + 1;
                                mainActivity.f11702e0 = i19;
                                mainActivity.f(i19);
                                break;
                            }
                            break;
                    }
                }
            }, new n0(i13));
            return;
        }
        String string = App.getInstance().f11574v.getString("year", "");
        int i14 = App.getInstance().f11574v.getInt("genre_id", 0);
        int i15 = App.getInstance().f11574v.getInt("pref_network_id", -1);
        this.S = bc.a.getItemsByGenres(this, String.valueOf(i14), i10, i12, string, App.getInstance().f11574v.getInt("sort_by_index", 0) != 0 ? "primary_release_date.desc" : "popularity.desc", i15, null).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new f(this) { // from class: ub.w0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MainActivity f20307m;

            {
                this.f20307m = this;
            }

            @Override // se.f
            public final void accept(Object obj) {
                int i142 = i13;
                int i152 = i12;
                MainActivity mainActivity = this.f20307m;
                switch (i142) {
                    case 0:
                        int i16 = MainActivity.f11697v0;
                        mainActivity.getClass();
                        ArrayList<Movie> listMovie = JsonUtils.parseListMovie((com.google.gson.o) obj, i152);
                        mainActivity.f11699b0.addAll(App.getInstance().filterList(listMovie));
                        mainActivity.f11700c0.notifyItemRangeChanged(mainActivity.f11699b0.size() - 1, listMovie.size());
                        if (listMovie.size() > 0 && mainActivity.f11699b0.size() == 0) {
                            int i17 = mainActivity.f11702e0 + 1;
                            mainActivity.f11702e0 = i17;
                            mainActivity.f(i17);
                            break;
                        }
                        break;
                    default:
                        int i18 = MainActivity.f11697v0;
                        mainActivity.getClass();
                        ArrayList<Movie> listMovie2 = JsonUtils.parseListMovie((com.google.gson.o) obj, i152);
                        mainActivity.f11699b0.addAll(App.getInstance().filterList(listMovie2));
                        mainActivity.f11700c0.notifyItemRangeChanged(mainActivity.f11699b0.size() - 1, listMovie2.size());
                        if (listMovie2.size() > 0 && mainActivity.f11699b0.size() == 0) {
                            int i19 = mainActivity.f11702e0 + 1;
                            mainActivity.f11702e0 = i19;
                            mainActivity.f(i19);
                            break;
                        }
                        break;
                }
            }
        }, new n0(2));
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
        try {
            this.f11699b0.remove(i10);
        } catch (Exception unused) {
        }
        if (this.f11699b0.isEmpty()) {
            recreate();
        } else {
            this.f11700c0.notifyItemRemoved(i10);
        }
    }

    public final void g() {
        if (App.getInstance().f11574v.getBoolean("pref_hide_continue", false)) {
            this.O.setVisibility(8);
            return;
        }
        ArrayList<Movie> watchingMoviesFromDb = App.getInstance().f11573u.getWatchingMoviesFromDb();
        if (watchingMoviesFromDb.size() <= 0) {
            this.O.setVisibility(8);
            return;
        }
        ArrayList<Movie> arrayList = this.K;
        arrayList.clear();
        arrayList.addAll(watchingMoviesFromDb);
        watchingMoviesFromDb.clear();
        this.M.notifyDataSetChanged();
        this.O.setVisibility(0);
        this.O.scrollToPosition(0);
    }

    public final void h() throws PackageManager.NameNotFoundException {
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Discord");
        dVarNewInstance.setMessage("Join the Flix Vision community at https://discord.gg/tKjc4PTvxu");
        dVarNewInstance.setButton1("OK", new z0(dVarNewInstance, 3));
        boolean z10 = false;
        try {
            getPackageManager().getPackageInfo("com.discord", 0);
            z10 = true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (z10) {
            dVarNewInstance.setButton2("OPEN APP", new a1(this, dVarNewInstance, 2));
        }
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
        String str = Constant.f12450b;
        editorEdit.putBoolean("discord_check", true).apply();
    }

    public final void i() {
        d dVarCreate = new d.a(this).create();
        dVarCreate.setTitle(getString(R.string.out_of_mem));
        dVarCreate.setIcon(R.drawable.ic_action_live_help);
        dVarCreate.setMessage(getString(R.string.out_of_memory_mess));
        dVarCreate.setButton(-1, getString(R.string.got_it), new t0(2));
        dVarCreate.setButton(-2, getString(R.string.reload_label), new u0(this, 1));
        try {
            dVarCreate.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void j() throws PackageManager.NameNotFoundException {
        boolean z10;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, true);
        dVarNewInstance.setTitle("Twitter");
        dVarNewInstance.setMessage("Find us on twitter at @FlixVisionApp");
        int i10 = 0;
        dVarNewInstance.setButton1("OK", new z0(dVarNewInstance, i10));
        try {
            getPackageManager().getPackageInfo("com.twitter.android", 0);
            z10 = true;
        } catch (PackageManager.NameNotFoundException unused) {
            z10 = false;
        }
        if (z10) {
            dVarNewInstance.setButton2("OPEN APP", new a1(this, dVarNewInstance, i10));
        }
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        SharedPreferences.Editor editorEdit = App.getInstance().f11574v.edit();
        String str = Constant.f12450b;
        editorEdit.putBoolean("twitter_check", true).apply();
    }

    public final void k() {
        boolean z10 = false;
        int i10 = App.getInstance().f11574v.getInt("content_type", 0);
        String string = App.getInstance().f11574v.getString("genre", "");
        String string2 = App.getInstance().f11574v.getString("year", "");
        if (string.length() > 0 || (!string.equalsIgnoreCase("all") && !string2.isEmpty())) {
            z10 = true;
        }
        String str = "MOVIES";
        if (i10 == 0) {
            if (z10) {
                String strConcat = ": ".concat(string);
                if (string2.length() > 0) {
                    strConcat = ac.c.C(strConcat, ": ", string2);
                }
                getSupportActionBar().setTitle((getString(R.string.movies_label) + strConcat).toUpperCase(Locale.ROOT));
                return;
            }
            int i11 = this.f11717t0;
            if (i11 == 0) {
                str = getString(R.string.movies_label).toUpperCase() + ": TRENDING";
            } else if (i11 == 1) {
                str = getString(R.string.movies_label).toUpperCase() + ": IN THEATER";
            } else if (i11 == 2) {
                str = getString(R.string.movies_label).toUpperCase() + ": POPULAR";
            }
            getSupportActionBar().setTitle(str.toUpperCase(Locale.ROOT));
            return;
        }
        if (z10) {
            String strConcat2 = ": ".concat(string);
            if (string2.length() > 0) {
                strConcat2 = ac.c.C(strConcat2, ": ", string2);
            }
            getSupportActionBar().setTitle((getString(R.string.tv_series_label) + strConcat2).toUpperCase(Locale.ROOT));
            return;
        }
        int i12 = this.f11717t0;
        if (i12 == 0) {
            str = getString(R.string.tv_series_label).toUpperCase() + ": TRENDING";
        } else if (i12 == 1) {
            str = getString(R.string.tv_series_label).toUpperCase() + ": NOW STREAMING";
        } else if (i12 == 2) {
            str = getString(R.string.tv_series_label).toUpperCase() + ": POPULAR";
        }
        getSupportActionBar().setTitle(str.toUpperCase(Locale.ROOT));
    }

    public void longClickMovie(int i10) {
        int i11 = 1;
        try {
            Movie movie = this.K.get(i10);
            FragmentManager fragmentManager = getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setTitle(movie.getTitle());
            dVarNewInstance.setMessage("What would you like to Do?");
            dVarNewInstance.setButton1("MARK AS WATCHED", new ub.u(this, movie, i10, i11));
            dVarNewInstance.setButton2("ADD TO FAVORITES", new v(2, this, movie));
            try {
                dVarNewInstance.show(fragmentManager, "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } catch (Exception e11) {
            be.d.makeToast(this, "ERROR OCCURRED: " + e11.getMessage(), true);
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 42 && i11 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0) {
                Toast.makeText(getBaseContext(), getString(R.string.did_not_catch_any_mic_voice_mess), 0).show();
                return;
            }
            String str = stringArrayListExtra.get(0);
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(getBaseContext(), getString(R.string.did_not_catch_any_mic_voice_mess), 0).show();
                return;
            }
            if (str == null || str.length() < 3) {
                return;
            }
            Intent intent2 = new Intent(this, (Class<?>) SearchResultsActivity.class);
            intent2.putExtra("query", str);
            intent2.putExtra("tv_shows_only", App.getInstance().f11574v.getInt("content_type", 0) == 1);
            startActivity(intent2);
            return;
        }
        if ((intent != null && intent.getIntExtra("result", -1) == 8888) || i10 == 1000) {
            recreate();
        } else if (i10 == 10001) {
            App.getInstance().fetch_anime();
        } else if (i10 == 2000) {
            askToUpdateIfAny(false, null);
        } else if (i10 == 12345 && i11 == -1) {
            String stringExtra = intent.getStringExtra("fileExtraPath");
            h hVar = new h();
            try {
                hVar.f13009m = stringExtra.split("/")[r4.length - 1];
            } catch (Exception unused) {
                hVar.f13009m = stringExtra;
            }
            hVar.f13008b = stringExtra;
            hVar.f13010n = "3";
            App.getInstance().f11573u.addHistoryIPTV(hVar);
            Intent intent3 = new Intent(this, (Class<?>) TVCategoriesActivity2.class);
            intent3.putExtra("is_file", true);
            intent3.putExtra("url", stringExtra);
            startActivity(intent3);
        } else if (i10 == 1100 && App.getInstance().f11574v.getBoolean("clear_history_pending", false)) {
            try {
                MaterialSearchView materialSearchView = this.f11698a0;
                if (materialSearchView != null) {
                    materialSearchView.clearHistory();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            o1.a.j(App.getInstance().f11574v, "clear_history_pending", false);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        e();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final int i10 = 1;
        App.getInstance().f11574v.getBoolean("pref_hide_unreleased", true);
        final int i11 = 0;
        if (bundle == null) {
            this.V = false;
            if (App.getInstance().f11574v.getBoolean("IS_RD_LOGGED_IN", false)) {
                App.getInstance().refreshTokenRD();
                RealDebridCommon.f12051p = true;
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
        try {
            setContentView(R.layout.activity_main);
        } catch (Exception e10) {
            e10.printStackTrace();
            i();
        } catch (OutOfMemoryError unused) {
            i();
            return;
        }
        int iRound = Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / 140);
        try {
            EventBus.getDefault().register(this);
        } catch (Exception unused2) {
        }
        this.f11712o0 = new fd.b();
        this.f11699b0 = new ArrayList<>();
        this.O = (RecyclerView) findViewById(R.id.recyclerview_continue);
        this.P = (RecyclerView) findViewById(R.id.recyclerview_network);
        this.U = (RelativeLayout) findViewById(R.id.activity_main);
        this.R = (TabLayout) findViewById(R.id.tabs);
        this.Z = (Toolbar) findViewById(R.id.toolbar);
        this.f11703f0 = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.X = (c) findViewById(R.id.nav_view);
        if (App.getInstance().f11574v.getBoolean("pref_show_adult_zone", true)) {
            this.X.inflateMenu(R.menu.nav_drawer_menu);
        } else {
            this.X.inflateMenu(R.menu.nav_drawer_menu_no_adult);
        }
        int i12 = 2;
        new ColorStateList(new int[][]{new int[]{android.R.attr.state_focused}, new int[]{-16842908}, new int[]{-16842913}, new int[]{android.R.attr.state_selected}}, new int[]{-16777216, -1, -1, -16777216});
        this.f11701d0 = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.f11698a0 = (MaterialSearchView) findViewById(R.id.search_view);
        this.f11715r0 = getResources().getColor(R.color.colorPrimary);
        AssetManager assets = getAssets();
        String str3 = Constant.f12450b;
        this.f11706i0 = Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        this.f11707j0 = Typeface.createFromAsset(getAssets(), "fonts/product_sans_bold.ttf");
        this.f11705h0 = new c4.a();
        try {
            EventBus.getDefault().register(this);
        } catch (Exception unused3) {
        }
        this.f11705h0.applyFontToNavigationView(this.X, this.f11707j0);
        setSupportActionBar(this.Z);
        this.X.setNavigationItemSelectedListener(this);
        c1 c1Var = new c1(this, this, this.f11703f0, this.Z);
        this.f11704g0 = c1Var;
        this.f11703f0.setDrawerListener(c1Var);
        this.f11704g0.syncState();
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_subject_24);
        this.f11700c0 = new t(getBaseContext(), this.f11699b0, this, this.Y, this, this);
        this.M = new e0(getBaseContext(), this.K, this, this);
        this.O.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.O.setAdapter(this.M);
        this.O.addItemDecoration(new fd.c(5));
        Context baseContext = getBaseContext();
        ArrayList<ld.a> arrayList = this.L;
        this.N = new u(baseContext, arrayList, this);
        this.P.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.P.setAdapter(this.N);
        int i13 = 10;
        o1.a.h(10, this.P);
        this.f11701d0.setRefreshListener(this);
        this.f11701d0.setLayoutManager(new CenterGridLayoutManager(this, iRound));
        this.f11701d0.addItemDecoration(new fd.c(12));
        this.f11701d0.setAdapter(this.f11700c0);
        this.f11701d0.setupMoreListener(this, 20);
        this.Z.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.b1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ MainActivity f20156m;

            {
                this.f20156m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i14 = i11;
                MainActivity mainActivity = this.f20156m;
                switch (i14) {
                    case 0:
                        int i15 = MainActivity.f11697v0;
                        mainActivity.getClass();
                        if (z10) {
                            try {
                                View actionView = mainActivity.W.getActionView();
                                if (actionView != null) {
                                    mainActivity.Z.clearFocus();
                                    actionView.requestFocus();
                                    break;
                                }
                            } catch (Exception unused4) {
                                return;
                            }
                        }
                        break;
                    default:
                        if (!z10) {
                            int i16 = MainActivity.f11697v0;
                            mainActivity.getClass();
                            break;
                        } else {
                            mainActivity.U.clearFocus();
                            mainActivity.f11701d0.requestFocus();
                            break;
                        }
                }
            }
        });
        this.f11698a0.setHint("Movies, TV Shows, People...");
        this.f11698a0.adjustTintAlpha(0.0f);
        this.f11698a0.setCloseOnTintClick(true);
        this.f11698a0.setOnQueryTextListener(new d1(this));
        this.f11698a0.setOnItemClickListener(new ub.f(this, i12));
        RelativeLayout relativeLayout = this.U;
        if (relativeLayout != null) {
            relativeLayout.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.b1

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ MainActivity f20156m;

                {
                    this.f20156m = this;
                }

                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z10) {
                    int i14 = i10;
                    MainActivity mainActivity = this.f20156m;
                    switch (i14) {
                        case 0:
                            int i15 = MainActivity.f11697v0;
                            mainActivity.getClass();
                            if (z10) {
                                try {
                                    View actionView = mainActivity.W.getActionView();
                                    if (actionView != null) {
                                        mainActivity.Z.clearFocus();
                                        actionView.requestFocus();
                                        break;
                                    }
                                } catch (Exception unused4) {
                                    return;
                                }
                            }
                            break;
                        default:
                            if (!z10) {
                                int i16 = MainActivity.f11697v0;
                                mainActivity.getClass();
                                break;
                            } else {
                                mainActivity.U.clearFocus();
                                mainActivity.f11701d0.requestFocus();
                                break;
                            }
                    }
                }
            });
        }
        this.R.setOnTabSelectedListener((TabLayout.d) new e1(this));
        if (bundle == null) {
            try {
                new Handler().postDelayed(new x0(this, 7), 5000L);
            } catch (Exception unused4) {
            }
        }
        if (App.getInstance().f11574v.getString("guid", "null").equals("null")) {
            App.getInstance().f11574v.edit().putString("guid", UUID.randomUUID().toString()).apply();
        }
        k();
        new Handler().postDelayed(new x0(this, 9), 1000L);
        new Handler().postDelayed(new x0(this, i13), 1000L);
        new Handler().postDelayed(new x0(this, 11), 500L);
        this.f11705h0.applyFontToToolbar(this.Z, this.f11707j0);
        f(this.f11702e0);
        if (App.getInstance().f11574v.getInt("content_type", 0) == 0) {
            this.f11708k0 = "IN THEATER";
        } else {
            this.f11708k0 = "NOW STREAMING";
        }
        try {
            this.R.getTabAt(1).setText(this.f11708k0);
        } catch (Exception unused5) {
        }
        new Handler().postDelayed(new x0(this, 8), 2000L);
        new Handler().postDelayed(new x0(this, 6), 3000L);
        App.getInstance().loadRemoteConfig();
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/FlixVision.Update" + "".replace(StringUtils.SPACE, "").replace(".", "") + ".apk");
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused6) {
        }
        if (!App.K) {
            try {
                this.Q = (MediaRouteButton) findViewById(R.id.media_route_button);
                CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), this.Q);
                CastContext.getSharedInstance(this);
            } catch (Exception unused7) {
            }
        }
        ArrayList<ld.a> networks = Constants.getNetworks();
        if (networks.size() > 0) {
            arrayList.clear();
            arrayList.addAll(networks);
            networks.clear();
            this.N.notifyDataSetChanged();
            this.P.setVisibility(0);
        } else {
            this.P.setVisibility(8);
        }
        g();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (App.K) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
        } else {
            getMenuInflater().inflate(R.menu.main_menu_smartphones, menu);
            CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), menu, R.id.media_route_menu_item);
        }
        this.f11710m0 = menu;
        this.W = menu.findItem(R.id.action_filter);
        this.f11705h0.applyFontToMenu(this.f11710m0, this.f11706i0);
        if (App.getInstance().f11574v.getInt("content_type", 0) == 0) {
            App.getInstance().f11574v.edit().putInt("actual_menu_index", 0).apply();
        } else {
            App.getInstance().f11574v.edit().putInt("actual_menu_index", 1).apply();
        }
        return true;
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // r.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int directionPressed = this.f11712o0.getDirectionPressed(keyEvent);
        if (directionPressed != 0 && directionPressed != 1 && directionPressed != 2 && directionPressed != 3 && directionPressed != 4) {
            switch (directionPressed) {
                case 10:
                    e();
                    break;
                case 11:
                    if (this.f11703f0.isDrawerOpen(8388611)) {
                        this.f11703f0.closeDrawer(8388611);
                    } else {
                        this.f11703f0.openDrawer(8388611);
                    }
                    return true;
                case 12:
                    this.f11698a0.openSearch();
                    return true;
                default:
                    return super.onKeyDown(i10, keyEvent);
            }
        }
        return false;
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        if (sharedPreferences.getBoolean("update_available", false)) {
            if (!App.getInstance().f11574v.getBoolean("mandatory_update", false)) {
                askToUpdateIfAny(false, movie);
                return;
            }
            askToUpdateIfAny(false, null);
        }
        openMovieintent(movie);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Constants.TRAKT_TV_EVENT trakt_tv_event) {
        if (trakt_tv_event != Constants.TRAKT_TV_EVENT.USER_LOGGED_IN || this.f11718u0) {
            return;
        }
        this.f11718u0 = true;
        d dVarCreate = new d.a(this).create();
        dVarCreate.setTitle("Trakt TV");
        dVarCreate.setIcon(R.drawable.trakt_logo_3);
        dVarCreate.setMessage("Hello " + App.getInstance().f11574v.getString("trakt_user_name", "") + getString(R.string.trakt_welcome_mess));
        int i10 = 0;
        dVarCreate.setButton(-1, getString(R.string.yes_sync_now), new t0(i10));
        dVarCreate.setButton(-2, getString(R.string.no_thanks_label), new t0(1));
        dVarCreate.setButton(-3, getString(R.string.go_to_trk_settings), new u0(this, i10));
        try {
            dVarCreate.show();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // aa.a
    public void onMoreAsked(int i10, int i11, int i12) {
        if (this.T) {
            this.f11702e0++;
            new Handler().postDelayed(new x0(this, 2), 200L);
        }
    }

    @Override // l7.c.InterfaceC0189c
    public boolean onNavigationItemSelected(MenuItem menuItem) throws PackageManager.NameNotFoundException {
        onNavigationItemSelected1(menuItem.getItemId());
        return false;
    }

    public boolean onNavigationItemSelected1(int i10) throws PackageManager.NameNotFoundException {
        this.f11703f0.closeDrawer(8388611);
        int i11 = 2;
        int i12 = 1;
        int i13 = 0;
        if (i10 == R.id.setting_follow_discord) {
            h();
        } else if (i10 == R.id.setting_contact) {
            FragmentManager fragmentManager = getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setTitle("Get in touch");
            dVarNewInstance.setMessage("Report issue and suggestions at info@flixvision.tv");
            dVarNewInstance.setButton1("OK", new z0(dVarNewInstance, i11));
            dVarNewInstance.setButton2("OPEN MAIL APP", new s0(this, dVarNewInstance, fragmentManager, i13));
            try {
                dVarNewInstance.show(fragmentManager, "");
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (i10 == R.id.action_user_torrent) {
            if (AllDebridCommon.f12043n || RealDebridCommon.f12051p || PremiumizeCommon.f12045b) {
                startActivity(new Intent(this, (Class<?>) UserTorrentsActivity.class));
            } else {
                Toast.makeText(this, "Please connect a Premium account first to see your Torrents (RealDebrid, Premiumize or AllDebrid", 1).show();
            }
        }
        if (i10 != R.id.action_donation) {
            if (i10 == R.id.action_adult) {
                if (App.getInstance().f11574v.getBoolean("pref_adult_zone_pin_set", false)) {
                    startActivity(new Intent(this, (Class<?>) AdultZonePINEntryActivity.class));
                } else {
                    startActivity(new Intent(this, (Class<?>) AdultPINSetupActivity.class));
                }
            } else if (i10 == R.id.setting_follow_twitter) {
                j();
            } else if (i10 == R.id.action_exit) {
                finish();
            } else if (i10 == R.id.action_drama) {
                startActivity(new Intent(this, (Class<?>) DramaHomeActivity.class));
            } else if (i10 == R.id.action_anime) {
                startActivity(new Intent(this, (Class<?>) AnimesListActivity.class));
            } else if (i10 == R.id.action_tvseries) {
                App.getInstance().f11574v.edit().putInt("actual_menu_index", 1).apply();
                App.getInstance().f11574v.edit().putInt("content_type", 1).apply();
                try {
                    new Handler().postDelayed(new x0(this, 3), 200L);
                } catch (Exception e11) {
                    e11.printStackTrace();
                    recreate();
                }
            } else if (i10 == R.id.action_movies) {
                App.getInstance().f11574v.edit().putInt("actual_menu_index", 0).apply();
                App.getInstance().f11574v.edit().putInt("content_type", 0).apply();
                try {
                    new Handler().postDelayed(new x0(this, 4), 200L);
                } catch (Exception e12) {
                    e12.printStackTrace();
                    recreate();
                }
            } else if (i10 == R.id.action_settings) {
                startActivityForResult(new Intent(this, (Class<?>) SettingsActivity.class), 1100);
            } else if (i10 == R.id.action_my_tv_imports) {
                startActivity(new Intent(this, (Class<?>) MyImportActivity.class));
            } else if (i10 == R.id.action_my_favorites) {
                if (App.getInstance().f11573u.getFavoritesMoviesFromDb().size() > 0) {
                    startActivity(new Intent(this, (Class<?>) FavoritesAcvivity.class));
                } else {
                    be.d.makeToast(this, "No Item in your Favorites", false);
                }
            } else if (i10 == R.id.action_import_tv) {
                FragmentManager fragmentManager2 = getFragmentManager();
                kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
                dVarNewInstance2.setTitle("M3U Import");
                dVarNewInstance2.setMessage("How do you want to import your M3U Playlist?");
                dVarNewInstance2.setButton2("From File", new y0(this, i13));
                dVarNewInstance2.setButton1("From URL", new y0(this, i12));
                try {
                    dVarNewInstance2.show(fragmentManager2, "");
                } catch (Exception e13) {
                    e13.printStackTrace();
                }
            } else if (i10 == R.id.action_live_tv_extra) {
                startActivity(new Intent(this, (Class<?>) TVCategoriesActivity2.class));
            } else if (i10 == R.id.action_trakt) {
                if (App.getInstance().f11574v.getBoolean("trakt_user_logged_in", false)) {
                    startActivity(new Intent(this, (Class<?>) TraktActivity.class));
                } else {
                    FragmentManager fragmentManager3 = getFragmentManager();
                    kc.d dVarNewInstance3 = kc.d.newInstance(this, false);
                    dVarNewInstance3.setTitle(getString(R.string.trakt_tv_label));
                    dVarNewInstance3.setCancelable(false);
                    dVarNewInstance3.setMessage(getString(R.string.connect_with_trakt_tv_enjoy_benefits_mess));
                    dVarNewInstance3.setButton1("CANCEL", new q0(i11));
                    dVarNewInstance3.setButton2(getString(R.string.action_sign_in), new y0(this, i11));
                    try {
                        dVarNewInstance3.show(fragmentManager3, "");
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                }
            } else if (i10 == R.id.action_watched_history) {
                if (App.getInstance().f11573u.getWatchedMoviesFromDb().size() == 0) {
                    be.d.makeToast(this, "No Item Marked As Watched Yet", false);
                } else {
                    startActivity(new Intent(this, (Class<?>) WatchedAcvivity.class));
                }
            } else if (i10 != R.id.action_watched_history && i10 != R.id.action_my_favorites) {
                this.f11710m0.findItem(R.id.action_sort_fav).setVisible(false);
            }
        }
        return false;
    }

    public void onNetworkClicked(ld.a aVar) {
        if (aVar.f16048b == 9991) {
            Intent intent = new Intent(this, (Class<?>) DramaHomeActivity.class);
            intent.setFlags(268435456);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(this, (Class<?>) FilterActivity.class);
            intent2.putExtra("network", aVar.f16048b);
            intent2.setFlags(268435456);
            startActivity(intent2);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_filter) {
            startActivity(new Intent(this, (Class<?>) FilterActivity.class));
        } else if (itemId == R.id.action_refresh) {
            try {
                resetFilter();
                finish();
                App.getInstance().restartApp();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (itemId == R.id.action_exit_app) {
            try {
                finish();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            int i10 = 1;
            if (itemId == R.id.action_sort_fav) {
                if (!this.V) {
                    Collections.sort(this.f11699b0);
                    this.V = true;
                }
                Collections.reverse(this.f11699b0);
                this.f11700c0.notifyDataSetChanged();
            } else {
                int i11 = 0;
                if (itemId == R.id.action_search) {
                    if (!App.K || App.getInstance().f11574v.getBoolean("pref_classic_search", false)) {
                        this.f11698a0.openSearch();
                    } else {
                        startActivity(new Intent(this, (Class<?>) SearchActivityTV.class));
                    }
                } else if (itemId == R.id.action_tvseries) {
                    App.getInstance().f11574v.edit().putInt("content_type", 1).apply();
                    try {
                        new Handler().postDelayed(new x0(this, i11), 300L);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        recreate();
                    }
                } else if (itemId == R.id.action_movies) {
                    App.getInstance().f11574v.edit().putInt("content_type", 0).apply();
                    try {
                        new Handler().postDelayed(new x0(this, i10), 300L);
                    } catch (Exception e13) {
                        e13.printStackTrace();
                        recreate();
                    }
                } else if (itemId == R.id.action_settings) {
                    startActivityForResult(new Intent(this, (Class<?>) SettingsActivity.class), 1100);
                } else if (itemId == R.id.action_check_update) {
                    FragmentManager fragmentManager = getFragmentManager();
                    kc.d dVarNewInstance = kc.d.newInstance(this, false);
                    dVarNewInstance.setloading();
                    try {
                        dVarNewInstance.show(fragmentManager, "");
                    } catch (Exception e14) {
                        e14.printStackTrace();
                    }
                    App.getInstance().loadRemoteConfig();
                    new Handler().postDelayed(new x(21, this, dVarNewInstance), 5000L);
                } else if (itemId == R.id.action_favorites) {
                    if (App.getInstance().f11573u.getFavoritesMoviesFromDb().size() > 0) {
                        startActivity(new Intent(this, (Class<?>) FavoritesAcvivity.class));
                    } else {
                        be.d.makeToast(this, "No Item in your Favorites", false);
                    }
                } else if (itemId == R.id.action_clear) {
                    int i12 = this.f11709l0;
                    if (i12 == 2) {
                        kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
                        dVarNewInstance2.setButton1("YES CLEAR", new a1(this, dVarNewInstance2, i10));
                        dVarNewInstance2.setButton2(getString(R.string.cancel_label), new z0(dVarNewInstance2, i10));
                        dVarNewInstance2.setMessage("This will clear all your Favorites\nDo You really want to clear them?");
                        dVarNewInstance2.setTitle("Clear Favorites");
                        dVarNewInstance2.show(getFragmentManager(), "");
                    }
                    int i13 = 4;
                    int i14 = 3;
                    if (i12 == 3) {
                        kc.d dVarNewInstance3 = kc.d.newInstance(this, true);
                        dVarNewInstance3.setButton1("YES CLEAR", new a1(this, dVarNewInstance3, i14));
                        dVarNewInstance3.setButton2(getString(R.string.cancel_label), new z0(dVarNewInstance3, i13));
                        dVarNewInstance3.setMessage("This will clear all your Watched Movies and Shows and You will loose their Progress. \nDo You really want to clear your History?");
                        dVarNewInstance3.setTitle("Clear Watch List");
                        dVarNewInstance3.show(getFragmentManager(), "");
                    }
                    if (i12 == 4) {
                        be.d.makeToast(this, "Cannot clear Watching list", false);
                    }
                }
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        MaterialSearchView materialSearchView = this.f11698a0;
        if (materialSearchView != null) {
            materialSearchView.clearSuggestions();
        }
        super.onPause();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.f
    public void onRefresh() {
        k();
        this.f11702e0 = 1;
        this.f11699b0.clear();
        f(this.f11702e0);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        MaterialSearchView materialSearchView = this.f11698a0;
        if (materialSearchView != null) {
            materialSearchView.activityResumed();
            this.f11698a0.closeSearch();
        }
        if (App.getInstance().f11566n) {
            g();
            App.getInstance().f11566n = false;
        }
    }

    public void openMovieintent(Movie movie) {
        App.getInstance().f11566n = false;
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
