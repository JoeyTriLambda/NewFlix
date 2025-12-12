package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.leanback.R;

/* loaded from: classes.dex */
public final class RowHeaderView extends TextView {
    public RowHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.rowHeaderStyle);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public RowHeaderView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
