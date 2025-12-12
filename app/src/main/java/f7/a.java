package f7;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R;
import n7.b;

/* compiled from: ElevationOverlayProvider.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f11523f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11524a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11525b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11526c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11527d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11528e;

    public a(Context context) {
        this(b.resolveBoolean(context, R.attr.elevationOverlayEnabled, false), c7.a.getColor(context, R.attr.elevationOverlayColor, 0), c7.a.getColor(context, R.attr.elevationOverlayAccentColor, 0), c7.a.getColor(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public float calculateOverlayAlphaFraction(float f10) {
        if (this.f11528e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int compositeOverlay(int i10, float f10) {
        int i11;
        float fCalculateOverlayAlphaFraction = calculateOverlayAlphaFraction(f10);
        int iAlpha = Color.alpha(i10);
        int iLayer = c7.a.layer(o0.a.setAlphaComponent(i10, 255), this.f11525b, fCalculateOverlayAlphaFraction);
        if (fCalculateOverlayAlphaFraction > 0.0f && (i11 = this.f11526c) != 0) {
            iLayer = c7.a.layer(iLayer, o0.a.setAlphaComponent(i11, f11523f));
        }
        return o0.a.setAlphaComponent(iLayer, iAlpha);
    }

    public int compositeOverlayIfNeeded(int i10, float f10) {
        if (this.f11524a) {
            return o0.a.setAlphaComponent(i10, 255) == this.f11527d ? compositeOverlay(i10, f10) : i10;
        }
        return i10;
    }

    public int compositeOverlayWithThemeSurfaceColorIfNeeded(float f10) {
        return compositeOverlayIfNeeded(this.f11527d, f10);
    }

    public boolean isThemeElevationOverlayEnabled() {
        return this.f11524a;
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f11524a = z10;
        this.f11525b = i10;
        this.f11526c = i11;
        this.f11527d = i12;
        this.f11528e = f10;
    }
}
