package ig;

import java.util.regex.Matcher;
import kotlin.text.MatcherMatchResult;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final f access$findNext(Matcher matcher, int i10, CharSequence charSequence) {
        if (matcher.find(i10)) {
            return new MatcherMatchResult(matcher, charSequence);
        }
        return null;
    }
}
