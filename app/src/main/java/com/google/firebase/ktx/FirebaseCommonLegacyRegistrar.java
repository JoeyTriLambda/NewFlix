package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;
import l8.b;
import mf.j;
import o9.g;

/* compiled from: Logging.kt */
@Keep
/* loaded from: classes.dex */
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b<?>> getComponents() {
        return j.listOf(g.create("fire-core-ktx", "20.4.3"));
    }
}
