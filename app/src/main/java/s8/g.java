package s8;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import d9.c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MetaDataStore.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f19137b = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public final w8.b f19138a;

    public g(w8.b bVar) {
        this.f19138a = bVar;
    }

    public static HashMap a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = null;
            if (!jSONObject.isNull(next)) {
                strOptString = jSONObject.optString(next, null);
            }
            map.put(next, strOptString);
        }
        return map;
    }

    public static ArrayList b(String str) throws JSONException {
        JSONArray jSONArray = new JSONObject(str).getJSONArray("rolloutsState");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            String string = jSONArray.getString(i10);
            try {
                b9.a aVar = k.f19162a;
                JSONObject jSONObject = new JSONObject(string);
                arrayList.add(k.create(jSONObject.getString("rolloutId"), jSONObject.getString("parameterKey"), jSONObject.getString("parameterValue"), jSONObject.getString("variantId"), jSONObject.getLong("templateVersion")));
            } catch (Exception e10) {
                o8.e.getLogger().w("Failed de-serializing rollouts state. " + string, e10);
            }
        }
        return arrayList;
    }

    public static String d(List<k> list) {
        HashMap map = new HashMap();
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < list.size(); i10++) {
            try {
                jSONArray.put(new JSONObject(((c.a) k.f19162a).encode(list.get(i10))));
            } catch (JSONException e10) {
                o8.e.getLogger().w("Exception parsing rollout assignment!", e10);
            }
        }
        map.put("rolloutsState", jSONArray);
        return new JSONObject(map).toString();
    }

    public static void e(File file) {
        if (file.exists() && file.delete()) {
            o8.e.getLogger().i("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [long] */
    public final Map<String, String> c(String str, boolean z10) throws Throwable {
        FileInputStream fileInputStream;
        Exception e10;
        File internalKeysFileForSession = z10 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        if (internalKeysFileForSession.exists()) {
            ?? length = internalKeysFileForSession.length();
            if (length != 0) {
                Closeable closeable = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(internalKeysFileForSession);
                    } catch (Exception e11) {
                        fileInputStream = null;
                        e10 = e11;
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                    try {
                        HashMap mapA = a(CommonUtils.streamToString(fileInputStream));
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return mapA;
                    } catch (Exception e12) {
                        e10 = e12;
                        o8.e.getLogger().w("Error deserializing user metadata.", e10);
                        e(internalKeysFileForSession);
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return Collections.emptyMap();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = length;
                    CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                    throw th;
                }
            }
        }
        e(internalKeysFileForSession);
        return Collections.emptyMap();
    }

    public File getInternalKeysFileForSession(String str) {
        return this.f19138a.getSessionFile(str, "internal-keys");
    }

    public File getKeysFileForSession(String str) {
        return this.f19138a.getSessionFile(str, "keys");
    }

    public File getRolloutsStateForSession(String str) {
        return this.f19138a.getSessionFile(str, "rollouts-state");
    }

    public File getUserDataFileForSession(String str) {
        return this.f19138a.getSessionFile(str, "user-data");
    }

    public List<k> readRolloutsState(String str) throws Throwable {
        FileInputStream fileInputStream;
        File rolloutsStateForSession = getRolloutsStateForSession(str);
        if (!rolloutsStateForSession.exists() || rolloutsStateForSession.length() == 0) {
            e(rolloutsStateForSession);
            return Collections.emptyList();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(rolloutsStateForSession);
                try {
                    ArrayList arrayListB = b(CommonUtils.streamToString(fileInputStream));
                    o8.e.getLogger().d("Loaded rollouts state:\n" + arrayListB + "\nfor session " + str);
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close rollouts state file.");
                    return arrayListB;
                } catch (Exception e10) {
                    e = e10;
                    fileInputStream2 = fileInputStream;
                    o8.e.getLogger().w("Error deserializing rollouts state.", e);
                    e(rolloutsStateForSession);
                    CommonUtils.closeOrLog(fileInputStream2, "Failed to close rollouts state file.");
                    return Collections.emptyList();
                } catch (Throwable th2) {
                    th = th2;
                    CommonUtils.closeOrLog(fileInputStream, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    public String readUserId(String str) throws Throwable {
        FileInputStream fileInputStream;
        File userDataFileForSession = getUserDataFileForSession(str);
        Closeable closeable = null;
        if (userDataFileForSession.exists()) {
            ?? r32 = (userDataFileForSession.length() > 0L ? 1 : (userDataFileForSession.length() == 0L ? 0 : -1));
            try {
                if (r32 != 0) {
                    try {
                        fileInputStream = new FileInputStream(userDataFileForSession);
                    } catch (Exception e10) {
                        e = e10;
                        fileInputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                        CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
                        String strOptString = !jSONObject.isNull("userId") ? jSONObject.optString("userId", null) : null;
                        o8.e.getLogger().d("Loaded userId " + strOptString + " for session " + str);
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return strOptString;
                    } catch (Exception e11) {
                        e = e11;
                        o8.e.getLogger().w("Error deserializing user metadata.", e);
                        e(userDataFileForSession);
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return null;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                closeable = r32;
            }
        }
        o8.e.getLogger().d("No userId set for session " + str);
        e(userDataFileForSession);
        return null;
    }

    public void writeKeyData(String str, Map<String, String> map) {
        writeKeyData(str, map, false);
    }

    public void writeRolloutState(String str, List<k> list) throws Throwable {
        File rolloutsStateForSession = getRolloutsStateForSession(str);
        if (list.isEmpty()) {
            e(rolloutsStateForSession);
            return;
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String strD = d(list);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(rolloutsStateForSession), f19137b));
                try {
                    bufferedWriter2.write(strD);
                    bufferedWriter2.flush();
                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close rollouts state file.");
                } catch (Exception e10) {
                    e = e10;
                    bufferedWriter = bufferedWriter2;
                    o8.e.getLogger().w("Error serializing rollouts state.", e);
                    e(rolloutsStateForSession);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close rollouts state file.");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close rollouts state file.");
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void writeUserData(String str, String str2) throws Throwable {
        File userDataFileForSession = getUserDataFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String string = new f(str2).toString();
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userDataFileForSession), f19137b));
                try {
                    bufferedWriter2.write(string);
                    bufferedWriter2.flush();
                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e10) {
                    e = e10;
                    bufferedWriter = bufferedWriter2;
                    o8.e.getLogger().w("Error serializing user metadata.", e);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public void writeKeyData(String str, Map<String, String> map, boolean z10) {
        File internalKeysFileForSession = z10 ? getInternalKeysFileForSession(str) : getKeysFileForSession(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String string = new JSONObject(map).toString();
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(internalKeysFileForSession), f19137b));
                try {
                    bufferedWriter2.write(string);
                    bufferedWriter2.flush();
                    CommonUtils.closeOrLog(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e10) {
                    e = e10;
                    bufferedWriter = bufferedWriter2;
                    o8.e.getLogger().w("Error serializing key/value metadata.", e);
                    e(internalKeysFileForSession);
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.closeOrLog(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
