package n1;

import android.annotation.SuppressLint;
import android.text.Editable;
import androidx.emoji2.text.p;

/* compiled from: EmojiEditableFactory.java */
/* loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f16451a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f16452b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f16453c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f16453c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f16452b == null) {
            synchronized (f16451a) {
                if (f16452b == null) {
                    f16452b = new b();
                }
            }
        }
        return f16452b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f16453c;
        return cls != null ? p.create(cls, charSequence) : super.newEditable(charSequence);
    }
}
