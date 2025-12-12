package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes.dex */
public interface AudioProcessor {

    /* renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f5704a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class UnhandledFormatException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public UnhandledFormatException(int i10, int i11, int i12) {
            StringBuilder sbT = ac.c.t("Unhandled format: ", i10, " Hz, ", i11, " channels in encoding ");
            sbT.append(i12);
            super(sbT.toString());
        }
    }

    boolean configure(int i10, int i11, int i12) throws UnhandledFormatException;

    void flush();

    ByteBuffer getOutput();

    int getOutputChannelCount();

    int getOutputEncoding();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
