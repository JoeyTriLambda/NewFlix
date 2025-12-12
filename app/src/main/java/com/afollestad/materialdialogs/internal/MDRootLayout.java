package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.R;

/* loaded from: classes.dex */
public class MDRootLayout extends ViewGroup {
    public static final /* synthetic */ int E = 0;
    public Paint A;
    public a B;
    public a C;
    public int D;

    /* renamed from: b, reason: collision with root package name */
    public View f5346b;

    /* renamed from: m, reason: collision with root package name */
    public View f5347m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5348n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5349o;

    /* renamed from: p, reason: collision with root package name */
    public final MDButton[] f5350p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5351q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5352r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5353s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5354t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5355u;

    /* renamed from: v, reason: collision with root package name */
    public int f5356v;

    /* renamed from: w, reason: collision with root package name */
    public int f5357w;

    /* renamed from: x, reason: collision with root package name */
    public int f5358x;

    /* renamed from: y, reason: collision with root package name */
    public GravityEnum f5359y;

    /* renamed from: z, reason: collision with root package name */
    public int f5360z;

    public class a implements ViewTreeObserver.OnScrollChangedListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f5361a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f5362b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f5363c;

        public a(ViewGroup viewGroup, boolean z10, boolean z11) {
            this.f5361a = viewGroup;
            this.f5362b = z10;
            this.f5363c = z11;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onScrollChanged() {
            /*
                r9 = this;
                com.afollestad.materialdialogs.internal.MDRootLayout r0 = com.afollestad.materialdialogs.internal.MDRootLayout.this
                com.afollestad.materialdialogs.internal.MDButton[] r1 = r0.f5350p
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L7:
                r5 = 8
                r6 = 1
                if (r4 >= r2) goto L1b
                r7 = r1[r4]
                if (r7 == 0) goto L18
                int r7 = r7.getVisibility()
                if (r7 == r5) goto L18
                r1 = 1
                goto L1c
            L18:
                int r4 = r4 + 1
                goto L7
            L1b:
                r1 = 0
            L1c:
                android.view.ViewGroup r2 = r9.f5361a
                boolean r4 = r2 instanceof android.webkit.WebView
                boolean r7 = r9.f5363c
                boolean r8 = r9.f5362b
                if (r4 == 0) goto L6d
                android.webkit.WebView r2 = (android.webkit.WebView) r2
                r0.getClass()
                if (r8 == 0) goto L47
                android.view.View r4 = r0.f5346b
                if (r4 == 0) goto L44
                int r4 = r4.getVisibility()
                if (r4 == r5) goto L44
                int r4 = r2.getScrollY()
                int r5 = r2.getPaddingTop()
                int r5 = r5 + r4
                if (r5 <= 0) goto L44
                r4 = 1
                goto L45
            L44:
                r4 = 0
            L45:
                r0.f5348n = r4
            L47:
                if (r7 == 0) goto Lc4
                if (r1 == 0) goto L6a
                int r1 = r2.getScrollY()
                int r4 = r2.getMeasuredHeight()
                int r4 = r4 + r1
                int r1 = r2.getPaddingBottom()
                int r4 = r4 - r1
                float r1 = (float) r4
                int r4 = r2.getContentHeight()
                float r4 = (float) r4
                float r2 = r2.getScale()
                float r2 = r2 * r4
                int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
                if (r1 >= 0) goto L6a
                r3 = 1
            L6a:
                r0.f5349o = r3
                goto Lc4
            L6d:
                r0.getClass()
                if (r8 == 0) goto L9a
                int r4 = r2.getChildCount()
                if (r4 <= 0) goto L9a
                android.view.View r4 = r0.f5346b
                if (r4 == 0) goto L97
                int r4 = r4.getVisibility()
                if (r4 == r5) goto L97
                int r4 = r2.getScrollY()
                int r5 = r2.getPaddingTop()
                int r5 = r5 + r4
                android.view.View r4 = r2.getChildAt(r3)
                int r4 = r4.getTop()
                if (r5 <= r4) goto L97
                r4 = 1
                goto L98
            L97:
                r4 = 0
            L98:
                r0.f5348n = r4
            L9a:
                if (r7 == 0) goto Lc4
                int r4 = r2.getChildCount()
                if (r4 <= 0) goto Lc4
                if (r1 == 0) goto Lc2
                int r1 = r2.getScrollY()
                int r4 = r2.getHeight()
                int r4 = r4 + r1
                int r1 = r2.getPaddingBottom()
                int r4 = r4 - r1
                int r1 = r2.getChildCount()
                int r1 = r1 - r6
                android.view.View r1 = r2.getChildAt(r1)
                int r1 = r1.getBottom()
                if (r4 >= r1) goto Lc2
                r3 = 1
            Lc2:
                r0.f5349o = r3
            Lc4:
                r0.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.a.onScrollChanged():void");
        }
    }

    public MDRootLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5348n = false;
        this.f5349o = false;
        this.f5350p = new MDButton[3];
        this.f5351q = false;
        this.f5352r = false;
        this.f5353s = true;
        this.f5359y = GravityEnum.START;
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MDRootLayout, 0, 0);
        this.f5354t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MDRootLayout_md_reduce_padding_no_title_no_buttons, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f5356v = resources.getDimensionPixelSize(R.dimen.md_notitle_vertical_padding);
        this.f5357w = resources.getDimensionPixelSize(R.dimen.md_button_frame_vertical_padding);
        this.f5360z = resources.getDimensionPixelSize(R.dimen.md_button_padding_frame_side);
        this.f5358x = resources.getDimensionPixelSize(R.dimen.md_button_height);
        this.A = new Paint();
        this.D = resources.getDimensionPixelSize(R.dimen.md_divider_height);
        this.A.setColor(o3.a.resolveColor(context, R.attr.md_divider_color));
        setWillNotDraw(false);
    }

    public static boolean b(View view) {
        boolean z10 = (view == null || view.getVisibility() == 8) ? false : true;
        if (z10 && (view instanceof MDButton)) {
            return ((MDButton) view).getText().toString().trim().length() > 0;
        }
        return z10;
    }

    public static boolean canRecyclerViewScroll(RecyclerView recyclerView) {
        if (recyclerView == null || recyclerView.getAdapter() == null || recyclerView.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.l layoutManager = recyclerView.getLayoutManager();
        int itemCount = recyclerView.getAdapter().getItemCount();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new MaterialDialog.NotImplementedException("Material Dialogs currently only supports LinearLayoutManager. Please report any new layout managers.");
        }
        int iFindLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        if (iFindLastVisibleItemPosition == -1) {
            return false;
        }
        return !(iFindLastVisibleItemPosition == itemCount - 1) || (recyclerView.getChildCount() > 0 && recyclerView.getChildAt(recyclerView.getChildCount() - 1).getBottom() > recyclerView.getHeight() - recyclerView.getPaddingBottom());
    }

    public final void a(ViewGroup viewGroup, boolean z10, boolean z11) {
        if ((z11 || this.B != null) && !(z11 && this.C == null)) {
            return;
        }
        a aVar = new a(viewGroup, z10, z11);
        if (z11) {
            this.C = aVar;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.C);
        } else {
            this.B = aVar;
            viewGroup.getViewTreeObserver().addOnScrollChangedListener(this.B);
        }
        aVar.onScrollChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(android.view.View r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.c(android.view.View, boolean):void");
    }

    public void noTitleNoPadding() {
        this.f5355u = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        View view = this.f5347m;
        if (view != null) {
            if (this.f5348n) {
                canvas.drawRect(0.0f, r0 - this.D, getMeasuredWidth(), view.getTop(), this.A);
            }
            if (this.f5349o) {
                canvas.drawRect(0.0f, this.f5347m.getBottom(), getMeasuredWidth(), r0 + this.D, this.A);
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() == R.id.titleFrame) {
                this.f5346b = childAt;
            } else {
                int id2 = childAt.getId();
                int i11 = R.id.buttonDefaultNeutral;
                MDButton[] mDButtonArr = this.f5350p;
                if (id2 == i11) {
                    mDButtonArr[0] = (MDButton) childAt;
                } else if (childAt.getId() == R.id.buttonDefaultNegative) {
                    mDButtonArr[1] = (MDButton) childAt;
                } else if (childAt.getId() == R.id.buttonDefaultPositive) {
                    mDButtonArr[2] = (MDButton) childAt;
                } else {
                    this.f5347m = childAt;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int measuredWidth;
        int measuredWidth2;
        int measuredWidth3;
        int measuredWidth4;
        int measuredWidth5;
        int measuredWidth6;
        int measuredWidth7;
        int measuredWidth8;
        int i15 = i11;
        if (b(this.f5346b)) {
            int measuredHeight = this.f5346b.getMeasuredHeight() + i15;
            this.f5346b.layout(i10, i15, i12, measuredHeight);
            i15 = measuredHeight;
        } else if (!this.f5355u && this.f5353s) {
            i15 += this.f5356v;
        }
        if (b(this.f5347m)) {
            View view = this.f5347m;
            view.layout(i10, i15, i12, view.getMeasuredHeight() + i15);
        }
        boolean z11 = this.f5352r;
        MDButton[] mDButtonArr = this.f5350p;
        if (z11) {
            int measuredHeight2 = i13 - this.f5357w;
            for (MDButton mDButton : mDButtonArr) {
                if (b(mDButton)) {
                    mDButton.layout(i10, measuredHeight2 - mDButton.getMeasuredHeight(), i12, measuredHeight2);
                    measuredHeight2 -= mDButton.getMeasuredHeight();
                }
            }
        } else {
            int i16 = this.f5353s ? i13 - this.f5357w : i13;
            int i17 = i16 - this.f5358x;
            int measuredWidth9 = this.f5360z;
            boolean zB = b(mDButtonArr[2]);
            GravityEnum gravityEnum = GravityEnum.END;
            if (zB) {
                if (this.f5359y == gravityEnum) {
                    measuredWidth7 = i10 + measuredWidth9;
                    measuredWidth8 = mDButtonArr[2].getMeasuredWidth() + measuredWidth7;
                    i14 = -1;
                } else {
                    int i18 = i12 - measuredWidth9;
                    measuredWidth7 = i18 - mDButtonArr[2].getMeasuredWidth();
                    measuredWidth8 = i18;
                    i14 = measuredWidth7;
                }
                mDButtonArr[2].layout(measuredWidth7, i17, measuredWidth8, i16);
                measuredWidth9 += mDButtonArr[2].getMeasuredWidth();
            } else {
                i14 = -1;
            }
            boolean zB2 = b(mDButtonArr[1]);
            GravityEnum gravityEnum2 = GravityEnum.START;
            if (zB2) {
                GravityEnum gravityEnum3 = this.f5359y;
                if (gravityEnum3 == gravityEnum) {
                    measuredWidth5 = measuredWidth9 + i10;
                    measuredWidth6 = mDButtonArr[1].getMeasuredWidth() + measuredWidth5;
                } else if (gravityEnum3 == gravityEnum2) {
                    measuredWidth6 = i12 - measuredWidth9;
                    measuredWidth5 = measuredWidth6 - mDButtonArr[1].getMeasuredWidth();
                } else {
                    measuredWidth5 = this.f5360z + i10;
                    measuredWidth6 = mDButtonArr[1].getMeasuredWidth() + measuredWidth5;
                    measuredWidth = measuredWidth6;
                    mDButtonArr[1].layout(measuredWidth5, i17, measuredWidth6, i16);
                }
                measuredWidth = -1;
                mDButtonArr[1].layout(measuredWidth5, i17, measuredWidth6, i16);
            } else {
                measuredWidth = -1;
            }
            if (b(mDButtonArr[0])) {
                GravityEnum gravityEnum4 = this.f5359y;
                if (gravityEnum4 == gravityEnum) {
                    measuredWidth3 = i12 - this.f5360z;
                    measuredWidth4 = measuredWidth3 - mDButtonArr[0].getMeasuredWidth();
                } else if (gravityEnum4 == gravityEnum2) {
                    measuredWidth4 = this.f5360z + i10;
                    measuredWidth3 = mDButtonArr[0].getMeasuredWidth() + measuredWidth4;
                } else {
                    if (measuredWidth != -1 || i14 == -1) {
                        if (i14 == -1 && measuredWidth != -1) {
                            measuredWidth2 = mDButtonArr[0].getMeasuredWidth();
                        } else if (i14 == -1) {
                            measuredWidth = ((i12 - i10) / 2) - (mDButtonArr[0].getMeasuredWidth() / 2);
                            measuredWidth2 = mDButtonArr[0].getMeasuredWidth();
                        }
                        i14 = measuredWidth2 + measuredWidth;
                    } else {
                        measuredWidth = i14 - mDButtonArr[0].getMeasuredWidth();
                    }
                    measuredWidth3 = i14;
                    measuredWidth4 = measuredWidth;
                }
                mDButtonArr[0].layout(measuredWidth4, i17, measuredWidth3, i16);
            }
        }
        c(this.f5347m, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0101  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r12, int r13) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.MDRootLayout.onMeasure(int, int):void");
    }

    public void setButtonGravity(GravityEnum gravityEnum) {
        this.f5359y = gravityEnum;
        if (getResources().getConfiguration().getLayoutDirection() == 1) {
            int iOrdinal = this.f5359y.ordinal();
            if (iOrdinal == 0) {
                this.f5359y = GravityEnum.END;
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                this.f5359y = GravityEnum.START;
            }
        }
    }

    public void setButtonStackedGravity(GravityEnum gravityEnum) {
        for (MDButton mDButton : this.f5350p) {
            if (mDButton != null) {
                mDButton.setStackedGravity(gravityEnum);
            }
        }
    }

    public void setDividerColor(int i10) {
        this.A.setColor(i10);
        invalidate();
    }

    public void setForceStack(boolean z10) {
        this.f5351q = z10;
        invalidate();
    }
}
