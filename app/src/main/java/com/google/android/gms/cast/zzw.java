package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast@@21.4.0 */
/* loaded from: classes.dex */
final class zzw {

    /* renamed from: a, reason: collision with root package name */
    public final String f7009a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7010b;

    /* renamed from: c, reason: collision with root package name */
    public final Collection f7011c;

    public /* synthetic */ zzw(String str, String str2, Collection collection) {
        this.f7009a = str;
        this.f7010b = str2;
        this.f7011c = collection;
    }

    public static /* bridge */ /* synthetic */ String a(zzw zzwVar) throws IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder(zzwVar.f7009a);
        String str = zzwVar.f7010b;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException("Invalid application ID: ".concat(str));
            }
            sb2.append("/");
            sb2.append(upperCase);
        }
        Collection<String> collection = zzwVar.f7011c;
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str == null) {
                sb2.append("/");
            }
            sb2.append("/");
            boolean z10 = true;
            for (String str2 : collection) {
                CastUtils.throwIfInvalidNamespace(str2);
                if (!z10) {
                    sb2.append(",");
                }
                sb2.append(CastUtils.zzc(str2));
                z10 = false;
            }
        }
        if (str == null && collection == null) {
            sb2.append("/");
        }
        if (collection == null) {
            sb2.append("/");
        }
        sb2.append("//ALLOW_IPV6");
        return sb2.toString();
    }
}
