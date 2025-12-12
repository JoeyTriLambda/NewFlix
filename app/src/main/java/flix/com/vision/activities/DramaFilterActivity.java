package flix.com.vision.activities;

import ac.m;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.google.android.material.snackbar.Snackbar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import com.uwetrottmann.trakt5.TraktV2;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaFilterActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Drama;
import flix.com.vision.tv.Constant;
import gd.e;
import java.util.ArrayList;
import java.util.Iterator;
import kc.d;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import ub.n;
import ub.o;

/* loaded from: classes2.dex */
public class DramaFilterActivity extends wb.a implements e {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11616a0 = 0;
    public String[] K;
    public String[] L;
    public TextView M;
    public TextView N;
    public RelativeLayout P;
    public ArrayList<Drama> Q;
    public m R;
    public SuperRecyclerView S;
    public int O = 1;
    public boolean T = false;
    public String U = "https://kissasiantv.to";
    public final ArrayList<Drama> V = new ArrayList<>();
    public d W = null;
    public int X = 0;
    public int Y = 0;
    public String Z = "/drama-list/most-popular.html?page=";

    public class a extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public class b extends AsyncTask<Void, Void, String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11617a;

        public b(String str) {
            this.f11617a = str;
        }

        @Override // android.os.AsyncTask
        public String doInBackground(Void... voidArr) {
            DramaFilterActivity dramaFilterActivity = DramaFilterActivity.this;
            try {
                String str = this.f11617a;
                Iterator<Element> it = ch.a.parse(App.get(str, str).body().string()).select("div.list-drama div.item").iterator();
                while (it.hasNext()) {
                    Element next = it.next();
                    try {
                        Drama drama = new Drama();
                        Element elementFirst = next.getElementsByTag("IMG").first();
                        if (elementFirst != null) {
                            String strAttr = elementFirst.attr("alt");
                            String str2 = "https://" + elementFirst.attr("src");
                            drama.f12389n = strAttr;
                            drama.f12392q = str2;
                        }
                        drama.f12391p = dramaFilterActivity.U + next.getElementsByTag("A").first().attr("href");
                        try {
                            if (drama.f12389n.toLowerCase().endsWith(")")) {
                                String strSubstring = drama.f12389n.substring(r3.length() - 6);
                                drama.f12389n = drama.f12389n.replace(strSubstring, "").trim();
                                drama.f12387b = strSubstring.replace("(", "").replace(")", "");
                            }
                        } catch (Exception unused) {
                        }
                        if (!dramaFilterActivity.V.contains(drama)) {
                            dramaFilterActivity.V.add(drama);
                        }
                    } catch (Exception unused2) {
                    }
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
            DramaFilterActivity dramaFilterActivity = DramaFilterActivity.this;
            d dVar = dramaFilterActivity.W;
            if (dVar != null) {
                try {
                    dVar.dismiss();
                } catch (Exception unused) {
                }
            }
            if (dramaFilterActivity.V.isEmpty()) {
                Snackbar.make(dramaFilterActivity.findViewById(R.id.activity_player), dramaFilterActivity.getString(R.string.no_more_content), 0).show();
                return;
            }
            dramaFilterActivity.Q.addAll(dramaFilterActivity.V);
            dramaFilterActivity.S.getAdapter().notifyDataSetChanged();
            dramaFilterActivity.S.invalidate();
        }
    }

    public void ExtractDominentColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 7));
        valueAnimatorOfObject.addListener(new a());
        valueAnimatorOfObject.start();
    }

    @SuppressLint({"StaticFieldLeak"})
    public final void d(int i10) {
        this.V.clear();
        new b((this.U + this.Z + i10).toLowerCase()).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void e(int i10) {
        String string = App.getInstance().f11574v.getString("server_anime", "1");
        String string2 = App.getInstance().f11574v.getString("genre_anime", "");
        String string3 = App.getInstance().f11574v.getString("year_anime", "");
        String string4 = App.getInstance().f11574v.getString("type_anime", "");
        String string5 = App.getInstance().f11574v.getString("lang_anime", "");
        string2.equals("All");
        string4.equals("All");
        string3.equals("All");
        string5.equals("All");
        string.equals(TraktV2.API_VERSION);
        d(i10);
    }

    public final void f() {
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, false);
        this.W = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.W.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"MissingSuperCall"})
    public void onBackPressed() {
        if (this.T) {
            this.T = false;
            finish();
            return;
        }
        Toast.makeText(getBaseContext(), "Press again to Exit", 0).show();
        if (this.Q.size() < 200) {
            this.S.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.S.getRecyclerView().scrollToPosition(0);
        }
        this.N.requestFocus();
        this.T = true;
        new Handler().postDelayed(new o(this, 1), 1600L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_drama_list);
        f();
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.U = sharedPreferences.getString("pref_drama_host", "https://kissasiantv.to");
        this.P = (RelativeLayout) findViewById(R.id.activity_player);
        this.N = (TextView) findViewById(R.id.lists_button);
        this.M = (TextView) findViewById(R.id.genres_button);
        this.S = (SuperRecyclerView) findViewById(R.id.recyclerview);
        final int i10 = 0;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.p

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaFilterActivity f20248m;

            {
                this.f20248m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                final DramaFilterActivity dramaFilterActivity = this.f20248m;
                switch (i11) {
                    case 0:
                        int i12 = DramaFilterActivity.f11616a0;
                        dramaFilterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(dramaFilterActivity, R.style.AlertDialogCustom));
                        final int i13 = 1;
                        aVar.setSingleChoiceItems(dramaFilterActivity.K, dramaFilterActivity.X, new DialogInterface.OnClickListener() { // from class: ub.q
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i14) {
                                String str2;
                                int i15 = i13;
                                DramaFilterActivity dramaFilterActivity2 = dramaFilterActivity;
                                switch (i15) {
                                    case 0:
                                        int i16 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.Y != i14) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.X = 0;
                                            dramaFilterActivity2.M.setText("All");
                                            dramaFilterActivity2.N.setText(dramaFilterActivity2.L[i14]);
                                            switch (i14) {
                                                case 1:
                                                    str2 = "most-popular.html";
                                                    break;
                                                case 2:
                                                    str2 = "latest-update.html";
                                                    break;
                                                case 3:
                                                    str2 = "new-hot.html";
                                                    break;
                                                case 4:
                                                    str2 = "ongoing.html";
                                                    break;
                                                case 5:
                                                    str2 = "completed.html";
                                                    break;
                                                case 6:
                                                    str2 = "upcoming.html";
                                                    break;
                                                default:
                                                    str2 = "";
                                                    break;
                                            }
                                            String strConcat = "/drama-list/".concat(str2);
                                            dramaFilterActivity2.Y = i14;
                                            try {
                                                dramaFilterActivity2.Z = "/" + strConcat + "?page=";
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i17 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.X != i14) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.Y = 0;
                                            dramaFilterActivity2.M.setText(dramaFilterActivity2.K[i14]);
                                            dramaFilterActivity2.N.setText("Most Popular");
                                            dramaFilterActivity2.X = i14;
                                            try {
                                                dramaFilterActivity2.Z = "/genre/" + dramaFilterActivity2.K[i14].replace(StringUtils.SPACE, "-") + "/?page=".toLowerCase();
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    default:
                        int i14 = DramaFilterActivity.f11616a0;
                        dramaFilterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(dramaFilterActivity, R.style.AlertDialogCustom));
                        final int i15 = 0;
                        aVar2.setSingleChoiceItems(dramaFilterActivity.L, dramaFilterActivity.Y, new DialogInterface.OnClickListener() { // from class: ub.q
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str2;
                                int i152 = i15;
                                DramaFilterActivity dramaFilterActivity2 = dramaFilterActivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.Y != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.X = 0;
                                            dramaFilterActivity2.M.setText("All");
                                            dramaFilterActivity2.N.setText(dramaFilterActivity2.L[i142]);
                                            switch (i142) {
                                                case 1:
                                                    str2 = "most-popular.html";
                                                    break;
                                                case 2:
                                                    str2 = "latest-update.html";
                                                    break;
                                                case 3:
                                                    str2 = "new-hot.html";
                                                    break;
                                                case 4:
                                                    str2 = "ongoing.html";
                                                    break;
                                                case 5:
                                                    str2 = "completed.html";
                                                    break;
                                                case 6:
                                                    str2 = "upcoming.html";
                                                    break;
                                                default:
                                                    str2 = "";
                                                    break;
                                            }
                                            String strConcat = "/drama-list/".concat(str2);
                                            dramaFilterActivity2.Y = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/" + strConcat + "?page=";
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i17 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.X != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.Y = 0;
                                            dramaFilterActivity2.M.setText(dramaFilterActivity2.K[i142]);
                                            dramaFilterActivity2.N.setText("Most Popular");
                                            dramaFilterActivity2.X = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/genre/" + dramaFilterActivity2.K[i142].replace(StringUtils.SPACE, "-") + "/?page=".toLowerCase();
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.p

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaFilterActivity f20248m;

            {
                this.f20248m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                final DramaFilterActivity dramaFilterActivity = this.f20248m;
                switch (i112) {
                    case 0:
                        int i12 = DramaFilterActivity.f11616a0;
                        dramaFilterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(dramaFilterActivity, R.style.AlertDialogCustom));
                        final int i13 = 1;
                        aVar.setSingleChoiceItems(dramaFilterActivity.K, dramaFilterActivity.X, new DialogInterface.OnClickListener() { // from class: ub.q
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str2;
                                int i152 = i13;
                                DramaFilterActivity dramaFilterActivity2 = dramaFilterActivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.Y != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.X = 0;
                                            dramaFilterActivity2.M.setText("All");
                                            dramaFilterActivity2.N.setText(dramaFilterActivity2.L[i142]);
                                            switch (i142) {
                                                case 1:
                                                    str2 = "most-popular.html";
                                                    break;
                                                case 2:
                                                    str2 = "latest-update.html";
                                                    break;
                                                case 3:
                                                    str2 = "new-hot.html";
                                                    break;
                                                case 4:
                                                    str2 = "ongoing.html";
                                                    break;
                                                case 5:
                                                    str2 = "completed.html";
                                                    break;
                                                case 6:
                                                    str2 = "upcoming.html";
                                                    break;
                                                default:
                                                    str2 = "";
                                                    break;
                                            }
                                            String strConcat = "/drama-list/".concat(str2);
                                            dramaFilterActivity2.Y = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/" + strConcat + "?page=";
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i17 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.X != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.Y = 0;
                                            dramaFilterActivity2.M.setText(dramaFilterActivity2.K[i142]);
                                            dramaFilterActivity2.N.setText("Most Popular");
                                            dramaFilterActivity2.X = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/genre/" + dramaFilterActivity2.K[i142].replace(StringUtils.SPACE, "-") + "/?page=".toLowerCase();
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    default:
                        int i14 = DramaFilterActivity.f11616a0;
                        dramaFilterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(dramaFilterActivity, R.style.AlertDialogCustom));
                        final int i15 = 0;
                        aVar2.setSingleChoiceItems(dramaFilterActivity.L, dramaFilterActivity.Y, new DialogInterface.OnClickListener() { // from class: ub.q
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str2;
                                int i152 = i15;
                                DramaFilterActivity dramaFilterActivity2 = dramaFilterActivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.Y != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.X = 0;
                                            dramaFilterActivity2.M.setText("All");
                                            dramaFilterActivity2.N.setText(dramaFilterActivity2.L[i142]);
                                            switch (i142) {
                                                case 1:
                                                    str2 = "most-popular.html";
                                                    break;
                                                case 2:
                                                    str2 = "latest-update.html";
                                                    break;
                                                case 3:
                                                    str2 = "new-hot.html";
                                                    break;
                                                case 4:
                                                    str2 = "ongoing.html";
                                                    break;
                                                case 5:
                                                    str2 = "completed.html";
                                                    break;
                                                case 6:
                                                    str2 = "upcoming.html";
                                                    break;
                                                default:
                                                    str2 = "";
                                                    break;
                                            }
                                            String strConcat = "/drama-list/".concat(str2);
                                            dramaFilterActivity2.Y = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/" + strConcat + "?page=";
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i17 = DramaFilterActivity.f11616a0;
                                        dramaFilterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (dramaFilterActivity2.X != i142) {
                                            dramaFilterActivity2.f();
                                            dramaFilterActivity2.Y = 0;
                                            dramaFilterActivity2.M.setText(dramaFilterActivity2.K[i142]);
                                            dramaFilterActivity2.N.setText("Most Popular");
                                            dramaFilterActivity2.X = i142;
                                            try {
                                                dramaFilterActivity2.Z = "/genre/" + dramaFilterActivity2.K[i142].replace(StringUtils.SPACE, "-") + "/?page=".toLowerCase();
                                                dramaFilterActivity2.Q.clear();
                                                dramaFilterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                }
            }
        });
        this.S.setRefreshListener(new n(this));
        ArrayList<Drama> arrayList = new ArrayList<>();
        this.Q = arrayList;
        this.R = new m(arrayList, this, this);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.S.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.S.addItemDecoration(new c(12));
        this.S.setAdapter(this.R);
        this.S.setupMoreListener(new n(this), 10);
        this.S.requestFocus();
        e(this.O);
        new Handler().postDelayed(new o(this, 0), 800L);
        this.K = getResources().getString(R.string.drama_genres).split(",");
        this.L = new String[]{"Most Popular", "Latest Update", "New & Hot", "Ongoing", "Completed", "Upcoming"};
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
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
