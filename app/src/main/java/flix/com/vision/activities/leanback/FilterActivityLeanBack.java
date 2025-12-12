package flix.com.vision.activities.leanback;

import ac.t;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import c1.c;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.MovieDetailActivity;
import flix.com.vision.activities.leanback.FilterActivityLeanBack;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.j;
import hd.g;
import java.util.ArrayList;
import java.util.Iterator;
import qe.b;
import ub.n0;
import wb.a;

/* loaded from: classes2.dex */
public class FilterActivityLeanBack extends a implements j, aa.a {

    /* renamed from: o0, reason: collision with root package name */
    public static final /* synthetic */ int f11904o0 = 0;
    public String[] M;
    public String[] N;
    public String[] O;
    public String[] P;
    public String[] Q;
    public String[] R;
    public RelativeLayout X;
    public ArrayList<ld.a> Z;

    /* renamed from: c0, reason: collision with root package name */
    public SuperRecyclerView f11907c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11908d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f11909e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f11910f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f11911g0;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f11912h0;

    /* renamed from: i0, reason: collision with root package name */
    public t f11913i0;

    /* renamed from: l0, reason: collision with root package name */
    public b f11916l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f11917m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f11918n0;
    public int K = 0;
    public int L = 0;
    public final ArrayList<Movie> S = new ArrayList<>();
    public int T = 0;
    public int U = 0;
    public int V = 0;
    public String W = "";
    public boolean Y = false;

    /* renamed from: a0, reason: collision with root package name */
    public int f11905a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public int f11906b0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public String f11914j0 = "popularity.desc";

    /* renamed from: k0, reason: collision with root package name */
    public int f11915k0 = 1;

    public final void d(int i10) {
        int i11 = 20;
        this.f11907c0.setupMoreListener(this, 20);
        b bVar = this.f11916l0;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f11916l0 = bc.a.getItemsByGenres(this, String.valueOf(this.K), i10, this.L, this.V > 0 ? this.W : null, this.f11914j0, this.f11906b0, null).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new c(this, i11), new n0(24));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11917m0) {
            this.f11917m0 = false;
            super.onBackPressed();
            return;
        }
        Toast.makeText(getBaseContext(), "Press again to go back...", 0).show();
        if (this.S.size() < 200) {
            this.f11907c0.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.f11907c0.getRecyclerView().scrollToPosition(0);
        }
        this.f11917m0 = true;
        this.f11907c0.clearFocus();
        this.f11911g0.requestFocus();
        new Handler().postDelayed(new xb.a(this, 1), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_filter_leanback);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("All");
        arrayList2.add("All");
        Iterator<g> it = Constants.getMovieCategories().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f13007b);
        }
        Iterator<g> it2 = Constants.getSeriesCategories().iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next().f13007b);
        }
        final int i10 = 0;
        this.M = (String[]) arrayList.toArray(new String[0]);
        this.N = (String[]) arrayList2.toArray(new String[0]);
        this.O = new String[]{"Popularity", "Release Date"};
        this.Q = new String[]{"Movies", "Series"};
        this.P = getResources().getStringArray(R.array.years);
        this.R = new String[]{"All", "Netflix", "Disney+", "Prime Video", "K-Drama", "Apple TV+", "Paramount+", "HBO Max", "Hulu", "Starz", "Bollywood", "ABC", "CBS", "AMC", "Peacock", "Marvel Studios", "BET+", "BritBox"};
        ArrayList<ld.a> arrayList3 = new ArrayList<>();
        this.Z = arrayList3;
        arrayList3.add(new ld.a(-1, "All", null, -1));
        this.Z.addAll(Constants.getNetworks());
        this.X = (RelativeLayout) findViewById(R.id.activity_player);
        this.f11912h0 = (TextView) findViewById(R.id.network_button);
        this.f11907c0 = (SuperRecyclerView) findViewById(R.id.recyclerview_cast);
        this.f11910f0 = (TextView) findViewById(R.id.sort_by_button);
        this.f11909e0 = (TextView) findViewById(R.id.year_button);
        this.f11908d0 = (TextView) findViewById(R.id.genres_button);
        this.f11911g0 = (TextView) findViewById(R.id.type_button);
        this.f11909e0.setOnClickListener(new View.OnClickListener(this) { // from class: xb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivityLeanBack f21725m;

            {
                this.f21725m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                final int i12 = 0;
                final FilterActivityLeanBack filterActivityLeanBack = this.f21725m;
                switch (i11) {
                    case 0:
                        int i13 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        aVar.setSingleChoiceItems(filterActivityLeanBack.P, filterActivityLeanBack.V, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i14) {
                                String str;
                                int i15;
                                int i16 = i12;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i16) {
                                    case 0:
                                        int i17 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i14) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i14]);
                                                filterActivityLeanBack2.V = i14;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i14]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i18 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i14 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i14];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i14 > 0) {
                                                        i14--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i14).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i14];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i14 > 0) {
                                                        i14--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i14).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i19 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i14) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i14]);
                                                filterActivityLeanBack2.f11905a0 = i14;
                                                int i20 = filterActivityLeanBack2.Z.get(i14).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i20;
                                                if (i20 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i21 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i14) {
                                            if (i14 == 0 && (i15 = filterActivityLeanBack2.f11906b0) != 999 && i15 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i14]);
                                                filterActivityLeanBack2.T = i14;
                                                filterActivityLeanBack2.L = i14;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i14 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i14) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i14]);
                                                filterActivityLeanBack2.U = i14;
                                                filterActivityLeanBack2.f11914j0 = i14 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    case 1:
                        int i14 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i15 = 1;
                        aVar2.setSingleChoiceItems(filterActivityLeanBack.L == 0 ? filterActivityLeanBack.M : filterActivityLeanBack.N, 0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i16 = i15;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i16) {
                                    case 0:
                                        int i17 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i18 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i19 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i20 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i20;
                                                if (i20 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i21 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                    case 2:
                        int i16 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i17 = 3;
                        aVar3.setSingleChoiceItems(filterActivityLeanBack.Q, filterActivityLeanBack.T, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i17;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i18 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i19 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i20 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i20;
                                                if (i20 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i21 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar3.show();
                        break;
                    case 3:
                        int i18 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i19 = 2;
                        aVar4.setSingleChoiceItems(filterActivityLeanBack.R, filterActivityLeanBack.f11905a0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i19;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i20 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i20;
                                                if (i20 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i21 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar4.show();
                        break;
                    default:
                        int i20 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i21 = 4;
                        aVar5.setSingleChoiceItems(filterActivityLeanBack.O, filterActivityLeanBack.U, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i21;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar5.show();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.f11908d0.setOnClickListener(new View.OnClickListener(this) { // from class: xb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivityLeanBack f21725m;

            {
                this.f21725m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                final int i12 = 0;
                final FilterActivityLeanBack filterActivityLeanBack = this.f21725m;
                switch (i112) {
                    case 0:
                        int i13 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        aVar.setSingleChoiceItems(filterActivityLeanBack.P, filterActivityLeanBack.V, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i12;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    case 1:
                        int i14 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i15 = 1;
                        aVar2.setSingleChoiceItems(filterActivityLeanBack.L == 0 ? filterActivityLeanBack.M : filterActivityLeanBack.N, 0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i15;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                    case 2:
                        int i16 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i17 = 3;
                        aVar3.setSingleChoiceItems(filterActivityLeanBack.Q, filterActivityLeanBack.T, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i17;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar3.show();
                        break;
                    case 3:
                        int i18 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i19 = 2;
                        aVar4.setSingleChoiceItems(filterActivityLeanBack.R, filterActivityLeanBack.f11905a0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i19;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar4.show();
                        break;
                    default:
                        int i20 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i21 = 4;
                        aVar5.setSingleChoiceItems(filterActivityLeanBack.O, filterActivityLeanBack.U, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i21;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar5.show();
                        break;
                }
            }
        });
        final int i12 = 2;
        this.f11911g0.setOnClickListener(new View.OnClickListener(this) { // from class: xb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivityLeanBack f21725m;

            {
                this.f21725m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                final int i122 = 0;
                final FilterActivityLeanBack filterActivityLeanBack = this.f21725m;
                switch (i112) {
                    case 0:
                        int i13 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        aVar.setSingleChoiceItems(filterActivityLeanBack.P, filterActivityLeanBack.V, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i122;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    case 1:
                        int i14 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i15 = 1;
                        aVar2.setSingleChoiceItems(filterActivityLeanBack.L == 0 ? filterActivityLeanBack.M : filterActivityLeanBack.N, 0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i15;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                    case 2:
                        int i16 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i17 = 3;
                        aVar3.setSingleChoiceItems(filterActivityLeanBack.Q, filterActivityLeanBack.T, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i17;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar3.show();
                        break;
                    case 3:
                        int i18 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i19 = 2;
                        aVar4.setSingleChoiceItems(filterActivityLeanBack.R, filterActivityLeanBack.f11905a0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i19;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar4.show();
                        break;
                    default:
                        int i20 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i21 = 4;
                        aVar5.setSingleChoiceItems(filterActivityLeanBack.O, filterActivityLeanBack.U, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i21;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar5.show();
                        break;
                }
            }
        });
        final int i13 = 3;
        this.f11912h0.setOnClickListener(new View.OnClickListener(this) { // from class: xb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivityLeanBack f21725m;

            {
                this.f21725m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                final int i122 = 0;
                final FilterActivityLeanBack filterActivityLeanBack = this.f21725m;
                switch (i112) {
                    case 0:
                        int i132 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        aVar.setSingleChoiceItems(filterActivityLeanBack.P, filterActivityLeanBack.V, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i122;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    case 1:
                        int i14 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i15 = 1;
                        aVar2.setSingleChoiceItems(filterActivityLeanBack.L == 0 ? filterActivityLeanBack.M : filterActivityLeanBack.N, 0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i15;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                    case 2:
                        int i16 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i17 = 3;
                        aVar3.setSingleChoiceItems(filterActivityLeanBack.Q, filterActivityLeanBack.T, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i17;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar3.show();
                        break;
                    case 3:
                        int i18 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i19 = 2;
                        aVar4.setSingleChoiceItems(filterActivityLeanBack.R, filterActivityLeanBack.f11905a0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i19;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar4.show();
                        break;
                    default:
                        int i20 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i21 = 4;
                        aVar5.setSingleChoiceItems(filterActivityLeanBack.O, filterActivityLeanBack.U, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i21;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar5.show();
                        break;
                }
            }
        });
        final int i14 = 4;
        this.f11910f0.setOnClickListener(new View.OnClickListener(this) { // from class: xb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivityLeanBack f21725m;

            {
                this.f21725m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i14;
                final int i122 = 0;
                final FilterActivityLeanBack filterActivityLeanBack = this.f21725m;
                switch (i112) {
                    case 0:
                        int i132 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        aVar.setSingleChoiceItems(filterActivityLeanBack.P, filterActivityLeanBack.V, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                String str;
                                int i152;
                                int i162 = i122;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i142) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.V = i142;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i142]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i142 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i142];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i142).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i142];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i142 > 0) {
                                                        i142--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i142).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i142) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i142]);
                                                filterActivityLeanBack2.f11905a0 = i142;
                                                int i202 = filterActivityLeanBack2.Z.get(i142).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i142) {
                                            if (i142 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i142]);
                                                filterActivityLeanBack2.T = i142;
                                                filterActivityLeanBack2.L = i142;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i142 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i142) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i142]);
                                                filterActivityLeanBack2.U = i142;
                                                filterActivityLeanBack2.f11914j0 = i142 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar.show();
                        break;
                    case 1:
                        int i142 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i15 = 1;
                        aVar2.setSingleChoiceItems(filterActivityLeanBack.L == 0 ? filterActivityLeanBack.M : filterActivityLeanBack.N, 0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i1422) {
                                String str;
                                int i152;
                                int i162 = i15;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.V = i1422;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i1422 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i1422];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i1422).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i1422];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i1422).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i1422]);
                                                filterActivityLeanBack2.f11905a0 = i1422;
                                                int i202 = filterActivityLeanBack2.Z.get(i1422).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i1422) {
                                            if (i1422 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i1422]);
                                                filterActivityLeanBack2.T = i1422;
                                                filterActivityLeanBack2.L = i1422;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i1422 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i1422]);
                                                filterActivityLeanBack2.U = i1422;
                                                filterActivityLeanBack2.f11914j0 = i1422 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar2.show();
                        break;
                    case 2:
                        int i16 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i17 = 3;
                        aVar3.setSingleChoiceItems(filterActivityLeanBack.Q, filterActivityLeanBack.T, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i1422) {
                                String str;
                                int i152;
                                int i162 = i17;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.V = i1422;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i1422 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i1422];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i1422).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i1422];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i1422).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i1422]);
                                                filterActivityLeanBack2.f11905a0 = i1422;
                                                int i202 = filterActivityLeanBack2.Z.get(i1422).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i1422) {
                                            if (i1422 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i1422]);
                                                filterActivityLeanBack2.T = i1422;
                                                filterActivityLeanBack2.L = i1422;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i1422 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i1422]);
                                                filterActivityLeanBack2.U = i1422;
                                                filterActivityLeanBack2.f11914j0 = i1422 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar3.show();
                        break;
                    case 3:
                        int i18 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i19 = 2;
                        aVar4.setSingleChoiceItems(filterActivityLeanBack.R, filterActivityLeanBack.f11905a0, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i1422) {
                                String str;
                                int i152;
                                int i162 = i19;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.V = i1422;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i1422 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i1422];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i1422).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i1422];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i1422).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i1422]);
                                                filterActivityLeanBack2.f11905a0 = i1422;
                                                int i202 = filterActivityLeanBack2.Z.get(i1422).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i1422) {
                                            if (i1422 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i1422]);
                                                filterActivityLeanBack2.T = i1422;
                                                filterActivityLeanBack2.L = i1422;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i1422 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i1422]);
                                                filterActivityLeanBack2.U = i1422;
                                                filterActivityLeanBack2.f11914j0 = i1422 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar4.show();
                        break;
                    default:
                        int i20 = FilterActivityLeanBack.f11904o0;
                        filterActivityLeanBack.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivityLeanBack, R.style.AlertDialogCustom));
                        final int i21 = 4;
                        aVar5.setSingleChoiceItems(filterActivityLeanBack.O, filterActivityLeanBack.U, new DialogInterface.OnClickListener() { // from class: xb.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i1422) {
                                String str;
                                int i152;
                                int i162 = i21;
                                FilterActivityLeanBack filterActivityLeanBack2 = filterActivityLeanBack;
                                switch (i162) {
                                    case 0:
                                        int i172 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.V != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11909e0.setText(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.V = i1422;
                                                filterActivityLeanBack2.W = String.valueOf(filterActivityLeanBack2.P[i1422]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i182 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (i1422 != 0) {
                                            try {
                                                if (filterActivityLeanBack2.L == 0) {
                                                    str = filterActivityLeanBack2.M[i1422];
                                                    ArrayList<g> movieCategories = Constants.getMovieCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = movieCategories.get(i1422).f13006a;
                                                } else {
                                                    str = filterActivityLeanBack2.N[i1422];
                                                    ArrayList<g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i1422 > 0) {
                                                        i1422--;
                                                    }
                                                    filterActivityLeanBack2.K = seriesCategories.get(i1422).f13006a;
                                                }
                                                filterActivityLeanBack2.f11908d0.setText(str);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i192 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.f11905a0 != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[i1422]);
                                                filterActivityLeanBack2.f11905a0 = i1422;
                                                int i202 = filterActivityLeanBack2.Z.get(i1422).f16048b;
                                                filterActivityLeanBack2.f11906b0 = i202;
                                                if (i202 != 999 && filterActivityLeanBack2.L == 0) {
                                                    filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[1]);
                                                    filterActivityLeanBack2.T = 1;
                                                    filterActivityLeanBack2.L = 1;
                                                    filterActivityLeanBack2.K = 0;
                                                    filterActivityLeanBack2.f11908d0.setText(filterActivityLeanBack2.N[0]);
                                                }
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i212 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.T != i1422) {
                                            if (i1422 == 0 && (i152 = filterActivityLeanBack2.f11906b0) != 999 && i152 != 9999) {
                                                try {
                                                    filterActivityLeanBack2.f11905a0 = 0;
                                                    filterActivityLeanBack2.f11912h0.setText(filterActivityLeanBack2.R[0]);
                                                    filterActivityLeanBack2.f11906b0 = -1;
                                                } catch (Exception unused4) {
                                                }
                                            }
                                            try {
                                                filterActivityLeanBack2.f11911g0.setText(filterActivityLeanBack2.Q[i1422]);
                                                filterActivityLeanBack2.T = i1422;
                                                filterActivityLeanBack2.L = i1422;
                                                filterActivityLeanBack2.K = 0;
                                                filterActivityLeanBack2.f11908d0.setText(i1422 == 0 ? filterActivityLeanBack2.M[0] : filterActivityLeanBack2.N[0]);
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused5) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i22 = FilterActivityLeanBack.f11904o0;
                                        filterActivityLeanBack2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivityLeanBack2.U != i1422) {
                                            try {
                                                filterActivityLeanBack2.f11910f0.setText(filterActivityLeanBack2.O[i1422]);
                                                filterActivityLeanBack2.U = i1422;
                                                filterActivityLeanBack2.f11914j0 = i1422 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivityLeanBack2.Y = true;
                                                filterActivityLeanBack2.f11915k0 = 1;
                                                filterActivityLeanBack2.d(1);
                                                break;
                                            } catch (Exception unused6) {
                                                return;
                                            }
                                        }
                                        break;
                                }
                            }
                        });
                        aVar5.show();
                        break;
                }
            }
        });
        this.f11908d0.requestFocus();
        float f10 = o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density;
        int iRound = Math.round(f10 / (App.K ? 140 : 120));
        if (App.getInstance().f11574v.getBoolean("prefs_show_big_cobers", false)) {
            iRound = Math.round(f10 / 180.0f);
        }
        int i15 = iRound;
        this.f11907c0.addItemDecoration(new fd.c(App.K ? 12 : 8));
        this.f11913i0 = new t(getBaseContext(), this.S, this, 0, this, null);
        this.f11907c0.setLayoutManager(new CenterGridLayoutManager(this, i15));
        this.f11907c0.addItemDecoration(new fd.c(8));
        this.f11907c0.setAdapter(this.f11913i0);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new c4.a();
        int intExtra = getIntent().getIntExtra("network", -1);
        this.f11906b0 = intExtra;
        if (intExtra != -1) {
            while (i10 < this.Z.size()) {
                if (this.Z.get(i10).f16048b == this.f11906b0) {
                    this.f11905a0 = i10;
                    this.f11912h0.setText(this.Z.get(i10).f16047a);
                }
                i10++;
            }
            int i16 = this.f11906b0;
            if (i16 != 999 && i16 != 9999) {
                this.T = 1;
                this.f11911g0.setText(this.Q[1]);
                this.L = 1;
            }
        }
        setBackgroundColor();
        d(this.f11915k0);
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // aa.a
    public void onMoreAsked(int i10, int i11, int i12) {
        this.f11915k0++;
        new Handler().postDelayed(new xb.a(this, 0), 200L);
    }

    public void setBackgroundColor() {
        this.f11918n0 = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f11918n0), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 20));
        valueAnimatorOfObject.start();
        this.f11918n0 = 0;
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
