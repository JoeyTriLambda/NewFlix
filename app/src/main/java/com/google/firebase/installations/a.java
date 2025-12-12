package com.google.firebase.installations;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.activity.d;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import g8.f;
import h9.b;
import i9.c;
import i9.g;
import i9.h;
import i9.i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import l8.e;
import l8.n;

/* compiled from: FirebaseInstallations.java */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: m, reason: collision with root package name */
    public static final Object f9802m = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final f f9803a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.firebase.installations.remote.c f9804b;

    /* renamed from: c, reason: collision with root package name */
    public final PersistedInstallation f9805c;

    /* renamed from: d, reason: collision with root package name */
    public final i f9806d;

    /* renamed from: e, reason: collision with root package name */
    public final n<k9.a> f9807e;

    /* renamed from: f, reason: collision with root package name */
    public final g f9808f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9809g;

    /* renamed from: h, reason: collision with root package name */
    public final ExecutorService f9810h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f9811i;

    /* renamed from: j, reason: collision with root package name */
    public String f9812j;

    /* renamed from: k, reason: collision with root package name */
    public final HashSet f9813k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f9814l;

    static {
        new AtomicInteger(1);
    }

    @SuppressLint({"ThreadPoolCreation"})
    public a() {
        throw null;
    }

    @SuppressLint({"ThreadPoolCreation"})
    public a(f fVar, b<g9.f> bVar, ExecutorService executorService, Executor executor) {
        com.google.firebase.installations.remote.c cVar = new com.google.firebase.installations.remote.c(fVar.getApplicationContext(), bVar);
        PersistedInstallation persistedInstallation = new PersistedInstallation(fVar);
        i iVar = i.getInstance();
        n<k9.a> nVar = new n<>(new e(fVar, 2));
        g gVar = new g();
        this.f9809g = new Object();
        this.f9813k = new HashSet();
        this.f9814l = new ArrayList();
        this.f9803a = fVar;
        this.f9804b = cVar;
        this.f9805c = persistedInstallation;
        this.f9806d = iVar;
        this.f9807e = nVar;
        this.f9808f = gVar;
        this.f9810h = executorService;
        this.f9811i = executor;
    }

    public static a getInstance() {
        return getInstance(f.getInstance());
    }

    public final void a(h hVar) {
        synchronized (this.f9809g) {
            this.f9814l.add(hVar);
        }
    }

    public final void b(boolean z10) {
        com.google.firebase.installations.local.b persistedInstallationEntryValue;
        String iid;
        synchronized (f9802m) {
            y5.e eVarA = y5.e.a(this.f9803a.getApplicationContext());
            try {
                persistedInstallationEntryValue = this.f9805c.readPersistedInstallationEntryValue();
                if (persistedInstallationEntryValue.isNotGenerated()) {
                    f fVar = this.f9803a;
                    boolean zEquals = fVar.getName().equals("CHIME_ANDROID_SDK");
                    g gVar = this.f9808f;
                    if ((zEquals || fVar.isDefaultApp()) && persistedInstallationEntryValue.shouldAttemptMigration()) {
                        iid = this.f9807e.get().readIid();
                        if (TextUtils.isEmpty(iid)) {
                            iid = gVar.createRandomFid();
                        }
                    } else {
                        iid = gVar.createRandomFid();
                    }
                    persistedInstallationEntryValue = this.f9805c.insertOrUpdatePersistedInstallationEntry(persistedInstallationEntryValue.withUnregisteredFid(iid));
                }
            } finally {
                if (eVarA != null) {
                    eVarA.b();
                }
            }
        }
        if (z10) {
            persistedInstallationEntryValue = persistedInstallationEntryValue.withClearedAuthToken();
        }
        h(persistedInstallationEntryValue);
        this.f9811i.execute(new i9.b(z10, 1, this));
    }

    public final com.google.firebase.installations.local.b c(com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        f fVar = this.f9803a;
        TokenResult tokenResultGenerateAuthToken = this.f9804b.generateAuthToken(fVar.getOptions().getApiKey(), bVar.getFirebaseInstallationId(), fVar.getOptions().getProjectId(), bVar.getRefreshToken());
        int iOrdinal = tokenResultGenerateAuthToken.getResponseCode().ordinal();
        if (iOrdinal == 0) {
            return bVar.withAuthToken(tokenResultGenerateAuthToken.getToken(), tokenResultGenerateAuthToken.getTokenExpirationTimestamp(), this.f9806d.currentTimeInSecs());
        }
        if (iOrdinal == 1) {
            return bVar.withFisError("BAD CONFIG");
        }
        if (iOrdinal != 2) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        i(null);
        return bVar.withNoGeneratedFid();
    }

    public final void d(com.google.firebase.installations.local.b bVar) {
        synchronized (f9802m) {
            y5.e eVarA = y5.e.a(this.f9803a.getApplicationContext());
            try {
                this.f9805c.insertOrUpdatePersistedInstallationEntry(bVar);
            } finally {
                if (eVarA != null) {
                    eVarA.b();
                }
            }
        }
    }

    public final void e() {
        f fVar = this.f9803a;
        Preconditions.checkNotEmpty(fVar.getOptions().getApplicationId(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(fVar.getOptions().getProjectId(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(fVar.getOptions().getApiKey(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        String applicationId = fVar.getOptions().getApplicationId();
        Pattern pattern = i.f13352c;
        Preconditions.checkArgument(applicationId.contains(":"), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(i.f13352c.matcher(fVar.getOptions().getApiKey()).matches(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final com.google.firebase.installations.local.b f(com.google.firebase.installations.local.b bVar) throws FirebaseInstallationsException {
        String token = (bVar.getFirebaseInstallationId() == null || bVar.getFirebaseInstallationId().length() != 11) ? null : this.f9807e.get().readToken();
        com.google.firebase.installations.remote.c cVar = this.f9804b;
        f fVar = this.f9803a;
        InstallationResponse installationResponseCreateFirebaseInstallation = cVar.createFirebaseInstallation(fVar.getOptions().getApiKey(), bVar.getFirebaseInstallationId(), fVar.getOptions().getProjectId(), fVar.getOptions().getApplicationId(), token);
        int iOrdinal = installationResponseCreateFirebaseInstallation.getResponseCode().ordinal();
        if (iOrdinal == 0) {
            return bVar.withRegisteredFid(installationResponseCreateFirebaseInstallation.getFid(), installationResponseCreateFirebaseInstallation.getRefreshToken(), this.f9806d.currentTimeInSecs(), installationResponseCreateFirebaseInstallation.getAuthToken().getToken(), installationResponseCreateFirebaseInstallation.getAuthToken().getTokenExpirationTimestamp());
        }
        if (iOrdinal == 1) {
            return bVar.withFisError("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    public final void g(Exception exc) {
        synchronized (this.f9809g) {
            Iterator it = this.f9814l.iterator();
            while (it.hasNext()) {
                if (((h) it.next()).onException(exc)) {
                    it.remove();
                }
            }
        }
    }

    @Override // i9.c
    public Task<String> getId() {
        String str;
        e();
        synchronized (this) {
            str = this.f9812j;
        }
        if (str != null) {
            return Tasks.forResult(str);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        a(new i9.e(taskCompletionSource));
        Task<String> task = taskCompletionSource.getTask();
        this.f9810h.execute(new d(this, 19));
        return task;
    }

    @Override // i9.c
    public Task<i9.f> getToken(boolean z10) {
        e();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        a(new i9.d(this.f9806d, taskCompletionSource));
        Task<i9.f> task = taskCompletionSource.getTask();
        this.f9810h.execute(new i9.b(z10, 0, this));
        return task;
    }

    public final void h(com.google.firebase.installations.local.b bVar) {
        synchronized (this.f9809g) {
            Iterator it = this.f9814l.iterator();
            while (it.hasNext()) {
                if (((h) it.next()).onStateReached(bVar)) {
                    it.remove();
                }
            }
        }
    }

    public final synchronized void i(String str) {
        this.f9812j = str;
    }

    public final synchronized void j(com.google.firebase.installations.local.b bVar, com.google.firebase.installations.local.b bVar2) {
        if (this.f9813k.size() != 0 && !TextUtils.equals(bVar.getFirebaseInstallationId(), bVar2.getFirebaseInstallationId())) {
            Iterator it = this.f9813k.iterator();
            while (it.hasNext()) {
                ((j9.a) it.next()).onFidChanged(bVar2.getFirebaseInstallationId());
            }
        }
    }

    public static a getInstance(f fVar) {
        Preconditions.checkArgument(fVar != null, "Null is not a valid value of FirebaseApp.");
        return (a) fVar.get(c.class);
    }
}
