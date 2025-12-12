package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zada<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: f, reason: collision with root package name */
    public final WeakReference<GoogleApiClient> f7253f;

    /* renamed from: g, reason: collision with root package name */
    public final zacz f7254g;

    /* renamed from: a, reason: collision with root package name */
    public ResultTransform<? super R, ? extends Result> f7248a = null;

    /* renamed from: b, reason: collision with root package name */
    public zada<? extends Result> f7249b = null;

    /* renamed from: c, reason: collision with root package name */
    public PendingResult<R> f7250c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7251d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public Status f7252e = null;

    /* renamed from: h, reason: collision with root package name */
    public boolean f7255h = false;

    public zada(WeakReference<GoogleApiClient> weakReference) {
        Preconditions.checkNotNull(weakReference, "GoogleApiClient reference must not be null");
        this.f7253f = weakReference;
        GoogleApiClient googleApiClient = weakReference.get();
        this.f7254g = new zacz(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    public static final void d(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e10) {
                Log.w("TransformedResultImpl", "Unable to release ".concat(String.valueOf(result)), e10);
            }
        }
    }

    public final void a(Status status) {
        synchronized (this.f7251d) {
            this.f7252e = status;
            c(status);
        }
    }

    public final void b() {
        if (this.f7248a == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f7253f.get();
        if (!this.f7255h && this.f7248a != null && googleApiClient != null) {
            googleApiClient.zao(this);
            this.f7255h = true;
        }
        Status status = this.f7252e;
        if (status != null) {
            c(status);
            return;
        }
        PendingResult<R> pendingResult = this.f7250c;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    public final void c(Status status) {
        synchronized (this.f7251d) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.f7248a;
            if (resultTransform != null) {
                ((zada) Preconditions.checkNotNull(this.f7249b)).a((Status) Preconditions.checkNotNull(resultTransform.onFailure(status), "onFailure must not return null"));
            } else {
                this.f7253f.get();
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void onResult(R r10) {
        synchronized (this.f7251d) {
            try {
                if (!r10.getStatus().isSuccess()) {
                    a(r10.getStatus());
                    d(r10);
                } else if (this.f7248a != null) {
                    zaco.zaa().submit(new zacy(this, r10));
                } else {
                    this.f7253f.get();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        zada<? extends Result> zadaVar;
        synchronized (this.f7251d) {
            Preconditions.checkState(this.f7248a == null, "Cannot call then() twice.");
            Preconditions.checkState(true, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f7248a = resultTransform;
            zadaVar = new zada<>(this.f7253f);
            this.f7249b = zadaVar;
            b();
        }
        return zadaVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zai(PendingResult<?> pendingResult) {
        synchronized (this.f7251d) {
            this.f7250c = pendingResult;
            b();
        }
    }
}
