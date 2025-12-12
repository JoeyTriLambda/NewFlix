package v7;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;

/* compiled from: PasswordToggleEndIconDelegate.java */
/* loaded from: classes.dex */
public final class r extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f20606e;

    /* renamed from: f, reason: collision with root package name */
    public EditText f20607f;

    /* renamed from: g, reason: collision with root package name */
    public final androidx.mediarouter.app.b f20608g;

    public r(com.google.android.material.textfield.a aVar, int i10) {
        super(aVar);
        this.f20606e = R.drawable.design_password_eye;
        this.f20608g = new androidx.mediarouter.app.b(this, 5);
        if (i10 != 0) {
            this.f20606e = i10;
        }
    }

    @Override // v7.l
    public final void a() {
        l();
    }

    @Override // v7.l
    public final int b() {
        return R.string.password_toggle_content_description;
    }

    @Override // v7.l
    public final int c() {
        return this.f20606e;
    }

    @Override // v7.l
    public final View.OnClickListener e() {
        return this.f20608g;
    }

    @Override // v7.l
    public final boolean i() {
        return true;
    }

    @Override // v7.l
    public final boolean j() {
        EditText editText = this.f20607f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // v7.l
    public final void m() {
        EditText editText = this.f20607f;
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            this.f20607f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // v7.l
    public final void n() {
        EditText editText = this.f20607f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // v7.l
    public final void onEditTextAttached(EditText editText) {
        this.f20607f = editText;
        l();
    }
}
