package x0;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MenuHostHelper.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f21290a;

    /* renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<o> f21291b = new CopyOnWriteArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f21292c = new HashMap();

    /* compiled from: MenuHostHelper.java */
    public static class a {
    }

    public m(Runnable runnable) {
        this.f21290a = runnable;
    }

    public void addMenuProvider(o oVar) {
        this.f21291b.add(oVar);
        this.f21290a.run();
    }

    public void onCreateMenu(Menu menu, MenuInflater menuInflater) {
        Iterator<o> it = this.f21291b.iterator();
        while (it.hasNext()) {
            it.next().onCreateMenu(menu, menuInflater);
        }
    }

    public void onMenuClosed(Menu menu) {
        Iterator<o> it = this.f21291b.iterator();
        while (it.hasNext()) {
            it.next().onMenuClosed(menu);
        }
    }

    public boolean onMenuItemSelected(MenuItem menuItem) {
        Iterator<o> it = this.f21291b.iterator();
        while (it.hasNext()) {
            if (it.next().onMenuItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void onPrepareMenu(Menu menu) {
        Iterator<o> it = this.f21291b.iterator();
        while (it.hasNext()) {
            it.next().onPrepareMenu(menu);
        }
    }

    public void removeMenuProvider(o oVar) {
        this.f21291b.remove(oVar);
        if (((a) this.f21292c.remove(oVar)) != null) {
            throw null;
        }
        this.f21290a.run();
    }
}
