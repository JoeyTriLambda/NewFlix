package ba;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ba.a;
import com.malinskiy.superrecyclerview.SuperRecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* compiled from: SwipeDismissRecyclerViewTouchListener.java */
/* loaded from: classes.dex */
public final class c extends la.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4823a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f4824b;

    public c(a aVar, int i10) {
        this.f4824b = aVar;
        this.f4823a = i10;
    }

    @Override // la.b, la.a.InterfaceC0190a
    public void onAnimationEnd(la.a aVar) {
        a aVar2 = this.f4824b;
        int i10 = aVar2.f4810t - 1;
        aVar2.f4810t = i10;
        if (i10 == 0) {
            ArrayList arrayList = aVar2.f4809s;
            Collections.sort(arrayList);
            int[] iArr = new int[arrayList.size()];
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                iArr[size] = ((a.c) arrayList.get(size)).f4818b;
            }
            SuperRecyclerView.b bVar = (SuperRecyclerView.b) aVar2.f4807q;
            RecyclerView recyclerView = aVar2.f4806p;
            bVar.onDismiss(recyclerView, iArr);
            aVar2.f4815y = -1;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a.c cVar = (a.c) it.next();
                ma.a.setAlpha(cVar.f4819m, 1.0f);
                View view = cVar.f4819m;
                ma.a.setTranslationX(view, 0.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = this.f4823a;
                view.setLayoutParams(layoutParams);
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            recyclerView.dispatchTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            arrayList.clear();
        }
    }
}
