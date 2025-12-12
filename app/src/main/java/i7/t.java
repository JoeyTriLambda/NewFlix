package i7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import x0.a1;
import x0.j0;
import x0.y0;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public final class t {

    /* compiled from: ViewUtils.java */
    public class a implements x0.v {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f13326a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f13327b;

        public a(c cVar, d dVar) {
            this.f13326a = cVar;
            this.f13327b = dVar;
        }

        @Override // x0.v
        public y0 onApplyWindowInsets(View view, y0 y0Var) {
            return ((t6.b) this.f13326a).onApplyWindowInsets(view, y0Var, new d(this.f13327b));
        }
    }

    /* compiled from: ViewUtils.java */
    public interface c {
    }

    public static void doOnApplyWindowInsets(View view, c cVar) {
        j0.setOnApplyWindowInsetsListener(view, new a(cVar, new d(j0.getPaddingStart(view), view.getPaddingTop(), j0.getPaddingEnd(view), view.getPaddingBottom())));
        requestApplyInsetsWhenAttached(view);
    }

    public static float dpToPx(Context context, int i10) {
        return TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
    }

    public static Integer getBackgroundColor(View view) {
        ColorStateList colorStateListOrNull = e7.a.getColorStateListOrNull(view.getBackground());
        if (colorStateListOrNull != null) {
            return Integer.valueOf(colorStateListOrNull.getDefaultColor());
        }
        return null;
    }

    public static float getParentAbsoluteElevation(View view) {
        float elevation = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            elevation += j0.getElevation((View) parent);
        }
        return elevation;
    }

    public static boolean isLayoutRtl(View view) {
        return j0.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode parseTintMode(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void requestApplyInsetsWhenAttached(View view) {
        if (j0.isAttachedToWindow(view)) {
            j0.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new b());
        }
    }

    public static void requestFocusAndShowKeyboard(View view, boolean z10) {
        view.requestFocus();
        view.post(new i9.b(z10, 2, view));
    }

    public static void showKeyboard(View view, boolean z10) {
        a1 windowInsetsController;
        if (!z10 || (windowInsetsController = j0.getWindowInsetsController(view)) == null) {
            ((InputMethodManager) m0.a.getSystemService(view.getContext(), InputMethodManager.class)).showSoftInput(view, 1);
        } else {
            windowInsetsController.show(y0.m.ime());
        }
    }

    /* compiled from: ViewUtils.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final int f13328a;

        /* renamed from: b, reason: collision with root package name */
        public final int f13329b;

        /* renamed from: c, reason: collision with root package name */
        public final int f13330c;

        public d(int i10, int i11, int i12, int i13) {
            this.f13328a = i10;
            this.f13329b = i12;
            this.f13330c = i13;
        }

        public d(d dVar) {
            this.f13328a = dVar.f13328a;
            this.f13329b = dVar.f13329b;
            this.f13330c = dVar.f13330c;
        }
    }

    /* compiled from: ViewUtils.java */
    public class b implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            j0.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
