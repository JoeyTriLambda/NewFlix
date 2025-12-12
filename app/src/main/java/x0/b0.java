package x0;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;

/* compiled from: SoftwareKeyboardControllerCompat.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f21229a;

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final View f21230a;

        public a(View view) {
            this.f21230a = view;
        }

        public void a() {
            final View viewFindViewById;
            View view = this.f21230a;
            if (view == null) {
                return;
            }
            if (view.isInEditMode() || view.onCheckIsTextEditor()) {
                view.requestFocus();
                viewFindViewById = view;
            } else {
                viewFindViewById = view.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = view.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: x0.a0
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = viewFindViewById;
                    ((InputMethodManager) view2.getContext().getSystemService("input_method")).showSoftInput(view2, 0);
                }
            });
        }
    }

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    public static class c {
    }

    public b0(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f21229a = new b(view);
        } else {
            this.f21229a = new a(view);
        }
    }

    public void show() {
        this.f21229a.a();
    }

    /* compiled from: SoftwareKeyboardControllerCompat.java */
    public static class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final View f21231b;

        /* renamed from: c, reason: collision with root package name */
        public final WindowInsetsController f21232c;

        public b(View view) {
            super(view);
            this.f21231b = view;
        }

        @Override // x0.b0.a
        public final void a() {
            View view = this.f21231b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f21232c;
            if (windowInsetsController == null) {
                windowInsetsController = view != null ? view.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            } else {
                super.a();
            }
        }

        public b(WindowInsetsController windowInsetsController) {
            super(null);
            this.f21232c = windowInsetsController;
        }
    }

    @Deprecated
    public b0(WindowInsetsController windowInsetsController) {
        this.f21229a = new b(windowInsetsController);
    }
}
