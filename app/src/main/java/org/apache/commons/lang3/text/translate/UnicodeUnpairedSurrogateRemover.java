package org.apache.commons.lang3.text.translate;

import java.io.IOException;
import java.io.Writer;

@Deprecated
/* loaded from: classes2.dex */
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {
    @Override // org.apache.commons.lang3.text.translate.CodePointTranslator
    public boolean translate(int i10, Writer writer) throws IOException {
        return i10 >= 55296 && i10 <= 57343;
    }
}
