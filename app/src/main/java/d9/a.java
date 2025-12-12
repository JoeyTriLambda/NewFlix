package d9;

import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements b9.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10953a;

    @Override // b9.b
    public final void encode(Object obj, b9.e eVar) throws IOException {
        switch (this.f10953a) {
            case 0:
                throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                b9.e eVar2 = eVar;
                Charset charset = com.google.firebase.encoders.proto.b.f9789f;
                eVar2.add(com.google.firebase.encoders.proto.b.f9790g, entry.getKey());
                eVar2.add(com.google.firebase.encoders.proto.b.f9791h, entry.getValue());
                return;
            default:
                throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
