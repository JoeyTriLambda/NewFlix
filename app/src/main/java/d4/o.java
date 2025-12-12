package d4;

import android.content.Context;
import com.android.volley.RequestQueue;

/* compiled from: Volley.java */
/* loaded from: classes.dex */
public final class o {
    public static RequestQueue newRequestQueue(Context context, a aVar) {
        RequestQueue requestQueue = new RequestQueue(new d(new n(context.getApplicationContext())), aVar == null ? new b(new g()) : new b(aVar));
        requestQueue.start();
        return requestQueue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, null);
    }
}
