package androidx.leanback.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/* compiled from: Presenter.java */
/* loaded from: classes.dex */
public abstract class f0 implements e {

    /* compiled from: Presenter.java */
    public static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public final View f3216a;

        public a(View view) {
            this.f3216a = view;
        }

        @Override // androidx.leanback.widget.e
        public final Object getFacet(Class<?> cls) {
            return null;
        }
    }

    public static void cancelAnimationsRecursive(View view) {
        if (view == null || !view.hasTransientState()) {
            return;
        }
        view.animate().cancel();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; view.hasTransientState() && i10 < childCount; i10++) {
                cancelAnimationsRecursive(viewGroup.getChildAt(i10));
            }
        }
    }

    @Override // androidx.leanback.widget.e
    public final Object getFacet(Class<?> cls) {
        return null;
    }

    public abstract void onBindViewHolder(a aVar, Object obj);

    public void onBindViewHolder(a aVar, Object obj, List<Object> list) {
        onBindViewHolder(aVar, obj);
    }

    public abstract a onCreateViewHolder(ViewGroup viewGroup);

    public abstract void onUnbindViewHolder(a aVar);

    public void onViewDetachedFromWindow(a aVar) {
        cancelAnimationsRecursive(aVar.f3216a);
    }

    public void onViewAttachedToWindow(a aVar) {
    }
}
