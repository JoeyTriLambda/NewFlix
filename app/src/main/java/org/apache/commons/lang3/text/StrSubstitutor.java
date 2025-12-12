package org.apache.commons.lang3.text;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.StringUtils;

@Deprecated
/* loaded from: classes2.dex */
public class StrSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    public static final StrMatcher DEFAULT_PREFIX = StrMatcher.stringMatcher("${");
    public static final StrMatcher DEFAULT_SUFFIX = StrMatcher.stringMatcher("}");
    public static final StrMatcher DEFAULT_VALUE_DELIMITER = StrMatcher.stringMatcher(":-");
    private boolean enableSubstitutionInVariables;
    private char escapeChar;
    private StrMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StrMatcher suffixMatcher;
    private StrMatcher valueDelimiterMatcher;
    private StrLookup<?> variableResolver;

    public StrSubstitutor() {
        this((StrLookup<?>) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            StrBuilder strBuilder = new StrBuilder(256);
            strBuilder.append("Infinite loop in property interpolation of ");
            strBuilder.append(list.remove(0));
            strBuilder.append(": ");
            strBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(strBuilder.toString());
        }
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StrSubstitutor(map).replace(obj);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StrSubstitutor(StrLookup.systemPropertiesLookup()).replace(obj);
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StrMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StrMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StrLookup<?> getVariableResolver() {
        return this.variableResolver;
    }

    public StrMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public String resolveVariable(String str, StrBuilder strBuilder, int i10, int i11) {
        StrLookup<?> variableResolver = getVariableResolver();
        if (variableResolver == null) {
            return null;
        }
        return variableResolver.lookup(str);
    }

    public void setEnableSubstitutionInVariables(boolean z10) {
        this.enableSubstitutionInVariables = z10;
    }

    public void setEscapeChar(char c10) {
        this.escapeChar = c10;
    }

    public void setPreserveEscapes(boolean z10) {
        this.preserveEscapes = z10;
    }

    public StrSubstitutor setValueDelimiter(char c10) {
        return setValueDelimiterMatcher(StrMatcher.charMatcher(c10));
    }

    public StrSubstitutor setValueDelimiterMatcher(StrMatcher strMatcher) {
        this.valueDelimiterMatcher = strMatcher;
        return this;
    }

    public StrSubstitutor setVariablePrefix(char c10) {
        return setVariablePrefixMatcher(StrMatcher.charMatcher(c10));
    }

    public StrSubstitutor setVariablePrefixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException("Variable prefix matcher must not be null!");
        }
        this.prefixMatcher = strMatcher;
        return this;
    }

    public void setVariableResolver(StrLookup<?> strLookup) {
        this.variableResolver = strLookup;
    }

    public StrSubstitutor setVariableSuffix(char c10) {
        return setVariableSuffixMatcher(StrMatcher.charMatcher(c10));
    }

    public StrSubstitutor setVariableSuffixMatcher(StrMatcher strMatcher) {
        if (strMatcher == null) {
            throw new IllegalArgumentException("Variable suffix matcher must not be null!");
        }
        this.suffixMatcher = strMatcher;
        return this;
    }

    public boolean substitute(StrBuilder strBuilder, int i10, int i11) {
        return substitute(strBuilder, i10, i11, null) > 0;
    }

    public <V> StrSubstitutor(Map<String, V> map) {
        this((StrLookup<?>) StrLookup.mapLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StrSubstitutor(map, str, str2).replace(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r12v7 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [org.apache.commons.lang3.text.StrSubstitutor] */
    private int substitute(StrBuilder strBuilder, int i10, int i11, List<String> list) {
        StrMatcher strMatcher;
        StrMatcher strMatcher2;
        char c10;
        boolean z10;
        String strSubstring;
        int iIsMatch;
        StrMatcher variablePrefixMatcher = getVariablePrefixMatcher();
        StrMatcher variableSuffixMatcher = getVariableSuffixMatcher();
        char escapeChar = getEscapeChar();
        StrMatcher valueDelimiterMatcher = getValueDelimiterMatcher();
        boolean zIsEnableSubstitutionInVariables = isEnableSubstitutionInVariables();
        boolean z11 = list == null;
        int i12 = i10;
        int i13 = i10 + i11;
        int i14 = 0;
        int i15 = 0;
        char[] cArr = strBuilder.buffer;
        ?? arrayList = list;
        while (i12 < i13) {
            int iIsMatch2 = variablePrefixMatcher.isMatch(cArr, i12, i10, i13);
            if (iIsMatch2 != 0) {
                if (i12 > i10) {
                    int i16 = i12 - 1;
                    if (cArr[i16] == escapeChar) {
                        if (this.preserveEscapes) {
                            i12++;
                        } else {
                            strBuilder.deleteCharAt(i16);
                            i14--;
                            i13--;
                            strMatcher = variablePrefixMatcher;
                            strMatcher2 = variableSuffixMatcher;
                            c10 = escapeChar;
                            cArr = strBuilder.buffer;
                            z10 = z11;
                            i15 = 1;
                            arrayList = arrayList;
                        }
                    }
                }
                int i17 = i12 + iIsMatch2;
                int i18 = i17;
                int i19 = 0;
                while (true) {
                    if (i18 >= i13) {
                        strMatcher = variablePrefixMatcher;
                        strMatcher2 = variableSuffixMatcher;
                        c10 = escapeChar;
                        z10 = z11;
                        i12 = i18;
                        arrayList = arrayList;
                        break;
                    }
                    if (!zIsEnableSubstitutionInVariables || (iIsMatch = variablePrefixMatcher.isMatch(cArr, i18, i10, i13)) == 0) {
                        int iIsMatch3 = variableSuffixMatcher.isMatch(cArr, i18, i10, i13);
                        if (iIsMatch3 == 0) {
                            i18++;
                        } else if (i19 == 0) {
                            strMatcher2 = variableSuffixMatcher;
                            c10 = escapeChar;
                            String str = new String(cArr, i17, (i18 - i12) - iIsMatch2);
                            if (zIsEnableSubstitutionInVariables) {
                                StrBuilder strBuilder2 = new StrBuilder(str);
                                substitute(strBuilder2, 0, strBuilder2.length());
                                str = strBuilder2.toString();
                            }
                            int i20 = i18 + iIsMatch3;
                            if (valueDelimiterMatcher != null) {
                                char[] charArray = str.toCharArray();
                                z10 = z11;
                                int i21 = 0;
                                while (i21 < charArray.length && (zIsEnableSubstitutionInVariables || variablePrefixMatcher.isMatch(charArray, i21, i21, charArray.length) == 0)) {
                                    int iIsMatch4 = valueDelimiterMatcher.isMatch(charArray, i21);
                                    if (iIsMatch4 != 0) {
                                        strMatcher = variablePrefixMatcher;
                                        String strSubstring2 = str.substring(0, i21);
                                        strSubstring = str.substring(i21 + iIsMatch4);
                                        str = strSubstring2;
                                        break;
                                    }
                                    i21++;
                                    variablePrefixMatcher = variablePrefixMatcher;
                                }
                                strMatcher = variablePrefixMatcher;
                            } else {
                                strMatcher = variablePrefixMatcher;
                                z10 = z11;
                            }
                            strSubstring = null;
                            if (arrayList == 0) {
                                arrayList = new ArrayList();
                                arrayList.add(new String(cArr, i10, i11));
                            }
                            checkCyclicSubstitution(str, arrayList);
                            arrayList.add(str);
                            String strResolveVariable = resolveVariable(str, strBuilder, i12, i20);
                            if (strResolveVariable != null) {
                                strSubstring = strResolveVariable;
                            }
                            if (strSubstring != null) {
                                int length = strSubstring.length();
                                strBuilder.replace(i12, i20, strSubstring);
                                int iSubstitute = (substitute(strBuilder, i12, length, arrayList) + length) - (i20 - i12);
                                i13 += iSubstitute;
                                i14 += iSubstitute;
                                cArr = strBuilder.buffer;
                                i12 = i20 + iSubstitute;
                                i15 = 1;
                            } else {
                                i12 = i20;
                            }
                            arrayList.remove(arrayList.size() - 1);
                            arrayList = arrayList;
                        } else {
                            i19--;
                            i18 += iIsMatch3;
                            escapeChar = escapeChar;
                            variablePrefixMatcher = variablePrefixMatcher;
                        }
                    } else {
                        i19++;
                        i18 += iIsMatch;
                    }
                }
            } else {
                i12++;
                strMatcher = variablePrefixMatcher;
                strMatcher2 = variableSuffixMatcher;
                c10 = escapeChar;
                z10 = z11;
                arrayList = arrayList;
            }
            variableSuffixMatcher = strMatcher2;
            escapeChar = c10;
            z11 = z10;
            variablePrefixMatcher = strMatcher;
        }
        return z11 ? i15 : i14;
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i10, int i11) {
        if (stringBuffer == null) {
            return false;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(stringBuffer, i10, i11);
        if (!substitute(strBuilderAppend, 0, i11)) {
            return false;
        }
        stringBuffer.replace(i10, i11 + i10, strBuilderAppend.toString());
        return true;
    }

    public StrSubstitutor setValueDelimiter(String str) {
        if (!StringUtils.isEmpty(str)) {
            return setValueDelimiterMatcher(StrMatcher.stringMatcher(str));
        }
        setValueDelimiterMatcher(null);
        return this;
    }

    public StrSubstitutor setVariablePrefix(String str) {
        if (str != null) {
            return setVariablePrefixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable prefix must not be null!");
    }

    public StrSubstitutor setVariableSuffix(String str) {
        if (str != null) {
            return setVariableSuffixMatcher(StrMatcher.stringMatcher(str));
        }
        throw new IllegalArgumentException("Variable suffix must not be null!");
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, '$');
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap map = new HashMap();
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String str = (String) enumerationPropertyNames.nextElement();
            map.put(str, properties.getProperty(str));
        }
        return replace(obj, map);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c10) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c10);
    }

    public <V> StrSubstitutor(Map<String, V> map, String str, String str2, char c10, String str3) {
        this((StrLookup<?>) StrLookup.mapLookup(map), str, str2, c10, str3);
    }

    public boolean replaceIn(StringBuilder sb2) {
        if (sb2 == null) {
            return false;
        }
        return replaceIn(sb2, 0, sb2.length());
    }

    public StrSubstitutor(StrLookup<?> strLookup) {
        this(strLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public boolean replaceIn(StringBuilder sb2, int i10, int i11) {
        if (sb2 == null) {
            return false;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(sb2, i10, i11);
        if (!substitute(strBuilderAppend, 0, i11)) {
            return false;
        }
        sb2.replace(i10, i11 + i10, strBuilderAppend.toString());
        return true;
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c10) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c10);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public boolean replaceIn(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, 0, strBuilder.length());
    }

    public boolean replaceIn(StrBuilder strBuilder, int i10, int i11) {
        if (strBuilder == null) {
            return false;
        }
        return substitute(strBuilder, i10, i11);
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilder = new StrBuilder(str);
        return !substitute(strBuilder, 0, str.length()) ? str : strBuilder.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, String str, String str2, char c10, String str3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c10);
        setValueDelimiter(str3);
    }

    public String replace(String str, int i10, int i11) {
        if (str == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(str, i10, i11);
        if (!substitute(strBuilderAppend, 0, i11)) {
            return str.substring(i10, i11 + i10);
        }
        return strBuilderAppend.toString();
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(cArr.length).append(cArr);
        substitute(strBuilderAppend, 0, cArr.length);
        return strBuilderAppend.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c10) {
        this(strLookup, strMatcher, strMatcher2, c10, DEFAULT_VALUE_DELIMITER);
    }

    public String replace(char[] cArr, int i10, int i11) {
        if (cArr == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(cArr, i10, i11);
        substitute(strBuilderAppend, 0, i11);
        return strBuilderAppend.toString();
    }

    public StrSubstitutor(StrLookup<?> strLookup, StrMatcher strMatcher, StrMatcher strMatcher2, char c10, StrMatcher strMatcher3) {
        this.preserveEscapes = false;
        setVariableResolver(strLookup);
        setVariablePrefixMatcher(strMatcher);
        setVariableSuffixMatcher(strMatcher2);
        setEscapeChar(c10);
        setValueDelimiterMatcher(strMatcher3);
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }

    public String replace(StringBuffer stringBuffer, int i10, int i11) {
        if (stringBuffer == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(stringBuffer, i10, i11);
        substitute(strBuilderAppend, 0, i11);
        return strBuilderAppend.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public String replace(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(charSequence, i10, i11);
        substitute(strBuilderAppend, 0, i11);
        return strBuilderAppend.toString();
    }

    public String replace(StrBuilder strBuilder) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(strBuilder.length()).append(strBuilder);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }

    public String replace(StrBuilder strBuilder, int i10, int i11) {
        if (strBuilder == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder(i11).append(strBuilder, i10, i11);
        substitute(strBuilderAppend, 0, i11);
        return strBuilderAppend.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        StrBuilder strBuilderAppend = new StrBuilder().append(obj);
        substitute(strBuilderAppend, 0, strBuilderAppend.length());
        return strBuilderAppend.toString();
    }
}
