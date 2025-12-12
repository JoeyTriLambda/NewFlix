package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import i1.d;
import i1.i;
import i1.j;
import i1.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kg.g0;
import kg.u;
import kg.w;
import kotlin.coroutines.CoroutineContext;
import lf.e;
import lf.h;
import mf.q;
import ng.g;
import ng.l;
import yf.p;
import zf.f;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
public final class SingleProcessDataStore<T> implements d<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final a f2190k = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public static final LinkedHashSet f2191l = new LinkedHashSet();

    /* renamed from: m, reason: collision with root package name */
    public static final Object f2192m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final yf.a<File> f2193a;

    /* renamed from: b, reason: collision with root package name */
    public final i<T> f2194b;

    /* renamed from: c, reason: collision with root package name */
    public final i1.a<T> f2195c;

    /* renamed from: d, reason: collision with root package name */
    public final g0 f2196d;

    /* renamed from: e, reason: collision with root package name */
    public final ng.a<T> f2197e;

    /* renamed from: f, reason: collision with root package name */
    public final String f2198f;

    /* renamed from: g, reason: collision with root package name */
    public final e f2199g;

    /* renamed from: h, reason: collision with root package name */
    public final g<j<T>> f2200h;

    /* renamed from: i, reason: collision with root package name */
    public List<? extends p<? super i1.g<T>, ? super qf.c<? super h>, ? extends Object>> f2201i;

    /* renamed from: j, reason: collision with root package name */
    public final SimpleActor<b<T>> f2202j;

    /* compiled from: SingleProcessDataStore.kt */
    public static final class a {
        public a(f fVar) {
        }

        public final Set<String> getActiveFiles$datastore_core() {
            return SingleProcessDataStore.f2191l;
        }

        public final Object getActiveFilesLock$datastore_core() {
            return SingleProcessDataStore.f2192m;
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    public static abstract class b<T> {

        /* compiled from: SingleProcessDataStore.kt */
        public static final class a<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name */
            public final j<T> f2213a;

            public a(j<T> jVar) {
                super(null);
                this.f2213a = jVar;
            }

            public j<T> getLastState() {
                return this.f2213a;
            }
        }

        /* compiled from: SingleProcessDataStore.kt */
        /* renamed from: androidx.datastore.core.SingleProcessDataStore$b$b, reason: collision with other inner class name */
        public static final class C0021b<T> extends b<T> {

            /* renamed from: a, reason: collision with root package name */
            public final p<T, qf.c<? super T>, Object> f2214a;

            /* renamed from: b, reason: collision with root package name */
            public final u<T> f2215b;

            /* renamed from: c, reason: collision with root package name */
            public final j<T> f2216c;

            /* renamed from: d, reason: collision with root package name */
            public final CoroutineContext f2217d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0021b(p<? super T, ? super qf.c<? super T>, ? extends Object> pVar, u<T> uVar, j<T> jVar, CoroutineContext coroutineContext) {
                super(null);
                zf.i.checkNotNullParameter(pVar, "transform");
                zf.i.checkNotNullParameter(uVar, "ack");
                zf.i.checkNotNullParameter(coroutineContext, "callerContext");
                this.f2214a = pVar;
                this.f2215b = uVar;
                this.f2216c = jVar;
                this.f2217d = coroutineContext;
            }

            public final u<T> getAck() {
                return this.f2215b;
            }

            public final CoroutineContext getCallerContext() {
                return this.f2217d;
            }

            public j<T> getLastState() {
                return this.f2216c;
            }

            public final p<T, qf.c<? super T>, Object> getTransform() {
                return this.f2214a;
            }
        }

        public b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    public static final class c extends OutputStream {

        /* renamed from: b, reason: collision with root package name */
        public final FileOutputStream f2218b;

        public c(FileOutputStream fileOutputStream) {
            zf.i.checkNotNullParameter(fileOutputStream, "fileOutputStream");
            this.f2218b = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f2218b.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f2218b.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            zf.i.checkNotNullParameter(bArr, "b");
            this.f2218b.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            zf.i.checkNotNullParameter(bArr, "bytes");
            this.f2218b.write(bArr, i10, i11);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SingleProcessDataStore(yf.a<? extends File> aVar, i<T> iVar, List<? extends p<? super i1.g<T>, ? super qf.c<? super h>, ? extends Object>> list, i1.a<T> aVar2, g0 g0Var) {
        zf.i.checkNotNullParameter(aVar, "produceFile");
        zf.i.checkNotNullParameter(iVar, "serializer");
        zf.i.checkNotNullParameter(list, "initTasksList");
        zf.i.checkNotNullParameter(aVar2, "corruptionHandler");
        zf.i.checkNotNullParameter(g0Var, "scope");
        this.f2193a = aVar;
        this.f2194b = iVar;
        this.f2195c = aVar2;
        this.f2196d = g0Var;
        this.f2197e = ng.c.flow(new SingleProcessDataStore$data$1(this, null));
        this.f2198f = ".tmp";
        this.f2199g = kotlin.a.lazy(new yf.a<File>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$file$2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleProcessDataStore<T> f2224b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f2224b = this;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // yf.a
            public final File invoke() {
                File file = (File) this.f2224b.f2193a.invoke();
                String absolutePath = file.getAbsolutePath();
                SingleProcessDataStore.a aVar3 = SingleProcessDataStore.f2190k;
                synchronized (aVar3.getActiveFilesLock$datastore_core()) {
                    if (!(!aVar3.getActiveFiles$datastore_core().contains(absolutePath))) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    Set<String> activeFiles$datastore_core = aVar3.getActiveFiles$datastore_core();
                    zf.i.checkNotNullExpressionValue(absolutePath, "it");
                    activeFiles$datastore_core.add(absolutePath);
                }
                return file;
            }
        });
        this.f2200h = l.MutableStateFlow(k.f13107a);
        this.f2201i = q.toList(list);
        this.f2202j = new SimpleActor<>(g0Var, new yf.l<Throwable, h>(this) { // from class: androidx.datastore.core.SingleProcessDataStore$actor$1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleProcessDataStore<T> f2208b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.f2208b = this;
            }

            @Override // yf.l
            public /* bridge */ /* synthetic */ h invoke(Throwable th2) {
                invoke2(th2);
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                if (th2 != null) {
                    this.f2208b.f2200h.setValue(new i1.f(th2));
                }
                SingleProcessDataStore.a aVar3 = SingleProcessDataStore.f2190k;
                Object activeFilesLock$datastore_core = aVar3.getActiveFilesLock$datastore_core();
                SingleProcessDataStore<T> singleProcessDataStore = this.f2208b;
                synchronized (activeFilesLock$datastore_core) {
                    aVar3.getActiveFiles$datastore_core().remove(singleProcessDataStore.a().getAbsolutePath());
                    h hVar = h.f16056a;
                }
            }
        }, new p<b<T>, Throwable, h>() { // from class: androidx.datastore.core.SingleProcessDataStore$actor$2
            @Override // yf.p
            public /* bridge */ /* synthetic */ h invoke(Object obj, Throwable th2) {
                invoke((SingleProcessDataStore.b) obj, th2);
                return h.f16056a;
            }

            public final void invoke(SingleProcessDataStore.b<T> bVar, Throwable th2) {
                zf.i.checkNotNullParameter(bVar, "msg");
                if (bVar instanceof SingleProcessDataStore.b.C0021b) {
                    u<T> ack = ((SingleProcessDataStore.b.C0021b) bVar).getAck();
                    if (th2 == null) {
                        th2 = new CancellationException("DataStore scope was cancelled before updateData could complete");
                    }
                    ack.completeExceptionally(th2);
                }
            }
        }, new SingleProcessDataStore$actor$3(this, null));
    }

    public static final Object access$handleRead(SingleProcessDataStore singleProcessDataStore, b.a aVar, qf.c cVar) throws Throwable {
        j<T> value = singleProcessDataStore.f2200h.getValue();
        if (!(value instanceof i1.b)) {
            if (value instanceof i1.h) {
                if (value == aVar.getLastState()) {
                    Object objD = singleProcessDataStore.d(cVar);
                    return objD == rf.a.getCOROUTINE_SUSPENDED() ? objD : h.f16056a;
                }
            } else {
                if (zf.i.areEqual(value, k.f13107a)) {
                    Object objD2 = singleProcessDataStore.d(cVar);
                    return objD2 == rf.a.getCOROUTINE_SUSPENDED() ? objD2 : h.f16056a;
                }
                if (value instanceof i1.f) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return h.f16056a;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:4|(1:6)(1:7))(0)|8|67|(6:(1:(1:(2:14|15))(2:16|17))|19|20|46|62|63)(4:24|64|25|(6:27|(2:29|69)|45|46|62|63)(3:30|(1:32)(1:33)|(2:35|(2:37|(1:70)(1:40))(2:50|51))(2:52|(2:54|55)(2:56|57))))|65|41|(1:71)(5:44|45|46|62|63)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00bb, code lost:
    
        r9 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00bc, code lost:
    
        r10 = r8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.SingleProcessDataStore, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$handleUpdate(androidx.datastore.core.SingleProcessDataStore r8, androidx.datastore.core.SingleProcessDataStore.b.C0021b r9, qf.c r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.access$handleUpdate(androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore$b$b, qf.c):java.lang.Object");
    }

    public final File a() {
        return (File) this.f2199g.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0100 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(qf.c<? super lf.h> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.b(qf.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(qf.c<? super lf.h> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.f2255o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2255o = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f2253m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2255o
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            androidx.datastore.core.SingleProcessDataStore r0 = r0.f2252b
            lf.f.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2b
            goto L43
        L2b:
            r5 = move-exception
            goto L48
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            lf.f.throwOnFailure(r5)
            r0.f2252b = r4     // Catch: java.lang.Throwable -> L46
            r0.f2255o = r3     // Catch: java.lang.Throwable -> L46
            java.lang.Object r5 = r4.b(r0)     // Catch: java.lang.Throwable -> L46
            if (r5 != r1) goto L43
            return r1
        L43:
            lf.h r5 = lf.h.f16056a
            return r5
        L46:
            r5 = move-exception
            r0 = r4
        L48:
            ng.g<i1.j<T>> r0 = r0.f2200h
            i1.h r1 = new i1.h
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.c(qf.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(qf.c<? super lf.h> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.f2259o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2259o = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f2257m
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2259o
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            androidx.datastore.core.SingleProcessDataStore r0 = r0.f2256b
            lf.f.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2b
            goto L4f
        L2b:
            r5 = move-exception
            goto L45
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            lf.f.throwOnFailure(r5)
            r0.f2256b = r4     // Catch: java.lang.Throwable -> L43
            r0.f2259o = r3     // Catch: java.lang.Throwable -> L43
            java.lang.Object r5 = r4.b(r0)     // Catch: java.lang.Throwable -> L43
            if (r5 != r1) goto L4f
            return r1
        L43:
            r5 = move-exception
            r0 = r4
        L45:
            ng.g<i1.j<T>> r0 = r0.f2200h
            i1.h r1 = new i1.h
            r1.<init>(r5)
            r0.setValue(r1)
        L4f:
            lf.h r5 = lf.h.f16056a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.d(qf.c):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.SingleProcessDataStore$readData$1, qf.c] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.SingleProcessDataStore] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v2, types: [i1.i, i1.i<T>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(qf.c<? super T> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L13
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.f2264p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2264p = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f2262n
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2264p
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.io.FileInputStream r1 = r0.f2261m
            androidx.datastore.core.SingleProcessDataStore r0 = r0.f2260b
            lf.f.throwOnFailure(r5)     // Catch: java.lang.Throwable -> L2d
            goto L55
        L2d:
            r5 = move-exception
            goto L60
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L37:
            lf.f.throwOnFailure(r5)
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L66
            java.io.File r2 = r4.a()     // Catch: java.io.FileNotFoundException -> L66
            r5.<init>(r2)     // Catch: java.io.FileNotFoundException -> L66
            i1.i<T> r2 = r4.f2194b     // Catch: java.lang.Throwable -> L5c
            r0.f2260b = r4     // Catch: java.lang.Throwable -> L5c
            r0.f2261m = r5     // Catch: java.lang.Throwable -> L5c
            r0.f2264p = r3     // Catch: java.lang.Throwable -> L5c
            java.lang.Object r0 = r2.readFrom(r5, r0)     // Catch: java.lang.Throwable -> L5c
            if (r0 != r1) goto L52
            return r1
        L52:
            r1 = r5
            r5 = r0
            r0 = r4
        L55:
            r2 = 0
            wf.a.closeFinally(r1, r2)     // Catch: java.io.FileNotFoundException -> L5a
            return r5
        L5a:
            r5 = move-exception
            goto L68
        L5c:
            r0 = move-exception
            r1 = r5
            r5 = r0
            r0 = r4
        L60:
            throw r5     // Catch: java.lang.Throwable -> L61
        L61:
            r2 = move-exception
            wf.a.closeFinally(r1, r5)     // Catch: java.io.FileNotFoundException -> L5a
            throw r2     // Catch: java.io.FileNotFoundException -> L5a
        L66:
            r5 = move-exception
            r0 = r4
        L68:
            java.io.File r1 = r0.a()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L79
            i1.i<T> r5 = r0.f2194b
            java.lang.Object r5 = r5.getDefaultValue()
            return r5
        L79:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.e(qf.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object f(qf.c<? super T> r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.f2269p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2269p = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f2267n
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2269p
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L55
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r1 = r0.f2266m
            java.lang.Object r0 = r0.f2265b
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            lf.f.throwOnFailure(r8)     // Catch: java.io.IOException -> L35
            goto L87
        L35:
            r8 = move-exception
            goto L8a
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3f:
            java.lang.Object r2 = r0.f2266m
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.f2265b
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            lf.f.throwOnFailure(r8)
            goto L79
        L4b:
            java.lang.Object r2 = r0.f2265b
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            lf.f.throwOnFailure(r8)     // Catch: androidx.datastore.core.CorruptionException -> L53
            goto L63
        L53:
            r8 = move-exception
            goto L66
        L55:
            lf.f.throwOnFailure(r8)
            r0.f2265b = r7     // Catch: androidx.datastore.core.CorruptionException -> L64
            r0.f2269p = r5     // Catch: androidx.datastore.core.CorruptionException -> L64
            java.lang.Object r8 = r7.e(r0)     // Catch: androidx.datastore.core.CorruptionException -> L64
            if (r8 != r1) goto L63
            return r1
        L63:
            return r8
        L64:
            r8 = move-exception
            r2 = r7
        L66:
            i1.a<T> r5 = r2.f2195c
            r0.f2265b = r2
            r0.f2266m = r8
            r0.f2269p = r4
            java.lang.Object r4 = r5.handleCorruption(r8, r0)
            if (r4 != r1) goto L75
            return r1
        L75:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L79:
            r0.f2265b = r2     // Catch: java.io.IOException -> L88
            r0.f2266m = r8     // Catch: java.io.IOException -> L88
            r0.f2269p = r3     // Catch: java.io.IOException -> L88
            java.lang.Object r0 = r4.writeData$datastore_core(r8, r0)     // Catch: java.io.IOException -> L88
            if (r0 != r1) goto L86
            return r1
        L86:
            r1 = r8
        L87:
            return r1
        L88:
            r8 = move-exception
            r0 = r2
        L8a:
            lf.a.addSuppressed(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.f(qf.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(kotlin.coroutines.CoroutineContext r8, yf.p r9, qf.c r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.f2275q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2275q = r1
            goto L18
        L13:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L18:
            java.lang.Object r10 = r0.f2273o
            java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2275q
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L45
            if (r2 == r5) goto L39
            if (r2 != r4) goto L31
            java.lang.Object r8 = r0.f2271m
            androidx.datastore.core.SingleProcessDataStore r9 = r0.f2270b
            lf.f.throwOnFailure(r10)
            goto L8a
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            java.lang.Object r8 = r0.f2272n
            java.lang.Object r9 = r0.f2271m
            i1.b r9 = (i1.b) r9
            androidx.datastore.core.SingleProcessDataStore r2 = r0.f2270b
            lf.f.throwOnFailure(r10)
            goto L6f
        L45:
            lf.f.throwOnFailure(r10)
            ng.g<i1.j<T>> r10 = r7.f2200h
            java.lang.Object r10 = r10.getValue()
            i1.b r10 = (i1.b) r10
            r10.checkHashCode()
            java.lang.Object r2 = r10.getValue()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r9, r2, r3)
            r0.f2270b = r7
            r0.f2271m = r10
            r0.f2272n = r2
            r0.f2275q = r5
            java.lang.Object r8 = kg.f.withContext(r8, r6, r0)
            if (r8 != r1) goto L6b
            return r1
        L6b:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L6f:
            r9.checkHashCode()
            boolean r9 = zf.i.areEqual(r8, r10)
            if (r9 == 0) goto L79
            goto L9c
        L79:
            r0.f2270b = r2
            r0.f2271m = r10
            r0.f2272n = r3
            r0.f2275q = r4
            java.lang.Object r8 = r2.writeData$datastore_core(r10, r0)
            if (r8 != r1) goto L88
            return r1
        L88:
            r8 = r10
            r9 = r2
        L8a:
            ng.g<i1.j<T>> r9 = r9.f2200h
            i1.b r10 = new i1.b
            if (r8 == 0) goto L95
            int r0 = r8.hashCode()
            goto L96
        L95:
            r0 = 0
        L96:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        L9c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.g(kotlin.coroutines.CoroutineContext, yf.p, qf.c):java.lang.Object");
    }

    @Override // i1.d
    public ng.a<T> getData() {
        return this.f2197e;
    }

    @Override // i1.d
    public Object updateData(p<? super T, ? super qf.c<? super T>, ? extends Object> pVar, qf.c<? super T> cVar) throws Throwable {
        u uVarCompletableDeferred$default = w.CompletableDeferred$default(null, 1, null);
        this.f2202j.offer(new b.C0021b(pVar, uVarCompletableDeferred$default, this.f2200h.getValue(), cVar.getContext()));
        return uVarCompletableDeferred$default.await(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object writeData$datastore_core(T r8, qf.c<? super lf.h> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.String r0 = "Unable to rename "
            boolean r1 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r1 == 0) goto L15
            r1 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r1 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r1
            int r2 = r1.f2285r
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f2285r = r2
            goto L1a
        L15:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r1 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r1.<init>(r7, r9)
        L1a:
            java.lang.Object r9 = r1.f2283p
            java.lang.Object r2 = rf.a.getCOROUTINE_SUSPENDED()
            int r3 = r1.f2285r
            r4 = 1
            if (r3 == 0) goto L3e
            if (r3 != r4) goto L36
            java.io.FileOutputStream r8 = r1.f2282o
            java.io.FileOutputStream r2 = r1.f2281n
            java.io.File r3 = r1.f2280m
            androidx.datastore.core.SingleProcessDataStore r1 = r1.f2279b
            lf.f.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L33
            goto L8c
        L33:
            r8 = move-exception
            goto Lbf
        L36:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3e:
            lf.f.throwOnFailure(r9)
            java.io.File r9 = r7.a()
            java.io.File r3 = r9.getCanonicalFile()
            java.io.File r3 = r3.getParentFile()
            if (r3 != 0) goto L50
            goto L59
        L50:
            r3.mkdirs()
            boolean r3 = r3.isDirectory()
            if (r3 == 0) goto Ld2
        L59:
            java.io.File r3 = new java.io.File
            java.io.File r9 = r7.a()
            java.lang.String r9 = r9.getAbsolutePath()
            java.lang.String r5 = r7.f2198f
            java.lang.String r9 = zf.i.stringPlus(r9, r5)
            r3.<init>(r9)
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.io.IOException -> Lbd
            r9.<init>(r3)     // Catch: java.io.IOException -> Lbd
            i1.i<T> r5 = r7.f2194b     // Catch: java.lang.Throwable -> Lc1
            androidx.datastore.core.SingleProcessDataStore$c r6 = new androidx.datastore.core.SingleProcessDataStore$c     // Catch: java.lang.Throwable -> Lc1
            r6.<init>(r9)     // Catch: java.lang.Throwable -> Lc1
            r1.f2279b = r7     // Catch: java.lang.Throwable -> Lc1
            r1.f2280m = r3     // Catch: java.lang.Throwable -> Lc1
            r1.f2281n = r9     // Catch: java.lang.Throwable -> Lc1
            r1.f2282o = r9     // Catch: java.lang.Throwable -> Lc1
            r1.f2285r = r4     // Catch: java.lang.Throwable -> Lc1
            java.lang.Object r8 = r5.writeTo(r8, r6, r1)     // Catch: java.lang.Throwable -> Lc1
            if (r8 != r2) goto L89
            return r2
        L89:
            r1 = r7
            r8 = r9
            r2 = r8
        L8c:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch: java.lang.Throwable -> L33
            r8.sync()     // Catch: java.lang.Throwable -> L33
            lf.h r8 = lf.h.f16056a     // Catch: java.lang.Throwable -> L33
            r8 = 0
            wf.a.closeFinally(r2, r8)     // Catch: java.io.IOException -> Lbd
            java.io.File r8 = r1.a()     // Catch: java.io.IOException -> Lbd
            boolean r8 = r3.renameTo(r8)     // Catch: java.io.IOException -> Lbd
            if (r8 == 0) goto La6
            lf.h r8 = lf.h.f16056a
            return r8
        La6:
            java.io.IOException r8 = new java.io.IOException     // Catch: java.io.IOException -> Lbd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.io.IOException -> Lbd
            r9.<init>(r0)     // Catch: java.io.IOException -> Lbd
            r9.append(r3)     // Catch: java.io.IOException -> Lbd
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch: java.io.IOException -> Lbd
            java.lang.String r9 = r9.toString()     // Catch: java.io.IOException -> Lbd
            r8.<init>(r9)     // Catch: java.io.IOException -> Lbd
            throw r8     // Catch: java.io.IOException -> Lbd
        Lbd:
            r8 = move-exception
            goto Lc8
        Lbf:
            r9 = r2
            goto Lc2
        Lc1:
            r8 = move-exception
        Lc2:
            throw r8     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r0 = move-exception
            wf.a.closeFinally(r9, r8)     // Catch: java.io.IOException -> Lbd
            throw r0     // Catch: java.io.IOException -> Lbd
        Lc8:
            boolean r9 = r3.exists()
            if (r9 == 0) goto Ld1
            r3.delete()
        Ld1:
            throw r8
        Ld2:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Unable to create parent directories of "
            java.lang.String r9 = zf.i.stringPlus(r0, r9)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.writeData$datastore_core(java.lang.Object, qf.c):java.lang.Object");
    }
}
