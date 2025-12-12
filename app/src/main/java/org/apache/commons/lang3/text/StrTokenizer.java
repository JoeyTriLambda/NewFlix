package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: classes2.dex */
public class StrTokenizer implements ListIterator<String>, Cloneable {
    private static final StrTokenizer CSV_TOKENIZER_PROTOTYPE;
    private static final StrTokenizer TSV_TOKENIZER_PROTOTYPE;
    private char[] chars;
    private StrMatcher delimMatcher;
    private boolean emptyAsNull;
    private boolean ignoreEmptyTokens;
    private StrMatcher ignoredMatcher;
    private StrMatcher quoteMatcher;
    private int tokenPos;
    private String[] tokens;
    private StrMatcher trimmerMatcher;

    static {
        StrTokenizer strTokenizer = new StrTokenizer();
        CSV_TOKENIZER_PROTOTYPE = strTokenizer;
        strTokenizer.setDelimiterMatcher(StrMatcher.commaMatcher());
        strTokenizer.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer.setEmptyTokenAsNull(false);
        strTokenizer.setIgnoreEmptyTokens(false);
        StrTokenizer strTokenizer2 = new StrTokenizer();
        TSV_TOKENIZER_PROTOTYPE = strTokenizer2;
        strTokenizer2.setDelimiterMatcher(StrMatcher.tabMatcher());
        strTokenizer2.setQuoteMatcher(StrMatcher.doubleQuoteMatcher());
        strTokenizer2.setIgnoredMatcher(StrMatcher.noneMatcher());
        strTokenizer2.setTrimmerMatcher(StrMatcher.trimMatcher());
        strTokenizer2.setEmptyTokenAsNull(false);
        strTokenizer2.setIgnoreEmptyTokens(false);
    }

    public StrTokenizer() {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = null;
    }

    private void addToken(List<String> list, String str) {
        if (StringUtils.isEmpty(str)) {
            if (isIgnoreEmptyTokens()) {
                return;
            }
            if (isEmptyTokenAsNull()) {
                str = null;
            }
        }
        list.add(str);
    }

    private void checkTokenized() {
        if (this.tokens == null) {
            char[] cArr = this.chars;
            if (cArr == null) {
                List<String> list = tokenize(null, 0, 0);
                this.tokens = (String[]) list.toArray(new String[list.size()]);
            } else {
                List<String> list2 = tokenize(cArr, 0, cArr.length);
                this.tokens = (String[]) list2.toArray(new String[list2.size()]);
            }
        }
    }

    private static StrTokenizer getCSVClone() {
        return (StrTokenizer) CSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getCSVInstance() {
        return getCSVClone();
    }

    private static StrTokenizer getTSVClone() {
        return (StrTokenizer) TSV_TOKENIZER_PROTOTYPE.clone();
    }

    public static StrTokenizer getTSVInstance() {
        return getTSVClone();
    }

    private boolean isQuote(char[] cArr, int i10, int i11, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = i10 + i14;
            if (i15 >= i11 || cArr[i15] != cArr[i12 + i14]) {
                return false;
            }
        }
        return true;
    }

    private int readNextToken(char[] cArr, int i10, int i11, StrBuilder strBuilder, List<String> list) {
        while (i10 < i11) {
            int iMax = Math.max(getIgnoredMatcher().isMatch(cArr, i10, i10, i11), getTrimmerMatcher().isMatch(cArr, i10, i10, i11));
            if (iMax == 0 || getDelimiterMatcher().isMatch(cArr, i10, i10, i11) > 0 || getQuoteMatcher().isMatch(cArr, i10, i10, i11) > 0) {
                break;
            }
            i10 += iMax;
        }
        if (i10 >= i11) {
            addToken(list, "");
            return -1;
        }
        int iIsMatch = getDelimiterMatcher().isMatch(cArr, i10, i10, i11);
        if (iIsMatch > 0) {
            addToken(list, "");
            return i10 + iIsMatch;
        }
        int iIsMatch2 = getQuoteMatcher().isMatch(cArr, i10, i10, i11);
        return iIsMatch2 > 0 ? readWithQuotes(cArr, i10 + iIsMatch2, i11, strBuilder, list, i10, iIsMatch2) : readWithQuotes(cArr, i10, i11, strBuilder, list, 0, 0);
    }

    private int readWithQuotes(char[] cArr, int i10, int i11, StrBuilder strBuilder, List<String> list, int i12, int i13) {
        strBuilder.clear();
        boolean z10 = i13 > 0;
        int i14 = i10;
        int size = 0;
        while (i14 < i11) {
            if (z10) {
                int i15 = size;
                int i16 = i14;
                if (isQuote(cArr, i14, i11, i12, i13)) {
                    int i17 = i16 + i13;
                    if (isQuote(cArr, i17, i11, i12, i13)) {
                        strBuilder.append(cArr, i16, i13);
                        i14 = (i13 * 2) + i16;
                        size = strBuilder.size();
                    } else {
                        size = i15;
                        i14 = i17;
                        z10 = false;
                    }
                } else {
                    i14 = i16 + 1;
                    strBuilder.append(cArr[i16]);
                    size = strBuilder.size();
                }
            } else {
                int i18 = size;
                int i19 = i14;
                int iIsMatch = getDelimiterMatcher().isMatch(cArr, i19, i10, i11);
                if (iIsMatch > 0) {
                    addToken(list, strBuilder.substring(0, i18));
                    return i19 + iIsMatch;
                }
                if (i13 <= 0 || !isQuote(cArr, i19, i11, i12, i13)) {
                    int iIsMatch2 = getIgnoredMatcher().isMatch(cArr, i19, i10, i11);
                    if (iIsMatch2 <= 0) {
                        iIsMatch2 = getTrimmerMatcher().isMatch(cArr, i19, i10, i11);
                        if (iIsMatch2 > 0) {
                            strBuilder.append(cArr, i19, iIsMatch2);
                        } else {
                            i14 = i19 + 1;
                            strBuilder.append(cArr[i19]);
                            size = strBuilder.size();
                        }
                    }
                    i14 = i19 + iIsMatch2;
                    size = i18;
                } else {
                    i14 = i19 + i13;
                    size = i18;
                    z10 = true;
                }
            }
        }
        addToken(list, strBuilder.substring(0, size));
        return -1;
    }

    public Object clone() {
        try {
            return cloneReset();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Object cloneReset() throws CloneNotSupportedException {
        StrTokenizer strTokenizer = (StrTokenizer) super.clone();
        char[] cArr = strTokenizer.chars;
        if (cArr != null) {
            strTokenizer.chars = (char[]) cArr.clone();
        }
        strTokenizer.reset();
        return strTokenizer;
    }

    public String getContent() {
        char[] cArr = this.chars;
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public StrMatcher getDelimiterMatcher() {
        return this.delimMatcher;
    }

    public StrMatcher getIgnoredMatcher() {
        return this.ignoredMatcher;
    }

    public StrMatcher getQuoteMatcher() {
        return this.quoteMatcher;
    }

    public String[] getTokenArray() {
        checkTokenized();
        return (String[]) this.tokens.clone();
    }

    public List<String> getTokenList() {
        checkTokenized();
        ArrayList arrayList = new ArrayList(this.tokens.length);
        arrayList.addAll(Arrays.asList(this.tokens));
        return arrayList;
    }

    public StrMatcher getTrimmerMatcher() {
        return this.trimmerMatcher;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        checkTokenized();
        return this.tokenPos < this.tokens.length;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        checkTokenized();
        return this.tokenPos > 0;
    }

    public boolean isEmptyTokenAsNull() {
        return this.emptyAsNull;
    }

    public boolean isIgnoreEmptyTokens() {
        return this.ignoreEmptyTokens;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.tokenPos;
    }

    public String nextToken() {
        if (!hasNext()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i10 = this.tokenPos;
        this.tokenPos = i10 + 1;
        return strArr[i10];
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.tokenPos - 1;
    }

    public String previousToken() {
        if (!hasPrevious()) {
            return null;
        }
        String[] strArr = this.tokens;
        int i10 = this.tokenPos - 1;
        this.tokenPos = i10;
        return strArr[i10];
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is unsupported");
    }

    public StrTokenizer reset() {
        this.tokenPos = 0;
        this.tokens = null;
        return this;
    }

    public StrTokenizer setDelimiterChar(char c10) {
        return setDelimiterMatcher(StrMatcher.charMatcher(c10));
    }

    public StrTokenizer setDelimiterMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            this.delimMatcher = StrMatcher.noneMatcher();
        } else {
            this.delimMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setDelimiterString(String str) {
        return setDelimiterMatcher(StrMatcher.stringMatcher(str));
    }

    public StrTokenizer setEmptyTokenAsNull(boolean z10) {
        this.emptyAsNull = z10;
        return this;
    }

    public StrTokenizer setIgnoreEmptyTokens(boolean z10) {
        this.ignoreEmptyTokens = z10;
        return this;
    }

    public StrTokenizer setIgnoredChar(char c10) {
        return setIgnoredMatcher(StrMatcher.charMatcher(c10));
    }

    public StrTokenizer setIgnoredMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.ignoredMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setQuoteChar(char c10) {
        return setQuoteMatcher(StrMatcher.charMatcher(c10));
    }

    public StrTokenizer setQuoteMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.quoteMatcher = strMatcher;
        }
        return this;
    }

    public StrTokenizer setTrimmerMatcher(StrMatcher strMatcher) {
        if (strMatcher != null) {
            this.trimmerMatcher = strMatcher;
        }
        return this;
    }

    public int size() {
        checkTokenized();
        return this.tokens.length;
    }

    public String toString() {
        if (this.tokens == null) {
            return "StrTokenizer[not tokenized yet]";
        }
        return "StrTokenizer" + getTokenList();
    }

    public List<String> tokenize(char[] cArr, int i10, int i11) {
        if (cArr == null || i11 == 0) {
            return Collections.emptyList();
        }
        StrBuilder strBuilder = new StrBuilder();
        ArrayList arrayList = new ArrayList();
        int nextToken = i10;
        while (nextToken >= 0 && nextToken < i11) {
            nextToken = readNextToken(cArr, nextToken, i11, strBuilder, arrayList);
            if (nextToken >= i11) {
                addToken(arrayList, "");
            }
        }
        return arrayList;
    }

    public static StrTokenizer getCSVInstance(String str) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(str);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(String str) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(str);
        return tSVClone;
    }

    @Override // java.util.ListIterator
    public void add(String str) {
        throw new UnsupportedOperationException("add() is unsupported");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.tokens;
        int i10 = this.tokenPos;
        this.tokenPos = i10 + 1;
        return strArr[i10];
    }

    @Override // java.util.ListIterator
    public String previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        String[] strArr = this.tokens;
        int i10 = this.tokenPos - 1;
        this.tokenPos = i10;
        return strArr[i10];
    }

    @Override // java.util.ListIterator
    public void set(String str) {
        throw new UnsupportedOperationException("set() is unsupported");
    }

    public StrTokenizer reset(String str) {
        reset();
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
        return this;
    }

    public static StrTokenizer getCSVInstance(char[] cArr) {
        StrTokenizer cSVClone = getCSVClone();
        cSVClone.reset(cArr);
        return cSVClone;
    }

    public static StrTokenizer getTSVInstance(char[] cArr) {
        StrTokenizer tSVClone = getTSVClone();
        tSVClone.reset(cArr);
        return tSVClone;
    }

    public StrTokenizer reset(char[] cArr) {
        reset();
        this.chars = ArrayUtils.clone(cArr);
        return this;
    }

    public StrTokenizer(String str) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        if (str != null) {
            this.chars = str.toCharArray();
        } else {
            this.chars = null;
        }
    }

    public StrTokenizer(String str, char c10) {
        this(str);
        setDelimiterChar(c10);
    }

    public StrTokenizer(String str, String str2) {
        this(str);
        setDelimiterString(str2);
    }

    public StrTokenizer(String str, StrMatcher strMatcher) {
        this(str);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(String str, char c10, char c11) {
        this(str, c10);
        setQuoteChar(c11);
    }

    public StrTokenizer(String str, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(str, strMatcher);
        setQuoteMatcher(strMatcher2);
    }

    public StrTokenizer(char[] cArr) {
        this.delimMatcher = StrMatcher.splitMatcher();
        this.quoteMatcher = StrMatcher.noneMatcher();
        this.ignoredMatcher = StrMatcher.noneMatcher();
        this.trimmerMatcher = StrMatcher.noneMatcher();
        this.emptyAsNull = false;
        this.ignoreEmptyTokens = true;
        this.chars = ArrayUtils.clone(cArr);
    }

    public StrTokenizer(char[] cArr, char c10) {
        this(cArr);
        setDelimiterChar(c10);
    }

    public StrTokenizer(char[] cArr, String str) {
        this(cArr);
        setDelimiterString(str);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher) {
        this(cArr);
        setDelimiterMatcher(strMatcher);
    }

    public StrTokenizer(char[] cArr, char c10, char c11) {
        this(cArr, c10);
        setQuoteChar(c11);
    }

    public StrTokenizer(char[] cArr, StrMatcher strMatcher, StrMatcher strMatcher2) {
        this(cArr, strMatcher);
        setQuoteMatcher(strMatcher2);
    }
}
