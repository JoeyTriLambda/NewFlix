package androidx.transition;

import android.view.ViewGroup;

/* compiled from: Scene.java */
/* loaded from: classes.dex */
public final class d {
    public static d getCurrentScene(ViewGroup viewGroup) {
        return (d) viewGroup.getTag(R.id.transition_current_scene);
    }

    public void exit() {
        getCurrentScene(null);
    }
}
