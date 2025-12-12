package v7;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import y0.c;

/* compiled from: EndIconDelegate.java */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public final TextInputLayout f20558a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.material.textfield.a f20559b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f20560c;

    /* renamed from: d, reason: collision with root package name */
    public final CheckableImageButton f20561d;

    public l(com.google.android.material.textfield.a aVar) {
        this.f20558a = aVar.f9456b;
        this.f20559b = aVar;
        this.f20560c = aVar.getContext();
        this.f20561d = aVar.f9462r;
    }

    public int b() {
        return 0;
    }

    public int c() {
        return 0;
    }

    public View.OnFocusChangeListener d() {
        return null;
    }

    public View.OnClickListener e() {
        return null;
    }

    public View.OnFocusChangeListener f() {
        return null;
    }

    public boolean g(int i10) {
        return true;
    }

    public c.a getTouchExplorationStateChangeListener() {
        return null;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this instanceof k;
    }

    public boolean j() {
        return false;
    }

    public final void l() {
        this.f20559b.f(false);
    }

    public void a() {
    }

    public void m() {
    }

    public void n() {
    }

    public void afterEditTextChanged(Editable editable) {
    }

    public void k(boolean z10) {
    }

    public void onEditTextAttached(EditText editText) {
    }

    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
    }
}
