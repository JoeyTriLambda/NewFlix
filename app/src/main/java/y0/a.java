package y0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* compiled from: AccessibilityClickableSpanCompat.java */
/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: b, reason: collision with root package name */
    public final int f21812b;

    /* renamed from: m, reason: collision with root package name */
    public final d f21813m;

    /* renamed from: n, reason: collision with root package name */
    public final int f21814n;

    public a(int i10, d dVar, int i11) {
        this.f21812b = i10;
        this.f21813m = dVar;
        this.f21814n = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f21812b);
        this.f21813m.performAction(this.f21814n, bundle);
    }
}
