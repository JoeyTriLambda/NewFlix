package n7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.material.R;
import n0.g;

/* compiled from: TextAppearance.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f16735a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16736b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16737c;

    /* renamed from: d, reason: collision with root package name */
    public final int f16738d;

    /* renamed from: e, reason: collision with root package name */
    public final float f16739e;

    /* renamed from: f, reason: collision with root package name */
    public final float f16740f;

    /* renamed from: g, reason: collision with root package name */
    public final float f16741g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f16742h;

    /* renamed from: i, reason: collision with root package name */
    public final float f16743i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f16744j;

    /* renamed from: k, reason: collision with root package name */
    public float f16745k;

    /* renamed from: l, reason: collision with root package name */
    public final int f16746l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16747m = false;

    /* renamed from: n, reason: collision with root package name */
    public Typeface f16748n;

    /* compiled from: TextAppearance.java */
    public class a extends g.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f16749a;

        public a(f fVar) {
            this.f16749a = fVar;
        }

        @Override // n0.g.e
        public void onFontRetrievalFailed(int i10) {
            d.this.f16747m = true;
            this.f16749a.onFontRetrievalFailed(i10);
        }

        @Override // n0.g.e
        public void onFontRetrieved(Typeface typeface) {
            d dVar = d.this;
            dVar.f16748n = Typeface.create(typeface, dVar.f16737c);
            dVar.f16747m = true;
            this.f16749a.onFontRetrieved(dVar.f16748n, false);
        }
    }

    /* compiled from: TextAppearance.java */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f16751a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f16752b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f16753c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f16751a = context;
            this.f16752b = textPaint;
            this.f16753c = fVar;
        }

        @Override // n7.f
        public void onFontRetrievalFailed(int i10) {
            this.f16753c.onFontRetrievalFailed(i10);
        }

        @Override // n7.f
        public void onFontRetrieved(Typeface typeface, boolean z10) {
            d.this.updateTextPaintMeasureState(this.f16751a, this.f16752b, typeface);
            this.f16753c.onFontRetrieved(typeface, z10);
        }
    }

    public d(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.TextAppearance);
        setTextSize(typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f16737c = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f16738d = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i11 = R.styleable.TextAppearance_fontFamily;
        i11 = typedArrayObtainStyledAttributes.hasValue(i11) ? i11 : R.styleable.TextAppearance_android_fontFamily;
        this.f16746l = typedArrayObtainStyledAttributes.getResourceId(i11, 0);
        this.f16736b = typedArrayObtainStyledAttributes.getString(i11);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f16735a = c.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f16739e = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f16740f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f16741g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, R.styleable.MaterialTextAppearance);
        int i12 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.f16742h = typedArrayObtainStyledAttributes2.hasValue(i12);
        this.f16743i = typedArrayObtainStyledAttributes2.getFloat(i12, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f16748n;
        int i10 = this.f16737c;
        if (typeface == null && (str = this.f16736b) != null) {
            this.f16748n = Typeface.create(str, i10);
        }
        if (this.f16748n == null) {
            int i11 = this.f16738d;
            if (i11 == 1) {
                this.f16748n = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.f16748n = Typeface.SERIF;
            } else if (i11 != 3) {
                this.f16748n = Typeface.DEFAULT;
            } else {
                this.f16748n = Typeface.MONOSPACE;
            }
            this.f16748n = Typeface.create(this.f16748n, i10);
        }
    }

    public Typeface getFallbackFont() {
        a();
        return this.f16748n;
    }

    public Typeface getFont(Context context) {
        if (this.f16747m) {
            return this.f16748n;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = n0.g.getFont(context, this.f16746l);
                this.f16748n = font;
                if (font != null) {
                    this.f16748n = Typeface.create(font, this.f16737c);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f16736b, e10);
            }
        }
        a();
        this.f16747m = true;
        return this.f16748n;
    }

    public void getFontAsync(Context context, TextPaint textPaint, f fVar) {
        updateTextPaintMeasureState(context, textPaint, getFallbackFont());
        getFontAsync(context, new b(context, textPaint, fVar));
    }

    public ColorStateList getTextColor() {
        return this.f16744j;
    }

    public float getTextSize() {
        return this.f16745k;
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f16744j = colorStateList;
    }

    public void setTextSize(float f10) {
        this.f16745k = f10;
    }

    public void updateDrawState(Context context, TextPaint textPaint, f fVar) {
        updateMeasureState(context, textPaint, fVar);
        ColorStateList colorStateList = this.f16744j;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f16735a;
        textPaint.setShadowLayer(this.f16741g, this.f16739e, this.f16740f, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(Context context, TextPaint textPaint, f fVar) {
        boolean z10 = true;
        if (!e.shouldLoadFontSynchronously()) {
            int i10 = this.f16746l;
            if ((i10 != 0 ? n0.g.getCachedFont(context, i10) : null) == null) {
                z10 = false;
            }
        }
        if (z10) {
            updateTextPaintMeasureState(context, textPaint, getFont(context));
        } else {
            getFontAsync(context, textPaint, fVar);
        }
    }

    public void updateTextPaintMeasureState(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceMaybeCopyWithFontWeightAdjustment = g.maybeCopyWithFontWeightAdjustment(context, typeface);
        if (typefaceMaybeCopyWithFontWeightAdjustment != null) {
            typeface = typefaceMaybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface);
        int i10 = (~typeface.getStyle()) & this.f16737c;
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f16745k);
        if (this.f16742h) {
            textPaint.setLetterSpacing(this.f16743i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getFontAsync(android.content.Context r5, n7.f r6) {
        /*
            r4 = this;
            boolean r0 = n7.e.shouldLoadFontSynchronously()
            r1 = 0
            int r2 = r4.f16746l
            r3 = 1
            if (r0 == 0) goto Lb
            goto L15
        Lb:
            if (r2 == 0) goto L12
            android.graphics.Typeface r0 = n0.g.getCachedFont(r5, r2)
            goto L13
        L12:
            r0 = r1
        L13:
            if (r0 == 0) goto L17
        L15:
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            if (r0 == 0) goto L1e
            r4.getFont(r5)
            goto L21
        L1e:
            r4.a()
        L21:
            if (r2 != 0) goto L25
            r4.f16747m = r3
        L25:
            boolean r0 = r4.f16747m
            if (r0 == 0) goto L2f
            android.graphics.Typeface r5 = r4.f16748n
            r6.onFontRetrieved(r5, r3)
            return
        L2f:
            n7.d$a r0 = new n7.d$a     // Catch: java.lang.Exception -> L38 android.content.res.Resources.NotFoundException -> L55
            r0.<init>(r6)     // Catch: java.lang.Exception -> L38 android.content.res.Resources.NotFoundException -> L55
            n0.g.getFont(r5, r2, r0, r1)     // Catch: java.lang.Exception -> L38 android.content.res.Resources.NotFoundException -> L55
            goto L5a
        L38:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Error loading font "
            r0.<init>(r1)
            java.lang.String r1 = r4.f16736b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "TextAppearance"
            android.util.Log.d(r1, r0, r5)
            r4.f16747m = r3
            r5 = -3
            r6.onFontRetrievalFailed(r5)
            goto L5a
        L55:
            r4.f16747m = r3
            r6.onFontRetrievalFailed(r3)
        L5a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.d.getFontAsync(android.content.Context, n7.f):void");
    }
}
