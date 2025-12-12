package th;

import zf.i;

/* compiled from: StringQualifier.kt */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f19924a;

    public c(String str) {
        i.checkNotNullParameter(str, "value");
        this.f19924a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && i.areEqual(getValue(), ((c) obj).getValue());
    }

    @Override // th.a
    public String getValue() {
        return this.f19924a;
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return getValue();
    }
}
