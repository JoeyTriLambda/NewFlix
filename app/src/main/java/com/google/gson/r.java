package com.google.gson;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import v9.y;

/* compiled from: JsonParser.java */
/* loaded from: classes.dex */
public final class r {
    public static o parseReader(Reader reader) throws JsonSyntaxException, JsonIOException {
        try {
            z9.a aVar = new z9.a(reader);
            o reader2 = parseReader(aVar);
            if (!reader2.isJsonNull() && aVar.peek() != JsonToken.END_DOCUMENT) {
                throw new JsonSyntaxException("Did not consume the entire document.");
            }
            return reader2;
        } catch (MalformedJsonException e10) {
            throw new JsonSyntaxException(e10);
        } catch (IOException e11) {
            throw new JsonIOException(e11);
        } catch (NumberFormatException e12) {
            throw new JsonSyntaxException(e12);
        }
    }

    public static o parseString(String str) throws JsonSyntaxException {
        return parseReader(new StringReader(str));
    }

    public static o parseReader(z9.a aVar) throws JsonSyntaxException, JsonIOException {
        boolean zIsLenient = aVar.isLenient();
        aVar.setLenient(true);
        try {
            try {
                return y.parse(aVar);
            } catch (OutOfMemoryError e10) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e10);
            } catch (StackOverflowError e11) {
                throw new JsonParseException("Failed parsing JSON source: " + aVar + " to Json", e11);
            }
        } finally {
            aVar.setLenient(zIsLenient);
        }
    }
}
