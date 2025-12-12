package flix.com.vision.activities;

import ac.h;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.GridLayoutManager;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Anime;
import gd.d;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AnimesFavoritesAcvivity extends wb.a implements d {
    public final int K = 200;
    public SuperRecyclerView L;
    public ArrayList<Anime> M;

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_anime_favoritess);
        this.L = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.M = App.getInstance().f11573u.getFavoritesMoviesFromDb_Anime();
        this.L.setAdapter(new h(getBaseContext(), this.M, this, this.K, this));
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.L.setLayoutManager(new GridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
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
