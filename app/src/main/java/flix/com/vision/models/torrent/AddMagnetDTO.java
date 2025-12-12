package flix.com.vision.models.torrent;

import ac.c;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class AddMagnetDTO implements Serializable {

    /* renamed from: id, reason: collision with root package name */
    private String f12426id;
    private String uri;

    public String getId() {
        return this.f12426id;
    }

    public String getUri() {
        return this.uri;
    }

    public void setId(String str) {
        this.f12426id = str;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("AddMagnetDTO{id='");
        sb2.append(this.f12426id);
        sb2.append("', url='");
        return c.o(sb2, this.uri, "'}");
    }
}
