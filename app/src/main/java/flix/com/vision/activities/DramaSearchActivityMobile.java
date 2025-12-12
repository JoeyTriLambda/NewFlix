package flix.com.vision.activities;

import ac.m;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.models.Drama;
import flix.com.vision.tv.Constant;
import gd.e;
import java.util.ArrayList;
import kc.d;
import ub.w;
import ub.y;

/* loaded from: classes2.dex */
public class DramaSearchActivityMobile extends wb.a implements e {
    public static final /* synthetic */ int U = 0;
    public RelativeLayout K;
    public Toolbar L;
    public MaterialSearchView M;
    public RecyclerView O;
    public m P;
    public int S;
    public d T;
    public final ArrayList<Drama> N = new ArrayList<>();
    public String Q = "https://kissasiantv.to";
    public boolean R = false;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.M.isOpen()) {
            this.M.closeSearch();
            return;
        }
        if (this.R) {
            this.R = false;
            super.onBackPressed();
            finish();
            return;
        }
        if (this.N.size() < 200) {
            this.O.smoothScrollToPosition(0);
        } else {
            this.O.scrollToPosition(0);
        }
        this.R = true;
        this.O.clearFocus();
        this.L.requestFocus();
        Toast.makeText(getBaseContext(), "Press Back again to Exit", 0).show();
        new Handler().postDelayed(new w(this, 0), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.Q = sharedPreferences.getString("pref_drama_host", "https://kissasiantv.to");
        Typeface.createFromAsset(getAssets(), "fonts/pproduct_sans_rregular.ttf");
        new c4.a();
        setContentView(R.layout.activity_drama_search_mobile);
        this.P = new m(this.N, this, this);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.M = materialSearchView;
        materialSearchView.setShouldKeepHistory(false);
        this.M.setTintAlpha(1);
        this.M.setHint("Search for any adult video...");
        this.M.setOnQueryTextListener(new y(this));
        this.K = (RelativeLayout) findViewById(R.id.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.L = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Adult Video Search");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_categories);
        this.O = recyclerView;
        recyclerView.setAdapter(this.P);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.O.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 130)));
        this.O.addItemDecoration(new fd.d(5));
        setBackgroundColor();
        new Handler().postDelayed(new w(this, 1), 500L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adult_search_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            this.M.openSearch();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void setBackgroundColor() {
        this.S = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.S), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 8));
        valueAnimatorOfObject.start();
        this.S = 0;
    }

    @Override // gd.e
    public void openDrama(Drama drama) {
    }

    @Override // gd.e
    public void removeDramaFromFavorites(Drama drama) {
    }
}
