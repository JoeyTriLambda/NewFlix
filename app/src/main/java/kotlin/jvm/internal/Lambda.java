package kotlin.jvm.internal;

import java.io.Serializable;
import zf.g;
import zf.i;
import zf.k;

/* compiled from: Lambda.kt */
/* loaded from: classes2.dex */
public abstract class Lambda<R> implements g<R>, Serializable {
    private final int arity;

    public Lambda(int i10) {
        this.arity = i10;
    }

    @Override // zf.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strRenderLambdaToString = k.renderLambdaToString((Lambda) this);
        i.checkNotNullExpressionValue(strRenderLambdaToString, "renderLambdaToString(this)");
        return strRenderLambdaToString;
    }
}
