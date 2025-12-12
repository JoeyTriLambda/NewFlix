package l;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import lf.f;
import lf.h;
import qf.c;
import yf.p;
import zf.i;

/* loaded from: classes2.dex */
public final class b extends SuspendLambda implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f15631b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, c cVar) {
        super(2, cVar);
        this.f15631b = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final c create(Object obj, c cVar) {
        return new b(this.f15631b, cVar);
    }

    @Override // yf.p
    public final Object invoke(Object obj, Object obj2) {
        return new b(this.f15631b, (c) obj2).invokeSuspend(h.f16056a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        rf.a.getCOROUTINE_SUSPENDED();
        f.throwOnFailure(obj);
        try {
            URLConnection uRLConnectionOpenConnection = new URL("https://" + this.f15631b + "/resolve").openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(5000);
            uRLConnectionOpenConnection.setReadTimeout(5000);
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            InputStream inputStream = httpURLConnection.getInputStream();
            try {
                i.checkNotNullExpressionValue(inputStream, "it");
                Reader inputStreamReader = new InputStreamReader(inputStream, ig.c.f13440b);
                String line = (inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).readLine();
                wf.a.closeFinally(inputStream, null);
                httpURLConnection.disconnect();
                return line;
            } finally {
            }
        } catch (Throwable th2) {
            throw new d(th2);
        }
    }
}
