package okhttp3.internal.concurrent;

import com.unity3d.ads.metadata.MediationMetaData;
import zf.f;
import zf.i;

/* compiled from: Task.kt */
/* loaded from: classes2.dex */
public abstract class Task {
    private final boolean cancelable;
    private final String name;
    private long nextExecuteNanoTime;
    private TaskQueue queue;

    public Task(String str, boolean z10) {
        i.checkNotNullParameter(str, MediationMetaData.KEY_NAME);
        this.name = str;
        this.cancelable = z10;
        this.nextExecuteNanoTime = -1L;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final String getName() {
        return this.name;
    }

    public final long getNextExecuteNanoTime$okhttp() {
        return this.nextExecuteNanoTime;
    }

    public final TaskQueue getQueue$okhttp() {
        return this.queue;
    }

    public final void initQueue$okhttp(TaskQueue taskQueue) {
        i.checkNotNullParameter(taskQueue, "queue");
        TaskQueue taskQueue2 = this.queue;
        if (taskQueue2 == taskQueue) {
            return;
        }
        if (!(taskQueue2 == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.queue = taskQueue;
    }

    public abstract long runOnce();

    public final void setNextExecuteNanoTime$okhttp(long j10) {
        this.nextExecuteNanoTime = j10;
    }

    public final void setQueue$okhttp(TaskQueue taskQueue) {
        this.queue = taskQueue;
    }

    public String toString() {
        return this.name;
    }

    public /* synthetic */ Task(String str, boolean z10, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
