package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
public final class y extends t {

    /* renamed from: d, reason: collision with root package name */
    public final SeekBar f1552d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1553e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f1554f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuff.Mode f1555g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1556h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1557i;

    public y(SeekBar seekBar) {
        super(seekBar);
        this.f1554f = null;
        this.f1555g = null;
        this.f1556h = false;
        this.f1557i = false;
        this.f1552d = seekBar;
    }

    @Override // androidx.appcompat.widget.t
    public final void a(AttributeSet attributeSet, int i10) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.a(attributeSet, i10);
        SeekBar seekBar = this.f1552d;
        Context context = seekBar.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar2 = this.f1552d;
        x0.j0.saveAttributeDataForStyleable(seekBar2, seekBar2.getContext(), iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        Drawable drawableIfKnown = c1VarObtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            seekBar.setThumb(drawableIfKnown);
        }
        Drawable drawable = c1VarObtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark);
        Drawable drawable2 = this.f1553e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1553e = drawable;
        if (drawable != null) {
            drawable.setCallback(seekBar);
            p0.a.setLayoutDirection(drawable, x0.j0.getLayoutDirection(seekBar));
            if (drawable.isStateful()) {
                drawable.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        int i11 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (c1VarObtainStyledAttributes.hasValue(i11)) {
            this.f1555g = i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i11, -1), this.f1555g);
            this.f1557i = true;
        }
        int i12 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (c1VarObtainStyledAttributes.hasValue(i12)) {
            this.f1554f = c1VarObtainStyledAttributes.getColorStateList(i12);
            this.f1556h = true;
        }
        c1VarObtainStyledAttributes.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f1553e;
        if (drawable != null) {
            if (this.f1556h || this.f1557i) {
                Drawable drawableWrap = p0.a.wrap(drawable.mutate());
                this.f1553e = drawableWrap;
                if (this.f1556h) {
                    p0.a.setTintList(drawableWrap, this.f1554f);
                }
                if (this.f1557i) {
                    p0.a.setTintMode(this.f1553e, this.f1555g);
                }
                if (this.f1553e.isStateful()) {
                    this.f1553e.setState(this.f1552d.getDrawableState());
                }
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f1553e != null) {
            int max = this.f1552d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1553e.getIntrinsicWidth();
                int intrinsicHeight = this.f1553e.getIntrinsicHeight();
                int i10 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i11 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1553e.setBounds(-i10, -i11, i10, i11);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1553e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
