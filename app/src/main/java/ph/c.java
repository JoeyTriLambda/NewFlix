package ph;

import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;
import org.koin.core.scope.Scope;
import zf.f;
import zf.i;

/* compiled from: InstanceFactory.kt */
/* loaded from: classes2.dex */
public abstract class c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final BeanDefinition<T> f17738a;

    /* compiled from: InstanceFactory.kt */
    public static final class a {
        public a(f fVar) {
        }
    }

    static {
        new a(null);
    }

    public c(BeanDefinition<T> beanDefinition) {
        i.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.f17738a = beanDefinition;
    }

    public static /* synthetic */ void drop$default(c cVar, Scope scope, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drop");
        }
        if ((i10 & 1) != 0) {
            scope = null;
        }
        cVar.drop(scope);
    }

    public T create(b bVar) throws InstanceCreationException {
        i.checkNotNullParameter(bVar, "context");
        qh.b logger = bVar.getLogger();
        StringBuilder sb2 = new StringBuilder("| (+) '");
        BeanDefinition<T> beanDefinition = this.f17738a;
        sb2.append(beanDefinition);
        sb2.append('\'');
        String string = sb2.toString();
        Level level = Level.DEBUG;
        if (logger.isAt(level)) {
            logger.display(level, string);
        }
        try {
            sh.a parameters = bVar.getParameters();
            if (parameters == null) {
                parameters = sh.b.emptyParametersHolder();
            }
            return beanDefinition.getDefinition().invoke(bVar.getScope(), parameters);
        } catch (Exception e10) {
            String stackTrace = yh.b.f22543a.getStackTrace(e10);
            qh.b logger2 = bVar.getLogger();
            String str = "* Instance creation error : could not create instance for '" + beanDefinition + "': " + stackTrace;
            Level level2 = Level.ERROR;
            if (logger2.isAt(level2)) {
                logger2.display(level2, str);
            }
            throw new InstanceCreationException("Could not create instance for '" + beanDefinition + '\'', e10);
        }
    }

    public abstract void drop(Scope scope);

    public abstract void dropAll();

    public boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        return i.areEqual(this.f17738a, cVar != null ? cVar.f17738a : null);
    }

    public abstract T get(b bVar);

    public final BeanDefinition<T> getBeanDefinition() {
        return this.f17738a;
    }

    public int hashCode() {
        return this.f17738a.hashCode();
    }
}
