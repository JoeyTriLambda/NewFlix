package flix.com.vision.activities;

import ac.h;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import androidx.appcompat.app.d;
import androidx.recyclerview.widget.GridLayoutManager;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Anime;
import gd.d;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AnimeHistoryActivity extends wb.a implements d {
    public static final /* synthetic */ int P = 0;
    public final int K = 200;
    public SuperRecyclerView L;
    public ArrayList<Anime> M;
    public h N;
    public RelativeLayout O;

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) throws SQLException {
            dialogInterface.dismiss();
            AnimeHistoryActivity animeHistoryActivity = AnimeHistoryActivity.this;
            animeHistoryActivity.M.clear();
            animeHistoryActivity.N.notifyDataSetChanged();
            App.getInstance().f11573u.clearHistory_Anime();
        }
    }

    public class c implements DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
        }
    }

    @Override // wb.a, androidx.fragment.app.p, androidx.activity.ComponentActivity, l0.j, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_anime_history);
        this.L = (SuperRecyclerView) findViewById(R.id.recyclerview);
        this.O = (RelativeLayout) findViewById(R.id.anime_favorites);
        this.M = App.getInstance().f11573u.getWatchedMoviesFromDb_Anime();
        h hVar = new h(getBaseContext(), this.M, this, this.K, this);
        this.N = hVar;
        this.L.setAdapter(hVar);
        DisplayMetrics displayMetricsB = o1.a.b(getWindowManager().getDefaultDisplay());
        this.L.setLayoutManager(new GridLayoutManager(this, Math.round((displayMetricsB.widthPixels / getResources().getDisplayMetrics().density) / 140.0f)));
        this.O.setOnClickListener(new androidx.mediarouter.app.b(this, 6));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_wwe_history, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_wwe_clear) {
            androidx.appcompat.app.d dVarCreate = new d.a(this).create();
            dVarCreate.setMessage(getString(R.string.confirm_clear_wwe));
            dVarCreate.setTitle(getString(R.string.clear_history_label));
            dVarCreate.setOnDismissListener(new a());
            dVarCreate.setButton(-1, getString(R.string.yes_clear_label), new b());
            dVarCreate.setButton(-2, getString(R.string.cancel_label), new c());
            try {
                dVarCreate.show();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else if (itemId == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // wb.a, androidx.fragment.app.p, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // gd.d
    public void openAnime(Anime anime) {
        Intent intent = new Intent(this, (Class<?>) AnimeDetailActivity.class);
        intent.putExtra("anime", anime);
        intent.setFlags(268435456);
        startActivity(intent);
    }

    public class a implements DialogInterface.OnDismissListener {
        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }
}
