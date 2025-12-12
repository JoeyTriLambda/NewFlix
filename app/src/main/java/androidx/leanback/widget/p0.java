package androidx.leanback.widget;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: ShadowHelperApi21.java */
/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3317a = new a();

    /* compiled from: ShadowHelperApi21.java */
    public static class a extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRect(0, 0, view.getWidth(), view.getHeight());
            outline.setAlpha(1.0f);
        }
    }

    /* compiled from: ShadowHelperApi21.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public View f3318a;

        /* renamed from: b, reason: collision with root package name */
        public float f3319b;

        /* renamed from: c, reason: collision with root package name */
        public float f3320c;
    }

    public static Object addDynamicShadow(View view, float f10, float f11, int i10) {
        if (i10 > 0) {
            i0.setClipToRoundedOutline(view, true, i10);
        } else {
            view.setOutlineProvider(f3317a);
        }
        b bVar = new b();
        bVar.f3318a = view;
        bVar.f3319b = f10;
        bVar.f3320c = f11;
        view.setZ(f10);
        return bVar;
    }

    public static void setShadowFocusLevel(Object obj, float f10) {
        b bVar = (b) obj;
        View view = bVar.f3318a;
        float f11 = bVar.f3319b;
        view.setZ(((bVar.f3320c - f11) * f10) + f11);
    }
}
