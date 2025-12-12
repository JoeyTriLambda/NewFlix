package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import o4.b;
import r4.c;
import r4.f;
import r4.k;

@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements c {
    @Override // r4.c
    public k create(f fVar) {
        return new b(fVar.getApplicationContext(), fVar.getWallClock(), fVar.getMonotonicClock());
    }
}
