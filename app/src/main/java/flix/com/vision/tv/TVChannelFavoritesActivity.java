package flix.com.vision.tv;

import ac.k;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
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
import hd.d;
import java.util.ArrayList;
import r.j;

/* loaded from: classes2.dex */
public class TVChannelFavoritesActivity extends j {
    public SuperRecyclerView K;
    public k L;
    public ArrayList<d> M;
    public AlphaAnimation N;
    public Handler O;
    public vb.d P;
    public TextView Q;
    public RelativeLayout R;

    public void ToastChannel(String str) {
        RelativeLayout relativeLayout = this.R;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setAlpha(1.0f);
        this.O.removeCallbacks(this.P);
        this.O.postDelayed(this.P, 2000L);
        this.Q.setText(str);
        this.R.setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new a();
        this.M = new ArrayList<>();
        setContentView(R.layout.activity_tv_channels_search_import);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        try {
            getSupportActionBar().setTitle("FAVORITES");
        } catch (Exception unused) {
        }
        this.K = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.K.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.K.addItemDecoration(new fd.d(5));
        this.M.addAll(App.getInstance().f11573u.getFavoritesChannels());
        k kVar = new k(this, this.M, this, 1, 100);
        this.L = kVar;
        this.K.setAdapter(kVar);
        this.L.notifyDataSetChanged();
        if (App.K) {
            this.R = (RelativeLayout) findViewById(R.id.toast_view);
            this.N = new AlphaAnimation(1.0f, 0.0f);
            this.Q = (TextView) findViewById(R.id.customToastText);
            this.O = new Handler();
            this.P = new vb.d(this, 16);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adult_search_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
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
