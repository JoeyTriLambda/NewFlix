package flix.com.vision.activities.adult;

import ac.d;
import ae.c;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.o;
import com.google.gson.r;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.adult.AdultCategoriesActivity;
import flix.com.vision.activities.adult.AdultHistoryActivity;
import flix.com.vision.activities.adult.AdultVideosFavoritesActivity;
import flix.com.vision.activities.adult.AdultVideosSearchActivity;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.tv.Constant;
import flix.com.vision.utils.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import qe.b;
import se.f;
import wb.a;

/* loaded from: classes2.dex */
public class AdultCategoriesActivity extends a {

    /* renamed from: a0, reason: collision with root package name */
    public static final /* synthetic */ int f11887a0 = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public RelativeLayout O;
    public c4.a P;
    public Typeface Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public b U;
    public SuperRecyclerView W;
    public d X;
    public int Z;
    public final ArrayList<id.a> V = new ArrayList<>();
    public boolean Y = false;

    public final void d() throws IOException {
        String strLoadJSONFromAsset = c.loadJSONFromAsset(this);
        if (strLoadJSONFromAsset == null || strLoadJSONFromAsset.length() <= 0) {
            return;
        }
        ArrayList<id.a> adultCategories = JsonUtils.parseAdultCategories(r.parseString(strLoadJSONFromAsset).getAsJsonObject());
        if (adultCategories != null && adultCategories.size() > 0) {
            this.V.addAll(adultCategories);
        }
        this.X.notifyDataSetChanged();
    }

    public void getCategories() {
        if (this.V.size() > 0) {
            return;
        }
        b bVar = this.U;
        if (bVar != null) {
            bVar.dispose();
        }
        final int i10 = 0;
        final int i11 = 1;
        this.U = bc.a.getAdultCategories().subscribeOn(gf.a.newThread()).observeOn(pe.a.mainThread()).subscribe(new f(this) { // from class: vb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20653m;

            {
                this.f20653m = this;
            }

            @Override // se.f
            public final void accept(Object obj) throws IOException {
                int i12 = i10;
                AdultCategoriesActivity adultCategoriesActivity = this.f20653m;
                switch (i12) {
                    case 0:
                        o oVar = (o) obj;
                        int i13 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        try {
                            ArrayList<id.a> adultCategories = JsonUtils.parseAdultCategories(oVar);
                            if (adultCategories != null && adultCategories.size() > 0) {
                                adultCategoriesActivity.V.addAll(adultCategories);
                            }
                            adultCategoriesActivity.X.notifyDataSetChanged();
                            break;
                        } catch (Exception unused) {
                            adultCategoriesActivity.d();
                        }
                        break;
                    default:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        Log.d(AdultCategoriesActivity.class.toString(), "", (Throwable) obj);
                        adultCategoriesActivity.d();
                        break;
                }
            }
        }, new f(this) { // from class: vb.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20653m;

            {
                this.f20653m = this;
            }

            @Override // se.f
            public final void accept(Object obj) throws IOException {
                int i12 = i11;
                AdultCategoriesActivity adultCategoriesActivity = this.f20653m;
                switch (i12) {
                    case 0:
                        o oVar = (o) obj;
                        int i13 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        try {
                            ArrayList<id.a> adultCategories = JsonUtils.parseAdultCategories(oVar);
                            if (adultCategories != null && adultCategories.size() > 0) {
                                adultCategoriesActivity.V.addAll(adultCategories);
                            }
                            adultCategoriesActivity.X.notifyDataSetChanged();
                            break;
                        } catch (Exception unused) {
                            adultCategoriesActivity.d();
                        }
                        break;
                    default:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        Log.d(AdultCategoriesActivity.class.toString(), "", (Throwable) obj);
                        adultCategoriesActivity.d();
                        break;
                }
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.Y) {
            this.Y = false;
            super.onBackPressed();
            finish();
            return;
        }
        if (this.V.size() < 200) {
            this.W.getRecyclerView().smoothScrollToPosition(0);
        } else {
            this.W.getRecyclerView().scrollToPosition(0);
        }
        this.Y = true;
        this.K.requestFocus();
        this.W.clearFocus();
        Toast.makeText(getBaseContext(), "Press Back again to Exit", 0).show();
        new Handler().postDelayed(new vb.a(this, 1), 2000L);
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.Q = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.P = new c4.a();
        setContentView(R.layout.activity_adult_categories);
        this.X = new d(this, this.V);
        this.O = (RelativeLayout) findViewById(R.id.history_button_adult);
        this.T = (TextView) findViewById(R.id.adult_settings_text);
        this.N = (RelativeLayout) findViewById(R.id.settings_button_adult);
        this.S = (TextView) findViewById(R.id.adult_search_text);
        this.R = (TextView) findViewById(R.id.adult_favorites_text);
        this.M = (RelativeLayout) findViewById(R.id.activity_player);
        this.L = (RelativeLayout) findViewById(R.id.favorites_button_adult);
        this.K = (RelativeLayout) findViewById(R.id.search_button_adult);
        this.W = (SuperRecyclerView) findViewById(R.id.recyclerview_categories);
        this.P.applyFontToView((TextView) findViewById(R.id.adult_page_title), this.Q);
        TextView textView = this.R;
        if (textView != null) {
            this.P.applyFontToView(textView, this.Q);
        }
        TextView textView2 = this.T;
        if (textView2 != null) {
            this.P.applyFontToView(textView2, this.Q);
        }
        TextView textView3 = this.S;
        if (textView3 != null) {
            this.P.applyFontToView(textView3, this.Q);
        }
        final int i10 = 0;
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: vb.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20655m;

            {
                this.f20655m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                AdultCategoriesActivity adultCategoriesActivity = this.f20655m;
                switch (i11) {
                    case 0:
                        int i12 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    case 1:
                        int i13 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultCategoriesActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) SettingsActivity.class));
                        break;
                    default:
                        int i15 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                }
            }
        });
        final int i11 = 1;
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: vb.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20655m;

            {
                this.f20655m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                AdultCategoriesActivity adultCategoriesActivity = this.f20655m;
                switch (i112) {
                    case 0:
                        int i12 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    case 1:
                        int i13 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultCategoriesActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) SettingsActivity.class));
                        break;
                    default:
                        int i15 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                }
            }
        });
        final int i12 = 2;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: vb.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20655m;

            {
                this.f20655m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                AdultCategoriesActivity adultCategoriesActivity = this.f20655m;
                switch (i112) {
                    case 0:
                        int i122 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    case 1:
                        int i13 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultCategoriesActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) SettingsActivity.class));
                        break;
                    default:
                        int i15 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                }
            }
        });
        final int i13 = 3;
        this.O.setOnClickListener(new View.OnClickListener(this) { // from class: vb.c

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ AdultCategoriesActivity f20655m;

            {
                this.f20655m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i13;
                AdultCategoriesActivity adultCategoriesActivity = this.f20655m;
                switch (i112) {
                    case 0:
                        int i122 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosSearchActivity.class));
                        break;
                    case 1:
                        int i132 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        if (App.getInstance().f11573u.getAdultVideosFromDb().size() != 0) {
                            adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultVideosFavoritesActivity.class));
                            break;
                        } else {
                            Toast.makeText(adultCategoriesActivity.getBaseContext(), "Long press on Video to add to your favorites", 1).show();
                            break;
                        }
                    case 2:
                        int i14 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) SettingsActivity.class));
                        break;
                    default:
                        int i15 = AdultCategoriesActivity.f11887a0;
                        adultCategoriesActivity.getClass();
                        adultCategoriesActivity.startActivity(new Intent(adultCategoriesActivity, (Class<?>) AdultHistoryActivity.class));
                        break;
                }
            }
        });
        this.W.setAdapter(this.X);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.W.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 200)));
        this.W.addItemDecoration(new fd.d(5));
        setBackgroundColor();
        getCategories();
        new Handler().postDelayed(new vb.a(this, 0), 1000L);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(ArrayList<id.a> arrayList) {
        this.V.addAll(arrayList);
        this.X.notifyDataSetChanged();
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void openCategory(int i10) {
        Intent intent = new Intent(this, (Class<?>) AdultVideosActivity.class);
        ArrayList<id.a> arrayList = this.V;
        intent.putExtra("categoryUrl", arrayList.get(i10).f13362c);
        intent.putExtra("categoryTitle", arrayList.get(i10).f13360a);
        startActivity(intent);
    }

    public void setBackgroundColor() {
        this.Z = 2505092;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(this.Z), 0);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 15));
        valueAnimatorOfObject.start();
        this.Z = 0;
    }
}
