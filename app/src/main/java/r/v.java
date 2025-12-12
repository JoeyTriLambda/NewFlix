package r;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f0;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: AppCompatViewInflater.java */
/* loaded from: classes.dex */
public class v {

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f18330b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f18331c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f18332d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f18333e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f18334f = {R.attr.screenReaderFocusable};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f18335g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h, reason: collision with root package name */
    public static final b0.k<String, Constructor<? extends View>> f18336h = new b0.k<>();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f18337a = new Object[2];

    /* compiled from: AppCompatViewInflater.java */
    public static class a implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final View f18338b;

        /* renamed from: m, reason: collision with root package name */
        public final String f18339m;

        /* renamed from: n, reason: collision with root package name */
        public Method f18340n;

        /* renamed from: o, reason: collision with root package name */
        public Context f18341o;

        public a(View view, String str) {
            this.f18338b = view;
            this.f18339m = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            String str;
            Method method;
            if (this.f18340n == null) {
                View view2 = this.f18338b;
                Context context = view2.getContext();
                while (true) {
                    String str2 = this.f18339m;
                    if (context == null) {
                        int id2 = view2.getId();
                        if (id2 == -1) {
                            str = "";
                        } else {
                            str = " with id '" + view2.getContext().getResources().getResourceEntryName(id2) + "'";
                        }
                        StringBuilder sbV = ac.c.v("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                        sbV.append(view2.getClass());
                        sbV.append(str);
                        throw new IllegalStateException(sbV.toString());
                    }
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f18340n = method;
                            this.f18341o = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
            }
            try {
                this.f18340n.invoke(this.f18341o, view);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    public final View a(Context context, String str, String str2) throws InflateException, NoSuchMethodException, SecurityException, ClassNotFoundException {
        String strConcat;
        b0.k<String, Constructor<? extends View>> kVar = f18336h;
        Constructor<? extends View> constructor = kVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f18330b);
            kVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f18337a);
    }

    public final void b(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public androidx.appcompat.widget.d createAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.d(context, attributeSet);
    }

    public androidx.appcompat.widget.f createButton(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    public androidx.appcompat.widget.g createCheckBox(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.g(context, attributeSet);
    }

    public androidx.appcompat.widget.h createCheckedTextView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.h(context, attributeSet);
    }

    public androidx.appcompat.widget.l createEditText(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.l(context, attributeSet);
    }

    public androidx.appcompat.widget.o createImageButton(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.o(context, attributeSet);
    }

    public androidx.appcompat.widget.q createImageView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.q(context, attributeSet);
    }

    public androidx.appcompat.widget.r createMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    public androidx.appcompat.widget.u createRadioButton(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.u(context, attributeSet);
    }

    public androidx.appcompat.widget.v createRatingBar(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.v(context, attributeSet);
    }

    public androidx.appcompat.widget.x createSeekBar(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.x(context, attributeSet);
    }

    public androidx.appcompat.widget.z createSpinner(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.z(context, attributeSet);
    }

    public AppCompatTextView createTextView(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public f0 createToggleButton(Context context, AttributeSet attributeSet) {
        return new f0(context, attributeSet);
    }

    public View createView(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View createView(android.view.View r3, java.lang.String r4, android.content.Context r5, android.util.AttributeSet r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 672
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: r.v.createView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet, boolean, boolean, boolean, boolean):android.view.View");
    }
}
