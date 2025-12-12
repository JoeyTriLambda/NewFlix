package io.github.giangpham96.expandable_textview;

import ac.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import fg.h;
import java.util.Iterator;
import kotlin.text.StringsKt__StringsKt;
import mf.t;
import p1.b;
import v0.f;
import zf.i;

/* compiled from: ExpandableTextView.kt */
/* loaded from: classes2.dex */
public final class ExpandableTextView extends AppCompatTextView {
    public static final /* synthetic */ int C = 0;
    public StaticLayout A;
    public CharSequence B;

    /* renamed from: s, reason: collision with root package name */
    public String f13455s;

    /* renamed from: t, reason: collision with root package name */
    public String f13456t;

    /* renamed from: u, reason: collision with root package name */
    public int f13457u;

    /* renamed from: v, reason: collision with root package name */
    public int f13458v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f13459w;

    /* renamed from: x, reason: collision with root package name */
    public int f13460x;

    /* renamed from: y, reason: collision with root package name */
    public ValueAnimator f13461y;

    /* renamed from: z, reason: collision with root package name */
    public SpannableString f13462z;

    /* compiled from: ExpandableTextView.kt */
    public static final class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i.checkNotNullParameter(animator, "animation");
            super.onAnimationEnd(animator);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.setText(expandableTextView.getCollapsed() ? expandableTextView.B : expandableTextView.getOriginalText());
            ViewGroup.LayoutParams layoutParams = expandableTextView.getLayoutParams();
            expandableTextView.getLayoutParams().height = -2;
            expandableTextView.setLayoutParams(layoutParams);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i.checkNotNullParameter(animator, "animation");
            super.onAnimationStart(animator);
            ExpandableTextView expandableTextView = ExpandableTextView.this;
            expandableTextView.f13459w = !expandableTextView.getCollapsed();
            expandableTextView.setText(expandableTextView.getOriginalText());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void o(ExpandableTextView expandableTextView, boolean z10) {
        expandableTextView.n((expandableTextView.getMeasuredWidth() - expandableTextView.getCompoundPaddingStart()) - expandableTextView.getCompoundPaddingEnd(), z10);
    }

    public final boolean getCollapsed() {
        return this.f13459w;
    }

    public final String getExpandAction() {
        return this.f13456t;
    }

    public final int getExpandActionColor() {
        return this.f13458v;
    }

    public final boolean getExpanded() {
        return !this.f13459w;
    }

    public final int getLimitedMaxLines() {
        return this.f13457u;
    }

    public final String getOriginalText() {
        return this.f13455s;
    }

    public final StaticLayout m(int i10, int i11, CharSequence charSequence) {
        int iCoerceAtLeast = h.coerceAtLeast(i11, 0);
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        if (Build.VERSION.SDK_INT >= 23) {
            StaticLayout staticLayoutBuild = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), getPaint(), iCoerceAtLeast).setIncludePad(false).setMaxLines(i10).setAlignment(alignment).setEllipsize(TextUtils.TruncateAt.END).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).build();
            i.checkNotNullExpressionValue(staticLayoutBuild, "{\n            StaticLayo…       .build()\n        }");
            return staticLayoutBuild;
        }
        StaticLayout staticLayoutCreate = g4.a.create(charSequence, 0, charSequence.length(), getPaint(), iCoerceAtLeast, alignment, getLineSpacingMultiplier(), getLineSpacingExtra(), false, TextUtils.TruncateAt.END, iCoerceAtLeast, i10, f.f20417c);
        i.checkNotNullExpressionValue(staticLayoutCreate, "{\n            StaticLayo…IRSTSTRONG_LTR)\n        }");
        return staticLayoutCreate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r14v7, types: [android.text.SpannableStringBuilder, java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9, types: [java.lang.CharSequence] */
    public final void n(int i10, boolean z10) {
        if (i10 <= 0) {
            return;
        }
        StaticLayout staticLayoutM = m(this.f13457u, i10, this.f13455s);
        if (z10) {
            this.A = m(1, i10, this.f13462z);
        }
        ?? text = staticLayoutM.getText();
        if (i.areEqual(text.toString(), this.f13455s)) {
            text = this.f13455s;
        } else {
            Iterator<Integer> it = h.until(0, staticLayoutM.getLineCount()).iterator();
            int lineWidth = 0;
            while (it.hasNext()) {
                lineWidth += (int) staticLayoutM.getLineWidth(((t) it).nextInt());
            }
            float f10 = lineWidth;
            StaticLayout staticLayout = this.A;
            i.checkNotNull(staticLayout);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f13455s, getPaint(), f10 - staticLayout.getLineWidth(0), TextUtils.TruncateAt.END);
            i.checkNotNullExpressionValue(charSequenceEllipsize, "textWithoutCta");
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default(charSequenceEllipsize, (char) 8230, 0, false, 6, (Object) null);
            if (i.areEqual(charSequenceEllipsize, "")) {
                StaticLayout staticLayout2 = this.A;
                i.checkNotNull(staticLayout2);
                text = staticLayout2.getText();
            } else if (iIndexOf$default != -1) {
                SpannableStringBuilder spannableStringBuilderAppend = new SpannableStringBuilder().append(charSequenceEllipsize);
                StaticLayout staticLayout3 = this.A;
                i.checkNotNull(staticLayout3);
                text = spannableStringBuilderAppend.replace(iIndexOf$default, iIndexOf$default + 1, staticLayout3.getText());
                i.checkNotNullExpressionValue(text, "span");
                int width = staticLayoutM.getWidth();
                DynamicLayout dynamicLayoutBuild = Build.VERSION.SDK_INT >= 28 ? DynamicLayout.Builder.obtain(text, getPaint(), width).setAlignment(Layout.Alignment.ALIGN_NORMAL).setIncludePad(false).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).build() : new DynamicLayout(text, text, getPaint(), width, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
                i.checkNotNullExpressionValue(dynamicLayoutBuild, "if (Build.VERSION.SDK_IN…ngExtra, false)\n        }");
                StaticLayout staticLayout4 = this.A;
                i.checkNotNull(staticLayout4);
                for (int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) text, staticLayout4.getText().toString(), 0, false, 6, (Object) null) - 1; iIndexOf$default2 >= 0 && dynamicLayoutBuild.getLineCount() > this.f13457u; iIndexOf$default2--) {
                    text.delete(iIndexOf$default2, iIndexOf$default2 + 1);
                }
            }
        }
        this.B = text;
        String str = text;
        if (!this.f13459w) {
            str = this.f13455s;
        }
        setText(str);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f13461y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = (View.MeasureSpec.getSize(i10) - getCompoundPaddingStart()) - getCompoundPaddingEnd();
        if (size != this.f13460x) {
            ValueAnimator valueAnimator = this.f13461y;
            if (!(valueAnimator != null && valueAnimator.isRunning())) {
                this.f13460x = size;
                n(size, true);
                super.onMeasure(i10, i11);
                return;
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        super.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void setExpandAction(String str) {
        i.checkNotNullParameter(str, "value");
        this.f13456t = str;
        int length = String.valueOf((char) 8230).length();
        SpannableString spannableString = new SpannableString(c.j("… ", str));
        this.f13462z = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(this.f13458v), length, this.f13462z.length(), 33);
        o(this, true);
    }

    public final void setExpandActionColor(int i10) {
        this.f13458v = i10;
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i10);
        int length = String.valueOf((char) 8230).length();
        SpannableString spannableString = this.f13462z;
        spannableString.setSpan(foregroundColorSpan, length, spannableString.length(), 33);
        o(this, true);
    }

    public final void setLimitedMaxLines(int i10) {
        if (getMaxLines() == -1 || i10 <= getMaxLines()) {
            this.f13457u = i10;
            o(this, false);
            return;
        }
        throw new IllegalStateException(kotlin.text.a.trimIndent("\n                    maxLines (" + getMaxLines() + ") must be greater than or equal to limitedMaxLines (" + i10 + "). \n                    maxLines can be -1 if there is no upper limit for lineCount.\n                ").toString());
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 == -1 || this.f13457u <= i10) {
            super.setMaxLines(i10);
            o(this, false);
            return;
        }
        throw new IllegalStateException(kotlin.text.a.trimIndent("\n                maxLines (" + i10 + ") must be greater than or equal to limitedMaxLines (" + this.f13457u + "). \n                maxLines can be -1 if there is no upper limit for lineCount.\n            ").toString());
    }

    public final void setOriginalText(String str) {
        i.checkNotNullParameter(str, "value");
        this.f13455s = str;
        o(this, false);
    }

    public final void toggle() {
        if (i.areEqual(this.f13455s, this.B)) {
            this.f13459w = !this.f13459w;
            return;
        }
        int height = getHeight();
        setText(this.f13459w ? this.f13455s : this.B);
        measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 0));
        int measuredHeight = getMeasuredHeight();
        ValueAnimator valueAnimator = this.f13461y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        long jCoerceAtMost = h.coerceAtMost(Math.abs(measuredHeight - height) * 2, 300L);
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(height, measuredHeight);
        valueAnimatorOfInt.setInterpolator(new b());
        valueAnimatorOfInt.setDuration(jCoerceAtMost);
        valueAnimatorOfInt.addUpdateListener(new l7.a(this, 22));
        valueAnimatorOfInt.addListener(new a());
        valueAnimatorOfInt.start();
        this.f13461y = valueAnimatorOfInt;
    }

    public /* synthetic */ ExpandableTextView(Context context, AttributeSet attributeSet, int i10, int i11, zf.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.checkNotNullParameter(context, "context");
        this.f13455s = "";
        this.f13456t = "";
        this.f13457u = 3;
        this.f13458v = m0.a.getColor(context, android.R.color.holo_purple);
        boolean z10 = true;
        this.f13459w = true;
        this.f13462z = new SpannableString("");
        setEllipsize(TextUtils.TruncateAt.END);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExpandableTextView);
        i.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.ExpandableTextView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.ExpandableTextView_expandAction);
        setExpandAction(string == null ? this.f13456t : string);
        setExpandActionColor(typedArrayObtainStyledAttributes.getColor(R.styleable.ExpandableTextView_expandActionColor, this.f13458v));
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.ExpandableTextView_originalText);
        setOriginalText(string2 == null ? this.f13455s : string2);
        setLimitedMaxLines(typedArrayObtainStyledAttributes.getInt(R.styleable.ExpandableTextView_limitedMaxLines, this.f13457u));
        if (getMaxLines() != -1 && this.f13457u > getMaxLines()) {
            z10 = false;
        }
        if (z10) {
            typedArrayObtainStyledAttributes.recycle();
            setOnClickListener(new androidx.mediarouter.app.b(this, 15));
            return;
        }
        throw new IllegalStateException(kotlin.text.a.trimIndent("\n                maxLines (" + getMaxLines() + ") must be greater than or equal to limitedMaxLines (" + this.f13457u + "). \n                maxLines can be -1 if there is no upper limit for lineCount.\n            ").toString());
    }
}
