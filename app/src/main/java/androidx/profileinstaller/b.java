package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* compiled from: DeviceProfileWriter.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final AssetManager f3839a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f3840b;

    /* renamed from: c, reason: collision with root package name */
    public final c.InterfaceC0037c f3841c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f3842d;

    /* renamed from: e, reason: collision with root package name */
    public final File f3843e;

    /* renamed from: f, reason: collision with root package name */
    public final String f3844f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3845g;

    /* renamed from: h, reason: collision with root package name */
    public final String f3846h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3847i = false;

    /* renamed from: j, reason: collision with root package name */
    public f2.b[] f3848j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f3849k;

    public b(AssetManager assetManager, Executor executor, c.InterfaceC0037c interfaceC0037c, String str, String str2, String str3, File file) {
        this.f3839a = assetManager;
        this.f3840b = executor;
        this.f3841c = interfaceC0037c;
        this.f3844f = str;
        this.f3845g = str2;
        this.f3846h = str3;
        this.f3843e = file;
        int i10 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i10 >= 24 && i10 <= 33) {
            switch (i10) {
                case 24:
                case 25:
                    bArr = f2.f.f11398e;
                    break;
                case 26:
                    bArr = f2.f.f11397d;
                    break;
                case 27:
                    bArr = f2.f.f11396c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = f2.f.f11395b;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = f2.f.f11394a;
                    break;
            }
        }
        this.f3842d = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f3841c.onDiagnosticReceived(5, null);
            }
            return null;
        }
    }

    public final void b(int i10, Serializable serializable) {
        this.f3840b.execute(new f2.a(i10, this, 0, serializable));
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.f3842d == null) {
            b(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (this.f3843e.canWrite()) {
            this.f3847i = true;
            return true;
        }
        b(4, null);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x008c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.profileinstaller.b read() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.b.read():androidx.profileinstaller.b");
    }

    public b transcodeIfNeeded() throws IOException {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream;
        c.InterfaceC0037c interfaceC0037c = this.f3841c;
        f2.b[] bVarArr = this.f3848j;
        if (bVarArr != null && (bArr = this.f3842d) != null) {
            if (!this.f3847i) {
                throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
            }
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
            } catch (IOException e10) {
                interfaceC0037c.onResultReceived(7, e10);
            } catch (IllegalStateException e11) {
                interfaceC0037c.onResultReceived(8, e11);
            }
            try {
                byteArrayOutputStream.write(d.f3852a);
                byteArrayOutputStream.write(bArr);
                if (!d.j(byteArrayOutputStream, bArr, bVarArr)) {
                    interfaceC0037c.onResultReceived(5, null);
                    this.f3848j = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.f3849k = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.f3848j = null;
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        return this;
    }

    public boolean write() {
        byte[] bArr = this.f3849k;
        if (bArr == null) {
            return false;
        }
        if (!this.f3847i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f3843e);
                    try {
                        byte[] bArr2 = new byte[512];
                        while (true) {
                            int i10 = byteArrayInputStream.read(bArr2);
                            if (i10 <= 0) {
                                b(1, null);
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                this.f3849k = null;
                                this.f3848j = null;
                                return true;
                            }
                            fileOutputStream.write(bArr2, 0, i10);
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (FileNotFoundException e10) {
                b(6, e10);
                this.f3849k = null;
                this.f3848j = null;
                return false;
            } catch (IOException e11) {
                b(7, e11);
                this.f3849k = null;
                this.f3848j = null;
                return false;
            }
        } catch (Throwable th4) {
            this.f3849k = null;
            this.f3848j = null;
            throw th4;
        }
    }
}
