package flix.com.vision.activities;

import ac.m;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Drama;
import gd.e;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DramaHistoryActivity extends wb.a implements e {
    public static final /* synthetic */ int O = 0;
    public SuperRecyclerView K;
    public ArrayList<Drama> L;
    public m M;
    public RelativeLayout N;

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_anime_history);
        this.K = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.N = (RelativeLayout) findViewById(R.id.anime_favorites);
        ArrayList<Drama> dramaHistory = App.getInstance().f11573u.getDramaHistory();
        this.L = dramaHistory;
        m mVar = new m(dramaHistory, this, this);
        this.M = mVar;
        this.K.setAdapter(mVar);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.K.setLayoutManager(new GridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
        this.N.setOnClickListener(new androidx.mediarouter.app.b(this, 8));
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
