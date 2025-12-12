package flix.com.vision.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.q;

/* loaded from: classes2.dex */
public class CustomImageView extends q {
    public CustomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        try {
            if (getDrawable() == null) {
                setMeasuredDimension(0, 0);
            } else {
                float intrinsicWidth = r0.getIntrinsicWidth() / r0.getIntrinsicHeight();
                if (intrinsicWidth >= View.MeasureSpec.getSize(i10) / View.MeasureSpec.getSize(i11)) {
                    int size = View.MeasureSpec.getSize(i10);
                    setMeasuredDimension(size, (int) (size / intrinsicWidth));
                } else {
                    int size2 = View.MeasureSpec.getSize(i11);
                    setMeasuredDimension((int) (size2 * intrinsicWidth), size2);
                }
            }
        } catch (Exception unused) {
            super.onMeasure(i10, i11);
        }
    }
}
