package com.google.firebase.sessions;

import zf.f;

/* compiled from: InstallationId.kt */
/* loaded from: classes.dex */
public final class InstallationId {

    /* renamed from: c, reason: collision with root package name */
    public static final Companion f9884c = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f9885a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9886b;

    /* compiled from: InstallationId.kt */
    public static final class Companion {
        public Companion(f fVar) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v16 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r9v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object create(i9.c r9, qf.c<? super com.google.firebase.sessions.InstallationId> r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof com.google.firebase.sessions.InstallationId$Companion$create$1
                if (r0 == 0) goto L13
                r0 = r10
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = (com.google.firebase.sessions.InstallationId$Companion$create$1) r0
                int r1 = r0.f9890o
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f9890o = r1
                goto L18
            L13:
                com.google.firebase.sessions.InstallationId$Companion$create$1 r0 = new com.google.firebase.sessions.InstallationId$Companion$create$1
                r0.<init>(r8, r10)
            L18:
                java.lang.Object r10 = r0.f9888m
                java.lang.Object r1 = rf.a.getCOROUTINE_SUSPENDED()
                int r2 = r0.f9890o
                java.lang.String r3 = ""
                java.lang.String r4 = "InstallationId"
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L46
                if (r2 == r6) goto L3e
                if (r2 != r5) goto L36
                java.lang.Object r9 = r0.f9887b
                java.lang.String r9 = (java.lang.String) r9
                lf.f.throwOnFailure(r10)     // Catch: java.lang.Exception -> L34
                goto L89
            L34:
                r10 = move-exception
                goto L8d
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f9887b
                i9.c r9 = (i9.c) r9
                lf.f.throwOnFailure(r10)     // Catch: java.lang.Exception -> L68
                goto L5e
            L46:
                lf.f.throwOnFailure(r10)
                r10 = 0
                com.google.android.gms.tasks.Task r10 = r9.getToken(r10)     // Catch: java.lang.Exception -> L68
                java.lang.String r2 = "firebaseInstallations.getToken(false)"
                zf.i.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L68
                r0.f9887b = r9     // Catch: java.lang.Exception -> L68
                r0.f9890o = r6     // Catch: java.lang.Exception -> L68
                java.lang.Object r10 = ug.c.await(r10, r0)     // Catch: java.lang.Exception -> L68
                if (r10 != r1) goto L5e
                return r1
            L5e:
                i9.f r10 = (i9.f) r10     // Catch: java.lang.Exception -> L68
                java.lang.String r10 = r10.getToken()     // Catch: java.lang.Exception -> L68
                r7 = r10
                r10 = r9
                r9 = r7
                goto L70
            L68:
                r10 = move-exception
                java.lang.String r2 = "Error getting authentication token."
                android.util.Log.w(r4, r2, r10)
                r10 = r9
                r9 = r3
            L70:
                java.lang.String r2 = "try {\n          firebase…e.\n          \"\"\n        }"
                zf.i.checkNotNullExpressionValue(r9, r2)
                com.google.android.gms.tasks.Task r10 = r10.getId()     // Catch: java.lang.Exception -> L34
                java.lang.String r2 = "firebaseInstallations.id"
                zf.i.checkNotNullExpressionValue(r10, r2)     // Catch: java.lang.Exception -> L34
                r0.f9887b = r9     // Catch: java.lang.Exception -> L34
                r0.f9890o = r5     // Catch: java.lang.Exception -> L34
                java.lang.Object r10 = ug.c.await(r10, r0)     // Catch: java.lang.Exception -> L34
                if (r10 != r1) goto L89
                return r1
            L89:
                java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> L34
                r3 = r10
                goto L92
            L8d:
                java.lang.String r0 = "Error getting Firebase installation id ."
                android.util.Log.w(r4, r0, r10)
            L92:
                com.google.firebase.sessions.InstallationId r10 = new com.google.firebase.sessions.InstallationId
                java.lang.String r0 = "fid"
                zf.i.checkNotNullExpressionValue(r3, r0)
                r0 = 0
                r10.<init>(r3, r9, r0)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.InstallationId.Companion.create(i9.c, qf.c):java.lang.Object");
        }
    }

    public InstallationId(String str, String str2, f fVar) {
        this.f9885a = str;
        this.f9886b = str2;
    }

    public final String getAuthToken() {
        return this.f9886b;
    }

    public final String getFid() {
        return this.f9885a;
    }
}
