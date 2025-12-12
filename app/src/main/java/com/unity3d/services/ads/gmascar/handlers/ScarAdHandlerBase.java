package com.unity3d.services.ads.gmascar.handlers;

import bb.c;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.misc.IEventListener;

/* loaded from: classes2.dex */
public abstract class ScarAdHandlerBase {
    protected final EventSubject<GMAEvent> _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final c _scarAdMetadata;

    public ScarAdHandlerBase(c cVar, EventSubject<GMAEvent> eventSubject, GMAEventSender gMAEventSender) {
        this._scarAdMetadata = cVar;
        this._eventSubject = eventSubject;
        this._gmaEventSender = gMAEventSender;
    }

    public void onAdClicked() {
        this._gmaEventSender.send(GMAEvent.AD_CLICKED, new Object[0]);
    }

    public void onAdClosed() {
        this._gmaEventSender.send(GMAEvent.AD_CLOSED, new Object[0]);
        this._eventSubject.unsubscribe();
    }

    public void onAdFailedToLoad(int i10, String str) {
        this._gmaEventSender.send(GMAEvent.LOAD_ERROR, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId(), str, Integer.valueOf(i10));
    }

    public void onAdLoaded() {
        this._gmaEventSender.send(GMAEvent.AD_LOADED, this._scarAdMetadata.getPlacementId(), this._scarAdMetadata.getQueryId());
    }

    public void onAdOpened() {
        this._gmaEventSender.send(GMAEvent.AD_STARTED, new Object[0]);
        this._eventSubject.subscribe(new IEventListener<GMAEvent>() { // from class: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase.1
            @Override // com.unity3d.services.core.misc.IEventListener
            public void onNextEvent(GMAEvent gMAEvent) {
                ScarAdHandlerBase.this._gmaEventSender.send(gMAEvent, new Object[0]);
            }
        });
    }

    public void onAdSkipped() {
        this._gmaEventSender.send(GMAEvent.AD_SKIPPED, new Object[0]);
    }
}
