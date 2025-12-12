package com.unity3d.services.core.request.metrics;

import ac.c;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ScarMetric {
    private static final String ASYNC_PREFIX = "async";
    private static final String HB_SIGNALS_FETCH_FAILURE = "native_hb_signals_%s_fetch_failure";
    private static final String HB_SIGNALS_FETCH_START = "native_hb_signals_%s_fetch_start";
    private static final String HB_SIGNALS_FETCH_SUCCESS = "native_hb_signals_%s_fetch_success";
    private static final String HB_SIGNALS_UPLOAD_FAILURE = "native_hb_signals_%s_upload_failure";
    private static final String HB_SIGNALS_UPLOAD_START = "native_hb_signals_%s_upload_start";
    private static final String HB_SIGNALS_UPLOAD_SUCCESS = "native_hb_signals_%s_upload_success";
    private static final String REASON = "reason";
    private static final String SYNC_PREFIX = "sync";
    private static long _fetchStartTime;
    private static long _uploadStartTime;

    private static long getTotalFetchTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _fetchStartTime);
    }

    private static long getTotalUploadTime() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - _uploadStartTime);
    }

    public static Metric hbSignalsFetchFailure(boolean z10, String str) {
        HashMap mapW = c.w(REASON, str);
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_FETCH_FAILURE, objArr), Long.valueOf(getTotalFetchTime()), mapW);
    }

    public static Metric hbSignalsFetchStart(boolean z10) {
        _fetchStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_FETCH_START, objArr), null);
    }

    public static Metric hbSignalsFetchSuccess(boolean z10) {
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_FETCH_SUCCESS, objArr), Long.valueOf(getTotalFetchTime()));
    }

    public static Metric hbSignalsUploadFailure(boolean z10, String str) {
        HashMap mapW = c.w(REASON, str);
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_FAILURE, objArr), Long.valueOf(getTotalUploadTime()), mapW);
    }

    public static Metric hbSignalsUploadStart(boolean z10) {
        _uploadStartTime = System.nanoTime();
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_START, objArr), null);
    }

    public static Metric hbSignalsUploadSuccess(boolean z10) {
        Object[] objArr = new Object[1];
        objArr[0] = z10 ? ASYNC_PREFIX : SYNC_PREFIX;
        return new Metric(String.format(HB_SIGNALS_UPLOAD_SUCCESS, objArr), Long.valueOf(getTotalUploadTime()));
    }
}
