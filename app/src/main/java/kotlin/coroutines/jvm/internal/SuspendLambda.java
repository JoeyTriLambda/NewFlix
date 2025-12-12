package kotlin.coroutines.jvm.internal;

import qf.c;
import zf.g;
import zf.i;
import zf.k;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes2.dex */
public abstract class SuspendLambda extends ContinuationImpl implements g<Object> {
    private final int arity;

    public SuspendLambda(int i10, c<Object> cVar) {
        super(cVar);
        this.arity = i10;
    }

    @Override // zf.g
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String strRenderLambdaToString = k.renderLambdaToString(this);
        i.checkNotNullExpressionValue(strRenderLambdaToString, "renderLambdaToString(this)");
        return strRenderLambdaToString;
    }

    public SuspendLambda(int i10) {
        this(i10, null);
    }
}
