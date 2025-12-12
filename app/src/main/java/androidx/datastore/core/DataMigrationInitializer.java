package androidx.datastore.core;

import i1.g;
import java.util.List;
import lf.h;
import qf.c;
import yf.p;
import zf.f;
import zf.i;

/* compiled from: DataMigrationInitializer.kt */
/* loaded from: classes.dex */
public final class DataMigrationInitializer<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f2162a = new Companion(null);

    /* compiled from: DataMigrationInitializer.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, java.lang.Throwable] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0089 -> B:23:0x006b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x008c -> B:23:0x006b). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final java.lang.Object access$runMigrations(androidx.datastore.core.DataMigrationInitializer.Companion r5, java.util.List r6, i1.g r7, qf.c r8) throws java.lang.Throwable {
            /*
                r5.getClass()
                boolean r0 = r8 instanceof androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                if (r0 == 0) goto L16
                r0 = r8
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = (androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1) r0
                int r1 = r0.f2170p
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L16
                int r1 = r1 - r2
                r0.f2170p = r1
                goto L1b
            L16:
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1 r0 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$1
                r0.<init>(r5, r8)
            L1b:
                java.lang.Object r5 = r0.f2168n
                java.lang.Object r8 = rf.a.getCOROUTINE_SUSPENDED()
                int r1 = r0.f2170p
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L45
                if (r1 == r3) goto L3d
                if (r1 != r2) goto L35
                java.util.Iterator r6 = r0.f2167m
                java.io.Serializable r7 = r0.f2166b
                kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
                lf.f.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L84
                goto L6b
            L35:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L3d:
                java.io.Serializable r6 = r0.f2166b
                java.util.List r6 = (java.util.List) r6
                lf.f.throwOnFailure(r5)
                goto L5f
            L45:
                lf.f.throwOnFailure(r5)
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2 r1 = new androidx.datastore.core.DataMigrationInitializer$Companion$runMigrations$2
                r4 = 0
                r1.<init>(r6, r5, r4)
                r0.f2166b = r5
                r0.f2170p = r3
                java.lang.Object r6 = r7.updateData(r1, r0)
                if (r6 != r8) goto L5e
                goto L9f
            L5e:
                r6 = r5
            L5f:
                kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
                r5.<init>()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
                r7 = r5
            L6b:
                boolean r5 = r6.hasNext()
                if (r5 == 0) goto L97
                java.lang.Object r5 = r6.next()
                yf.l r5 = (yf.l) r5
                r0.f2166b = r7     // Catch: java.lang.Throwable -> L84
                r0.f2167m = r6     // Catch: java.lang.Throwable -> L84
                r0.f2170p = r2     // Catch: java.lang.Throwable -> L84
                java.lang.Object r5 = r5.invoke(r0)     // Catch: java.lang.Throwable -> L84
                if (r5 != r8) goto L6b
                goto L9f
            L84:
                r5 = move-exception
                T r1 = r7.f15262b
                if (r1 != 0) goto L8c
                r7.f15262b = r5
                goto L6b
            L8c:
                zf.i.checkNotNull(r1)
                T r1 = r7.f15262b
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                lf.a.addSuppressed(r1, r5)
                goto L6b
            L97:
                T r5 = r7.f15262b
                java.lang.Throwable r5 = (java.lang.Throwable) r5
                if (r5 != 0) goto La0
                lf.h r8 = lf.h.f16056a
            L9f:
                return r8
            La0:
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataMigrationInitializer.Companion.access$runMigrations(androidx.datastore.core.DataMigrationInitializer$Companion, java.util.List, i1.g, qf.c):java.lang.Object");
        }

        public final <T> p<g<T>, c<? super h>, Object> getInitializer(List<? extends i1.c<T>> list) {
            i.checkNotNullParameter(list, "migrations");
            return new DataMigrationInitializer$Companion$getInitializer$1(list, null);
        }
    }
}
