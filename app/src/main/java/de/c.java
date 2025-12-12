package de;

import ee.a0;
import ee.g;
import ee.m;
import ee.n;
import ee.q;
import ee.r;
import ee.s;
import ee.v;
import ee.w;
import ee.x;
import ee.y;
import ee.z;
import h.j;
import h.k;
import i.t;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import kg.e0;
import kg.g0;
import kg.h;
import kg.h0;
import kg.s0;
import kotlin.NoWhenBranchMatchedException;
import zf.i;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f11013a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f11014b;

    /* renamed from: c, reason: collision with root package name */
    public final ng.f f11015c;

    public c(InputStream inputStream, g0 g0Var) {
        i.checkNotNullParameter(inputStream, "inputStream");
        i.checkNotNullParameter(g0Var, "outScope");
        this.f11013a = inputStream;
        this.f11015c = ng.i.MutableSharedFlow$default(0, 0, null, 7, null);
        int i10 = e0.f15105h;
        g0 g0VarCoroutineScope = h0.CoroutineScope(s0.getIO().plus(new b(e0.b.f15106b, g0Var)));
        this.f11014b = g0VarCoroutineScope;
        h.launch$default(g0VarCoroutineScope, new kotlinx.coroutines.c("Receive"), null, new h.b(this, null), 2, null);
    }

    public static final w a(c cVar, t tVar) throws k, j, IOException {
        w xVar;
        w nVar;
        cVar.getClass();
        DataInputStream dataInputStream = new DataInputStream(cVar.f11013a);
        i.checkNotNullParameter(tVar, "type");
        i.checkNotNullParameter(dataInputStream, "stream");
        byte[] bArr = new byte[16];
        dataInputStream.read(bArr);
        switch (tVar) {
            case EF0:
                throw new k();
            case f13083m:
            case f13084n:
            case EF5:
            case f13086p:
            case f13087q:
            case EF14:
            case EF12:
            case EF10:
            case EF6:
            case EF4:
                throw new j(tVar);
            case f13085o:
            case f13088r:
            case f13089s:
            case f13091u:
            case f13092v:
            case f13093w:
                i.checkNotNullParameter(tVar, "type");
                i.checkNotNullParameter(bArr, "instanceId");
                i.checkNotNullParameter(dataInputStream, "stream");
                int iA = a.a(dataInputStream);
                int iOrdinal = tVar.ordinal();
                if (iOrdinal != 4) {
                    if (iOrdinal == 7) {
                        nVar = new n(bArr, iA, a.c(dataInputStream), a.a(dataInputStream));
                    } else if (iOrdinal == 8) {
                        xVar = new r(iA, bArr);
                        break;
                    } else {
                        switch (iOrdinal) {
                            case 15:
                                nVar = new ee.d(bArr, iA, a.c(dataInputStream), a.a(dataInputStream));
                                break;
                            case 16:
                                String strC = a.c(dataInputStream);
                                int iA2 = a.a(dataInputStream);
                                int iA3 = a.a(dataInputStream);
                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                for (int i10 = 0; i10 < iA3; i10++) {
                                    linkedHashMap.put(a.c(dataInputStream), a.c(dataInputStream));
                                }
                                xVar = new q(bArr, iA, strC, iA2, linkedHashMap);
                                break;
                            case 17:
                                nVar = new ee.j(bArr, iA, a.b(dataInputStream));
                                break;
                            default:
                                throw new j(tVar);
                        }
                    }
                    xVar = nVar;
                    break;
                } else {
                    byte[] bArr2 = new byte[a.a(dataInputStream)];
                    dataInputStream.readFully(bArr2);
                    xVar = new x(bArr, iA, bArr2);
                    break;
                }
            case f13090t:
                xVar = new z(bArr);
                break;
            case f13094x:
            case f13095y:
            case EF4:
            case A:
            case B:
            case E:
            case F:
            case H:
                i.checkNotNullParameter(tVar, "type");
                i.checkNotNullParameter(bArr, "instanceId");
                i.checkNotNullParameter(dataInputStream, "stream");
                boolean z10 = dataInputStream.readBoolean();
                String strC2 = a.c(dataInputStream);
                int iOrdinal2 = tVar.ordinal();
                if (iOrdinal2 != 18) {
                    if (iOrdinal2 != 19) {
                        if (iOrdinal2 != 22) {
                            if (iOrdinal2 != 23) {
                                if (iOrdinal2 != 26) {
                                    if (iOrdinal2 != 27) {
                                        if (iOrdinal2 != 29) {
                                            throw new j(tVar);
                                        }
                                        xVar = new ee.a(bArr, z10, strC2);
                                        break;
                                    } else {
                                        i.checkNotNullParameter(dataInputStream, "<this>");
                                        double dLongBitsToDouble = Double.longBitsToDouble(a.b(dataInputStream));
                                        i.checkNotNullParameter(dataInputStream, "<this>");
                                        xVar = new ee.k(bArr, z10, strC2, dLongBitsToDouble, Double.longBitsToDouble(a.b(dataInputStream)));
                                        break;
                                    }
                                } else {
                                    xVar = new ee.b(bArr, z10, strC2, a.b(dataInputStream), a.b(dataInputStream), a.b(dataInputStream));
                                    break;
                                }
                            } else {
                                xVar = new ee.i(bArr, z10, strC2);
                                break;
                            }
                        } else {
                            xVar = new g(bArr, z10, strC2);
                            break;
                        }
                    } else {
                        xVar = new m(bArr, z10, strC2);
                        break;
                    }
                } else {
                    xVar = new v(bArr, z10, strC2);
                    break;
                }
            case f13096z:
            case C:
            case D:
                i.checkNotNullParameter(tVar, "type");
                i.checkNotNullParameter(bArr, "instanceId");
                i.checkNotNullParameter(dataInputStream, "stream");
                boolean z11 = dataInputStream.readBoolean();
                String strC3 = a.c(dataInputStream);
                int iA4 = a.a(dataInputStream);
                int iOrdinal3 = tVar.ordinal();
                if (iOrdinal3 != 21) {
                    if (iOrdinal3 != 25) {
                        throw new j(tVar);
                    }
                    xVar = new s(bArr, z11, strC3, iA4);
                    break;
                } else {
                    xVar = new y(bArr, z11, strC3, iA4);
                    break;
                }
            case G:
                xVar = new a0(bArr);
                break;
            case I:
                xVar = new ee.t(bArr, a.c(dataInputStream));
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        ng.g gVar = k.c.f14701a;
        k.c.a("Receiver", "<-- " + xVar);
        return xVar;
    }
}
