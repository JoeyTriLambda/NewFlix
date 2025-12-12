package x;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* compiled from: ActionMenuItem.java */
/* loaded from: classes.dex */
public final class a implements q0.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f21181a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21182b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21183c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f21184d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f21185e;

    /* renamed from: f, reason: collision with root package name */
    public Intent f21186f;

    /* renamed from: g, reason: collision with root package name */
    public char f21187g;

    /* renamed from: i, reason: collision with root package name */
    public char f21189i;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f21191k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f21192l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f21193m;

    /* renamed from: n, reason: collision with root package name */
    public CharSequence f21194n;

    /* renamed from: h, reason: collision with root package name */
    public int f21188h = 4096;

    /* renamed from: j, reason: collision with root package name */
    public int f21190j = 4096;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f21195o = null;

    /* renamed from: p, reason: collision with root package name */
    public PorterDuff.Mode f21196p = null;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21197q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f21198r = false;

    /* renamed from: s, reason: collision with root package name */
    public int f21199s = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f21192l = context;
        this.f21181a = i11;
        this.f21182b = i10;
        this.f21183c = i13;
        this.f21184d = charSequence;
    }

    public final void a() {
        Drawable drawable = this.f21191k;
        if (drawable != null) {
            if (this.f21197q || this.f21198r) {
                Drawable drawableWrap = p0.a.wrap(drawable);
                this.f21191k = drawableWrap;
                Drawable drawableMutate = drawableWrap.mutate();
                this.f21191k = drawableMutate;
                if (this.f21197q) {
                    p0.a.setTintList(drawableMutate, this.f21195o);
                }
                if (this.f21198r) {
                    p0.a.setTintMode(this.f21191k, this.f21196p);
                }
            }
        }
    }

    @Override // q0.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // q0.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // q0.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // q0.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f21190j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f21189i;
    }

    @Override // q0.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f21193m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f21182b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f21191k;
    }

    @Override // q0.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f21195o;
    }

    @Override // q0.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f21196p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f21186f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f21181a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // q0.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f21188h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f21187g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f21183c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // q0.b
    public x0.b getSupportActionProvider() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f21184d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f21185e;
        return charSequence != null ? charSequence : this.f21184d;
    }

    @Override // q0.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f21194n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // q0.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f21199s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f21199s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f21199s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f21199s & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f21189i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f21199s = (z10 ? 1 : 0) | (this.f21199s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f21199s = (z10 ? 2 : 0) | (this.f21199s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f21199s = (z10 ? 16 : 0) | (this.f21199s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f21191k = drawable;
        a();
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f21195o = colorStateList;
        this.f21197q = true;
        a();
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f21196p = mode;
        this.f21198r = true;
        a();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f21186f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f21187g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f21187g = c10;
        this.f21189i = Character.toLowerCase(c11);
        return this;
    }

    @Override // q0.b
    public q0.b setSupportActionProvider(x0.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f21184d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f21185e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f21199s = (this.f21199s & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f21189i = Character.toLowerCase(c10);
        this.f21190j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public q0.b setContentDescription(CharSequence charSequence) {
        this.f21193m = charSequence;
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f21187g = c10;
        this.f21188h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f21184d = this.f21192l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public q0.b setTooltipText(CharSequence charSequence) {
        this.f21194n = charSequence;
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f21191k = m0.a.getDrawable(this.f21192l, i10);
        a();
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f21187g = c10;
        this.f21188h = KeyEvent.normalizeMetaState(i10);
        this.f21189i = Character.toLowerCase(c11);
        this.f21190j = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }
}
