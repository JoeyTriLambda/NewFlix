package s3;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import s3.a;

/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public final class m extends a<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f19046i;

    /* renamed from: j, reason: collision with root package name */
    public final a<Float, Float> f19047j;

    /* renamed from: k, reason: collision with root package name */
    public final a<Float, Float> f19048k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f19046i = new PointF();
        this.f19047j = aVar;
        this.f19048k = aVar2;
        setProgress(getProgress());
    }

    @Override // s3.a
    public void setProgress(float f10) {
        a<Float, Float> aVar = this.f19047j;
        aVar.setProgress(f10);
        a<Float, Float> aVar2 = this.f19048k;
        aVar2.setProgress(f10);
        this.f19046i.set(aVar.getValue().floatValue(), aVar2.getValue().floatValue());
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f19018a;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((a.InterfaceC0246a) arrayList.get(i10)).onValueChanged();
            i10++;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // s3.a
    public PointF getValue() {
        return this.f19046i;
    }

    @Override // s3.a
    public final PointF getValue(b4.a<PointF> aVar, float f10) {
        return this.f19046i;
    }
}
