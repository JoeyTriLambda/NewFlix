package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.c1;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, j, AdapterView.OnItemClickListener {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f918m = {R.attr.background, R.attr.divider};

    /* renamed from: b, reason: collision with root package name */
    public e f919b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.j
    public void initialize(e eVar) {
        this.f919b = eVar;
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean invokeItem(g gVar) {
        return this.f919b.performItemAction(gVar, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        invokeItem((g) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, f918m, i10, 0);
        if (c1VarObtainStyledAttributes.hasValue(0)) {
            setBackgroundDrawable(c1VarObtainStyledAttributes.getDrawable(0));
        }
        if (c1VarObtainStyledAttributes.hasValue(1)) {
            setDivider(c1VarObtainStyledAttributes.getDrawable(1));
        }
        c1VarObtainStyledAttributes.recycle();
    }
}
