package org.koin.android.ext.koin;

import ac.c;
import android.app.Application;
import android.content.Context;
import kh.a;
import kh.b;
import lf.h;
import mf.j;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.definition.Kind;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.logger.Level;
import org.koin.core.scope.Scope;
import yf.l;
import yf.p;
import zf.i;
import zf.k;

/* compiled from: KoinExt.kt */
/* loaded from: classes2.dex */
public final class KoinExtKt {
    public static final b androidContext(b bVar, final Context context) {
        i.checkNotNullParameter(bVar, "<this>");
        i.checkNotNullParameter(context, "androidContext");
        qh.b logger = bVar.getKoin().getLogger();
        Level level = Level.INFO;
        if (logger.isAt(level)) {
            qh.b logger2 = bVar.getKoin().getLogger();
            if (logger2.isAt(level)) {
                logger2.display(level, "[init] declare Android Context");
            }
        }
        if (context instanceof Application) {
            a.loadModules$default(bVar.getKoin(), j.listOf(wh.b.module$default(false, new l<rh.a, h>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(rh.a aVar) {
                    invoke2(aVar);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(rh.a aVar) {
                    i.checkNotNullParameter(aVar, "$this$module");
                    final Context context2 = context;
                    SingleInstanceFactory<?> singleInstanceFactoryY = c.y(new BeanDefinition(uh.c.f20383e.getRootScopeQualifier(), k.getOrCreateKotlinClass(Application.class), null, new p<Scope, sh.a, Application>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // yf.p
                        public final Application invoke(Scope scope, sh.a aVar2) {
                            i.checkNotNullParameter(scope, "$this$single");
                            i.checkNotNullParameter(aVar2, "it");
                            return (Application) context2;
                        }
                    }, Kind.Singleton, mf.k.emptyList()), aVar);
                    if (aVar.get_createdAtStart()) {
                        aVar.prepareForCreationAtStart(singleInstanceFactoryY);
                    }
                    wh.a.binds(new nh.c(aVar, singleInstanceFactoryY), new gg.b[]{k.getOrCreateKotlinClass(Context.class), k.getOrCreateKotlinClass(Application.class)});
                }
            }, 1, null)), false, 2, null);
        } else {
            a.loadModules$default(bVar.getKoin(), j.listOf(wh.b.module$default(false, new l<rh.a, h>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // yf.l
                public /* bridge */ /* synthetic */ h invoke(rh.a aVar) {
                    invoke2(aVar);
                    return h.f16056a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(rh.a aVar) {
                    i.checkNotNullParameter(aVar, "$this$module");
                    final Context context2 = context;
                    p<Scope, sh.a, Context> pVar = new p<Scope, sh.a, Context>() { // from class: org.koin.android.ext.koin.KoinExtKt.androidContext.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // yf.p
                        public final Context invoke(Scope scope, sh.a aVar2) {
                            i.checkNotNullParameter(scope, "$this$single");
                            i.checkNotNullParameter(aVar2, "it");
                            return context2;
                        }
                    };
                    SingleInstanceFactory<?> singleInstanceFactoryY = c.y(new BeanDefinition(uh.c.f20383e.getRootScopeQualifier(), k.getOrCreateKotlinClass(Context.class), null, pVar, Kind.Singleton, mf.k.emptyList()), aVar);
                    if (aVar.get_createdAtStart()) {
                        aVar.prepareForCreationAtStart(singleInstanceFactoryY);
                    }
                    new nh.c(aVar, singleInstanceFactoryY);
                }
            }, 1, null)), false, 2, null);
        }
        return bVar;
    }

    public static final b androidLogger(b bVar, Level level) {
        i.checkNotNullParameter(bVar, "<this>");
        i.checkNotNullParameter(level, "level");
        bVar.getKoin().setupLogger(new jh.a(level));
        return bVar;
    }
}
