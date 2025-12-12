package s8;

/* compiled from: FileLogStore.java */
/* loaded from: classes.dex */
public interface c {
    void closeLogFile();

    void deleteLogFile();

    byte[] getLogAsBytes();

    String getLogAsString();

    void writeToLog(long j10, String str);
}
