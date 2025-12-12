package x;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import b0.k;

/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f21200a;

    /* renamed from: b, reason: collision with root package name */
    public k<q0.b, MenuItem> f21201b;

    /* renamed from: c, reason: collision with root package name */
    public k<q0.c, SubMenu> f21202c;

    public b(Context context) {
        this.f21200a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (!(menuItem instanceof q0.b)) {
            return menuItem;
        }
        q0.b bVar = (q0.b) menuItem;
        if (this.f21201b == null) {
            this.f21201b = new k<>();
        }
        MenuItem menuItem2 = this.f21201b.get(bVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f21200a, bVar);
        this.f21201b.put(bVar, cVar);
        return cVar;
    }

    public final SubMenu b(SubMenu subMenu) {
        if (!(subMenu instanceof q0.c)) {
            return subMenu;
        }
        q0.c cVar = (q0.c) subMenu;
        if (this.f21202c == null) {
            this.f21202c = new k<>();
        }
        SubMenu subMenu2 = this.f21202c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        g gVar = new g(this.f21200a, cVar);
        this.f21202c.put(cVar, gVar);
        return gVar;
    }
}
