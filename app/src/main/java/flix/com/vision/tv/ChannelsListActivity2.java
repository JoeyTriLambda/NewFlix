package flix.com.vision.tv;

import ac.k;
import ae.c;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.d;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.helpers.CenterGridLayoutManager;
import flix.com.vision.materialsearchview.MaterialSearchView;
import hd.d;
import java.util.ArrayList;
import java.util.Iterator;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import ub.o0;
import ub.p0;

/* loaded from: classes2.dex */
public class ChannelsListActivity2 extends wb.a {
    public static final /* synthetic */ int U = 0;
    public MaterialSearchView K;
    public ProgressBar L;
    public k M;
    public RecyclerView P;
    public Menu S;
    public final ArrayList<d> N = new ArrayList<>();
    public final ArrayList<d> O = new ArrayList<>();
    public String Q = "";
    public String R = "";
    public boolean T = false;

    public class a implements MaterialSearchView.OnQueryTextListener {
        public a() {
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextChange(String str) {
            ChannelsListActivity2 channelsListActivity2 = ChannelsListActivity2.this;
            if (channelsListActivity2.O.size() == 0) {
                return false;
            }
            if (str.trim().isEmpty()) {
                channelsListActivity2.N.clear();
                channelsListActivity2.N.addAll(channelsListActivity2.O);
                channelsListActivity2.M.notifyDataSetChanged();
                return true;
            }
            channelsListActivity2.N.clear();
            Iterator<d> it = channelsListActivity2.O.iterator();
            while (it.hasNext()) {
                d next = it.next();
                if (next.f12984q.toLowerCase().contains(str.toLowerCase())) {
                    channelsListActivity2.N.add(next);
                }
            }
            channelsListActivity2.M.notifyDataSetChanged();
            return false;
        }

        @Override // flix.com.vision.materialsearchview.MaterialSearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String str) {
            return false;
        }
    }

    public void OpenChannel(d dVar) {
        if (dVar.f12989v.size() <= 1) {
            OpenChannell(dVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            ArrayList<hd.k> arrayList2 = dVar.f12989v;
            if (i10 >= arrayList2.size()) {
                CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]);
                d.a aVar = new d.a(new ContextThemeWrapper(this, R.style.AlertDialogCustom));
                aVar.setSingleChoiceItems(charSequenceArr, -1, new o0(this, dVar, 8));
                aVar.setOnDismissListener(new p0(11));
                aVar.show();
                return;
            }
            arrayList.add(arrayList2.get(i10).f13029w);
            i10++;
        }
    }

    public void OpenChannell(hd.d dVar) {
        Intent intent = new Intent(this, (Class<?>) PlayerActivityLiveExtended.class);
        if (App.getInstance().f11574v.getInt("player_index", 0) != 0) {
            intent = new Intent(this, (Class<?>) PlayerActivityLiveExternal.class);
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        int i10 = App.getInstance().f11574v.getInt("player_index", 0) != 0 ? 2 : 1000;
        ArrayList<hd.d> arrayList2 = this.N;
        if (arrayList2.size() > i10) {
            for (int i11 = 0; i11 < i10; i11++) {
                arrayList.add(arrayList2.get(i11));
            }
            arrayList.add(0, dVar);
            intent.putExtra("index", 0);
            intent.putParcelableArrayListExtra("channels3g", arrayList);
        } else {
            intent.putExtra("index", arrayList2.indexOf(dVar));
            intent.putParcelableArrayListExtra("channels3g", arrayList2);
            intent.putExtra("img_url", dVar.f12985r);
            intent.putExtra("title_simple", dVar.f12984q);
        }
        try {
            startActivityForResult(intent, 9866);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void categorySelected(String str) {
        this.L.setVisibility(0);
        c.GetCategoriesChannels(Constant.f12450b, str, false);
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.K.isOpen()) {
            this.K.closeSearch();
        } else {
            super.onBackPressed();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.channel_list_new);
        EventBus.getDefault().register(this);
        String stringExtra = getIntent().getStringExtra("cat_id");
        if (App.K) {
            new AlphaAnimation(1.0f, 0.0f);
            new Handler();
        }
        getIntent().getStringExtra("url");
        String stringExtra2 = getIntent().getStringExtra("label");
        this.Q = stringExtra2;
        if (stringExtra2 == null) {
            this.Q = "";
        }
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle(this.Q + ", " + getString(R.string.channels_label));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MaterialSearchView materialSearchView = (MaterialSearchView) findViewById(R.id.search_view);
        this.K = materialSearchView;
        materialSearchView.adjustTintAlpha(0.0f);
        this.K.setShouldKeepHistory(false);
        this.K.setOnQueryTextListener(new a());
        this.L = (ProgressBar) findViewById(R.id.loader);
        this.P = (RecyclerView) findViewById(R.id.recyclerview);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.P.setLayoutManager(new CenterGridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140)));
        this.P.addItemDecoration(new fd.d(5));
        k kVar = new k(getBaseContext(), this.N, this, 8989, 100);
        this.M = kVar;
        this.P.setAdapter(kVar);
        categorySelected(stringExtra);
        this.R = getIntent().getStringExtra("cat_name");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        this.S = menu;
        getMenuInflater().inflate(R.menu.menu_channel_list_2, menu);
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(lc.a aVar) {
        if (aVar != null) {
            ArrayList<hd.d> arrayList = aVar.f16046a;
            if (arrayList.size() > 0) {
                ArrayList<hd.d> arrayList2 = this.N;
                arrayList2.clear();
                Iterator<hd.d> it = arrayList.iterator();
                while (it.hasNext()) {
                    hd.d next = it.next();
                    arrayList2.add(next);
                    this.O.add(next);
                }
                this.M.notifyDataSetChanged();
                this.L.setVisibility(8);
                getSupportActionBar().setTitle(this.R + ": " + arrayList2.size() + " Channels");
                this.P.smoothScrollToPosition(0);
            }
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_search) {
            this.K.openSearch();
        } else if (itemId == R.id.action_favorites_channels_list) {
            boolean z10 = !this.T;
            this.T = z10;
            ArrayList<hd.d> arrayList = this.O;
            ArrayList<hd.d> arrayList2 = this.N;
            if (z10) {
                ArrayList<hd.d> favoritesChannels = App.getInstance().f11573u.getFavoritesChannels();
                ArrayList arrayList3 = new ArrayList();
                Iterator<hd.d> it = favoritesChannels.iterator();
                while (it.hasNext()) {
                    arrayList3.add(it.next().f12984q);
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator<hd.d> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    hd.d next = it2.next();
                    String str = next.f12984q;
                    if (str != null && str.trim().length() > 1 && arrayList3.contains(next.f12984q)) {
                        arrayList4.add(next);
                    }
                }
                if (arrayList4.size() > 0) {
                    arrayList2.clear();
                    arrayList2.addAll(arrayList4);
                    this.M.notifyDataSetChanged();
                    this.S.findItem(R.id.action_favorites_channels_list).setIcon(R.drawable.ic_action_favorite);
                } else {
                    Toast.makeText(this, getString(R.string.no_fav_channels_label), 0).show();
                    this.T = false;
                }
            } else {
                arrayList2.clear();
                arrayList2.addAll(arrayList);
                this.M.notifyDataSetChanged();
                this.S.findItem(R.id.action_favorites_channels_list).setIcon(R.drawable.ic_action_favorite_border);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        MaterialSearchView materialSearchView = this.K;
        if (materialSearchView != null) {
            materialSearchView.activityResumed();
            this.K.closeSearch();
        }
        super.onResume();
    }
}
