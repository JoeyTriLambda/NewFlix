package androidx.leanback.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.R;

/* compiled from: ShadowOverlayHelper.java */
/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3338a = 1;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3339b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3340c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3341d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3342e;

    /* renamed from: f, reason: collision with root package name */
    public int f3343f;

    /* renamed from: g, reason: collision with root package name */
    public float f3344g;

    /* renamed from: h, reason: collision with root package name */
    public float f3345h;

    /* compiled from: ShadowOverlayHelper.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3346a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3347b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f3348c;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3350e;

        /* renamed from: d, reason: collision with root package name */
        public boolean f3349d = true;

        /* renamed from: f, reason: collision with root package name */
        public b f3351f = b.f3352c;

        public r0 build(Context context) {
            r0 r0Var = new r0();
            r0Var.f3339b = this.f3346a;
            boolean z10 = false;
            r0Var.f3340c = this.f3347b && r0.supportsRoundedCorner();
            r0Var.f3341d = this.f3348c && r0.supportsShadow();
            if (r0Var.f3340c) {
                b bVar = this.f3351f;
                if (bVar.getRoundedCornerRadius() == 0) {
                    r0Var.f3343f = context.getResources().getDimensionPixelSize(R.dimen.lb_rounded_rect_corner_radius);
                } else {
                    r0Var.f3343f = bVar.getRoundedCornerRadius();
                }
            }
            if (!r0Var.f3341d) {
                r0Var.f3338a = 1;
                if ((!r0.supportsForeground() || this.f3350e) && r0Var.f3339b) {
                    z10 = true;
                }
                r0Var.f3342e = z10;
            } else if (this.f3349d && r0.supportsDynamicShadow()) {
                r0Var.f3338a = 3;
                b bVar2 = this.f3351f;
                if (bVar2.getDynamicShadowUnfocusedZ() < 0.0f) {
                    Resources resources = context.getResources();
                    r0Var.f3345h = resources.getDimension(R.dimen.lb_material_shadow_focused_z);
                    r0Var.f3344g = resources.getDimension(R.dimen.lb_material_shadow_normal_z);
                } else {
                    r0Var.f3345h = bVar2.getDynamicShadowFocusedZ();
                    r0Var.f3344g = bVar2.getDynamicShadowUnfocusedZ();
                }
                if ((!r0.supportsForeground() || this.f3350e) && r0Var.f3339b) {
                    z10 = true;
                }
                r0Var.f3342e = z10;
            } else {
                r0Var.f3338a = 2;
                r0Var.f3342e = true;
            }
            return r0Var;
        }

        public a keepForegroundDrawable(boolean z10) {
            this.f3350e = z10;
            return this;
        }

        public a needsOverlay(boolean z10) {
            this.f3346a = z10;
            return this;
        }

        public a needsRoundedCorner(boolean z10) {
            this.f3347b = z10;
            return this;
        }

        public a needsShadow(boolean z10) {
            this.f3348c = z10;
            return this;
        }

        public a options(b bVar) {
            this.f3351f = bVar;
            return this;
        }

        public a preferZOrder(boolean z10) {
            this.f3349d = z10;
            return this;
        }
    }

    /* compiled from: ShadowOverlayHelper.java */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f3352c = new b();

        /* renamed from: a, reason: collision with root package name */
        public final float f3353a = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        public final float f3354b = -1.0f;

        public final float getDynamicShadowFocusedZ() {
            return this.f3354b;
        }

        public final float getDynamicShadowUnfocusedZ() {
            return this.f3353a;
        }

        public final int getRoundedCornerRadius() {
            return 0;
        }
    }

    public static void a(Object obj, int i10, float f10) {
        if (obj != null) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            } else if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                p0.setShadowFocusLevel(obj, f10);
            } else {
                x0 x0Var = (x0) obj;
                x0Var.f3410a.setAlpha(1.0f - f10);
                x0Var.f3411b.setAlpha(f10);
            }
        }
    }

    public static void setNoneWrapperOverlayColor(View view, int i10) {
        int i11 = Build.VERSION.SDK_INT;
        Drawable foreground = i11 >= 23 ? view.getForeground() : null;
        if (foreground instanceof ColorDrawable) {
            ((ColorDrawable) foreground).setColor(i10);
            return;
        }
        ColorDrawable colorDrawable = new ColorDrawable(i10);
        if (i11 >= 23) {
            view.setForeground(colorDrawable);
        }
    }

    public static void setNoneWrapperShadowFocusLevel(View view, float f10) {
        a(view.getTag(R.id.lb_shadow_impl), 3, f10);
    }

    public static boolean supportsDynamicShadow() {
        return true;
    }

    public static boolean supportsForeground() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean supportsRoundedCorner() {
        return true;
    }

    public static boolean supportsShadow() {
        return true;
    }

    public q0 createShadowOverlayContainer(Context context) {
        if (needsWrapper()) {
            return new q0(context, this.f3338a, this.f3339b, this.f3344g, this.f3345h, this.f3343f);
        }
        throw new IllegalArgumentException();
    }

    public int getShadowType() {
        return this.f3338a;
    }

    public boolean needsOverlay() {
        return this.f3339b;
    }

    public boolean needsWrapper() {
        return this.f3342e;
    }

    public void onViewCreated(View view) {
        if (needsWrapper()) {
            return;
        }
        if (!this.f3341d) {
            if (this.f3340c) {
                i0.setClipToRoundedOutline(view, true, this.f3343f);
            }
        } else if (this.f3338a == 3) {
            view.setTag(R.id.lb_shadow_impl, p0.addDynamicShadow(view, this.f3344g, this.f3345h, this.f3343f));
        } else if (this.f3340c) {
            i0.setClipToRoundedOutline(view, true, this.f3343f);
        }
    }

    public void prepareParentForShadow(ViewGroup viewGroup) {
        if (this.f3338a == 2) {
            viewGroup.setLayoutMode(1);
        }
    }

    public void setOverlayColor(View view, int i10) {
        if (needsWrapper()) {
            ((q0) view).setOverlayColor(i10);
        } else {
            setNoneWrapperOverlayColor(view, i10);
        }
    }
}
