package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import zf.i;

/* compiled from: RealInterceptorChain.kt */
/* loaded from: classes2.dex */
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall realCall, List<? extends Interceptor> list, int i10, Exchange exchange, Request request, int i11, int i12, int i13) {
        i.checkNotNullParameter(realCall, "call");
        i.checkNotNullParameter(list, "interceptors");
        i.checkNotNullParameter(request, "request");
        this.call = realCall;
        this.interceptors = list;
        this.index = i10;
        this.exchange = exchange;
        this.request = request;
        this.connectTimeoutMillis = i11;
        this.readTimeoutMillis = i12;
        this.writeTimeoutMillis = i13;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain realInterceptorChain, int i10, Exchange exchange, Request request, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = realInterceptorChain.index;
        }
        if ((i14 & 2) != 0) {
            exchange = realInterceptorChain.exchange;
        }
        Exchange exchange2 = exchange;
        if ((i14 & 4) != 0) {
            request = realInterceptorChain.request;
        }
        Request request2 = request;
        if ((i14 & 8) != 0) {
            i11 = realInterceptorChain.connectTimeoutMillis;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = realInterceptorChain.readTimeoutMillis;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = realInterceptorChain.writeTimeoutMillis;
        }
        return realInterceptorChain.copy$okhttp(i10, exchange2, request2, i15, i16, i13);
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange exchange = this.exchange;
        if (exchange == null) {
            return null;
        }
        return exchange.getConnection$okhttp();
    }

    public final RealInterceptorChain copy$okhttp(int i10, Exchange exchange, Request request, int i11, int i12, int i13) {
        i.checkNotNullParameter(request, "request");
        return new RealInterceptorChain(this.call, this.interceptors, i10, exchange, request, i11, i12, i13);
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request request) throws IOException {
        i.checkNotNullParameter(request, "request");
        if (!(this.index < this.interceptors.size())) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.calls++;
        Exchange exchange = this.exchange;
        if (exchange != null) {
            if (!exchange.getFinder$okhttp().sameHostAndPort(request.url())) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
            }
            if (!(this.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
            }
        }
        RealInterceptorChain realInterceptorChainCopy$okhttp$default = copy$okhttp$default(this, this.index + 1, null, request, 0, 0, 0, 58, null);
        Interceptor interceptor = this.interceptors.get(this.index);
        Response responseIntercept = interceptor.intercept(realInterceptorChainCopy$okhttp$default);
        if (responseIntercept == null) {
            throw new NullPointerException("interceptor " + interceptor + " returned null");
        }
        if (this.exchange != null) {
            if (!(this.index + 1 >= this.interceptors.size() || realInterceptorChainCopy$okhttp$default.calls == 1)) {
                throw new IllegalStateException(("network interceptor " + interceptor + " must call proceed() exactly once").toString());
            }
        }
        if (responseIntercept.body() != null) {
            return responseIntercept;
        }
        throw new IllegalStateException(("interceptor " + interceptor + " returned a response with no body").toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int i10, TimeUnit timeUnit) {
        i.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", i10, timeUnit), 0, 0, 55, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int i10, TimeUnit timeUnit) {
        i.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", i10, timeUnit), 0, 47, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int i10, TimeUnit timeUnit) {
        i.checkNotNullParameter(timeUnit, "unit");
        if (this.exchange == null) {
            return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", i10, timeUnit), 31, null);
        }
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
