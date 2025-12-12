package r;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

/* compiled from: ActionBarDrawerToggle.java */
/* loaded from: classes.dex */
public class c implements DrawerLayout.e {

    /* renamed from: a, reason: collision with root package name */
    public final a f18178a;

    /* renamed from: b, reason: collision with root package name */
    public final DrawerLayout f18179b;

    /* renamed from: c, reason: collision with root package name */
    public final t.d f18180c;

    /* renamed from: f, reason: collision with root package name */
    public final int f18183f;

    /* renamed from: g, reason: collision with root package name */
    public final int f18184g;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f18181d = true;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18182e = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18185h = false;

    /* compiled from: ActionBarDrawerToggle.java */
    public interface a {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int i10);

        void setActionBarUpIndicator(Drawable drawable, int i10);
    }

    /* compiled from: ActionBarDrawerToggle.java */
    public interface b {
        a getDrawerToggleDelegate();
    }

    /* compiled from: ActionBarDrawerToggle.java */
    /* renamed from: r.c$c, reason: collision with other inner class name */
    public static class C0233c implements a {

        /* renamed from: a, reason: collision with root package name */
        public final Activity f18186a;

        /* compiled from: ActionBarDrawerToggle.java */
        /* renamed from: r.c$c$a */
        public static class a {
            public static void a(ActionBar actionBar, int i10) {
                actionBar.setHomeActionContentDescription(i10);
            }

            public static void b(ActionBar actionBar, Drawable drawable) {
                actionBar.setHomeAsUpIndicator(drawable);
            }
        }

        public C0233c(Activity activity) {
            this.f18186a = activity;
        }

        @Override // r.c.a
        public Context getActionBarThemedContext() {
            Activity activity = this.f18186a;
            ActionBar actionBar = activity.getActionBar();
            return actionBar != null ? actionBar.getThemedContext() : activity;
        }

        @Override // r.c.a
        public Drawable getThemeUpIndicator() {
            TypedArray typedArrayObtainStyledAttributes = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(0);
            typedArrayObtainStyledAttributes.recycle();
            return drawable;
        }

        @Override // r.c.a
        public boolean isNavigationVisible() {
            ActionBar actionBar = this.f18186a.getActionBar();
            return (actionBar == null || (actionBar.getDisplayOptions() & 4) == 0) ? false : true;
        }

        @Override // r.c.a
        public void setActionBarDescription(int i10) {
            ActionBar actionBar = this.f18186a.getActionBar();
            if (actionBar != null) {
                a.a(actionBar, i10);
            }
        }

        @Override // r.c.a
        public void setActionBarUpIndicator(Drawable drawable, int i10) {
            ActionBar actionBar = this.f18186a.getActionBar();
            if (actionBar != null) {
                a.b(actionBar, drawable);
                a.a(actionBar, i10);
            }
        }
    }

    /* compiled from: ActionBarDrawerToggle.java */
    public static class d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final Toolbar f18187a;

        /* renamed from: b, reason: collision with root package name */
        public final Drawable f18188b;

        /* renamed from: c, reason: collision with root package name */
        public final CharSequence f18189c;

        public d(Toolbar toolbar) {
            this.f18187a = toolbar;
            this.f18188b = toolbar.getNavigationIcon();
            this.f18189c = toolbar.getNavigationContentDescription();
        }

        @Override // r.c.a
        public Context getActionBarThemedContext() {
            return this.f18187a.getContext();
        }

        @Override // r.c.a
        public Drawable getThemeUpIndicator() {
            return this.f18188b;
        }

        @Override // r.c.a
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // r.c.a
        public void setActionBarDescription(int i10) {
            Toolbar toolbar = this.f18187a;
            if (i10 == 0) {
                toolbar.setNavigationContentDescription(this.f18189c);
            } else {
                toolbar.setNavigationContentDescription(i10);
            }
        }

        @Override // r.c.a
        public void setActionBarUpIndicator(Drawable drawable, int i10) {
            this.f18187a.setNavigationIcon(drawable);
            setActionBarDescription(i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i10, int i11) {
        if (toolbar != null) {
            this.f18178a = new d(toolbar);
            toolbar.setNavigationOnClickListener(new r.b(this));
        } else if (activity instanceof b) {
            this.f18178a = ((b) activity).getDrawerToggleDelegate();
        } else {
            this.f18178a = new C0233c(activity);
        }
        this.f18179b = drawerLayout;
        this.f18183f = i10;
        this.f18184g = i11;
        this.f18180c = new t.d(this.f18178a.getActionBarThemedContext());
        this.f18178a.getThemeUpIndicator();
    }

    public final void a(float f10) {
        t.d dVar = this.f18180c;
        if (f10 == 1.0f) {
            dVar.setVerticalMirror(true);
        } else if (f10 == 0.0f) {
            dVar.setVerticalMirror(false);
        }
        dVar.setProgress(f10);
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerClosed(View view) {
        a(0.0f);
        if (this.f18182e) {
            this.f18178a.setActionBarDescription(this.f18183f);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerOpened(View view) {
        a(1.0f);
        if (this.f18182e) {
            this.f18178a.setActionBarDescription(this.f18184g);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerSlide(View view, float f10) {
        if (this.f18181d) {
            a(Math.min(1.0f, Math.max(0.0f, f10)));
        } else {
            a(0.0f);
        }
    }

    public void syncState() {
        DrawerLayout drawerLayout = this.f18179b;
        if (drawerLayout.isDrawerOpen(8388611)) {
            a(1.0f);
        } else {
            a(0.0f);
        }
        if (this.f18182e) {
            int i10 = drawerLayout.isDrawerOpen(8388611) ? this.f18184g : this.f18183f;
            boolean z10 = this.f18185h;
            a aVar = this.f18178a;
            if (!z10 && !aVar.isNavigationVisible()) {
                Log.w("ActionBarDrawerToggle", "DrawerToggle may not show up because NavigationIcon is not visible. You may need to call actionbar.setDisplayHomeAsUpEnabled(true);");
                this.f18185h = true;
            }
            aVar.setActionBarUpIndicator(this.f18180c, i10);
        }
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.e
    public void onDrawerStateChanged(int i10) {
    }
}
