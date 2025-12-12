package com.google.android.gms.common.internal;

import ac.c;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@KeepForSdk
/* loaded from: classes.dex */
public final class Objects {

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    @KeepForSdk
    public static final class ToStringHelper {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f7353a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f7354b;

        public /* synthetic */ ToStringHelper(Object obj) {
            Preconditions.checkNotNull(obj);
            this.f7354b = obj;
            this.f7353a = new ArrayList();
        }

        @KeepForSdk
        public ToStringHelper add(String str, Object obj) {
            Preconditions.checkNotNull(str);
            this.f7353a.add(c.C(str, "=", String.valueOf(obj)));
            return this;
        }

        @KeepForSdk
        public String toString() {
            StringBuilder sb2 = new StringBuilder(100);
            sb2.append(this.f7354b.getClass().getSimpleName());
            sb2.append('{');
            ArrayList arrayList = this.f7353a;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append((String) arrayList.get(i10));
                if (i10 < size - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append('}');
            return sb2.toString();
        }
    }

    private Objects() {
        throw new AssertionError("Uninstantiable");
    }

    @KeepForSdk
    public static boolean checkBundlesEquality(Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!equal(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    @KeepForSdk
    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @KeepForSdk
    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @KeepForSdk
    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
