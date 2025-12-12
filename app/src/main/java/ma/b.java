package ma;

import android.os.Build;
import android.view.View;
import java.util.WeakHashMap;
import la.a;

/* compiled from: ViewPropertyAnimator.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap<View, b> f16225a = new WeakHashMap<>(0);

    public static b animate(View view) {
        WeakHashMap<View, b> weakHashMap = f16225a;
        b dVar = weakHashMap.get(view);
        if (dVar == null) {
            int iIntValue = Integer.valueOf(Build.VERSION.SDK).intValue();
            dVar = iIntValue >= 14 ? new d(view) : iIntValue >= 11 ? new c(view) : new e(view);
            weakHashMap.put(view, dVar);
        }
        return dVar;
    }

    public abstract b alpha(float f10);

    public abstract b setDuration(long j10);

    public abstract b setListener(a.InterfaceC0190a interfaceC0190a);

    public abstract b translationX(float f10);
}
