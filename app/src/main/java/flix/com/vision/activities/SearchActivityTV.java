package flix.com.vision.activities;

import ac.c;
import ac.r;
import ac.t;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SearchActivityTV;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.i;
import gd.j;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import ub.n0;
import ub.q1;
import ub.r1;
import ub.s0;
import ub.t0;
import ub.v;

/* loaded from: classes2.dex */
public class SearchActivityTV extends wb.a implements j, i {

    /* renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ int f11775j0 = 0;
    public SpinKitView K;
    public t N;
    public TextView R;
    public TextView S;
    public TextView T;
    public RecyclerView U;
    public RecyclerView V;
    public RecyclerView W;
    public RelativeLayout X;
    public RelativeLayout Y;
    public RelativeLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    public RelativeLayout f11776a0;

    /* renamed from: b0, reason: collision with root package name */
    public ImageView f11777b0;

    /* renamed from: c0, reason: collision with root package name */
    public ImageView f11778c0;

    /* renamed from: d0, reason: collision with root package name */
    public ImageView f11779d0;

    /* renamed from: e0, reason: collision with root package name */
    public LinearLayout f11780e0;

    /* renamed from: f0, reason: collision with root package name */
    public qe.b f11781f0;

    /* renamed from: i0, reason: collision with root package name */
    public ProgressDialog f11784i0;
    public final ArrayList<Movie> L = new ArrayList<>();
    public final ArrayList<Movie> M = new ArrayList<>();
    public final ArrayList<String> O = new ArrayList<>();
    public final ArrayList<String> P = new ArrayList<>();
    public String Q = "";

    /* renamed from: g0, reason: collision with root package name */
    public int f11782g0 = App.getInstance().f11574v.getInt("content_type", 0);

    /* renamed from: h0, reason: collision with root package name */
    public boolean f11783h0 = true;

    public class a extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public class b extends AsyncTask<String, Integer, String> {

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ int f11785e = 0;

        /* renamed from: a, reason: collision with root package name */
        public String f11786a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f11787b = "";

        /* renamed from: c, reason: collision with root package name */
        public String f11788c = "";

        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i10) {
                dialogInterface.dismiss();
                b.this.cancel(true);
            }
        }

        /* renamed from: flix.com.vision.activities.SearchActivityTV$b$b, reason: collision with other inner class name */
        public class DialogInterfaceOnClickListenerC0141b implements DialogInterface.OnClickListener {
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
                File file = new File(this.f11788c);
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
            SearchActivityTV searchActivityTV = SearchActivityTV.this;
            searchActivityTV.f11784i0 = new ProgressDialog(searchActivityTV);
            ProgressDialog progressDialog = searchActivityTV.f11784i0;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(searchActivityTV.getString(R.string.downloading_update_wait));
            sb2.append(StringUtils.SPACE);
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            sb2.append(sharedPreferences.getString("update_version_name", ""));
            progressDialog.setTitle(sb2.toString());
            searchActivityTV.f11784i0.setIndeterminate(false);
            searchActivityTV.f11784i0.setMax(100);
            searchActivityTV.f11784i0.setCancelable(false);
            searchActivityTV.f11784i0.setButton(-1, searchActivityTV.getString(R.string.cancel_label), new a());
            searchActivityTV.f11784i0.setProgressStyle(1);
            searchActivityTV.f11784i0.show();
        }

        @Override // android.os.AsyncTask
        public String doInBackground(String... strArr) throws PackageManager.NameNotFoundException, IOException {
            URL url;
            URLConnection uRLConnectionOpenConnection;
            String str;
            SearchActivityTV searchActivityTV = SearchActivityTV.this;
            String str2 = "";
            try {
                url = new URL(strArr[0]);
                uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.connect();
                this.f11787b = Environment.getExternalStorageDirectory().getPath();
                str = this.f11787b + "/FlixVision.Update" + this.f11786a.replace(StringUtils.SPACE, "").replace(".", "") + ".apk";
                this.f11788c = str;
            } catch (Exception e10) {
                e = e10;
            }
            try {
                int contentLength = uRLConnectionOpenConnection.getContentLength();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
                try {
                    this.f11786a = "." + searchActivityTV.getPackageManager().getPackageInfo(searchActivityTV.getPackageName(), 0).versionName;
                } catch (PackageManager.NameNotFoundException e11) {
                    e11.printStackTrace();
                    this.f11786a = "";
                }
                FileOutputStream fileOutputStream = new FileOutputStream(this.f11788c);
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
                    File file = new File(this.f11788c);
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
            SearchActivityTV searchActivityTV = SearchActivityTV.this;
            super.onPostExecute((b) str);
            try {
                searchActivityTV.f11784i0.dismiss();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            File file = new File(str);
            if (!file.exists()) {
                d dVarCreate = new d.a(searchActivityTV).create();
                dVarCreate.setTitle("OOPPSS!!");
                dVarCreate.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate.setMessage(searchActivityTV.getString(R.string.error_downloading_apk_mess));
                dVarCreate.setButton(-1, "GOT IT", new DialogInterfaceOnClickListenerC0141b());
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
                    Uri uriForFile = FileProvider.getUriForFile(searchActivityTV.getBaseContext(), searchActivityTV.getBaseContext().getApplicationContext().getPackageName() + ".provider", file);
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                    intent.setFlags(1);
                    searchActivityTV.startActivity(intent);
                } else {
                    Uri uriFromFile = Uri.fromFile(file);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
                    intent2.setFlags(268435456);
                    searchActivityTV.startActivity(intent2);
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                d dVarCreate2 = new d.a(searchActivityTV).create();
                dVarCreate2.setTitle("OOPPSS!!");
                dVarCreate2.setIcon(R.drawable.ic_action_error_outline);
                dVarCreate2.setMessage(searchActivityTV.getString(R.string.apk_downloaded_but_could_not) + this.f11788c + "\n\nAnd Install the Apk manually");
                dVarCreate2.setButton(-1, "GOT IT", new t0(4));
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
            SearchActivityTV.this.f11784i0.setProgress(numArr[0].intValue());
        }
    }

    public static String removeLastChar(String str) {
        return (str == null || str.length() == 0) ? "" : str.substring(0, str.length() - 1);
    }

    public final void askToUpdateIfAny(boolean z10, Movie movie) {
        try {
            SharedPreferences sharedPreferences = App.getInstance().f11574v;
            String str = Constant.f12450b;
            if (!sharedPreferences.getBoolean("update_available", false) || App.getInstance().f11574v.getString("update_url", "").length() <= 5) {
                return;
            }
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setButton1(getString(R.string.later_label).toUpperCase(), new s0(this, dVarNewInstance, movie, 1));
            dVarNewInstance.setButton2(getString(R.string.download_update_label), new v(3, this, dVarNewInstance));
            dVarNewInstance.setMessage(getString(R.string.new_update_message) + App.getInstance().f11574v.getString("update_message", "") + getString(R.string.make_sure_you_get_it_mess));
            dVarNewInstance.setTitle(getString(R.string.update_available_label) + StringUtils.SPACE + App.getInstance().f11574v.getString("update_version_name", ""));
            dVarNewInstance.show(getFragmentManager(), "");
        } catch (Exception unused) {
        }
    }

    public final void d() {
        bc.a.gettabbedList(this, 1, this.f11782g0 == 0 ? "movie" : "tv", 0).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new q1(this, 2), new n0(14));
    }

    public final void e() {
        this.S.setText(this.Q);
        int i10 = 0;
        if (this.Q.trim().length() > 0) {
            int i11 = 1;
            if (this.Q.trim().length() > 1) {
                this.K.setVisibility(0);
                qe.b bVar = this.f11781f0;
                if (bVar != null) {
                    bVar.dispose();
                }
                this.f11781f0 = bc.a.searchDataMulti(this, this.Q, 1, false).subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new q1(this, i10), new q1(this, i11));
                return;
            }
            return;
        }
        if (this.Q.isEmpty()) {
            this.S.setText("Search by title or people");
            this.T.setVisibility(0);
            ArrayList<Movie> arrayList = this.M;
            arrayList.clear();
            arrayList.addAll(this.L);
            this.N.notifyDataSetChanged();
            this.V.scrollToPosition(0);
        }
    }

    public void extractDominantColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 14));
        valueAnimatorOfObject.addListener(new a());
        valueAnimatorOfObject.start();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        if (i10 == 1210 && i11 == -1 && (str = intent.getStringArrayListExtra("android.speech.extra.RESULTS").get(0)) != null && !str.isEmpty()) {
            this.Q = str;
            e();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_tv);
        this.f11779d0 = (ImageView) findViewById(R.id.mic_icon);
        this.f11778c0 = (ImageView) findViewById(R.id.back_icon);
        this.f11777b0 = (ImageView) findViewById(R.id.space_icon);
        this.R = (TextView) findViewById(R.id.clear_text_label);
        this.K = (SpinKitView) findViewById(R.id.loader);
        this.f11780e0 = (LinearLayout) findViewById(R.id.main_relative_view);
        this.f11776a0 = (RelativeLayout) findViewById(R.id.clear_button);
        this.T = (TextView) findViewById(R.id.discover_text_view);
        this.Y = (RelativeLayout) findViewById(R.id.button_blank_space);
        this.Z = (RelativeLayout) findViewById(R.id.button_back_space);
        this.S = (TextView) findViewById(R.id.query_text_view);
        this.X = (RelativeLayout) findViewById(R.id.button_search_mic);
        this.U = (RecyclerView) findViewById(R.id.recycler_view_letters);
        this.V = (RecyclerView) findViewById(R.id.recycler_view_results);
        this.W = (RecyclerView) findViewById(R.id.recycler_view_letters_numeric);
        extractDominantColor();
        final int i10 = 0;
        this.Y.setOnClickListener(new r1(this, 0));
        final int i11 = 1;
        this.Z.setOnClickListener(new r1(this, 1));
        final int i12 = 2;
        this.f11776a0.setOnClickListener(new r1(this, 2));
        final int i13 = 3;
        this.X.setOnClickListener(new r1(this, 3));
        this.f11776a0.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.s1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchActivityTV f20272m;

            {
                this.f20272m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i14 = i10;
                SearchActivityTV searchActivityTV = this.f20272m;
                switch (i14) {
                    case 0:
                        if (!z10) {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.white));
                            break;
                        } else {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    case 2:
                        if (!z10) {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    default:
                        if (!z10) {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                }
            }
        });
        this.Y.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.s1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchActivityTV f20272m;

            {
                this.f20272m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i14 = i11;
                SearchActivityTV searchActivityTV = this.f20272m;
                switch (i14) {
                    case 0:
                        if (!z10) {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.white));
                            break;
                        } else {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    case 2:
                        if (!z10) {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    default:
                        if (!z10) {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                }
            }
        });
        this.Z.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.s1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchActivityTV f20272m;

            {
                this.f20272m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i14 = i12;
                SearchActivityTV searchActivityTV = this.f20272m;
                switch (i14) {
                    case 0:
                        if (!z10) {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.white));
                            break;
                        } else {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    case 2:
                        if (!z10) {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    default:
                        if (!z10) {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                }
            }
        });
        this.X.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: ub.s1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ SearchActivityTV f20272m;

            {
                this.f20272m = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                int i14 = i13;
                SearchActivityTV searchActivityTV = this.f20272m;
                switch (i14) {
                    case 0:
                        if (!z10) {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.white));
                            break;
                        } else {
                            searchActivityTV.R.setTextColor(searchActivityTV.getResources().getColor(R.color.black));
                            break;
                        }
                    case 1:
                        if (!z10) {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11777b0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    case 2:
                        if (!z10) {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11778c0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                    default:
                        if (!z10) {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.white), PorterDuff.Mode.SRC_IN));
                            break;
                        } else {
                            searchActivityTV.f11779d0.setColorFilter(new PorterDuffColorFilter(m0.a.getColor(searchActivityTV, R.color.black), PorterDuff.Mode.SRC_IN));
                            break;
                        }
                }
            }
        });
        ArrayList<String> arrayList = this.O;
        o1.a.p(arrayList, "a", "b", "c", "d");
        o1.a.p(arrayList, "e", "f", "g", "h");
        o1.a.p(arrayList, "i", "j", "k", "l");
        o1.a.p(arrayList, "m", "n", "o", "p");
        o1.a.p(arrayList, "q", "r", "s", "t");
        o1.a.p(arrayList, "u", "v", "w", "x");
        arrayList.add("y");
        arrayList.add("z");
        ArrayList<String> arrayList2 = this.P;
        o1.a.p(arrayList2, "1", TraktV2.API_VERSION, "3", "4");
        o1.a.p(arrayList2, "5", "6", "7", "8");
        arrayList2.add("9");
        arrayList2.add("0");
        this.U.setAdapter(new r(this, this, arrayList));
        this.U.setLayoutManager(new GridLayoutManager(this, 7));
        this.W.setAdapter(new r(this, this, arrayList2));
        this.W.setLayoutManager(new GridLayoutManager(this, 7));
        t tVar = new t(this, this.M, this, 1111, this, null);
        this.N = tVar;
        this.V.setAdapter(tVar);
        RecyclerView recyclerView = this.V;
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        float f10 = displayMetricsB.widthPixels / getResources().getDisplayMetrics().density;
        ArrayList<String> arrayList3 = App.B;
        recyclerView.setLayoutManager(new CenterGridLayoutManager(this, Math.round((f10 / 140) * 0.7f)));
        d();
        new Handler().postDelayed(new androidx.activity.d(this, 27), 200L);
    }

    @Override // gd.i
    public void onLetterClicked(String str) {
        this.Q = c.o(new StringBuilder(), this.Q, str);
        e();
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

    public void openMovieintent(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
