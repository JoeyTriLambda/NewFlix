package r;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.e1;
import java.util.ArrayList;
import r.a;
import r.n;
import x0.j0;

/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public final class b0 extends r.a {

    /* renamed from: a, reason: collision with root package name */
    public final e1 f18164a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f18165b;

    /* renamed from: c, reason: collision with root package name */
    public final e f18166c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f18167d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f18168e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f18169f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<a.b> f18170g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public final a f18171h = new a();

    /* compiled from: ToolbarActionBar.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b0 b0Var = b0.this;
            Window.Callback callback = b0Var.f18165b;
            boolean z10 = b0Var.f18168e;
            e1 e1Var = b0Var.f18164a;
            if (!z10) {
                e1Var.setMenuCallbacks(b0Var.new c(), b0Var.new d());
                b0Var.f18168e = true;
            }
            Menu menu = e1Var.getMenu();
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (eVar != null) {
                eVar.stopDispatchingItemsChanged();
            }
            try {
                menu.clear();
                if (!callback.onCreatePanelMenu(0, menu) || !callback.onPreparePanel(0, null, menu)) {
                    menu.clear();
                }
            } finally {
                if (eVar != null) {
                    eVar.startDispatchingItemsChanged();
                }
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public class b implements Toolbar.h {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.h
        public boolean onMenuItemClick(MenuItem menuItem) {
            return b0.this.f18165b.onMenuItemSelected(0, menuItem);
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public final class c implements i.a {

        /* renamed from: b, reason: collision with root package name */
        public boolean f18174b;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.i.a
        public void onCloseMenu(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (this.f18174b) {
                return;
            }
            this.f18174b = true;
            b0 b0Var = b0.this;
            b0Var.f18164a.dismissPopupMenus();
            b0Var.f18165b.onPanelClosed(108, eVar);
            this.f18174b = false;
        }

        @Override // androidx.appcompat.view.menu.i.a
        public boolean onOpenSubMenu(androidx.appcompat.view.menu.e eVar) {
            b0.this.f18165b.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public final class d implements e.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            b0 b0Var = b0.this;
            boolean zIsOverflowMenuShowing = b0Var.f18164a.isOverflowMenuShowing();
            Window.Callback callback = b0Var.f18165b;
            if (zIsOverflowMenuShowing) {
                callback.onPanelClosed(108, eVar);
            } else if (callback.onPreparePanel(0, null, eVar)) {
                callback.onMenuOpened(108, eVar);
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    public class e implements n.c {
        public e() {
        }

        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(b0.this.f18164a.getContext());
            }
            return null;
        }

        public boolean onPreparePanel(int i10) {
            if (i10 != 0) {
                return false;
            }
            b0 b0Var = b0.this;
            if (b0Var.f18167d) {
                return false;
            }
            b0Var.f18164a.setMenuPrepared();
            b0Var.f18167d = true;
            return false;
        }
    }

    public b0(Toolbar toolbar, CharSequence charSequence, n.j jVar) {
        b bVar = new b();
        w0.h.checkNotNull(toolbar);
        e1 e1Var = new e1(toolbar, false);
        this.f18164a = e1Var;
        this.f18165b = (Window.Callback) w0.h.checkNotNull(jVar);
        e1Var.setWindowCallback(jVar);
        toolbar.setOnMenuItemClickListener(bVar);
        e1Var.setWindowTitle(charSequence);
        this.f18166c = new e();
    }

    @Override // r.a
    public final void a() {
        this.f18164a.getViewGroup().removeCallbacks(this.f18171h);
    }

    @Override // r.a
    public boolean closeOptionsMenu() {
        return this.f18164a.hideOverflowMenu();
    }

    @Override // r.a
    public boolean collapseActionView() {
        e1 e1Var = this.f18164a;
        if (!e1Var.hasExpandedActionView()) {
            return false;
        }
        e1Var.collapseActionView();
        return true;
    }

    @Override // r.a
    public void dispatchMenuVisibilityChanged(boolean z10) {
        if (z10 == this.f18169f) {
            return;
        }
        this.f18169f = z10;
        ArrayList<a.b> arrayList = this.f18170g;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onMenuVisibilityChanged(z10);
        }
    }

    @Override // r.a
    public int getDisplayOptions() {
        return this.f18164a.getDisplayOptions();
    }

    @Override // r.a
    public Context getThemedContext() {
        return this.f18164a.getContext();
    }

    @Override // r.a
    public void hide() {
        this.f18164a.setVisibility(8);
    }

    @Override // r.a
    public boolean invalidateOptionsMenu() {
        e1 e1Var = this.f18164a;
        ViewGroup viewGroup = e1Var.getViewGroup();
        a aVar = this.f18171h;
        viewGroup.removeCallbacks(aVar);
        j0.postOnAnimation(e1Var.getViewGroup(), aVar);
        return true;
    }

    @Override // r.a
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // r.a
    public boolean onKeyShortcut(int i10, KeyEvent keyEvent) {
        boolean z10 = this.f18168e;
        e1 e1Var = this.f18164a;
        if (!z10) {
            e1Var.setMenuCallbacks(new c(), new d());
            this.f18168e = true;
        }
        Menu menu = e1Var.getMenu();
        if (menu == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i10, keyEvent, 0);
    }

    @Override // r.a
    public boolean onMenuKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            openOptionsMenu();
        }
        return true;
    }

    @Override // r.a
    public boolean openOptionsMenu() {
        return this.f18164a.showOverflowMenu();
    }

    @Override // r.a
    public void setDisplayHomeAsUpEnabled(boolean z10) {
        setDisplayOptions(z10 ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i10, int i11) {
        e1 e1Var = this.f18164a;
        e1Var.setDisplayOptions((i10 & i11) | ((~i11) & e1Var.getDisplayOptions()));
    }

    @Override // r.a
    public void setHomeActionContentDescription(int i10) {
        this.f18164a.setNavigationContentDescription(i10);
    }

    @Override // r.a
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f18164a.setNavigationIcon(drawable);
    }

    @Override // r.a
    public void setSubtitle(CharSequence charSequence) {
        this.f18164a.setSubtitle(charSequence);
    }

    @Override // r.a
    public void setTitle(CharSequence charSequence) {
        this.f18164a.setTitle(charSequence);
    }

    @Override // r.a
    public void setWindowTitle(CharSequence charSequence) {
        this.f18164a.setWindowTitle(charSequence);
    }

    @Override // r.a
    public void setHomeAsUpIndicator(int i10) {
        this.f18164a.setNavigationIcon(i10);
    }

    @Override // r.a
    public void setDefaultDisplayHomeAsUpEnabled(boolean z10) {
    }

    @Override // r.a
    public void setHomeButtonEnabled(boolean z10) {
    }

    @Override // r.a
    public void setShowHideAnimationEnabled(boolean z10) {
    }
}
