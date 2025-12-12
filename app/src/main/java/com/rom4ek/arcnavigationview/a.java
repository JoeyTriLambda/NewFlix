package com.rom4ek.arcnavigationview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;

/* compiled from: ArcViewSettings.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10433a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10434b;

    /* renamed from: c, reason: collision with root package name */
    public float f10435c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f10436d;

    public a(Context context, AttributeSet attributeSet) {
        this.f10433a = true;
        this.f10436d = new ColorDrawable(-1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArcDrawer, 0, 0);
        this.f10434b = typedArrayObtainStyledAttributes.getDimension(R.styleable.ArcDrawer_arc_width, dpToPx(context, 10));
        this.f10433a = typedArrayObtainStyledAttributes.getInt(R.styleable.ArcDrawer_arc_cropDirection, 0) == 0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.background, android.R.attr.layout_gravity});
        this.f10436d = typedArrayObtainStyledAttributes2.getDrawable(0);
        typedArrayObtainStyledAttributes2.recycle();
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float dpToPx(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public float getArcWidth() {
        return this.f10434b;
    }

    public Drawable getBackgroundDrawable() {
        return this.f10436d;
    }

    public float getElevation() {
        return this.f10435c;
    }

    public boolean isCropInside() {
        return this.f10433a;
    }

    public void setElevation(float f10) {
        this.f10435c = f10;
    }
}
