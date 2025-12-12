package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes.dex */
public final class zaz extends RemoteCreator<zam> {

    /* renamed from: c, reason: collision with root package name */
    public static final zaz f7397c = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i10, int i11) throws RemoteCreator.RemoteCreatorException {
        zaz zazVar = f7397c;
        try {
            zax zaxVar = new zax(1, i10, i11, null);
            return (View) ObjectWrapper.unwrap(zazVar.getRemoteCreatorInstance(context).zae(ObjectWrapper.wrap(context), zaxVar));
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("Could not get button with size ");
            sb2.append(i10);
            sb2.append(" and color ");
            sb2.append(i11);
            throw new RemoteCreator.RemoteCreatorException(sb2.toString(), e10);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    public final /* synthetic */ zam getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof zam ? (zam) iInterfaceQueryLocalInterface : new zam(iBinder);
    }
}
