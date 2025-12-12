package s8;

import com.google.auto.value.AutoValue;
import t8.f0;

/* compiled from: RolloutAssignment.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final b9.a f19162a = new d9.c().configureWith(a.f19119a).build();

    public static k create(String str, String str2, String str3, String str4, long j10) {
        if (str3.length() > 256) {
            str3 = str3.substring(0, 256);
        }
        return new b(str, str2, str3, str4, j10);
    }

    public abstract String getParameterKey();

    public abstract String getParameterValue();

    public abstract String getRolloutId();

    public abstract long getTemplateVersion();

    public abstract String getVariantId();

    public f0.e.d.AbstractC0277e toReportProto() {
        return f0.e.d.AbstractC0277e.builder().setRolloutVariant(f0.e.d.AbstractC0277e.b.builder().setVariantId(getVariantId()).setRolloutId(getRolloutId()).build()).setParameterKey(getParameterKey()).setParameterValue(getParameterValue()).setTemplateVersion(getTemplateVersion()).build();
    }
}
