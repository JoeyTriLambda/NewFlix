package org.koin.core.instance;

import java.util.HashMap;
import lf.h;
import org.koin.core.scope.Scope;
import ph.b;
import ph.c;
import yf.a;
import zf.i;

/* compiled from: ScopedInstanceFactory.kt */
/* loaded from: classes2.dex */
public final class ScopedInstanceFactory<T> extends c<T> {
    public static final /* synthetic */ HashMap access$getValues$p(ScopedInstanceFactory scopedInstanceFactory) {
        scopedInstanceFactory.getClass();
        return null;
    }

    @Override // ph.c
    public T create(b bVar) {
        i.checkNotNullParameter(bVar, "context");
        bVar.getScope().getId();
        throw null;
    }

    @Override // ph.c
    public void drop(Scope scope) {
        if (scope != null) {
            if (getBeanDefinition().getCallbacks().getOnClose() != null) {
                scope.getId();
                throw null;
            }
            scope.getId();
            throw null;
        }
    }

    @Override // ph.c
    public void dropAll() {
        throw null;
    }

    @Override // ph.c
    public T get(final b bVar) {
        i.checkNotNullParameter(bVar, "context");
        if (i.areEqual(bVar.getScope().getScopeQualifier(), getBeanDefinition().getScopeQualifier())) {
            yh.b.f22543a.m238synchronized(this, new a<h>(this) { // from class: org.koin.core.instance.ScopedInstanceFactory.get.1

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ScopedInstanceFactory<T> f17375b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.f17375b = this;
                }

                @Override // yf.a
                public /* bridge */ /* synthetic */ h invoke() {
                    invoke2();
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ScopedInstanceFactory<T> scopedInstanceFactory = this.f17375b;
                    b bVar2 = bVar;
                    if (scopedInstanceFactory.isCreated(bVar2)) {
                        return;
                    }
                    ScopedInstanceFactory.access$getValues$p(scopedInstanceFactory).put(bVar2.getScope().getId(), scopedInstanceFactory.create(bVar2));
                }
            });
            bVar.getScope().getId();
            throw null;
        }
        throw new IllegalStateException(("Wrong Scope: trying to open instance for " + bVar.getScope().getId() + " in " + getBeanDefinition()).toString());
    }

    public boolean isCreated(b bVar) {
        Scope scope;
        if (bVar != null && (scope = bVar.getScope()) != null) {
            scope.getId();
        }
        throw null;
    }
}
