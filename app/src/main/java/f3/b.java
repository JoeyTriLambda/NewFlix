package f3;

import java.util.List;

/* compiled from: DependencyDao.kt */
/* loaded from: classes.dex */
public interface b {
    List<String> getDependentWorkIds(String str);

    boolean hasCompletedAllPrerequisites(String str);

    boolean hasDependents(String str);

    void insertDependency(a aVar);
}
