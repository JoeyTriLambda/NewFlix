package q7;

import android.graphics.Outline;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: ShapeableDelegateV22.java */
/* loaded from: classes.dex */
public final class s extends q {

    /* renamed from: f, reason: collision with root package name */
    public boolean f18036f = false;

    /* renamed from: g, reason: collision with root package name */
    public float f18037g = 0.0f;

    /* compiled from: ShapeableDelegateV22.java */
    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            s sVar = s.this;
            if (sVar.f18033c == null || sVar.f18034d.isEmpty()) {
                return;
            }
            RectF rectF = sVar.f18034d;
            outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, sVar.f18037g);
        }
    }

    public s(View view) {
        d(view);
    }

    private void d(View view) {
        view.setOutlineProvider(new a());
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0114  */
    @Override // q7.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(android.view.View r10) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: q7.s.a(android.view.View):void");
    }

    @Override // q7.q
    public final boolean b() {
        return !this.f18036f || this.f18031a;
    }
}
