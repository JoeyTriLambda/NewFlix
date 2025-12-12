package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.cast.framework.R;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.4.0 */
/* loaded from: classes.dex */
final class zzi {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f6443a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    public final int f6444b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6445c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6446d;

    /* renamed from: e, reason: collision with root package name */
    public final int f6447e;

    /* renamed from: f, reason: collision with root package name */
    public final zzh f6448f;

    public zzi(zzh zzhVar) {
        this.f6448f = zzhVar;
        Resources resources = zzhVar.getResources();
        this.f6444b = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_inner_radius);
        this.f6445c = resources.getDimensionPixelOffset(R.dimen.cast_libraries_material_featurehighlight_inner_margin);
        this.f6446d = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_max_width);
        this.f6447e = resources.getDimensionPixelSize(R.dimen.cast_libraries_material_featurehighlight_text_horizontal_offset);
    }

    public final int a(View view, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = i13 - i10;
        int i15 = i11 - i13;
        int i16 = i13 - (i12 / 2);
        int i17 = this.f6447e;
        int i18 = i14 <= i15 ? i16 + i17 : i16 - i17;
        int i19 = marginLayoutParams.leftMargin;
        if (i18 - i19 < i10) {
            return i10 + i19;
        }
        int i20 = marginLayoutParams.rightMargin;
        return (i18 + i12) + i20 > i11 ? (i11 - i12) - i20 : i18;
    }

    public final void b(View view, int i10, int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(View.MeasureSpec.makeMeasureSpec(Math.min((i10 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin, this.f6446d), 1073741824), View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE));
    }
}
