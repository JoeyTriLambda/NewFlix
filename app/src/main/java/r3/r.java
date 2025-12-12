package r3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.model.content.ShapeStroke;

/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public final class r extends a {

    /* renamed from: o, reason: collision with root package name */
    public final com.airbnb.lottie.model.layer.a f18569o;

    /* renamed from: p, reason: collision with root package name */
    public final String f18570p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f18571q;

    /* renamed from: r, reason: collision with root package name */
    public final s3.a<Integer, Integer> f18572r;

    /* renamed from: s, reason: collision with root package name */
    public s3.p f18573s;

    public r(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.getCapType().toPaintCap(), shapeStroke.getJoinType().toPaintJoin(), shapeStroke.getMiterLimit(), shapeStroke.getOpacity(), shapeStroke.getWidth(), shapeStroke.getLineDashPattern(), shapeStroke.getDashOffset());
        this.f18569o = aVar;
        this.f18570p = shapeStroke.getName();
        this.f18571q = shapeStroke.isHidden();
        s3.a<Integer, Integer> aVarCreateAnimation = shapeStroke.getColor().createAnimation();
        this.f18572r = aVarCreateAnimation;
        aVarCreateAnimation.addUpdateListener(this);
        aVar.addAnimation(aVarCreateAnimation);
    }

    @Override // r3.a, u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        super.addValueCallback(t10, cVar);
        Integer num = p3.k.f17507b;
        s3.a<Integer, Integer> aVar = this.f18572r;
        if (t10 == num) {
            aVar.setValueCallback(cVar);
            return;
        }
        if (t10 == p3.k.C) {
            s3.p pVar = this.f18573s;
            com.airbnb.lottie.model.layer.a aVar2 = this.f18569o;
            if (pVar != null) {
                aVar2.removeAnimation(pVar);
            }
            if (cVar == null) {
                this.f18573s = null;
                return;
            }
            s3.p pVar2 = new s3.p(cVar);
            this.f18573s = pVar2;
            pVar2.addUpdateListener(this);
            aVar2.addAnimation(aVar);
        }
    }

    @Override // r3.a, r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        if (this.f18571q) {
            return;
        }
        int intValue = ((s3.b) this.f18572r).getIntValue();
        q3.a aVar = this.f18457i;
        aVar.setColor(intValue);
        s3.p pVar = this.f18573s;
        if (pVar != null) {
            aVar.setColorFilter((ColorFilter) pVar.getValue());
        }
        super.draw(canvas, matrix, i10);
    }

    @Override // r3.c
    public String getName() {
        return this.f18570p;
    }
}
