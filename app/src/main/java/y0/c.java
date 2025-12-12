package y0;

import android.view.accessibility.AccessibilityManager;

/* compiled from: AccessibilityManagerCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: AccessibilityManagerCompat.java */
    public interface a {
    }

    /* compiled from: AccessibilityManagerCompat.java */
    public static final class b implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public final a f21815a;

        public b(a aVar) {
            this.f21815a = aVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f21815a.equals(((b) obj).f21815a);
            }
            return false;
        }

        public int hashCode() {
            return this.f21815a.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z10) {
            ((c1.c) this.f21815a).c(z10);
        }
    }

    public static boolean addTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new b(aVar));
    }

    public static boolean removeTouchExplorationStateChangeListener(AccessibilityManager accessibilityManager, a aVar) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new b(aVar));
    }
}
