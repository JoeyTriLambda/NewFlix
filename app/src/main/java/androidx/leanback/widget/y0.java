package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.leanback.R;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: StreamingTextView.java */
/* loaded from: classes.dex */
public class y0 extends EditText {

    /* renamed from: q, reason: collision with root package name */
    public static final Pattern f3414q = Pattern.compile("\\S+");

    /* renamed from: r, reason: collision with root package name */
    public static final a f3415r = new a();

    /* renamed from: b, reason: collision with root package name */
    public final Random f3416b;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f3417m;

    /* renamed from: n, reason: collision with root package name */
    public Bitmap f3418n;

    /* renamed from: o, reason: collision with root package name */
    public int f3419o;

    /* renamed from: p, reason: collision with root package name */
    public ObjectAnimator f3420p;

    /* compiled from: StreamingTextView.java */
    public static class a extends Property<y0, Integer> {
        public a() {
            super(Integer.class, "streamPosition");
        }

        @Override // android.util.Property
        public Integer get(y0 y0Var) {
            return Integer.valueOf(y0Var.getStreamPosition());
        }

        @Override // android.util.Property
        public void set(y0 y0Var, Integer num) {
            y0Var.setStreamPosition(num.intValue());
        }
    }

    /* compiled from: StreamingTextView.java */
    public class b extends ReplacementSpan {

        /* renamed from: b, reason: collision with root package name */
        public final int f3421b;

        /* renamed from: m, reason: collision with root package name */
        public final int f3422m;

        public b(int i10, int i11) {
            this.f3421b = i10;
            this.f3422m = i11;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
            int iMeasureText = (int) paint.measureText(charSequence, i10, i11);
            y0 y0Var = y0.this;
            int width = y0Var.f3417m.getWidth();
            int i15 = width * 2;
            int i16 = iMeasureText / i15;
            int i17 = (iMeasureText % i15) / 2;
            boolean zIsLayoutRtl = y0.isLayoutRtl(y0Var);
            y0Var.f3416b.setSeed(this.f3421b);
            int alpha = paint.getAlpha();
            for (int i18 = 0; i18 < i16 && this.f3422m + i18 < y0Var.f3419o; i18++) {
                float f11 = (width / 2) + (i18 * i15) + i17;
                float f12 = zIsLayoutRtl ? ((f10 + iMeasureText) - f11) - width : f10 + f11;
                paint.setAlpha((y0Var.f3416b.nextInt(4) + 1) * 63);
                if (y0Var.f3416b.nextBoolean()) {
                    canvas.drawBitmap(y0Var.f3418n, f12, i13 - r12.getHeight(), paint);
                } else {
                    canvas.drawBitmap(y0Var.f3417m, f12, i13 - r12.getHeight(), paint);
                }
            }
            paint.setAlpha(alpha);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence, i10, i11);
        }
    }

    public y0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3416b = new Random();
    }

    public static boolean isLayoutRtl(View view) {
        return 1 == view.getLayoutDirection();
    }

    public final Bitmap a(int i10) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), i10), (int) (r4.getWidth() * 1.3f), (int) (r4.getHeight() * 1.3f), false);
    }

    public int getStreamPosition() {
        return this.f3419o;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f3417m = a(R.drawable.lb_text_dot_one);
        this.f3418n = a(R.drawable.lb_text_dot_two);
        reset();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(y0.class.getCanonicalName());
    }

    public void reset() {
        this.f3419o = -1;
        ObjectAnimator objectAnimator = this.f3420p;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        setText("");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    public void setStreamPosition(int i10) {
        this.f3419o = i10;
        invalidate();
    }

    public void updateRecognizedText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            Matcher matcher = f3414q.matcher(str2);
            while (matcher.find()) {
                int iStart = matcher.start() + length;
                spannableStringBuilder.setSpan(new b(str2.charAt(matcher.start()), iStart), iStart, matcher.end() + length, 33);
            }
        }
        this.f3419o = Math.max(str.length(), this.f3419o);
        setText(new SpannedString(spannableStringBuilder));
        bringPointIntoView(length());
        ObjectAnimator objectAnimator = this.f3420p;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        int streamPosition = getStreamPosition();
        int length2 = length();
        int i10 = length2 - streamPosition;
        if (i10 > 0) {
            if (this.f3420p == null) {
                ObjectAnimator objectAnimator2 = new ObjectAnimator();
                this.f3420p = objectAnimator2;
                objectAnimator2.setTarget(this);
                this.f3420p.setProperty(f3415r);
            }
            this.f3420p.setIntValues(streamPosition, length2);
            this.f3420p.setDuration(i10 * 50);
            this.f3420p.start();
        }
    }

    public y0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3416b = new Random();
    }
}
