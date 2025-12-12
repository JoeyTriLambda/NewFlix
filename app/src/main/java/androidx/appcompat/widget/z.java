package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.d;
import java.lang.reflect.InvocationTargetException;

/* compiled from: AppCompatSpinner.java */
/* loaded from: classes.dex */
public final class z extends Spinner {

    /* renamed from: t, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    public static final int[] f1558t = {R.attr.spinnerMode};

    /* renamed from: b, reason: collision with root package name */
    public final androidx.appcompat.widget.e f1559b;

    /* renamed from: m, reason: collision with root package name */
    public final Context f1560m;

    /* renamed from: n, reason: collision with root package name */
    public final a f1561n;

    /* renamed from: o, reason: collision with root package name */
    public SpinnerAdapter f1562o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f1563p;

    /* renamed from: q, reason: collision with root package name */
    public final j f1564q;

    /* renamed from: r, reason: collision with root package name */
    public int f1565r;

    /* renamed from: s, reason: collision with root package name */
    public final Rect f1566s;

    /* compiled from: AppCompatSpinner.java */
    public class a extends l0 {

        /* renamed from: u, reason: collision with root package name */
        public final /* synthetic */ h f1567u;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, h hVar) {
            super(view);
            this.f1567u = hVar;
        }

        @Override // androidx.appcompat.widget.l0
        public x.f getPopup() {
            return this.f1567u;
        }

        @Override // androidx.appcompat.widget.l0
        @SuppressLint({"SyntheticAccessor"})
        public boolean onForwardingStarted() {
            z zVar = z.this;
            if (zVar.getInternalPopup().isShowing()) {
                return true;
            }
            zVar.f1564q.show(d.b(zVar), d.a(zVar));
            return true;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            z zVar = z.this;
            if (!zVar.getInternalPopup().isShowing()) {
                zVar.f1564q.show(d.b(zVar), d.a(zVar));
            }
            ViewTreeObserver viewTreeObserver = zVar.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public static final class c {
        public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public static final class d {
        public static int a(View view) {
            return view.getTextAlignment();
        }

        public static int b(View view) {
            return view.getTextDirection();
        }

        public static void c(View view, int i10) {
            view.setTextAlignment(i10);
        }

        public static void d(View view, int i10) {
            view.setTextDirection(i10);
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public static final class e {
        public static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (w0.c.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public class f implements j, DialogInterface.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public androidx.appcompat.app.d f1570b;

        /* renamed from: m, reason: collision with root package name */
        public ListAdapter f1571m;

        /* renamed from: n, reason: collision with root package name */
        public CharSequence f1572n;

        public f() {
        }

        @Override // androidx.appcompat.widget.z.j
        public void dismiss() {
            androidx.appcompat.app.d dVar = this.f1570b;
            if (dVar != null) {
                dVar.dismiss();
                this.f1570b = null;
            }
        }

        @Override // androidx.appcompat.widget.z.j
        public Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.z.j
        public CharSequence getHintText() {
            return this.f1572n;
        }

        @Override // androidx.appcompat.widget.z.j
        public int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.z.j
        public int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.z.j
        public boolean isShowing() {
            androidx.appcompat.app.d dVar = this.f1570b;
            if (dVar != null) {
                return dVar.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            z zVar = z.this;
            zVar.setSelection(i10);
            if (zVar.getOnItemClickListener() != null) {
                zVar.performItemClick(null, i10, this.f1571m.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.z.j
        public void setAdapter(ListAdapter listAdapter) {
            this.f1571m = listAdapter;
        }

        @Override // androidx.appcompat.widget.z.j
        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.j
        public void setHorizontalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.j
        public void setHorizontalOriginalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.j
        public void setPromptText(CharSequence charSequence) {
            this.f1572n = charSequence;
        }

        @Override // androidx.appcompat.widget.z.j
        public void setVerticalOffset(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.z.j
        public void show(int i10, int i11) {
            if (this.f1571m == null) {
                return;
            }
            z zVar = z.this;
            d.a aVar = new d.a(zVar.getPopupContext());
            CharSequence charSequence = this.f1572n;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.d dVarCreate = aVar.setSingleChoiceItems(this.f1571m, zVar.getSelectedItemPosition(), this).create();
            this.f1570b = dVarCreate;
            ListView listView = dVarCreate.getListView();
            d.d(listView, i10);
            d.c(listView, i11);
            this.f1570b.show();
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public static class g implements ListAdapter, SpinnerAdapter {

        /* renamed from: b, reason: collision with root package name */
        public final SpinnerAdapter f1574b;

        /* renamed from: m, reason: collision with root package name */
        public final ListAdapter f1575m;

        public g(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1574b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1575m = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof y0) {
                    y0 y0Var = (y0) spinnerAdapter;
                    if (y0Var.getDropDownViewTheme() == null) {
                        y0Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1575m;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1575m;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1574b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public class h extends o0 implements j {
        public CharSequence O;
        public ListAdapter P;
        public final Rect Q;
        public int R;

        /* compiled from: AppCompatSpinner.java */
        public class a implements AdapterView.OnItemClickListener {
            public a() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                h hVar = h.this;
                z.this.setSelection(i10);
                if (z.this.getOnItemClickListener() != null) {
                    z.this.performItemClick(view, i10, hVar.P.getItemId(i10));
                }
                hVar.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                h hVar = h.this;
                z zVar = z.this;
                hVar.getClass();
                if (!(x0.j0.isAttachedToWindow(zVar) && zVar.getGlobalVisibleRect(hVar.Q))) {
                    hVar.dismiss();
                } else {
                    hVar.c();
                    h.super.show();
                }
            }
        }

        /* compiled from: AppCompatSpinner.java */
        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1578b;

            public c(b bVar) {
                this.f1578b = bVar;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = z.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1578b);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.Q = new Rect();
            setAnchorView(z.this);
            setModal(true);
            setPromptPosition(0);
            setOnItemClickListener(new a());
        }

        public final void c() {
            int i10;
            Drawable background = getBackground();
            z zVar = z.this;
            if (background != null) {
                background.getPadding(zVar.f1566s);
                i10 = k1.isLayoutRtl(zVar) ? zVar.f1566s.right : -zVar.f1566s.left;
            } else {
                Rect rect = zVar.f1566s;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = zVar.getPaddingLeft();
            int paddingRight = zVar.getPaddingRight();
            int width = zVar.getWidth();
            int i11 = zVar.f1565r;
            if (i11 == -2) {
                int iA = zVar.a((SpinnerAdapter) this.P, getBackground());
                int i12 = zVar.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = zVar.f1566s;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (iA > i13) {
                    iA = i13;
                }
                setContentWidth(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i11);
            }
            setHorizontalOffset(k1.isLayoutRtl(zVar) ? (((width - paddingRight) - getWidth()) - getHorizontalOriginalOffset()) + i10 : getHorizontalOriginalOffset() + paddingLeft + i10);
        }

        @Override // androidx.appcompat.widget.z.j
        public CharSequence getHintText() {
            return this.O;
        }

        public int getHorizontalOriginalOffset() {
            return this.R;
        }

        @Override // androidx.appcompat.widget.o0, androidx.appcompat.widget.z.j
        public void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.P = listAdapter;
        }

        @Override // androidx.appcompat.widget.z.j
        public void setHorizontalOriginalOffset(int i10) {
            this.R = i10;
        }

        @Override // androidx.appcompat.widget.z.j
        public void setPromptText(CharSequence charSequence) {
            this.O = charSequence;
        }

        @Override // androidx.appcompat.widget.z.j
        public void show(int i10, int i11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            ViewTreeObserver viewTreeObserver;
            boolean zIsShowing = isShowing();
            c();
            setInputMethodMode(2);
            super.show();
            ListView listView = getListView();
            listView.setChoiceMode(1);
            d.d(listView, i10);
            d.c(listView, i11);
            z zVar = z.this;
            setSelection(zVar.getSelectedItemPosition());
            if (zIsShowing || (viewTreeObserver = zVar.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            setOnDismissListener(new c(bVar));
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public static class i extends View.BaseSavedState {
        public static final Parcelable.Creator<i> CREATOR = new a();

        /* renamed from: b, reason: collision with root package name */
        public boolean f1580b;

        /* compiled from: AppCompatSpinner.java */
        public class a implements Parcelable.Creator<i> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public i createFromParcel(Parcel parcel) {
                return new i(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public i[] newArray(int i10) {
                return new i[i10];
            }
        }

        public i(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1580b ? (byte) 1 : (byte) 0);
        }

        public i(Parcel parcel) {
            super(parcel);
            this.f1580b = parcel.readByte() != 0;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    public interface j {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i10);

        void setHorizontalOriginalOffset(int i10);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i10);

        void show(int i10, int i11);
    }

    public z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.f1566s;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        j jVar = this.f1564q;
        return jVar != null ? jVar.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        j jVar = this.f1564q;
        return jVar != null ? jVar.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1564q != null ? this.f1565r : super.getDropDownWidth();
    }

    public final j getInternalPopup() {
        return this.f1564q;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        j jVar = this.f1564q;
        return jVar != null ? jVar.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1560m;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        j jVar = this.f1564q;
        return jVar != null ? jVar.getHintText() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j jVar = this.f1564q;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        jVar.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1564q == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        i iVar = (i) parcelable;
        super.onRestoreInstanceState(iVar.getSuperState());
        if (!iVar.f1580b || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar = new i(super.onSaveInstanceState());
        j jVar = this.f1564q;
        iVar.f1580b = jVar != null && jVar.isShowing();
        return iVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar = this.f1561n;
        if (aVar == null || !aVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        j jVar = this.f1564q;
        if (jVar == null) {
            return super.performClick();
        }
        if (jVar.isShowing()) {
            return true;
        }
        jVar.show(d.b(this), d.a(this));
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            eVar.f(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        j jVar = this.f1564q;
        if (jVar == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            jVar.setHorizontalOriginalOffset(i10);
            jVar.setHorizontalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        j jVar = this.f1564q;
        if (jVar != null) {
            jVar.setVerticalOffset(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f1564q != null) {
            this.f1565r = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        j jVar = this.f1564q;
        if (jVar != null) {
            jVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(s.a.getDrawable(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        j jVar = this.f1564q;
        if (jVar != null) {
            jVar.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            eVar.h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.e eVar = this.f1559b;
        if (eVar != null) {
            eVar.i(mode);
        }
    }

    public z(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1563p) {
            this.f1562o = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        j jVar = this.f1564q;
        if (jVar != null) {
            Context context = this.f1560m;
            if (context == null) {
                context = getContext();
            }
            jVar.setAdapter(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public z(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00db  */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.z] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
