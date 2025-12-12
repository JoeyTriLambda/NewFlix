package v2;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* compiled from: ApiFeature.java */
/* loaded from: classes.dex */
public abstract class a implements v2.e {

    /* renamed from: c, reason: collision with root package name */
    public static final HashSet f20429c = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final String f20430a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20431b;

    /* compiled from: ApiFeature.java */
    /* renamed from: v2.a$a, reason: collision with other inner class name */
    public static class C0295a {

        /* renamed from: a, reason: collision with root package name */
        public static final HashSet f20432a = new HashSet(Arrays.asList(m.getFactory().getWebViewFeatures()));
    }

    /* compiled from: ApiFeature.java */
    public static class b extends a {
        public b(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 23;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class c extends a {
        public c(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 24;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class d extends a {
        public d(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return false;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class e extends a {
        public e(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class f extends a {
        public f(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class g extends a {
        public g() {
            super("TRACING_CONTROLLER_BASIC_USAGE", "TRACING_CONTROLLER_BASIC_USAGE");
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class h extends a {
        public h(String str, String str2) {
            super(str, str2);
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* compiled from: ApiFeature.java */
    public static class i extends a {
        public i() {
            super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        }

        @Override // v2.a
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }

    public a(String str, String str2) {
        this.f20430a = str;
        this.f20431b = str2;
        f20429c.add(this);
    }

    public static Set<a> values() {
        return Collections.unmodifiableSet(f20429c);
    }

    @Override // v2.e
    public String getPublicFeatureName() {
        return this.f20430a;
    }

    @Override // v2.e
    public boolean isSupported() {
        return isSupportedByFramework() || isSupportedByWebView();
    }

    public abstract boolean isSupportedByFramework();

    public boolean isSupportedByWebView() {
        return BoundaryInterfaceReflectionUtil.containsFeature(C0295a.f20432a, this.f20431b);
    }
}
