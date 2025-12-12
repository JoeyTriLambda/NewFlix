package e9;

import b9.f;
import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ProtobufEncoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, b9.d<?>> f11172a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f11173b;

    /* renamed from: c, reason: collision with root package name */
    public final b9.d<Object> f11174c;

    /* compiled from: ProtobufEncoder.java */
    public static final class a implements c9.b<a> {

        /* renamed from: d, reason: collision with root package name */
        public static final d9.a f11175d = new d9.a(2);

        /* renamed from: a, reason: collision with root package name */
        public final HashMap f11176a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final HashMap f11177b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final d9.a f11178c = f11175d;

        public c build() {
            return new c(new HashMap(this.f11176a), new HashMap(this.f11177b), this.f11178c);
        }

        public a configureWith(c9.a aVar) {
            aVar.configure(this);
            return this;
        }

        @Override // c9.b
        public <U> a registerEncoder(Class<U> cls, b9.d<? super U> dVar) {
            this.f11176a.put(cls, dVar);
            this.f11177b.remove(cls);
            return this;
        }
    }

    public c(HashMap map, HashMap map2, d9.a aVar) {
        this.f11172a = map;
        this.f11173b = map2;
        this.f11174c = aVar;
    }

    public static a builder() {
        return new a();
    }

    public void encode(Object obj, OutputStream outputStream) throws IOException {
        Map<Class<?>, f<?>> map = this.f11173b;
        b9.d<Object> dVar = this.f11174c;
        Map<Class<?>, b9.d<?>> map2 = this.f11172a;
        com.google.firebase.encoders.proto.b bVar = new com.google.firebase.encoders.proto.b(outputStream, map2, map, dVar);
        if (obj == null) {
            return;
        }
        b9.d<?> dVar2 = map2.get(obj.getClass());
        if (dVar2 != null) {
            dVar2.encode(obj, bVar);
        } else {
            throw new EncodingException("No encoder for " + obj.getClass());
        }
    }

    public byte[] encode(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            encode(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
