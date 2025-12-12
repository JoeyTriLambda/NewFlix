package ma;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import la.a;
import la.k;

/* compiled from: ViewPropertyAnimatorHC.java */
/* loaded from: classes.dex */
public final class c extends ma.b {

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference<View> f16226b;

    /* renamed from: c, reason: collision with root package name */
    public long f16227c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16228d = false;

    /* renamed from: e, reason: collision with root package name */
    public a.InterfaceC0190a f16229e = null;

    /* renamed from: f, reason: collision with root package name */
    public final b f16230f = new b();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<C0197c> f16231g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    public final a f16232h = new a();

    /* renamed from: i, reason: collision with root package name */
    public final HashMap<la.a, d> f16233i = new HashMap<>();

    /* compiled from: ViewPropertyAnimatorHC.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.getClass();
            k kVarOfFloat = k.ofFloat(1.0f);
            ArrayList<C0197c> arrayList = cVar.f16231g;
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            arrayList.clear();
            int size = arrayList2.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                i10 |= ((C0197c) arrayList2.get(i11)).f16236a;
            }
            cVar.f16233i.put(kVarOfFloat, new d(i10, arrayList2));
            b bVar = cVar.f16230f;
            kVarOfFloat.addUpdateListener(bVar);
            kVarOfFloat.addListener(bVar);
            if (cVar.f16228d) {
                kVarOfFloat.setDuration(cVar.f16227c);
            }
            kVarOfFloat.start();
        }
    }

    /* compiled from: ViewPropertyAnimatorHC.java */
    public class b implements a.InterfaceC0190a, k.g {
        public b() {
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationCancel(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = c.this.f16229e;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationCancel(aVar);
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationEnd(la.a aVar) {
            c cVar = c.this;
            a.InterfaceC0190a interfaceC0190a = cVar.f16229e;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationEnd(aVar);
            }
            cVar.f16233i.remove(aVar);
            if (cVar.f16233i.isEmpty()) {
                cVar.f16229e = null;
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationRepeat(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = c.this.f16229e;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationRepeat(aVar);
            }
        }

        @Override // la.a.InterfaceC0190a
        public void onAnimationStart(la.a aVar) {
            a.InterfaceC0190a interfaceC0190a = c.this.f16229e;
            if (interfaceC0190a != null) {
                interfaceC0190a.onAnimationStart(aVar);
            }
        }

        @Override // la.k.g
        public void onAnimationUpdate(k kVar) {
            View view;
            float animatedFraction = kVar.getAnimatedFraction();
            c cVar = c.this;
            d dVar = cVar.f16233i.get(kVar);
            if ((dVar.f16239a & 511) != 0 && (view = cVar.f16226b.get()) != null) {
                view.invalidate();
            }
            ArrayList<C0197c> arrayList = dVar.f16240b;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    C0197c c0197c = arrayList.get(i10);
                    float f10 = (c0197c.f16238c * animatedFraction) + c0197c.f16237b;
                    View view2 = cVar.f16226b.get();
                    if (view2 != null) {
                        int i11 = c0197c.f16236a;
                        if (i11 == 1) {
                            view2.setTranslationX(f10);
                        } else if (i11 == 2) {
                            view2.setTranslationY(f10);
                        } else if (i11 == 4) {
                            view2.setScaleX(f10);
                        } else if (i11 == 8) {
                            view2.setScaleY(f10);
                        } else if (i11 == 16) {
                            view2.setRotation(f10);
                        } else if (i11 == 32) {
                            view2.setRotationX(f10);
                        } else if (i11 == 64) {
                            view2.setRotationY(f10);
                        } else if (i11 == 128) {
                            view2.setX(f10);
                        } else if (i11 == 256) {
                            view2.setY(f10);
                        } else if (i11 == 512) {
                            view2.setAlpha(f10);
                        }
                    }
                }
            }
            View view3 = cVar.f16226b.get();
            if (view3 != null) {
                view3.invalidate();
            }
        }
    }

    /* compiled from: ViewPropertyAnimatorHC.java */
    /* renamed from: ma.c$c, reason: collision with other inner class name */
    public static class C0197c {

        /* renamed from: a, reason: collision with root package name */
        public final int f16236a;

        /* renamed from: b, reason: collision with root package name */
        public final float f16237b;

        /* renamed from: c, reason: collision with root package name */
        public final float f16238c;

        public C0197c(int i10, float f10, float f11) {
            this.f16236a = i10;
            this.f16237b = f10;
            this.f16238c = f11;
        }
    }

    /* compiled from: ViewPropertyAnimatorHC.java */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f16239a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<C0197c> f16240b;

        public d(int i10, ArrayList<C0197c> arrayList) {
            this.f16239a = i10;
            this.f16240b = arrayList;
        }
    }

    public c(View view) {
        this.f16226b = new WeakReference<>(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(float r13, int r14) {
        /*
            r12 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r12.f16226b
            java.lang.Object r1 = r0.get()
            android.view.View r1 = (android.view.View) r1
            r2 = 1
            if (r1 == 0) goto L62
            if (r14 == r2) goto L5d
            r3 = 2
            if (r14 == r3) goto L58
            r3 = 4
            if (r14 == r3) goto L53
            r3 = 8
            if (r14 == r3) goto L4e
            r3 = 16
            if (r14 == r3) goto L49
            r3 = 32
            if (r14 == r3) goto L44
            r3 = 64
            if (r14 == r3) goto L3f
            r3 = 128(0x80, float:1.8E-43)
            if (r14 == r3) goto L3a
            r3 = 256(0x100, float:3.59E-43)
            if (r14 == r3) goto L35
            r3 = 512(0x200, float:7.17E-43)
            if (r14 == r3) goto L30
            goto L62
        L30:
            float r1 = r1.getAlpha()
            goto L63
        L35:
            float r1 = r1.getY()
            goto L63
        L3a:
            float r1 = r1.getX()
            goto L63
        L3f:
            float r1 = r1.getRotationY()
            goto L63
        L44:
            float r1 = r1.getRotationX()
            goto L63
        L49:
            float r1 = r1.getRotation()
            goto L63
        L4e:
            float r1 = r1.getScaleY()
            goto L63
        L53:
            float r1 = r1.getScaleX()
            goto L63
        L58:
            float r1 = r1.getTranslationY()
            goto L63
        L5d:
            float r1 = r1.getTranslationX()
            goto L63
        L62:
            r1 = 0
        L63:
            float r13 = r13 - r1
            java.util.HashMap<la.a, ma.c$d> r3 = r12.f16233i
            int r4 = r3.size()
            if (r4 <= 0) goto Lbc
            java.util.Set r4 = r3.keySet()
            java.util.Iterator r4 = r4.iterator()
        L74:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto Lb6
            java.lang.Object r5 = r4.next()
            la.a r5 = (la.a) r5
            java.lang.Object r6 = r3.get(r5)
            ma.c$d r6 = (ma.c.d) r6
            int r7 = r6.f16239a
            r7 = r7 & r14
            r8 = 0
            if (r7 == 0) goto Laf
            java.util.ArrayList<ma.c$c> r7 = r6.f16240b
            if (r7 == 0) goto Laf
            int r9 = r7.size()
            r10 = 0
        L95:
            if (r10 >= r9) goto Laf
            java.lang.Object r11 = r7.get(r10)
            ma.c$c r11 = (ma.c.C0197c) r11
            int r11 = r11.f16236a
            if (r11 != r14) goto Lac
            r7.remove(r10)
            int r7 = r6.f16239a
            int r8 = ~r14
            r7 = r7 & r8
            r6.f16239a = r7
            r8 = 1
            goto Laf
        Lac:
            int r10 = r10 + 1
            goto L95
        Laf:
            if (r8 == 0) goto L74
            int r6 = r6.f16239a
            if (r6 != 0) goto L74
            goto Lb7
        Lb6:
            r5 = 0
        Lb7:
            if (r5 == 0) goto Lbc
            r5.cancel()
        Lbc:
            ma.c$c r2 = new ma.c$c
            r2.<init>(r14, r1, r13)
            java.util.ArrayList<ma.c$c> r13 = r12.f16231g
            r13.add(r2)
            java.lang.Object r13 = r0.get()
            android.view.View r13 = (android.view.View) r13
            if (r13 == 0) goto Ld6
            ma.c$a r14 = r12.f16232h
            r13.removeCallbacks(r14)
            r13.post(r14)
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.c.a(float, int):void");
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
        this.f16228d = true;
        this.f16227c = j10;
        return this;
    }

    @Override // ma.b
    public ma.b setListener(a.InterfaceC0190a interfaceC0190a) {
        this.f16229e = interfaceC0190a;
        return this;
    }

    @Override // ma.b
    public ma.b translationX(float f10) {
        a(f10, 1);
        return this;
    }
}
