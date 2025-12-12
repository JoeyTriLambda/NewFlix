package com.google.android.gms.internal.measurement;

import b8.g;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableSetMultimap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* loaded from: classes.dex */
public final class zzhx {
    public static final g<ImmutableSetMultimap<String, String>> zza = Suppliers.memoize(new g() { // from class: com.google.android.gms.internal.measurement.zzhw
        @Override // b8.g
        public final Object get() {
            return new ImmutableSetMultimap.a().build();
        }
    });
}
