package com.google.firebase.sessions.settings;

import android.net.Uri;
import com.unity3d.services.core.request.metrics.MetricCommonTags;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import kg.g0;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import lf.h;
import org.json.JSONObject;
import qf.c;
import r9.b;
import sf.d;
import yf.p;
import zf.f;
import zf.i;

/* compiled from: RemoteSettingsFetcher.kt */
/* loaded from: classes.dex */
public final class RemoteSettingsFetcher implements s9.a {

    /* renamed from: a, reason: collision with root package name */
    public final b f9999a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f10000b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10001c;

    /* compiled from: RemoteSettingsFetcher.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    /* compiled from: RemoteSettingsFetcher.kt */
    @d(c = "com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2", f = "RemoteSettingsFetcher.kt", l = {68, 70, 73}, m = "invokeSuspend")
    /* renamed from: com.google.firebase.sessions.settings.RemoteSettingsFetcher$doConfigFetch$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<g0, c<? super h>, Object> {

        /* renamed from: b, reason: collision with root package name */
        public int f10002b;

        /* renamed from: n, reason: collision with root package name */
        public final /* synthetic */ Map<String, String> f10004n;

        /* renamed from: o, reason: collision with root package name */
        public final /* synthetic */ p<JSONObject, c<? super h>, Object> f10005o;

        /* renamed from: p, reason: collision with root package name */
        public final /* synthetic */ p<String, c<? super h>, Object> f10006p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Map<String, String> map, p<? super JSONObject, ? super c<? super h>, ? extends Object> pVar, p<? super String, ? super c<? super h>, ? extends Object> pVar2, c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.f10004n = map;
            this.f10005o = pVar;
            this.f10006p = pVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final c<h> create(Object obj, c<?> cVar) {
            return RemoteSettingsFetcher.this.new AnonymousClass2(this.f10004n, this.f10005o, this.f10006p, cVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = rf.a.getCOROUTINE_SUSPENDED();
            int i10 = this.f10002b;
            p<String, c<? super h>, Object> pVar = this.f10006p;
            try {
                if (i10 == 0) {
                    lf.f.throwOnFailure(obj);
                    URLConnection uRLConnectionOpenConnection = RemoteSettingsFetcher.access$settingsUrl(RemoteSettingsFetcher.this).openConnection();
                    i.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnectionOpenConnection;
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setRequestProperty("Accept", "application/json");
                    for (Map.Entry<String, String> entry : this.f10004n.entrySet()) {
                        httpsURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                    int responseCode = httpsURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        InputStream inputStream = httpsURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        StringBuilder sb2 = new StringBuilder();
                        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                        while (true) {
                            ?? line = bufferedReader.readLine();
                            ref$ObjectRef.f15262b = line;
                            if (line == 0) {
                                break;
                            }
                            sb2.append((String) line);
                        }
                        bufferedReader.close();
                        inputStream.close();
                        JSONObject jSONObject = new JSONObject(sb2.toString());
                        p<JSONObject, c<? super h>, Object> pVar2 = this.f10005o;
                        this.f10002b = 1;
                        if (pVar2.invoke(jSONObject, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        String str = "Bad response code: " + responseCode;
                        this.f10002b = 2;
                        if (pVar.invoke(str, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i10 != 1 && i10 != 2 && i10 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lf.f.throwOnFailure(obj);
                }
            } catch (Exception e10) {
                String message = e10.getMessage();
                if (message == null) {
                    message = e10.toString();
                }
                this.f10002b = 3;
                if (pVar.invoke(message, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return h.f16056a;
        }

        @Override // yf.p
        public final Object invoke(g0 g0Var, c<? super h> cVar) {
            return ((AnonymousClass2) create(g0Var, cVar)).invokeSuspend(h.f16056a);
        }
    }

    static {
        new a(null);
    }

    public RemoteSettingsFetcher(b bVar, CoroutineContext coroutineContext, String str) {
        i.checkNotNullParameter(bVar, "appInfo");
        i.checkNotNullParameter(coroutineContext, "blockingDispatcher");
        i.checkNotNullParameter(str, "baseUrl");
        this.f9999a = bVar;
        this.f10000b = coroutineContext;
        this.f10001c = str;
    }

    public static final URL access$settingsUrl(RemoteSettingsFetcher remoteSettingsFetcher) {
        remoteSettingsFetcher.getClass();
        Uri.Builder builderAppendPath = new Uri.Builder().scheme("https").authority(remoteSettingsFetcher.f10001c).appendPath("spi").appendPath("v2").appendPath("platforms").appendPath(MetricCommonTags.METRIC_COMMON_TAG_PLATFORM_ANDROID).appendPath("gmp");
        b bVar = remoteSettingsFetcher.f9999a;
        return new URL(builderAppendPath.appendPath(bVar.getAppId()).appendPath("settings").appendQueryParameter("build_version", bVar.getAndroidAppInfo().getAppBuildVersion()).appendQueryParameter("display_version", bVar.getAndroidAppInfo().getVersionName()).build().toString());
    }

    @Override // s9.a
    public Object doConfigFetch(Map<String, String> map, p<? super JSONObject, ? super c<? super h>, ? extends Object> pVar, p<? super String, ? super c<? super h>, ? extends Object> pVar2, c<? super h> cVar) {
        Object objWithContext = kg.f.withContext(this.f10000b, new AnonymousClass2(map, pVar, pVar2, null), cVar);
        return objWithContext == rf.a.getCOROUTINE_SUSPENDED() ? objWithContext : h.f16056a;
    }

    public /* synthetic */ RemoteSettingsFetcher(b bVar, CoroutineContext coroutineContext, String str, int i10, f fVar) {
        this(bVar, coroutineContext, (i10 & 4) != 0 ? "firebase-settings.crashlytics.com" : str);
    }
}
