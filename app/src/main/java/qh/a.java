package qh;

import org.koin.core.logger.Level;
import zf.i;

/* compiled from: EmptyLogger.kt */
/* loaded from: classes2.dex */
public final class a extends b {
    public a() {
        super(Level.NONE);
    }

    @Override // qh.b
    public void display(Level level, String str) {
        i.checkNotNullParameter(level, "level");
        i.checkNotNullParameter(str, "msg");
    }
}
