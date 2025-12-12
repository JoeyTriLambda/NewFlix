package go;

import go.Seq;

/* loaded from: classes2.dex */
public abstract class Universe {

    public static final class proxyerror extends Exception implements Seq.Proxy, error {
        private final int refnum;

        public proxyerror(int i10) {
            this.refnum = i10;
            Seq.trackGoRef(i10, this);
        }

        @Override // go.error
        public native String error();

        @Override // java.lang.Throwable
        public String getMessage() {
            return error();
        }

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }
    }

    static {
        Seq.touch();
        _init();
    }

    private Universe() {
    }

    private static native void _init();

    public static void touch() {
    }
}
