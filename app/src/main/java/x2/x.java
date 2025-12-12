package x2;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: WorkContinuationImpl.java */
/* loaded from: classes.dex */
public final class x extends w2.m {

    /* renamed from: j, reason: collision with root package name */
    public static final String f21486j = w2.g.tagWithPrefix("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final e0 f21487a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21488b;

    /* renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f21489c;

    /* renamed from: d, reason: collision with root package name */
    public final List<? extends w2.o> f21490d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f21491e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f21492f;

    /* renamed from: g, reason: collision with root package name */
    public final List<x> f21493g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f21494h;

    /* renamed from: i, reason: collision with root package name */
    public w2.i f21495i;

    public x(e0 e0Var, List<? extends w2.o> list) {
        this(e0Var, null, ExistingWorkPolicy.KEEP, list, null);
    }

    public static boolean a(x xVar, HashSet hashSet) {
        hashSet.addAll(xVar.getIds());
        Set<String> setPrerequisitesFor = prerequisitesFor(xVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (setPrerequisitesFor.contains((String) it.next())) {
                return true;
            }
        }
        List<x> parents = xVar.getParents();
        if (parents != null && !parents.isEmpty()) {
            Iterator<x> it2 = parents.iterator();
            while (it2.hasNext()) {
                if (a(it2.next(), hashSet)) {
                    return true;
                }
            }
        }
        hashSet.removeAll(xVar.getIds());
        return false;
    }

    public static Set<String> prerequisitesFor(x xVar) {
        HashSet hashSet = new HashSet();
        List<x> parents = xVar.getParents();
        if (parents != null && !parents.isEmpty()) {
            Iterator<x> it = parents.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().getIds());
            }
        }
        return hashSet;
    }

    public w2.i enqueue() {
        if (this.f21494h) {
            w2.g.get().warning(f21486j, "Already enqueued work ids (" + TextUtils.join(", ", this.f21491e) + ")");
        } else {
            g3.c cVar = new g3.c(this);
            i3.d dVar = (i3.d) this.f21487a.getWorkTaskExecutor();
            dVar.getClass();
            i3.b.a(dVar, cVar);
            this.f21495i = cVar.getOperation();
        }
        return this.f21495i;
    }

    public ExistingWorkPolicy getExistingWorkPolicy() {
        return this.f21489c;
    }

    public List<String> getIds() {
        return this.f21491e;
    }

    public String getName() {
        return this.f21488b;
    }

    public List<x> getParents() {
        return this.f21493g;
    }

    public List<? extends w2.o> getWork() {
        return this.f21490d;
    }

    public e0 getWorkManagerImpl() {
        return this.f21487a;
    }

    public boolean hasCycles() {
        return a(this, new HashSet());
    }

    public boolean isEnqueued() {
        return this.f21494h;
    }

    public void markEnqueued() {
        this.f21494h = true;
    }

    public x(e0 e0Var, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends w2.o> list) {
        this(e0Var, str, existingWorkPolicy, list, null);
    }

    public x(e0 e0Var, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends w2.o> list, List<x> list2) {
        this.f21487a = e0Var;
        this.f21488b = str;
        this.f21489c = existingWorkPolicy;
        this.f21490d = list;
        this.f21493g = list2;
        this.f21491e = new ArrayList(list.size());
        this.f21492f = new ArrayList();
        if (list2 != null) {
            Iterator<x> it = list2.iterator();
            while (it.hasNext()) {
                this.f21492f.addAll(it.next().f21492f);
            }
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            String stringId = list.get(i10).getStringId();
            this.f21491e.add(stringId);
            this.f21492f.add(stringId);
        }
    }
}
