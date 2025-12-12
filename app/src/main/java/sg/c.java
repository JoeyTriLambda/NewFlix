package sg;

import kotlinx.coroutines.selects.TrySelectDetailedResult;
import pg.b0;

/* compiled from: Select.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b0 f19289a = new b0("STATE_REG");

    /* renamed from: b, reason: collision with root package name */
    public static final b0 f19290b = new b0("STATE_COMPLETED");

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f19291c = new b0("STATE_CANCELLED");

    static {
        new b0("NO_RESULT");
        new b0("PARAM_CLAUSE_0");
    }

    public static final TrySelectDetailedResult access$TrySelectDetailedResult(int i10) {
        if (i10 == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i10 == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i10 == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i10 == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i10).toString());
    }
}
