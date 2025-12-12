package k3;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import com.ptrbrynt.kotlin_bloc.core.BlocBase;
import oa.b;
import oa.e;
import zf.i;

/* loaded from: classes.dex */
public final class a extends oa.a {
    @Override // oa.a
    public final void onChange(BlocBase blocBase, b bVar) {
        i.checkNotNullParameter(blocBase, "bloc");
        i.checkNotNullParameter(bVar, "change");
        super.onChange(blocBase, bVar);
    }

    @Override // oa.a
    public final void onCreate(BlocBase blocBase) {
        i.checkNotNullParameter(blocBase, "bloc");
        super.onCreate(blocBase);
    }

    @Override // oa.a
    public final void onEvent(Bloc bloc, Object obj) {
        i.checkNotNullParameter(bloc, "bloc");
        super.onEvent(bloc, obj);
    }

    @Override // oa.a
    public final void onTransition(Bloc bloc, e eVar) {
        i.checkNotNullParameter(bloc, "bloc");
        i.checkNotNullParameter(eVar, "transition");
        super.onTransition(bloc, eVar);
    }
}
