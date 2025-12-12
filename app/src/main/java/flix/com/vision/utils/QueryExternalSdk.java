package flix.com.vision.utils;

import android.content.Context;
import android.util.Log;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import appgain.Appgain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes2.dex */
public class QueryExternalSdk extends Worker {

    /* renamed from: q, reason: collision with root package name */
    public static boolean f12493q = true;

    public QueryExternalSdk(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public c.a doWork() throws IOException {
        try {
            String string = getInputData().getString("DEVICE_ID");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("https://apis.cyberprotector.online/active.php?app=appgain&appname=%s&pub=%s&deviceid=%s", "appgain", getInputData().getString("PUBLISHER_ID"), string)).openConnection();
            httpURLConnection.setRequestMethod("GET");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String line = bufferedReader.readLine();
            bufferedReader.close();
            if ("OK".equalsIgnoreCase(line)) {
                Log.d("ExraSdk", "Query QueryExternalSdk OK ");
                if (f12493q) {
                    Log.d("ExraSdk", "Start Appgain ");
                    Appgain.run(string);
                    f12493q = false;
                }
            } else {
                Log.d("ExraSdk", "Stop Appgain ");
                Appgain.stop(string);
                f12493q = true;
            }
            return c.a.success();
        } catch (Exception e10) {
            Log.e("ExraSdk", "Exception on appgain query and restart " + e10.getMessage());
            e10.printStackTrace();
            return c.a.retry();
        }
    }
}
