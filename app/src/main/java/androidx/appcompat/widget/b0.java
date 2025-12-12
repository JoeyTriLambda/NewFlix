package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import n0.g;

/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f1254a;

    /* renamed from: b, reason: collision with root package name */
    public a1 f1255b;

    /* renamed from: c, reason: collision with root package name */
    public a1 f1256c;

    /* renamed from: d, reason: collision with root package name */
    public a1 f1257d;

    /* renamed from: e, reason: collision with root package name */
    public a1 f1258e;

    /* renamed from: f, reason: collision with root package name */
    public a1 f1259f;

    /* renamed from: g, reason: collision with root package name */
    public a1 f1260g;

    /* renamed from: h, reason: collision with root package name */
    public a1 f1261h;

    /* renamed from: i, reason: collision with root package name */
    public final d0 f1262i;

    /* renamed from: j, reason: collision with root package name */
    public int f1263j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f1264k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f1265l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1266m;

    /* compiled from: AppCompatTextHelper.java */
    public static class b {
        public static Drawable[] a(TextView textView) {
            return textView.getCompoundDrawablesRelative();
        }

        public static void b(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }

        public static void c(TextView textView, Locale locale) {
            textView.setTextLocale(locale);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public static class c {
        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public static class d {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public static class e {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public static class f {
        public static Typeface a(Typeface typeface, int i10, boolean z10) {
            return Typeface.create(typeface, i10, z10);
        }
    }

    public b0(TextView textView) {
        this.f1254a = textView;
        this.f1262i = new d0(textView);
    }

    public static a1 c(Context context, k kVar, int i10) {
        ColorStateList colorStateListF;
        synchronized (kVar) {
            colorStateListF = kVar.f1418a.f(context, i10);
        }
        if (colorStateListF == null) {
            return null;
        }
        a1 a1Var = new a1();
        a1Var.f1252d = true;
        a1Var.f1249a = colorStateListF;
        return a1Var;
    }

    public final void a(Drawable drawable, a1 a1Var) {
        if (drawable == null || a1Var == null) {
            return;
        }
        k.a(drawable, a1Var, this.f1254a.getDrawableState());
    }

    public final void b() {
        a1 a1Var = this.f1255b;
        TextView textView = this.f1254a;
        if (a1Var != null || this.f1256c != null || this.f1257d != null || this.f1258e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f1255b);
            a(compoundDrawables[1], this.f1256c);
            a(compoundDrawables[2], this.f1257d);
            a(compoundDrawables[3], this.f1258e);
        }
        if (this.f1259f == null && this.f1260g == null) {
            return;
        }
        Drawable[] drawableArrA = b.a(textView);
        a(drawableArrA[0], this.f1259f);
        a(drawableArrA[2], this.f1260g);
    }

    public final ColorStateList d() {
        a1 a1Var = this.f1261h;
        if (a1Var != null) {
            return a1Var.f1249a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        a1 a1Var = this.f1261h;
        if (a1Var != null) {
            return a1Var.f1250b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01a1  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(android.util.AttributeSet r24, int r25) {
        /*
            Method dump skipped, instructions count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b0.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i10) {
        String string;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, i10, R.styleable.TextAppearance);
        int i11 = R.styleable.TextAppearance_textAllCaps;
        boolean zHasValue = c1VarObtainStyledAttributes.hasValue(i11);
        TextView textView = this.f1254a;
        if (zHasValue) {
            textView.setAllCaps(c1VarObtainStyledAttributes.getBoolean(i11, false));
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 < 23) {
            int i13 = R.styleable.TextAppearance_android_textColor;
            if (c1VarObtainStyledAttributes.hasValue(i13) && (colorStateList3 = c1VarObtainStyledAttributes.getColorStateList(i13)) != null) {
                textView.setTextColor(colorStateList3);
            }
            int i14 = R.styleable.TextAppearance_android_textColorLink;
            if (c1VarObtainStyledAttributes.hasValue(i14) && (colorStateList2 = c1VarObtainStyledAttributes.getColorStateList(i14)) != null) {
                textView.setLinkTextColor(colorStateList2);
            }
            int i15 = R.styleable.TextAppearance_android_textColorHint;
            if (c1VarObtainStyledAttributes.hasValue(i15) && (colorStateList = c1VarObtainStyledAttributes.getColorStateList(i15)) != null) {
                textView.setHintTextColor(colorStateList);
            }
        }
        int i16 = R.styleable.TextAppearance_android_textSize;
        if (c1VarObtainStyledAttributes.hasValue(i16) && c1VarObtainStyledAttributes.getDimensionPixelSize(i16, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        m(context, c1VarObtainStyledAttributes);
        if (i12 >= 26) {
            int i17 = R.styleable.TextAppearance_fontVariationSettings;
            if (c1VarObtainStyledAttributes.hasValue(i17) && (string = c1VarObtainStyledAttributes.getString(i17)) != null) {
                e.d(textView, string);
            }
        }
        c1VarObtainStyledAttributes.recycle();
        Typeface typeface = this.f1265l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f1263j);
        }
    }

    public final void h(int i10, int i11, int i12, int i13) throws IllegalArgumentException {
        d0 d0Var = this.f1262i;
        if (d0Var.i()) {
            DisplayMetrics displayMetrics = d0Var.f1308j.getResources().getDisplayMetrics();
            d0Var.j(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (d0Var.g()) {
                d0Var.a();
            }
        }
    }

    public final void i(int[] iArr, int i10) throws IllegalArgumentException {
        d0 d0Var = this.f1262i;
        if (d0Var.i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i10 == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = d0Var.f1308j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArrCopyOf[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                d0Var.f1304f = d0.b(iArrCopyOf);
                if (!d0Var.h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                d0Var.f1305g = false;
            }
            if (d0Var.g()) {
                d0Var.a();
            }
        }
    }

    public final void j(int i10) {
        d0 d0Var = this.f1262i;
        if (d0Var.i()) {
            if (i10 == 0) {
                d0Var.f1299a = 0;
                d0Var.f1302d = -1.0f;
                d0Var.f1303e = -1.0f;
                d0Var.f1301c = -1.0f;
                d0Var.f1304f = new int[0];
                d0Var.f1300b = false;
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException(ac.c.f("Unknown auto-size text type: ", i10));
            }
            DisplayMetrics displayMetrics = d0Var.f1308j.getResources().getDisplayMetrics();
            d0Var.j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (d0Var.g()) {
                d0Var.a();
            }
        }
    }

    public final void k(ColorStateList colorStateList) {
        if (this.f1261h == null) {
            this.f1261h = new a1();
        }
        a1 a1Var = this.f1261h;
        a1Var.f1249a = colorStateList;
        a1Var.f1252d = colorStateList != null;
        this.f1255b = a1Var;
        this.f1256c = a1Var;
        this.f1257d = a1Var;
        this.f1258e = a1Var;
        this.f1259f = a1Var;
        this.f1260g = a1Var;
    }

    public final void l(PorterDuff.Mode mode) {
        if (this.f1261h == null) {
            this.f1261h = new a1();
        }
        a1 a1Var = this.f1261h;
        a1Var.f1250b = mode;
        a1Var.f1251c = mode != null;
        this.f1255b = a1Var;
        this.f1256c = a1Var;
        this.f1257d = a1Var;
        this.f1258e = a1Var;
        this.f1259f = a1Var;
        this.f1260g = a1Var;
    }

    public final void m(Context context, c1 c1Var) {
        String string;
        this.f1263j = c1Var.getInt(R.styleable.TextAppearance_android_textStyle, this.f1263j);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            int i11 = c1Var.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f1264k = i11;
            if (i11 != -1) {
                this.f1263j = (this.f1263j & 2) | 0;
            }
        }
        int i12 = R.styleable.TextAppearance_android_fontFamily;
        if (!c1Var.hasValue(i12) && !c1Var.hasValue(R.styleable.TextAppearance_fontFamily)) {
            int i13 = R.styleable.TextAppearance_android_typeface;
            if (c1Var.hasValue(i13)) {
                this.f1266m = false;
                int i14 = c1Var.getInt(i13, 1);
                if (i14 == 1) {
                    this.f1265l = Typeface.SANS_SERIF;
                    return;
                } else if (i14 == 2) {
                    this.f1265l = Typeface.SERIF;
                    return;
                } else {
                    if (i14 != 3) {
                        return;
                    }
                    this.f1265l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f1265l = null;
        int i15 = R.styleable.TextAppearance_fontFamily;
        if (c1Var.hasValue(i15)) {
            i12 = i15;
        }
        int i16 = this.f1264k;
        int i17 = this.f1263j;
        if (!context.isRestricted()) {
            try {
                Typeface font = c1Var.getFont(i12, this.f1263j, new a(i16, i17, new WeakReference(this.f1254a)));
                if (font != null) {
                    if (i10 < 28 || this.f1264k == -1) {
                        this.f1265l = font;
                    } else {
                        this.f1265l = f.a(Typeface.create(font, 0), this.f1264k, (this.f1263j & 2) != 0);
                    }
                }
                this.f1266m = this.f1265l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f1265l != null || (string = c1Var.getString(i12)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f1264k == -1) {
            this.f1265l = Typeface.create(string, this.f1263j);
        } else {
            this.f1265l = f.a(Typeface.create(string, 0), this.f1264k, (this.f1263j & 2) != 0);
        }
    }

    /* compiled from: AppCompatTextHelper.java */
    public class a extends g.e {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1267a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1268b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f1269c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f1267a = i10;
            this.f1268b = i11;
            this.f1269c = weakReference;
        }

        @Override // n0.g.e
        public void onFontRetrieved(Typeface typeface) {
            int i10;
            if (Build.VERSION.SDK_INT >= 28 && (i10 = this.f1267a) != -1) {
                typeface = f.a(typeface, i10, (this.f1268b & 2) != 0);
            }
            b0 b0Var = b0.this;
            if (b0Var.f1266m) {
                b0Var.f1265l = typeface;
                TextView textView = (TextView) this.f1269c.get();
                if (textView != null) {
                    if (x0.j0.isAttachedToWindow(textView)) {
                        textView.post(new c0(textView, typeface, b0Var.f1263j));
                    } else {
                        textView.setTypeface(typeface, b0Var.f1263j);
                    }
                }
            }
        }

        @Override // n0.g.e
        public void onFontRetrievalFailed(int i10) {
        }
    }
}
