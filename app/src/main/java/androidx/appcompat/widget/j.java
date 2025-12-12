package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.R;

/* compiled from: AppCompatCompoundButtonHelper.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final CompoundButton f1389a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f1390b = null;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f1391c = null;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1392d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1393e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1394f;

    public j(CompoundButton compoundButton) {
        this.f1389a = compoundButton;
    }

    public final void a() throws NoSuchFieldException, SecurityException {
        CompoundButton compoundButton = this.f1389a;
        Drawable buttonDrawable = d1.c.getButtonDrawable(compoundButton);
        if (buttonDrawable != null) {
            if (this.f1392d || this.f1393e) {
                Drawable drawableMutate = p0.a.wrap(buttonDrawable).mutate();
                if (this.f1392d) {
                    p0.a.setTintList(drawableMutate, this.f1390b);
                }
                if (this.f1393e) {
                    p0.a.setTintMode(drawableMutate, this.f1391c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(compoundButton.getDrawableState());
                }
                compoundButton.setButtonDrawable(drawableMutate);
            }
        }
    }

    public final void b(AttributeSet attributeSet, int i10) {
        boolean z10;
        int resourceId;
        int resourceId2;
        CompoundButton compoundButton = this.f1389a;
        Context context = compoundButton.getContext();
        int[] iArr = R.styleable.CompoundButton;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, iArr, i10, 0);
        CompoundButton compoundButton2 = this.f1389a;
        x0.j0.saveAttributeDataForStyleable(compoundButton2, compoundButton2.getContext(), iArr, attributeSet, c1VarObtainStyledAttributes.getWrappedTypeArray(), i10, 0);
        try {
            int i11 = R.styleable.CompoundButton_buttonCompat;
            if (!c1VarObtainStyledAttributes.hasValue(i11) || (resourceId2 = c1VarObtainStyledAttributes.getResourceId(i11, 0)) == 0) {
                z10 = false;
            } else {
                try {
                    compoundButton.setButtonDrawable(s.a.getDrawable(compoundButton.getContext(), resourceId2));
                    z10 = true;
                } catch (Resources.NotFoundException unused) {
                }
            }
            if (!z10) {
                int i12 = R.styleable.CompoundButton_android_button;
                if (c1VarObtainStyledAttributes.hasValue(i12) && (resourceId = c1VarObtainStyledAttributes.getResourceId(i12, 0)) != 0) {
                    compoundButton.setButtonDrawable(s.a.getDrawable(compoundButton.getContext(), resourceId));
                }
            }
            int i13 = R.styleable.CompoundButton_buttonTint;
            if (c1VarObtainStyledAttributes.hasValue(i13)) {
                d1.c.setButtonTintList(compoundButton, c1VarObtainStyledAttributes.getColorStateList(i13));
            }
            int i14 = R.styleable.CompoundButton_buttonTintMode;
            if (c1VarObtainStyledAttributes.hasValue(i14)) {
                d1.c.setButtonTintMode(compoundButton, i0.parseTintMode(c1VarObtainStyledAttributes.getInt(i14, -1), null));
            }
        } finally {
            c1VarObtainStyledAttributes.recycle();
        }
    }
}
