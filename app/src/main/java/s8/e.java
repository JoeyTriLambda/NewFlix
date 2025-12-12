package s8;

/* compiled from: LogFileManager.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final a f19134c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final w8.b f19135a;

    /* renamed from: b, reason: collision with root package name */
    public c f19136b;

    public e(w8.b bVar) {
        this.f19135a = bVar;
        this.f19136b = f19134c;
    }

    public void clearLog() {
        this.f19136b.deleteLogFile();
    }

    public byte[] getBytesForLog() {
        return this.f19136b.getLogAsBytes();
    }

    public String getLogString() {
        return this.f19136b.getLogAsString();
    }

    public final void setCurrentSession(String str) {
        this.f19136b.closeLogFile();
        this.f19136b = f19134c;
        if (str == null) {
            return;
        }
        this.f19136b = new j(this.f19135a.getSessionFile(str, "userlog"));
    }

    public void writeToLog(long j10, String str) {
        this.f19136b.writeToLog(j10, str);
    }

    public e(w8.b bVar, String str) {
        this(bVar);
        setCurrentSession(str);
    }

    /* compiled from: LogFileManager.java */
    public static final class a implements c {
        @Override // s8.c
        public byte[] getLogAsBytes() {
            return null;
        }

        @Override // s8.c
        public String getLogAsString() {
            return null;
        }

        @Override // s8.c
        public void closeLogFile() {
        }

        @Override // s8.c
        public void deleteLogFile() {
        }

        @Override // s8.c
        public void writeToLog(long j10, String str) {
        }
    }
}
