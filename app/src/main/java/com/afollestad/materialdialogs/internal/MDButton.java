package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R;
import o3.a;

/* loaded from: classes.dex */
public class MDButton extends TextView {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5341b;

    /* renamed from: m, reason: collision with root package name */
    public GravityEnum f5342m;

    /* renamed from: n, reason: collision with root package name */
    public int f5343n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f5344o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f5345p;

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5341b = false;
        this.f5343n = context.getResources().getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
        this.f5342m = GravityEnum.END;
    }

    public final void a(boolean z10, boolean z11) {
        if (this.f5341b != z10 || z11) {
            setGravity(z10 ? this.f5342m.getGravityInt() | 16 : 17);
            setTextAlignment(z10 ? this.f5342m.getTextAlignment() : 4);
            a.setBackgroundCompat(this, z10 ? this.f5344o : this.f5345p);
            if (z10) {
                setPadding(this.f5343n, getPaddingTop(), this.f5343n, getPaddingBottom());
            }
            this.f5341b = z10;
        }
    }

    public void setAllCapsCompat(boolean z10) {
        setAllCaps(z10);
    }

    public void setDefaultSelector(Drawable drawable) {
        this.f5345p = drawable;
        if (this.f5341b) {
            return;
        }
        a(false, true);
    }

    public void setStackedGravity(GravityEnum gravityEnum) {
        this.f5342m = gravityEnum;
    }

    public void setStackedSelector(Drawable drawable) {
        this.f5344o = drawable;
        if (this.f5341b) {
            a(true, true);
        }
    }
}
