package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.proto.Protobuf;
import e9.b;

/* loaded from: classes.dex */
public final class LogEventDropped {

    /* renamed from: a, reason: collision with root package name */
    public final long f5675a;

    /* renamed from: b, reason: collision with root package name */
    public final Reason f5676b;

    public enum Reason implements b {
        REASON_UNKNOWN(0),
        MESSAGE_TOO_OLD(1),
        CACHE_FULL(2),
        PAYLOAD_TOO_BIG(3),
        MAX_RETRIES_REACHED(4),
        INVALID_PAYLOD(5),
        SERVER_ERROR(6);


        /* renamed from: b, reason: collision with root package name */
        public final int f5685b;

        Reason(int i10) {
            this.f5685b = i10;
        }

        @Override // e9.b
        public int getNumber() {
            return this.f5685b;
        }
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f5686a = 0;

        /* renamed from: b, reason: collision with root package name */
        public Reason f5687b = Reason.REASON_UNKNOWN;

        public LogEventDropped build() {
            return new LogEventDropped(this.f5686a, this.f5687b);
        }

        public a setEventsDroppedCount(long j10) {
            this.f5686a = j10;
            return this;
        }

        public a setReason(Reason reason) {
            this.f5687b = reason;
            return this;
        }
    }

    static {
        new a().build();
    }

    public LogEventDropped(long j10, Reason reason) {
        this.f5675a = j10;
        this.f5676b = reason;
    }

    public static a newBuilder() {
        return new a();
    }

    @Protobuf
    public long getEventsDroppedCount() {
        return this.f5675a;
    }

    @Protobuf
    public Reason getReason() {
        return this.f5676b;
    }
}
