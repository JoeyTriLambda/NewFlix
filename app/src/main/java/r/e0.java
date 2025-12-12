package r;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.h0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import r.a;
import w.b;
import x0.j0;
import x0.r0;
import x0.t0;
import x0.u0;

/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public final class e0 extends r.a implements ActionBarOverlayLayout.d {
    public static final AccelerateInterpolator A = new AccelerateInterpolator();
    public static final DecelerateInterpolator B = new DecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    public Context f18205a;

    /* renamed from: b, reason: collision with root package name */
    public Context f18206b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f18207c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f18208d;

    /* renamed from: e, reason: collision with root package name */
    public h0 f18209e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f18210f;

    /* renamed from: g, reason: collision with root package name */
    public final View f18211g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18212h;

    /* renamed from: i, reason: collision with root package name */
    public d f18213i;

    /* renamed from: j, reason: collision with root package name */
    public d f18214j;

    /* renamed from: k, reason: collision with root package name */
    public b.a f18215k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f18216l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<a.b> f18217m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f18218n;

    /* renamed from: o, reason: collision with root package name */
    public int f18219o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f18220p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f18221q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f18222r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f18223s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f18224t;

    /* renamed from: u, reason: collision with root package name */
    public w.h f18225u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f18226v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f18227w;

    /* renamed from: x, reason: collision with root package name */
    public final a f18228x;

    /* renamed from: y, reason: collision with root package name */
    public final b f18229y;

    /* renamed from: z, reason: collision with root package name */
    public final c f18230z;

    /* compiled from: WindowDecorActionBar.java */
    public class a extends t0 {
        public a() {
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            View view2;
            e0 e0Var = e0.this;
            if (e0Var.f18220p && (view2 = e0Var.f18211g) != null) {
                view2.setTranslationY(0.0f);
                e0Var.f18208d.setTranslationY(0.0f);
            }
            e0Var.f18208d.setVisibility(8);
            e0Var.f18208d.setTransitioning(false);
            e0Var.f18225u = null;
            b.a aVar = e0Var.f18215k;
            if (aVar != null) {
                aVar.onDestroyActionMode(e0Var.f18214j);
                e0Var.f18214j = null;
                e0Var.f18215k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = e0Var.f18207c;
            if (actionBarOverlayLayout != null) {
                j0.requestApplyInsets(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class b extends t0 {
        public b() {
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            e0 e0Var = e0.this;
            e0Var.f18225u = null;
            e0Var.f18208d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class c implements u0 {
        public c() {
        }

        public void onAnimationUpdate(View view) {
            ((View) e0.this.f18208d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    public class d extends w.b implements e.a {

        /* renamed from: n, reason: collision with root package name */
        public final Context f18234n;

        /* renamed from: o, reason: collision with root package name */
        public final androidx.appcompat.view.menu.e f18235o;

        /* renamed from: p, reason: collision with root package name */
        public b.a f18236p;

        /* renamed from: q, reason: collision with root package name */
        public WeakReference<View> f18237q;

        public d(Context context, b.a aVar) {
            this.f18234n = context;
            this.f18236p = aVar;
            androidx.appcompat.view.menu.e defaultShowAsAction = new androidx.appcompat.view.menu.e(context).setDefaultShowAsAction(1);
            this.f18235o = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        public boolean dispatchOnCreate() {
            androidx.appcompat.view.menu.e eVar = this.f18235o;
            eVar.stopDispatchingItemsChanged();
            try {
                return this.f18236p.onCreateActionMode(this, eVar);
            } finally {
                eVar.startDispatchingItemsChanged();
            }
        }

        @Override // w.b
        public void finish() {
            e0 e0Var = e0.this;
            if (e0Var.f18213i != this) {
                return;
            }
            if ((e0Var.f18221q || e0Var.f18222r) ? false : true) {
                this.f18236p.onDestroyActionMode(this);
            } else {
                e0Var.f18214j = this;
                e0Var.f18215k = this.f18236p;
            }
            this.f18236p = null;
            e0Var.animateToMode(false);
            e0Var.f18210f.closeMode();
            e0Var.f18207c.setHideOnContentScrollEnabled(e0Var.f18227w);
            e0Var.f18213i = null;
        }

        @Override // w.b
        public View getCustomView() {
            WeakReference<View> weakReference = this.f18237q;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // w.b
        public Menu getMenu() {
            return this.f18235o;
        }

        @Override // w.b
        public MenuInflater getMenuInflater() {
            return new w.g(this.f18234n);
        }

        @Override // w.b
        public CharSequence getSubtitle() {
            return e0.this.f18210f.getSubtitle();
        }

        @Override // w.b
        public CharSequence getTitle() {
            return e0.this.f18210f.getTitle();
        }

        @Override // w.b
        public void invalidate() {
            if (e0.this.f18213i != this) {
                return;
            }
            androidx.appcompat.view.menu.e eVar = this.f18235o;
            eVar.stopDispatchingItemsChanged();
            try {
                this.f18236p.onPrepareActionMode(this, eVar);
            } finally {
                eVar.startDispatchingItemsChanged();
            }
        }

        @Override // w.b
        public boolean isTitleOptional() {
            return e0.this.f18210f.isTitleOptional();
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            b.a aVar = this.f18236p;
            if (aVar != null) {
                return aVar.onActionItemClicked(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void onMenuModeChange(androidx.appcompat.view.menu.e eVar) {
            if (this.f18236p == null) {
                return;
            }
            invalidate();
            e0.this.f18210f.showOverflowMenu();
        }

        @Override // w.b
        public void setCustomView(View view) {
            e0.this.f18210f.setCustomView(view);
            this.f18237q = new WeakReference<>(view);
        }

        @Override // w.b
        public void setSubtitle(CharSequence charSequence) {
            e0.this.f18210f.setSubtitle(charSequence);
        }

        @Override // w.b
        public void setTitle(CharSequence charSequence) {
            e0.this.f18210f.setTitle(charSequence);
        }

        @Override // w.b
        public void setTitleOptionalHint(boolean z10) {
            super.setTitleOptionalHint(z10);
            e0.this.f18210f.setTitleOptional(z10);
        }

        @Override // w.b
        public void setSubtitle(int i10) {
            setSubtitle(e0.this.f18205a.getResources().getString(i10));
        }

        @Override // w.b
        public void setTitle(int i10) {
            setTitle(e0.this.f18205a.getResources().getString(i10));
        }
    }

    public e0(Activity activity, boolean z10) {
        new ArrayList();
        this.f18217m = new ArrayList<>();
        this.f18219o = 0;
        this.f18220p = true;
        this.f18224t = true;
        this.f18228x = new a();
        this.f18229y = new b();
        this.f18230z = new c();
        View decorView = activity.getWindow().getDecorView();
        b(decorView);
        if (z10) {
            return;
        }
        this.f18211g = decorView.findViewById(R.id.content);
    }

    public void animateToMode(boolean z10) {
        r0 r0Var;
        r0 r0Var2;
        if (z10) {
            if (!this.f18223s) {
                this.f18223s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f18207c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                d(false);
            }
        } else if (this.f18223s) {
            this.f18223s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f18207c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            d(false);
        }
        if (!j0.isLaidOut(this.f18208d)) {
            if (z10) {
                this.f18209e.setVisibility(4);
                this.f18210f.setVisibility(0);
                return;
            } else {
                this.f18209e.setVisibility(0);
                this.f18210f.setVisibility(8);
                return;
            }
        }
        if (z10) {
            r0Var2 = this.f18209e.setupAnimatorToVisibility(4, 100L);
            r0Var = this.f18210f.setupAnimatorToVisibility(0, 200L);
        } else {
            r0Var = this.f18209e.setupAnimatorToVisibility(0, 200L);
            r0Var2 = this.f18210f.setupAnimatorToVisibility(8, 100L);
        }
        w.h hVar = new w.h();
        hVar.playSequentially(r0Var2, r0Var);
        hVar.start();
    }

    public final void b(View view) {
        h0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f18207c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(androidx.appcompat.R.id.action_bar);
        if (callbackFindViewById instanceof h0) {
            wrapper = (h0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f18209e = wrapper;
        this.f18210f = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f18208d = actionBarContainer;
        h0 h0Var = this.f18209e;
        if (h0Var == null || this.f18210f == null || actionBarContainer == null) {
            throw new IllegalStateException(e0.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        this.f18205a = h0Var.getContext();
        boolean z10 = (this.f18209e.getDisplayOptions() & 4) != 0;
        if (z10) {
            this.f18212h = true;
        }
        w.a aVar = w.a.get(this.f18205a);
        setHomeButtonEnabled(aVar.enableHomeButtonByDefault() || z10);
        c(aVar.hasEmbeddedTabs());
        TypedArray typedArrayObtainStyledAttributes = this.f18205a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void c(boolean z10) {
        this.f18218n = z10;
        if (z10) {
            this.f18208d.setTabContainer(null);
            this.f18209e.setEmbeddedTabView(null);
        } else {
            this.f18209e.setEmbeddedTabView(null);
            this.f18208d.setTabContainer(null);
        }
        boolean z11 = getNavigationMode() == 2;
        this.f18209e.setCollapsible(!this.f18218n && z11);
        this.f18207c.setHasNonEmbeddedTabs(!this.f18218n && z11);
    }

    @Override // r.a
    public boolean collapseActionView() {
        h0 h0Var = this.f18209e;
        if (h0Var == null || !h0Var.hasExpandedActionView()) {
            return false;
        }
        this.f18209e.collapseActionView();
        return true;
    }

    public final void d(boolean z10) {
        if (this.f18223s || !(this.f18221q || this.f18222r)) {
            if (this.f18224t) {
                return;
            }
            this.f18224t = true;
            doShow(z10);
            return;
        }
        if (this.f18224t) {
            this.f18224t = false;
            doHide(z10);
        }
    }

    @Override // r.a
    public void dispatchMenuVisibilityChanged(boolean z10) {
        if (z10 == this.f18216l) {
            return;
        }
        this.f18216l = z10;
        ArrayList<a.b> arrayList = this.f18217m;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onMenuVisibilityChanged(z10);
        }
    }

    public void doHide(boolean z10) {
        View view;
        w.h hVar = this.f18225u;
        if (hVar != null) {
            hVar.cancel();
        }
        int i10 = this.f18219o;
        a aVar = this.f18228x;
        if (i10 != 0 || (!this.f18226v && !z10)) {
            aVar.onAnimationEnd(null);
            return;
        }
        this.f18208d.setAlpha(1.0f);
        this.f18208d.setTransitioning(true);
        w.h hVar2 = new w.h();
        float f10 = -this.f18208d.getHeight();
        if (z10) {
            this.f18208d.getLocationInWindow(new int[]{0, 0});
            f10 -= r6[1];
        }
        r0 r0VarTranslationY = j0.animate(this.f18208d).translationY(f10);
        r0VarTranslationY.setUpdateListener(this.f18230z);
        hVar2.play(r0VarTranslationY);
        if (this.f18220p && (view = this.f18211g) != null) {
            hVar2.play(j0.animate(view).translationY(f10));
        }
        hVar2.setInterpolator(A);
        hVar2.setDuration(250L);
        hVar2.setListener(aVar);
        this.f18225u = hVar2;
        hVar2.start();
    }

    public void doShow(boolean z10) {
        w.h hVar = this.f18225u;
        if (hVar != null) {
            hVar.cancel();
        }
        this.f18208d.setVisibility(0);
        int i10 = this.f18219o;
        b bVar = this.f18229y;
        View view = this.f18211g;
        if (i10 == 0 && (this.f18226v || z10)) {
            this.f18208d.setTranslationY(0.0f);
            float f10 = -this.f18208d.getHeight();
            if (z10) {
                this.f18208d.getLocationInWindow(new int[]{0, 0});
                f10 -= r7[1];
            }
            this.f18208d.setTranslationY(f10);
            w.h hVar2 = new w.h();
            r0 r0VarTranslationY = j0.animate(this.f18208d).translationY(0.0f);
            r0VarTranslationY.setUpdateListener(this.f18230z);
            hVar2.play(r0VarTranslationY);
            if (this.f18220p && view != null) {
                view.setTranslationY(f10);
                hVar2.play(j0.animate(view).translationY(0.0f));
            }
            hVar2.setInterpolator(B);
            hVar2.setDuration(250L);
            hVar2.setListener(bVar);
            this.f18225u = hVar2;
            hVar2.start();
        } else {
            this.f18208d.setAlpha(1.0f);
            this.f18208d.setTranslationY(0.0f);
            if (this.f18220p && view != null) {
                view.setTranslationY(0.0f);
            }
            bVar.onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f18207c;
        if (actionBarOverlayLayout != null) {
            j0.requestApplyInsets(actionBarOverlayLayout);
        }
    }

    public void enableContentAnimations(boolean z10) {
        this.f18220p = z10;
    }

    @Override // r.a
    public int getDisplayOptions() {
        return this.f18209e.getDisplayOptions();
    }

    public int getNavigationMode() {
        return this.f18209e.getNavigationMode();
    }

    @Override // r.a
    public Context getThemedContext() {
        if (this.f18206b == null) {
            TypedValue typedValue = new TypedValue();
            this.f18205a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f18206b = new ContextThemeWrapper(this.f18205a, i10);
            } else {
                this.f18206b = this.f18205a;
            }
        }
        return this.f18206b;
    }

    @Override // r.a
    public void hide() {
        if (this.f18221q) {
            return;
        }
        this.f18221q = true;
        d(false);
    }

    public void hideForSystem() {
        if (this.f18222r) {
            return;
        }
        this.f18222r = true;
        d(true);
    }

    @Override // r.a
    public void onConfigurationChanged(Configuration configuration) {
        c(w.a.get(this.f18205a).hasEmbeddedTabs());
    }

    public void onContentScrollStarted() {
        w.h hVar = this.f18225u;
        if (hVar != null) {
            hVar.cancel();
            this.f18225u = null;
        }
    }

    @Override // r.a
    public boolean onKeyShortcut(int i10, KeyEvent keyEvent) {
        Menu menu;
        d dVar = this.f18213i;
        if (dVar == null || (menu = dVar.getMenu()) == null) {
            return false;
        }
        menu.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menu.performShortcut(i10, keyEvent, 0);
    }

    public void onWindowVisibilityChanged(int i10) {
        this.f18219o = i10;
    }

    @Override // r.a
    public void setDefaultDisplayHomeAsUpEnabled(boolean z10) {
        if (this.f18212h) {
            return;
        }
        setDisplayHomeAsUpEnabled(z10);
    }

    @Override // r.a
    public void setDisplayHomeAsUpEnabled(boolean z10) {
        setDisplayOptions(z10 ? 4 : 0, 4);
    }

    public void setDisplayOptions(int i10, int i11) {
        int displayOptions = this.f18209e.getDisplayOptions();
        if ((i11 & 4) != 0) {
            this.f18212h = true;
        }
        this.f18209e.setDisplayOptions((i10 & i11) | ((~i11) & displayOptions));
    }

    public void setElevation(float f10) {
        j0.setElevation(this.f18208d, f10);
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 && !this.f18207c.isInOverlayMode()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f18227w = z10;
        this.f18207c.setHideOnContentScrollEnabled(z10);
    }

    @Override // r.a
    public void setHomeActionContentDescription(int i10) {
        this.f18209e.setNavigationContentDescription(i10);
    }

    @Override // r.a
    public void setHomeAsUpIndicator(Drawable drawable) {
        this.f18209e.setNavigationIcon(drawable);
    }

    @Override // r.a
    public void setHomeButtonEnabled(boolean z10) {
        this.f18209e.setHomeButtonEnabled(z10);
    }

    @Override // r.a
    public void setShowHideAnimationEnabled(boolean z10) {
        w.h hVar;
        this.f18226v = z10;
        if (z10 || (hVar = this.f18225u) == null) {
            return;
        }
        hVar.cancel();
    }

    @Override // r.a
    public void setSubtitle(CharSequence charSequence) {
        this.f18209e.setSubtitle(charSequence);
    }

    @Override // r.a
    public void setTitle(CharSequence charSequence) {
        this.f18209e.setTitle(charSequence);
    }

    @Override // r.a
    public void setWindowTitle(CharSequence charSequence) {
        this.f18209e.setWindowTitle(charSequence);
    }

    public void showForSystem() {
        if (this.f18222r) {
            this.f18222r = false;
            d(true);
        }
    }

    @Override // r.a
    public w.b startActionMode(b.a aVar) {
        d dVar = this.f18213i;
        if (dVar != null) {
            dVar.finish();
        }
        this.f18207c.setHideOnContentScrollEnabled(false);
        this.f18210f.killMode();
        d dVar2 = new d(this.f18210f.getContext(), aVar);
        if (!dVar2.dispatchOnCreate()) {
            return null;
        }
        this.f18213i = dVar2;
        dVar2.invalidate();
        this.f18210f.initForMode(dVar2);
        animateToMode(true);
        return dVar2;
    }

    @Override // r.a
    public void setHomeAsUpIndicator(int i10) {
        this.f18209e.setNavigationIcon(i10);
    }

    public e0(Dialog dialog) {
        new ArrayList();
        this.f18217m = new ArrayList<>();
        this.f18219o = 0;
        this.f18220p = true;
        this.f18224t = true;
        this.f18228x = new a();
        this.f18229y = new b();
        this.f18230z = new c();
        b(dialog.getWindow().getDecorView());
    }

    public void onContentScrollStopped() {
    }
}
