package com.unity3d.services.ads.gmascar.handlers;

import bb.c;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.e;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

/* loaded from: classes2.dex */
public class ScarInterstitialAdHandler extends ScarAdHandlerBase implements e {
    public ScarInterstitialAdHandler(c cVar, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(cVar, eventSubject, gMAEventSender);
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase
    public void onAdClosed() {
        if (!this._eventSubject.eventQueueIsEmpty()) {
            super.onAdSkipped();
        }
        super.onAdClosed();
    }

    public void onAdFailedToShow(int i10, String str) {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_SHOW_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i10));
    }

    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.INTERSTITIAL_IMPRESSION_RECORDED, new Object[0]);
    }

    public void onAdLeftApplication() {
        this._gmaEventSender.send(GMAEvent.AD_LEFT_APPLICATION, new Object[0]);
    }
}
