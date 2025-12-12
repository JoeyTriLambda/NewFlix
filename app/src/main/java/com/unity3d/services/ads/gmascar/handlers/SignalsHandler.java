package com.unity3d.services.ads.gmascar.handlers;

import cb.b;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;

/* loaded from: classes2.dex */
public class SignalsHandler implements b {
    private GMAEventSender _gmaEventSender;

    public SignalsHandler(GMAEventSender gMAEventSender) {
        this._gmaEventSender = gMAEventSender;
    }

    @Override // cb.b
    public void onSignalsCollected(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS, str);
    }

    @Override // cb.b
    public void onSignalsCollectionFailed(String str) {
        this._gmaEventSender.send(GMAEvent.SIGNALS_ERROR, str);
    }
}
