package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f1;
import androidx.appcompat.widget.l0;

/* loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements j.a, View.OnClickListener, ActionMenuView.a {
    public final int A;
    public int B;
    public final int C;

    /* renamed from: s, reason: collision with root package name */
    public g f909s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f910t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f911u;

    /* renamed from: v, reason: collision with root package name */
    public e.b f912v;

    /* renamed from: w, reason: collision with root package name */
    public a f913w;

    /* renamed from: x, reason: collision with root package name */
    public b f914x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f915y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f916z;

    public class a extends l0 {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.l0
        public x.f getPopup() {
            b bVar = ActionMenuItemView.this.f914x;
            if (bVar != null) {
                return bVar.getPopup();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.l0
        public boolean onForwardingStarted() {
            x.f popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            e.b bVar = actionMenuItemView.f912v;
            return bVar != null && bVar.invokeItem(actionMenuItemView.f909s) && (popup = getPopup()) != null && popup.isShowing();
        }
    }

    public static abstract class b {
        public abstract x.f getPopup();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // androidx.appcompat.view.menu.j.a
    public g getItemData() {
        return this.f909s;
    }

    public boolean hasText() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void initialize(g gVar, int i10) {
        this.f909s = gVar;
        setIcon(gVar.getIcon());
        setTitle(prefersCondensedTitle() ? gVar.getTitleCondensed() : gVar.getTitle());
        setId(gVar.getItemId());
        setVisibility(gVar.isVisible() ? 0 : 8);
        setEnabled(gVar.isEnabled());
        if (gVar.hasSubMenu() && this.f913w == null) {
            this.f913w = new a();
        }
    }

    public final boolean m() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i10 = configuration.screenWidthDp;
        return i10 >= 480 || (i10 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void n() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.f910t);
        if (this.f911u != null && (!this.f909s.showsTextAsAction() || (!this.f915y && !this.f916z))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.f910t : null);
        CharSequence contentDescription = this.f909s.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z12 ? null : this.f909s.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f909s.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            f1.setTooltipText(this, z12 ? null : this.f909s.getTitle());
        } else {
            f1.setTooltipText(this, tooltipText);
        }
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerAfter() {
        return hasText();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.a
    public boolean needsDividerBefore() {
        return hasText() && this.f909s.getIcon() == null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e.b bVar = this.f912v;
        if (bVar != null) {
            bVar.invokeItem(this.f909s);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f915y = m();
        n();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        boolean zHasText = hasText();
        if (zHasText && (i12 = this.B) >= 0) {
            super.setPadding(i12, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int measuredWidth = getMeasuredWidth();
        int i13 = this.A;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i13) : i13;
        if (mode != 1073741824 && i13 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i11);
        }
        if (zHasText || this.f911u == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f911u.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        if (this.f909s.hasSubMenu() && (aVar = this.f913w) != null && aVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setExpandedFormat(boolean z10) {
        if (this.f916z != z10) {
            this.f916z = z10;
            g gVar = this.f909s;
            if (gVar != null) {
                gVar.actionFormatChanged();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f911u = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i10 = this.C;
            if (intrinsicWidth > i10) {
                intrinsicHeight = (int) (intrinsicHeight * (i10 / intrinsicWidth));
                intrinsicWidth = i10;
            }
            if (intrinsicHeight > i10) {
                intrinsicWidth = (int) (intrinsicWidth * (i10 / intrinsicHeight));
            } else {
                i10 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i10);
        }
        setCompoundDrawables(drawable, null, null, null);
        n();
    }

    public void setItemInvoker(e.b bVar) {
        this.f912v = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        this.B = i10;
        super.setPadding(i10, i11, i12, i13);
    }

    public void setPopupCallback(b bVar) {
        this.f914x = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f910t = charSequence;
        n();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Resources resources = context.getResources();
        this.f915y = m();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i10, 0);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.C = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.B = -1;
        setSaveEnabled(false);
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }
}
