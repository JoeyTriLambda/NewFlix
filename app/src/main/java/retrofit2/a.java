package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18948b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f18949m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Callback f18950n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f18951o;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i10) {
        this.f18948b = i10;
        this.f18949m = anonymousClass1;
        this.f18950n = callback;
        this.f18951o = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f18948b;
        Callback callback = this.f18950n;
        DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1 = this.f18949m;
        Object obj = this.f18951o;
        switch (i10) {
            case 0:
                anonymousClass1.lambda$onResponse$0(callback, (Response) obj);
                break;
            default:
                anonymousClass1.lambda$onFailure$1(callback, (Throwable) obj);
                break;
        }
    }
}
