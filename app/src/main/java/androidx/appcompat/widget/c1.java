package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import n0.g;

/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public final class c1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1290a;

    /* renamed from: b, reason: collision with root package name */
    public final TypedArray f1291b;

    /* renamed from: c, reason: collision with root package name */
    public TypedValue f1292c;

    public c1(Context context, TypedArray typedArray) {
        this.f1290a = context;
        this.f1291b = typedArray;
    }

    public static c1 obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr) {
        return new c1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public boolean getBoolean(int i10, boolean z10) {
        return this.f1291b.getBoolean(i10, z10);
    }

    public int getColor(int i10, int i11) {
        return this.f1291b.getColor(i10, i11);
    }

    public ColorStateList getColorStateList(int i10) {
        int resourceId;
        ColorStateList colorStateList;
        TypedArray typedArray = this.f1291b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateList = s.a.getColorStateList(this.f1290a, resourceId)) == null) ? typedArray.getColorStateList(i10) : colorStateList;
    }

    public float getDimension(int i10, float f10) {
        return this.f1291b.getDimension(i10, f10);
    }

    public int getDimensionPixelOffset(int i10, int i11) {
        return this.f1291b.getDimensionPixelOffset(i10, i11);
    }

    public int getDimensionPixelSize(int i10, int i11) {
        return this.f1291b.getDimensionPixelSize(i10, i11);
    }

    public Drawable getDrawable(int i10) {
        int resourceId;
        TypedArray typedArray = this.f1291b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) ? typedArray.getDrawable(i10) : s.a.getDrawable(this.f1290a, resourceId);
    }

    public Drawable getDrawableIfKnown(int i10) {
        int resourceId;
        Drawable drawableE;
        if (!this.f1291b.hasValue(i10) || (resourceId = this.f1291b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        k kVar = k.get();
        Context context = this.f1290a;
        synchronized (kVar) {
            drawableE = kVar.f1418a.e(context, resourceId, true);
        }
        return drawableE;
    }

    public float getFloat(int i10, float f10) {
        return this.f1291b.getFloat(i10, f10);
    }

    public Typeface getFont(int i10, int i11, g.e eVar) {
        int resourceId = this.f1291b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1292c == null) {
            this.f1292c = new TypedValue();
        }
        return n0.g.getFont(this.f1290a, resourceId, this.f1292c, i11, eVar);
    }

    public int getInt(int i10, int i11) {
        return this.f1291b.getInt(i10, i11);
    }

    public int getInteger(int i10, int i11) {
        return this.f1291b.getInteger(i10, i11);
    }

    public int getLayoutDimension(int i10, int i11) {
        return this.f1291b.getLayoutDimension(i10, i11);
    }

    public int getResourceId(int i10, int i11) {
        return this.f1291b.getResourceId(i10, i11);
    }

    public String getString(int i10) {
        return this.f1291b.getString(i10);
    }

    public CharSequence getText(int i10) {
        return this.f1291b.getText(i10);
    }

    public CharSequence[] getTextArray(int i10) {
        return this.f1291b.getTextArray(i10);
    }

    public TypedArray getWrappedTypeArray() {
        return this.f1291b;
    }

    public boolean hasValue(int i10) {
        return this.f1291b.hasValue(i10);
    }

    public void recycle() {
        this.f1291b.recycle();
    }

    public static c1 obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new c1(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public static c1 obtainStyledAttributes(Context context, int i10, int[] iArr) {
        return new c1(context, context.obtainStyledAttributes(i10, iArr));
    }
}
