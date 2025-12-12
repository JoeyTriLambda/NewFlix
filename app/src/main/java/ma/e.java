package ma;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import la.a;
import la.k;

/* compiled from: ViewPropertyAnimatorPreHC.java */
/* loaded from: classes.dex */
public final class e extends ma.b {

    /* renamed from: b, reason: collision with root package name */
    public final na.a f16243b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference<View> f16244c;

    /* renamed from: d, reason: collision with root package name */
    public long f16245d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16246e = false;

    /* renamed from: f, reason: collision with root package name */
    public a.InterfaceC0190a f16247f = null;

    /* renamed from: g, reason: collision with root package name */
    public final b f16248g = new b();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<c> f16249h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    public final a f16250i = new a();

    /* renamed from: j, reason: collision with root package name */
    public final HashMap<la.a, d> f16251j = new HashMap<>();

    /* compiled from: ViewPropertyAnimatorPreHC.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar = e.this;
            eVar.getClass();
            k kVarOfFloat = k.ofFloat(1.0f);
            ArrayList<c> arrayList = eVar.f16249h;
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            arrayList.clear();
            int size = arrayList2.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i10 |= ((c) arrayList2.get(i11)).f16254a;
            }
            eVar.f16251j.put(kVarOfFloat, new d(i10, arrayList2));
            b bVar = eVar.f16248g;
            kVarOfFloat.addUpdateListener(bVar);
            kVarOfFloat.addListener(bVar);
            if (eVar.f16246e) {
                kVarOfFloat.setDuration(eVar.f16245d);
            }
            kVarOfFloat.start();
        }
    }

    /* compiled from: ViewPropertyAnimatorPreHC.java */
    public class b implements a.InterfaceC0190a, k.g {
        public b() {
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationCancel(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = e.this.f16247f;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationCancel(aVar);
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationEnd(la.a aVar) {
            e eVar = e.this;
            a.InterfaceC0190a interfaceC0190a = eVar.f16247f;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationEnd(aVar);
            }
            eVar.f16251j.remove(aVar);
            if (eVar.f16251j.isEmpty()) {
                eVar.f16247f = null;
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationRepeat(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = e.this.f16247f;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationRepeat(aVar);
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationStart(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = e.this.f16247f;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationStart(aVar);
            }
        }

        @Override // la.k.g
        public void onAnimationUpdate(k kVar) {
            View view;
            float animatedFraction = kVar.getAnimatedFraction();
            e eVar = e.this;
            d dVar = eVar.f16251j.get(kVar);
            if ((dVar.f16257a & 511) != 0 && (view = eVar.f16244c.get()) != null) {
                view.invalidate();
            }
            ArrayList<c> arrayList = dVar.f16258b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    c cVar = arrayList.get(i10);
                    float f10 = (cVar.f16256c * animatedFraction) + cVar.f16255b;
                    na.a aVar = eVar.f16243b;
                    int i11 = cVar.f16254a;
                    if (i11 == 1) {
                        aVar.setTranslationX(f10);
                    } else if (i11 == 2) {
                        aVar.setTranslationY(f10);
                    } else if (i11 == 4) {
                        aVar.setScaleX(f10);
                    } else if (i11 == 8) {
                        aVar.setScaleY(f10);
                    } else if (i11 == 16) {
                        aVar.setRotation(f10);
                    } else if (i11 == 32) {
                        aVar.setRotationX(f10);
                    } else if (i11 == 64) {
                        aVar.setRotationY(f10);
                    } else if (i11 == 128) {
                        aVar.setX(f10);
                    } else if (i11 == 256) {
                        aVar.setY(f10);
                    } else if (i11 == 512) {
                        aVar.setAlpha(f10);
                    }
                }
            }
            View view2 = eVar.f16244c.get();
            if (view2 != null) {
                view2.invalidate();
            }
        }
    }

    /* compiled from: ViewPropertyAnimatorPreHC.java */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f16254a;

        /* renamed from: b, reason: collision with root package name */
        public final float f16255b;

        /* renamed from: c, reason: collision with root package name */
        public final float f16256c;

        public c(int i10, float f10, float f11) {
            this.f16254a = i10;
            this.f16255b = f10;
            this.f16256c = f11;
        }
    }

    /* compiled from: ViewPropertyAnimatorPreHC.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f16257a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<c> f16258b;

        public d(int i10, ArrayList<c> arrayList) {
            this.f16257a = i10;
            this.f16258b = arrayList;
        }
    }

    public e(View view) {
        this.f16244c = new WeakReference<>(view);
        this.f16243b = na.a.wrap(view);
    }

    public final void a(float f10, int i10) {
        la.a next;
        ArrayList<c> arrayList;
        na.a aVar = this.f16243b;
        float alpha = i10 != 1 ? i10 != 2 ? i10 != 4 ? i10 != 8 ? i10 != 16 ? i10 != 32 ? i10 != 64 ? i10 != 128 ? i10 != 256 ? i10 != 512 ? 0.0f : aVar.getAlpha() : aVar.getY() : aVar.getX() : aVar.getRotationY() : aVar.getRotationX() : aVar.getRotation() : aVar.getScaleY() : aVar.getScaleX() : aVar.getTranslationY() : aVar.getTranslationX();
        float f11 = f10 - alpha;
        HashMap<la.a, d> map = this.f16251j;
        if (map.size() > 0) {
            Iterator<la.a> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                d dVar = map.get(next);
                boolean z10 = false;
                if ((dVar.f16257a & i10) != 0 && (arrayList = dVar.f16258b) != null) {
                    int size = arrayList.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            break;
                        }
                        if (arrayList.get(i11).f16254a == i10) {
                            arrayList.remove(i11);
                            dVar.f16257a &= ~i10;
                            z10 = true;
                            break;
                        }
                        i11++;
                    }
                }
                if (z10 && dVar.f16257a == 0) {
                    break;
                }
            }
            if (next != null) {
                next.cancel();
            }
        }
        this.f16249h.add(new c(i10, alpha, f11));
        View view = this.f16244c.get();
        if (view != null) {
            a aVar2 = this.f16250i;
            view.removeCallbacks(aVar2);
            view.post(aVar2);
        }
    }

    @Override // ma.b
    public ma.b alpha(float f10) {
        a(f10, 512);
        return this;
    }

    @Override // ma.b
    public ma.b setDuration(long j10) {
        if (j10 < 0) {
            throw new IllegalArgumentException(ac.c.h("Animators cannot have negative duration: ", j10));
        }
        this.f16246e = true;
        this.f16245d = j10;
        return this;
    }

    @Override // ma.b
    public ma.b setListener(a.InterfaceC0190a interfaceC0190a) {
        this.f16247f = interfaceC0190a;
        return this;
    }

    @Override // ma.b
    public ma.b translationX(float f10) {
        a(f10, 1);
        return this;
    }
}
