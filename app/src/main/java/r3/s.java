package r3;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import java.util.ArrayList;
import java.util.List;
import s3.a;

/* compiled from: TrimPathContent.java */
/* loaded from: classes.dex */
public final class s implements c, a.InterfaceC0246a {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18574a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f18575b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ShapeTrimPath.Type f18576c;

    /* renamed from: d, reason: collision with root package name */
    public final s3.a<?, Float> f18577d;

    /* renamed from: e, reason: collision with root package name */
    public final s3.a<?, Float> f18578e;

    /* renamed from: f, reason: collision with root package name */
    public final s3.a<?, Float> f18579f;

    public s(com.airbnb.lottie.model.layer.a aVar, ShapeTrimPath shapeTrimPath) {
        shapeTrimPath.getName();
        this.f18574a = shapeTrimPath.isHidden();
        this.f18576c = shapeTrimPath.getType();
        s3.a<Float, Float> aVarCreateAnimation = shapeTrimPath.getStart().createAnimation();
        this.f18577d = aVarCreateAnimation;
        s3.a<Float, Float> aVarCreateAnimation2 = shapeTrimPath.getEnd().createAnimation();
        this.f18578e = aVarCreateAnimation2;
        s3.a<Float, Float> aVarCreateAnimation3 = shapeTrimPath.getOffset().createAnimation();
        this.f18579f = aVarCreateAnimation3;
        aVar.addAnimation(aVarCreateAnimation);
        aVar.addAnimation(aVarCreateAnimation2);
        aVar.addAnimation(aVarCreateAnimation3);
        aVarCreateAnimation.addUpdateListener(this);
        aVarCreateAnimation2.addUpdateListener(this);
        aVarCreateAnimation3.addUpdateListener(this);
    }

    public final void a(a.InterfaceC0246a interfaceC0246a) {
        this.f18575b.add(interfaceC0246a);
    }

    public s3.a<?, Float> getEnd() {
        return this.f18578e;
    }

    public s3.a<?, Float> getOffset() {
        return this.f18579f;
    }

    public s3.a<?, Float> getStart() {
        return this.f18577d;
    }

    public boolean isHidden() {
        return this.f18574a;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f18575b;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((a.InterfaceC0246a) arrayList.get(i10)).onValueChanged();
            i10++;
        }
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
    }
}
