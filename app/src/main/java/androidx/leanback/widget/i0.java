package androidx.leanback.widget;

import android.graphics.Outline;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;

/* compiled from: RoundedRectHelperApi21.java */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static SparseArray<ViewOutlineProvider> f3239a;

    /* compiled from: RoundedRectHelperApi21.java */
    public static final class a extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name */
        public final int f3240a;

        public a(int i10) {
            this.f3240a = i10;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.f3240a);
            outline.setAlpha(1.0f);
        }
    }

    public static void setClipToRoundedOutline(View view, boolean z10, int i10) {
        if (z10) {
            if (f3239a == null) {
                f3239a = new SparseArray<>();
            }
            ViewOutlineProvider aVar = f3239a.get(i10);
            if (aVar == null) {
                aVar = new a(i10);
                if (f3239a.size() < 32) {
                    f3239a.put(i10, aVar);
                }
            }
            view.setOutlineProvider(aVar);
        } else {
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        view.setClipToOutline(z10);
    }
}
