package com.google.gson.internal.bind;

import com.google.gson.l;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.s;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

/* compiled from: JsonTreeWriter.java */
/* loaded from: classes.dex */
public final class c extends z9.b {
    public static final a A = new a();
    public static final s B = new s("closed");

    /* renamed from: x, reason: collision with root package name */
    public final ArrayList f10194x;

    /* renamed from: y, reason: collision with root package name */
    public String f10195y;

    /* renamed from: z, reason: collision with root package name */
    public o f10196z;

    /* compiled from: JsonTreeWriter.java */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    public c() {
        super(A);
        this.f10194x = new ArrayList();
        this.f10196z = p.f10239b;
    }

    @Override // z9.b
    public z9.b beginArray() throws IOException {
        l lVar = new l();
        h(lVar);
        this.f10194x.add(lVar);
        return this;
    }

    @Override // z9.b
    public z9.b beginObject() throws IOException {
        q qVar = new q();
        h(qVar);
        this.f10194x.add(qVar);
        return this;
    }

    @Override // z9.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ArrayList arrayList = this.f10194x;
        if (!arrayList.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        arrayList.add(B);
    }

    @Override // z9.b
    public z9.b endArray() throws IOException {
        ArrayList arrayList = this.f10194x;
        if (arrayList.isEmpty() || this.f10195y != null) {
            throw new IllegalStateException();
        }
        if (!(g() instanceof l)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
        return this;
    }

    @Override // z9.b
    public z9.b endObject() throws IOException {
        ArrayList arrayList = this.f10194x;
        if (arrayList.isEmpty() || this.f10195y != null) {
            throw new IllegalStateException();
        }
        if (!(g() instanceof q)) {
            throw new IllegalStateException();
        }
        arrayList.remove(arrayList.size() - 1);
        return this;
    }

    public final o g() {
        return (o) this.f10194x.get(r0.size() - 1);
    }

    public o get() {
        ArrayList arrayList = this.f10194x;
        if (arrayList.isEmpty()) {
            return this.f10196z;
        }
        throw new IllegalStateException("Expected one JSON element but was " + arrayList);
    }

    public final void h(o oVar) {
        if (this.f10195y != null) {
            if (!oVar.isJsonNull() || getSerializeNulls()) {
                ((q) g()).add(this.f10195y, oVar);
            }
            this.f10195y = null;
            return;
        }
        if (this.f10194x.isEmpty()) {
            this.f10196z = oVar;
            return;
        }
        o oVarG = g();
        if (!(oVarG instanceof l)) {
            throw new IllegalStateException();
        }
        ((l) oVarG).add(oVar);
    }

    @Override // z9.b
    public z9.b name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f10194x.isEmpty() || this.f10195y != null) {
            throw new IllegalStateException();
        }
        if (!(g() instanceof q)) {
            throw new IllegalStateException();
        }
        this.f10195y = str;
        return this;
    }

    @Override // z9.b
    public z9.b nullValue() throws IOException {
        h(p.f10239b);
        return this;
    }

    @Override // z9.b
    public z9.b value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        h(new s(str));
        return this;
    }

    @Override // z9.b
    public z9.b value(boolean z10) throws IOException {
        h(new s(Boolean.valueOf(z10)));
        return this;
    }

    @Override // z9.b
    public z9.b value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        h(new s(bool));
        return this;
    }

    @Override // z9.b
    public z9.b value(long j10) throws IOException {
        h(new s(Long.valueOf(j10)));
        return this;
    }

    @Override // z9.b
    public z9.b value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        h(new s(number));
        return this;
    }

    @Override // z9.b, java.io.Flushable
    public void flush() throws IOException {
    }
}
