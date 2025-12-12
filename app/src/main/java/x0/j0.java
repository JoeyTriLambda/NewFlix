package x0;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.OnReceiveContentListener;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.PathInterpolator;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import x0.a;
import x0.x0;
import x0.y0;
import y0.d;

/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap<View, r0> f21269a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f21270b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f21271c = false;

    /* renamed from: d, reason: collision with root package name */
    public static ThreadLocal<Rect> f21272d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f21273e = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: f, reason: collision with root package name */
    public static final e0 f21274f = new x() { // from class: x0.e0
        @Override // x0.x
        public final c onReceiveContent(c cVar) {
            return cVar;
        }
    };

    /* renamed from: g, reason: collision with root package name */
    public static final a f21275g = new a();

    /* compiled from: ViewCompat.java */
    public static abstract class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final int f21277a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<T> f21278b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21279c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21280d;

        public b(int i10, Class<T> cls, int i11, int i12) {
            this.f21277a = i10;
            this.f21278b = cls;
            this.f21280d = i11;
            this.f21279c = i12;
        }

        public static boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(Object obj, View view);

        public final T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f21279c) {
                return b(view);
            }
            T t10 = (T) view.getTag(this.f21277a);
            if (this.f21278b.isInstance(t10)) {
                return t10;
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(Object obj, View view) {
            if (Build.VERSION.SDK_INT >= this.f21279c) {
                c(obj, view);
                return;
            }
            if (f(d(view), obj)) {
                x0.a accessibilityDelegate = j0.getAccessibilityDelegate(view);
                if (accessibilityDelegate == null) {
                    accessibilityDelegate = new x0.a();
                }
                j0.setAccessibilityDelegate(view, accessibilityDelegate);
                view.setTag(this.f21277a, obj);
                j0.e(view, this.f21280d);
            }
        }

        public abstract boolean f(T t10, T t11);
    }

    /* compiled from: ViewCompat.java */
    public static class c {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* compiled from: ViewCompat.java */
    public static class d {

        /* compiled from: ViewCompat.java */
        public class a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a, reason: collision with root package name */
            public y0 f21281a = null;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ View f21282b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ v f21283c;

            public a(View view, v vVar) {
                this.f21282b = view;
                this.f21283c = vVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                y0 windowInsetsCompat = y0.toWindowInsetsCompat(windowInsets, view);
                int i10 = Build.VERSION.SDK_INT;
                v vVar = this.f21283c;
                if (i10 < 30) {
                    d.a(windowInsets, this.f21282b);
                    if (windowInsetsCompat.equals(this.f21281a)) {
                        return vVar.onApplyWindowInsets(view, windowInsetsCompat).toWindowInsets();
                    }
                }
                this.f21281a = windowInsetsCompat;
                y0 y0VarOnApplyWindowInsets = vVar.onApplyWindowInsets(view, windowInsetsCompat);
                if (i10 >= 30) {
                    return y0VarOnApplyWindowInsets.toWindowInsets();
                }
                j0.requestApplyInsets(view);
                return y0VarOnApplyWindowInsets.toWindowInsets();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static y0 b(View view, y0 y0Var, Rect rect) {
            WindowInsets windowInsets = y0Var.toWindowInsets();
            if (windowInsets != null) {
                return y0.toWindowInsetsCompat(view.computeSystemWindowInsets(windowInsets, rect), view);
            }
            rect.setEmpty();
            return y0Var;
        }

        public static boolean c(View view, float f10, float f11, boolean z10) {
            return view.dispatchNestedFling(f10, f11, z10);
        }

        public static boolean d(View view, float f10, float f11) {
            return view.dispatchNestedPreFling(f10, f11);
        }

        public static boolean e(View view, int i10, int i11, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i10, i11, iArr, iArr2);
        }

        public static boolean f(View view, int i10, int i11, int i12, int i13, int[] iArr) {
            return view.dispatchNestedScroll(i10, i11, i12, i13, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static y0 getRootWindowInsets(View view) {
            return y0.a.getRootWindowInsets(view);
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static String j(View view) {
            return view.getTransitionName();
        }

        public static float k(View view) {
            return view.getTranslationZ();
        }

        public static float l(View view) {
            return view.getZ();
        }

        public static boolean m(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean n(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean o(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void p(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void q(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void r(View view, float f10) {
            view.setElevation(f10);
        }

        public static void s(View view, boolean z10) {
            view.setNestedScrollingEnabled(z10);
        }

        public static void t(View view, v vVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R.id.tag_on_apply_window_listener, vVar);
            }
            if (vVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, vVar));
            }
        }

        public static void u(View view, String str) {
            view.setTransitionName(str);
        }

        public static void v(View view, float f10) {
            view.setTranslationZ(f10);
        }

        public static void w(View view, float f10) {
            view.setZ(f10);
        }

        public static boolean x(View view, int i10) {
            return view.startNestedScroll(i10);
        }

        public static void y(View view) {
            view.stopNestedScroll();
        }
    }

    /* compiled from: ViewCompat.java */
    public static class e {
        public static int a(View view) {
            return view.getScrollIndicators();
        }

        public static void b(View view, int i10) {
            view.setScrollIndicators(i10);
        }

        public static void c(View view, int i10, int i11) {
            view.setScrollIndicators(i10, i11);
        }

        public static y0 getRootWindowInsets(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            y0 windowInsetsCompat = y0.toWindowInsetsCompat(rootWindowInsets);
            windowInsetsCompat.f21341a.p(windowInsetsCompat);
            windowInsetsCompat.f21341a.d(view.getRootView());
            return windowInsetsCompat;
        }
    }

    /* compiled from: ViewCompat.java */
    public static class f {
        public static void a(View view) {
            view.cancelDragAndDrop();
        }

        public static void b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        public static void c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        public static void d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        public static boolean e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i10) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i10);
        }

        public static void f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* compiled from: ViewCompat.java */
    public static class g {
        public static void a(View view, Collection<View> collection, int i10) {
            view.addKeyboardNavigationClusters(collection, i10);
        }

        public static int b(View view) {
            return view.getImportantForAutofill();
        }

        public static int c(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }

        public static View h(View view, View view2, int i10) {
            return view.keyboardNavigationClusterSearch(view2, i10);
        }

        public static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        public static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void k(View view, boolean z10) {
            view.setFocusedByDefault(z10);
        }

        public static void l(View view, int i10) {
            view.setImportantForAutofill(i10);
        }

        public static void m(View view, boolean z10) {
            view.setKeyboardNavigationCluster(z10);
        }

        public static void n(View view, int i10) {
            view.setNextClusterForwardId(i10);
        }

        public static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* compiled from: ViewCompat.java */
    public static class h {
        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, x0.l0] */
        public static void a(View view, final m mVar) {
            int i10 = R.id.tag_unhandled_key_listeners;
            b0.k kVar = (b0.k) view.getTag(i10);
            if (kVar == null) {
                kVar = new b0.k();
                view.setTag(i10, kVar);
            }
            Objects.requireNonNull(mVar);
            ?? r02 = new View.OnUnhandledKeyEventListener() { // from class: x0.l0
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return mVar.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            kVar.put(mVar, r02);
            view.addOnUnhandledKeyEventListener(r02);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, m mVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            b0.k kVar = (b0.k) view.getTag(R.id.tag_unhandled_key_listeners);
            if (kVar == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) kVar.get(mVar)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        public static <T> T f(View view, int i10) {
            return (T) view.requireViewById(i10);
        }

        public static void g(View view, boolean z10) {
            view.setAccessibilityHeading(z10);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, boolean z10) {
            view.setScreenReaderFocusable(z10);
        }

        public static void setAutofillId(View view, a1.a aVar) {
            view.setAutofillId(null);
        }
    }

    /* compiled from: ViewCompat.java */
    public static class i {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static ContentCaptureSession b(View view) {
            return view.getContentCaptureSession();
        }

        public static List<Rect> c(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void d(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i10, i11);
        }

        public static void e(View view, b1.a aVar) {
            view.setContentCaptureSession(null);
        }

        public static void f(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* compiled from: ViewCompat.java */
    public static class j {
        public static int a(View view) {
            return view.getImportantForContentCapture();
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static boolean c(View view) {
            return view.isImportantForContentCapture();
        }

        public static void d(View view, int i10) {
            view.setImportantForContentCapture(i10);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }

        public static a1 getWindowInsetsController(View view) {
            WindowInsetsController windowInsetsController = view.getWindowInsetsController();
            if (windowInsetsController != null) {
                return a1.toWindowInsetsControllerCompat(windowInsetsController);
            }
            return null;
        }
    }

    /* compiled from: ViewCompat.java */
    public static final class k {
        public static String[] getReceiveContentMimeTypes(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static x0.c performReceiveContent(View view, x0.c cVar) {
            ContentInfo contentInfo = cVar.toContentInfo();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfo);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfo ? cVar : x0.c.toContentInfoCompat(contentInfoPerformReceiveContent);
        }

        public static void setOnReceiveContentListener(View view, String[] strArr, w wVar) {
            if (wVar == null) {
                view.setOnReceiveContentListener(strArr, null);
            } else {
                view.setOnReceiveContentListener(strArr, new l(wVar));
            }
        }
    }

    /* compiled from: ViewCompat.java */
    public static final class l implements OnReceiveContentListener {

        /* renamed from: a, reason: collision with root package name */
        public final w f21284a;

        public l(w wVar) {
            this.f21284a = wVar;
        }

        @Override // android.view.OnReceiveContentListener
        public ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
            x0.c contentInfoCompat = x0.c.toContentInfoCompat(contentInfo);
            x0.c cVarOnReceiveContent = this.f21284a.onReceiveContent(view, contentInfoCompat);
            if (cVarOnReceiveContent == null) {
                return null;
            }
            return cVarOnReceiveContent == contentInfoCompat ? contentInfo : cVarOnReceiveContent.toContentInfo();
        }
    }

    /* compiled from: ViewCompat.java */
    public interface m {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* compiled from: ViewCompat.java */
    public static class n {

        /* renamed from: d, reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f21285d = new ArrayList<>();

        /* renamed from: a, reason: collision with root package name */
        public WeakHashMap<View, Boolean> f21286a = null;

        /* renamed from: b, reason: collision with root package name */
        public SparseArray<WeakReference<View>> f21287b = null;

        /* renamed from: c, reason: collision with root package name */
        public WeakReference<KeyEvent> f21288c = null;

        public static boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((m) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }

        public final View a(View view, KeyEvent keyEvent) {
            View viewA;
            WeakHashMap<View, Boolean> weakHashMap = this.f21286a;
            if (weakHashMap == null || !weakHashMap.containsKey(view)) {
                return null;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                do {
                    childCount--;
                    if (childCount >= 0) {
                        viewA = a(viewGroup.getChildAt(childCount), keyEvent);
                    }
                } while (viewA == null);
                return viewA;
            }
            if (b(view, keyEvent)) {
                return view;
            }
            return null;
        }
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = n.f21285d;
        int i10 = R.id.tag_unhandled_key_event_manager;
        n nVar = (n) view.getTag(i10);
        if (nVar == null) {
            nVar = new n();
            view.setTag(i10, nVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = nVar.f21286a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = n.f21285d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (nVar.f21286a == null) {
                        nVar.f21286a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = n.f21285d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            nVar.f21286a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                nVar.f21286a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View viewA = nVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (viewA != null && !KeyEvent.isModifierKey(keyCode)) {
                if (nVar.f21287b == null) {
                    nVar.f21287b = new SparseArray<>();
                }
                nVar.f21287b.put(keyCode, new WeakReference<>(viewA));
            }
        }
        return viewA != null;
    }

    public static int addAccessibilityAction(View view, CharSequence charSequence, y0.g gVar) {
        int id2;
        ArrayList arrayListC = c(view);
        int i10 = 0;
        while (true) {
            if (i10 >= arrayListC.size()) {
                int i11 = -1;
                for (int i12 = 0; i12 < 32 && i11 == -1; i12++) {
                    int i13 = f21273e[i12];
                    boolean z10 = true;
                    for (int i14 = 0; i14 < arrayListC.size(); i14++) {
                        z10 &= ((d.a) arrayListC.get(i14)).getId() != i13;
                    }
                    if (z10) {
                        i11 = i13;
                    }
                }
                id2 = i11;
            } else {
                if (TextUtils.equals(charSequence, ((d.a) arrayListC.get(i10)).getLabel())) {
                    id2 = ((d.a) arrayListC.get(i10)).getId();
                    break;
                }
                i10++;
            }
        }
        if (id2 != -1) {
            d.a aVar = new d.a(id2, charSequence, gVar);
            x0.a accessibilityDelegate = getAccessibilityDelegate(view);
            if (accessibilityDelegate == null) {
                accessibilityDelegate = new x0.a();
            }
            setAccessibilityDelegate(view, accessibilityDelegate);
            f(view, aVar.getId());
            c(view).add(aVar);
            e(view, 0);
        }
        return id2;
    }

    @Deprecated
    public static r0 animate(View view) {
        if (f21269a == null) {
            f21269a = new WeakHashMap<>();
        }
        r0 r0Var = f21269a.get(view);
        if (r0Var != null) {
            return r0Var;
        }
        r0 r0Var2 = new r0(view);
        f21269a.put(view, r0Var2);
        return r0Var2;
    }

    public static View.AccessibilityDelegate b(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return i.a(view);
        }
        if (f21271c) {
            return null;
        }
        if (f21270b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f21270b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f21271c = true;
                return null;
            }
        }
        try {
            Object obj = f21270b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f21271c = true;
            return null;
        }
    }

    public static ArrayList c(View view) {
        int i10 = R.id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i10);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i10, arrayList2);
        return arrayList2;
    }

    public static y0 computeSystemWindowInsets(View view, y0 y0Var, Rect rect) {
        return d.b(view, y0Var, rect);
    }

    public static Rect d() {
        if (f21272d == null) {
            f21272d = new ThreadLocal<>();
        }
        Rect rect = f21272d.get();
        if (rect == null) {
            rect = new Rect();
            f21272d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static y0 dispatchApplyWindowInsets(View view, y0 y0Var) {
        WindowInsets windowInsets = y0Var.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsA = c.a(view, windowInsets);
            if (!windowInsetsA.equals(windowInsets)) {
                return y0.toWindowInsetsCompat(windowInsetsA, view);
            }
        }
        return y0Var;
    }

    public static void e(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = getAccessibilityPaneTitle(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z10 ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i10);
                if (z10) {
                    accessibilityEventObtain.getText().add(getAccessibilityPaneTitle(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i10 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                        return;
                    } catch (AbstractMethodError e10) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i10);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(getAccessibilityPaneTitle(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void f(View view, int i10) {
        ArrayList arrayListC = c(view);
        for (int i11 = 0; i11 < arrayListC.size(); i11++) {
            if (((d.a) arrayListC.get(i11)).getId() == i10) {
                arrayListC.remove(i11);
                return;
            }
        }
    }

    public static void g(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    @Deprecated
    public static int generateViewId() {
        return View.generateViewId();
    }

    public static x0.a getAccessibilityDelegate(View view) {
        View.AccessibilityDelegate accessibilityDelegateB = b(view);
        if (accessibilityDelegateB == null) {
            return null;
        }
        return accessibilityDelegateB instanceof a.C0309a ? ((a.C0309a) accessibilityDelegateB).f21219a : new x0.a(accessibilityDelegateB);
    }

    public static CharSequence getAccessibilityPaneTitle(View view) {
        Object tag;
        int i10 = R.id.tag_accessibility_pane_title;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = h.b(view);
        } else {
            tag = view.getTag(i10);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ColorStateList getBackgroundTintList(View view) {
        return d.g(view);
    }

    public static PorterDuff.Mode getBackgroundTintMode(View view) {
        return d.h(view);
    }

    @Deprecated
    public static Display getDisplay(View view) {
        return view.getDisplay();
    }

    public static float getElevation(View view) {
        return d.i(view);
    }

    @Deprecated
    public static boolean getFitsSystemWindows(View view) {
        return view.getFitsSystemWindows();
    }

    @Deprecated
    public static int getImportantForAccessibility(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int getImportantForAutofill(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return g.b(view);
        }
        return 0;
    }

    @Deprecated
    public static int getLayoutDirection(View view) {
        return view.getLayoutDirection();
    }

    @Deprecated
    public static int getMinimumHeight(View view) {
        return view.getMinimumHeight();
    }

    @Deprecated
    public static int getMinimumWidth(View view) {
        return view.getMinimumWidth();
    }

    public static String[] getOnReceiveContentMimeTypes(View view) {
        return Build.VERSION.SDK_INT >= 31 ? k.getReceiveContentMimeTypes(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    @Deprecated
    public static int getPaddingEnd(View view) {
        return view.getPaddingEnd();
    }

    @Deprecated
    public static int getPaddingStart(View view) {
        return view.getPaddingStart();
    }

    @Deprecated
    public static ViewParent getParentForAccessibility(View view) {
        return view.getParentForAccessibility();
    }

    public static y0 getRootWindowInsets(View view) {
        return Build.VERSION.SDK_INT >= 23 ? e.getRootWindowInsets(view) : d.getRootWindowInsets(view);
    }

    public static CharSequence getStateDescription(View view) {
        Object tag;
        int i10 = R.id.tag_state_description;
        if (Build.VERSION.SDK_INT >= 30) {
            tag = j.b(view);
        } else {
            tag = view.getTag(i10);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static String getTransitionName(View view) {
        return d.j(view);
    }

    @Deprecated
    public static a1 getWindowInsetsController(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            return j.getWindowInsetsController(view);
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Window window = ((Activity) context).getWindow();
                if (window != null) {
                    return w0.getInsetsController(window, view);
                }
                return null;
            }
        }
        return null;
    }

    @Deprecated
    public static int getWindowSystemUiVisibility(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float getZ(View view) {
        return d.l(view);
    }

    public static boolean hasAccessibilityDelegate(View view) {
        return b(view) != null;
    }

    @Deprecated
    public static boolean hasOnClickListeners(View view) {
        return view.hasOnClickListeners();
    }

    @Deprecated
    public static boolean hasTransientState(View view) {
        return view.hasTransientState();
    }

    public static boolean isAccessibilityHeading(View view) {
        Object tag;
        int i10 = R.id.tag_accessibility_heading;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(h.c(view));
        } else {
            tag = view.getTag(i10);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        return bool != null && bool.booleanValue();
    }

    @Deprecated
    public static boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }

    @Deprecated
    public static boolean isLaidOut(View view) {
        return view.isLaidOut();
    }

    public static boolean isNestedScrollingEnabled(View view) {
        return d.o(view);
    }

    @Deprecated
    public static boolean isPaddingRelative(View view) {
        return view.isPaddingRelative();
    }

    public static boolean isScreenReaderFocusable(View view) {
        Object tag;
        int i10 = R.id.tag_screen_reader_focusable;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = Boolean.valueOf(h.d(view));
        } else {
            tag = view.getTag(i10);
            if (!Boolean.class.isInstance(tag)) {
                tag = null;
            }
        }
        Boolean bool = (Boolean) tag;
        return bool != null && bool.booleanValue();
    }

    public static void offsetLeftAndRight(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i10);
            return;
        }
        Rect rectD = d();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectD.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectD.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            g(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                g((View) parent2);
            }
        }
        if (z10 && rectD.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectD);
        }
    }

    public static void offsetTopAndBottom(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i10);
            return;
        }
        Rect rectD = d();
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            rectD.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !rectD.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            g(view);
            Object parent2 = view.getParent();
            if (parent2 instanceof View) {
                g((View) parent2);
            }
        }
        if (z10 && rectD.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(rectD);
        }
    }

    public static y0 onApplyWindowInsets(View view, y0 y0Var) {
        WindowInsets windowInsets = y0Var.toWindowInsets();
        if (windowInsets != null) {
            WindowInsets windowInsetsB = c.b(view, windowInsets);
            if (!windowInsetsB.equals(windowInsets)) {
                return y0.toWindowInsetsCompat(windowInsetsB, view);
            }
        }
        return y0Var;
    }

    @Deprecated
    public static void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        view.onInitializeAccessibilityNodeInfo(dVar.unwrap());
    }

    @Deprecated
    public static boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        return view.performAccessibilityAction(i10, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static x0.c performReceiveContent(View view, x0.c cVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + cVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return k.performReceiveContent(view, cVar);
        }
        w wVar = (w) view.getTag(R.id.tag_on_receive_content_listener);
        x xVar = f21274f;
        if (wVar == null) {
            if (view instanceof x) {
                xVar = (x) view;
            }
            return xVar.onReceiveContent(cVar);
        }
        x0.c cVarOnReceiveContent = wVar.onReceiveContent(view, cVar);
        if (cVarOnReceiveContent == null) {
            return null;
        }
        if (view instanceof x) {
            xVar = (x) view;
        }
        return xVar.onReceiveContent(cVarOnReceiveContent);
    }

    @Deprecated
    public static void postInvalidateOnAnimation(View view) {
        view.postInvalidateOnAnimation();
    }

    @Deprecated
    public static void postOnAnimation(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @SuppressLint({"LambdaLast"})
    @Deprecated
    public static void postOnAnimationDelayed(View view, Runnable runnable, long j10) {
        view.postOnAnimationDelayed(runnable, j10);
    }

    public static void removeAccessibilityAction(View view, int i10) {
        f(view, i10);
        e(view, 0);
    }

    public static void replaceAccessibilityAction(View view, d.a aVar, CharSequence charSequence, y0.g gVar) {
        if (gVar == null && charSequence == null) {
            removeAccessibilityAction(view, aVar.getId());
            return;
        }
        d.a aVarCreateReplacementAction = aVar.createReplacementAction(charSequence, gVar);
        x0.a accessibilityDelegate = getAccessibilityDelegate(view);
        if (accessibilityDelegate == null) {
            accessibilityDelegate = new x0.a();
        }
        setAccessibilityDelegate(view, accessibilityDelegate);
        f(view, aVarCreateReplacementAction.getId());
        c(view).add(aVarCreateReplacementAction);
        e(view, 0);
    }

    public static void requestApplyInsets(View view) {
        c.c(view);
    }

    public static void saveAttributeDataForStyleable(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            i.d(view, context, iArr, attributeSet, typedArray, i10, i11);
        }
    }

    public static void setAccessibilityDelegate(View view, x0.a aVar) {
        if (aVar == null && (b(view) instanceof a.C0309a)) {
            aVar = new x0.a();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f21218b);
    }

    public static void setAccessibilityHeading(View view, boolean z10) {
        new i0(R.id.tag_accessibility_heading).e(Boolean.valueOf(z10), view);
    }

    @Deprecated
    public static void setAccessibilityLiveRegion(View view, int i10) {
        view.setAccessibilityLiveRegion(i10);
    }

    public static void setAccessibilityPaneTitle(View view, CharSequence charSequence) {
        new g0(R.id.tag_accessibility_pane_title).e(charSequence, view);
        a aVar = f21275g;
        if (charSequence == null) {
            aVar.f21276b.remove(view);
            view.removeOnAttachStateChangeListener(aVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(aVar);
        } else {
            aVar.f21276b.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(aVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(aVar);
            }
        }
    }

    @Deprecated
    public static void setBackground(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void setBackgroundTintList(View view, ColorStateList colorStateList) {
        int i10 = Build.VERSION.SDK_INT;
        d.p(view, colorStateList);
        if (i10 == 21) {
            Drawable background = view.getBackground();
            boolean z10 = (d.g(view) == null && d.h(view) == null) ? false : true;
            if (background == null || !z10) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    public static void setBackgroundTintMode(View view, PorterDuff.Mode mode) {
        int i10 = Build.VERSION.SDK_INT;
        d.q(view, mode);
        if (i10 == 21) {
            Drawable background = view.getBackground();
            boolean z10 = (d.g(view) == null && d.h(view) == null) ? false : true;
            if (background == null || !z10) {
                return;
            }
            if (background.isStateful()) {
                background.setState(view.getDrawableState());
            }
            view.setBackground(background);
        }
    }

    @Deprecated
    public static void setClipBounds(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void setElevation(View view, float f10) {
        d.r(view, f10);
    }

    @Deprecated
    public static void setFitsSystemWindows(View view, boolean z10) {
        view.setFitsSystemWindows(z10);
    }

    @Deprecated
    public static void setImportantForAccessibility(View view, int i10) {
        view.setImportantForAccessibility(i10);
    }

    public static void setImportantForAutofill(View view, int i10) {
        if (Build.VERSION.SDK_INT >= 26) {
            g.l(view, i10);
        }
    }

    @Deprecated
    public static void setLabelFor(View view, int i10) {
        view.setLabelFor(i10);
    }

    public static void setOnApplyWindowInsetsListener(View view, v vVar) {
        d.t(view, vVar);
    }

    @Deprecated
    public static void setPaddingRelative(View view, int i10, int i11, int i12, int i13) {
        view.setPaddingRelative(i10, i11, i12, i13);
    }

    public static void setPointerIcon(View view, z zVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            f.d(view, (PointerIcon) (zVar != null ? zVar.getPointerIcon() : null));
        }
    }

    public static void setScreenReaderFocusable(View view, boolean z10) {
        new f0(R.id.tag_screen_reader_focusable).e(Boolean.valueOf(z10), view);
    }

    public static void setScrollIndicators(View view, int i10, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            e.c(view, i10, i11);
        }
    }

    public static void setStateDescription(View view, CharSequence charSequence) {
        new h0(R.id.tag_state_description).e(charSequence, view);
    }

    public static void setTransitionName(View view, String str) {
        d.u(view, str);
    }

    public static void setWindowInsetsAnimationCallback(View view, x0.b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            x0.d.setCallback(view, bVar);
            return;
        }
        PathInterpolator pathInterpolator = x0.c.f21312e;
        Object tag = view.getTag(R.id.tag_on_apply_window_listener);
        if (bVar == null) {
            view.setTag(R.id.tag_window_insets_animation_callback, null);
            if (tag == null) {
                view.setOnApplyWindowInsetsListener(null);
                return;
            }
            return;
        }
        View.OnApplyWindowInsetsListener aVar = new x0.c.a(view, bVar);
        view.setTag(R.id.tag_window_insets_animation_callback, aVar);
        if (tag == null) {
            view.setOnApplyWindowInsetsListener(aVar);
        }
    }

    public static void setZ(View view, float f10) {
        d.w(view, f10);
    }

    public static void stopNestedScroll(View view) {
        d.y(view);
    }

    /* compiled from: ViewCompat.java */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final WeakHashMap<View, Boolean> f21276b = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.f21276b.entrySet()) {
                    View key = entry.getKey();
                    boolean zBooleanValue = entry.getValue().booleanValue();
                    boolean z10 = key.isShown() && key.getWindowVisibility() == 0;
                    if (zBooleanValue != z10) {
                        j0.e(key, z10 ? 16 : 32);
                        entry.setValue(Boolean.valueOf(z10));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }
}
