package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.fragment.R;
import java.util.ArrayList;
import java.util.Iterator;
import x0.y0;

/* compiled from: FragmentContainerView.kt */
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2705b;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f2706m;

    /* renamed from: n, reason: collision with root package name */
    public View.OnApplyWindowInsetsListener f2707n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2708o;

    /* compiled from: FragmentContainerView.kt */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f2709a = new a();

        public final WindowInsets onApplyWindowInsets(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener, View view, WindowInsets windowInsets) {
            zf.i.checkNotNullParameter(onApplyWindowInsetsListener, "onApplyWindowInsetsListener");
            zf.i.checkNotNullParameter(view, "v");
            zf.i.checkNotNullParameter(windowInsets, "insets");
            WindowInsets windowInsetsOnApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            zf.i.checkNotNullExpressionValue(windowInsetsOnApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            return windowInsetsOnApplyWindowInsets;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        zf.i.checkNotNullParameter(context, "context");
    }

    public final void a(View view) {
        if (this.f2706m.contains(view)) {
            this.f2705b.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        zf.i.checkNotNullParameter(view, "child");
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof Fragment ? (Fragment) tag : null) != null) {
            super.addView(view, i10, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        y0 y0VarOnApplyWindowInsets;
        zf.i.checkNotNullParameter(windowInsets, "insets");
        y0 windowInsetsCompat = y0.toWindowInsetsCompat(windowInsets);
        zf.i.checkNotNullExpressionValue(windowInsetsCompat, "toWindowInsetsCompat(insets)");
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f2707n;
        if (onApplyWindowInsetsListener != null) {
            a aVar = a.f2709a;
            zf.i.checkNotNull(onApplyWindowInsetsListener);
            y0VarOnApplyWindowInsets = y0.toWindowInsetsCompat(aVar.onApplyWindowInsets(onApplyWindowInsetsListener, this, windowInsets));
        } else {
            y0VarOnApplyWindowInsets = x0.j0.onApplyWindowInsets(this, windowInsetsCompat);
        }
        zf.i.checkNotNullExpressionValue(y0VarOnApplyWindowInsets, "if (applyWindowInsetsLis…, insetsCompat)\n        }");
        if (!y0VarOnApplyWindowInsets.isConsumed()) {
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                x0.j0.dispatchApplyWindowInsets(getChildAt(i10), y0VarOnApplyWindowInsets);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        zf.i.checkNotNullParameter(canvas, "canvas");
        if (this.f2708o) {
            Iterator it = this.f2705b.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j10) {
        zf.i.checkNotNullParameter(canvas, "canvas");
        zf.i.checkNotNullParameter(view, "child");
        if (this.f2708o) {
            ArrayList arrayList = this.f2705b;
            if ((!arrayList.isEmpty()) && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j10);
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view) {
        zf.i.checkNotNullParameter(view, "view");
        this.f2706m.remove(view);
        if (this.f2705b.remove(view)) {
            this.f2708o = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends Fragment> F getFragment() {
        p pVar;
        Fragment fragment;
        y supportFragmentManager;
        View view = this;
        while (true) {
            pVar = null;
            if (view == null) {
                fragment = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            fragment = tag instanceof Fragment ? (Fragment) tag : null;
            if (fragment != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (fragment == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof p) {
                    pVar = (p) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (pVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = pVar.getSupportFragmentManager();
        } else {
            if (!fragment.isAdded()) {
                throw new IllegalStateException("The Fragment " + fragment + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            supportFragmentManager = fragment.getChildFragmentManager();
        }
        return (F) supportFragmentManager.findFragmentById(getId());
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        zf.i.checkNotNullParameter(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                zf.i.checkNotNullExpressionValue(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        zf.i.checkNotNullParameter(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i10) {
        View childAt = getChildAt(i10);
        zf.i.checkNotNullExpressionValue(childAt, "view");
        a(childAt);
        super.removeViewAt(i10);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        zf.i.checkNotNullParameter(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            zf.i.checkNotNullExpressionValue(childAt, "view");
            a(childAt);
        }
        super.removeViews(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i10, int i11) {
        int i12 = i10 + i11;
        for (int i13 = i10; i13 < i12; i13++) {
            View childAt = getChildAt(i13);
            zf.i.checkNotNullExpressionValue(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i10, i11);
    }

    public final void setDrawDisappearingViewsLast(boolean z10) {
        this.f2708o = z10;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        zf.i.checkNotNullParameter(onApplyWindowInsetsListener, "listener");
        this.f2707n = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view) {
        zf.i.checkNotNullParameter(view, "view");
        if (view.getParent() == this) {
            this.f2706m.add(view);
        }
        super.startViewTransition(view);
    }

    public /* synthetic */ FragmentContainerView(Context context, AttributeSet attributeSet, int i10, int i11, zf.f fVar) {
        this(context, attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i10) {
        String str;
        super(context, attributeSet, i10);
        zf.i.checkNotNullParameter(context, "context");
        this.f2705b = new ArrayList();
        this.f2706m = new ArrayList();
        this.f2708o = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            int[] iArr = R.styleable.FragmentContainerView;
            zf.i.checkNotNullExpressionValue(iArr, "FragmentContainerView");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name);
                str = "android:name";
            } else {
                str = "class";
            }
            typedArrayObtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, y yVar) {
        View view;
        super(context, attributeSet);
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(attributeSet, "attrs");
        zf.i.checkNotNullParameter(yVar, "fm");
        this.f2705b = new ArrayList();
        this.f2706m = new ArrayList();
        this.f2708o = true;
        String classAttribute = attributeSet.getClassAttribute();
        int[] iArr = R.styleable.FragmentContainerView;
        zf.i.checkNotNullExpressionValue(iArr, "FragmentContainerView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        classAttribute = classAttribute == null ? typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        int id2 = getId();
        Fragment fragmentFindFragmentById = yVar.findFragmentById(id2);
        if (classAttribute != null && fragmentFindFragmentById == null) {
            if (id2 == -1) {
                throw new IllegalStateException(ac.c.k("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            Fragment fragmentInstantiate = yVar.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            zf.i.checkNotNullExpressionValue(fragmentInstantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            fragmentInstantiate.onInflate(context, attributeSet, (Bundle) null);
            g0 reorderingAllowed = yVar.beginTransaction().setReorderingAllowed(true);
            reorderingAllowed.getClass();
            fragmentInstantiate.R = this;
            reorderingAllowed.add(getId(), fragmentInstantiate, string).commitNowAllowingStateLoss();
        }
        Iterator it = yVar.f2940c.e().iterator();
        while (it.hasNext()) {
            e0 e0Var = (e0) it.next();
            Fragment fragment = e0Var.f2794c;
            if (fragment.I == getId() && (view = fragment.S) != null && view.getParent() == null) {
                fragment.R = this;
                e0Var.b();
            }
        }
    }
}
