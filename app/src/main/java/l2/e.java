package l2;

import android.database.sqlite.SQLiteStatement;
import k2.i;

/* compiled from: FrameworkSQLiteStatement.kt */
/* loaded from: classes.dex */
public final class e extends d implements i {

    /* renamed from: m, reason: collision with root package name */
    public final SQLiteStatement f15727m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        zf.i.checkNotNullParameter(sQLiteStatement, "delegate");
        this.f15727m = sQLiteStatement;
    }

    @Override // k2.i
    public long executeInsert() {
        return this.f15727m.executeInsert();
    }

    @Override // k2.i
    public int executeUpdateDelete() {
        return this.f15727m.executeUpdateDelete();
    }
}
