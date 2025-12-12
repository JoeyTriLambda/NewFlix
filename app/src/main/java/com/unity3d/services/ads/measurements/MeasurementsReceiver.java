package com.unity3d.services.ads.measurements;

import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import zf.i;

/* compiled from: MeasurementsReceiver.kt */
@SuppressLint({"NewApi", "MissingPermission"})
/* loaded from: classes2.dex */
public final class MeasurementsReceiver implements OutcomeReceiver<Object, Exception> {
    private final MeasurementsEvents errorEvent;
    private final IEventSender eventSender;
    private final MeasurementsEvents successEvent;

    public MeasurementsReceiver(IEventSender iEventSender, MeasurementsEvents measurementsEvents, MeasurementsEvents measurementsEvents2) {
        i.checkNotNullParameter(iEventSender, "eventSender");
        i.checkNotNullParameter(measurementsEvents, "successEvent");
        i.checkNotNullParameter(measurementsEvents2, "errorEvent");
        this.eventSender = iEventSender;
        this.successEvent = measurementsEvents;
        this.errorEvent = measurementsEvents2;
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(Object obj) {
        i.checkNotNullParameter(obj, "p0");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.successEvent, new Object[0]);
    }

    @Override // android.os.OutcomeReceiver
    public void onError(Exception exc) {
        i.checkNotNullParameter(exc, "error");
        this.eventSender.sendEvent(WebViewEventCategory.MEASUREMENTS, this.errorEvent, exc.toString());
    }
}
