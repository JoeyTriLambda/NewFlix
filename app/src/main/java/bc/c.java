package bc;

import android.os.Build;
import android.util.Log;
import com.google.gson.j;
import fd.g;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import okhttp3.ConnectionSpec;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* compiled from: TraktMovieApiRequest.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static d f4853a;

    /* renamed from: b, reason: collision with root package name */
    public static d f4854b;

    /* renamed from: c, reason: collision with root package name */
    public static d f4855c;

    /* renamed from: d, reason: collision with root package name */
    public static d f4856d;

    /* renamed from: e, reason: collision with root package name */
    public static d f4857e;

    /* compiled from: TraktMovieApiRequest.java */
    public class a implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return chain.proceed(request.newBuilder().header("User-Agent", "MacOS").method(request.method(), request.body()).build());
        }
    }

    /* compiled from: TraktMovieApiRequest.java */
    public class b implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            return chain.proceed(request.newBuilder().header("User-Agent", "MacOS").method(request.method(), request.body()).build());
        }
    }

    /* compiled from: TraktMovieApiRequest.java */
    /* renamed from: bc.c$c, reason: collision with other inner class name */
    public class C0057c implements Interceptor {
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            chain.request();
            return chain.proceed(chain.request());
        }
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) throws NoSuchAlgorithmException, KeyManagementException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1.2");
            sSLContext.init(null, null, null);
            builder.sslSocketFactory(new g(sSLContext.getSocketFactory()));
            ConnectionSpec connectionSpecBuild = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_2).build();
            ArrayList arrayList = new ArrayList();
            arrayList.add(connectionSpecBuild);
            arrayList.add(ConnectionSpec.COMPATIBLE_TLS);
            arrayList.add(ConnectionSpec.CLEARTEXT);
            builder.connectionSpecs(arrayList);
        } catch (Exception e10) {
            Log.e("OkHttpTLSCompat", "Error while setting TLS 1.2", e10);
        }
        return builder;
    }

    public static d getInstanceAllDebridAPI() {
        if (f4854b == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            f4854b = (d) new Retrofit.Builder().baseUrl("https://api.alldebrid.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build().create(d.class);
        }
        return f4854b;
    }

    public static d getInstanceDebrid() {
        if (f4855c == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            f4855c = (d) new Retrofit.Builder().baseUrl("https://api.real-debrid.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build().create(d.class);
        }
        return f4855c;
    }

    public static d getInstanceFlix(String str) {
        d dVar = (d) new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create(new j().setLenient().create())).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new a()).build()).build().create(d.class);
        f4853a = dVar;
        return dVar;
    }

    public static d getInstanceHDO(String str) {
        d dVar = (d) new Retrofit.Builder().baseUrl(str).addConverterFactory(ScalarsConverterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new b()).build()).build().create(d.class);
        f4853a = dVar;
        return dVar;
    }

    public static d getInstancePremiumizeAPI() {
        if (f4854b == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            f4854b = (d) new Retrofit.Builder().baseUrl("https://www.premiumize.me").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()).build().create(d.class);
        }
        return f4854b;
    }

    public static OkHttpClient getNewHttpClient() {
        if (Build.VERSION.SDK_INT < 22) {
            OkHttpClient.Builder builderCache = new OkHttpClient.Builder().followRedirects(true).followSslRedirects(true).retryOnConnectionFailure(true).cache(null);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return enableTls12OnPreLollipop(builderCache.connectTimeout(15L, timeUnit).writeTimeout(15L, timeUnit).readTimeout(15L, timeUnit)).build();
        }
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    public static d getRequest(String str) {
        if (f4857e == null) {
            f4857e = (d) new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(new OkHttpClient.Builder().addInterceptor(new C0057c()).build()).build().create(d.class);
        }
        return f4857e;
    }

    public static d getRequestTmdb() {
        if (f4856d == null) {
            f4856d = (d) new Retrofit.Builder().baseUrl("https://api.themoviedb.org").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).client(getNewHttpClient()).build().create(d.class);
        }
        return f4856d;
    }
}
