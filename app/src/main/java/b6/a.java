package b6;

import android.graphics.Bitmap;
import android.text.Layout;

/* compiled from: Cue.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f4777b;

    /* renamed from: m, reason: collision with root package name */
    public final float f4778m;

    /* renamed from: n, reason: collision with root package name */
    public final float f4779n;

    public a(Bitmap bitmap, float f10, int i10, float f11, int i11, float f12, float f13) {
        this(null, f11, f10);
    }

    public a(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12) {
        this(charSequence, alignment, f10, i10, i11, f11, i12, f12, false, -16777216);
    }

    public a(CharSequence charSequence, Layout.Alignment alignment, float f10, int i10, int i11, float f11, int i12, float f12, boolean z10, int i13) {
        this(charSequence, f10, f11);
    }

    public a(CharSequence charSequence, float f10, float f11) {
        this.f4777b = charSequence;
        this.f4778m = f10;
        this.f4779n = f11;
    }
}
