package x1;

import android.media.VolumeProvider;
import android.os.Build;

/* compiled from: VolumeProviderCompat.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final int f21378a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21379b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21380c;

    /* renamed from: d, reason: collision with root package name */
    public int f21381d;

    /* renamed from: e, reason: collision with root package name */
    public d f21382e;

    /* renamed from: f, reason: collision with root package name */
    public VolumeProvider f21383f;

    /* compiled from: VolumeProviderCompat.java */
    public class a extends VolumeProvider {
        public a(int i10, int i11, int i12, String str) {
            super(i10, i11, i12, str);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            f.this.onAdjustVolume(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            f.this.onSetVolumeTo(i10);
        }
    }

    /* compiled from: VolumeProviderCompat.java */
    public class b extends VolumeProvider {
        public b(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            f.this.onAdjustVolume(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            f.this.onSetVolumeTo(i10);
        }
    }

    /* compiled from: VolumeProviderCompat.java */
    public static class c {
        public static void a(VolumeProvider volumeProvider, int i10) {
            volumeProvider.setCurrentVolume(i10);
        }
    }

    /* compiled from: VolumeProviderCompat.java */
    public static abstract class d {
        public abstract void onVolumeChanged(f fVar);
    }

    public f(int i10, int i11, int i12, String str) {
        this.f21378a = i10;
        this.f21379b = i11;
        this.f21381d = i12;
        this.f21380c = str;
    }

    public final int getCurrentVolume() {
        return this.f21381d;
    }

    public final int getMaxVolume() {
        return this.f21379b;
    }

    public final int getVolumeControl() {
        return this.f21378a;
    }

    public Object getVolumeProvider() {
        if (this.f21383f == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f21383f = new a(this.f21378a, this.f21379b, this.f21381d, this.f21380c);
            } else {
                this.f21383f = new b(this.f21378a, this.f21379b, this.f21381d);
            }
        }
        return this.f21383f;
    }

    public abstract void onAdjustVolume(int i10);

    public abstract void onSetVolumeTo(int i10);

    public void setCallback(d dVar) {
        this.f21382e = dVar;
    }

    public final void setCurrentVolume(int i10) {
        this.f21381d = i10;
        c.a((VolumeProvider) getVolumeProvider(), i10);
        d dVar = this.f21382e;
        if (dVar != null) {
            dVar.onVolumeChanged(this);
        }
    }
}
