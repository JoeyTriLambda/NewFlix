package androidx.leanback.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.leanback.R;

/* loaded from: classes.dex */
class ResizingTextView extends TextView {

    /* renamed from: b, reason: collision with root package name */
    public final int f3103b;

    /* renamed from: m, reason: collision with root package name */
    public final int f3104m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f3105n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3106o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3107p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f3108q;

    /* renamed from: r, reason: collision with root package name */
    public int f3109r;

    /* renamed from: s, reason: collision with root package name */
    public float f3110s;

    /* renamed from: t, reason: collision with root package name */
    public int f3111t;

    /* renamed from: u, reason: collision with root package name */
    public int f3112u;

    public ResizingTextView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10);
        this.f3108q = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbResizingTextView, i10, i11);
        try {
            this.f3103b = typedArrayObtainStyledAttributes.getInt(R.styleable.lbResizingTextView_resizeTrigger, 1);
            this.f3104m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.lbResizingTextView_resizedTextSize, -1);
            this.f3105n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.lbResizingTextView_maintainLineSpacing, false);
            this.f3106o = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.lbResizingTextView_resizedPaddingAdjustmentTop, 0);
            this.f3107p = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.lbResizingTextView_resizedPaddingAdjustmentBottom, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void a(int i10, int i11) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i10, getPaddingEnd(), i11);
        } else {
            setPadding(getPaddingLeft(), i10, getPaddingRight(), i11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd A[PHI: r2
  0x00cd: PHI (r2v6 boolean) = (r2v2 boolean), (r2v8 boolean) binds: [B:40:0x00ca, B:27:0x0097] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ResizingTextView.onMeasure(int, int):void");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(d1.i.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }
}
