package flix.com.vision.activities;

import ac.t;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;
import com.uwetrottmann.trakt5.TraktV2;
import de.hdodenhof.circleimageview.CircleImageView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.activities.TraktActivity;
import flix.com.vision.models.Movie;
import java.util.ArrayList;
import java.util.Locale;
import r.j;
import ub.m2;

/* loaded from: classes2.dex */
public class TraktActivity extends j implements gd.j {
    public static final /* synthetic */ int U = 0;
    public RelativeLayout K;
    public RelativeLayout L;
    public SpinKitView M;
    public TraktV2 N;
    public TextView O;
    public TextView P;
    public t Q;
    public CircleImageView R;
    public RecyclerView S;
    public final ArrayList<Movie> T = new ArrayList<>();

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_trakt);
        this.S = (RecyclerView) findViewById(R.id.recyclerview);
        this.R = (CircleImageView) findViewById(R.id.image_user);
        this.P = (TextView) findViewById(R.id.label_watchlist_button);
        this.O = (TextView) findViewById(R.id.label_collection_button);
        this.K = (RelativeLayout) findViewById(R.id.collection_button);
        this.L = (RelativeLayout) findViewById(R.id.watchlist_button);
        this.M = (SpinKitView) findViewById(R.id.loader);
        this.Q = new t(this, this.T, this, 0, this, null);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        float f10 = displayMetricsB.widthPixels / getResources().getDisplayMetrics().density;
        ArrayList<String> arrayList = App.B;
        this.S.setLayoutManager(new GridLayoutManager(this, Math.round(f10 / 140)));
        o1.a.h(12, this.S);
        this.S.setAdapter(this.Q);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("TRAKT OF  " + App.getInstance().f11574v.getString("trakt_user_name", "N/A").toUpperCase(Locale.ROOT));
        final int i10 = 1;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final int i11 = 0;
        new m2(this, 1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        try {
            if (this.R != null) {
                Picasso.get().load(App.getInstance().f11574v.getString("trakt_avatar", null)).fit().centerCrop().into(this.R);
                this.R.setBorderColor(getResources().getColor(R.color.white));
            }
        } catch (Exception unused) {
        }
        this.K.setOnClickListener(new View.OnClickListener(this) { // from class: ub.l2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktActivity f20228m;

            {
                this.f20228m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i11;
                TraktActivity traktActivity = this.f20228m;
                switch (i12) {
                    case 0:
                        int i13 = TraktActivity.U;
                        traktActivity.getClass();
                        new m2(traktActivity, 1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        break;
                    default:
                        int i14 = TraktActivity.U;
                        traktActivity.getClass();
                        new m2(traktActivity, 2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        break;
                }
            }
        });
        this.L.setOnClickListener(new View.OnClickListener(this) { // from class: ub.l2

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ TraktActivity f20228m;

            {
                this.f20228m = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i12 = i10;
                TraktActivity traktActivity = this.f20228m;
                switch (i12) {
                    case 0:
                        int i13 = TraktActivity.U;
                        traktActivity.getClass();
                        new m2(traktActivity, 1).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        break;
                    default:
                        int i14 = TraktActivity.U;
                        traktActivity.getClass();
                        new m2(traktActivity, 2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
                        break;
                }
            }
        });
    }

    @Override // gd.j
    public void onMediaSelected(Movie movie) {
        Intent intent = new Intent(this, (Class<?>) MovieDetailActivity.class);
        intent.putExtra("movie", movie);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    @Override // gd.j
    public void favoriteDeleted(int i10) {
    }
}
