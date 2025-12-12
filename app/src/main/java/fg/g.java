package fg;

import org.apache.commons.lang3.ClassUtils;
import zf.i;

/* compiled from: Ranges.kt */
/* loaded from: classes2.dex */
public class g {
    public static final void checkStepIsPositive(boolean z10, Number number) {
        i.checkNotNullParameter(number, "step");
        if (z10) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + ClassUtils.PACKAGE_SEPARATOR_CHAR);
    }
}
