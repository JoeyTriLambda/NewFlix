package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.f0;
import androidx.transition.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TransitionSet.java */
/* loaded from: classes.dex */
public class h extends e {
    public int O;
    public ArrayList<e> M = new ArrayList<>();
    public boolean N = true;
    public boolean P = false;
    public int Q = 0;

    /* compiled from: TransitionSet.java */
    public class a extends f {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f4430b;

        public a(e eVar) {
            this.f4430b = eVar;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(e eVar) {
            this.f4430b.runAnimators();
            eVar.removeListener(this);
        }
    }

    /* compiled from: TransitionSet.java */
    public static class b extends f {

        /* renamed from: b, reason: collision with root package name */
        public final h f4431b;

        public b(h hVar) {
            this.f4431b = hVar;
        }

        @Override // androidx.transition.e.InterfaceC0045e
        public void onTransitionEnd(e eVar) {
            h hVar = this.f4431b;
            int i10 = hVar.O - 1;
            hVar.O = i10;
            if (i10 == 0) {
                hVar.P = false;
                hVar.end();
            }
            eVar.removeListener(this);
        }

        @Override // androidx.transition.f, androidx.transition.e.InterfaceC0045e
        public void onTransitionStart(e eVar) {
            h hVar = this.f4431b;
            if (hVar.P) {
                return;
            }
            hVar.start();
            hVar.P = true;
        }
    }

    public h addTransition(e eVar) {
        this.M.add(eVar);
        eVar.f4404t = this;
        long j10 = this.f4398n;
        if (j10 >= 0) {
            eVar.setDuration(j10);
        }
        if ((this.Q & 1) != 0) {
            eVar.setInterpolator(getInterpolator());
        }
        if ((this.Q & 2) != 0) {
            getPropagation();
            eVar.setPropagation(null);
        }
        if ((this.Q & 4) != 0) {
            eVar.setPathMotion(getPathMotion());
        }
        if ((this.Q & 8) != 0) {
            eVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.e
    public final void c(q2.i iVar) {
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).c(iVar);
        }
    }

    @Override // androidx.transition.e
    public void cancel() {
        super.cancel();
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).cancel();
        }
    }

    @Override // androidx.transition.e
    public void captureEndValues(q2.i iVar) {
        if (i(iVar.f17786b)) {
            Iterator<e> it = this.M.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.i(iVar.f17786b)) {
                    next.captureEndValues(iVar);
                    iVar.f17787c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.e
    public void captureStartValues(q2.i iVar) {
        if (i(iVar.f17786b)) {
            Iterator<e> it = this.M.iterator();
            while (it.hasNext()) {
                e next = it.next();
                if (next.i(iVar.f17786b)) {
                    next.captureStartValues(iVar);
                    iVar.f17787c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.e
    public final void f(ViewGroup viewGroup, f0 f0Var, f0 f0Var2, ArrayList<q2.i> arrayList, ArrayList<q2.i> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVar = this.M.get(i10);
            if (startDelay > 0 && (this.N || i10 == 0)) {
                long startDelay2 = eVar.getStartDelay();
                if (startDelay2 > 0) {
                    eVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    eVar.setStartDelay(startDelay);
                }
            }
            eVar.f(viewGroup, f0Var, f0Var2, arrayList, arrayList2);
        }
    }

    public e getTransitionAt(int i10) {
        if (i10 < 0 || i10 >= this.M.size()) {
            return null;
        }
        return this.M.get(i10);
    }

    public int getTransitionCount() {
        return this.M.size();
    }

    @Override // androidx.transition.e
    public final String l(String str) {
        String strL = super.l(str);
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            StringBuilder sbU = ac.c.u(strL, StringUtils.LF);
            sbU.append(this.M.get(i10).l(str + "  "));
            strL = sbU.toString();
        }
        return strL;
    }

    @Override // androidx.transition.e
    public void pause(View view) {
        super.pause(view);
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).pause(view);
        }
    }

    @Override // androidx.transition.e
    public void resume(View view) {
        super.resume(view);
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).resume(view);
        }
    }

    @Override // androidx.transition.e
    public void runAnimators() {
        if (this.M.isEmpty()) {
            start();
            end();
            return;
        }
        b bVar = new b(this);
        Iterator<e> it = this.M.iterator();
        while (it.hasNext()) {
            it.next().addListener(bVar);
        }
        this.O = this.M.size();
        if (this.N) {
            Iterator<e> it2 = this.M.iterator();
            while (it2.hasNext()) {
                it2.next().runAnimators();
            }
            return;
        }
        for (int i10 = 1; i10 < this.M.size(); i10++) {
            this.M.get(i10 - 1).addListener(new a(this.M.get(i10)));
        }
        e eVar = this.M.get(0);
        if (eVar != null) {
            eVar.runAnimators();
        }
    }

    @Override // androidx.transition.e
    public void setEpicenterCallback(e.d dVar) {
        super.setEpicenterCallback(dVar);
        this.Q |= 8;
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).setEpicenterCallback(dVar);
        }
    }

    public h setOrdering(int i10) {
        if (i10 == 0) {
            this.N = true;
        } else {
            if (i10 != 1) {
                throw new AndroidRuntimeException(ac.c.f("Invalid parameter for TransitionSet ordering: ", i10));
            }
            this.N = false;
        }
        return this;
    }

    @Override // androidx.transition.e
    public void setPathMotion(q2.d dVar) {
        super.setPathMotion(dVar);
        this.Q |= 4;
        if (this.M != null) {
            for (int i10 = 0; i10 < this.M.size(); i10++) {
                this.M.get(i10).setPathMotion(dVar);
            }
        }
    }

    @Override // androidx.transition.e
    public void setPropagation(q2.g gVar) {
        super.setPropagation(gVar);
        this.Q |= 2;
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.M.get(i10).setPropagation(gVar);
        }
    }

    @Override // androidx.transition.e
    public h addListener(e.InterfaceC0045e interfaceC0045e) {
        return (h) super.addListener(interfaceC0045e);
    }

    @Override // androidx.transition.e
    public h addTarget(View view) {
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            this.M.get(i10).addTarget(view);
        }
        return (h) super.addTarget(view);
    }

    @Override // androidx.transition.e
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public e mo10clone() {
        h hVar = (h) super.mo10clone();
        hVar.M = new ArrayList<>();
        int size = this.M.size();
        for (int i10 = 0; i10 < size; i10++) {
            e eVarMo10clone = this.M.get(i10).mo10clone();
            hVar.M.add(eVarMo10clone);
            eVarMo10clone.f4404t = hVar;
        }
        return hVar;
    }

    @Override // androidx.transition.e
    public h removeListener(e.InterfaceC0045e interfaceC0045e) {
        return (h) super.removeListener(interfaceC0045e);
    }

    @Override // androidx.transition.e
    public h removeTarget(View view) {
        for (int i10 = 0; i10 < this.M.size(); i10++) {
            this.M.get(i10).removeTarget(view);
        }
        return (h) super.removeTarget(view);
    }

    @Override // androidx.transition.e
    public h setDuration(long j10) {
        ArrayList<e> arrayList;
        super.setDuration(j10);
        if (this.f4398n >= 0 && (arrayList = this.M) != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.M.get(i10).setDuration(j10);
            }
        }
        return this;
    }

    @Override // androidx.transition.e
    public h setInterpolator(TimeInterpolator timeInterpolator) {
        this.Q |= 1;
        ArrayList<e> arrayList = this.M;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.M.get(i10).setInterpolator(timeInterpolator);
            }
        }
        return (h) super.setInterpolator(timeInterpolator);
    }

    @Override // androidx.transition.e
    public h setStartDelay(long j10) {
        return (h) super.setStartDelay(j10);
    }
}
