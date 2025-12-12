package s8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t8.f0;

/* compiled from: RolloutAssignmentList.java */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19163a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final int f19164b;

    public l(int i10) {
        this.f19164b = i10;
    }

    public List<f0.e.d.AbstractC0277e> getReportRolloutsState() {
        List<k> rolloutAssignmentList = getRolloutAssignmentList();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < rolloutAssignmentList.size(); i10++) {
            arrayList.add(rolloutAssignmentList.get(i10).toReportProto());
        }
        return arrayList;
    }

    public synchronized List<k> getRolloutAssignmentList() {
        return Collections.unmodifiableList(new ArrayList(this.f19163a));
    }

    public synchronized boolean updateRolloutAssignmentList(List<k> list) {
        this.f19163a.clear();
        if (list.size() <= this.f19164b) {
            return this.f19163a.addAll(list);
        }
        o8.e.getLogger().w("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f19164b);
        return this.f19163a.addAll(list.subList(0, this.f19164b));
    }
}
