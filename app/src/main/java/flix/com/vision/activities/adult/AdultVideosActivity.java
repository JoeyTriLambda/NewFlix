package flix.com.vision.activities.adult;

import ac.f;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
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
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.activities.player.AdultVideoPlayerActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.tv.Constant;
import gd.b;
import gd.c;
import java.util.ArrayList;
import java.util.Locale;
import kc.d;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import ub.o0;
import ub.p0;
import vb.g;

/* loaded from: classes2.dex */
public class AdultVideosActivity extends wb.a implements c, aa.a, gd.a, b {

    /* renamed from: g0, reason: collision with root package name */
    public static final /* synthetic */ int f11889g0 = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public c4.a Q;
    public Typeface R;
    public TextView S;
    public TextView T;
    public TextView U;
    public TextView V;
    public SuperRecyclerView X;
    public f Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f11890a0;

    /* renamed from: e0, reason: collision with root package name */
    public int f11894e0;

    /* renamed from: f0, reason: collision with root package name */
    public d f11895f0;
    public final ArrayList<id.b> P = new ArrayList<>();
    public final ArrayList<id.c> W = new ArrayList<>();

    /* renamed from: b0, reason: collision with root package name */
    public int f11891b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    public int f11892c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f11893d0 = false;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11896a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<id.c> f11897b;

        public a(AdultVideosActivity adultVideosActivity) {
        }
    }

    @Override // gd.a
    public void OnStreamResolvedSuccess(ArrayList<id.b> arrayList) {
        d dVar = this.f11895f0;
        if (dVar != null) {
            try {
                dVar.dismiss();
            } catch (Exception unused) {
            }
        }
        ArrayList<id.b> arrayList2 = this.P;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        a aVar = new a(this);
        aVar.f11896a = true;
        EventBus.getDefault().post(aVar);
    }

    @Override // gd.c
    public void OnVideoListSuccess(ArrayList<id.c> arrayList) {
        a aVar = new a(this);
        aVar.f11897b = arrayList;
        aVar.f11896a = false;
        EventBus.getDefault().post(aVar);
    }

    public final void d(String str) {
        Intent intent = new Intent(this, (Class<?>) AdultVideoPlayerActivity.class);
        intent.putExtra("url", str);
        ArrayList<id.c> arrayList = this.W;
        intent.putExtra("videoUrl", arrayList.get(this.f11892c0).f13366b);
        intent.putExtra("title", arrayList.get(this.f11892c0).f13365a);
        intent.putExtra("image_url", arrayList.get(this.f11892c0).f13367c);
        startActivity(intent);
    }

    public void getVideos(int i10) {
        new od.d(this, this).process(this.Z, i10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f11893d0) {
            this.f11893d0 = false;
            super.onBackPressed();
            finish();
            return;
        }
        if (this.W.size() < 200) {
            this.X.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.X.getRecyclerView().scrollToPosition(0);
        }
        this.f11893d0 = true;
        this.K.requestFocus();
        this.X.clearFocus();
        Toast.makeText(getBaseContext(), "Press Back again to Exit", 0).show();
        new Handler().postDelayed(new g(this, 1), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    @SuppressLint({"SetTextI18n"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.R = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.Q = new c4.a();
        setContentView(R.layout.activity_adult_categories);
        this.Z = getIntent().getStringExtra("categoryUrl");
        this.f11890a0 = getIntent().getStringExtra("categoryTitle");
        this.Y = new f(this, this, this.W);
        this.O = (RelativeLayout) findViewById(R.id.history_button_adult);
        this.N = (RelativeLayout) findViewById(R.id.settings_button_adult);
        this.V = (TextView) findViewById(R.id.adult_settings_text);
        this.M = (RelativeLayout) findViewById(R.id.activity_player);
        this.T = (TextView) findViewById(R.id.adult_favorites_text);
        this.U = (TextView) findViewById(R.id.adult_search_text);
        this.L = (RelativeLayout) findViewById(R.id.favorites_button_adult);
        this.K = (RelativeLayout) findViewById(R.id.search_button_adult);
        this.X = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        TextView textView = (TextView) findViewById(R.id.adult_page_title);
        this.S = textView;
        this.Q.applyFontToView(textView, this.R);
        TextView textView2 = this.T;
        if (textView2 != null) {
            this.Q.applyFontToView(textView2, this.R);
        }
        TextView textView3 = this.U;
        if (textView3 != null) {
            this.Q.applyFontToView(textView3, this.R);
        }
        TextView textView4 = this.V;
        if (textView4 != null) {
            this.Q.applyFontToView(textView4, this.R);
        }
        final int i10 = 0;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: vb.h

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultVideosActivity f20665m;

            {
                this.f20665m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                AdultVideosActivity adultVideosActivity = this.f20665m;
                switch (i11) {
                    case 0:
                        int i12 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                    case 1:
                        int i13 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultVideosActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        int i15 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        final int i11 = 1;
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: vb.h

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultVideosActivity f20665m;

            {
                this.f20665m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                AdultVideosActivity adultVideosActivity = this.f20665m;
                switch (i112) {
                    case 0:
                        int i12 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                    case 1:
                        int i13 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultVideosActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        int i15 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        final int i12 = 2;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: vb.h

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultVideosActivity f20665m;

            {
                this.f20665m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                AdultVideosActivity adultVideosActivity = this.f20665m;
                switch (i112) {
                    case 0:
                        int i122 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                    case 1:
                        int i13 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultVideosActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        int i15 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        final int i13 = 3;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: vb.h

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultVideosActivity f20665m;

            {
                this.f20665m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                AdultVideosActivity adultVideosActivity = this.f20665m;
                switch (i112) {
                    case 0:
                        int i122 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                    case 1:
                        int i132 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultVideosActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    default:
                        int i15 = AdultVideosActivity.f11889g0;
                        adultVideosActivity.getClass();
                        adultVideosActivity.startActivity(new Intent(adultVideosActivity, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        this.X.setAdapter(this.Y);
        this.X.setLayoutManager(new CenterGridLayoutManager(this, Math.round((o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density) / (!App.getInstance().f11574v.getBoolean("pref_adult_show_big_pictures", false) ? 130 : 260))));
        this.X.addItemDecoration(new fd.d(5));
        this.X.setupMoreListener(this, 28);
        setBackgroundColor();
        new Handler().postDelayed(new g(this, 2), 1000L);
        if (getResources().getConfiguration().orientation == 2) {
            this.S.setText("AdultZone · " + this.f11890a0);
        }
        getVideos(this.f11891b0);
        new Handler().postDelayed(new g(this, 3), 5000L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(a aVar) {
        ArrayList<id.c> arrayList = this.W;
        int size = arrayList.size();
        ArrayList<id.c> arrayList2 = aVar.f11897b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList.addAll(aVar.f11897b);
            this.Y.notifyItemRangeInserted(size, aVar.f11897b.size());
            return;
        }
        if (aVar.f11896a) {
            ArrayList<id.b> arrayList3 = this.P;
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
            aVar2.setSingleChoiceItems(charSequenceArr, -1, new o0(this, arrayList3, 3));
            aVar2.setOnDismissListener(new p0(5));
            aVar2.show();
        }
    }

    @Override // aa.a
    public void onMoreAsked(int i10, int i11, int i12) {
        new Handler().postDelayed(new g(this, 0), 200L);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.b
    public void openAdultVideo(int i10) {
        this.f11892c0 = i10;
        FragmentManager fragmentManager = getFragmentManager();
        kc.d dVarNewInstance = kc.d.newInstance(this, false);
        this.f11895f0 = dVarNewInstance;
        dVarNewInstance.setloading();
        try {
            this.f11895f0.show(fragmentManager, "");
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        new od.b(this, this).process(this.W.get(i10).f13366b);
    }

    public void playAdultLink(String str) {
        int i10 = App.getInstance().f11574v.getInt("pref_adult_zone_player", 0);
        if (i10 <= 0 || i10 >= 4) {
            if (i10 != 4) {
                d(str);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.setDataAndType(Uri.parse(str), "video/mp4");
            startActivity(intent);
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
        this.f11894e0 = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.f11894e0), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 17));
        valueAnimatorOfObject.start();
        this.f11894e0 = 0;
    }
}
