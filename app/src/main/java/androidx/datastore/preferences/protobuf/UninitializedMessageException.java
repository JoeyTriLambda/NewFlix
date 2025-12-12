package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    public UninitializedMessageException(k0 k0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
