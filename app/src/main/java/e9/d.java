package e9;

import b9.g;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;

/* compiled from: ProtobufValueEncoderContext.java */
/* loaded from: classes.dex */
public final class d implements g {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11179a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11180b = false;

    /* renamed from: c, reason: collision with root package name */
    public b9.c f11181c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.firebase.encoders.proto.b f11182d;

    public d(com.google.firebase.encoders.proto.b bVar) {
        this.f11182d = bVar;
    }

    @Override // b9.g
    public g add(String str) throws IOException {
        if (this.f11179a) {
            throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f11179a = true;
        this.f11182d.a(this.f11181c, str, this.f11180b);
        return this;
    }

    @Override // b9.g
    public g add(boolean z10) throws IOException {
        if (!this.f11179a) {
            this.f11179a = true;
            this.f11182d.c(this.f11181c, z10 ? 1 : 0, this.f11180b);
            return this;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }
}
