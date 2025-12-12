package i7;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

/* compiled from: VisibilityAwareImageButton.java */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class u extends ImageButton {

    /* renamed from: b, reason: collision with root package name */
    public int f13331b;

    public final int getUserSetVisibility() {
        return this.f13331b;
    }

    public final void internalSetVisibility(int i10, boolean z10) {
        super.setVisibility(i10);
        if (z10) {
            this.f13331b = i10;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        internalSetVisibility(i10, true);
    }
}
