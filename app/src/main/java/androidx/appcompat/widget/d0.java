package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: l, reason: collision with root package name */
    public static final RectF f1297l = new RectF();

    /* renamed from: m, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public static final ConcurrentHashMap<String, Method> f1298m = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public int f1299a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1300b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f1301c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f1302d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f1303e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1304f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f1305g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f1306h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f1307i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f1308j;

    /* renamed from: k, reason: collision with root package name */
    public final f f1309k;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static final class a {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, TextView textView, TextPaint textPaint) {
            return new StaticLayout(charSequence, textPaint, i10, alignment, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding());
        }

        public static int b(TextView textView) {
            return textView.getMaxLines();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static final class b {
        public static boolean a(View view) {
            return view.isInLayout();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static final class c {
        public static StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11, TextView textView, TextPaint textPaint, f fVar) {
            StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), textPaint, i10);
            StaticLayout.Builder hyphenationFrequency = builderObtain.setAlignment(alignment).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).setIncludePad(textView.getIncludeFontPadding()).setBreakStrategy(textView.getBreakStrategy()).setHyphenationFrequency(textView.getHyphenationFrequency());
            if (i11 == -1) {
                i11 = Integer.MAX_VALUE;
            }
            hyphenationFrequency.setMaxLines(i11);
            try {
                fVar.a(builderObtain, textView);
            } catch (ClassCastException unused) {
                Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
            }
            return builderObtain.build();
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class d extends f {
        @Override // androidx.appcompat.widget.d0.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) d0.e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class e extends d {
        @Override // androidx.appcompat.widget.d0.d, androidx.appcompat.widget.d0.f
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // androidx.appcompat.widget.d0.f
        public boolean b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    static {
        new ConcurrentHashMap();
    }

    public d0(TextView textView) {
        this.f1307i = textView;
        this.f1308j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            this.f1309k = new e();
        } else if (i10 >= 23) {
            this.f1309k = new d();
        } else {
            this.f1309k = new f();
        }
    }

    public static int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public static Method d(String str) throws SecurityException {
        try {
            ConcurrentHashMap<String, Method> concurrentHashMap = f1298m;
            Method declaredMethod = concurrentHashMap.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                concurrentHashMap.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    public static <T> T e(Object obj, String str, T t10) {
        try {
            return (T) d(str).invoke(obj, new Object[0]);
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e10);
            return t10;
        }
    }

    public final void a() {
        if (i() && this.f1299a != 0) {
            if (this.f1300b) {
                if (this.f1307i.getMeasuredHeight() <= 0 || this.f1307i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f1309k.b(this.f1307i) ? 1048576 : (this.f1307i.getMeasuredWidth() - this.f1307i.getTotalPaddingLeft()) - this.f1307i.getTotalPaddingRight();
                int height = (this.f1307i.getHeight() - this.f1307i.getCompoundPaddingBottom()) - this.f1307i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1297l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float fC = c(rectF);
                    if (fC != this.f1307i.getTextSize()) {
                        f(fC, 0);
                    }
                }
            }
            this.f1300b = true;
        }
    }

    public final int c(RectF rectF) {
        int i10;
        StaticLayout staticLayoutA;
        CharSequence transformation;
        int length = this.f1304f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i11 = length - 1;
        int i12 = 1;
        int i13 = 0;
        while (i12 <= i11) {
            int i14 = (i12 + i11) / 2;
            int i15 = this.f1304f[i14];
            TextView textView = this.f1307i;
            CharSequence text = textView.getText();
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, textView)) != null) {
                text = transformation;
            }
            int i16 = Build.VERSION.SDK_INT;
            int iB = a.b(textView);
            TextPaint textPaint = this.f1306h;
            if (textPaint == null) {
                this.f1306h = new TextPaint();
            } else {
                textPaint.reset();
            }
            this.f1306h.set(textView.getPaint());
            this.f1306h.setTextSize(i15);
            Layout.Alignment alignment = (Layout.Alignment) e(textView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
            int iRound = Math.round(rectF.right);
            if (i16 >= 23) {
                i10 = iB;
                staticLayoutA = c.a(text, alignment, iRound, iB, this.f1307i, this.f1306h, this.f1309k);
            } else {
                i10 = iB;
                staticLayoutA = a.a(text, alignment, iRound, textView, this.f1306h);
            }
            if ((i10 == -1 || (staticLayoutA.getLineCount() <= i10 && staticLayoutA.getLineEnd(staticLayoutA.getLineCount() - 1) == text.length())) && ((float) staticLayoutA.getHeight()) <= rectF.bottom) {
                int i17 = i14 + 1;
                i13 = i12;
                i12 = i17;
            } else {
                i13 = i14 - 1;
                i11 = i13;
            }
        }
        return this.f1304f[i13];
    }

    public final void f(float f10, int i10) {
        Context context = this.f1308j;
        float fApplyDimension = TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics());
        TextView textView = this.f1307i;
        if (fApplyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(fApplyDimension);
            boolean zA = b.a(textView);
            if (textView.getLayout() != null) {
                this.f1300b = false;
                try {
                    Method methodD = d("nullLayouts");
                    if (methodD != null) {
                        methodD.invoke(textView, new Object[0]);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (zA) {
                    textView.forceLayout();
                } else {
                    textView.requestLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (i() && this.f1299a == 1) {
            if (!this.f1305g || this.f1304f.length == 0) {
                int iFloor = ((int) Math.floor((this.f1303e - this.f1302d) / this.f1301c)) + 1;
                int[] iArr = new int[iFloor];
                for (int i10 = 0; i10 < iFloor; i10++) {
                    iArr[i10] = Math.round((i10 * this.f1301c) + this.f1302d);
                }
                this.f1304f = b(iArr);
            }
            this.f1300b = true;
        } else {
            this.f1300b = false;
        }
        return this.f1300b;
    }

    public final boolean h() {
        boolean z10 = this.f1304f.length > 0;
        this.f1305g = z10;
        if (z10) {
            this.f1299a = 1;
            this.f1302d = r0[0];
            this.f1303e = r0[r1 - 1];
            this.f1301c = -1.0f;
        }
        return z10;
    }

    public final boolean i() {
        return !(this.f1307i instanceof l);
    }

    public final void j(float f10, float f11, float f12) throws IllegalArgumentException {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f1299a = 1;
        this.f1302d = f10;
        this.f1303e = f11;
        this.f1301c = f12;
        this.f1305g = false;
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    public static class f {
        public boolean b(TextView textView) {
            return ((Boolean) d0.e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }

        public void a(StaticLayout.Builder builder, TextView textView) {
        }
    }
}
