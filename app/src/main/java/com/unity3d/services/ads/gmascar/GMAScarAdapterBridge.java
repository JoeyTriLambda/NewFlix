package com.unity3d.services.ads.gmascar;

import bb.c;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.b;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory;
import com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.ads.gmascar.finder.GMAInitializer;
import com.unity3d.services.ads.gmascar.finder.PresenceDetector;
import com.unity3d.services.ads.gmascar.finder.ScarVersionFinder;
import com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler;
import com.unity3d.services.ads.gmascar.handlers.SignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.timer.DefaultIntervalTimerFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class GMAScarAdapterBridge {
    private final AdapterStatusBridge _adapterStatusBridge;
    private final GMAEventSender _gmaEventSender;
    private final GMAInitializer _gmaInitializer;
    private final InitializeListenerBridge _initializationListenerBridge;
    private final InitializationStatusBridge _initializationStatusBridge;
    private final MobileAdsBridgeBase _mobileAdsBridge;
    private final PresenceDetector _presenceDetector;
    private d _scarAdapter;
    private final ScarAdapterFactory _scarAdapterFactory;
    private final ScarVersionFinder _scarVersionFinder;
    private final WebViewErrorHandler _webViewErrorHandler;

    public GMAScarAdapterBridge(MobileAdsBridgeBase mobileAdsBridgeBase, InitializeListenerBridge initializeListenerBridge, InitializationStatusBridge initializationStatusBridge, AdapterStatusBridge adapterStatusBridge, WebViewErrorHandler webViewErrorHandler, ScarAdapterFactory scarAdapterFactory, GMAEventSender gMAEventSender) {
        this._initializationStatusBridge = initializationStatusBridge;
        this._initializationListenerBridge = initializeListenerBridge;
        this._adapterStatusBridge = adapterStatusBridge;
        this._webViewErrorHandler = webViewErrorHandler;
        this._scarAdapterFactory = scarAdapterFactory;
        this._mobileAdsBridge = mobileAdsBridgeBase;
        this._gmaEventSender = gMAEventSender;
        PresenceDetector presenceDetector = new PresenceDetector(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge);
        this._presenceDetector = presenceDetector;
        GMAInitializer gMAInitializer = new GMAInitializer(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge, gMAEventSender);
        this._gmaInitializer = gMAInitializer;
        this._scarVersionFinder = new ScarVersionFinder(mobileAdsBridgeBase, presenceDetector, gMAInitializer, gMAEventSender);
    }

    private d getScarAdapterObject() {
        MobileAdsBridgeBase mobileAdsBridgeBase;
        if (this._scarAdapter == null && (mobileAdsBridgeBase = this._mobileAdsBridge) != null) {
            this._scarAdapter = this._scarAdapterFactory.createScarAdapter(mobileAdsBridgeBase.getAdapterVersion(this._scarVersionFinder.getVersionCode()), this._webViewErrorHandler);
        }
        return this._scarAdapter;
    }

    private EventSubject getScarEventSubject(Integer num) {
        return new EventSubject(new ArrayDeque(Arrays.asList(GMAEvent.FIRST_QUARTILE, GMAEvent.MIDPOINT, GMAEvent.THIRD_QUARTILE, GMAEvent.LAST_QUARTILE)), num, new DefaultIntervalTimerFactory());
    }

    private void loadInterstitialAd(c cVar) {
        this._scarAdapter.loadInterstitialAd(ClientProperties.getApplicationContext(), cVar, new ScarInterstitialAdHandler(cVar, getScarEventSubject(cVar.getVideoLengthMs()), this._gmaEventSender));
    }

    private void loadRewardedAd(c cVar) {
        this._scarAdapter.loadRewardedAd(ClientProperties.getApplicationContext(), cVar, new ScarRewardedAdHandler(cVar, getScarEventSubject(cVar.getVideoLengthMs()), this._gmaEventSender));
    }

    public void getSCARBiddingSignals(BiddingSignalsHandler biddingSignalsHandler) {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase == null || !mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            biddingSignalsHandler.onSignalsCollectionFailed("SCAR bidding unsupported.");
            return;
        }
        d scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            biddingSignalsHandler.onSignalsCollectionFailed("Could not create SCAR adapter object.");
        } else {
            ((h) scarAdapterObject).getSCARBiddingSignals(ClientProperties.getApplicationContext(), biddingSignalsHandler);
        }
    }

    public void getSCARSignals(String[] strArr, String[] strArr2) {
        this._scarAdapter = getScarAdapterObject();
        SignalsHandler signalsHandler = new SignalsHandler(this._gmaEventSender);
        d dVar = this._scarAdapter;
        if (dVar == null) {
            this._webViewErrorHandler.handleError((j) b.InternalSignalsError("Could not create SCAR adapter object"));
        } else {
            ((h) dVar).getSCARSignals(ClientProperties.getApplicationContext(), strArr, strArr2, signalsHandler);
        }
    }

    public void getVersion() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        this._scarVersionFinder.getVersion();
    }

    public boolean hasSCARBiddingSupport() {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase == null || !mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            return false;
        }
        d scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        return scarAdapterObject != null;
    }

    public void initializeScar() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (!this._presenceDetector.areGMAClassesPresent()) {
            this._webViewErrorHandler.handleError((j) new b(GMAEvent.SCAR_NOT_PRESENT, new Object[0]));
        } else {
            this._gmaEventSender.send(GMAEvent.SCAR_PRESENT, new Object[0]);
            this._gmaInitializer.initializeGMA();
        }
    }

    public boolean isInitialized() {
        return this._gmaInitializer.isInitialized();
    }

    public void load(boolean z10, String str, String str2, String str3, String str4, int i10) {
        c cVar = new c(str, str2, str4, str3, Integer.valueOf(i10));
        d scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            this._webViewErrorHandler.handleError((j) b.InternalLoadError(cVar, "Scar Adapter object is null"));
        } else if (z10) {
            loadInterstitialAd(cVar);
        } else {
            loadRewardedAd(cVar);
        }
    }

    public void show(String str, String str2, boolean z10) {
        c cVar = new c(str, str2);
        d scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            this._webViewErrorHandler.handleError((j) b.InternalShowError(cVar, "Scar Adapter object is null"));
        } else {
            ((h) scarAdapterObject).show(ClientProperties.getActivity(), str2, str);
        }
    }
}
