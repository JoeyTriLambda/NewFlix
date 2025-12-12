package flix.com.vision.tv;

import ac.k;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import fd.c;
import fd.h;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.SettingsActivity;
import flix.com.vision.activities.player.PlayerActivityLiveTV;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.helpers.CenterLayoutManager;
import flix.com.vision.tv.ChannelsListActivityImport;
import flix.com.vision.tv.TVChannelFavoritesActivity;
import flix.com.vision.tv.TVChannelSearchActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import vb.d;
import wb.a;

/* loaded from: classes2.dex */
public class ChannelsListActivityImport extends a {

    /* renamed from: h0, reason: collision with root package name */
    public static final /* synthetic */ int f12442h0 = 0;
    public RelativeLayout L;
    public RelativeLayout M;
    public RelativeLayout N;
    public c4.a O;
    public Typeface P;
    public TextView Q;
    public TextView R;
    public TextView S;
    public TextView T;
    public LinearLayout U;
    public LinearLayout V;
    public k W;
    public k X;
    public RecyclerView Y;
    public RecyclerView Z;

    /* renamed from: a0, reason: collision with root package name */
    public AlphaAnimation f12443a0;

    /* renamed from: d0, reason: collision with root package name */
    public Handler f12446d0;

    /* renamed from: e0, reason: collision with root package name */
    public d f12447e0;

    /* renamed from: f0, reason: collision with root package name */
    public TextView f12448f0;

    /* renamed from: g0, reason: collision with root package name */
    public RelativeLayout f12449g0;
    public HashSet<String> K = new HashSet<>();

    /* renamed from: b0, reason: collision with root package name */
    public final ArrayList<hd.d> f12444b0 = new ArrayList<>();

    /* renamed from: c0, reason: collision with root package name */
    public String f12445c0 = "";

    public void ToastChannel(String str) {
        RelativeLayout relativeLayout = this.f12449g0;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setAlpha(1.0f);
        this.f12446d0.removeCallbacks(this.f12447e0);
        this.f12446d0.postDelayed(this.f12447e0, 2000L);
        this.f12448f0.setText(str);
        this.f12449g0.setVisibility(0);
    }

    public void channelLongPress(int i10, ArrayList<hd.d> arrayList) {
        final hd.d dVar = arrayList.get(i10);
        final int i11 = 1;
        if (this.K.contains(dVar.f12984q)) {
            FragmentManager fragmentManager = getFragmentManager();
            kc.d dVarNewInstance = kc.d.newInstance(this, true);
            dVarNewInstance.setTitle(dVar.f12984q);
            dVarNewInstance.setMessage("What would you like to Do?");
            final int i12 = 0;
            dVarNewInstance.setButton1("REMOVE FAVORITE", new View.OnClickListener(this) { // from class: ae.b

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ ChannelsListActivityImport f637m;

                {
                    this.f637m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i12;
                    hd.d dVar2 = dVar;
                    ChannelsListActivityImport channelsListActivityImport = this.f637m;
                    switch (i13) {
                        case 0:
                            int i14 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.getClass();
                            be.d.makeToast(channelsListActivityImport, "Removed From Favorites", true);
                            channelsListActivityImport.K.remove(dVar2.f12984q);
                            App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                            channelsListActivityImport.updateFavoritesBar();
                            break;
                        case 1:
                            int i15 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.playChannel(dVar2);
                            break;
                        case 2:
                            int i16 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.getClass();
                            be.d.makeToast(channelsListActivityImport, "Added To Favorites", true);
                            channelsListActivityImport.K.add(dVar2.f12984q);
                            App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                            channelsListActivityImport.updateFavoritesBar();
                            break;
                        default:
                            int i17 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.playChannel(dVar2);
                            break;
                    }
                }
            });
            dVarNewInstance.setButton2("PLAY", new View.OnClickListener(this) { // from class: ae.b

                /* renamed from: m, reason: collision with root package name */
                public final /* synthetic */ ChannelsListActivityImport f637m;

                {
                    this.f637m = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i13 = i11;
                    hd.d dVar2 = dVar;
                    ChannelsListActivityImport channelsListActivityImport = this.f637m;
                    switch (i13) {
                        case 0:
                            int i14 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.getClass();
                            be.d.makeToast(channelsListActivityImport, "Removed From Favorites", true);
                            channelsListActivityImport.K.remove(dVar2.f12984q);
                            App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                            channelsListActivityImport.updateFavoritesBar();
                            break;
                        case 1:
                            int i15 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.playChannel(dVar2);
                            break;
                        case 2:
                            int i16 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.getClass();
                            be.d.makeToast(channelsListActivityImport, "Added To Favorites", true);
                            channelsListActivityImport.K.add(dVar2.f12984q);
                            App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                            channelsListActivityImport.updateFavoritesBar();
                            break;
                        default:
                            int i17 = ChannelsListActivityImport.f12442h0;
                            channelsListActivityImport.playChannel(dVar2);
                            break;
                    }
                }
            });
            try {
                dVarNewInstance.show(fragmentManager, "");
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        FragmentManager fragmentManager2 = getFragmentManager();
        kc.d dVarNewInstance2 = kc.d.newInstance(this, true);
        dVarNewInstance2.setTitle(dVar.f12984q);
        dVarNewInstance2.setMessage("What would you like to Do?");
        final int i13 = 2;
        dVarNewInstance2.setButton1("ADD TO FAVORITES", new View.OnClickListener(this) { // from class: ae.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ChannelsListActivityImport f637m;

            {
                this.f637m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i13;
                hd.d dVar2 = dVar;
                ChannelsListActivityImport channelsListActivityImport = this.f637m;
                switch (i132) {
                    case 0:
                        int i14 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        be.d.makeToast(channelsListActivityImport, "Removed From Favorites", true);
                        channelsListActivityImport.K.remove(dVar2.f12984q);
                        App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                        channelsListActivityImport.updateFavoritesBar();
                        break;
                    case 1:
                        int i15 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.playChannel(dVar2);
                        break;
                    case 2:
                        int i16 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        be.d.makeToast(channelsListActivityImport, "Added To Favorites", true);
                        channelsListActivityImport.K.add(dVar2.f12984q);
                        App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                        channelsListActivityImport.updateFavoritesBar();
                        break;
                    default:
                        int i17 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.playChannel(dVar2);
                        break;
                }
            }
        });
        final int i14 = 3;
        dVarNewInstance2.setButton2("PLAY", new View.OnClickListener(this) { // from class: ae.b

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ChannelsListActivityImport f637m;

            {
                this.f637m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i132 = i14;
                hd.d dVar2 = dVar;
                ChannelsListActivityImport channelsListActivityImport = this.f637m;
                switch (i132) {
                    case 0:
                        int i142 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        be.d.makeToast(channelsListActivityImport, "Removed From Favorites", true);
                        channelsListActivityImport.K.remove(dVar2.f12984q);
                        App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                        channelsListActivityImport.updateFavoritesBar();
                        break;
                    case 1:
                        int i15 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.playChannel(dVar2);
                        break;
                    case 2:
                        int i16 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        be.d.makeToast(channelsListActivityImport, "Added To Favorites", true);
                        channelsListActivityImport.K.add(dVar2.f12984q);
                        App.getInstance().f11574v.edit().putStringSet("pref_tv_channel_fav_" + channelsListActivityImport.f12445c0, channelsListActivityImport.K).apply();
                        channelsListActivityImport.updateFavoritesBar();
                        break;
                    default:
                        int i17 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.playChannel(dVar2);
                        break;
                }
            }
        });
        try {
            dVarNewInstance2.show(fragmentManager2, "");
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.Z.hasFocus()) {
            super.onBackPressed();
        } else {
            this.Z.requestFocus();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.channel_list_activity_import);
        this.f12445c0 = getIntent().getStringExtra("cat_name");
        this.K = new HashSet<>(App.getInstance().f11574v.getStringSet("pref_tv_channel_fav_" + this.f12445c0, new HashSet()));
        AssetManager assets = getAssets();
        String str = Constant.f12450b;
        this.P = Typeface.createFromAsset(assets, "fonts/product_sans_bold.ttf");
        this.O = new c4.a();
        this.Z = (RecyclerView) findViewById(R.id.recyclerview_tv_channels_favorites);
        this.V = (LinearLayout) findViewById(R.id.tv_favorites_channels_layout);
        this.T = (TextView) findViewById(R.id.adult_settings_text);
        this.N = (RelativeLayout) findViewById(R.id.settings_button_adult);
        this.S = (TextView) findViewById(R.id.adult_search_text);
        this.R = (TextView) findViewById(R.id.adult_favorites_text);
        this.M = (RelativeLayout) findViewById(R.id.favorites_button_adult);
        this.L = (RelativeLayout) findViewById(R.id.search_button_adult);
        this.Y = (RecyclerView) findViewById(R.id.recyclerview);
        this.U = (LinearLayout) findViewById(R.id.loader);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.Y.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.Y.addItemDecoration(new fd.d(5));
        k kVar = new k(getBaseContext(), App.getInstance().f11570r, this, 8989, 100);
        this.W = kVar;
        kVar.setImportActivity(this);
        this.Y.setAdapter(this.W);
        k kVar2 = new k(getBaseContext(), this.f12444b0, this, 8989, 100);
        this.X = kVar2;
        kVar2.setImportActivity(this);
        this.Y.setAdapter(this.W);
        final int i10 = 0;
        this.Z.setLayoutManager(new CenterLayoutManager(this, 0, false));
        this.Z.setAdapter(this.X);
        this.Z.addItemDecoration(new c(15));
        TextView textView = (TextView) findViewById(R.id.adult_page_title);
        this.Q = textView;
        this.O.applyFontToView(textView, this.P);
        TextView textView2 = this.R;
        if (textView2 != null) {
            this.O.applyFontToView(textView2, this.P);
        }
        TextView textView3 = this.T;
        if (textView3 != null) {
            this.O.applyFontToView(textView3, this.P);
        }
        TextView textView4 = this.S;
        if (textView4 != null) {
            this.O.applyFontToView(textView4, this.P);
        }
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: ae.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ChannelsListActivityImport f635m;

            {
                this.f635m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                ChannelsListActivityImport channelsListActivityImport = this.f635m;
                switch (i11) {
                    case 0:
                        int i12 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelSearchActivity.class));
                        break;
                    case 1:
                        int i13 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelFavoritesActivity.class));
                        break;
                    default:
                        int i14 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        final int i11 = 1;
        this.M.setOnClickListener(new View.OnClickListener(this) { // from class: ae.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ChannelsListActivityImport f635m;

            {
                this.f635m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                ChannelsListActivityImport channelsListActivityImport = this.f635m;
                switch (i112) {
                    case 0:
                        int i12 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelSearchActivity.class));
                        break;
                    case 1:
                        int i13 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelFavoritesActivity.class));
                        break;
                    default:
                        int i14 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        final int i12 = 2;
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ae.a

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ ChannelsListActivityImport f635m;

            {
                this.f635m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i12;
                ChannelsListActivityImport channelsListActivityImport = this.f635m;
                switch (i112) {
                    case 0:
                        int i122 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelSearchActivity.class));
                        break;
                    case 1:
                        int i13 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) TVChannelFavoritesActivity.class));
                        break;
                    default:
                        int i14 = ChannelsListActivityImport.f12442h0;
                        channelsListActivityImport.getClass();
                        channelsListActivityImport.startActivity(new Intent(channelsListActivityImport, (Class<?>) SettingsActivity.class));
                        break;
                }
            }
        });
        this.W.notifyDataSetChanged();
        updateFavoritesBar();
        this.N.clearFocus();
        this.L.clearFocus();
        this.Y.requestFocus();
        if (!App.getInstance().f11574v.getBoolean("hint_tv_channels_shown", false)) {
            be.d.makeToast(this, "You can long press on a Channel to pin it at the top of the list", true);
            o1.a.j(App.getInstance().f11574v, "hint_tv_channels_shown", true);
        }
        if (App.K) {
            this.f12449g0 = (RelativeLayout) findViewById(R.id.toast_view);
            this.f12443a0 = new AlphaAnimation(1.0f, 0.0f);
            this.f12448f0 = (TextView) findViewById(R.id.customToastText);
            this.f12446d0 = new Handler();
            this.f12447e0 = new d(this, 13);
        }
        getIntent().getStringExtra("url");
        getIntent().getStringExtra("label");
        this.U.setVisibility(8);
        this.Q.setText(this.f12445c0 + " · " + App.getInstance().f11570r.size());
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void playChannel(hd.d dVar) {
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

    public void updateFavoritesBar() {
        ArrayList<hd.d> arrayList = this.f12444b0;
        try {
            arrayList.clear();
            Iterator<hd.d> it = App.getInstance().f11570r.iterator();
            while (it.hasNext()) {
                hd.d next = it.next();
                if (this.K.contains(next.f12984q)) {
                    arrayList.add(next);
                }
            }
            Collections.reverse(arrayList);
            if (arrayList.isEmpty()) {
                this.V.setVisibility(8);
            } else {
                this.V.setVisibility(0);
                this.X.notifyDataSetChanged();
            }
        } catch (Exception e10) {
            be.d.makeToast(this, "ERROR: " + e10.getMessage(), false);
        }
    }
}
