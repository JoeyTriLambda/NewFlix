package g2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import k2.f;

/* compiled from: DatabaseConfiguration.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12549a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12550b;

    /* renamed from: c, reason: collision with root package name */
    public final f.c f12551c;

    /* renamed from: d, reason: collision with root package name */
    public final RoomDatabase.d f12552d;

    /* renamed from: e, reason: collision with root package name */
    public final List<RoomDatabase.b> f12553e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12554f;

    /* renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f12555g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f12556h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f12557i;

    /* renamed from: j, reason: collision with root package name */
    public final Intent f12558j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f12559k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f12560l;

    /* renamed from: m, reason: collision with root package name */
    public final Set<Integer> f12561m;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<InputStream> f12562n;

    /* renamed from: o, reason: collision with root package name */
    public final List<Object> f12563o;

    /* renamed from: p, reason: collision with root package name */
    public final List<h2.a> f12564p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f12565q;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    public c(Context context, String str, f.c cVar, RoomDatabase.d dVar, List<? extends RoomDatabase.b> list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.e eVar, List<? extends Object> list2, List<? extends h2.a> list3) {
        zf.i.checkNotNullParameter(context, "context");
        zf.i.checkNotNullParameter(cVar, "sqliteOpenHelperFactory");
        zf.i.checkNotNullParameter(dVar, "migrationContainer");
        zf.i.checkNotNullParameter(journalMode, "journalMode");
        zf.i.checkNotNullParameter(executor, "queryExecutor");
        zf.i.checkNotNullParameter(executor2, "transactionExecutor");
        zf.i.checkNotNullParameter(list2, "typeConverters");
        zf.i.checkNotNullParameter(list3, "autoMigrationSpecs");
        this.f12549a = context;
        this.f12550b = str;
        this.f12551c = cVar;
        this.f12552d = dVar;
        this.f12553e = list;
        this.f12554f = z10;
        this.f12555g = journalMode;
        this.f12556h = executor;
        this.f12557i = executor2;
        this.f12558j = intent;
        this.f12559k = z11;
        this.f12560l = z12;
        this.f12561m = set;
        this.f12562n = callable;
        this.f12563o = list2;
        this.f12564p = list3;
        this.f12565q = intent != null;
    }

    public boolean isMigrationRequired(int i10, int i11) {
        Set<Integer> set;
        return !((i10 > i11) && this.f12560l) && this.f12559k && ((set = this.f12561m) == null || !set.contains(Integer.valueOf(i10)));
    }
}
