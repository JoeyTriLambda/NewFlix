package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public TypedValue f1125b;

    /* renamed from: m, reason: collision with root package name */
    public TypedValue f1126m;

    /* renamed from: n, reason: collision with root package name */
    public TypedValue f1127n;

    /* renamed from: o, reason: collision with root package name */
    public TypedValue f1128o;

    /* renamed from: p, reason: collision with root package name */
    public TypedValue f1129p;

    /* renamed from: q, reason: collision with root package name */
    public TypedValue f1130q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f1131r;

    /* renamed from: s, reason: collision with root package name */
    public a f1132s;

    public interface a {
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1129p == null) {
            this.f1129p = new TypedValue();
        }
        return this.f1129p;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1130q == null) {
            this.f1130q = new TypedValue();
        }
        return this.f1130q;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1127n == null) {
            this.f1127n = new TypedValue();
        }
        return this.f1127n;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1128o == null) {
            this.f1128o = new TypedValue();
        }
        return this.f1128o;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1125b == null) {
            this.f1125b = new TypedValue();
        }
        return this.f1125b;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1126m == null) {
            this.f1126m = new TypedValue();
        }
        return this.f1126m;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a aVar = this.f1132s;
        if (aVar != null) {
            ((r.p) aVar).onAttachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a aVar = this.f1132s;
        if (aVar != null) {
            ((r.p) aVar).onDetachedFromWindow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00de  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r17, int r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(a aVar) {
        this.f1132s = aVar;
    }

    public void setDecorPadding(int i10, int i11, int i12, int i13) {
        this.f1131r.set(i10, i11, i12, i13);
        if (x0.j0.isLaidOut(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1131r = new Rect();
    }
}
