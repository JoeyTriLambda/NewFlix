package yb;

import flix.com.vision.activities.leanback.fragment.TVListFragmentMain;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f22046b;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ TVListFragmentMain f22047m;

    public /* synthetic */ a(TVListFragmentMain tVListFragmentMain, int i10) {
        this.f22046b = i10;
        this.f22047m = tVListFragmentMain;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f22046b;
        TVListFragmentMain tVListFragmentMain = this.f22047m;
        switch (i10) {
            case 0:
                int i11 = TVListFragmentMain.T0;
                tVListFragmentMain.setSelectedPosition(0);
                break;
            case 1:
                int i12 = TVListFragmentMain.T0;
                if (tVListFragmentMain.getVerticalGridView() != null) {
                    tVListFragmentMain.getVerticalGridView().requestFocus();
                }
                tVListFragmentMain.setSelectedPosition(0);
                break;
            case 2:
                flix.com.vision.activities.leanback.fragment.a aVar = tVListFragmentMain.O0;
                if (aVar != null) {
                    aVar.finished();
                    break;
                }
                break;
            case 3:
                flix.com.vision.activities.leanback.fragment.a aVar2 = tVListFragmentMain.O0;
                if (aVar2 != null) {
                    aVar2.finished();
                    break;
                }
                break;
            default:
                flix.com.vision.activities.leanback.fragment.a aVar3 = tVListFragmentMain.O0;
                if (aVar3 != null) {
                    aVar3.finished();
                    break;
                }
                break;
        }
    }
}
