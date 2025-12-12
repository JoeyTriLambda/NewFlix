package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zaa = new zaq();
    public static final /* synthetic */ int zad = 0;

    @KeepName
    private zas mResultGuardian;
    protected final CallbackHandler<R> zab;
    protected final WeakReference<GoogleApiClient> zac;
    private final Object zae;
    private final CountDownLatch zaf;
    private final ArrayList<PendingResult.StatusListener> zag;
    private ResultCallback<? super R> zah;
    private final AtomicReference<zadb> zai;
    private R zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private ICancelToken zao;
    private volatile zada<R> zap;
    private boolean zaq;

    @Deprecated
    public BasePendingResult() {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(Looper.getMainLooper());
        this.zac = new WeakReference<>(null);
    }

    private final R zaa() {
        R r10;
        synchronized (this.zae) {
            Preconditions.checkState(!this.zal, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r10 = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        zadb andSet = this.zai.getAndSet(null);
        if (andSet == null) {
            return (R) Preconditions.checkNotNull(r10);
        }
        andSet.getClass();
        throw null;
    }

    private final void zab(R r10) {
        this.zaj = r10;
        this.zak = r10.getStatus();
        this.zao = null;
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            ResultCallback<? super R> resultCallback = this.zah;
            if (resultCallback != null) {
                this.zab.removeMessages(2);
                this.zab.zaa(resultCallback, zaa());
            } else if (this.zaj instanceof Releasable) {
                this.mResultGuardian = new zas(this);
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zag;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.get(i10).onComplete(this.zak);
        }
        this.zag.clear();
    }

    public static void zal(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e10) {
                Log.w("BasePendingResult", "Unable to release ".concat(String.valueOf(result)), e10);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zae) {
            if (isReady()) {
                statusListener.onComplete(this.zak);
            } else {
                this.zag.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() throws InterruptedException {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        Preconditions.checkState(!this.zal, "Result has already been consumed");
        Preconditions.checkState(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f7070q);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return (R) zaa();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.zae) {
            if (!this.zam && !this.zal) {
                ICancelToken iCancelToken = this.zao;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zal(this.zaj);
                this.zam = true;
                zab(createFailedResult(Status.f7073t));
            }
        }
    }

    @KeepForSdk
    public abstract R createFailedResult(Status status);

    @KeepForSdk
    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zan = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean isCanceled() {
        boolean z10;
        synchronized (this.zae) {
            z10 = this.zam;
        }
        return z10;
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    @KeepForSdk
    public final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zae) {
            this.zao = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(R r10) {
        synchronized (this.zae) {
            if (this.zan || this.zam) {
                zal(r10);
                return;
            }
            isReady();
            Preconditions.checkState(!isReady(), "Results have already been set");
            Preconditions.checkState(!this.zal, "Result has already been consumed");
            zab(r10);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.zae) {
            if (resultCallback == null) {
                this.zah = null;
                return;
            }
            boolean z10 = true;
            Preconditions.checkState(!this.zal, "Result has already been consumed.");
            if (this.zap != null) {
                z10 = false;
            }
            Preconditions.checkState(z10, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zab.zaa(resultCallback, zaa());
            } else {
                this.zah = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> transformedResultThen;
        Preconditions.checkState(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            Preconditions.checkState(this.zap == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zah == null, "Cannot call then() if callbacks are set.");
            Preconditions.checkState(!this.zam, "Cannot call then() if result was canceled.");
            this.zaq = true;
            this.zap = new zada<>(this.zac);
            transformedResultThen = this.zap.then(resultTransform);
            if (isReady()) {
                this.zab.zaa(this.zap, zaa());
            } else {
                this.zah = this.zap;
            }
        }
        return transformedResultThen;
    }

    public final void zak() {
        boolean z10 = true;
        if (!this.zaq && !zaa.get().booleanValue()) {
            z10 = false;
        }
        this.zaq = z10;
    }

    public final boolean zam() {
        boolean zIsCanceled;
        synchronized (this.zae) {
            if (this.zac.get() == null || !this.zaq) {
                cancel();
            }
            zIsCanceled = isCanceled();
        }
        return zIsCanceled;
    }

    public final void zan(zadb zadbVar) {
        this.zai.set(zadbVar);
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends com.google.android.gms.internal.base.zaq {
        public CallbackHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                    return;
                } catch (RuntimeException e10) {
                    BasePendingResult.zal(result);
                    throw e10;
                }
            }
            if (i10 == 2) {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.f7072s);
                return;
            }
            StringBuilder sb2 = new StringBuilder(45);
            sb2.append("Don't know how to handle message: ");
            sb2.append(i10);
            Log.wtf("BasePendingResult", sb2.toString(), new Exception());
        }

        public final void zaa(ResultCallback<? super R> resultCallback, R r10) {
            int i10 = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.checkNotNull(resultCallback), r10)));
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }
    }

    @KeepForSdk
    @Deprecated
    public BasePendingResult(Looper looper) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(looper);
        this.zac = new WeakReference<>(null);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j10, TimeUnit timeUnit) {
        if (j10 > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.checkState(!this.zal, "Result has already been consumed.");
        Preconditions.checkState(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j10, timeUnit)) {
                forceFailureUnlessReady(Status.f7072s);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.f7070q);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return (R) zaa();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j10, TimeUnit timeUnit) {
        synchronized (this.zae) {
            if (resultCallback == null) {
                this.zah = null;
                return;
            }
            boolean z10 = true;
            Preconditions.checkState(!this.zal, "Result has already been consumed.");
            if (this.zap != null) {
                z10 = false;
            }
            Preconditions.checkState(z10, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zab.zaa(resultCallback, zaa());
            } else {
                this.zah = resultCallback;
                CallbackHandler<R> callbackHandler = this.zab;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j10));
            }
        }
    }

    @KeepForSdk
    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zac = new WeakReference<>(googleApiClient);
    }

    @VisibleForTesting
    @KeepForSdk
    public BasePendingResult(CallbackHandler<R> callbackHandler) {
        this.zae = new Object();
        this.zaf = new CountDownLatch(1);
        this.zag = new ArrayList<>();
        this.zai = new AtomicReference<>();
        this.zaq = false;
        this.zab = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zac = new WeakReference<>(null);
    }
}
