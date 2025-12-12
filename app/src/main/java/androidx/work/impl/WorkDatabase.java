package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import f3.b;
import f3.e;
import f3.o;
import f3.r;
import f3.u;
import f3.y;
import g2.n;
import java.util.concurrent.Executor;
import k2.f;
import x2.c;
import x2.f0;
import x2.g;
import x2.h;
import x2.j;
import x2.k;
import x2.l;
import x2.m;
import x2.s;
import zf.f;
import zf.i;

/* compiled from: WorkDatabase.kt */
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: m, reason: collision with root package name */
    public static final a f4515m = new a(null);

    /* compiled from: WorkDatabase.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final WorkDatabase create(final Context context, Executor executor, boolean z10) {
            i.checkNotNullParameter(context, "context");
            i.checkNotNullParameter(executor, "queryExecutor");
            return (WorkDatabase) (z10 ? n.inMemoryDatabaseBuilder(context, WorkDatabase.class).allowMainThreadQueries() : n.databaseBuilder(context, WorkDatabase.class, "androidx.work.workdb").openHelperFactory(new f.c() { // from class: x2.y
                @Override // k2.f.c
                public final k2.f create(f.b bVar) {
                    Context context2 = context;
                    zf.i.checkNotNullParameter(context2, "$context");
                    zf.i.checkNotNullParameter(bVar, "configuration");
                    f.b.a aVarBuilder = f.b.f14724f.builder(context2);
                    aVarBuilder.name(bVar.f14726b).callback(bVar.f14727c).noBackupDirectory(true).allowDataLossOnRecovery(true);
                    return new l2.c().create(aVarBuilder.build());
                }
            })).setQueryExecutor(executor).addCallback(c.f21390a).addMigrations(x2.i.f21422c).addMigrations(new s(context, 2, 3)).addMigrations(j.f21425c).addMigrations(k.f21428c).addMigrations(new s(context, 5, 6)).addMigrations(l.f21453c).addMigrations(m.f21454c).addMigrations(x2.n.f21455c).addMigrations(new f0(context)).addMigrations(new s(context, 10, 11)).addMigrations(x2.f.f21406c).addMigrations(g.f21408c).addMigrations(h.f21414c).fallbackToDestructiveMigration().build();
        }
    }

    public static final WorkDatabase create(Context context, Executor executor, boolean z10) {
        return f4515m.create(context, executor, z10);
    }

    public abstract b dependencyDao();

    public abstract e preferenceDao();

    public abstract f3.j systemIdInfoDao();

    public abstract o workNameDao();

    public abstract r workProgressDao();

    public abstract u workSpecDao();

    public abstract y workTagDao();
}
