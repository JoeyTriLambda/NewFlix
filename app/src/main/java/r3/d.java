package r3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;
import s3.a;

/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public final class d implements e, m, a.InterfaceC0246a, u3.e {

    /* renamed from: a, reason: collision with root package name */
    public final q3.a f18466a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f18467b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f18468c;

    /* renamed from: d, reason: collision with root package name */
    public final Path f18469d;

    /* renamed from: e, reason: collision with root package name */
    public final RectF f18470e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18471f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f18472g;

    /* renamed from: h, reason: collision with root package name */
    public final List<c> f18473h;

    /* renamed from: i, reason: collision with root package name */
    public final p3.f f18474i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f18475j;

    /* renamed from: k, reason: collision with root package name */
    public final s3.o f18476k;

    public d(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, w3.i iVar) {
        v3.l lVar;
        String name = iVar.getName();
        boolean zIsHidden = iVar.isHidden();
        List<w3.b> items = iVar.getItems();
        ArrayList arrayList = new ArrayList(items.size());
        int i10 = 0;
        for (int i11 = 0; i11 < items.size(); i11++) {
            c content = items.get(i11).toContent(fVar, aVar);
            if (content != null) {
                arrayList.add(content);
            }
        }
        List<w3.b> items2 = iVar.getItems();
        while (true) {
            if (i10 >= items2.size()) {
                lVar = null;
                break;
            }
            w3.b bVar = items2.get(i10);
            if (bVar instanceof v3.l) {
                lVar = (v3.l) bVar;
                break;
            }
            i10++;
        }
        this(fVar, aVar, name, zIsHidden, arrayList, lVar);
    }

    public final List<m> a() {
        if (this.f18475j == null) {
            this.f18475j = new ArrayList();
            int i10 = 0;
            while (true) {
                List<c> list = this.f18473h;
                if (i10 >= list.size()) {
                    break;
                }
                c cVar = list.get(i10);
                if (cVar instanceof m) {
                    this.f18475j.add((m) cVar);
                }
                i10++;
            }
        }
        return this.f18475j;
    }

    @Override // u3.e
    public <T> void addValueCallback(T t10, b4.c<T> cVar) {
        s3.o oVar = this.f18476k;
        if (oVar != null) {
            oVar.applyValueCallback(t10, cVar);
        }
    }

    @Override // r3.e
    public void draw(Canvas canvas, Matrix matrix, int i10) {
        boolean z10;
        if (this.f18472g) {
            return;
        }
        Matrix matrix2 = this.f18468c;
        matrix2.set(matrix);
        s3.o oVar = this.f18476k;
        if (oVar != null) {
            matrix2.preConcat(oVar.getMatrix());
            i10 = (int) (((((oVar.getOpacity() == null ? 100 : oVar.getOpacity().getValue().intValue()) / 100.0f) * i10) / 255.0f) * 255.0f);
        }
        boolean zIsApplyingOpacityToLayersEnabled = this.f18474i.isApplyingOpacityToLayersEnabled();
        boolean z11 = false;
        List<c> list = this.f18473h;
        if (zIsApplyingOpacityToLayersEnabled) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= list.size()) {
                    z10 = false;
                    break;
                } else {
                    if ((list.get(i11) instanceof e) && (i12 = i12 + 1) >= 2) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
            if (z10 && i10 != 255) {
                z11 = true;
            }
        }
        if (z11) {
            RectF rectF = this.f18467b;
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            getBounds(rectF, matrix2, true);
            q3.a aVar = this.f18466a;
            aVar.setAlpha(i10);
            a4.h.saveLayerCompat(canvas, rectF, aVar);
        }
        if (z11) {
            i10 = 255;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof e) {
                ((e) cVar).draw(canvas, matrix2, i10);
            }
        }
        if (z11) {
            canvas.restore();
        }
    }

    @Override // r3.e
    public void getBounds(RectF rectF, Matrix matrix, boolean z10) {
        Matrix matrix2 = this.f18468c;
        matrix2.set(matrix);
        s3.o oVar = this.f18476k;
        if (oVar != null) {
            matrix2.preConcat(oVar.getMatrix());
        }
        RectF rectF2 = this.f18470e;
        rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
        List<c> list = this.f18473h;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof e) {
                ((e) cVar).getBounds(rectF2, matrix2, z10);
                rectF.union(rectF2);
            }
        }
    }

    @Override // r3.c
    public String getName() {
        return this.f18471f;
    }

    @Override // r3.m
    public Path getPath() {
        Matrix matrix = this.f18468c;
        matrix.reset();
        s3.o oVar = this.f18476k;
        if (oVar != null) {
            matrix.set(oVar.getMatrix());
        }
        Path path = this.f18469d;
        path.reset();
        if (this.f18472g) {
            return path;
        }
        List<c> list = this.f18473h;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof m) {
                path.addPath(((m) cVar).getPath(), matrix);
            }
        }
        return path;
    }

    @Override // s3.a.InterfaceC0246a
    public void onValueChanged() {
        this.f18474i.invalidateSelf();
    }

    @Override // u3.e
    public void resolveKeyPath(u3.d dVar, int i10, List<u3.d> list, u3.d dVar2) {
        if (!dVar.matches(getName(), i10)) {
            return;
        }
        if (!"__container".equals(getName())) {
            dVar2 = dVar2.addKey(getName());
            if (dVar.fullyResolvesTo(getName(), i10)) {
                list.add(dVar2.resolve(this));
            }
        }
        if (!dVar.propagateToChildren(getName(), i10)) {
            return;
        }
        int iIncrementDepthBy = dVar.incrementDepthBy(getName(), i10) + i10;
        int i11 = 0;
        while (true) {
            List<c> list2 = this.f18473h;
            if (i11 >= list2.size()) {
                return;
            }
            c cVar = list2.get(i11);
            if (cVar instanceof u3.e) {
                ((u3.e) cVar).resolveKeyPath(dVar, iIncrementDepthBy, list, dVar2);
            }
            i11++;
        }
    }

    @Override // r3.c
    public void setContents(List<c> list, List<c> list2) {
        int size = list.size();
        List<c> list3 = this.f18473h;
        ArrayList arrayList = new ArrayList(list3.size() + size);
        arrayList.addAll(list);
        for (int size2 = list3.size() - 1; size2 >= 0; size2--) {
            c cVar = list3.get(size2);
            cVar.setContents(arrayList, list3.subList(0, size2));
            arrayList.add(cVar);
        }
    }

    public d(p3.f fVar, com.airbnb.lottie.model.layer.a aVar, String str, boolean z10, ArrayList arrayList, v3.l lVar) {
        this.f18466a = new q3.a();
        this.f18467b = new RectF();
        this.f18468c = new Matrix();
        this.f18469d = new Path();
        this.f18470e = new RectF();
        this.f18471f = str;
        this.f18474i = fVar;
        this.f18472g = z10;
        this.f18473h = arrayList;
        if (lVar != null) {
            s3.o oVarCreateAnimation = lVar.createAnimation();
            this.f18476k = oVarCreateAnimation;
            oVarCreateAnimation.addAnimationsToLayer(aVar);
            oVarCreateAnimation.addListener(this);
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            c cVar = (c) arrayList.get(size);
            if (cVar instanceof j) {
                arrayList2.add((j) cVar);
            }
        }
        int size2 = arrayList2.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                return;
            } else {
                ((j) arrayList2.get(size2)).absorbContent(arrayList.listIterator(arrayList.size()));
            }
        }
    }
}
