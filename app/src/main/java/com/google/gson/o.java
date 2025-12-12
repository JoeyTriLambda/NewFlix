package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;
import v9.y;

/* compiled from: JsonElement.java */
/* loaded from: classes.dex */
public abstract class o {
    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public l getAsJsonArray() {
        if (isJsonArray()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public q getAsJsonObject() {
        if (isJsonObject()) {
            return (q) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public s getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (s) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof l;
    }

    public boolean isJsonNull() {
        return this instanceof p;
    }

    public boolean isJsonObject() {
        return this instanceof q;
    }

    public boolean isJsonPrimitive() {
        return this instanceof s;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            z9.b bVar = new z9.b(stringWriter);
            bVar.setLenient(true);
            y.write(this, bVar);
            return stringWriter.toString();
        } catch (IOException e10) {
            throw new AssertionError(e10);
        }
    }
}
