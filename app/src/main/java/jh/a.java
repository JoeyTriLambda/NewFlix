package jh;

import android.util.Log;
import org.koin.core.logger.Level;
import qh.b;
import zf.i;

/* compiled from: AndroidLogger.kt */
/* loaded from: classes2.dex */
public final class a extends b {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Level level) {
        super(level);
        i.checkNotNullParameter(level, "level");
    }

    @Override // qh.b
    public void display(Level level, String str) {
        i.checkNotNullParameter(level, "level");
        i.checkNotNullParameter(str, "msg");
        int iOrdinal = level.ordinal();
        if (iOrdinal == 0) {
            Log.d("[Koin]", str);
            return;
        }
        if (iOrdinal == 1) {
            Log.i("[Koin]", str);
            return;
        }
        if (iOrdinal == 2) {
            Log.w("[Koin]", str);
        } else if (iOrdinal != 3) {
            Log.e("[Koin]", str);
        } else {
            Log.e("[Koin]", str);
        }
    }
}
