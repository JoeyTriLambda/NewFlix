package d9;

import b9.f;
import b9.g;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JsonDataEncoderBuilder.java */
/* loaded from: classes.dex */
public final class c implements c9.b<c> {

    /* renamed from: f, reason: collision with root package name */
    public static final d9.b f10956f;

    /* renamed from: g, reason: collision with root package name */
    public static final d9.b f10957g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10959a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f10960b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final d9.a f10961c = f10955e;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10962d = false;

    /* renamed from: e, reason: collision with root package name */
    public static final d9.a f10955e = new d9.a(0);

    /* renamed from: h, reason: collision with root package name */
    public static final b f10958h = new b();

    /* compiled from: JsonDataEncoderBuilder.java */
    public static final class b implements f<Date> {

        /* renamed from: a, reason: collision with root package name */
        public static final SimpleDateFormat f10964a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f10964a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        @Override // b9.b
        public void encode(Date date, g gVar) throws IOException {
            gVar.add(f10964a.format(date));
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [d9.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [d9.b] */
    static {
        final int i10 = 0;
        f10956f = new f() { // from class: d9.b
            @Override // b9.b
            public final void encode(Object obj, g gVar) throws IOException {
                switch (i10) {
                    case 0:
                        gVar.add((String) obj);
                        break;
                    default:
                        gVar.add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i11 = 1;
        f10957g = new f() { // from class: d9.b
            @Override // b9.b
            public final void encode(Object obj, g gVar) throws IOException {
                switch (i11) {
                    case 0:
                        gVar.add((String) obj);
                        break;
                    default:
                        gVar.add(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public c() {
        registerEncoder(String.class, f10956f);
        registerEncoder(Boolean.class, f10957g);
        registerEncoder(Date.class, f10958h);
    }

    public b9.a build() {
        return new a();
    }

    public c configureWith(c9.a aVar) {
        aVar.configure(this);
        return this;
    }

    public c ignoreNullValues(boolean z10) {
        this.f10962d = z10;
        return this;
    }

    @Override // c9.b
    public <T> c registerEncoder(Class<T> cls, b9.d<? super T> dVar) {
        this.f10959a.put(cls, dVar);
        this.f10960b.remove(cls);
        return this;
    }

    public <T> c registerEncoder(Class<T> cls, f<? super T> fVar) {
        this.f10960b.put(cls, fVar);
        this.f10959a.remove(cls);
        return this;
    }

    /* compiled from: JsonDataEncoderBuilder.java */
    public class a implements b9.a {
        public a() {
        }

        public void encode(Object obj, Writer writer) throws IOException {
            c cVar = c.this;
            d dVar = new d(writer, cVar.f10959a, cVar.f10960b, cVar.f10961c, cVar.f10962d);
            dVar.a(obj);
            dVar.b();
            dVar.f10966b.flush();
        }

        public String encode(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                encode(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }
}
