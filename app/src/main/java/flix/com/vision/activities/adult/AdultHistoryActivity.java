package flix.com.vision.activities.adult;

import ac.f;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.SQLException;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import fd.h;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.tv.Constant;
import gd.b;
import id.c;
import java.util.ArrayList;
import java.util.Locale;
import kc.d;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import ub.o0;
import ub.p0;
import ub.u;
import ub.v;

/* loaded from: classes2.dex */
public class AdultHistoryActivity extends wb.a implements gd.a, b {
    public static final /* synthetic */ int X = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public c4.a O;
    public Typeface P;
    public TextView Q;
    public SuperRecyclerView S;
    public f T;
    public int V;
    public d W;
    public final ArrayList<id.b> N = new ArrayList<>();
    public final ArrayList<c> R = new ArrayList<>();
    public int U = 0;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11888a;

        public a(AdultHistoryActivity adultHistoryActivity) {
        }
    }

    @Override // gd.a
    public void OnStreamResolvedSuccess(ArrayList<id.b> arrayList) {
        d dVar = this.W;
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
        aVar.f11888a = true;
        EventBus.getDefault().post(aVar);
    }

    public final void d(String str) {
        Intent intent = new Intent(this, (Class<?>) AdultVideoPlayerActivity.class);
        intent.putExtra("url", str);
        ArrayList<c> arrayList = this.R;
        intent.putExtra("videoUrl", arrayList.get(this.U).f13366b);
        intent.putExtra("title", arrayList.get(this.U).f13365a);
        intent.putExtra("image_url", arrayList.get(this.U).f13367c);
        startActivity(intent);
    }

    public void getVideos() {
        ArrayList<c> adultHistoryFromDb = App.getInstance().f11573u.getAdultHistoryFromDb();
        if (adultHistoryFromDb != null && adultHistoryFromDb.size() > 0) {
            ArrayList<c> arrayList = this.R;
            arrayList.clear();
            arrayList.addAll(adultHistoryFromDb);
        }
        this.T.notifyDataSetChanged();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.P = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.O = new c4.a();
        setContentView(R.layout.activity_adult_history);
        this.T = new f(this, this, this.R);
        this.M = (RelativeLayout) findViewById(R.id.button_adult_clear_history);
        this.L = (RelativeLayout) findViewById(R.id.activity_player);
        this.Q = (TextView) findViewById(R.id.adult_search_text_fav);
        this.K = (RelativeLayout) findViewById(R.id.search_button_adult);
        this.S = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        this.O.applyFontToView((TextView) findViewById(R.id.adult_page_title), this.P);
        this.O.applyFontToView(this.Q, this.P);
        final int i10 = 0;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: vb.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultHistoryActivity f20659m;

            {
                this.f20659m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws SQLException {
                int i11 = i10;
                AdultHistoryActivity adultHistoryActivity = this.f20659m;
                switch (i11) {
                    case 0:
                        int i12 = AdultHistoryActivity.X;
                        adultHistoryActivity.getClass();
                        adultHistoryActivity.startActivity(new Intent(adultHistoryActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        adultHistoryActivity.R.clear();
                        adultHistoryActivity.T.notifyDataSetChanged();
                        App.getInstance().f11573u.clearHistoryAdult();
                        adultHistoryActivity.finish();
                        break;
                }
            }
        });
        final int i11 = 1;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: vb.e

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultHistoryActivity f20659m;

            {
                this.f20659m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws SQLException {
                int i112 = i11;
                AdultHistoryActivity adultHistoryActivity = this.f20659m;
                switch (i112) {
                    case 0:
                        int i12 = AdultHistoryActivity.X;
                        adultHistoryActivity.getClass();
                        adultHistoryActivity.startActivity(new Intent(adultHistoryActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        adultHistoryActivity.R.clear();
                        adultHistoryActivity.T.notifyDataSetChanged();
                        App.getInstance().f11573u.clearHistoryAdult();
                        adultHistoryActivity.finish();
                        break;
                }
            }
        });
        this.S.setAdapter(this.T);
        this.S.setLayoutManager(new CenterGridLayoutManager(this, Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / (!App.getInstance().f11574v.getBoolean("pref_adult_show_big_pictures", false) ? 130 : 260))));
        this.S.addItemDecoration(new fd.d(5));
        new Handler().postDelayed(new vb.d(this, 0), 1000L);
        setBackgroundColor();
        getVideos();
    }

    public void onHistoryLongPress(int i10) {
        c cVar = this.R.get(i10);
        FragmentManager fragmentManager = getFragmentManager();
        d dVarNewInstance = d.newInstance(this, true);
        dVarNewInstance.setTitle(cVar.f13365a);
        dVarNewInstance.setMessage("What would you like to Do?");
        dVarNewInstance.setButton1("DELETE FROM HISTORY", new u(this, cVar, i10, 3));
        dVarNewInstance.setButton2("ADD TO FAVORITES", new v(5, this, cVar));
        try {
            dVarNewInstance.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        this.R.size();
        aVar.getClass();
        if (aVar.f11888a) {
            ArrayList<id.b> arrayList = this.N;
            if (App.getInstance().f11574v.getBoolean("pref_adult_zone_always_play_best", true) && arrayList.size() > 0) {
                playAdultLink(arrayList.get(0).f13364m);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                arrayList2.add(arrayList.get(i10).f13363b.toUpperCase(Locale.ROOT));
            }
            CharSequence[] charSequenceArr = (CharSequence[]) arrayList2.toArray(new CharSequence[arrayList2.size()]);
            d.a aVar2 = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
            aVar2.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList, 2));
            aVar2.setOnDismissListener(new p0(4));
            aVar2.show();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        getVideos();
    }

    @Override // gd.b
    public void openAdultVideo(int i10) {
        this.U = i10;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        this.W = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.W.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new od.b(this, this).process(this.R.get(i10).f13366b);
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
        this.V = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.V), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 16));
        valueAnimatorOfObject.start();
        this.V = 0;
    }
}
