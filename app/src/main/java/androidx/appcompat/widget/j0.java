package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
public class j0 extends ListView {

    /* renamed from: b, reason: collision with root package name */
    public final Rect f1395b;

    /* renamed from: m, reason: collision with root package name */
    public int f1396m;

    /* renamed from: n, reason: collision with root package name */
    public int f1397n;

    /* renamed from: o, reason: collision with root package name */
    public int f1398o;

    /* renamed from: p, reason: collision with root package name */
    public int f1399p;

    /* renamed from: q, reason: collision with root package name */
    public int f1400q;

    /* renamed from: r, reason: collision with root package name */
    public d f1401r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1402s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f1403t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1404u;

    /* renamed from: v, reason: collision with root package name */
    public d1.f f1405v;

    /* renamed from: w, reason: collision with root package name */
    public f f1406w;

    /* compiled from: DropDownListView.java */
    public static class a {
        public static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    /* compiled from: DropDownListView.java */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static final Method f1407a;

        /* renamed from: b, reason: collision with root package name */
        public static final Method f1408b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f1409c;

        /* renamed from: d, reason: collision with root package name */
        public static final boolean f1410d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, Boolean.TYPE, cls2, cls2);
                f1407a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1408b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1409c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1410d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* compiled from: DropDownListView.java */
    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    /* compiled from: DropDownListView.java */
    public static class d extends t.c {

        /* renamed from: m, reason: collision with root package name */
        public boolean f1411m;

        public d(Drawable drawable) {
            super(drawable);
            this.f1411m = true;
        }

        @Override // t.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1411m) {
                super.draw(canvas);
            }
        }

        @Override // t.c, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f1411m) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // t.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1411m) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // t.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1411m) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // t.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1411m) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* compiled from: DropDownListView.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static final Field f1412a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                e10.printStackTrace();
            }
            f1412a = declaredField;
        }
    }

    /* compiled from: DropDownListView.java */
    public class f implements Runnable {
        public f() {
        }

        public void cancel() {
            j0 j0Var = j0.this;
            j0Var.f1406w = null;
            j0Var.removeCallbacks(this);
        }

        public void post() {
            j0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            j0 j0Var = j0.this;
            j0Var.f1406w = null;
            j0Var.drawableStateChanged();
        }
    }

    public j0(Context context, boolean z10) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f1395b = new Rect();
        this.f1396m = 0;
        this.f1397n = 0;
        this.f1398o = 0;
        this.f1399p = 0;
        this.f1403t = z10;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z10) {
        d dVar = this.f1401r;
        if (dVar != null) {
            dVar.f1411m = z10;
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f1395b;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f1406w != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        Drawable selector = getSelector();
        if (selector != null && this.f1404u && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1403t || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1403t || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1403t || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1403t && this.f1402s) || super.isInTouchMode();
    }

    public int measureHeightOfChildrenCompat(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i15 < count) {
            int itemViewType = adapter.getItemViewType(i15);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i15, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i18 = layoutParams.height;
            view.measure(i10, i18 > 0 ? View.MeasureSpec.makeMeasureSpec(i18, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i15 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i13) {
                return (i14 < 0 || i15 <= i14 || i17 <= 0 || measuredHeight == i13) ? i13 : i17;
            }
            if (i14 >= 0 && i15 >= i14) {
                i17 = measuredHeight;
            }
            i15++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f1406w = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onForwardedEvent(android.view.MotionEvent r17, int r18) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.j0.onForwardedEvent(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1406w == null) {
            f fVar = new f();
            this.f1406w = fVar;
            fVar.post();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i10 < 30 || !b.f1410d) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            b.f1407a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            b.f1408b.invoke(this, Integer.valueOf(iPointToPosition));
                            b.f1409c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e10) {
                            e10.printStackTrace();
                        } catch (InvocationTargetException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f1404u && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1400q = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        f fVar = this.f1406w;
        if (fVar != null) {
            fVar.cancel();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f1402s = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f1401r = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1396m = rect.left;
        this.f1397n = rect.top;
        this.f1398o = rect.right;
        this.f1399p = rect.bottom;
    }
}
