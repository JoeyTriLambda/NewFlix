package flix.com.vision.activities;

import ac.o;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.d;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;
import fd.c;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.DramaDetailActivity;
import flix.com.vision.models.Drama;
import flix.com.vision.tv.Constant;
import hd.f;
import java.util.ArrayList;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes2.dex */
public class DramaDetailActivity extends wb.a {

    /* renamed from: b0, reason: collision with root package name */
    public static final /* synthetic */ int f11610b0 = 0;
    public ImageView K;
    public TextView L;
    public TextView M;
    public RelativeLayout N;
    public SpinKitView O;
    public RecyclerView P;
    public ImageView Q;
    public TextView R;
    public TextView S;
    public o T;
    public Drama U;
    public ImageButton X;
    public RelativeLayout Y;

    /* renamed from: a0, reason: collision with root package name */
    public Menu f11611a0;
    public final ArrayList<f> V = new ArrayList<>();
    public String W = "https://kissasiantv.to";
    public int Z = -1;

    public enum RESULT_EVENT {
        SUCCESS,
        /* JADX INFO: Fake field, exist only in values array */
        ERROR,
        /* JADX INFO: Fake field, exist only in values array */
        EPISODE_READY,
        EPISODE_FAILED,
        /* JADX INFO: Fake field, exist only in values array */
        LOAD_FOO_LINK
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Menu menu;
            DramaDetailActivity dramaDetailActivity = DramaDetailActivity.this;
            try {
                if (!App.getInstance().f11573u.isMovieFavorited_ANIME(dramaDetailActivity.U.toMovie()) || (menu = dramaDetailActivity.f11611a0) == null) {
                    return;
                }
                menu.findItem(R.id.action_fav).setIcon(R.drawable.ic_action_favorite);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public class b extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }
    }

    public void extractDominantColor() {
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), 0, 2505092);
        valueAnimatorOfObject.setDuration(2000L);
        valueAnimatorOfObject.addUpdateListener(new l7.a(this, 6));
        valueAnimatorOfObject.addListener(new b());
        valueAnimatorOfObject.start();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_drama_detail);
        } catch (Exception e10) {
            e10.printStackTrace();
            finish();
        }
        this.Y = (RelativeLayout) findViewById(R.id.activity_anime_detail);
        SharedPreferences sharedPreferences = App.getInstance().f11574v;
        String str = Constant.f12450b;
        this.W = sharedPreferences.getString("pref_drama_host", "https://kissasiantv.to");
        this.X = (ImageButton) findViewById(R.id.play_single_media_button);
        this.M = (TextView) findViewById(R.id.anime_year_label);
        this.K = (ImageView) findViewById(R.id.button_favorite_image);
        EventBus.getDefault().register(this);
        if (bundle == null) {
            App.C.clear();
        }
        this.O = (SpinKitView) findViewById(R.id.loader_view);
        this.L = (TextView) findViewById(R.id.last_watched_label);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.add_favorites);
        this.N = relativeLayout;
        if (relativeLayout != null) {
            relativeLayout.setOnFocusChangeListener(new v7.b(this, 3));
        }
        this.P = (RecyclerView) findViewById(R.id.listview_);
        this.Q = (ImageView) findViewById(R.id.poster);
        this.R = (TextView) findViewById(R.id.plot);
        this.S = (TextView) findViewById(R.id.title);
        Drama drama = (Drama) getIntent().getSerializableExtra("drama");
        this.U = drama;
        this.S.setText(drama.f12389n);
        String string = App.getInstance().f11574v.getString(this.U.f12391p + "episode", null);
        if (string != null) {
            this.L.setText("· last episode: E".concat(string));
        } else {
            this.L.setVisibility(8);
        }
        final int i10 = 0;
        this.X.setOnClickListener(new View.OnClickListener(this) { // from class: ub.m

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaDetailActivity f20230m;

            {
                this.f20230m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i11 = i10;
                DramaDetailActivity dramaDetailActivity = this.f20230m;
                boolean z10 = false;
                switch (i11) {
                    case 0:
                        int i12 = DramaDetailActivity.f11610b0;
                        dramaDetailActivity.openEpisode(0);
                        break;
                    default:
                        int i13 = DramaDetailActivity.f11610b0;
                        dramaDetailActivity.getClass();
                        if (App.getInstance().f11573u.isDramaFavorited(dramaDetailActivity.U)) {
                            App.getInstance().f11573u.deletDramaFromFavorites(dramaDetailActivity.U);
                            try {
                                ic.a.Success(dramaDetailActivity.getApplicationContext(), "Removed from your list", null, 80, 0);
                            } catch (Exception unused) {
                            }
                        } else {
                            App.getInstance().f11573u.addDramaToFavorites(dramaDetailActivity.U);
                            try {
                                ic.a.Success(dramaDetailActivity.getApplicationContext(), "Added to your Drama List", null, 80, 0);
                            } catch (Exception unused2) {
                            }
                            z10 = true;
                        }
                        if (!z10) {
                            dramaDetailActivity.K.setImageResource(R.drawable.ic_bookmark);
                            break;
                        } else {
                            dramaDetailActivity.K.setImageResource(R.drawable.ic_delete_bookmark);
                            break;
                        }
                }
            }
        });
        this.M.setText(this.U.f12387b);
        final int i11 = 1;
        this.X.setOnFocusChangeListener(new ub.b(1));
        this.N.setOnClickListener(new View.OnClickListener(this) { // from class: ub.m

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ DramaDetailActivity f20230m;

            {
                this.f20230m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i112 = i11;
                DramaDetailActivity dramaDetailActivity = this.f20230m;
                boolean z10 = false;
                switch (i112) {
                    case 0:
                        int i12 = DramaDetailActivity.f11610b0;
                        dramaDetailActivity.openEpisode(0);
                        break;
                    default:
                        int i13 = DramaDetailActivity.f11610b0;
                        dramaDetailActivity.getClass();
                        if (App.getInstance().f11573u.isDramaFavorited(dramaDetailActivity.U)) {
                            App.getInstance().f11573u.deletDramaFromFavorites(dramaDetailActivity.U);
                            try {
                                ic.a.Success(dramaDetailActivity.getApplicationContext(), "Removed from your list", null, 80, 0);
                            } catch (Exception unused) {
                            }
                        } else {
                            App.getInstance().f11573u.addDramaToFavorites(dramaDetailActivity.U);
                            try {
                                ic.a.Success(dramaDetailActivity.getApplicationContext(), "Added to your Drama List", null, 80, 0);
                            } catch (Exception unused2) {
                            }
                            z10 = true;
                        }
                        if (!z10) {
                            dramaDetailActivity.K.setImageResource(R.drawable.ic_bookmark);
                            break;
                        } else {
                            dramaDetailActivity.K.setImageResource(R.drawable.ic_delete_bookmark);
                            break;
                        }
                }
            }
        });
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }
        if (getResources().getConfiguration().orientation == 2) {
            try {
                getSupportActionBar().hide();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        try {
            Picasso.get().load(this.U.f12392q).fit().placeholder(R.drawable.ic_anime).centerCrop().into(this.Q);
        } catch (OutOfMemoryError e12) {
            e12.printStackTrace();
        }
        float f10 = o1.a.b(getWindowManager().getDefaultDisplay()).widthPixels / getResources().getDisplayMetrics().density;
        int i12 = App.K ? 12 : 8;
        int iRound = Math.round(f10 / 105);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listview_);
        this.P = recyclerView;
        recyclerView.setClipToPadding(false);
        this.P.addItemDecoration(new c(i12));
        ArrayList<f> arrayList = this.V;
        o oVar = new o(this, arrayList, string);
        this.T = oVar;
        this.P.setAdapter(oVar);
        this.P.setLayoutManager(new GridLayoutManager(this, iRound));
        if (bundle == null) {
            new flix.com.vision.activities.b(this, this.U.f12391p.replace("www9.gogoanime.io", "gogoanime.pe")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            arrayList.addAll(bundle.getParcelableArrayList("episodes"));
            this.T.notifyDataSetChanged();
            this.O.setVisibility(8);
            this.Z = 0;
            EventBus.getDefault().post(RESULT_EVENT.SUCCESS);
        }
        new Handler().postDelayed(new a(), 500L);
        new Handler().postDelayed(new d(this, 26), 800L);
        this.P.requestFocus();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anime_detail_menu_2, menu);
        this.f11611a0 = menu;
        return true;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(RESULT_EVENT result_event) {
        if (result_event == RESULT_EVENT.SUCCESS) {
            this.T.notifyDataSetChanged();
            this.O.setVisibility(8);
        } else if (result_event == RESULT_EVENT.EPISODE_FAILED) {
            this.O.setVisibility(8);
            Toast.makeText(getBaseContext(), getString(R.string.failed_to_load), 1);
        }
        this.O.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId != R.id.action_fav) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (App.getInstance().f11573u.isMovieFavorited_ANIME(this.U.toMovie())) {
            menuItem.setIcon(R.drawable.love);
            App.getInstance().f11573u.deleteFavoriteMovie_ANIME(this.U.toMovie());
            Snackbar.make(findViewById(R.id.main_view), R.string.removed_fav_label, -1).show();
        } else {
            menuItem.setIcon(R.drawable.ic_action_favorite);
            App.getInstance().f11573u.addMovieFavorites_Anime(this.U.toMovie());
            Snackbar.make(findViewById(R.id.main_view), R.string.added_fav_label, -1).show();
        }
        return true;
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            o oVar = this.T;
            if (oVar != null) {
                oVar.notifyDataSetChanged();
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("episodes", this.V);
    }

    public void openEpisode(int i10) {
        App.getInstance().A.clear();
        ArrayList<f> arrayList = App.getInstance().A;
        ArrayList<f> arrayList2 = this.V;
        arrayList.addAll(arrayList2);
        Intent intent = new Intent(this, (Class<?>) LinksActivity.class);
        intent.putExtra("server_index", this.Z);
        intent.putExtra("url", arrayList2.get(i10).f12994n);
        intent.putExtra("img_url", this.U.f12392q);
        intent.putExtra("movie", this.U.toMovie());
        int i11 = i10 + 1;
        intent.putExtra("episode_number", i11);
        intent.putExtra("title_episode", "Episode " + i10 + 1);
        intent.putExtra("title", this.U.f12389n + " - episode " + arrayList2.get(i10).f12996p);
        intent.putExtra("episode", arrayList2.get(i10).f12996p);
        intent.putExtra("title_simple", this.U.f12389n);
        startActivity(intent);
        String strF = ac.c.f("", i11);
        App.getInstance().f11574v.edit().putString(this.U.f12391p + "episode", strF).apply();
        App.getInstance().f11573u.addDramaToContinue(this.U);
    }
}
