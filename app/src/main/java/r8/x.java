package r8;

import java.util.SortedSet;
import java.util.concurrent.Callable;

/* compiled from: CrashlyticsCore.java */
/* loaded from: classes.dex */
public final class x implements Callable<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f18796b;

    public x(w wVar) {
        this.f18796b = wVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        r rVar = this.f18796b.f18781g;
        y yVar = rVar.f18746c;
        if (!yVar.isPresent()) {
            SortedSet<String> sortedSetListSortedOpenSessionIds = rVar.f18756m.listSortedOpenSessionIds();
            String strFirst = !sortedSetListSortedOpenSessionIds.isEmpty() ? sortedSetListSortedOpenSessionIds.first() : null;
            boolean z10 = strFirst != null && rVar.f18753j.hasCrashDataForSession(strFirst);
            return Boolean.valueOf(z10);
        }
        o8.e.getLogger().v("Found previous crash marker.");
        yVar.remove();
        return Boolean.valueOf(z10);
    }
}
