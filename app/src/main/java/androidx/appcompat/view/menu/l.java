package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.e;

/* compiled from: SubMenuBuilder.java */
/* loaded from: classes.dex */
public class l extends e implements SubMenu {
    public final g A;

    /* renamed from: z, reason: collision with root package name */
    public final e f1068z;

    public l(Context context, e eVar, g gVar) {
        super(context);
        this.f1068z = eVar;
        this.A = gVar;
    }

    @Override // androidx.appcompat.view.menu.e
    public final boolean a(e eVar, MenuItem menuItem) {
        return super.a(eVar, menuItem) || this.f1068z.a(eVar, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean collapseItemActionView(g gVar) {
        return this.f1068z.collapseItemActionView(gVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean expandItemActionView(g gVar) {
        return this.f1068z.expandItemActionView(gVar);
    }

    @Override // androidx.appcompat.view.menu.e
    public String getActionViewStatesKey() {
        g gVar = this.A;
        int itemId = gVar != null ? gVar.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + itemId;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.A;
    }

    public Menu getParentMenu() {
        return this.f1068z;
    }

    @Override // androidx.appcompat.view.menu.e
    public e getRootMenu() {
        return this.f1068z.getRootMenu();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean isGroupDividerEnabled() {
        return this.f1068z.isGroupDividerEnabled();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean isQwertyMode() {
        return this.f1068z.isQwertyMode();
    }

    @Override // androidx.appcompat.view.menu.e
    public boolean isShortcutsVisible() {
        return this.f1068z.isShortcutsVisible();
    }

    @Override // androidx.appcompat.view.menu.e
    public void setCallback(e.a aVar) {
        this.f1068z.setCallback(aVar);
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setGroupDividerEnabled(boolean z10) {
        this.f1068z.setGroupDividerEnabled(z10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) setHeaderViewInt(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.e, android.view.Menu
    public void setQwertyMode(boolean z10) {
        this.f1068z.setQwertyMode(z10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        return (SubMenu) setHeaderIconInt(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        return (SubMenu) setHeaderTitleInt(i10);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.A.setIcon(i10);
        return this;
    }
}
