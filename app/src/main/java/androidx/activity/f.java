package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.p;
import androidx.fragment.app.y;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.w;
import androidx.savedstate.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements a.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f809a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f810b;

    public /* synthetic */ f(Object obj, int i10) {
        this.f809a = i10;
        this.f810b = obj;
    }

    @Override // androidx.savedstate.a.c
    public final Bundle saveState() {
        int i10 = this.f809a;
        Object obj = this.f810b;
        switch (i10) {
            case 0:
                ComponentActivity componentActivity = (ComponentActivity) obj;
                componentActivity.getClass();
                Bundle bundle = new Bundle();
                componentActivity.f747u.onSaveInstanceState(bundle);
                return bundle;
            case 1:
                p pVar = (p) obj;
                int i11 = p.H;
                while (p.b(pVar.getSupportFragmentManager())) {
                }
                pVar.D.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
                return new Bundle();
            case 2:
                return ((y) obj).N();
            default:
                w wVar = (w) obj;
                w.a aVar = w.f3519f;
                zf.i.checkNotNullParameter(wVar, "this$0");
                for (Map.Entry entry : kotlin.collections.a.toMap(wVar.f3522b).entrySet()) {
                    wVar.set((String) entry.getKey(), ((a.c) entry.getValue()).saveState());
                }
                LinkedHashMap linkedHashMap = wVar.f3521a;
                Set<String> setKeySet = linkedHashMap.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap.get(str));
                }
                return t0.c.bundleOf(lf.g.to("keys", arrayList), lf.g.to("values", arrayList2));
        }
    }
}
