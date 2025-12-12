package cz.msebera.android.httpclient.config;

import ac.c;
import cz.msebera.android.httpclient.util.Args;

/* loaded from: classes2.dex */
public class MessageConstraints implements Cloneable {
    public static final MessageConstraints DEFAULT = new Builder().build();
    private final int maxHeaderCount;
    private final int maxLineLength;

    public static class Builder {
        private int maxLineLength = -1;
        private int maxHeaderCount = -1;

        public MessageConstraints build() {
            return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
        }

        public Builder setMaxHeaderCount(int i10) {
            this.maxHeaderCount = i10;
            return this;
        }

        public Builder setMaxLineLength(int i10) {
            this.maxLineLength = i10;
            return this;
        }
    }

    public MessageConstraints(int i10, int i11) {
        this.maxLineLength = i10;
        this.maxHeaderCount = i11;
    }

    public static Builder copy(MessageConstraints messageConstraints) {
        Args.notNull(messageConstraints, "Message constraints");
        return new Builder().setMaxHeaderCount(messageConstraints.getMaxHeaderCount()).setMaxLineLength(messageConstraints.getMaxLineLength());
    }

    public static Builder custom() {
        return new Builder();
    }

    public static MessageConstraints lineLen(int i10) {
        return new MessageConstraints(Args.notNegative(i10, "Max line length"), -1);
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[maxLineLength=");
        sb2.append(this.maxLineLength);
        sb2.append(", maxHeaderCount=");
        return c.m(sb2, this.maxHeaderCount, "]");
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessageConstraints m27clone() throws CloneNotSupportedException {
        return (MessageConstraints) super.clone();
    }
}
