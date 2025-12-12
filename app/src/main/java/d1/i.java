package d1;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.Locale;
import v0.d;

/* compiled from: TextViewCompat.java */
/* loaded from: classes.dex */
public final class i {

    /* compiled from: TextViewCompat.java */
    public static class a {
        public static int a(TextView textView) {
            return textView.getBreakStrategy();
        }

        public static ColorStateList b(TextView textView) {
            return textView.getCompoundDrawableTintList();
        }

        public static PorterDuff.Mode c(TextView textView) {
            return textView.getCompoundDrawableTintMode();
        }

        public static int d(TextView textView) {
            return textView.getHyphenationFrequency();
        }

        public static void e(TextView textView, int i10) {
            textView.setBreakStrategy(i10);
        }

        public static void f(TextView textView, ColorStateList colorStateList) {
            textView.setCompoundDrawableTintList(colorStateList);
        }

        public static void g(TextView textView, PorterDuff.Mode mode) {
            textView.setCompoundDrawableTintMode(mode);
        }

        public static void h(TextView textView, int i10) {
            textView.setHyphenationFrequency(i10);
        }
    }

    /* compiled from: TextViewCompat.java */
    public static class b {
        public static DecimalFormatSymbols a(Locale locale) {
            return DecimalFormatSymbols.getInstance(locale);
        }
    }

    /* compiled from: TextViewCompat.java */
    public static class d implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f10783a;

        /* renamed from: b, reason: collision with root package name */
        public final TextView f10784b;

        /* renamed from: c, reason: collision with root package name */
        public Class<?> f10785c;

        /* renamed from: d, reason: collision with root package name */
        public Method f10786d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f10787e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f10788f = false;

        public d(TextView textView, ActionMode.Callback callback) {
            this.f10783a = callback;
            this.f10784b = textView;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            return this.f10783a.onActionItemClicked(actionMode, menuItem);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            return this.f10783a.onCreateActionMode(actionMode, menu);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode actionMode) {
            this.f10783a.onDestroyActionMode(actionMode);
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
        @Override // android.view.ActionMode.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onPrepareActionMode(android.view.ActionMode r14, android.view.Menu r15) throws java.lang.IllegalAccessException, java.lang.ClassNotFoundException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
            /*
                Method dump skipped, instructions count: 302
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: d1.i.d.onPrepareActionMode(android.view.ActionMode, android.view.Menu):boolean");
        }
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(TextView textView) {
        return textView.getPaddingTop() - textView.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView textView) {
        return textView.getPaddingBottom() + textView.getPaint().getFontMetricsInt().bottom;
    }

    public static int getMaxLines(TextView textView) {
        return textView.getMaxLines();
    }

    public static d.a getTextMetricsParams(TextView textView) {
        TextDirectionHeuristic textDirectionHeuristic;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return new d.a(c.c(textView));
        }
        d.a.C0292a c0292a = new d.a.C0292a(new TextPaint(textView.getPaint()));
        if (i10 >= 23) {
            c0292a.setBreakStrategy(a.a(textView));
            c0292a.setHyphenationFrequency(a.d(textView));
        }
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else {
            if (i10 < 28 || (textView.getInputType() & 15) != 3) {
                boolean z10 = textView.getLayoutDirection() == 1;
                switch (textView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (!z10) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        }
                }
            } else {
                byte directionality = Character.getDirectionality(c.b(b.a(textView.getTextLocale()))[0].codePointAt(0));
                textDirectionHeuristic = (directionality == 1 || directionality == 2) ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            }
        }
        c0292a.setTextDirection(textDirectionHeuristic);
        return c0292a.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(TextView textView, ColorStateList colorStateList) {
        w0.h.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.f(textView, colorStateList);
        } else if (textView instanceof l) {
            ((l) textView).setSupportCompoundDrawablesTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(TextView textView, PorterDuff.Mode mode) {
        w0.h.checkNotNull(textView);
        if (Build.VERSION.SDK_INT >= 24) {
            a.g(textView, mode);
        } else if (textView instanceof l) {
            ((l) textView).setSupportCompoundDrawablesTintMode(mode);
        }
    }

    public static void setCompoundDrawablesRelative(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void setFirstBaselineToTopHeight(TextView textView, int i10) {
        w0.h.checkArgumentNonnegative(i10);
        if (Build.VERSION.SDK_INT >= 28) {
            c.d(textView, i10);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = textView.getIncludeFontPadding() ? fontMetricsInt.top : fontMetricsInt.ascent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), i10 + i11, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static void setLastBaselineToBottomHeight(TextView textView, int i10) {
        w0.h.checkArgumentNonnegative(i10);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i11 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
        if (i10 > Math.abs(i11)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i10 - i11);
        }
    }

    public static void setLineHeight(TextView textView, int i10) {
        w0.h.checkArgumentNonnegative(i10);
        if (i10 != textView.getPaint().getFontMetricsInt(null)) {
            textView.setLineSpacing(i10 - r0, 1.0f);
        }
    }

    public static void setPrecomputedText(TextView textView, v0.d dVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            textView.setText(c.a(dVar.getPrecomputedText()));
        } else {
            if (!getTextMetricsParams(textView).equalsWithoutTextDirection(dVar.getParams())) {
                throw new IllegalArgumentException("Given text can not be applied to TextView.");
            }
            textView.setText(dVar);
        }
    }

    public static void setTextAppearance(TextView textView, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i10);
        } else {
            textView.setTextAppearance(textView.getContext(), i10);
        }
    }

    public static void setTextMetricsParams(TextView textView, d.a aVar) {
        TextDirectionHeuristic textDirection = aVar.getTextDirection();
        int i10 = 1;
        if (textDirection != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirection != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirection == TextDirectionHeuristics.ANYRTL_LTR) {
                i10 = 2;
            } else if (textDirection == TextDirectionHeuristics.LTR) {
                i10 = 3;
            } else if (textDirection == TextDirectionHeuristics.RTL) {
                i10 = 4;
            } else if (textDirection == TextDirectionHeuristics.LOCALE) {
                i10 = 5;
            } else if (textDirection == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i10 = 6;
            } else if (textDirection == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i10 = 7;
            }
        }
        textView.setTextDirection(i10);
        if (Build.VERSION.SDK_INT >= 23) {
            textView.getPaint().set(aVar.getTextPaint());
            a.e(textView, aVar.getBreakStrategy());
            a.h(textView, aVar.getHyphenationFrequency());
        } else {
            float textScaleX = aVar.getTextPaint().getTextScaleX();
            textView.getPaint().set(aVar.getTextPaint());
            if (textScaleX == textView.getTextScaleX()) {
                textView.setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            textView.setTextScaleX(textScaleX);
        }
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        return (!(callback instanceof d) || Build.VERSION.SDK_INT < 26) ? callback : ((d) callback).f10783a;
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView textView, ActionMode.Callback callback) {
        int i10 = Build.VERSION.SDK_INT;
        return (i10 < 26 || i10 > 27 || (callback instanceof d) || callback == null) ? callback : new d(textView, callback);
    }

    /* compiled from: TextViewCompat.java */
    public static class c {
        public static String[] b(DecimalFormatSymbols decimalFormatSymbols) {
            return decimalFormatSymbols.getDigitStrings();
        }

        public static PrecomputedText.Params c(TextView textView) {
            return textView.getTextMetricsParams();
        }

        public static void d(TextView textView, int i10) {
            textView.setFirstBaselineToTopHeight(i10);
        }

        public static CharSequence a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }
}
