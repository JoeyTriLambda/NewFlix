package com.unity3d.services.ads.gmascar.managers;

/* loaded from: classes2.dex */
public enum SCARBiddingManagerType {
    DISABLED("dis"),
    EAGER("eag"),
    LAZY("laz"),
    HYBRID("hyb");

    private final String name;

    public static class Constants {
        private static final String DIS = "dis";
        private static final String EAG = "eag";
        private static final String HYB = "hyb";
        private static final String LAZ = "laz";

        private Constants() {
        }
    }

    SCARBiddingManagerType(String str) {
        this.name = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType fromName(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 2
            r2 = 1
            switch(r0) {
                case 99470: goto L28;
                case 100171: goto L1e;
                case 103793: goto L14;
                case 106917: goto La;
                default: goto L9;
            }
        L9:
            goto L32
        La:
            java.lang.String r0 = "laz"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 1
            goto L33
        L14:
            java.lang.String r0 = "hyb"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 2
            goto L33
        L1e:
            java.lang.String r0 = "eag"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 0
            goto L33
        L28:
            java.lang.String r0 = "dis"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            r3 = 3
            goto L33
        L32:
            r3 = -1
        L33:
            if (r3 == 0) goto L42
            if (r3 == r2) goto L3f
            if (r3 == r1) goto L3c
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.DISABLED
            return r3
        L3c:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.HYBRID
            return r3
        L3f:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.LAZY
            return r3
        L42:
            com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType r3 = com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.EAGER
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType.fromName(java.lang.String):com.unity3d.services.ads.gmascar.managers.SCARBiddingManagerType");
    }

    public String getName() {
        return this.name;
    }
}
