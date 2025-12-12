package y0;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AccessibilityNodeProviderCompat.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f21838a;

    /* compiled from: AccessibilityNodeProviderCompat.java */
    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a, reason: collision with root package name */
        public final e f21839a;

        public a(e eVar) {
            this.f21839a = eVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            d dVarCreateAccessibilityNodeInfo = this.f21839a.createAccessibilityNodeInfo(i10);
            if (dVarCreateAccessibilityNodeInfo == null) {
                return null;
            }
            return dVarCreateAccessibilityNodeInfo.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i10) {
            List<d> listFindAccessibilityNodeInfosByText = this.f21839a.findAccessibilityNodeInfosByText(str, i10);
            if (listFindAccessibilityNodeInfosByText == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listFindAccessibilityNodeInfosByText.size();
            for (int i11 = 0; i11 < size; i11++) {
                arrayList.add(listFindAccessibilityNodeInfosByText.get(i11).unwrap());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i10) {
            d dVarFindFocus = this.f21839a.findFocus(i10);
            if (dVarFindFocus == null) {
                return null;
            }
            return dVarFindFocus.unwrap();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, Bundle bundle) {
            return this.f21839a.performAction(i10, i11, bundle);
        }
    }

    /* compiled from: AccessibilityNodeProviderCompat.java */
    public static class b extends a {
        public b(e eVar) {
            super(eVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f21839a.addExtraDataToAccessibilityNodeInfo(i10, d.wrap(accessibilityNodeInfo), str, bundle);
        }
    }

    public e() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f21838a = new b(this);
        } else {
            this.f21838a = new a(this);
        }
    }

    public d createAccessibilityNodeInfo(int i10) {
        return null;
    }

    public List<d> findAccessibilityNodeInfosByText(String str, int i10) {
        return null;
    }

    public d findFocus(int i10) {
        return null;
    }

    public Object getProvider() {
        return this.f21838a;
    }

    public boolean performAction(int i10, int i11, Bundle bundle) {
        return false;
    }

    public e(Object obj) {
        this.f21838a = obj;
    }

    public void addExtraDataToAccessibilityNodeInfo(int i10, d dVar, String str, Bundle bundle) {
    }
}
