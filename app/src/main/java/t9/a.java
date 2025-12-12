package t9;

import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import l8.h;
import o9.f;

/* compiled from: ComponentMonitor.java */
/* loaded from: classes.dex */
public final class a implements h {
    @Override // l8.h
    public List<l8.b<?>> processRegistrar(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (l8.b<?> bVarWithFactory : componentRegistrar.getComponents()) {
            String name = bVarWithFactory.getName();
            if (name != null) {
                bVarWithFactory = bVarWithFactory.withFactory(new f(name, 1, bVarWithFactory));
            }
            arrayList.add(bVarWithFactory);
        }
        return arrayList;
    }
}
