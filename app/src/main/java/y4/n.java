package y4;

import ac.m;
import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.r0;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Drama;
import java.io.Serializable;
import java.util.Map;
import t4.a;
import y4.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements p.a, r0.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f21882b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Serializable f21883m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f21884n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f21885o;

    public /* synthetic */ n(ac.m mVar, Drama drama, m.a aVar, r0 r0Var) {
        this.f21882b = mVar;
        this.f21883m = drama;
        this.f21884n = aVar;
        this.f21885o = r0Var;
    }

    @Override // y4.p.a, n4.d
    public final Object apply(Object obj) {
        p pVar = (p) this.f21882b;
        String str = (String) this.f21883m;
        Map map = (Map) this.f21884n;
        a.C0257a c0257a = (a.C0257a) this.f21885o;
        pVar.getClass();
        return (t4.a) p.g(((SQLiteDatabase) obj).rawQuery(str, new String[0]), new q2.b(5, pVar, map, c0257a));
    }

    @Override // androidx.appcompat.widget.r0.c
    public final boolean onMenuItemClick(MenuItem menuItem) {
        ac.m mVar = (ac.m) this.f21882b;
        Drama drama = (Drama) this.f21883m;
        m.a aVar = (m.a) this.f21884n;
        r0 r0Var = (r0) this.f21885o;
        mVar.getClass();
        int itemId = menuItem.getItemId();
        Activity activity = mVar.f507e;
        if (itemId == R.id.action_add_favorites_live_tv) {
            App.getInstance().f11573u.addDramaToFavorites(drama);
            Toast.makeText(activity, activity.getString(R.string.added_fav_label), 0).show();
        }
        if (menuItem.getItemId() == R.id.action_remove_favorites_live_tv) {
            App.getInstance().f11573u.deletDramaFromFavorites(drama);
            Toast.makeText(activity, activity.getString(R.string.removed_fav_label), 0).show();
            gd.e eVar = mVar.f506d;
            if (eVar != null) {
                eVar.removeDramaFromFavorites(aVar.f509u);
            }
        }
        r0Var.dismiss();
        return true;
    }
}
