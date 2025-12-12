package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public final class n0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f1464b;

    public n0(o0 o0Var) {
        this.f1464b = o0Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        j0 j0Var;
        if (i10 == -1 || (j0Var = this.f1464b.f1470n) == null) {
            return;
        }
        j0Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
