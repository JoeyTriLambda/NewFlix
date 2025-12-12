package com.unity3d.services.ads.gmascar.adapters;

import com.unity3d.scar.adapter.common.b;
import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.d;
import com.unity3d.scar.adapter.common.j;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.SdkProperties;
import db.a;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
public class ScarAdapterFactory {

    /* renamed from: com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion;

        static {
            int[] iArr = new int[ScarAdapterVersion.values().length];
            $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion = iArr;
            try {
                iArr[ScarAdapterVersion.V192.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.V195.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.V20.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.V21.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[ScarAdapterVersion.NA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void reportAdapterFailure(ScarAdapterVersion scarAdapterVersion, c<j> cVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        String str = String.format("SCAR version %s is not supported.", scarAdapterVersion.name());
        cVar.handleError(b.AdapterCreationError(str));
        DeviceLog.debug(str);
    }

    public d createScarAdapter(ScarAdapterVersion scarAdapterVersion, c<j> cVar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int i10 = AnonymousClass1.$SwitchMap$com$unity3d$services$ads$gmascar$finder$ScarAdapterVersion[scarAdapterVersion.ordinal()];
        if (i10 == 1) {
            return new a(cVar);
        }
        if (i10 == 2) {
            return new gb.a(cVar);
        }
        if (i10 == 3) {
            return new jb.a(cVar);
        }
        if (i10 == 4) {
            return new mb.a(cVar, SdkProperties.getVersionName());
        }
        reportAdapterFailure(scarAdapterVersion, cVar);
        return null;
    }
}
