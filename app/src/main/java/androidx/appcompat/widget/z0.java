package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: TintContextWrapper.java */
/* loaded from: classes.dex */
public final class z0 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1581c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<z0>> f1582d;

    /* renamed from: a, reason: collision with root package name */
    public final t0 f1583a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f1584b;

    public z0(Context context) {
        super(context);
        if (!j1.shouldBeUsed()) {
            this.f1583a = new b1(this, context.getResources());
            this.f1584b = null;
            return;
        }
        j1 j1Var = new j1(this, context.getResources());
        this.f1583a = j1Var;
        Resources.Theme themeNewTheme = j1Var.newTheme();
        this.f1584b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static Context wrap(Context context) {
        if (!(((context instanceof z0) || (context.getResources() instanceof b1) || (context.getResources() instanceof j1) || !j1.shouldBeUsed()) ? false : true)) {
            return context;
        }
        synchronized (f1581c) {
            ArrayList<WeakReference<z0>> arrayList = f1582d;
            if (arrayList == null) {
                f1582d = new ArrayList<>();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference<z0> weakReference = f1582d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1582d.remove(size);
                    }
                }
                for (int size2 = f1582d.size() - 1; size2 >= 0; size2--) {
                    WeakReference<z0> weakReference2 = f1582d.get(size2);
                    z0 z0Var = weakReference2 != null ? weakReference2.get() : null;
                    if (z0Var != null && z0Var.getBaseContext() == context) {
                        return z0Var;
                    }
                }
            }
            z0 z0Var2 = new z0(context);
            f1582d.add(new WeakReference<>(z0Var2));
            return z0Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1583a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1583a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1584b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f1584b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
