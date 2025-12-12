package flix.com.vision.activities;

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
import flix.com.vision.activities.FilterActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.helpers.Constants;
import flix.com.vision.models.Movie;
import flix.com.vision.tv.Constant;
import gd.j;
import hd.g;
import java.util.ArrayList;
import java.util.Iterator;
import ub.f0;

/* loaded from: classes2.dex */
public class FilterActivity extends wb.a implements j, aa.a {

    /* renamed from: o0, reason: collision with root package name */
    public static final /* synthetic */ int f11656o0 = 0;
    public String[] M;
    public String[] N;
    public String[] O;
    public String[] P;
    public String[] Q;
    public String[] R;
    public RelativeLayout X;
    public ArrayList<ld.a> Z;

    /* renamed from: c0, reason: collision with root package name */
    public SuperRecyclerView f11659c0;

    /* renamed from: d0, reason: collision with root package name */
    public TextView f11660d0;

    /* renamed from: e0, reason: collision with root package name */
    public TextView f11661e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f11662f0;

    /* renamed from: g0, reason: collision with root package name */
    public TextView f11663g0;

    /* renamed from: h0, reason: collision with root package name */
    public TextView f11664h0;

    /* renamed from: i0, reason: collision with root package name */
    public t f11665i0;

    /* renamed from: l0, reason: collision with root package name */
    public qe.b f11668l0;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f11669m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f11670n0;
    public int K = 0;
    public int L = 0;
    public final ArrayList<Movie> S = new ArrayList<>();
    public int T = 0;
    public int U = 0;
    public int V = 0;
    public String W = "";
    public boolean Y = false;

    /* renamed from: a0, reason: collision with root package name */
    public int f11657a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public int f11658b0 = -1;

    /* renamed from: j0, reason: collision with root package name */
    public String f11666j0 = "popularity.desc";

    /* renamed from: k0, reason: collision with root package name */
    public int f11667k0 = 1;

    public final void d(int i10) {
        this.f11659c0.setupMoreListener(this, 20);
        qe.b bVar = this.f11668l0;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f11668l0 = bc.a.getItemsByGenres(this, String.valueOf(this.K), i10, this.L, this.V > 0 ? this.W : null, this.f11666j0, this.f11658b0, null).observeOn(pe.a.mainThread()).subscribeOn(gf.a.newThread()).subscribe(new c(this, 16), new u8.a(28));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11669m0) {
            this.f11669m0 = false;
            super.onBackPressed();
            return;
        }
        Toast.makeText(getBaseContext(), "Press again to go back...", 0).show();
        if (this.S.size() < 200) {
            this.f11659c0.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.f11659c0.getRecyclerView().scrollToPosition(0);
        }
        this.f11669m0 = true;
        this.f11659c0.clearFocus();
        this.f11663g0.requestFocus();
        new Handler().postDelayed(new f0(this, 0), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_filter_main);
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
        this.f11664h0 = (TextView) findViewById(R.id.network_button);
        this.f11659c0 = (SuperRecyclerView) findViewById(R.id.recyclerview_cast);
        this.f11662f0 = (TextView) findViewById(R.id.sort_by_button);
        this.f11661e0 = (TextView) findViewById(R.id.year_button);
        this.f11660d0 = (TextView) findViewById(R.id.genres_button);
        this.f11663g0 = (TextView) findViewById(R.id.type_button);
        this.f11661e0.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivity f20171m;

            {
                this.f20171m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                final int i12 = 0;
                final FilterActivity filterActivity = this.f20171m;
                switch (i11) {
                    case 0:
                        int i13 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i14 = 3;
                        aVar.setSingleChoiceItems(filterActivity.P, filterActivity.V, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i15) {
                                int i16;
                                String str;
                                int i17 = i14;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i17) {
                                    case 0:
                                        int i18 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i15) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i15]);
                                                filterActivity2.f11657a0 = i15;
                                                int i19 = filterActivity2.Z.get(i15).f16048b;
                                                filterActivity2.f11658b0 = i19;
                                                if (i19 != 999 && i19 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i20 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i15 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i15];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i15 > 0) {
                                                        i15--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i15).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i15];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i15 > 0) {
                                                        i15--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i15).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i21 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i15) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i15]);
                                                filterActivity2.U = i15;
                                                filterActivity2.f11666j0 = i15 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i15) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i15]);
                                                filterActivity2.V = i15;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i15]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i15) {
                                            if (i15 == 0 && (i16 = filterActivity2.f11658b0) != 999 && i16 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i15]);
                                                filterActivity2.T = i15;
                                                filterActivity2.L = i15;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i15 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i15 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i16 = 1;
                        aVar2.setSingleChoiceItems(filterActivity.L == 0 ? filterActivity.M : filterActivity.N, 0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i17 = i16;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i17) {
                                    case 0:
                                        int i18 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i19 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i19;
                                                if (i19 != 999 && i19 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i20 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i21 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i17 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i18 = 4;
                        aVar3.setSingleChoiceItems(filterActivity.Q, filterActivity.T, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i18;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i19 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i19;
                                                if (i19 != 999 && i19 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i20 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i21 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i19 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        aVar4.setSingleChoiceItems(filterActivity.R, filterActivity.f11657a0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i12;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i20 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i21 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i20 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i21 = 2;
                        aVar5.setSingleChoiceItems(filterActivity.O, filterActivity.U, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i21;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
        this.f11660d0.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivity f20171m;

            {
                this.f20171m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                final int i12 = 0;
                final FilterActivity filterActivity = this.f20171m;
                switch (i112) {
                    case 0:
                        int i13 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i14 = 3;
                        aVar.setSingleChoiceItems(filterActivity.P, filterActivity.V, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i14;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i15 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i16 = 1;
                        aVar2.setSingleChoiceItems(filterActivity.L == 0 ? filterActivity.M : filterActivity.N, 0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i16;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i17 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i18 = 4;
                        aVar3.setSingleChoiceItems(filterActivity.Q, filterActivity.T, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i18;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i19 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        aVar4.setSingleChoiceItems(filterActivity.R, filterActivity.f11657a0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i12;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i20 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i21 = 2;
                        aVar5.setSingleChoiceItems(filterActivity.O, filterActivity.U, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i21;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
        this.f11663g0.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivity f20171m;

            {
                this.f20171m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                final int i122 = 0;
                final FilterActivity filterActivity = this.f20171m;
                switch (i112) {
                    case 0:
                        int i13 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i14 = 3;
                        aVar.setSingleChoiceItems(filterActivity.P, filterActivity.V, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i14;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i15 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i16 = 1;
                        aVar2.setSingleChoiceItems(filterActivity.L == 0 ? filterActivity.M : filterActivity.N, 0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i16;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i17 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i18 = 4;
                        aVar3.setSingleChoiceItems(filterActivity.Q, filterActivity.T, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i18;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i19 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        aVar4.setSingleChoiceItems(filterActivity.R, filterActivity.f11657a0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i122;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i20 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i21 = 2;
                        aVar5.setSingleChoiceItems(filterActivity.O, filterActivity.U, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i21;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
        this.f11664h0.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivity f20171m;

            {
                this.f20171m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                final int i122 = 0;
                final FilterActivity filterActivity = this.f20171m;
                switch (i112) {
                    case 0:
                        int i132 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i14 = 3;
                        aVar.setSingleChoiceItems(filterActivity.P, filterActivity.V, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i14;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i15 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i16 = 1;
                        aVar2.setSingleChoiceItems(filterActivity.L == 0 ? filterActivity.M : filterActivity.N, 0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i16;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i17 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i18 = 4;
                        aVar3.setSingleChoiceItems(filterActivity.Q, filterActivity.T, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i18;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i19 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        aVar4.setSingleChoiceItems(filterActivity.R, filterActivity.f11657a0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i122;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i20 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i21 = 2;
                        aVar5.setSingleChoiceItems(filterActivity.O, filterActivity.U, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i21;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
        this.f11662f0.setOnClickListener(new View.OnClickListener(this) { // from class: ub.e0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FilterActivity f20171m;

            {
                this.f20171m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i14;
                final int i122 = 0;
                final FilterActivity filterActivity = this.f20171m;
                switch (i112) {
                    case 0:
                        int i132 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i142 = 3;
                        aVar.setSingleChoiceItems(filterActivity.P, filterActivity.V, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i142;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i15 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i16 = 1;
                        aVar2.setSingleChoiceItems(filterActivity.L == 0 ? filterActivity.M : filterActivity.N, 0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i16;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i17 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar3 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i18 = 4;
                        aVar3.setSingleChoiceItems(filterActivity.Q, filterActivity.T, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i18;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i19 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar4 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        aVar4.setSingleChoiceItems(filterActivity.R, filterActivity.f11657a0, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i122;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
                        int i20 = FilterActivity.f11656o0;
                        filterActivity.getClass();
                        d.a aVar5 = new d.a(new ContextThemeWrapper(filterActivity, R.style.AlertDialogCustom));
                        final int i21 = 2;
                        aVar5.setSingleChoiceItems(filterActivity.O, filterActivity.U, new DialogInterface.OnClickListener() { // from class: ub.g0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i152) {
                                int i162;
                                String str;
                                int i172 = i21;
                                FilterActivity filterActivity2 = filterActivity;
                                switch (i172) {
                                    case 0:
                                        int i182 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.f11657a0 != i152) {
                                            try {
                                                filterActivity2.f11664h0.setText(filterActivity2.R[i152]);
                                                filterActivity2.f11657a0 = i152;
                                                int i192 = filterActivity2.Z.get(i152).f16048b;
                                                filterActivity2.f11658b0 = i192;
                                                if (i192 != 999 && i192 != 9999 && filterActivity2.L == 0) {
                                                    filterActivity2.f11663g0.setText(filterActivity2.Q[1]);
                                                    filterActivity2.T = 1;
                                                    filterActivity2.L = 1;
                                                    filterActivity2.K = 0;
                                                    filterActivity2.f11660d0.setText(filterActivity2.N[0]);
                                                }
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i202 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (i152 != 0) {
                                            try {
                                                if (filterActivity2.L == 0) {
                                                    str = filterActivity2.M[i152];
                                                    ArrayList<hd.g> movieCategories = Constants.getMovieCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = movieCategories.get(i152).f13006a;
                                                } else {
                                                    str = filterActivity2.N[i152];
                                                    ArrayList<hd.g> seriesCategories = Constants.getSeriesCategories();
                                                    if (i152 > 0) {
                                                        i152--;
                                                    }
                                                    filterActivity2.K = seriesCategories.get(i152).f13006a;
                                                }
                                                filterActivity2.f11660d0.setText(str);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused2) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 2:
                                        int i212 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.U != i152) {
                                            try {
                                                filterActivity2.f11662f0.setText(filterActivity2.O[i152]);
                                                filterActivity2.U = i152;
                                                filterActivity2.f11666j0 = i152 == 0 ? "popularity.desc" : "primary_release_date.desc";
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused3) {
                                                return;
                                            }
                                        }
                                        break;
                                    case 3:
                                        int i22 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.V != i152) {
                                            try {
                                                filterActivity2.f11661e0.setText(filterActivity2.P[i152]);
                                                filterActivity2.V = i152;
                                                filterActivity2.W = String.valueOf(filterActivity2.P[i152]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
                                                break;
                                            } catch (Exception unused4) {
                                                return;
                                            }
                                        }
                                        break;
                                    default:
                                        int i23 = FilterActivity.f11656o0;
                                        filterActivity2.getClass();
                                        dialogInterface.dismiss();
                                        if (filterActivity2.T != i152) {
                                            if (i152 == 0 && (i162 = filterActivity2.f11658b0) != 999 && i162 != 9999) {
                                                try {
                                                    filterActivity2.f11657a0 = 0;
                                                    filterActivity2.f11664h0.setText(filterActivity2.R[0]);
                                                    filterActivity2.f11658b0 = -1;
                                                } catch (Exception unused5) {
                                                }
                                            }
                                            try {
                                                filterActivity2.f11663g0.setText(filterActivity2.Q[i152]);
                                                filterActivity2.T = i152;
                                                filterActivity2.L = i152;
                                                filterActivity2.K = 0;
                                                filterActivity2.f11660d0.setText(i152 == 0 ? filterActivity2.M[0] : filterActivity2.N[0]);
                                                filterActivity2.Y = true;
                                                filterActivity2.f11667k0 = 1;
                                                filterActivity2.d(1);
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
        this.f11660d0.requestFocus();
        int iRound = Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / 140);
        this.f11659c0.addItemDecoration(new fd.c(App.K ? 12 : 8));
        this.f11665i0 = new t(getBaseContext(), this.S, this, 0, this, null);
        this.f11659c0.setLayoutManager(new CenterGridLayoutManager(this, iRound));
        this.f11659c0.addItemDecoration(new fd.c(8));
        this.f11659c0.setAdapter(this.f11665i0);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new c4.a();
        int intExtra = getIntent().getIntExtra("network", -1);
        this.f11658b0 = intExtra;
        if (intExtra != -1) {
            while (i10 < this.Z.size()) {
                if (this.Z.get(i10).f16048b == this.f11658b0) {
                    this.f11657a0 = i10;
                    this.f11664h0.setText(this.Z.get(i10).f16047a);
                }
                i10++;
            }
            int i15 = this.f11658b0;
            if (i15 != 999 && i15 != 9999) {
                this.T = 1;
                this.f11663g0.setText(this.Q[1]);
                this.L = 1;
            }
        }
        setBackgroundColor();
        d(this.f11667k0);
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
        this.f11667k0++;
        new Handler().postDelayed(new f0(this, 1), 200L);
    }

    public void setBackgroundColor() {
        this.f11670n0 = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f11670n0), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 10));
        valueAnimatorOfObject.start();
        this.f11670n0 = 0;
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
