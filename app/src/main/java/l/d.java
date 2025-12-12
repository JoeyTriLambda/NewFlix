package l;

import zf.i;

/* loaded from: classes2.dex */
public final class d extends Throwable {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Throwable th2) {
        super(th2);
        i.checkNotNullParameter(th2, "cause");
    }
}
