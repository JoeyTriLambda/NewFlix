package androidx.room;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.a;
import lf.e;
import zf.i;

/* compiled from: SharedSQLiteStatement.kt */
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f4308a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4309b;

    /* renamed from: c, reason: collision with root package name */
    public final e f4310c;

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        i.checkNotNullParameter(roomDatabase, "database");
        this.f4308a = roomDatabase;
        this.f4309b = new AtomicBoolean(false);
        this.f4310c = a.lazy(new yf.a<k2.i>() { // from class: androidx.room.SharedSQLiteStatement$stmt$2
            {
                super(0);
            }

            @Override // yf.a
            public final k2.i invoke() {
                SharedSQLiteStatement sharedSQLiteStatement = this.f4311b;
                return sharedSQLiteStatement.f4308a.compileStatement(sharedSQLiteStatement.createQuery());
            }
        });
    }

    public k2.i acquire() {
        assertNotMainThread();
        if (this.f4309b.compareAndSet(false, true)) {
            return (k2.i) this.f4310c.getValue();
        }
        return this.f4308a.compileStatement(createQuery());
    }

    public void assertNotMainThread() {
        this.f4308a.assertNotMainThread();
    }

    public abstract String createQuery();

    public void release(k2.i iVar) {
        i.checkNotNullParameter(iVar, "statement");
        if (iVar == ((k2.i) this.f4310c.getValue())) {
            this.f4309b.set(false);
        }
    }
}
