package ye;

/* compiled from: ObservableFromArray.java */
/* loaded from: classes2.dex */
public final class i0<T> extends ne.k<T> {

    /* renamed from: b, reason: collision with root package name */
    public final T[] f22178b;

    /* compiled from: ObservableFromArray.java */
    public static final class a<T> extends we.b<T> {

        /* renamed from: b, reason: collision with root package name */
        public final ne.q<? super T> f22179b;

        /* renamed from: m, reason: collision with root package name */
        public final T[] f22180m;

        /* renamed from: n, reason: collision with root package name */
        public int f22181n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f22182o;

        /* renamed from: p, reason: collision with root package name */
        public volatile boolean f22183p;

        public a(ne.q<? super T> qVar, T[] tArr) {
            this.f22179b = qVar;
            this.f22180m = tArr;
        }

        @Override // ve.f
        public void clear() {
            this.f22181n = this.f22180m.length;
        }

        @Override // qe.b
        public void dispose() {
            this.f22183p = true;
        }

        public boolean isDisposed() {
            return this.f22183p;
        }

        @Override // ve.f
        public boolean isEmpty() {
            return this.f22181n == this.f22180m.length;
        }

        @Override // ve.f
        public T poll() {
            int i10 = this.f22181n;
            T[] tArr = this.f22180m;
            if (i10 == tArr.length) {
                return null;
            }
            this.f22181n = i10 + 1;
            return (T) ue.a.requireNonNull(tArr[i10], "The array element is null");
        }

        @Override // ve.c
        public int requestFusion(int i10) {
            if ((i10 & 1) == 0) {
                return 0;
            }
            this.f22182o = true;
            return 1;
        }
    }

    public i0(T[] tArr) {
        this.f22178b = tArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        if (r0.isDisposed() != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        r3.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0041, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return;
     */
    @Override // ne.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void subscribeActual(ne.q<? super T> r6) {
        /*
            r5 = this;
            ye.i0$a r0 = new ye.i0$a
            T[] r1 = r5.f22178b
            r0.<init>(r6, r1)
            r6.onSubscribe(r0)
            boolean r6 = r0.f22182o
            if (r6 == 0) goto Lf
            return
        Lf:
            T[] r6 = r0.f22180m
            int r1 = r6.length
            r2 = 0
        L13:
            ne.q<? super T> r3 = r0.f22179b
            if (r2 >= r1) goto L38
            boolean r4 = r0.isDisposed()
            if (r4 != 0) goto L38
            r4 = r6[r2]
            if (r4 != 0) goto L32
            java.lang.NullPointerException r6 = new java.lang.NullPointerException
            java.lang.String r0 = "The element at index "
            java.lang.String r1 = " is null"
            java.lang.String r0 = o1.a.d(r0, r2, r1)
            r6.<init>(r0)
            r3.onError(r6)
            goto L41
        L32:
            r3.onNext(r4)
            int r2 = r2 + 1
            goto L13
        L38:
            boolean r6 = r0.isDisposed()
            if (r6 != 0) goto L41
            r3.onComplete()
        L41:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ye.i0.subscribeActual(ne.q):void");
    }
}
