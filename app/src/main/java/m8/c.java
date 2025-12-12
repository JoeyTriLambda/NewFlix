package m8;

import m8.f;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f16212b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f16213m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Runnable f16214n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ f.b f16215o;

    public /* synthetic */ c(e eVar, Runnable runnable, f.b bVar, int i10) {
        this.f16212b = i10;
        this.f16213m = eVar;
        this.f16214n = runnable;
        this.f16215o = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f16212b;
        final f.b bVar = this.f16215o;
        final Runnable runnable = this.f16214n;
        e eVar = this.f16213m;
        switch (i10) {
            case 0:
                eVar.getClass();
                final int i11 = 0;
                eVar.f16219b.execute(new Runnable() { // from class: m8.d
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i12 = i11;
                        f.b bVar2 = bVar;
                        Runnable runnable2 = runnable;
                        switch (i12) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((f.a) bVar2).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    ((f.a) bVar2).set(null);
                                    return;
                                } catch (Exception e11) {
                                    ((f.a) bVar2).setException(e11);
                                    return;
                                }
                            default:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e12) {
                                    ((f.a) bVar2).setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                eVar.getClass();
                final int i12 = 2;
                eVar.f16219b.execute(new Runnable() { // from class: m8.d
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i122 = i12;
                        f.b bVar2 = bVar;
                        Runnable runnable2 = runnable;
                        switch (i122) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((f.a) bVar2).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    ((f.a) bVar2).set(null);
                                    return;
                                } catch (Exception e11) {
                                    ((f.a) bVar2).setException(e11);
                                    return;
                                }
                            default:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e12) {
                                    ((f.a) bVar2).setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                eVar.getClass();
                final int i13 = 1;
                eVar.f16219b.execute(new Runnable() { // from class: m8.d
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        int i122 = i13;
                        f.b bVar2 = bVar;
                        Runnable runnable2 = runnable;
                        switch (i122) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e10) {
                                    ((f.a) bVar2).setException(e10);
                                    throw e10;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    ((f.a) bVar2).set(null);
                                    return;
                                } catch (Exception e11) {
                                    ((f.a) bVar2).setException(e11);
                                    return;
                                }
                            default:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e12) {
                                    ((f.a) bVar2).setException(e12);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
