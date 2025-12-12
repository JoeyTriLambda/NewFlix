package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ActivityChooserView$InnerLayout extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f1112b = {R.attr.background};

    public ActivityChooserView$InnerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, f1112b);
        setBackgroundDrawable(c1VarObtainStyledAttributes.getDrawable(0));
        c1VarObtainStyledAttributes.recycle();
    }
}
