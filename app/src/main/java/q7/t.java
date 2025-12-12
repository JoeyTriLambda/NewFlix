package q7;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: ShapeableDelegateV33.java */
/* loaded from: classes.dex */
public final class t extends q {

    /* compiled from: ShapeableDelegateV33.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            t tVar = t.this;
            if (tVar.f18035e.isEmpty()) {
                return;
            }
            outline.setPath(tVar.f18035e);
        }
    }

    public t(View view) {
        d(view);
    }

    private void d(View view) {
        view.setOutlineProvider(new a());
    }

    @Override // q7.q
    public final void a(View view) {
        view.setClipToOutline(!this.f18031a);
        if (this.f18031a) {
            view.invalidate();
        } else {
            view.invalidateOutline();
        }
    }

    @Override // q7.q
    public final boolean b() {
        return this.f18031a;
    }
}
