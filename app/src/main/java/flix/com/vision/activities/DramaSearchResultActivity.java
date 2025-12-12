package flix.com.vision.activities;

import ac.c;
import ac.m;
import ac.r;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uwetrottmann.trakt5.TraktV2;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaSearchResultActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Drama;
import flix.com.vision.tv.Constant;
import gd.e;
import gd.i;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import ub.a0;

/* loaded from: classes2.dex */
public class DramaSearchResultActivity extends wb.a implements i, e {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11655a0 = 0;
    public RecyclerView K;
    public RecyclerView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public RelativeLayout P;
    public ProgressBar S;
    public ArrayList<Drama> T;
    public RecyclerView U;
    public TextView V;
    public TextView W;
    public LinearLayout X;
    public final ArrayList<String> Q = new ArrayList<>();
    public final ArrayList<String> R = new ArrayList<>();
    public String Y = "";
    public String Z = "https://kissasiantv.to";

    public class a extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public static String removeLastChar(String str) {
        return (str == null || str.length() == 0) ? "" : str.substring(0, str.length() - 1);
    }

    public final void d() {
        this.V.setText(this.Y);
        if (this.Y.isEmpty()) {
            this.V.setText("Search Drama Show or Movie by title");
        }
    }

    public void extractDominantColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 9));
        valueAnimatorOfObject.addListener(new a());
        valueAnimatorOfObject.start();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_tv_drama);
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.Z = sharedPreferences.getString("pref_drama_host", "https://kissasiantv.to");
        ArrayList<Drama> arrayList = new ArrayList<>();
        this.T = arrayList;
        new m(arrayList, this, this);
        this.U = (RecyclerView) findViewById(R.id.recyclerview);
        this.W = (TextView) findViewById(R.id.discover_text_view);
        this.P = (RelativeLayout) findViewById(R.id.search_button);
        this.V = (TextView) findViewById(R.id.query_text_view);
        this.X = (LinearLayout) findViewById(R.id.main_relative_view);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.L = (RecyclerView) findViewById(R.id.recycler_view_letters_numeric);
        this.K = (RecyclerView) findViewById(R.id.recycler_view_letters);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.X = (LinearLayout) findViewById(R.id.main_relative_view);
        this.O = (RelativeLayout) findViewById(R.id.clear_button);
        this.M = (RelativeLayout) findViewById(R.id.button_blank_space);
        this.N = (RelativeLayout) findViewById(R.id.button_back_space);
        this.V = (TextView) findViewById(R.id.query_text_view);
        this.K = (RecyclerView) findViewById(R.id.recycler_view_letters);
        this.L = (RecyclerView) findViewById(R.id.recycler_view_letters_numeric);
        extractDominantColor();
        ArrayList<String> arrayList2 = this.Q;
        this.K.setAdapter(new r(this, this, arrayList2));
        this.K.setLayoutManager(new GridLayoutManager(this, 7));
        ArrayList<String> arrayList3 = this.R;
        this.L.setAdapter(new r(this, this, arrayList3));
        this.L.setLayoutManager(new GridLayoutManager(this, 7));
        this.U.setAdapter(new m(this.T, this, this));
        RecyclerView recyclerView = this.U;
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        recyclerView.setLayoutManager(new CenterGridLayoutManager(this, Math.round(((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140) * 0.7f)));
        arrayList2.add("a");
        arrayList2.add("b");
        o1.a.p(arrayList2, "c", "d", "e", "f");
        o1.a.p(arrayList2, "g", "h", "i", "j");
        o1.a.p(arrayList2, "k", "l", "m", "n");
        o1.a.p(arrayList2, "o", "p", "q", "r");
        o1.a.p(arrayList2, "s", "t", "u", "v");
        o1.a.p(arrayList2, "w", "x", "y", "z");
        o1.a.p(arrayList3, "1", TraktV2.API_VERSION, "3", "4");
        o1.a.p(arrayList3, "5", "6", "7", "8");
        arrayList3.add("9");
        arrayList3.add("0");
        final int i10 = 0;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ub.z

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaSearchResultActivity f20332m;

            {
                this.f20332m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                DramaSearchResultActivity dramaSearchResultActivity = this.f20332m;
                switch (i11) {
                    case 0:
                        String str2 = dramaSearchResultActivity.Y;
                        if (str2 != null && !str2.isEmpty() && str2.length() >= 3) {
                            dramaSearchResultActivity.S.setVisibility(0);
                            new a0(dramaSearchResultActivity, false, str2.replace("'", "")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            break;
                        } else if (str2 != null && str2.length() < 3) {
                            Toast.makeText(dramaSearchResultActivity, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i12 = DramaSearchResultActivity.f11655a0;
                        dramaSearchResultActivity.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        dramaSearchResultActivity.Y = DramaSearchResultActivity.removeLastChar(dramaSearchResultActivity.Y);
                        dramaSearchResultActivity.d();
                        break;
                    default:
                        if (!dramaSearchResultActivity.Y.isEmpty()) {
                            dramaSearchResultActivity.Y = "";
                            dramaSearchResultActivity.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.z

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaSearchResultActivity f20332m;

            {
                this.f20332m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                DramaSearchResultActivity dramaSearchResultActivity = this.f20332m;
                switch (i112) {
                    case 0:
                        String str2 = dramaSearchResultActivity.Y;
                        if (str2 != null && !str2.isEmpty() && str2.length() >= 3) {
                            dramaSearchResultActivity.S.setVisibility(0);
                            new a0(dramaSearchResultActivity, false, str2.replace("'", "")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            break;
                        } else if (str2 != null && str2.length() < 3) {
                            Toast.makeText(dramaSearchResultActivity, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i12 = DramaSearchResultActivity.f11655a0;
                        dramaSearchResultActivity.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        dramaSearchResultActivity.Y = DramaSearchResultActivity.removeLastChar(dramaSearchResultActivity.Y);
                        dramaSearchResultActivity.d();
                        break;
                    default:
                        if (!dramaSearchResultActivity.Y.isEmpty()) {
                            dramaSearchResultActivity.Y = "";
                            dramaSearchResultActivity.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.z

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaSearchResultActivity f20332m;

            {
                this.f20332m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                DramaSearchResultActivity dramaSearchResultActivity = this.f20332m;
                switch (i112) {
                    case 0:
                        String str2 = dramaSearchResultActivity.Y;
                        if (str2 != null && !str2.isEmpty() && str2.length() >= 3) {
                            dramaSearchResultActivity.S.setVisibility(0);
                            new a0(dramaSearchResultActivity, false, str2.replace("'", "")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            break;
                        } else if (str2 != null && str2.length() < 3) {
                            Toast.makeText(dramaSearchResultActivity, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i122 = DramaSearchResultActivity.f11655a0;
                        dramaSearchResultActivity.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        dramaSearchResultActivity.Y = DramaSearchResultActivity.removeLastChar(dramaSearchResultActivity.Y);
                        dramaSearchResultActivity.d();
                        break;
                    default:
                        if (!dramaSearchResultActivity.Y.isEmpty()) {
                            dramaSearchResultActivity.Y = "";
                            dramaSearchResultActivity.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i13 = 3;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.z

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaSearchResultActivity f20332m;

            {
                this.f20332m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                DramaSearchResultActivity dramaSearchResultActivity = this.f20332m;
                switch (i112) {
                    case 0:
                        String str2 = dramaSearchResultActivity.Y;
                        if (str2 != null && !str2.isEmpty() && str2.length() >= 3) {
                            dramaSearchResultActivity.S.setVisibility(0);
                            new a0(dramaSearchResultActivity, false, str2.replace("'", "")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                            break;
                        } else if (str2 != null && str2.length() < 3) {
                            Toast.makeText(dramaSearchResultActivity, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i122 = DramaSearchResultActivity.f11655a0;
                        dramaSearchResultActivity.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        dramaSearchResultActivity.Y = DramaSearchResultActivity.removeLastChar(dramaSearchResultActivity.Y);
                        dramaSearchResultActivity.d();
                        break;
                    default:
                        if (!dramaSearchResultActivity.Y.isEmpty()) {
                            dramaSearchResultActivity.Y = "";
                            dramaSearchResultActivity.d();
                            break;
                        }
                        break;
                }
            }
        });
        new a0(this, true, c.o(new StringBuilder(), this.Z, "/drama-list/new-hot.html")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // gd.i
    public void onLetterClicked(String str) {
        this.Y = c.o(new StringBuilder(), this.Y, str);
        d();
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onPause() {
        super.onPause();
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
