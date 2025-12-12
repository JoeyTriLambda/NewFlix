package r9;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.google.firebase.sessions.DataCollectionState;
import com.google.firebase.sessions.EventType;
import com.google.firebase.sessions.LogEnvironment;
import com.google.firebase.sessions.api.SessionSubscriber;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.Map;

/* compiled from: SessionEvents.kt */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f18878a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static final b9.a f18879b;

    static {
        b9.a aVarBuild = new d9.c().configureWith(c.f18819a).ignoreNullValues(true).build();
        zf.i.checkNotNullExpressionValue(aVarBuild, "JsonDataEncoderBuilder()…lues(true)\n      .build()");
        f18879b = aVarBuild;
    }

    public final m buildSession(g8.f fVar, l lVar, SessionsSettings sessionsSettings, Map<SessionSubscriber.Name, ? extends SessionSubscriber> map, String str, String str2) {
        zf.i.checkNotNullParameter(fVar, "firebaseApp");
        zf.i.checkNotNullParameter(lVar, "sessionDetails");
        zf.i.checkNotNullParameter(sessionsSettings, "sessionsSettings");
        zf.i.checkNotNullParameter(map, "subscribers");
        zf.i.checkNotNullParameter(str, "firebaseInstallationId");
        zf.i.checkNotNullParameter(str2, "firebaseAuthenticationToken");
        EventType eventType = EventType.SESSION_START;
        String sessionId = lVar.getSessionId();
        String firstSessionId = lVar.getFirstSessionId();
        int sessionIndex = lVar.getSessionIndex();
        long sessionStartTimestampUs = lVar.getSessionStartTimestampUs();
        SessionSubscriber sessionSubscriber = map.get(SessionSubscriber.Name.PERFORMANCE);
        DataCollectionState dataCollectionState = DataCollectionState.COLLECTION_ENABLED;
        DataCollectionState dataCollectionState2 = DataCollectionState.COLLECTION_DISABLED;
        DataCollectionState dataCollectionState3 = DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        DataCollectionState dataCollectionState4 = sessionSubscriber == null ? dataCollectionState3 : sessionSubscriber.isDataCollectionEnabled() ? dataCollectionState : dataCollectionState2;
        SessionSubscriber sessionSubscriber2 = map.get(SessionSubscriber.Name.CRASHLYTICS);
        if (sessionSubscriber2 == null) {
            dataCollectionState = dataCollectionState3;
        } else if (!sessionSubscriber2.isDataCollectionEnabled()) {
            dataCollectionState = dataCollectionState2;
        }
        return new m(eventType, new p(sessionId, firstSessionId, sessionIndex, sessionStartTimestampUs, new d(dataCollectionState4, dataCollectionState, sessionsSettings.getSamplingRate()), str, str2), getApplicationInfo(fVar));
    }

    public final b getApplicationInfo(g8.f fVar) {
        zf.i.checkNotNullParameter(fVar, "firebaseApp");
        Context applicationContext = fVar.getApplicationContext();
        zf.i.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext");
        String packageName = applicationContext.getPackageName();
        PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 0);
        String strValueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        String applicationId = fVar.getOptions().getApplicationId();
        zf.i.checkNotNullExpressionValue(applicationId, "firebaseApp.options.applicationId");
        String str = Build.MODEL;
        zf.i.checkNotNullExpressionValue(str, "MODEL");
        String str2 = Build.VERSION.RELEASE;
        zf.i.checkNotNullExpressionValue(str2, "RELEASE");
        LogEnvironment logEnvironment = LogEnvironment.LOG_ENVIRONMENT_PROD;
        zf.i.checkNotNullExpressionValue(packageName, "packageName");
        String str3 = packageInfo.versionName;
        String str4 = str3 == null ? strValueOf : str3;
        String str5 = Build.MANUFACTURER;
        zf.i.checkNotNullExpressionValue(str5, "MANUFACTURER");
        i iVar = i.f18865a;
        Context applicationContext2 = fVar.getApplicationContext();
        zf.i.checkNotNullExpressionValue(applicationContext2, "firebaseApp.applicationContext");
        h currentProcessDetails = iVar.getCurrentProcessDetails(applicationContext2);
        Context applicationContext3 = fVar.getApplicationContext();
        zf.i.checkNotNullExpressionValue(applicationContext3, "firebaseApp.applicationContext");
        return new b(applicationId, str, "1.2.3", str2, logEnvironment, new a(packageName, str4, strValueOf, str5, currentProcessDetails, iVar.getAppProcessDetails(applicationContext3)));
    }

    public final b9.a getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions() {
        return f18879b;
    }
}
