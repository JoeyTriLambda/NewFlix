package i6;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import l6.l;

/* compiled from: WebvttParserUtil.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f13263a = Pattern.compile("^NOTE(( |\t).*)?$");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f13264b = Pattern.compile("^\ufeff?WEBVTT(( |\t).*)?$");

    public static Matcher findNextCueHeader(l lVar) {
        String line;
        while (true) {
            String line2 = lVar.readLine();
            if (line2 == null) {
                return null;
            }
            if (f13263a.matcher(line2).matches()) {
                do {
                    line = lVar.readLine();
                    if (line != null) {
                    }
                } while (!line.isEmpty());
            } else {
                Matcher matcher = f.f13248b.matcher(line2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }

    public static float parsePercentage(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long parseTimestampUs(String str) throws NumberFormatException {
        String[] strArrSplit = str.split("\\.", 2);
        long j10 = 0;
        for (String str2 : strArrSplit[0].split(":")) {
            j10 = (j10 * 60) + Long.parseLong(str2);
        }
        return (Long.parseLong(strArrSplit[1]) + (j10 * 1000)) * 1000;
    }

    public static void validateWebvttHeaderLine(l lVar) throws SubtitleDecoderException {
        String line = lVar.readLine();
        if (line == null || !f13264b.matcher(line).matches()) {
            throw new SubtitleDecoderException(ac.c.j("Expected WEBVTT. Got ", line));
        }
    }
}
