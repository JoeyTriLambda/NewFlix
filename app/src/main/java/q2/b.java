package q2;

import ac.z;
import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.r0;
import flix.com.vision.App;
import flix.com.vision.R;
import flix.com.vision.models.Anime;
import flix.com.vision.tv.MyImportActivity;
import t0.d;
import y4.p;
import z4.a;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements d.a, a.InterfaceC0331a, p.a, r0.c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17778b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f17779m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f17780n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f17781o;

    public /* synthetic */ b(int i10, Object obj, Object obj2, Object obj3) {
        this.f17778b = i10;
        this.f17779m = obj;
        this.f17780n = obj2;
        this.f17781o = obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x02cd A[PHI: r10
  0x02cd: PHI (r10v12 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason) = 
  (r10v5 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason)
  (r10v7 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason)
  (r10v8 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason)
  (r10v9 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason)
  (r10v10 com.google.android.datatransport.runtime.firebase.transport.LogEventDropped$Reason)
 binds: [B:70:0x02cb, B:76:0x02dd, B:79:0x02e6, B:82:0x02ef, B:85:0x02f8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // y4.p.a, n4.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object apply(java.lang.Object r24) {
        /*
            Method dump skipped, instructions count: 980
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.b.apply(java.lang.Object):java.lang.Object");
    }

    @Override // z4.a.InterfaceC0331a
    public final Object execute() {
        w4.b bVar = (w4.b) this.f17779m;
        q4.o oVar = (q4.o) this.f17780n;
        bVar.f20941d.persist(oVar, (q4.i) this.f17781o);
        bVar.f20938a.schedule(oVar, 1);
        return null;
    }

    @Override // t0.d.a
    public final void onCancel() {
        Runnable runnable = (Runnable) this.f17779m;
        androidx.transition.e eVar = (androidx.transition.e) this.f17781o;
        Runnable runnable2 = (Runnable) this.f17780n;
        if (runnable != null) {
            runnable.run();
        } else {
            eVar.cancel();
            runnable2.run();
        }
    }

    @Override // androidx.appcompat.widget.r0.c
    public final boolean onMenuItemClick(MenuItem menuItem) {
        int i10 = this.f17778b;
        Object obj = this.f17781o;
        Object obj2 = this.f17780n;
        Object obj3 = this.f17779m;
        switch (i10) {
            case 6:
                ac.f fVar = (ac.f) obj3;
                id.c cVar = (id.c) obj2;
                r0 r0Var = (r0) obj;
                fVar.getClass();
                int itemId = menuItem.getItemId();
                Activity activity = fVar.f445e;
                if (itemId == R.id.action_add_favorites_live_tv) {
                    App.getInstance().f11573u.addFavoritesAdult(cVar);
                    Toast.makeText(activity, activity.getString(R.string.added_fav_label), 0).show();
                }
                if (menuItem.getItemId() == R.id.action_remove_favorites_live_tv) {
                    App.getInstance().f11573u.deleteFavoriteAdultVideo(cVar);
                    Toast.makeText(activity, activity.getString(R.string.removed_fav_label), 0).show();
                }
                r0Var.dismiss();
                break;
            case 7:
                ac.h hVar = (ac.h) obj3;
                Anime anime = (Anime) obj2;
                r0 r0Var2 = (r0) obj;
                hVar.getClass();
                int itemId2 = menuItem.getItemId();
                Context context = hVar.f456d;
                if (itemId2 == R.id.action_add_favorites_live_tv) {
                    App.getInstance().f11573u.addMovieFavorites_Anime(anime.toMovie());
                    Toast.makeText(context, context.getString(R.string.added_fav_label), 0).show();
                }
                if (menuItem.getItemId() == R.id.action_remove_favorites_live_tv) {
                    App.getInstance().f11573u.deleteFavoriteMovie_ANIME(anime.toMovie());
                    Toast.makeText(context, context.getString(R.string.removed_fav_label), 0).show();
                }
                r0Var2.dismiss();
                break;
            case 8:
                ac.k kVar = (ac.k) obj3;
                hd.d dVar = (hd.d) obj2;
                r0 r0Var3 = (r0) obj;
                kVar.getClass();
                int itemId3 = menuItem.getItemId();
                Context context2 = kVar.f488e;
                if (itemId3 == R.id.action_add_favorites_live_tv) {
                    App.getInstance().f11573u.addChannelToFavorites(dVar);
                    Toast.makeText(context2, context2.getString(R.string.added_fav_label), 0).show();
                }
                if (menuItem.getItemId() == R.id.action_remove_favorites_live_tv) {
                    App.getInstance().f11573u.deleteChannelFromFavorites(dVar);
                    Toast.makeText(context2, context2.getString(R.string.removed_fav_label), 0).show();
                }
                r0Var3.dismiss();
                break;
            default:
                z zVar = (z) obj3;
                z.a aVar = (z.a) obj2;
                r0 r0Var4 = (r0) obj;
                zVar.getClass();
                int itemId4 = menuItem.getItemId();
                Activity activity2 = zVar.f608d;
                if (itemId4 == R.id.action_remove) {
                    ((MyImportActivity) activity2).removeItem(aVar.f612u);
                } else if (menuItem.getItemId() == R.id.action_open) {
                    ((MyImportActivity) activity2).openItem(aVar.f612u);
                } else if (menuItem.getItemId() == R.id.action_edit) {
                    ((MyImportActivity) activity2).editItem(aVar.f612u);
                }
                r0Var4.dismiss();
                break;
        }
        return true;
    }

    public /* synthetic */ b(Runnable runnable, androidx.transition.e eVar, Runnable runnable2) {
        this.f17778b = 0;
        this.f17779m = runnable;
        this.f17781o = eVar;
        this.f17780n = runnable2;
    }
}
