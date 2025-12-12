package lg;

import kg.e0;

/* compiled from: AndroidExceptionPreHandler.kt */
/* loaded from: classes2.dex */
public final class b extends qf.a implements e0 {
    private volatile Object _preHandler;

    public b() {
        super(e0.b.f15106b);
        this._preHandler = this;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    @Override // kg.e0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void handleException(kotlin.coroutines.CoroutineContext r6, java.lang.Throwable r7) {
        /*
            r5 = this;
            int r6 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            r1 = 1
            r2 = 0
            if (r0 > r6) goto Le
            r0 = 28
            if (r6 >= r0) goto Le
            r6 = 1
            goto Lf
        Le:
            r6 = 0
        Lf:
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5._preHandler
            r0 = 0
            if (r6 == r5) goto L19
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            goto L3f
        L19:
            java.lang.Class<java.lang.Thread> r6 = java.lang.Thread.class
            java.lang.String r3 = "getUncaughtExceptionPreHandler"
            java.lang.Class[] r4 = new java.lang.Class[r2]     // Catch: java.lang.Throwable -> L3c
            java.lang.reflect.Method r6 = r6.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L3c
            int r3 = r6.getModifiers()     // Catch: java.lang.Throwable -> L3c
            boolean r3 = java.lang.reflect.Modifier.isPublic(r3)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L38
            int r3 = r6.getModifiers()     // Catch: java.lang.Throwable -> L3c
            boolean r3 = java.lang.reflect.Modifier.isStatic(r3)     // Catch: java.lang.Throwable -> L3c
            if (r3 == 0) goto L38
            goto L39
        L38:
            r1 = 0
        L39:
            if (r1 == 0) goto L3c
            goto L3d
        L3c:
            r6 = r0
        L3d:
            r5._preHandler = r6
        L3f:
            if (r6 == 0) goto L48
            java.lang.Object[] r1 = new java.lang.Object[r2]
            java.lang.Object r6 = r6.invoke(r0, r1)
            goto L49
        L48:
            r6 = r0
        L49:
            boolean r1 = r6 instanceof java.lang.Thread.UncaughtExceptionHandler
            if (r1 == 0) goto L50
            r0 = r6
            java.lang.Thread$UncaughtExceptionHandler r0 = (java.lang.Thread.UncaughtExceptionHandler) r0
        L50:
            if (r0 == 0) goto L59
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            r0.uncaughtException(r6, r7)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lg.b.handleException(kotlin.coroutines.CoroutineContext, java.lang.Throwable):void");
    }
}
