package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x0.j0;

/* compiled from: DefaultItemAnimator.java */
/* loaded from: classes.dex */
public final class c extends u {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f4117s;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4118h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4119i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList<e> f4120j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList<d> f4121k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList<ArrayList<RecyclerView.z>> f4122l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList<ArrayList<e>> f4123m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList<ArrayList<d>> f4124n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4125o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4126p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4127q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList<RecyclerView.z> f4128r = new ArrayList<>();

    /* compiled from: DefaultItemAnimator.java */
    public class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4129b;

        public a(ArrayList arrayList) {
            this.f4129b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f4129b;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                c cVar = c.this;
                if (!zHasNext) {
                    arrayList.clear();
                    cVar.f4123m.remove(arrayList);
                    return;
                }
                e eVar = (e) it.next();
                RecyclerView.z zVar = eVar.f4141a;
                cVar.getClass();
                View view = zVar.f4041a;
                int i10 = eVar.f4144d - eVar.f4142b;
                int i11 = eVar.f4145e - eVar.f4143c;
                if (i10 != 0) {
                    view.animate().translationX(0.0f);
                }
                if (i11 != 0) {
                    view.animate().translationY(0.0f);
                }
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                cVar.f4126p.add(zVar);
                viewPropertyAnimatorAnimate.setDuration(cVar.getMoveDuration()).setListener(new f(cVar, zVar, i10, view, i11, viewPropertyAnimatorAnimate)).start();
            }
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4131b;

        public b(ArrayList arrayList) {
            this.f4131b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f4131b;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                c cVar = c.this;
                if (!zHasNext) {
                    arrayList.clear();
                    cVar.f4124n.remove(arrayList);
                    return;
                }
                d dVar = (d) it.next();
                cVar.getClass();
                RecyclerView.z zVar = dVar.f4135a;
                View view = zVar == null ? null : zVar.f4041a;
                RecyclerView.z zVar2 = dVar.f4136b;
                View view2 = zVar2 != null ? zVar2.f4041a : null;
                ArrayList<RecyclerView.z> arrayList2 = cVar.f4128r;
                if (view != null) {
                    ViewPropertyAnimator duration = view.animate().setDuration(cVar.getChangeDuration());
                    arrayList2.add(dVar.f4135a);
                    duration.translationX(dVar.f4139e - dVar.f4137c);
                    duration.translationY(dVar.f4140f - dVar.f4138d);
                    duration.alpha(0.0f).setListener(new g(cVar, dVar, duration, view)).start();
                }
                if (view2 != null) {
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                    arrayList2.add(dVar.f4136b);
                    viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(cVar.getChangeDuration()).alpha(1.0f).setListener(new h(cVar, dVar, viewPropertyAnimatorAnimate, view2)).start();
                }
            }
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0041c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f4133b;

        public RunnableC0041c(ArrayList arrayList) {
            this.f4133b = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList arrayList = this.f4133b;
            Iterator it = arrayList.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                c cVar = c.this;
                if (!zHasNext) {
                    arrayList.clear();
                    cVar.f4122l.remove(arrayList);
                    return;
                }
                RecyclerView.z zVar = (RecyclerView.z) it.next();
                cVar.getClass();
                View view = zVar.f4041a;
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                cVar.f4125o.add(zVar);
                viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(cVar.getAddDuration()).setListener(new androidx.recyclerview.widget.e(view, viewPropertyAnimatorAnimate, cVar, zVar)).start();
            }
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.z f4135a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.z f4136b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4137c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4138d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4139e;

        /* renamed from: f, reason: collision with root package name */
        public final int f4140f;

        public d(RecyclerView.z zVar, RecyclerView.z zVar2, int i10, int i11, int i12, int i13) {
            this.f4135a = zVar;
            this.f4136b = zVar2;
            this.f4137c = i10;
            this.f4138d = i11;
            this.f4139e = i12;
            this.f4140f = i13;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("ChangeInfo{oldHolder=");
            sb2.append(this.f4135a);
            sb2.append(", newHolder=");
            sb2.append(this.f4136b);
            sb2.append(", fromX=");
            sb2.append(this.f4137c);
            sb2.append(", fromY=");
            sb2.append(this.f4138d);
            sb2.append(", toX=");
            sb2.append(this.f4139e);
            sb2.append(", toY=");
            return ac.c.l(sb2, this.f4140f, '}');
        }
    }

    /* compiled from: DefaultItemAnimator.java */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final RecyclerView.z f4141a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4142b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4143c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4144d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4145e;

        public e(RecyclerView.z zVar, int i10, int i11, int i12, int i13) {
            this.f4141a = zVar;
            this.f4142b = i10;
            this.f4143c = i11;
            this.f4144d = i12;
            this.f4145e = i13;
        }
    }

    public static void b(ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                ((RecyclerView.z) arrayList.get(size)).f4041a.animate().cancel();
            }
        }
    }

    @Override // androidx.recyclerview.widget.u
    public boolean animateAdd(RecyclerView.z zVar) {
        f(zVar);
        zVar.f4041a.setAlpha(0.0f);
        this.f4119i.add(zVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean animateChange(RecyclerView.z zVar, RecyclerView.z zVar2, int i10, int i11, int i12, int i13) {
        if (zVar == zVar2) {
            return animateMove(zVar, i10, i11, i12, i13);
        }
        float translationX = zVar.f4041a.getTranslationX();
        View view = zVar.f4041a;
        float translationY = view.getTranslationY();
        float alpha = view.getAlpha();
        f(zVar);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        view.setTranslationX(translationX);
        view.setTranslationY(translationY);
        view.setAlpha(alpha);
        if (zVar2 != null) {
            f(zVar2);
            View view2 = zVar2.f4041a;
            view2.setTranslationX(-i14);
            view2.setTranslationY(-i15);
            view2.setAlpha(0.0f);
        }
        this.f4121k.add(new d(zVar, zVar2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean animateMove(RecyclerView.z zVar, int i10, int i11, int i12, int i13) {
        View view = zVar.f4041a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) zVar.f4041a.getTranslationY());
        f(zVar);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            dispatchMoveFinished(zVar);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f4120j.add(new e(zVar, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.u
    public boolean animateRemove(RecyclerView.z zVar) {
        f(zVar);
        this.f4118h.add(zVar);
        return true;
    }

    public final void c() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean canReuseUpdatedViewHolder(RecyclerView.z zVar, List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(zVar, list);
    }

    public final void d(RecyclerView.z zVar, ArrayList arrayList) {
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            d dVar = (d) arrayList.get(size);
            if (e(dVar, zVar) && dVar.f4135a == null && dVar.f4136b == null) {
                arrayList.remove(dVar);
            }
        }
    }

    public final boolean e(d dVar, RecyclerView.z zVar) {
        boolean z10 = false;
        if (dVar.f4136b == zVar) {
            dVar.f4136b = null;
        } else {
            if (dVar.f4135a != zVar) {
                return false;
            }
            dVar.f4135a = null;
            z10 = true;
        }
        zVar.f4041a.setAlpha(1.0f);
        View view = zVar.f4041a;
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        dispatchChangeFinished(zVar, z10);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void endAnimation(RecyclerView.z zVar) {
        View view = zVar.f4041a;
        view.animate().cancel();
        ArrayList<e> arrayList = this.f4120j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (arrayList.get(size).f4141a == zVar) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(zVar);
                arrayList.remove(size);
            }
        }
        d(zVar, this.f4121k);
        if (this.f4118h.remove(zVar)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(zVar);
        }
        if (this.f4119i.remove(zVar)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(zVar);
        }
        ArrayList<ArrayList<d>> arrayList2 = this.f4124n;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            ArrayList<d> arrayList3 = arrayList2.get(size2);
            d(zVar, arrayList3);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList<ArrayList<e>> arrayList4 = this.f4123m;
        int size3 = arrayList4.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            ArrayList<e> arrayList5 = arrayList4.get(size3);
            int size4 = arrayList5.size();
            while (true) {
                size4--;
                if (size4 < 0) {
                    break;
                }
                if (arrayList5.get(size4).f4141a == zVar) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(zVar);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.z>> arrayList6 = this.f4122l;
        int size5 = arrayList6.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                this.f4127q.remove(zVar);
                this.f4125o.remove(zVar);
                this.f4128r.remove(zVar);
                this.f4126p.remove(zVar);
                c();
                return;
            }
            ArrayList<RecyclerView.z> arrayList7 = arrayList6.get(size5);
            if (arrayList7.remove(zVar)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(zVar);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void endAnimations() {
        ArrayList<e> arrayList = this.f4120j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            e eVar = arrayList.get(size);
            View view = eVar.f4141a.f4041a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(eVar.f4141a);
            arrayList.remove(size);
        }
        ArrayList<RecyclerView.z> arrayList2 = this.f4118h;
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            dispatchRemoveFinished(arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList<RecyclerView.z> arrayList3 = this.f4119i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.z zVar = arrayList3.get(size3);
            zVar.f4041a.setAlpha(1.0f);
            dispatchAddFinished(zVar);
            arrayList3.remove(size3);
        }
        ArrayList<d> arrayList4 = this.f4121k;
        int size4 = arrayList4.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            d dVar = arrayList4.get(size4);
            RecyclerView.z zVar2 = dVar.f4135a;
            if (zVar2 != null) {
                e(dVar, zVar2);
            }
            RecyclerView.z zVar3 = dVar.f4136b;
            if (zVar3 != null) {
                e(dVar, zVar3);
            }
        }
        arrayList4.clear();
        if (!isRunning()) {
            return;
        }
        ArrayList<ArrayList<e>> arrayList5 = this.f4123m;
        int size5 = arrayList5.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<e> arrayList6 = arrayList5.get(size5);
            int size6 = arrayList6.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    e eVar2 = arrayList6.get(size6);
                    View view2 = eVar2.f4141a.f4041a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(eVar2.f4141a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
        }
        ArrayList<ArrayList<RecyclerView.z>> arrayList7 = this.f4122l;
        int size7 = arrayList7.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.z> arrayList8 = arrayList7.get(size7);
            int size8 = arrayList8.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.z zVar4 = arrayList8.get(size8);
                    zVar4.f4041a.setAlpha(1.0f);
                    dispatchAddFinished(zVar4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
        }
        ArrayList<ArrayList<d>> arrayList9 = this.f4124n;
        int size9 = arrayList9.size();
        while (true) {
            size9--;
            if (size9 < 0) {
                b(this.f4127q);
                b(this.f4126p);
                b(this.f4125o);
                b(this.f4128r);
                dispatchAnimationsFinished();
                return;
            }
            ArrayList<d> arrayList10 = arrayList9.get(size9);
            int size10 = arrayList10.size();
            while (true) {
                size10--;
                if (size10 >= 0) {
                    d dVar2 = arrayList10.get(size10);
                    RecyclerView.z zVar5 = dVar2.f4135a;
                    if (zVar5 != null) {
                        e(dVar2, zVar5);
                    }
                    RecyclerView.z zVar6 = dVar2.f4136b;
                    if (zVar6 != null) {
                        e(dVar2, zVar6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
        }
    }

    public final void f(RecyclerView.z zVar) {
        if (f4117s == null) {
            f4117s = new ValueAnimator().getInterpolator();
        }
        zVar.f4041a.animate().setInterpolator(f4117s);
        endAnimation(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public boolean isRunning() {
        return (this.f4119i.isEmpty() && this.f4121k.isEmpty() && this.f4120j.isEmpty() && this.f4118h.isEmpty() && this.f4126p.isEmpty() && this.f4127q.isEmpty() && this.f4125o.isEmpty() && this.f4128r.isEmpty() && this.f4123m.isEmpty() && this.f4122l.isEmpty() && this.f4124n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.i
    public void runPendingAnimations() {
        ArrayList<RecyclerView.z> arrayList = this.f4118h;
        boolean z10 = !arrayList.isEmpty();
        ArrayList<e> arrayList2 = this.f4120j;
        boolean z11 = !arrayList2.isEmpty();
        ArrayList<d> arrayList3 = this.f4121k;
        boolean z12 = !arrayList3.isEmpty();
        ArrayList<RecyclerView.z> arrayList4 = this.f4119i;
        boolean z13 = !arrayList4.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.z> it = arrayList.iterator();
            while (it.hasNext()) {
                RecyclerView.z next = it.next();
                View view = next.f4041a;
                ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
                this.f4127q.add(next);
                viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new androidx.recyclerview.widget.d(view, viewPropertyAnimatorAnimate, this, next)).start();
            }
            arrayList.clear();
            if (z11) {
                ArrayList<e> arrayList5 = new ArrayList<>();
                arrayList5.addAll(arrayList2);
                this.f4123m.add(arrayList5);
                arrayList2.clear();
                a aVar = new a(arrayList5);
                if (z10) {
                    j0.postOnAnimationDelayed(arrayList5.get(0).f4141a.f4041a, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList<d> arrayList6 = new ArrayList<>();
                arrayList6.addAll(arrayList3);
                this.f4124n.add(arrayList6);
                arrayList3.clear();
                b bVar = new b(arrayList6);
                if (z10) {
                    j0.postOnAnimationDelayed(arrayList6.get(0).f4135a.f4041a, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList<RecyclerView.z> arrayList7 = new ArrayList<>();
                arrayList7.addAll(arrayList4);
                this.f4122l.add(arrayList7);
                arrayList4.clear();
                RunnableC0041c runnableC0041c = new RunnableC0041c(arrayList7);
                if (z10 || z11 || z12) {
                    j0.postOnAnimationDelayed(arrayList7.get(0).f4041a, runnableC0041c, Math.max(z11 ? getMoveDuration() : 0L, z12 ? getChangeDuration() : 0L) + (z10 ? getRemoveDuration() : 0L));
                } else {
                    runnableC0041c.run();
                }
            }
        }
    }
}
