package com.google.firebase.encoders.proto;

import b9.c;
import b9.d;
import b9.e;
import b9.f;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.proto.a;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ProtobufDataEncoderContext.java */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f9789f = Charset.forName("UTF-8");

    /* renamed from: g, reason: collision with root package name */
    public static final c f9790g = c.builder("key").withProperty(a.builder().tag(1).build()).build();

    /* renamed from: h, reason: collision with root package name */
    public static final c f9791h = c.builder("value").withProperty(a.builder().tag(2).build()).build();

    /* renamed from: i, reason: collision with root package name */
    public static final d9.a f9792i = new d9.a(1);

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f9793a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<Class<?>, d<?>> f9794b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<Class<?>, f<?>> f9795c;

    /* renamed from: d, reason: collision with root package name */
    public final d<Object> f9796d;

    /* renamed from: e, reason: collision with root package name */
    public final e9.d f9797e = new e9.d(this);

    public b(OutputStream outputStream, Map<Class<?>, d<?>> map, Map<Class<?>, f<?>> map2, d<Object> dVar) {
        this.f9793a = outputStream;
        this.f9794b = map;
        this.f9795c = map2;
        this.f9796d = dVar;
    }

    public static int f(c cVar) {
        Protobuf protobuf = (Protobuf) cVar.getProperty(Protobuf.class);
        if (protobuf != null) {
            return ((a.C0100a) protobuf).tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    public final b a(c cVar, Object obj, boolean z10) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z10 && charSequence.length() == 0) {
                return this;
            }
            g((f(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f9789f);
            g(bytes.length);
            this.f9793a.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                a(cVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                e(f9792i, cVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            b(cVar, ((Double) obj).doubleValue(), z10);
            return this;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (!z10 || fFloatValue != 0.0f) {
                g((f(cVar) << 3) | 5);
                this.f9793a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            }
            return this;
        }
        if (obj instanceof Number) {
            d(cVar, ((Number) obj).longValue(), z10);
            return this;
        }
        if (obj instanceof Boolean) {
            c(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z10);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z10 && bArr.length == 0) {
                return this;
            }
            g((f(cVar) << 3) | 2);
            g(bArr.length);
            this.f9793a.write(bArr);
            return this;
        }
        d<?> dVar = this.f9794b.get(obj.getClass());
        if (dVar != null) {
            e(dVar, cVar, obj, z10);
            return this;
        }
        f<?> fVar = this.f9795c.get(obj.getClass());
        if (fVar != null) {
            e9.d dVar2 = this.f9797e;
            dVar2.f11179a = false;
            dVar2.f11181c = cVar;
            dVar2.f11180b = z10;
            fVar.encode(obj, dVar2);
            return this;
        }
        if (obj instanceof e9.b) {
            return add(cVar, ((e9.b) obj).getNumber());
        }
        if (obj instanceof Enum) {
            return add(cVar, ((Enum) obj).ordinal());
        }
        e(this.f9796d, cVar, obj, z10);
        return this;
    }

    public final void b(c cVar, double d10, boolean z10) throws IOException {
        if (z10 && d10 == 0.0d) {
            return;
        }
        g((f(cVar) << 3) | 1);
        this.f9793a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(d10).array());
    }

    public final void c(c cVar, int i10, boolean z10) throws IOException {
        if (z10 && i10 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) cVar.getProperty(Protobuf.class);
        if (protobuf == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        a.C0100a c0100a = (a.C0100a) protobuf;
        int iOrdinal = c0100a.intEncoding().ordinal();
        if (iOrdinal == 0) {
            g(c0100a.tag() << 3);
            g(i10);
        } else if (iOrdinal == 1) {
            g(c0100a.tag() << 3);
            g((i10 << 1) ^ (i10 >> 31));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            g((c0100a.tag() << 3) | 5);
            this.f9793a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i10).array());
        }
    }

    public final void d(c cVar, long j10, boolean z10) throws IOException {
        if (z10 && j10 == 0) {
            return;
        }
        Protobuf protobuf = (Protobuf) cVar.getProperty(Protobuf.class);
        if (protobuf == null) {
            throw new EncodingException("Field has no @Protobuf config");
        }
        a.C0100a c0100a = (a.C0100a) protobuf;
        int iOrdinal = c0100a.intEncoding().ordinal();
        if (iOrdinal == 0) {
            g(c0100a.tag() << 3);
            h(j10);
        } else if (iOrdinal == 1) {
            g(c0100a.tag() << 3);
            h((j10 >> 63) ^ (j10 << 1));
        } else {
            if (iOrdinal != 2) {
                return;
            }
            g((c0100a.tag() << 3) | 1);
            this.f9793a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(j10).array());
        }
    }

    public final void e(d dVar, c cVar, Object obj, boolean z10) throws IOException {
        e9.a aVar = new e9.a();
        try {
            OutputStream outputStream = this.f9793a;
            this.f9793a = aVar;
            try {
                dVar.encode(obj, this);
                this.f9793a = outputStream;
                long j10 = aVar.f11171b;
                aVar.close();
                if (z10 && j10 == 0) {
                    return;
                }
                g((f(cVar) << 3) | 2);
                h(j10);
                dVar.encode(obj, this);
            } catch (Throwable th2) {
                this.f9793a = outputStream;
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                aVar.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public final void g(int i10) throws IOException {
        while ((i10 & (-128)) != 0) {
            this.f9793a.write((i10 & 127) | 128);
            i10 >>>= 7;
        }
        this.f9793a.write(i10 & 127);
    }

    public final void h(long j10) throws IOException {
        while (((-128) & j10) != 0) {
            this.f9793a.write((((int) j10) & 127) | 128);
            j10 >>>= 7;
        }
        this.f9793a.write(((int) j10) & 127);
    }

    @Override // b9.e
    public e add(c cVar, Object obj) throws IOException {
        return a(cVar, obj, true);
    }

    @Override // b9.e
    public e add(c cVar, double d10) throws IOException {
        b(cVar, d10, true);
        return this;
    }

    @Override // b9.e
    public b add(c cVar, int i10) throws IOException {
        c(cVar, i10, true);
        return this;
    }

    @Override // b9.e
    public b add(c cVar, long j10) throws IOException {
        d(cVar, j10, true);
        return this;
    }

    @Override // b9.e
    public b add(c cVar, boolean z10) throws IOException {
        c(cVar, z10 ? 1 : 0, true);
        return this;
    }
}
