package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class s extends x0.a {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f4244d;

    /* renamed from: e, reason: collision with root package name */
    public final a f4245e;

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends x0.a {

        /* renamed from: d, reason: collision with root package name */
        public final s f4246d;

        /* renamed from: e, reason: collision with root package name */
        public final WeakHashMap f4247e = new WeakHashMap();

        public a(s sVar) {
            this.f4246d = sVar;
        }

        @Override // x0.a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            return aVar != null ? aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // x0.a
        public y0.e getAccessibilityNodeProvider(View view) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            return aVar != null ? aVar.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // x0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // x0.a
        public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
            s sVar = this.f4246d;
            if (!sVar.f4244d.hasPendingAdapterUpdates()) {
                RecyclerView recyclerView = sVar.f4244d;
                if (recyclerView.getLayoutManager() != null) {
                    recyclerView.getLayoutManager().c(view, dVar);
                    x0.a aVar = (x0.a) this.f4247e.get(view);
                    if (aVar != null) {
                        aVar.onInitializeAccessibilityNodeInfo(view, dVar);
                        return;
                    } else {
                        super.onInitializeAccessibilityNodeInfo(view, dVar);
                        return;
                    }
                }
            }
            super.onInitializeAccessibilityNodeInfo(view, dVar);
        }

        @Override // x0.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // x0.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            x0.a aVar = (x0.a) this.f4247e.get(viewGroup);
            return aVar != null ? aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // x0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            s sVar = this.f4246d;
            if (!sVar.f4244d.hasPendingAdapterUpdates()) {
                RecyclerView recyclerView = sVar.f4244d;
                if (recyclerView.getLayoutManager() != null) {
                    x0.a aVar = (x0.a) this.f4247e.get(view);
                    if (aVar != null) {
                        if (aVar.performAccessibilityAction(view, i10, bundle)) {
                            return true;
                        }
                    } else if (super.performAccessibilityAction(view, i10, bundle)) {
                        return true;
                    }
                    RecyclerView.l layoutManager = recyclerView.getLayoutManager();
                    RecyclerView recyclerView2 = layoutManager.f3962b;
                    return layoutManager.performAccessibilityActionForItem(recyclerView2.f3916m, recyclerView2.f3927r0, view, i10, bundle);
                }
            }
            return super.performAccessibilityAction(view, i10, bundle);
        }

        @Override // x0.a
        public void sendAccessibilityEvent(View view, int i10) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i10);
            } else {
                super.sendAccessibilityEvent(view, i10);
            }
        }

        @Override // x0.a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            x0.a aVar = (x0.a) this.f4247e.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public s(RecyclerView recyclerView) {
        this.f4244d = recyclerView;
        x0.a itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof a)) {
            this.f4245e = new a(this);
        } else {
            this.f4245e = (a) itemDelegate;
        }
    }

    public x0.a getItemDelegate() {
        return this.f4245e;
    }

    @Override // x0.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f4244d.hasPendingAdapterUpdates()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // x0.a
    public void onInitializeAccessibilityNodeInfo(View view, y0.d dVar) {
        super.onInitializeAccessibilityNodeInfo(view, dVar);
        RecyclerView recyclerView = this.f4244d;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return;
        }
        RecyclerView.l layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f3962b;
        layoutManager.onInitializeAccessibilityNodeInfo(recyclerView2.f3916m, recyclerView2.f3927r0, dVar);
    }

    @Override // x0.a
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f4244d;
        if (recyclerView.hasPendingAdapterUpdates() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        RecyclerView.l layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f3962b;
        return layoutManager.performAccessibilityAction(recyclerView2.f3916m, recyclerView2.f3927r0, i10, bundle);
    }
}
