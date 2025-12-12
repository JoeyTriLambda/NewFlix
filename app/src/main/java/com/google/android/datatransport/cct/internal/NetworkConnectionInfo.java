package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import com.google.android.datatransport.cct.internal.c;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class NetworkConnectionInfo {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v1 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype, still in use, count: 1, list:
  (r1v1 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype) from 0x0127: INVOKE 
  (r2v11 android.util.SparseArray<com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype>)
  (1 int)
  (r1v1 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$MobileSubtype)
 VIRTUAL call: android.util.SparseArray.put(int, java.lang.Object):void A[MD:(int, E):void (c)] (LINE:296)
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
    public static final class MobileSubtype {
        UNKNOWN_MOBILE_SUBTYPE(0),
        /* JADX INFO: Fake field, exist only in values array */
        GPRS(1),
        /* JADX INFO: Fake field, exist only in values array */
        EDGE(2),
        /* JADX INFO: Fake field, exist only in values array */
        UMTS(3),
        /* JADX INFO: Fake field, exist only in values array */
        CDMA(4),
        /* JADX INFO: Fake field, exist only in values array */
        EVDO_0(5),
        /* JADX INFO: Fake field, exist only in values array */
        EVDO_A(6),
        /* JADX INFO: Fake field, exist only in values array */
        RTT(7),
        /* JADX INFO: Fake field, exist only in values array */
        HSDPA(8),
        /* JADX INFO: Fake field, exist only in values array */
        HSUPA(9),
        /* JADX INFO: Fake field, exist only in values array */
        HSPA(10),
        /* JADX INFO: Fake field, exist only in values array */
        IDEN(11),
        /* JADX INFO: Fake field, exist only in values array */
        EVDO_B(12),
        /* JADX INFO: Fake field, exist only in values array */
        LTE_CA(13),
        /* JADX INFO: Fake field, exist only in values array */
        TD_SCDMA(14),
        /* JADX INFO: Fake field, exist only in values array */
        IWLAN(15),
        /* JADX INFO: Fake field, exist only in values array */
        LTE_CA(16),
        /* JADX INFO: Fake field, exist only in values array */
        TD_SCDMA(17),
        /* JADX INFO: Fake field, exist only in values array */
        IWLAN(18),
        /* JADX INFO: Fake field, exist only in values array */
        LTE_CA(19),
        COMBINED(100);


        /* renamed from: o, reason: collision with root package name */
        public static final SparseArray<MobileSubtype> f5613o;

        /* renamed from: b, reason: collision with root package name */
        public final int f5615b;

        static {
            MobileSubtype mobileSubtype = UNKNOWN_MOBILE_SUBTYPE;
            SparseArray<MobileSubtype> sparseArray = new SparseArray<>();
            f5613o = sparseArray;
            sparseArray.put(0, mobileSubtype);
            sparseArray.put(1, mobileSubtype);
            sparseArray.put(2, mobileSubtype);
            sparseArray.put(3, mobileSubtype);
            sparseArray.put(4, mobileSubtype);
            sparseArray.put(5, mobileSubtype);
            sparseArray.put(6, mobileSubtype);
            sparseArray.put(7, mobileSubtype);
            sparseArray.put(8, mobileSubtype);
            sparseArray.put(9, mobileSubtype);
            sparseArray.put(10, mobileSubtype);
            sparseArray.put(11, mobileSubtype);
            sparseArray.put(12, mobileSubtype);
            sparseArray.put(13, mobileSubtype);
            sparseArray.put(14, mobileSubtype);
            sparseArray.put(15, mobileSubtype);
            sparseArray.put(16, mobileSubtype);
            sparseArray.put(17, mobileSubtype);
            sparseArray.put(18, mobileSubtype);
            sparseArray.put(19, mobileSubtype);
        }

        public MobileSubtype(int i10) {
            this.f5615b = i10;
        }

        public static MobileSubtype forNumber(int i10) {
            return f5613o.get(i10);
        }

        public static MobileSubtype valueOf(String str) {
            return (MobileSubtype) Enum.valueOf(MobileSubtype.class, str);
        }

        public static MobileSubtype[] values() {
            return (MobileSubtype[]) f5614p.clone();
        }

        public int getValue() {
            return this.f5615b;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType, still in use, count: 1, list:
  (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType) from 0x010a: INVOKE 
  (r4v8 android.util.SparseArray<com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType>)
  (0 int)
  (r0v0 com.google.android.datatransport.cct.internal.NetworkConnectionInfo$NetworkType)
 VIRTUAL call: android.util.SparseArray.put(int, java.lang.Object):void A[MD:(int, E):void (c)] (LINE:267)
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
    public static final class NetworkType {
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE(0),
        /* JADX INFO: Fake field, exist only in values array */
        WIFI(1),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_MMS(2),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_SUPL(3),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_DUN(4),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_HIPRI(5),
        /* JADX INFO: Fake field, exist only in values array */
        WIMAX(6),
        /* JADX INFO: Fake field, exist only in values array */
        BLUETOOTH(7),
        /* JADX INFO: Fake field, exist only in values array */
        DUMMY(8),
        /* JADX INFO: Fake field, exist only in values array */
        ETHERNET(9),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_FOTA(10),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_IMS(11),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_CBS(12),
        /* JADX INFO: Fake field, exist only in values array */
        PROXY(13),
        /* JADX INFO: Fake field, exist only in values array */
        VPN(14),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_EMERGENCY(15),
        /* JADX INFO: Fake field, exist only in values array */
        PROXY(16),
        /* JADX INFO: Fake field, exist only in values array */
        VPN(17),
        NONE(-1);


        /* renamed from: n, reason: collision with root package name */
        public static final SparseArray<NetworkType> f5617n;

        /* renamed from: b, reason: collision with root package name */
        public final int f5619b;

        static {
            NetworkType networkType = NONE;
            SparseArray<NetworkType> sparseArray = new SparseArray<>();
            f5617n = sparseArray;
            sparseArray.put(0, networkType);
            sparseArray.put(1, networkType);
            sparseArray.put(2, networkType);
            sparseArray.put(3, networkType);
            sparseArray.put(4, networkType);
            sparseArray.put(5, networkType);
            sparseArray.put(6, networkType);
            sparseArray.put(7, networkType);
            sparseArray.put(8, networkType);
            sparseArray.put(9, networkType);
            sparseArray.put(10, networkType);
            sparseArray.put(11, networkType);
            sparseArray.put(12, networkType);
            sparseArray.put(13, networkType);
            sparseArray.put(14, networkType);
            sparseArray.put(15, networkType);
            sparseArray.put(16, networkType);
            sparseArray.put(17, networkType);
            sparseArray.put(-1, networkType);
        }

        public NetworkType(int i10) {
            this.f5619b = i10;
        }

        public static NetworkType forNumber(int i10) {
            return f5617n.get(i10);
        }

        public static NetworkType valueOf(String str) {
            return (NetworkType) Enum.valueOf(NetworkType.class, str);
        }

        public static NetworkType[] values() {
            return (NetworkType[]) f5618o.clone();
        }

        public int getValue() {
            return this.f5619b;
        }
    }

    @AutoValue.Builder
    public static abstract class a {
        public abstract NetworkConnectionInfo build();

        public abstract a setMobileSubtype(MobileSubtype mobileSubtype);

        public abstract a setNetworkType(NetworkType networkType);
    }

    public static a builder() {
        return new c.a();
    }

    public abstract MobileSubtype getMobileSubtype();

    public abstract NetworkType getNetworkType();
}
