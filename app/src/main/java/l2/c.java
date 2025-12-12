package l2;

import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import k2.f;
import zf.i;

/* compiled from: FrameworkSQLiteOpenHelperFactory.kt */
/* loaded from: classes.dex */
public final class c implements f.c {
    @Override // k2.f.c
    public f create(f.b bVar) {
        i.checkNotNullParameter(bVar, "configuration");
        return new FrameworkSQLiteOpenHelper(bVar.f14725a, bVar.f14726b, bVar.f14727c, bVar.f14728d, bVar.f14729e);
    }
}
