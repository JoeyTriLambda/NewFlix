package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
public final class s extends PopupWindow {
    public s(Context context, AttributeSet attributeSet, int i10, int i11) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, attributeSet, i10, i11);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i10, i11);
        int i12 = R.styleable.PopupWindow_overlapAnchor;
        if (c1VarObtainStyledAttributes.hasValue(i12)) {
            d1.h.setOverlapAnchor(this, c1VarObtainStyledAttributes.getBoolean(i12, false));
        }
        setBackgroundDrawable(c1VarObtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        c1VarObtainStyledAttributes.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11) {
        super.showAsDropDown(view, i10, i11);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i10, int i11, int i12, int i13) {
        super.update(view, i10, i11, i12, i13);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i10, int i11, int i12) {
        super.showAsDropDown(view, i10, i11, i12);
    }
}
