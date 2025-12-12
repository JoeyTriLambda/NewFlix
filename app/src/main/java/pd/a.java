package pd;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.text.Editable;
import android.util.Base64;
import android.util.JsonReader;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.transition.e;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentRegistrar;
import flix.com.vision.activities.MainActivity;
import flix.com.vision.activities.MovieDetailActivity;
import h9.a;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import l8.h;
import n4.g;
import o4.b;
import o9.g;
import q4.o;
import se.f;
import t8.f0;
import u8.b;
import x0.c0;
import x0.d;
import x0.m0;
import y4.p;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements Response.ErrorListener, f, d.b, d.a, e.f, v4.c, g, p.a, TextInputLayout.e, g.a, h, a.InterfaceC0161a, b.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17670b;

    public /* synthetic */ a(int i10) {
        this.f17670b = i10;
    }

    public void a(Context context, int[] iArr, MotionEvent motionEvent, int i10) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = m0.getScaledMinimumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
        iArr[1] = m0.getScaledMaximumFlingVelocity(context, viewConfiguration, motionEvent.getDeviceId(), i10, motionEvent.getSource());
    }

    @Override // se.f
    public void accept(Object obj) {
        switch (this.f17670b) {
            case 2:
                break;
            case 3:
                break;
            case 4:
                Log.e("", "");
                break;
            case 5:
                Log.e("", "");
                break;
            case 12:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 13:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 15:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 17:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            case 19:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
            default:
                Log.d(MainActivity.class.toString(), "", (Throwable) obj);
                break;
        }
    }

    @Override // y4.p.a, n4.d
    public Object apply(Object obj) {
        switch (this.f17670b) {
            case 10:
                n4.b bVar = p.f21888q;
                return (List) p.g(((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new a(14));
            case 11:
                n4.b bVar2 = p.f21888q;
                throw new SynchronizationException("Timed out while trying to open db.", (Throwable) obj);
            case 12:
                Cursor cursor = (Cursor) obj;
                n4.b bVar3 = p.f21888q;
                if (cursor.moveToNext()) {
                    return Long.valueOf(cursor.getLong(0));
                }
                return 0L;
            case 13:
                n4.b bVar4 = p.f21888q;
                throw new SynchronizationException("Timed out while trying to acquire the lock.", (Throwable) obj);
            case 14:
                Cursor cursor2 = (Cursor) obj;
                n4.b bVar5 = p.f21888q;
                ArrayList arrayList = new ArrayList();
                while (cursor2.moveToNext()) {
                    o.a priority = o.builder().setBackendName(cursor2.getString(1)).setPriority(b5.a.valueOf(cursor2.getInt(2)));
                    String string = cursor2.getString(3);
                    arrayList.add(priority.setExtras(string == null ? null : Base64.decode(string, 0)).build());
                }
                return arrayList;
            case 15:
                Cursor cursor3 = (Cursor) obj;
                n4.b bVar6 = p.f21888q;
                if (cursor3.moveToNext()) {
                    return Long.valueOf(cursor3.getLong(0));
                }
                return null;
            case 16:
                n4.b bVar7 = p.f21888q;
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
            case 17:
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            default:
                Cursor cursor4 = (Cursor) obj;
                n4.b bVar8 = p.f21888q;
                ArrayList arrayList2 = new ArrayList();
                int length = 0;
                while (cursor4.moveToNext()) {
                    byte[] blob = cursor4.getBlob(0);
                    arrayList2.add(blob);
                    length += blob.length;
                }
                byte[] bArr = new byte[length];
                int length2 = 0;
                for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                    byte[] bArr2 = (byte[]) arrayList2.get(i10);
                    System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                    length2 += bArr2.length;
                }
                return bArr;
        }
    }

    public int b(Editable editable) {
        int i10 = TextInputLayout.N0;
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    public String c(Object obj) {
        switch (this.f17670b) {
            case 20:
                ApplicationInfo applicationInfo = ((Context) obj).getApplicationInfo();
                return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
            case 21:
                ApplicationInfo applicationInfo2 = ((Context) obj).getApplicationInfo();
                return (applicationInfo2 == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo2.minSdkVersion);
            case 22:
                Context context = (Context) obj;
                int i10 = Build.VERSION.SDK_INT;
                return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : (i10 < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) ? (i10 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? "" : "embedded" : "auto";
            default:
                Context context2 = (Context) obj;
                String installerPackageName = context2.getPackageManager().getInstallerPackageName(context2.getPackageName());
                return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
        }
    }

    public float d(VelocityTracker velocityTracker, MotionEvent motionEvent, int i10) {
        c0.addMovement(velocityTracker, motionEvent);
        c0.computeCurrentVelocity(velocityTracker, 1000);
        return c0.getAxisVelocity(velocityTracker, i10);
    }

    public void e(e.InterfaceC0045e interfaceC0045e, e eVar, boolean z10) {
        switch (this.f17670b) {
            case 2:
                interfaceC0045e.onTransitionStart(eVar, z10);
                break;
            case 3:
                interfaceC0045e.onTransitionEnd(eVar, z10);
                break;
            case 4:
                interfaceC0045e.onTransitionCancel(eVar);
                break;
            case 5:
                interfaceC0045e.onTransitionPause(eVar);
                break;
            default:
                interfaceC0045e.onTransitionResume(eVar);
                break;
        }
    }

    public Object f(Object obj, Object obj2) {
        b.a aVar = (b.a) obj;
        b.C0210b c0210b = (b.C0210b) obj2;
        URL url = c0210b.f17012b;
        if (url == null) {
            return null;
        }
        u4.a.d("CctTransportBackend", "Following redirect to: %s", url);
        return new b.a(c0210b.f17012b, aVar.f17009b, aVar.f17010c);
    }

    @Override // com.android.volley.Response.ErrorListener
    public void onErrorResponse(VolleyError volleyError) {
        switch (this.f17670b) {
            case 0:
                volleyError.printStackTrace();
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 12:
            case 13:
            case 15:
            case 17:
            case 19:
            default:
                Log.d(MovieDetailActivity.class.toString(), "", null);
                break;
            case 14:
                Log.d(MovieDetailActivity.class.toString(), "", null);
                break;
            case 16:
                Log.d(MovieDetailActivity.class.toString(), "", null);
                break;
            case 18:
                Log.d(MovieDetailActivity.class.toString(), "", null);
                break;
            case 20:
                Log.d(MovieDetailActivity.class.toString(), "", null);
                break;
        }
    }

    @Override // u8.b.a
    public Object parse(JsonReader jsonReader) throws IOException {
        switch (this.f17670b) {
            case 26:
                return u8.b.e(jsonReader);
            case 27:
                b9.a aVar = u8.b.f20138a;
                f0.d.b.a aVarBuilder = f0.d.b.builder();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    strNextName.getClass();
                    if (strNextName.equals("filename")) {
                        aVarBuilder.setFilename(jsonReader.nextString());
                    } else if (strNextName.equals("contents")) {
                        aVarBuilder.setContents(Base64.decode(jsonReader.nextString(), 2));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return aVarBuilder.build();
            case 28:
                b9.a aVar2 = u8.b.f20138a;
                f0.e.d.AbstractC0277e.a aVarBuilder2 = f0.e.d.AbstractC0277e.builder();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    strNextName2.getClass();
                    switch (strNextName2) {
                        case "parameterKey":
                            aVarBuilder2.setParameterKey(jsonReader.nextString());
                            break;
                        case "templateVersion":
                            aVarBuilder2.setTemplateVersion(jsonReader.nextLong());
                            break;
                        case "rolloutVariant":
                            f0.e.d.AbstractC0277e.b.a aVarBuilder3 = f0.e.d.AbstractC0277e.b.builder();
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String strNextName3 = jsonReader.nextName();
                                strNextName3.getClass();
                                if (strNextName3.equals("variantId")) {
                                    aVarBuilder3.setVariantId(jsonReader.nextString());
                                } else if (strNextName3.equals("rolloutId")) {
                                    aVarBuilder3.setRolloutId(jsonReader.nextString());
                                } else {
                                    jsonReader.skipValue();
                                }
                            }
                            jsonReader.endObject();
                            aVarBuilder2.setRolloutVariant(aVarBuilder3.build());
                            break;
                        case "parameterValue":
                            aVarBuilder2.setParameterValue(jsonReader.nextString());
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                return aVarBuilder2.build();
            default:
                return u8.b.b(jsonReader);
        }
    }

    @Override // l8.h
    public List processRegistrar(ComponentRegistrar componentRegistrar) {
        return componentRegistrar.getComponents();
    }

    @Override // h9.a.InterfaceC0161a
    public void handle(h9.b bVar) {
    }

    @Override // n4.g
    public void onSchedule(Exception exc) {
    }
}
