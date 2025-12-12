package d4;

import com.android.volley.Header;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* compiled from: HttpResponse.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f10833a;

    /* renamed from: b, reason: collision with root package name */
    public final List<Header> f10834b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10835c;

    /* renamed from: d, reason: collision with root package name */
    public final InputStream f10836d;

    public f(int i10, List<Header> list) {
        this(i10, list, -1, null);
    }

    public final InputStream getContent() {
        InputStream inputStream = this.f10836d;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public final int getContentLength() {
        return this.f10835c;
    }

    public final List<Header> getHeaders() {
        return Collections.unmodifiableList(this.f10834b);
    }

    public final int getStatusCode() {
        return this.f10833a;
    }

    public f(int i10, List<Header> list, int i11, InputStream inputStream) {
        this.f10833a = i10;
        this.f10834b = list;
        this.f10835c = i11;
        this.f10836d = inputStream;
    }
}
