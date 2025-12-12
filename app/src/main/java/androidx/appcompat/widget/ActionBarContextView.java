package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R;

/* loaded from: classes.dex */
public class ActionBarContextView extends androidx.appcompat.widget.a {
    public TextView A;
    public final int B;
    public final int C;
    public boolean D;
    public final int E;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f1079t;

    /* renamed from: u, reason: collision with root package name */
    public CharSequence f1080u;

    /* renamed from: v, reason: collision with root package name */
    public View f1081v;

    /* renamed from: w, reason: collision with root package name */
    public View f1082w;

    /* renamed from: x, reason: collision with root package name */
    public View f1083x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f1084y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f1085z;

    public class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w.b f1086b;

        public a(w.b bVar) {
            this.f1086b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f1086b.finish();
        }
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public final void c() {
        if (this.f1084y == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1084y = linearLayout;
            this.f1085z = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.A = (TextView) this.f1084y.findViewById(R.id.action_bar_subtitle);
            int i10 = this.B;
            if (i10 != 0) {
                this.f1085z.setTextAppearance(getContext(), i10);
            }
            int i11 = this.C;
            if (i11 != 0) {
                this.A.setTextAppearance(getContext(), i11);
            }
        }
        this.f1085z.setText(this.f1079t);
        this.A.setText(this.f1080u);
        boolean z10 = !TextUtils.isEmpty(this.f1079t);
        boolean z11 = !TextUtils.isEmpty(this.f1080u);
        int i12 = 0;
        this.A.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f1084y;
        if (!z10 && !z11) {
            i12 = 8;
        }
        linearLayout2.setVisibility(i12);
        if (this.f1084y.getParent() == null) {
            addView(this.f1084y);
        }
    }

    public void closeMode() {
        if (this.f1081v == null) {
            killMode();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1080u;
    }

    public CharSequence getTitle() {
        return this.f1079t;
    }

    public void initForMode(w.b bVar) {
        View view = this.f1081v;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.E, (ViewGroup) this, false);
            this.f1081v = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f1081v);
        }
        View viewFindViewById = this.f1081v.findViewById(R.id.action_mode_close_button);
        this.f1082w = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.getMenu();
        c cVar = this.f1239o;
        if (cVar != null) {
            cVar.dismissPopupMenus();
        }
        c cVar2 = new c(getContext());
        this.f1239o = cVar2;
        cVar2.setReserveOverflow(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.addMenuPresenter(this.f1239o, this.f1237m);
        ActionMenuView actionMenuView = (ActionMenuView) this.f1239o.getMenuView(this);
        this.f1238n = actionMenuView;
        x0.j0.setBackground(actionMenuView, null);
        addView(this.f1238n, layoutParams);
    }

    public boolean isTitleOptional() {
        return this.D;
    }

    public void killMode() {
        removeAllViews();
        this.f1083x = null;
        this.f1238n = null;
        this.f1239o = null;
        View view = this.f1082w;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.f1239o;
        if (cVar != null) {
            cVar.hideOverflowMenu();
            this.f1239o.hideSubMenus();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zIsLayoutRtl = k1.isLayoutRtl(this);
        int paddingRight = zIsLayoutRtl ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f1081v;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1081v.getLayoutParams();
            int i14 = zIsLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zIsLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = androidx.appcompat.widget.a.next(paddingRight, i14, zIsLayoutRtl);
            paddingRight = androidx.appcompat.widget.a.next(next + positionChild(this.f1081v, next, paddingTop, paddingTop2, zIsLayoutRtl), i15, zIsLayoutRtl);
        }
        int iPositionChild = paddingRight;
        LinearLayout linearLayout = this.f1084y;
        if (linearLayout != null && this.f1083x == null && linearLayout.getVisibility() != 8) {
            iPositionChild += positionChild(this.f1084y, iPositionChild, paddingTop, paddingTop2, zIsLayoutRtl);
        }
        int i16 = iPositionChild;
        View view2 = this.f1083x;
        if (view2 != null) {
            positionChild(view2, i16, paddingTop, paddingTop2, zIsLayoutRtl);
        }
        int paddingLeft = zIsLayoutRtl ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f1238n;
        if (actionMenuView != null) {
            positionChild(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zIsLayoutRtl);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f1240p;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f1081v;
        if (view != null) {
            int iMeasureChildView = measureChildView(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1081v.getLayoutParams();
            paddingLeft = iMeasureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f1238n;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = measureChildView(this.f1238n, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f1084y;
        if (linearLayout != null && this.f1083x == null) {
            if (this.D) {
                this.f1084y.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1084y.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f1084y.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = measureChildView(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f1083x;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i12 = layoutParams.width;
            int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i12 >= 0) {
                paddingLeft = Math.min(i12, paddingLeft);
            }
            int i14 = layoutParams.height;
            int i15 = i14 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i14 >= 0) {
                iMin = Math.min(i14, iMin);
            }
            this.f1083x.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f1240p > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f1240p = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f1083x;
        if (view2 != null) {
            removeView(view2);
        }
        this.f1083x = view;
        if (view != null && (linearLayout = this.f1084y) != null) {
            removeView(linearLayout);
            this.f1084y = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1080u = charSequence;
        c();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1079t = charSequence;
        c();
        x0.j0.setAccessibilityPaneTitle(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.D) {
            requestLayout();
        }
        this.D = z10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ x0.r0 setupAnimatorToVisibility(int i10, long j10) {
        return super.setupAnimatorToVisibility(i10, j10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        c cVar = this.f1239o;
        if (cVar != null) {
            return cVar.showOverflowMenu();
        }
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        c1 c1VarObtainStyledAttributes = c1.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i10, 0);
        x0.j0.setBackground(this, c1VarObtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.B = c1VarObtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.C = c1VarObtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f1240p = c1VarObtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.E = c1VarObtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        c1VarObtainStyledAttributes.recycle();
    }
}
