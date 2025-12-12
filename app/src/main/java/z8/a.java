package z8;

/* compiled from: MiddleOutFallbackStrategy.java */
/* loaded from: classes.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f22619a;

    /* renamed from: b, reason: collision with root package name */
    public final d[] f22620b;

    /* renamed from: c, reason: collision with root package name */
    public final b f22621c;

    public a(int i10, d... dVarArr) {
        this.f22619a = i10;
        this.f22620b = dVarArr;
        this.f22621c = new b(i10);
    }

    @Override // z8.d
    public StackTraceElement[] getTrimmedStackTrace(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i10 = this.f22619a;
        if (length <= i10) {
            return stackTraceElementArr;
        }
        StackTraceElement[] trimmedStackTrace = stackTraceElementArr;
        for (d dVar : this.f22620b) {
            if (trimmedStackTrace.length <= i10) {
                break;
            }
            trimmedStackTrace = dVar.getTrimmedStackTrace(stackTraceElementArr);
        }
        return trimmedStackTrace.length > i10 ? this.f22621c.getTrimmedStackTrace(trimmedStackTrace) : trimmedStackTrace;
    }
}
