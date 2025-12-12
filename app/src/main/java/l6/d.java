package l6;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f15849a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f15850b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f15851c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f15852d;

    static {
        HashMap map = new HashMap();
        f15852d = map;
        map.put("aliceblue", -984833);
        map.put("antiquewhite", -332841);
        map.put("aqua", -16711681);
        o1.a.i(-8388652, map, "aquamarine", -983041, "azure", -657956, "beige", -6972, "bisque");
        o1.a.i(-16777216, map, "black", -5171, "blanchedalmond", -16776961, "blue", -7722014, "blueviolet");
        o1.a.i(-5952982, map, "brown", -2180985, "burlywood", -10510688, "cadetblue", -8388864, "chartreuse");
        o1.a.i(-2987746, map, "chocolate", -32944, "coral", -10185235, "cornflowerblue", -1828, "cornsilk");
        map.put("crimson", -2354116);
        map.put("cyan", -16711681);
        map.put("darkblue", -16777077);
        map.put("darkcyan", -16741493);
        map.put("darkgoldenrod", -4684277);
        map.put("darkgray", -5658199);
        map.put("darkgreen", -16751616);
        map.put("darkgrey", -5658199);
        map.put("darkkhaki", -4343957);
        o1.a.i(-7667573, map, "darkmagenta", -11179217, "darkolivegreen", -29696, "darkorange", -6737204, "darkorchid");
        o1.a.i(-7667712, map, "darkred", -1468806, "darksalmon", -7357297, "darkseagreen", -12042869, "darkslateblue");
        map.put("darkslategray", -13676721);
        map.put("darkslategrey", -13676721);
        map.put("darkturquoise", -16724271);
        map.put("darkviolet", -7077677);
        map.put("deeppink", -60269);
        map.put("deepskyblue", -16728065);
        map.put("dimgray", -9868951);
        map.put("dimgrey", -9868951);
        o1.a.i(-14774017, map, "dodgerblue", -5103070, "firebrick", -1296, "floralwhite", -14513374, "forestgreen");
        map.put("fuchsia", -65281);
        map.put("gainsboro", -2302756);
        map.put("ghostwhite", -460545);
        map.put("gold", -10496);
        map.put("goldenrod", -2448096);
        map.put("gray", -8355712);
        map.put("green", -16744448);
        map.put("greenyellow", -5374161);
        map.put("grey", -8355712);
        o1.a.i(-983056, map, "honeydew", -38476, "hotpink", -3318692, "indianred", -11861886, "indigo");
        o1.a.i(-16, map, "ivory", -989556, "khaki", -1644806, "lavender", -3851, "lavenderblush");
        o1.a.i(-8586240, map, "lawngreen", -1331, "lemonchiffon", -5383962, "lightblue", -1015680, "lightcoral");
        map.put("lightcyan", -2031617);
        map.put("lightgoldenrodyellow", -329006);
        map.put("lightgray", -2894893);
        map.put("lightgreen", -7278960);
        map.put("lightgrey", -2894893);
        map.put("lightpink", -18751);
        map.put("lightsalmon", -24454);
        map.put("lightseagreen", -14634326);
        map.put("lightskyblue", -7876870);
        map.put("lightslategray", -8943463);
        map.put("lightslategrey", -8943463);
        map.put("lightsteelblue", -5192482);
        map.put("lightyellow", -32);
        map.put("lime", -16711936);
        map.put("limegreen", -13447886);
        map.put("linen", -331546);
        map.put("magenta", -65281);
        map.put("maroon", -8388608);
        map.put("mediumaquamarine", -10039894);
        o1.a.i(-16777011, map, "mediumblue", -4565549, "mediumorchid", -7114533, "mediumpurple", -12799119, "mediumseagreen");
        o1.a.i(-8689426, map, "mediumslateblue", -16713062, "mediumspringgreen", -12004916, "mediumturquoise", -3730043, "mediumvioletred");
        o1.a.i(-15132304, map, "midnightblue", -655366, "mintcream", -6943, "mistyrose", -6987, "moccasin");
        o1.a.i(-8531, map, "navajowhite", -16777088, "navy", -133658, "oldlace", -8355840, "olive");
        o1.a.i(-9728477, map, "olivedrab", -23296, "orange", -47872, "orangered", -2461482, "orchid");
        o1.a.i(-1120086, map, "palegoldenrod", -6751336, "palegreen", -5247250, "paleturquoise", -2396013, "palevioletred");
        o1.a.i(-4139, map, "papayawhip", -9543, "peachpuff", -3308225, "peru", -16181, "pink");
        o1.a.i(-2252579, map, "plum", -5185306, "powderblue", -8388480, "purple", -10079335, "rebeccapurple");
        o1.a.i(-65536, map, "red", -4419697, "rosybrown", -12490271, "royalblue", -7650029, "saddlebrown");
        o1.a.i(-360334, map, "salmon", -744352, "sandybrown", -13726889, "seagreen", -2578, "seashell");
        o1.a.i(-6270419, map, "sienna", -4144960, "silver", -7876885, "skyblue", -9807155, "slateblue");
        map.put("slategray", -9404272);
        map.put("slategrey", -9404272);
        map.put("snow", -1286);
        map.put("springgreen", -16711809);
        o1.a.i(-12156236, map, "steelblue", -2968436, "tan", -16744320, "teal", -2572328, "thistle");
        o1.a.i(-40121, map, "tomato", 0, "transparent", -12525360, "turquoise", -1146130, "violet");
        o1.a.i(-663885, map, "wheat", -1, "white", -657931, "whitesmoke", -256, "yellow");
        map.put("yellowgreen", -6632142);
    }

    public static int a(String str, boolean z10) {
        a.checkArgument(!TextUtils.isEmpty(str));
        String strReplace = str.replace(StringUtils.SPACE, "");
        if (strReplace.charAt(0) == '#') {
            int i10 = (int) Long.parseLong(strReplace.substring(1), 16);
            if (strReplace.length() == 7) {
                return i10 | (-16777216);
            }
            if (strReplace.length() == 9) {
                return ((i10 & 255) << 24) | (i10 >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (strReplace.startsWith("rgba")) {
            Matcher matcher = (z10 ? f15851c : f15850b).matcher(strReplace);
            if (matcher.matches()) {
                return Integer.parseInt(matcher.group(3), 10) | ((z10 ? (int) (Float.parseFloat(matcher.group(4)) * 255.0f) : Integer.parseInt(matcher.group(4), 10)) << 24) | (Integer.parseInt(matcher.group(1), 10) << 16) | (Integer.parseInt(matcher.group(2), 10) << 8);
            }
        } else if (strReplace.startsWith("rgb")) {
            Matcher matcher2 = f15849a.matcher(strReplace);
            if (matcher2.matches()) {
                return Integer.parseInt(matcher2.group(3), 10) | (Integer.parseInt(matcher2.group(1), 10) << 16) | (-16777216) | (Integer.parseInt(matcher2.group(2), 10) << 8);
            }
        } else {
            Integer num = (Integer) f15852d.get(u.toLowerInvariant(strReplace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public static int parseCssColor(String str) {
        return a(str, true);
    }

    public static int parseTtmlColor(String str) {
        return a(str, false);
    }
}
