package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.R;
import androidx.appcompat.widget.s0;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f1416b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static k f1417c;

    /* renamed from: a, reason: collision with root package name */
    public s0 f1418a;

    /* compiled from: AppCompatDrawableManager.java */
    public class a implements s0.f {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f1419a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b, reason: collision with root package name */
        public final int[] f1420b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c, reason: collision with root package name */
        public final int[] f1421c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};

        /* renamed from: d, reason: collision with root package name */
        public final int[] f1422d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e, reason: collision with root package name */
        public final int[] f1423e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

        /* renamed from: f, reason: collision with root package name */
        public final int[] f1424f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

        public static boolean a(int[] iArr, int i10) {
            for (int i11 : iArr) {
                if (i11 == i10) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(Context context, int i10) {
            int themeAttrColor = x0.getThemeAttrColor(context, R.attr.colorControlHighlight);
            return new ColorStateList(new int[][]{x0.f1546b, x0.f1548d, x0.f1547c, x0.f1550f}, new int[]{x0.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), o0.a.compositeColors(themeAttrColor, i10), o0.a.compositeColors(themeAttrColor, i10), i10});
        }

        public static LayerDrawable c(s0 s0Var, Context context, int i10) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
            Drawable drawable = s0Var.getDrawable(context, R.drawable.abc_star_black_48dp);
            Drawable drawable2 = s0Var.getDrawable(context, R.drawable.abc_star_half_black_48dp);
            if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawable;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawable2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawable2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, android.R.id.background);
            layerDrawable.setId(1, android.R.id.secondaryProgress);
            layerDrawable.setId(2, android.R.id.progress);
            return layerDrawable;
        }

        public static void d(Drawable drawable, int i10, PorterDuff.Mode mode) {
            if (i0.canSafelyMutateDrawable(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = k.f1416b;
            }
            drawable.setColorFilter(k.getPorterDuffColorFilter(i10, mode));
        }

        public Drawable createDrawableFor(s0 s0Var, Context context, int i10) {
            if (i10 == R.drawable.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{s0Var.getDrawable(context, R.drawable.abc_cab_background_internal_bg), s0Var.getDrawable(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            }
            if (i10 == R.drawable.abc_ratingbar_material) {
                return c(s0Var, context, R.dimen.abc_star_big);
            }
            if (i10 == R.drawable.abc_ratingbar_indicator_material) {
                return c(s0Var, context, R.dimen.abc_star_medium);
            }
            if (i10 == R.drawable.abc_ratingbar_small_material) {
                return c(s0Var, context, R.dimen.abc_star_small);
            }
            return null;
        }

        public ColorStateList getTintListForDrawableRes(Context context, int i10) {
            if (i10 == R.drawable.abc_edit_text_material) {
                return s.a.getColorStateList(context, R.color.abc_tint_edittext);
            }
            if (i10 == R.drawable.abc_switch_track_mtrl_alpha) {
                return s.a.getColorStateList(context, R.color.abc_tint_switch_track);
            }
            if (i10 != R.drawable.abc_switch_thumb_material) {
                if (i10 == R.drawable.abc_btn_default_mtrl_shape) {
                    return b(context, x0.getThemeAttrColor(context, R.attr.colorButtonNormal));
                }
                if (i10 == R.drawable.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i10 == R.drawable.abc_btn_colored_material) {
                    return b(context, x0.getThemeAttrColor(context, R.attr.colorAccent));
                }
                if (i10 == R.drawable.abc_spinner_mtrl_am_alpha || i10 == R.drawable.abc_spinner_textfield_background_material) {
                    return s.a.getColorStateList(context, R.color.abc_tint_spinner);
                }
                if (a(this.f1420b, i10)) {
                    return x0.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
                }
                if (a(this.f1423e, i10)) {
                    return s.a.getColorStateList(context, R.color.abc_tint_default);
                }
                if (a(this.f1424f, i10)) {
                    return s.a.getColorStateList(context, R.color.abc_tint_btn_checkable);
                }
                if (i10 == R.drawable.abc_seekbar_thumb_material) {
                    return s.a.getColorStateList(context, R.color.abc_tint_seek_thumb);
                }
                return null;
            }
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            int i11 = R.attr.colorSwitchThumbNormal;
            ColorStateList themeAttrColorStateList = x0.getThemeAttrColorStateList(context, i11);
            if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
                iArr[0] = x0.f1546b;
                iArr2[0] = x0.getDisabledThemeAttrColor(context, i11);
                iArr[1] = x0.f1549e;
                iArr2[1] = x0.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = x0.f1550f;
                iArr2[2] = x0.getThemeAttrColor(context, i11);
            } else {
                int[] iArr3 = x0.f1546b;
                iArr[0] = iArr3;
                iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
                iArr[1] = x0.f1549e;
                iArr2[1] = x0.getThemeAttrColor(context, R.attr.colorControlActivated);
                iArr[2] = x0.f1550f;
                iArr2[2] = themeAttrColorStateList.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        public PorterDuff.Mode getTintModeForDrawableRes(int i10) {
            if (i10 == R.drawable.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        public boolean tintDrawable(Context context, int i10, Drawable drawable) {
            if (i10 == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int i11 = R.attr.colorControlNormal;
                int themeAttrColor = x0.getThemeAttrColor(context, i11);
                PorterDuff.Mode mode = k.f1416b;
                d(drawableFindDrawableByLayerId, themeAttrColor, mode);
                d(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), x0.getThemeAttrColor(context, i11), mode);
                d(layerDrawable.findDrawableByLayerId(android.R.id.progress), x0.getThemeAttrColor(context, R.attr.colorControlActivated), mode);
                return true;
            }
            if (i10 != R.drawable.abc_ratingbar_material && i10 != R.drawable.abc_ratingbar_indicator_material && i10 != R.drawable.abc_ratingbar_small_material) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            Drawable drawableFindDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
            int disabledThemeAttrColor = x0.getDisabledThemeAttrColor(context, R.attr.colorControlNormal);
            PorterDuff.Mode mode2 = k.f1416b;
            d(drawableFindDrawableByLayerId2, disabledThemeAttrColor, mode2);
            Drawable drawableFindDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress);
            int i12 = R.attr.colorControlActivated;
            d(drawableFindDrawableByLayerId3, x0.getThemeAttrColor(context, i12), mode2);
            d(layerDrawable2.findDrawableByLayerId(android.R.id.progress), x0.getThemeAttrColor(context, i12), mode2);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0060 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean tintDrawableUsingColorFilter(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.k.f1416b
                int[] r1 = r6.f1419a
                boolean r1 = a(r1, r8)
                r2 = -1
                r3 = 0
                r4 = 1
                if (r1 == 0) goto L10
                int r8 = androidx.appcompat.R.attr.colorControlNormal
                goto L3c
            L10:
                int[] r1 = r6.f1421c
                boolean r1 = a(r1, r8)
                if (r1 == 0) goto L1b
                int r8 = androidx.appcompat.R.attr.colorControlActivated
                goto L3c
            L1b:
                int[] r1 = r6.f1422d
                boolean r1 = a(r1, r8)
                if (r1 == 0) goto L26
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L39
            L26:
                int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L35
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = 16842800(0x1010030, float:2.3693693E-38)
                goto L3e
            L35:
                int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
                if (r8 != r1) goto L40
            L39:
                r8 = 16842801(0x1010031, float:2.3693695E-38)
            L3c:
                r1 = r8
                r8 = -1
            L3e:
                r5 = 1
                goto L43
            L40:
                r8 = -1
                r1 = 0
                r5 = 0
            L43:
                if (r5 == 0) goto L60
                boolean r3 = androidx.appcompat.widget.i0.canSafelyMutateDrawable(r9)
                if (r3 == 0) goto L4f
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L4f:
                int r7 = androidx.appcompat.widget.x0.getThemeAttrColor(r7, r1)
                android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.k.getPorterDuffColorFilter(r7, r0)
                r9.setColorFilter(r7)
                if (r8 == r2) goto L5f
                r9.setAlpha(r8)
            L5f:
                return r4
            L60:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.k.a.tintDrawableUsingColorFilter(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }
    }

    public static void a(Drawable drawable, a1 a1Var, int[] iArr) {
        PorterDuff.Mode mode = s0.f1508h;
        int[] state = drawable.getState();
        if (i0.canSafelyMutateDrawable(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = a1Var.f1252d;
        if (z10 || a1Var.f1251c) {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z10 ? a1Var.f1249a : null;
            PorterDuff.Mode mode2 = a1Var.f1251c ? a1Var.f1250b : s0.f1508h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = s0.getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public static synchronized k get() {
        if (f1417c == null) {
            preload();
        }
        return f1417c;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int i10, PorterDuff.Mode mode) {
        return s0.getPorterDuffColorFilter(i10, mode);
    }

    public static synchronized void preload() {
        if (f1417c == null) {
            k kVar = new k();
            f1417c = kVar;
            kVar.f1418a = s0.get();
            f1417c.f1418a.setHooks(new a());
        }
    }

    public synchronized Drawable getDrawable(Context context, int i10) {
        return this.f1418a.getDrawable(context, i10);
    }

    public synchronized void onConfigurationChanged(Context context) {
        this.f1418a.onConfigurationChanged(context);
    }
}
