package ph;

import lf.h;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import yf.l;
import zf.i;

/* compiled from: FactoryInstanceFactory.kt */
/* loaded from: classes2.dex */
public final class a<T> extends c<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        i.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // ph.c
    public void drop(Scope scope) {
        l<T, h> onClose = getBeanDefinition().getCallbacks().getOnClose();
        if (onClose != null) {
            onClose.invoke(null);
        }
    }

    @Override // ph.c
    public T get(b bVar) {
        i.checkNotNullParameter(bVar, "context");
        return create(bVar);
    }

    @Override // ph.c
    public void dropAll() {
    }
}
