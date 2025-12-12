package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.appcompat.R;
import com.unity3d.services.core.request.metrics.MetricCommonTags;

/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
public final class h1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: v, reason: collision with root package name */
    public static h1 f1355v;

    /* renamed from: w, reason: collision with root package name */
    public static h1 f1356w;

    /* renamed from: b, reason: collision with root package name */
    public final View f1357b;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f1358m;

    /* renamed from: n, reason: collision with root package name */
    public final int f1359n;

    /* renamed from: o, reason: collision with root package name */
    public final g1 f1360o;

    /* renamed from: p, reason: collision with root package name */
    public final g1 f1361p;

    /* renamed from: q, reason: collision with root package name */
    public int f1362q;

    /* renamed from: r, reason: collision with root package name */
    public int f1363r;

    /* renamed from: s, reason: collision with root package name */
    public i1 f1364s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1365t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1366u = true;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.appcompat.widget.g1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.appcompat.widget.g1] */
    public h1(View view, CharSequence charSequence) {
        final int i10 = 0;
        this.f1360o = new Runnable(this) { // from class: androidx.appcompat.widget.g1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h1 f1350m;

            {
                this.f1350m = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                int i11 = i10;
                h1 h1Var = this.f1350m;
                switch (i11) {
                    case 0:
                        h1Var.c(false);
                        break;
                    default:
                        h1Var.a();
                        break;
                }
            }
        };
        final int i11 = 1;
        this.f1361p = new Runnable(this) { // from class: androidx.appcompat.widget.g1

            /* renamed from: m, reason: collision with root package name */
            public final /* synthetic */ h1 f1350m;

            {
                this.f1350m = this;
            }

            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                int i112 = i11;
                h1 h1Var = this.f1350m;
                switch (i112) {
                    case 0:
                        h1Var.c(false);
                        break;
                    default:
                        h1Var.a();
                        break;
                }
            }
        };
        this.f1357b = view;
        this.f1358m = charSequence;
        this.f1359n = x0.m0.getScaledHoverSlop(ViewConfiguration.get(view.getContext()));
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(h1 h1Var) {
        h1 h1Var2 = f1355v;
        if (h1Var2 != null) {
            h1Var2.f1357b.removeCallbacks(h1Var2.f1360o);
        }
        f1355v = h1Var;
        if (h1Var != null) {
            h1Var.f1357b.postDelayed(h1Var.f1360o, ViewConfiguration.getLongPressTimeout());
        }
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        h1 h1Var = f1355v;
        if (h1Var != null && h1Var.f1357b == view) {
            b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new h1(view, charSequence);
            return;
        }
        h1 h1Var2 = f1356w;
        if (h1Var2 != null && h1Var2.f1357b == view) {
            h1Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public final void a() {
        h1 h1Var = f1356w;
        View view = this.f1357b;
        if (h1Var == this) {
            f1356w = null;
            i1 i1Var = this.f1364s;
            if (i1Var != null) {
                View view2 = i1Var.f1383b;
                if (view2.getParent() != null) {
                    ((WindowManager) i1Var.f1382a.getSystemService("window")).removeView(view2);
                }
                this.f1364s = null;
                this.f1366u = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1355v == this) {
            b(null);
        }
        view.removeCallbacks(this.f1361p);
    }

    public final void c(boolean z10) throws Resources.NotFoundException {
        int height;
        int i10;
        String str;
        int i11;
        String str2;
        long longPressTimeout;
        long j10;
        long j11;
        View view = this.f1357b;
        if (x0.j0.isAttachedToWindow(view)) {
            b(null);
            h1 h1Var = f1356w;
            if (h1Var != null) {
                h1Var.a();
            }
            f1356w = this;
            this.f1365t = z10;
            i1 i1Var = new i1(view.getContext());
            this.f1364s = i1Var;
            int width = this.f1362q;
            int i12 = this.f1363r;
            boolean z11 = this.f1365t;
            View view2 = i1Var.f1383b;
            boolean z12 = view2.getParent() != null;
            Context context = i1Var.f1382a;
            if (z12) {
                if (view2.getParent() != null) {
                    ((WindowManager) context.getSystemService("window")).removeView(view2);
                }
            }
            i1Var.f1384c.setText(this.f1358m);
            WindowManager.LayoutParams layoutParams = i1Var.f1385d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i12 + dimensionPixelOffset2;
                i10 = i12 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i10 = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z11 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                str2 = "window";
            } else {
                Rect rect = i1Var.f1386e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    str = "window";
                    i11 = 0;
                } else {
                    Resources resources = context.getResources();
                    str = "window";
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID);
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i11 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = i1Var.f1388g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = i1Var.f1387f;
                view.getLocationOnScreen(iArr2);
                int i13 = iArr2[i11] - iArr[i11];
                iArr2[i11] = i13;
                iArr2[1] = iArr2[1] - iArr[1];
                layoutParams.x = (i13 + width) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, i11);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i14 = iArr2[1];
                int i15 = ((i10 + i14) - dimensionPixelOffset3) - measuredHeight;
                int i16 = i14 + height + dimensionPixelOffset3;
                if (z11) {
                    if (i15 >= 0) {
                        layoutParams.y = i15;
                    } else {
                        layoutParams.y = i16;
                    }
                } else if (measuredHeight + i16 <= rect.height()) {
                    layoutParams.y = i16;
                } else {
                    layoutParams.y = i15;
                }
                str2 = str;
            }
            ((WindowManager) context.getSystemService(str2)).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.f1365t) {
                j11 = 2500;
            } else {
                if ((x0.j0.getWindowSystemUiVisibility(view) & 1) == 1) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j10 = 15000;
                }
                j11 = j10 - longPressTimeout;
            }
            g1 g1Var = this.f1361p;
            view.removeCallbacks(g1Var);
            view.postDelayed(g1Var, j11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onHover(android.view.View r5, android.view.MotionEvent r6) {
        /*
            r4 = this;
            androidx.appcompat.widget.i1 r5 = r4.f1364s
            r0 = 0
            if (r5 == 0) goto La
            boolean r5 = r4.f1365t
            if (r5 == 0) goto La
            return r0
        La:
            android.view.View r5 = r4.f1357b
            android.content.Context r1 = r5.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            return r0
        L25:
            int r1 = r6.getAction()
            r2 = 7
            r3 = 1
            if (r1 == r2) goto L38
            r5 = 10
            if (r1 == r5) goto L32
            goto L74
        L32:
            r4.f1366u = r3
            r4.a()
            goto L74
        L38:
            boolean r5 = r5.isEnabled()
            if (r5 == 0) goto L74
            androidx.appcompat.widget.i1 r5 = r4.f1364s
            if (r5 != 0) goto L74
            float r5 = r6.getX()
            int r5 = (int) r5
            float r6 = r6.getY()
            int r6 = (int) r6
            boolean r1 = r4.f1366u
            if (r1 != 0) goto L69
            int r1 = r4.f1362q
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r4.f1359n
            if (r1 > r2) goto L69
            int r1 = r4.f1363r
            int r1 = r6 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L67
            goto L69
        L67:
            r3 = 0
            goto L6f
        L69:
            r4.f1362q = r5
            r4.f1363r = r6
            r4.f1366u = r0
        L6f:
            if (r3 == 0) goto L74
            b(r4)
        L74:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.h1.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) throws Resources.NotFoundException {
        this.f1362q = view.getWidth() / 2;
        this.f1363r = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
