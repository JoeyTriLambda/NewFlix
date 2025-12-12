package d4;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;

/* compiled from: BaseHttpStack.java */
/* loaded from: classes.dex */
public abstract class a {
    public abstract f executeRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
