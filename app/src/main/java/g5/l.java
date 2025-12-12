package g5;

/* compiled from: SeekMap.java */
/* loaded from: classes.dex */
public interface l {

    /* compiled from: SeekMap.java */
    public static final class a implements l {

        /* renamed from: a, reason: collision with root package name */
        public final long f12727a;

        public a(long j10) {
            this.f12727a = j10;
        }

        @Override // g5.l
        public long getDurationUs() {
            return this.f12727a;
        }

        @Override // g5.l
        public long getPosition(long j10) {
            return 0L;
        }

        @Override // g5.l
        public boolean isSeekable() {
            return false;
        }
    }

    long getDurationUs();

    long getPosition(long j10);

    boolean isSeekable();
}
