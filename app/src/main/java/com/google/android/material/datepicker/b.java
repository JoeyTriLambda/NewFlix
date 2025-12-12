package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import com.google.android.material.R;
import x0.j0;

/* compiled from: CalendarItemStyle.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f9037a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f9038b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f9039c;

    /* renamed from: d, reason: collision with root package name */
    public final ColorStateList f9040d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9041e;

    /* renamed from: f, reason: collision with root package name */
    public final q7.l f9042f;

    public b(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i10, q7.l lVar, Rect rect) {
        w0.h.checkArgumentNonnegative(rect.left);
        w0.h.checkArgumentNonnegative(rect.top);
        w0.h.checkArgumentNonnegative(rect.right);
        w0.h.checkArgumentNonnegative(rect.bottom);
        this.f9037a = rect;
        this.f9038b = colorStateList2;
        this.f9039c = colorStateList;
        this.f9040d = colorStateList3;
        this.f9041e = i10;
        this.f9042f = lVar;
    }

    public static b a(Context context, int i10) throws Resources.NotFoundException {
        w0.h.checkArgument(i10 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.MaterialCalendarItem);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetLeft, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetTop, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetRight, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialCalendarItem_android_insetBottom, 0));
        ColorStateList colorStateList = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemFillColor);
        ColorStateList colorStateList2 = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemTextColor);
        ColorStateList colorStateList3 = n7.c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendarItem_itemStrokeColor);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialCalendarItem_itemStrokeWidth, 0);
        q7.l lVarBuild = q7.l.builder(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearance, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendarItem_itemShapeAppearanceOverlay, 0)).build();
        typedArrayObtainStyledAttributes.recycle();
        return new b(colorStateList, colorStateList2, colorStateList3, dimensionPixelSize, lVarBuild, rect);
    }

    public final void b(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        q7.g gVar = new q7.g();
        q7.g gVar2 = new q7.g();
        q7.l lVar = this.f9042f;
        gVar.setShapeAppearanceModel(lVar);
        gVar2.setShapeAppearanceModel(lVar);
        if (colorStateList == null) {
            colorStateList = this.f9039c;
        }
        gVar.setFillColor(colorStateList);
        gVar.setStroke(this.f9041e, this.f9040d);
        ColorStateList colorStateList3 = this.f9038b;
        if (colorStateList2 == null) {
            colorStateList2 = colorStateList3;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateList3.withAlpha(30), gVar, gVar2);
        Rect rect = this.f9037a;
        j0.setBackground(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
