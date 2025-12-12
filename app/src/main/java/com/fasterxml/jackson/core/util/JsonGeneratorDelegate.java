package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class JsonGeneratorDelegate extends JsonGenerator {
    protected JsonGenerator delegate;
    protected boolean delegateCopyMethods;

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator) {
        this(jsonGenerator, true);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canOmitFields() {
        return this.delegate.canOmitFields();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteBinaryNatively() {
        return this.delegate.canWriteBinaryNatively();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteObjectId() {
        return this.delegate.canWriteObjectId();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean canWriteTypeId() {
        return this.delegate.canWriteTypeId();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentEvent(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentEvent(jsonParser);
        } else {
            super.copyCurrentEvent(jsonParser);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void copyCurrentStructure(JsonParser jsonParser) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.copyCurrentStructure(jsonParser);
        } else {
            super.copyCurrentStructure(jsonParser);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public CharacterEscapes getCharacterEscapes() {
        return this.delegate.getCharacterEscapes();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getCurrentValue() {
        return this.delegate.getCurrentValue();
    }

    public JsonGenerator getDelegate() {
        return this.delegate;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getFeatureMask() {
        return this.delegate.getFeatureMask();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getHighestEscapedChar() {
        return this.delegate.getHighestEscapedChar();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int getOutputBuffered() {
        return this.delegate.getOutputBuffered();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public PrettyPrinter getPrettyPrinter() {
        return this.delegate.getPrettyPrinter();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public FormatSchema getSchema() {
        return this.delegate.getSchema();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideFormatFeatures(int i10, int i11) {
        this.delegate.overrideFormatFeatures(i10, i11);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator overrideStdFeatures(int i10, int i11) {
        this.delegate.overrideStdFeatures(i10, i11);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this.delegate.setCharacterEscapes(characterEscapes);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void setCurrentValue(Object obj) {
        this.delegate.setCurrentValue(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    @Deprecated
    public JsonGenerator setFeatureMask(int i10) {
        this.delegate.setFeatureMask(i10);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setHighestNonEscapedChar(int i10) {
        this.delegate.setHighestNonEscapedChar(i10);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setPrettyPrinter(PrettyPrinter prettyPrinter) {
        this.delegate.setPrettyPrinter(prettyPrinter);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator setRootValueSeparator(SerializableString serializableString) {
        this.delegate.setRootValueSeparator(serializableString);
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public JsonGenerator useDefaultPrettyPrinter() {
        this.delegate.useDefaultPrettyPrinter();
        return this;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator, com.fasterxml.jackson.core.Versioned
    public Version version() {
        return this.delegate.version();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(int[] iArr, int i10, int i11) throws IOException {
        this.delegate.writeArray(iArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i10, int i11) throws IOException {
        this.delegate.writeBinary(base64Variant, bArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeBoolean(boolean z10) throws IOException {
        this.delegate.writeBoolean(z10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEmbeddedObject(Object obj) throws IOException {
        this.delegate.writeEmbeddedObject(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndArray() throws IOException {
        this.delegate.writeEndArray();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeEndObject() throws IOException {
        this.delegate.writeEndObject();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldId(long j10) throws IOException {
        this.delegate.writeFieldId(j10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(String str) throws IOException {
        this.delegate.writeFieldName(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNull() throws IOException {
        this.delegate.writeNull();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(short s10) throws IOException {
        this.delegate.writeNumber(s10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObject(Object obj) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeObject(obj);
            return;
        }
        if (obj == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec != null) {
            codec.writeValue(this, obj);
        } else {
            _writeSimpleObject(obj);
        }
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectId(Object obj) throws IOException {
        this.delegate.writeObjectId(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeObjectRef(Object obj) throws IOException {
        this.delegate.writeObjectRef(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeOmittedField(String str) throws IOException {
        this.delegate.writeOmittedField(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str) throws IOException {
        this.delegate.writeRaw(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawUTF8String(byte[] bArr, int i10, int i11) throws IOException {
        this.delegate.writeRawUTF8String(bArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str) throws IOException {
        this.delegate.writeRawValue(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray() throws IOException {
        this.delegate.writeStartArray();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject() throws IOException {
        this.delegate.writeStartObject();
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(String str) throws IOException {
        this.delegate.writeString(str);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTree(TreeNode treeNode) throws IOException {
        if (this.delegateCopyMethods) {
            this.delegate.writeTree(treeNode);
            return;
        }
        if (treeNode == null) {
            writeNull();
            return;
        }
        ObjectCodec codec = getCodec();
        if (codec == null) {
            throw new IllegalStateException("No ObjectCodec defined");
        }
        codec.writeTree(this, treeNode);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeTypeId(Object obj) throws IOException {
        this.delegate.writeTypeId(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeUTF8String(byte[] bArr, int i10, int i11) throws IOException {
        this.delegate.writeUTF8String(bArr, i10, i11);
    }

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator, boolean z10) {
        this.delegate = jsonGenerator;
        this.delegateCopyMethods = z10;
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(long[] jArr, int i10, int i11) throws IOException {
        this.delegate.writeArray(jArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public int writeBinary(Base64Variant base64Variant, InputStream inputStream, int i10) throws IOException {
        return this.delegate.writeBinary(base64Variant, inputStream, i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeFieldName(SerializableString serializableString) throws IOException {
        this.delegate.writeFieldName(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(int i10) throws IOException {
        this.delegate.writeNumber(i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(String str, int i10, int i11) throws IOException {
        this.delegate.writeRaw(str, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(String str, int i10, int i11) throws IOException {
        this.delegate.writeRawValue(str, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(int i10) throws IOException {
        this.delegate.writeStartArray(i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj) throws IOException {
        this.delegate.writeStartObject(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(Reader reader, int i10) throws IOException {
        this.delegate.writeString(reader, i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeArray(double[] dArr, int i10, int i11) throws IOException {
        this.delegate.writeArray(dArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(long j10) throws IOException {
        this.delegate.writeNumber(j10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(SerializableString serializableString) throws IOException {
        this.delegate.writeRaw(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRawValue(char[] cArr, int i10, int i11) throws IOException {
        this.delegate.writeRawValue(cArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj) throws IOException {
        this.delegate.writeStartArray(obj);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartObject(Object obj, int i10) throws IOException {
        this.delegate.writeStartObject(obj, i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(char[] cArr, int i10, int i11) throws IOException {
        this.delegate.writeString(cArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigInteger bigInteger) throws IOException {
        this.delegate.writeNumber(bigInteger);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char[] cArr, int i10, int i11) throws IOException {
        this.delegate.writeRaw(cArr, i10, i11);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeStartArray(Object obj, int i10) throws IOException {
        this.delegate.writeStartArray(obj, i10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeString(SerializableString serializableString) throws IOException {
        this.delegate.writeString(serializableString);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(double d10) throws IOException {
        this.delegate.writeNumber(d10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeRaw(char c10) throws IOException {
        this.delegate.writeRaw(c10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(float f10) throws IOException {
        this.delegate.writeNumber(f10);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(BigDecimal bigDecimal) throws IOException {
        this.delegate.writeNumber(bigDecimal);
    }

    @Override // com.fasterxml.jackson.core.JsonGenerator
    public void writeNumber(String str) throws UnsupportedOperationException, IOException {
        this.delegate.writeNumber(str);
    }
}
