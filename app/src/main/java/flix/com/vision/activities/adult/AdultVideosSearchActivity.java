package flix.com.vision.activities.adult;

import ac.f;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.h;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import flix.com.vision.tv.Constant;
import gd.b;
import gd.c;
import java.util.ArrayList;
import java.util.Locale;
import kc.d;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import ub.o0;
import ub.p0;
import vb.i;
import vb.j;

/* loaded from: classes2.dex */
public class AdultVideosSearchActivity extends wb.a implements c, aa.a, gd.a, b {
    public static final /* synthetic */ int Z = 0;
    public RelativeLayout K;
    public Toolbar L;
    public MaterialSearchView M;
    public SuperRecyclerView P;
    public f Q;
    public String R;
    public int X;
    public d Y;
    public final ArrayList<id.b> N = new ArrayList<>();
    public final ArrayList<id.c> O = new ArrayList<>();
    public String S = "https://www.xvideos.com/?k=";
    public int T = 0;
    public String U = "";
    public int V = 0;
    public boolean W = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11899a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<id.c> f11900b;

        public a(AdultVideosSearchActivity adultVideosSearchActivity) {
        }
    }

    @Override // gd.a
    public void OnStreamResolvedSuccess(ArrayList<id.b> arrayList) {
        d dVar = this.Y;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        ArrayList<id.b> arrayList2 = this.N;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        a aVar = new a(this);
        aVar.f11899a = true;
        EventBus.getDefault().post(aVar);
    }

    @Override // gd.c
    public void OnVideoListSuccess(ArrayList<id.c> arrayList) {
        d dVar = this.Y;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        a aVar = new a(this);
        aVar.f11900b = arrayList;
        aVar.f11899a = false;
        EventBus.getDefault().post(aVar);
    }

    public final void d(String str) {
        Intent intent = new Intent(this, (Class<?>) AdultVideoPlayerActivity.class);
        intent.putExtra("url", str);
        ArrayList<id.c> arrayList = this.O;
        intent.putExtra("videoUrl", arrayList.get(this.V).f13366b);
        intent.putExtra("title", arrayList.get(this.V).f13365a);
        intent.putExtra("image_url", arrayList.get(this.V).f13367c);
        startActivity(intent);
    }

    public void getVideos(int i10) {
        this.R = this.S + this.U.replace(StringUtils.SPACE, "+") + "&p=" + i10;
        new od.d(this, this).process(this.R, i10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.M.isOpen()) {
            this.M.closeSearch();
            return;
        }
        if (this.W) {
            this.W = false;
            super.onBackPressed();
            finish();
            return;
        }
        if (this.O.size() < 200) {
            this.P.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.P.getRecyclerView().scrollToPosition(0);
        }
        this.W = true;
        this.P.clearFocus();
        this.L.requestFocus();
        Toast.makeText(getBaseContext(), "Press Back again to Exit", 0).show();
        new Handler().postDelayed(new i(this, 2), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.S = "https://www.xvideos.com/?k=";
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        Typeface.createFromAsset(assets, "fonts/pproduct_sans_rregular.ttf");
        new c4.a();
        setContentView(R.layout.activity_adult_search);
        this.Q = new f(this, this, this.O);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.M = materialSearchView;
        materialSearchView.setShouldKeepHistory(false);
        this.M.setTintAlpha(1);
        this.M.setHint("Search for any adult video...");
        this.M.setOnQueryTextListener(new j(this));
        this.K = (RelativeLayout) findViewById(R.id.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.L = toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Adult Video Search");
        SuperRecyclerView superRecyclerView = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        this.P = superRecyclerView;
        superRecyclerView.setAdapter(this.Q);
        this.P.setLayoutManager(new CenterGridLayoutManager(this, Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / (!App.getInstance().f11574v.getBoolean("pref_adult_show_big_pictures", false) ? 130 : 260))));
        this.P.addItemDecoration(new fd.d(5));
        this.P.setupMoreListener(this, 28);
        setBackgroundColor();
        new Handler().postDelayed(new i(this, 1), 500L);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adult_search_menu, menu);
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        ArrayList<id.c> arrayList = this.O;
        int size = arrayList.size();
        ArrayList<id.c> arrayList2 = aVar.f11900b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList.addAll(aVar.f11900b);
            this.Q.notifyItemRangeInserted(size, aVar.f11900b.size());
            return;
        }
        if (aVar.f11899a) {
            ArrayList<id.b> arrayList3 = this.N;
            if (App.getInstance().f11574v.getBoolean("pref_adult_zone_always_play_best", true) && arrayList3.size() > 0) {
                playAdultLink(arrayList3.get(0).f13364m);
                return;
            }
            ArrayList arrayList4 = new ArrayList();
            for (int i10 = 0; i10 < arrayList3.size(); i10++) {
                arrayList4.add(arrayList3.get(i10).f13363b.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList4.toArray(new CharSequence[arrayList4.size()]);
            d.a aVar2 = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            aVar2.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList3, 5));
            aVar2.setOnDismissListener(new p0(7));
            aVar2.show();
        }
    }

    @Override // aa.a
    public void onMoreAsked(int i10, int i11, int i12) {
        new Handler().postDelayed(new i(this, 0), 200L);
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

    @Override // gd.b
    public void openAdultVideo(int i10) {
        this.V = i10;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        this.Y = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.Y.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new od.b(this, this).process(this.O.get(i10).f13366b);
    }

    public void playAdultLink(String str) {
        int i10 = App.getInstance().f11574v.getInt("pref_adult_zone_player", 0);
        if (i10 <= 0) {
            d(str);
            return;
        }
        try {
            if (i10 == 1) {
                h.PlayMXPlayer(this, null, str, null, null, -1);
            } else if (i10 == 2) {
                h.PlayVLC(this, null, str, null, null, -1);
            } else if (i10 != 3) {
            } else {
                h.PlayXPlayer(this, null, str);
            }
        } catch (Exception unused) {
            Toast.makeText(getBaseContext(), "Failed to load external Player, Make sure it is installed", 1).show();
            d(str);
        }
    }

    public void setBackgroundColor() {
        this.X = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.X), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 19));
        valueAnimatorOfObject.start();
        this.X = 0;
    }
}
