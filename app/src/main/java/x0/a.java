package x0;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import java.util.Collections;
import java.util.List;
import y0.d;

/* compiled from: AccessibilityDelegateCompat.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f21216c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f21217a;

    /* renamed from: b, reason: collision with root package name */
    public final C0309a f21218b;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: x0.a$a, reason: collision with other inner class name */
    public static final class C0309a extends View.AccessibilityDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final a f21219a;

        public C0309a(a aVar) {
            this.f21219a = aVar;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f21219a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            y0.e accessibilityNodeProvider = this.f21219a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.getProvider();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f21219a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            y0.d dVarWrap = y0.d.wrap(accessibilityNodeInfo);
            dVarWrap.setScreenReaderFocusable(j0.isScreenReaderFocusable(view));
            dVarWrap.setHeading(j0.isAccessibilityHeading(view));
            dVarWrap.setPaneTitle(j0.getAccessibilityPaneTitle(view));
            dVarWrap.setStateDescription(j0.getStateDescription(view));
            this.f21219a.onInitializeAccessibilityNodeInfo(view, dVarWrap);
            dVarWrap.addSpansToExtras(accessibilityNodeInfo.getText(), view);
            List listEmptyList = (List) view.getTag(R.id.tag_accessibility_actions);
            if (listEmptyList == null) {
                listEmptyList = Collections.emptyList();
            }
            for (int i10 = 0; i10 < listEmptyList.size(); i10++) {
                dVarWrap.addAction((d.a) listEmptyList.get(i10));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f21219a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f21219a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            return this.f21219a.performAccessibilityAction(view, i10, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i10) {
            this.f21219a.sendAccessibilityEvent(view, i10);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f21219a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public a() {
        this(f21216c);
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.f21217a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public y0.e getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f21217a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new y0.e(accessibilityNodeProvider);
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f21217a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        this.f21217a.onInitializeAccessibilityNodeInfo(view, dVar.unwrap());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f21217a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f21217a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityAction(android.view.View r6, int r7, android.os.Bundle r8) {
        /*
            r5 = this;
            int r0 = androidx.core.R.id.tag_accessibility_actions
            java.lang.Object r0 = r6.getTag(r0)
            java.util.List r0 = (java.util.List) r0
            if (r0 != 0) goto Le
            java.util.List r0 = java.util.Collections.emptyList()
        Le:
            r1 = 0
            r2 = 0
        L10:
            int r3 = r0.size()
            if (r2 >= r3) goto L2a
            java.lang.Object r3 = r0.get(r2)
            y0.d$a r3 = (y0.d.a) r3
            int r4 = r3.getId()
            if (r4 != r7) goto L27
            boolean r0 = r3.perform(r6, r8)
            goto L2b
        L27:
            int r2 = r2 + 1
            goto L10
        L2a:
            r0 = 0
        L2b:
            if (r0 != 0) goto L33
            android.view.View$AccessibilityDelegate r0 = r5.f21217a
            boolean r0 = r0.performAccessibilityAction(r6, r7, r8)
        L33:
            if (r0 != 0) goto L84
            int r2 = androidx.core.R.id.accessibility_action_clickable_span
            if (r7 != r2) goto L84
            if (r8 == 0) goto L84
            java.lang.String r7 = "ACCESSIBILITY_CLICKABLE_SPAN_ID"
            r0 = -1
            int r7 = r8.getInt(r7, r0)
            int r8 = androidx.core.R.id.tag_accessibility_clickable_spans
            java.lang.Object r8 = r6.getTag(r8)
            android.util.SparseArray r8 = (android.util.SparseArray) r8
            if (r8 == 0) goto L83
            java.lang.Object r7 = r8.get(r7)
            java.lang.ref.WeakReference r7 = (java.lang.ref.WeakReference) r7
            if (r7 == 0) goto L83
            java.lang.Object r7 = r7.get()
            android.text.style.ClickableSpan r7 = (android.text.style.ClickableSpan) r7
            r8 = 1
            if (r7 == 0) goto L7c
            android.view.accessibility.AccessibilityNodeInfo r0 = r6.createAccessibilityNodeInfo()
            java.lang.CharSequence r0 = r0.getText()
            android.text.style.ClickableSpan[] r0 = y0.d.getClickableSpans(r0)
            r2 = 0
        L6a:
            if (r0 == 0) goto L7c
            int r3 = r0.length
            if (r2 >= r3) goto L7c
            r3 = r0[r2]
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L79
            r0 = 1
            goto L7d
        L79:
            int r2 = r2 + 1
            goto L6a
        L7c:
            r0 = 0
        L7d:
            if (r0 == 0) goto L83
            r7.onClick(r6)
            r1 = 1
        L83:
            r0 = r1
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x0.a.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public void sendAccessibilityEvent(View view, int i10) {
        this.f21217a.sendAccessibilityEvent(view, i10);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.f21217a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f21217a = accessibilityDelegate;
        this.f21218b = new C0309a(this);
    }
}
