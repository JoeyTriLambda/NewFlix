package androidx.activity.result;

import android.annotation.SuppressLint;

/* compiled from: ActivityResultLauncher.java */
/* loaded from: classes.dex */
public abstract class c<I> {
    public void launch(@SuppressLint({"UnknownNullness"}) I i10) {
        launch(i10, null);
    }

    public abstract void launch(@SuppressLint({"UnknownNullness"}) I i10, l0.c cVar);

    public abstract void unregister();
}
