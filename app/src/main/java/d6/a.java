package d6;

import java.util.List;
import l6.l;

/* compiled from: DvbDecoder.java */
/* loaded from: classes.dex */
public final class a extends b6.b {

    /* renamed from: m, reason: collision with root package name */
    public final b f10897m;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        l lVar = new l(list.get(0));
        this.f10897m = new b(lVar.readUnsignedShort(), lVar.readUnsignedShort());
    }

    @Override // b6.b
    public c decode(byte[] bArr, int i10, boolean z10) {
        b bVar = this.f10897m;
        if (z10) {
            bVar.reset();
        }
        return new c(bVar.decode(bArr, i10));
    }
}
