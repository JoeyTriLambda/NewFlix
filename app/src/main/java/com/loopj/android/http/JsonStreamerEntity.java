package com.loopj.android.http;

import android.text.TextUtils;
import com.loopj.android.http.RequestParams;
import com.unity3d.ads.metadata.MediationMetaData;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class JsonStreamerEntity implements HttpEntity {
    private static final int BUFFER_SIZE = 4096;
    private static final String LOG_TAG = "JsonStreamerEntity";
    private final Header contentEncoding;
    private final byte[] elapsedField;
    private final ResponseHandlerInterface progressHandler;
    private static final UnsupportedOperationException ERR_UNSUPPORTED = new UnsupportedOperationException("Unsupported operation in this implementation.");
    private static final byte[] JSON_TRUE = "true".getBytes();
    private static final byte[] JSON_FALSE = "false".getBytes();
    private static final byte[] JSON_NULL = "null".getBytes();
    private static final byte[] STREAM_NAME = escape(MediationMetaData.KEY_NAME);
    private static final byte[] STREAM_TYPE = escape("type");
    private static final byte[] STREAM_CONTENTS = escape("contents");
    private static final Header HEADER_JSON_CONTENT = new BasicHeader("Content-Type", "application/json");
    private static final Header HEADER_GZIP_ENCODING = new BasicHeader("Content-Encoding", AsyncHttpClient.ENCODING_GZIP);
    private final byte[] buffer = new byte[BUFFER_SIZE];
    private final Map<String, Object> jsonParams = new HashMap();

    public JsonStreamerEntity(ResponseHandlerInterface responseHandlerInterface, boolean z10, String str) {
        this.progressHandler = responseHandlerInterface;
        this.contentEncoding = z10 ? HEADER_GZIP_ENCODING : null;
        this.elapsedField = TextUtils.isEmpty(str) ? null : escape(str);
    }

    private void endMetaData(OutputStream outputStream) throws IOException {
        outputStream.write(34);
    }

    public static byte[] escape(String str) {
        if (str == null) {
            return JSON_NULL;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append('\"');
        int length = str.length();
        int i10 = -1;
        while (true) {
            i10++;
            if (i10 >= length) {
                sb2.append('\"');
                return sb2.toString().getBytes();
            }
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\f') {
                sb2.append("\\f");
            } else if (cCharAt == '\r') {
                sb2.append("\\r");
            } else if (cCharAt == '\"') {
                sb2.append("\\\"");
            } else if (cCharAt != '\\') {
                switch (cCharAt) {
                    case '\b':
                        sb2.append("\\b");
                        break;
                    case '\t':
                        sb2.append("\\t");
                        break;
                    case '\n':
                        sb2.append("\\n");
                        break;
                    default:
                        if (cCharAt <= 31 || ((cCharAt >= 127 && cCharAt <= 159) || (cCharAt >= 8192 && cCharAt <= 8447))) {
                            String hexString = Integer.toHexString(cCharAt);
                            sb2.append("\\u");
                            int length2 = 4 - hexString.length();
                            for (int i11 = 0; i11 < length2; i11++) {
                                sb2.append('0');
                            }
                            sb2.append(hexString.toUpperCase(Locale.US));
                            break;
                        } else {
                            sb2.append(cCharAt);
                            break;
                        }
                }
            } else {
                sb2.append("\\\\");
            }
        }
    }

    private void writeMetaData(OutputStream outputStream, String str, String str2) throws IOException {
        outputStream.write(STREAM_NAME);
        outputStream.write(58);
        outputStream.write(escape(str));
        outputStream.write(44);
        outputStream.write(STREAM_TYPE);
        outputStream.write(58);
        outputStream.write(escape(str2));
        outputStream.write(44);
        outputStream.write(STREAM_CONTENTS);
        outputStream.write(58);
        outputStream.write(34);
    }

    private void writeToFromFile(OutputStream outputStream, RequestParams.FileWrapper fileWrapper) throws IOException {
        writeMetaData(outputStream, fileWrapper.file.getName(), fileWrapper.contentType);
        long length = fileWrapper.file.length();
        FileInputStream fileInputStream = new FileInputStream(fileWrapper.file);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        long j10 = 0;
        while (true) {
            int i10 = fileInputStream.read(this.buffer);
            if (i10 == -1) {
                AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
                endMetaData(outputStream);
                AsyncHttpClient.silentCloseInputStream(fileInputStream);
                return;
            } else {
                base64OutputStream.write(this.buffer, 0, i10);
                j10 += i10;
                this.progressHandler.sendProgressMessage(j10, length);
            }
        }
    }

    private void writeToFromStream(OutputStream outputStream, RequestParams.StreamWrapper streamWrapper) throws IOException {
        writeMetaData(outputStream, streamWrapper.name, streamWrapper.contentType);
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 18);
        while (true) {
            int i10 = streamWrapper.inputStream.read(this.buffer);
            if (i10 == -1) {
                break;
            } else {
                base64OutputStream.write(this.buffer, 0, i10);
            }
        }
        AsyncHttpClient.silentCloseOutputStream(base64OutputStream);
        endMetaData(outputStream);
        if (streamWrapper.autoClose) {
            AsyncHttpClient.silentCloseInputStream(streamWrapper.inputStream);
        }
    }

    public void addPart(String str, Object obj) {
        this.jsonParams.put(str, obj);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public InputStream getContent() throws UnsupportedOperationException, IOException {
        throw ERR_UNSUPPORTED;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentEncoding() {
        return this.contentEncoding;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public long getContentLength() {
        return -1L;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public Header getContentType() {
        return HEADER_JSON_CONTENT;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalStateException("Output stream cannot be null.");
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.contentEncoding != null) {
            outputStream = new GZIPOutputStream(outputStream, BUFFER_SIZE);
        }
        outputStream.write(123);
        Set<String> setKeySet = this.jsonParams.keySet();
        int size = setKeySet.size();
        if (size > 0) {
            int i10 = 0;
            for (String str : setKeySet) {
                i10++;
                try {
                    Object obj = this.jsonParams.get(str);
                    outputStream.write(escape(str));
                    outputStream.write(58);
                    if (obj == null) {
                        outputStream.write(JSON_NULL);
                    } else {
                        boolean z10 = obj instanceof RequestParams.FileWrapper;
                        if (z10 || (obj instanceof RequestParams.StreamWrapper)) {
                            outputStream.write(123);
                            if (z10) {
                                writeToFromFile(outputStream, (RequestParams.FileWrapper) obj);
                            } else {
                                writeToFromStream(outputStream, (RequestParams.StreamWrapper) obj);
                            }
                            outputStream.write(125);
                        } else if (obj instanceof JsonValueInterface) {
                            outputStream.write(((JsonValueInterface) obj).getEscapedJsonValue());
                        } else if ((obj instanceof JSONObject) || (obj instanceof JSONArray)) {
                            outputStream.write(obj.toString().getBytes());
                        } else if (obj instanceof Boolean) {
                            outputStream.write(((Boolean) obj).booleanValue() ? JSON_TRUE : JSON_FALSE);
                        } else if (obj instanceof Long) {
                            outputStream.write((((Number) obj).longValue() + "").getBytes());
                        } else if (obj instanceof Double) {
                            outputStream.write((((Number) obj).doubleValue() + "").getBytes());
                        } else if (obj instanceof Float) {
                            outputStream.write((((Number) obj).floatValue() + "").getBytes());
                        } else if (obj instanceof Integer) {
                            outputStream.write((((Number) obj).intValue() + "").getBytes());
                        } else {
                            outputStream.write(escape(obj.toString()));
                        }
                    }
                    if (this.elapsedField != null || i10 < size) {
                        outputStream.write(44);
                    }
                } catch (Throwable th2) {
                    if (this.elapsedField != null || i10 < size) {
                        outputStream.write(44);
                    }
                    throw th2;
                }
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            byte[] bArr = this.elapsedField;
            if (bArr != null) {
                outputStream.write(bArr);
                outputStream.write(58);
                outputStream.write((jCurrentTimeMillis2 + "").getBytes());
            }
            AsyncHttpClient.log.i(LOG_TAG, "Uploaded JSON in " + Math.floor(jCurrentTimeMillis2 / 1000) + " seconds");
        }
        outputStream.write(125);
        outputStream.flush();
        AsyncHttpClient.silentCloseOutputStream(outputStream);
    }

    @Override // cz.msebera.android.httpclient.HttpEntity
    public void consumeContent() throws UnsupportedOperationException, IOException {
    }
}
