package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: ListPopupWindow.java */
/* loaded from: classes.dex */
public class o0 implements x.f {
    public static final Method L;
    public static final Method M;
    public static final Method N;
    public AdapterView.OnItemClickListener A;
    public AdapterView.OnItemSelectedListener B;
    public final g C;
    public final f D;
    public final e E;
    public final c F;
    public final Handler G;
    public final Rect H;
    public Rect I;
    public boolean J;
    public final s K;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1468b;

    /* renamed from: m, reason: collision with root package name */
    public ListAdapter f1469m;

    /* renamed from: n, reason: collision with root package name */
    public j0 f1470n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1471o;

    /* renamed from: p, reason: collision with root package name */
    public int f1472p;

    /* renamed from: q, reason: collision with root package name */
    public int f1473q;

    /* renamed from: r, reason: collision with root package name */
    public int f1474r;

    /* renamed from: s, reason: collision with root package name */
    public final int f1475s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1476t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1477u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1478v;

    /* renamed from: w, reason: collision with root package name */
    public int f1479w;

    /* renamed from: x, reason: collision with root package name */
    public final int f1480x;

    /* renamed from: y, reason: collision with root package name */
    public d f1481y;

    /* renamed from: z, reason: collision with root package name */
    public View f1482z;

    /* compiled from: ListPopupWindow.java */
    public static class a {
        public static int a(PopupWindow popupWindow, View view, int i10, boolean z10) {
            return popupWindow.getMaxAvailableHeight(view, i10, z10);
        }
    }

    /* compiled from: ListPopupWindow.java */
    public static class b {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z10) {
            popupWindow.setIsClippedToScreen(z10);
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.this.clearListSelection();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class d extends DataSetObserver {
        public d() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            o0 o0Var = o0.this;
            if (o0Var.isShowing()) {
                o0Var.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            o0.this.dismiss();
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class f implements View.OnTouchListener {
        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            s sVar;
            int action = motionEvent.getAction();
            int x10 = (int) motionEvent.getX();
            int y10 = (int) motionEvent.getY();
            o0 o0Var = o0.this;
            if (action == 0 && (sVar = o0Var.K) != null && sVar.isShowing() && x10 >= 0) {
                s sVar2 = o0Var.K;
                if (x10 < sVar2.getWidth() && y10 >= 0 && y10 < sVar2.getHeight()) {
                    o0Var.G.postDelayed(o0Var.C, 250L);
                    return false;
                }
            }
            if (action != 1) {
                return false;
            }
            o0Var.G.removeCallbacks(o0Var.C);
            return false;
        }
    }

    /* compiled from: ListPopupWindow.java */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            o0 o0Var = o0.this;
            j0 j0Var = o0Var.f1470n;
            if (j0Var == null || !x0.j0.isAttachedToWindow(j0Var) || o0Var.f1470n.getCount() <= o0Var.f1470n.getChildCount() || o0Var.f1470n.getChildCount() > o0Var.f1480x) {
                return;
            }
            o0Var.K.setInputMethodMode(2);
            o0Var.show();
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                L = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                N = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                M = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public o0(Context context) {
        this(context, null, R.attr.listPopupWindowStyle);
    }

    public j0 a(Context context, boolean z10) {
        return new j0(context, z10);
    }

    public void clearListSelection() {
        j0 j0Var = this.f1470n;
        if (j0Var != null) {
            j0Var.setListSelectionHidden(true);
            j0Var.requestLayout();
        }
    }

    @Override // x.f
    public void dismiss() {
        s sVar = this.K;
        sVar.dismiss();
        sVar.setContentView(null);
        this.f1470n = null;
        this.G.removeCallbacks(this.C);
    }

    public View getAnchorView() {
        return this.f1482z;
    }

    public Drawable getBackground() {
        return this.K.getBackground();
    }

    public int getHorizontalOffset() {
        return this.f1473q;
    }

    @Override // x.f
    public ListView getListView() {
        return this.f1470n;
    }

    public Object getSelectedItem() {
        if (isShowing()) {
            return this.f1470n.getSelectedItem();
        }
        return null;
    }

    public long getSelectedItemId() {
        if (isShowing()) {
            return this.f1470n.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int getSelectedItemPosition() {
        if (isShowing()) {
            return this.f1470n.getSelectedItemPosition();
        }
        return -1;
    }

    public View getSelectedView() {
        if (isShowing()) {
            return this.f1470n.getSelectedView();
        }
        return null;
    }

    public int getVerticalOffset() {
        if (this.f1476t) {
            return this.f1474r;
        }
        return 0;
    }

    public int getWidth() {
        return this.f1472p;
    }

    public boolean isInputMethodNotNeeded() {
        return this.K.getInputMethodMode() == 2;
    }

    public boolean isModal() {
        return this.J;
    }

    @Override // x.f
    public boolean isShowing() {
        return this.K.isShowing();
    }

    public void setAdapter(ListAdapter listAdapter) {
        d dVar = this.f1481y;
        if (dVar == null) {
            this.f1481y = new d();
        } else {
            ListAdapter listAdapter2 = this.f1469m;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dVar);
            }
        }
        this.f1469m = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1481y);
        }
        j0 j0Var = this.f1470n;
        if (j0Var != null) {
            j0Var.setAdapter(this.f1469m);
        }
    }

    public void setAnchorView(View view) {
        this.f1482z = view;
    }

    public void setAnimationStyle(int i10) {
        this.K.setAnimationStyle(i10);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.K.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i10) {
        Drawable background = this.K.getBackground();
        if (background == null) {
            setWidth(i10);
            return;
        }
        Rect rect = this.H;
        background.getPadding(rect);
        this.f1472p = rect.left + rect.right + i10;
    }

    public void setDropDownGravity(int i10) {
        this.f1479w = i10;
    }

    public void setEpicenterBounds(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void setHorizontalOffset(int i10) {
        this.f1473q = i10;
    }

    public void setInputMethodMode(int i10) {
        this.K.setInputMethodMode(i10);
    }

    public void setModal(boolean z10) {
        this.J = z10;
        this.K.setFocusable(z10);
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.K.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.A = onItemClickListener;
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.B = onItemSelectedListener;
    }

    public void setOverlapAnchor(boolean z10) {
        this.f1478v = true;
        this.f1477u = z10;
    }

    public void setSelection(int i10) {
        j0 j0Var = this.f1470n;
        if (!isShowing() || j0Var == null) {
            return;
        }
        j0Var.setListSelectionHidden(false);
        j0Var.setSelection(i10);
        if (j0Var.getChoiceMode() != 0) {
            j0Var.setItemChecked(i10, true);
        }
    }

    public void setVerticalOffset(int i10) {
        this.f1474r = i10;
        this.f1476t = true;
    }

    public void setWidth(int i10) {
        this.f1472p = i10;
    }

    @Override // x.f
    public void show() throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10;
        int iA;
        int paddingBottom;
        j0 j0Var = this.f1470n;
        s sVar = this.K;
        Context context = this.f1468b;
        if (j0Var == null) {
            j0 j0VarA = a(context, !this.J);
            this.f1470n = j0VarA;
            j0VarA.setAdapter(this.f1469m);
            this.f1470n.setOnItemClickListener(this.A);
            this.f1470n.setFocusable(true);
            this.f1470n.setFocusableInTouchMode(true);
            this.f1470n.setOnItemSelectedListener(new n0(this));
            this.f1470n.setOnScrollListener(this.E);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.B;
            if (onItemSelectedListener != null) {
                this.f1470n.setOnItemSelectedListener(onItemSelectedListener);
            }
            sVar.setContentView(this.f1470n);
        }
        Drawable background = sVar.getBackground();
        Rect rect = this.H;
        if (background != null) {
            background.getPadding(rect);
            int i11 = rect.top;
            i10 = rect.bottom + i11;
            if (!this.f1476t) {
                this.f1474r = -i11;
            }
        } else {
            rect.setEmpty();
            i10 = 0;
        }
        boolean z10 = sVar.getInputMethodMode() == 2;
        View anchorView = getAnchorView();
        int i12 = this.f1474r;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = M;
            if (method != null) {
                try {
                    iA = ((Integer) method.invoke(sVar, anchorView, Integer.valueOf(i12), Boolean.valueOf(z10))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            } else {
                iA = sVar.getMaxAvailableHeight(anchorView, i12);
            }
        } else {
            iA = a.a(sVar, anchorView, i12, z10);
        }
        int i13 = this.f1471o;
        if (i13 == -1) {
            paddingBottom = iA + i10;
        } else {
            int i14 = this.f1472p;
            int iMeasureHeightOfChildrenCompat = this.f1470n.measureHeightOfChildrenCompat(i14 != -2 ? i14 != -1 ? View.MeasureSpec.makeMeasureSpec(i14, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), 0, -1, iA + 0, -1);
            paddingBottom = iMeasureHeightOfChildrenCompat + (iMeasureHeightOfChildrenCompat > 0 ? this.f1470n.getPaddingBottom() + this.f1470n.getPaddingTop() + i10 + 0 : 0);
        }
        boolean zIsInputMethodNotNeeded = isInputMethodNotNeeded();
        d1.h.setWindowLayoutType(sVar, this.f1475s);
        if (sVar.isShowing()) {
            if (x0.j0.isAttachedToWindow(getAnchorView())) {
                int width = this.f1472p;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = getAnchorView().getWidth();
                }
                if (i13 == -1) {
                    i13 = zIsInputMethodNotNeeded ? paddingBottom : -1;
                    if (zIsInputMethodNotNeeded) {
                        sVar.setWidth(this.f1472p == -1 ? -1 : 0);
                        sVar.setHeight(0);
                    } else {
                        sVar.setWidth(this.f1472p == -1 ? -1 : 0);
                        sVar.setHeight(-1);
                    }
                } else if (i13 == -2) {
                    i13 = paddingBottom;
                }
                sVar.setOutsideTouchable(true);
                View anchorView2 = getAnchorView();
                int i15 = this.f1473q;
                int i16 = this.f1474r;
                if (width < 0) {
                    width = -1;
                }
                sVar.update(anchorView2, i15, i16, width, i13 < 0 ? -1 : i13);
                return;
            }
            return;
        }
        int width2 = this.f1472p;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = getAnchorView().getWidth();
        }
        if (i13 == -1) {
            i13 = -1;
        } else if (i13 == -2) {
            i13 = paddingBottom;
        }
        sVar.setWidth(width2);
        sVar.setHeight(i13);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = L;
            if (method2 != null) {
                try {
                    method2.invoke(sVar, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b.b(sVar, true);
        }
        sVar.setOutsideTouchable(true);
        sVar.setTouchInterceptor(this.D);
        if (this.f1478v) {
            d1.h.setOverlapAnchor(sVar, this.f1477u);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = N;
            if (method3 != null) {
                try {
                    method3.invoke(sVar, this.I);
                } catch (Exception e10) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e10);
                }
            }
        } else {
            b.a(sVar, this.I);
        }
        d1.h.showAsDropDown(sVar, getAnchorView(), this.f1473q, this.f1474r, this.f1479w);
        this.f1470n.setSelection(-1);
        if (!this.J || this.f1470n.isInTouchMode()) {
            clearListSelection();
        }
        if (this.J) {
            return;
        }
        this.G.post(this.F);
    }

    public o0(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public o0(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f1471o = -2;
        this.f1472p = -2;
        this.f1475s = 1002;
        this.f1479w = 0;
        this.f1480x = Integer.MAX_VALUE;
        this.C = new g();
        this.D = new f();
        this.E = new e();
        this.F = new c();
        this.H = new Rect();
        this.f1468b = context;
        this.G = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ListPopupWindow, i10, i11);
        this.f1473q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f1474r = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1476t = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        s sVar = new s(context, attributeSet, i10, i11);
        this.K = sVar;
        sVar.setInputMethodMode(1);
    }

    public void setPromptPosition(int i10) {
    }

    /* compiled from: ListPopupWindow.java */
    public class e implements AbsListView.OnScrollListener {
        public e() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (i10 == 1) {
                o0 o0Var = o0.this;
                if (o0Var.isInputMethodNotNeeded() || o0Var.K.getContentView() == null) {
                    return;
                }
                Handler handler = o0Var.G;
                g gVar = o0Var.C;
                handler.removeCallbacks(gVar);
                gVar.run();
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
