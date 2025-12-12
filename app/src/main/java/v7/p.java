package v7;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.o0;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import x0.j0;

/* compiled from: MaterialAutoCompleteTextView.java */
/* loaded from: classes.dex */
public final class p extends androidx.appcompat.widget.d {

    /* renamed from: p, reason: collision with root package name */
    public final o0 f20594p;

    /* renamed from: q, reason: collision with root package name */
    public final AccessibilityManager f20595q;

    /* renamed from: r, reason: collision with root package name */
    public final Rect f20596r;

    /* renamed from: s, reason: collision with root package name */
    public final int f20597s;

    /* renamed from: t, reason: collision with root package name */
    public final float f20598t;

    /* renamed from: u, reason: collision with root package name */
    public ColorStateList f20599u;

    /* renamed from: v, reason: collision with root package name */
    public int f20600v;

    /* renamed from: w, reason: collision with root package name */
    public ColorStateList f20601w;

    /* compiled from: MaterialAutoCompleteTextView.java */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            p pVar = p.this;
            p.a(pVar, i10 < 0 ? pVar.f20594p.getSelectedItem() : pVar.getAdapter().getItem(i10));
            AdapterView.OnItemClickListener onItemClickListener = pVar.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i10 < 0) {
                    view = pVar.f20594p.getSelectedView();
                    i10 = pVar.f20594p.getSelectedItemPosition();
                    j10 = pVar.f20594p.getSelectedItemId();
                }
                onItemClickListener.onItemClick(pVar.f20594p.getListView(), view, i10, j10);
            }
            pVar.f20594p.dismiss();
        }
    }

    /* compiled from: MaterialAutoCompleteTextView.java */
    public class b<T> extends ArrayAdapter<String> {

        /* renamed from: b, reason: collision with root package name */
        public ColorStateList f20603b;

        /* renamed from: m, reason: collision with root package name */
        public ColorStateList f20604m;

        public b(Context context, int i10, String[] strArr) {
            super(context, i10, strArr);
            a();
        }

        public final void a() {
            ColorStateList colorStateList;
            p pVar = p.this;
            ColorStateList colorStateList2 = pVar.f20601w;
            ColorStateList colorStateList3 = null;
            if (colorStateList2 != null) {
                int[] iArr = {R.attr.state_pressed};
                colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
            } else {
                colorStateList = null;
            }
            this.f20604m = colorStateList;
            if (pVar.f20600v != 0) {
                if (pVar.f20601w != null) {
                    int[] iArr2 = {R.attr.state_hovered, -16842919};
                    int[] iArr3 = {R.attr.state_selected, -16842919};
                    colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{c7.a.layer(pVar.f20600v, pVar.f20601w.getColorForState(iArr3, 0)), c7.a.layer(pVar.f20600v, pVar.f20601w.getColorForState(iArr2, 0)), pVar.f20600v});
                }
            }
            this.f20603b = colorStateList3;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                p pVar = p.this;
                Drawable rippleDrawable = null;
                if (pVar.getText().toString().contentEquals(textView.getText())) {
                    if (pVar.f20600v != 0) {
                        ColorDrawable colorDrawable = new ColorDrawable(pVar.f20600v);
                        if (this.f20604m != null) {
                            p0.a.setTintList(colorDrawable, this.f20603b);
                            rippleDrawable = new RippleDrawable(this.f20604m, colorDrawable, null);
                        } else {
                            rippleDrawable = colorDrawable;
                        }
                    }
                }
                j0.setBackground(textView, rippleDrawable);
            }
            return view2;
        }
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.autoCompleteTextViewStyle);
    }

    public static void a(p pVar, Object obj) {
        pVar.setText(pVar.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public final boolean c() {
        boolean z10;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f20595q;
        if (accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled()) {
            return true;
        }
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16)) == null) {
            z10 = false;
        } else {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        return z10;
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (c()) {
            this.f20594p.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f20599u;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutB = b();
        return (textInputLayoutB == null || !textInputLayoutB.isProvidingHint()) ? super.getHint() : textInputLayoutB.getHint();
    }

    public float getPopupElevation() {
        return this.f20598t;
    }

    public int getSimpleItemSelectedColor() {
        return this.f20600v;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f20601w;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null && textInputLayoutB.isProvidingHint() && super.getHint() == null && i7.f.isMeizuDevice()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20594p.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout textInputLayoutB = b();
            int measuredWidth2 = 0;
            if (adapter != null && textInputLayoutB != null) {
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                o0 o0Var = this.f20594p;
                int iMin = Math.min(adapter.getCount(), Math.max(0, o0Var.getSelectedItemPosition()) + 15);
                View view = null;
                int iMax = 0;
                for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
                    int itemViewType = adapter.getItemViewType(iMax2);
                    if (itemViewType != measuredWidth2) {
                        view = null;
                        measuredWidth2 = itemViewType;
                    }
                    view = adapter.getView(iMax2, view, textInputLayoutB);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = Math.max(iMax, view.getMeasuredWidth());
                }
                Drawable background = o0Var.getBackground();
                if (background != null) {
                    Rect rect = this.f20596r;
                    background.getPadding(rect);
                    iMax += rect.left + rect.right;
                }
                measuredWidth2 = textInputLayoutB.getEndIconView().getMeasuredWidth() + iMax;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, measuredWidth2), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z10) {
        if (c()) {
            return;
        }
        super.onWindowFocusChanged(z10);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t10) {
        super.setAdapter(t10);
        this.f20594p.setAdapter(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        o0 o0Var = this.f20594p;
        if (o0Var != null) {
            o0Var.setBackgroundDrawable(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i10) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i10));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f20599u = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof q7.g) {
            ((q7.g) dropDownBackground).setFillColor(this.f20599u);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f20594p.setOnItemSelectedListener(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i10) {
        super.setRawInputType(i10);
        TextInputLayout textInputLayoutB = b();
        if (textInputLayoutB != null) {
            textInputLayoutB.s();
        }
    }

    public void setSimpleItemSelectedColor(int i10) {
        this.f20600v = i10;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).a();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f20601w = colorStateList;
        if (getAdapter() instanceof b) {
            ((b) getAdapter()).a();
        }
    }

    public void setSimpleItems(int i10) {
        setSimpleItems(getResources().getStringArray(i10));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (c()) {
            this.f20594p.show();
        } else {
            super.showDropDown();
        }
    }

    public p(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.wrap(context, attributeSet, i10, 0), attributeSet, i10);
        this.f20596r = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = i7.r.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialAutoCompleteTextView, i10, com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        int i11 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType;
        if (typedArrayObtainStyledAttributes.hasValue(i11) && typedArrayObtainStyledAttributes.getInt(i11, 0) == 0) {
            setKeyListener(null);
        }
        this.f20597s = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemLayout, com.google.android.material.R.layout.mtrl_auto_complete_simple_item);
        this.f20598t = typedArrayObtainStyledAttributes.getDimensionPixelOffset(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_popupElevation, com.google.android.material.R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int i12 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            this.f20599u = ColorStateList.valueOf(typedArrayObtainStyledAttributes.getColor(i12, 0));
        }
        this.f20600v = typedArrayObtainStyledAttributes.getColor(com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.f20601w = n7.c.getColorStateList(context2, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.f20595q = (AccessibilityManager) context2.getSystemService("accessibility");
        o0 o0Var = new o0(context2);
        this.f20594p = o0Var;
        o0Var.setModal(true);
        o0Var.setAnchorView(this);
        o0Var.setInputMethodMode(2);
        o0Var.setAdapter(getAdapter());
        o0Var.setOnItemClickListener(new a());
        int i13 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_simpleItems;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            setSimpleItems(typedArrayObtainStyledAttributes.getResourceId(i13, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new b(getContext(), this.f20597s, strArr));
    }
}
