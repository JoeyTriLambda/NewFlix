package cz.msebera.android.httpclient.impl.client.cache;

import ac.c;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class WarningValue {
    private static final String ASCTIME_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}";
    private static final String DATE1 = "\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}";
    private static final String DATE2 = "\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}";
    private static final String DATE3 = "(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d";
    private static final String DOMAINLABEL = "\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String HOST = "((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+)";
    private static final String HOSTNAME = "(\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?";
    private static final String HTTP_DATE = "((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4})";
    private static final String IPV4ADDRESS = "\\d+\\.\\d+\\.\\d+\\.\\d+";
    private static final String MONTH = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec";
    private static final String PORT = "\\d*";
    private static final String RFC1123_DATE = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String RFC850_DATE = "(Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT";
    private static final String TIME = "\\d{2}:\\d{2}:\\d{2}";
    private static final String TOPLABEL = "\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?";
    private static final String WEEKDAY = "Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday";
    private static final String WKDAY = "Mon|Tue|Wed|Thu|Fri|Sat|Sun";
    private int init_offs;
    private int offs;
    private final String src;
    private String warnAgent;
    private int warnCode;
    private Date warnDate;
    private String warnText;
    private static final String HOSTPORT = "(((\\p{Alnum}([\\p{Alnum}-]*\\p{Alnum})?\\.)*\\p{Alpha}([\\p{Alnum}-]*\\p{Alnum})?\\.?)|(\\d+\\.\\d+\\.\\d+\\.\\d+))(\\:\\d*)?";
    private static final Pattern HOSTPORT_PATTERN = Pattern.compile(HOSTPORT);
    private static final String WARN_DATE = "\"(((Mon|Tue|Wed|Thu|Fri|Sat|Sun), (\\d{2} (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) \\d{4}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Monday|Tuesday|Wednesday|Thursday|Friday|Saturday|Sunday), (\\d{2}-(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec)-\\d{2}) (\\d{2}:\\d{2}:\\d{2}) GMT)|((Mon|Tue|Wed|Thu|Fri|Sat|Sun) ((Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec) ( |\\d)\\d) (\\d{2}:\\d{2}:\\d{2}) \\d{4}))\"";
    private static final Pattern WARN_DATE_PATTERN = Pattern.compile(WARN_DATE);

    public WarningValue(String str) {
        this(str, 0);
    }

    public static WarningValue[] getWarningValues(Header header) {
        ArrayList arrayList = new ArrayList();
        String value = header.getValue();
        int i10 = 0;
        while (i10 < value.length()) {
            try {
                WarningValue warningValue = new WarningValue(value, i10);
                arrayList.add(warningValue);
                i10 = warningValue.offs;
            } catch (IllegalArgumentException unused) {
                int iIndexOf = value.indexOf(44, i10);
                if (iIndexOf == -1) {
                    break;
                }
                i10 = iIndexOf + 1;
            }
        }
        return (WarningValue[]) arrayList.toArray(new WarningValue[0]);
    }

    private boolean isChar(char c10) {
        return c10 >= 0 && c10 <= 127;
    }

    private boolean isControl(char c10) {
        return c10 == 127 || (c10 >= 0 && c10 <= 31);
    }

    private boolean isSeparator(char c10) {
        return c10 == '(' || c10 == ')' || c10 == '<' || c10 == '>' || c10 == '@' || c10 == ',' || c10 == ';' || c10 == ':' || c10 == '\\' || c10 == '\"' || c10 == '/' || c10 == '[' || c10 == ']' || c10 == '?' || c10 == '=' || c10 == '{' || c10 == '}' || c10 == ' ' || c10 == '\t';
    }

    private boolean isTokenChar(char c10) {
        return (!isChar(c10) || isControl(c10) || isSeparator(c10)) ? false : true;
    }

    private void parseError() {
        throw new IllegalArgumentException(c.k("Bad warn code \"", this.src.substring(this.init_offs), "\""));
    }

    public void consumeCharacter(char c10) {
        if (this.offs + 1 > this.src.length() || c10 != this.src.charAt(this.offs)) {
            parseError();
        }
        this.offs++;
    }

    public void consumeHostPort() {
        Matcher matcher = HOSTPORT_PATTERN.matcher(this.src.substring(this.offs));
        if (!matcher.find()) {
            parseError();
        }
        if (matcher.start() != 0) {
            parseError();
        }
        this.offs = matcher.end() + this.offs;
    }

    public void consumeLinearWhitespace() {
        while (this.offs < this.src.length()) {
            char cCharAt = this.src.charAt(this.offs);
            if (cCharAt != '\t') {
                if (cCharAt != '\r') {
                    if (cCharAt != ' ') {
                        return;
                    }
                } else {
                    if (this.offs + 2 >= this.src.length() || this.src.charAt(this.offs + 1) != '\n') {
                        return;
                    }
                    if (this.src.charAt(this.offs + 2) != ' ' && this.src.charAt(this.offs + 2) != '\t') {
                        return;
                    } else {
                        this.offs += 2;
                    }
                }
            }
            this.offs++;
        }
    }

    public void consumeQuotedString() {
        if (this.src.charAt(this.offs) != '\"') {
            parseError();
        }
        this.offs++;
        boolean z10 = false;
        while (this.offs < this.src.length() && !z10) {
            char cCharAt = this.src.charAt(this.offs);
            if (this.offs + 1 < this.src.length() && cCharAt == '\\' && isChar(this.src.charAt(this.offs + 1))) {
                this.offs += 2;
            } else if (cCharAt == '\"') {
                this.offs++;
                z10 = true;
            } else if (cCharAt == '\"' || isControl(cCharAt)) {
                parseError();
            } else {
                this.offs++;
            }
        }
        if (z10) {
            return;
        }
        parseError();
    }

    public void consumeToken() {
        if (!isTokenChar(this.src.charAt(this.offs))) {
            parseError();
        }
        while (this.offs < this.src.length() && isTokenChar(this.src.charAt(this.offs))) {
            this.offs++;
        }
    }

    public void consumeWarnAgent() {
        int i10 = this.offs;
        try {
            consumeHostPort();
            this.warnAgent = this.src.substring(i10, this.offs);
            consumeCharacter(TokenParser.SP);
        } catch (IllegalArgumentException unused) {
            this.offs = i10;
            consumeToken();
            this.warnAgent = this.src.substring(i10, this.offs);
            consumeCharacter(TokenParser.SP);
        }
    }

    public void consumeWarnCode() {
        if (this.offs + 4 > this.src.length() || !Character.isDigit(this.src.charAt(this.offs)) || !Character.isDigit(this.src.charAt(this.offs + 1)) || !Character.isDigit(this.src.charAt(this.offs + 2)) || this.src.charAt(this.offs + 3) != ' ') {
            parseError();
        }
        String str = this.src;
        int i10 = this.offs;
        this.warnCode = Integer.parseInt(str.substring(i10, i10 + 3));
        this.offs += 4;
    }

    public void consumeWarnDate() {
        int i10 = this.offs;
        Matcher matcher = WARN_DATE_PATTERN.matcher(this.src.substring(i10));
        if (!matcher.lookingAt()) {
            parseError();
        }
        int iEnd = matcher.end() + this.offs;
        this.offs = iEnd;
        this.warnDate = DateUtils.parseDate(this.src.substring(i10 + 1, iEnd - 1));
    }

    public void consumeWarnText() {
        int i10 = this.offs;
        consumeQuotedString();
        this.warnText = this.src.substring(i10, this.offs);
    }

    public void consumeWarnValue() {
        consumeLinearWhitespace();
        consumeWarnCode();
        consumeWarnAgent();
        consumeWarnText();
        if (this.offs + 1 < this.src.length() && this.src.charAt(this.offs) == ' ' && this.src.charAt(this.offs + 1) == '\"') {
            consumeCharacter(TokenParser.SP);
            consumeWarnDate();
        }
        consumeLinearWhitespace();
        if (this.offs != this.src.length()) {
            consumeCharacter(',');
        }
    }

    public String getWarnAgent() {
        return this.warnAgent;
    }

    public int getWarnCode() {
        return this.warnCode;
    }

    public Date getWarnDate() {
        return this.warnDate;
    }

    public String getWarnText() {
        return this.warnText;
    }

    public String toString() {
        return this.warnDate != null ? String.format("%d %s %s \"%s\"", Integer.valueOf(this.warnCode), this.warnAgent, this.warnText, DateUtils.formatDate(this.warnDate)) : String.format("%d %s %s", Integer.valueOf(this.warnCode), this.warnAgent, this.warnText);
    }

    public WarningValue(String str, int i10) {
        this.init_offs = i10;
        this.offs = i10;
        this.src = str;
        consumeWarnValue();
    }
}
