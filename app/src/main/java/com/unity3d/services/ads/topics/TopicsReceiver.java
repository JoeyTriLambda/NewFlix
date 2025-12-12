package com.unity3d.services.ads.topics;

import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zf.i;

/* compiled from: TopicsReceiver.kt */
@SuppressLint({"NewApi", "MissingPermission"})
/* loaded from: classes2.dex */
public final class TopicsReceiver implements OutcomeReceiver<GetTopicsResponse, Exception> {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender iEventSender) {
        i.checkNotNullParameter(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public final JSONObject formatTopic(Topic topic) throws JSONException {
        i.checkNotNullParameter(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taxonomyVersion", topic.getTaxonomyVersion());
        jSONObject.put("modelVersion", topic.getModelVersion());
        jSONObject.put("topicId", topic.getTopicId());
        return jSONObject;
    }

    @Override // android.os.OutcomeReceiver
    public void onError(Exception exc) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        i.checkNotNullParameter(exc, "error");
        DeviceLog.debug("GetTopics exception: " + exc);
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, exc.toString());
    }

    @Override // android.os.OutcomeReceiver
    public void onResult(GetTopicsResponse getTopicsResponse) {
        i.checkNotNullParameter(getTopicsResponse, "result");
        JSONArray jSONArray = new JSONArray();
        List<Topic> topics = getTopicsResponse.getTopics();
        i.checkNotNullExpressionValue(topics, "result.topics");
        for (Topic topic : topics) {
            i.checkNotNullExpressionValue(topic, "it");
            jSONArray.put(formatTopic(topic));
        }
        IEventSender iEventSender = this.eventSender;
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.TOPICS;
        TopicsEvents topicsEvents = TopicsEvents.TOPICS_AVAILABLE;
        String string = jSONArray.toString();
        i.checkNotNullExpressionValue(string, "resultArray.toString()");
        iEventSender.sendEvent(webViewEventCategory, topicsEvents, string);
    }
}
