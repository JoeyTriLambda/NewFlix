package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import x0.j0;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements s7.f {

    /* renamed from: b, reason: collision with root package name */
    public TextView f9323b;

    /* renamed from: m, reason: collision with root package name */
    public Button f9324m;

    /* renamed from: n, reason: collision with root package name */
    public final TimeInterpolator f9325n;

    /* renamed from: o, reason: collision with root package name */
    public int f9326o;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9325n = k7.g.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, p6.a.f17605b);
    }

    public final boolean a(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f9323b.getPaddingTop() == i11 && this.f9323b.getPaddingBottom() == i12) {
            return z10;
        }
        TextView textView = this.f9323b;
        if (j0.isPaddingRelative(textView)) {
            j0.setPaddingRelative(textView, j0.getPaddingStart(textView), i11, j0.getPaddingEnd(textView), i12);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i11, textView.getPaddingRight(), i12);
        return true;
    }

    @Override // s7.f
    public void animateContentIn(int i10, int i11) {
        this.f9323b.setAlpha(0.0f);
        long j10 = i11;
        ViewPropertyAnimator duration = this.f9323b.animate().alpha(1.0f).setDuration(j10);
        TimeInterpolator timeInterpolator = this.f9325n;
        long j11 = i10;
        duration.setInterpolator(timeInterpolator).setStartDelay(j11).start();
        if (this.f9324m.getVisibility() == 0) {
            this.f9324m.setAlpha(0.0f);
            this.f9324m.animate().alpha(1.0f).setDuration(j10).setInterpolator(timeInterpolator).setStartDelay(j11).start();
        }
    }

    @Override // s7.f
    public void animateContentOut(int i10, int i11) {
        this.f9323b.setAlpha(1.0f);
        long j10 = i11;
        ViewPropertyAnimator duration = this.f9323b.animate().alpha(0.0f).setDuration(j10);
        TimeInterpolator timeInterpolator = this.f9325n;
        long j11 = i10;
        duration.setInterpolator(timeInterpolator).setStartDelay(j11).start();
        if (this.f9324m.getVisibility() == 0) {
            this.f9324m.setAlpha(1.0f);
            this.f9324m.animate().alpha(0.0f).setDuration(j10).setInterpolator(timeInterpolator).setStartDelay(j11).start();
        }
    }

    public Button getActionView() {
        return this.f9324m;
    }

    public TextView getMessageView() {
        return this.f9323b;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f9323b = (TextView) findViewById(R.id.snackbar_text);
        this.f9324m = (Button) findViewById(R.id.snackbar_action);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r8, int r9) throws android.content.res.Resources.NotFoundException {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.getOrientation()
            r1 = 1
            if (r0 != r1) goto Lb
            return
        Lb:
            android.content.res.Resources r0 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r2)
            android.content.res.Resources r2 = r7.getResources()
            int r3 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r2 = r2.getDimensionPixelSize(r3)
            android.widget.TextView r3 = r7.f9323b
            android.text.Layout r3 = r3.getLayout()
            r4 = 0
            if (r3 == 0) goto L30
            int r3 = r3.getLineCount()
            if (r3 <= r1) goto L30
            r3 = 1
            goto L31
        L30:
            r3 = 0
        L31:
            if (r3 == 0) goto L4a
            int r5 = r7.f9326o
            if (r5 <= 0) goto L4a
            android.widget.Button r5 = r7.f9324m
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f9326o
            if (r5 <= r6) goto L4a
            int r2 = r0 - r2
            boolean r0 = r7.a(r1, r0, r2)
            if (r0 == 0) goto L55
            goto L56
        L4a:
            if (r3 == 0) goto L4d
            goto L4e
        L4d:
            r0 = r2
        L4e:
            boolean r0 = r7.a(r4, r0, r0)
            if (r0 == 0) goto L55
            goto L56
        L55:
            r1 = 0
        L56:
            if (r1 == 0) goto L5b
            super.onMeasure(r8, r9)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f9326o = i10;
    }
}
