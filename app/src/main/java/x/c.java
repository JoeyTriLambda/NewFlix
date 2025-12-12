package x;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import x0.b;

/* compiled from: MenuItemWrapperICS.java */
/* loaded from: classes.dex */
public final class c extends x.b implements MenuItem {

    /* renamed from: d, reason: collision with root package name */
    public final q0.b f21203d;

    /* renamed from: e, reason: collision with root package name */
    public Method f21204e;

    /* compiled from: MenuItemWrapperICS.java */
    public class a extends x0.b {

        /* renamed from: c, reason: collision with root package name */
        public final ActionProvider f21205c;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f21205c = actionProvider;
        }

        @Override // x0.b
        public boolean hasSubMenu() {
            return this.f21205c.hasSubMenu();
        }

        @Override // x0.b
        public View onCreateActionView() {
            return this.f21205c.onCreateActionView();
        }

        @Override // x0.b
        public boolean onPerformDefaultAction() {
            return this.f21205c.onPerformDefaultAction();
        }

        @Override // x0.b
        public void onPrepareSubMenu(SubMenu subMenu) {
            this.f21205c.onPrepareSubMenu(c.this.b(subMenu));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: e, reason: collision with root package name */
        public b.InterfaceC0310b f21207e;

        public b(c cVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // x0.b
        public boolean isVisible() {
            return this.f21205c.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z10) {
            b.InterfaceC0310b interfaceC0310b = this.f21207e;
            if (interfaceC0310b != null) {
                ((g.a) interfaceC0310b).onActionProviderVisibilityChanged(z10);
            }
        }

        @Override // x0.b
        public View onCreateActionView(MenuItem menuItem) {
            return this.f21205c.onCreateActionView(menuItem);
        }

        @Override // x0.b
        public boolean overridesItemVisibility() {
            return this.f21205c.overridesItemVisibility();
        }

        @Override // x0.b
        public void setVisibilityListener(b.InterfaceC0310b interfaceC0310b) {
            this.f21207e = interfaceC0310b;
            this.f21205c.setVisibilityListener(interfaceC0310b != null ? this : null);
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    /* renamed from: x.c$c, reason: collision with other inner class name */
    public static class C0308c extends FrameLayout implements w.c {

        /* renamed from: b, reason: collision with root package name */
        public final CollapsibleActionView f21208b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0308c(View view) {
            super(view.getContext());
            this.f21208b = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // w.c
        public void onActionViewCollapsed() {
            this.f21208b.onActionViewCollapsed();
        }

        @Override // w.c
        public void onActionViewExpanded() {
            this.f21208b.onActionViewExpanded();
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f21209a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f21209a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f21209a.onMenuItemActionCollapse(c.this.a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f21209a.onMenuItemActionExpand(c.this.a(menuItem));
        }
    }

    /* compiled from: MenuItemWrapperICS.java */
    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f21211a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f21211a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f21211a.onMenuItemClick(c.this.a(menuItem));
        }
    }

    public c(Context context, q0.b bVar) {
        super(context);
        if (bVar == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f21203d = bVar;
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f21203d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f21203d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        x0.b supportActionProvider = this.f21203d.getSupportActionProvider();
        if (supportActionProvider instanceof a) {
            return ((a) supportActionProvider).f21205c;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f21203d.getActionView();
        return actionView instanceof C0308c ? (View) ((C0308c) actionView).f21208b : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f21203d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f21203d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f21203d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f21203d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f21203d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f21203d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f21203d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f21203d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f21203d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f21203d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f21203d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f21203d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f21203d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return b(this.f21203d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f21203d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f21203d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f21203d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f21203d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f21203d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f21203d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f21203d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f21203d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f21203d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.f21200a, actionProvider);
        if (actionProvider == null) {
            bVar = null;
        }
        this.f21203d.setSupportActionProvider(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0308c(view);
        }
        this.f21203d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f21203d.setAlphabeticShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f21203d.setCheckable(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f21203d.setChecked(z10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f21203d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f21203d.setEnabled(z10);
        return this;
    }

    public void setExclusiveCheckable(boolean z10) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Method method = this.f21204e;
            q0.b bVar = this.f21203d;
            if (method == null) {
                this.f21204e = bVar.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f21204e.invoke(bVar, Boolean.valueOf(z10));
        } catch (Exception e10) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e10);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f21203d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f21203d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f21203d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f21203d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f21203d.setNumericShortcut(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f21203d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f21203d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f21203d.setShortcut(c10, c11);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i10) {
        this.f21203d.setShowAsAction(i10);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i10) {
        this.f21203d.setShowAsActionFlags(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f21203d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f21203d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f21203d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        return this.f21203d.setVisible(z10);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f21203d.setAlphabeticShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f21203d.setIcon(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f21203d.setNumericShortcut(c10, i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f21203d.setShortcut(c10, c11, i10, i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f21203d.setTitle(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i10) {
        q0.b bVar = this.f21203d;
        bVar.setActionView(i10);
        View actionView = bVar.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            bVar.setActionView(new C0308c(actionView));
        }
        return this;
    }
}
