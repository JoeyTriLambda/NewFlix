package i7;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.c1;
import com.google.android.material.R;

/* compiled from: ThemeEnforcement.java */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f13323a = {R.attr.colorPrimary};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f13324b = {R.attr.colorPrimaryVariant};

    public static void a(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i10, i11);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z10) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    public static void b(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i10, i11);
        boolean z10 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 != null && iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
            for (int i12 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i12, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z10 = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
            z10 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z10) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= iArr.length) {
                typedArrayObtainStyledAttributes.recycle();
                z10 = true;
                break;
            } else {
                if (!typedArrayObtainStyledAttributes.hasValue(i10)) {
                    typedArrayObtainStyledAttributes.recycle();
                    break;
                }
                i10++;
            }
        }
        if (!z10) {
            throw new IllegalArgumentException(ac.c.k("The style on this component requires your app theme to be ", str, " (or a descendant)."));
        }
    }

    public static void checkAppCompatTheme(Context context) {
        c(context, f13323a, "Theme.AppCompat");
    }

    public static void checkMaterialTheme(Context context) {
        c(context, f13324b, "Theme.MaterialComponents");
    }

    public static boolean isMaterial3Theme(Context context) {
        return n7.b.resolveBoolean(context, R.attr.isMaterial3Theme, false);
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        a(context, attributeSet, i10, i11);
        b(context, attributeSet, iArr, i10, i11, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i10, i11);
    }

    public static c1 obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11, int... iArr2) {
        a(context, attributeSet, i10, i11);
        b(context, attributeSet, iArr, i10, i11, iArr2);
        return c1.obtainStyledAttributes(context, attributeSet, iArr, i10, i11);
    }
}
