package org.apache.commons.lang3.builder;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.reflect.FieldUtils;

/* loaded from: classes2.dex */
public class ReflectionDiffBuilder implements Builder<DiffResult> {
    private final DiffBuilder diffBuilder;
    private final Object left;
    private final Object right;

    public <T> ReflectionDiffBuilder(T t10, T t11, ToStringStyle toStringStyle) {
        this.left = t10;
        this.right = t11;
        this.diffBuilder = new DiffBuilder(t10, t11, toStringStyle);
    }

    private boolean accept(Field field) {
        if (field.getName().indexOf(36) == -1 && !Modifier.isTransient(field.getModifiers())) {
            return !Modifier.isStatic(field.getModifiers());
        }
        return false;
    }

    private void appendFields(Class<?> cls) {
        for (Field field : FieldUtils.getAllFields(cls)) {
            if (accept(field)) {
                try {
                    this.diffBuilder.append(field.getName(), FieldUtils.readField(field, this.left, true), FieldUtils.readField(field, this.right, true));
                } catch (IllegalAccessException e10) {
                    throw new InternalError("Unexpected IllegalAccessException: " + e10.getMessage());
                }
            }
        }
    }

    @Override // org.apache.commons.lang3.builder.Builder
    public DiffResult build() {
        if (this.left.equals(this.right)) {
            return this.diffBuilder.build();
        }
        appendFields(this.left.getClass());
        return this.diffBuilder.build();
    }
}
