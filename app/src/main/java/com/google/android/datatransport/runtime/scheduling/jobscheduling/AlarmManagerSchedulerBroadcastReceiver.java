package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import q4.o;
import q4.s;

/* loaded from: classes.dex */
public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f5688a = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int iIntValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i10 = intent.getExtras().getInt("attemptNumber");
        s.initialize(context);
        o.a priority = o.builder().setBackendName(queryParameter).setPriority(b5.a.valueOf(iIntValue));
        if (queryParameter2 != null) {
            priority.setExtras(Base64.decode(queryParameter2, 0));
        }
        s.getInstance().getUploader().upload(priority.build(), i10, new x4.a(0));
    }
}
