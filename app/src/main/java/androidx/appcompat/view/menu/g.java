package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.ArrayList;
import x0.b;

/* compiled from: MenuItemImpl.java */
/* loaded from: classes.dex */
public final class g implements q0.b {
    public x0.b A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a, reason: collision with root package name */
    public final int f1012a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1013b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1014c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1015d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f1016e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1017f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f1018g;

    /* renamed from: h, reason: collision with root package name */
    public char f1019h;

    /* renamed from: j, reason: collision with root package name */
    public char f1021j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f1023l;

    /* renamed from: n, reason: collision with root package name */
    public final e f1025n;

    /* renamed from: o, reason: collision with root package name */
    public l f1026o;

    /* renamed from: p, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1027p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f1028q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1029r;

    /* renamed from: y, reason: collision with root package name */
    public int f1036y;

    /* renamed from: z, reason: collision with root package name */
    public View f1037z;

    /* renamed from: i, reason: collision with root package name */
    public int f1020i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f1022k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f1024m = 0;

    /* renamed from: s, reason: collision with root package name */
    public ColorStateList f1030s = null;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuff.Mode f1031t = null;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1032u = false;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1033v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1034w = false;

    /* renamed from: x, reason: collision with root package name */
    public int f1035x = 16;
    public boolean C = false;

    /* compiled from: MenuItemImpl.java */
    public class a implements b.InterfaceC0310b {
        public a() {
        }

        public void onActionProviderVisibilityChanged(boolean z10) {
            e eVar = g.this.f1025n;
            eVar.f992h = true;
            eVar.onItemsChanged(true);
        }
    }

    public g(e eVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f1025n = eVar;
        this.f1012a = i11;
        this.f1013b = i10;
        this.f1014c = i12;
        this.f1015d = i13;
        this.f1016e = charSequence;
        this.f1036y = i14;
    }

    public static void a(int i10, int i11, String str, StringBuilder sb2) {
        if ((i10 & i11) == i11) {
            sb2.append(str);
        }
    }

    public void actionFormatChanged() {
        e eVar = this.f1025n;
        eVar.f995k = true;
        eVar.onItemsChanged(true);
    }

    public final Drawable b(Drawable drawable) {
        if (drawable != null && this.f1034w && (this.f1032u || this.f1033v)) {
            drawable = p0.a.wrap(drawable).mutate();
            if (this.f1032u) {
                p0.a.setTintList(drawable, this.f1030s);
            }
            if (this.f1033v) {
                p0.a.setTintMode(drawable, this.f1031t);
            }
            this.f1034w = false;
        }
        return drawable;
    }

    @Override // q0.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1036y & 8) == 0) {
            return false;
        }
        if (this.f1037z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1025n.collapseItemActionView(this);
        }
        return false;
    }

    @Override // q0.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1025n.expandItemActionView(this);
        }
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // q0.b, android.view.MenuItem
    public View getActionView() {
        View view = this.f1037z;
        if (view != null) {
            return view;
        }
        x0.b bVar = this.A;
        if (bVar == null) {
            return null;
        }
        View viewOnCreateActionView = bVar.onCreateActionView(this);
        this.f1037z = viewOnCreateActionView;
        return viewOnCreateActionView;
    }

    @Override // q0.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1022k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1021j;
    }

    @Override // q0.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1028q;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1013b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1023l;
        if (drawable != null) {
            return b(drawable);
        }
        if (this.f1024m == 0) {
            return null;
        }
        Drawable drawable2 = s.a.getDrawable(this.f1025n.getContext(), this.f1024m);
        this.f1024m = 0;
        this.f1023l = drawable2;
        return b(drawable2);
    }

    @Override // q0.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1030s;
    }

    @Override // q0.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1031t;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1018g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1012a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // q0.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1020i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1019h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1014c;
    }

    public int getOrdering() {
        return this.f1015d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1026o;
    }

    @Override // q0.b
    public x0.b getSupportActionProvider() {
        return this.A;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1016e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1017f;
        return charSequence != null ? charSequence : this.f1016e;
    }

    @Override // q0.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1029r;
    }

    public boolean hasCollapsibleActionView() {
        x0.b bVar;
        if ((this.f1036y & 8) == 0) {
            return false;
        }
        if (this.f1037z == null && (bVar = this.A) != null) {
            this.f1037z = bVar.onCreateActionView(this);
        }
        return this.f1037z != null;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1026o != null;
    }

    public boolean invoke() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1027p;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        e eVar = this.f1025n;
        if (eVar.a(eVar, this)) {
            return true;
        }
        if (this.f1018g != null) {
            try {
                eVar.getContext().startActivity(this.f1018g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        x0.b bVar = this.A;
        return bVar != null && bVar.onPerformDefaultAction();
    }

    public boolean isActionButton() {
        return (this.f1035x & 32) == 32;
    }

    @Override // q0.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1035x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1035x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1035x & 16) != 0;
    }

    public boolean isExclusiveCheckable() {
        return (this.f1035x & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        x0.b bVar = this.A;
        return (bVar == null || !bVar.overridesItemVisibility()) ? (this.f1035x & 8) == 0 : (this.f1035x & 8) == 0 && this.A.isVisible();
    }

    public boolean requestsActionButton() {
        return (this.f1036y & 1) == 1;
    }

    public boolean requiresActionButton() {
        return (this.f1036y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public void setActionViewExpanded(boolean z10) {
        this.C = z10;
        this.f1025n.onItemsChanged(false);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f1021j == c10) {
            return this;
        }
        this.f1021j = Character.toLowerCase(c10);
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f1035x;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f1035x = i11;
        if (i10 != i11) {
            this.f1025n.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        int i10 = this.f1035x;
        int i11 = i10 & 4;
        e eVar = this.f1025n;
        if (i11 != 0) {
            eVar.getClass();
            int groupId = getGroupId();
            ArrayList<g> arrayList = eVar.f990f;
            int size = arrayList.size();
            eVar.stopDispatchingItemsChanged();
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = arrayList.get(i12);
                if (gVar.getGroupId() == groupId && gVar.isExclusiveCheckable() && gVar.isCheckable()) {
                    boolean z11 = gVar == this;
                    int i13 = gVar.f1035x;
                    int i14 = (z11 ? 2 : 0) | (i13 & (-3));
                    gVar.f1035x = i14;
                    if (i13 != i14) {
                        gVar.f1025n.onItemsChanged(false);
                    }
                }
            }
            eVar.startDispatchingItemsChanged();
        } else {
            int i15 = (z10 ? 2 : 0) | (i10 & (-3));
            this.f1035x = i15;
            if (i10 != i15) {
                eVar.onItemsChanged(false);
            }
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1035x |= 16;
        } else {
            this.f1035x &= -17;
        }
        this.f1025n.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean z10) {
        this.f1035x = (z10 ? 4 : 0) | (this.f1035x & (-5));
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1024m = 0;
        this.f1023l = drawable;
        this.f1034w = true;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1030s = colorStateList;
        this.f1032u = true;
        this.f1034w = true;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1031t = mode;
        this.f1033v = true;
        this.f1034w = true;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1018g = intent;
        return this;
    }

    public void setIsActionButton(boolean z10) {
        if (z10) {
            this.f1035x |= 32;
        } else {
            this.f1035x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f1019h == c10) {
            return this;
        }
        this.f1019h = c10;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1027p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1019h = c10;
        this.f1021j = Character.toLowerCase(c11);
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1036y = i10;
        e eVar = this.f1025n;
        eVar.f995k = true;
        eVar.onItemsChanged(true);
    }

    public void setSubMenu(l lVar) {
        this.f1026o = lVar;
        lVar.setHeaderTitle(getTitle());
    }

    @Override // q0.b
    public q0.b setSupportActionProvider(x0.b bVar) {
        x0.b bVar2 = this.A;
        if (bVar2 != null) {
            bVar2.reset();
        }
        this.f1037z = null;
        this.A = bVar;
        this.f1025n.onItemsChanged(true);
        x0.b bVar3 = this.A;
        if (bVar3 != null) {
            bVar3.setVisibilityListener(new a());
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1016e = charSequence;
        this.f1025n.onItemsChanged(false);
        l lVar = this.f1026o;
        if (lVar != null) {
            lVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1017f = charSequence;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        int i10 = this.f1035x;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f1035x = i11;
        if (i10 != i11) {
            e eVar = this.f1025n;
            eVar.f992h = true;
            eVar.onItemsChanged(true);
        }
        return this;
    }

    public boolean shouldShowIcon() {
        this.f1025n.getClass();
        return false;
    }

    public boolean showsTextAsAction() {
        return (this.f1036y & 4) == 4;
    }

    public String toString() {
        CharSequence charSequence = this.f1016e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // android.view.MenuItem
    public q0.b setContentDescription(CharSequence charSequence) {
        this.f1028q = charSequence;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public q0.b setTooltipText(CharSequence charSequence) {
        this.f1029r = charSequence;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setActionView(View view) {
        int i10;
        this.f1037z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i10 = this.f1012a) > 0) {
            view.setId(i10);
        }
        e eVar = this.f1025n;
        eVar.f995k = true;
        eVar.onItemsChanged(true);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f1021j == c10 && this.f1022k == i10) {
            return this;
        }
        this.f1021j = Character.toLowerCase(c10);
        this.f1022k = KeyEvent.normalizeMetaState(i10);
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f1019h == c10 && this.f1020i == i10) {
            return this;
        }
        this.f1019h = c10;
        this.f1020i = KeyEvent.normalizeMetaState(i10);
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // q0.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1019h = c10;
        this.f1020i = KeyEvent.normalizeMetaState(i10);
        this.f1021j = Character.toLowerCase(c11);
        this.f1022k = KeyEvent.normalizeMetaState(i11);
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1023l = null;
        this.f1024m = i10;
        this.f1034w = true;
        this.f1025n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f1025n.getContext().getString(i10));
    }

    @Override // q0.b, android.view.MenuItem
    public q0.b setActionView(int i10) {
        Context context = this.f1025n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false));
        return this;
    }
}
