package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;

/* compiled from: AppCompatBackgroundHelper.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final View f1312a;

    /* renamed from: d, reason: collision with root package name */
    public a1 f1315d;

    /* renamed from: e, reason: collision with root package name */
    public a1 f1316e;

    /* renamed from: f, reason: collision with root package name */
    public a1 f1317f;

    /* renamed from: c, reason: collision with root package name */
    public int f1314c = -1;

    /* renamed from: b, reason: collision with root package name */
    public final k f1313b = k.get();

    public e(View view) {
        this.f1312a = view;
    }

    public final void a() {
        View view = this.f1312a;
        Drawable background = view.getBackground();
        if (background != null) {
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = true;
            if (i10 <= 21 ? i10 == 21 : this.f1315d != null) {
                if (this.f1317f == null) {
                    this.f1317f = new a1();
                }
                a1 a1Var = this.f1317f;
                a1Var.f1249a = null;
                a1Var.f1252d = false;
                a1Var.f1250b = null;
                a1Var.f1251c = false;
                ColorStateList backgroundTintList = x0.j0.getBackgroundTintList(view);
                if (backgroundTintList != null) {
                    a1Var.f1252d = true;
                    a1Var.f1249a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = x0.j0.getBackgroundTintMode(view);
                if (backgroundTintMode != null) {
                    a1Var.f1251c = true;
                    a1Var.f1250b = backgroundTintMode;
                }
                if (a1Var.f1252d || a1Var.f1251c) {
                    k.a(background, a1Var, view.getDrawableState());
                } else {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            a1 a1Var2 = this.f1316e;
            if (a1Var2 != null) {
                k.a(background, a1Var2, view.getDrawableState());
                return;
            }
            a1 a1Var3 = this.f1315d;
            if (a1Var3 != null) {
                k.a(background, a1Var3, view.getDrawableState());
            }
        }
    }

    public final ColorStateList b() {
        a1 a1Var = this.f1316e;
        if (a1Var != null) {
            return a1Var.f1249a;
        }
        return null;
    }

    public final PorterDuff.Mode c() {
        a1 a1Var = this.f1316e;
        if (a1Var != null) {
            return a1Var.f1250b;
        }
        return null;
    }

    public final void d(AttributeSet attributeSet, int i10) {
        ColorStateList colorStateListF;
        View view = this.f1312a;
        Context context = view.getContext();
        int[] iArr = R.styleable.ViewBackgroundHelper;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        View view2 = this.f1312a;
        x0.j0.saveAttributeDataForStyleable(view2, view2.getContext(), iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            int i11 = R.styleable.ViewBackgroundHelper_android_background;
            if (c1VarObtainStyledAttributes.hasValue(i11)) {
                this.f1314c = c1VarObtainStyledAttributes.getResourceId(i11, -1);
                k kVar = this.f1313b;
                Context context2 = view.getContext();
                int i12 = this.f1314c;
                synchronized (kVar) {
                    colorStateListF = kVar.f1418a.f(context2, i12);
                }
                if (colorStateListF != null) {
                    g(colorStateListF);
                }
            }
            int i13 = R.styleable.ViewBackgroundHelper_backgroundTint;
            if (c1VarObtainStyledAttributes.hasValue(i13)) {
                x0.j0.setBackgroundTintList(view, c1VarObtainStyledAttributes.getColorStateList(i13));
            }
            int i14 = R.styleable.ViewBackgroundHelper_backgroundTintMode;
            if (c1VarObtainStyledAttributes.hasValue(i14)) {
                x0.j0.setBackgroundTintMode(view, i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i14, -1), null));
            }
        } finally {
            c1VarObtainStyledAttributes.recycle();
        }
    }

    public final void e() {
        this.f1314c = -1;
        g(null);
        a();
    }

    public final void f(int i10) {
        ColorStateList colorStateListF;
        this.f1314c = i10;
        k kVar = this.f1313b;
        if (kVar != null) {
            Context context = this.f1312a.getContext();
            synchronized (kVar) {
                colorStateListF = kVar.f1418a.f(context, i10);
            }
        } else {
            colorStateListF = null;
        }
        g(colorStateListF);
        a();
    }

    public final void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1315d == null) {
                this.f1315d = new a1();
            }
            a1 a1Var = this.f1315d;
            a1Var.f1249a = colorStateList;
            a1Var.f1252d = true;
        } else {
            this.f1315d = null;
        }
        a();
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f1316e == null) {
            this.f1316e = new a1();
        }
        a1 a1Var = this.f1316e;
        a1Var.f1249a = colorStateList;
        a1Var.f1252d = true;
        a();
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f1316e == null) {
            this.f1316e = new a1();
        }
        a1 a1Var = this.f1316e;
        a1Var.f1250b = mode;
        a1Var.f1251c = true;
        a();
    }
}
