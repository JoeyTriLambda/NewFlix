package d9;

import android.util.Base64;
import android.util.JsonWriter;
import b9.f;
import b9.g;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: JsonValueObjectEncoderContext.java */
/* loaded from: classes.dex */
public final class d implements b9.e, g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10965a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f10966b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, b9.d<?>> f10967c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f10968d;

    /* renamed from: e, reason: collision with root package name */
    public final b9.d<Object> f10969e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10970f;

    public d(Writer writer, HashMap map, HashMap map2, a aVar, boolean z10) {
        this.f10966b = new JsonWriter(writer);
        this.f10967c = map;
        this.f10968d = map2;
        this.f10969e = aVar;
        this.f10970f = z10;
    }

    public final d a(Object obj) throws IOException {
        JsonWriter jsonWriter = this.f10966b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        int i10 = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        add((String) key, entry.getValue());
                    } catch (ClassCastException e10) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e10);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            b9.d<?> dVar = this.f10967c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.encode(obj, this);
                jsonWriter.endObject();
                return this;
            }
            f<?> fVar = this.f10968d.get(obj.getClass());
            if (fVar != null) {
                fVar.encode(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                if (obj instanceof e) {
                    add(((e) obj).getNumber());
                } else {
                    add(((Enum) obj).name());
                }
                return this;
            }
            jsonWriter.beginObject();
            this.f10969e.encode(obj, this);
            jsonWriter.endObject();
            return this;
        }
        if (obj instanceof byte[]) {
            return add((byte[]) obj);
        }
        jsonWriter.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i10 < length) {
                jsonWriter.value(r6[i10]);
                i10++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i10 < length2) {
                add(jArr[i10]);
                i10++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i10 < length3) {
                jsonWriter.value(dArr[i10]);
                i10++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i10 < length4) {
                jsonWriter.value(zArr[i10]);
                i10++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i10 < length5) {
                a(numberArr[i10]);
                i10++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i10 < length6) {
                a(objArr[i10]);
                i10++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final void b() throws IOException {
        if (!this.f10965a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }

    public d add(String str, Object obj) throws IOException {
        boolean z10 = this.f10970f;
        JsonWriter jsonWriter = this.f10966b;
        if (z10) {
            if (obj == null) {
                return this;
            }
            b();
            jsonWriter.name(str);
            return a(obj);
        }
        b();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        return a(obj);
    }

    public d add(String str, double d10) throws IOException {
        b();
        this.f10966b.name(str);
        return add(d10);
    }

    public d add(String str, int i10) throws IOException {
        b();
        this.f10966b.name(str);
        return add(i10);
    }

    public d add(String str, long j10) throws IOException {
        b();
        this.f10966b.name(str);
        return add(j10);
    }

    public d add(String str, boolean z10) throws IOException {
        b();
        this.f10966b.name(str);
        return add(z10);
    }

    @Override // b9.e
    public b9.e add(b9.c cVar, Object obj) throws IOException {
        return add(cVar.getName(), obj);
    }

    @Override // b9.e
    public b9.e add(b9.c cVar, double d10) throws IOException {
        return add(cVar.getName(), d10);
    }

    @Override // b9.e
    public b9.e add(b9.c cVar, int i10) throws IOException {
        return add(cVar.getName(), i10);
    }

    @Override // b9.e
    public b9.e add(b9.c cVar, long j10) throws IOException {
        return add(cVar.getName(), j10);
    }

    @Override // b9.e
    public b9.e add(b9.c cVar, boolean z10) throws IOException {
        return add(cVar.getName(), z10);
    }

    @Override // b9.g
    public d add(String str) throws IOException {
        b();
        this.f10966b.value(str);
        return this;
    }

    public d add(double d10) throws IOException {
        b();
        this.f10966b.value(d10);
        return this;
    }

    public d add(int i10) throws IOException {
        b();
        this.f10966b.value(i10);
        return this;
    }

    public d add(long j10) throws IOException {
        b();
        this.f10966b.value(j10);
        return this;
    }

    @Override // b9.g
    public d add(boolean z10) throws IOException {
        b();
        this.f10966b.value(z10);
        return this;
    }

    public d add(byte[] bArr) throws IOException {
        b();
        JsonWriter jsonWriter = this.f10966b;
        if (bArr == null) {
            jsonWriter.nullValue();
        } else {
            jsonWriter.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }
}
