package j6;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import c5.p;
import c5.q;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Arrays;
import java.util.Map;
import u5.n;
import u5.o;

/* compiled from: MappingTrackSelector.java */
/* loaded from: classes.dex */
public abstract class e extends h {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray<Map<o, b>> f14660a = new SparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    public final SparseBooleanArray f14661b = new SparseBooleanArray();

    /* renamed from: c, reason: collision with root package name */
    public a f14662c;

    /* compiled from: MappingTrackSelector.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f14663a;

        /* renamed from: b, reason: collision with root package name */
        public final o[] f14664b;

        public a(o[] oVarArr) {
            this.f14664b = oVarArr;
            this.f14663a = oVarArr.length;
        }

        public o getTrackGroups(int i10) {
            return this.f14664b[i10];
        }
    }

    /* compiled from: MappingTrackSelector.java */
    public static final class b {
        public f createTrackSelection(o oVar) {
            oVar.get(0);
            throw null;
        }
    }

    public final a getCurrentMappedTrackInfo() {
        return this.f14662c;
    }

    public final boolean hasSelectionOverride(int i10, o oVar) {
        Map<o, b> map = this.f14660a.get(i10);
        return map != null && map.containsKey(oVar);
    }

    @Override // j6.h
    public final void onSelectionActivated(Object obj) {
        this.f14662c = (a) obj;
    }

    @Override // j6.h
    public final i selectTracks(p[] pVarArr, o oVar) throws ExoPlaybackException {
        int[] iArr;
        int[] iArr2 = new int[pVarArr.length + 1];
        int length = pVarArr.length + 1;
        n[][] nVarArr = new n[length][];
        int[][][] iArr3 = new int[pVarArr.length + 1][][];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = oVar.f20111a;
            nVarArr[i10] = new n[i11];
            iArr3[i10] = new int[i11][];
        }
        int length2 = pVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i12 = 0; i12 < length2; i12++) {
            iArr4[i12] = pVarArr[i12].supportsMixedMimeTypeAdaptation();
        }
        for (int i13 = 0; i13 < oVar.f20111a; i13++) {
            n nVar = oVar.get(i13);
            int length3 = pVarArr.length;
            int i14 = 0;
            int i15 = 0;
            while (true) {
                if (i14 >= pVarArr.length) {
                    break;
                }
                p pVar = pVarArr[i14];
                for (int i16 = 0; i16 < nVar.f20107a; i16++) {
                    int iSupportsFormat = pVar.supportsFormat(nVar.getFormat(i16)) & 7;
                    if (iSupportsFormat > i15) {
                        if (iSupportsFormat == 4) {
                            length3 = i14;
                            break;
                        }
                        length3 = i14;
                        i15 = iSupportsFormat;
                    }
                }
                i14++;
            }
            if (length3 == pVarArr.length) {
                iArr = new int[nVar.f20107a];
            } else {
                p pVar2 = pVarArr[length3];
                int[] iArr5 = new int[nVar.f20107a];
                for (int i17 = 0; i17 < nVar.f20107a; i17++) {
                    iArr5[i17] = pVar2.supportsFormat(nVar.getFormat(i17));
                }
                iArr = iArr5;
            }
            int i18 = iArr2[length3];
            nVarArr[length3][i18] = nVar;
            iArr3[length3][i18] = iArr;
            iArr2[length3] = i18 + 1;
        }
        o[] oVarArr = new o[pVarArr.length];
        int[] iArr6 = new int[pVarArr.length];
        for (int i19 = 0; i19 < pVarArr.length; i19++) {
            int i20 = iArr2[i19];
            oVarArr[i19] = new o((n[]) Arrays.copyOf(nVarArr[i19], i20));
            iArr3[i19] = (int[][]) Arrays.copyOf(iArr3[i19], i20);
            iArr6[i19] = ((c5.a) pVarArr[i19]).getTrackType();
        }
        new o((n[]) Arrays.copyOf(nVarArr[pVarArr.length], iArr2[pVarArr.length]));
        f[] fVarArrSelectTracks = selectTracks(pVarArr, oVarArr, iArr3);
        int i21 = 0;
        while (true) {
            if (i21 >= pVarArr.length) {
                break;
            }
            if (this.f14661b.get(i21)) {
                fVarArrSelectTracks[i21] = null;
            } else {
                o oVar2 = oVarArr[i21];
                if (hasSelectionOverride(i21, oVar2)) {
                    b bVar = this.f14660a.get(i21).get(oVar2);
                    fVarArrSelectTracks[i21] = bVar != null ? bVar.createTrackSelection(oVar2) : null;
                }
            }
            i21++;
        }
        a aVar = new a(oVarArr);
        q[] qVarArr = new q[pVarArr.length];
        for (int i22 = 0; i22 < pVarArr.length; i22++) {
            qVarArr[i22] = fVarArrSelectTracks[i22] != null ? q.f5146b : null;
        }
        return new i(oVar, new g(fVarArrSelectTracks), aVar, qVarArr);
    }

    public abstract f[] selectTracks(p[] pVarArr, o[] oVarArr, int[][][] iArr) throws ExoPlaybackException;
}
