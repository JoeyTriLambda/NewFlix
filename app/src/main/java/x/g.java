package x;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: SubMenuWrapperICS.java */
/* loaded from: classes.dex */
public final class g extends e implements SubMenu {

    /* renamed from: e, reason: collision with root package name */
    public final q0.c f21215e;

    public g(Context context, q0.c cVar) {
        super(context, cVar);
        this.f21215e = cVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f21215e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return a(this.f21215e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        this.f21215e.setHeaderIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        this.f21215e.setHeaderTitle(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f21215e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f21215e.setIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f21215e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f21215e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f21215e.setIcon(drawable);
        return this;
    }
}
