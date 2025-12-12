package m4;

/* compiled from: MultiplePulseRing.java */
/* loaded from: classes.dex */
public final class h extends l4.g {
    @Override // l4.g
    public void onChildCreated(l4.f... fVarArr) {
        int i10 = 0;
        while (i10 < fVarArr.length) {
            l4.f fVar = fVarArr[i10];
            i10++;
            fVar.setAnimationDelay(i10 * 200);
        }
    }

    @Override // l4.g
    public l4.f[] onCreateChild() {
        return new l4.f[]{new j(), new j(), new j()};
    }
}
