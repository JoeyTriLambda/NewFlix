package oa;

import com.ptrbrynt.kotlin_bloc.core.Bloc;
import com.ptrbrynt.kotlin_bloc.core.BlocBase;
import zf.i;

/* compiled from: BlocObserver.kt */
/* loaded from: classes.dex */
public abstract class a {
    public <B extends BlocBase<State>, State> void onChange(B b10, b<State> bVar) {
        i.checkNotNullParameter(b10, "bloc");
        i.checkNotNullParameter(bVar, "change");
    }

    public <B extends BlocBase<?>> void onCreate(B b10) {
        i.checkNotNullParameter(b10, "bloc");
    }

    public <B extends Bloc<Event, ?>, Event> void onEvent(B b10, Event event) {
        i.checkNotNullParameter(b10, "bloc");
    }

    public <B extends Bloc<Event, State>, Event, State> void onTransition(B b10, e<Event, State> eVar) {
        i.checkNotNullParameter(b10, "bloc");
        i.checkNotNullParameter(eVar, "transition");
    }
}
