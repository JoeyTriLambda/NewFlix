package u6;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import o7.b;
import q7.g;
import q7.l;
import q7.p;
import x0.j0;

/* compiled from: MaterialButtonHelper.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: u, reason: collision with root package name */
    public static final boolean f20114u;

    /* renamed from: v, reason: collision with root package name */
    public static final boolean f20115v;

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f20116a;

    /* renamed from: b, reason: collision with root package name */
    public l f20117b;

    /* renamed from: c, reason: collision with root package name */
    public int f20118c;

    /* renamed from: d, reason: collision with root package name */
    public int f20119d;

    /* renamed from: e, reason: collision with root package name */
    public int f20120e;

    /* renamed from: f, reason: collision with root package name */
    public int f20121f;

    /* renamed from: g, reason: collision with root package name */
    public int f20122g;

    /* renamed from: h, reason: collision with root package name */
    public int f20123h;

    /* renamed from: i, reason: collision with root package name */
    public PorterDuff.Mode f20124i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f20125j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f20126k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f20127l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f20128m;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20132q;

    /* renamed from: s, reason: collision with root package name */
    public LayerDrawable f20134s;

    /* renamed from: t, reason: collision with root package name */
    public int f20135t;

    /* renamed from: n, reason: collision with root package name */
    public boolean f20129n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f20130o = false;

    /* renamed from: p, reason: collision with root package name */
    public boolean f20131p = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20133r = true;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f20114u = true;
        f20115v = i10 <= 22;
    }

    public a(MaterialButton materialButton, l lVar) {
        this.f20116a = materialButton;
        this.f20117b = lVar;
    }

    public final g a(boolean z10) {
        LayerDrawable layerDrawable = this.f20134s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return f20114u ? (g) ((LayerDrawable) ((InsetDrawable) this.f20134s.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0) : (g) this.f20134s.getDrawable(!z10 ? 1 : 0);
    }

    public final void b(l lVar) {
        this.f20117b = lVar;
        if (!f20115v || this.f20130o) {
            if (a(false) != null) {
                a(false).setShapeAppearanceModel(lVar);
            }
            if (a(true) != null) {
                a(true).setShapeAppearanceModel(lVar);
            }
            if (getMaskDrawable() != null) {
                getMaskDrawable().setShapeAppearanceModel(lVar);
                return;
            }
            return;
        }
        MaterialButton materialButton = this.f20116a;
        int paddingStart = j0.getPaddingStart(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = j0.getPaddingEnd(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        d();
        j0.setPaddingRelative(materialButton, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    public final void c(int i10, int i11) {
        MaterialButton materialButton = this.f20116a;
        int paddingStart = j0.getPaddingStart(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = j0.getPaddingEnd(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i12 = this.f20120e;
        int i13 = this.f20121f;
        this.f20121f = i11;
        this.f20120e = i10;
        if (!this.f20130o) {
            d();
        }
        j0.setPaddingRelative(materialButton, paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.graphics.drawable.LayerDrawable, android.graphics.drawable.RippleDrawable] */
    public final void d() {
        InsetDrawable insetDrawable;
        g gVar = new g(this.f20117b);
        MaterialButton materialButton = this.f20116a;
        gVar.initializeElevationOverlay(materialButton.getContext());
        p0.a.setTintList(gVar, this.f20125j);
        PorterDuff.Mode mode = this.f20124i;
        if (mode != null) {
            p0.a.setTintMode(gVar, mode);
        }
        gVar.setStroke(this.f20123h, this.f20126k);
        g gVar2 = new g(this.f20117b);
        gVar2.setTint(0);
        gVar2.setStroke(this.f20123h, this.f20129n ? c7.a.getColor(materialButton, R.attr.colorSurface) : 0);
        if (f20114u) {
            g gVar3 = new g(this.f20117b);
            this.f20128m = gVar3;
            p0.a.setTint(gVar3, -1);
            ?? rippleDrawable = new RippleDrawable(b.sanitizeRippleDrawableColor(this.f20127l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar2, gVar}), this.f20118c, this.f20120e, this.f20119d, this.f20121f), this.f20128m);
            this.f20134s = rippleDrawable;
            insetDrawable = rippleDrawable;
        } else {
            o7.a aVar = new o7.a(this.f20117b);
            this.f20128m = aVar;
            p0.a.setTintList(aVar, b.sanitizeRippleDrawableColor(this.f20127l));
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.f20128m});
            this.f20134s = layerDrawable;
            insetDrawable = new InsetDrawable((Drawable) layerDrawable, this.f20118c, this.f20120e, this.f20119d, this.f20121f);
        }
        materialButton.setInternalBackground(insetDrawable);
        g gVarA = a(false);
        if (gVarA != null) {
            gVarA.setElevation(this.f20135t);
            gVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void e() {
        g gVarA = a(false);
        g gVarA2 = a(true);
        if (gVarA != null) {
            gVarA.setStroke(this.f20123h, this.f20126k);
            if (gVarA2 != null) {
                gVarA2.setStroke(this.f20123h, this.f20129n ? c7.a.getColor(this.f20116a, R.attr.colorSurface) : 0);
            }
        }
    }

    public int getInsetBottom() {
        return this.f20121f;
    }

    public int getInsetTop() {
        return this.f20120e;
    }

    public p getMaskDrawable() {
        LayerDrawable layerDrawable = this.f20134s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f20134s.getNumberOfLayers() > 2 ? (p) this.f20134s.getDrawable(2) : (p) this.f20134s.getDrawable(1);
    }

    public void setInsetBottom(int i10) {
        c(this.f20120e, i10);
    }

    public void setInsetTop(int i10) {
        c(i10, this.f20121f);
    }
}
