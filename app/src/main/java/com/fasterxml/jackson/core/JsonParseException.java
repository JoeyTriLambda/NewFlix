package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.RequestPayload;

/* loaded from: classes.dex */
public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    @Deprecated
    public JsonParseException(String str, JsonLocation jsonLocation) {
        super(str, jsonLocation, (Throwable) null);
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public RequestPayload getRequestPayload() {
        return super.getRequestPayload();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public String getRequestPayloadAsString() {
        return super.getRequestPayloadAsString();
    }

    @Deprecated
    public JsonParseException(String str, JsonLocation jsonLocation, Throwable th2) {
        super(str, jsonLocation, th2);
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException
    public JsonParser getProcessor() {
        return super.getProcessor();
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public JsonParseException withParser(JsonParser jsonParser) {
        this._processor = jsonParser;
        return this;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    public JsonParseException withRequestPayload(RequestPayload requestPayload) {
        this._requestPayload = requestPayload;
        return this;
    }

    public JsonParseException(JsonParser jsonParser, String str) {
        super(jsonParser, str);
    }

    public JsonParseException(JsonParser jsonParser, String str, Throwable th2) {
        super(jsonParser, str, th2);
    }

    public JsonParseException(JsonParser jsonParser, String str, JsonLocation jsonLocation) {
        super(jsonParser, str, jsonLocation);
    }

    public JsonParseException(JsonParser jsonParser, String str, JsonLocation jsonLocation, Throwable th2) {
        super(str, jsonLocation, th2);
    }
}
