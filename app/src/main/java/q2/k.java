package q2;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewUtils.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final m f17789a;

    /* renamed from: b, reason: collision with root package name */
    public static final a f17790b;

    /* compiled from: ViewUtils.java */
    public class a extends Property<View, Float> {
        public a() {
            super(Float.class, "translationAlpha");
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(k.f17789a.getTransitionAlpha(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f10) {
            k.f17789a.setTransitionAlpha(view, f10.floatValue());
        }
    }

    /* compiled from: ViewUtils.java */
    public class b extends Property<View, Rect> {
        public b() {
            super(Rect.class, "clipBounds");
        }

        @Override // android.util.Property
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f17789a = new p();
        } else if (i10 >= 23) {
            f17789a = new o();
        } else if (i10 >= 22) {
            f17789a = new n();
        } else {
            f17789a = new m();
        }
        f17790b = new a();
        new b();
    }

    public static void a(View view, int i10, int i11, int i12, int i13) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        f17789a.setLeftTopRightBottom(view, i10, i11, i12, i13);
    }

    public static void b(View view, int i10) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        f17789a.setTransitionVisibility(view, i10);
    }
}
