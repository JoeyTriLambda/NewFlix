package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.base.ParserBase;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.TextBuffer;
import com.unity3d.ads.metadata.MediationMetaData;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* loaded from: classes.dex */
public class ReaderBasedJsonParser extends ParserBase {
    protected boolean _bufferRecyclable;
    protected final int _hashSeed;
    protected char[] _inputBuffer;
    protected int _nameStartCol;
    protected long _nameStartOffset;
    protected int _nameStartRow;
    protected ObjectCodec _objectCodec;
    protected Reader _reader;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete;
    private static final int FEAT_MASK_TRAILING_COMMA = JsonParser.Feature.ALLOW_TRAILING_COMMA.getMask();
    private static final int FEAT_MASK_LEADING_ZEROS = JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS.getMask();
    private static final int FEAT_MASK_NON_NUM_NUMBERS = JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS.getMask();
    private static final int FEAT_MASK_ALLOW_MISSING = JsonParser.Feature.ALLOW_MISSING_VALUES.getMask();
    private static final int FEAT_MASK_ALLOW_SINGLE_QUOTES = JsonParser.Feature.ALLOW_SINGLE_QUOTES.getMask();
    private static final int FEAT_MASK_ALLOW_UNQUOTED_NAMES = JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES.getMask();
    private static final int FEAT_MASK_ALLOW_JAVA_COMMENTS = JsonParser.Feature.ALLOW_COMMENTS.getMask();
    private static final int FEAT_MASK_ALLOW_YAML_COMMENTS = JsonParser.Feature.ALLOW_YAML_COMMENTS.getMask();
    protected static final int[] _icLatin1 = CharTypes.getInputCodeLatin1();

    public ReaderBasedJsonParser(IOContext iOContext, int i10, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer, char[] cArr, int i11, int i12, boolean z10) {
        super(iOContext, i10);
        this._reader = reader;
        this._inputBuffer = cArr;
        this._inputPtr = i11;
        this._inputEnd = i12;
        this._objectCodec = objectCodec;
        this._symbols = charsToNameCanonicalizer;
        this._hashSeed = charsToNameCanonicalizer.hashSeed();
        this._bufferRecyclable = z10;
    }

    private final void _checkMatchEnd(String str, int i10, int i11) throws IOException {
        if (Character.isJavaIdentifierPart((char) i11)) {
            _reportInvalidToken(str.substring(0, i10));
        }
    }

    private void _closeScope(int i10) throws JsonParseException {
        if (i10 == 93) {
            _updateLocation();
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(i10, '}');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_ARRAY;
        }
        if (i10 == 125) {
            _updateLocation();
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(i10, ']');
            }
            this._parsingContext = this._parsingContext.clearAndGetParent();
            this._currToken = JsonToken.END_OBJECT;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String _handleOddName2(int r5, int r6, int[] r7) throws java.io.IOException {
        /*
            r4 = this;
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4._textBuffer
            char[] r1 = r4._inputBuffer
            int r2 = r4._inputPtr
            int r2 = r2 - r5
            r0.resetWithShared(r1, r5, r2)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.getCurrentSegment()
            com.fasterxml.jackson.core.util.TextBuffer r0 = r4._textBuffer
            int r0 = r0.getCurrentSegmentSize()
            int r1 = r7.length
        L17:
            int r2 = r4._inputPtr
            int r3 = r4._inputEnd
            if (r2 < r3) goto L24
            boolean r2 = r4._loadMore()
            if (r2 != 0) goto L24
            goto L37
        L24:
            char[] r2 = r4._inputBuffer
            int r3 = r4._inputPtr
            char r2 = r2[r3]
            if (r2 >= r1) goto L31
            r3 = r7[r2]
            if (r3 == 0) goto L51
            goto L37
        L31:
            boolean r3 = java.lang.Character.isJavaIdentifierPart(r2)
            if (r3 != 0) goto L51
        L37:
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            r5.setCurrentLength(r0)
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r7 = r5.getTextBuffer()
            int r0 = r5.getTextOffset()
            int r5 = r5.size()
            com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer r1 = r4._symbols
            java.lang.String r5 = r1.findSymbol(r7, r0, r5, r6)
            return r5
        L51:
            int r3 = r4._inputPtr
            int r3 = r3 + 1
            r4._inputPtr = r3
            int r6 = r6 * 33
            int r6 = r6 + r2
            int r3 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r3 < r0) goto L69
            com.fasterxml.jackson.core.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.finishCurrentSegment()
            r0 = 0
            goto L17
        L69:
            r0 = r3
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddName2(int, int, int[]):java.lang.String");
    }

    private final void _isNextTokenNameYes(int i10) throws IOException {
        this._currToken = JsonToken.FIELD_NAME;
        _updateLocation();
        if (i10 == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return;
        }
        if (i10 == 45) {
            this._nextToken = _parseNegNumber();
            return;
        }
        if (i10 == 91) {
            this._nextToken = JsonToken.START_ARRAY;
            return;
        }
        if (i10 == 102) {
            _matchToken("false", 1);
            this._nextToken = JsonToken.VALUE_FALSE;
            return;
        }
        if (i10 == 110) {
            _matchToken("null", 1);
            this._nextToken = JsonToken.VALUE_NULL;
            return;
        }
        if (i10 == 116) {
            _matchToken("true", 1);
            this._nextToken = JsonToken.VALUE_TRUE;
        } else {
            if (i10 == 123) {
                this._nextToken = JsonToken.START_OBJECT;
                return;
            }
            switch (i10) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    this._nextToken = _parsePosNumber(i10);
                    break;
                default:
                    this._nextToken = _handleOddValue(i10);
                    break;
            }
        }
    }

    private final void _matchFalse() throws IOException {
        int i10;
        char c10;
        int i11 = this._inputPtr;
        if (i11 + 4 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i11] == 'a') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'l') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 's') {
                        int i14 = i13 + 1;
                        if (cArr[i14] == 'e' && ((c10 = cArr[(i10 = i14 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                            this._inputPtr = i10;
                            return;
                        }
                    }
                }
            }
        }
        _matchToken("false", 1);
    }

    private final void _matchNull() throws IOException {
        int i10;
        char c10;
        int i11 = this._inputPtr;
        if (i11 + 3 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i11] == 'u') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'l') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 'l' && ((c10 = cArr[(i10 = i13 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                        this._inputPtr = i10;
                        return;
                    }
                }
            }
        }
        _matchToken("null", 1);
    }

    private final void _matchToken2(String str, int i10) throws IOException {
        int i11;
        char c10;
        int length = str.length();
        do {
            if ((this._inputPtr >= this._inputEnd && !_loadMore()) || this._inputBuffer[this._inputPtr] != str.charAt(i10)) {
                _reportInvalidToken(str.substring(0, i10));
            }
            i11 = this._inputPtr + 1;
            this._inputPtr = i11;
            i10++;
        } while (i10 < length);
        if ((i11 < this._inputEnd || _loadMore()) && (c10 = this._inputBuffer[this._inputPtr]) >= '0' && c10 != ']' && c10 != '}') {
            _checkMatchEnd(str, i10, c10);
        }
    }

    private final void _matchTrue() throws IOException {
        int i10;
        char c10;
        int i11 = this._inputPtr;
        if (i11 + 3 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            if (cArr[i11] == 'r') {
                int i12 = i11 + 1;
                if (cArr[i12] == 'u') {
                    int i13 = i12 + 1;
                    if (cArr[i13] == 'e' && ((c10 = cArr[(i10 = i13 + 1)]) < '0' || c10 == ']' || c10 == '}')) {
                        this._inputPtr = i10;
                        return;
                    }
                }
            }
        }
        _matchToken("true", 1);
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = jsonToken;
        return jsonToken;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.fasterxml.jackson.core.JsonToken _nextTokenNotInObject(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 34
            r1 = 1
            if (r4 != r0) goto Lc
            r3._tokenIncomplete = r1
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
            r3._currToken = r4
            return r4
        Lc:
            r0 = 44
            if (r4 == r0) goto L7e
            r0 = 45
            if (r4 == r0) goto L77
            r0 = 91
            if (r4 == r0) goto L66
            r0 = 93
            if (r4 == r0) goto L7e
            r0 = 102(0x66, float:1.43E-43)
            if (r4 == r0) goto L5c
            r0 = 110(0x6e, float:1.54E-43)
            if (r4 == r0) goto L52
            r0 = 116(0x74, float:1.63E-43)
            if (r4 == r0) goto L48
            r0 = 123(0x7b, float:1.72E-43)
            if (r4 == r0) goto L37
            switch(r4) {
                case 48: goto L30;
                case 49: goto L30;
                case 50: goto L30;
                case 51: goto L30;
                case 52: goto L30;
                case 53: goto L30;
                case 54: goto L30;
                case 55: goto L30;
                case 56: goto L30;
                case 57: goto L30;
                default: goto L2f;
            }
        L2f:
            goto L8f
        L30:
            com.fasterxml.jackson.core.JsonToken r4 = r3._parsePosNumber(r4)
            r3._currToken = r4
            return r4
        L37:
            com.fasterxml.jackson.core.json.JsonReadContext r4 = r3._parsingContext
            int r0 = r3._tokenInputRow
            int r1 = r3._tokenInputCol
            com.fasterxml.jackson.core.json.JsonReadContext r4 = r4.createChildObjectContext(r0, r1)
            r3._parsingContext = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            r3._currToken = r4
            return r4
        L48:
            java.lang.String r4 = "true"
            r3._matchToken(r4, r1)
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_TRUE
            r3._currToken = r4
            return r4
        L52:
            java.lang.String r4 = "null"
            r3._matchToken(r4, r1)
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            r3._currToken = r4
            return r4
        L5c:
            java.lang.String r4 = "false"
            r3._matchToken(r4, r1)
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_FALSE
            r3._currToken = r4
            return r4
        L66:
            com.fasterxml.jackson.core.json.JsonReadContext r4 = r3._parsingContext
            int r0 = r3._tokenInputRow
            int r1 = r3._tokenInputCol
            com.fasterxml.jackson.core.json.JsonReadContext r4 = r4.createChildArrayContext(r0, r1)
            r3._parsingContext = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            r3._currToken = r4
            return r4
        L77:
            com.fasterxml.jackson.core.JsonToken r4 = r3._parseNegNumber()
            r3._currToken = r4
            return r4
        L7e:
            int r0 = r3._features
            int r2 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r2
            if (r0 == 0) goto L8f
            int r4 = r3._inputPtr
            int r4 = r4 - r1
            r3._inputPtr = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            r3._currToken = r4
            return r4
        L8f:
            com.fasterxml.jackson.core.JsonToken r4 = r3._handleOddValue(r4)
            r3._currToken = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._nextTokenNotInObject(int):com.fasterxml.jackson.core.JsonToken");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v18 ??, r9v12 ??, r9v5 ??, r9v3 ??, r9v9 ??, r9v7 ??, r9v10 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x006e -> B:30:0x0050). Please report as a decompilation issue!!! */
    private final com.fasterxml.jackson.core.JsonToken _parseFloat(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r9v0 ??, r9v1 ??, r9v18 ??, r9v12 ??, r9v5 ??, r9v3 ??, r9v9 ??, r9v7 ??, r9v10 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r9v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
        */

    private String _parseName2(int i10, int i11, int i12) throws IOException {
        this._textBuffer.resetWithShared(this._inputBuffer, i10, this._inputPtr - i10);
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in field name", JsonToken.FIELD_NAME);
            }
            char[] cArr = this._inputBuffer;
            int i13 = this._inputPtr;
            this._inputPtr = i13 + 1;
            char c_decodeEscaped = cArr[i13];
            if (c_decodeEscaped <= '\\') {
                if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped <= i12) {
                    if (c_decodeEscaped == i12) {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        TextBuffer textBuffer = this._textBuffer;
                        return this._symbols.findSymbol(textBuffer.getTextBuffer(), textBuffer.getTextOffset(), textBuffer.size(), i11);
                    }
                    if (c_decodeEscaped < ' ') {
                        _throwUnquotedSpace(c_decodeEscaped, MediationMetaData.KEY_NAME);
                    }
                }
            }
            i11 = (i11 * 33) + c_decodeEscaped;
            int i14 = currentSegmentSize + 1;
            currentSegment[currentSegmentSize] = c_decodeEscaped;
            if (i14 >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            } else {
                currentSegmentSize = i14;
            }
        }
    }

    private final JsonToken _parseNumber2(boolean z10, int i10) throws IOException {
        int i11;
        char nextChar;
        boolean z11;
        int i12;
        char nextChar2;
        if (z10) {
            i10++;
        }
        this._inputPtr = i10;
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int i13 = 0;
        if (z10) {
            cArrEmptyAndGetCurrentSegment[0] = '-';
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i14 = this._inputPtr;
        if (i14 < this._inputEnd) {
            char[] cArr = this._inputBuffer;
            this._inputPtr = i14 + 1;
            nextChar = cArr[i14];
        } else {
            nextChar = getNextChar("No digit following minus sign", JsonToken.VALUE_NUMBER_INT);
        }
        if (nextChar == '0') {
            nextChar = _verifyNoLeadingZeroes();
        }
        int i15 = 0;
        while (nextChar >= '0' && nextChar <= '9') {
            i15++;
            if (i11 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i11 = 0;
            }
            int i16 = i11 + 1;
            cArrEmptyAndGetCurrentSegment[i11] = nextChar;
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                i11 = i16;
                nextChar = 0;
                z11 = true;
                break;
            }
            char[] cArr2 = this._inputBuffer;
            int i17 = this._inputPtr;
            this._inputPtr = i17 + 1;
            nextChar = cArr2[i17];
            i11 = i16;
        }
        z11 = false;
        if (i15 == 0) {
            return _handleInvalidNumberStart(nextChar, z10);
        }
        if (nextChar == '.') {
            if (i11 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i11 = 0;
            }
            cArrEmptyAndGetCurrentSegment[i11] = nextChar;
            i11++;
            i12 = 0;
            while (true) {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    z11 = true;
                    break;
                }
                char[] cArr3 = this._inputBuffer;
                int i18 = this._inputPtr;
                this._inputPtr = i18 + 1;
                nextChar = cArr3[i18];
                if (nextChar < '0' || nextChar > '9') {
                    break;
                }
                i12++;
                if (i11 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i11 = 0;
                }
                cArrEmptyAndGetCurrentSegment[i11] = nextChar;
                i11++;
            }
            if (i12 == 0) {
                reportUnexpectedNumberChar(nextChar, "Decimal point not followed by a digit");
            }
        } else {
            i12 = 0;
        }
        if (nextChar == 'e' || nextChar == 'E') {
            if (i11 >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                i11 = 0;
            }
            int i19 = i11 + 1;
            cArrEmptyAndGetCurrentSegment[i11] = nextChar;
            int i20 = this._inputPtr;
            if (i20 < this._inputEnd) {
                char[] cArr4 = this._inputBuffer;
                this._inputPtr = i20 + 1;
                nextChar2 = cArr4[i20];
            } else {
                nextChar2 = getNextChar("expected a digit for number exponent");
            }
            if (nextChar2 == '-' || nextChar2 == '+') {
                if (i19 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i19 = 0;
                }
                int i21 = i19 + 1;
                cArrEmptyAndGetCurrentSegment[i19] = nextChar2;
                int i22 = this._inputPtr;
                if (i22 < this._inputEnd) {
                    char[] cArr5 = this._inputBuffer;
                    this._inputPtr = i22 + 1;
                    nextChar2 = cArr5[i22];
                } else {
                    nextChar2 = getNextChar("expected a digit for number exponent");
                }
                i19 = i21;
            }
            nextChar = nextChar2;
            int i23 = 0;
            while (nextChar <= '9' && nextChar >= '0') {
                i23++;
                if (i19 >= cArrEmptyAndGetCurrentSegment.length) {
                    cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                    i19 = 0;
                }
                i11 = i19 + 1;
                cArrEmptyAndGetCurrentSegment[i19] = nextChar;
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    i13 = i23;
                    z11 = true;
                    break;
                }
                char[] cArr6 = this._inputBuffer;
                int i24 = this._inputPtr;
                this._inputPtr = i24 + 1;
                nextChar = cArr6[i24];
                i19 = i11;
            }
            i13 = i23;
            i11 = i19;
            if (i13 == 0) {
                reportUnexpectedNumberChar(nextChar, "Exponent indicator not followed by a digit");
            }
        }
        if (!z11) {
            this._inputPtr--;
            if (this._parsingContext.inRoot()) {
                _verifyRootSpace(nextChar);
            }
        }
        this._textBuffer.setCurrentLength(i11);
        return reset(z10, i15, i12, i13);
    }

    private final int _skipAfterComma2() throws IOException {
        char c10;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.typeDesc() + " entries");
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            int i11 = i10 + 1;
            this._inputPtr = i11;
            c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    _skipComment();
                } else if (c10 != '#' || !_skipYAMLComment()) {
                    break;
                }
            } else if (c10 < ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i11;
                } else if (c10 == '\r') {
                    _skipCR();
                } else if (c10 != '\t') {
                    _throwInvalidSpace(c10);
                }
            }
        }
        return c10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0026, code lost:
    
        _reportInvalidEOF(" in a comment", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void _skipCComment() throws java.io.IOException {
        /*
            r3 = this;
        L0:
            int r0 = r3._inputPtr
            int r1 = r3._inputEnd
            if (r0 < r1) goto Lc
            boolean r0 = r3._loadMore()
            if (r0 == 0) goto L26
        Lc:
            char[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            int r2 = r1 + 1
            r3._inputPtr = r2
            char r0 = r0[r1]
            r1 = 42
            if (r0 > r1) goto L0
            if (r0 != r1) goto L3c
            int r0 = r3._inputEnd
            if (r2 < r0) goto L2d
            boolean r0 = r3._loadMore()
            if (r0 != 0) goto L2d
        L26:
            java.lang.String r0 = " in a comment"
            r1 = 0
            r3._reportInvalidEOF(r0, r1)
            return
        L2d:
            char[] r0 = r3._inputBuffer
            int r1 = r3._inputPtr
            char r0 = r0[r1]
            r2 = 47
            if (r0 != r2) goto L0
            int r1 = r1 + 1
            r3._inputPtr = r1
            return
        L3c:
            r1 = 32
            if (r0 >= r1) goto L0
            r1 = 10
            if (r0 != r1) goto L4d
            int r0 = r3._currInputRow
            int r0 = r0 + 1
            r3._currInputRow = r0
            r3._currInputRowStart = r2
            goto L0
        L4d:
            r1 = 13
            if (r0 != r1) goto L55
            r3._skipCR()
            goto L0
        L55:
            r1 = 9
            if (r0 == r1) goto L0
            r3._throwInvalidSpace(r0)
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._skipCComment():void");
    }

    private final int _skipColon() throws IOException {
        int i10 = this._inputPtr;
        if (i10 + 4 >= this._inputEnd) {
            return _skipColon2(false);
        }
        char[] cArr = this._inputBuffer;
        char c10 = cArr[i10];
        if (c10 == ':') {
            int i11 = i10 + 1;
            this._inputPtr = i11;
            char c11 = cArr[i11];
            if (c11 > ' ') {
                if (c11 == '/' || c11 == '#') {
                    return _skipColon2(true);
                }
                this._inputPtr = i11 + 1;
                return c11;
            }
            if (c11 == ' ' || c11 == '\t') {
                int i12 = i11 + 1;
                this._inputPtr = i12;
                char c12 = cArr[i12];
                if (c12 > ' ') {
                    if (c12 == '/' || c12 == '#') {
                        return _skipColon2(true);
                    }
                    this._inputPtr = i12 + 1;
                    return c12;
                }
            }
            return _skipColon2(true);
        }
        if (c10 == ' ' || c10 == '\t') {
            int i13 = i10 + 1;
            this._inputPtr = i13;
            c10 = cArr[i13];
        }
        if (c10 != ':') {
            return _skipColon2(false);
        }
        int i14 = this._inputPtr + 1;
        this._inputPtr = i14;
        char c13 = cArr[i14];
        if (c13 > ' ') {
            if (c13 == '/' || c13 == '#') {
                return _skipColon2(true);
            }
            this._inputPtr = i14 + 1;
            return c13;
        }
        if (c13 == ' ' || c13 == '\t') {
            int i15 = i14 + 1;
            this._inputPtr = i15;
            char c14 = cArr[i15];
            if (c14 > ' ') {
                if (c14 == '/' || c14 == '#') {
                    return _skipColon2(true);
                }
                this._inputPtr = i15 + 1;
                return c14;
            }
        }
        return _skipColon2(true);
    }

    private final int _skipColon2(boolean z10) throws IOException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" within/between " + this._parsingContext.typeDesc() + " entries", null);
                return -1;
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            int i11 = i10 + 1;
            this._inputPtr = i11;
            char c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    _skipComment();
                } else if (c10 != '#' || !_skipYAMLComment()) {
                    if (z10) {
                        return c10;
                    }
                    if (c10 != ':') {
                        _reportUnexpectedChar(c10, "was expecting a colon to separate field name and value");
                    }
                    z10 = true;
                }
            } else if (c10 < ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i11;
                } else if (c10 == '\r') {
                    _skipCR();
                } else if (c10 != '\t') {
                    _throwInvalidSpace(c10);
                }
            }
        }
    }

    private final int _skipColonFast(int i10) throws IOException {
        char[] cArr = this._inputBuffer;
        int i11 = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == ':') {
            int i12 = i11 + 1;
            char c11 = cArr[i11];
            if (c11 > ' ') {
                if (c11 != '/' && c11 != '#') {
                    this._inputPtr = i12;
                    return c11;
                }
            } else if (c11 == ' ' || c11 == '\t') {
                int i13 = i12 + 1;
                char c12 = cArr[i12];
                if (c12 > ' ' && c12 != '/' && c12 != '#') {
                    this._inputPtr = i13;
                    return c12;
                }
                i12 = i13;
            }
            this._inputPtr = i12 - 1;
            return _skipColon2(true);
        }
        if (c10 == ' ' || c10 == '\t') {
            int i14 = i11 + 1;
            char c13 = cArr[i11];
            i11 = i14;
            c10 = c13;
        }
        boolean z10 = c10 == ':';
        if (z10) {
            int i15 = i11 + 1;
            char c14 = cArr[i11];
            if (c14 > ' ') {
                if (c14 != '/' && c14 != '#') {
                    this._inputPtr = i15;
                    return c14;
                }
            } else if (c14 == ' ' || c14 == '\t') {
                i11 = i15 + 1;
                char c15 = cArr[i15];
                if (c15 > ' ' && c15 != '/' && c15 != '#') {
                    this._inputPtr = i11;
                    return c15;
                }
            }
            i11 = i15;
        }
        this._inputPtr = i11 - 1;
        return _skipColon2(z10);
    }

    private final int _skipComma(int i10) throws IOException {
        if (i10 != 44) {
            _reportUnexpectedChar(i10, "was expecting comma to separate " + this._parsingContext.typeDesc() + " entries");
        }
        while (true) {
            int i11 = this._inputPtr;
            if (i11 >= this._inputEnd) {
                return _skipAfterComma2();
            }
            char[] cArr = this._inputBuffer;
            int i12 = i11 + 1;
            this._inputPtr = i12;
            char c10 = cArr[i11];
            if (c10 > ' ') {
                if (c10 != '/' && c10 != '#') {
                    return c10;
                }
                this._inputPtr = i12 - 1;
                return _skipAfterComma2();
            }
            if (c10 < ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i12;
                } else if (c10 == '\r') {
                    _skipCR();
                } else if (c10 != '\t') {
                    _throwInvalidSpace(c10);
                }
            }
        }
    }

    private void _skipComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_JAVA_COMMENTS) == 0) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in a comment", null);
        }
        char[] cArr = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '/') {
            _skipLine();
        } else if (c10 == '*') {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c10, "was expecting either '*' or '/' for a comment");
        }
    }

    private void _skipLine() throws IOException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return;
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            int i11 = i10 + 1;
            this._inputPtr = i11;
            char c10 = cArr[i10];
            if (c10 < ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i11;
                    return;
                } else if (c10 == '\r') {
                    _skipCR();
                    return;
                } else if (c10 != '\t') {
                    _throwInvalidSpace(c10);
                }
            }
        }
    }

    private final int _skipWSOrEnd() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            return _eofAsNextChar();
        }
        char[] cArr = this._inputBuffer;
        int i10 = this._inputPtr;
        int i11 = i10 + 1;
        this._inputPtr = i11;
        char c10 = cArr[i10];
        if (c10 > ' ') {
            if (c10 != '/' && c10 != '#') {
                return c10;
            }
            this._inputPtr = i11 - 1;
            return _skipWSOrEnd2();
        }
        if (c10 != ' ') {
            if (c10 == '\n') {
                this._currInputRow++;
                this._currInputRowStart = i11;
            } else if (c10 == '\r') {
                _skipCR();
            } else if (c10 != '\t') {
                _throwInvalidSpace(c10);
            }
        }
        while (true) {
            int i12 = this._inputPtr;
            if (i12 >= this._inputEnd) {
                return _skipWSOrEnd2();
            }
            char[] cArr2 = this._inputBuffer;
            int i13 = i12 + 1;
            this._inputPtr = i13;
            char c11 = cArr2[i12];
            if (c11 > ' ') {
                if (c11 != '/' && c11 != '#') {
                    return c11;
                }
                this._inputPtr = i13 - 1;
                return _skipWSOrEnd2();
            }
            if (c11 != ' ') {
                if (c11 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i13;
                } else if (c11 == '\r') {
                    _skipCR();
                } else if (c11 != '\t') {
                    _throwInvalidSpace(c11);
                }
            }
        }
    }

    private int _skipWSOrEnd2() throws IOException {
        char c10;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                return _eofAsNextChar();
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            int i11 = i10 + 1;
            this._inputPtr = i11;
            c10 = cArr[i10];
            if (c10 > ' ') {
                if (c10 == '/') {
                    _skipComment();
                } else if (c10 != '#' || !_skipYAMLComment()) {
                    break;
                }
            } else if (c10 != ' ') {
                if (c10 == '\n') {
                    this._currInputRow++;
                    this._currInputRowStart = i11;
                } else if (c10 == '\r') {
                    _skipCR();
                } else if (c10 != '\t') {
                    _throwInvalidSpace(c10);
                }
            }
        }
        return c10;
    }

    private boolean _skipYAMLComment() throws IOException {
        if ((this._features & FEAT_MASK_ALLOW_YAML_COMMENTS) == 0) {
            return false;
        }
        _skipLine();
        return true;
    }

    private final void _updateLocation() {
        int i10 = this._inputPtr;
        this._tokenInputTotal = this._currInputProcessed + i10;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = i10 - this._currInputRowStart;
    }

    private final void _updateNameLocation() {
        int i10 = this._inputPtr;
        this._nameStartOffset = i10;
        this._nameStartRow = this._currInputRow;
        this._nameStartCol = i10 - this._currInputRowStart;
    }

    private char _verifyNLZ2() throws IOException {
        char c10;
        if ((this._inputPtr >= this._inputEnd && !_loadMore()) || (c10 = this._inputBuffer[this._inputPtr]) < '0' || c10 > '9') {
            return '0';
        }
        if ((this._features & FEAT_MASK_LEADING_ZEROS) == 0) {
            reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr++;
        if (c10 == '0') {
            do {
                if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                    break;
                }
                char[] cArr = this._inputBuffer;
                int i10 = this._inputPtr;
                c10 = cArr[i10];
                if (c10 < '0' || c10 > '9') {
                    return '0';
                }
                this._inputPtr = i10 + 1;
            } while (c10 == '0');
        }
        return c10;
    }

    private final char _verifyNoLeadingZeroes() throws IOException {
        char c10;
        int i10 = this._inputPtr;
        if (i10 >= this._inputEnd || ((c10 = this._inputBuffer[i10]) >= '0' && c10 <= '9')) {
            return _verifyNLZ2();
        }
        return '0';
    }

    private final void _verifyRootSpace(int i10) throws IOException {
        int i11 = this._inputPtr + 1;
        this._inputPtr = i11;
        if (i10 != 9) {
            if (i10 == 10) {
                this._currInputRow++;
                this._currInputRowStart = i11;
            } else if (i10 == 13) {
                _skipCR();
            } else if (i10 != 32) {
                _reportMissingRootWS(i10);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _closeInput() throws IOException {
        if (this._reader != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)) {
                this._reader.close();
            }
            this._reader = null;
        }
    }

    public byte[] _decodeBase64(Base64Variant base64Variant) throws IOException {
        ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                _loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            char c10 = cArr[i10];
            if (c10 > ' ') {
                int iDecodeBase64Char = base64Variant.decodeBase64Char(c10);
                if (iDecodeBase64Char < 0) {
                    if (c10 == '\"') {
                        return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                    }
                    iDecodeBase64Char = _decodeBase64Escape(base64Variant, c10, 0);
                    if (iDecodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i11 = this._inputPtr;
                this._inputPtr = i11 + 1;
                char c11 = cArr2[i11];
                int iDecodeBase64Char2 = base64Variant.decodeBase64Char(c11);
                if (iDecodeBase64Char2 < 0) {
                    iDecodeBase64Char2 = _decodeBase64Escape(base64Variant, c11, 1);
                }
                int i12 = (iDecodeBase64Char << 6) | iDecodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i13 = this._inputPtr;
                this._inputPtr = i13 + 1;
                char c12 = cArr3[i13];
                int iDecodeBase64Char3 = base64Variant.decodeBase64Char(c12);
                if (iDecodeBase64Char3 < 0) {
                    if (iDecodeBase64Char3 != -2) {
                        if (c12 == '\"') {
                            byteArrayBuilder_getByteArrayBuilder.append(i12 >> 4);
                            if (base64Variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char3 = _decodeBase64Escape(base64Variant, c12, 2);
                    }
                    if (iDecodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            _loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i14 = this._inputPtr;
                        this._inputPtr = i14 + 1;
                        char c13 = cArr4[i14];
                        if (!base64Variant.usesPaddingChar(c13) && _decodeBase64Escape(base64Variant, c13, 3) != -2) {
                            throw reportInvalidBase64Char(base64Variant, c13, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                        byteArrayBuilder_getByteArrayBuilder.append(i12 >> 4);
                    }
                }
                int i15 = (i12 << 6) | iDecodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    _loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i16 = this._inputPtr;
                this._inputPtr = i16 + 1;
                char c14 = cArr5[i16];
                int iDecodeBase64Char4 = base64Variant.decodeBase64Char(c14);
                if (iDecodeBase64Char4 < 0) {
                    if (iDecodeBase64Char4 != -2) {
                        if (c14 == '\"') {
                            byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i15 >> 2);
                            if (base64Variant.usesPadding()) {
                                this._inputPtr--;
                                _handleBase64MissingPadding(base64Variant);
                            }
                            return byteArrayBuilder_getByteArrayBuilder.toByteArray();
                        }
                        iDecodeBase64Char4 = _decodeBase64Escape(base64Variant, c14, 3);
                    }
                    if (iDecodeBase64Char4 == -2) {
                        byteArrayBuilder_getByteArrayBuilder.appendTwoBytes(i15 >> 2);
                    }
                }
                byteArrayBuilder_getByteArrayBuilder.appendThreeBytes((i15 << 6) | iDecodeBase64Char4);
            }
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public char _decodeEscaped() throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
        }
        char[] cArr = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        char c10 = cArr[i10];
        if (c10 == '\"' || c10 == '/' || c10 == '\\') {
            return c10;
        }
        if (c10 == 'b') {
            return '\b';
        }
        if (c10 == 'f') {
            return '\f';
        }
        if (c10 == 'n') {
            return '\n';
        }
        if (c10 == 'r') {
            return '\r';
        }
        if (c10 == 't') {
            return '\t';
        }
        if (c10 != 'u') {
            return _handleUnrecognizedCharacterEscape(c10);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(" in character escape sequence", JsonToken.VALUE_STRING);
            }
            char[] cArr2 = this._inputBuffer;
            int i13 = this._inputPtr;
            this._inputPtr = i13 + 1;
            char c11 = cArr2[i13];
            int iCharToHex = CharTypes.charToHex(c11);
            if (iCharToHex < 0) {
                _reportUnexpectedChar(c11, "expected a hex-digit for character escape sequence");
            }
            i11 = (i11 << 4) | iCharToHex;
        }
        return (char) i11;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public final void _finishString() throws IOException {
        int i10 = this._inputPtr;
        int i11 = this._inputEnd;
        if (i10 < i11) {
            int[] iArr = _icLatin1;
            int length = iArr.length;
            while (true) {
                char[] cArr = this._inputBuffer;
                char c10 = cArr[i10];
                if (c10 >= length || iArr[c10] == 0) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                } else if (c10 == '\"') {
                    TextBuffer textBuffer = this._textBuffer;
                    int i12 = this._inputPtr;
                    textBuffer.resetWithShared(cArr, i12, i10 - i12);
                    this._inputPtr = i10 + 1;
                    return;
                }
            }
        }
        TextBuffer textBuffer2 = this._textBuffer;
        char[] cArr2 = this._inputBuffer;
        int i13 = this._inputPtr;
        textBuffer2.resetWithCopy(cArr2, i13, i10 - i13);
        this._inputPtr = i10;
        _finishString2();
    }

    public void _finishString2() throws IOException {
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int[] iArr = _icLatin1;
        int length = iArr.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            char c_decodeEscaped = cArr[i10];
            if (c_decodeEscaped < length && iArr[c_decodeEscaped] != 0) {
                if (c_decodeEscaped == '\"') {
                    this._textBuffer.setCurrentLength(currentSegmentSize);
                    return;
                } else if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped < ' ') {
                    _throwUnquotedSpace(c_decodeEscaped, "string value");
                }
            }
            if (currentSegmentSize >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            currentSegment[currentSegmentSize] = c_decodeEscaped;
            currentSegmentSize++;
        }
    }

    public final String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        return iId != 5 ? (iId == 6 || iId == 7 || iId == 8) ? this._textBuffer.contentsAsString() : jsonToken.asString() : this._parsingContext.getCurrentName();
    }

    public JsonToken _handleApos() throws IOException {
        char[] cArrEmptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
            }
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            this._inputPtr = i10 + 1;
            char c_decodeEscaped = cArr[i10];
            if (c_decodeEscaped <= '\\') {
                if (c_decodeEscaped == '\\') {
                    c_decodeEscaped = _decodeEscaped();
                } else if (c_decodeEscaped <= '\'') {
                    if (c_decodeEscaped == '\'') {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        return JsonToken.VALUE_STRING;
                    }
                    if (c_decodeEscaped < ' ') {
                        _throwUnquotedSpace(c_decodeEscaped, "string value");
                    }
                }
            }
            if (currentSegmentSize >= cArrEmptyAndGetCurrentSegment.length) {
                cArrEmptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            cArrEmptyAndGetCurrentSegment[currentSegmentSize] = c_decodeEscaped;
            currentSegmentSize++;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public com.fasterxml.jackson.core.JsonToken _handleInvalidNumberStart(
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, char], vars: [r10v0 ??, r10v1 ??, r10v5 ??]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:107)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:83)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:57)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:45)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:405)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
        	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:79)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
        */

    public String _handleOddName(int i10) throws IOException {
        if (i10 == 39 && (this._features & FEAT_MASK_ALLOW_SINGLE_QUOTES) != 0) {
            return _parseAposName();
        }
        if ((this._features & FEAT_MASK_ALLOW_UNQUOTED_NAMES) == 0) {
            _reportUnexpectedChar(i10, "was expecting double-quote to start field name");
        }
        int[] inputCodeLatin1JsNames = CharTypes.getInputCodeLatin1JsNames();
        int length = inputCodeLatin1JsNames.length;
        if (!(i10 < length ? inputCodeLatin1JsNames[i10] == 0 : Character.isJavaIdentifierPart((char) i10))) {
            _reportUnexpectedChar(i10, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i11 = this._inputPtr;
        int i12 = this._hashSeed;
        int i13 = this._inputEnd;
        if (i11 < i13) {
            do {
                char[] cArr = this._inputBuffer;
                char c10 = cArr[i11];
                if (c10 < length) {
                    if (inputCodeLatin1JsNames[c10] != 0) {
                        int i14 = this._inputPtr - 1;
                        this._inputPtr = i11;
                        return this._symbols.findSymbol(cArr, i14, i11 - i14, i12);
                    }
                } else if (!Character.isJavaIdentifierPart(c10)) {
                    int i15 = this._inputPtr - 1;
                    this._inputPtr = i11;
                    return this._symbols.findSymbol(this._inputBuffer, i15, i11 - i15, i12);
                }
                i12 = (i12 * 33) + c10;
                i11++;
            } while (i11 < i13);
        }
        int i16 = this._inputPtr - 1;
        this._inputPtr = i11;
        return _handleOddName2(i16, i12, inputCodeLatin1JsNames);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.fasterxml.jackson.core.JsonToken _handleOddValue(int r4) throws java.io.IOException {
        /*
            r3 = this;
            r0 = 39
            if (r4 == r0) goto L86
            r0 = 73
            r1 = 1
            if (r4 == r0) goto L6d
            r0 = 78
            if (r4 == r0) goto L54
            r0 = 93
            if (r4 == r0) goto L3c
            r0 = 43
            if (r4 == r0) goto L1b
            r0 = 44
            if (r4 == r0) goto L45
            goto L92
        L1b:
            int r4 = r3._inputPtr
            int r0 = r3._inputEnd
            if (r4 < r0) goto L2c
            boolean r4 = r3._loadMore()
            if (r4 != 0) goto L2c
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NUMBER_INT
            r3._reportInvalidEOFInValue(r4)
        L2c:
            char[] r4 = r3._inputBuffer
            int r0 = r3._inputPtr
            int r1 = r0 + 1
            r3._inputPtr = r1
            char r4 = r4[r0]
            r0 = 0
            com.fasterxml.jackson.core.JsonToken r4 = r3._handleInvalidNumberStart(r4, r0)
            return r4
        L3c:
            com.fasterxml.jackson.core.json.JsonReadContext r0 = r3._parsingContext
            boolean r0 = r0.inArray()
            if (r0 != 0) goto L45
            goto L92
        L45:
            int r0 = r3._features
            int r2 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.FEAT_MASK_ALLOW_MISSING
            r0 = r0 & r2
            if (r0 == 0) goto L92
            int r4 = r3._inputPtr
            int r4 = r4 - r1
            r3._inputPtr = r4
            com.fasterxml.jackson.core.JsonToken r4 = com.fasterxml.jackson.core.JsonToken.VALUE_NULL
            return r4
        L54:
            java.lang.String r0 = "NaN"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L67
            r1 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            com.fasterxml.jackson.core.JsonToken r4 = r3.resetAsNaN(r0, r1)
            return r4
        L67:
            java.lang.String r0 = "Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r0)
            goto L92
        L6d:
            java.lang.String r0 = "Infinity"
            r3._matchToken(r0, r1)
            int r1 = r3._features
            int r2 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.FEAT_MASK_NON_NUM_NUMBERS
            r1 = r1 & r2
            if (r1 == 0) goto L80
            r1 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            com.fasterxml.jackson.core.JsonToken r4 = r3.resetAsNaN(r0, r1)
            return r4
        L80:
            java.lang.String r0 = "Non-standard token 'Infinity': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow"
            r3._reportError(r0)
            goto L92
        L86:
            int r0 = r3._features
            int r1 = com.fasterxml.jackson.core.json.ReaderBasedJsonParser.FEAT_MASK_ALLOW_SINGLE_QUOTES
            r0 = r0 & r1
            if (r0 == 0) goto L92
            com.fasterxml.jackson.core.JsonToken r4 = r3._handleApos()
            return r4
        L92:
            boolean r0 = java.lang.Character.isJavaIdentifierStart(r4)
            if (r0 == 0) goto Lae
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            char r1 = (char) r4
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r3._validJsonTokenList()
            r3._reportInvalidToken(r0, r1)
        Lae:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "expected a valid value "
            r0.<init>(r1)
            java.lang.String r1 = r3._validJsonValueList()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r3._reportUnexpectedChar(r4, r0)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(int):com.fasterxml.jackson.core.JsonToken");
    }

    public boolean _isNextTokenNameMaybe(int i10, String str) throws IOException {
        JsonToken jsonToken_parseNegNumber;
        String str_parseName = i10 == 34 ? _parseName() : _handleOddName(i10);
        this._parsingContext.setCurrentName(str_parseName);
        this._currToken = JsonToken.FIELD_NAME;
        int i_skipColon = _skipColon();
        _updateLocation();
        if (i_skipColon == 34) {
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            return str.equals(str_parseName);
        }
        if (i_skipColon == 45) {
            jsonToken_parseNegNumber = _parseNegNumber();
        } else if (i_skipColon == 91) {
            jsonToken_parseNegNumber = JsonToken.START_ARRAY;
        } else if (i_skipColon == 102) {
            _matchFalse();
            jsonToken_parseNegNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipColon == 110) {
            _matchNull();
            jsonToken_parseNegNumber = JsonToken.VALUE_NULL;
        } else if (i_skipColon == 116) {
            _matchTrue();
            jsonToken_parseNegNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipColon != 123) {
            switch (i_skipColon) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken_parseNegNumber = _parsePosNumber(i_skipColon);
                    break;
                default:
                    jsonToken_parseNegNumber = _handleOddValue(i_skipColon);
                    break;
            }
        } else {
            jsonToken_parseNegNumber = JsonToken.START_OBJECT;
        }
        this._nextToken = jsonToken_parseNegNumber;
        return str.equals(str_parseName);
    }

    public boolean _loadMore() throws IOException {
        int i10 = this._inputEnd;
        Reader reader = this._reader;
        if (reader != null) {
            char[] cArr = this._inputBuffer;
            int i11 = reader.read(cArr, 0, cArr.length);
            if (i11 > 0) {
                this._inputPtr = 0;
                this._inputEnd = i11;
                long j10 = i10;
                this._currInputProcessed += j10;
                this._currInputRowStart -= i10;
                this._nameStartOffset -= j10;
                return true;
            }
            _closeInput();
            if (i11 == 0) {
                throw new IOException("Reader returned 0 characters when trying to read " + this._inputEnd);
            }
        }
        return false;
    }

    public void _loadMoreGuaranteed() throws IOException {
        if (_loadMore()) {
            return;
        }
        _reportInvalidEOF();
    }

    public final void _matchToken(String str, int i10) throws IOException {
        int i11;
        int length = str.length();
        if (this._inputPtr + length >= this._inputEnd) {
            _matchToken2(str, i10);
            return;
        }
        do {
            if (this._inputBuffer[this._inputPtr] != str.charAt(i10)) {
                _reportInvalidToken(str.substring(0, i10));
            }
            i11 = this._inputPtr + 1;
            this._inputPtr = i11;
            i10++;
        } while (i10 < length);
        char c10 = this._inputBuffer[i11];
        if (c10 < '0' || c10 == ']' || c10 == '}') {
            return;
        }
        _checkMatchEnd(str, i10, c10);
    }

    public String _parseAposName() throws IOException {
        int i10 = this._inputPtr;
        int i11 = this._hashSeed;
        int i12 = this._inputEnd;
        if (i10 < i12) {
            int[] iArr = _icLatin1;
            int length = iArr.length;
            do {
                char[] cArr = this._inputBuffer;
                char c10 = cArr[i10];
                if (c10 != '\'') {
                    if (c10 < length && iArr[c10] != 0) {
                        break;
                    }
                    i11 = (i11 * 33) + c10;
                    i10++;
                } else {
                    int i13 = this._inputPtr;
                    this._inputPtr = i10 + 1;
                    return this._symbols.findSymbol(cArr, i13, i10 - i13, i11);
                }
            } while (i10 < i12);
        }
        int i14 = this._inputPtr;
        this._inputPtr = i10;
        return _parseName2(i14, i11, 39);
    }

    public final String _parseName() throws IOException {
        int i10 = this._inputPtr;
        int i11 = this._hashSeed;
        int[] iArr = _icLatin1;
        while (true) {
            if (i10 >= this._inputEnd) {
                break;
            }
            char[] cArr = this._inputBuffer;
            char c10 = cArr[i10];
            if (c10 >= iArr.length || iArr[c10] == 0) {
                i11 = (i11 * 33) + c10;
                i10++;
            } else if (c10 == '\"') {
                int i12 = this._inputPtr;
                this._inputPtr = i10 + 1;
                return this._symbols.findSymbol(cArr, i12, i10 - i12, i11);
            }
        }
        int i13 = this._inputPtr;
        this._inputPtr = i10;
        return _parseName2(i13, i11, 34);
    }

    public final JsonToken _parseNegNumber() throws IOException {
        int i10 = this._inputPtr;
        int i11 = i10 - 1;
        int i12 = this._inputEnd;
        if (i10 >= i12) {
            return _parseNumber2(true, i11);
        }
        int i13 = i10 + 1;
        char c10 = this._inputBuffer[i10];
        if (c10 > '9' || c10 < '0') {
            this._inputPtr = i13;
            return _handleInvalidNumberStart(c10, true);
        }
        if (c10 == '0') {
            return _parseNumber2(true, i11);
        }
        int i14 = 1;
        while (i13 < i12) {
            int i15 = i13 + 1;
            char c11 = this._inputBuffer[i13];
            if (c11 < '0' || c11 > '9') {
                if (c11 == '.' || c11 == 'e' || c11 == 'E') {
                    this._inputPtr = i15;
                    return _parseFloat(c11, i11, i15, true, i14);
                }
                int i16 = i15 - 1;
                this._inputPtr = i16;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c11);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, i11, i16 - i11);
                return resetInt(true, i14);
            }
            i14++;
            i13 = i15;
        }
        return _parseNumber2(true, i11);
    }

    public final JsonToken _parsePosNumber(int i10) throws IOException {
        int i11 = this._inputPtr;
        int i12 = i11 - 1;
        int i13 = this._inputEnd;
        if (i10 == 48) {
            return _parseNumber2(false, i12);
        }
        int i14 = 1;
        while (i11 < i13) {
            int i15 = i11 + 1;
            char c10 = this._inputBuffer[i11];
            if (c10 < '0' || c10 > '9') {
                if (c10 == '.' || c10 == 'e' || c10 == 'E') {
                    this._inputPtr = i15;
                    return _parseFloat(c10, i12, i15, false, i14);
                }
                int i16 = i15 - 1;
                this._inputPtr = i16;
                if (this._parsingContext.inRoot()) {
                    _verifyRootSpace(c10);
                }
                this._textBuffer.resetWithShared(this._inputBuffer, i12, i16 - i12);
                return resetInt(false, i14);
            }
            i14++;
            i11 = i15;
        }
        this._inputPtr = i12;
        return _parseNumber2(false, i12);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int _readBinary(com.fasterxml.jackson.core.Base64Variant r17, java.io.OutputStream r18, byte[] r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser._readBinary(com.fasterxml.jackson.core.Base64Variant, java.io.OutputStream, byte[]):int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase
    public void _releaseBuffers() throws IOException {
        char[] cArr;
        super._releaseBuffers();
        this._symbols.release();
        if (!this._bufferRecyclable || (cArr = this._inputBuffer) == null) {
            return;
        }
        this._inputBuffer = null;
        this._ioContext.releaseTokenBuffer(cArr);
    }

    public void _reportInvalidToken(String str) throws IOException {
        _reportInvalidToken(str, _validJsonTokenList());
    }

    public final void _skipCR() throws IOException {
        if (this._inputPtr < this._inputEnd || _loadMore()) {
            char[] cArr = this._inputBuffer;
            int i10 = this._inputPtr;
            if (cArr[i10] == '\n') {
                this._inputPtr = i10 + 1;
            }
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    public final void _skipString() throws IOException {
        this._tokenIncomplete = false;
        int i10 = this._inputPtr;
        int i11 = this._inputEnd;
        char[] cArr = this._inputBuffer;
        while (true) {
            if (i10 >= i11) {
                this._inputPtr = i10;
                if (!_loadMore()) {
                    _reportInvalidEOF(": was expecting closing quote for a string value", JsonToken.VALUE_STRING);
                }
                i10 = this._inputPtr;
                i11 = this._inputEnd;
            }
            int i12 = i10 + 1;
            char c10 = cArr[i10];
            if (c10 <= '\\') {
                if (c10 == '\\') {
                    this._inputPtr = i12;
                    _decodeEscaped();
                    i10 = this._inputPtr;
                    i11 = this._inputEnd;
                } else if (c10 <= '\"') {
                    if (c10 == '\"') {
                        this._inputPtr = i12;
                        return;
                    } else if (c10 < ' ') {
                        this._inputPtr = i12;
                        _throwUnquotedSpace(c10, "string value");
                    }
                }
            }
            i10 = i12;
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void finishToken() throws IOException {
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException {
        byte[] bArr;
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_EMBEDDED_OBJECT && (bArr = this._binaryValue) != null) {
            return bArr;
        }
        if (jsonToken != JsonToken.VALUE_STRING) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e10) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e10.getMessage());
            }
        } else if (this._binaryValue == null) {
            ByteArrayBuilder byteArrayBuilder_getByteArrayBuilder = _getByteArrayBuilder();
            _decodeBase64(getText(), byteArrayBuilder_getByteArrayBuilder, base64Variant);
            this._binaryValue = byteArrayBuilder_getByteArrayBuilder.toByteArray();
        }
        return this._binaryValue;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getCurrentLocation() {
        return new JsonLocation(_getSourceReference(), -1L, this._currInputProcessed + this._inputPtr, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public Object getInputSource() {
        return this._reader;
    }

    @Deprecated
    public char getNextChar(String str) throws IOException {
        return getNextChar(str, null);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getText() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return _getText2(jsonToken);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final char[] getTextCharacters() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return null;
        }
        int iId = jsonToken.id();
        if (iId != 5) {
            if (iId != 6) {
                if (iId != 7 && iId != 8) {
                    return this._currToken.asCharArray();
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextBuffer();
        }
        if (!this._nameCopied) {
            String currentName = this._parsingContext.getCurrentName();
            int length = currentName.length();
            char[] cArr = this._nameCopyBuffer;
            if (cArr == null) {
                this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
            } else if (cArr.length < length) {
                this._nameCopyBuffer = new char[length];
            }
            currentName.getChars(0, length, this._nameCopyBuffer, 0);
            this._nameCopied = true;
        }
        return this._nameCopyBuffer;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final int getTextLength() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == null) {
            return 0;
        }
        int iId = jsonToken.id();
        if (iId == 5) {
            return this._parsingContext.getCurrentName().length();
        }
        if (iId != 6) {
            if (iId != 7 && iId != 8) {
                return this._currToken.asCharArray().length;
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        if (r0 != 8) goto L16;
     */
    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int getTextOffset() throws java.io.IOException {
        /*
            r3 = this;
            com.fasterxml.jackson.core.JsonToken r0 = r3._currToken
            r1 = 0
            if (r0 == 0) goto L24
            int r0 = r0.id()
            r2 = 6
            if (r0 == r2) goto L14
            r2 = 7
            if (r0 == r2) goto L1d
            r2 = 8
            if (r0 == r2) goto L1d
            goto L24
        L14:
            boolean r0 = r3._tokenIncomplete
            if (r0 == 0) goto L1d
            r3._tokenIncomplete = r1
            r3._finishString()
        L1d:
            com.fasterxml.jackson.core.util.TextBuffer r0 = r3._textBuffer
            int r0 = r0.getTextOffset()
            return r0
        L24:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.json.ReaderBasedJsonParser.getTextOffset():int");
    }

    @Override // com.fasterxml.jackson.core.base.ParserBase, com.fasterxml.jackson.core.JsonParser
    public JsonLocation getTokenLocation() {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return new JsonLocation(_getSourceReference(), -1L, this._tokenInputTotal - 1, this._tokenInputRow, this._tokenInputCol);
        }
        return new JsonLocation(_getSourceReference(), -1L, (this._nameStartOffset - 1) + this._currInputProcessed, this._nameStartRow, this._nameStartCol);
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString() throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return jsonToken == JsonToken.FIELD_NAME ? getCurrentName() : super.getValueAsString(null);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final Boolean nextBooleanValue() throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            JsonToken jsonTokenNextToken = nextToken();
            if (jsonTokenNextToken != null) {
                int iId = jsonTokenNextToken.id();
                if (iId == 9) {
                    return Boolean.TRUE;
                }
                if (iId == 10) {
                    return Boolean.FALSE;
                }
            }
            return null;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_TRUE) {
            return Boolean.TRUE;
        }
        if (jsonToken == JsonToken.VALUE_FALSE) {
            return Boolean.FALSE;
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public boolean nextFieldName(SerializableString serializableString) throws IOException {
        int i10 = 0;
        this._numTypesValid = 0;
        if (this._currToken == JsonToken.FIELD_NAME) {
            _nextAfterName();
            return false;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return false;
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125) {
            _closeScope(i_skipWSOrEnd);
            return false;
        }
        if (this._parsingContext.expectComma()) {
            i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                _closeScope(i_skipWSOrEnd);
                return false;
            }
        }
        if (!this._parsingContext.inObject()) {
            _updateLocation();
            _nextTokenNotInObject(i_skipWSOrEnd);
            return false;
        }
        _updateNameLocation();
        if (i_skipWSOrEnd == 34) {
            char[] cArrAsQuotedChars = serializableString.asQuotedChars();
            int length = cArrAsQuotedChars.length;
            int i11 = this._inputPtr;
            if (i11 + length + 4 < this._inputEnd) {
                int i12 = length + i11;
                if (this._inputBuffer[i12] == '\"') {
                    while (i11 != i12) {
                        if (cArrAsQuotedChars[i10] == this._inputBuffer[i11]) {
                            i10++;
                            i11++;
                        }
                    }
                    this._parsingContext.setCurrentName(serializableString.getValue());
                    _isNextTokenNameYes(_skipColonFast(i11 + 1));
                    return true;
                }
            }
        }
        return _isNextTokenNameMaybe(i_skipWSOrEnd, serializableString.getValue());
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final int nextIntValue(int i10) throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getIntValue() : i10;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getIntValue();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return i10;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final long nextLongValue(long j10) throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            return nextToken() == JsonToken.VALUE_NUMBER_INT ? getLongValue() : j10;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_NUMBER_INT) {
            return getLongValue();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return j10;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public final String nextTextValue() throws IOException {
        if (this._currToken != JsonToken.FIELD_NAME) {
            if (nextToken() == JsonToken.VALUE_STRING) {
                return getText();
            }
            return null;
        }
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        this._currToken = jsonToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        return null;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final JsonToken nextToken() throws IOException {
        JsonToken jsonToken_parseNegNumber;
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            return _nextAfterName();
        }
        this._numTypesValid = 0;
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125) {
            _closeScope(i_skipWSOrEnd);
            return this._currToken;
        }
        if (this._parsingContext.expectComma()) {
            i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
            if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                _closeScope(i_skipWSOrEnd);
                return this._currToken;
            }
        }
        boolean zInObject = this._parsingContext.inObject();
        if (zInObject) {
            _updateNameLocation();
            this._parsingContext.setCurrentName(i_skipWSOrEnd == 34 ? _parseName() : _handleOddName(i_skipWSOrEnd));
            this._currToken = jsonToken2;
            i_skipWSOrEnd = _skipColon();
        }
        _updateLocation();
        if (i_skipWSOrEnd == 34) {
            this._tokenIncomplete = true;
            jsonToken_parseNegNumber = JsonToken.VALUE_STRING;
        } else if (i_skipWSOrEnd == 45) {
            jsonToken_parseNegNumber = _parseNegNumber();
        } else if (i_skipWSOrEnd == 91) {
            if (!zInObject) {
                this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            }
            jsonToken_parseNegNumber = JsonToken.START_ARRAY;
        } else if (i_skipWSOrEnd == 102) {
            _matchFalse();
            jsonToken_parseNegNumber = JsonToken.VALUE_FALSE;
        } else if (i_skipWSOrEnd == 110) {
            _matchNull();
            jsonToken_parseNegNumber = JsonToken.VALUE_NULL;
        } else if (i_skipWSOrEnd == 116) {
            _matchTrue();
            jsonToken_parseNegNumber = JsonToken.VALUE_TRUE;
        } else if (i_skipWSOrEnd == 123) {
            if (!zInObject) {
                this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            jsonToken_parseNegNumber = JsonToken.START_OBJECT;
        } else if (i_skipWSOrEnd != 125) {
            switch (i_skipWSOrEnd) {
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                    jsonToken_parseNegNumber = _parsePosNumber(i_skipWSOrEnd);
                    break;
                default:
                    jsonToken_parseNegNumber = _handleOddValue(i_skipWSOrEnd);
                    break;
            }
        } else {
            _reportUnexpectedChar(i_skipWSOrEnd, "expected a value");
            _matchTrue();
            jsonToken_parseNegNumber = JsonToken.VALUE_TRUE;
        }
        if (zInObject) {
            this._nextToken = jsonToken_parseNegNumber;
            return this._currToken;
        }
        this._currToken = jsonToken_parseNegNumber;
        return jsonToken_parseNegNumber;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int readBinaryValue(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        if (!this._tokenIncomplete || this._currToken != JsonToken.VALUE_STRING) {
            byte[] binaryValue = getBinaryValue(base64Variant);
            outputStream.write(binaryValue);
            return binaryValue.length;
        }
        byte[] bArrAllocBase64Buffer = this._ioContext.allocBase64Buffer();
        try {
            return _readBinary(base64Variant, outputStream, bArrAllocBase64Buffer);
        } finally {
            this._ioContext.releaseBase64Buffer(bArrAllocBase64Buffer);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int releaseBuffered(Writer writer) throws IOException {
        int i10 = this._inputEnd;
        int i11 = this._inputPtr;
        int i12 = i10 - i11;
        if (i12 < 1) {
            return 0;
        }
        writer.write(this._inputBuffer, i11, i12);
        return i12;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    public void _reportInvalidToken(String str, String str2) throws IOException {
        StringBuilder sb2 = new StringBuilder(str);
        while (true) {
            if (this._inputPtr >= this._inputEnd && !_loadMore()) {
                break;
            }
            char c10 = this._inputBuffer[this._inputPtr];
            if (!Character.isJavaIdentifierPart(c10)) {
                break;
            }
            this._inputPtr++;
            sb2.append(c10);
            if (sb2.length() >= 256) {
                sb2.append("...");
                break;
            }
        }
        _reportError("Unrecognized token '%s': was expecting %s", sb2, str2);
    }

    public char getNextChar(String str, JsonToken jsonToken) throws IOException {
        if (this._inputPtr >= this._inputEnd && !_loadMore()) {
            _reportInvalidEOF(str, jsonToken);
        }
        char[] cArr = this._inputBuffer;
        int i10 = this._inputPtr;
        this._inputPtr = i10 + 1;
        return cArr[i10];
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public int getText(Writer writer) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsToWriter(writer);
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            String currentName = this._parsingContext.getCurrentName();
            writer.write(currentName);
            return currentName.length();
        }
        if (jsonToken == null) {
            return 0;
        }
        if (jsonToken.isNumeric()) {
            return this._textBuffer.contentsToWriter(writer);
        }
        char[] cArrAsCharArray = jsonToken.asCharArray();
        writer.write(cArrAsCharArray);
        return cArrAsCharArray.length;
    }

    @Override // com.fasterxml.jackson.core.base.ParserMinimalBase, com.fasterxml.jackson.core.JsonParser
    public final String getValueAsString(String str) throws IOException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken == JsonToken.VALUE_STRING) {
            if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.contentsAsString();
        }
        if (jsonToken == JsonToken.FIELD_NAME) {
            return getCurrentName();
        }
        return super.getValueAsString(str);
    }

    public ReaderBasedJsonParser(IOContext iOContext, int i10, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i10);
        this._reader = reader;
        this._inputBuffer = iOContext.allocTokenBuffer();
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._objectCodec = objectCodec;
        this._symbols = charsToNameCanonicalizer;
        this._hashSeed = charsToNameCanonicalizer.hashSeed();
        this._bufferRecyclable = true;
    }

    @Override // com.fasterxml.jackson.core.JsonParser
    public String nextFieldName() throws IOException {
        JsonToken jsonToken_parseNegNumber;
        this._numTypesValid = 0;
        JsonToken jsonToken = this._currToken;
        JsonToken jsonToken2 = JsonToken.FIELD_NAME;
        if (jsonToken == jsonToken2) {
            _nextAfterName();
            return null;
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int i_skipWSOrEnd = _skipWSOrEnd();
        if (i_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._binaryValue = null;
        if (i_skipWSOrEnd != 93 && i_skipWSOrEnd != 125) {
            if (this._parsingContext.expectComma()) {
                i_skipWSOrEnd = _skipComma(i_skipWSOrEnd);
                if ((this._features & FEAT_MASK_TRAILING_COMMA) != 0 && (i_skipWSOrEnd == 93 || i_skipWSOrEnd == 125)) {
                    _closeScope(i_skipWSOrEnd);
                    return null;
                }
            }
            if (!this._parsingContext.inObject()) {
                _updateLocation();
                _nextTokenNotInObject(i_skipWSOrEnd);
                return null;
            }
            _updateNameLocation();
            String str_parseName = i_skipWSOrEnd == 34 ? _parseName() : _handleOddName(i_skipWSOrEnd);
            this._parsingContext.setCurrentName(str_parseName);
            this._currToken = jsonToken2;
            int i_skipColon = _skipColon();
            _updateLocation();
            if (i_skipColon == 34) {
                this._tokenIncomplete = true;
                this._nextToken = JsonToken.VALUE_STRING;
                return str_parseName;
            }
            if (i_skipColon == 45) {
                jsonToken_parseNegNumber = _parseNegNumber();
            } else if (i_skipColon == 91) {
                jsonToken_parseNegNumber = JsonToken.START_ARRAY;
            } else if (i_skipColon == 102) {
                _matchFalse();
                jsonToken_parseNegNumber = JsonToken.VALUE_FALSE;
            } else if (i_skipColon == 110) {
                _matchNull();
                jsonToken_parseNegNumber = JsonToken.VALUE_NULL;
            } else if (i_skipColon == 116) {
                _matchTrue();
                jsonToken_parseNegNumber = JsonToken.VALUE_TRUE;
            } else if (i_skipColon != 123) {
                switch (i_skipColon) {
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                        jsonToken_parseNegNumber = _parsePosNumber(i_skipColon);
                        break;
                    default:
                        jsonToken_parseNegNumber = _handleOddValue(i_skipColon);
                        break;
                }
            } else {
                jsonToken_parseNegNumber = JsonToken.START_OBJECT;
            }
            this._nextToken = jsonToken_parseNegNumber;
            return str_parseName;
        }
        _closeScope(i_skipWSOrEnd);
        return null;
    }
}
