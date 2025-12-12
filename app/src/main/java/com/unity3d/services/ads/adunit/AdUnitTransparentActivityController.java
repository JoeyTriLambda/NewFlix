package com.unity3d.services.ads.adunit;

import android.graphics.drawable.ColorDrawable;
import com.unity3d.services.core.misc.ViewUtilities;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class AdUnitTransparentActivityController extends AdUnitActivityController {
    public AdUnitTransparentActivityController(IAdUnitActivity iAdUnitActivity, IEventSender iEventSender, IAdUnitViewHandlerFactory iAdUnitViewHandlerFactory) {
        super(iAdUnitActivity, iEventSender, iAdUnitViewHandlerFactory);
    }

    @Override // com.unity3d.services.ads.adunit.AdUnitActivityController
    public void createLayout() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        super.createLayout();
        ViewUtilities.setBackground(this._layout, new ColorDrawable(0));
    }
}
