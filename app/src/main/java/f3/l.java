package f3;

/* compiled from: SystemIdInfo.kt */
/* loaded from: classes.dex */
public final class l {
    public static final i systemIdInfo(m mVar, int i10) {
        zf.i.checkNotNullParameter(mVar, "generationalId");
        return new i(mVar.getWorkSpecId(), mVar.getGeneration(), i10);
    }
}
