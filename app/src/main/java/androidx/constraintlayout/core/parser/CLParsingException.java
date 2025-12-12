package androidx.constraintlayout.core.parser;

/* loaded from: classes.dex */
public class CLParsingException extends Exception {
    public String reason() {
        return "null (null at line 0)";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
