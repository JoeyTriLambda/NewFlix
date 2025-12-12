package flix.com.vision.activities;

import ac.h;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.models.Anime;
import gd.d;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public class AnimeSearchResultActivityClassic extends wb.a implements d {
    public ProgressBar K;
    public ArrayList<Anime> L;
    public h M;
    public SuperRecyclerView N;
    public final int O = 100;

    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f11594b;

        public a(ArrayList arrayList) {
            this.f11594b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            AnimeSearchResultActivityClassic animeSearchResultActivityClassic = AnimeSearchResultActivityClassic.this;
            animeSearchResultActivityClassic.L.addAll(this.f11594b);
            animeSearchResultActivityClassic.M.notifyDataSetChanged();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_result_activty_anime);
        this.L = new ArrayList<>();
        this.M = new h(getBaseContext(), this.L, this, this.O, this);
        this.N = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.K = (ProgressBar) findViewById(R.id.loader);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.N.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
        this.N.addItemDecoration(new c(12));
        this.N.setAdapter(this.M);
        String stringExtra = getIntent().getStringExtra("query");
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Results for \"" + stringExtra + "\"");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.L.addAll(App.getInstance().f11573u.searchGoAnime(stringExtra.replace("'", "")));
        if (this.L.size() < 1) {
            this.K.setVisibility(8);
            androidx.appcompat.app.d dVarCreate = new d.a(this).create();
            dVarCreate.setTitle(getString(R.string.no_result_mess));
            dVarCreate.setIcon(R.drawable.ic_action_sentiment_very_dissatisfied);
            dVarCreate.setMessage(getString(R.string.go_back_check_query_mess));
            dVarCreate.setButton(-3, getString(R.string.ok_label), new ub.c(this));
            try {
                dVarCreate.show();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            dVarCreate.setCancelable(false);
            dVarCreate.setOnDismissListener(new ub.d(this));
        }
        Collections.reverse(this.L);
        this.N.getAdapter().notifyDataSetChanged();
        this.N.invalidate();
        this.K.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anime_search_menu, menu);
        return true;
    }

    @Override // wb.a, r.j, androidx.fragment.app.p, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
        }
        if (itemId != R.id.action_sort_anime) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.L);
        this.L.clear();
        this.M.notifyDataSetChanged();
        Collections.reverse(arrayList);
        new Handler().postDelayed(new a(arrayList), 300L);
        return true;
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
