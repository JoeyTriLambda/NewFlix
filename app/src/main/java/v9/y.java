package v9;

import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: Streams.java */
/* loaded from: classes.dex */
public final class y {
    public static com.google.gson.o parse(z9.a aVar) throws JsonParseException {
        boolean z10;
        try {
            try {
                aVar.peek();
                try {
                    return (com.google.gson.o) TypeAdapters.f10171z.read(aVar);
                } catch (EOFException e10) {
                    e = e10;
                    z10 = false;
                    if (z10) {
                        return com.google.gson.p.f10239b;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e11) {
                throw new JsonSyntaxException(e11);
            } catch (IOException e12) {
                throw new JsonIOException(e12);
            } catch (NumberFormatException e13) {
                throw new JsonSyntaxException(e13);
            }
        } catch (EOFException e14) {
            e = e14;
            z10 = true;
        }
    }

    public static void write(com.google.gson.o oVar, z9.b bVar) throws IOException {
        TypeAdapters.f10171z.write(bVar, oVar);
    }
}
