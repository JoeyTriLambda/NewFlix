package y5;

import java.io.IOException;
import java.util.LinkedList;

/* compiled from: HlsSampleStream.java */
/* loaded from: classes.dex */
public final class i implements u5.k {

    /* renamed from: b, reason: collision with root package name */
    public final int f21978b;

    /* renamed from: m, reason: collision with root package name */
    public final j f21979m;

    public i(j jVar, int i10) {
        this.f21979m = jVar;
        this.f21978b = i10;
    }

    @Override // u5.k
    public boolean isReady() {
        j jVar = this.f21979m;
        return jVar.N || (!jVar.c() && jVar.f21992x[this.f21978b].hasNextSample());
    }

    @Override // u5.k
    public void maybeThrowError() throws IOException {
        j jVar = this.f21979m;
        jVar.f21986r.maybeThrowError();
        jVar.f21982n.maybeThrowError();
    }

    @Override // u5.k
    public int readData(c5.j jVar, e5.e eVar, boolean z10) {
        j jVar2 = this.f21979m;
        if (jVar2.c()) {
            return -3;
        }
        LinkedList<f> linkedList = jVar2.f21989u;
        if (!linkedList.isEmpty()) {
            while (true) {
                boolean z11 = true;
                if (linkedList.size() <= 1) {
                    break;
                }
                int i10 = linkedList.getFirst().f21940j;
                int i11 = 0;
                while (true) {
                    u5.j[] jVarArr = jVar2.f21992x;
                    if (i11 < jVarArr.length) {
                        if (jVar2.H[i11] && jVarArr[i11].peekSourceId() == i10) {
                            z11 = false;
                            break;
                        }
                        i11++;
                    } else {
                        break;
                    }
                }
                if (!z11) {
                    break;
                }
                linkedList.removeFirst();
            }
            f first = linkedList.getFirst();
            c5.i iVar = first.f20468c;
            if (!iVar.equals(jVar2.C)) {
                jVar2.f21987s.downstreamFormatChanged(jVar2.f21980b, iVar, first.f20469d, first.f20470e, first.f20471f);
            }
            jVar2.C = iVar;
        }
        return jVar2.f21992x[this.f21978b].read(jVar, eVar, z10, jVar2.N, jVar2.J);
    }

    @Override // u5.k
    public void skipData(long j10) {
        j jVar = this.f21979m;
        u5.j jVar2 = jVar.f21992x[this.f21978b];
        if (!jVar.N || j10 <= jVar2.getLargestQueuedTimestampUs()) {
            jVar2.advanceTo(j10, true, true);
        } else {
            jVar2.advanceToEnd();
        }
    }
}
