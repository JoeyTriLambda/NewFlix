package retrofit2.converter.gson;

import com.google.gson.i;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import y9.a;

/* loaded from: classes2.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final i gson;

    private GsonConverterFactory(i iVar) {
        this.gson = iVar;
    }

    public static GsonConverterFactory create() {
        return create(new i());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.getAdapter(a.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.getAdapter(a.get(type)));
    }

    public static GsonConverterFactory create(i iVar) {
        if (iVar != null) {
            return new GsonConverterFactory(iVar);
        }
        throw new NullPointerException("gson == null");
    }
}
