package t4;

import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: LogSourceMetrics.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19409a;

    /* renamed from: b, reason: collision with root package name */
    public final List<LogEventDropped> f19410b;

    /* compiled from: LogSourceMetrics.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f19411a = "";

        /* renamed from: b, reason: collision with root package name */
        public List<LogEventDropped> f19412b = new ArrayList();

        public c build() {
            return new c(this.f19411a, Collections.unmodifiableList(this.f19412b));
        }

        public a setLogEventDroppedList(List<LogEventDropped> list) {
            this.f19412b = list;
            return this;
        }

        public a setLogSource(String str) {
            this.f19411a = str;
            return this;
        }
    }

    static {
        new a().build();
    }

    public c(String str, List<LogEventDropped> list) {
        this.f19409a = str;
        this.f19410b = list;
    }

    public static a newBuilder() {
        return new a();
    }

    @Protobuf
    public List<LogEventDropped> getLogEventDroppedList() {
        return this.f19410b;
    }

    @Protobuf
    public String getLogSource() {
        return this.f19409a;
    }
}
