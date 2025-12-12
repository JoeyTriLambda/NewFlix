package c6;

import b6.h;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* compiled from: CeaDecoder.java */
/* loaded from: classes.dex */
public abstract class d implements b6.e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList<b6.g> f5239a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList<h> f5240b;

    /* renamed from: c, reason: collision with root package name */
    public final PriorityQueue<b6.g> f5241c;

    /* renamed from: d, reason: collision with root package name */
    public b6.g f5242d;

    /* renamed from: e, reason: collision with root package name */
    public long f5243e;

    public d() {
        for (int i10 = 0; i10 < 10; i10++) {
            this.f5239a.add(new b6.g());
        }
        this.f5240b = new LinkedList<>();
        for (int i11 = 0; i11 < 2; i11++) {
            this.f5240b.add(new e(this));
        }
        this.f5241c = new PriorityQueue<>();
    }

    public abstract b6.d createSubtitle();

    public abstract void decode(b6.g gVar);

    @Override // e5.c
    public void flush() {
        LinkedList<b6.g> linkedList;
        this.f5243e = 0L;
        while (true) {
            PriorityQueue<b6.g> priorityQueue = this.f5241c;
            boolean zIsEmpty = priorityQueue.isEmpty();
            linkedList = this.f5239a;
            if (zIsEmpty) {
                break;
            }
            b6.g gVarPoll = priorityQueue.poll();
            gVarPoll.clear();
            linkedList.add(gVarPoll);
        }
        b6.g gVar = this.f5242d;
        if (gVar != null) {
            gVar.clear();
            linkedList.add(gVar);
            this.f5242d = null;
        }
    }

    public abstract boolean isNewSubtitleDataAvailable();

    public void releaseOutputBuffer(h hVar) {
        hVar.clear();
        this.f5240b.add(hVar);
    }

    @Override // b6.e
    public void setPositionUs(long j10) {
        this.f5243e = j10;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // e5.c
    public b6.g dequeueInputBuffer() throws SubtitleDecoderException {
        l6.a.checkState(this.f5242d == null);
        LinkedList<b6.g> linkedList = this.f5239a;
        if (linkedList.isEmpty()) {
            return null;
        }
        b6.g gVarPollFirst = linkedList.pollFirst();
        this.f5242d = gVarPollFirst;
        return gVarPollFirst;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0071, code lost:
    
        return null;
     */
    @Override // e5.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b6.h dequeueOutputBuffer() throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            r11 = this;
            java.util.LinkedList<b6.h> r0 = r11.f5240b
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto La
            return r2
        La:
            java.util.PriorityQueue<b6.g> r1 = r11.f5241c
            boolean r3 = r1.isEmpty()
            if (r3 != 0) goto L71
            java.lang.Object r3 = r1.peek()
            b6.g r3 = (b6.g) r3
            long r3 = r3.f11143o
            long r5 = r11.f5243e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L71
            java.lang.Object r1 = r1.poll()
            b6.g r1 = (b6.g) r1
            boolean r3 = r1.isEndOfStream()
            java.util.LinkedList<b6.g> r4 = r11.f5239a
            if (r3 == 0) goto L3f
            java.lang.Object r0 = r0.pollFirst()
            b6.h r0 = (b6.h) r0
            r2 = 4
            r0.addFlag(r2)
            r1.clear()
            r4.add(r1)
            return r0
        L3f:
            r11.decode(r1)
            boolean r3 = r11.isNewSubtitleDataAvailable()
            if (r3 == 0) goto L6a
            b6.d r8 = r11.createSubtitle()
            boolean r3 = r1.isDecodeOnly()
            if (r3 != 0) goto L6a
            java.lang.Object r0 = r0.pollFirst()
            b6.h r0 = (b6.h) r0
            long r6 = r1.f11143o
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r0
            r5.setContent(r6, r8, r9)
            r1.clear()
            r4.add(r1)
            return r0
        L6a:
            r1.clear()
            r4.add(r1)
            goto La
        L71:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c6.d.dequeueOutputBuffer():b6.h");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // e5.c
    public void queueInputBuffer(b6.g gVar) throws SubtitleDecoderException {
        l6.a.checkArgument(gVar == this.f5242d);
        if (gVar.isDecodeOnly()) {
            gVar.clear();
            this.f5239a.add(gVar);
        } else {
            this.f5241c.add(gVar);
        }
        this.f5242d = null;
    }

    @Override // e5.c
    public void release() {
    }
}
