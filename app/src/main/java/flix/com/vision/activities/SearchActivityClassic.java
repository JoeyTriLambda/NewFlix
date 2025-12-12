package flix.com.vision.activities;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import flix.com.vision.R;
import flix.com.vision.materialsearchview.MaterialSearchView;
import ub.o1;
import ub.p1;

/* loaded from: classes2.dex */
public class SearchActivityClassic extends wb.a {
    public static final /* synthetic */ int O = 0;
    public RelativeLayout K;
    public MaterialSearchView L;
    public final String M = "";
    public int N;

    public static boolean isTV() {
        return Build.MODEL.contains("AFT");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.L.isOpen()) {
            this.L.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_search_classic);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.L = materialSearchView;
        materialSearchView.setShouldKeepHistory(false);
        this.L.setTintAlpha(1);
        this.L.setHint("Movies, TV Shows, People...");
        this.L.setOnQueryTextListener(new p1(this));
        this.K = (RelativeLayout) findViewById(R.id.activity_player);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search");
        setBackgroundColor();
        new Handler().postDelayed(new o1(this, 0), 500L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu_classic, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_search) {
            this.L.openSearch();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(new o1(this, 1), 500L);
    }

    public void setBackgroundColor() {
        this.N = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.N), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 13));
        valueAnimatorOfObject.start();
        this.N = 0;
    }
}
