package org.adblockplus.libadblockplus;

/* loaded from: classes2.dex */
public class HeaderEntry {
    private final String key;
    private final String value;

    public HeaderEntry(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    public static HeaderEntry of(String str, String str2) {
        return new HeaderEntry(str, str2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof HeaderEntry)) {
            return false;
        }
        HeaderEntry headerEntry = (HeaderEntry) obj;
        return this.key.equals(headerEntry.key) && this.value.equals(headerEntry.value);
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() + (this.key.hashCode() * 31);
    }

    public String toString() {
        return this.key + ": " + this.value;
    }
}
