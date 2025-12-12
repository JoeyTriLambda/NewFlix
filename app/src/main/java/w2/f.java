package w2;

/* compiled from: InputMergerFactory.java */
/* loaded from: classes.dex */
public abstract class f {

    /* compiled from: InputMergerFactory.java */
    public class a extends f {
        @Override // w2.f
        public e createInputMerger(String str) {
            return null;
        }
    }

    public static f getDefaultInputMergerFactory() {
        return new a();
    }

    public abstract e createInputMerger(String str);

    public final e createInputMergerWithDefaultFallback(String str) {
        e eVarCreateInputMerger = createInputMerger(str);
        return eVarCreateInputMerger == null ? e.fromClassName(str) : eVarCreateInputMerger;
    }
}
