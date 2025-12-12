package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.leanback.R;

/* loaded from: classes.dex */
public class VerticalGridView extends b {
    public VerticalGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void initAttributes(Context context, AttributeSet attributeSet) {
        X(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbVerticalGridView);
        setColumnWidth(typedArrayObtainStyledAttributes);
        setNumColumns(typedArrayObtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setColumnWidth(TypedArray typedArray) {
        int i10 = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i10) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i10, 0));
        }
    }

    public void setNumColumns(int i10) {
        this.Q0.setNumRows(i10);
        requestLayout();
    }

    public VerticalGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.Q0.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    public void setColumnWidth(int i10) {
        this.Q0.setRowHeight(i10);
        requestLayout();
    }
}
