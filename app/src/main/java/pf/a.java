package pf;

import java.util.Timer;

/* compiled from: Timer.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final Timer timer(String str, boolean z10) {
        return str == null ? new Timer(z10) : new Timer(str, z10);
    }
}
