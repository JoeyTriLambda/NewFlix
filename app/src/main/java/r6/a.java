package r6;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R;
import i7.p;
import i7.r;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import n7.d;
import q7.g;
import q7.l;
import r6.b;

/* compiled from: BadgeDrawable.java */
/* loaded from: classes.dex */
public final class a extends Drawable implements p.b {

    /* renamed from: y, reason: collision with root package name */
    public static final int f18607y = R.style.Widget_MaterialComponents_Badge;

    /* renamed from: z, reason: collision with root package name */
    public static final int f18608z = R.attr.badgeStyle;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<Context> f18609b;

    /* renamed from: m, reason: collision with root package name */
    public final g f18610m;

    /* renamed from: n, reason: collision with root package name */
    public final p f18611n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f18612o;

    /* renamed from: p, reason: collision with root package name */
    public final b f18613p;

    /* renamed from: q, reason: collision with root package name */
    public float f18614q;

    /* renamed from: r, reason: collision with root package name */
    public float f18615r;

    /* renamed from: s, reason: collision with root package name */
    public int f18616s;

    /* renamed from: t, reason: collision with root package name */
    public float f18617t;

    /* renamed from: u, reason: collision with root package name */
    public float f18618u;

    /* renamed from: v, reason: collision with root package name */
    public float f18619v;

    /* renamed from: w, reason: collision with root package name */
    public WeakReference<View> f18620w;

    /* renamed from: x, reason: collision with root package name */
    public WeakReference<FrameLayout> f18621x;

    public a(Context context) {
        d dVar;
        WeakReference<Context> weakReference = new WeakReference<>(context);
        this.f18609b = weakReference;
        r.checkMaterialTheme(context);
        this.f18612o = new Rect();
        p pVar = new p(this);
        this.f18611n = pVar;
        pVar.getTextPaint().setTextAlign(Paint.Align.CENTER);
        b bVar = new b(context);
        this.f18613p = bVar;
        boolean zB = b();
        b.a aVar = bVar.f18623b;
        g gVar = new g(l.builder(context, zB ? aVar.f18639r.intValue() : aVar.f18637p.intValue(), b() ? aVar.f18640s.intValue() : aVar.f18638q.intValue()).build());
        this.f18610m = gVar;
        c();
        Context context2 = weakReference.get();
        if (context2 != null && pVar.getTextAppearance() != (dVar = new d(context2, aVar.f18636o.intValue()))) {
            pVar.setTextAppearance(dVar, context2);
            pVar.getTextPaint().setColor(aVar.f18635n.intValue());
            invalidateSelf();
            d();
            invalidateSelf();
        }
        if (getMaxCharacterCount() != -2) {
            this.f18616s = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
        } else {
            this.f18616s = getMaxNumber();
        }
        pVar.setTextSizeDirty(true);
        d();
        invalidateSelf();
        pVar.setTextSizeDirty(true);
        c();
        d();
        invalidateSelf();
        pVar.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(aVar.f18634m.intValue());
        if (gVar.getFillColor() != colorStateListValueOf) {
            gVar.setFillColor(colorStateListValueOf);
            invalidateSelf();
        }
        pVar.getTextPaint().setColor(aVar.f18635n.intValue());
        invalidateSelf();
        WeakReference<View> weakReference2 = this.f18620w;
        if (weakReference2 != null && weakReference2.get() != null) {
            View view = this.f18620w.get();
            WeakReference<FrameLayout> weakReference3 = this.f18621x;
            updateBadgeCoordinates(view, weakReference3 != null ? weakReference3.get() : null);
        }
        d();
        setVisible(aVar.E.booleanValue(), false);
    }

    public static a create(Context context) {
        return new a(context);
    }

    public final String a() {
        boolean zHasText = hasText();
        WeakReference<Context> weakReference = this.f18609b;
        if (!zHasText) {
            if (!hasNumber()) {
                return null;
            }
            int i10 = this.f18616s;
            b bVar = this.f18613p;
            if (i10 == -2 || getNumber() <= this.f18616s) {
                return NumberFormat.getInstance(bVar.f18623b.f18646y).format(getNumber());
            }
            Context context = weakReference.get();
            return context == null ? "" : String.format(bVar.f18623b.f18646y, context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.f18616s), "+");
        }
        String text = getText();
        int maxCharacterCount = getMaxCharacterCount();
        if (maxCharacterCount != -2 && text != null && text.length() > maxCharacterCount) {
            Context context2 = weakReference.get();
            if (context2 == null) {
                return "";
            }
            text = String.format(context2.getString(R.string.m3_exceed_max_badge_text_suffix), text.substring(0, maxCharacterCount - 1), "…");
        }
        return text;
    }

    public final boolean b() {
        return hasText() || hasNumber();
    }

    public final void c() {
        Context context = this.f18609b.get();
        if (context == null) {
            return;
        }
        boolean zB = b();
        b bVar = this.f18613p;
        this.f18610m.setShapeAppearanceModel(l.builder(context, zB ? bVar.f18623b.f18639r.intValue() : bVar.f18623b.f18637p.intValue(), b() ? bVar.f18623b.f18640s.intValue() : bVar.f18623b.f18638q.intValue()).build());
        invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() {
        /*
            Method dump skipped, instructions count: 661
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.a.d():void");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        String strA;
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f18610m.draw(canvas);
        if (!b() || (strA = a()) == null) {
            return;
        }
        Rect rect = new Rect();
        p pVar = this.f18611n;
        pVar.getTextPaint().getTextBounds(strA, 0, strA.length(), rect);
        float fExactCenterY = this.f18615r - rect.exactCenterY();
        canvas.drawText(strA, this.f18614q, rect.bottom <= 0 ? (int) fExactCenterY : Math.round(fExactCenterY), pVar.getTextPaint());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f18613p.f18623b.f18641t;
    }

    public CharSequence getContentDescription() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        boolean zHasText = hasText();
        b bVar = this.f18613p;
        if (zHasText) {
            CharSequence charSequence = bVar.f18623b.f18647z;
            return charSequence != null ? charSequence : getText();
        }
        if (!hasNumber()) {
            return bVar.f18623b.A;
        }
        if (bVar.f18623b.B == 0 || (context = this.f18609b.get()) == null) {
            return null;
        }
        int i10 = this.f18616s;
        b.a aVar = bVar.f18623b;
        if (i10 != -2) {
            int number = getNumber();
            int i11 = this.f18616s;
            if (number > i11) {
                return context.getString(aVar.C, Integer.valueOf(i11));
            }
        }
        return context.getResources().getQuantityString(aVar.B, getNumber(), Integer.valueOf(getNumber()));
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> weakReference = this.f18621x;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18612o.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18612o.width();
    }

    public int getMaxCharacterCount() {
        return this.f18613p.f18623b.f18644w;
    }

    public int getMaxNumber() {
        return this.f18613p.f18623b.f18645x;
    }

    public int getNumber() {
        int i10 = this.f18613p.f18623b.f18643v;
        if (i10 != -1) {
            return i10;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public String getText() {
        return this.f18613p.f18623b.f18642u;
    }

    public boolean hasNumber() {
        b.a aVar = this.f18613p.f18623b;
        if (!(aVar.f18642u != null)) {
            if (aVar.f18643v != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasText() {
        return this.f18613p.f18623b.f18642u != null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, i7.p.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // i7.p.b
    public void onTextSizeChange() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        b bVar = this.f18613p;
        bVar.f18622a.f18641t = i10;
        bVar.f18623b.f18641t = i10;
        this.f18611n.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.f18620w = new WeakReference<>(view);
        this.f18621x = new WeakReference<>(frameLayout);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
        d();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
