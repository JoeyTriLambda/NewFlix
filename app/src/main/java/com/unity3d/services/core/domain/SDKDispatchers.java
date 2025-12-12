package com.unity3d.services.core.domain;

import kg.s0;
import kotlinx.coroutines.b;

/* compiled from: SDKDispatchers.kt */
/* loaded from: classes2.dex */
public final class SDKDispatchers implements ISDKDispatchers {

    /* renamed from: io, reason: collision with root package name */
    private final b f10706io = s0.getIO();

    /* renamed from: default, reason: not valid java name */
    private final b f0default = s0.getDefault();
    private final b main = s0.getMain();

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public b getDefault() {
        return this.f0default;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public b getIo() {
        return this.f10706io;
    }

    @Override // com.unity3d.services.core.domain.ISDKDispatchers
    public b getMain() {
        return this.main;
    }
}
