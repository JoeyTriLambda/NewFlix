package fd;

import com.comcast.viper.hlsparserj.PlaylistFactory;
import com.comcast.viper.hlsparserj.PlaylistVersion;
import com.comcast.viper.hlsparserj.tags.UnparsedTag;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* compiled from: TVHelper.java */
/* loaded from: classes2.dex */
public final class i {
    public static ArrayList<hd.d> parseChannels(String str) {
        ArrayList arrayList;
        String strTrim;
        String uri;
        String strTrim2;
        ArrayList<hd.d> arrayList2 = new ArrayList<>();
        try {
            arrayList = (ArrayList) PlaylistFactory.parsePlaylist(PlaylistVersion.TWELVE, str).getTags();
            arrayList2 = parseExtended(arrayList);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (arrayList2.size() > 0) {
            return arrayList2;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            UnparsedTag unparsedTag = (UnparsedTag) it.next();
            hd.d dVar = new hd.d();
            String[] strArrSplit = unparsedTag.getRawTag().split(",");
            try {
                strTrim = strArrSplit[strArrSplit.length - 1].trim();
                try {
                    String strTrim3 = strArrSplit.length > 1 ? strArrSplit[strArrSplit.length - 2].trim() : "";
                    if (strTrim3.contains("tvg-logo")) {
                        try {
                            strTrim2 = strTrim3.split("tvg-logo=")[1].split(StringUtils.SPACE)[0].replace("\"", "").trim();
                        } catch (Exception e11) {
                            e11.printStackTrace();
                            strTrim2 = "";
                        }
                        if (strTrim2 != null) {
                            dVar.f12985r = strTrim2;
                        } else {
                            dVar.f12985r = "";
                        }
                    }
                    if (strTrim3.contains("group-title=")) {
                        String strTrim4 = strTrim3.split("group-title=")[1].replace("\"", "").trim();
                        if (strTrim4 != null) {
                            dVar.f12987t = strTrim4;
                        }
                    } else {
                        dVar.f12987t = "UNGROUPED";
                    }
                } catch (Exception e12) {
                    e = e12;
                    e.printStackTrace();
                    if (!strTrim.toLowerCase().contains("label")) {
                        dVar.f12984q = strTrim.toUpperCase();
                        uri = unparsedTag.getURI();
                        dVar.f12983p = uri;
                        if (uri != null) {
                        }
                        arrayList2.add(dVar);
                    }
                }
            } catch (Exception e13) {
                e = e13;
                strTrim = "";
            }
            if (!strTrim.toLowerCase().contains("label") && !strTrim.toLowerCase().contains("[off]")) {
                dVar.f12984q = strTrim.toUpperCase();
                uri = unparsedTag.getURI();
                dVar.f12983p = uri;
                if (uri != null || !uri.contains("autoiptv.")) {
                    arrayList2.add(dVar);
                }
            }
        }
        return arrayList2;
    }

    public static ArrayList<hd.d> parseExtended(ArrayList<UnparsedTag> arrayList) {
        ArrayList<hd.d> arrayList2 = new ArrayList<>();
        Iterator<UnparsedTag> it = arrayList.iterator();
        while (it.hasNext()) {
            UnparsedTag next = it.next();
            hd.d dVar = new hd.d();
            String uri = next.getURI();
            if (uri != null && uri.length() > 0) {
                dVar.f12983p = uri;
                String str = null;
                String str2 = "";
                String str3 = null;
                for (String str4 : next.getRawTag().split("\" ")) {
                    String[] strArrSplit = str4.split("=\"");
                    if (strArrSplit.length > 1) {
                        String str5 = strArrSplit[0];
                        String str6 = strArrSplit[1];
                        if (str6.contains("\"")) {
                            str6 = str6.split("\"")[0];
                        }
                        if (str5.toLowerCase().contains("tvg-name")) {
                            str = str6;
                        }
                        if (str5.toLowerCase().contains("tvg-logo")) {
                            str2 = str6;
                        }
                        if (str5.toLowerCase().contains("group-title")) {
                            str3 = str6;
                        }
                        if (str3 == null || str3.isEmpty()) {
                            str3 = "UNGROUPED";
                        }
                    }
                }
                if (str != null) {
                    dVar.f12984q = str;
                    dVar.f12987t = str3.toUpperCase();
                    dVar.f12983p = uri;
                    dVar.f12985r = str2;
                    arrayList2.add(dVar);
                }
            }
        }
        return arrayList2;
    }
}
