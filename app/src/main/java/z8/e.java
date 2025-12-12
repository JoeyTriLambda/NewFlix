package z8;

import java.util.Stack;

/* compiled from: TrimmedThrowableData.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f22624a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22625b;

    /* renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f22626c;

    /* renamed from: d, reason: collision with root package name */
    public final e f22627d;

    public e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.f22624a = str;
        this.f22625b = str2;
        this.f22626c = stackTraceElementArr;
        this.f22627d = eVar;
    }

    public static e makeTrimmedThrowableData(Throwable th2, d dVar) {
        Stack stack = new Stack();
        while (th2 != null) {
            stack.push(th2);
            th2 = th2.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th3 = (Throwable) stack.pop();
            eVar = new e(th3.getLocalizedMessage(), th3.getClass().getName(), dVar.getTrimmedStackTrace(th3.getStackTrace()), eVar);
        }
        return eVar;
    }
}
