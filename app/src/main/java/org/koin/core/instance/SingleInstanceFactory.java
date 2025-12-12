package org.koin.core.instance;

import lf.h;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.scope.Scope;
import ph.b;
import ph.c;
import yf.a;
import yf.l;
import zf.i;

/* compiled from: SingleInstanceFactory.kt */
/* loaded from: classes2.dex */
public final class SingleInstanceFactory<T> extends c<T> {

    /* renamed from: b, reason: collision with root package name */
    public T f17377b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleInstanceFactory(BeanDefinition<T> beanDefinition) {
        super(beanDefinition);
        i.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // ph.c
    public T create(b bVar) {
        i.checkNotNullParameter(bVar, "context");
        T t10 = this.f17377b;
        if (t10 == null) {
            return (T) super.create(bVar);
        }
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    @Override // ph.c
    public void drop(Scope scope) {
        l<T, h> onClose = getBeanDefinition().getCallbacks().getOnClose();
        if (onClose != null) {
            onClose.invoke(this.f17377b);
        }
        this.f17377b = null;
    }

    @Override // ph.c
    public void dropAll() {
        c.drop$default(this, null, 1, null);
    }

    @Override // ph.c
    public T get(final b bVar) {
        i.checkNotNullParameter(bVar, "context");
        yh.b.f22543a.m238synchronized(this, new a<h>(this) { // from class: org.koin.core.instance.SingleInstanceFactory.get.1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleInstanceFactory<T> f17378b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.f17378b = this;
            }

            @Override // yf.a
            public /* bridge */ /* synthetic */ h invoke() {
                invoke2();
                return h.f16056a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SingleInstanceFactory<T> singleInstanceFactory = this.f17378b;
                b bVar2 = bVar;
                if (singleInstanceFactory.isCreated(bVar2)) {
                    return;
                }
                singleInstanceFactory.f17377b = singleInstanceFactory.create(bVar2);
            }
        });
        T t10 = this.f17377b;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    public boolean isCreated(b bVar) {
        return this.f17377b != null;
    }
}
