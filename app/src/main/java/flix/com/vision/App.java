package flix.com.vision;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.b;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.google.gson.l;
import com.google.gson.q;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import d4.m;
import ec.e;
import flix.com.vision.App;
import flix.com.vision.api.alldebrid.AllDebridCommon;
import flix.com.vision.api.premiumize.PremiumizeCommon;
import flix.com.vision.api.realdebrid.RealDebridCommon;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import flix.com.vision.tv.TVCategory;
import flix.com.vision.utils.JsonUtils;
import flix.com.vision.utils.QueryExternalSdk;
import hd.f;
import hd.h;
import hd.o;
import io.netas.Netas;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.adblockplus.libadblockplus.HttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w2.j;
import w2.n;

/* loaded from: classes2.dex */
public class App extends Application {
    public static String D;
    public static final HashMap G;
    public static App H;
    public static boolean I;
    public static ArrayList<String> J;
    public static boolean K;
    public static ArrayList<String> L;
    public static ArrayList<String> M;
    public static ArrayList<String> N;
    public ArrayList<f> A;

    /* renamed from: b, reason: collision with root package name */
    public String f11564b;

    /* renamed from: p, reason: collision with root package name */
    public String f11568p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<hd.d> f11569q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<hd.d> f11570r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<TVCategory> f11571s;

    /* renamed from: t, reason: collision with root package name */
    public bc.b f11572t;

    /* renamed from: u, reason: collision with root package name */
    public jc.c f11573u;

    /* renamed from: v, reason: collision with root package name */
    public SharedPreferences f11574v;

    /* renamed from: w, reason: collision with root package name */
    public RequestQueue f11575w;
    public static final ArrayList<String> B = new ArrayList<>();
    public static final ArrayList<o> C = new ArrayList<>();
    public static final int E = 30000;
    public static String F = "";

    /* renamed from: m, reason: collision with root package name */
    public boolean f11565m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11566n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f11567o = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11576x = true;

    /* renamed from: y, reason: collision with root package name */
    public final ArrayDeque<String> f11577y = new ArrayDeque<>();

    /* renamed from: z, reason: collision with root package name */
    public String f11578z = "http://185.112.144.240";

    public class a extends AsyncTask<String, String, String> {
        public a() {
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) {
            App app = App.this;
            try {
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (app.f11574v.getBoolean("data_type10", false)) {
                return null;
            }
            app.downloadFileAndUnzipNew(Constants.f12320b, false);
            return null;
        }
    }

    public class b extends AsyncTask<Void, Void, String> {
        public b() {
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) throws Resources.NotFoundException {
            String string = App.getInstance().getResources().getString(R.string.config_uri);
            try {
                Response response = App.get(string, string);
                boolean zIsSuccessful = response.isSuccessful();
                App app = App.this;
                if (zIsSuccessful) {
                    app.parseRemoteConfig(JsonUtils.parse(response.body().string()).getAsJsonObject());
                } else {
                    String string2 = App.getInstance().getResources().getString(R.string.config_uri_backup);
                    app.parseRemoteConfig(JsonUtils.parse(App.get(string2, string2).body().string()).getAsJsonObject());
                }
                return null;
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((b) str);
        }
    }

    public class c extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f11581a;

        /* renamed from: b, reason: collision with root package name */
        public final String f11582b;

        public d(App app, String str, String str2) {
            this.f11581a = str;
            this.f11582b = str2;
        }
    }

    static {
        new HashSet();
        G = new HashMap();
        I = false;
        J = new ArrayList<>();
        K = false;
        new ArrayList();
    }

    public static void RefreshAllDebridHosts() {
        if (N == null) {
            N = new ArrayList<>();
        }
        getInstance().getRequestQueue().add(new m(0, AllDebridCommon.f12042m, new u8.a(15), new u8.a(16)));
    }

    public static void RefreshPremHosts(String str, int i10) {
        if (M == null) {
            M = new ArrayList<>();
        }
        getInstance().getRequestQueue().add(new m(i10, ac.c.j("https://www.premiumize.me/api/services/list?apikey=", str), new u8.a(22), new u8.a(23)));
    }

    public static void RefreshRDHosts(String str, int i10) {
        if (L == null) {
            L = new ArrayList<>();
        }
        getInstance().getRequestQueue().add(new m(i10, str, new u8.a(18), new u8.a(19)));
    }

    public static void c() throws Resources.NotFoundException {
        if (L == null) {
            L = new ArrayList<>();
        }
        if (L.size() > 0) {
            return;
        }
        Collections.addAll(L, getInstance().getResources().getStringArray(R.array.hosts));
    }

    @SuppressLint({"CheckResult"})
    public static void deleteAllMagnetsAllDebrid() {
        bc.a.getAllMagnetAllDebrid().observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new u8.a(11), new u8.a(12));
    }

    @SuppressLint({"CheckResult"})
    public static synchronized void deleteMagnetsAllDebrid(String str) {
        bc.a.deleteMagnetAllDebrid(str).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new u8.a(20), new u8.a(21));
    }

    public static void extractDominantColor(View view) {
        try {
            ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
            valueAnimatorOfObject.setDuration(2000L);
            valueAnimatorOfObject.addUpdateListener(new l7.a(view, 2));
            valueAnimatorOfObject.addListener(new c());
            valueAnimatorOfObject.start();
        } catch (Exception unused) {
        }
    }

    public static Response get(String str, String str2) {
        try {
            return new OkHttpClient().newCall(new Request.Builder().header("Referer", str2).url(str).build()).execute();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Response getAjax(String str) {
        try {
            return new OkHttpClient().newCall(new Request.Builder().header(HttpClient.HEADER_REQUESTED_WITH, HttpClient.HEADER_REQUESTED_WITH_XMLHTTPREQUEST).url(str).build()).execute();
        } catch (Exception unused) {
            return null;
        }
    }

    public static synchronized App getInstance() {
        return H;
    }

    public static boolean isADSupported(String str) {
        ArrayList<String> arrayList = N;
        if (arrayList == null || arrayList.size() < 10) {
            return true;
        }
        Iterator<String> it = N.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRdSupported(String str) {
        ArrayList<String> arrayList = L;
        if (arrayList == null || arrayList.size() < 10) {
            return true;
        }
        Iterator<String> it = L.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static Response post(String str, Map<String, String> map, String str2) {
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        try {
            return okHttpClient.newCall(new Request.Builder().header("Referer", str2).header(HttpClient.HEADER_REQUESTED_WITH, HttpClient.HEADER_REQUESTED_WITH_XMLHTTPREQUEST).url(str).post(builder.build()).build()).execute();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str, String str2, boolean z10) throws IOException {
        FileReader fileReader;
        try {
            String line = null;
            try {
                fileReader = new FileReader(new File(str + str2));
            } catch (FileNotFoundException e10) {
                e10.printStackTrace();
                fileReader = null;
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder sb2 = new StringBuilder();
            try {
                line = bufferedReader.readLine();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            while (line != null) {
                sb2.append(line);
                sb2.append(StringUtils.LF);
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e13) {
                e13.printStackTrace();
            }
            String string = sb2.toString();
            if (string != null) {
                d(string, str2, z10);
            }
        } catch (Exception unused) {
        }
    }

    public boolean addHash(String str) {
        String hashFromMagnet = be.f.getHashFromMagnet(str);
        if (hashFromMagnet == null) {
            return true;
        }
        String lowerCase = hashFromMagnet.toLowerCase();
        if (J == null) {
            J = new ArrayList<>();
        }
        if (J.contains(lowerCase)) {
            return false;
        }
        J.add(lowerCase);
        return true;
    }

    public <T> void addToRequestQueue(com.android.volley.Request<T> request, String str) {
        if (TextUtils.isEmpty(str)) {
            str = VolleyLog.TAG;
        }
        request.setTag(str);
        request.setRetryPolicy(new DefaultRetryPolicy(E, 1, 1.0f));
        getRequestQueue().add(request);
    }

    public final void b() throws Throwable {
        try {
            n.getInstance(this).enqueueUniquePeriodicWork("AppgainQueryWork", ExistingPeriodicWorkPolicy.REPLACE, new j.a(QueryExternalSdk.class, 60L, TimeUnit.MINUTES).setInputData(new b.a().putString("DEVICE_ID", Settings.Secure.getString(getContentResolver(), "android_id")).putString("PUBLISHER_ID", "flixview").build()).build());
        } catch (Exception e10) {
            Log.e("MonControl", "exception while startPeriodicQuery " + e10.getMessage());
        }
    }

    public void cleanTorrentsRealDebrid() {
        bc.a.getMagnetsRealDebridAll(RealDebridCommon.f12049n, RealDebridCommon.f12047b, DefaultRetryPolicy.DEFAULT_TIMEOUT_MS).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new tb.c(this, 0), new u8.a(17));
    }

    public final void d(String str, String str2, boolean z10) throws JSONException {
        if (!(z10 && str2.contains("anime")) && (!str2.contains("anime") || this.f11574v.getBoolean("data_type10", false))) {
            return;
        }
        ArrayList<hd.a> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                String string = jSONObject.getString("url");
                String string2 = jSONObject.getString("title_with_year");
                String string3 = jSONObject.getString("genres");
                jSONObject.getString("title");
                String string4 = jSONObject.getString("img_url");
                String string5 = jSONObject.getString("plot");
                hd.a aVar = new hd.a();
                aVar.f12969b = string;
                aVar.f12968a = string2;
                aVar.f12971d = string3;
                aVar.f12972e = string5;
                aVar.f12970c = string4;
                arrayList.add(aVar);
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        if (arrayList.size() <= 0 || !this.f11573u.AddAnimeItem(arrayList) || z10) {
            return;
        }
        o1.a.j(this.f11574v, "data_type10", true);
        try {
            Toast.makeText(getApplicationContext(), "Anime section ready...", 0).show();
        } catch (Exception unused) {
        }
    }

    public void deleteTorrentsRealDebrid(String str) {
        bc.a.deleteMagnetRealDebrid(str, RealDebridCommon.f12049n, RealDebridCommon.f12047b).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new tb.c(this, 1), new tb.c(this, 2));
    }

    public void deleteTorrentsRealDebridNew() {
        bc.a.getMagnetsRealDebridAll(RealDebridCommon.f12049n, RealDebridCommon.f12047b, 30).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new tb.b(this, new ArrayDeque(), 0), new u8.a(13));
    }

    public synchronized void deleteTorrentsRealDebridNewNew(ArrayDeque<String> arrayDeque) {
        bc.a.deleteMagnetRealDebrid(arrayDeque.pop(), RealDebridCommon.f12049n, RealDebridCommon.f12047b).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new u8.a(14), new tb.b(this, arrayDeque, 1));
    }

    public boolean downloadFileAndUnzipNew(String str, boolean z10) throws InterruptedException, IOException {
        String strSubstring;
        String str2 = null;
        try {
            str2 = getApplicationContext().getExternalCacheDir().getAbsolutePath() + "/files/";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection.getResponseCode() != 200) {
                httpURLConnection.disconnect();
                return false;
            }
            String headerField = httpURLConnection.getHeaderField("Content-Disposition");
            httpURLConnection.getContentType();
            httpURLConnection.getContentLength();
            if (headerField != null) {
                int iIndexOf = headerField.indexOf("filename=");
                strSubstring = iIndexOf > 0 ? headerField.substring(iIndexOf + 10, headerField.length() - 1) : "";
            } else {
                strSubstring = str.substring(str.lastIndexOf("/") + 1);
            }
            InputStream inputStream = httpURLConnection.getInputStream();
            if (strSubstring.endsWith(".zi")) {
                strSubstring = strSubstring.concat("p");
            }
            String strB = ac.c.B(str2, strSubstring);
            try {
                File file2 = new File(strB);
                if (file2.exists()) {
                    file2.delete();
                }
            } catch (Exception unused) {
            }
            FileOutputStream fileOutputStream = new FileOutputStream(strB);
            byte[] bArr = new byte[4096];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, i10);
            }
            fileOutputStream.close();
            inputStream.close();
            System.out.println("File downloaded");
            httpURLConnection.disconnect();
            ArrayList arrayList = new ArrayList();
            try {
                ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(str2 + strSubstring)));
                byte[] bArr2 = new byte[1024];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String name = nextEntry.getName();
                    if (!name.contains("MA")) {
                        if (nextEntry.isDirectory()) {
                            new File(str2 + name).mkdirs();
                        } else {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str2 + name);
                            while (true) {
                                int i11 = zipInputStream.read(bArr2);
                                if (i11 == -1) {
                                    break;
                                }
                                fileOutputStream2.write(bArr2, 0, i11);
                            }
                            fileOutputStream2.close();
                            zipInputStream.closeEntry();
                            arrayList.add(new d(this, str2, name));
                        }
                    }
                }
                zipInputStream.close();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    d dVar = (d) it.next();
                    try {
                        Thread.sleep(1000L);
                        a(dVar.f11581a, dVar.f11582b, z10);
                    } catch (InterruptedException e11) {
                        e11.printStackTrace();
                        a(dVar.f11581a, dVar.f11582b, z10);
                    } catch (Exception unused2) {
                    }
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return true;
        } catch (IOException e13) {
            e13.printStackTrace();
            return false;
        }
    }

    public void fetchReleaseNote() {
        o1.a.p(B, "• Fixed FVSTREAM Movie Server\n", "• Added More TV Channels\n", "• Added new Embed Provider\n", "• Many bug fixes\n");
    }

    public void fetch_anime() {
        new a().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public ArrayList<Movie> filterList(ArrayList<Movie> arrayList) {
        if (this.f11576x) {
            arrayList = Constants.filterFlaggedContent(arrayList);
        }
        if (!this.f11574v.getBoolean("pref_hide_unreleased", true)) {
            return arrayList;
        }
        ArrayList<Movie> arrayList2 = new ArrayList<>();
        Iterator<Movie> it = arrayList.iterator();
        while (it.hasNext()) {
            Movie next = it.next();
            if (next.released()) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public RequestQueue getRequestQueue() {
        if (this.f11575w == null) {
            this.f11575w = d4.o.newRequestQueue(getApplicationContext());
        }
        return this.f11575w;
    }

    public void initTech(boolean z10) throws Throwable {
        SharedPreferences sharedPreferences = this.f11574v;
        String str = Constant.f12450b;
        if (sharedPreferences.getBoolean("pref_t_ninja_1", true)) {
            try {
                new Netas.Builder().withPublisher("flixview_gms").withForegroundService(Boolean.valueOf(z10)).build(this, "Flix Vision", "Flix Vision", R.mipmap.ic_launcher).start();
            } catch (Exception unused) {
            }
        }
        // REMOVED: AppBandwidthMonetizer malware initialization - bandwidth hijacking SDK
        // try {
        //     SharedPreferences sharedPreferences2 = this.f11574v;
        //     String str2 = Constant.f12450b;
        //     if (sharedPreferences2.getBoolean("pref_t_ninja_2", true)) {
        //         ea.a.getInstance(this).initPro("flixview");
        //         b();
        //     }
        // } catch (Exception unused2) {
        // }
        SharedPreferences sharedPreferences3 = this.f11574v;
        String str3 = Constant.f12450b;
        // REMOVED: TraffMonetizer malware initialization - bandwidth hijacking SDK
        // if (sharedPreferences3.getBoolean("pref_traff_1", false) && this.f11574v.getBoolean("pref_traff_1", false)) {
        //     ua.a.f20139a.init(this, "A95Piq2hlZLJuil9YEQe4Ng2L1mHjSF5oMkt+0vcRLU=");
        // }
    }

    public boolean isTVDevice() {
        try {
            if (((UiModeManager) getSystemService("uimode")).getCurrentModeType() == 4) {
                K = true;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return K;
    }

    @SuppressLint({"StaticFieldLeak"})
    public void loadRemoteConfig() {
        new b().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // android.app.Application
    public void onCreate() throws Throwable {
        super.onCreate();
        H = this;
        new Handler();
        this.A = new ArrayList<>();
        this.f11573u = new jc.c(this);
        SharedPreferences sharedPreferences = getSharedPreferences("flix.com.vision", 0);
        this.f11574v = sharedPreferences;
        I = sharedPreferences.getBoolean("pref_hd_posters", false);
        if (this.f11574v.getBoolean("IS_RD_LOGGED_IN", false)) {
            getInstance().refreshTokenRD();
            RealDebridCommon.f12051p = true;
            RefreshRDHosts("https://api.real-debrid.com/rest/1.0/hosts", 0);
        }
        if (this.f11574v.getBoolean("PREM_LOGGED_IN", false)) {
            PremiumizeCommon.f12045b = true;
            SharedPreferences sharedPreferences2 = getInstance().f11574v;
            String str = Constants.f12319a;
            String string = sharedPreferences2.getString("prem_apikey", null);
            PremiumizeCommon.f12046m = string;
            RefreshPremHosts(string, 0);
        }
        if (this.f11574v.getBoolean("ALL_DEBRID_LOGGED_IN", false)) {
            AllDebridCommon.f12043n = true;
            SharedPreferences sharedPreferences3 = getInstance().f11574v;
            String str2 = Constants.f12319a;
            AllDebridCommon.f12044o = sharedPreferences3.getString("all_debrid_apikey", null);
            RefreshAllDebridHosts();
        }
        if (RealDebridCommon.f12051p && !this.f11574v.getBoolean("RD_CLEANED", false)) {
            new Handler().postDelayed(new Runnable() { // from class: tb.a
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList<String> arrayList = App.B;
                    this.f19880b.cleanTorrentsRealDebrid();
                }
            }, 5000L);
        }
        if (getInstance().f11574v.getString("default_download_folder", null) == null) {
            D = Environment.getExternalStorageDirectory() + "/StreamzHD_Downloads/";
            getInstance().f11574v.edit().putString("default_download_folder", D).apply();
        } else {
            D = getInstance().f11574v.getString("default_download_folder", Environment.getExternalStorageDirectory() + "/StreamzHD_Downloads/");
        }
        this.f11572t = new bc.b(getApplicationContext());
        isTVDevice();
        Calendar.getInstance().get(1);
        this.f11569q = new ArrayList<>();
        this.f11570r = new ArrayList<>();
        this.f11571s = new ArrayList<>();
        fetchReleaseNote();
        loadRemoteConfig();
        md.a.fetchTMDBAPI();
        initTech(K);
        fetch_anime();
    }

    public void parseRemoteConfig(q qVar) throws NumberFormatException {
        boolean z10;
        int i10;
        try {
            SharedPreferences.Editor editorEdit = getInstance().f11574v.edit();
            String str = Constant.f12450b;
            editorEdit.putBoolean("update_available", false).apply();
            String asString = qVar.get(ClientCookie.DOMAIN_ATTR).getAsString();
            if (asString != null && !asString.isEmpty()) {
                this.f11578z = asString;
            }
            String asString2 = qVar.get("apk_url").getAsString();
            String asString3 = qVar.get("version_code").getAsString();
            String asString4 = qVar.get("update_enforcement").getAsString();
            boolean asBoolean = qVar.get("janint").getAsBoolean();
            boolean asBoolean2 = qVar.get("janint2").getAsBoolean();
            String asString5 = qVar.get("message").getAsString();
            String asString6 = qVar.get("version_name").getAsString();
            String asString7 = qVar.get("iptv_url").getAsString();
            String asString8 = qVar.get("anime_domain").getAsString();
            String asString9 = qVar.get("MovieRulzHindi").getAsString();
            String asString10 = qVar.get("ml_host").getAsString();
            String asString11 = qVar.get("autoembed").getAsString();
            String asString12 = qVar.get("anime_ajax_host").getAsString();
            boolean asBoolean3 = qVar.get("futumov_pattern").getAsBoolean();
            boolean asBoolean4 = qVar.get("secure_gomov").getAsBoolean();
            boolean asBoolean5 = qVar.get("load_logos").getAsBoolean();
            int asInt = qVar.get("ads_delay").getAsInt();
            if (asString8 == null || asString8.length() <= 0) {
                z10 = asBoolean5;
            } else {
                z10 = asBoolean5;
                getInstance().f11574v.edit().putString("anime_domain", asString8).apply();
            }
            if (asString10 != null && asString10.length() > 0) {
                getInstance().f11574v.edit().putString("pref_ml_host", asString10).apply();
            }
            l asJsonArray = qVar.get("playlists").getAsJsonArray();
            if (asJsonArray != null) {
                int i11 = 0;
                while (i11 < asJsonArray.size()) {
                    q asJsonObject = asJsonArray.get(i11).getAsJsonObject();
                    h hVar = new h();
                    hVar.f13009m = asJsonObject.get(MediationMetaData.KEY_NAME).getAsString();
                    hVar.f13008b = asJsonObject.get("url").getAsString();
                    hVar.f13010n = "1";
                    this.f11573u.addHistoryIPTV(hVar);
                    i11++;
                    asJsonArray = asJsonArray;
                }
            }
            if (asString12 != null && asString12.length() > 5) {
                SharedPreferences.Editor editorEdit2 = getInstance().f11574v.edit();
                String str2 = Constant.f12450b;
                editorEdit2.putString("anime_host_ajax_pref", asString12).apply();
            }
            SharedPreferences.Editor editorEdit3 = getInstance().f11574v.edit();
            String str3 = Constant.f12450b;
            editorEdit3.putString("MovieRulzHindi_url", asString9).apply();
            getInstance().f11574v.edit().putString("autoembed_url", asString11).apply();
            getInstance().f11574v.edit().putString("iptv_url", asString7).apply();
            getInstance().f11574v.edit().putBoolean("pref_t_ninja_1", asBoolean).apply();
            getInstance().f11574v.edit().putBoolean("pref_t_ninja_2", asBoolean2).apply();
            getInstance().f11574v.edit().putBoolean("pref_secure_gomov", asBoolean4).apply();
            getInstance().f11574v.edit().putBoolean("pref_show_ads", false).apply();
            getInstance().f11574v.edit().putBoolean("show_unity_ads", false).apply();
            this.f11576x = asBoolean3;
            getInstance().f11574v.edit().putInt("pref_show_ads_delay", asInt).apply();
            getInstance().f11574v.edit().putBoolean("pref_load_logos", z10).apply();
            // REMOVED: TraffMonetizer malware control code - bandwidth hijacking SDK
            // try {
            //     boolean asBoolean6 = qVar.get("traff_sd").getAsBoolean();
            //     ua.a aVar = ua.a.f20139a;
            //     if (!asBoolean6 || this.f11574v.getBoolean("pref_traff_1", false)) {
            //         if (!asBoolean6) {
            //             try {
            //                 aVar.stop();
            //             } catch (Exception unused) {
            //             }
            //         }
            //     } else if (this.f11574v.getBoolean("pref_traff_1", false)) {
            //         aVar.init(this, "A95Piq2hlZLJuil9YEQe4Ng2L1mHjSF5oMkt+0vcRLU=");
            //     }
            //     SharedPreferences.Editor editorEdit4 = getInstance().f11574v.edit();
            //     String str4 = Constant.f12450b;
            //     editorEdit4.putBoolean("pref_traff_1", asBoolean6).apply();
            } catch (Exception unused2) {
            }
            try {
                i10 = Integer.parseInt(asString3);
            } catch (NumberFormatException e10) {
                e10.printStackTrace();
                i10 = 0;
            }
            try {
                int i12 = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
                if (i10 > i12) {
                    SharedPreferences.Editor editorEdit5 = getInstance().f11574v.edit();
                    String str5 = Constant.f12450b;
                    editorEdit5.putBoolean("update_available", true).apply();
                    getInstance().f11574v.edit().putString("update_url", asString2).apply();
                    getInstance().f11574v.edit().putString("update_message", asString5).apply();
                    getInstance().f11574v.edit().putString("update_version_name", asString6).apply();
                    getInstance().f11574v.edit().putBoolean("mandatory_update", asString4.equals("mandatory")).apply();
                } else if (i10 == i12) {
                    SharedPreferences.Editor editorEdit6 = getInstance().f11574v.edit();
                    String str6 = Constant.f12450b;
                    editorEdit6.putBoolean("update_available", false).apply();
                }
            } catch (PackageManager.NameNotFoundException e11) {
                e11.printStackTrace();
            }
            boolean asBoolean7 = qVar.get("live_tv_main_active").getAsBoolean();
            SharedPreferences.Editor editorEdit7 = getInstance().f11574v.edit();
            String str7 = Constant.f12450b;
            editorEdit7.putBoolean("live_tv_main_active", asBoolean7).apply();
            String asString13 = qVar.get("drama_host").getAsString();
            if (asString13 == null || asString13.isEmpty()) {
                return;
            }
            getInstance().f11574v.edit().putString("pref_drama_host", asString13).apply();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
    }

    public void refreshTokenRD() {
        RealDebridCommon.f12051p = true;
        new e(this);
        e.Do_Async();
    }

    public void restartApp() {
        try {
            Intent launchIntentForPackage = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            launchIntentForPackage.addFlags(67108864);
            startActivity(launchIntentForPackage);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
