package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;
import kotlin.Result;
import zf.f;
import zf.i;

/* compiled from: NonBehavioralFlag.kt */
/* loaded from: classes2.dex */
public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;

    public static final Companion Companion = new Companion(null);

    /* compiled from: NonBehavioralFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final NonBehavioralFlag fromString(String str) {
            Object objM59constructorimpl;
            i.checkNotNullParameter(str, "value");
            try {
                int i10 = Result.f15189m;
                String upperCase = str.toUpperCase(Locale.ROOT);
                i.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                objM59constructorimpl = Result.m59constructorimpl(NonBehavioralFlag.valueOf(upperCase));
            } catch (Throwable th2) {
                int i11 = Result.f15189m;
                objM59constructorimpl = Result.m59constructorimpl(lf.f.createFailure(th2));
            }
            NonBehavioralFlag nonBehavioralFlag = NonBehavioralFlag.UNKNOWN;
            if (Result.m63isFailureimpl(objM59constructorimpl)) {
                objM59constructorimpl = nonBehavioralFlag;
            }
            return (NonBehavioralFlag) objM59constructorimpl;
        }
    }
}
