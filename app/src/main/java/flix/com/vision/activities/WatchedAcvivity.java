package flix.com.vision.activities;

import ac.d0;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Movie;
import gd.j;
import java.util.ArrayList;
import kc.d;
import ub.u;
import ub.v;
import ub.y2;

/* loaded from: classes2.dex */
public class WatchedAcvivity extends wb.a implements j {
    public static final /* synthetic */ int P = 0;
    public TextView K;
    public final int L = 200;
    public SuperRecyclerView M;
    public ArrayList<Movie> N;
    public d0 O;

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_watched);
        this.K = (TextView) findViewById(R.id.clear_button);
        this.M = (SuperRecyclerView) findViewById(R.id.recyclerview_favorites);
        this.N = App.getInstance().f11573u.getWatchedMoviesFromDb();
        d0 d0Var = new d0(getBaseContext(), this.N, this, this.L, this, null);
        this.O = d0Var;
        this.M.setAdapter(d0Var);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.M.setLayoutManager(new GridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
        this.K.setOnClickListener(new y2(this, 0));
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

    public void showLongPressDialog(Movie movie, int i10) {
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, true);
        dVarNewInstance.setTitle(movie.getTitle());
        dVarNewInstance.setMessage("What would you like to Do?");
        dVarNewInstance.setButton2("ADD TO FAVORITES", new v(4, this, movie));
        dVarNewInstance.setButton3("REMOVE", new u(this, movie, i10, 2));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
