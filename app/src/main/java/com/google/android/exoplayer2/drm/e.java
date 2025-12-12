package com.google.android.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.ResourceBusyException;
import android.media.UnsupportedSchemeException;
import com.google.android.exoplayer2.drm.a;
import com.google.android.exoplayer2.drm.d;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import l6.u;

/* compiled from: FrameworkMediaDrm.java */
@TargetApi(18)
/* loaded from: classes.dex */
public final class e implements d<f5.c> {

    /* renamed from: a, reason: collision with root package name */
    public final MediaDrm f5843a;

    /* compiled from: FrameworkMediaDrm.java */
    public class a implements MediaDrm.OnEventListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.b f5844a;

        public a(d.b bVar) {
            this.f5844a = bVar;
        }

        @Override // android.media.MediaDrm.OnEventListener
        public void onEvent(MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
            ((a.d) this.f5844a).onEvent(e.this, bArr, i10, i11, bArr2);
        }
    }

    /* compiled from: FrameworkMediaDrm.java */
    public class b implements d.a {
    }

    /* compiled from: FrameworkMediaDrm.java */
    public class c implements d.c {
    }

    public e(UUID uuid) throws UnsupportedSchemeException {
        this.f5843a = new MediaDrm((UUID) l6.a.checkNotNull(uuid));
    }

    public static e newInstance(UUID uuid) throws UnsupportedDrmException {
        try {
            return new e(uuid);
        } catch (UnsupportedSchemeException e10) {
            throw new UnsupportedDrmException(1, e10);
        } catch (Exception e11) {
            throw new UnsupportedDrmException(2, e11);
        }
    }

    public void closeSession(byte[] bArr) {
        this.f5843a.closeSession(bArr);
    }

    public d.a getKeyRequest(byte[] bArr, byte[] bArr2, String str, int i10, HashMap<String, String> map) throws NotProvisionedException {
        this.f5843a.getKeyRequest(bArr, bArr2, str, i10, map);
        return new b();
    }

    public String getPropertyString(String str) {
        return this.f5843a.getPropertyString(str);
    }

    public d.c getProvisionRequest() {
        this.f5843a.getProvisionRequest();
        return new c();
    }

    public byte[] openSession() throws ResourceBusyException, NotProvisionedException {
        return this.f5843a.openSession();
    }

    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        return this.f5843a.provideKeyResponse(bArr, bArr2);
    }

    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.f5843a.provideProvisionResponse(bArr);
    }

    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f5843a.queryKeyStatus(bArr);
    }

    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f5843a.restoreKeys(bArr, bArr2);
    }

    public void setOnEventListener(d.b<? super f5.c> bVar) {
        this.f5843a.setOnEventListener(bVar == null ? null : new a(bVar));
    }

    public f5.c createMediaCrypto(UUID uuid, byte[] bArr) throws MediaCryptoException {
        return new f5.c(new MediaCrypto(uuid, bArr), u.f15907a < 21 && c5.b.f5034d.equals(uuid) && "L3".equals(getPropertyString("securityLevel")));
    }
}
