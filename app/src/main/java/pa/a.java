package pa;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.rom4ek.arcnavigationview.ArcNavigationView;

/* compiled from: ArcNavigationView.java */
/* loaded from: classes.dex */
public final class a extends ViewOutlineProvider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArcNavigationView f17645a;

    public a(ArcNavigationView arcNavigationView) {
        this.f17645a = arcNavigationView;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(View view, Outline outline) {
        ArcNavigationView arcNavigationView = this.f17645a;
        if (arcNavigationView.O.isConvex()) {
            outline.setConvexPath(arcNavigationView.O);
        }
    }
}
