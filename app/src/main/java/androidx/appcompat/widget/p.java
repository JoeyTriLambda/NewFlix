package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;

/* compiled from: AppCompatImageHelper.java */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f1488a;

    /* renamed from: b, reason: collision with root package name */
    public a1 f1489b;

    /* renamed from: c, reason: collision with root package name */
    public a1 f1490c;

    /* renamed from: d, reason: collision with root package name */
    public int f1491d = 0;

    public p(ImageView imageView) {
        this.f1488a = imageView;
    }

    public final void a() {
        ImageView imageView = this.f1488a;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            i0.a(drawable);
        }
        if (drawable != null) {
            int i10 = Build.VERSION.SDK_INT;
            boolean z10 = true;
            if (i10 <= 21 && i10 == 21) {
                if (this.f1490c == null) {
                    this.f1490c = new a1();
                }
                a1 a1Var = this.f1490c;
                a1Var.f1249a = null;
                a1Var.f1252d = false;
                a1Var.f1250b = null;
                a1Var.f1251c = false;
                ColorStateList imageTintList = d1.e.getImageTintList(imageView);
                if (imageTintList != null) {
                    a1Var.f1252d = true;
                    a1Var.f1249a = imageTintList;
                }
                PorterDuff.Mode imageTintMode = d1.e.getImageTintMode(imageView);
                if (imageTintMode != null) {
                    a1Var.f1251c = true;
                    a1Var.f1250b = imageTintMode;
                }
                if (a1Var.f1252d || a1Var.f1251c) {
                    k.a(drawable, a1Var, imageView.getDrawableState());
                } else {
                    z10 = false;
                }
                if (z10) {
                    return;
                }
            }
            a1 a1Var2 = this.f1489b;
            if (a1Var2 != null) {
                k.a(drawable, a1Var2, imageView.getDrawableState());
            }
        }
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i10) {
        int resourceId;
        ImageView imageView = this.f1488a;
        Context context = imageView.getContext();
        int[] iArr = R.styleable.AppCompatImageView;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        ImageView imageView2 = this.f1488a;
        x0.j0.saveAttributeDataForStyleable(imageView2, imageView2.getContext(), iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = c1VarObtainStyledAttributes.getResourceId(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = s.a.getDrawable(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                i0.a(drawable);
            }
            int i11 = R.styleable.AppCompatImageView_tint;
            if (c1VarObtainStyledAttributes.hasValue(i11)) {
                d1.e.setImageTintList(imageView, c1VarObtainStyledAttributes.getColorStateList(i11));
            }
            int i12 = R.styleable.AppCompatImageView_tintMode;
            if (c1VarObtainStyledAttributes.hasValue(i12)) {
                d1.e.setImageTintMode(imageView, i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i12, -1), null));
            }
        } finally {
            c1VarObtainStyledAttributes.recycle();
        }
    }

    public void setImageResource(int i10) {
        ImageView imageView = this.f1488a;
        if (i10 != 0) {
            Drawable drawable = s.a.getDrawable(imageView.getContext(), i10);
            if (drawable != null) {
                i0.a(drawable);
            }
            imageView.setImageDrawable(drawable);
        } else {
            imageView.setImageDrawable(null);
        }
        a();
    }
}
