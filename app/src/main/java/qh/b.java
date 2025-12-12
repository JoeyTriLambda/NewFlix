package qh;

import org.koin.core.logger.Level;
import zf.i;

/* compiled from: Logger.kt */
/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Level f18153a;

    public b(Level level) {
        i.checkNotNullParameter(level, "level");
        this.f18153a = level;
    }

    public abstract void display(Level level, String str);

    public final boolean isAt(Level level) {
        i.checkNotNullParameter(level, "lvl");
        return this.f18153a.compareTo(level) <= 0;
    }
}
