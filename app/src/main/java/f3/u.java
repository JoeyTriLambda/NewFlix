package f3;

import android.annotation.SuppressLint;
import androidx.work.WorkInfo$State;
import f3.t;
import java.util.List;

/* compiled from: WorkSpecDao.kt */
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public interface u {
    void delete(String str);

    List<t> getAllEligibleWorkSpecsForScheduling(int i10);

    List<t> getEligibleWorkForScheduling(int i10);

    List<androidx.work.b> getInputsFromPrerequisites(String str);

    List<t> getRecentlyCompletedWork(long j10);

    List<t> getRunningWork();

    List<t> getScheduledWork();

    WorkInfo$State getState(String str);

    List<String> getUnfinishedWorkWithName(String str);

    t getWorkSpec(String str);

    List<t.b> getWorkSpecIdAndStatesForName(String str);

    boolean hasUnfinishedWork();

    void incrementPeriodCount(String str);

    int incrementWorkSpecRunAttemptCount(String str);

    void insertWorkSpec(t tVar);

    int markWorkSpecScheduled(String str, long j10);

    int resetScheduledState();

    int resetWorkSpecRunAttemptCount(String str);

    void setLastEnqueuedTime(String str, long j10);

    void setOutput(String str, androidx.work.b bVar);

    int setState(WorkInfo$State workInfo$State, String str);

    void updateWorkSpec(t tVar);
}
