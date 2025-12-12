package a2;

import android.media.MediaRoute2Info;
import android.media.RouteDiscoveryPreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: MediaRouter2Utils.java */
/* loaded from: classes.dex */
public final class q {

    /* compiled from: MediaRouter2Utils.java */
    public static final class a {
        public static void copyDescriptorVisibilityToBuilder(MediaRoute2Info.Builder builder, g gVar) {
            if (gVar.isVisibilityPublic()) {
                builder.setVisibilityPublic();
            } else {
                builder.setVisibilityRestricted(gVar.getAllowedPackages());
            }
        }

        public static Set<String> getDeduplicationIds(MediaRoute2Info mediaRoute2Info) {
            return mediaRoute2Info.getDeduplicationIds();
        }

        public static int getType(MediaRoute2Info mediaRoute2Info) {
            return mediaRoute2Info.getType();
        }

        public static void setDeduplicationIds(MediaRoute2Info.Builder builder, Set<String> set) {
            builder.setDeduplicationIds(set);
        }

        public static void setDeviceType(MediaRoute2Info.Builder builder, int i10) {
            builder.setType(i10);
        }
    }

    public static ArrayList a(List list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaRoute2Info mediaRoute2Info = (MediaRoute2Info) it.next();
            if (mediaRoute2Info != null) {
                arrayList.add(mediaRoute2Info.getId());
            }
        }
        return arrayList;
    }

    public static RouteDiscoveryPreference b(h hVar) {
        if (!hVar.isValid()) {
            return new RouteDiscoveryPreference.Builder(new ArrayList(), false).build();
        }
        boolean zIsActiveScan = hVar.isActiveScan();
        ArrayList arrayList = new ArrayList();
        for (String str : hVar.getSelector().getControlCategories()) {
            str.getClass();
            switch (str) {
                case "android.media.intent.category.REMOTE_PLAYBACK":
                    str = "android.media.route.feature.REMOTE_PLAYBACK";
                    break;
                case "android.media.intent.category.LIVE_AUDIO":
                    str = "android.media.route.feature.LIVE_AUDIO";
                    break;
                case "android.media.intent.category.LIVE_VIDEO":
                    str = "android.media.route.feature.LIVE_VIDEO";
                    break;
            }
            arrayList.add(str);
        }
        return new RouteDiscoveryPreference.Builder(arrayList, zIsActiveScan).build();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static a2.g toMediaRouteDescriptor(android.media.MediaRoute2Info r9) {
        /*
            r0 = 0
            if (r9 != 0) goto L4
            return r0
        L4:
            a2.g$a r1 = new a2.g$a
            java.lang.String r2 = a2.d.g(r9)
            java.lang.CharSequence r3 = a2.d.f(r9)
            java.lang.String r3 = r3.toString()
            r1.<init>(r2, r3)
            int r2 = a2.d.a(r9)
            a2.g$a r1 = r1.setConnectionState(r2)
            int r2 = a2.d.w(r9)
            a2.g$a r1 = r1.setVolumeHandling(r2)
            int r2 = a2.d.A(r9)
            a2.g$a r1 = r1.setVolumeMax(r2)
            int r2 = a2.d.D(r9)
            a2.g$a r1 = r1.setVolume(r2)
            android.os.Bundle r2 = a2.d.d(r9)
            a2.g$a r1 = r1.setExtras(r2)
            r2 = 1
            a2.g$a r1 = r1.setEnabled(r2)
            r3 = 0
            a2.g$a r1 = r1.setCanDisconnect(r3)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 34
            if (r4 < r5) goto L78
            java.util.Set r4 = a2.q.a.getDeduplicationIds(r9)
            r1.setDeduplicationIds(r4)
            int r4 = a2.q.a.getType(r9)
            r5 = 2000(0x7d0, float:2.803E-42)
            if (r4 == r5) goto L75
            switch(r4) {
                case 1001: goto L73;
                case 1002: goto L71;
                case 1003: goto L6f;
                case 1004: goto L6d;
                case 1005: goto L6b;
                case 1006: goto L69;
                case 1007: goto L66;
                case 1008: goto L63;
                case 1009: goto L60;
                default: goto L5f;
            }
        L5f:
            goto L78
        L60:
            r4 = 10
            goto L79
        L63:
            r4 = 9
            goto L79
        L66:
            r4 = 8
            goto L79
        L69:
            r4 = 7
            goto L79
        L6b:
            r4 = 6
            goto L79
        L6d:
            r4 = 5
            goto L79
        L6f:
            r4 = 4
            goto L79
        L71:
            r4 = 2
            goto L79
        L73:
            r4 = 1
            goto L79
        L75:
            r4 = 1000(0x3e8, float:1.401E-42)
            goto L79
        L78:
            r4 = 0
        L79:
            java.lang.CharSequence r5 = a2.p.n(r9)
            if (r5 == 0) goto L86
            java.lang.String r5 = r5.toString()
            r1.setDescription(r5)
        L86:
            android.net.Uri r5 = a2.p.i(r9)
            if (r5 == 0) goto L8f
            r1.setIconUri(r5)
        L8f:
            android.os.Bundle r9 = a2.d.d(r9)
            if (r9 == 0) goto Ld6
            java.lang.String r5 = "androidx.mediarouter.media.KEY_EXTRAS"
            boolean r6 = r9.containsKey(r5)
            if (r6 == 0) goto Ld6
            java.lang.String r6 = "androidx.mediarouter.media.KEY_DEVICE_TYPE"
            boolean r7 = r9.containsKey(r6)
            if (r7 == 0) goto Ld6
            java.lang.String r7 = "androidx.mediarouter.media.KEY_CONTROL_FILTERS"
            boolean r8 = r9.containsKey(r7)
            if (r8 != 0) goto Lae
            goto Ld6
        Lae:
            android.os.Bundle r0 = r9.getBundle(r5)
            r1.setExtras(r0)
            if (r4 == 0) goto Lb8
            goto Lbc
        Lb8:
            int r4 = r9.getInt(r6, r3)
        Lbc:
            r1.setDeviceType(r4)
            java.lang.String r0 = "androidx.mediarouter.media.KEY_PLAYBACK_TYPE"
            int r0 = r9.getInt(r0, r2)
            r1.setPlaybackType(r0)
            java.util.ArrayList r9 = r9.getParcelableArrayList(r7)
            if (r9 == 0) goto Ld1
            r1.addControlFilters(r9)
        Ld1:
            a2.g r9 = r1.build()
            return r9
        Ld6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.q.toMediaRouteDescriptor(android.media.MediaRoute2Info):a2.g");
    }
}
