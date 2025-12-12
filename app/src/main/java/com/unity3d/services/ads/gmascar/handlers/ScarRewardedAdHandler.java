package com.unity3d.services.ads.gmascar.handlers;

import bb.c;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.f;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

/* loaded from: classes2.dex */
public class ScarRewardedAdHandler extends ScarAdHandlerBase implements f {
    private boolean _hasEarnedReward;

    public ScarRewardedAdHandler(c cVar, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        super(cVar, eventSubject, gMAEventSender);
        this._hasEarnedReward = false;
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase
    public void onAdClosed() {
        if (!this._hasEarnedReward) {
            super.onAdSkipped();
        }
        super.onAdClosed();
    }

    public void onAdFailedToShow(int i10, String str) {
        this._gmaEventSender.send(GMAEvent.REWARDED_SHOW_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i10));
    }

    public void onAdImpression() {
        this._gmaEventSender.send(GMAEvent.REWARDED_IMPRESSION_RECORDED, new Object[0]);
    }

    public void onUserEarnedReward() {
        this._hasEarnedReward = true;
        this._gmaEventSender.send(GMAEvent.AD_EARNED_REWARD, new Object[0]);
    }
}
