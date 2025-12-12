package go;

import ac.c;
import android.content.Context;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.logging.Logger;
import o1.a;

/* loaded from: classes2.dex */
public class Seq {
    private static final int NULL_REFNUM = 41;
    static final RefTracker tracker;
    private static Logger log = Logger.getLogger("GoSeq");
    public static final Ref nullRef = new Ref(41, null);
    private static final GoRefQueue goRefQueue = new GoRefQueue();

    public interface GoObject {
        int incRefnum();
    }

    public static class GoRef extends PhantomReference<GoObject> {
        final int refnum;

        public GoRef(int i10, GoObject goObject, GoRefQueue goRefQueue) {
            super(goObject, goRefQueue);
            if (i10 > 0) {
                throw new RuntimeException(c.f("GoRef instantiated with a Java refnum ", i10));
            }
            this.refnum = i10;
        }
    }

    public static class GoRefQueue extends ReferenceQueue<GoObject> {
        private final Collection<GoRef> refs = Collections.synchronizedCollection(new HashSet());

        public GoRefQueue() {
            Thread thread = new Thread(new Runnable() { // from class: go.Seq.GoRefQueue.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            GoRef goRef = (GoRef) GoRefQueue.this.remove();
                            GoRefQueue.this.refs.remove(goRef);
                            Seq.destroyRef(goRef.refnum);
                            goRef.clear();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            });
            thread.setDaemon(true);
            thread.setName("GoRefQueue Finalizer Thread");
            thread.start();
        }

        public void track(int i10, GoObject goObject) {
            this.refs.add(new GoRef(i10, goObject, this));
        }
    }

    public interface Proxy extends GoObject {
    }

    public static final class Ref {
        public final Object obj;
        private int refcnt;
        public final int refnum;

        public Ref(int i10, Object obj) {
            if (i10 < 0) {
                throw new RuntimeException(c.f("Ref instantiated with a Go refnum ", i10));
            }
            this.refnum = i10;
            this.refcnt = 0;
            this.obj = obj;
        }

        public static /* synthetic */ int access$110(Ref ref) {
            int i10 = ref.refcnt;
            ref.refcnt = i10 - 1;
            return i10;
        }

        public void inc() {
            int i10 = this.refcnt;
            if (i10 == Integer.MAX_VALUE) {
                throw new RuntimeException(c.m(new StringBuilder("refnum "), this.refnum, " overflow"));
            }
            this.refcnt = i10 + 1;
        }
    }

    public static final class RefMap {
        private int next = 0;
        private int live = 0;
        private int[] keys = new int[16];
        private Ref[] objs = new Ref[16];

        private void grow() {
            Ref[] refArr;
            int iRoundPow2 = roundPow2(this.live) * 2;
            int[] iArr = this.keys;
            if (iRoundPow2 > iArr.length) {
                iArr = new int[iArr.length * 2];
                refArr = new Ref[this.objs.length * 2];
            } else {
                refArr = this.objs;
            }
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int[] iArr2 = this.keys;
                if (i10 >= iArr2.length) {
                    break;
                }
                Ref ref = this.objs[i10];
                if (ref != null) {
                    iArr[i11] = iArr2[i10];
                    refArr[i11] = ref;
                    i11++;
                }
                i10++;
            }
            for (int i12 = i11; i12 < iArr.length; i12++) {
                iArr[i12] = 0;
                refArr[i12] = null;
            }
            this.keys = iArr;
            this.objs = refArr;
            this.next = i11;
            if (this.live == i11) {
                return;
            }
            throw new RuntimeException("bad state: live=" + this.live + ", next=" + this.next);
        }

        private static int roundPow2(int i10) {
            int i11 = 1;
            while (i11 < i10) {
                i11 *= 2;
            }
            return i11;
        }

        public Ref get(int i10) {
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i10);
            if (iBinarySearch >= 0) {
                return this.objs[iBinarySearch];
            }
            return null;
        }

        public void put(int i10, Ref ref) {
            if (ref == null) {
                throw new RuntimeException(a.d("put a null ref (with key ", i10, ")"));
            }
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i10);
            if (iBinarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[iBinarySearch] == null) {
                    refArr[iBinarySearch] = ref;
                    this.live++;
                }
                if (refArr[iBinarySearch] != ref) {
                    throw new RuntimeException(a.d("replacing an existing ref (with key ", i10, ")"));
                }
                return;
            }
            if (this.next >= this.keys.length) {
                grow();
                iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i10);
            }
            int i11 = ~iBinarySearch;
            int i12 = this.next;
            if (i11 < i12) {
                int[] iArr = this.keys;
                int i13 = i11 + 1;
                System.arraycopy(iArr, i11, iArr, i13, i12 - i11);
                Ref[] refArr2 = this.objs;
                System.arraycopy(refArr2, i11, refArr2, i13, this.next - i11);
            }
            this.keys[i11] = i10;
            this.objs[i11] = ref;
            this.live++;
            this.next++;
        }

        public void remove(int i10) {
            int iBinarySearch = Arrays.binarySearch(this.keys, 0, this.next, i10);
            if (iBinarySearch >= 0) {
                Ref[] refArr = this.objs;
                if (refArr[iBinarySearch] != null) {
                    refArr[iBinarySearch] = null;
                    this.live--;
                }
            }
        }
    }

    public static final class RefTracker {
        private static final int REF_OFFSET = 42;
        private int next = 42;
        private final RefMap javaObjs = new RefMap();
        private final IdentityHashMap<Object, Integer> javaRefs = new IdentityHashMap<>();

        public synchronized void dec(int i10) {
            if (i10 <= 0) {
                Seq.log.severe("dec request for Go object " + i10);
                return;
            }
            if (i10 == Seq.nullRef.refnum) {
                return;
            }
            Ref ref = this.javaObjs.get(i10);
            if (ref == null) {
                throw new RuntimeException("referenced Java object is not found: refnum=" + i10);
            }
            Ref.access$110(ref);
            if (ref.refcnt <= 0) {
                this.javaObjs.remove(i10);
                this.javaRefs.remove(ref.obj);
            }
        }

        public synchronized Ref get(int i10) {
            if (i10 < 0) {
                throw new RuntimeException("ref called with Go refnum " + i10);
            }
            if (i10 == 41) {
                return Seq.nullRef;
            }
            Ref ref = this.javaObjs.get(i10);
            if (ref != null) {
                return ref;
            }
            throw new RuntimeException("unknown java Ref: " + i10);
        }

        public synchronized int inc(Object obj) {
            if (obj == null) {
                return 41;
            }
            if (obj instanceof Proxy) {
                return ((Proxy) obj).incRefnum();
            }
            Integer numValueOf = this.javaRefs.get(obj);
            if (numValueOf == null) {
                int i10 = this.next;
                if (i10 == Integer.MAX_VALUE) {
                    throw new RuntimeException("createRef overflow for " + obj);
                }
                this.next = i10 + 1;
                numValueOf = Integer.valueOf(i10);
                this.javaRefs.put(obj, numValueOf);
            }
            int iIntValue = numValueOf.intValue();
            Ref ref = this.javaObjs.get(iIntValue);
            if (ref == null) {
                ref = new Ref(iIntValue, obj);
                this.javaObjs.put(iIntValue, ref);
            }
            ref.inc();
            return iIntValue;
        }

        public synchronized void incRefnum(int i10) {
            Ref ref = this.javaObjs.get(i10);
            if (ref == null) {
                throw new RuntimeException("referenced Java object is not found: refnum=" + i10);
            }
            ref.inc();
        }
    }

    static {
        System.loadLibrary("gojni");
        init();
        Universe.touch();
        tracker = new RefTracker();
    }

    private Seq() {
    }

    public static void decRef(int i10) {
        tracker.dec(i10);
    }

    public static native void destroyRef(int i10);

    public static Ref getRef(int i10) {
        return tracker.get(i10);
    }

    public static int incGoObjectRef(GoObject goObject) {
        return goObject.incRefnum();
    }

    public static native void incGoRef(int i10, GoObject goObject);

    public static int incRef(Object obj) {
        return tracker.inc(obj);
    }

    public static void incRefnum(int i10) {
        tracker.incRefnum(i10);
    }

    private static native void init();

    public static void setContext(Context context) {
        setContext((Object) context);
    }

    public static native void setContext(Object obj);

    public static void trackGoRef(int i10, GoObject goObject) {
        if (i10 > 0) {
            throw new RuntimeException(c.f("trackGoRef called with Java refnum ", i10));
        }
        goRefQueue.track(i10, goObject);
    }

    public static void touch() {
    }
}
