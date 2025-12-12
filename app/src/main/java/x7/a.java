package x7;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import w.d;

/* compiled from: MaterialThemeOverlay.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f21638a = {R.attr.theme, com.google.android.material.R.attr.theme};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f21639b = {com.google.android.material.R.attr.materialThemeOverlay};

    public static Context wrap(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f21639b, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        boolean z10 = (context instanceof d) && ((d) context).getThemeResId() == resourceId;
        if (resourceId == 0 || z10) {
            return context;
        }
        d dVar = new d(context, resourceId);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f21638a);
        int resourceId2 = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
        int resourceId3 = typedArrayObtainStyledAttributes2.getResourceId(1, 0);
        typedArrayObtainStyledAttributes2.recycle();
        if (resourceId2 == 0) {
            resourceId2 = resourceId3;
        }
        if (resourceId2 != 0) {
            dVar.getTheme().applyStyle(resourceId2, true);
        }
        return dVar;
    }
}
