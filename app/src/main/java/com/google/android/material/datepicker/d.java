package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* compiled from: DateSelector.java */
/* loaded from: classes.dex */
public interface d<S> extends Parcelable {
    int getDefaultThemeResId(Context context);

    Collection<Long> getSelectedDays();

    Collection<w0.d<Long, Long>> getSelectedRanges();

    S getSelection();

    String getSelectionContentDescription(Context context);

    String getSelectionDisplayString(Context context);

    boolean isSelectionComplete();

    View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, w<S> wVar);

    void select(long j10);
}
