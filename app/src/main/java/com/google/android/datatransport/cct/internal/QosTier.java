package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.google.android.datatransport.cct.internal.QosTier, still in use, count: 1, list:
  (r1v1 com.google.android.datatransport.cct.internal.QosTier) from 0x004b: INVOKE (r11v3 android.util.SparseArray), (1 int), (r1v1 com.google.android.datatransport.cct.internal.QosTier) VIRTUAL call: android.util.SparseArray.put(int, java.lang.Object):void A[MD:(int, E):void (c)] (LINE:76)
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(Unknown Source)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class QosTier {
    DEFAULT,
    /* JADX INFO: Fake field, exist only in values array */
    UNMETERED_ONLY,
    /* JADX INFO: Fake field, exist only in values array */
    UNMETERED_OR_DAILY,
    /* JADX INFO: Fake field, exist only in values array */
    FAST_IF_RADIO_AWAKE,
    /* JADX INFO: Fake field, exist only in values array */
    NEVER,
    /* JADX INFO: Fake field, exist only in values array */
    UNRECOGNIZED;

    static {
        QosTier qosTier = DEFAULT;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, qosTier);
        sparseArray.put(1, qosTier);
        sparseArray.put(2, qosTier);
        sparseArray.put(3, qosTier);
        sparseArray.put(4, qosTier);
        sparseArray.put(-1, qosTier);
    }

    public QosTier() {
    }

    public static QosTier valueOf(String str) {
        return (QosTier) Enum.valueOf(QosTier.class, str);
    }

    public static QosTier[] values() {
        return (QosTier[]) f5621m.clone();
    }
}
