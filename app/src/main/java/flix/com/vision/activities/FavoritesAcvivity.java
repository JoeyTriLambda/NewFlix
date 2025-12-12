package flix.com.vision.activities;

import ac.t;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.GridLayoutManager;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.FavoritesAcvivity;
import flix.com.vision.models.Movie;
import gd.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;

/* loaded from: classes2.dex */
public class FavoritesAcvivity extends wb.a implements j {
    public static final /* synthetic */ int V = 0;
    public int K;
    public int L;
    public String[] M;
    public String[] N;
    public TextView O;
    public TextView P;
    public final int Q = 200;
    public SuperRecyclerView R;
    public ArrayList<Movie> S;
    public ArrayList<Movie> T;
    public t U;

    /* JADX WARN: Type inference failed for: r1v1, types: [ub.d0] */
    public final void d() {
        this.S.clear();
        Iterator<Movie> it = this.T.iterator();
        while (it.hasNext()) {
            Movie next = it.next();
            if (this.K == 0) {
                this.S.add(next);
            }
            if (this.K == 1 && !next.isSeries()) {
                this.S.add(next);
            }
            if (this.K == 2 && next.isSeries()) {
                this.S.add(next);
            }
        }
        if (this.L == 1) {
            Collections.sort(this.S, Comparator.comparing(new Function() { // from class: ub.d0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((Movie) obj).getTitle();
                }
            }));
        }
        this.U.notifyDataSetChanged();
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
        this.S.remove(i10);
        this.U.notifyItemRemoved(i10);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_favorites);
        this.M = new String[]{"Show All", "Movies", "TV Shows"};
        this.N = new String[]{"By Date", "Alphabetic"};
        this.T = new ArrayList<>();
        this.R = (SuperRecyclerView) findViewById(R.id.recyclerview_favorites);
        this.O = (TextView) findViewById(R.id.filter_button);
        this.P = (TextView) findViewById(R.id.sort_button);
        ArrayList<Movie> favoritesMoviesFromDb = App.getInstance().f11573u.getFavoritesMoviesFromDb();
        this.S = favoritesMoviesFromDb;
        this.T.addAll(favoritesMoviesFromDb);
        t tVar = new t(getBaseContext(), this.S, this, this.Q, this, null);
        this.U = tVar;
        this.R.setAdapter(tVar);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.R.setLayoutManager(new GridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
        final int i10 = 0;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: ub.b0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FavoritesAcvivity f20154m;

            {
                this.f20154m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                final FavoritesAcvivity favoritesAcvivity = this.f20154m;
                switch (i11) {
                    case 0:
                        int i12 = FavoritesAcvivity.V;
                        favoritesAcvivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(favoritesAcvivity, R.style.AlertDialogCustom));
                        final int i13 = 1;
                        aVar.setSingleChoiceItems(favoritesAcvivity.M, favoritesAcvivity.K, new DialogInterface.OnClickListener() { // from class: ub.c0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i14) {
                                int i15 = i13;
                                FavoritesAcvivity favoritesAcvivity2 = favoritesAcvivity;
                                switch (i15) {
                                    case 0:
                                        int i16 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.P.setText(favoritesAcvivity2.N[i14]);
                                            favoritesAcvivity2.L = i14;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused) {
                                            return;
                                        }
                                    default:
                                        int i17 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.O.setText(favoritesAcvivity2.M[i14]);
                                            favoritesAcvivity2.K = i14;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                }
                            }
                        });
                        aVar.show();
                        break;
                    default:
                        int i14 = FavoritesAcvivity.V;
                        favoritesAcvivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(favoritesAcvivity, R.style.AlertDialogCustom));
                        final int i15 = 0;
                        aVar2.setSingleChoiceItems(favoritesAcvivity.N, favoritesAcvivity.L, new DialogInterface.OnClickListener() { // from class: ub.c0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                int i152 = i15;
                                FavoritesAcvivity favoritesAcvivity2 = favoritesAcvivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.P.setText(favoritesAcvivity2.N[i142]);
                                            favoritesAcvivity2.L = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused) {
                                            return;
                                        }
                                    default:
                                        int i17 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.O.setText(favoritesAcvivity2.M[i142]);
                                            favoritesAcvivity2.K = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                }
                            }
                        });
                        aVar2.show();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.P.setOnClickListener(new View.OnClickListener(this) { // from class: ub.b0

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ FavoritesAcvivity f20154m;

            {
                this.f20154m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                final FavoritesAcvivity favoritesAcvivity = this.f20154m;
                switch (i112) {
                    case 0:
                        int i12 = FavoritesAcvivity.V;
                        favoritesAcvivity.getClass();
                        d.a aVar = new d.a(new ContextThemeWrapper(favoritesAcvivity, R.style.AlertDialogCustom));
                        final int i13 = 1;
                        aVar.setSingleChoiceItems(favoritesAcvivity.M, favoritesAcvivity.K, new DialogInterface.OnClickListener() { // from class: ub.c0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                int i152 = i13;
                                FavoritesAcvivity favoritesAcvivity2 = favoritesAcvivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.P.setText(favoritesAcvivity2.N[i142]);
                                            favoritesAcvivity2.L = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused) {
                                            return;
                                        }
                                    default:
                                        int i17 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.O.setText(favoritesAcvivity2.M[i142]);
                                            favoritesAcvivity2.K = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                }
                            }
                        });
                        aVar.show();
                        break;
                    default:
                        int i14 = FavoritesAcvivity.V;
                        favoritesAcvivity.getClass();
                        d.a aVar2 = new d.a(new ContextThemeWrapper(favoritesAcvivity, R.style.AlertDialogCustom));
                        final int i15 = 0;
                        aVar2.setSingleChoiceItems(favoritesAcvivity.N, favoritesAcvivity.L, new DialogInterface.OnClickListener() { // from class: ub.c0
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i142) {
                                int i152 = i15;
                                FavoritesAcvivity favoritesAcvivity2 = favoritesAcvivity;
                                switch (i152) {
                                    case 0:
                                        int i16 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.P.setText(favoritesAcvivity2.N[i142]);
                                            favoritesAcvivity2.L = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused) {
                                            return;
                                        }
                                    default:
                                        int i17 = FavoritesAcvivity.V;
                                        favoritesAcvivity2.getClass();
                                        dialogInterface.dismiss();
                                        try {
                                            favoritesAcvivity2.O.setText(favoritesAcvivity2.M[i142]);
                                            favoritesAcvivity2.K = i142;
                                            favoritesAcvivity2.d();
                                            break;
                                        } catch (Exception unused2) {
                                            return;
                                        }
                                }
                            }
                        });
                        aVar2.show();
                        break;
                }
            }
        });
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
