package flix.com.vision.activities;

import ac.c;
import ac.h;
import ac.r;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
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
import flix.com.vision.activities.AnimeSearchResultActivty;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Anime;
import gd.d;
import gd.i;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class AnimeSearchResultActivty extends wb.a implements i, d {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11596a0 = 0;
    public RecyclerView K;
    public RecyclerView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public RelativeLayout P;
    public ProgressBar S;
    public ArrayList<Anime> T;
    public RecyclerView U;
    public TextView V;
    public TextView W;
    public LinearLayout Y;
    public final ArrayList<String> Q = new ArrayList<>();
    public final ArrayList<String> R = new ArrayList<>();
    public final int X = 100;
    public String Z = "";

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
        this.V.setText(this.Z);
        if (this.Z.isEmpty()) {
            this.V.setText("Search by title or people");
        }
    }

    public void extractDominantColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 4));
        valueAnimatorOfObject.addListener(new a());
        valueAnimatorOfObject.start();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_tv_anime);
        this.T = new ArrayList<>();
        new h(getBaseContext(), this.T, this, this.X, null);
        this.U = (RecyclerView) findViewById(R.id.recyclerview);
        this.W = (TextView) findViewById(R.id.discover_text_view);
        this.P = (RelativeLayout) findViewById(R.id.search_button);
        this.V = (TextView) findViewById(R.id.query_text_view);
        this.Y = (LinearLayout) findViewById(R.id.main_relative_view);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.L = (RecyclerView) findViewById(R.id.recycler_view_letters_numeric);
        this.K = (RecyclerView) findViewById(R.id.recycler_view_letters);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.S = (ProgressBar) findViewById(R.id.loader);
        this.Y = (LinearLayout) findViewById(R.id.main_relative_view);
        this.O = (RelativeLayout) findViewById(R.id.clear_button);
        this.M = (RelativeLayout) findViewById(R.id.button_blank_space);
        this.N = (RelativeLayout) findViewById(R.id.button_back_space);
        this.V = (TextView) findViewById(R.id.query_text_view);
        this.K = (RecyclerView) findViewById(R.id.recycler_view_letters);
        this.L = (RecyclerView) findViewById(R.id.recycler_view_letters_numeric);
        extractDominantColor();
        ArrayList<String> arrayList = this.Q;
        this.K.setAdapter(new r(this, this, arrayList));
        this.K.setLayoutManager(new GridLayoutManager(this, 7));
        ArrayList<String> arrayList2 = this.R;
        this.L.setAdapter(new r(this, this, arrayList2));
        this.L.setLayoutManager(new GridLayoutManager(this, 7));
        this.U.setAdapter(new h(this, this.T, this, 1111, this));
        RecyclerView recyclerView = this.U;
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        float f10 = displayMetricsB.widthPixels / getResources().getDisplayMetrics().density;
        ArrayList<String> arrayList3 = App.B;
        recyclerView.setLayoutManager(new CenterGridLayoutManager(this, Math.round((f10 / 140) * 0.7f)));
        arrayList.add("a");
        arrayList.add("b");
        o1.a.p(arrayList, "c", "d", "e", "f");
        o1.a.p(arrayList, "g", "h", "i", "j");
        o1.a.p(arrayList, "k", "l", "m", "n");
        o1.a.p(arrayList, "o", "p", "q", "r");
        o1.a.p(arrayList, "s", "t", "u", "v");
        o1.a.p(arrayList, "w", "x", "y", "z");
        o1.a.p(arrayList2, "1", TraktV2.API_VERSION, "3", "4");
        o1.a.p(arrayList2, "5", "6", "7", "8");
        arrayList2.add("9");
        arrayList2.add("0");
        final int i10 = 0;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeSearchResultActivty f20169m;

            {
                this.f20169m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                AnimeSearchResultActivty animeSearchResultActivty = this.f20169m;
                switch (i11) {
                    case 0:
                        String str = animeSearchResultActivty.Z;
                        if (str != null && !str.isEmpty() && str.length() >= 3) {
                            animeSearchResultActivty.S.setVisibility(0);
                            animeSearchResultActivty.T.addAll(App.getInstance().f11573u.searchGoAnime(str.replace("'", "")));
                            animeSearchResultActivty.S.setVisibility(8);
                            if (animeSearchResultActivty.T.size() < 1) {
                                animeSearchResultActivty.W.setText("No anime found");
                                animeSearchResultActivty.W.setVisibility(0);
                            } else {
                                animeSearchResultActivty.W.setVisibility(8);
                            }
                            Collections.reverse(animeSearchResultActivty.T);
                            animeSearchResultActivty.U.getAdapter().notifyDataSetChanged();
                            animeSearchResultActivty.U.invalidate();
                            animeSearchResultActivty.S.setVisibility(8);
                            break;
                        } else if (str != null && str.length() < 3) {
                            Toast.makeText(animeSearchResultActivty, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i12 = AnimeSearchResultActivty.f11596a0;
                        animeSearchResultActivty.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        animeSearchResultActivty.Z = AnimeSearchResultActivty.removeLastChar(animeSearchResultActivty.Z);
                        animeSearchResultActivty.d();
                        break;
                    default:
                        if (!animeSearchResultActivty.Z.isEmpty()) {
                            animeSearchResultActivty.Z = "";
                            animeSearchResultActivty.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 1;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeSearchResultActivty f20169m;

            {
                this.f20169m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                AnimeSearchResultActivty animeSearchResultActivty = this.f20169m;
                switch (i112) {
                    case 0:
                        String str = animeSearchResultActivty.Z;
                        if (str != null && !str.isEmpty() && str.length() >= 3) {
                            animeSearchResultActivty.S.setVisibility(0);
                            animeSearchResultActivty.T.addAll(App.getInstance().f11573u.searchGoAnime(str.replace("'", "")));
                            animeSearchResultActivty.S.setVisibility(8);
                            if (animeSearchResultActivty.T.size() < 1) {
                                animeSearchResultActivty.W.setText("No anime found");
                                animeSearchResultActivty.W.setVisibility(0);
                            } else {
                                animeSearchResultActivty.W.setVisibility(8);
                            }
                            Collections.reverse(animeSearchResultActivty.T);
                            animeSearchResultActivty.U.getAdapter().notifyDataSetChanged();
                            animeSearchResultActivty.U.invalidate();
                            animeSearchResultActivty.S.setVisibility(8);
                            break;
                        } else if (str != null && str.length() < 3) {
                            Toast.makeText(animeSearchResultActivty, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i12 = AnimeSearchResultActivty.f11596a0;
                        animeSearchResultActivty.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        animeSearchResultActivty.Z = AnimeSearchResultActivty.removeLastChar(animeSearchResultActivty.Z);
                        animeSearchResultActivty.d();
                        break;
                    default:
                        if (!animeSearchResultActivty.Z.isEmpty()) {
                            animeSearchResultActivty.Z = "";
                            animeSearchResultActivty.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 2;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeSearchResultActivty f20169m;

            {
                this.f20169m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                AnimeSearchResultActivty animeSearchResultActivty = this.f20169m;
                switch (i112) {
                    case 0:
                        String str = animeSearchResultActivty.Z;
                        if (str != null && !str.isEmpty() && str.length() >= 3) {
                            animeSearchResultActivty.S.setVisibility(0);
                            animeSearchResultActivty.T.addAll(App.getInstance().f11573u.searchGoAnime(str.replace("'", "")));
                            animeSearchResultActivty.S.setVisibility(8);
                            if (animeSearchResultActivty.T.size() < 1) {
                                animeSearchResultActivty.W.setText("No anime found");
                                animeSearchResultActivty.W.setVisibility(0);
                            } else {
                                animeSearchResultActivty.W.setVisibility(8);
                            }
                            Collections.reverse(animeSearchResultActivty.T);
                            animeSearchResultActivty.U.getAdapter().notifyDataSetChanged();
                            animeSearchResultActivty.U.invalidate();
                            animeSearchResultActivty.S.setVisibility(8);
                            break;
                        } else if (str != null && str.length() < 3) {
                            Toast.makeText(animeSearchResultActivty, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i122 = AnimeSearchResultActivty.f11596a0;
                        animeSearchResultActivty.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        animeSearchResultActivty.Z = AnimeSearchResultActivty.removeLastChar(animeSearchResultActivty.Z);
                        animeSearchResultActivty.d();
                        break;
                    default:
                        if (!animeSearchResultActivty.Z.isEmpty()) {
                            animeSearchResultActivty.Z = "";
                            animeSearchResultActivty.d();
                            break;
                        }
                        break;
                }
            }
        });
        final int i13 = 3;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AnimeSearchResultActivty f20169m;

            {
                this.f20169m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                AnimeSearchResultActivty animeSearchResultActivty = this.f20169m;
                switch (i112) {
                    case 0:
                        String str = animeSearchResultActivty.Z;
                        if (str != null && !str.isEmpty() && str.length() >= 3) {
                            animeSearchResultActivty.S.setVisibility(0);
                            animeSearchResultActivty.T.addAll(App.getInstance().f11573u.searchGoAnime(str.replace("'", "")));
                            animeSearchResultActivty.S.setVisibility(8);
                            if (animeSearchResultActivty.T.size() < 1) {
                                animeSearchResultActivty.W.setText("No anime found");
                                animeSearchResultActivty.W.setVisibility(0);
                            } else {
                                animeSearchResultActivty.W.setVisibility(8);
                            }
                            Collections.reverse(animeSearchResultActivty.T);
                            animeSearchResultActivty.U.getAdapter().notifyDataSetChanged();
                            animeSearchResultActivty.U.invalidate();
                            animeSearchResultActivty.S.setVisibility(8);
                            break;
                        } else if (str != null && str.length() < 3) {
                            Toast.makeText(animeSearchResultActivty, "enter at least 3 characters", 0).show();
                            break;
                        }
                        break;
                    case 1:
                        int i122 = AnimeSearchResultActivty.f11596a0;
                        animeSearchResultActivty.onLetterClicked(StringUtils.SPACE);
                        break;
                    case 2:
                        animeSearchResultActivty.Z = AnimeSearchResultActivty.removeLastChar(animeSearchResultActivty.Z);
                        animeSearchResultActivty.d();
                        break;
                    default:
                        if (!animeSearchResultActivty.Z.isEmpty()) {
                            animeSearchResultActivty.Z = "";
                            animeSearchResultActivty.d();
                            break;
                        }
                        break;
                }
            }
        });
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // gd.i
    public void onLetterClicked(String str) {
        this.Z = c.o(new StringBuilder(), this.Z, str);
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

    @Override // gd.d
    public void openAnime(Anime anime) {
        Intent intent = new Intent(this, (Class<?>) AnimeDetailActivity.class);
        intent.putExtra("anime", anime);
        intent.setFlags(268435456);
        startActivity(intent);
    }
}
