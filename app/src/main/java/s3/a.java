package s3;

import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseKeyframeAnimation.java */
/* loaded from: classes.dex */
public abstract class a<K, A> {

    /* renamed from: c, reason: collision with root package name */
    public final c<K> f19020c;

    /* renamed from: e, reason: collision with root package name */
    public b4.c<A> f19022e;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f19018a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    public boolean f19019b = false;

    /* renamed from: d, reason: collision with root package name */
    public float f19021d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    public A f19023f = null;

    /* renamed from: g, reason: collision with root package name */
    public float f19024g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f19025h = -1.0f;

    /* compiled from: BaseKeyframeAnimation.java */
    /* renamed from: s3.a$a, reason: collision with other inner class name */
    public interface InterfaceC0246a {
        void onValueChanged();
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class b<T> implements c<T> {
        @Override // s3.a.c
        public b4.a<T> getCurrentKeyframe() {
            throw new IllegalStateException("not implemented");
        }

        @Override // s3.a.c
        public float getEndProgress() {
            return 1.0f;
        }

        @Override // s3.a.c
        public float getStartDelayProgress() {
            return 0.0f;
        }

        @Override // s3.a.c
        public boolean isCachedValueEnabled(float f10) {
            throw new IllegalStateException("not implemented");
        }

        @Override // s3.a.c
        public boolean isEmpty() {
            return true;
        }

        @Override // s3.a.c
        public boolean isValueChanged(float f10) {
            return false;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public interface c<T> {
        b4.a<T> getCurrentKeyframe();

        float getEndProgress();

        float getStartDelayProgress();

        boolean isCachedValueEnabled(float f10);

        boolean isEmpty();

        boolean isValueChanged(float f10);
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class d<T> implements c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final List<? extends b4.a<T>> f19026a;

        /* renamed from: c, reason: collision with root package name */
        public b4.a<T> f19028c = null;

        /* renamed from: d, reason: collision with root package name */
        public float f19029d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        public b4.a<T> f19027b = a(0.0f);

        public d(List<? extends b4.a<T>> list) {
            this.f19026a = list;
        }

        public final b4.a<T> a(float f10) {
            List<? extends b4.a<T>> list = this.f19026a;
            b4.a<T> aVar = list.get(list.size() - 1);
            if (f10 >= aVar.getStartProgress()) {
                return aVar;
            }
            for (int size = list.size() - 2; size >= 1; size--) {
                b4.a<T> aVar2 = list.get(size);
                if (this.f19027b != aVar2 && aVar2.containsProgress(f10)) {
                    return aVar2;
                }
            }
            return list.get(0);
        }

        @Override // s3.a.c
        public b4.a<T> getCurrentKeyframe() {
            return this.f19027b;
        }

        @Override // s3.a.c
        public float getEndProgress() {
            return this.f19026a.get(r0.size() - 1).getEndProgress();
        }

        @Override // s3.a.c
        public float getStartDelayProgress() {
            return this.f19026a.get(0).getStartProgress();
        }

        @Override // s3.a.c
        public boolean isCachedValueEnabled(float f10) {
            b4.a<T> aVar = this.f19028c;
            b4.a<T> aVar2 = this.f19027b;
            if (aVar == aVar2 && this.f19029d == f10) {
                return true;
            }
            this.f19028c = aVar2;
            this.f19029d = f10;
            return false;
        }

        @Override // s3.a.c
        public boolean isEmpty() {
            return false;
        }

        @Override // s3.a.c
        public boolean isValueChanged(float f10) {
            if (this.f19027b.containsProgress(f10)) {
                return !this.f19027b.isStatic();
            }
            this.f19027b = a(f10);
            return true;
        }
    }

    /* compiled from: BaseKeyframeAnimation.java */
    public static final class e<T> implements c<T> {

        /* renamed from: a, reason: collision with root package name */
        public final b4.a<T> f19030a;

        /* renamed from: b, reason: collision with root package name */
        public float f19031b = -1.0f;

        public e(List<? extends b4.a<T>> list) {
            this.f19030a = list.get(0);
        }

        @Override // s3.a.c
        public b4.a<T> getCurrentKeyframe() {
            return this.f19030a;
        }

        @Override // s3.a.c
        public float getEndProgress() {
            return this.f19030a.getEndProgress();
        }

        @Override // s3.a.c
        public float getStartDelayProgress() {
            return this.f19030a.getStartProgress();
        }

        @Override // s3.a.c
        public boolean isCachedValueEnabled(float f10) {
            if (this.f19031b == f10) {
                return true;
            }
            this.f19031b = f10;
            return false;
        }

        @Override // s3.a.c
        public boolean isEmpty() {
            return false;
        }

        @Override // s3.a.c
        public boolean isValueChanged(float f10) {
            return !this.f19030a.isStatic();
        }
    }

    public a(List<? extends b4.a<K>> list) {
        c eVar;
        if (list.isEmpty()) {
            eVar = new b();
        } else {
            eVar = list.size() == 1 ? new e(list) : new d(list);
        }
        this.f19020c = eVar;
    }

    public float a() {
        if (this.f19025h == -1.0f) {
            this.f19025h = this.f19020c.getEndProgress();
        }
        return this.f19025h;
    }

    public void addUpdateListener(InterfaceC0246a interfaceC0246a) {
        this.f19018a.add(interfaceC0246a);
    }

    public final float b() {
        if (this.f19019b) {
            return 0.0f;
        }
        b4.a<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return (this.f19021d - currentKeyframe.getStartProgress()) / (currentKeyframe.getEndProgress() - currentKeyframe.getStartProgress());
    }

    public b4.a<K> getCurrentKeyframe() {
        p3.c.beginSection("BaseKeyframeAnimation#getCurrentKeyframe");
        b4.a<K> currentKeyframe = this.f19020c.getCurrentKeyframe();
        p3.c.endSection("BaseKeyframeAnimation#getCurrentKeyframe");
        return currentKeyframe;
    }

    public float getInterpolatedCurrentKeyframeProgress() {
        b4.a<K> currentKeyframe = getCurrentKeyframe();
        if (currentKeyframe.isStatic()) {
            return 0.0f;
        }
        return currentKeyframe.f4758d.getInterpolation(b());
    }

    public float getProgress() {
        return this.f19021d;
    }

    public A getValue() {
        float interpolatedCurrentKeyframeProgress = getInterpolatedCurrentKeyframeProgress();
        if (this.f19022e == null && this.f19020c.isCachedValueEnabled(interpolatedCurrentKeyframeProgress)) {
            return this.f19023f;
        }
        A value = getValue(getCurrentKeyframe(), interpolatedCurrentKeyframeProgress);
        this.f19023f = value;
        return value;
    }

    public abstract A getValue(b4.a<K> aVar, float f10);

    public void notifyListeners() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f19018a;
            if (i10 >= arrayList.size()) {
                return;
            }
            ((InterfaceC0246a) arrayList.get(i10)).onValueChanged();
            i10++;
        }
    }

    public void setIsDiscrete() {
        this.f19019b = true;
    }

    public void setProgress(float f10) {
        c<K> cVar = this.f19020c;
        if (cVar.isEmpty()) {
            return;
        }
        if (this.f19024g == -1.0f) {
            this.f19024g = cVar.getStartDelayProgress();
        }
        float f11 = this.f19024g;
        if (f10 < f11) {
            if (f11 == -1.0f) {
                this.f19024g = cVar.getStartDelayProgress();
            }
            f10 = this.f19024g;
        } else if (f10 > a()) {
            f10 = a();
        }
        if (f10 == this.f19021d) {
            return;
        }
        this.f19021d = f10;
        if (cVar.isValueChanged(f10)) {
            notifyListeners();
        }
    }

    public void setValueCallback(b4.c<A> cVar) {
        b4.c<A> cVar2 = this.f19022e;
        if (cVar2 != null) {
            cVar2.setAnimation(null);
        }
        this.f19022e = cVar;
        if (cVar != null) {
            cVar.setAnimation(this);
        }
    }
}
