package flix.com.vision.tv;

import ac.y;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import c4.a;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.d;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import gd.l;
import java.util.ArrayList;
import java.util.Iterator;
import r.j;

/* loaded from: classes2.dex */
public class TVCategorySearchActivity extends j implements l {
    public MaterialSearchView K;
    public SuperRecyclerView L;
    public y M;
    public ArrayList<TVCategory> N;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.K.isOpen()) {
            this.K.closeSearch();
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new a();
        this.N = new ArrayList<>();
        setContentView(R.layout.activity_tv_category_search);
        this.M = new y(this.N, this, this);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.K = materialSearchView;
        materialSearchView.setShouldKeepHistory(false);
        this.K.setTintAlpha(1);
        this.K.setHint("Searching in all categories...");
        this.K.setOnQueryTextListener(new ae.j(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TV Genre Search");
        SuperRecyclerView superRecyclerView = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        this.L = superRecyclerView;
        superRecyclerView.setAdapter(this.M);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.L.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.L.addItemDecoration(new d(5));
        new Handler().postDelayed(new vb.d(this, 15), 500L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adult_search_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            this.K.openSearch();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.l
    public void openCategory(TVCategory tVCategory) {
        App.getInstance().f11570r.clear();
        Iterator<hd.d> it = App.getInstance().f11569q.iterator();
        while (it.hasNext()) {
            hd.d next = it.next();
            if (next.f12987t.equalsIgnoreCase(tVCategory.getCategoryName())) {
                App.getInstance().f11570r.add(next);
            }
        }
        Intent intent = new Intent(this, (Class<?>) ChannelsListActivityImport.class);
        intent.putExtra("cat_name", tVCategory.getCategoryName());
        startActivity(intent);
    }

    @Override // gd.l
    public void onLongPress(int i10, ArrayList<TVCategory> arrayList) {
    }
}
