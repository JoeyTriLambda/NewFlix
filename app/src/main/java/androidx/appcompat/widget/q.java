package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* compiled from: AppCompatImageView.java */
/* loaded from: classes.dex */
public class q extends ImageView {

    /* renamed from: b, reason: collision with root package name */
    public final e f1492b;

    /* renamed from: m, reason: collision with root package name */
    public final p f1493m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1494n;

    public q(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1492b;
        if (eVar != null) {
            eVar.a();
        }
        p pVar = this.f1493m;
        if (pVar != null) {
            pVar.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1492b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1492b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        a1 a1Var;
        p pVar = this.f1493m;
        if (pVar == null || (a1Var = pVar.f1489b) == null) {
            return null;
        }
        return a1Var.f1249a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        a1 a1Var;
        p pVar = this.f1493m;
        if (pVar == null || (a1Var = pVar.f1489b) == null) {
            return null;
        }
        return a1Var.f1250b;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return ((this.f1493m.f1488a.getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1492b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f1492b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        p pVar = this.f1493m;
        if (pVar != null) {
            pVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        p pVar = this.f1493m;
        if (pVar != null && drawable != null && !this.f1494n) {
            pVar.f1491d = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (pVar != null) {
            pVar.a();
            if (this.f1494n) {
                return;
            }
            ImageView imageView = pVar.f1488a;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(pVar.f1491d);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f1494n = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        p pVar = this.f1493m;
        if (pVar != null) {
            pVar.setImageResource(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        p pVar = this.f1493m;
        if (pVar != null) {
            pVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1492b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1492b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        p pVar = this.f1493m;
        if (pVar != null) {
            if (pVar.f1489b == null) {
                pVar.f1489b = new a1();
            }
            a1 a1Var = pVar.f1489b;
            a1Var.f1249a = colorStateList;
            a1Var.f1252d = true;
            pVar.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        p pVar = this.f1493m;
        if (pVar != null) {
            if (pVar.f1489b == null) {
                pVar.f1489b = new a1();
            }
            a1 a1Var = pVar.f1489b;
            a1Var.f1250b = mode;
            a1Var.f1251c = true;
            pVar.a();
        }
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public q(Context context, AttributeSet attributeSet, int i10) {
        super(z0.wrap(context), attributeSet, i10);
        this.f1494n = false;
        x0.checkAppCompatTheme(this, getContext());
        e eVar = new e(this);
        this.f1492b = eVar;
        eVar.d(attributeSet, i10);
        p pVar = new p(this);
        this.f1493m = pVar;
        pVar.loadFromAttributes(attributeSet, i10);
    }
}
