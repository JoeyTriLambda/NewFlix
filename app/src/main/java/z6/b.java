package z6;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* compiled from: Chip.java */
/* loaded from: classes.dex */
public final class b extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Chip f22615a;

    public b(Chip chip) {
        this.f22615a = chip;
    }

    @Override // android.view.ViewOutlineProvider
    @TargetApi(21)
    public void getOutline(View view, Outline outline) {
        com.google.android.material.chip.a aVar = this.f22615a.f8963p;
        if (aVar != null) {
            aVar.getOutline(outline);
        } else {
            outline.setAlpha(0.0f);
        }
    }
}
