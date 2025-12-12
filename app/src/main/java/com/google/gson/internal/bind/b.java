package com.google.gson.internal.bind;

import com.google.gson.l;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.s;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* compiled from: JsonTreeReader.java */
/* loaded from: classes.dex */
public final class b extends z9.a {
    public static final Object E;
    public Object[] A;
    public int B;
    public String[] C;
    public int[] D;

    /* compiled from: JsonTreeReader.java */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        new a();
        E = new Object();
    }

    private String d(boolean z10) {
        StringBuilder sb2 = new StringBuilder("$");
        int i10 = 0;
        while (true) {
            int i11 = this.B;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.A;
            Object obj = objArr[i10];
            if (obj instanceof l) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.D[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof q) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                String str = this.C[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    private String f() {
        return " at path " + getPath();
    }

    @Override // z9.a
    public void beginArray() throws IOException {
        o(JsonToken.BEGIN_ARRAY);
        r(((l) p()).iterator());
        this.D[this.B - 1] = 0;
    }

    @Override // z9.a
    public void beginObject() throws IOException {
        o(JsonToken.BEGIN_OBJECT);
        r(((q) p()).entrySet().iterator());
    }

    @Override // z9.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.A = new Object[]{E};
        this.B = 1;
    }

    @Override // z9.a
    public void endArray() throws IOException {
        o(JsonToken.END_ARRAY);
        q();
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // z9.a
    public void endObject() throws IOException {
        o(JsonToken.END_OBJECT);
        q();
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // z9.a
    public String getPath() {
        return d(false);
    }

    @Override // z9.a
    public String getPreviousPath() {
        return d(true);
    }

    @Override // z9.a
    public boolean hasNext() throws IOException {
        JsonToken jsonTokenPeek = peek();
        return (jsonTokenPeek == JsonToken.END_OBJECT || jsonTokenPeek == JsonToken.END_ARRAY || jsonTokenPeek == JsonToken.END_DOCUMENT) ? false : true;
    }

    @Override // z9.a
    public boolean nextBoolean() throws IOException {
        o(JsonToken.BOOLEAN);
        boolean asBoolean = ((s) q()).getAsBoolean();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asBoolean;
    }

    @Override // z9.a
    public double nextDouble() throws IOException {
        JsonToken jsonTokenPeek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenPeek != jsonToken && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenPeek + f());
        }
        double asDouble = ((s) p()).getAsDouble();
        if (!isLenient() && (Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
        }
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asDouble;
    }

    @Override // z9.a
    public int nextInt() throws IOException {
        JsonToken jsonTokenPeek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenPeek != jsonToken && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenPeek + f());
        }
        int asInt = ((s) p()).getAsInt();
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asInt;
    }

    @Override // z9.a
    public long nextLong() throws IOException {
        JsonToken jsonTokenPeek = peek();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (jsonTokenPeek != jsonToken && jsonTokenPeek != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenPeek + f());
        }
        long asLong = ((s) p()).getAsLong();
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asLong;
    }

    @Override // z9.a
    public String nextName() throws IOException {
        o(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p()).next();
        String str = (String) entry.getKey();
        this.C[this.B - 1] = str;
        r(entry.getValue());
        return str;
    }

    @Override // z9.a
    public void nextNull() throws IOException {
        o(JsonToken.NULL);
        q();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // z9.a
    public String nextString() throws IOException {
        JsonToken jsonTokenPeek = peek();
        JsonToken jsonToken = JsonToken.STRING;
        if (jsonTokenPeek != jsonToken && jsonTokenPeek != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + jsonTokenPeek + f());
        }
        String asString = ((s) q()).getAsString();
        int i10 = this.B;
        if (i10 > 0) {
            int[] iArr = this.D;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return asString;
    }

    public final void o(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + peek() + f());
    }

    public final Object p() {
        return this.A[this.B - 1];
    }

    @Override // z9.a
    public JsonToken peek() throws IOException {
        if (this.B == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object objP = p();
        if (objP instanceof Iterator) {
            boolean z10 = this.A[this.B - 2] instanceof q;
            Iterator it = (Iterator) objP;
            if (!it.hasNext()) {
                return z10 ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z10) {
                return JsonToken.NAME;
            }
            r(it.next());
            return peek();
        }
        if (objP instanceof q) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (objP instanceof l) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(objP instanceof s)) {
            if (objP instanceof p) {
                return JsonToken.NULL;
            }
            if (objP == E) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        s sVar = (s) objP;
        if (sVar.isString()) {
            return JsonToken.STRING;
        }
        if (sVar.isBoolean()) {
            return JsonToken.BOOLEAN;
        }
        if (sVar.isNumber()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    public void promoteNameToValue() throws IOException {
        o(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) p()).next();
        r(entry.getValue());
        r(new s((String) entry.getKey()));
    }

    public final Object q() {
        Object[] objArr = this.A;
        int i10 = this.B - 1;
        this.B = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    public final void r(Object obj) {
        int i10 = this.B;
        Object[] objArr = this.A;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.A = Arrays.copyOf(objArr, i11);
            this.D = Arrays.copyOf(this.D, i11);
            this.C = (String[]) Arrays.copyOf(this.C, i11);
        }
        Object[] objArr2 = this.A;
        int i12 = this.B;
        this.B = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // z9.a
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
            this.C[this.B - 2] = "null";
        } else {
            q();
            int i10 = this.B;
            if (i10 > 0) {
                this.C[i10 - 1] = "null";
            }
        }
        int i11 = this.B;
        if (i11 > 0) {
            int[] iArr = this.D;
            int i12 = i11 - 1;
            iArr[i12] = iArr[i12] + 1;
        }
    }

    @Override // z9.a
    public String toString() {
        return b.class.getSimpleName() + f();
    }
}
