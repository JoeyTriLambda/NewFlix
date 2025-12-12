package ke;

import android.content.Context;
import android.util.LruCache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import d4.h;
import d4.o;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f15086a;

    /* renamed from: b, reason: collision with root package name */
    public RequestQueue f15087b;

    /* renamed from: ke.a$a, reason: collision with other inner class name */
    public class C0179a implements h.a {
        public C0179a() {
            new LruCache(20);
        }
    }

    public class b implements RequestQueue.RequestFilter {
        @Override // com.android.volley.RequestQueue.RequestFilter
        public boolean apply(Request<?> request) {
            return true;
        }
    }

    public a(Context context) {
        this.f15086a = context;
        RequestQueue requestQueueA = a();
        this.f15087b = requestQueueA;
        new h(requestQueueA, new C0179a());
    }

    public RequestQueue a() {
        if (this.f15087b == null) {
            this.f15087b = o.newRequestQueue(this.f15086a.getApplicationContext());
        }
        return this.f15087b;
    }

    public void b() {
        RequestQueue requestQueue = this.f15087b;
        if (requestQueue != null) {
            requestQueue.start();
        }
    }

    public void c() {
        RequestQueue requestQueue = this.f15087b;
        if (requestQueue != null) {
            requestQueue.cancelAll((RequestQueue.RequestFilter) new b());
            this.f15087b.stop();
        }
    }

    public <T> void a(Request<T> request) {
        a().add(request);
    }
}
