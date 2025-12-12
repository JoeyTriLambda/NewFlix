package u5;

/* compiled from: SequenceableLoader.java */
/* loaded from: classes.dex */
public interface l {

    /* compiled from: SequenceableLoader.java */
    public interface a<T extends l> {
        void onContinueLoadingRequested(T t10);
    }

    boolean continueLoading(long j10);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();
}
