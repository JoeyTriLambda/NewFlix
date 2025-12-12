package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;

/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public final class e1 implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f1318a;

    /* renamed from: b, reason: collision with root package name */
    public int f1319b;

    /* renamed from: c, reason: collision with root package name */
    public v0 f1320c;

    /* renamed from: d, reason: collision with root package name */
    public View f1321d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1322e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1323f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1324g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1325h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f1326i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f1327j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f1328k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f1329l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1330m;

    /* renamed from: n, reason: collision with root package name */
    public c f1331n;

    /* renamed from: o, reason: collision with root package name */
    public int f1332o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f1333p;

    /* compiled from: ToolbarWidgetWrapper.java */
    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final x.a f1334b;

        public a() {
            this.f1334b = new x.a(e1.this.f1318a.getContext(), 0, R.id.home, 0, 0, e1.this.f1326i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e1 e1Var = e1.this;
            Window.Callback callback = e1Var.f1329l;
            if (callback == null || !e1Var.f1330m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1334b);
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    public class b extends x0.t0 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1336a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1337b;

        public b(int i10) {
            this.f1337b = i10;
        }

        @Override // x0.t0, x0.s0
        public void onAnimationCancel(View view) {
            this.f1336a = true;
        }

        @Override // x0.s0
        public void onAnimationEnd(View view) {
            if (this.f1336a) {
                return;
            }
            e1.this.f1318a.setVisibility(this.f1337b);
        }

        @Override // x0.t0, x0.s0
        public void onAnimationStart(View view) {
            e1.this.f1318a.setVisibility(0);
        }
    }

    public e1(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, androidx.appcompat.R.string.abc_action_bar_up_description, androidx.appcompat.R.drawable.abc_ic_ab_back_material);
    }

    public final void a() {
        Drawable drawable;
        int i10 = this.f1319b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) == 0 || (drawable = this.f1323f) == null) {
            drawable = this.f1322e;
        }
        this.f1318a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.h0
    public boolean canShowOverflowMenu() {
        return this.f1318a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.h0
    public void collapseActionView() {
        this.f1318a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.h0
    public void dismissPopupMenus() {
        this.f1318a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.h0
    public Context getContext() {
        return this.f1318a.getContext();
    }

    @Override // androidx.appcompat.widget.h0
    public int getDisplayOptions() {
        return this.f1319b;
    }

    @Override // androidx.appcompat.widget.h0
    public Menu getMenu() {
        return this.f1318a.getMenu();
    }

    @Override // androidx.appcompat.widget.h0
    public int getNavigationMode() {
        return 0;
    }

    @Override // androidx.appcompat.widget.h0
    public CharSequence getTitle() {
        return this.f1318a.getTitle();
    }

    @Override // androidx.appcompat.widget.h0
    public ViewGroup getViewGroup() {
        return this.f1318a;
    }

    @Override // androidx.appcompat.widget.h0
    public boolean hasExpandedActionView() {
        return this.f1318a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.h0
    public boolean hideOverflowMenu() {
        return this.f1318a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.h0
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.h0
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.h0
    public boolean isOverflowMenuShowPending() {
        return this.f1318a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.h0
    public boolean isOverflowMenuShowing() {
        return this.f1318a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.h0
    public void setCollapsible(boolean z10) {
        this.f1318a.setCollapsible(z10);
    }

    public void setCustomView(View view) {
        View view2 = this.f1321d;
        Toolbar toolbar = this.f1318a;
        if (view2 != null && (this.f1319b & 16) != 0) {
            toolbar.removeView(view2);
        }
        this.f1321d = view;
        if (view == null || (this.f1319b & 16) == 0) {
            return;
        }
        toolbar.addView(view);
    }

    public void setDefaultNavigationContentDescription(int i10) {
        if (i10 == this.f1332o) {
            return;
        }
        this.f1332o = i10;
        if (TextUtils.isEmpty(this.f1318a.getNavigationContentDescription())) {
            setNavigationContentDescription(this.f1332o);
        }
    }

    @Override // androidx.appcompat.widget.h0
    public void setDisplayOptions(int i10) {
        View view;
        int i11 = this.f1319b ^ i10;
        this.f1319b = i10;
        if (i11 != 0) {
            int i12 = i11 & 4;
            Toolbar toolbar = this.f1318a;
            if (i12 != 0) {
                if ((i10 & 4) != 0 && (i10 & 4) != 0) {
                    if (TextUtils.isEmpty(this.f1328k)) {
                        toolbar.setNavigationContentDescription(this.f1332o);
                    } else {
                        toolbar.setNavigationContentDescription(this.f1328k);
                    }
                }
                if ((this.f1319b & 4) != 0) {
                    Drawable drawable = this.f1324g;
                    if (drawable == null) {
                        drawable = this.f1333p;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i11 & 3) != 0) {
                a();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    toolbar.setTitle(this.f1326i);
                    toolbar.setSubtitle(this.f1327j);
                } else {
                    toolbar.setTitle((CharSequence) null);
                    toolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f1321d) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                toolbar.addView(view);
            } else {
                toolbar.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.h0
    public void setEmbeddedTabView(v0 v0Var) {
        v0 v0Var2 = this.f1320c;
        if (v0Var2 != null) {
            ViewParent parent = v0Var2.getParent();
            Toolbar toolbar = this.f1318a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1320c);
            }
        }
        this.f1320c = v0Var;
    }

    @Override // androidx.appcompat.widget.h0
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.h0
    public void setLogo(int i10) {
        setLogo(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.h0
    public void setMenu(Menu menu, i.a aVar) {
        c cVar = this.f1331n;
        Toolbar toolbar = this.f1318a;
        if (cVar == null) {
            c cVar2 = new c(toolbar.getContext());
            this.f1331n = cVar2;
            cVar2.setId(androidx.appcompat.R.id.action_menu_presenter);
        }
        this.f1331n.setCallback(aVar);
        toolbar.setMenu((androidx.appcompat.view.menu.e) menu, this.f1331n);
    }

    @Override // androidx.appcompat.widget.h0
    public void setMenuCallbacks(i.a aVar, e.a aVar2) {
        this.f1318a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.h0
    public void setMenuPrepared() {
        this.f1330m = true;
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        this.f1328k = charSequence;
        if ((this.f1319b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(charSequence);
            Toolbar toolbar = this.f1318a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.f1332o);
            } else {
                toolbar.setNavigationContentDescription(this.f1328k);
            }
        }
    }

    @Override // androidx.appcompat.widget.h0
    public void setNavigationIcon(Drawable drawable) {
        this.f1324g = drawable;
        int i10 = this.f1319b & 4;
        Toolbar toolbar = this.f1318a;
        if (i10 == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        if (drawable == null) {
            drawable = this.f1333p;
        }
        toolbar.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.h0
    public void setSubtitle(CharSequence charSequence) {
        this.f1327j = charSequence;
        if ((this.f1319b & 8) != 0) {
            this.f1318a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.h0
    public void setTitle(CharSequence charSequence) {
        this.f1325h = true;
        this.f1326i = charSequence;
        if ((this.f1319b & 8) != 0) {
            Toolbar toolbar = this.f1318a;
            toolbar.setTitle(charSequence);
            if (this.f1325h) {
                x0.j0.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.h0
    public void setVisibility(int i10) {
        this.f1318a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.h0
    public void setWindowCallback(Window.Callback callback) {
        this.f1329l = callback;
    }

    @Override // androidx.appcompat.widget.h0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1325h) {
            return;
        }
        this.f1326i = charSequence;
        if ((this.f1319b & 8) != 0) {
            Toolbar toolbar = this.f1318a;
            toolbar.setTitle(charSequence);
            if (this.f1325h) {
                x0.j0.setAccessibilityPaneTitle(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.h0
    public x0.r0 setupAnimatorToVisibility(int i10, long j10) {
        return x0.j0.animate(this.f1318a).alpha(i10 == 0 ? 1.0f : 0.0f).setDuration(j10).setListener(new b(i10));
    }

    @Override // androidx.appcompat.widget.h0
    public boolean showOverflowMenu() {
        return this.f1318a.showOverflowMenu();
    }

    public e1(Toolbar toolbar, boolean z10, int i10, int i11) {
        int i12;
        Drawable drawable;
        this.f1332o = 0;
        this.f1318a = toolbar;
        this.f1326i = toolbar.getTitle();
        this.f1327j = toolbar.getSubtitle();
        this.f1325h = this.f1326i != null;
        this.f1324g = toolbar.getNavigationIcon();
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(toolbar.getContext(), null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        this.f1333p = c1VarObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence text = c1VarObtainStyledAttributes.getText(androidx.appcompat.R.styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = c1VarObtainStyledAttributes.getText(androidx.appcompat.R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                setSubtitle(text2);
            }
            Drawable drawable2 = c1VarObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_logo);
            if (drawable2 != null) {
                setLogo(drawable2);
            }
            Drawable drawable3 = c1VarObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActionBar_icon);
            if (drawable3 != null) {
                setIcon(drawable3);
            }
            if (this.f1324g == null && (drawable = this.f1333p) != null) {
                setNavigationIcon(drawable);
            }
            setDisplayOptions(c1VarObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActionBar_displayOptions, 0));
            int resourceId = c1VarObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                setCustomView(LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false));
                setDisplayOptions(this.f1319b | 16);
            }
            int layoutDimension = c1VarObtainStyledAttributes.getLayoutDimension(androidx.appcompat.R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = c1VarObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = c1VarObtainStyledAttributes.getDimensionPixelOffset(androidx.appcompat.R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.setContentInsetsRelative(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = c1VarObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                toolbar.setTitleTextAppearance(toolbar.getContext(), resourceId2);
            }
            int resourceId3 = c1VarObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                toolbar.setSubtitleTextAppearance(toolbar.getContext(), resourceId3);
            }
            int resourceId4 = c1VarObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.f1333p = toolbar.getNavigationIcon();
                i12 = 15;
            } else {
                i12 = 11;
            }
            this.f1319b = i12;
        }
        c1VarObtainStyledAttributes.recycle();
        setDefaultNavigationContentDescription(i10);
        this.f1328k = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.h0
    public void setIcon(Drawable drawable) {
        this.f1322e = drawable;
        a();
    }

    public void setLogo(Drawable drawable) {
        this.f1323f = drawable;
        a();
    }

    @Override // androidx.appcompat.widget.h0
    public void setNavigationIcon(int i10) {
        setNavigationIcon(i10 != 0 ? s.a.getDrawable(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.h0
    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 == 0 ? null : getContext().getString(i10));
    }

    @Override // androidx.appcompat.widget.h0
    public void setHomeButtonEnabled(boolean z10) {
    }
}
