package flix.com.vision.tv;

import ac.k;
import ae.l;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import c4.a;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.h;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.PlayerActivityLiveTV;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.tv.TVChannelSearchActivity;
import hd.d;
import java.util.ArrayList;
import r.j;

/* loaded from: classes2.dex */
public class TVChannelSearchActivity extends j {
    public MaterialSearchView K;
    public SuperRecyclerView L;
    public k M;
    public ArrayList<d> N;
    public AlphaAnimation O;
    public ProgressDialog P;
    public Handler Q;
    public ae.k R;
    public TextView S;
    public RelativeLayout T;

    public void ToastChannel(String str) {
        RelativeLayout relativeLayout = this.T;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setAlpha(1.0f);
        this.Q.removeCallbacks(this.R);
        this.Q.postDelayed(this.R, 2000L);
        this.S.setText(str);
        this.T.setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.K.isOpen()) {
            this.K.closeSearch();
        } else {
            super.onBackPressed();
            finish();
        }
    }

    /* JADX WARN: Type inference failed for: r7v43, types: [ae.k] */
    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new a();
        this.N = new ArrayList<>();
        setContentView(R.layout.activity_tv_channels_search_import);
        this.M = new k(this, this.N, this, 1, 100);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.K = materialSearchView;
        final int i10 = 0;
        materialSearchView.setShouldKeepHistory(false);
        final int i11 = 1;
        this.K.setTintAlpha(1);
        this.K.setHint("Search in all channels...");
        this.K.setOnQueryTextListener(new l(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TV Channel Search");
        SuperRecyclerView superRecyclerView = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        this.L = superRecyclerView;
        superRecyclerView.setAdapter(this.M);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.L.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.L.addItemDecoration(new fd.d(5));
        if (App.K) {
            this.T = (RelativeLayout) findViewById(R.id.toast_view);
            this.O = new AlphaAnimation(1.0f, 0.0f);
            this.S = (TextView) findViewById(R.id.customToastText);
            this.Q = new Handler();
            this.R = new Runnable(this) { // from class: ae.k

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ TVChannelSearchActivity f657m;

                {
                    this.f657m = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    int i12 = i10;
                    TVChannelSearchActivity tVChannelSearchActivity = this.f657m;
                    switch (i12) {
                        case 0:
                            tVChannelSearchActivity.O.setInterpolator(new AccelerateInterpolator());
                            tVChannelSearchActivity.O.setDuration(500L);
                            tVChannelSearchActivity.T.startAnimation(tVChannelSearchActivity.O);
                            tVChannelSearchActivity.T.setVisibility(8);
                            break;
                        default:
                            tVChannelSearchActivity.K.openSearch();
                            break;
                    }
                }
            };
        }
        new Handler().postDelayed(new Runnable(this) { // from class: ae.k

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TVChannelSearchActivity f657m;

            {
                this.f657m = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i12 = i11;
                TVChannelSearchActivity tVChannelSearchActivity = this.f657m;
                switch (i12) {
                    case 0:
                        tVChannelSearchActivity.O.setInterpolator(new AccelerateInterpolator());
                        tVChannelSearchActivity.O.setDuration(500L);
                        tVChannelSearchActivity.T.startAnimation(tVChannelSearchActivity.O);
                        tVChannelSearchActivity.T.setVisibility(8);
                        break;
                    default:
                        tVChannelSearchActivity.K.openSearch();
                        break;
                }
            }
        }, 500L);
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

    public void playChannel(d dVar) {
        if (App.getInstance().f11574v.getInt("player_index", 0) == 0) {
            try {
                Intent intent = new Intent(this, (Class<?>) PlayerActivityLiveTV.class);
                intent.putExtra("channel", dVar);
                startActivity(intent);
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        hd.k kVar = new hd.k();
        kVar.f13027u = dVar.f12983p;
        try {
            if (App.getInstance().f11574v.getInt("player_index", 0) == 1) {
                h.PlayMXPlayer(this, dVar.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n, -1);
            } else if (App.getInstance().f11574v.getInt("player_index", 0) == 2) {
                h.PlayVLC(this, dVar.f12984q, kVar.f13027u, kVar.f13021o, kVar.f13020n, -1);
            } else if (App.getInstance().f11574v.getInt("player_index", 0) == 3) {
                h.PlayXPlayer(this, dVar.f12984q, kVar.f13027u);
            }
        } catch (Exception unused) {
            Toast.makeText(getBaseContext(), "Failed to load channel", 0).show();
        }
    }
}
