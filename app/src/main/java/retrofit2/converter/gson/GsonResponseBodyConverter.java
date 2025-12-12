package retrofit2.converter.gson;

import com.google.gson.JsonIOException;
import com.google.gson.i;
import com.google.gson.stream.JsonToken;
import com.google.gson.w;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import z9.a;

/* loaded from: classes2.dex */
final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final w<T> adapter;
    private final i gson;

    public GsonResponseBodyConverter(i iVar, w<T> wVar) {
        this.gson = iVar;
        this.adapter = wVar;
    }

    @Override // retrofit2.Converter
    public T convert(ResponseBody responseBody) throws IOException {
        a aVarNewJsonReader = this.gson.newJsonReader(responseBody.charStream());
        try {
            T t10 = this.adapter.read(aVarNewJsonReader);
            if (aVarNewJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return t10;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
