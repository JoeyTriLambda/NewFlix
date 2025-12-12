package androidx.fragment.app.strictmode;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.y;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import mf.q;
import mf.z;
import r.x;
import zf.f;
import zf.i;

/* compiled from: FragmentStrictMode.kt */
/* loaded from: classes.dex */
public final class FragmentStrictMode {

    /* renamed from: a, reason: collision with root package name */
    public static final b f2912a = b.f2922c;

    /* compiled from: FragmentStrictMode.kt */
    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* compiled from: FragmentStrictMode.kt */
    public interface a {
    }

    /* compiled from: FragmentStrictMode.kt */
    public static final class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f2922c;

        /* renamed from: a, reason: collision with root package name */
        public final Set<Flag> f2923a;

        /* renamed from: b, reason: collision with root package name */
        public final LinkedHashMap f2924b;

        /* compiled from: FragmentStrictMode.kt */
        public static final class a {
            public a(f fVar) {
            }
        }

        static {
            new a(null);
            f2922c = new b(z.emptySet(), null, kotlin.collections.a.emptyMap());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends Flag> set, a aVar, Map<String, ? extends Set<Class<? extends Violation>>> map) {
            i.checkNotNullParameter(set, "flags");
            i.checkNotNullParameter(map, "allowedViolations");
            this.f2923a = set;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends Violation>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f2924b = linkedHashMap;
        }

        public final Set<Flag> getFlags$fragment_release() {
            return this.f2923a;
        }

        public final a getListener$fragment_release() {
            return null;
        }

        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.f2924b;
        }
    }

    public static b a(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                y parentFragmentManager = fragment.getParentFragmentManager();
                i.checkNotNullExpressionValue(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.getStrictModePolicy() != null) {
                    b strictModePolicy = parentFragmentManager.getStrictModePolicy();
                    i.checkNotNull(strictModePolicy);
                    return strictModePolicy;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return f2912a;
    }

    public static void b(b bVar, Violation violation) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (bVar.getFlags$fragment_release().contains(Flag.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in ".concat(name), violation);
        }
        bVar.getListener$fragment_release();
        if (bVar.getFlags$fragment_release().contains(Flag.PENALTY_DEATH)) {
            x xVar = new x(3, name, violation);
            if (!fragment.isAdded()) {
                xVar.run();
                return;
            }
            Handler handler = fragment.getParentFragmentManager().getHost().getHandler();
            i.checkNotNullExpressionValue(handler, "fragment.parentFragmentManager.host.handler");
            if (i.areEqual(handler.getLooper(), Looper.myLooper())) {
                xVar.run();
            } else {
                handler.post(xVar);
            }
        }
    }

    public static void c(Violation violation) {
        if (y.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(violation.getFragment().getClass().getName()), violation);
        }
    }

    public static boolean d(b bVar, Class cls, Class cls2) {
        Set<Class<? extends Violation>> set = bVar.getMAllowedViolations$fragment_release().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (i.areEqual(cls2.getSuperclass(), Violation.class) || !q.contains(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }

    public static final void onFragmentReuse(Fragment fragment, String str) {
        i.checkNotNullParameter(fragment, "fragment");
        i.checkNotNullParameter(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        c(fragmentReuseViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) && d(bVarA, fragment.getClass(), FragmentReuseViolation.class)) {
            b(bVarA, fragmentReuseViolation);
        }
    }

    public static final void onFragmentTagUsage(Fragment fragment, ViewGroup viewGroup) throws IllegalAccessException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        c(fragmentTagUsageViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && d(bVarA, fragment.getClass(), FragmentTagUsageViolation.class)) {
            b(bVarA, fragmentTagUsageViolation);
        }
    }

    public static final void onGetRetainInstanceUsage(Fragment fragment) {
        i.checkNotNullParameter(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        c(getRetainInstanceUsageViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && d(bVarA, fragment.getClass(), GetRetainInstanceUsageViolation.class)) {
            b(bVarA, getRetainInstanceUsageViolation);
        }
    }

    public static final void onGetTargetFragmentRequestCodeUsage(Fragment fragment) {
        i.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        c(getTargetFragmentRequestCodeUsageViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && d(bVarA, fragment.getClass(), GetTargetFragmentRequestCodeUsageViolation.class)) {
            b(bVarA, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    public static final void onGetTargetFragmentUsage(Fragment fragment) {
        i.checkNotNullParameter(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        c(getTargetFragmentUsageViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && d(bVarA, fragment.getClass(), GetTargetFragmentUsageViolation.class)) {
            b(bVarA, getTargetFragmentUsageViolation);
        }
    }

    public static final void onSetRetainInstanceUsage(Fragment fragment) {
        i.checkNotNullParameter(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        c(setRetainInstanceUsageViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && d(bVarA, fragment.getClass(), SetRetainInstanceUsageViolation.class)) {
            b(bVarA, setRetainInstanceUsageViolation);
        }
    }

    public static final void onSetUserVisibleHint(Fragment fragment, boolean z10) {
        i.checkNotNullParameter(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z10);
        c(setUserVisibleHintViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && d(bVarA, fragment.getClass(), SetUserVisibleHintViolation.class)) {
            b(bVarA, setUserVisibleHintViolation);
        }
    }

    public static final void onWrongFragmentContainer(Fragment fragment, ViewGroup viewGroup) {
        i.checkNotNullParameter(fragment, "fragment");
        i.checkNotNullParameter(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        c(wrongFragmentContainerViolation);
        b bVarA = a(fragment);
        if (bVarA.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && d(bVarA, fragment.getClass(), WrongFragmentContainerViolation.class)) {
            b(bVarA, wrongFragmentContainerViolation);
        }
    }
}
