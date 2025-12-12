package retrofit2.converter.gson;

import ah.c;
import com.google.gson.i;
import com.google.gson.w;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;
import z9.b;

/* loaded from: classes2.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.get("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final w<T> adapter;
    private final i gson;

    public GsonRequestBodyConverter(i iVar, w<T> wVar) {
        this.gson = iVar;
        this.adapter = wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) throws IOException {
        return convert((GsonRequestBodyConverter<T>) obj);
    }

    @Override // retrofit2.Converter
    public RequestBody convert(T t10) throws IOException {
        c cVar = new c();
        b bVarNewJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(cVar.outputStream(), UTF_8));
        this.adapter.write(bVarNewJsonWriter, t10);
        bVarNewJsonWriter.close();
        return RequestBody.create(MEDIA_TYPE, cVar.readByteString());
    }
}
