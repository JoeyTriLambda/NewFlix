package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.leanback.R;

/* compiled from: ListRowView.java */
/* loaded from: classes.dex */
public final class w extends LinearLayout {

    /* renamed from: b, reason: collision with root package name */
    public final HorizontalGridView f3406b;

    public w(Context context) {
        this(context, null);
    }

    public HorizontalGridView getGridView() {
        return this.f3406b;
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public w(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.lb_list_row, this);
        HorizontalGridView horizontalGridView = (HorizontalGridView) findViewById(R.id.row_content);
        this.f3406b = horizontalGridView;
        horizontalGridView.setHasFixedSize(false);
        setOrientation(1);
        setDescendantFocusability(262144);
    }
}
