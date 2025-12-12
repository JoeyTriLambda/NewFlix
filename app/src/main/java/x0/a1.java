package x0;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* compiled from: WindowInsetsControllerCompat.java */
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: a, reason: collision with root package name */
    public final e f21221a;

    /* compiled from: WindowInsetsControllerCompat.java */
    public static class a extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Window f21222a;

        /* renamed from: b, reason: collision with root package name */
        public final b0 f21223b;

        public a(Window window, b0 b0Var) {
            this.f21222a = window;
            this.f21223b = b0Var;
        }

        @Override // x0.a1.e
        public final void a(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    if (i11 == 1) {
                        unsetSystemUiFlag(4);
                        unsetWindowFlag(1024);
                    } else if (i11 == 2) {
                        unsetSystemUiFlag(2);
                    } else if (i11 == 8) {
                        this.f21223b.show();
                    }
                }
            }
        }

        public void setSystemUiFlag(int i10) {
            View decorView = this.f21222a.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void setWindowFlag(int i10) {
            this.f21222a.addFlags(i10);
        }

        public void unsetSystemUiFlag(int i10) {
            View decorView = this.f21222a.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public void unsetWindowFlag(int i10) {
            this.f21222a.clearFlags(i10);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    public static class b extends a {
        public b(Window window, b0 b0Var) {
            super(window, b0Var);
        }

        @Override // x0.a1.e
        public void setAppearanceLightStatusBars(boolean z10) {
            if (!z10) {
                unsetSystemUiFlag(8192);
                return;
            }
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    public static class c extends b {
        public c(Window window, b0 b0Var) {
            super(window, b0Var);
        }

        @Override // x0.a1.e
        public void setAppearanceLightNavigationBars(boolean z10) {
            if (!z10) {
                unsetSystemUiFlag(16);
                return;
            }
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
        }
    }

    @Deprecated
    public a1(WindowInsetsController windowInsetsController) {
        this.f21221a = new d(windowInsetsController, new b0(windowInsetsController));
    }

    @Deprecated
    public static a1 toWindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        return new a1(windowInsetsController);
    }

    public void setAppearanceLightNavigationBars(boolean z10) {
        this.f21221a.setAppearanceLightNavigationBars(z10);
    }

    public void setAppearanceLightStatusBars(boolean z10) {
        this.f21221a.setAppearanceLightStatusBars(z10);
    }

    public void show(int i10) {
        this.f21221a.a(i10);
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final WindowInsetsController f21224a;

        /* renamed from: b, reason: collision with root package name */
        public final b0 f21225b;

        /* renamed from: c, reason: collision with root package name */
        public final Window f21226c;

        public d(Window window, b0 b0Var) {
            this(window.getInsetsController(), b0Var);
            this.f21226c = window;
        }

        @Override // x0.a1.e
        public final void a(int i10) {
            if ((i10 & 8) != 0) {
                this.f21225b.show();
            }
            this.f21224a.show(i10 & (-9));
        }

        @Override // x0.a1.e
        public void setAppearanceLightNavigationBars(boolean z10) {
            WindowInsetsController windowInsetsController = this.f21224a;
            Window window = this.f21226c;
            if (z10) {
                if (window != null) {
                    setSystemUiFlag(16);
                }
                windowInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                if (window != null) {
                    unsetSystemUiFlag(16);
                }
                windowInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // x0.a1.e
        public void setAppearanceLightStatusBars(boolean z10) {
            WindowInsetsController windowInsetsController = this.f21224a;
            Window window = this.f21226c;
            if (z10) {
                if (window != null) {
                    setSystemUiFlag(8192);
                }
                windowInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                if (window != null) {
                    unsetSystemUiFlag(8192);
                }
                windowInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        public void setSystemUiFlag(int i10) {
            View decorView = this.f21226c.getDecorView();
            decorView.setSystemUiVisibility(i10 | decorView.getSystemUiVisibility());
        }

        public void unsetSystemUiFlag(int i10) {
            View decorView = this.f21226c.getDecorView();
            decorView.setSystemUiVisibility((~i10) & decorView.getSystemUiVisibility());
        }

        public d(WindowInsetsController windowInsetsController, b0 b0Var) {
            new b0.k();
            this.f21224a = windowInsetsController;
            this.f21225b = b0Var;
        }
    }

    public a1(Window window, View view) {
        b0 b0Var = new b0(view);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.f21221a = new d(window, b0Var);
            return;
        }
        if (i10 >= 26) {
            this.f21221a = new c(window, b0Var);
        } else if (i10 >= 23) {
            this.f21221a = new b(window, b0Var);
        } else {
            this.f21221a = new a(window, b0Var);
        }
    }

    /* compiled from: WindowInsetsControllerCompat.java */
    public static class e {
        public void a(int i10) {
            throw null;
        }

        public void setAppearanceLightNavigationBars(boolean z10) {
        }

        public void setAppearanceLightStatusBars(boolean z10) {
        }
    }
}
