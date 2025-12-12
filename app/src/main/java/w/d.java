package w;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R;

/* compiled from: ContextThemeWrapper.java */
/* loaded from: classes.dex */
public final class d extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f20780f;

    /* renamed from: a, reason: collision with root package name */
    public int f20781a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f20782b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f20783c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f20784d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f20785e;

    /* compiled from: ContextThemeWrapper.java */
    public static class a {
        public static Context a(d dVar, Configuration configuration) {
            return dVar.createConfigurationContext(configuration);
        }
    }

    public d() {
        super(null);
    }

    public final void a() {
        boolean z10 = this.f20782b == null;
        if (z10) {
            this.f20782b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f20782b.setTo(theme);
            }
        }
        onApplyThemeResource(this.f20782b, this.f20781a, z10);
    }

    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.f20785e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f20784d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f20784d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f20785e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f20784d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = w.d.f20780f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            w.d.f20780f = r1
        L1c:
            android.content.res.Configuration r1 = w.d.f20780f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f20784d
            android.content.Context r0 = w.d.a.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f20785e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f20785e = r0
        L38:
            android.content.res.Resources r0 = r3.f20785e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w.d.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f20783c == null) {
            this.f20783c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f20783c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f20782b;
        if (theme != null) {
            return theme;
        }
        if (this.f20781a == 0) {
            this.f20781a = R.style.Theme_AppCompat_Light;
        }
        a();
        return this.f20782b;
    }

    public int getThemeResId() {
        return this.f20781a;
    }

    public void onApplyThemeResource(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f20781a != i10) {
            this.f20781a = i10;
            a();
        }
    }

    public d(Context context, int i10) {
        super(context);
        this.f20781a = i10;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f20782b = theme;
    }
}
