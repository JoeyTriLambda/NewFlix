package org.apache.commons.lang3.builder;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class MultilineRecursiveToStringStyle extends RecursiveToStringStyle {
    private static final int INDENT = 2;
    private static final long serialVersionUID = 1;
    private int spaces = 2;

    public MultilineRecursiveToStringStyle() {
        resetIndent();
    }

    private void resetIndent() {
        setArrayStart("{" + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setArraySeparator("," + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setArrayEnd(System.lineSeparator() + ((Object) spacer(this.spaces + (-2))) + "}");
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(System.lineSeparator());
        sb2.append((Object) spacer(this.spaces));
        setContentStart(sb2.toString());
        setFieldSeparator("," + System.lineSeparator() + ((Object) spacer(this.spaces)));
        setContentEnd(System.lineSeparator() + ((Object) spacer(this.spaces + (-2))) + "]");
    }

    private StringBuilder spacer(int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(StringUtils.SPACE);
        }
        return sb2;
    }

    @Override // org.apache.commons.lang3.builder.RecursiveToStringStyle, org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
        if (ClassUtils.isPrimitiveWrapper(obj.getClass()) || String.class.equals(obj.getClass()) || !accept(obj.getClass())) {
            super.appendDetail(stringBuffer, str, obj);
            return;
        }
        this.spaces += 2;
        resetIndent();
        stringBuffer.append(ReflectionToStringBuilder.toString(obj, this));
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void reflectionAppendArrayDetail(StringBuffer stringBuffer, String str, Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        this.spaces += 2;
        resetIndent();
        super.reflectionAppendArrayDetail(stringBuffer, str, obj);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, Object[] objArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, objArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, long[] jArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, jArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, int[] iArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, iArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, short[] sArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, sArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, byte[] bArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, bArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, char[] cArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, cArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, double[] dArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, dArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, float[] fArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, fArr);
        this.spaces -= 2;
        resetIndent();
    }

    @Override // org.apache.commons.lang3.builder.ToStringStyle
    public void appendDetail(StringBuffer stringBuffer, String str, boolean[] zArr) {
        this.spaces += 2;
        resetIndent();
        super.appendDetail(stringBuffer, str, zArr);
        this.spaces -= 2;
        resetIndent();
    }
}
