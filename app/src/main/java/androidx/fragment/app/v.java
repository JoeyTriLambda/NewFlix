package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import java.lang.reflect.InvocationTargetException;

/* compiled from: FragmentLayoutInflaterFactory.java */
/* loaded from: classes.dex */
public final class v implements LayoutInflater.Factory2 {

    /* renamed from: b, reason: collision with root package name */
    public final y f2931b;

    public v(y yVar) {
        this.f2931b = yVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean zIsAssignableFrom;
        e0 e0VarF;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        y yVar = this.f2931b;
        if (zEquals) {
            return new FragmentContainerView(context, attributeSet, yVar);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = Fragment.class.isAssignableFrom(t.a(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id2 = view != null ? view.getId() : 0;
                if (id2 == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment fragmentFindFragmentById = resourceId != -1 ? yVar.findFragmentById(resourceId) : null;
                if (fragmentFindFragmentById == null && string != null) {
                    fragmentFindFragmentById = yVar.findFragmentByTag(string);
                }
                if (fragmentFindFragmentById == null && id2 != -1) {
                    fragmentFindFragmentById = yVar.findFragmentById(id2);
                }
                if (fragmentFindFragmentById == null) {
                    fragmentFindFragmentById = yVar.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
                    fragmentFindFragmentById.f2687y = true;
                    fragmentFindFragmentById.H = resourceId != 0 ? resourceId : id2;
                    fragmentFindFragmentById.I = id2;
                    fragmentFindFragmentById.J = string;
                    fragmentFindFragmentById.f2688z = true;
                    fragmentFindFragmentById.D = yVar;
                    fragmentFindFragmentById.E = yVar.getHost();
                    fragmentFindFragmentById.onInflate(yVar.getHost().f2928m, attributeSet, fragmentFindFragmentById.f2675m);
                    e0VarF = yVar.a(fragmentFindFragmentById);
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Fragment " + fragmentFindFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    if (fragmentFindFragmentById.f2688z) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                    }
                    fragmentFindFragmentById.f2688z = true;
                    fragmentFindFragmentById.D = yVar;
                    fragmentFindFragmentById.E = yVar.getHost();
                    fragmentFindFragmentById.onInflate(yVar.getHost().f2928m, attributeSet, fragmentFindFragmentById.f2675m);
                    e0VarF = yVar.f(fragmentFindFragmentById);
                    if (y.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Retained Fragment " + fragmentFindFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                }
                ViewGroup viewGroup = (ViewGroup) view;
                FragmentStrictMode.onFragmentTagUsage(fragmentFindFragmentById, viewGroup);
                fragmentFindFragmentById.R = viewGroup;
                e0VarF.k();
                e0VarF.j();
                View view2 = fragmentFindFragmentById.S;
                if (view2 == null) {
                    throw new IllegalStateException(ac.c.k("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (fragmentFindFragmentById.S.getTag() == null) {
                    fragmentFindFragmentById.S.setTag(string);
                }
                fragmentFindFragmentById.S.addOnAttachStateChangeListener(new a(e0VarF));
                return fragmentFindFragmentById.S;
            }
        }
        return null;
    }

    /* compiled from: FragmentLayoutInflaterFactory.java */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e0 f2932b;

        public a(e0 e0Var) {
            this.f2932b = e0Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            e0 e0Var = this.f2932b;
            Fragment fragment = e0Var.f2794c;
            e0Var.k();
            SpecialEffectsController.f((ViewGroup) fragment.S.getParent(), v.this.f2931b).e();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
