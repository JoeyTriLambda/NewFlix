package s3;

import android.graphics.Path;
import java.util.List;

/* compiled from: ShapeKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class l extends a<w3.g, Path> {

    /* renamed from: i, reason: collision with root package name */
    public final w3.g f19044i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f19045j;

    public l(List<b4.a<w3.g>> list) {
        super(list);
        this.f19044i = new w3.g();
        this.f19045j = new Path();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // s3.a
    public Path getValue(b4.a<w3.g> aVar, float f10) {
        w3.g gVar = aVar.f4756b;
        w3.g gVar2 = aVar.f4757c;
        w3.g gVar3 = this.f19044i;
        gVar3.interpolateBetween(gVar, gVar2, f10);
        Path path = this.f19045j;
        a4.g.getPathFromData(gVar3, path);
        return path;
    }
}
