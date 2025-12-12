package com.fasterxml.jackson.core;

/* loaded from: classes.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;
    protected transient JsonGenerator _processor;

    @Deprecated
    public JsonGenerationException(Throwable th2) {
        super(th2);
    }

    public JsonGenerationException withGenerator(JsonGenerator jsonGenerator) {
        this._processor = jsonGenerator;
        return this;
    }

    @Deprecated
    public JsonGenerationException(String str) {
        super(str, (JsonLocation) null);
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public JsonGenerator getProcessor() {
        return this._processor;
    }

    @Deprecated
    public JsonGenerationException(String str, Throwable th2) {
        super(str, null, th2);
    }

    public JsonGenerationException(Throwable th2, JsonGenerator jsonGenerator) {
        super(th2);
        this._processor = jsonGenerator;
    }

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null);
        this._processor = jsonGenerator;
    }

    public JsonGenerationException(String str, Throwable th2, JsonGenerator jsonGenerator) {
        super(str, null, th2);
        this._processor = jsonGenerator;
    }
}
