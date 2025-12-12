package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;
import l8.b;

/* loaded from: classes.dex */
public class DependencyCycleException extends DependencyException {

    /* renamed from: b, reason: collision with root package name */
    public final List<b<?>> f9738b;

    public DependencyCycleException(List<b<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f9738b = list;
    }
}
